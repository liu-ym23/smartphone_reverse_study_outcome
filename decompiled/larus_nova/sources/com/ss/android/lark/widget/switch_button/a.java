package com.ss.android.lark.widget.switch_button;

import android.R;
import android.content.res.ColorStateList;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final ColorStateList a(int r100) {
        int r101 = r100 - (-805306368);
        return new ColorStateList(new int[][]{new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910}, new int[]{R.attr.state_checked, R.attr.state_pressed}, new int[]{-16842912, R.attr.state_pressed}, new int[]{R.attr.state_checked}, new int[]{-16842912}}, new int[]{r100 - (-520093696), 268435456, r101, 536870912, r101, 536870912});
    }

    @JvmStatic
    public static final ColorStateList b(int r100) {
        int r101 = r100 - (-1728053248);
        return new ColorStateList(new int[][]{new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910}, new int[]{R.attr.state_pressed, -16842912}, new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_checked}, new int[]{-16842912}}, new int[]{r100 - (-1442840576), -4539718, r101, r101, r100 | (-16777216), -1118482});
    }
}
