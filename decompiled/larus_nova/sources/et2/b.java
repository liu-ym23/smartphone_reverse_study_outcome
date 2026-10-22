package et2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Let2/b;", "", "", "viewPoolMode", "I", "d", "()I", "setViewPoolMode", "(I)V", "", "contextCache", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setContextCache", "(Z)V", "fixAsyncLoad", "b", "setFixAsyncLoad", "useNewText", "c", "setUseNewText", "<init>", "()V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("view_context_cache")
    private boolean contextCache;

    @SerializedName("fix_async_load")
    private boolean fixAsyncLoad;

    @SerializedName("use_new_text")
    private boolean useNewText;

    @SerializedName("view_pool_mode")
    private int viewPoolMode;

    public b() {
        this.viewPoolMode = 1;
        this.contextCache = true;
        this.fixAsyncLoad = true;
        this.useNewText = true;
    }

    public final boolean a() {
        return this.contextCache;
    }

    public final boolean b() {
        return this.fixAsyncLoad;
    }

    public final boolean c() {
        return this.useNewText;
    }

    public final int d() {
        return this.viewPoolMode;
    }
}
