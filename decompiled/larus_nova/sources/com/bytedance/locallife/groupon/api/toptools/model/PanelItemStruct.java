package com.bytedance.locallife.groupon.api.toptools.model;

import com.bytedance.locallife.groupon.struct.FrequencyInfo;
import com.bytedance.locallife.groupon.struct.bubble.model.TagDesc;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012HÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0010HÆ\u0003J¿\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007J\t\u0010=\u001a\u00020>HÖ\u0001J\u0006\u0010?\u001a\u00020\"J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001d¨\u0006A"}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/model/PanelItemStruct;", "", "showName", "", "title", "shortTitle", "entranceConfigList", "", "Lcom/bytedance/locallife/groupon/api/toptools/model/EntranceConfig;", SocialConstants.PARAM_APP_DESC, "Lcom/bytedance/locallife/groupon/struct/bubble/model/TagDesc;", "descExpiredTimestamp", "", "jumpUrl", "jumpTargetUrl", "frequencyData", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "trackParams", "", "descTrackParams", "btmDCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getBtmDCode", "()Ljava/lang/String;", "getDesc", "()Ljava/util/List;", "getDescExpiredTimestamp", "()J", "getDescTrackParams", "()Ljava/util/Map;", "getEntranceConfigList", "getFrequencyData", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "hasUndertaken", "", "getHasUndertaken", "()Z", "setHasUndertaken", "(Z)V", "getJumpTargetUrl", "getJumpUrl", "getShortTitle", "getShowName", "getTitle", "getTrackParams", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getValidDesc", "hashCode", "", "needJumpUndertake", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PanelItemStruct {

    @SerializedName("btm_d_code")
    private final String btmDCode;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final List<TagDesc> desc;

    @SerializedName("desc_expired_timestamp")
    private final long descExpiredTimestamp;

    @SerializedName("desc_track_params")
    private final Map<String, Object> descTrackParams;

    @SerializedName("entrance_config")
    private final List<EntranceConfig> entranceConfigList;

    @SerializedName("frequency_data")
    private final FrequencyInfo frequencyData;
    private boolean hasUndertaken;

    @SerializedName("jump_target_url")
    private final String jumpTargetUrl;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("short_title")
    private final String shortTitle;

    @SerializedName("show_name")
    private final String showName;

    @SerializedName("title")
    private final String title;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public PanelItemStruct() {
        this(null, null, null, null, null, 0, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PanelItemStruct copy$default(PanelItemStruct r110, String r111, String r112, String r113, List r114, List r115, long r210, String r211, String r212, FrequencyInfo r213, Map r214, Map r215, String r216, int r217, Object r218) {
        if ((r217 & 1) == 0) goto L5;
        String r100 = r110.showName;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r102 = r110.shortTitle;
    L15:
        if ((r217 & 8) == 0) goto L17;
        List r103 = r110.entranceConfigList;
    L19:
        if ((r217 & 16) == 0) goto L21;
        List r104 = r110.desc;
    L23:
        if ((r217 & 32) == 0) goto L25;
        long r105 = r110.descExpiredTimestamp;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r106 = r110.jumpUrl;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r116 = r110.jumpTargetUrl;
    L35:
        if ((r217 & 256) == 0) goto L37;
        FrequencyInfo r117 = r110.frequencyData;
    L39:
        if ((r217 & 512) == 0) goto L41;
        Map r118 = r110.trackParams;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        Map r119 = r110.descTrackParams;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        String r107 = r110.btmDCode;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r116, r117, r118, r119, r107);
    L49:
        r107 = r216;
        goto L51
    L45:
        r119 = r215;
        goto L47
    L41:
        r118 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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
        return this.showName;
    }

    public final Map<String, Object> component10() {
        return this.trackParams;
    }

    public final Map<String, Object> component11() {
        return this.descTrackParams;
    }

    public final String component12() {
        return this.btmDCode;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.shortTitle;
    }

    public final List<EntranceConfig> component4() {
        return this.entranceConfigList;
    }

    public final List<TagDesc> component5() {
        return this.desc;
    }

    public final long component6() {
        return this.descExpiredTimestamp;
    }

    public final String component7() {
        return this.jumpUrl;
    }

    public final String component8() {
        return this.jumpTargetUrl;
    }

    public final FrequencyInfo component9() {
        return this.frequencyData;
    }

    public final PanelItemStruct copy(String r110, String r111, String r112, List<EntranceConfig> r113, List<TagDesc> r210, long r211, String r212, String r213, FrequencyInfo r214, Map<String, ? extends Object> r215, Map<String, ? extends Object> r216, String r217) {
        return new PanelItemStruct(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PanelItemStruct) == true) goto L8;
        return false;
    L8:
        PanelItemStruct r101 = (PanelItemStruct) r100;
        if (Intrinsics.areEqual(this.showName, r101.showName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shortTitle, r101.shortTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entranceConfigList, r101.entranceConfigList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L24;
        return false;
    L24:
        if (this.descExpiredTimestamp == r101.descExpiredTimestamp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.jumpTargetUrl, r101.jumpTargetUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.frequencyData, r101.frequencyData) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.descTrackParams, r101.descTrackParams) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.btmDCode, r101.btmDCode) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.showName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shortTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<EntranceConfig> r110 = this.entranceConfigList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<TagDesc> r113 = this.desc;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.descExpiredTimestamp;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        String r118 = this.jumpUrl;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.jumpTargetUrl;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        FrequencyInfo r124 = this.frequencyData;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        Map<String, Object> r127 = this.trackParams;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        Map<String, Object> r130 = this.descTrackParams;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.btmDCode;
        if (r133 == null) goto L47;
        r101 = r133.hashCode();
    L47:
        return r132 + r101;
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
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
        return "PanelItemStruct(showName=" + this.showName + ", title=" + this.title + ", shortTitle=" + this.shortTitle + ", entranceConfigList=" + this.entranceConfigList + ", desc=" + this.desc + ", descExpiredTimestamp=" + this.descExpiredTimestamp + ", jumpUrl=" + this.jumpUrl + ", jumpTargetUrl=" + this.jumpTargetUrl + ", frequencyData=" + this.frequencyData + ", trackParams=" + this.trackParams + ", descTrackParams=" + this.descTrackParams + ", btmDCode=" + this.btmDCode + ')';
    }

    public final List<TagDesc> getValidDesc() {
        if (this.hasUndertaken == false) goto L6;
        return null;
    L6:
        if (this.desc != null) goto L8;
        return null;
    L8:
        long r100 = this.descExpiredTimestamp;
        if (r100 <= 0) goto L14;
        if ((r100 * 1000) > System.currentTimeMillis()) goto L14;
        return null;
    L14:
        return this.desc;
    }

    public final boolean needJumpUndertake() {
        List<TagDesc> r100 = getValidDesc();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final String getBtmDCode() {
        return this.btmDCode;
    }

    public final List<TagDesc> getDesc() {
        return this.desc;
    }

    public final long getDescExpiredTimestamp() {
        return this.descExpiredTimestamp;
    }

    public final Map<String, Object> getDescTrackParams() {
        return this.descTrackParams;
    }

    public final List<EntranceConfig> getEntranceConfigList() {
        return this.entranceConfigList;
    }

    public final FrequencyInfo getFrequencyData() {
        return this.frequencyData;
    }

    public final boolean getHasUndertaken() {
        return this.hasUndertaken;
    }

    public final String getJumpTargetUrl() {
        return this.jumpTargetUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getShortTitle() {
        return this.shortTitle;
    }

    public final String getShowName() {
        return this.showName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final void setHasUndertaken(boolean r100) {
        this.hasUndertaken = r100;
    }

    public PanelItemStruct(String r100, String r101, String r102, List<EntranceConfig> r103, List<TagDesc> r104, long r105, String r106, String r107, FrequencyInfo r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112, String r113) {
        this.showName = r100;
        this.title = r101;
        this.shortTitle = r102;
        this.entranceConfigList = r103;
        this.desc = r104;
        this.descExpiredTimestamp = r105;
        this.jumpUrl = r106;
        this.jumpTargetUrl = r107;
        this.frequencyData = r110;
        this.trackParams = r111;
        this.descTrackParams = r112;
        this.btmDCode = r113;
    }

    public /* synthetic */ PanelItemStruct(String r110, String r111, String r112, List r113, List r114, long r210, String r211, String r212, FrequencyInfo r213, Map r214, Map r215, String r216, int r217, DefaultConstructorMarker r218) {
        String r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        List r104 = CollectionsKt.emptyList();
    L19:
        if ((r217 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r217 & 32) == 0) goto L25;
        long r106 = 0;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r217 & 256) == 0) goto L37;
        FrequencyInfo r116 = null;
    L39:
        if ((r217 & 512) == 0) goto L41;
        Map r117 = null;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        Map r118 = null;
    L47:
        if ((r217 & 2048) != 0) goto L50;
        r100 = r216;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r100);
        return;
    L45:
        r118 = r215;
        goto L47
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
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
