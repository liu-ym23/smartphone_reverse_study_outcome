package l90;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Ll90/b;", "", "", "jMem", "J", "getJMem", "()J", "setJMem", "(J)V", "nMem", "getNMem", "setNMem", "", "fps", "D", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()D", "setFps", "(D)V", "<init>", "()V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("fps")
    private double fps;

    @SerializedName("availableMem")
    private long jMem;

    @SerializedName("availableNMem")
    private long nMem;

    public b() {
    }

    public final double a() {
        return this.fps;
    }
}
