package com.larus.bmhome.chat.layout.holder.video.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;", "Ljava/io/Serializable;", "url", "", "urlV2", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getUrl", "()Ljava/lang/String;", "getUrlV2", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverImageEntity implements Serializable {

    @SerializedName("height")
    private final int height;

    @SerializedName("url")
    private final String url;

    @SerializedName("url_v2")
    private final String urlV2;

    @SerializedName("width")
    private final int width;

    public CoverImageEntity() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ CoverImageEntity copy$default(CoverImageEntity r100, String r101, String r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.urlV2;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.width;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.height;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.urlV2;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final CoverImageEntity copy(String r100, String r101, int r102, int r103) {
        return new CoverImageEntity(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoverImageEntity) == true) goto L8;
        return false;
    L8:
        CoverImageEntity r101 = (CoverImageEntity) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlV2, r101.urlV2) == true) goto L15;
        return false;
    L15:
        if (this.width == r101.width) goto L18;
        return false;
    L18:
        if (this.height == r101.height) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.urlV2;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.width) * 31) + this.height;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CoverImageEntity(url=" + this.url + ", urlV2=" + this.urlV2 + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlV2() {
        return this.urlV2;
    }

    public final int getWidth() {
        return this.width;
    }

    public CoverImageEntity(String r100, String r101, int r102, int r103) {
        this.url = r100;
        this.urlV2 = r101;
        this.width = r102;
        this.height = r103;
    }

    public /* synthetic */ CoverImageEntity(String r100, String r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
