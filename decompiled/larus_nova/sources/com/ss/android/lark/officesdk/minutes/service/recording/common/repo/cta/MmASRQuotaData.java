package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012(\b\u0002\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0013HÆ\u0003J)\u0010B\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0016HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003Jø\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132(\b\u0002\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020KHÖ\u0001J\t\u0010L\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u0005\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001dR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u000e\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u000f\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R6\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#¨\u0006M"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;", "Ljava/io/Serializable;", "usage", "", "amount", "isAdmin", "", "billUrl", "", "customerServiceUrl", "linkUrl", "ignoreUpgrade", "asrActionType", "canBuy", "isRequireAsrQuota", "isFreeTenant", "licensePlanKey", "billFeatureKey", "featureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "functionSceneBuyUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "benefitCenterUrl", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;Ljava/lang/String;)V", "getUsage", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAmount", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBillUrl", "()Ljava/lang/String;", "getCustomerServiceUrl", "getLinkUrl", "getIgnoreUpgrade", "getAsrActionType", "getCanBuy", "getLicensePlanKey", "getBillFeatureKey", "getFeatureDetail", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "getFunctionSceneBuyUrlMap", "()Ljava/util/HashMap;", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "getBenefitCenterUrl", "isExceed", "getRemainQuota", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmASRQuotaData implements Serializable {

    @SerializedName("amount")
    private final Long amount;

    @SerializedName("asr_action_type")
    private final Long asrActionType;

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("bill_feature_key")
    private final String billFeatureKey;

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("can_buy")
    private final Boolean canBuy;

    @SerializedName("customer_service_url")
    private final String customerServiceUrl;

    @SerializedName("feature_detail")
    private final MmFeatureDetail featureDetail;

    @SerializedName("function_scene_buy_url_map")
    private final HashMap<String, String> functionSceneBuyUrlMap;

    @SerializedName("ignore_upgrade")
    private final Boolean ignoreUpgrade;

    @SerializedName("is_admin")
    private final Boolean isAdmin;

    @SerializedName("is_free_tenant")
    private final Boolean isFreeTenant;

    @SerializedName("is_require_asr_quota")
    private final Boolean isRequireAsrQuota;

    @SerializedName("license_plan_key")
    private final String licensePlanKey;

    @SerializedName("link_url")
    private final String linkUrl;

    @SerializedName("unavailable_reason")
    private final MmUnavailableReason unavailableReason;

    @SerializedName("usage")
    private final Long usage;

    public MmASRQuotaData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmASRQuotaData copy$default(MmASRQuotaData r110, Long r111, Long r112, Boolean r210, String r211, String r212, String r213, Boolean r214, Long r215, Boolean r216, Boolean r217, Boolean r218, String r219, String r310, MmFeatureDetail r311, HashMap r312, MmUnavailableReason r313, String r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        Long r100 = r110.usage;
    L7:
        if ((r315 & 2) == 0) goto L9;
        Long r101 = r110.amount;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Boolean r102 = r110.isAdmin;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.billUrl;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = r110.customerServiceUrl;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.linkUrl;
    L27:
        if ((r315 & 64) == 0) goto L29;
        Boolean r106 = r110.ignoreUpgrade;
    L31:
        if ((r315 & 128) == 0) goto L33;
        Long r107 = r110.asrActionType;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Boolean r113 = r110.canBuy;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Boolean r114 = r110.isRequireAsrQuota;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Boolean r115 = r110.isFreeTenant;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.licensePlanKey;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.billFeatureKey;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        MmFeatureDetail r118 = r110.featureDetail;
    L58:
        MmFeatureDetail r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        HashMap r119 = r110.functionSceneBuyUrlMap;
    L62:
        HashMap r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        MmUnavailableReason r120 = r110.unavailableReason;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        String r108 = r110.benefitCenterUrl;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
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

    public final Long component1() {
        return this.usage;
    }

    public final Boolean component10() {
        return this.isRequireAsrQuota;
    }

    public final Boolean component11() {
        return this.isFreeTenant;
    }

    public final String component12() {
        return this.licensePlanKey;
    }

    public final String component13() {
        return this.billFeatureKey;
    }

    public final MmFeatureDetail component14() {
        return this.featureDetail;
    }

    public final HashMap<String, String> component15() {
        return this.functionSceneBuyUrlMap;
    }

    public final MmUnavailableReason component16() {
        return this.unavailableReason;
    }

    public final String component17() {
        return this.benefitCenterUrl;
    }

    public final Long component2() {
        return this.amount;
    }

    public final Boolean component3() {
        return this.isAdmin;
    }

    public final String component4() {
        return this.billUrl;
    }

    public final String component5() {
        return this.customerServiceUrl;
    }

    public final String component6() {
        return this.linkUrl;
    }

    public final Boolean component7() {
        return this.ignoreUpgrade;
    }

    public final Long component8() {
        return this.asrActionType;
    }

    public final Boolean component9() {
        return this.canBuy;
    }

    public final MmASRQuotaData copy(Long r210, Long r211, Boolean r212, String r213, String r214, String r215, Boolean r216, Long r217, Boolean r218, Boolean r219, Boolean r310, String r311, String r312, MmFeatureDetail r313, HashMap<String, String> r314, MmUnavailableReason r315, String r316) {
        return new MmASRQuotaData(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmASRQuotaData) == true) goto L8;
        return false;
    L8:
        MmASRQuotaData r101 = (MmASRQuotaData) r100;
        if (Intrinsics.areEqual(this.usage, r101.usage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isAdmin, r101.isAdmin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.billUrl, r101.billUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.customerServiceUrl, r101.customerServiceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.linkUrl, r101.linkUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ignoreUpgrade, r101.ignoreUpgrade) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.asrActionType, r101.asrActionType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.canBuy, r101.canBuy) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isRequireAsrQuota, r101.isRequireAsrQuota) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isFreeTenant, r101.isFreeTenant) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.licensePlanKey, r101.licensePlanKey) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.billFeatureKey, r101.billFeatureKey) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.featureDetail, r101.featureDetail) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.functionSceneBuyUrlMap, r101.functionSceneBuyUrlMap) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.unavailableReason, r101.unavailableReason) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.benefitCenterUrl, r101.benefitCenterUrl) == true) goto L59;
        return false;
    L59:
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
        Boolean r107 = this.isAdmin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.billUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.customerServiceUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.linkUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.ignoreUpgrade;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.asrActionType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.canBuy;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isRequireAsrQuota;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.isFreeTenant;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.licensePlanKey;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.billFeatureKey;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        MmFeatureDetail r140 = this.featureDetail;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        HashMap<String, String> r143 = this.functionSceneBuyUrlMap;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        MmUnavailableReason r146 = this.unavailableReason;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.benefitCenterUrl;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
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
        return "MmASRQuotaData(usage=" + this.usage + ", amount=" + this.amount + ", isAdmin=" + this.isAdmin + ", billUrl=" + this.billUrl + ", customerServiceUrl=" + this.customerServiceUrl + ", linkUrl=" + this.linkUrl + ", ignoreUpgrade=" + this.ignoreUpgrade + ", asrActionType=" + this.asrActionType + ", canBuy=" + this.canBuy + ", isRequireAsrQuota=" + this.isRequireAsrQuota + ", isFreeTenant=" + this.isFreeTenant + ", licensePlanKey=" + this.licensePlanKey + ", billFeatureKey=" + this.billFeatureKey + ", featureDetail=" + this.featureDetail + ", functionSceneBuyUrlMap=" + this.functionSceneBuyUrlMap + ", unavailableReason=" + this.unavailableReason + ", benefitCenterUrl=" + this.benefitCenterUrl + ')';
    }

    public final long getRemainQuota() {
        Long r100 = this.amount;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (this.usage == null) goto L7;
        return r100.longValue() - this.usage.longValue();
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

    public final Long getAsrActionType() {
        return this.asrActionType;
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

    public final String getCustomerServiceUrl() {
        return this.customerServiceUrl;
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

    public final String getLinkUrl() {
        return this.linkUrl;
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

    public MmASRQuotaData(Long r100, Long r101, Boolean r102, String r103, String r104, String r105, Boolean r106, Long r110, Boolean r111, Boolean r112, Boolean r113, String r114, String r115, MmFeatureDetail r116, HashMap<String, String> r117, MmUnavailableReason r118, String r119) {
        this.usage = r100;
        this.amount = r101;
        this.isAdmin = r102;
        this.billUrl = r103;
        this.customerServiceUrl = r104;
        this.linkUrl = r105;
        this.ignoreUpgrade = r106;
        this.asrActionType = r110;
        this.canBuy = r111;
        this.isRequireAsrQuota = r112;
        this.isFreeTenant = r113;
        this.licensePlanKey = r114;
        this.billFeatureKey = r115;
        this.featureDetail = r116;
        this.functionSceneBuyUrlMap = r117;
        this.unavailableReason = r118;
        this.benefitCenterUrl = r119;
    }

    public /* synthetic */ MmASRQuotaData(Long r110, Long r210, Boolean r211, String r212, String r213, String r214, Boolean r215, Long r216, Boolean r217, Boolean r218, Boolean r219, String r310, String r311, MmFeatureDetail r312, HashMap r313, MmUnavailableReason r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Boolean r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        Boolean r106 = Boolean.FALSE;
    L31:
        if ((r316 & 128) == 0) goto L33;
        Long r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Boolean r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Boolean r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Boolean r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        MmFeatureDetail r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        HashMap r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        MmUnavailableReason r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        String r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
