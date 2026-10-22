package com.lynx.canvas;

/* JADX INFO: loaded from: classes32.dex */
public class Settings {
    public Settings() {
    }

    private static KryptonSettingsService getSettingsService(KryptonApp r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (KryptonSettingsService) r100.getService(KryptonSettingsService.class);
    }

    public static boolean booleanValueForKey(KryptonApp r100, String r101, boolean r102) {
        KryptonSettingsService r103 = getSettingsService(r100);
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.booleanValueForKey(r101, r102);
    }

    public static double doubleValueForKey(KryptonApp r100, String r101, double r102) {
        KryptonSettingsService r103 = getSettingsService(r100);
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.doubleValueForKey(r101, r102);
    }

    public static int integerValueForKey(KryptonApp r100, String r101, int r102) {
        KryptonSettingsService r103 = getSettingsService(r100);
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.integerValueForKey(r101, r102);
    }

    public static String stringValueForKey(KryptonApp r100, String r101, String r102) {
        KryptonSettingsService r103 = getSettingsService(r100);
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.stringValueForKey(r101, r102);
    }
}
