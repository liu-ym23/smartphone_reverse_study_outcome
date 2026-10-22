package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lnv6/a0;", "", "Lnv6/k0;", "randomStrategyParams", "Lnv6/k0;", "b", "()Lnv6/k0;", "", "firstMeetEffectiveType", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "<init>", "()V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("first_meet_effective_type")
    private final Integer firstMeetEffectiveType;

    @SerializedName("random_strategy_params")
    private final k0 randomStrategyParams;

    public a0() {
    }

    public final Integer a() {
        return this.firstMeetEffectiveType;
    }

    public final k0 b() {
        return this.randomStrategyParams;
    }
}
