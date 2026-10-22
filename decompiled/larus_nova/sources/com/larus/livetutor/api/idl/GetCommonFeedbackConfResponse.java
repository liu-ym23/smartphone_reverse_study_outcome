package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/livetutor/api/idl/GetCommonFeedbackConfResponse;", "Ljava/io/Serializable;", "conversationConf", "Lcom/larus/livetutor/api/idl/CommonFeedbackConf;", "statusInfo", "Lcom/larus/livetutor/api/idl/StatusInfo;", "<init>", "(Lcom/larus/livetutor/api/idl/CommonFeedbackConf;Lcom/larus/livetutor/api/idl/StatusInfo;)V", "getConversationConf", "()Lcom/larus/livetutor/api/idl/CommonFeedbackConf;", "setConversationConf", "(Lcom/larus/livetutor/api/idl/CommonFeedbackConf;)V", "getStatusInfo", "()Lcom/larus/livetutor/api/idl/StatusInfo;", "setStatusInfo", "(Lcom/larus/livetutor/api/idl/StatusInfo;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCommonFeedbackConfResponse implements Serializable {

    @SerializedName("conversation_conf")
    private CommonFeedbackConf conversationConf;

    @SerializedName("status_info")
    private StatusInfo statusInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public GetCommonFeedbackConfResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GetCommonFeedbackConfResponse copy$default(GetCommonFeedbackConfResponse r100, CommonFeedbackConf r101, StatusInfo r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.conversationConf;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.statusInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final CommonFeedbackConf component1() {
        return this.conversationConf;
    }

    public final StatusInfo component2() {
        return this.statusInfo;
    }

    public final GetCommonFeedbackConfResponse copy(CommonFeedbackConf r100, StatusInfo r101) {
        return new GetCommonFeedbackConfResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetCommonFeedbackConfResponse) == true) goto L8;
        return false;
    L8:
        GetCommonFeedbackConfResponse r101 = (GetCommonFeedbackConfResponse) r100;
        if (Intrinsics.areEqual(this.conversationConf, r101.conversationConf) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusInfo, r101.statusInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CommonFeedbackConf r100 = this.conversationConf;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        StatusInfo r104 = this.statusInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetCommonFeedbackConfResponse(conversationConf=" + this.conversationConf + ", statusInfo=" + this.statusInfo + ')';
    }

    public final CommonFeedbackConf getConversationConf() {
        return this.conversationConf;
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final void setConversationConf(CommonFeedbackConf r100) {
        this.conversationConf = r100;
    }

    public final void setStatusInfo(StatusInfo r100) {
        this.statusInfo = r100;
    }

    public GetCommonFeedbackConfResponse(CommonFeedbackConf r100, StatusInfo r101) {
        this.conversationConf = r100;
        this.statusInfo = r101;
    }

    public /* synthetic */ GetCommonFeedbackConfResponse(CommonFeedbackConf r100, StatusInfo r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
