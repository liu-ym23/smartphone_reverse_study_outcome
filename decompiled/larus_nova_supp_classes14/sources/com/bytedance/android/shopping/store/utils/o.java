package com.bytedance.android.shopping.store.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static final float a = 0.0f;
    public static final float b = 0.0f;
    public static final boolean c = false;

    static {
        boolean r2 = true;
        if (ECShopABSettings.d() != 1) goto L13;
        Configuration r0 = Resources.getSystem().getConfiguration();
        if (r0 == null) goto L8;
        Float r1 = Float.valueOf(r0.fontScale);
    L9:
        float r3 = com.bytedance.android.shopping.extensions.k.e(r1, 1.0f);
        if (r3 >= 0.0f) goto L12;
    L14:
        float r4 = 1.15f;
    L15:
        a = r4;
        Resources r5 = Resources.getSystem();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels;
        Resources r7 = Resources.getSystem();
        b = (r6 / WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density) / 375.0f;
        if (r4 > 1.0f) goto L19;
        r2 = false;
    L19:
        c = r2;
        return;
    L12:
        if (r3 > 1.0f) goto L14;
    L8:
        r1 = null;
    L13:
        r4 = 1.0f;
        goto L15
    }

    public static final int a(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$spStore");
        boolean r0 = ECStoreFoldPhoneHelper.d();
        float r3 = r2.floatValue();
        if (r0 == true) goto L6;
        r3 = (r3 * a) * b;
    L6:
        Resources r1 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    }
}
