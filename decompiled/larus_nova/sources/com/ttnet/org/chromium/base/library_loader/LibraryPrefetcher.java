package com.ttnet.org.chromium.base.library_loader;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.SysUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.task.PostTask;
import com.ttnet.org.chromium.base.task.TaskTraits;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryPrefetcher {
    private static final String TAG = "LibraryPrefetcher";
    private static final AtomicBoolean sPrefetchLibraryHasBeenCalled = null;

    public interface Natives {
        void forkAndPrefetchNativeLibrary();

        int percentageOfResidentNativeLibraryCode();

        void periodicallyCollectResidency();
    }

    public LibraryPrefetcher() {
    }

    public static /* synthetic */ void a() {
        lambda$asyncPrefetchLibrariesToMemory$0();
    }

    public static /* synthetic */ void b(boolean r100) {
        lambda$asyncPrefetchLibrariesToMemory$1(r100);
    }

    static {
        sPrefetchLibraryHasBeenCalled = new AtomicBoolean();
    }

    public static void asyncPrefetchLibrariesToMemory() {
        SysUtils.logPageFaultCountToTracing();
        final boolean r100 = sPrefetchLibraryHasBeenCalled.compareAndSet(false, true);
        if (r100 == true) goto L5;
    L8:
        PostTask.postTask(TaskTraits.USER_BLOCKING, new b(r100));
        return;
    L5:
        if (CommandLine.getInstance().hasSwitch("log-native-library-residency") == false) goto L8;
        ThreadMethodProxy.start(new PthreadThreadV2(new a(), TAG));
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$0() {
        LibraryPrefetcherJni.get().periodicallyCollectResidency();
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$1(boolean r100) {
        int r101 = LibraryPrefetcherJni.get().percentageOfResidentNativeLibraryCode();
        TraceEvent r102 = TraceEvent.scoped("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(r101));
        if (r100 == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L13;
        LibraryPrefetcherJni.get().forkAndPrefetchNativeLibrary();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r102 != null) goto L30;
    L25:
        throw th;
    L30:
        r102.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
    L13:
        if (r101 != (-1)) goto L15;
    L26:
        if (r102 == null) goto L28;
        r102.close();
    L28:
        ContextUtils.getAppSharedPreferences().edit().remove("dont_prefetch_libraries").apply();
        return;
    L15:
        if (r100 == false) goto L17;
        String r104 = ".ColdStartup";
    L18:
        RecordHistogram.recordPercentageHistogram("LibraryLoader.PercentageOfResidentCodeBeforePrefetch".concat(r104), r101);     // Catch: Throwable -> L10
        goto L26
    L17:
        r104 = ".WarmStartup";
        goto L18
    L5:
        if (r101 >= 90) goto L7;
        r103 = true;
        goto L8
    }
}
