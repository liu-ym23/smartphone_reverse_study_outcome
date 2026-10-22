package f98;

import com.google.gson.annotations.SerializedName;
import com.larus.avlink.e.model.VisionIntentionSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/e/model/DoraFilePayload;", "", "<init>", "()V", "visionIntentSource", "", "getVisionIntentSource", "()Ljava/lang/Integer;", "setVisionIntentSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("vision_intent_source")
    private Integer visionIntentSource;

    public c() {
        this.visionIntentSource = Integer.valueOf(VisionIntentionSource.UNKNOWN.getValue());
    }

    public final void a(Integer r100) {
        this.visionIntentSource = r100;
    }
}
