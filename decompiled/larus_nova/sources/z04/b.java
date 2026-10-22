package z04;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(Activity r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 23) goto L11;
        int r102 = a(r100.getWindow()).getSystemUiVisibility();
        if (r101 == false) goto L7;
        int r103 = r102 | 8192;
    L8:
        if (r103 == r102) goto L12;
        a(r100.getWindow()).setSystemUiVisibility(r103);
        return;
    L12:
        return;
    L7:
        r103 = r102 & (-8193);
        goto L8
    }
}
