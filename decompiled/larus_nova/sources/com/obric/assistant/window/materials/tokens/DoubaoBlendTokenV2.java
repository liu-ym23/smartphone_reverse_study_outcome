package com.obric.assistant.window.materials.tokens;

import android.content.res.ColorStateList;
import cia.e;
import cia.f;
import cia.g;
import cia.h;
import cia.i;
import cia.j;
import com.obric.oui.color.a;
import com.obric.oui.graphic.BlendMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\tR.\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\tR.\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\tR$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\tR.\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\u0013R$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\tR$\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010\tR.\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010\u0013R$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010\tR$\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010\tR.\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010\u0013R$\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010\tR$\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010\tR.\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\u0003\u001a\u0004\b@\u0010\u0013R\u0010\u0010A\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0018\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006J"}, d2 = {"Lcom/obric/assistant/window/materials/tokens/DoubaoBlendTokenV2;", "", "<init>", "()V", "DoubaoV2_Color_Blend_Fluid_Regular_Light", "", "Lcom/obric/oui/color/BlendConfig;", "getDoubaoV2_Color_Blend_Fluid_Regular_Light$annotations", "getDoubaoV2_Color_Blend_Fluid_Regular_Light", "()[Lcom/obric/oui/color/BlendConfig;", "[Lcom/obric/oui/color/BlendConfig;", "DoubaoV2_Color_Blend_Fluid_Regular_Dark", "getDoubaoV2_Color_Blend_Fluid_Regular_Dark$annotations", "getDoubaoV2_Color_Blend_Fluid_Regular_Dark", "DoubaoV2_Color_Blend_Regular", "Lkotlin/Function1;", "", "getDoubaoV2_Color_Blend_Regular$annotations", "getDoubaoV2_Color_Blend_Regular", "()Lkotlin/jvm/functions/Function1;", "DoubaoV2_Color_Blend_Frost_Regular_Light", "getDoubaoV2_Color_Blend_Frost_Regular_Light$annotations", "getDoubaoV2_Color_Blend_Frost_Regular_Light", "DoubaoV2_Color_Blend_Frost_Regular_Dark", "getDoubaoV2_Color_Blend_Frost_Regular_Dark$annotations", "getDoubaoV2_Color_Blend_Frost_Regular_Dark", "DoubaoV2_Color_Blend_Frost_Regular", "getDoubaoV2_Color_Blend_Frost_Regular$annotations", "getDoubaoV2_Color_Blend_Frost_Regular", "DoubaoV2_Color_Blend_Fluid_Thin_Blue_Light", "getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Light$annotations", "getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Light", "DoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark", "getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark$annotations", "getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark", "DoubaoV2_Color_Blend_Thin_Blue", "getDoubaoV2_Color_Blend_Thin_Blue$annotations", "getDoubaoV2_Color_Blend_Thin_Blue", "DoubaoV2_Color_Blend_Frost_Thin_Blue_Light", "getDoubaoV2_Color_Blend_Frost_Thin_Blue_Light$annotations", "getDoubaoV2_Color_Blend_Frost_Thin_Blue_Light", "DoubaoV2_Color_Blend_Frost_Thin_Blue_Dark", "getDoubaoV2_Color_Blend_Frost_Thin_Blue_Dark$annotations", "getDoubaoV2_Color_Blend_Frost_Thin_Blue_Dark", "DoubaoV2_Color_Blend_Frost_Thin_Blue", "getDoubaoV2_Color_Blend_Frost_Thin_Blue$annotations", "getDoubaoV2_Color_Blend_Frost_Thin_Blue", "DoubaoV2_Color_Blend_Fluid_Thin_Light", "getDoubaoV2_Color_Blend_Fluid_Thin_Light$annotations", "getDoubaoV2_Color_Blend_Fluid_Thin_Light", "DoubaoV2_Color_Blend_Fluid_Thin_Dark", "getDoubaoV2_Color_Blend_Fluid_Thin_Dark$annotations", "getDoubaoV2_Color_Blend_Fluid_Thin_Dark", "DoubaoV2_Color_Blend_Fluid_Thin", "getDoubaoV2_Color_Blend_Fluid_Thin$annotations", "getDoubaoV2_Color_Blend_Fluid_Thin", "DoubaoV2_Color_Blend_Frost_Thin_Light", "getDoubaoV2_Color_Blend_Frost_Thin_Light$annotations", "getDoubaoV2_Color_Blend_Frost_Thin_Light", "DoubaoV2_Color_Blend_Frost_Thin_Dark", "getDoubaoV2_Color_Blend_Frost_Thin_Dark$annotations", "getDoubaoV2_Color_Blend_Frost_Thin_Dark", "DoubaoV2_Color_Blend_Frost_Thin", "getDoubaoV2_Color_Blend_Frost_Thin$annotations", "getDoubaoV2_Color_Blend_Frost_Thin", "DoubaoV2_Color_Blend_Fallback_Regular_Light", "Landroid/content/res/ColorStateList;", "DoubaoV2_Color_Blend_Fallback_Regular_Dark", "DoubaoV2_Color_Blend_Fallback_Thin_Light", "DoubaoV2_Color_Blend_Fallback_Thin_Dark", "DoubaoV2_Color_Blend_Frost_Thick_Light", "DoubaoV2_Color_Blend_Frost_Thick_Dark", "DoubaoV2_Color_Blend_Fluid_Thick_Light", "DoubaoV2_Color_Blend_Fluid_Thick_Dark", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoBlendTokenV2 {
    public static final ColorStateList DoubaoV2_Color_Blend_Fallback_Regular_Dark = null;
    public static final ColorStateList DoubaoV2_Color_Blend_Fallback_Regular_Light = null;
    public static final ColorStateList DoubaoV2_Color_Blend_Fallback_Thin_Dark = null;
    public static final ColorStateList DoubaoV2_Color_Blend_Fallback_Thin_Light = null;
    private static final a[] DoubaoV2_Color_Blend_Fluid_Regular_Dark = null;
    private static final a[] DoubaoV2_Color_Blend_Fluid_Regular_Light = null;
    public static final a[] DoubaoV2_Color_Blend_Fluid_Thick_Dark = null;
    public static final a[] DoubaoV2_Color_Blend_Fluid_Thick_Light = null;
    private static final Function1<Boolean, a[]> DoubaoV2_Color_Blend_Fluid_Thin = null;
    private static final a[] DoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark = null;
    private static final a[] DoubaoV2_Color_Blend_Fluid_Thin_Blue_Light = null;
    private static final a[] DoubaoV2_Color_Blend_Fluid_Thin_Dark = null;
    private static final a[] DoubaoV2_Color_Blend_Fluid_Thin_Light = null;
    private static final Function1<Boolean, a[]> DoubaoV2_Color_Blend_Frost_Regular = null;
    private static final a[] DoubaoV2_Color_Blend_Frost_Regular_Dark = null;
    private static final a[] DoubaoV2_Color_Blend_Frost_Regular_Light = null;
    public static final a[] DoubaoV2_Color_Blend_Frost_Thick_Dark = null;
    public static final a[] DoubaoV2_Color_Blend_Frost_Thick_Light = null;
    private static final Function1<Boolean, a[]> DoubaoV2_Color_Blend_Frost_Thin = null;
    private static final Function1<Boolean, a[]> DoubaoV2_Color_Blend_Frost_Thin_Blue = null;
    private static final a[] DoubaoV2_Color_Blend_Frost_Thin_Blue_Dark = null;
    private static final a[] DoubaoV2_Color_Blend_Frost_Thin_Blue_Light = null;
    private static final a[] DoubaoV2_Color_Blend_Frost_Thin_Dark = null;
    private static final a[] DoubaoV2_Color_Blend_Frost_Thin_Light = null;
    private static final Function1<Boolean, a[]> DoubaoV2_Color_Blend_Regular = null;
    private static final Function1<Boolean, a[]> DoubaoV2_Color_Blend_Thin_Blue = null;
    public static final DoubaoBlendTokenV2 INSTANCE = null;

    private DoubaoBlendTokenV2() {
    }

    public static /* synthetic */ a[] a(boolean r100) {
        return DoubaoV2_Color_Blend_Frost_Thin_Blue$lambda$3(r100);
    }

    public static /* synthetic */ a[] b(boolean r100) {
        return DoubaoV2_Color_Blend_Frost_Thin$lambda$5(r100);
    }

    public static /* synthetic */ a[] c(boolean r100) {
        return DoubaoV2_Color_Blend_Fluid_Thin$lambda$4(r100);
    }

    public static /* synthetic */ a[] d(boolean r100) {
        return DoubaoV2_Color_Blend_Frost_Regular$lambda$1(r100);
    }

    public static /* synthetic */ a[] e(boolean r100) {
        return DoubaoV2_Color_Blend_Thin_Blue$lambda$2(r100);
    }

    public static /* synthetic */ a[] f(boolean r100) {
        return DoubaoV2_Color_Blend_Regular$lambda$0(r100);
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Regular_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Regular_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Thin_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Fluid_Thin_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Regular_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Regular_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Thin_Blue$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Thin_Blue_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Thin_Blue_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Thin_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Frost_Thin_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Color_Blend_Thin_Blue$annotations() {
    }

    static {
        INSTANCE = new DoubaoBlendTokenV2();
        BlendMode r100 = BlendMode.LUMINOSITY;
        BlendMode r101 = BlendMode.COLOR_DODGE;
        BlendMode r102 = BlendMode.SRC_OVER;
        DoubaoV2_Color_Blend_Fluid_Regular_Light = new a[]{new a(-1716342094, r100), new a(-13421773, r101), new a(1726737387, r102)};
        BlendMode r110 = BlendMode.COLOR_BURN;
        DoubaoV2_Color_Blend_Fluid_Regular_Dark = new a[]{new a(1291845632, r102), new a(-1718052712, r100), new a(-1716210508, r110), new a(335544320, r102)};
        DoubaoV2_Color_Blend_Regular = new e();
        DoubaoV2_Color_Blend_Frost_Regular_Light = new a[]{new a(-1716342094, r100), new a(-13421773, r101), new a(1726737387, r102)};
        DoubaoV2_Color_Blend_Frost_Regular_Dark = new a[]{new a(1291845632, r102), new a(-1718052712, r100), new a(-1716210508, r110), new a(335544320, r102)};
        DoubaoV2_Color_Blend_Frost_Regular = new f();
        DoubaoV2_Color_Blend_Fluid_Thin_Blue_Light = new a[]{new a(-1716342094, r100), new a(-13421773, r101), new a(1728053247, r102), new a(520975103, r102)};
        DoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark = new a[]{new a(1291845632, r102), new a(1719697536, r100), new a(1719697536, r110), new a(1299300351, r102)};
        DoubaoV2_Color_Blend_Thin_Blue = new g();
        DoubaoV2_Color_Blend_Frost_Thin_Blue_Light = new a[]{new a(-1716342094, r100), new a(-13421773, r101), new a(1728053247, r102), new a(520975103, r102)};
        DoubaoV2_Color_Blend_Frost_Thin_Blue_Dark = new a[]{new a(1291845632, r102), new a(1719697536, r100), new a(1719697536, r110), new a(1299300351, r102)};
        DoubaoV2_Color_Blend_Frost_Thin_Blue = new h();
        DoubaoV2_Color_Blend_Fluid_Thin_Light = new a[]{new a(1722987186, r100), new a(-1724697805, r101), new a(1726737387, r102)};
        DoubaoV2_Color_Blend_Fluid_Thin_Dark = new a[]{new a(1291845632, r102), new a(-1718052712, r100), new a(-2135640908, r110)};
        DoubaoV2_Color_Blend_Fluid_Thin = new i();
        DoubaoV2_Color_Blend_Frost_Thin_Light = new a[]{new a(1722987186, r100), new a(-1724697805, r101), new a(1727395317, r102)};
        DoubaoV2_Color_Blend_Frost_Thin_Dark = new a[]{new a(1291845632, r102), new a(-1718052712, r100), new a(-2135640908, r110)};
        DoubaoV2_Color_Blend_Frost_Thin = new j();
        DoubaoV2_Color_Blend_Fallback_Regular_Light = ColorStateList.valueOf(-16777216);
        DoubaoV2_Color_Blend_Fallback_Regular_Dark = ColorStateList.valueOf(-1722987187);
        DoubaoV2_Color_Blend_Fallback_Thin_Light = ColorStateList.valueOf(-1291845632);
        DoubaoV2_Color_Blend_Fallback_Thin_Dark = ColorStateList.valueOf(1296911693);
        DoubaoV2_Color_Blend_Frost_Thick_Light = new a[]{new a(1375731712, r102), new a(-1726013665, r101), new a(-604506121, r102)};
        DoubaoV2_Color_Blend_Frost_Thick_Dark = new a[]{new a(-1728053248, r102), new a(1305267404, r100), new a(-1717986919, r110), new a(858138150, r102)};
        DoubaoV2_Color_Blend_Fluid_Thick_Light = new a[]{new a(1375731712, r102), new a(-1726013665, r101), new a(-604506121, r102)};
        DoubaoV2_Color_Blend_Fluid_Thick_Dark = new a[]{new a(-1728053248, r102), new a(1305267404, r100), new a(-1717986919, r110), new a(858138150, r102)};
    }

    public static final a[] getDoubaoV2_Color_Blend_Fluid_Regular_Dark() {
        return DoubaoV2_Color_Blend_Fluid_Regular_Dark;
    }

    public static final a[] getDoubaoV2_Color_Blend_Fluid_Regular_Light() {
        return DoubaoV2_Color_Blend_Fluid_Regular_Light;
    }

    public static final Function1<Boolean, a[]> getDoubaoV2_Color_Blend_Fluid_Thin() {
        return DoubaoV2_Color_Blend_Fluid_Thin;
    }

    public static final a[] getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark() {
        return DoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark;
    }

    public static final a[] getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Light() {
        return DoubaoV2_Color_Blend_Fluid_Thin_Blue_Light;
    }

    public static final a[] getDoubaoV2_Color_Blend_Fluid_Thin_Dark() {
        return DoubaoV2_Color_Blend_Fluid_Thin_Dark;
    }

    public static final a[] getDoubaoV2_Color_Blend_Fluid_Thin_Light() {
        return DoubaoV2_Color_Blend_Fluid_Thin_Light;
    }

    public static final Function1<Boolean, a[]> getDoubaoV2_Color_Blend_Frost_Regular() {
        return DoubaoV2_Color_Blend_Frost_Regular;
    }

    public static final a[] getDoubaoV2_Color_Blend_Frost_Regular_Dark() {
        return DoubaoV2_Color_Blend_Frost_Regular_Dark;
    }

    public static final a[] getDoubaoV2_Color_Blend_Frost_Regular_Light() {
        return DoubaoV2_Color_Blend_Frost_Regular_Light;
    }

    public static final Function1<Boolean, a[]> getDoubaoV2_Color_Blend_Frost_Thin() {
        return DoubaoV2_Color_Blend_Frost_Thin;
    }

    public static final Function1<Boolean, a[]> getDoubaoV2_Color_Blend_Frost_Thin_Blue() {
        return DoubaoV2_Color_Blend_Frost_Thin_Blue;
    }

    public static final a[] getDoubaoV2_Color_Blend_Frost_Thin_Blue_Dark() {
        return DoubaoV2_Color_Blend_Frost_Thin_Blue_Dark;
    }

    public static final a[] getDoubaoV2_Color_Blend_Frost_Thin_Blue_Light() {
        return DoubaoV2_Color_Blend_Frost_Thin_Blue_Light;
    }

    public static final a[] getDoubaoV2_Color_Blend_Frost_Thin_Dark() {
        return DoubaoV2_Color_Blend_Frost_Thin_Dark;
    }

    public static final a[] getDoubaoV2_Color_Blend_Frost_Thin_Light() {
        return DoubaoV2_Color_Blend_Frost_Thin_Light;
    }

    public static final Function1<Boolean, a[]> getDoubaoV2_Color_Blend_Regular() {
        return DoubaoV2_Color_Blend_Regular;
    }

    public static final Function1<Boolean, a[]> getDoubaoV2_Color_Blend_Thin_Blue() {
        return DoubaoV2_Color_Blend_Thin_Blue;
    }

    private static final a[] DoubaoV2_Color_Blend_Fluid_Thin$lambda$4(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return DoubaoV2_Color_Blend_Fluid_Thin_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Color_Blend_Fluid_Thin_Light;
    }

    private static final a[] DoubaoV2_Color_Blend_Frost_Regular$lambda$1(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return DoubaoV2_Color_Blend_Frost_Regular_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Color_Blend_Frost_Regular_Light;
    }

    private static final a[] DoubaoV2_Color_Blend_Frost_Thin$lambda$5(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return DoubaoV2_Color_Blend_Frost_Thin_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Color_Blend_Frost_Thin_Light;
    }

    private static final a[] DoubaoV2_Color_Blend_Frost_Thin_Blue$lambda$3(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return DoubaoV2_Color_Blend_Frost_Thin_Blue_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Color_Blend_Frost_Thin_Blue_Light;
    }

    private static final a[] DoubaoV2_Color_Blend_Regular$lambda$0(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return DoubaoV2_Color_Blend_Fluid_Regular_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Color_Blend_Fluid_Regular_Light;
    }

    private static final a[] DoubaoV2_Color_Blend_Thin_Blue$lambda$2(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return DoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Color_Blend_Fluid_Thin_Blue_Light;
    }
}
