package com.relax.relaxframework;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b,\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006."}, d2 = {"Lcom/relax/relaxframework/ModifierValue_AnimationProperty;", "", "", "value", "I", "getValue", "()I", "None", "Opacity", "ScaleX", "ScaleY", "ScaleXY", "Width", "Height", "BackgroundColor", "Visibility", "Left", "Top", "Right", "Bottom", "Transform", "Color", "MaxWidth", "MinWidth", "MaxHeight", "MinHeight", EffectTypeConstants.TYPE_FILTER, "PaddingLeft", "PaddingRight", "PaddingTop", "PaddingBottom", "MarginLeft", "MarginRight", "MarginTop", "MarginBottom", "BorderLeftWidth", "BorderRightWidth", "BorderTopWidth", "BorderBottomWidth", "BorderTopColor", "BorderLeftColor", "BorderRightColor", "BorderBottomColor", "FlexBasis", "FlexGrow", CancelRetainContactInfoFunctions.All, "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_AnimationProperty extends Enum<ModifierValue_AnimationProperty> {
    public static final ModifierValue_AnimationProperty All = null;
    public static final ModifierValue_AnimationProperty BackgroundColor = null;
    public static final ModifierValue_AnimationProperty BorderBottomColor = null;
    public static final ModifierValue_AnimationProperty BorderBottomWidth = null;
    public static final ModifierValue_AnimationProperty BorderLeftColor = null;
    public static final ModifierValue_AnimationProperty BorderLeftWidth = null;
    public static final ModifierValue_AnimationProperty BorderRightColor = null;
    public static final ModifierValue_AnimationProperty BorderRightWidth = null;
    public static final ModifierValue_AnimationProperty BorderTopColor = null;
    public static final ModifierValue_AnimationProperty BorderTopWidth = null;
    public static final ModifierValue_AnimationProperty Bottom = null;
    public static final ModifierValue_AnimationProperty Color = null;
    public static final ModifierValue_AnimationProperty Filter = null;
    public static final ModifierValue_AnimationProperty FlexBasis = null;
    public static final ModifierValue_AnimationProperty FlexGrow = null;
    public static final ModifierValue_AnimationProperty Height = null;
    public static final ModifierValue_AnimationProperty Left = null;
    public static final ModifierValue_AnimationProperty MarginBottom = null;
    public static final ModifierValue_AnimationProperty MarginLeft = null;
    public static final ModifierValue_AnimationProperty MarginRight = null;
    public static final ModifierValue_AnimationProperty MarginTop = null;
    public static final ModifierValue_AnimationProperty MaxHeight = null;
    public static final ModifierValue_AnimationProperty MaxWidth = null;
    public static final ModifierValue_AnimationProperty MinHeight = null;
    public static final ModifierValue_AnimationProperty MinWidth = null;
    public static final ModifierValue_AnimationProperty None = null;
    public static final ModifierValue_AnimationProperty Opacity = null;
    public static final ModifierValue_AnimationProperty PaddingBottom = null;
    public static final ModifierValue_AnimationProperty PaddingLeft = null;
    public static final ModifierValue_AnimationProperty PaddingRight = null;
    public static final ModifierValue_AnimationProperty PaddingTop = null;
    public static final ModifierValue_AnimationProperty Right = null;
    public static final ModifierValue_AnimationProperty ScaleX = null;
    public static final ModifierValue_AnimationProperty ScaleXY = null;
    public static final ModifierValue_AnimationProperty ScaleY = null;
    public static final ModifierValue_AnimationProperty Top = null;
    public static final ModifierValue_AnimationProperty Transform = null;
    public static final ModifierValue_AnimationProperty Visibility = null;
    public static final ModifierValue_AnimationProperty Width = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_AnimationProperty[] f404799a = null;
    private final int value;

    public static ModifierValue_AnimationProperty valueOf(String r100) {
        return (ModifierValue_AnimationProperty) r27.a.a(ModifierValue_AnimationProperty.class, r100);
    }

    public static ModifierValue_AnimationProperty[] values() {
        return (ModifierValue_AnimationProperty[]) f404799a.clone();
    }

    static {
        ModifierValue_AnimationProperty r100 = new ModifierValue_AnimationProperty("None", 0, 0);
        None = r100;
        ModifierValue_AnimationProperty r101 = new ModifierValue_AnimationProperty("Opacity", 1, 1);
        Opacity = r101;
        ModifierValue_AnimationProperty r102 = new ModifierValue_AnimationProperty("ScaleX", 2, 2);
        ScaleX = r102;
        ModifierValue_AnimationProperty r103 = new ModifierValue_AnimationProperty("ScaleY", 3, 4);
        ScaleY = r103;
        ModifierValue_AnimationProperty r104 = new ModifierValue_AnimationProperty("ScaleXY", 4, 8);
        ScaleXY = r104;
        ModifierValue_AnimationProperty r110 = new ModifierValue_AnimationProperty("Width", 5, 16);
        Width = r110;
        ModifierValue_AnimationProperty r111 = new ModifierValue_AnimationProperty("Height", 6, 32);
        Height = r111;
        ModifierValue_AnimationProperty r112 = new ModifierValue_AnimationProperty("BackgroundColor", 7, 64);
        BackgroundColor = r112;
        ModifierValue_AnimationProperty r105 = new ModifierValue_AnimationProperty("Visibility", 8, 128);
        Visibility = r105;
        ModifierValue_AnimationProperty r106 = new ModifierValue_AnimationProperty("Left", 9, 256);
        Left = r106;
        ModifierValue_AnimationProperty r113 = new ModifierValue_AnimationProperty("Top", 10, 512);
        Top = r113;
        ModifierValue_AnimationProperty r107 = new ModifierValue_AnimationProperty("Right", 11, 1024);
        Right = r107;
        ModifierValue_AnimationProperty r108 = new ModifierValue_AnimationProperty("Bottom", 12, 2048);
        Bottom = r108;
        ModifierValue_AnimationProperty r109 = new ModifierValue_AnimationProperty("Transform", 13, 4096);
        Transform = r109;
        ModifierValue_AnimationProperty r114 = new ModifierValue_AnimationProperty("Color", 14, 8192);
        Color = r114;
        ModifierValue_AnimationProperty r115 = new ModifierValue_AnimationProperty("MaxWidth", 15, 16384);
        MaxWidth = r115;
        ModifierValue_AnimationProperty r116 = new ModifierValue_AnimationProperty("MinWidth", 16, 32768);
        MinWidth = r116;
        ModifierValue_AnimationProperty r117 = new ModifierValue_AnimationProperty("MaxHeight", 17, 65536);
        MaxHeight = r117;
        ModifierValue_AnimationProperty r118 = new ModifierValue_AnimationProperty("MinHeight", 18, 131072);
        MinHeight = r118;
        ModifierValue_AnimationProperty r119 = new ModifierValue_AnimationProperty(EffectTypeConstants.TYPE_FILTER, 19, 262144);
        Filter = r119;
        ModifierValue_AnimationProperty r120 = new ModifierValue_AnimationProperty("PaddingLeft", 20, ErrorCode.HANG);
        PaddingLeft = r120;
        ModifierValue_AnimationProperty r121 = new ModifierValue_AnimationProperty("PaddingRight", 21, 262146);
        PaddingRight = r121;
        ModifierValue_AnimationProperty r122 = new ModifierValue_AnimationProperty("PaddingTop", 22, 262147);
        PaddingTop = r122;
        ModifierValue_AnimationProperty r123 = new ModifierValue_AnimationProperty("PaddingBottom", 23, 262148);
        PaddingBottom = r123;
        ModifierValue_AnimationProperty r124 = new ModifierValue_AnimationProperty("MarginLeft", 24, 262149);
        MarginLeft = r124;
        ModifierValue_AnimationProperty r125 = new ModifierValue_AnimationProperty("MarginRight", 25, 262150);
        MarginRight = r125;
        ModifierValue_AnimationProperty r126 = new ModifierValue_AnimationProperty("MarginTop", 26, 262151);
        MarginTop = r126;
        ModifierValue_AnimationProperty r127 = new ModifierValue_AnimationProperty("MarginBottom", 27, 262152);
        MarginBottom = r127;
        ModifierValue_AnimationProperty r128 = new ModifierValue_AnimationProperty("BorderLeftWidth", 28, 262153);
        BorderLeftWidth = r128;
        ModifierValue_AnimationProperty r129 = new ModifierValue_AnimationProperty("BorderRightWidth", 29, 262154);
        BorderRightWidth = r129;
        ModifierValue_AnimationProperty r130 = new ModifierValue_AnimationProperty("BorderTopWidth", 30, 262155);
        BorderTopWidth = r130;
        ModifierValue_AnimationProperty r131 = new ModifierValue_AnimationProperty("BorderBottomWidth", 31, 262156);
        BorderBottomWidth = r131;
        ModifierValue_AnimationProperty r132 = new ModifierValue_AnimationProperty("BorderTopColor", 32, 262157);
        BorderTopColor = r132;
        ModifierValue_AnimationProperty r133 = new ModifierValue_AnimationProperty("BorderLeftColor", 33, 262158);
        BorderLeftColor = r133;
        ModifierValue_AnimationProperty r134 = new ModifierValue_AnimationProperty("BorderRightColor", 34, 262159);
        BorderRightColor = r134;
        ModifierValue_AnimationProperty r135 = new ModifierValue_AnimationProperty("BorderBottomColor", 35, 262160);
        BorderBottomColor = r135;
        ModifierValue_AnimationProperty r136 = new ModifierValue_AnimationProperty("FlexBasis", 36, 262161);
        FlexBasis = r136;
        ModifierValue_AnimationProperty r137 = new ModifierValue_AnimationProperty("FlexGrow", 37, 262162);
        FlexGrow = r137;
        ModifierValue_AnimationProperty r138 = new ModifierValue_AnimationProperty(CancelRetainContactInfoFunctions.All, 38, 524288);
        All = r138;
        f404799a = new ModifierValue_AnimationProperty[]{r100, r101, r102, r103, r104, r110, r111, r112, r105, r106, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_AnimationProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
