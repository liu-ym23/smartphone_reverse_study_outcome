package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "Ljava/io/Serializable;", "reasonCode", "", "windowLimitType", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getReasonCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWindowLimitType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmUnavailableReason implements Serializable {

    @SerializedName(FlowNetworkIDLStub.OMNI_UPLOAD_REASON_CODE_KEY)
    private final Integer reasonCode;

    @SerializedName("window_limit_type")
    private final String windowLimitType;

    /* JADX WARN: Multi-variable type inference failed */
    public MmUnavailableReason() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MmUnavailableReason copy$default(MmUnavailableReason r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.reasonCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.windowLimitType;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.reasonCode;
    }

    public final String component2() {
        return this.windowLimitType;
    }

    public final MmUnavailableReason copy(Integer r100, String r101) {
        return new MmUnavailableReason(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmUnavailableReason) == true) goto L8;
        return false;
    L8:
        MmUnavailableReason r101 = (MmUnavailableReason) r100;
        if (Intrinsics.areEqual(this.reasonCode, r101.reasonCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitType, r101.windowLimitType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.reasonCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.windowLimitType;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MmUnavailableReason(reasonCode=" + this.reasonCode + ", windowLimitType=" + this.windowLimitType + ')';
    }

    public final Integer getReasonCode() {
        return this.reasonCode;
    }

    public final String getWindowLimitType() {
        return this.windowLimitType;
    }

    public MmUnavailableReason(Integer r100, String r101) {
        this.reasonCode = r100;
        this.windowLimitType = r101;
    }

    public /* synthetic */ MmUnavailableReason(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
