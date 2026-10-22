package eh;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes43.dex */
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

    public static int b(Context r100) {
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r100.getResources().getDimensionPixelSize(r101);
    }

    public static void c(Activity r100) {
        Window r101 = r100.getWindow();
        r101.clearFlags(201326592);
        int r102 = (a(r101).getSystemUiVisibility() | 1024) | 256;
        a(r101).setSystemUiVisibility(r102);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setStatusBarColor(0);
    }
}
