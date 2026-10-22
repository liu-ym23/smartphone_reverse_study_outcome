package fs2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lfs2/b;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "jatoOpt", "c", "setJatoOpt", "taskTypeSort", "e", "setTaskTypeSort", "taskRunOpt", "d", "setTaskRunOpt", "", "defaultScatterSpacing", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setDefaultScatterSpacing", "(J)V", "<init>", "()V", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("default_scatter_spacing")
    private long defaultScatterSpacing;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("jato_opt")
    private boolean jatoOpt;

    @SerializedName("task_run_opt")
    private boolean taskRunOpt;

    @SerializedName("task_type_sort")
    private boolean taskTypeSort;

    public b() {
        this.defaultScatterSpacing = 10;
    }

    public final long a() {
        return this.defaultScatterSpacing;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.jatoOpt;
    }

    public final boolean d() {
        return this.taskRunOpt;
    }

    public final boolean e() {
        return this.taskTypeSort;
    }
}
