package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0015HÆ\u0003J)\u0010@\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018HÆ\u0003Jø\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0007\u0010!R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\t\u0010!R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\n\u0010!R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b'\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R6\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006I"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "Ljava/io/Serializable;", "aiAmount", "", "aiUsage", "asrAmount", "asrUsage", "isAIQuotaActive", "", "isASRQuotaActive", "isAIMinutesQuotaActive", "aiMinutesAmount", "aiMinutesUsage", "remainingAIQuota", "remainingAIMinutesQuota", "remainingASRQuota", "billUrl", "", "benefitCenterUrl", "aiMinutesQuotaStatus", "featureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "functionSceneBuyUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;)V", "getAiAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAiUsage", "getAsrAmount", "getAsrUsage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAiMinutesAmount", "getAiMinutesUsage", "getRemainingAIQuota", "getRemainingAIMinutesQuota", "getRemainingASRQuota", "getBillUrl", "()Ljava/lang/String;", "getBenefitCenterUrl", "getAiMinutesQuotaStatus", "getFeatureDetail", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "getFunctionSceneBuyUrlMap", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmDisplayQuotaData implements Serializable {

    @SerializedName("ai_amount")
    private final Long aiAmount;

    @SerializedName("ai_minutes_amount")
    private final Long aiMinutesAmount;

    @SerializedName("ai_minutes_quota_status")
    private final Long aiMinutesQuotaStatus;

    @SerializedName("ai_minutes_usage")
    private final Long aiMinutesUsage;

    @SerializedName("ai_usage")
    private final Long aiUsage;

    @SerializedName("asr_amount")
    private final Long asrAmount;

    @SerializedName("asr_usage")
    private final Long asrUsage;

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("feature_detail")
    private final MmFeatureDetail featureDetail;

    @SerializedName("function_scene_buy_url_map")
    private final HashMap<String, String> functionSceneBuyUrlMap;

    @SerializedName("is_ai_minutes_quota_active")
    private final Boolean isAIMinutesQuotaActive;

    @SerializedName("is_ai_quota_active")
    private final Boolean isAIQuotaActive;

    @SerializedName("is_asr_quota_active")
    private final Boolean isASRQuotaActive;

    @SerializedName("remaining_ai_minutes_quota")
    private final Long remainingAIMinutesQuota;

    @SerializedName("remaining_ai_quota")
    private final Long remainingAIQuota;

    @SerializedName("remaining_asr_quota")
    private final Long remainingASRQuota;

    public MmDisplayQuotaData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmDisplayQuotaData copy$default(MmDisplayQuotaData r110, Long r111, Long r112, Long r210, Long r211, Boolean r212, Boolean r213, Boolean r214, Long r215, Long r216, Long r217, Long r218, Long r219, String r310, String r311, Long r312, MmFeatureDetail r313, HashMap r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        Long r100 = r110.aiAmount;
    L7:
        if ((r315 & 2) == 0) goto L9;
        Long r101 = r110.aiUsage;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Long r102 = r110.asrAmount;
    L15:
        if ((r315 & 8) == 0) goto L17;
        Long r103 = r110.asrUsage;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Boolean r104 = r110.isAIQuotaActive;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Boolean r105 = r110.isASRQuotaActive;
    L27:
        if ((r315 & 64) == 0) goto L29;
        Boolean r106 = r110.isAIMinutesQuotaActive;
    L31:
        if ((r315 & 128) == 0) goto L33;
        Long r107 = r110.aiMinutesAmount;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Long r113 = r110.aiMinutesUsage;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Long r114 = r110.remainingAIQuota;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Long r115 = r110.remainingAIMinutesQuota;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Long r116 = r110.remainingASRQuota;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.billUrl;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        String r118 = r110.benefitCenterUrl;
    L58:
        String r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        Long r119 = r110.aiMinutesQuotaStatus;
    L62:
        Long r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        MmFeatureDetail r120 = r110.featureDetail;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        HashMap r108 = r110.functionSceneBuyUrlMap;
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
        return this.aiAmount;
    }

    public final Long component10() {
        return this.remainingAIQuota;
    }

    public final Long component11() {
        return this.remainingAIMinutesQuota;
    }

    public final Long component12() {
        return this.remainingASRQuota;
    }

    public final String component13() {
        return this.billUrl;
    }

    public final String component14() {
        return this.benefitCenterUrl;
    }

    public final Long component15() {
        return this.aiMinutesQuotaStatus;
    }

    public final MmFeatureDetail component16() {
        return this.featureDetail;
    }

    public final HashMap<String, String> component17() {
        return this.functionSceneBuyUrlMap;
    }

    public final Long component2() {
        return this.aiUsage;
    }

    public final Long component3() {
        return this.asrAmount;
    }

    public final Long component4() {
        return this.asrUsage;
    }

    public final Boolean component5() {
        return this.isAIQuotaActive;
    }

    public final Boolean component6() {
        return this.isASRQuotaActive;
    }

    public final Boolean component7() {
        return this.isAIMinutesQuotaActive;
    }

    public final Long component8() {
        return this.aiMinutesAmount;
    }

    public final Long component9() {
        return this.aiMinutesUsage;
    }

    public final MmDisplayQuotaData copy(Long r210, Long r211, Long r212, Long r213, Boolean r214, Boolean r215, Boolean r216, Long r217, Long r218, Long r219, Long r310, Long r311, String r312, String r313, Long r314, MmFeatureDetail r315, HashMap<String, String> r316) {
        return new MmDisplayQuotaData(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmDisplayQuotaData) == true) goto L8;
        return false;
    L8:
        MmDisplayQuotaData r101 = (MmDisplayQuotaData) r100;
        if (Intrinsics.areEqual(this.aiAmount, r101.aiAmount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aiUsage, r101.aiUsage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asrAmount, r101.asrAmount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asrUsage, r101.asrUsage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAIQuotaActive, r101.isAIQuotaActive) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isASRQuotaActive, r101.isASRQuotaActive) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isAIMinutesQuotaActive, r101.isAIMinutesQuotaActive) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.aiMinutesAmount, r101.aiMinutesAmount) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.aiMinutesUsage, r101.aiMinutesUsage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.remainingAIQuota, r101.remainingAIQuota) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.remainingAIMinutesQuota, r101.remainingAIMinutesQuota) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.remainingASRQuota, r101.remainingASRQuota) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.billUrl, r101.billUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.benefitCenterUrl, r101.benefitCenterUrl) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.aiMinutesQuotaStatus, r101.aiMinutesQuotaStatus) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.featureDetail, r101.featureDetail) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.functionSceneBuyUrlMap, r101.functionSceneBuyUrlMap) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        Long r100 = this.aiAmount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.aiUsage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.asrAmount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.asrUsage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isAIQuotaActive;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isASRQuotaActive;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isAIMinutesQuotaActive;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.aiMinutesAmount;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.aiMinutesUsage;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.remainingAIQuota;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.remainingAIMinutesQuota;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.remainingASRQuota;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.billUrl;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.benefitCenterUrl;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.aiMinutesQuotaStatus;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        MmFeatureDetail r146 = this.featureDetail;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        HashMap<String, String> r149 = this.functionSceneBuyUrlMap;
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
        return "MmDisplayQuotaData(aiAmount=" + this.aiAmount + ", aiUsage=" + this.aiUsage + ", asrAmount=" + this.asrAmount + ", asrUsage=" + this.asrUsage + ", isAIQuotaActive=" + this.isAIQuotaActive + ", isASRQuotaActive=" + this.isASRQuotaActive + ", isAIMinutesQuotaActive=" + this.isAIMinutesQuotaActive + ", aiMinutesAmount=" + this.aiMinutesAmount + ", aiMinutesUsage=" + this.aiMinutesUsage + ", remainingAIQuota=" + this.remainingAIQuota + ", remainingAIMinutesQuota=" + this.remainingAIMinutesQuota + ", remainingASRQuota=" + this.remainingASRQuota + ", billUrl=" + this.billUrl + ", benefitCenterUrl=" + this.benefitCenterUrl + ", aiMinutesQuotaStatus=" + this.aiMinutesQuotaStatus + ", featureDetail=" + this.featureDetail + ", functionSceneBuyUrlMap=" + this.functionSceneBuyUrlMap + ')';
    }

    public final Long getAiAmount() {
        return this.aiAmount;
    }

    public final Long getAiMinutesAmount() {
        return this.aiMinutesAmount;
    }

    public final Long getAiMinutesQuotaStatus() {
        return this.aiMinutesQuotaStatus;
    }

    public final Long getAiMinutesUsage() {
        return this.aiMinutesUsage;
    }

    public final Long getAiUsage() {
        return this.aiUsage;
    }

    public final Long getAsrAmount() {
        return this.asrAmount;
    }

    public final Long getAsrUsage() {
        return this.asrUsage;
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final String getBillUrl() {
        return this.billUrl;
    }

    public final MmFeatureDetail getFeatureDetail() {
        return this.featureDetail;
    }

    public final HashMap<String, String> getFunctionSceneBuyUrlMap() {
        return this.functionSceneBuyUrlMap;
    }

    public final Long getRemainingAIMinutesQuota() {
        return this.remainingAIMinutesQuota;
    }

    public final Long getRemainingAIQuota() {
        return this.remainingAIQuota;
    }

    public final Long getRemainingASRQuota() {
        return this.remainingASRQuota;
    }

    public final Boolean isAIMinutesQuotaActive() {
        return this.isAIMinutesQuotaActive;
    }

    public final Boolean isAIQuotaActive() {
        return this.isAIQuotaActive;
    }

    public final Boolean isASRQuotaActive() {
        return this.isASRQuotaActive;
    }

    public MmDisplayQuotaData(Long r100, Long r101, Long r102, Long r103, Boolean r104, Boolean r105, Boolean r106, Long r110, Long r111, Long r112, Long r113, Long r114, String r115, String r116, Long r117, MmFeatureDetail r118, HashMap<String, String> r119) {
        this.aiAmount = r100;
        this.aiUsage = r101;
        this.asrAmount = r102;
        this.asrUsage = r103;
        this.isAIQuotaActive = r104;
        this.isASRQuotaActive = r105;
        this.isAIMinutesQuotaActive = r106;
        this.aiMinutesAmount = r110;
        this.aiMinutesUsage = r111;
        this.remainingAIQuota = r112;
        this.remainingAIMinutesQuota = r113;
        this.remainingASRQuota = r114;
        this.billUrl = r115;
        this.benefitCenterUrl = r116;
        this.aiMinutesQuotaStatus = r117;
        this.featureDetail = r118;
        this.functionSceneBuyUrlMap = r119;
    }

    public /* synthetic */ MmDisplayQuotaData(Long r110, Long r210, Long r211, Long r212, Boolean r213, Boolean r214, Boolean r215, Long r216, Long r217, Long r218, Long r219, Long r310, String r311, String r312, Long r313, MmFeatureDetail r314, HashMap r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Boolean r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        Boolean r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        Long r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Long r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Long r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Long r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Long r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        Long r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        MmFeatureDetail r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        HashMap r109 = null;
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
