package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.ee.bear.doc.blockeditpanel.model.CustomColorStates;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static ColorStateList e(CustomColorStates r5) {
        return c(b(r5.getPressedColor(), r5.getDefaultColor()), b(r5.getSelectedColor(), r5.getDefaultColor()), b(r5.getPressedInSelectedColor(), r5.getDefaultColor()), b(r5.getDisabledColor(), r5.getDefaultColor()), b(r5.getDefaultColor(), r5.getDefaultColor()));
    }

    public static int a(Context r4, EMenuItemConfig.b r5) {
        int r6 = r4.getResources().getColor(r5.a);
        double r0 = r5.b;
        int r7 = n.a;
        if (r0 < 0.0d) goto L9;
        if (r0 > 1.0d) goto L9;
        return ColorUtils.setAlphaComponent(r6, (int) (r0 * 255.0d));
    L9:
        throw new IllegalArgumentException();
    }

    public static int b(String r0, String r1) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return com.larksuite.framework.utils.b.a.getResources().getColor(2131106500);
    L6:
        if (r0 == null) goto L10;
        return com.bytedance.ee.util.ui.ColorUtils.h(r0);
    L10:
        return com.bytedance.ee.util.ui.ColorUtils.h(r1);
    }

    public static ColorStateList d(Context r4, EMenuItemConfig.a r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return c(a(r4, r5.a), a(r4, r5.c), a(r4, r5.d), a(r4, r5.b), a(r4, r5.e));
    }

    public static void f(View r1, EMenuItemConfig.a r2) {
        if (r2 == null) goto L4;
        r1.setBackgroundTintList(d(r1.getContext(), r2));
        return;
    L4:
        r1.setBackgroundTintList(null);
    }

    public static void g(ImageView r1, EMenuItemConfig.a r2) {
        if (r2 == null) goto L4;
        r1.setImageTintList(d(r1.getContext(), r2));
        return;
    L4:
        r1.setImageTintList(null);
    }

    public static ColorStateList c(int r8, int r9, int r10, int r11, int r12) {
        return new ColorStateList(new int[][]{new int[]{-16842913, R.attr.state_pressed}, new int[]{R.attr.state_selected, -16842919}, new int[]{R.attr.state_selected, R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{r8, r9, r10, r11, r12});
    }
}
