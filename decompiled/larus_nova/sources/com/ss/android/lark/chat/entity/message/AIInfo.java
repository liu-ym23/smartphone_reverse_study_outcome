package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIInfo;", "Ljava/io/Serializable;", "roundId", "", "buttonConfig", "Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;", "rootRoundId", "enterpriseQAGeneralInfo", "Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;)V", "getRoundId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getButtonConfig", "()Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;", "getRootRoundId", "getEnterpriseQAGeneralInfo", "()Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;)Lcom/ss/android/lark/chat/entity/message/AIInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIInfo implements Serializable {
    private final AIButtonConfig buttonConfig;
    private final EnterpriseQAGeneralInfo enterpriseQAGeneralInfo;
    private final Long rootRoundId;
    private final Long roundId;

    public static /* synthetic */ AIInfo copy$default(AIInfo r100, Long r101, AIButtonConfig r102, Long r103, EnterpriseQAGeneralInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.roundId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.buttonConfig;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rootRoundId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.enterpriseQAGeneralInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.roundId;
    }

    public final AIButtonConfig component2() {
        return this.buttonConfig;
    }

    public final Long component3() {
        return this.rootRoundId;
    }

    public final EnterpriseQAGeneralInfo component4() {
        return this.enterpriseQAGeneralInfo;
    }

    public final AIInfo copy(Long r100, AIButtonConfig r101, Long r102, EnterpriseQAGeneralInfo r103) {
        return new AIInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIInfo) == true) goto L8;
        return false;
    L8:
        AIInfo r101 = (AIInfo) r100;
        if (Intrinsics.areEqual(this.roundId, r101.roundId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonConfig, r101.buttonConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rootRoundId, r101.rootRoundId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterpriseQAGeneralInfo, r101.enterpriseQAGeneralInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r100 = this.roundId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AIButtonConfig r104 = this.buttonConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.rootRoundId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        EnterpriseQAGeneralInfo r110 = this.enterpriseQAGeneralInfo;
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
        return "AIInfo(roundId=" + this.roundId + ", buttonConfig=" + this.buttonConfig + ", rootRoundId=" + this.rootRoundId + ", enterpriseQAGeneralInfo=" + this.enterpriseQAGeneralInfo + ')';
    }

    public final AIButtonConfig getButtonConfig() {
        return this.buttonConfig;
    }

    public final EnterpriseQAGeneralInfo getEnterpriseQAGeneralInfo() {
        return this.enterpriseQAGeneralInfo;
    }

    public final Long getRootRoundId() {
        return this.rootRoundId;
    }

    public final Long getRoundId() {
        return this.roundId;
    }

    public AIInfo(Long r100, AIButtonConfig r101, Long r102, EnterpriseQAGeneralInfo r103) {
        this.roundId = r100;
        this.buttonConfig = r101;
        this.rootRoundId = r102;
        this.enterpriseQAGeneralInfo = r103;
    }
}
