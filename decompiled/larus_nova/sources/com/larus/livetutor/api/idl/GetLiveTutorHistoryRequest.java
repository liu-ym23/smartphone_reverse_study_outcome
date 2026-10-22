package com.larus.livetutor.api.idl;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryRequest;", "Ljava/io/Serializable;", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "cursorId", "<init>", "(JLjava/lang/Long;)V", "getLimit", "()J", "setLimit", "(J)V", "getCursorId", "()Ljava/lang/Long;", "setCursorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(JLjava/lang/Long;)Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryRequest;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetLiveTutorHistoryRequest implements Serializable {

    @SerializedName("cursor_id")
    private Long cursorId;

    @SerializedName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private long limit;

    public GetLiveTutorHistoryRequest() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ GetLiveTutorHistoryRequest copy$default(GetLiveTutorHistoryRequest r100, long r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.limit;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cursorId;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.limit;
    }

    public final Long component2() {
        return this.cursorId;
    }

    public final GetLiveTutorHistoryRequest copy(long r100, Long r101) {
        return new GetLiveTutorHistoryRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetLiveTutorHistoryRequest) == true) goto L8;
        return false;
    L8:
        GetLiveTutorHistoryRequest r101 = (GetLiveTutorHistoryRequest) r100;
        if (this.limit == r101.limit) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cursorId, r101.cursorId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.limit;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Long r102 = this.cursorId;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public String toString() {
        return "GetLiveTutorHistoryRequest(limit=" + this.limit + ", cursorId=" + this.cursorId + ')';
    }

    public final Long getCursorId() {
        return this.cursorId;
    }

    public final long getLimit() {
        return this.limit;
    }

    public final void setCursorId(Long r100) {
        this.cursorId = r100;
    }

    public final void setLimit(long r100) {
        this.limit = r100;
    }

    public GetLiveTutorHistoryRequest(long r100, Long r101) {
        this.limit = r100;
        this.cursorId = r101;
    }

    public /* synthetic */ GetLiveTutorHistoryRequest(long r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
