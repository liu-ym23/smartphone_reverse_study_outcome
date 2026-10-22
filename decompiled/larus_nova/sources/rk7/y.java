package rk7;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lrk7/y;", "", "", "enable", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Lrk7/a0;", "strategies", "Lrk7/a0;", "b", "()Lrk7/a0;", "setStrategies", "(Lrk7/a0;)V", "useKeva", "getUseKeva", "setUseKeva", "<init>", "()V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class y {

    @SerializedName("enabled")
    private Boolean enable;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private a0 strategies;

    @SerializedName("use_keva")
    private Boolean useKeva;

    public y() {
        Boolean r100 = Boolean.FALSE;
        this.enable = r100;
        this.useKeva = r100;
    }

    public final Boolean a() {
        return this.enable;
    }

    public final a0 b() {
        return this.strategies;
    }
}
