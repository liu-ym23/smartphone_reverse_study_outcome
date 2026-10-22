package com.bytedance.awemeopen.apps.framework.framework.viewpager.helper;

import android.app.Activity;
import android.content.SharedPreferences;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.user.c;
import k34.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosEnterDyPlayerToastHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(AosEnterDyPlayerToastHelper$tipSp$2.INSTANCE);
    }

    public static void a(Activity r11, String r12) {
        d14.a r0 = b14.a.a;
        c r1 = b14.a.a(b.class).getAccessToken();
        if (r1 == null) goto L5;
        String r2 = r1.b;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return;
    L15:
        long r4 = AosExtConfig.b.v(r2);
        Lazy r5 = a;
        if (k0.c(System.currentTimeMillis(), RangesKt.coerceAtLeast(0, RangesKt.coerceAtLeast(r4, ((SharedPreferences) r5.getValue()).getLong(r2, 0)))) == false) goto L18;
        return;
    L18:
        String r13 = p0.a(r12);
        if (r13.length() <= 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L25;
        XToast r7 = new XToast(r11, y54.a.a().getString(2131894189, new Object[]{r13}), 3);
        r7.h = 3000;
        r7.d = 1;
        r7.b();
        ((SharedPreferences) r5.getValue()).edit().putLong(r2, System.currentTimeMillis()).apply();
        return;
    L25:
        return;
    L21:
        r6 = false;
        goto L22
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }
}
