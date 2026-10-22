package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "Ljava/io/Serializable;", "reasonCode", "", "windowLimitType", "", "<init>", "(ILjava/lang/String;)V", "getReasonCode", "()I", "getWindowLimitType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowUnavailableReason implements Serializable {
    private final int reasonCode;
    private final String windowLimitType;

    /* JADX WARN: Multi-variable type inference failed */
    public MmEndWindowUnavailableReason() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MmEndWindowUnavailableReason copy$default(MmEndWindowUnavailableReason r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.reasonCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.windowLimitType;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.reasonCode;
    }

    public final String component2() {
        return this.windowLimitType;
    }

    public final MmEndWindowUnavailableReason copy(int r100, String r101) {
        return new MmEndWindowUnavailableReason(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmEndWindowUnavailableReason) == true) goto L8;
        return false;
    L8:
        MmEndWindowUnavailableReason r101 = (MmEndWindowUnavailableReason) r100;
        if (this.reasonCode == r101.reasonCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitType, r101.windowLimitType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.reasonCode * 31;
        String r101 = this.windowLimitType;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "MmEndWindowUnavailableReason(reasonCode=" + this.reasonCode + ", windowLimitType=" + this.windowLimitType + ')';
    }

    public final int getReasonCode() {
        return this.reasonCode;
    }

    public final String getWindowLimitType() {
        return this.windowLimitType;
    }

    public MmEndWindowUnavailableReason(int r100, String r101) {
        this.reasonCode = r100;
        this.windowLimitType = r101;
    }

    public /* synthetic */ MmEndWindowUnavailableReason(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
