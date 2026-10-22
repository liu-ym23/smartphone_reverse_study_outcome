package com.relax.relaxframework;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b-\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.¨\u0006/"}, d2 = {"Lcom/relax/relaxframework/AnimationPropertyType;", "", "", "value", "I", "getValue", "()I", "None", "Opacity", "ScaleX", "ScaleY", "ScaleXY", "Width", "Height", "BackgroundColor", "Visibility", "Left", "Top", "Right", "Bottom", "Transform", "Color", "MaxWidth", "MinWidth", "MaxHeight", "MinHeight", "PaddingLeft", "PaddingRight", "PaddingTop", "PaddingBottom", "MarginLeft", "MarginRight", "MarginTop", "MarginBottom", "BorderLeftWidth", "BorderRightWidth", "BorderTopWidth", "BorderBottomWidth", "BorderTopColor", "BorderLeftColor", "BorderRightColor", "BorderBottomColor", "FlexBasis", "FlexGrow", EffectTypeConstants.TYPE_FILTER, "BoxShadow", CancelRetainContactInfoFunctions.All, "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimationPropertyType extends Enum<AnimationPropertyType> {
    public static final AnimationPropertyType All = null;
    public static final AnimationPropertyType BackgroundColor = null;
    public static final AnimationPropertyType BorderBottomColor = null;
    public static final AnimationPropertyType BorderBottomWidth = null;
    public static final AnimationPropertyType BorderLeftColor = null;
    public static final AnimationPropertyType BorderLeftWidth = null;
    public static final AnimationPropertyType BorderRightColor = null;
    public static final AnimationPropertyType BorderRightWidth = null;
    public static final AnimationPropertyType BorderTopColor = null;
    public static final AnimationPropertyType BorderTopWidth = null;
    public static final AnimationPropertyType Bottom = null;
    public static final AnimationPropertyType BoxShadow = null;
    public static final AnimationPropertyType Color = null;
    public static final AnimationPropertyType Filter = null;
    public static final AnimationPropertyType FlexBasis = null;
    public static final AnimationPropertyType FlexGrow = null;
    public static final AnimationPropertyType Height = null;
    public static final AnimationPropertyType Left = null;
    public static final AnimationPropertyType MarginBottom = null;
    public static final AnimationPropertyType MarginLeft = null;
    public static final AnimationPropertyType MarginRight = null;
    public static final AnimationPropertyType MarginTop = null;
    public static final AnimationPropertyType MaxHeight = null;
    public static final AnimationPropertyType MaxWidth = null;
    public static final AnimationPropertyType MinHeight = null;
    public static final AnimationPropertyType MinWidth = null;
    public static final AnimationPropertyType None = null;
    public static final AnimationPropertyType Opacity = null;
    public static final AnimationPropertyType PaddingBottom = null;
    public static final AnimationPropertyType PaddingLeft = null;
    public static final AnimationPropertyType PaddingRight = null;
    public static final AnimationPropertyType PaddingTop = null;
    public static final AnimationPropertyType Right = null;
    public static final AnimationPropertyType ScaleX = null;
    public static final AnimationPropertyType ScaleXY = null;
    public static final AnimationPropertyType ScaleY = null;
    public static final AnimationPropertyType Top = null;
    public static final AnimationPropertyType Transform = null;
    public static final AnimationPropertyType Visibility = null;
    public static final AnimationPropertyType Width = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationPropertyType[] f404670a = null;
    private final int value;

    public static AnimationPropertyType valueOf(String r100) {
        return (AnimationPropertyType) r27.a.a(AnimationPropertyType.class, r100);
    }

    public static AnimationPropertyType[] values() {
        return (AnimationPropertyType[]) f404670a.clone();
    }

    static {
        AnimationPropertyType r100 = new AnimationPropertyType("None", 0, 0);
        None = r100;
        AnimationPropertyType r101 = new AnimationPropertyType("Opacity", 1, 1);
        Opacity = r101;
        AnimationPropertyType r102 = new AnimationPropertyType("ScaleX", 2, 2);
        ScaleX = r102;
        AnimationPropertyType r103 = new AnimationPropertyType("ScaleY", 3, 4);
        ScaleY = r103;
        AnimationPropertyType r104 = new AnimationPropertyType("ScaleXY", 4, 8);
        ScaleXY = r104;
        AnimationPropertyType r110 = new AnimationPropertyType("Width", 5, 16);
        Width = r110;
        AnimationPropertyType r111 = new AnimationPropertyType("Height", 6, 32);
        Height = r111;
        AnimationPropertyType r112 = new AnimationPropertyType("BackgroundColor", 7, 64);
        BackgroundColor = r112;
        AnimationPropertyType r105 = new AnimationPropertyType("Visibility", 8, 128);
        Visibility = r105;
        AnimationPropertyType r106 = new AnimationPropertyType("Left", 9, 256);
        Left = r106;
        AnimationPropertyType r113 = new AnimationPropertyType("Top", 10, 512);
        Top = r113;
        AnimationPropertyType r107 = new AnimationPropertyType("Right", 11, 1024);
        Right = r107;
        AnimationPropertyType r108 = new AnimationPropertyType("Bottom", 12, 2048);
        Bottom = r108;
        AnimationPropertyType r109 = new AnimationPropertyType("Transform", 13, 4096);
        Transform = r109;
        AnimationPropertyType r114 = new AnimationPropertyType("Color", 14, 8192);
        Color = r114;
        AnimationPropertyType r115 = new AnimationPropertyType("MaxWidth", 15, 16384);
        MaxWidth = r115;
        AnimationPropertyType r116 = new AnimationPropertyType("MinWidth", 16, 32768);
        MinWidth = r116;
        AnimationPropertyType r117 = new AnimationPropertyType("MaxHeight", 17, 65536);
        MaxHeight = r117;
        AnimationPropertyType r118 = new AnimationPropertyType("MinHeight", 18, 131072);
        MinHeight = r118;
        AnimationPropertyType r119 = new AnimationPropertyType("PaddingLeft", 19, 131073);
        PaddingLeft = r119;
        AnimationPropertyType r120 = new AnimationPropertyType("PaddingRight", 20, 131074);
        PaddingRight = r120;
        AnimationPropertyType r121 = new AnimationPropertyType("PaddingTop", 21, 131075);
        PaddingTop = r121;
        AnimationPropertyType r122 = new AnimationPropertyType("PaddingBottom", 22, 131076);
        PaddingBottom = r122;
        AnimationPropertyType r123 = new AnimationPropertyType("MarginLeft", 23, 131077);
        MarginLeft = r123;
        AnimationPropertyType r124 = new AnimationPropertyType("MarginRight", 24, 131078);
        MarginRight = r124;
        AnimationPropertyType r125 = new AnimationPropertyType("MarginTop", 25, 131079);
        MarginTop = r125;
        AnimationPropertyType r126 = new AnimationPropertyType("MarginBottom", 26, 131080);
        MarginBottom = r126;
        AnimationPropertyType r127 = new AnimationPropertyType("BorderLeftWidth", 27, 131081);
        BorderLeftWidth = r127;
        AnimationPropertyType r128 = new AnimationPropertyType("BorderRightWidth", 28, 131082);
        BorderRightWidth = r128;
        AnimationPropertyType r129 = new AnimationPropertyType("BorderTopWidth", 29, 131083);
        BorderTopWidth = r129;
        AnimationPropertyType r130 = new AnimationPropertyType("BorderBottomWidth", 30, 131084);
        BorderBottomWidth = r130;
        AnimationPropertyType r131 = new AnimationPropertyType("BorderTopColor", 31, 131085);
        BorderTopColor = r131;
        AnimationPropertyType r132 = new AnimationPropertyType("BorderLeftColor", 32, 131086);
        BorderLeftColor = r132;
        AnimationPropertyType r133 = new AnimationPropertyType("BorderRightColor", 33, 131087);
        BorderRightColor = r133;
        AnimationPropertyType r134 = new AnimationPropertyType("BorderBottomColor", 34, 131088);
        BorderBottomColor = r134;
        AnimationPropertyType r135 = new AnimationPropertyType("FlexBasis", 35, 131089);
        FlexBasis = r135;
        AnimationPropertyType r136 = new AnimationPropertyType("FlexGrow", 36, 131090);
        FlexGrow = r136;
        AnimationPropertyType r137 = new AnimationPropertyType(EffectTypeConstants.TYPE_FILTER, 37, 131091);
        Filter = r137;
        AnimationPropertyType r138 = new AnimationPropertyType("BoxShadow", 38, 131092);
        BoxShadow = r138;
        AnimationPropertyType r139 = new AnimationPropertyType(CancelRetainContactInfoFunctions.All, 39, 262144);
        All = r139;
        f404670a = new AnimationPropertyType[]{r100, r101, r102, r103, r104, r110, r111, r112, r105, r106, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationPropertyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
