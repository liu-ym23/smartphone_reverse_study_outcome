package f98;

import com.google.gson.annotations.SerializedName;
import com.ss.android.vesdk.VECameraSettings$Parameters$NoiseReduce;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R(\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R \u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\"\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R$\u00101\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001e\u00105\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R\u001e\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\b\"\u0004\b?\u0010\n¨\u0006@"}, d2 = {"Lcom/larus/avlink/e/model/FileContent;", "", "<init>", "()V", "contentType", "", "getContentType$annotations", "getContentType", "()I", "setContentType", "(I)V", "data", "", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "width", "getWidth", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "height", "getHeight", "setHeight", "sideType", "getSideType$annotations", "getSideType", "setSideType", "imageId", "getImageId", "setImageId", "shootTime", "", "getShootTime", "()Ljava/lang/Long;", "setShootTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "highQuality", "", "getHighQuality", "()Z", "setHighQuality", "(Z)V", "ext", "getExt", "setExt", "fileStatus", "getFileStatus$annotations", "getFileStatus", "setFileStatus", "size", "getSize", "()J", "setSize", "(J)V", "hasOCR", "getHasOCR", "setHasOCR", "cameraTakeImageState", "getCameraTakeImageState", "setCameraTakeImageState", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("camera_take_image_state")
    private int cameraTakeImageState;

    @SerializedName("content_type")
    private int contentType;

    @SerializedName("data")
    private String data;

    @SerializedName("ext")
    private String ext;

    @SerializedName("status")
    private int fileStatus;

    @SerializedName("has_ocr")
    private boolean hasOCR;

    @SerializedName("height")
    private Integer height;

    @SerializedName(VECameraSettings$Parameters$NoiseReduce.HIGH_QUALITY)
    private boolean highQuality;

    @SerializedName("pic_id")
    private String imageId;

    @SerializedName("pic_shooting_time")
    private Long shootTime;

    @SerializedName("side_type")
    private Integer sideType;

    @SerializedName("size")
    private long size;

    @SerializedName("width")
    private Integer width;

    public l() {
        this.contentType = 1;
        this.sideType = 0;
    }

    public final Integer a() {
        return this.height;
    }

    public final String b() {
        return this.imageId;
    }

    public final long c() {
        return this.size;
    }

    public final Integer d() {
        return this.width;
    }

    public final void e(int r100) {
        this.cameraTakeImageState = r100;
    }

    public final void f(int r100) {
        this.contentType = r100;
    }

    public final void g(String r100) {
        this.data = r100;
    }

    public final void h(String r100) {
        this.ext = r100;
    }

    public final void i(int r100) {
        this.fileStatus = r100;
    }

    public final void j(boolean r100) {
        this.hasOCR = r100;
    }

    public final void k(Integer r100) {
        this.height = r100;
    }

    public final void l(boolean r100) {
        this.highQuality = r100;
    }

    public final void m(String r100) {
        this.imageId = r100;
    }

    public final void n(Long r100) {
        this.shootTime = r100;
    }

    public final void o(Integer r100) {
        this.sideType = r100;
    }

    public final void p(long r100) {
        this.size = r100;
    }

    public final void q(Integer r100) {
        this.width = r100;
    }
}
