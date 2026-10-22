package com.larus.common.venue.impl.venue.api;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006:"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/PocketPageData;", "", "pageId", "", "topPockets", "", "Lcom/larus/common/venue/impl/venue/api/Pocket;", "bottomPockets", "status", "", "showInputBox", "", RuleConditionBean.VERSION_CODE_KEY, "defaultSelectedPocketId", "configName", "iconUrl", "intentionWeight", "Lcom/larus/common/venue/impl/venue/api/IntentionWeightConfig;", OnekeyLoginConstants.CU_KEY_OPERATOR, UserInfo.UPDATE_TIME, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getPageId", "()Ljava/lang/String;", "getTopPockets", "()Ljava/util/List;", "getBottomPockets", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowInputBox", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVersionCode", "getDefaultSelectedPocketId", "getConfigName", "getIconUrl", "getIntentionWeight", "getOperator", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/PocketPageData;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PocketPageData {

    @SerializedName("bottom_pockets")
    private final List<Pocket> bottomPockets;

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("default_selected_pocket_id")
    private final String defaultSelectedPocketId;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("intention_weight")
    private final List<IntentionWeightConfig> intentionWeight;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    private final String operator;

    @SerializedName(a.KEY_PAGE_ID)
    private final String pageId;

    @SerializedName("show_input_box")
    private final Boolean showInputBox;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("top_pockets")
    private final List<Pocket> topPockets;

    @SerializedName("update_time")
    private final String updateTime;

    @SerializedName("version_code")
    private final String versionCode;

    public PocketPageData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PocketPageData copy$default(PocketPageData r110, String r111, List r112, List r113, Integer r114, Boolean r115, String r116, String r210, String r211, String r212, List r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.pageId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        List r101 = r110.topPockets;
    L11:
        if ((r216 & 4) == 0) goto L13;
        List r102 = r110.bottomPockets;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r103 = r110.status;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Boolean r104 = r110.showInputBox;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.versionCode;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.defaultSelectedPocketId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.configName;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.iconUrl;
    L39:
        if ((r216 & 512) == 0) goto L41;
        List r118 = r110.intentionWeight;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.operator;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.updateTime;
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
        return this.pageId;
    }

    public final List<IntentionWeightConfig> component10() {
        return this.intentionWeight;
    }

    public final String component11() {
        return this.operator;
    }

    public final String component12() {
        return this.updateTime;
    }

    public final List<Pocket> component2() {
        return this.topPockets;
    }

    public final List<Pocket> component3() {
        return this.bottomPockets;
    }

    public final Integer component4() {
        return this.status;
    }

    public final Boolean component5() {
        return this.showInputBox;
    }

    public final String component6() {
        return this.versionCode;
    }

    public final String component7() {
        return this.defaultSelectedPocketId;
    }

    public final String component8() {
        return this.configName;
    }

    public final String component9() {
        return this.iconUrl;
    }

    public final PocketPageData copy(String r110, List<Pocket> r111, List<Pocket> r112, Integer r113, Boolean r114, String r210, String r211, String r212, String r213, List<IntentionWeightConfig> r214, String r215, String r216) {
        return new PocketPageData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PocketPageData) == true) goto L8;
        return false;
    L8:
        PocketPageData r101 = (PocketPageData) r100;
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topPockets, r101.topPockets) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottomPockets, r101.bottomPockets) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showInputBox, r101.showInputBox) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.versionCode, r101.versionCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.defaultSelectedPocketId, r101.defaultSelectedPocketId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.configName, r101.configName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.intentionWeight, r101.intentionWeight) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.operator, r101.operator) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.pageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Pocket> r104 = this.topPockets;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Pocket> r107 = this.bottomPockets;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.showInputBox;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.versionCode;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.defaultSelectedPocketId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.configName;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.iconUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<IntentionWeightConfig> r128 = this.intentionWeight;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.operator;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.updateTime;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
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
        return "PocketPageData(pageId=" + this.pageId + ", topPockets=" + this.topPockets + ", bottomPockets=" + this.bottomPockets + ", status=" + this.status + ", showInputBox=" + this.showInputBox + ", versionCode=" + this.versionCode + ", defaultSelectedPocketId=" + this.defaultSelectedPocketId + ", configName=" + this.configName + ", iconUrl=" + this.iconUrl + ", intentionWeight=" + this.intentionWeight + ", operator=" + this.operator + ", updateTime=" + this.updateTime + ')';
    }

    public final List<Pocket> getBottomPockets() {
        return this.bottomPockets;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final String getDefaultSelectedPocketId() {
        return this.defaultSelectedPocketId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<IntentionWeightConfig> getIntentionWeight() {
        return this.intentionWeight;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final Boolean getShowInputBox() {
        return this.showInputBox;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final List<Pocket> getTopPockets() {
        return this.topPockets;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public PocketPageData(String r100, List<Pocket> r101, List<Pocket> r102, Integer r103, Boolean r104, String r105, String r106, String r107, String r108, List<IntentionWeightConfig> r110, String r111, String r112) {
        this.pageId = r100;
        this.topPockets = r101;
        this.bottomPockets = r102;
        this.status = r103;
        this.showInputBox = r104;
        this.versionCode = r105;
        this.defaultSelectedPocketId = r106;
        this.configName = r107;
        this.iconUrl = r108;
        this.intentionWeight = r110;
        this.operator = r111;
        this.updateTime = r112;
    }

    public /* synthetic */ PocketPageData(String r110, List r111, List r112, Integer r113, Boolean r114, String r115, String r210, String r211, String r212, List r213, String r214, String r215, int r216, DefaultConstructorMarker r217) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
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
        List r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
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
