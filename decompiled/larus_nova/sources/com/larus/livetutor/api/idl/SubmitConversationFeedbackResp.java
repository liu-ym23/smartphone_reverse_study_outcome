package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/larus/livetutor/api/idl/SubmitConversationFeedbackResp;", "Ljava/io/Serializable;", "statusInfo", "Lcom/larus/livetutor/api/idl/StatusInfo;", "<init>", "(Lcom/larus/livetutor/api/idl/StatusInfo;)V", "getStatusInfo", "()Lcom/larus/livetutor/api/idl/StatusInfo;", "setStatusInfo", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmitConversationFeedbackResp implements Serializable {

    @SerializedName("status_info")
    private StatusInfo statusInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public SubmitConversationFeedbackResp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SubmitConversationFeedbackResp copy$default(SubmitConversationFeedbackResp r100, StatusInfo r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.statusInfo;
    L6:
        return r100.copy(r101);
    }

    public final StatusInfo component1() {
        return this.statusInfo;
    }

    public final SubmitConversationFeedbackResp copy(StatusInfo r100) {
        return new SubmitConversationFeedbackResp(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubmitConversationFeedbackResp) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.statusInfo, ((SubmitConversationFeedbackResp) r100).statusInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        StatusInfo r100 = this.statusInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SubmitConversationFeedbackResp(statusInfo=" + this.statusInfo + ')';
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public SubmitConversationFeedbackResp(StatusInfo r100) {
        this.statusInfo = r100;
    }

    public final void setStatusInfo(StatusInfo r100) {
        this.statusInfo = r100;
    }

    public /* synthetic */ SubmitConversationFeedbackResp(StatusInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
