package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/settings/provider/chat/ImageGenerateHeicConfig;", "", "<init>", "()V", "thumbImageUseHeic", "", "getThumbImageUseHeic", "()Z", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w0 {

    @SerializedName("thumb_image_use_heic")
    private final boolean thumbImageUseHeic;

    public w0() {
        this.thumbImageUseHeic = true;
    }

    public final boolean a() {
        return this.thumbImageUseHeic;
    }
}
