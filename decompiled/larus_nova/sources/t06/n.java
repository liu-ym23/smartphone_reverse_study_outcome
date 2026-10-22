package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lt06/n;", "Lt06/a;", "", "", "Lt06/f;", "feLimitLoadSourceConfig", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class n extends a {

    @SerializedName("fe_limit_load_source")
    private final Map<String, f> feLimitLoadSourceConfig;

    public n() {
        this.feLimitLoadSourceConfig = null;
    }

    public final Map<String, f> a() {
        return this.feLimitLoadSourceConfig;
    }
}
