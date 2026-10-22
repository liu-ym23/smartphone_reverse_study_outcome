package com.larus.im.bean.job;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/im/bean/job/AIJobRequestState;", "", "requestType", "Lcom/larus/im/bean/job/AIJobRequestType;", "status", "Lcom/larus/im/bean/job/AIJobRequestStatus;", "errorCode", "", "errorMessage", "", "<init>", "(Lcom/larus/im/bean/job/AIJobRequestType;Lcom/larus/im/bean/job/AIJobRequestStatus;ILjava/lang/String;)V", "getRequestType", "()Lcom/larus/im/bean/job/AIJobRequestType;", "getStatus", "()Lcom/larus/im/bean/job/AIJobRequestStatus;", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIJobRequestState {
    private final int errorCode;
    private final String errorMessage;
    private final AIJobRequestType requestType;
    private final AIJobRequestStatus status;

    public static /* synthetic */ AIJobRequestState copy$default(AIJobRequestState r100, AIJobRequestType r101, AIJobRequestStatus r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.requestType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.status;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.errorCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.errorMessage;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final AIJobRequestType component1() {
        return this.requestType;
    }

    public final AIJobRequestStatus component2() {
        return this.status;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.errorMessage;
    }

    public final AIJobRequestState copy(AIJobRequestType r100, AIJobRequestStatus r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        Intrinsics.checkNotNullParameter(r101, "status");
        return new AIJobRequestState(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIJobRequestState) == true) goto L8;
        return false;
    L8:
        AIJobRequestState r101 = (AIJobRequestState) r100;
        if (this.requestType == r101.requestType) goto L12;
        return false;
    L12:
        if (this.status == r101.status) goto L15;
        return false;
    L15:
        if (this.errorCode == r101.errorCode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errorMessage, r101.errorMessage) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.requestType.hashCode() * 31) + this.status.hashCode()) * 31) + this.errorCode) * 31;
        String r101 = this.errorMessage;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AIJobRequestState(requestType=" + this.requestType + ", status=" + this.status + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final AIJobRequestType getRequestType() {
        return this.requestType;
    }

    public final AIJobRequestStatus getStatus() {
        return this.status;
    }

    public AIJobRequestState(AIJobRequestType r100, AIJobRequestStatus r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        Intrinsics.checkNotNullParameter(r101, "status");
        this.requestType = r100;
        this.status = r101;
        this.errorCode = r102;
        this.errorMessage = r103;
    }

    public /* synthetic */ AIJobRequestState(AIJobRequestType r100, AIJobRequestStatus r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
