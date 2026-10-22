package ey9;

import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Js\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "", "vid", "", "downloadUrl", "duration", "", "videoType", "videoModel", "cover", "Lcom/larus/uaigc/avatar/api/Image;", DocCallbackImpl.KEY_THUMBNAIL, "readingText", "reviewInfo", "Lcom/larus/uaigc/avatar/api/VideoReviewInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Lcom/larus/uaigc/avatar/api/Image;Lcom/larus/uaigc/avatar/api/Image;Ljava/lang/String;Lcom/larus/uaigc/avatar/api/VideoReviewInfo;)V", "getVid", "()Ljava/lang/String;", "getDownloadUrl", "getDuration", "()D", "getVideoType", "getVideoModel", "getCover", "()Lcom/larus/uaigc/avatar/api/Image;", "getThumbnail", "getReadingText", "getReviewInfo", "()Lcom/larus/uaigc/avatar/api/VideoReviewInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("cover")
    private final f cover;

    @SerializedName("download_url")
    private final String downloadUrl;

    @SerializedName("duration")
    private final double duration;

    @SerializedName("reading_text")
    private final String readingText;

    @SerializedName("review_info")
    private final m reviewInfo;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private final f thumbnail;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("video_model")
    private final String videoModel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE)
    private final String videoType;

    public a() {
        this(null, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.duration, r101.duration) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoType, r101.videoType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoModel, r101.videoModel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.thumbnail, r101.thumbnail) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.readingText, r101.readingText) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.reviewInfo, r101.reviewInfo) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.downloadUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = Double.doubleToLongBits(this.duration);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.videoType;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.videoModel;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        f r115 = this.cover;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        f r118 = this.thumbnail;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.readingText;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        m r124 = this.reviewInfo;
        if (r124 == null) goto L35;
        r101 = r124.hashCode();
    L35:
        return r123 + r101;
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiReplicaRefVideo(vid=" + this.vid + ", downloadUrl=" + this.downloadUrl + ", duration=" + this.duration + ", videoType=" + this.videoType + ", videoModel=" + this.videoModel + ", cover=" + this.cover + ", thumbnail=" + this.thumbnail + ", readingText=" + this.readingText + ", reviewInfo=" + this.reviewInfo + ')';
    }

    public final f a() {
        return this.cover;
    }

    public final String b() {
        return this.downloadUrl;
    }

    public final double c() {
        return this.duration;
    }

    public final f d() {
        return this.thumbnail;
    }

    public final String e() {
        return this.vid;
    }

    public final String f() {
        return this.videoModel;
    }

    public final String g() {
        return this.videoType;
    }

    public a(String r100, double r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 128) == 0) goto L14;
        r103 = null;
    L14:
        this.vid = r100;
        this.downloadUrl = null;
        this.duration = r101;
        this.videoType = r102;
        this.videoModel = null;
        this.cover = null;
        this.thumbnail = null;
        this.readingText = r103;
        this.reviewInfo = null;
    }
}
