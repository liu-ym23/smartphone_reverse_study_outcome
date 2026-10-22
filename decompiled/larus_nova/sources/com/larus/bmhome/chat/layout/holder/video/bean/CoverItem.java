package com.larus.bmhome.chat.layout.holder.video.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;", "Ljava/io/Serializable;", "key", "", "imageThumb", "Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;", "previewImage", "imageUri", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getImageThumb", "()Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;", "getPreviewImage", "getImageUri", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverItem implements Serializable {

    @SerializedName("image_thumb")
    private final CoverImageEntity imageThumb;

    @SerializedName("image_uri")
    private final String imageUri;

    @SerializedName("key")
    private final String key;

    @SerializedName("preview_img")
    private final CoverImageEntity previewImage;

    public CoverItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CoverItem copy$default(CoverItem r100, String r101, CoverImageEntity r102, CoverImageEntity r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.imageThumb;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.previewImage;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.imageUri;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.key;
    }

    public final CoverImageEntity component2() {
        return this.imageThumb;
    }

    public final CoverImageEntity component3() {
        return this.previewImage;
    }

    public final String component4() {
        return this.imageUri;
    }

    public final CoverItem copy(String r100, CoverImageEntity r101, CoverImageEntity r102, String r103) {
        return new CoverItem(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoverItem) == true) goto L8;
        return false;
    L8:
        CoverItem r101 = (CoverItem) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewImage, r101.previewImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUri, r101.imageUri) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CoverImageEntity r104 = this.imageThumb;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CoverImageEntity r107 = this.previewImage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imageUri;
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
        return "CoverItem(key=" + this.key + ", imageThumb=" + this.imageThumb + ", previewImage=" + this.previewImage + ", imageUri=" + this.imageUri + ')';
    }

    public final CoverImageEntity getImageThumb() {
        return this.imageThumb;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getKey() {
        return this.key;
    }

    public final CoverImageEntity getPreviewImage() {
        return this.previewImage;
    }

    public CoverItem(String r100, CoverImageEntity r101, CoverImageEntity r102, String r103) {
        this.key = r100;
        this.imageThumb = r101;
        this.previewImage = r102;
        this.imageUri = r103;
    }

    public /* synthetic */ CoverItem(String r100, CoverImageEntity r101, CoverImageEntity r102, String r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
