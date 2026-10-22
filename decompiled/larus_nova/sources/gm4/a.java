package gm4;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.window.controller.DuxBreakPointController;
import com.bytedance.dux.window.controller.DuxWindowSizeController;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hm4.b;
import hm4.d;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DuxBreakPointController f481672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DuxWindowSizeController f481673b = null;

    static {
        f481672a = new DuxBreakPointController();
        f481673b = DuxWindowSizeController.f205934a;
    }

    public static hm4.a c(View r100) {
        return f481673b.a(r100);
    }

    public static hm4.a d(Context r100) {
        View r101 = null;
        if ((r100 instanceof Activity) == false) goto L13;
        Window r102 = ((Activity) r100).getWindow();
        if (r102 == null) goto L14;
        r101 = r102.getDecorView();
        if (c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == c.f346341a) goto L14;
        c.a(r103, "getDecorView");
    L14:
        return c(r101);
    L13:
        return c(null);
    }

    public static b e(hm4.c r100) {
        f481672a.getClass();
        View r101 = r100.f485931a;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L29;
        List<b> r104 = hm4.c.f485930c;
        if ((r100.f485932b & 1) != 1) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        float r106 = DuxWindowSizeController.f205934a.a(r100.f485931a).f485914a;
    L16:
        List<b> r107 = hm4.c.f485930c;
        ListIterator<b> r108 = r107.listIterator(r107.size());
    L18:
        if (r108.hasPrevious() == false) goto L25;
        b r109 = r108.previous();
        if (r106 < r109.f485928a) goto L22;
        boolean r110 = true;
    L23:
        if (r110 == false) goto L18;
    L26:
        b r111 = r109;
        if (r111 == null) goto L43;
        return r111;
    L43:
        return b.f485918c;
    L22:
        r110 = false;
        goto L23
    L25:
        r109 = null;
        goto L26
    L15:
        r106 = DuxWindowSizeController.f205934a.a(r100.f485931a).f485915b;
        goto L16
    L12:
        r105 = false;
        goto L13
    L29:
        d r112 = com.bytedance.dux.window.controller.b.b();
        List<b> r113 = hm4.c.f485930c;
        if ((r100.f485932b & 2) != 2) goto L32;
        r102 = true;
    L32:
        if (r102 == false) goto L34;
        b r114 = r112.f485935c;
    L36:
        return r114;
    L34:
        r114 = r112.f485934b;
        goto L36
    L5:
        if (r101.isAttachedToWindow() != true) goto L7;
        r103 = true;
        goto L8
    }

    public static void a(hm4.c r100, jm4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "listener");
        b(r100, r101);
    }

    public static void b(hm4.c r100, jm4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "listener");
        f481672a.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Map<PadAdaptScene, Boolean> r102 = DuxConfig.f204897a;
        em4.d.b("DuxBreakPointController", "addWindowConfigChangeListener：only support pad or fold!");
    }
}
