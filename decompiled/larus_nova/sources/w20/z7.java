package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lw20/z7;", "", "", ShortVideoSegments.KEY_CAMERA_ID, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "eventTracking", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setEventTracking", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z7 {

    @SerializedName(ShortVideoSegments.KEY_CAMERA_ID)
    private String cameraId;

    @SerializedName("eventTracking")
    private JsonObject eventTracking;

    public z7() {
    }

    public final String a() {
        return this.cameraId;
    }

    public final JsonObject b() {
        return this.eventTracking;
    }
}
