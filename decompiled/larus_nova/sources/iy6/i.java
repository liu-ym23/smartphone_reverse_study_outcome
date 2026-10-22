package iy6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Liy6/i;", "", "", "vid", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "", "playUrlList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "urlExpire", "getUrlExpire", "", "width", "I", "getWidth", "()I", "height", "getHeight", "posterImage", "getPosterImage", "musicUrl", "getMusicUrl", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("height")
    private final int height;

    @SerializedName("music_url")
    private final String musicUrl;

    @SerializedName("play_url_list")
    private final List<String> playUrlList;

    @SerializedName("poster_image")
    private final String posterImage;

    @SerializedName("url_expire")
    private final String urlExpire;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("width")
    private final int width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.playUrlList, r101.playUrlList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urlExpire, r101.urlExpire) == true) goto L18;
        return false;
    L18:
        if (this.width == r101.width) goto L21;
        return false;
    L21:
        if (this.height == r101.height) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.posterImage, r101.posterImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.musicUrl, r101.musicUrl) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.playUrlList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.urlExpire;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + this.width) * 31) + this.height) * 31;
        String r110 = this.posterImage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.musicUrl;
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
        return "PoiVideo(vid=" + this.vid + ", playUrlList=" + this.playUrlList + ", urlExpire=" + this.urlExpire + ", width=" + this.width + ", height=" + this.height + ", posterImage=" + this.posterImage + ", musicUrl=" + this.musicUrl + ')';
    }

    public i() {
        this.vid = null;
        this.playUrlList = null;
        this.urlExpire = null;
        this.width = 0;
        this.height = 0;
        this.posterImage = null;
        this.musicUrl = null;
    }

    public final List<String> a() {
        return this.playUrlList;
    }
}
