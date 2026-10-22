package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f436138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, List<WeakReference<MmBaseRecordingActivity>>> f436139b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f436140a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f436140a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f436140a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f436138a = new Handler(Looper.getMainLooper());
        f436139b = new LinkedHashMap();
    }

    public static void a(Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f436138a.post(new a(r100));
    }
}
