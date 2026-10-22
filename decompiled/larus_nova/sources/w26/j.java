package w26;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000f¨\u00066"}, d2 = {"Lw26/j;", "", "", "enableMemCache", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableMemCache", "(Z)V", "", "memorySize", "I", ce.f26391f, "()I", "setMemorySize", "(I)V", "enableRemoteConfig", "e", "setEnableRemoteConfig", "", "", "prefix2ak", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "setPrefix2ak", "(Ljava/util/Map;)V", "enablePreload", "b", "setEnablePreload", "preloadTemplateSize", ce.f26396k, "setPreloadTemplateSize", "preloadSubResMemSize", ce.f26395j, "setPreloadSubResMemSize", "", "preloadMemWarningProportion", "D", RXScreenCaptureService.KEY_INDEX, "()D", "setPreloadMemWarningProportion", "(D)V", "enableRedirectCache", "c", "setEnableRedirectCache", "enableRedirectDefaultCache", "d", "setEnableRedirectDefaultCache", "globalRedirectCacheSize", "f", "setGlobalRedirectCacheSize", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("enable_mem")
    private boolean enableMemCache;

    @SerializedName("enable_preload")
    private boolean enablePreload;

    @SerializedName("enable_redirect_cache")
    private boolean enableRedirectCache;

    @SerializedName("enable_redirect_default_cache")
    private boolean enableRedirectDefaultCache;

    @SerializedName("enable_remote_config")
    private boolean enableRemoteConfig;

    @SerializedName("global_redirect_cache_size")
    private int globalRedirectCacheSize;

    @SerializedName("mem_size")
    private int memorySize;

    @SerializedName("prefix2ak")
    private Map<String, String> prefix2ak;

    @SerializedName("preload_memory_warning_proportion")
    private double preloadMemWarningProportion;

    @SerializedName("preload_sub_res_mem_size")
    private int preloadSubResMemSize;

    @SerializedName("preload_template_size")
    private int preloadTemplateSize;

    public j() {
        this.enableMemCache = true;
        this.memorySize = 3000000;
        this.enableRemoteConfig = true;
        this.prefix2ak = new LinkedHashMap();
        this.enablePreload = true;
        this.preloadTemplateSize = 10;
        this.preloadSubResMemSize = 10;
        this.preloadMemWarningProportion = 0.1d;
        this.enableRedirectCache = true;
        this.globalRedirectCacheSize = 1000;
    }

    public final boolean a() {
        return this.enableMemCache;
    }

    public final boolean b() {
        return this.enablePreload;
    }

    public final boolean c() {
        return this.enableRedirectCache;
    }

    public final boolean d() {
        return this.enableRedirectDefaultCache;
    }

    public final boolean e() {
        return this.enableRemoteConfig;
    }

    public final int f() {
        return this.globalRedirectCacheSize;
    }

    public final int g() {
        return this.memorySize;
    }

    public final Map<String, String> h() {
        return this.prefix2ak;
    }

    public final double i() {
        return this.preloadMemWarningProportion;
    }

    public final int j() {
        return this.preloadSubResMemSize;
    }

    public final int k() {
        return this.preloadTemplateSize;
    }
}
