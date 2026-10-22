package ss1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lss1/c;", "", "", "performanceMonitorInterval", "I", "c", "()I", "setPerformanceMonitorInterval", "(I)V", "valueAnimConsecutiveFailedTime", "d", "setValueAnimConsecutiveFailedTime", "flowLikeViewCacheNum", "b", "setFlowLikeViewCacheNum", "flowLikeDelayTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setFlowLikeDelayTime", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("enter_room_flow_like_delay_time")
    private int flowLikeDelayTime;

    @SerializedName("flow_like_view_cache_num")
    private int flowLikeViewCacheNum;

    @SerializedName("performance_monitor_interval")
    private int performanceMonitorInterval;

    @SerializedName("value_anim_consecutive_failed_time")
    private int valueAnimConsecutiveFailedTime;

    public c() {
        this.performanceMonitorInterval = 1;
        this.valueAnimConsecutiveFailedTime = 1;
        this.flowLikeViewCacheNum = 5;
    }

    public final int a() {
        return this.flowLikeDelayTime;
    }

    public final int b() {
        return this.flowLikeViewCacheNum;
    }

    public final int c() {
        return this.performanceMonitorInterval;
    }

    public final int d() {
        return this.valueAnimConsecutiveFailedTime;
    }
}
