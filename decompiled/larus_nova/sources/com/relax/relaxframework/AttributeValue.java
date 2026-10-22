package com.relax.relaxframework;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b*\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006,"}, d2 = {"Lcom/relax/relaxframework/AttributeValue;", "", "", "value", "I", "getValue", "()I", BdpAppEventConstant.TRUE, BdpAppEventConstant.FALSE, "ModeScaleToFill", "ModeAspectFit", "ModeAspectFill", "ModeCenter", "TextOverflowClip", "ListTypeWaterFall", "ListTypeFlow", "ListTypeSingle", "ListUpdateAnimationDefault", "ImageTransitionFadeIn", "InputTypeText", "InputTypeNumber", "InputTypeDigit", "InputTypePassword", "InputTypeTel", "InputTypeEmail", "InputActionSend", "InputActionSearch", "InputActionGo", "InputActionDone", "InputActionNext", "VideoViewObjectFitContain", "VideoViewObjectFitCover", "VideoViewObjectFitFill", "TopLeft", "TopCenter", "TopRight", "CenterLeft", "Center", "CenterRight", "BottomLeft", "BottomCenter", "BottomRight", "Auto", "Fill", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AttributeValue extends Enum<AttributeValue> {
    public static final AttributeValue Auto = null;
    public static final AttributeValue BottomCenter = null;
    public static final AttributeValue BottomLeft = null;
    public static final AttributeValue BottomRight = null;
    public static final AttributeValue Center = null;
    public static final AttributeValue CenterLeft = null;
    public static final AttributeValue CenterRight = null;
    public static final AttributeValue False = null;
    public static final AttributeValue Fill = null;
    public static final AttributeValue ImageTransitionFadeIn = null;
    public static final AttributeValue InputActionDone = null;
    public static final AttributeValue InputActionGo = null;
    public static final AttributeValue InputActionNext = null;
    public static final AttributeValue InputActionSearch = null;
    public static final AttributeValue InputActionSend = null;
    public static final AttributeValue InputTypeDigit = null;
    public static final AttributeValue InputTypeEmail = null;
    public static final AttributeValue InputTypeNumber = null;
    public static final AttributeValue InputTypePassword = null;
    public static final AttributeValue InputTypeTel = null;
    public static final AttributeValue InputTypeText = null;
    public static final AttributeValue ListTypeFlow = null;
    public static final AttributeValue ListTypeSingle = null;
    public static final AttributeValue ListTypeWaterFall = null;
    public static final AttributeValue ListUpdateAnimationDefault = null;
    public static final AttributeValue ModeAspectFill = null;
    public static final AttributeValue ModeAspectFit = null;
    public static final AttributeValue ModeCenter = null;
    public static final AttributeValue ModeScaleToFill = null;
    public static final AttributeValue TextOverflowClip = null;
    public static final AttributeValue TopCenter = null;
    public static final AttributeValue TopLeft = null;
    public static final AttributeValue TopRight = null;
    public static final AttributeValue True = null;
    public static final AttributeValue VideoViewObjectFitContain = null;
    public static final AttributeValue VideoViewObjectFitCover = null;
    public static final AttributeValue VideoViewObjectFitFill = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttributeValue[] f404675a = null;
    private final int value;

    public static AttributeValue valueOf(String r100) {
        return (AttributeValue) r27.a.a(AttributeValue.class, r100);
    }

    public static AttributeValue[] values() {
        return (AttributeValue[]) f404675a.clone();
    }

    static {
        AttributeValue r100 = new AttributeValue(BdpAppEventConstant.TRUE, 0, 40001);
        True = r100;
        AttributeValue r101 = new AttributeValue(BdpAppEventConstant.FALSE, 1, 40002);
        False = r101;
        AttributeValue r102 = new AttributeValue("ModeScaleToFill", 2, 40003);
        ModeScaleToFill = r102;
        AttributeValue r103 = new AttributeValue("ModeAspectFit", 3, 40004);
        ModeAspectFit = r103;
        AttributeValue r104 = new AttributeValue("ModeAspectFill", 4, 40005);
        ModeAspectFill = r104;
        AttributeValue r105 = new AttributeValue("ModeCenter", 5, 40006);
        ModeCenter = r105;
        AttributeValue r110 = new AttributeValue("TextOverflowClip", 6, 40007);
        TextOverflowClip = r110;
        AttributeValue r111 = new AttributeValue("ListTypeWaterFall", 7, 40008);
        ListTypeWaterFall = r111;
        AttributeValue r112 = new AttributeValue("ListTypeFlow", 8, 40009);
        ListTypeFlow = r112;
        AttributeValue r113 = new AttributeValue("ListTypeSingle", 9, 40010);
        ListTypeSingle = r113;
        AttributeValue r114 = new AttributeValue("ListUpdateAnimationDefault", 10, 40011);
        ListUpdateAnimationDefault = r114;
        AttributeValue r106 = new AttributeValue("ImageTransitionFadeIn", 11, 40012);
        ImageTransitionFadeIn = r106;
        AttributeValue r107 = new AttributeValue("InputTypeText", 12, 40013);
        InputTypeText = r107;
        AttributeValue r108 = new AttributeValue("InputTypeNumber", 13, 40014);
        InputTypeNumber = r108;
        AttributeValue r109 = new AttributeValue("InputTypeDigit", 14, 40015);
        InputTypeDigit = r109;
        AttributeValue r115 = new AttributeValue("InputTypePassword", 15, 40016);
        InputTypePassword = r115;
        AttributeValue r116 = new AttributeValue("InputTypeTel", 16, 40017);
        InputTypeTel = r116;
        AttributeValue r117 = new AttributeValue("InputTypeEmail", 17, 40018);
        InputTypeEmail = r117;
        AttributeValue r118 = new AttributeValue("InputActionSend", 18, 40019);
        InputActionSend = r118;
        AttributeValue r119 = new AttributeValue("InputActionSearch", 19, 40020);
        InputActionSearch = r119;
        AttributeValue r120 = new AttributeValue("InputActionGo", 20, 40021);
        InputActionGo = r120;
        AttributeValue r121 = new AttributeValue("InputActionDone", 21, 40022);
        InputActionDone = r121;
        AttributeValue r122 = new AttributeValue("InputActionNext", 22, 40023);
        InputActionNext = r122;
        AttributeValue r123 = new AttributeValue("VideoViewObjectFitContain", 23, 40024);
        VideoViewObjectFitContain = r123;
        AttributeValue r124 = new AttributeValue("VideoViewObjectFitCover", 24, 40025);
        VideoViewObjectFitCover = r124;
        AttributeValue r125 = new AttributeValue("VideoViewObjectFitFill", 25, 40026);
        VideoViewObjectFitFill = r125;
        AttributeValue r126 = new AttributeValue("TopLeft", 26, 40027);
        TopLeft = r126;
        AttributeValue r127 = new AttributeValue("TopCenter", 27, 40028);
        TopCenter = r127;
        AttributeValue r128 = new AttributeValue("TopRight", 28, 40029);
        TopRight = r128;
        AttributeValue r129 = new AttributeValue("CenterLeft", 29, 40030);
        CenterLeft = r129;
        AttributeValue r130 = new AttributeValue("Center", 30, 40031);
        Center = r130;
        AttributeValue r131 = new AttributeValue("CenterRight", 31, 40032);
        CenterRight = r131;
        AttributeValue r132 = new AttributeValue("BottomLeft", 32, 40033);
        BottomLeft = r132;
        AttributeValue r133 = new AttributeValue("BottomCenter", 33, TTVideoEngineInterface.GLOBAL_PLAYER_OPTION_ENABLE_REFACTOR_LOGGER);
        BottomCenter = r133;
        AttributeValue r134 = new AttributeValue("BottomRight", 34, 40035);
        BottomRight = r134;
        AttributeValue r135 = new AttributeValue("Auto", 35, 40036);
        Auto = r135;
        AttributeValue r136 = new AttributeValue("Fill", 36, 40037);
        Fill = r136;
        f404675a = new AttributeValue[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136};
    }

    public final int getValue() {
        return this.value;
    }

    public AttributeValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
