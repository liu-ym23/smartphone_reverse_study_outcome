package vt1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lvt1/b;", "", "", GearStrategyConsts.EV_SELECT_BEGIN, "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "end", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(GearStrategyConsts.EV_SELECT_BEGIN)
    private final Long begin;

    @SerializedName("end")
    private final Long end;

    public b() {
        this.begin = null;
        this.end = null;
    }

    public final Long a() {
        return this.begin;
    }

    public final Long b() {
        return this.end;
    }
}
