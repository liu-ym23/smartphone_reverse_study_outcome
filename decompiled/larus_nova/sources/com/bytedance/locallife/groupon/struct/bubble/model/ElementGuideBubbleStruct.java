package com.bytedance.locallife.groupon.struct.bubble.model;

import com.bytedance.locallife.groupon.struct.FrequencyInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0001FB\u0095\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bC\u0010DJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0097\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0002HÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b*\u0010)R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b.\u0010&R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b/\u0010&R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b3\u0010&R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106R*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u00109R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010$\u001a\u0004\b:\u0010&\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;", "", "", "component1", "", "component2", "component3", "Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;", "component4", "component5", "component6", "Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;", "component7", "component8", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "component9", "", "component10", "component11", "style", "bubbleCategory", "liveSeconds", "button", "moduleId", PickerReporterConstants.KEY.TARGET, "content", "jumpUrl", "frequencyData", "trackParams", "guideElement", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "I", "getBubbleCategory", "()I", "getLiveSeconds", "Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;", "getButton", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;", "getModuleId", "getTarget", "Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;", "getContent", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;", "getJumpUrl", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "getFrequencyData", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "getGuideElement", "setGuideElement", "(Ljava/lang/String;)V", "hasBorder", "Z", "getHasBorder", "()Z", "setHasBorder", "(Z)V", "<init>", "(Ljava/lang/String;IILcom/bytedance/locallife/groupon/struct/bubble/model/BubbleButton;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;Ljava/util/Map;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class ElementGuideBubbleStruct {
    public static final int CATEGORY_CARD_BUBBLE = 2;
    public static final int CATEGORY_COMMON_GUIDE_BUBBLE = 5;
    public static final int CATEGORY_ELEMENT_GENERAL_BUBBLE = 3;
    public static final int CATEGORY_FEED_TAB_BUBBLE = 4;
    public static final int CATEGORY_INTRO = 1;
    public static final a Companion = null;
    public static final String STYLE_COMMON_BUBBLE = "common_guide";
    public static final String STYLE_DUX_BUBBLE = "dux";
    public static final String STYLE_GUIDE_TIPS = "guide_tips";
    public static final String STYLE_ICON_TEXT_BUBBLE = "icon_text";
    public static final String STYLE_PLAIN = "plain";
    public static final String STYLE_RICH_TEXT = "rich_text";

    @SerializedName("bubble_category")
    private final int bubbleCategory;

    @SerializedName("button")
    private final BubbleButton button;

    @SerializedName("content")
    private final BubbleContent content;

    @SerializedName("frequency_data")
    private final FrequencyInfo frequencyData;

    @SerializedName("guide_element")
    private String guideElement;
    private boolean hasBorder;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("live_seconds")
    private final int liveSeconds;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("style")
    private final String style;

    @SerializedName(PickerReporterConstants.KEY.TARGET)
    private final String target;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ElementGuideBubbleStruct() {
        this(null, 0, 0, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElementGuideBubbleStruct copy$default(ElementGuideBubbleStruct r110, String r111, int r112, int r113, BubbleButton r114, String r115, String r116, BubbleContent r117, String r210, FrequencyInfo r211, Map r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.style;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r110.bubbleCategory;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r110.liveSeconds;
    L15:
        if ((r214 & 8) == 0) goto L17;
        BubbleButton r103 = r110.button;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.moduleId;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.target;
    L27:
        if ((r214 & 64) == 0) goto L29;
        BubbleContent r106 = r110.content;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.jumpUrl;
    L35:
        if ((r214 & 256) == 0) goto L37;
        FrequencyInfo r118 = r110.frequencyData;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Map r119 = r110.trackParams;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.guideElement;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
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

    public final Map<String, Object> component10() {
        return this.trackParams;
    }

    public final String component11() {
        return this.guideElement;
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
        return this.moduleId;
    }

    public final String component6() {
        return this.target;
    }

    public final BubbleContent component7() {
        return this.content;
    }

    public final String component8() {
        return this.jumpUrl;
    }

    public final FrequencyInfo component9() {
        return this.frequencyData;
    }

    public final ElementGuideBubbleStruct copy(String r110, int r111, int r112, BubbleButton r113, String r114, String r115, BubbleContent r210, String r211, FrequencyInfo r212, Map<String, ? extends Object> r213, String r214) {
        return new ElementGuideBubbleStruct(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ElementGuideBubbleStruct) == true) goto L8;
        return false;
    L8:
        ElementGuideBubbleStruct r101 = (ElementGuideBubbleStruct) r100;
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
        if (Intrinsics.areEqual(this.moduleId, r101.moduleId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.frequencyData, r101.frequencyData) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.guideElement, r101.guideElement) == true) goto L41;
        return false;
    L41:
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
        String r107 = this.moduleId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.target;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        BubbleContent r113 = this.content;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.jumpUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        FrequencyInfo r119 = this.frequencyData;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.trackParams;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.guideElement;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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
        return "ElementGuideBubbleStruct(style=" + this.style + ", bubbleCategory=" + this.bubbleCategory + ", liveSeconds=" + this.liveSeconds + ", button=" + this.button + ", moduleId=" + this.moduleId + ", target=" + this.target + ", content=" + this.content + ", jumpUrl=" + this.jumpUrl + ", frequencyData=" + this.frequencyData + ", trackParams=" + this.trackParams + ", guideElement=" + this.guideElement + ')';
    }

    public final int getBubbleCategory() {
        return this.bubbleCategory;
    }

    public final BubbleButton getButton() {
        return this.button;
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

    public final boolean getHasBorder() {
        return this.hasBorder;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getLiveSeconds() {
        return this.liveSeconds;
    }

    public final String getModuleId() {
        return this.moduleId;
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

    public final void setGuideElement(String r100) {
        this.guideElement = r100;
    }

    public final void setHasBorder(boolean r100) {
        this.hasBorder = r100;
    }

    public ElementGuideBubbleStruct(String r100, int r101, int r102, BubbleButton r103, String r104, String r105, BubbleContent r106, String r107, FrequencyInfo r108, Map<String, ? extends Object> r110, String r111) {
        this.style = r100;
        this.bubbleCategory = r101;
        this.liveSeconds = r102;
        this.button = r103;
        this.moduleId = r104;
        this.target = r105;
        this.content = r106;
        this.jumpUrl = r107;
        this.frequencyData = r108;
        this.trackParams = r110;
        this.guideElement = r111;
    }

    public /* synthetic */ ElementGuideBubbleStruct(String r110, int r111, int r112, BubbleButton r113, String r114, String r115, BubbleContent r116, String r210, FrequencyInfo r211, Map r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r103 = 3;
    L15:
        if ((r214 & 8) == 0) goto L17;
        BubbleButton r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        BubbleContent r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        FrequencyInfo r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Map r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
