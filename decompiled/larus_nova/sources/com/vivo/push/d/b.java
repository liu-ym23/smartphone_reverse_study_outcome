package com.vivo.push.d;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.vivo.push.IPushActionListener;
import com.vivo.push.m;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f462280a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f462281a = null;

        static {
            f462281a = new b(0);
        }

        public static /* synthetic */ b a() {
            return f462281a;
        }
    }

    private b() {
        this.f462280a = 0;
    }

    public static b a() {
        return a.a();
    }

    public /* synthetic */ b(byte r100) {
        this();
    }

    public static View INVOKEVIRTUAL_com_vivo_push_d_b_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ int a(Activity r100) {
        if (r100 != null) goto L5;
    L15:
        boolean r101 = false;
    L16:
        if (r101 == true) goto L20;
        return 8105;
    L20:
        if (com.vivo.push.restructure.a.a().g().a(16384) == true) goto L24;
        return 8106;
    L24:
        if (com.vivo.push.restructure.a.a().f().b(r100) == false) goto L27;
        return 8107;
    L27:
        return 0;
    L5:
        if (r100.isFinishing() == true) goto L15;
        if (r100.getWindow() == null) goto L15;
        if (INVOKEVIRTUAL_com_vivo_push_d_b_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()) == null) goto L15;
        if (INVOKEVIRTUAL_com_vivo_push_d_b_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getVisibility() != 0) goto L15;
        r101 = true;
        goto L16
    }

    public final void a(Activity r100, IPushActionListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        com.vivo.push.util.g.a().execute(new c(this, r100, r101));
    }

    public final void a(Activity r100, IPushActionListener r110, long r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        m.a();
        if (m.a(this.f462280a) == true) goto L8;
        t.c("NotifyGuideDialogManage", "tryShowGuideDialog: isCallingTooQuick, return");
        r110.onStateChanged(1002);
        return;
    L8:
        this.f462280a = SystemClock.elapsedRealtime();
        com.vivo.push.util.g.a().execute(new e(this, r100, r110, r111));
    }
}
