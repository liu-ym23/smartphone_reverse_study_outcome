package com.bytedance.locallife.biz.monitor.param;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f256748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedBlockingQueue<a> f256749b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f256750c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f256751d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f256752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f256753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f256754c;

        public a() {
            this.f256754c = "确定";
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f256755a;

        public b(a r100) {
            this.f256755a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.f256749b.offer(this.f256755a);     // Catch: Throwable -> L6
            if (f.f256751d == true) goto L9;
            f.f256751d = true;     // Catch: Throwable -> L6
            f.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public f() {
    }

    static {
        f256749b = new LinkedBlockingQueue();
        f256750c = new Handler(Looper.getMainLooper());
    }

    public static final void a() {
        Activity r100 = HostServiceUtilsKt.E().getCurrentActivity();
        if (r100 != null) goto L7;
        int r101 = f256748a;
        if (r101 >= 10) goto L12;
        f256748a = r101 + 1;
        f256750c.postDelayed(g.f256756a, 1000);
        return;
    L12:
        return;
    L7:
        final a r102 = f256749b.poll();
        if (r102 != null) goto L10;
        f256751d = false;
        return;
    L10:
        com.bytedance.dux.dialog.alert.g r103 = new com.bytedance.dux.dialog.alert.g(r100);
        r103.f204939h = r102.f256752a;
        r103.f204940i = r102.f256753b;
        r103.f204949r = true;
        String r104 = r102.f256754c;
        Function2<DialogInterface, Integer, Unit> r105 = new ParamConflictDialogQueue$showNext$2(r102);
        Intrinsics.checkNotNullParameter(r104, "text");
        Intrinsics.checkNotNullParameter(r105, "listener");
        r103.f204945n = r104;
        r103.f204946o = new com.bytedance.dux.dialog.alert.f(r105);
        r103.c();
    }

    public static void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        f256750c.post(new b(r100));
    }
}
