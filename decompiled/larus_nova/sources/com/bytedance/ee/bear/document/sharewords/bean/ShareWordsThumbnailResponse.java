package com.bytedance.ee.bear.document.sharewords.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", "stateTime", "", "url", "", "decryptKey", "decryptType", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;I)V", "getStateTime", "()J", "getUrl", "()Ljava/lang/String;", "getDecryptKey", "getDecryptType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsThumbnailResponse implements NonProguard {

    @SerializedName("decrypt_key")
    private final String decryptKey;

    @SerializedName("decrypt_type")
    private final int decryptType;
    private final long stateTime;
    private final String url;

    public ShareWordsThumbnailResponse() {
        this(0, null, null, 0, 15, null);
    }

    public static /* synthetic */ ShareWordsThumbnailResponse copy$default(ShareWordsThumbnailResponse r100, long r101, String r102, String r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.stateTime;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.url;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.decryptKey;
    L11:
        String r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.decryptType;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.stateTime;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.decryptKey;
    }

    public final int component4() {
        return this.decryptType;
    }

    public final ShareWordsThumbnailResponse copy(long r100, String r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "decryptKey");
        return new ShareWordsThumbnailResponse(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareWordsThumbnailResponse) == true) goto L8;
        return false;
    L8:
        ShareWordsThumbnailResponse r101 = (ShareWordsThumbnailResponse) r100;
        if (this.stateTime == r101.stateTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.decryptKey, r101.decryptKey) == true) goto L18;
        return false;
    L18:
        if (this.decryptType == r101.decryptType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.stateTime;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.url.hashCode()) * 31) + this.decryptKey.hashCode()) * 31) + this.decryptType;
    }

    public String toString() {
        return "ShareWordsThumbnailResponse(stateTime=" + this.stateTime + ", url=" + this.url + ", decryptKey=" + this.decryptKey + ", decryptType=" + this.decryptType + ')';
    }

    public final String getDecryptKey() {
        return this.decryptKey;
    }

    public final int getDecryptType() {
        return this.decryptType;
    }

    public final long getStateTime() {
        return this.stateTime;
    }

    public final String getUrl() {
        return this.url;
    }

    public ShareWordsThumbnailResponse(long r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "decryptKey");
        this.stateTime = r100;
        this.url = r101;
        this.decryptKey = r102;
        this.decryptType = r103;
    }

    public /* synthetic */ ShareWordsThumbnailResponse(long r100, String r101, String r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r102 = r100;
        if ((r112 & 2) == 0) goto L8;
        String r103 = "";
    L10:
        if ((r112 & 4) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r112 & 8) == 0) goto L16;
        int r105 = -1;
    L17:
        this(r102, r103, r104, r105);
        return;
    L16:
        r105 = r111;
        goto L17
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }
}
