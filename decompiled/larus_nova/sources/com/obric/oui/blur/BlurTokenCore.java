package com.obric.oui.blur;

import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurTokenCore {
    public static final float Blur_Background_Regular = 20.0f;
    public static final float Blur_Background_Thick = 64.0f;
    public static final float Blur_Progress_Regular = 20.0f;
    public static final float Blur_Progress_Thin = 8.0f;
    public static final float Blur_Regular = 20.0f;
    public static final float Blur_Thick = 32.0f;
    public static final float Blur_Thin = 8.0f;
    public static final float Blur_UltraThick = 64.0f;
    public static final float Blur_UltraThin = 0.0f;
    static final float Blur_UltraThin_V1 = 4.0f;
    static final float Blur_UltraThin_V2 = 2.0f;
    public static final float Blur_Zero = 0.1f;
    private static volatile ConcurrentHashMap<String, Float> tokens;

    static {
        if (OMaterialHelper.f() < 4) goto L5;
        float r100 = 2.0f;
    L6:
        Blur_UltraThin = r100;
        return;
    L5:
        r100 = 4.0f;
        goto L6
    }

    private BlurTokenCore() {
    }

    private static ConcurrentHashMap<String, Float> getTokens(Object r100) {
        ConcurrentHashMap<String, Float> r101 = tokens;
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(BlurTokenCore.class);
        r101 = tokens;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        ConcurrentHashMap<String, Float> r102 = s.b(r100, Float.class);     // Catch: Throwable -> L11
        tokens = r102;     // Catch: Throwable -> L11
        r101 = r102;
    L9:
        monitor-exit(BlurTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static Float parse(Object r100, String r101) {
        return (Float) s.c(r101, getTokens(r100));
    }

    public static void register(Object r100, Object r101, boolean r102) {
        s.d(getTokens(r100), r101, Float.class, r102);
    }

    public static void registerTokens(Object r100, Map<String, Float> r101, boolean r102) {
        s.e(getTokens(r100), r101, r102);
    }
}
