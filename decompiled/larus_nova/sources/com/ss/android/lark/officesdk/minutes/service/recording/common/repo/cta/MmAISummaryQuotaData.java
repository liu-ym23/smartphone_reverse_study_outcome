package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012(\b\u0002\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u00103\u001a\u00020\bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0014HÆ\u0003J)\u0010A\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0017HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jò\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142(\b\u0002\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\t\u0010$R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\n\u0010$R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\u0010\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R6\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"¨\u0006L"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "Ljava/io/Serializable;", "usage", "", "amount", "billUrl", "", "canBuy", "", "isAdmin", "isRequireAsrQuota", "ignoreUpgrade", "showSuperAdmin", "superAdminList", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaDataSuperAdmin;", "isFreeTenant", "licensePlanKey", "billFeatureKey", "featureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "functionSceneBuyUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "benefitCenterUrl", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;Ljava/lang/String;)V", "getUsage", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAmount", "getBillUrl", "()Ljava/lang/String;", "getCanBuy", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIgnoreUpgrade", "getShowSuperAdmin", "getSuperAdminList", "()Ljava/util/List;", "getLicensePlanKey", "getBillFeatureKey", "getFeatureDetail", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "getFunctionSceneBuyUrlMap", "()Ljava/util/HashMap;", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "getBenefitCenterUrl", "isExceed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmAISummaryQuotaData implements Serializable {

    @SerializedName("amount")
    private final Long amount;

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("bill_feature_key")
    private final String billFeatureKey;

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("can_buy")
    private final Boolean canBuy;

    @SerializedName("feature_detail")
    private final MmFeatureDetail featureDetail;

    @SerializedName("function_scene_buy_url_map")
    private final HashMap<String, String> functionSceneBuyUrlMap;

    @SerializedName("ignore_upgrade")
    private final Boolean ignoreUpgrade;

    @SerializedName("is_super_admin")
    private final Boolean isAdmin;

    @SerializedName("is_free_tenant")
    private final Boolean isFreeTenant;

    @SerializedName("is_require_asr_quota")
    private final Boolean isRequireAsrQuota;

    @SerializedName("license_plan_key")
    private final String licensePlanKey;

    @SerializedName("show_super_admin")
    private final Boolean showSuperAdmin;

    @SerializedName("super_admin_list")
    private final List<MmQuotaDataSuperAdmin> superAdminList;

    @SerializedName("unavailable_reason")
    private final MmUnavailableReason unavailableReason;

    @SerializedName("usage")
    private final Long usage;

    public MmAISummaryQuotaData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmAISummaryQuotaData copy$default(MmAISummaryQuotaData r110, Long r111, Long r112, String r210, Boolean r211, Boolean r212, Boolean r213, Boolean r214, Boolean r215, List r216, Boolean r217, String r218, String r219, MmFeatureDetail r310, HashMap r311, MmUnavailableReason r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        Long r100 = r110.usage;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Long r101 = r110.amount;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.billUrl;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Boolean r103 = r110.canBuy;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Boolean r104 = r110.isAdmin;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Boolean r105 = r110.isRequireAsrQuota;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Boolean r106 = r110.ignoreUpgrade;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Boolean r107 = r110.showSuperAdmin;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r113 = r110.superAdminList;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Boolean r114 = r110.isFreeTenant;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.licensePlanKey;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r116 = r110.billFeatureKey;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        MmFeatureDetail r117 = r110.featureDetail;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        HashMap r118 = r110.functionSceneBuyUrlMap;
    L58:
        HashMap r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        MmUnavailableReason r119 = r110.unavailableReason;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.benefitCenterUrl;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
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

    public final Long component1() {
        return this.usage;
    }

    public final Boolean component10() {
        return this.isFreeTenant;
    }

    public final String component11() {
        return this.licensePlanKey;
    }

    public final String component12() {
        return this.billFeatureKey;
    }

    public final MmFeatureDetail component13() {
        return this.featureDetail;
    }

    public final HashMap<String, String> component14() {
        return this.functionSceneBuyUrlMap;
    }

    public final MmUnavailableReason component15() {
        return this.unavailableReason;
    }

    public final String component16() {
        return this.benefitCenterUrl;
    }

    public final Long component2() {
        return this.amount;
    }

    public final String component3() {
        return this.billUrl;
    }

    public final Boolean component4() {
        return this.canBuy;
    }

    public final Boolean component5() {
        return this.isAdmin;
    }

    public final Boolean component6() {
        return this.isRequireAsrQuota;
    }

    public final Boolean component7() {
        return this.ignoreUpgrade;
    }

    public final Boolean component8() {
        return this.showSuperAdmin;
    }

    public final List<MmQuotaDataSuperAdmin> component9() {
        return this.superAdminList;
    }

    public final MmAISummaryQuotaData copy(Long r110, Long r210, String r211, Boolean r212, Boolean r213, Boolean r214, Boolean r215, Boolean r216, List<MmQuotaDataSuperAdmin> r217, Boolean r218, String r219, String r310, MmFeatureDetail r311, HashMap<String, String> r312, MmUnavailableReason r313, String r314) {
        return new MmAISummaryQuotaData(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmAISummaryQuotaData) == true) goto L8;
        return false;
    L8:
        MmAISummaryQuotaData r101 = (MmAISummaryQuotaData) r100;
        if (Intrinsics.areEqual(this.usage, r101.usage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.billUrl, r101.billUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.canBuy, r101.canBuy) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAdmin, r101.isAdmin) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isRequireAsrQuota, r101.isRequireAsrQuota) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ignoreUpgrade, r101.ignoreUpgrade) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.showSuperAdmin, r101.showSuperAdmin) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.superAdminList, r101.superAdminList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isFreeTenant, r101.isFreeTenant) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.licensePlanKey, r101.licensePlanKey) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.billFeatureKey, r101.billFeatureKey) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.featureDetail, r101.featureDetail) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.functionSceneBuyUrlMap, r101.functionSceneBuyUrlMap) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.unavailableReason, r101.unavailableReason) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.benefitCenterUrl, r101.benefitCenterUrl) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        Long r100 = this.usage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.amount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.billUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.canBuy;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isAdmin;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isRequireAsrQuota;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.ignoreUpgrade;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.showSuperAdmin;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<MmQuotaDataSuperAdmin> r125 = this.superAdminList;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isFreeTenant;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.licensePlanKey;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.billFeatureKey;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        MmFeatureDetail r137 = this.featureDetail;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        HashMap<String, String> r140 = this.functionSceneBuyUrlMap;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        MmUnavailableReason r143 = this.unavailableReason;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.benefitCenterUrl;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
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
        return "MmAISummaryQuotaData(usage=" + this.usage + ", amount=" + this.amount + ", billUrl=" + this.billUrl + ", canBuy=" + this.canBuy + ", isAdmin=" + this.isAdmin + ", isRequireAsrQuota=" + this.isRequireAsrQuota + ", ignoreUpgrade=" + this.ignoreUpgrade + ", showSuperAdmin=" + this.showSuperAdmin + ", superAdminList=" + this.superAdminList + ", isFreeTenant=" + this.isFreeTenant + ", licensePlanKey=" + this.licensePlanKey + ", billFeatureKey=" + this.billFeatureKey + ", featureDetail=" + this.featureDetail + ", functionSceneBuyUrlMap=" + this.functionSceneBuyUrlMap + ", unavailableReason=" + this.unavailableReason + ", benefitCenterUrl=" + this.benefitCenterUrl + ')';
    }

    public final boolean isExceed() {
        Long r100 = this.usage;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.amount == null) goto L9;
        if (r100.longValue() < this.amount.longValue()) goto L9;
        return true;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final String getBillFeatureKey() {
        return this.billFeatureKey;
    }

    public final String getBillUrl() {
        return this.billUrl;
    }

    public final Boolean getCanBuy() {
        return this.canBuy;
    }

    public final MmFeatureDetail getFeatureDetail() {
        return this.featureDetail;
    }

    public final HashMap<String, String> getFunctionSceneBuyUrlMap() {
        return this.functionSceneBuyUrlMap;
    }

    public final Boolean getIgnoreUpgrade() {
        return this.ignoreUpgrade;
    }

    public final String getLicensePlanKey() {
        return this.licensePlanKey;
    }

    public final Boolean getShowSuperAdmin() {
        return this.showSuperAdmin;
    }

    public final List<MmQuotaDataSuperAdmin> getSuperAdminList() {
        return this.superAdminList;
    }

    public final MmUnavailableReason getUnavailableReason() {
        return this.unavailableReason;
    }

    public final Long getUsage() {
        return this.usage;
    }

    public final Boolean isAdmin() {
        return this.isAdmin;
    }

    public final Boolean isFreeTenant() {
        return this.isFreeTenant;
    }

    public final Boolean isRequireAsrQuota() {
        return this.isRequireAsrQuota;
    }

    public MmAISummaryQuotaData(Long r100, Long r101, String r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, Boolean r110, List<MmQuotaDataSuperAdmin> r111, Boolean r112, String r113, String r114, MmFeatureDetail r115, HashMap<String, String> r116, MmUnavailableReason r117, String r118) {
        this.usage = r100;
        this.amount = r101;
        this.billUrl = r102;
        this.canBuy = r103;
        this.isAdmin = r104;
        this.isRequireAsrQuota = r105;
        this.ignoreUpgrade = r106;
        this.showSuperAdmin = r110;
        this.superAdminList = r111;
        this.isFreeTenant = r112;
        this.licensePlanKey = r113;
        this.billFeatureKey = r114;
        this.featureDetail = r115;
        this.functionSceneBuyUrlMap = r116;
        this.unavailableReason = r117;
        this.benefitCenterUrl = r118;
    }

    public /* synthetic */ MmAISummaryQuotaData(Long r110, Long r111, String r210, Boolean r211, Boolean r212, Boolean r213, Boolean r214, Boolean r215, List r216, Boolean r217, String r218, String r219, MmFeatureDetail r310, HashMap r311, MmUnavailableReason r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Boolean r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Boolean r106 = Boolean.FALSE;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Boolean r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Boolean r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        MmFeatureDetail r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        HashMap r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        MmUnavailableReason r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
