package fv1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lfv1/e;", "", "", "pushTimesLimit", "I", "d", "()I", "setPushTimesLimit", "(I)V", "", "pushTimeGap", "J", "c", "()J", "setPushTimeGap", "(J)V", "pushShowDuration", "b", "setPushShowDuration", "pushDelayDuration", "getPushDelayDuration", "setPushDelayDuration", "", "pushIntervalDebug", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setPushIntervalDebug", "(Z)V", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("push_delay_duration")
    private long pushDelayDuration;

    @SerializedName("push_interval_debug")
    private boolean pushIntervalDebug;

    @SerializedName("push_show_duration")
    private long pushShowDuration;

    @SerializedName("push_time_gap")
    private long pushTimeGap;

    @SerializedName("push_times_limit")
    private int pushTimesLimit;

    public e() {
        this.pushTimesLimit = 2;
        this.pushTimeGap = 60;
        this.pushShowDuration = 5;
        this.pushDelayDuration = 10;
    }

    public final boolean a() {
        return this.pushIntervalDebug;
    }

    public final long b() {
        return this.pushShowDuration;
    }

    public final long c() {
        return this.pushTimeGap;
    }

    public final int d() {
        return this.pushTimesLimit;
    }
}
