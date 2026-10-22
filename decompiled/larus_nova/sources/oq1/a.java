package oq1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Loq1/a;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "memoryCacheMaxCount", "I", "c", "()I", "setMemoryCacheMaxCount", "(I)V", "memoryCacheMaxAgeTime", "b", "setMemoryCacheMaxAgeTime", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("memory_cache_max_age_time")
    private int memoryCacheMaxAgeTime;

    @SerializedName("memory_cache_max_count")
    private int memoryCacheMaxCount;

    /* JADX INFO: renamed from: oq1.a$a, reason: collision with other inner class name */
    public static final class C7090a {
    }

    static {
    }

    public a() {
        this.memoryCacheMaxCount = 10;
        this.memoryCacheMaxAgeTime = 300;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.memoryCacheMaxAgeTime;
    }

    public final int c() {
        return this.memoryCacheMaxCount;
    }
}
