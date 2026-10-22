package com.google.android.material.resources;

/* JADX INFO: loaded from: classes23.dex */
public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public TextAppearanceConfig() {
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }

    public static void setShouldLoadFontSynchronously(boolean r100) {
        shouldLoadFontSynchronously = r100;
    }
}
