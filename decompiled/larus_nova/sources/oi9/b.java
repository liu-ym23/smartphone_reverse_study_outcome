package oi9;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes30.dex */
public final class b extends oi9.a {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f523474a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            r100[NetworkUtils.NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[NetworkUtils.NetworkType.MOBILE_3G_H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[NetworkUtils.NetworkType.MOBILE_3G_HP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[NetworkUtils.NetworkType.WIFI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[NetworkUtils.NetworkType.WIFI_24GHZ.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[NetworkUtils.NetworkType.WIFI_5GHZ.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f523474a = r100;
        }
    }

    public b() {
    }

    public static View e(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final int f(Context r100, Context r101) {
        if (r100 != null) goto L5;
        r100 = r101;
    L5:
        if (r100.getResources().getConfiguration().orientation != 2) goto L7;
        boolean r102 = true;
    L8:
        int r103 = g(vd7.c.b(r100), r100);
        int r104 = g(vd7.c.a(r100), r100);
        if (r102 == false) goto L12;
        return Math.min(r103, r104);
    L12:
        return Math.max(r103, r104);
    L7:
        r102 = false;
        goto L8
    }

    public final int g(double r100, Context r101) {
        Resources r102 = r101.getResources();
        return (int) ((r100 / ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)) + ((double) 0.5f));
    }
}
