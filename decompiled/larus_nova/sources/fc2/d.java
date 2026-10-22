package fc2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lfc2/d;", "", "", "enableInterest", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "enableTruth", "b", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("enable_interest")
    private final boolean enableInterest;

    @SerializedName("enable_truth")
    private final boolean enableTruth;

    public d() {
    }

    public final boolean a() {
        return this.enableInterest;
    }

    public final boolean b() {
        return this.enableTruth;
    }
}
