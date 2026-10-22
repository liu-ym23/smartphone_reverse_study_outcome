package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import androidx.core.graphics.ColorUtils;
import com.bytedance.ee.bear.doc.blockeditpanel.model.CustomColorStates;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class f {
    public static ColorStateList e(CustomColorStates r100) {
        return c(b(r100.getPressedColor(), r100.getDefaultColor()), b(r100.getSelectedColor(), r100.getDefaultColor()), b(r100.getPressedInSelectedColor(), r100.getDefaultColor()), b(r100.getDisabledColor(), r100.getDefaultColor()), b(r100.getDefaultColor(), r100.getDefaultColor()));
    }

    public static int a(Context r100, EMenuItemConfig.b r101) {
        int r102 = r100.getResources().getColor(r101.f217625a);
        double r103 = r101.f217626b;
        int r104 = n.f243167a;
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        if (r103 > 1.0d) goto L9;
        return ColorUtils.setAlphaComponent(r102, (int) (r103 * 255.0d));
    L9:
        throw new IllegalArgumentException();
    }

    public static int b(String r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return com.larksuite.framework.utils.b.f285948a.getResources().getColor(R.color.static_black);
    L6:
        if (r100 == null) goto L10;
        return com.bytedance.ee.util.ui.ColorUtils.h(r100);
    L10:
        return com.bytedance.ee.util.ui.ColorUtils.h(r101);
    }

    public static ColorStateList d(Context r100, EMenuItemConfig.a r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return c(a(r100, r101.f217620a), a(r100, r101.f217622c), a(r100, r101.f217623d), a(r100, r101.f217621b), a(r100, r101.f217624e));
    }

    public static void f(View r100, EMenuItemConfig.a r101) {
        if (r101 == null) goto L4;
        r100.setBackgroundTintList(d(r100.getContext(), r101));
        return;
    L4:
        r100.setBackgroundTintList(null);
    }

    public static void g(ImageView r100, EMenuItemConfig.a r101) {
        if (r101 == null) goto L4;
        r100.setImageTintList(d(r100.getContext(), r101));
        return;
    L4:
        r100.setImageTintList(null);
    }

    public static ColorStateList c(int r100, int r101, int r110, int r111, int r112) {
        return new ColorStateList(new int[][]{new int[]{-16842913, android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected, -16842919}, new int[]{android.R.attr.state_selected, android.R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{r100, r101, r110, r111, r112});
    }
}
