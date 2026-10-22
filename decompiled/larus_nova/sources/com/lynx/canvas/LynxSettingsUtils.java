package com.lynx.canvas;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.tasm.service.ILynxTrailService;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxSettingsUtils {
    private static final String TAG = "LynxSettingsUtils";

    public LynxSettingsUtils() {
    }

    public static boolean booleanValueForKey(String r100, boolean r101) {
        Object r102 = objectValueForKey(r100, null);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Boolean) == false) goto L10;
        return ((Boolean) r102).booleanValue();
    L10:
        if ((r102 instanceof Number) == false) goto L17;
        if (((Number) r102).doubleValue() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L30;
        return false;
    L30:
        return true;
    L17:
        if ((r102 instanceof String) == false) goto L29;
        String r103 = (String) r102;
        if (r103.equalsIgnoreCase("true") == false) goto L21;
    L28:
        return true;
    L21:
        if (r103.equals("1") == true) goto L28;
        if (r103.equalsIgnoreCase("false") == false) goto L26;
    L27:
        return false;
    L26:
        if (r103.equals("0") == true) goto L27;
    L29:
        return r101;
    }

    public static double doubleValueForKey(String r100, double r101) {
        Object r102 = objectValueForKey(r100, null);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Number) == false) goto L10;
        return ((Number) r102).doubleValue();
    L10:
        if ((r102 instanceof Boolean) == false) goto L17;
        if (((Boolean) r102).booleanValue() == false) goto L14;
        return 1.0d;
    L14:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L17:
        if ((r102 instanceof String) == true) goto L23;
    L22:
        return r101;
    L23:
        return CastDoubleProtector.parseDouble((String) r102);
    L20:
        e = move-exception;
        KryptonLLog.w(TAG, e.toString());
        goto L22
    }

    public static int integerValueForKey(String r100, int r101) {
        Object r102 = objectValueForKey(r100, null);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Number) == false) goto L10;
        return ((Number) r102).intValue();
    L10:
        if ((r102 instanceof Boolean) == false) goto L14;
        return ((Boolean) r102).booleanValue() ? 1 : 0;
    L14:
        if ((r102 instanceof String) == true) goto L20;
    L19:
        return r101;
    L20:
        return CastIntegerProtector.parseInt((String) r102);
    L17:
        e = move-exception;
        KryptonLLog.w(TAG, e.toString());
        goto L19
    }

    public static Object objectValueForKey(String r100, Object r101) {
        ILynxTrailService r102 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.objectValueForTrailKey(r100);
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103;
    }

    public static String stringValueForKey(String r100, String r101) {
        Object r102 = objectValueForKey(r100, null);
        if (r102 != null) goto L5;
    L8:
        return r101;
    L5:
        if ((r102 instanceof String) == false) goto L8;
        return (String) r102;
    }
}
