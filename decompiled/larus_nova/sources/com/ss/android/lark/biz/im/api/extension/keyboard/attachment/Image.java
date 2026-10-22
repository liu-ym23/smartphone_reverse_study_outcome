package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u000f\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0011\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;", "Ljava/io/Serializable;", "key", "", "md5", "imageThumb", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;", "imageOri", "resourceId", "localResPath", "localRealPath", LocationMonitorConst.IDENTIFIER, "ext", "", "previewImage", "isMarked", "", "isCropped", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setMarked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setCropped", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ImageObj;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;", "equals", "other", "", "hashCode", "", "toString", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Image implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("metadata")
    public Map<String, String> ext;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    public String identifier;

    @SerializedName("image_ori")
    public ImageObj imageOri;

    @SerializedName("image_thumb")
    public ImageObj imageThumb;
    private transient Boolean isCropped;
    private transient Boolean isMarked;

    @SerializedName("key")
    public String key;

    @SerializedName("local_real_path")
    public String localRealPath;

    @SerializedName("local_res_path")
    public String localResPath;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    public String f410135md5;

    @SerializedName("preview_img")
    public ImageObj previewImage;

    @SerializedName("resource_id")
    public String resourceId;

    @SerializedName("source")
    public String source;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Image() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Image copy$default(Image r110, String r111, String r112, ImageObj r113, ImageObj r114, String r115, String r210, String r211, String r212, Map r213, ImageObj r214, Boolean r215, Boolean r216, String r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.f410135md5;
    L11:
        if ((r218 & 4) == 0) goto L13;
        ImageObj r102 = r110.imageThumb;
    L15:
        if ((r218 & 8) == 0) goto L17;
        ImageObj r103 = r110.imageOri;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.resourceId;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.localResPath;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.localRealPath;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.identifier;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Map r116 = r110.ext;
    L39:
        if ((r218 & 512) == 0) goto L41;
        ImageObj r117 = r110.previewImage;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r118 = r110.isMarked;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Boolean r119 = r110.isCropped;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        String r108 = r110.source;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final ImageObj component10() {
        return this.previewImage;
    }

    public final Boolean component11() {
        return this.isMarked;
    }

    public final Boolean component12() {
        return this.isCropped;
    }

    public final String component13() {
        return this.source;
    }

    public final String component2() {
        return this.f410135md5;
    }

    public final ImageObj component3() {
        return this.imageThumb;
    }

    public final ImageObj component4() {
        return this.imageOri;
    }

    public final String component5() {
        return this.resourceId;
    }

    public final String component6() {
        return this.localResPath;
    }

    public final String component7() {
        return this.localRealPath;
    }

    public final String component8() {
        return this.identifier;
    }

    public final Map<String, String> component9() {
        return this.ext;
    }

    public final Image copy(String r110, String r111, ImageObj r112, ImageObj r113, String r210, String r211, String r212, String r213, Map<String, String> r214, ImageObj r215, Boolean r216, Boolean r217, String r218) {
        return new Image(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Image) == true) goto L8;
        return false;
    L8:
        Image r101 = (Image) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410135md5, r101.f410135md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.localResPath, r101.localResPath) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.localRealPath, r101.localRealPath) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.previewImage, r101.previewImage) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isMarked, r101.isMarked) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isCropped, r101.isCropped) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f410135md5;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ImageObj r107 = this.imageThumb;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ImageObj r110 = this.imageOri;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.resourceId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.localResPath;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.localRealPath;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.identifier;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.ext;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ImageObj r128 = this.previewImage;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.isMarked;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.isCropped;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.source;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "Image(key=" + this.key + ", md5=" + this.f410135md5 + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", resourceId=" + this.resourceId + ", localResPath=" + this.localResPath + ", localRealPath=" + this.localRealPath + ", identifier=" + this.identifier + ", ext=" + this.ext + ", previewImage=" + this.previewImage + ", isMarked=" + this.isMarked + ", isCropped=" + this.isCropped + ", source=" + this.source + ')';
    }

    public final Boolean isCropped() {
        return this.isCropped;
    }

    public final Boolean isMarked() {
        return this.isMarked;
    }

    public final void setCropped(Boolean r100) {
        this.isCropped = r100;
    }

    public final void setMarked(Boolean r100) {
        this.isMarked = r100;
    }

    public Image(String r100, String r101, ImageObj r102, ImageObj r103, String r104, String r105, String r106, String r107, Map<String, String> r108, ImageObj r110, Boolean r111, Boolean r112, String r113) {
        this.key = r100;
        this.f410135md5 = r101;
        this.imageThumb = r102;
        this.imageOri = r103;
        this.resourceId = r104;
        this.localResPath = r105;
        this.localRealPath = r106;
        this.identifier = r107;
        this.ext = r108;
        this.previewImage = r110;
        this.isMarked = r111;
        this.isCropped = r112;
        this.source = r113;
    }

    public /* synthetic */ Image(String r110, String r111, ImageObj r112, ImageObj r113, String r114, String r210, String r211, String r212, Map r213, ImageObj r214, Boolean r215, Boolean r216, String r217, int r218, DefaultConstructorMarker r219) {
        String r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        ImageObj r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        ImageObj r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Map r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        ImageObj r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Boolean r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
