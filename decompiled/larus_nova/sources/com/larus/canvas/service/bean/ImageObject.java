package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/larus/canvas/service/bean/ImageObject;", "Ljava/io/Serializable;", "uri", "", "url", "width", "", "height", "urlFormats", "", "aiCreationImage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "heicUrl", "getHeicUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "()Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/larus/canvas/service/bean/ImageObject;", "equals", "other", "", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageObject implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("ai_creation_image")
    public final Boolean aiCreationImage;

    @SerializedName("height")
    public final Integer height;

    @SerializedName("uri")
    public final String uri;

    @SerializedName("url")
    public final String url;

    @SerializedName("url_formats")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final Map<String, String> urlFormats;

    @SerializedName("width")
    public final Integer width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageObject() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageObject copy$default(ImageObject r100, String r101, String r102, Integer r103, Integer r104, Map r105, Boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.url;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.width;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.height;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.urlFormats;
    L17:
        Map r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.aiCreationImage;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final Map<String, String> component5() {
        return this.urlFormats;
    }

    public final Boolean component6() {
        return this.aiCreationImage;
    }

    public final ImageObject copy(String r100, String r110, Integer r111, Integer r112, Map<String, String> r113, Boolean r114) {
        return new ImageObject(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageObject) == true) goto L8;
        return false;
    L8:
        ImageObject r101 = (ImageObject) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.urlFormats, r101.urlFormats) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aiCreationImage, r101.aiCreationImage) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.uri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.width;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.height;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.urlFormats;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.aiCreationImage;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ImageObject(uri=" + this.uri + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", urlFormats=" + this.urlFormats + ", aiCreationImage=" + this.aiCreationImage + ')';
    }

    public final String getHeicUrl() {
        Map<String, String> r100 = this.urlFormats;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("heic");
    }

    public ImageObject(String r100, String r101, Integer r102, Integer r103, Map<String, String> r104, Boolean r105) {
        this.uri = r100;
        this.url = r101;
        this.width = r102;
        this.height = r103;
        this.urlFormats = r104;
        this.aiCreationImage = r105;
    }

    public /* synthetic */ ImageObject(String r100, String r101, Integer r102, Integer r103, Map r110, Boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        Integer r105 = r102;
        if ((r112 & 8) == 0) goto L16;
        r103 = 0;
    L16:
        Integer r106 = r103;
        if ((r112 & 16) == 0) goto L19;
        Map r107 = null;
    L21:
        if ((r112 & 32) == 0) goto L23;
        Boolean r115 = null;
    L24:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L23:
        r115 = r111;
        goto L24
    L19:
        r107 = r110;
        goto L21
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
