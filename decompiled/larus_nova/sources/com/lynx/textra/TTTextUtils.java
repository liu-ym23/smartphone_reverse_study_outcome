package com.lynx.textra;

import android.content.Context;

/* JADX INFO: loaded from: classes32.dex */
public class TTTextUtils {
    public static Context context = null;
    public static float density_ = 1.0f;

    public TTTextUtils() {
    }

    public static float Dp2Px(float r100, float r101) {
        return (r100 * r101) / 160.0f;
    }

    public static float Px2Dp(float r100, float r101) {
        return (r100 * 160.0f) / r101;
    }

    public static native int nativeGetSystemPropInt(String r100);

    public static String SystemDefaultFamilyName() {
        Context r100 = context;
        if (r100 != null) goto L7;
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    L7:
        return PlatformFontCaps.Factory.getStrategy(r100).defaultFamilyName();
    }

    public static float Dp2Px(float r100) {
        return r100 * density_;
    }

    public static float Px2Dp(float r100) {
        return r100 / density_;
    }

    public static void SetDpi(float r100) {
        monitor-enter(TTTextUtils.class);
        density_ = r100 / 160.0f;     // Catch: Throwable -> L8
        monitor-exit(TTTextUtils.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static byte[] SystemFontStyleAdjust(float r100, short r101) {
        BBufferOutputStream r102 = new BBufferOutputStream(6);
        r102.writeFloat(r100);
        Context r103 = context;
        if (r103 == null) goto L5;
        r102.writeShort(PlatformFontCaps.Factory.getStrategy(r103).adjust(r101));
    L7:
        return r102.getByteArray();
    L5:
        r102.writeShort(r101);
        goto L7
    }
}
