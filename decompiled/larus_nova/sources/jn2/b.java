package jn2;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L7;
        return;
    L7:
        c(r101, a(r101), 0);
    }

    public static void d(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L7;
        return;
    L7:
        c(r101, a(r101), 514);
    }

    public static void e(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L7;
        return;
    L7:
        View r102 = a(r101);
        if (r102 != null) goto L10;
        return;
    L10:
        if (r101.getAttributes() != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        r101.clearFlags(1024);
    L17:
        int r104 = r102.getSystemUiVisibility();
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r105 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r105.a();
        r105.a();
        if (r104 == 1280) goto L22;
        r102.setSystemUiVisibility(1280);
        return;
    L22:
        return;
    L12:
        if ((r101.getAttributes().flags & 1024) != 1024) goto L14;
        r103 = true;
        goto L15
    }

    public static void c(Window r100, View r101, int r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100.getAttributes() != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L11;
        r100.clearFlags(1024);
    L11:
        int r104 = r101.getSystemUiVisibility();
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        int r105 = 5124;
        if (r102 == 0) goto L14;
        r105 = 5124 | r102;
    L14:
        if (r104 == r105) goto L18;
        r101.setSystemUiVisibility(r105);
        return;
    L18:
        return;
    L6:
        if ((r100.getAttributes().flags & 1024) != 1024) goto L8;
        r103 = true;
        goto L9
    }
}
