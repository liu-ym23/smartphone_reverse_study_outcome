package com.google.android.gms.common.util;

import android.os.Build;
import androidx.core.os.BuildCompat;

/* JADX INFO: loaded from: classes23.dex */
public final class PlatformVersion {
    private PlatformVersion() {
    }

    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    public static boolean isAtLeastJellyBean() {
        return true;
    }

    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    public static boolean isAtLeastKitKat() {
        return true;
    }

    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    public static boolean isAtLeastLollipop() {
        return true;
    }

    public static boolean isAtLeastLollipopMR1() {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastM() {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastS() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastSv2() {
        if (Build.VERSION.SDK_INT < 32) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAtLeastU() {
        if (isAtLeastT() == true) goto L7;
        return false;
    L7:
        return BuildCompat.isAtLeastU();
    }

    public static boolean isAtLeastV() {
        if (isAtLeastU() == true) goto L7;
        return false;
    L7:
        return BuildCompat.isAtLeastV();
    }
}
