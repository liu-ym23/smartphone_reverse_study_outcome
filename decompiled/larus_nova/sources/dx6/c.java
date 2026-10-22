package dx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ldx6/c;", "", "", "marginTop", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "marginBottom", "b", "", "", "", "Ldx6/a;", "actionInfos", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "<init>", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public class c {

    @SerializedName("actionInfos")
    private final Map<String, List<a>> actionInfos;

    @SerializedName("marginBottom")
    private final Integer marginBottom;

    @SerializedName("marginTop")
    private final Integer marginTop;

    public c() {
        this.marginTop = 0;
        this.marginBottom = 0;
    }

    public final Map<String, List<a>> a() {
        return this.actionInfos;
    }

    public final Integer b() {
        return this.marginBottom;
    }

    public final Integer c() {
        return this.marginTop;
    }
}
