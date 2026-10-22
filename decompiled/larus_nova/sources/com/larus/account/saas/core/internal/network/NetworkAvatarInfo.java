package com.larus.account.saas.core.internal.network;

import b48.j;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "", "Lb48/j;", "toAvatarInfo", "", "component1", "component2", "component3", "uri", "tinyUrl", "originUrl", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "getTinyUrl", "getOriginUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class NetworkAvatarInfo {

    @SerializedName("origin_url")
    private final String originUrl;

    @SerializedName("tiny_url")
    private final String tinyUrl;

    @SerializedName("uri")
    private final String uri;

    public NetworkAvatarInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NetworkAvatarInfo copy$default(NetworkAvatarInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.tinyUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.originUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.tinyUrl;
    }

    public final String component3() {
        return this.originUrl;
    }

    public final NetworkAvatarInfo copy(String r100, String r101, String r102) {
        return new NetworkAvatarInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetworkAvatarInfo) == true) goto L8;
        return false;
    L8:
        NetworkAvatarInfo r101 = (NetworkAvatarInfo) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tinyUrl, r101.tinyUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originUrl, r101.originUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.uri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tinyUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.originUrl;
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
        return "NetworkAvatarInfo(uri=" + this.uri + ", tinyUrl=" + this.tinyUrl + ", originUrl=" + this.originUrl + ')';
    }

    public final j toAvatarInfo() {
        return new j(this.uri, this.tinyUrl, this.originUrl);
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getTinyUrl() {
        return this.tinyUrl;
    }

    public final String getUri() {
        return this.uri;
    }

    public NetworkAvatarInfo(String r100, String r101, String r102) {
        this.uri = r100;
        this.tinyUrl = r101;
        this.originUrl = r102;
    }

    public /* synthetic */ NetworkAvatarInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
