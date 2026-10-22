package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003JA\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;", "Ljava/io/Serializable;", "url", "", "width", "", "height", "urlFormats", "", "<init>", "(Ljava/lang/String;IILjava/util/Map;)V", "heicUrl", "getHeicUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageObj implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("height")
    public int height;

    @SerializedName("url")
    public String url;

    @SerializedName("url_formats")
    public final Map<String, String> urlFormats;

    @SerializedName("width")
    public int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageObj() {
        this(null, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageObj copy$default(ImageObj r100, String r101, int r102, int r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.width;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.urlFormats;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final Map<String, String> component4() {
        return this.urlFormats;
    }

    public final ImageObj copy(String r100, int r101, int r102, Map<String, String> r103) {
        return new ImageObj(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageObj) == true) goto L8;
        return false;
    L8:
        ImageObj r101 = (ImageObj) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L15;
        return false;
    L15:
        if (this.height == r101.height) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.urlFormats, r101.urlFormats) == true) goto L20;
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
        int r103 = ((((r102 * 31) + this.width) * 31) + this.height) * 31;
        Map<String, String> r104 = this.urlFormats;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageObj(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", urlFormats=" + this.urlFormats + ')';
    }

    public final String getHeicUrl() {
        Map<String, String> r100 = this.urlFormats;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("heic");
    }

    public ImageObj(String r100, int r101, int r102, Map<String, String> r103) {
        this.url = r100;
        this.width = r101;
        this.height = r102;
        this.urlFormats = r103;
    }

    public /* synthetic */ ImageObj(String r100, int r101, int r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
