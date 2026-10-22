package y9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Ly9/m;", "", "", "webUseMem", "Z", "c", "()Z", "setWebUseMem", "(Z)V", "lynxUseMem", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setLynxUseMem", "", "memorySize", "I", "b", "()I", "setMemorySize", "(I)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("lynx_use_memory")
    private boolean lynxUseMem;

    @SerializedName("memory_size_mb")
    private int memorySize;

    @SerializedName("web_use_memory")
    private boolean webUseMem;

    public m() {
        this.lynxUseMem = true;
    }

    public final boolean a() {
        return this.lynxUseMem;
    }

    public final int b() {
        return this.memorySize;
    }

    public final boolean c() {
        return this.webUseMem;
    }
}
