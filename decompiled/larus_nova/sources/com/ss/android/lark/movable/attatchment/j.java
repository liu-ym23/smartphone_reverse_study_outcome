package com.ss.android.lark.movable.attatchment;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageGalleryItem;", "", "originUrl", "", "key", "caption", "isDriveImage", "", "isExtraLong", "width", "", "height", "itemViewFrame", "Lcom/ss/android/lark/movable/attatchment/CGFrame;", "imageViewSize", "Lcom/ss/android/lark/movable/attatchment/CGSize;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZFFLcom/ss/android/lark/movable/attatchment/CGFrame;Lcom/ss/android/lark/movable/attatchment/CGSize;)V", "getOriginUrl", "()Ljava/lang/String;", "getKey", "getCaption", "()Z", "getWidth", "()F", "getHeight", "getItemViewFrame", "()Lcom/ss/android/lark/movable/attatchment/CGFrame;", "getImageViewSize", "()Lcom/ss/android/lark/movable/attatchment/CGSize;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("caption")
    private final String caption;

    @SerializedName("height")
    private final float height;

    @SerializedName("image_view_size")
    private final g imageViewSize;

    @SerializedName("is_drive_image")
    private final boolean isDriveImage;

    @SerializedName("is_extra_long")
    private final boolean isExtraLong;

    @SerializedName("item_view_frame")
    private final e itemViewFrame;

    @SerializedName("key")
    private final String key;

    @SerializedName("origin_url")
    private final String originUrl;

    @SerializedName("width")
    private final float width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.originUrl, r101.originUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.caption, r101.caption) == true) goto L18;
        return false;
    L18:
        if (this.isDriveImage == r101.isDriveImage) goto L21;
        return false;
    L21:
        if (this.isExtraLong == r101.isExtraLong) goto L24;
        return false;
    L24:
        if (Float.compare(this.width, r101.width) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.height, r101.height) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.itemViewFrame, r101.itemViewFrame) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageViewSize, r101.imageViewSize) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.originUrl.hashCode() * 31) + this.key.hashCode()) * 31) + this.caption.hashCode()) * 31;
        int r101 = 1231;
        if (this.isDriveImage == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isExtraLong == true) goto L11;
        r101 = 1237;
    L11:
        return ((((((((r103 + r101) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + this.itemViewFrame.hashCode()) * 31) + this.imageViewSize.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageGalleryItem(originUrl=" + this.originUrl + ", key=" + this.key + ", caption=" + this.caption + ", isDriveImage=" + this.isDriveImage + ", isExtraLong=" + this.isExtraLong + ", width=" + this.width + ", height=" + this.height + ", itemViewFrame=" + this.itemViewFrame + ", imageViewSize=" + this.imageViewSize + ')';
    }

    public final String b() {
        return this.caption;
    }

    public final float c() {
        return this.height;
    }

    public final g d() {
        return this.imageViewSize;
    }

    public final e e() {
        return this.itemViewFrame;
    }

    public final String f() {
        return this.key;
    }

    public final String g() {
        return this.originUrl;
    }

    public final float h() {
        return this.width;
    }

    public final boolean i() {
        return this.isExtraLong;
    }

    public static j a(j r110, float r111, float r112, e r113, g r114) {
        String r100 = r110.originUrl;
        String r101 = r110.key;
        String r102 = r110.caption;
        boolean r103 = r110.isDriveImage;
        boolean r104 = r110.isExtraLong;
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "caption");
        Intrinsics.checkNotNullParameter(r113, "itemViewFrame");
        Intrinsics.checkNotNullParameter(r114, "imageViewSize");
        return new j(r100, r101, r102, r103, r104, r111, r112, r113, r114);
    }

    public j(String r100, String r101, String r102, boolean r103, boolean r104, float r105, float r106, e r107, g r110) {
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "caption");
        Intrinsics.checkNotNullParameter(r107, "itemViewFrame");
        Intrinsics.checkNotNullParameter(r110, "imageViewSize");
        this.originUrl = r100;
        this.key = r101;
        this.caption = r102;
        this.isDriveImage = r103;
        this.isExtraLong = r104;
        this.width = r105;
        this.height = r106;
        this.itemViewFrame = r107;
        this.imageViewSize = r110;
    }
}
