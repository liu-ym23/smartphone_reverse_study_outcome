package com.larus.share.service;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/share/service/ShareShortUrlItem;", "", "longUrl", "", "shortUrl", "status", "", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getLongUrl", "()Ljava/lang/String;", "getShortUrl", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/share/service/ShareShortUrlItem;", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareShortUrlItem {

    @SerializedName("long_url")
    private final String longUrl;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("short_url")
    private final String shortUrl;

    @SerializedName("status")
    private final Integer status;

    public ShareShortUrlItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ShareShortUrlItem copy$default(ShareShortUrlItem r100, String r101, String r102, Integer r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.longUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.shortUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.status;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.msg;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.longUrl;
    }

    public final String component2() {
        return this.shortUrl;
    }

    public final Integer component3() {
        return this.status;
    }

    public final String component4() {
        return this.msg;
    }

    public final ShareShortUrlItem copy(String r100, String r101, Integer r102, String r103) {
        return new ShareShortUrlItem(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareShortUrlItem) == true) goto L8;
        return false;
    L8:
        ShareShortUrlItem r101 = (ShareShortUrlItem) r100;
        if (Intrinsics.areEqual(this.longUrl, r101.longUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shortUrl, r101.shortUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.longUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.shortUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.status;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.msg;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ShareShortUrlItem(longUrl=" + this.longUrl + ", shortUrl=" + this.shortUrl + ", status=" + this.status + ", msg=" + this.msg + ')';
    }

    public final String getLongUrl() {
        return this.longUrl;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getShortUrl() {
        return this.shortUrl;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public ShareShortUrlItem(String r100, String r101, Integer r102, String r103) {
        this.longUrl = r100;
        this.shortUrl = r101;
        this.status = r102;
        this.msg = r103;
    }

    public /* synthetic */ ShareShortUrlItem(String r100, String r101, Integer r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
