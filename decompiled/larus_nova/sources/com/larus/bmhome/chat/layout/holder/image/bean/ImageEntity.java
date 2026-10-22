package com.larus.bmhome.chat.layout.holder.image.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;", "Ljava/io/Serializable;", "url", "", "urlV2", "width", "", "height", "uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getUrlV2", "getWidth", "()I", "getHeight", "getUri", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageEntity implements Serializable {

    @SerializedName("height")
    private final int height;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("url")
    private final String url;

    @SerializedName("url_v2")
    private final String urlV2;

    @SerializedName("width")
    private final int width;

    public ImageEntity() {
        this(null, null, 0, 0, null, 31, null);
    }

    public static /* synthetic */ ImageEntity copy$default(ImageEntity r100, String r101, String r102, int r103, int r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.urlV2;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.width;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.height;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.uri;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final String component5() {
        return this.uri;
    }

    public final ImageEntity copy(String r100, String r101, int r110, int r111, String r112) {
        return new ImageEntity(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageEntity) == true) goto L8;
        return false;
    L8:
        ImageEntity r101 = (ImageEntity) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlV2, r101.urlV2) == true) goto L15;
        return false;
    L15:
        if (this.width == r101.width) goto L18;
        return false;
    L18:
        if (this.height == r101.height) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L23;
        return false;
    L23:
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
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.width) * 31) + this.height) * 31;
        String r107 = this.uri;
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
        return "ImageEntity(url=" + this.url + ", urlV2=" + this.urlV2 + ", width=" + this.width + ", height=" + this.height + ", uri=" + this.uri + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getUri() {
        return this.uri;
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

    public ImageEntity(String r100, String r101, int r102, int r103, String r104) {
        this.url = r100;
        this.urlV2 = r101;
        this.width = r102;
        this.height = r103;
        this.uri = r104;
    }

    public /* synthetic */ ImageEntity(String r100, String r101, int r102, int r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
