package ku1;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lku1/b;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "upgradeAllScene", ce.f26391f, "setUpgradeAllScene", "", "", "astScene", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setAstScene", "(Ljava/util/List;)V", "fetchFull", "c", "setFetchFull", "logFeatureChange", "d", "setLogFeatureChange", "logStrategyExecute", "e", "setLogStrategyExecute", "testStrategyName", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTestStrategyName", "(Ljava/lang/String;)V", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("ast_scene")
    private List<String> astScene;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fetch_full")
    private boolean fetchFull;

    @SerializedName("log_feature_change")
    private boolean logFeatureChange;

    @SerializedName("log_strategy_execute")
    private boolean logStrategyExecute;

    @SerializedName("test_strategy_name")
    private String testStrategyName;

    @SerializedName("upgrade_all_scene")
    private boolean upgradeAllScene;

    public b() {
        this.astScene = new ArrayList();
        this.testStrategyName = "";
    }

    public final List<String> a() {
        return this.astScene;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.fetchFull;
    }

    public final boolean d() {
        return this.logFeatureChange;
    }

    public final boolean e() {
        return this.logStrategyExecute;
    }

    public final String f() {
        return this.testStrategyName;
    }

    public final boolean g() {
        return this.upgradeAllScene;
    }
}
