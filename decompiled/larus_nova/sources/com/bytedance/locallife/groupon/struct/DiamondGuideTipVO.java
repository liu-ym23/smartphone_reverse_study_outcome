package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.groupon.struct.bubble.model.BubbleButton;
import com.bytedance.locallife.groupon.struct.bubble.model.BubbleContent;
import com.bytedance.locallife.groupon.struct.bubble.model.ElementGuideBubbleStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J\u0006\u00102\u001a\u00020\u0018J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0019\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010HÆ\u0003J¡\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0005HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0016R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006E"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/DiamondGuideTipVO;", "", "style", "", "bubbleCategory", "", "liveSeconds", "button", "Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;", PickerReporterConstants.KEY.TARGET, "content", "Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;", "jumpUrl", "frequencyData", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "trackParams", "", "guideElement", "nodeTag", "cardType", "(Ljava/lang/String;IILcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)V", "getBubbleCategory", "()I", "bubbleStruct", "Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;", "getBubbleStruct", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;", "bubbleStruct$delegate", "Lkotlin/Lazy;", "getButton", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;", "getCardType", "setCardType", "(I)V", "getContent", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;", "getFrequencyData", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "getGuideElement", "()Ljava/lang/String;", "setGuideElement", "(Ljava/lang/String;)V", "getJumpUrl", "getLiveSeconds", "getNodeTag", "setNodeTag", "getStyle", "getTarget", "getTrackParams", "()Ljava/util/Map;", "asElementGuideBubbleStruct", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DiamondGuideTipVO {

    @SerializedName("bubble_category")
    private final int bubbleCategory;
    private final Lazy bubbleStruct$delegate;

    @SerializedName("button")
    private final BubbleButton button;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private int cardType;

    @SerializedName("content")
    private final BubbleContent content;

    @SerializedName("frequency_data")
    private final FrequencyInfo frequencyData;

    @SerializedName("guide_element")
    private String guideElement;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("live_seconds")
    private final int liveSeconds;

    @SerializedName("node_tag")
    private String nodeTag;

    @SerializedName("style")
    private final String style;

    @SerializedName(PickerReporterConstants.KEY.TARGET)
    private final String target;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public DiamondGuideTipVO() {
        this(null, 0, 0, null, null, null, null, null, null, null, null, 0, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiamondGuideTipVO copy$default(DiamondGuideTipVO r110, String r111, int r112, int r113, BubbleButton r114, String r115, BubbleContent r116, String r210, FrequencyInfo r211, Map r212, String r213, String r214, int r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.style;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.bubbleCategory;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.liveSeconds;
    L15:
        if ((r216 & 8) == 0) goto L17;
        BubbleButton r103 = r110.button;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.target;
    L23:
        if ((r216 & 32) == 0) goto L25;
        BubbleContent r105 = r110.content;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.jumpUrl;
    L31:
        if ((r216 & 128) == 0) goto L33;
        FrequencyInfo r107 = r110.frequencyData;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Map r117 = r110.trackParams;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.guideElement;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.nodeTag;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        int r108 = r110.cardType;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.style;
    }

    public final String component10() {
        return this.guideElement;
    }

    public final String component11() {
        return this.nodeTag;
    }

    public final int component12() {
        return this.cardType;
    }

    public final int component2() {
        return this.bubbleCategory;
    }

    public final int component3() {
        return this.liveSeconds;
    }

    public final BubbleButton component4() {
        return this.button;
    }

    public final String component5() {
        return this.target;
    }

    public final BubbleContent component6() {
        return this.content;
    }

    public final String component7() {
        return this.jumpUrl;
    }

    public final FrequencyInfo component8() {
        return this.frequencyData;
    }

    public final Map<String, Object> component9() {
        return this.trackParams;
    }

    public final DiamondGuideTipVO copy(String r110, int r111, int r112, BubbleButton r113, String r114, BubbleContent r210, String r211, FrequencyInfo r212, Map<String, ? extends Object> r213, String r214, String r215, int r216) {
        return new DiamondGuideTipVO(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DiamondGuideTipVO) == true) goto L8;
        return false;
    L8:
        DiamondGuideTipVO r101 = (DiamondGuideTipVO) r100;
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L12;
        return false;
    L12:
        if (this.bubbleCategory == r101.bubbleCategory) goto L15;
        return false;
    L15:
        if (this.liveSeconds == r101.liveSeconds) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.frequencyData, r101.frequencyData) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.guideElement, r101.guideElement) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.nodeTag, r101.nodeTag) == true) goto L42;
        return false;
    L42:
        if (this.cardType == r101.cardType) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.style;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.bubbleCategory) * 31) + this.liveSeconds) * 31;
        BubbleButton r104 = this.button;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.target;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        BubbleContent r110 = this.content;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.jumpUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        FrequencyInfo r116 = this.frequencyData;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.trackParams;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.guideElement;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.nodeTag;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return ((r124 + r101) * 31) + this.cardType;
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
        return "DiamondGuideTipVO(style=" + this.style + ", bubbleCategory=" + this.bubbleCategory + ", liveSeconds=" + this.liveSeconds + ", button=" + this.button + ", target=" + this.target + ", content=" + this.content + ", jumpUrl=" + this.jumpUrl + ", frequencyData=" + this.frequencyData + ", trackParams=" + this.trackParams + ", guideElement=" + this.guideElement + ", nodeTag=" + this.nodeTag + ", cardType=" + this.cardType + ')';
    }

    private final ElementGuideBubbleStruct getBubbleStruct() {
        return (ElementGuideBubbleStruct) this.bubbleStruct$delegate.getValue();
    }

    public final ElementGuideBubbleStruct asElementGuideBubbleStruct() {
        return getBubbleStruct();
    }

    public final int getBubbleCategory() {
        return this.bubbleCategory;
    }

    public final BubbleButton getButton() {
        return this.button;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final BubbleContent getContent() {
        return this.content;
    }

    public final FrequencyInfo getFrequencyData() {
        return this.frequencyData;
    }

    public final String getGuideElement() {
        return this.guideElement;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getLiveSeconds() {
        return this.liveSeconds;
    }

    public final String getNodeTag() {
        return this.nodeTag;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTarget() {
        return this.target;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final void setCardType(int r100) {
        this.cardType = r100;
    }

    public final void setGuideElement(String r100) {
        this.guideElement = r100;
    }

    public final void setNodeTag(String r100) {
        this.nodeTag = r100;
    }

    public DiamondGuideTipVO(String r100, int r101, int r102, BubbleButton r103, String r104, BubbleContent r105, String r106, FrequencyInfo r107, Map<String, ? extends Object> r108, String r110, String r111, int r112) {
        this.style = r100;
        this.bubbleCategory = r101;
        this.liveSeconds = r102;
        this.button = r103;
        this.target = r104;
        this.content = r105;
        this.jumpUrl = r106;
        this.frequencyData = r107;
        this.trackParams = r108;
        this.guideElement = r110;
        this.nodeTag = r111;
        this.cardType = r112;
        this.bubbleStruct$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DiamondGuideTipVO$bubbleStruct$2(this));
    }

    public /* synthetic */ DiamondGuideTipVO(String r110, int r111, int r112, BubbleButton r113, String r114, BubbleContent r210, String r211, FrequencyInfo r212, Map r213, String r214, String r215, int r216, int r217, DefaultConstructorMarker r218) {
        String r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        int r102 = 0;
        if ((r217 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r217 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r217 & 8) == 0) goto L17;
        BubbleButton r105 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r217 & 32) == 0) goto L25;
        BubbleContent r107 = null;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r217 & 128) == 0) goto L33;
        FrequencyInfo r115 = null;
    L35:
        if ((r217 & 256) == 0) goto L37;
        Map r116 = null;
    L39:
        if ((r217 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r217 & 1024) != 0) goto L47;
        r100 = r215;
    L47:
        if ((r217 & 2048) != 0) goto L50;
        r102 = r216;
    L50:
        this(r101, r103, r104, r105, r106, r107, r108, r115, r116, r117, r100, r102);
        return;
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
        goto L35
    L29:
        r108 = r211;
        goto L31
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
