package com.larus.uaigc.api;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003Jf\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/uaigc/api/GetResourceWithoutWatermarkData;", "", "withoutWatermark", "", "downloadImage", "", "", "Lcom/larus/uaigc/api/CreationNoWatermarkImage;", "previewImage", "downloadVideo", "Lcom/google/gson/JsonElement;", "previewVideo", "<init>", "(Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "getWithoutWatermark", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDownloadImage", "()Ljava/util/Map;", "getPreviewImage", "getDownloadVideo", "()Lcom/google/gson/JsonElement;", "getPreviewVideo", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)Lcom/larus/uaigc/api/GetResourceWithoutWatermarkData;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("download_image")
    private final Map<String, c> downloadImage;

    @SerializedName("download_video")
    private final JsonElement downloadVideo;

    @SerializedName("preview_image")
    private final Map<String, c> previewImage;

    @SerializedName("preview_video")
    private final JsonElement previewVideo;

    @SerializedName("without_watermark")
    private final Boolean withoutWatermark;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.withoutWatermark, r101.withoutWatermark) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadImage, r101.downloadImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewImage, r101.previewImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.downloadVideo, r101.downloadVideo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.previewVideo, r101.previewVideo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.withoutWatermark;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, c> r104 = this.downloadImage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, c> r107 = this.previewImage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JsonElement r110 = this.downloadVideo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        JsonElement r113 = this.previewVideo;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public final String toString() {
        return "GetResourceWithoutWatermarkData(withoutWatermark=" + this.withoutWatermark + ", downloadImage=" + this.downloadImage + ", previewImage=" + this.previewImage + ", downloadVideo=" + this.downloadVideo + ", previewVideo=" + this.previewVideo + ')';
    }

    public i() {
        this.withoutWatermark = Boolean.FALSE;
        this.downloadImage = null;
        this.previewImage = null;
        this.downloadVideo = null;
        this.previewVideo = null;
    }

    public final Map<String, c> a() {
        return this.downloadImage;
    }

    public final JsonElement b() {
        return this.downloadVideo;
    }

    public final Map<String, c> c() {
        return this.previewImage;
    }

    public final JsonElement d() {
        return this.previewVideo;
    }

    public final Boolean e() {
        return this.withoutWatermark;
    }
}
