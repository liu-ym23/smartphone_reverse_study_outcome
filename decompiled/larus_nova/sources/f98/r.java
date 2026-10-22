package f98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/larus/avlink/e/model/VisionInfo;", "", "<init>", "()V", "visionMeta", "Lcom/larus/avlink/e/model/VisionMeta;", "getVisionMeta", "()Lcom/larus/avlink/e/model/VisionMeta;", "setVisionMeta", "(Lcom/larus/avlink/e/model/VisionMeta;)V", "visionInfoType", "", "getVisionInfoType$annotations", "getVisionInfoType", "()Ljava/lang/Integer;", "setVisionInfoType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ocrDetail", "", "getOcrDetail", "()Ljava/lang/String;", "setOcrDetail", "(Ljava/lang/String;)V", "ocrDetectionRes", "", "getOcrDetectionRes", "()Ljava/lang/Boolean;", "setOcrDetectionRes", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName("ocr_detail")
    private String ocrDetail;

    @SerializedName("ocr_detection_res")
    private Boolean ocrDetectionRes;

    @SerializedName("vision_info_type")
    private Integer visionInfoType;

    @SerializedName("vision_meta")
    private s visionMeta;

    public r() {
    }

    public final void a(String r100) {
        this.ocrDetail = r100;
    }

    public final void b(Boolean r100) {
        this.ocrDetectionRes = r100;
    }

    public final void c(Integer r100) {
        this.visionInfoType = r100;
    }

    public final void d(s r100) {
        this.visionMeta = r100;
    }
}
