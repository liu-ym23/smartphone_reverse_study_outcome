package com.bytedance.android.shopping.api.anchorv3;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\u0018\u00002\u00020\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;", "Ljava/io/Serializable;", "enterFrom", "", "enterMethod", "eComEntranceForm", "v3EventsAdditions", "whichAccount", "recommendInfo", "requestId", "productSourcePage", "moduleLabel", "labelNameFromLive", "baseVerifiedCategory", "labelNameLive", "transitionTrackerData", "threeDLogData", "inflowRecommendType", "adType", "ecomShareTrackParams", "shareGroupInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdType", "()Ljava/lang/String;", "setAdType", "(Ljava/lang/String;)V", "getBaseVerifiedCategory", "getEComEntranceForm", "getEcomShareTrackParams", "setEcomShareTrackParams", "getEnterFrom", "getEnterMethod", "getInflowRecommendType", "getLabelNameFromLive", "getLabelNameLive", "getModuleLabel", "setModuleLabel", "getProductSourcePage", "setProductSourcePage", "getRecommendInfo", "getRequestId", "getShareGroupInfo", "getThreeDLogData", "getTransitionTrackerData", "getV3EventsAdditions", "getWhichAccount", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECLogExtraData implements Serializable {
    private String adType;
    private final String baseVerifiedCategory;
    private final String eComEntranceForm;
    private String ecomShareTrackParams;
    private final String enterFrom;
    private final String enterMethod;
    private final String inflowRecommendType;
    private final String labelNameFromLive;
    private final String labelNameLive;
    private String moduleLabel;
    private String productSourcePage;
    private final String recommendInfo;
    private final String requestId;
    private final String shareGroupInfo;
    private final String threeDLogData;
    private final String transitionTrackerData;
    private final String v3EventsAdditions;
    private final String whichAccount;

    public ECLogExtraData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public final String getAdType() {
        return this.adType;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final String getEComEntranceForm() {
        return this.eComEntranceForm;
    }

    public final String getEcomShareTrackParams() {
        return this.ecomShareTrackParams;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getInflowRecommendType() {
        return this.inflowRecommendType;
    }

    public final String getLabelNameFromLive() {
        return this.labelNameFromLive;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final String getModuleLabel() {
        return this.moduleLabel;
    }

    public final String getProductSourcePage() {
        return this.productSourcePage;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getShareGroupInfo() {
        return this.shareGroupInfo;
    }

    public final String getThreeDLogData() {
        return this.threeDLogData;
    }

    public final String getTransitionTrackerData() {
        return this.transitionTrackerData;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final void setAdType(String r1) {
        this.adType = r1;
    }

    public final void setEcomShareTrackParams(String r1) {
        this.ecomShareTrackParams = r1;
    }

    public final void setModuleLabel(String r1) {
        this.moduleLabel = r1;
    }

    public final void setProductSourcePage(String r1) {
        this.productSourcePage = r1;
    }

    public ECLogExtraData(String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        Intrinsics.checkNotNullParameter(r6, "enterMethod");
        this.enterFrom = r5;
        this.enterMethod = r6;
        this.eComEntranceForm = r7;
        this.v3EventsAdditions = r8;
        this.whichAccount = r9;
        this.recommendInfo = r10;
        this.requestId = r11;
        this.productSourcePage = r12;
        this.moduleLabel = r13;
        this.labelNameFromLive = r14;
        this.baseVerifiedCategory = r15;
        this.labelNameLive = r16;
        this.transitionTrackerData = r17;
        this.threeDLogData = r18;
        this.inflowRecommendType = r19;
        this.adType = r20;
        this.ecomShareTrackParams = r21;
        this.shareGroupInfo = r22;
    }

    public /* synthetic */ ECLogExtraData(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, int r38, DefaultConstructorMarker r39) {
        String r2 = "";
        if ((r38 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r38 & 2) != 0) goto L11;
        r2 = r21;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        String r4 = null;
    L63:
        if ((r38 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r38 & 131072) == 0) goto L73;
        String r0 = null;
    L74:
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r4, r16, r17, r0);
        return;
    L73:
        r0 = r37;
        goto L74
    L69:
        r17 = r36;
        goto L71
    L65:
        r16 = r35;
        goto L67
    L61:
        r4 = r34;
        goto L63
    L57:
        r15 = r33;
        goto L59
    L53:
        r14 = r32;
        goto L55
    L49:
        r13 = r31;
        goto L51
    L45:
        r12 = r30;
        goto L47
    L41:
        r11 = r29;
        goto L43
    L37:
        r10 = r28;
        goto L39
    L33:
        r9 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r3 = r22;
        goto L15
    L5:
        r1 = r20;
        goto L7
    }
}
