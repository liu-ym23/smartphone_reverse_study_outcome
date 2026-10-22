package com.bytedance.common.jato.view.dump;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum RenderOpType extends Enum<RenderOpType> {
    private static final /* synthetic */ RenderOpType[] $VALUES = null;
    public static final RenderOpType nAddAnimator = null;
    public static final RenderOpType nClearStretch = null;
    public static final RenderOpType nDiscardDisplayList = null;
    public static final RenderOpType nEndAllAnimators = null;
    public static final RenderOpType nForceEndAnimators = null;
    public static final RenderOpType nMaxType = null;
    public static final RenderOpType nOffsetLeftAndRight = null;
    public static final RenderOpType nOffsetTopAndBottom = null;
    public static final RenderOpType nRequestPositionUpdates = null;
    public static final RenderOpType nResetPivot = null;
    public static final RenderOpType nSetAllowForceDark = null;
    public static final RenderOpType nSetAlpha = null;
    public static final RenderOpType nSetAmbientShadowColor = null;
    public static final RenderOpType nSetAnimationMatrix = null;
    public static final RenderOpType nSetBackdropRenderEffect = null;
    public static final RenderOpType nSetBottom = null;
    public static final RenderOpType nSetCameraDistance = null;
    public static final RenderOpType nSetClipBounds = null;
    public static final RenderOpType nSetClipBoundsEmpty = null;
    public static final RenderOpType nSetClipToBounds = null;
    public static final RenderOpType nSetClipToOutline = null;
    public static final RenderOpType nSetElevation = null;
    public static final RenderOpType nSetHasOverlappingRendering = null;
    public static final RenderOpType nSetLayerPaint = null;
    public static final RenderOpType nSetLayerType = null;
    public static final RenderOpType nSetLeft = null;
    public static final RenderOpType nSetLeftTopRightBottom = null;
    public static final RenderOpType nSetOutlineEmpty = null;
    public static final RenderOpType nSetOutlineNone = null;
    public static final RenderOpType nSetOutlinePath = null;
    public static final RenderOpType nSetOutlineRoundRect = null;
    public static final RenderOpType nSetPivotX = null;
    public static final RenderOpType nSetPivotY = null;
    public static final RenderOpType nSetProjectBackwards = null;
    public static final RenderOpType nSetProjectionReceiver = null;
    public static final RenderOpType nSetRenderEffect = null;
    public static final RenderOpType nSetRevealClip = null;
    public static final RenderOpType nSetRight = null;
    public static final RenderOpType nSetRotation = null;
    public static final RenderOpType nSetRotationX = null;
    public static final RenderOpType nSetRotationY = null;
    public static final RenderOpType nSetScaleX = null;
    public static final RenderOpType nSetScaleY = null;
    public static final RenderOpType nSetSpotShadowColor = null;
    public static final RenderOpType nSetStaticMatrix = null;
    public static final RenderOpType nSetTop = null;
    public static final RenderOpType nSetTranslationX = null;
    public static final RenderOpType nSetTranslationY = null;
    public static final RenderOpType nSetTranslationZ = null;
    public static final RenderOpType nStretch = null;
    public static final RenderOpType setExtraInfo = null;
    public static final RenderOpType unknownRenderType = null;
    private final int index;

    static {
        RenderOpType r100 = new RenderOpType("unknownRenderType", 0, 32);
        unknownRenderType = r100;
        RenderOpType r101 = new RenderOpType("nAddAnimator", 1, 33);
        nAddAnimator = r101;
        RenderOpType r102 = new RenderOpType("nEndAllAnimators", 2, 34);
        nEndAllAnimators = r102;
        RenderOpType r103 = new RenderOpType("nForceEndAnimators", 3, 35);
        nForceEndAnimators = r103;
        RenderOpType r104 = new RenderOpType("nRequestPositionUpdates", 4, 36);
        nRequestPositionUpdates = r104;
        RenderOpType r110 = new RenderOpType("nSetLayerType", 5, 37);
        nSetLayerType = r110;
        RenderOpType r111 = new RenderOpType("nDiscardDisplayList", 6, 38);
        nDiscardDisplayList = r111;
        RenderOpType r105 = new RenderOpType("nSetLayerPaint", 7, 39);
        nSetLayerPaint = r105;
        RenderOpType r106 = new RenderOpType("nSetStaticMatrix", 8, 40);
        nSetStaticMatrix = r106;
        RenderOpType r112 = new RenderOpType("nSetAnimationMatrix", 9, 41);
        nSetAnimationMatrix = r112;
        RenderOpType r113 = new RenderOpType("nSetClipToBounds", 10, 42);
        nSetClipToBounds = r113;
        RenderOpType r114 = new RenderOpType("nSetClipBounds", 11, 43);
        nSetClipBounds = r114;
        RenderOpType r107 = new RenderOpType("nSetClipBoundsEmpty", 12, 44);
        nSetClipBoundsEmpty = r107;
        RenderOpType r108 = new RenderOpType("nSetProjectBackwards", 13, 45);
        nSetProjectBackwards = r108;
        RenderOpType r109 = new RenderOpType("nSetProjectionReceiver", 14, 46);
        nSetProjectionReceiver = r109;
        RenderOpType r115 = new RenderOpType("nSetOutlineRoundRect", 15, 47);
        nSetOutlineRoundRect = r115;
        RenderOpType r116 = new RenderOpType("nSetOutlinePath", 16, 48);
        nSetOutlinePath = r116;
        RenderOpType r117 = new RenderOpType("nSetOutlineEmpty", 17, 49);
        nSetOutlineEmpty = r117;
        RenderOpType r118 = new RenderOpType("nSetOutlineNone", 18, 50);
        nSetOutlineNone = r118;
        RenderOpType r119 = new RenderOpType("nClearStretch", 19, 51);
        nClearStretch = r119;
        RenderOpType r120 = new RenderOpType("nStretch", 20, 52);
        nStretch = r120;
        RenderOpType r121 = new RenderOpType("nSetSpotShadowColor", 21, 53);
        nSetSpotShadowColor = r121;
        RenderOpType r122 = new RenderOpType("nSetAmbientShadowColor", 22, 54);
        nSetAmbientShadowColor = r122;
        RenderOpType r123 = new RenderOpType("nSetClipToOutline", 23, 55);
        nSetClipToOutline = r123;
        RenderOpType r124 = new RenderOpType("nSetRevealClip", 24, 56);
        nSetRevealClip = r124;
        RenderOpType r125 = new RenderOpType("nSetAlpha", 25, 57);
        nSetAlpha = r125;
        RenderOpType r126 = new RenderOpType("nSetRenderEffect", 26, 58);
        nSetRenderEffect = r126;
        RenderOpType r127 = new RenderOpType("nSetBackdropRenderEffect", 27, 59);
        nSetBackdropRenderEffect = r127;
        RenderOpType r128 = new RenderOpType("nSetHasOverlappingRendering", 28, 60);
        nSetHasOverlappingRendering = r128;
        RenderOpType r129 = new RenderOpType("nSetElevation", 29, 61);
        nSetElevation = r129;
        RenderOpType r130 = new RenderOpType("nSetTranslationX", 30, 62);
        nSetTranslationX = r130;
        RenderOpType r131 = new RenderOpType("nSetTranslationY", 31, 63);
        nSetTranslationY = r131;
        RenderOpType r132 = new RenderOpType("nSetTranslationZ", 32, 64);
        nSetTranslationZ = r132;
        RenderOpType r133 = new RenderOpType("nSetRotation", 33, 65);
        nSetRotation = r133;
        RenderOpType r134 = new RenderOpType("nSetRotationX", 34, 66);
        nSetRotationX = r134;
        RenderOpType r135 = new RenderOpType("nSetRotationY", 35, 67);
        nSetRotationY = r135;
        RenderOpType r136 = new RenderOpType("nSetScaleX", 36, 68);
        nSetScaleX = r136;
        RenderOpType r137 = new RenderOpType("nSetScaleY", 37, 69);
        nSetScaleY = r137;
        RenderOpType r138 = new RenderOpType("nSetPivotX", 38, 70);
        nSetPivotX = r138;
        RenderOpType r139 = new RenderOpType("nSetPivotY", 39, 71);
        nSetPivotY = r139;
        RenderOpType r140 = new RenderOpType("nResetPivot", 40, 72);
        nResetPivot = r140;
        RenderOpType r141 = new RenderOpType("nSetCameraDistance", 41, 73);
        nSetCameraDistance = r141;
        RenderOpType r142 = new RenderOpType("nSetLeft", 42, 74);
        nSetLeft = r142;
        RenderOpType r143 = new RenderOpType("nSetTop", 43, 75);
        nSetTop = r143;
        RenderOpType r144 = new RenderOpType("nSetRight", 44, 76);
        nSetRight = r144;
        RenderOpType r145 = new RenderOpType("nSetBottom", 45, 77);
        nSetBottom = r145;
        RenderOpType r146 = new RenderOpType("nSetLeftTopRightBottom", 46, 78);
        nSetLeftTopRightBottom = r146;
        RenderOpType r147 = new RenderOpType("nOffsetLeftAndRight", 47, 79);
        nOffsetLeftAndRight = r147;
        RenderOpType r148 = new RenderOpType("nOffsetTopAndBottom", 48, 80);
        nOffsetTopAndBottom = r148;
        RenderOpType r149 = new RenderOpType("nSetAllowForceDark", 49, 81);
        nSetAllowForceDark = r149;
        RenderOpType r150 = new RenderOpType("setExtraInfo", 50, 82);
        setExtraInfo = r150;
        RenderOpType r151 = new RenderOpType("nMaxType", 51, r150.index);
        nMaxType = r151;
        $VALUES = new RenderOpType[]{r100, r101, r102, r103, r104, r110, r111, r105, r106, r112, r113, r114, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151};
    }

    public static RenderOpType[] values() {
        return (RenderOpType[]) $VALUES.clone();
    }

    public int boolFalse() {
        return index();
    }

    public int boolTrue() {
        return index() | Integer.MIN_VALUE;
    }

    public int index() {
        return this.index;
    }

    public static RenderOpType valueOf(String r100) {
        return (RenderOpType) a.a(RenderOpType.class, r100);
    }

    private RenderOpType(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
