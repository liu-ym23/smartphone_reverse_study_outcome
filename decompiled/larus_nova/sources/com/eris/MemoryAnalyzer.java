package com.eris;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class MemoryAnalyzer {
    private static final AtomicBoolean isAnalysing = null;
    private static final boolean libraryLoaded = false;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f274007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f274009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f274010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f274011e;

        public final void a() {
            File r100 = this.f274007a.getExternalFilesDir("live.eris.memory");
            if (r100 != null) goto L6;
        L24:
            MemoryAnalyzer.access$000().set(false);
            return;
        L6:
            if (r100.exists() == false) goto L8;
        L10:
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "dump.hprof");
            PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "out.txt");
            String r103 = this.f274007a.getApplicationInfo().nativeLibraryDir;
            String r104 = File.separator;
            if (r103.endsWith(r104) == true) goto L13;
            r103 = r103 + r104;
        L13:
            boolean r105 = MemoryAnalyzer.access$100(r103 + "liberis-analyzer.so", r101.getAbsolutePath(), r102.getAbsolutePath(), this.f274010d, this.f274008b, this.f274011e);
            if (r101.exists() == false) goto L16;
            r101.delete();
        L16:
            if (r105 == false) goto L21;
            if (r102.exists() == false) goto L21;
            this.f274009c.a(r102);
        L21:
            if (r102.exists() == false) goto L23;
            r102.delete();
        L23:
            this.f274009c.a(null);
            goto L24
        L8:
            if (r100.mkdirs() == true) goto L10;
            r100.toString();
            goto L24
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, String r101, int r102, int r103, b r104) {
            this.f274007a = r100;
            this.f274008b = r102;
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            this.f274010d = r101;
            this.f274011e = r103;
            this.f274009c = r104;
        }
    }

    public interface b {
        void a(PolarisFileWrapper r100);
    }

    static {
        INVOKESTATIC_com_eris_MemoryAnalyzer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("eris");     // Catch: Throwable -> L5
        boolean r100 = true;
    L6:
        libraryLoaded = r100;
        isAnalysing = new AtomicBoolean(false);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public MemoryAnalyzer() {
    }

    private static native boolean analyseClassInstanceCount(String r100, String r101, String r102, String r103, int r104, int r105);

    public static /* synthetic */ AtomicBoolean access$000() {
        return isAnalysing;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_eris_MemoryAnalyzer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ boolean access$100(String r100, String r101, String r102, String r103, int r104, int r105) {
        return analyseClassInstanceCount(r100, r101, r102, r103, r104, r105);
    }

    public static void analyseClassInstanceCount(Context r100, String r101, int r102, int r103, Executor r110, b r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (libraryLoaded == false) goto L23;
        if (r111 != null) goto L8;
        return;
    L8:
        if (r103 > 0) goto L11;
        return;
    L11:
        if (isAnalysing.getAndSet(true) == false) goto L13;
        return;
    L13:
        if (r102 >= 0) goto L15;
        int r104 = 0;
    L16:
        a r105 = new a(r100.getApplicationContext(), r101, r104, r103, r111);
        if (r110 == null) goto L19;
        r110.execute(r105);
        return;
    L19:
        ThreadMethodProxy.start(new PthreadThreadV2(r105, "eris-analyse"));
        return;
    L15:
        r104 = r102;
        goto L16
    }
}
