package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/KevaPerfOptConfig;", "", "enableInitRepoMainOnlyOpt", "", "enableGetRepoLockOpt", "enableExecutorOpt", "enableIndependentExecutorOpt", "executorCorePoolSize", "", "<init>", "(ZZZZI)V", "getEnableInitRepoMainOnlyOpt", "()Z", "getEnableGetRepoLockOpt", "getEnableExecutorOpt", "getEnableIndependentExecutorOpt", "getExecutorCorePoolSize", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c2 {

    @SerializedName("enable_executor_opt")
    private final boolean enableExecutorOpt;

    @SerializedName("enable_get_repo_lock_opt")
    private final boolean enableGetRepoLockOpt;

    @SerializedName("enable_independent_executor_opt")
    private final boolean enableIndependentExecutorOpt;

    @SerializedName("enable_init_repo_main_only_opt")
    private final boolean enableInitRepoMainOnlyOpt;

    @SerializedName("executor_core_pool_size")
    private final int executorCorePoolSize;

    public c2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r101 = (c2) r100;
        if (this.enableInitRepoMainOnlyOpt == r101.enableInitRepoMainOnlyOpt) goto L12;
        return false;
    L12:
        if (this.enableGetRepoLockOpt == r101.enableGetRepoLockOpt) goto L15;
        return false;
    L15:
        if (this.enableExecutorOpt == r101.enableExecutorOpt) goto L18;
        return false;
    L18:
        if (this.enableIndependentExecutorOpt == r101.enableIndependentExecutorOpt) goto L21;
        return false;
    L21:
        if (this.executorCorePoolSize == r101.executorCorePoolSize) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableInitRepoMainOnlyOpt == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableGetRepoLockOpt == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableExecutorOpt == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableIndependentExecutorOpt == true) goto L19;
        r100 = 1237;
    L19:
        return ((r106 + r100) * 31) + this.executorCorePoolSize;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "KevaPerfOptConfig(enableInitRepoMainOnlyOpt=" + this.enableInitRepoMainOnlyOpt + ", enableGetRepoLockOpt=" + this.enableGetRepoLockOpt + ", enableExecutorOpt=" + this.enableExecutorOpt + ", enableIndependentExecutorOpt=" + this.enableIndependentExecutorOpt + ", executorCorePoolSize=" + this.executorCorePoolSize + ')';
    }

    public final boolean a() {
        return this.enableExecutorOpt;
    }

    public final boolean b() {
        return this.enableGetRepoLockOpt;
    }

    public final boolean c() {
        return this.enableIndependentExecutorOpt;
    }

    public final boolean d() {
        return this.enableInitRepoMainOnlyOpt;
    }

    public final int e() {
        return this.executorCorePoolSize;
    }

    public c2(int r100) {
        this.enableInitRepoMainOnlyOpt = false;
        this.enableGetRepoLockOpt = false;
        this.enableExecutorOpt = false;
        this.enableIndependentExecutorOpt = false;
        this.executorCorePoolSize = 0;
    }
}
