package iy6;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.locallife.poi.media.entity.PoiMediaStyle;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Liy6/g;", "", "", "style", "I", "e", "()I", "", "mediaId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "authorId", "b", "Liy6/i;", "video", "Liy6/i;", ce.f26391f, "()Liy6/i;", "Liy6/e;", "album", "Liy6/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Liy6/e;", "createSource", "c", "updateSource", "f", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("album")
    private final e album;

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("create_source")
    private final String createSource;

    @SerializedName(AppConstants.BUNDLE_MEDIA_ID)
    private final String mediaId;

    @SerializedName("style")
    private final int style;

    @SerializedName("update_source")
    private final String updateSource;

    @SerializedName("video")
    private final i video;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.style == r101.style) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mediaId, r101.mediaId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.album, r101.album) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createSource, r101.createSource) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.updateSource, r101.updateSource) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.style * 31;
        String r101 = this.mediaId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.authorId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        i r108 = this.video;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        e r111 = this.album;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.createSource;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.updateSource;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiMedia(style=" + this.style + ", mediaId=" + this.mediaId + ", authorId=" + this.authorId + ", video=" + this.video + ", album=" + this.album + ", createSource=" + this.createSource + ", updateSource=" + this.updateSource + ')';
    }

    public g() {
        this.style = PoiMediaStyle.POI_MEDIA_STYLE_VIDEO.getStyle();
        this.mediaId = null;
        this.authorId = null;
        this.video = null;
        this.album = null;
        this.createSource = null;
        this.updateSource = null;
    }

    public final e a() {
        return this.album;
    }

    public final String b() {
        return this.authorId;
    }

    public final String c() {
        return this.createSource;
    }

    public final String d() {
        return this.mediaId;
    }

    public final int e() {
        return this.style;
    }

    public final String f() {
        return this.updateSource;
    }

    public final i g() {
        return this.video;
    }
}
