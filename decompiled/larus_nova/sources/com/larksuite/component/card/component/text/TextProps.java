package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bE\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010?\u001a\u00020\u0017J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010P\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010R\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010S\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010T\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010U\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u009c\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00172\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0007HÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010%R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b+\u0010%R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b0\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b1\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b2\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b3\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b;\u00108R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b<\u00108R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b=\u00108R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b\u001c\u00108R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b>\u00108¨\u0006\\"}, d2 = {"Lcom/larksuite/component/card/component/text/TextProps;", "", "id", "", "parentId", "textColor", "textSize", "", "bgColor", "maxLines", "textLines", "lineSpacing", "", "align", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "ellipsize", "contentProps", "", "Lcom/larksuite/component/card/component/text/ContentProps;", "atClickable", "", "linkClickable", "disableAtStyle", "disableTagStyle", "disableNumberTagStyle", "isTranslateElement", "inTable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getParentId", "getTextColor", "getTextSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgColor", "getMaxLines$annotations", "()V", "getMaxLines", "getTextLines", "getLineSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getAlign", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "getPaddingBottom", "getEllipsize", "getContentProps", "()Ljava/util/List;", "getAtClickable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinkClickable", "getDisableAtStyle", "getDisableTagStyle", "getDisableNumberTagStyle", "getInTable", "isTranslate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larksuite/component/card/component/text/TextProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextProps {
    private final String align;
    private final Boolean atClickable;
    private final String bgColor;
    private final List<ContentProps> contentProps;
    private final Boolean disableAtStyle;
    private final Boolean disableNumberTagStyle;
    private final Boolean disableTagStyle;
    private final String ellipsize;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f283580id;
    private final Boolean inTable;
    private final Boolean isTranslateElement;
    private final Float lineSpacing;
    private final Boolean linkClickable;
    private final Integer maxLines;
    private final Integer paddingBottom;
    private final Integer paddingLeft;
    private final Integer paddingRight;
    private final Integer paddingTop;
    private final String parentId;
    private final String textColor;
    private final Integer textLines;
    private final Integer textSize;

    public TextProps() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextProps copy$default(TextProps r110, String r111, String r112, String r210, Integer r211, String r212, Integer r213, Integer r214, Float r215, String r216, Integer r217, Integer r218, Integer r219, Integer r310, String r311, List r312, Boolean r313, Boolean r314, Boolean r315, Boolean r316, Boolean r317, Boolean r318, Boolean r319, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = r110.f283580id;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = r110.parentId;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = r110.textColor;
    L15:
        if ((r410 & 8) == 0) goto L17;
        Integer r103 = r110.textSize;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = r110.bgColor;
    L23:
        if ((r410 & 32) == 0) goto L25;
        Integer r105 = r110.maxLines;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Integer r106 = r110.textLines;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Float r107 = r110.lineSpacing;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r113 = r110.align;
    L39:
        if ((r410 & 512) == 0) goto L41;
        Integer r114 = r110.paddingLeft;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Integer r115 = r110.paddingRight;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        Integer r116 = r110.paddingTop;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        Integer r117 = r110.paddingBottom;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r118 = r110.ellipsize;
    L58:
        String r320 = r118;
        if ((r410 & 16384) == 0) goto L61;
        List r119 = r110.contentProps;
    L62:
        List r321 = r119;
        if ((r410 & 32768) == 0) goto L65;
        Boolean r120 = r110.atClickable;
    L66:
        Boolean r322 = r120;
        if ((r410 & 65536) == 0) goto L69;
        Boolean r121 = r110.linkClickable;
    L70:
        Boolean r323 = r121;
        if ((r410 & 131072) == 0) goto L73;
        Boolean r122 = r110.disableAtStyle;
    L74:
        Boolean r324 = r122;
        if ((r410 & 262144) == 0) goto L77;
        Boolean r123 = r110.disableTagStyle;
    L78:
        Boolean r325 = r123;
        if ((r410 & 524288) == 0) goto L81;
        Boolean r124 = r110.disableNumberTagStyle;
    L82:
        Boolean r326 = r124;
        if ((r410 & 1048576) == 0) goto L85;
        Boolean r125 = r110.isTranslateElement;
    L87:
        if ((r410 & 2097152) == 0) goto L89;
        Boolean r108 = r110.inTable;
    L91:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r125, r108);
    L89:
        r108 = r319;
        goto L91
    L85:
        r125 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Deprecated(message = "only for lk_md")
    public static /* synthetic */ void getMaxLines$annotations() {
    }

    public final String component1() {
        return this.f283580id;
    }

    public final Integer component10() {
        return this.paddingLeft;
    }

    public final Integer component11() {
        return this.paddingRight;
    }

    public final Integer component12() {
        return this.paddingTop;
    }

    public final Integer component13() {
        return this.paddingBottom;
    }

    public final String component14() {
        return this.ellipsize;
    }

    public final List<ContentProps> component15() {
        return this.contentProps;
    }

    public final Boolean component16() {
        return this.atClickable;
    }

    public final Boolean component17() {
        return this.linkClickable;
    }

    public final Boolean component18() {
        return this.disableAtStyle;
    }

    public final Boolean component19() {
        return this.disableTagStyle;
    }

    public final String component2() {
        return this.parentId;
    }

    public final Boolean component20() {
        return this.disableNumberTagStyle;
    }

    public final Boolean component21() {
        return this.isTranslateElement;
    }

    public final Boolean component22() {
        return this.inTable;
    }

    public final String component3() {
        return this.textColor;
    }

    public final Integer component4() {
        return this.textSize;
    }

    public final String component5() {
        return this.bgColor;
    }

    public final Integer component6() {
        return this.maxLines;
    }

    public final Integer component7() {
        return this.textLines;
    }

    public final Float component8() {
        return this.lineSpacing;
    }

    public final String component9() {
        return this.align;
    }

    public final TextProps copy(String r210, String r211, String r212, Integer r213, String r214, Integer r310, Integer r311, Float r312, String r313, Integer r314, Integer r315, Integer r316, Integer r317, String r318, List<ContentProps> r319, Boolean r410, Boolean r411, Boolean r412, Boolean r413, Boolean r414, Boolean r415, Boolean r416) {
        return new TextProps(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextProps) == true) goto L8;
        return false;
    L8:
        TextProps r101 = (TextProps) r100;
        if (Intrinsics.areEqual(this.f283580id, r101.f283580id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textSize, r101.textSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxLines, r101.maxLines) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.textLines, r101.textLines) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lineSpacing, r101.lineSpacing) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.align, r101.align) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.paddingLeft, r101.paddingLeft) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.paddingRight, r101.paddingRight) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.paddingTop, r101.paddingTop) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.paddingBottom, r101.paddingBottom) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ellipsize, r101.ellipsize) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.contentProps, r101.contentProps) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.atClickable, r101.atClickable) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.linkClickable, r101.linkClickable) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.disableAtStyle, r101.disableAtStyle) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.disableTagStyle, r101.disableTagStyle) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.disableNumberTagStyle, r101.disableNumberTagStyle) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.isTranslateElement, r101.isTranslateElement) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.inTable, r101.inTable) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        String r100 = this.f283580id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.parentId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.textSize;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bgColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.maxLines;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.textLines;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.lineSpacing;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.align;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.paddingLeft;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.paddingRight;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.paddingTop;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.paddingBottom;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.ellipsize;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<ContentProps> r143 = this.contentProps;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.atClickable;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.linkClickable;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.disableAtStyle;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.disableTagStyle;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Boolean r158 = this.disableNumberTagStyle;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Boolean r161 = this.isTranslateElement;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        Boolean r164 = this.inTable;
        if (r164 == null) goto L91;
        r101 = r164.hashCode();
    L91:
        return r163 + r101;
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TextProps(id=" + this.f283580id + ", parentId=" + this.parentId + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", bgColor=" + this.bgColor + ", maxLines=" + this.maxLines + ", textLines=" + this.textLines + ", lineSpacing=" + this.lineSpacing + ", align=" + this.align + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", ellipsize=" + this.ellipsize + ", contentProps=" + this.contentProps + ", atClickable=" + this.atClickable + ", linkClickable=" + this.linkClickable + ", disableAtStyle=" + this.disableAtStyle + ", disableTagStyle=" + this.disableTagStyle + ", disableNumberTagStyle=" + this.disableNumberTagStyle + ", isTranslateElement=" + this.isTranslateElement + ", inTable=" + this.inTable + ')';
    }

    public final boolean isTranslate() {
        Boolean r100 = this.isTranslateElement;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final String getAlign() {
        return this.align;
    }

    public final Boolean getAtClickable() {
        return this.atClickable;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final List<ContentProps> getContentProps() {
        return this.contentProps;
    }

    public final Boolean getDisableAtStyle() {
        return this.disableAtStyle;
    }

    public final Boolean getDisableNumberTagStyle() {
        return this.disableNumberTagStyle;
    }

    public final Boolean getDisableTagStyle() {
        return this.disableTagStyle;
    }

    public final String getEllipsize() {
        return this.ellipsize;
    }

    public final String getId() {
        return this.f283580id;
    }

    public final Boolean getInTable() {
        return this.inTable;
    }

    public final Float getLineSpacing() {
        return this.lineSpacing;
    }

    public final Boolean getLinkClickable() {
        return this.linkClickable;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final Integer getPaddingBottom() {
        return this.paddingBottom;
    }

    public final Integer getPaddingLeft() {
        return this.paddingLeft;
    }

    public final Integer getPaddingRight() {
        return this.paddingRight;
    }

    public final Integer getPaddingTop() {
        return this.paddingTop;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Integer getTextLines() {
        return this.textLines;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public final Boolean isTranslateElement() {
        return this.isTranslateElement;
    }

    public TextProps(String r100, String r101, String r102, Integer r103, String r104, Integer r105, Integer r106, Float r110, String r111, Integer r112, Integer r113, Integer r114, Integer r115, String r116, List<ContentProps> r117, Boolean r118, Boolean r119, Boolean r210, Boolean r211, Boolean r212, Boolean r213, Boolean r214) {
        this.f283580id = r100;
        this.parentId = r101;
        this.textColor = r102;
        this.textSize = r103;
        this.bgColor = r104;
        this.maxLines = r105;
        this.textLines = r106;
        this.lineSpacing = r110;
        this.align = r111;
        this.paddingLeft = r112;
        this.paddingRight = r113;
        this.paddingTop = r114;
        this.paddingBottom = r115;
        this.ellipsize = r116;
        this.contentProps = r117;
        this.atClickable = r118;
        this.linkClickable = r119;
        this.disableAtStyle = r210;
        this.disableTagStyle = r211;
        this.disableNumberTagStyle = r212;
        this.isTranslateElement = r213;
        this.inTable = r214;
    }

    public /* synthetic */ TextProps(String r210, String r211, String r212, Integer r213, String r214, Integer r215, Integer r310, Float r311, String r312, Integer r313, Integer r314, Integer r315, Integer r316, String r317, List r318, Boolean r319, Boolean r410, Boolean r411, Boolean r412, Boolean r413, Boolean r414, Boolean r415, int r416, DefaultConstructorMarker r417) {
        if ((r416 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r416 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r416 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r416 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r416 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r416 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r416 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r416 & 128) == 0) goto L33;
        Float r107 = null;
    L35:
        if ((r416 & 256) == 0) goto L37;
        String r110 = "left";
    L39:
        if ((r416 & 512) == 0) goto L41;
        Integer r111 = 0;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        Integer r112 = 0;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        Integer r113 = 0;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        Integer r114 = 0;
    L55:
        if ((r416 & 8192) == 0) goto L57;
        String r115 = "end";
    L59:
        if ((r416 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r416 & 32768) == 0) goto L65;
        Boolean r116 = Boolean.TRUE;
    L67:
        if ((r416 & 65536) == 0) goto L69;
        Boolean r117 = Boolean.TRUE;
    L71:
        if ((r416 & 131072) == 0) goto L73;
        Boolean r118 = Boolean.FALSE;
    L75:
        if ((r416 & 262144) == 0) goto L77;
        Boolean r119 = Boolean.FALSE;
    L79:
        if ((r416 & 524288) == 0) goto L81;
        Boolean r216 = Boolean.FALSE;
    L83:
        if ((r416 & 1048576) == 0) goto L85;
        Boolean r217 = Boolean.FALSE;
    L87:
        if ((r416 & 2097152) == 0) goto L89;
        Boolean r109 = Boolean.FALSE;
    L90:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r216, r217, r109);
        return;
    L89:
        r109 = r415;
        goto L90
    L85:
        r217 = r414;
        goto L87
    L81:
        r216 = r413;
        goto L83
    L77:
        r119 = r412;
        goto L79
    L73:
        r118 = r411;
        goto L75
    L69:
        r117 = r410;
        goto L71
    L65:
        r116 = r319;
        goto L67
    L61:
        r108 = r318;
        goto L63
    L57:
        r115 = r317;
        goto L59
    L53:
        r114 = r316;
        goto L55
    L49:
        r113 = r315;
        goto L51
    L45:
        r112 = r314;
        goto L47
    L41:
        r111 = r313;
        goto L43
    L37:
        r110 = r312;
        goto L39
    L33:
        r107 = r311;
        goto L35
    L29:
        r106 = r310;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
