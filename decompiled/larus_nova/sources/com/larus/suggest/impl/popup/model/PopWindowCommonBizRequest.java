package com.larus.suggest.impl.popup.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/suggest/impl/popup/model/PopWindowCommonBizRequest;", "", "bizReqId", "", "fromSource", "", "params", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBizReqId", "()Ljava/lang/String;", "getFromSource", "()I", "getParams", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowCommonBizRequest {
    public static final a Companion = null;
    public static final int FROM_SOURCE_POP_WINDOW = 2;

    @SerializedName("biz_req_id")
    private final String bizReqId;

    @SerializedName("from_source")
    private final int fromSource;

    @SerializedName("params")
    private final String params;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PopWindowCommonBizRequest() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ PopWindowCommonBizRequest copy$default(PopWindowCommonBizRequest r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.bizReqId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fromSource;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.params;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.bizReqId;
    }

    public final int component2() {
        return this.fromSource;
    }

    public final String component3() {
        return this.params;
    }

    public final PopWindowCommonBizRequest copy(String r100, int r101, String r102) {
        return new PopWindowCommonBizRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowCommonBizRequest) == true) goto L8;
        return false;
    L8:
        PopWindowCommonBizRequest r101 = (PopWindowCommonBizRequest) r100;
        if (Intrinsics.areEqual(this.bizReqId, r101.bizReqId) == true) goto L12;
        return false;
    L12:
        if (this.fromSource == r101.fromSource) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.bizReqId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.fromSource) * 31;
        String r104 = this.params;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowCommonBizRequest(bizReqId=" + this.bizReqId + ", fromSource=" + this.fromSource + ", params=" + this.params + ')';
    }

    public final String getBizReqId() {
        return this.bizReqId;
    }

    public final int getFromSource() {
        return this.fromSource;
    }

    public final String getParams() {
        return this.params;
    }

    public PopWindowCommonBizRequest(String r100, int r101, String r102) {
        this.bizReqId = r100;
        this.fromSource = r101;
        this.params = r102;
    }

    public /* synthetic */ PopWindowCommonBizRequest(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 2;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
