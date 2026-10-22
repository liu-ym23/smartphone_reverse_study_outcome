package com.ss.android.ugc.aweme.poi.coi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003J¼\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0010\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019¨\u00068"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;", "Ljava/io/Serializable;", "coiDisplayAB", "", "locationAnchorInfo", "", "", "singleLocationInfo", "titleGroup", "Lcom/ss/android/ugc/aweme/poi/coi/CoiCellTypeInfo;", "subtitleGroup", "infoGroup", "recGroup", "ratingGroup", "mobInfo", "Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayMobiInfo;", "isLive", "", "liveInfo", "Lcom/ss/android/ugc/aweme/poi/coi/LiveInfo;", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayMobiInfo;Ljava/lang/Boolean;Lcom/ss/android/ugc/aweme/poi/coi/LiveInfo;)V", "getCoiDisplayAB", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInfoGroup", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLiveInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/LiveInfo;", "getLocationAnchorInfo", "getMobInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayMobiInfo;", "getRatingGroup", "getRecGroup", "getSingleLocationInfo", "getSubtitleGroup", "getTitleGroup", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayMobiInfo;Ljava/lang/Boolean;Lcom/ss/android/ugc/aweme/poi/coi/LiveInfo;)Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;", "equals", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CoiDisplayInfo implements Serializable {

    @SerializedName("coi_display_strategy")
    private final Integer coiDisplayAB;

    @SerializedName("info_group")
    private final List<CoiCellTypeInfo> infoGroup;

    @SerializedName("is_live")
    private final Boolean isLive;

    @SerializedName("live_info")
    private final LiveInfo liveInfo;

    @SerializedName("location_anchor_texts")
    private final List<String> locationAnchorInfo;

    @SerializedName("mob_info")
    private final CoiDisplayMobiInfo mobInfo;

    @SerializedName("rating_group")
    private final List<CoiCellTypeInfo> ratingGroup;

    @SerializedName("single_coi_middle_line_group")
    private final List<CoiCellTypeInfo> recGroup;

    @SerializedName("single_location_text")
    private final List<String> singleLocationInfo;

    @SerializedName("subtitle_group")
    private final List<CoiCellTypeInfo> subtitleGroup;

    @SerializedName("title_group")
    private final List<CoiCellTypeInfo> titleGroup;

    public CoiDisplayInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoiDisplayInfo copy$default(CoiDisplayInfo r110, Integer r111, List r112, List r113, List r114, List r115, List r116, List r117, List r210, CoiDisplayMobiInfo r211, Boolean r212, LiveInfo r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Integer r100 = r110.coiDisplayAB;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r101 = r110.locationAnchorInfo;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r102 = r110.singleLocationInfo;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r103 = r110.titleGroup;
    L19:
        if ((r214 & 16) == 0) goto L21;
        List r104 = r110.subtitleGroup;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List r105 = r110.infoGroup;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r106 = r110.recGroup;
    L31:
        if ((r214 & 128) == 0) goto L33;
        List r107 = r110.ratingGroup;
    L35:
        if ((r214 & 256) == 0) goto L37;
        CoiDisplayMobiInfo r118 = r110.mobInfo;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Boolean r119 = r110.isLive;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        LiveInfo r108 = r110.liveInfo;
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

    public final Integer component1() {
        return this.coiDisplayAB;
    }

    public final Boolean component10() {
        return this.isLive;
    }

    public final LiveInfo component11() {
        return this.liveInfo;
    }

    public final List<String> component2() {
        return this.locationAnchorInfo;
    }

    public final List<String> component3() {
        return this.singleLocationInfo;
    }

    public final List<CoiCellTypeInfo> component4() {
        return this.titleGroup;
    }

    public final List<CoiCellTypeInfo> component5() {
        return this.subtitleGroup;
    }

    public final List<CoiCellTypeInfo> component6() {
        return this.infoGroup;
    }

    public final List<CoiCellTypeInfo> component7() {
        return this.recGroup;
    }

    public final List<CoiCellTypeInfo> component8() {
        return this.ratingGroup;
    }

    public final CoiDisplayMobiInfo component9() {
        return this.mobInfo;
    }

    public final CoiDisplayInfo copy(Integer r110, List<String> r111, List<String> r112, List<CoiCellTypeInfo> r113, List<CoiCellTypeInfo> r114, List<CoiCellTypeInfo> r115, List<CoiCellTypeInfo> r210, List<CoiCellTypeInfo> r211, CoiDisplayMobiInfo r212, Boolean r213, LiveInfo r214) {
        return new CoiDisplayInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoiDisplayInfo) == true) goto L8;
        return false;
    L8:
        CoiDisplayInfo r101 = (CoiDisplayInfo) r100;
        if (Intrinsics.areEqual(this.coiDisplayAB, r101.coiDisplayAB) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.locationAnchorInfo, r101.locationAnchorInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.singleLocationInfo, r101.singleLocationInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleGroup, r101.titleGroup) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subtitleGroup, r101.subtitleGroup) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.infoGroup, r101.infoGroup) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.recGroup, r101.recGroup) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ratingGroup, r101.ratingGroup) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.mobInfo, r101.mobInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isLive, r101.isLive) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.liveInfo, r101.liveInfo) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.coiDisplayAB;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.locationAnchorInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.singleLocationInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<CoiCellTypeInfo> r110 = this.titleGroup;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<CoiCellTypeInfo> r113 = this.subtitleGroup;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<CoiCellTypeInfo> r116 = this.infoGroup;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<CoiCellTypeInfo> r119 = this.recGroup;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<CoiCellTypeInfo> r122 = this.ratingGroup;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        CoiDisplayMobiInfo r125 = this.mobInfo;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isLive;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        LiveInfo r131 = this.liveInfo;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "CoiDisplayInfo(coiDisplayAB=" + this.coiDisplayAB + ", locationAnchorInfo=" + this.locationAnchorInfo + ", singleLocationInfo=" + this.singleLocationInfo + ", titleGroup=" + this.titleGroup + ", subtitleGroup=" + this.subtitleGroup + ", infoGroup=" + this.infoGroup + ", recGroup=" + this.recGroup + ", ratingGroup=" + this.ratingGroup + ", mobInfo=" + this.mobInfo + ", isLive=" + this.isLive + ", liveInfo=" + this.liveInfo + ')';
    }

    public final Integer getCoiDisplayAB() {
        return this.coiDisplayAB;
    }

    public final List<CoiCellTypeInfo> getInfoGroup() {
        return this.infoGroup;
    }

    public final LiveInfo getLiveInfo() {
        return this.liveInfo;
    }

    public final List<String> getLocationAnchorInfo() {
        return this.locationAnchorInfo;
    }

    public final CoiDisplayMobiInfo getMobInfo() {
        return this.mobInfo;
    }

    public final List<CoiCellTypeInfo> getRatingGroup() {
        return this.ratingGroup;
    }

    public final List<CoiCellTypeInfo> getRecGroup() {
        return this.recGroup;
    }

    public final List<String> getSingleLocationInfo() {
        return this.singleLocationInfo;
    }

    public final List<CoiCellTypeInfo> getSubtitleGroup() {
        return this.subtitleGroup;
    }

    public final List<CoiCellTypeInfo> getTitleGroup() {
        return this.titleGroup;
    }

    public final Boolean isLive() {
        return this.isLive;
    }

    public CoiDisplayInfo(Integer r100, List<String> r101, List<String> r102, List<CoiCellTypeInfo> r103, List<CoiCellTypeInfo> r104, List<CoiCellTypeInfo> r105, List<CoiCellTypeInfo> r106, List<CoiCellTypeInfo> r107, CoiDisplayMobiInfo r108, Boolean r110, LiveInfo r111) {
        this.coiDisplayAB = r100;
        this.locationAnchorInfo = r101;
        this.singleLocationInfo = r102;
        this.titleGroup = r103;
        this.subtitleGroup = r104;
        this.infoGroup = r105;
        this.recGroup = r106;
        this.ratingGroup = r107;
        this.mobInfo = r108;
        this.isLive = r110;
        this.liveInfo = r111;
    }

    public /* synthetic */ CoiDisplayInfo(Integer r110, List r111, List r112, List r113, List r114, List r115, List r116, List r210, CoiDisplayMobiInfo r211, Boolean r212, LiveInfo r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        Integer r100 = 0;
    L6:
        LiveInfo r101 = null;
        if ((r214 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        CoiDisplayMobiInfo r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Boolean r118 = Boolean.FALSE;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r101 = r213;
    L46:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r117, r118, r101);
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
        r100 = r110;
        goto L6
    }
}
