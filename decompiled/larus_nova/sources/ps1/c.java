package ps1;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lps1/c;", "", "", com.heytap.mcssdk.constant.b.f276371u, "Ljava/lang/String;", "getAppID", "()Ljava/lang/String;", "token", "getToken", "asrCluster", "getAsrCluster", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("appid")
    private final String appID;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_ASR_CLUSTER_STRING)
    private final String asrCluster;

    @SerializedName("token")
    private final String token;

    public c() {
        this.appID = "NgkPlWgFic";
        this.token = "nzR3DG0EqO9RWalGyzQt1s0DiawucFS1";
        this.asrCluster = "volc_input_common";
    }
}
