package nv2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lnv2/a;", "", "", "safeInterval", "J", "c", "()J", "", "maxShowTimes", "I", "b", "()I", "maxCloseTimes", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f520815a = 0;

    @SerializedName("max_close_times")
    private final int maxCloseTimes;

    @SerializedName("max_show_times")
    private final int maxShowTimes;

    @SerializedName("safe_interval")
    private final long safeInterval;

    /* JADX INFO: renamed from: nv2.a$a, reason: collision with other inner class name */
    public static final class C6977a {
    }

    static {
    }

    public final String toString() {
        return "PlayerTipsConfig(safeInterval=" + this.safeInterval + ", maxShowTimes=" + this.maxShowTimes + ')';
    }

    public a() {
        this.safeInterval = 60000;
        this.maxShowTimes = 10;
        this.maxCloseTimes = 2;
    }

    public final int a() {
        return this.maxCloseTimes;
    }

    public final int b() {
        return this.maxShowTimes;
    }

    public final long c() {
        return this.safeInterval;
    }
}
