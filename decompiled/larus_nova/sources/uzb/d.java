package uzb;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes37.dex */
public final class d extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f552245b = null;

    static {
        f552245b = new d();
    }

    public d() {
    }

    public static View c(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // uzb.e
    public final boolean b(Activity r100) {
        if (c(r100.getWindow()).isAttachedToWindow() == false) goto L5;
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(c(r100.getWindow()));
        if (r101 != null) goto L11;
        return super.b(r100);
    L11:
        if (r101.getSystemWindowInsetBottom() <= r101.getStableInsetBottom()) goto L13;
        return true;
    L13:
        return false;
    L5:
        return super.b(r100);
    }
}
