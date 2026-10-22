package com.obric.assistant.window.materials.tokens;

import android.content.res.ColorStateList;
import cia.b;
import cia.c;
import cia.d;
import com.obric.oui.color.a;
import com.obric.oui.graphic.BlendMode;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\tR.\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\tR.\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\tR$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\tR.\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\u0013R$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\tR$\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010\tR.\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010\u0013R\u0010\u0010/\u001a\u0002008\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0002008\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0002008\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0002008\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0018\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0018\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u00068"}, d2 = {"Lcom/obric/assistant/window/materials/tokens/DoubaoBlendToken;", "", "<init>", "()V", "Doubao_Color_Blend_Fluid_Regular_Light", "", "Lcom/obric/oui/color/BlendConfig;", "getDoubao_Color_Blend_Fluid_Regular_Light$annotations", "getDoubao_Color_Blend_Fluid_Regular_Light", "()[Lcom/obric/oui/color/BlendConfig;", "[Lcom/obric/oui/color/BlendConfig;", "Doubao_Color_Blend_Fluid_Regular_Dark", "getDoubao_Color_Blend_Fluid_Regular_Dark$annotations", "getDoubao_Color_Blend_Fluid_Regular_Dark", "Doubao_Color_Blend_Regular", "Lkotlin/Function1;", "", "getDoubao_Color_Blend_Regular$annotations", "getDoubao_Color_Blend_Regular", "()Lkotlin/jvm/functions/Function1;", "Doubao_Color_Blend_Frost_Regular_Light", "getDoubao_Color_Blend_Frost_Regular_Light$annotations", "getDoubao_Color_Blend_Frost_Regular_Light", "Doubao_Color_Blend_Frost_Regular_Dark", "getDoubao_Color_Blend_Frost_Regular_Dark$annotations", "getDoubao_Color_Blend_Frost_Regular_Dark", "Doubao_Color_Blend_Frost_Regular", "getDoubao_Color_Blend_Frost_Regular$annotations", "getDoubao_Color_Blend_Frost_Regular", "Doubao_Color_Blend_Fluid_Thin_Light", "getDoubao_Color_Blend_Fluid_Thin_Light$annotations", "getDoubao_Color_Blend_Fluid_Thin_Light", "Doubao_Color_Blend_Fluid_Thin_Dark", "getDoubao_Color_Blend_Fluid_Thin_Dark$annotations", "getDoubao_Color_Blend_Fluid_Thin_Dark", "Doubao_Color_Blend_Fluid_Thin", "getDoubao_Color_Blend_Fluid_Thin$annotations", "getDoubao_Color_Blend_Fluid_Thin", "Doubao_Color_Blend_Frost_Thin_Light", "getDoubao_Color_Blend_Frost_Thin_Light$annotations", "getDoubao_Color_Blend_Frost_Thin_Light", "Doubao_Color_Blend_Frost_Thin_Dark", "getDoubao_Color_Blend_Frost_Thin_Dark$annotations", "getDoubao_Color_Blend_Frost_Thin_Dark", "Doubao_Color_Blend_Frost_Thin", "getDoubao_Color_Blend_Frost_Thin$annotations", "getDoubao_Color_Blend_Frost_Thin", "Doubao_Color_Blend_Fallback_Regular_Light", "Landroid/content/res/ColorStateList;", "Doubao_Color_Blend_Fallback_Regular_Dark", "Doubao_Color_Blend_Fallback_Thin_Light", "Doubao_Color_Blend_Fallback_Thin_Dark", "Doubao_Color_Blend_Frost_Thick_Light", "Doubao_Color_Blend_Frost_Thick_Dark", "Doubao_Color_Blend_Fluid_Thick_Light", "Doubao_Color_Blend_Fluid_Thick_Dark", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoBlendToken {
    public static final ColorStateList Doubao_Color_Blend_Fallback_Regular_Dark = null;
    public static final ColorStateList Doubao_Color_Blend_Fallback_Regular_Light = null;
    public static final ColorStateList Doubao_Color_Blend_Fallback_Thin_Dark = null;
    public static final ColorStateList Doubao_Color_Blend_Fallback_Thin_Light = null;
    private static final a[] Doubao_Color_Blend_Fluid_Regular_Dark = null;
    private static final a[] Doubao_Color_Blend_Fluid_Regular_Light = null;
    public static final a[] Doubao_Color_Blend_Fluid_Thick_Dark = null;
    public static final a[] Doubao_Color_Blend_Fluid_Thick_Light = null;
    private static final Function1<Boolean, a[]> Doubao_Color_Blend_Fluid_Thin = null;
    private static final a[] Doubao_Color_Blend_Fluid_Thin_Dark = null;
    private static final a[] Doubao_Color_Blend_Fluid_Thin_Light = null;
    private static final Function1<Boolean, a[]> Doubao_Color_Blend_Frost_Regular = null;
    private static final a[] Doubao_Color_Blend_Frost_Regular_Dark = null;
    private static final a[] Doubao_Color_Blend_Frost_Regular_Light = null;
    public static final a[] Doubao_Color_Blend_Frost_Thick_Dark = null;
    public static final a[] Doubao_Color_Blend_Frost_Thick_Light = null;
    private static final Function1<Boolean, a[]> Doubao_Color_Blend_Frost_Thin = null;
    private static final a[] Doubao_Color_Blend_Frost_Thin_Dark = null;
    private static final a[] Doubao_Color_Blend_Frost_Thin_Light = null;
    private static final Function1<Boolean, a[]> Doubao_Color_Blend_Regular = null;
    public static final DoubaoBlendToken INSTANCE = null;

    private DoubaoBlendToken() {
    }

    public static /* synthetic */ a[] a(boolean r100) {
        return Doubao_Color_Blend_Fluid_Thin$lambda$2(r100);
    }

    public static /* synthetic */ a[] b(boolean r100) {
        return Doubao_Color_Blend_Frost_Regular$lambda$1(r100);
    }

    public static /* synthetic */ a[] c(boolean r100) {
        return Doubao_Color_Blend_Regular$lambda$0(r100);
    }

    public static /* synthetic */ a[] d(boolean r100) {
        return Doubao_Color_Blend_Frost_Thin$lambda$3(r100);
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Fluid_Regular_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Fluid_Regular_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Fluid_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Fluid_Thin_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Fluid_Thin_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Frost_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Frost_Regular_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Frost_Regular_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Frost_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Frost_Thin_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Frost_Thin_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Color_Blend_Regular$annotations() {
    }

    static {
        INSTANCE = new DoubaoBlendToken();
        BlendMode r100 = BlendMode.LUMINOSITY;
        BlendMode r101 = BlendMode.COLOR_DODGE;
        BlendMode r102 = BlendMode.SRC_OVER;
        Doubao_Color_Blend_Fluid_Regular_Light = new a[]{new a(-1717000024, r100), new a(-13421773, r101), new a(-1711276033, r102)};
        BlendMode r110 = BlendMode.COLOR_BURN;
        Doubao_Color_Blend_Fluid_Regular_Dark = new a[]{new a(-863993728, r100), new a(1620679065, r110), new a(855638016, r102)};
        Doubao_Color_Blend_Regular = new cia.a();
        Doubao_Color_Blend_Frost_Regular_Light = new a[]{new a(-1717000024, r100), new a(-13421773, r101), new a(-1275068417, r102)};
        Doubao_Color_Blend_Frost_Regular_Dark = new a[]{new a(-863993728, r100), new a(1620679065, r110), new a(855638016, r102)};
        Doubao_Color_Blend_Frost_Regular = new b();
        Doubao_Color_Blend_Fluid_Thin_Light = new a[]{new a(-1717000024, r100), new a(-869059789, r101), new a(1728053247, r102)};
        Doubao_Color_Blend_Fluid_Thin_Dark = new a[]{new a(-1719631744, r100), new a(1724697804, r110), new a(520093696, r102)};
        Doubao_Color_Blend_Fluid_Thin = new c();
        Doubao_Color_Blend_Frost_Thin_Light = new a[]{new a(-1717000024, r100), new a(-869059789, r101), new a(1308622847, r102)};
        Doubao_Color_Blend_Frost_Thin_Dark = new a[]{new a(-1719631744, r100), new a(FakePickerAvatarCreator.LTGRAY, r110), new a(520093696, r102)};
        Doubao_Color_Blend_Frost_Thin = new d();
        Doubao_Color_Blend_Fallback_Regular_Light = ColorStateList.valueOf(-16777216);
        Doubao_Color_Blend_Fallback_Regular_Dark = ColorStateList.valueOf(-1722987187);
        Doubao_Color_Blend_Fallback_Thin_Light = ColorStateList.valueOf(-1291845632);
        Doubao_Color_Blend_Fallback_Thin_Dark = ColorStateList.valueOf(1296911693);
        Doubao_Color_Blend_Frost_Thick_Light = new a[]{new a(-1726013665, r101), new a(-336728595, r102)};
        Doubao_Color_Blend_Frost_Thick_Dark = new a[]{new a(13421772, r110), new a(-351005676, r102)};
        Doubao_Color_Blend_Fluid_Thick_Light = new a[]{new a(-1726013665, r101), new a(-336728595, r102)};
        Doubao_Color_Blend_Fluid_Thick_Dark = new a[]{new a(13421772, r110), new a(-433181138, r102)};
    }

    public static final a[] getDoubao_Color_Blend_Fluid_Regular_Dark() {
        return Doubao_Color_Blend_Fluid_Regular_Dark;
    }

    public static final a[] getDoubao_Color_Blend_Fluid_Regular_Light() {
        return Doubao_Color_Blend_Fluid_Regular_Light;
    }

    public static final Function1<Boolean, a[]> getDoubao_Color_Blend_Fluid_Thin() {
        return Doubao_Color_Blend_Fluid_Thin;
    }

    public static final a[] getDoubao_Color_Blend_Fluid_Thin_Dark() {
        return Doubao_Color_Blend_Fluid_Thin_Dark;
    }

    public static final a[] getDoubao_Color_Blend_Fluid_Thin_Light() {
        return Doubao_Color_Blend_Fluid_Thin_Light;
    }

    public static final Function1<Boolean, a[]> getDoubao_Color_Blend_Frost_Regular() {
        return Doubao_Color_Blend_Frost_Regular;
    }

    public static final a[] getDoubao_Color_Blend_Frost_Regular_Dark() {
        return Doubao_Color_Blend_Frost_Regular_Dark;
    }

    public static final a[] getDoubao_Color_Blend_Frost_Regular_Light() {
        return Doubao_Color_Blend_Frost_Regular_Light;
    }

    public static final Function1<Boolean, a[]> getDoubao_Color_Blend_Frost_Thin() {
        return Doubao_Color_Blend_Frost_Thin;
    }

    public static final a[] getDoubao_Color_Blend_Frost_Thin_Dark() {
        return Doubao_Color_Blend_Frost_Thin_Dark;
    }

    public static final a[] getDoubao_Color_Blend_Frost_Thin_Light() {
        return Doubao_Color_Blend_Frost_Thin_Light;
    }

    public static final Function1<Boolean, a[]> getDoubao_Color_Blend_Regular() {
        return Doubao_Color_Blend_Regular;
    }

    private static final a[] Doubao_Color_Blend_Fluid_Thin$lambda$2(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return Doubao_Color_Blend_Fluid_Thin_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Color_Blend_Fluid_Thin_Light;
    }

    private static final a[] Doubao_Color_Blend_Frost_Regular$lambda$1(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return Doubao_Color_Blend_Frost_Regular_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Color_Blend_Frost_Regular_Light;
    }

    private static final a[] Doubao_Color_Blend_Frost_Thin$lambda$3(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return Doubao_Color_Blend_Frost_Thin_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Color_Blend_Frost_Thin_Light;
    }

    private static final a[] Doubao_Color_Blend_Regular$lambda$0(boolean r100) {
        if (r100 == true) goto L10;
        if (r100 == true) goto L9;
        return Doubao_Color_Blend_Fluid_Regular_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Color_Blend_Fluid_Regular_Light;
    }
}
