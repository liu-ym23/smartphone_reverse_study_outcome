package com.larus.reach.impl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/larus/reach/impl/ReachActionRequest;", "", "bizReqPsm", "", "bizReqId", "fromSource", "", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBizReqPsm", "()Ljava/lang/String;", "getBizReqId", "getFromSource", "()I", "getParams", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ReachActionRequest {

    @SerializedName("biz_req_id")
    private final String bizReqId;

    @SerializedName("biz_req_psm")
    private final String bizReqPsm;

    @SerializedName("from_source")
    private final int fromSource;

    @SerializedName("params")
    private final String params;

    public ReachActionRequest() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ ReachActionRequest copy$default(ReachActionRequest r100, String r101, String r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bizReqPsm;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bizReqId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.fromSource;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.params;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.bizReqPsm;
    }

    public final String component2() {
        return this.bizReqId;
    }

    public final int component3() {
        return this.fromSource;
    }

    public final String component4() {
        return this.params;
    }

    public final ReachActionRequest copy(String r100, String r101, int r102, String r103) {
        return new ReachActionRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReachActionRequest) == true) goto L8;
        return false;
    L8:
        ReachActionRequest r101 = (ReachActionRequest) r100;
        if (Intrinsics.areEqual(this.bizReqPsm, r101.bizReqPsm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizReqId, r101.bizReqId) == true) goto L15;
        return false;
    L15:
        if (this.fromSource == r101.fromSource) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.bizReqPsm;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizReqId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.fromSource) * 31;
        String r107 = this.params;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ReachActionRequest(bizReqPsm=" + this.bizReqPsm + ", bizReqId=" + this.bizReqId + ", fromSource=" + this.fromSource + ", params=" + this.params + ')';
    }

    public final String getBizReqId() {
        return this.bizReqId;
    }

    public final String getBizReqPsm() {
        return this.bizReqPsm;
    }

    public final int getFromSource() {
        return this.fromSource;
    }

    public final String getParams() {
        return this.params;
    }

    public ReachActionRequest(String r100, String r101, int r102, String r103) {
        this.bizReqPsm = r100;
        this.bizReqId = r101;
        this.fromSource = r102;
        this.params = r103;
    }

    public /* synthetic */ ReachActionRequest(String r100, String r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
