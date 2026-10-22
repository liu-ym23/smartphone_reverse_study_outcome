package com.bytedance.bdp.bdpbase.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes11.dex */
public final class o {
    public static Activity getActivity(View r100) {
        Context r101 = r100.getContext();
        if ((r101 instanceof Activity) == true) goto L5;
        View r102 = r100.getRootView();
        if (r102 != null) goto L9;
        return null;
    L9:
        Context r103 = r102.getContext();
        if ((r103 instanceof Activity) == true) goto L12;
        View r104 = r102.findViewById(R.id.content);
        if (r104 != null) goto L16;
        return null;
    L16:
        Context r105 = r104.getContext();
    L17:
        if (r105 == null) goto L25;
        if ((r105 instanceof Activity) == true) goto L21;
        if ((r105 instanceof ContextWrapper) == false) goto L17;
        r105 = ((ContextWrapper) r105).getBaseContext();
        goto L17
    L21:
        return (Activity) r105;
    L25:
        return null;
    L12:
        return (Activity) r103;
    L5:
        return (Activity) r101;
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    public static String b(Context r100, int r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getApplicationContext().getResources().getString(r101);
    }

    public static int c(String r100, String r101) {
        if (r100 != null) goto L4;
    L3:
        r100 = r101;
    L23:
        if (TextUtils.isEmpty(r100) == true) goto L27;
        return Color.parseColor(r100);
    L27:
        return ColorProtector.parseColor(r101);
    L4:
        int r102 = r100.length();
        StringBuilder r103 = new StringBuilder("#");
        if (r102 != 7) goto L10;
        if (r100.charAt(0) == '#') goto L23;
    L10:
        if (r102 != 9) goto L15;
        if (r100.charAt(0) != '#') goto L15;
        r103.append(r100.substring(7, 9));
        r103.append(r100.substring(1, 7));
        r100 = r103.toString();
    L15:
        if (r102 == 4) goto L18;
        if (r102 != 5) goto L3;
    L18:
        if (r100.charAt(0) != '#') goto L3;
        if (r102 != 5) goto L21;
        r103.append(r100.charAt(4));
        r103.append(r100.charAt(4));
    L21:
        r103.append(r100.charAt(1));
        r103.append(r100.charAt(1));
        r103.append(r100.charAt(2));
        r103.append(r100.charAt(2));
        r103.append(r100.charAt(3));
        r103.append(r100.charAt(3));
        r100 = r103.toString();
        goto L23
    }

    public static final void d(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() == r101) goto L18;
        if (r101 != 0) goto L7;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L19;
        r100.setVisibility(r101);
        return;
    L19:
        return;
    L7:
        if (r101 == 8) goto L12;
        if (r101 == 4) goto L12;
        r102 = false;
        goto L13
    }

    public static ColorStateList e(int r100, int r101) {
        int[] r102 = {r101, r101, r100, r101, r100, r100};
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, r102);
    }
}
