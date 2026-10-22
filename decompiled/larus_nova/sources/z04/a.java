package z04;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    static {
    }

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

    @JvmStatic
    public static final void b(Activity r100, int r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Window r101 = r100.getWindow();
        if (r101 == null) goto L29;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 26) goto L27;
        r101.setNavigationBarColor(r110);
        if (r111 == null) goto L9;
        boolean r112 = r111.booleanValue();
    L13:
        Intrinsics.checkNotNullParameter(r101, LiveEndPageData.TAG_WINDOW);
        if (r102 < 26) goto L27;
        int r113 = a(r101).getSystemUiVisibility();
        if (r112 == false) goto L24;
        WindowManager.LayoutParams r114 = r101.getAttributes();
        if ((r114.flags & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L21;
        r101.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L21:
        if ((r114.flags & Integer.MIN_VALUE) != 0) goto L23;
        r101.addFlags(Integer.MIN_VALUE);
    L23:
        int r115 = r113 | 16;
    L25:
        if (r115 == r113) goto L27;
        a(r101).setSystemUiVisibility(r115);
        goto L27
    L24:
        r115 = r113 & (-17);
        goto L25
    L9:
        int r116 = Color.red(r110);
        int r103 = Color.green(r110);
        if ((((((double) r116) * 0.299d) + (((double) r103) * 0.587d)) + (((double) Color.blue(r110)) * 0.114d)) < 192.0d) goto L12;
        r112 = true;
        goto L13
    L12:
        r112 = false;
    L27:
        Unit r104 = Unit.INSTANCE;
        return;
    }
}
