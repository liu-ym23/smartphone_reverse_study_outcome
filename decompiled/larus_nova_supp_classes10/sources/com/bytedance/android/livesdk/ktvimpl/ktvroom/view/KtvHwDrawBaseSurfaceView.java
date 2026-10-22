package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvHwDrawBaseSurfaceView;", "Lcom/bytedance/android/live/ktv/common/view/ContinuousSurfaceAdapterView;", "Ljava/lang/Runnable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KtvHwDrawBaseSurfaceView extends ContinuousSurfaceAdapterView implements Runnable {
    public boolean e;
    public PthreadThreadV2 f;
    public Canvas g;
    public final int h;

    public static final class a {
    }

    static {
    }

    public abstract void e(Canvas r1);

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
    L3:
        if (this.e == false) goto L64;
        long r0 = System.currentTimeMillis();
        if (getVisibility() == 0) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L13;
        SurfaceHolder r5 = getSurfaceHolder();     // Catch: Throwable -> L37 Exception -> L39
        if (r5 == null) goto L24;
        Canvas r6 = r5.lockHardwareCanvas();     // Catch: Throwable -> L37 Exception -> L39
    L25:
        this.g = r6;     // Catch: Throwable -> L37 Exception -> L39
        if (r6 == null) goto L28;
        r6.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L37 Exception -> L39
    L28:
        e(this.g);     // Catch: Throwable -> L37 Exception -> L39
        if (this.g != null) goto L75;
    L49:
        long r2 = System.currentTimeMillis() - r0;
        int r1 = this.h;
        if (r2 >= r1) goto L3;
        Thread.sleep(((long) r1) - r2);     // Catch: Exception -> L54
        goto L3
    L75:
        SurfaceHolder r7 = getSurfaceHolder();     // Catch: Exception -> L35
        if (r7 == null) goto L49;
        r7.unlockCanvasAndPost(this.g);     // Catch: Exception -> L35
    L35:
        e = e;
        StringBuilder r8 = new StringBuilder();
    L20:
        r8.append(name());
        r8.append(" unlockCanvasAndPost exception ");
        r8.append(Log.getStackTraceString(e));
        ALogger.e("KtvHwDrawBaseSurfaceView", r8.toString());
        goto L49
    L24:
        r6 = null;
        goto L25
    L13:
        if (this.g == null) goto L49;
        SurfaceHolder r9 = getSurfaceHolder();     // Catch: Exception -> L18
        if (r9 == null) goto L49;
        r9.unlockCanvasAndPost(this.g);     // Catch: Exception -> L18
    L18:
        e = e;
        r8 = new StringBuilder();
        goto L20
    L8:
        if (((ContinuousSurfaceAdapterView) this).d != 0) goto L10;
        r4 = true;
        goto L11
    L39:
        e = move-exception;
        ALogger.e("KtvHwDrawBaseSurfaceView", name() + " draw exception " + Log.getStackTraceString(e));     // Catch: Throwable -> L37
        if (this.g == null) goto L49;
        SurfaceHolder r10 = getSurfaceHolder();     // Catch: Exception -> L47
        if (r10 == null) goto L49;
        r10.unlockCanvasAndPost(this.g);     // Catch: Exception -> L47
    L47:
        e = e;
        r8 = new StringBuilder();
    L37:
        th = move-exception;
        if (this.g != null) goto L69;
    L63:
        throw th;
    L69:
        SurfaceHolder r3 = getSurfaceHolder();     // Catch: Exception -> L61
        if (r3 == null) goto L63;
        r3.unlockCanvasAndPost(this.g);     // Catch: Exception -> L61
    L61:
        e = move-exception;
        ALogger.e("KtvHwDrawBaseSurfaceView", name() + " unlockCanvasAndPost exception " + Log.getStackTraceString(e));
        goto L63
    }

    @Override // java.lang.Runnable
    public final void run() {
        d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void surfaceCreated(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.surfaceCreated(r2);
        r2.setFormat(-3);
        this.e = true;
        PthreadThreadV2 r3 = new PthreadThreadV2(this, "KtvHwDrawBaseSurfaceView");
        this.f = r3;
        ThreadMethodProxy.start(r3);
    }

    public final void surfaceDestroyed(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.surfaceDestroyed(r2);
        this.e = false;
        PthreadThreadV2 r3 = this.f;
        if (r3 == null) goto L6;
        r3.interrupt();
        return;
    }

    public KtvHwDrawBaseSurfaceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.e = true;
        this.h = 1000 / ((Number) KtvSettingHelper.f0.getValue()).intValue();
        c();
    }
}
