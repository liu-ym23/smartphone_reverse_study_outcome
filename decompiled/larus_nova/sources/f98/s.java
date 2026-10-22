package f98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/avlink/e/model/VisionMeta;", "", "<init>", "()V", "picId", "", "getPicId", "()Ljava/lang/String;", "setPicId", "(Ljava/lang/String;)V", "side", "", "getSide$annotations", "getSide", "()Ljava/lang/Integer;", "setSide", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName("pic_id")
    private String picId;

    @SerializedName("side_type")
    private Integer side;

    public s() {
        this.side = 0;
    }

    public final void a(String r100) {
        this.picId = r100;
    }

    public final void b(Integer r100) {
        this.side = r100;
    }
}
