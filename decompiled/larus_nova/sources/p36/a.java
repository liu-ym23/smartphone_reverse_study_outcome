package p36;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f527590a;

    /* JADX INFO: renamed from: p36.a$a, reason: collision with other inner class name */
    public interface InterfaceC7146a {
        void a(int r100);
    }

    static {
    }

    public static int a(Window r100, Context r101) {
        View r102 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == c.f346341a) goto L7;
        c.a(r103, "getDecorView");
    L7:
        Rect r104 = new Rect();
        r102.getWindowVisibleDisplayFrame(r104);
        int r105 = Math.abs(r102.getBottom() - r104.bottom);
        Resources r106 = r101.getResources();
        int r107 = r106.getDimensionPixelSize(r106.getIdentifier("status_bar_height", "dimen", "android"));
        Resources r108 = r101.getResources();
        if (r105 > (r107 + r108.getDimensionPixelSize(r108.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android")))) goto L12;
        f527590a = r105;
        return 0;
    L12:
        return r105 - f527590a;
    }
}
