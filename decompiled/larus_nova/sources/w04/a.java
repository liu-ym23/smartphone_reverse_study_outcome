package w04;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f557782a = 0;

    static {
    }

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

    public static boolean b(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((a(r100.getWindow()).getSystemUiVisibility() & 1280) != 1280) goto L9;
        return true;
    L9:
        return false;
    }

    public static void c(AosBaseActivity r100, boolean r101) {
        Window r102 = r100.getWindow();
        if (r101 == false) goto L5;
        a(r102).setSystemUiVisibility(a(r102).getSystemUiVisibility() | 8192);
        return;
    L5:
        a(r102).setSystemUiVisibility(a(r102).getSystemUiVisibility() & (-8193));
    }
}
