package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b9\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010O\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0090\u0002\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b,\u0010\u001eR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b-\u0010\u001eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b/\u0010\u001eR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b0\u0010\u001eR\"\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b1\u0010)\"\u0004\b2\u00103R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b4\u0010\u001eR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b5\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b6\u0010\u001eR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b7\u0010\u001eR\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b<\u0010\u001e¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "Ljava/io/Serializable;", "width", "", "height", "color", "", "fontSize", "fontWeight", "", "lineHeight", "fontFamily", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "marginLeft", "marginTop", "marginRight", "marginBottom", "ellipsize", "maxLine", "shape", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;", "backGround", "aspectRatio", "radius", "", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;)V", "getAspectRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBackGround", "()Ljava/lang/String;", "setBackGround", "(Ljava/lang/String;)V", "getColor", "getEllipsize", "getFontFamily", "getFontSize", "getFontWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getLineHeight", "getMarginBottom", "getMarginLeft", "getMarginRight", "getMarginTop", "getMaxLine", "setMaxLine", "(Ljava/lang/Integer;)V", "getPaddingBottom", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "getRadius", "()Ljava/util/List;", "getShape", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "equals", "", "other", "", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductStyle implements Serializable {

    @SerializedName("aspect_ratio")
    private final Float aspectRatio;

    @SerializedName("background_color")
    private String backGround;
    private final String color;

    @SerializedName("ellipsize")
    private final String ellipsize;

    @SerializedName("font_family")
    private final String fontFamily;

    @SerializedName("font_size")
    private final Float fontSize;

    @SerializedName("font_weight")
    private final Integer fontWeight;
    private final Float height;

    @SerializedName("line_height")
    private final Float lineHeight;

    @SerializedName("margin_bottom")
    private final Float marginBottom;

    @SerializedName("margin_left")
    private final Float marginLeft;

    @SerializedName("margin_right")
    private final Float marginRight;

    @SerializedName("margin_top")
    private final Float marginTop;

    @SerializedName("max_line")
    private Integer maxLine;

    @SerializedName("padding_bottom")
    private final Float paddingBottom;

    @SerializedName("padding_left")
    private final Float paddingLeft;

    @SerializedName("padding_right")
    private final Float paddingRight;

    @SerializedName("padding_top")
    private final Float paddingTop;

    @SerializedName("radius")
    private final List<Float> radius;

    @SerializedName("shape")
    private final Shape shape;
    private final Float width;

    public ProductStyle() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductStyle copy$default(ProductStyle r17, Float r18, Float r19, String r20, Float r21, Integer r22, Float r23, String r24, Float r25, Float r26, Float r27, Float r28, Float r29, Float r30, Float r31, Float r32, String r33, Integer r34, Shape r35, String r36, Float r37, List r38, int r39, Object r40) {
        if ((r39 & 1) == 0) goto L5;
        Float r2 = r17.width;
    L7:
        if ((r39 & 2) == 0) goto L9;
        Float r3 = r17.height;
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r4 = r17.color;
    L15:
        if ((r39 & 8) == 0) goto L17;
        Float r5 = r17.fontSize;
    L19:
        if ((r39 & 16) == 0) goto L21;
        Integer r6 = r17.fontWeight;
    L23:
        if ((r39 & 32) == 0) goto L25;
        Float r7 = r17.lineHeight;
    L27:
        if ((r39 & 64) == 0) goto L29;
        String r8 = r17.fontFamily;
    L31:
        if ((r39 & 128) == 0) goto L33;
        Float r9 = r17.paddingLeft;
    L35:
        if ((r39 & 256) == 0) goto L37;
        Float r10 = r17.paddingRight;
    L39:
        if ((r39 & 512) == 0) goto L41;
        Float r11 = r17.paddingTop;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        Float r12 = r17.paddingBottom;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        Float r13 = r17.marginLeft;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        Float r14 = r17.marginTop;
    L55:
        if ((r39 & 8192) == 0) goto L57;
        Float r15 = r17.marginRight;
    L58:
        Float r310 = r15;
        if ((r39 & 16384) == 0) goto L61;
        Float r16 = r17.marginBottom;
    L62:
        Float r311 = r16;
        if ((r39 & 32768) == 0) goto L65;
        String r110 = r17.ellipsize;
    L66:
        String r312 = r110;
        if ((r39 & 65536) == 0) goto L69;
        Integer r111 = r17.maxLine;
    L70:
        Integer r313 = r111;
        if ((r39 & 131072) == 0) goto L73;
        Shape r112 = r17.shape;
    L74:
        Shape r314 = r112;
        if ((r39 & 262144) == 0) goto L77;
        String r113 = r17.backGround;
    L78:
        String r315 = r113;
        if ((r39 & 524288) == 0) goto L81;
        Float r114 = r17.aspectRatio;
    L83:
        if ((r39 & 1048576) == 0) goto L85;
        List r1 = r17.radius;
    L87:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r114, r1);
    L85:
        r1 = r38;
        goto L87
    L81:
        r114 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Float component1() {
        return this.width;
    }

    public final Float component10() {
        return this.paddingTop;
    }

    public final Float component11() {
        return this.paddingBottom;
    }

    public final Float component12() {
        return this.marginLeft;
    }

    public final Float component13() {
        return this.marginTop;
    }

    public final Float component14() {
        return this.marginRight;
    }

    public final Float component15() {
        return this.marginBottom;
    }

    public final String component16() {
        return this.ellipsize;
    }

    public final Integer component17() {
        return this.maxLine;
    }

    public final Shape component18() {
        return this.shape;
    }

    public final String component19() {
        return this.backGround;
    }

    public final Float component2() {
        return this.height;
    }

    public final Float component20() {
        return this.aspectRatio;
    }

    public final List<Float> component21() {
        return this.radius;
    }

    public final String component3() {
        return this.color;
    }

    public final Float component4() {
        return this.fontSize;
    }

    public final Integer component5() {
        return this.fontWeight;
    }

    public final Float component6() {
        return this.lineHeight;
    }

    public final String component7() {
        return this.fontFamily;
    }

    public final Float component8() {
        return this.paddingLeft;
    }

    public final Float component9() {
        return this.paddingRight;
    }

    public final ProductStyle copy(Float r24, Float r25, String r26, Float r27, Integer r28, Float r29, String r30, Float r31, Float r32, Float r33, Float r34, Float r35, Float r36, Float r37, Float r38, String r39, Integer r40, Shape r41, String r42, Float r43, List<Float> r44) {
        return new ProductStyle(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductStyle) == false) goto L48;
        ProductStyle r4 = (ProductStyle) r3;
        if (Intrinsics.areEqual(this.width, r4.width) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontSize, r4.fontSize) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontWeight, r4.fontWeight) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lineHeight, r4.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontFamily, r4.fontFamily) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.paddingLeft, r4.paddingLeft) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.paddingRight, r4.paddingRight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.paddingTop, r4.paddingTop) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.paddingBottom, r4.paddingBottom) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.marginLeft, r4.marginLeft) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.marginTop, r4.marginTop) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.marginRight, r4.marginRight) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.marginBottom, r4.marginBottom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ellipsize, r4.ellipsize) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.maxLine, r4.maxLine) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.shape, r4.shape) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.backGround, r4.backGround) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.aspectRatio, r4.aspectRatio) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.radius, r4.radius) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public int hashCode() {
        Float r0 = this.width;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Float r4 = this.height;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.color;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.fontSize;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.fontWeight;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Float r16 = this.lineHeight;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.fontFamily;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.paddingLeft;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Float r25 = this.paddingRight;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Float r28 = this.paddingTop;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Float r31 = this.paddingBottom;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Float r34 = this.marginLeft;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Float r37 = this.marginTop;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Float r40 = this.marginRight;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Float r43 = this.marginBottom;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.ellipsize;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Integer r49 = this.maxLine;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        Shape r52 = this.shape;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.backGround;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        Float r58 = this.aspectRatio;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        List<Float> r61 = this.radius;
        if (r61 == null) goto L86;
        r1 = r61.hashCode();
    L86:
        return r60 + r1;
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ProductStyle(width=" + this.width + ", height=" + this.height + ", color=" + this.color + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", fontFamily=" + this.fontFamily + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", marginLeft=" + this.marginLeft + ", marginTop=" + this.marginTop + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", ellipsize=" + this.ellipsize + ", maxLine=" + this.maxLine + ", shape=" + this.shape + ", backGround=" + this.backGround + ", aspectRatio=" + this.aspectRatio + ", radius=" + this.radius + ")";
    }

    public final Float getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getBackGround() {
        return this.backGround;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getEllipsize() {
        return this.ellipsize;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final Integer getFontWeight() {
        return this.fontWeight;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final Float getMarginBottom() {
        return this.marginBottom;
    }

    public final Float getMarginLeft() {
        return this.marginLeft;
    }

    public final Float getMarginRight() {
        return this.marginRight;
    }

    public final Float getMarginTop() {
        return this.marginTop;
    }

    public final Integer getMaxLine() {
        return this.maxLine;
    }

    public final Float getPaddingBottom() {
        return this.paddingBottom;
    }

    public final Float getPaddingLeft() {
        return this.paddingLeft;
    }

    public final Float getPaddingRight() {
        return this.paddingRight;
    }

    public final Float getPaddingTop() {
        return this.paddingTop;
    }

    public final List<Float> getRadius() {
        return this.radius;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setBackGround(String r1) {
        this.backGround = r1;
    }

    public final void setMaxLine(Integer r1) {
        this.maxLine = r1;
    }

    public ProductStyle(Float r3, Float r4, String r5, Float r6, Integer r7, Float r8, String r9, Float r10, Float r11, Float r12, Float r13, Float r14, Float r15, Float r16, Float r17, String r18, Integer r19, Shape r20, String r21, Float r22, List<Float> r23) {
        this.width = r3;
        this.height = r4;
        this.color = r5;
        this.fontSize = r6;
        this.fontWeight = r7;
        this.lineHeight = r8;
        this.fontFamily = r9;
        this.paddingLeft = r10;
        this.paddingRight = r11;
        this.paddingTop = r12;
        this.paddingBottom = r13;
        this.marginLeft = r14;
        this.marginTop = r15;
        this.marginRight = r16;
        this.marginBottom = r17;
        this.ellipsize = r18;
        this.maxLine = r19;
        this.shape = r20;
        this.backGround = r21;
        this.aspectRatio = r22;
        this.radius = r23;
    }

    public /* synthetic */ ProductStyle(Float r23, Float r24, String r25, Float r26, Integer r27, Float r28, String r29, Float r30, Float r31, Float r32, Float r33, Float r34, Float r35, Float r36, Float r37, String r38, Integer r39, Shape r40, String r41, Float r42, List r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        Float r1 = null;
    L7:
        if ((r44 & 2) == 0) goto L9;
        Float r3 = null;
    L11:
        if ((r44 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r44 & 8) == 0) goto L17;
        Float r5 = null;
    L19:
        if ((r44 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r44 & 32) == 0) goto L25;
        Float r7 = null;
    L27:
        if ((r44 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r44 & 128) == 0) goto L33;
        Float r9 = null;
    L35:
        if ((r44 & 256) == 0) goto L37;
        Float r10 = null;
    L39:
        if ((r44 & 512) == 0) goto L41;
        Float r11 = null;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        Float r12 = null;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        Float r13 = null;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        Float r14 = null;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        Float r15 = null;
    L59:
        if ((r44 & 16384) == 0) goto L61;
        Float r2 = null;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r44 & 65536) == 0) goto L69;
        Integer r17 = null;
    L71:
        if ((r44 & 131072) == 0) goto L73;
        Shape r18 = null;
    L75:
        if ((r44 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r44 & 524288) == 0) goto L81;
        Float r20 = null;
    L83:
        if ((r44 & 1048576) == 0) goto L85;
        List r0 = null;
    L86:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r0);
        return;
    L85:
        r0 = r43;
        goto L86
    L81:
        r20 = r42;
        goto L83
    L77:
        r19 = r41;
        goto L79
    L73:
        r18 = r40;
        goto L75
    L69:
        r17 = r39;
        goto L71
    L65:
        r16 = r38;
        goto L67
    L61:
        r2 = r37;
        goto L63
    L57:
        r15 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L55
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }
}
