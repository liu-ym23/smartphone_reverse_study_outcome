package tn2;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Ltn2/b;", "", "", "mShellTemperatureLevel", "I", "b", "()I", "", "mShellTemperature", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("shell_temperature")
    private final float mShellTemperature;

    @SerializedName("shell_temperature_level")
    private final int mShellTemperatureLevel;

    public b() {
        this.mShellTemperature = 100.0f;
    }

    public final float a() {
        return this.mShellTemperature;
    }

    public final int b() {
        return this.mShellTemperatureLevel;
    }
}
