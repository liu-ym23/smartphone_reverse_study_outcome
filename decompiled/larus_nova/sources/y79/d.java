package y79;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.ImageObj;
import com.tencent.connect.share.QzonePublish;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003Jy\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\tHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/larus/drive/sdk/api/file/upload/UploadDriveFileInfo;", "", "fileName", "", "fileUri", "fileUrl", "fileSize", "", "fileType", "", "ccmType", "imageThumb", "Lcom/larus/im/bean/message/ImageObj;", "imageOri", "videoCover", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;F)V", "getFileName", "()Ljava/lang/String;", "getFileUri", "getFileUrl", "getFileSize", "()J", "getFileType", "()I", "getCcmType", "getImageThumb", "()Lcom/larus/im/bean/message/ImageObj;", "setImageThumb", "(Lcom/larus/im/bean/message/ImageObj;)V", "getImageOri", "setImageOri", "getVideoCover", "setVideoCover", "getVideoDuration", "()F", "setVideoDuration", "(F)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("ccm_type")
    private final int ccmType;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("file_size")
    private final long fileSize;

    @SerializedName("file_type")
    private final int fileType;

    @SerializedName("file_uri")
    private final String fileUri;

    @SerializedName(ShareType.FILE_URL)
    private final String fileUrl;

    @SerializedName("image_ori")
    private ImageObj imageOri;

    @SerializedName("image_thumb")
    private ImageObj imageThumb;

    @SerializedName("video_cover")
    private ImageObj videoCover;

    @SerializedName("video_duration")
    private float videoDuration;

    public static final class a {
    }

    static {
    }

    public d() {
        this(null, null, null, 0, 0, 0, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileUri, r101.fileUri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileUrl, r101.fileUrl) == true) goto L18;
        return false;
    L18:
        if (this.fileSize == r101.fileSize) goto L21;
        return false;
    L21:
        if (this.fileType == r101.fileType) goto L24;
        return false;
    L24:
        if (this.ccmType == r101.ccmType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.videoCover, r101.videoCover) == true) goto L36;
        return false;
    L36:
        if (Float.compare(this.videoDuration, r101.videoDuration) == 0) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.fileName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.fileUri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.fileUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.fileSize;
        int r111 = (((((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.fileType) * 31) + this.ccmType) * 31;
        ImageObj r112 = this.imageThumb;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        ImageObj r115 = this.imageOri;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        ImageObj r118 = this.videoCover;
        if (r118 == null) goto L27;
        r101 = r118.hashCode();
    L27:
        return ((r117 + r101) * 31) + Float.floatToIntBits(this.videoDuration);
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
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
        return "UploadDriveFileInfo(fileName=" + this.fileName + ", fileUri=" + this.fileUri + ", fileUrl=" + this.fileUrl + ", fileSize=" + this.fileSize + ", fileType=" + this.fileType + ", ccmType=" + this.ccmType + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", videoCover=" + this.videoCover + ", videoDuration=" + this.videoDuration + ')';
    }

    public final int a() {
        return this.ccmType;
    }

    public final String b() {
        return this.fileName;
    }

    public final long c() {
        return this.fileSize;
    }

    public final int d() {
        return this.fileType;
    }

    public final String e() {
        return this.fileUri;
    }

    public final String f() {
        return this.fileUrl;
    }

    public final ImageObj g() {
        return this.imageOri;
    }

    public final ImageObj h() {
        return this.imageThumb;
    }

    public final ImageObj i() {
        return this.videoCover;
    }

    public final float j() {
        return this.videoDuration;
    }

    public d(String r100, String r101, String r102, long r103, int r104, int r105, ImageObj r110, ImageObj r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = 0;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = 12;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r110 = null;
    L24:
        if ((r112 & 128) == 0) goto L26;
        r111 = null;
    L26:
        this.fileName = r100;
        this.fileUri = r101;
        this.fileUrl = r102;
        this.fileSize = r103;
        this.fileType = r104;
        this.ccmType = r105;
        this.imageThumb = r110;
        this.imageOri = r111;
        this.videoCover = null;
        this.videoDuration = 0.0f;
    }
}
