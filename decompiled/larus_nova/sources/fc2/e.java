package fc2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lfc2/e;", "", "", "audioEnable", "Z", "c", "()Z", "asrEnable", "b", "asrConnectOpt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "delayTime", "J", "getDelayTime", "()J", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("asr_connect_opt")
    private final boolean asrConnectOpt;

    @SerializedName("asr_permission_enable")
    private final boolean asrEnable;

    @SerializedName("audio_permission_enable")
    private final boolean audioEnable;

    @SerializedName("asr_close_delay")
    private final long delayTime;

    public e() {
        this.audioEnable = true;
        this.asrEnable = true;
        this.asrConnectOpt = true;
        this.delayTime = 500;
    }

    public final boolean a() {
        return this.asrConnectOpt;
    }

    public final boolean b() {
        return this.asrEnable;
    }

    public final boolean c() {
        return this.audioEnable;
    }
}
