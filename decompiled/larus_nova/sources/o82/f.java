package o82;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f522349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f522350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f522351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f522352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ValueAnimator f522353e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f522354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f522355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f522356h;

    public f() {
    }

    static {
        f522353e = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(160);
    }

    public static final boolean a(Window r100) {
        if (r100 == null) goto L21;
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L8;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L8;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L8:
        if (r101 == null) goto L21;
        if (r101.getWindowToken() == null) goto L21;
        Context r103 = r101.getContext();
        if ((r103 instanceof ContextThemeWrapper) == false) goto L18;
        Context r104 = ((ContextThemeWrapper) r103).getBaseContext();
        if ((r104 instanceof Activity) == false) goto L23;
        boolean r105 = ((Activity) r104).isFinishing();
    L25:
        return true ^ r105;
    L23:
        return true;
    L18:
        if ((r103 instanceof Activity) == false) goto L24;
        r105 = ((Activity) r103).isFinishing();
        goto L25
    L24:
        return true;
    L21:
        return false;
    }
}
