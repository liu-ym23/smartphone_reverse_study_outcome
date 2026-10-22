package fb1;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.connect.share.QzonePublish;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lfb1/e;", "", "", "videoId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", ce.f26395j, "(Ljava/lang/String;)V", "videoFilePath", "d", RXScreenCaptureService.KEY_INDEX, "", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "J", "c", "()J", "h", "(J)V", "", "videoRatio", FaceService.girlLabel, "f", "()F", ce.f26396k, "(F)V", "", "Lcom/bytedance/android/livesdk/message/model/ed;", "colorList", "Ljava/util/List;", "b", "()Ljava/util/List;", ce.f26391f, "(Ljava/util/List;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e {

    @SerializedName("colors_model")
    private List<ed> colorList;

    @SerializedName("video_duration")
    private long videoDuration;

    @SerializedName("video_path")
    private String videoFilePath;

    @SerializedName("video_id")
    private String videoId;

    @SerializedName("video_ratio")
    private float videoRatio;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videoFilePath, r101.videoFilePath) == true) goto L10;
        return false;
    L10:
        if (this.videoDuration == r101.videoDuration) goto L12;
        return false;
    L12:
        if (Float.compare(this.videoRatio, r101.videoRatio) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.colorList, r101.colorList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.videoId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.videoFilePath;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.videoDuration;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + Float.floatToIntBits(this.videoRatio)) * 31;
        List<ed> r109 = this.colorList;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoSourceModel(videoId=" + this.videoId + ", videoFilePath=" + this.videoFilePath + ", videoDuration=" + this.videoDuration + ", videoRatio=" + this.videoRatio + ", colorList=" + this.colorList + ")";
    }

    public final void k() {
        this.videoRatio = 1.7777778f;
    }

    public final List<ed> b() {
        return this.colorList;
    }

    public final long c() {
        return this.videoDuration;
    }

    public final String d() {
        return this.videoFilePath;
    }

    public final String e() {
        return this.videoId;
    }

    public final float f() {
        return this.videoRatio;
    }

    public static e a(e r100) {
        String r101 = r100.videoId;
        String r102 = r100.videoFilePath;
        long r103 = r100.videoDuration;
        float r104 = r100.videoRatio;
        List<ed> r105 = r100.colorList;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "videoId");
        return new e(r101, r102, r103, r104, r105);
    }

    public final void g(List<ed> r100) {
        this.colorList = r100;
    }

    public final void h(long r100) {
        this.videoDuration = r100;
    }

    public final void i(String r100) {
        this.videoFilePath = r100;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoId = r100;
    }

    public e(String r100, String r101, long r102, float r103, List<ed> r104) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        this.videoId = r100;
        this.videoFilePath = r101;
        this.videoDuration = r102;
        this.videoRatio = r103;
        this.colorList = r104;
    }
}
