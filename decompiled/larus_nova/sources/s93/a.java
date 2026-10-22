package s93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ls93/a;", "", "", "forbidOrderOnePrefetch", "Z", "b", "()Z", "enablePreloadWhitelist", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "", "tabPreloadWhitelist", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable_preload_whitelist")
    private final Boolean enablePreloadWhitelist;

    @SerializedName("forbid_order_one_prefetch")
    private final boolean forbidOrderOnePrefetch;

    @SerializedName("tab_preload_whitelist")
    private final List<Integer> tabPreloadWhitelist;

    public a() {
        this.forbidOrderOnePrefetch = true;
        this.enablePreloadWhitelist = Boolean.FALSE;
    }

    public final Boolean a() {
        return this.enablePreloadWhitelist;
    }

    public final boolean b() {
        return this.forbidOrderOnePrefetch;
    }

    public final List<Integer> c() {
        return this.tabPreloadWhitelist;
    }
}
