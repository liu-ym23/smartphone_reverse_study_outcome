package com.obric.oui.fluid;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class FluidTokenCore {
    public static final b OUI_Effect_Fluid_Regular_Dark = null;
    static final b OUI_Effect_Fluid_Regular_Dark_V1 = null;
    static final b OUI_Effect_Fluid_Regular_Dark_V2 = null;
    public static final b OUI_Effect_Fluid_Regular_Light = null;
    static final b OUI_Effect_Fluid_Regular_Light_V1 = null;
    static final b OUI_Effect_Fluid_Regular_Light_V2 = null;
    public static final b OUI_Effect_Fluid_Thin_Dark = null;
    static final b OUI_Effect_Fluid_Thin_Dark_V1 = null;
    static final b OUI_Effect_Fluid_Thin_Dark_V2 = null;
    public static final b OUI_Effect_Fluid_Thin_Light = null;
    static final b OUI_Effect_Fluid_Thin_Light_V1 = null;
    static final b OUI_Effect_Fluid_Thin_Light_V2 = null;
    private static volatile ConcurrentHashMap<String, b> tokens;

    static {
        BlendMode r110 = BlendMode.COLOR_DODGE;
        BlendMode r111 = BlendMode.PLUS_LIGHTER;
        b r100 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 1.0f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r110.getPorterDuffMode(), Float.intBitsToFloat(452984831), r111.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Light_V2 = r100;
        b r101 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.8f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r110.getPorterDuffMode(), Float.intBitsToFloat(872415231), r111.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V2 = r101;
        b r112 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r110.getPorterDuffMode(), Float.intBitsToFloat(452984831), r111.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Light_V2 = r112;
        b r113 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.4f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r110.getPorterDuffMode(), Float.intBitsToFloat(872415231), r111.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V2 = r113;
        b r102 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.6f, 0.0f});
        OUI_Effect_Fluid_Regular_Light_V1 = r102;
        b r103 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.16f, 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V1 = r103;
        b r104 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.3f, 0.0f});
        OUI_Effect_Fluid_Thin_Light_V1 = r104;
        b r105 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.1f, 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V1 = r105;
        if (OMaterialHelper.f() >= 4) goto L6;
        r100 = r102;
    L6:
        OUI_Effect_Fluid_Regular_Light = r100;
        if (OMaterialHelper.f() >= 4) goto L10;
        r101 = r103;
    L10:
        OUI_Effect_Fluid_Regular_Dark = r101;
        if (OMaterialHelper.f() >= 4) goto L14;
        r112 = r104;
    L14:
        OUI_Effect_Fluid_Thin_Light = r112;
        if (OMaterialHelper.f() >= 4) goto L18;
        r113 = r105;
    L18:
        OUI_Effect_Fluid_Thin_Dark = r113;
    }

    private FluidTokenCore() {
    }

    private static ConcurrentHashMap<String, b> getTokens(Object r100) {
        ConcurrentHashMap<String, b> r101 = tokens;
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(FluidTokenCore.class);
        r101 = tokens;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = s.a(FluidTokenCore.class, b.class);     // Catch: Throwable -> L11
        tokens = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(FluidTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static b parse(Object r100, String r101) {
        return (b) s.c(r101, getTokens(r100));
    }

    public static void register(Object r100, Object r101, boolean r102) {
        s.d(getTokens(r100), r101, b.class, r102);
    }

    public static void registerTokens(Object r100, Map<String, b> r101, boolean r102) {
        s.e(getTokens(r100), r101, r102);
    }
}
