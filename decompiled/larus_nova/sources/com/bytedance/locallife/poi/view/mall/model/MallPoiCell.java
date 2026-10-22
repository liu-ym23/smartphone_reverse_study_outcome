package com.bytedance.locallife.poi.view.mall.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u0015J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010&J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J¨\u0001\u0010:\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0013HÖ\u0001J\t\u0010@\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,¨\u0006A"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/MallPoiCell;", "Ljava/io/Serializable;", "highReviews", "", "Lcom/bytedance/locallife/poi/view/mall/model/HighlightVideoReviews;", "tabId", "", "poiInfo", "Lcom/bytedance/locallife/poi/view/mall/model/MallPoiInfo;", "recommendPercentTag", "", "poiLabel", "spuInfo", "Lcom/bytedance/locallife/poi/view/mall/model/CommonSpuInfo;", "sortId", "reqId", "sortSessionId", "distanceM", "showLabel", "", "hasMobShow", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/bytedance/locallife/poi/view/mall/model/MallPoiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getDistanceM", "()Ljava/lang/String;", "getHasMobShow", "()Z", "setHasMobShow", "(Z)V", "getHighReviews", "()Ljava/util/List;", "getPoiInfo", "()Lcom/bytedance/locallife/poi/view/mall/model/MallPoiInfo;", "getPoiLabel", "getRecommendPercentTag", "setRecommendPercentTag", "(Ljava/lang/String;)V", "getReqId", "getShowLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSortId", "getSortSessionId", "getSpuInfo", "getTabId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/bytedance/locallife/poi/view/mall/model/MallPoiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/bytedance/locallife/poi/view/mall/model/MallPoiCell;", "equals", "other", "", "hashCode", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MallPoiCell implements Serializable {

    @SerializedName("distance_val")
    private final String distanceM;
    private boolean hasMobShow;

    @SerializedName("highlight_video_reviews")
    private final List<HighlightVideoReviews> highReviews;

    @SerializedName("poi_info")
    private final MallPoiInfo poiInfo;

    @SerializedName("poi_label")
    private final String poiLabel;

    @SerializedName("recommend_percent_tag")
    private String recommendPercentTag;

    @SerializedName("sort_req_id")
    private final String reqId;

    @SerializedName("poi_label_show")
    private final Integer showLabel;

    @SerializedName("sort_id")
    private final String sortId;

    @SerializedName("sort_session_id")
    private final String sortSessionId;

    @SerializedName("spu_infos")
    private final List<CommonSpuInfo> spuInfo;

    @SerializedName("need_br")
    private final Boolean tabId;

    public MallPoiCell() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallPoiCell copy$default(MallPoiCell r110, List r111, Boolean r112, MallPoiInfo r113, String r114, String r115, List r116, String r210, String r211, String r212, String r213, Integer r214, boolean r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        List r100 = r110.highReviews;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Boolean r101 = r110.tabId;
    L11:
        if ((r216 & 4) == 0) goto L13;
        MallPoiInfo r102 = r110.poiInfo;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.recommendPercentTag;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.poiLabel;
    L23:
        if ((r216 & 32) == 0) goto L25;
        List r105 = r110.spuInfo;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.sortId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.reqId;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.sortSessionId;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.distanceM;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r119 = r110.showLabel;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        boolean r108 = r110.hasMobShow;
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

    public final List<HighlightVideoReviews> component1() {
        return this.highReviews;
    }

    public final String component10() {
        return this.distanceM;
    }

    public final Integer component11() {
        return this.showLabel;
    }

    public final boolean component12() {
        return this.hasMobShow;
    }

    public final Boolean component2() {
        return this.tabId;
    }

    public final MallPoiInfo component3() {
        return this.poiInfo;
    }

    public final String component4() {
        return this.recommendPercentTag;
    }

    public final String component5() {
        return this.poiLabel;
    }

    public final List<CommonSpuInfo> component6() {
        return this.spuInfo;
    }

    public final String component7() {
        return this.sortId;
    }

    public final String component8() {
        return this.reqId;
    }

    public final String component9() {
        return this.sortSessionId;
    }

    public final MallPoiCell copy(List<HighlightVideoReviews> r110, Boolean r111, MallPoiInfo r112, String r113, String r114, List<CommonSpuInfo> r210, String r211, String r212, String r213, String r214, Integer r215, boolean r216) {
        return new MallPoiCell(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MallPoiCell) == true) goto L8;
        return false;
    L8:
        MallPoiCell r101 = (MallPoiCell) r100;
        if (Intrinsics.areEqual(this.highReviews, r101.highReviews) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.poiInfo, r101.poiInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendPercentTag, r101.recommendPercentTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiLabel, r101.poiLabel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.spuInfo, r101.spuInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sortId, r101.sortId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sortSessionId, r101.sortSessionId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.distanceM, r101.distanceM) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.showLabel, r101.showLabel) == true) goto L42;
        return false;
    L42:
        if (this.hasMobShow == r101.hasMobShow) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        List<HighlightVideoReviews> r100 = this.highReviews;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.tabId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        MallPoiInfo r107 = this.poiInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.recommendPercentTag;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.poiLabel;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<CommonSpuInfo> r116 = this.spuInfo;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.sortId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.reqId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.sortSessionId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.distanceM;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.showLabel;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        int r132 = (r130 + r101) * 31;
        if (this.hasMobShow == false) goto L49;
        int r133 = 1231;
    L51:
        return r132 + r133;
    L49:
        r133 = 1237;
        goto L51
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
        return "MallPoiCell(highReviews=" + this.highReviews + ", tabId=" + this.tabId + ", poiInfo=" + this.poiInfo + ", recommendPercentTag=" + this.recommendPercentTag + ", poiLabel=" + this.poiLabel + ", spuInfo=" + this.spuInfo + ", sortId=" + this.sortId + ", reqId=" + this.reqId + ", sortSessionId=" + this.sortSessionId + ", distanceM=" + this.distanceM + ", showLabel=" + this.showLabel + ", hasMobShow=" + this.hasMobShow + ')';
    }

    public final String getDistanceM() {
        return this.distanceM;
    }

    public final boolean getHasMobShow() {
        return this.hasMobShow;
    }

    public final List<HighlightVideoReviews> getHighReviews() {
        return this.highReviews;
    }

    public final MallPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final String getPoiLabel() {
        return this.poiLabel;
    }

    public final String getRecommendPercentTag() {
        return this.recommendPercentTag;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final Integer getShowLabel() {
        return this.showLabel;
    }

    public final String getSortId() {
        return this.sortId;
    }

    public final String getSortSessionId() {
        return this.sortSessionId;
    }

    public final List<CommonSpuInfo> getSpuInfo() {
        return this.spuInfo;
    }

    public final Boolean getTabId() {
        return this.tabId;
    }

    public final void setHasMobShow(boolean r100) {
        this.hasMobShow = r100;
    }

    public final void setRecommendPercentTag(String r100) {
        this.recommendPercentTag = r100;
    }

    public MallPoiCell(List<HighlightVideoReviews> r100, Boolean r101, MallPoiInfo r102, String r103, String r104, List<CommonSpuInfo> r105, String r106, String r107, String r108, String r110, Integer r111, boolean r112) {
        this.highReviews = r100;
        this.tabId = r101;
        this.poiInfo = r102;
        this.recommendPercentTag = r103;
        this.poiLabel = r104;
        this.spuInfo = r105;
        this.sortId = r106;
        this.reqId = r107;
        this.sortSessionId = r108;
        this.distanceM = r110;
        this.showLabel = r111;
        this.hasMobShow = r112;
    }

    public /* synthetic */ MallPoiCell(List r110, Boolean r111, MallPoiInfo r112, String r113, String r114, List r115, String r210, String r211, String r212, String r213, Integer r214, boolean r215, int r216, DefaultConstructorMarker r217) {
        Integer r100 = null;
        if ((r216 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Boolean r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        MallPoiInfo r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r117 = "-1";
    L43:
        if ((r216 & 1024) != 0) goto L47;
        r100 = r214;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        boolean r109 = false;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r100, r109);
        return;
    L49:
        r109 = r215;
        goto L50
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
