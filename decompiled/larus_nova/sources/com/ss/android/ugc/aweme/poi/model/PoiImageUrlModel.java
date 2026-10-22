package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "Ljava/io/Serializable;", "url", "", "uri", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;II)V", "getHeight", "()I", "setHeight", "(I)V", "getUri", "()Ljava/lang/String;", "getUrl", "getUrlList", "()Ljava/util/List;", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiImageUrlModel implements Serializable {

    @SerializedName("height")
    private int height;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("url")
    private final String url;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> urlList;

    @SerializedName("width")
    private int width;

    public PoiImageUrlModel() {
        this(null, null, null, 0, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiImageUrlModel copy$default(PoiImageUrlModel r100, String r101, String r102, List r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.uri;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.urlList;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.width;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.height;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.uri;
    }

    public final List<String> component3() {
        return this.urlList;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final PoiImageUrlModel copy(String r100, String r101, List<String> r110, int r111, int r112) {
        return new PoiImageUrlModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiImageUrlModel) == true) goto L8;
        return false;
    L8:
        PoiImageUrlModel r101 = (PoiImageUrlModel) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L18;
        return false;
    L18:
        if (this.width == r101.width) goto L21;
        return false;
    L21:
        if (this.height == r101.height) goto L23;
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
        String r104 = this.uri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.urlList;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((((r106 + r101) * 31) + this.width) * 31) + this.height;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiImageUrlModel(url=" + this.url + ", uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ')';
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

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public PoiImageUrlModel(String r100, String r101, List<String> r102, int r103, int r104) {
        this.url = r100;
        this.uri = r101;
        this.urlList = r102;
        this.width = r103;
        this.height = r104;
    }

    public /* synthetic */ PoiImageUrlModel(String r100, String r101, List r102, int r103, int r104, int r105, DefaultConstructorMarker r110) {
        List r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        int r108 = 0;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 0;
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
