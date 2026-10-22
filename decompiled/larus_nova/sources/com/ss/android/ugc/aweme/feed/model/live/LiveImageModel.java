package com.ss.android.ugc.aweme.feed.model.live;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0016\u0010\u0014\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0006\u0010 \u001a\u00020\u001dR\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\"R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010#¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/live/LiveImageModel;", "Ljava/io/Serializable;", "", "getAvgColor", "avgColor", "", "setAvgColor", "", "getImageType", "imageType", "setImageType", "getSchema", "schema", "setSchema", "getUri", "uri", "setUri", "", "getUrlList", "urlList", "setUrlList", "getWidth", "width", "setWidth", "getHeight", "height", "setHeight", "", "o", "", "equals", "hashCode", "isValid", "HASH_CODE_31", "I", "Ljava/lang/String;", "Ljava/util/List;", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public class LiveImageModel implements Serializable {
    private final int HASH_CODE_31;

    @SerializedName("avg_color")
    public String avgColor;

    @SerializedName("height")
    private int height;

    @SerializedName("image_type")
    private int imageType;

    @SerializedName("open_web_url")
    private String schema;

    @SerializedName("uri")
    protected String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> urlList;

    @SerializedName("width")
    private int width;

    public int hashCode() {
        int r100 = 1;
        Object[] r101 = {this.avgColor, this.uri, this.urlList, Integer.valueOf(this.width), Integer.valueOf(this.height)};
        int r102 = 0;
    L3:
        if (r102 >= 5) goto L9;
        Object r103 = r101[r102];
        int r104 = this.HASH_CODE_31 * r100;
        if (r103 == null) goto L7;
        int r105 = r103.hashCode();
    L8:
        r100 = r105 + r104;
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = 0;
        goto L8
    L9:
        return r100;
    }

    public final boolean isValid() {
        String r100 = this.uri;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L19;
        List<String> r102 = this.urlList;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
    L19:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public LiveImageModel() {
        this.HASH_CODE_31 = 31;
    }

    public final String getAvgColor() {
        return this.avgColor;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final int getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L44:
        return false;
    L8:
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == false) goto L44;
        LiveImageModel r101 = (LiveImageModel) r100;
        if (this.width == r101.width) goto L13;
    L42:
        return false;
    L13:
        if (this.height != r101.height) goto L42;
        String r102 = this.avgColor;
        String r103 = r101.avgColor;
        if (r102 == r103) goto L21;
        if (r102 != null) goto L18;
    L20:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L42;
        String r105 = this.uri;
        String r106 = r101.uri;
        if (r105 == r106) goto L30;
        if (r105 != null) goto L27;
    L29:
        boolean r107 = false;
    L31:
        if (r107 == false) goto L42;
        List<String> r108 = this.urlList;
        List<String> r109 = r101.urlList;
        if (r108 == r109) goto L39;
        if (r108 != null) goto L36;
    L38:
        boolean r110 = false;
    L40:
        if (r110 == false) goto L42;
        return true;
    L36:
        if (Intrinsics.areEqual(r108, r109) == false) goto L38;
    L39:
        r110 = true;
        goto L40
    L27:
        if (Intrinsics.areEqual(r105, r106) == false) goto L29;
    L30:
        r107 = true;
        goto L31
    L18:
        if (Intrinsics.areEqual(r102, r103) == false) goto L20;
    L21:
        r104 = true;
        goto L22
    }

    public final void setAvgColor(String r100) {
        this.avgColor = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setImageType(int r100) {
        this.imageType = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrlList(List<String> r100) {
        this.urlList = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
