package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.TintTypedArray;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS = null;
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS = null;
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    static {
        APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};
        MATERIAL_CHECK_ATTRS = new int[]{R.attr.colorSecondary};
    }

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(Context r100) {
        checkTheme(r100, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    public static void checkMaterialTheme(Context r100) {
        checkTheme(r100, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    public static boolean isAppCompatTheme(Context r100) {
        return isTheme(r100, APPCOMPAT_CHECK_ATTRS);
    }

    public static boolean isMaterialTheme(Context r100) {
        return isTheme(r100, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(Context r100, int[] r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101);
        boolean r103 = r102.hasValue(0);
        r102.recycle();
        return r103;
    }

    private static void checkTheme(Context r100, int[] r101, String r102) {
        if (isTheme(r100, r101) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + r102 + " (or a descendant).");
    }

    private static void checkCompatibleTheme(Context r100, AttributeSet r101, int r102, int r103) {
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.textAppearance, R.attr.enforceMaterialTheme, R.attr.enforceTextAppearance}, r102, r103);
        boolean r105 = r104.getBoolean(1, false);
        r104.recycle();
        if (r105 == false) goto L5;
        checkMaterialTheme(r100);
    L5:
        checkAppCompatTheme(r100);
    }

    private static void checkTextAppearance(Context r100, AttributeSet r101, int[] r102, int r103, int r104, int... r105) {
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.textAppearance, R.attr.enforceMaterialTheme, R.attr.enforceTextAppearance}, r103, r104);
        boolean r107 = false;
        if (r106.getBoolean(2, false) == true) goto L6;
        r106.recycle();
        return;
    L6:
        if (r105 == null) goto L12;
        if (r105.length == 0) goto L12;
        boolean r108 = isCustomTextAppearanceValid(r100, r101, r102, r103, r104, r105);
    L15:
        r106.recycle();
        if (r108 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L12:
        if (r106.getResourceId(0, -1) == (-1)) goto L14;
        r107 = true;
    L14:
        r108 = r107;
        goto L15
    }

    private static boolean isCustomTextAppearanceValid(Context r100, AttributeSet r101, int[] r102, int r103, int r104, int... r105) {
        TypedArray r106 = r100.obtainStyledAttributes(r101, r102, r103, r104);
        int r107 = r105.length;
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L9;
        if (r106.getResourceId(r105[r108], -1) == (-1)) goto L6;
        r108 = r108 + 1;
        goto L3
    L6:
        r106.recycle();
        return false;
    L9:
        r106.recycle();
        return true;
    }

    public static TypedArray obtainStyledAttributes(Context r100, AttributeSet r101, int[] r102, int r103, int r104, int... r105) {
        checkCompatibleTheme(r100, r101, r103, r104);
        checkTextAppearance(r100, r101, r102, r103, r104, r105);
        return r100.obtainStyledAttributes(r101, r102, r103, r104);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context r100, AttributeSet r101, int[] r102, int r103, int r104, int... r105) {
        checkCompatibleTheme(r100, r101, r103, r104);
        checkTextAppearance(r100, r101, r102, r103, r104, r105);
        return TintTypedArray.obtainStyledAttributes(r100, r101, r102, r103, r104);
    }
}
