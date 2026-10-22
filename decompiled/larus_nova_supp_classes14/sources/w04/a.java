package w04;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static boolean b(Activity r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((a(r2.getWindow()).getSystemUiVisibility() & 1280) != 1280) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(AosBaseActivity r0, boolean r1) {
        Window r2 = r0.getWindow();
        if (r1 == false) goto L5;
        a(r2).setSystemUiVisibility(a(r2).getSystemUiVisibility() | 8192);
        return;
    L5:
        a(r2).setSystemUiVisibility(a(r2).getSystemUiVisibility() & (-8193));
    }
}
