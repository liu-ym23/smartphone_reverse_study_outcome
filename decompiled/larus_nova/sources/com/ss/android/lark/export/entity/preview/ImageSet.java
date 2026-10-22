package com.ss.android.lark.export.entity.preview;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.ss.android.lark.image.entity.Image;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0000J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ji\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006)"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ImageSet;", "Ljava/io/Serializable;", "key", "", PlayerResolution.SDKKEY.ORIGIN, "Lcom/ss/android/lark/image/entity/Image;", DocCallbackImpl.KEY_THUMBNAIL, "middle", "thumbnailWebp", "middleWebp", "middleMp4", "cover", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;Lcom/ss/android/lark/image/entity/Image;)V", "getKey", "()Ljava/lang/String;", "getOrigin", "()Lcom/ss/android/lark/image/entity/Image;", "getThumbnail", "getMiddle", "getThumbnailWebp", "getMiddleWebp", "getMiddleMp4", "getCover", "equals", "", "other", "", "hashCode", "", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSet implements Serializable {
    private final Image cover;
    private final String key;
    private final Image middle;
    private final Image middleMp4;
    private final Image middleWebp;
    private final Image origin;
    private final Image thumbnail;
    private final Image thumbnailWebp;

    public ImageSet() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ImageSet copy$default(ImageSet r100, String r110, Image r111, Image r112, Image r113, Image r114, Image r115, Image r116, Image r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.key;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Image r102 = r100.origin;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Image r103 = r100.thumbnail;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Image r104 = r100.middle;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Image r105 = r100.thumbnailWebp;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Image r106 = r100.middleWebp;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Image r107 = r100.middleMp4;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Image r108 = r100.cover;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final Image component2() {
        return this.origin;
    }

    public final Image component3() {
        return this.thumbnail;
    }

    public final Image component4() {
        return this.middle;
    }

    public final Image component5() {
        return this.thumbnailWebp;
    }

    public final Image component6() {
        return this.middleWebp;
    }

    public final Image component7() {
        return this.middleMp4;
    }

    public final Image component8() {
        return this.cover;
    }

    public final ImageSet copy(String r110, Image r111, Image r112, Image r113, Image r114, Image r115, Image r116, Image r117) {
        return new ImageSet(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public String toString() {
        return "ImageSet(key=" + this.key + ", origin=" + this.origin + ", thumbnail=" + this.thumbnail + ", middle=" + this.middle + ", thumbnailWebp=" + this.thumbnailWebp + ", middleWebp=" + this.middleWebp + ", middleMp4=" + this.middleMp4 + ", cover=" + this.cover + ')';
    }

    public final ImageSet clone() {
        return new ImageSet(this.key, this.origin, this.thumbnail, this.middle, this.thumbnailWebp, this.middleWebp, this.middleMp4, this.cover);
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Image r104 = this.origin;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Image r107 = this.thumbnail;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Image r110 = this.middle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Image r113 = this.thumbnailWebp;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Image r116 = this.middleWebp;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Image r119 = this.middleMp4;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Image r122 = this.cover;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final Image getCover() {
        return this.cover;
    }

    public final String getKey() {
        return this.key;
    }

    public final Image getMiddle() {
        return this.middle;
    }

    public final Image getMiddleMp4() {
        return this.middleMp4;
    }

    public final Image getMiddleWebp() {
        return this.middleWebp;
    }

    public final Image getOrigin() {
        return this.origin;
    }

    public final Image getThumbnail() {
        return this.thumbnail;
    }

    public final Image getThumbnailWebp() {
        return this.thumbnailWebp;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ImageSet.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.ImageSet");
        ImageSet r102 = (ImageSet) r100;
        if (Intrinsics.areEqual(this.key, r102.key) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.origin, r102.origin) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.thumbnail, r102.thumbnail) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.middle, r102.middle) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.thumbnailWebp, r102.thumbnailWebp) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.middleWebp, r102.middleWebp) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.middleMp4, r102.middleMp4) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.cover, r102.cover) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public ImageSet(String r100, Image r101, Image r102, Image r103, Image r104, Image r105, Image r106, Image r107) {
        this.key = r100;
        this.origin = r101;
        this.thumbnail = r102;
        this.middle = r103;
        this.thumbnailWebp = r104;
        this.middleWebp = r105;
        this.middleMp4 = r106;
        this.cover = r107;
    }

    public /* synthetic */ ImageSet(String r110, Image r111, Image r112, Image r113, Image r114, Image r115, Image r116, Image r117, int r118, DefaultConstructorMarker r119) {
        Image r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Image r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Image r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Image r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Image r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Image r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Image r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
