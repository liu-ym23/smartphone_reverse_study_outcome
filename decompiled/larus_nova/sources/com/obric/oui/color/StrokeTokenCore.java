package com.obric.oui.color;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.obric.oui.graphic.BlendMode;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class StrokeTokenCore {
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Blue_Regular = null;
    public static final j0 OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Blue_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Blue_Thin = null;
    public static final j0 OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Blue_Thin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Green_Regular = null;
    public static final j0 OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Green_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Green_Thin = null;
    public static final j0 OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Green_Thin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Red_Regular = null;
    public static final j0 OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Red_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Red_Thin = null;
    public static final j0 OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Red_Thin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Regular = null;
    public static final j0 OUI_Effect_Stroke_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Thick = null;
    public static final j0 OUI_Effect_Stroke_Thick_Dark = null;
    public static final j0 OUI_Effect_Stroke_Thick_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Thin = null;
    public static final j0 OUI_Effect_Stroke_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Thin_Light = null;
    public static final j0 OUI_Effect_Stroke_Tinted_Dark = null;
    public static final j0 OUI_Effect_Stroke_Tinted_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_UltraThin = null;
    public static final j0 OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final j0 OUI_Effect_Stroke_UltraThin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Thin_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, j0>> providers;
    private static volatile ConcurrentHashMap<String, j0> tokens;

    public static /* synthetic */ j0 a(Boolean r100) {
        return lambda$static$5(r100);
    }

    public static /* synthetic */ j0 b(Boolean r100) {
        return lambda$static$4(r100);
    }

    public static /* synthetic */ j0 c(Boolean r100) {
        return lambda$static$8(r100);
    }

    public static /* synthetic */ j0 d(Boolean r100) {
        return lambda$static$7(r100);
    }

    public static /* synthetic */ j0 e(Boolean r100) {
        return lambda$static$0(r100);
    }

    public static /* synthetic */ j0 f(Boolean r100) {
        return lambda$static$6(r100);
    }

    public static /* synthetic */ j0 g(Boolean r100) {
        return lambda$static$1(r100);
    }

    public static /* synthetic */ j0 h(Boolean r100) {
        return lambda$static$3(r100);
    }

    public static /* synthetic */ j0 i(Boolean r100) {
        return lambda$static$11(r100);
    }

    public static /* synthetic */ j0 j(Function1 r100, Boolean r101) {
        return lambda$toCoreProviders$12(r100, r101);
    }

    public static /* synthetic */ j0 k(Boolean r100) {
        return lambda$static$10(r100);
    }

    public static /* synthetic */ j0 l(Boolean r100) {
        return lambda$static$9(r100);
    }

    public static /* synthetic */ j0 m(Boolean r100) {
        return lambda$static$2(r100);
    }

    static {
        BlendMode r100 = BlendMode.SRC_OVER;
        OUI_Effect_Stroke_Regular_Light = new j0(1.0f, 1728053247, r100);
        OUI_Effect_Stroke_Regular_Dark = new j0(1.0f, 1715618370, r100);
        OUI_Effect_Stroke_Regular = new q0();
        OUI_Effect_Stroke_UltraThin_Light = new j0(1.0f, 452984831, r100);
        OUI_Effect_Stroke_UltraThin_Dark = new j0(1.0f, 452984831, r100);
        OUI_Effect_Stroke_UltraThin = new t0();
        OUI_Effect_Stroke_Thin_Light = new j0(1.0f, 1728053247, r100);
        OUI_Effect_Stroke_Thin_Dark = new j0(1.0f, AMapEngineUtils.HALF_MAX_P20_WIDTH, r100);
        OUI_Effect_Stroke_Thin = new u0();
        OUI_Effect_Stroke_Thick_Light = new j0(1.0f, 1727526903, r100);
        OUI_Effect_Stroke_Thick_Dark = new j0(1.0f, 1294872110, r100);
        OUI_Effect_Stroke_Thick = new v0();
        OUI_Effect_Stroke_Tinted_Light = new j0(1.0f, 1728053247, r100);
        OUI_Effect_Stroke_Tinted_Dark = new j0(1.0f, 1728053247, r100);
        OUI_Effect_Stroke_Blue_Regular_Light = new j0(1.0f, 1713799679, r100);
        OUI_Effect_Stroke_Blue_Regular_Dark = new j0(1.0f, 1713799679, r100);
        OUI_Effect_Stroke_Blue_Regular = new w0();
        OUI_Effect_Stroke_Blue_Thin_Light = new j0(1.0f, 1718003455, r100);
        OUI_Effect_Stroke_Blue_Thin_Dark = new j0(1.0f, 1718003455, r100);
        OUI_Effect_Stroke_Blue_Thin = new x0();
        OUI_Effect_Stroke_Red_Regular_Light = new j0(1.0f, 1728007501, r100);
        OUI_Effect_Stroke_Red_Regular_Dark = new j0(1.0f, 1728007501, r100);
        OUI_Effect_Stroke_Red_Regular = new y0();
        OUI_Effect_Stroke_Red_Thin_Light = new j0(1.0f, 1728022407, r100);
        OUI_Effect_Stroke_Red_Thin_Dark = new j0(1.0f, 1728022407, r100);
        OUI_Effect_Stroke_Red_Thin = new n0();
        OUI_Effect_Stroke_Green_Regular_Light = new j0(1.0f, 1712637776, r100);
        OUI_Effect_Stroke_Green_Regular_Dark = new j0(1.0f, 1712637776, r100);
        OUI_Effect_Stroke_Green_Regular = new o0();
        OUI_Effect_Stroke_Green_Thin_Light = new j0(1.0f, 1719135647, r100);
        OUI_Effect_Stroke_Green_Thin_Dark = new j0(1.0f, 1719135647, r100);
        OUI_Effect_Stroke_Green_Thin = new p0();
        OUI_Effect_Stroke_Yellow_Regular_Light = new j0(1.0f, 1728038170, r100);
        OUI_Effect_Stroke_Yellow_Regular_Dark = new j0(1.0f, 1728038170, r100);
        OUI_Effect_Stroke_Yellow_Regular = new r0();
        OUI_Effect_Stroke_Yellow_Thin_Light = new j0(1.0f, 1728041577, r100);
        OUI_Effect_Stroke_Yellow_Thin_Dark = new j0(1.0f, 1728041577, r100);
        OUI_Effect_Stroke_Yellow_Thin = new s0();
    }

    private StrokeTokenCore() {
    }

    private static ConcurrentHashMap<String, Function1<Boolean, j0>> getProviders(Object r100) {
        ConcurrentHashMap<String, Function1<Boolean, j0>> r101 = providers;
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r101 = providers;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = com.obric.oui.material.s.a(StrokeTokenCore.class, Function1.class);     // Catch: Throwable -> L11
        providers = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, j0> getTokens(Object r100) {
        ConcurrentHashMap<String, j0> r101 = tokens;
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r101 = tokens;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = com.obric.oui.material.s.a(StrokeTokenCore.class, j0.class);     // Catch: Throwable -> L11
        tokens = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ j0 lambda$static$0(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$1(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_UltraThin_Light;
    L6:
        return OUI_Effect_Stroke_UltraThin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$10(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$11(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$2(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$3(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Thick_Light;
    L6:
        return OUI_Effect_Stroke_Thick_Dark;
    }

    private static /* synthetic */ j0 lambda$static$4(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$5(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$6(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Red_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Red_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$7(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Red_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Red_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$8(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Green_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Green_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$9(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        return OUI_Effect_Stroke_Green_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Green_Thin_Dark;
    }

    private static j0 toCore(j0 r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new j0(r100.f399496a, r100.f399497b, r100.f399498c);
    }

    private static ConcurrentHashMap<String, Function1<Boolean, j0>> toCoreProviders(Map<String, ? extends Function1<Boolean, j0>> r100) {
        ConcurrentHashMap<String, Function1<Boolean, j0>> r101 = new ConcurrentHashMap();
        if (r100 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, ? extends Function1<Boolean, j0>>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Function1<Boolean, j0>> r103 = r102.next();
        final Function1<Boolean, j0> r104 = r103.getValue();
        r101.put(r103.getKey(), new m0(r104));
        goto L9
    }

    private static ConcurrentHashMap<String, j0> toCoreTokens(Map<String, j0> r100) {
        ConcurrentHashMap<String, j0> r101 = new ConcurrentHashMap();
        if (r100 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, j0>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, j0> r103 = r102.next();
        r101.put(r103.getKey(), toCore(r103.getValue()));
        goto L9
    }

    private static /* synthetic */ j0 lambda$toCoreProviders$12(Function1 r100, Boolean r101) {
        return toCore((j0) r100.invoke(r101));
    }

    public static Function1<Boolean, j0> parseProvider(Object r100, String r101) {
        return (Function1) com.obric.oui.material.s.c(r101, getProviders(r100));
    }

    public static j0 parse(Object r100, String r101, boolean r102) {
        j0 r103 = (j0) com.obric.oui.material.s.c(r101, getTokens(r100));
        if (r103 != null) goto L10;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        if (r102 == false) goto L7;
        String r105 = "_light";
    L8:
        r104.append(r105);
        return (j0) com.obric.oui.material.s.c(r104.toString(), getTokens(r100));
    L7:
        r105 = "_dark";
        goto L8
    L10:
        return r103;
    }

    public static void register(Object r100, Object r101, boolean r102) {
        com.obric.oui.material.s.d(getTokens(r100), r101, j0.class, r102);
        com.obric.oui.material.s.e(getTokens(r100), toCoreTokens(com.obric.oui.material.s.b(r101, j0.class)), r102);
    }

    public static void registerProvider(Object r100, Object r101, boolean r102) {
        com.obric.oui.material.s.d(getProviders(r100), r101, Function1.class, r102);
    }

    public static void registerProviderTokens(Object r100, Map<String, ? extends Function1<Boolean, j0>> r101, boolean r102) {
        com.obric.oui.material.s.e(getProviders(r100), toCoreProviders(r101), r102);
    }

    public static void registerTokens(Object r100, Map<String, j0> r101, boolean r102) {
        com.obric.oui.material.s.e(getTokens(r100), toCoreTokens(r101), r102);
    }
}
