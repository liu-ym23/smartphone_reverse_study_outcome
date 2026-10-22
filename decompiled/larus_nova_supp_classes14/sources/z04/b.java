package z04;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(Activity r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L11;
        int r0 = a(r2.getWindow()).getSystemUiVisibility();
        if (r3 == false) goto L7;
        int r4 = r0 | 8192;
    L8:
        if (r4 == r0) goto L12;
        a(r2.getWindow()).setSystemUiVisibility(r4);
        return;
    L12:
        return;
    L7:
        r4 = r0 & (-8193);
        goto L8
    }
}
