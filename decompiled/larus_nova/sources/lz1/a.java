package lz1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Llz1/a;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "", "", "durationMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setDurationMap", "(Ljava/util/Map;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("duration")
    private Map<Integer, Float> durationMap;

    @SerializedName("enable")
    private boolean enable;

    public a() {
        this.durationMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(6, Float.valueOf(10.0f)), TuplesKt.to(7, Float.valueOf(2.0f)), TuplesKt.to(8, Float.valueOf(0.5f))});
    }

    public final Map<Integer, Float> a() {
        return this.durationMap;
    }

    public final boolean b() {
        return this.enable;
    }
}
