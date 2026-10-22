package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u0017J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaData;", "Ljava/io/Serializable;", "aiQuota", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "asrQuota", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;", "displayQuota", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "mempopeDeviceBonusPopup", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;)V", "getAiQuota", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "getAsrQuota", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;", "getDisplayQuota", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "getMempopeDeviceBonusPopup", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;", "isAdmin", "", "quotaType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaType;", "getBillUrl", "", "functionScene", "getBenefitCenterUrl", "getFeatureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmQuotaData implements Serializable {

    @SerializedName("ai_quota")
    private final MmAISummaryQuotaData aiQuota;

    @SerializedName("asr_quota")
    private final MmASRQuotaData asrQuota;

    @SerializedName("display_quota")
    private final MmDisplayQuotaData displayQuota;

    @SerializedName("mempope_device_bonus_popup")
    private final MmMempopeDeviceBonusPopup mempopeDeviceBonusPopup;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434898a = null;

        static {
            int[] r100 = new int[MmQuotaType.values().length];
            r100[MmQuotaType.AI_SUMMARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MmQuotaType.ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MmQuotaType.MempopeDeviceBonus.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f434898a = r100;
        }
    }

    public MmQuotaData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MmQuotaData copy$default(MmQuotaData r100, MmAISummaryQuotaData r101, MmASRQuotaData r102, MmDisplayQuotaData r103, MmMempopeDeviceBonusPopup r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.aiQuota;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.asrQuota;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.displayQuota;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.mempopeDeviceBonusPopup;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final MmAISummaryQuotaData component1() {
        return this.aiQuota;
    }

    public final MmASRQuotaData component2() {
        return this.asrQuota;
    }

    public final MmDisplayQuotaData component3() {
        return this.displayQuota;
    }

    public final MmMempopeDeviceBonusPopup component4() {
        return this.mempopeDeviceBonusPopup;
    }

    public final MmQuotaData copy(MmAISummaryQuotaData r100, MmASRQuotaData r101, MmDisplayQuotaData r102, MmMempopeDeviceBonusPopup r103) {
        return new MmQuotaData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmQuotaData) == true) goto L8;
        return false;
    L8:
        MmQuotaData r101 = (MmQuotaData) r100;
        if (Intrinsics.areEqual(this.aiQuota, r101.aiQuota) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrQuota, r101.asrQuota) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayQuota, r101.displayQuota) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mempopeDeviceBonusPopup, r101.mempopeDeviceBonusPopup) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        MmAISummaryQuotaData r100 = this.aiQuota;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MmASRQuotaData r104 = this.asrQuota;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        MmDisplayQuotaData r107 = this.displayQuota;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        MmMempopeDeviceBonusPopup r110 = this.mempopeDeviceBonusPopup;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "MmQuotaData(aiQuota=" + this.aiQuota + ", asrQuota=" + this.asrQuota + ", displayQuota=" + this.displayQuota + ", mempopeDeviceBonusPopup=" + this.mempopeDeviceBonusPopup + ')';
    }

    public final MmAISummaryQuotaData getAiQuota() {
        return this.aiQuota;
    }

    public final MmASRQuotaData getAsrQuota() {
        return this.asrQuota;
    }

    public final MmDisplayQuotaData getDisplayQuota() {
        return this.displayQuota;
    }

    public final MmMempopeDeviceBonusPopup getMempopeDeviceBonusPopup() {
        return this.mempopeDeviceBonusPopup;
    }

    public final String getBenefitCenterUrl(MmQuotaType r100) {
        Intrinsics.checkNotNullParameter(r100, "quotaType");
        int r101 = a.f434898a[r100.ordinal()];
        String r102 = null;
        if (r101 != 1) goto L5;
        MmAISummaryQuotaData r103 = this.aiQuota;
        if (r103 == null) goto L26;
        String r104 = r103.getBenefitCenterUrl();
        if (r104 == null) goto L26;
    L33:
        return r104;
    L26:
        MmDisplayQuotaData r105 = this.displayQuota;
        if (r105 == null) goto L29;
        r102 = r105.getBenefitCenterUrl();
    L29:
        if (r102 != null) goto L32;
        return "";
    L32:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        MmASRQuotaData r106 = this.asrQuota;
        if (r106 == null) goto L15;
        r104 = r106.getBenefitCenterUrl();
        if (r104 != null) goto L33;
    L15:
        MmDisplayQuotaData r107 = this.displayQuota;
        if (r107 == null) goto L18;
        r102 = r107.getBenefitCenterUrl();
    L18:
        if (r102 != null) goto L32;
        return "";
    L7:
        if (r101 != 3) goto L10;
        return "";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final MmFeatureDetail getFeatureDetail(MmQuotaType r100) {
        Intrinsics.checkNotNullParameter(r100, "quotaType");
        int r101 = a.f434898a[r100.ordinal()];
        if (r101 != 1) goto L5;
        MmAISummaryQuotaData r102 = this.aiQuota;
        if (r102 != null) goto L19;
        return null;
    L19:
        return r102.getFeatureDetail();
    L5:
        if (r101 != 2) goto L7;
        MmASRQuotaData r103 = this.asrQuota;
        if (r103 != null) goto L23;
        return null;
    L23:
        return r103.getFeatureDetail();
    L7:
        if (r101 != 3) goto L12;
        MmMempopeDeviceBonusPopup r104 = this.mempopeDeviceBonusPopup;
        if (r104 != null) goto L21;
        return null;
    L21:
        return r104.getFeatureDetail();
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isAdmin(MmQuotaType r100) {
        Intrinsics.checkNotNullParameter(r100, "quotaType");
        int r101 = a.f434898a[r100.ordinal()];
        if (r101 != 1) goto L5;
        MmAISummaryQuotaData r102 = this.aiQuota;
        if (r102 == null) goto L25;
        Boolean r103 = r102.isAdmin();
        if (r103 != null) goto L21;
        return false;
    L21:
        return r103.booleanValue();
    L25:
        return false;
    L5:
        if (r101 != 2) goto L7;
        MmASRQuotaData r104 = this.asrQuota;
        if (r104 == null) goto L22;
        Boolean r105 = r104.isAdmin();
        if (r105 != null) goto L24;
        return false;
    L24:
        return r105.booleanValue();
    L22:
        return false;
    L7:
        if (r101 != 3) goto L10;
        return false;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final String getBillUrl(MmQuotaType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "quotaType");
        Intrinsics.checkNotNullParameter(r101, "functionScene");
        int r102 = a.f434898a[r100.ordinal()];
        boolean r103 = false;
        String r104 = null;
        if (r102 != 1) goto L5;
        MmAISummaryQuotaData r105 = this.aiQuota;
        if (r105 == null) goto L35;
        HashMap<String, String> r106 = r105.getFunctionSceneBuyUrlMap();
        if (r106 == null) goto L35;
        String r107 = r106.get(r101);
    L36:
        if (r107 != null) goto L39;
        r107 = "";
    L39:
        if (r107.length() != 0) goto L41;
        r103 = true;
    L41:
        if (r103 == false) goto L47;
        MmAISummaryQuotaData r108 = this.aiQuota;
        if (r108 == null) goto L45;
        r104 = r108.getBillUrl();
    L45:
        if (r104 != null) goto L46;
        return "";
    L46:
        return r104;
    L47:
        return r107;
    L35:
        r107 = null;
        goto L36
    L5:
        if (r102 != 2) goto L7;
        MmASRQuotaData r109 = this.asrQuota;
        if (r109 == null) goto L16;
        HashMap<String, String> r110 = r109.getFunctionSceneBuyUrlMap();
        if (r110 == null) goto L16;
        r107 = r110.get(r101);
    L17:
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        if (r107.length() != 0) goto L22;
        r103 = true;
    L22:
        if (r103 == false) goto L47;
        MmASRQuotaData r111 = this.asrQuota;
        if (r111 == null) goto L26;
        r104 = r111.getBillUrl();
    L26:
        if (r104 != null) goto L46;
        return "";
    L16:
        r107 = null;
        goto L17
    L7:
        if (r102 != 3) goto L10;
        return "";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public MmQuotaData(MmAISummaryQuotaData r100, MmASRQuotaData r101, MmDisplayQuotaData r102, MmMempopeDeviceBonusPopup r103) {
        this.aiQuota = r100;
        this.asrQuota = r101;
        this.displayQuota = r102;
        this.mempopeDeviceBonusPopup = r103;
    }

    public static /* synthetic */ String getBillUrl$default(MmQuotaData r100, MmQuotaType r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.getBillUrl(r101, r102);
    }

    public /* synthetic */ MmQuotaData(MmAISummaryQuotaData r100, MmASRQuotaData r101, MmDisplayQuotaData r102, MmMempopeDeviceBonusPopup r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
