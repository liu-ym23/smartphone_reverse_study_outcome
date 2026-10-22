package uv8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u000bHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u008d\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u000bHÖ\u0001J\t\u0010F\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001e\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001e\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001e\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006G"}, d2 = {"Lcom/larus/business/debug/base/coroutinus/tracer/CoroutinesPeriodPackInfo;", "", "appLaunchTime", "", "totalCreateCnt", "totalRunningCnt", "totalRunDelayCnt", "totalFinishCnt", "totalCancelCnt", "totalSlowCnt", "incCreateCnt", "", "incRunDelayCnt", "incFinishCnt", "incCancelCnt", "incSlowCnt", "topRunDelayDispatcher", "", "<init>", "(JJJJJJJIIIIILjava/lang/String;)V", "getAppLaunchTime", "()J", "setAppLaunchTime", "(J)V", "getTotalCreateCnt", "setTotalCreateCnt", "getTotalRunningCnt", "setTotalRunningCnt", "getTotalRunDelayCnt", "setTotalRunDelayCnt", "getTotalFinishCnt", "setTotalFinishCnt", "getTotalCancelCnt", "setTotalCancelCnt", "getTotalSlowCnt", "setTotalSlowCnt", "getIncCreateCnt", "()I", "setIncCreateCnt", "(I)V", "getIncRunDelayCnt", "setIncRunDelayCnt", "getIncFinishCnt", "setIncFinishCnt", "getIncCancelCnt", "setIncCancelCnt", "getIncSlowCnt", "setIncSlowCnt", "getTopRunDelayDispatcher", "()Ljava/lang/String;", "setTopRunDelayDispatcher", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("ap_launch_t")
    private long appLaunchTime;

    @SerializedName("i_cancel_cnt")
    private int incCancelCnt;

    @SerializedName("i_create_cnt")
    private int incCreateCnt;

    @SerializedName("i_finish_cnt")
    private int incFinishCnt;

    @SerializedName("i_wait_cnt")
    private int incRunDelayCnt;

    @SerializedName("i_slow_cnt")
    private int incSlowCnt;

    @SerializedName("top_wait_trd")
    private String topRunDelayDispatcher;

    @SerializedName("t_cancel_cnt")
    private long totalCancelCnt;

    @SerializedName("t_create_cnt")
    private long totalCreateCnt;

    @SerializedName("t_finish_cnt")
    private long totalFinishCnt;

    @SerializedName("t_wait_cnt")
    private long totalRunDelayCnt;

    @SerializedName("t_running_cnt")
    private long totalRunningCnt;

    @SerializedName("t_slow_cnt")
    private long totalSlowCnt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.appLaunchTime == r101.appLaunchTime) goto L12;
        return false;
    L12:
        if (this.totalCreateCnt == r101.totalCreateCnt) goto L15;
        return false;
    L15:
        if (this.totalRunningCnt == r101.totalRunningCnt) goto L18;
        return false;
    L18:
        if (this.totalRunDelayCnt == r101.totalRunDelayCnt) goto L21;
        return false;
    L21:
        if (this.totalFinishCnt == r101.totalFinishCnt) goto L24;
        return false;
    L24:
        if (this.totalCancelCnt == r101.totalCancelCnt) goto L27;
        return false;
    L27:
        if (this.totalSlowCnt == r101.totalSlowCnt) goto L30;
        return false;
    L30:
        if (this.incCreateCnt == r101.incCreateCnt) goto L33;
        return false;
    L33:
        if (this.incRunDelayCnt == r101.incRunDelayCnt) goto L36;
        return false;
    L36:
        if (this.incFinishCnt == r101.incFinishCnt) goto L39;
        return false;
    L39:
        if (this.incCancelCnt == r101.incCancelCnt) goto L42;
        return false;
    L42:
        if (this.incSlowCnt == r101.incSlowCnt) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.topRunDelayDispatcher, r101.topRunDelayDispatcher) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        long r100 = this.appLaunchTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.totalCreateCnt;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.totalRunningCnt;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.totalRunDelayCnt;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.totalFinishCnt;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.totalCancelCnt;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.totalSlowCnt;
        int r113 = (((((((((((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.incCreateCnt) * 31) + this.incRunDelayCnt) * 31) + this.incFinishCnt) * 31) + this.incCancelCnt) * 31) + this.incSlowCnt) * 31;
        String r114 = this.topRunDelayDispatcher;
        if (r114 != null) goto L5;
        int r115 = 0;
    L7:
        return r113 + r115;
    L5:
        r115 = r114.hashCode();
        goto L7
    }

    public final String toString() {
        return "CoroutinesPeriodPackInfo(appLaunchTime=" + this.appLaunchTime + ", totalCreateCnt=" + this.totalCreateCnt + ", totalRunningCnt=" + this.totalRunningCnt + ", totalRunDelayCnt=" + this.totalRunDelayCnt + ", totalFinishCnt=" + this.totalFinishCnt + ", totalCancelCnt=" + this.totalCancelCnt + ", totalSlowCnt=" + this.totalSlowCnt + ", incCreateCnt=" + this.incCreateCnt + ", incRunDelayCnt=" + this.incRunDelayCnt + ", incFinishCnt=" + this.incFinishCnt + ", incCancelCnt=" + this.incCancelCnt + ", incSlowCnt=" + this.incSlowCnt + ", topRunDelayDispatcher=" + this.topRunDelayDispatcher + ')';
    }

    public a() {
        this.appLaunchTime = 0;
        this.totalCreateCnt = 0;
        this.totalRunningCnt = 0;
        this.totalRunDelayCnt = 0;
        this.totalFinishCnt = 0;
        this.totalCancelCnt = 0;
        this.totalSlowCnt = 0;
        this.incCreateCnt = 0;
        this.incRunDelayCnt = 0;
        this.incFinishCnt = 0;
        this.incCancelCnt = 0;
        this.incSlowCnt = 0;
        this.topRunDelayDispatcher = null;
    }
}
