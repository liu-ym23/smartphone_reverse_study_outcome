package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.blur.BlurTokenCore;
import com.obric.oui.color.BlendTokenCore;
import com.obric.oui.color.StrokeTokenCore;
import com.obric.oui.color.j0;
import com.obric.oui.fluid.FluidTokenCore;
import com.obric.oui.shadow.ShadowTokenCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class MaterialTokenCore {
    public static final e[] OUI_Bg_Floating_Blue_Dark = null;
    public static final e[] OUI_Bg_Floating_Blue_Light = null;
    public static final e[] OUI_Bg_Floating_Dark = null;
    public static final e[] OUI_Bg_Floating_Fill_Dark = null;
    public static final e OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_Fill_Light = null;
    public static final e OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final e OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final e OUI_Bg_Floating_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final e OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final e OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final e OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final e OUI_Bg_Floating_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Frost_Light = null;
    public static final e OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final e OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final e[] OUI_Bg_Floating_Light = null;
    public static final e[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final e OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final e OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final e OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_OnImage_Light = null;
    public static final e[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final e OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_Overlay_Light = null;
    public static final e[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final e[] OUI_Bg_Floating_Tinted_Light = null;
    public static final e[] OUI_Bg_Modal_Dark = null;
    public static final e OUI_Bg_Modal_Fluid_Dark = null;
    public static final e OUI_Bg_Modal_Fluid_Light = null;
    public static final e OUI_Bg_Modal_Frost_Dark = null;
    public static final e OUI_Bg_Modal_Frost_Light = null;
    public static final e[] OUI_Bg_Modal_Light = null;
    public static final e[] OUI_Bg_Overlay_Search_Dark = null;
    public static final e OUI_Bg_Overlay_Search_Fluid_Dark = null;
    public static final e OUI_Bg_Overlay_Search_Fluid_Light = null;
    public static final e OUI_Bg_Overlay_Search_Frost_Dark = null;
    public static final e OUI_Bg_Overlay_Search_Frost_Light = null;
    public static final e[] OUI_Bg_Overlay_Search_Light = null;
    public static final e[] OUI_Bg_Popup_Dark = null;
    public static final e OUI_Bg_Popup_Fluid_Dark = null;
    public static final e OUI_Bg_Popup_Fluid_Light = null;
    public static final e OUI_Bg_Popup_Frost_Dark = null;
    public static final e OUI_Bg_Popup_Frost_Light = null;
    public static final e[] OUI_Bg_Popup_Light = null;
    public static final e[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final e OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final e OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final e OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final e OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final e[] OUI_Bg_Popup_OnImage_Light = null;
    public static final e[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final e OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final e OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final e OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final e OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final e[] OUI_Bg_Popup_Overlay_Light = null;
    public static final e OUI_Text_Primary_Dark = null;
    public static final e OUI_Text_Primary_Light = null;
    public static final e OUI_Text_Secondary_Dark = null;
    public static final e OUI_Text_Secondary_Light = null;
    public static final e OUI_Text_Tertiary_Dark = null;
    public static final e OUI_Text_Tertiary_Light = null;
    public static final String TOKEN_BG_FLOATING = "oui_bg_floating";
    public static final String TOKEN_BG_FLOATING_BLUE = "oui_bg_floating_blue";
    public static final String TOKEN_BG_FLOATING_FILL = "oui_bg_floating_fill";
    public static final String TOKEN_BG_FLOATING_ON_IMAGE = "oui_bg_floating_onimage";
    public static final String TOKEN_BG_FLOATING_OVERLAY = "oui_bg_floating_overlay";
    public static final String TOKEN_BG_FLOATING_TINTED = "oui_bg_floating_tinted";
    public static final String TOKEN_BG_MODAL = "oui_bg_modal";
    public static final String TOKEN_BG_POPUP = "oui_bg_popup";
    public static final String TOKEN_BG_POPUP_ON_IMAGE = "oui_bg_popup_onimage";
    public static final String TOKEN_BG_POPUP_OVERLAY = "oui_bg_popup_overlay";
    public static final String TOKEN_TEXT_PRIMARY = "oui_text_primary";
    public static final String TOKEN_TEXT_SECONDARY = "oui_text_secondary";
    public static final String TOKEN_TEXT_TERTIARY = "oui_text_tertiary";
    private static volatile ConcurrentHashMap<String, e[]> tokenSets;
    private static volatile ConcurrentHashMap<String, e> tokens;

    static {
        ColorStateList r100 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r110 = BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light;
        com.obric.oui.color.b r210 = BlendTokenCore.OUI_Color_State_Press_Light;
        com.obric.oui.color.b r211 = com.obric.oui.color.b.f399490c;
        kma.b r101 = kma.b.d(r110, r110, r210, r211, r211, r211);
        j0 r111 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Float r310 = Float.valueOf(8.0f);
        com.obric.oui.shadow.b[] r311 = ShadowTokenCore.Oui_Shadow_Regular;
        e r112 = new e(r100, r101, null, null, r111, null, null, r310, r311, null);
        OUI_Bg_Floating_Frost_Light = r112;
        ColorStateList r212 = ColorStateList.valueOf(-13421773);
        com.obric.oui.color.b[] r410 = BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark;
        com.obric.oui.color.b r102 = BlendTokenCore.OUI_Color_State_Press_Dark;
        kma.b r213 = kma.b.d(r410, r410, r102, r211, r211, r211);
        j0 r411 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark;
        e r103 = new e(r212, r213, null, null, r411, null, null, r310, r311, null);
        OUI_Bg_Floating_Frost_Dark = r103;
        ColorStateList r214 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r113 = BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light;
        kma.b r215 = kma.b.d(r113, r113, r210, r211, r211, r211);
        float r510 = BlurTokenCore.Blur_UltraThin;
        Float r312 = Float.valueOf(r510);
        com.obric.oui.fluid.b r511 = FluidTokenCore.OUI_Effect_Fluid_Regular_Light;
        e r104 = new e(r214, r215, null, null, null, null, null, r312, r311, r511);
        OUI_Bg_Floating_Fluid_Light = r104;
        ColorStateList r216 = ColorStateList.valueOf(-13421773);
        com.obric.oui.color.b[] r512 = BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark;
        kma.b r217 = kma.b.d(r512, r512, r102, r211, r211, r211);
        Float r313 = Float.valueOf(r510);
        com.obric.oui.fluid.b r513 = FluidTokenCore.OUI_Effect_Fluid_Regular_Dark;
        e r114 = new e(r216, r217, null, null, null, null, null, r313, r311, r513);
        OUI_Bg_Floating_Fluid_Dark = r114;
        OUI_Bg_Floating_Light = new e[]{r112, r104};
        OUI_Bg_Floating_Dark = new e[]{r103, r114};
        ColorStateList r218 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r105 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        j0 r106 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r610 = Float.valueOf(20.0f);
        com.obric.oui.shadow.b[] r611 = ShadowTokenCore.Oui_Shadow_Thick;
        e r107 = new e(r218, null, r105, null, r106, null, null, r610, r611, null);
        OUI_Bg_Floating_OnImage_Frost_Light = r107;
        ColorStateList r412 = ColorStateList.valueOf(-13421773);
        com.obric.oui.color.b[] r108 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark;
        j0 r612 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark;
        e r109 = new e(r412, null, r108, null, r612, null, null, r610, r611, null);
        OUI_Bg_Floating_OnImage_Frost_Dark = r109;
        ColorStateList r219 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r115 = BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light;
        e r116 = new e(r219, null, r115, null, null, null, null, r310, r611, r511);
        OUI_Bg_Floating_OnImage_Fluid_Light = r116;
        ColorStateList r220 = ColorStateList.valueOf(-13421773);
        com.obric.oui.color.b[] r613 = BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark;
        e r117 = new e(r220, null, r613, null, null, null, null, r310, r611, r513);
        OUI_Bg_Floating_OnImage_Fluid_Dark = r117;
        OUI_Bg_Floating_OnImage_Light = new e[]{r107, r116};
        OUI_Bg_Floating_OnImage_Dark = new e[]{r109, r117};
        ColorStateList r221 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r118 = BlendTokenCore.OUI_Color_Fills_Thick_Light;
        e r119 = new e(r221, null, r118, null, null, null, null, r310, null, null);
        OUI_Bg_Floating_Fill_Frost_Light = r119;
        ColorStateList r222 = ColorStateList.valueOf(-13421773);
        com.obric.oui.color.b[] r120 = BlendTokenCore.OUI_Color_Fills_Thick_Dark;
        e r121 = new e(r222, null, r120, null, null, null, null, r310, null, null);
        OUI_Bg_Floating_Fill_Frost_Dark = r121;
        OUI_Bg_Floating_Fill_Fluid_Light = new e(ColorStateList.valueOf(-1), null, r118, null, null, null, null, r310, null, r511);
        OUI_Bg_Floating_Fill_Fluid_Dark = new e(ColorStateList.valueOf(-13421773), null, r120, null, null, null, null, r310, null, r513);
        OUI_Bg_Floating_Fill_Light = new e[]{r119};
        OUI_Bg_Floating_Fill_Dark = new e[]{r121};
        e r122 = new e(ColorStateList.valueOf(-1), null, r110, null, r111, null, null, r610, r611, null);
        OUI_Bg_Popup_Frost_Light = r122;
        e r123 = new e(ColorStateList.valueOf(-13421773), null, r410, null, r411, null, null, r610, r611, null);
        OUI_Bg_Popup_Frost_Dark = r123;
        e r124 = new e(ColorStateList.valueOf(-1), null, r113, null, null, null, null, r610, r611, r511);
        OUI_Bg_Popup_Fluid_Light = r124;
        e r125 = new e(ColorStateList.valueOf(-13421773), null, r512, null, null, null, null, r610, r611, r513);
        OUI_Bg_Popup_Fluid_Dark = r125;
        OUI_Bg_Popup_Light = new e[]{r122, r124};
        OUI_Bg_Popup_Dark = new e[]{r123, r125};
        ColorStateList r413 = ColorStateList.valueOf(-1);
        Float r126 = Float.valueOf(32.0f);
        com.obric.oui.shadow.b[] r127 = ShadowTokenCore.Oui_Shadow_UltraThick;
        e r128 = new e(r413, null, r105, null, r106, null, null, r126, r127, null);
        OUI_Bg_Popup_OnImage_Frost_Light = r128;
        e r129 = new e(ColorStateList.valueOf(-13421773), null, r108, null, r612, null, null, r126, r127, null);
        OUI_Bg_Popup_OnImage_Frost_Dark = r129;
        e r130 = new e(ColorStateList.valueOf(-1), null, r115, null, null, null, null, r610, r127, r511);
        OUI_Bg_Popup_OnImage_Fluid_Light = r130;
        e r131 = new e(ColorStateList.valueOf(-13421773), null, r613, null, null, null, null, r610, r127, r513);
        OUI_Bg_Popup_OnImage_Fluid_Dark = r131;
        OUI_Bg_Popup_OnImage_Light = new e[]{r128, r130};
        OUI_Bg_Popup_OnImage_Dark = new e[]{r129, r131};
        e r132 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Light, null, null, r126, null, null);
        OUI_Bg_Modal_Frost_Light = r132;
        e r133 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark, null, null, r126, null, null);
        OUI_Bg_Modal_Frost_Dark = r133;
        e r134 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Light, null, null, null, null, r126, null, r511);
        OUI_Bg_Modal_Fluid_Light = r134;
        e r135 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Dark, null, null, null, null, r126, null, r513);
        OUI_Bg_Modal_Fluid_Dark = r135;
        OUI_Bg_Modal_Light = new e[]{r132, r134};
        OUI_Bg_Modal_Dark = new e[]{r133, r135};
        com.obric.oui.color.b[] r136 = BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light;
        e r137 = new e(null, kma.b.d(r136, r136, r210, r211, r211, r211), null, null, r106, null, null, Float.valueOf(r510), null, null);
        OUI_Bg_Floating_Overlay_Frost_Light = r137;
        com.obric.oui.color.b[] r138 = BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark;
        e r139 = new e(null, kma.b.d(r138, r138, r102, r211, r211, r211), null, null, r612, null, null, Float.valueOf(r510), null, null);
        OUI_Bg_Floating_Overlay_Frost_Dark = r139;
        com.obric.oui.color.b[] r140 = BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light;
        e r141 = new e(null, kma.b.d(r140, r140, r210, r211, r211, r211), null, null, null, null, null, Float.valueOf(r510), null, r511);
        OUI_Bg_Floating_Overlay_Fluid_Light = r141;
        com.obric.oui.color.b[] r142 = BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark;
        e r143 = new e(null, kma.b.d(r142, r142, r102, r211, r211, r211), null, null, null, null, null, Float.valueOf(r510), null, r513);
        OUI_Bg_Floating_Overlay_Fluid_Dark = r143;
        e[] r144 = {r137, r141};
        OUI_Bg_Floating_Overlay_Light = r144;
        e[] r145 = {r139, r143};
        OUI_Bg_Floating_Overlay_Dark = r145;
        OUI_Bg_Overlay_Search_Frost_Light = r137;
        OUI_Bg_Overlay_Search_Frost_Dark = r139;
        OUI_Bg_Overlay_Search_Fluid_Light = r141;
        OUI_Bg_Overlay_Search_Fluid_Dark = r143;
        OUI_Bg_Overlay_Search_Light = r144;
        OUI_Bg_Overlay_Search_Dark = r145;
        e r146 = new e(null, kma.b.c(r138, r138, r102), null, null, r612, null, null, r610, r611, null);
        OUI_Bg_Popup_Overlay_Frost_Light = r146;
        e r147 = new e(null, kma.b.c(r138, r138, r102), null, null, r612, null, null, r610, r611, null);
        OUI_Bg_Popup_Overlay_Frost_Dark = r147;
        e r148 = new e(null, kma.b.c(r142, r142, r102), null, null, null, null, null, r610, r611, r511);
        OUI_Bg_Popup_Overlay_Fluid_Light = r148;
        e r149 = new e(null, kma.b.c(r142, r142, r102), null, null, null, null, null, r610, r611, r511);
        OUI_Bg_Popup_Overlay_Fluid_Dark = r149;
        OUI_Bg_Popup_Overlay_Light = new e[]{r146, r148};
        OUI_Bg_Popup_Overlay_Dark = new e[]{r147, r149};
        ColorStateList r223 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r150 = BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light;
        e r151 = new e(r223, null, r150, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light, null, null, r310, r311, null);
        OUI_Bg_Floating_Frost_Tinted_Light = r151;
        ColorStateList r224 = ColorStateList.valueOf(-16777216);
        com.obric.oui.color.b[] r152 = BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark;
        e r153 = new e(r224, null, r152, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark, null, null, r310, r311, null);
        OUI_Bg_Floating_Frost_Tinted_Dark = r153;
        e r154 = new e(ColorStateList.valueOf(-1), null, r150, null, null, null, null, Float.valueOf(r510), r311, r513);
        OUI_Bg_Floating_Fluid_Tinted_Light = r154;
        e r155 = new e(ColorStateList.valueOf(-16777216), null, r152, null, null, null, null, Float.valueOf(r510), r311, r513);
        OUI_Bg_Floating_Fluid_Tinted_Dark = r155;
        OUI_Bg_Floating_Tinted_Light = new e[]{r151, r154};
        OUI_Bg_Floating_Tinted_Dark = new e[]{r153, r155};
        ColorStateList r225 = ColorStateList.valueOf(-15895809);
        com.obric.oui.color.b[] r156 = BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light;
        e r157 = new e(r225, null, r156, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light, null, null, r310, r311, null);
        OUI_Bg_Floating_Frost_Blue_Light = r157;
        ColorStateList r226 = ColorStateList.valueOf(-16087553);
        com.obric.oui.color.b[] r158 = BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark;
        e r159 = new e(r226, null, r158, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark, null, null, r310, r311, null);
        OUI_Bg_Floating_Frost_Blue_Dark = r159;
        e r160 = new e(ColorStateList.valueOf(-15895809), null, r156, null, null, null, null, Float.valueOf(r510), r311, r513);
        OUI_Bg_Floating_Fluid_Blue_Light = r160;
        e r161 = new e(ColorStateList.valueOf(-16087553), null, r158, null, null, null, null, Float.valueOf(r510), r311, r513);
        OUI_Bg_Floating_Fluid_Blue_Dark = r161;
        OUI_Bg_Floating_Blue_Light = new e[]{r157, r160};
        OUI_Bg_Floating_Blue_Dark = new e[]{r159, r161};
        OUI_Text_Primary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Light, null, null, null, null, null, null, null);
        OUI_Text_Primary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Light, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Light, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Dark, null, null, null, null, null, null, null);
    }

    private MaterialTokenCore() {
    }

    private static ConcurrentHashMap<String, e[]> getTokenSets(Object r100) {
        ConcurrentHashMap<String, e[]> r101 = tokenSets;
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r101 = tokenSets;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = s.a(MaterialTokenCore.class, e[].class);     // Catch: Throwable -> L11
        tokenSets = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, e> getTokens(Object r100) {
        ConcurrentHashMap<String, e> r101 = tokens;
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r101 = tokens;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = s.a(MaterialTokenCore.class, e.class);     // Catch: Throwable -> L11
        tokens = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static e parse(Object r100, String r101, boolean r102) {
        e r103 = (e) s.c(r101, getTokens(r100));
        if (r103 != null) goto L10;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        if (r102 == false) goto L7;
        String r105 = "_light";
    L8:
        r104.append(r105);
        return (e) s.c(r104.toString(), getTokens(r100));
    L7:
        r105 = "_dark";
        goto L8
    L10:
        return r103;
    }

    public static e[] parseSet(Object r100, String r101, boolean r102) {
        e[] r103 = (e[]) s.c(r101, getTokenSets(r100));
        if (r103 != null) goto L9;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        if (r102 == false) goto L7;
        String r105 = "_light";
    L8:
        r104.append(r105);
        r103 = (e[]) s.c(r104.toString(), getTokenSets(r100));
        goto L9
    L7:
        r105 = "_dark";
    L9:
        if (r103 != null) goto L14;
        e r106 = parse(r100, r101, r102);
        if (r106 != null) goto L13;
        return r103;
    L13:
        return new e[]{r106};
    L14:
        return r103;
    }

    public static void register(Object r100, Object r101, boolean r102) {
        s.d(getTokens(r100), r101, e.class, r102);
    }

    public static void registerSet(Object r100, Object r101, boolean r102) {
        s.d(getTokenSets(r100), r101, e[].class, r102);
    }

    public static void registerTokenSets(Object r100, Map<String, e[]> r101, boolean r102) {
        s.e(getTokenSets(r100), r101, r102);
    }

    public static void registerTokens(Object r100, Map<String, e> r101, boolean r102) {
        s.e(getTokens(r100), r101, r102);
    }
}
