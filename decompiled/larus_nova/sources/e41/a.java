package e41;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f470974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f470975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MessageQueue.IdleHandler f470976c;

    public final void a() {
        Runnable r100 = this.f470975b;
        if (r100 == null) goto L5;
        this.f470974a.removeCallbacks(r100);
    L5:
        this.f470975b = null;
        MessageQueue.IdleHandler r101 = this.f470976c;
        if (r101 != null) goto L8;
    L14:
        this.f470976c = null;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        Looper r102 = this.f470974a.getLooper();
        if (r102 == null) goto L14;
        MessageQueue r103 = r102.getQueue();
        if (r103 == null) goto L14;
        r103.removeIdleHandler(r101);
        goto L14
    }

    public a() {
        this.f470974a = new Handler(Looper.getMainLooper());
    }

    public final void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        long r101 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.d();
        if (r101 > 0) goto L6;
        r100.run();
        return;
    L6:
        Runnable r102 = this.f470975b;
        if (r102 == null) goto L9;
        this.f470974a.removeCallbacks(r102);
    L9:
        this.f470974a.postDelayed(r100, r101);
        this.f470975b = r100;
    }

    public final void c(MessageQueue.IdleHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r101 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r101.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97540k.getValue(r101, com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a[9])).booleanValue() == true) goto L5;
    L21:
        r100.queueIdle();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L21;
        MessageQueue.IdleHandler r102 = this.f470976c;
        if (r102 == null) goto L14;
        Looper r103 = this.f470974a.getLooper();
        if (r103 == null) goto L14;
        MessageQueue r104 = r103.getQueue();
        if (r104 == null) goto L14;
        r104.removeIdleHandler(r102);
    L14:
        Looper r105 = this.f470974a.getLooper();
        if (r105 == null) goto L19;
        MessageQueue r106 = r105.getQueue();
        if (r106 == null) goto L19;
        r106.addIdleHandler(r100);
    L19:
        this.f470976c = r100;
    }
}
