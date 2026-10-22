package j08;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.ColorUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f496832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f496833b;

    public final void a() {
        int r100 = Build.VERSION.SDK_INT;
        Window r101 = this.f496832a;
        if (r100 < 28) goto L5;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.layoutInDisplayCutoutMode = 1;
        r101.setAttributes(r102);
    L5:
        Window r103 = this.f496832a;
        r103.clearFlags(67108864);
        r103.addFlags(Integer.MIN_VALUE);
        r103.setStatusBarColor(ColorUtils.blendARGB(this.f496833b, -16777216, 0.0f));
        r103.setNavigationBarColor(ColorUtils.blendARGB(this.f496833b, -16777216, 0.0f));
        if (r100 < 23) goto L8;
        int r104 = 9472;
    L9:
        int r105 = (r104 | 0) | 4096;
        View r106 = this.f496832a.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L14:
        r106.setSystemUiVisibility(r105);
        return;
    L8:
        r104 = 1280;
        goto L9
    }

    public a(Window r100) {
        this.f496833b = 0;
        this.f496832a = r100;
    }
}
