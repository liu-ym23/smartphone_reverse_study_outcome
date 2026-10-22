package com.larus.drive.sdk.api.network.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/drive/sdk/api/network/resp/GetUserStorageResp;", "", "showSizeLimit", "", "totalSize", "", "usedSize", "<init>", "(ZJJ)V", "getShowSizeLimit", "()Z", "getTotalSize", "()J", "getUsedSize", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserStorageResp {

    @SerializedName("show_size_limit")
    private final boolean showSizeLimit;

    @SerializedName("total_size_limit_bytes")
    private final long totalSize;

    @SerializedName("used_size_bytes")
    private final long usedSize;

    public GetUserStorageResp() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ GetUserStorageResp copy$default(GetUserStorageResp r100, boolean r101, long r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.showSizeLimit;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = r100.totalSize;
    L8:
        long r106 = r102;
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.usedSize;
    L11:
        boolean r107 = r101;
        return r100.copy(r107, r106, r103);
    }

    public final boolean component1() {
        return this.showSizeLimit;
    }

    public final long component2() {
        return this.totalSize;
    }

    public final long component3() {
        return this.usedSize;
    }

    public final GetUserStorageResp copy(boolean r100, long r101, long r110) {
        return new GetUserStorageResp(r100, r101, r110);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetUserStorageResp) == true) goto L8;
        return false;
    L8:
        GetUserStorageResp r101 = (GetUserStorageResp) r100;
        if (this.showSizeLimit == r101.showSizeLimit) goto L12;
        return false;
    L12:
        if (this.totalSize == r101.totalSize) goto L15;
        return false;
    L15:
        if (this.usedSize == r101.usedSize) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.showSizeLimit == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.totalSize;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.usedSize;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "GetUserStorageResp(showSizeLimit=" + this.showSizeLimit + ", totalSize=" + this.totalSize + ", usedSize=" + this.usedSize + ')';
    }

    public final boolean getShowSizeLimit() {
        return this.showSizeLimit;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final long getUsedSize() {
        return this.usedSize;
    }

    public GetUserStorageResp(boolean r100, long r101, long r102) {
        this.showSizeLimit = r100;
        this.totalSize = r101;
        this.usedSize = r102;
    }

    public /* synthetic */ GetUserStorageResp(boolean r100, long r101, long r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r110 & 2) == 0) goto L8;
        long r103 = 0;
    L10:
        if ((r110 & 4) == 0) goto L12;
        long r112 = 0;
    L13:
        this(r100, r103, r112);
        return;
    L12:
        r112 = r102;
        goto L13
    L8:
        r103 = r101;
        goto L10
    }
}
