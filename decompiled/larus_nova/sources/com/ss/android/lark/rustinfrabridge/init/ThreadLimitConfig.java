package com.ss.android.lark.rustinfrabridge.init;

import androidx.camera.video.AudioStats;
import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "rust_sdk_thread_limit")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/ss/android/lark/rustinfrabridge/init/ThreadLimitConfig;", "", "threadCoreSize", "", "threadPriority", "threadCreateDuration", "", "threadSpawnThreshold", "", "threadEpochStepCount", "workerReleaseDuration", "threadWaitingTimeThreshold", "netWaitingTimeThreshold", "performanceMonitor", "", "<init>", "(IIJDIJIIZ)V", "getThreadCoreSize", "()I", "getThreadPriority", "getThreadCreateDuration", "()J", "getThreadSpawnThreshold", "()D", "getThreadEpochStepCount", "setThreadEpochStepCount", "(I)V", "getWorkerReleaseDuration", "getThreadWaitingTimeThreshold", "getNetWaitingTimeThreshold", "getPerformanceMonitor", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "store_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadLimitConfig {

    @SerializedName("net_semaphore_monitor_waiting_time_threshold")
    private final int netWaitingTimeThreshold;

    @SerializedName(UploadTypeInf.PERFORMANCE)
    private final boolean performanceMonitor;

    @SerializedName("thread_core_size")
    private final int threadCoreSize;

    @SerializedName("thread_create_duration")
    private final long threadCreateDuration;

    @SerializedName("thread_epoch_step_count")
    private int threadEpochStepCount;

    @SerializedName(IVideoEventLogger.FEATURE_KEY_THREAD_PRIORITY)
    private final int threadPriority;

    @SerializedName("thread_spawn_threshold")
    private final double threadSpawnThreshold;

    @SerializedName("thread_monitor_waiting_time_threshold")
    private final int threadWaitingTimeThreshold;

    @SerializedName("worker_release_duration")
    private final long workerReleaseDuration;

    public ThreadLimitConfig() {
        this(0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 0, 0, 0, false, 511, null);
    }

    public static /* synthetic */ ThreadLimitConfig copy$default(ThreadLimitConfig r110, int r111, int r112, long r113, double r114, int r210, long r211, int r212, int r213, boolean r214, int r215, Object r216) {
        if ((r215 & 1) == 0) goto L5;
        int r100 = r110.threadCoreSize;
    L7:
        if ((r215 & 2) == 0) goto L9;
        int r101 = r110.threadPriority;
    L11:
        if ((r215 & 4) == 0) goto L13;
        long r102 = r110.threadCreateDuration;
    L15:
        if ((r215 & 8) == 0) goto L17;
        double r103 = r110.threadSpawnThreshold;
    L19:
        if ((r215 & 16) == 0) goto L21;
        int r104 = r110.threadEpochStepCount;
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r105 = r110.workerReleaseDuration;
    L27:
        if ((r215 & 64) == 0) goto L29;
        int r115 = r110.threadWaitingTimeThreshold;
    L31:
        if ((r215 & 128) == 0) goto L33;
        int r116 = r110.netWaitingTimeThreshold;
    L35:
        if ((r215 & 256) == 0) goto L37;
        boolean r106 = r110.performanceMonitor;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r106);
    L37:
        r106 = r214;
        goto L39
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.threadCoreSize;
    }

    public final int component2() {
        return this.threadPriority;
    }

    public final long component3() {
        return this.threadCreateDuration;
    }

    public final double component4() {
        return this.threadSpawnThreshold;
    }

    public final int component5() {
        return this.threadEpochStepCount;
    }

    public final long component6() {
        return this.workerReleaseDuration;
    }

    public final int component7() {
        return this.threadWaitingTimeThreshold;
    }

    public final int component8() {
        return this.netWaitingTimeThreshold;
    }

    public final boolean component9() {
        return this.performanceMonitor;
    }

    public final ThreadLimitConfig copy(int r110, int r111, long r112, double r113, int r210, long r211, int r212, int r213, boolean r214) {
        return new ThreadLimitConfig(r110, r111, r112, r113, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThreadLimitConfig) == true) goto L8;
        return false;
    L8:
        ThreadLimitConfig r101 = (ThreadLimitConfig) r100;
        if (this.threadCoreSize == r101.threadCoreSize) goto L12;
        return false;
    L12:
        if (this.threadPriority == r101.threadPriority) goto L15;
        return false;
    L15:
        if (this.threadCreateDuration == r101.threadCreateDuration) goto L18;
        return false;
    L18:
        if (Double.compare(this.threadSpawnThreshold, r101.threadSpawnThreshold) == 0) goto L21;
        return false;
    L21:
        if (this.threadEpochStepCount == r101.threadEpochStepCount) goto L24;
        return false;
    L24:
        if (this.workerReleaseDuration == r101.workerReleaseDuration) goto L27;
        return false;
    L27:
        if (this.threadWaitingTimeThreshold == r101.threadWaitingTimeThreshold) goto L30;
        return false;
    L30:
        if (this.netWaitingTimeThreshold == r101.netWaitingTimeThreshold) goto L33;
        return false;
    L33:
        if (this.performanceMonitor == r101.performanceMonitor) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.threadCoreSize * 31) + this.threadPriority) * 31;
        long r101 = this.threadCreateDuration;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.threadSpawnThreshold);
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.threadEpochStepCount) * 31;
        long r105 = this.workerReleaseDuration;
        int r106 = (((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.threadWaitingTimeThreshold) * 31) + this.netWaitingTimeThreshold) * 31;
        if (this.performanceMonitor == false) goto L5;
        int r107 = 1231;
    L7:
        return r106 + r107;
    L5:
        r107 = 1237;
        goto L7
    }

    public String toString() {
        return "ThreadLimitConfig(threadCoreSize=" + this.threadCoreSize + ", threadPriority=" + this.threadPriority + ", threadCreateDuration=" + this.threadCreateDuration + ", threadSpawnThreshold=" + this.threadSpawnThreshold + ", threadEpochStepCount=" + this.threadEpochStepCount + ", workerReleaseDuration=" + this.workerReleaseDuration + ", threadWaitingTimeThreshold=" + this.threadWaitingTimeThreshold + ", netWaitingTimeThreshold=" + this.netWaitingTimeThreshold + ", performanceMonitor=" + this.performanceMonitor + ')';
    }

    public final int getNetWaitingTimeThreshold() {
        return this.netWaitingTimeThreshold;
    }

    public final boolean getPerformanceMonitor() {
        return this.performanceMonitor;
    }

    public final int getThreadCoreSize() {
        return this.threadCoreSize;
    }

    public final long getThreadCreateDuration() {
        return this.threadCreateDuration;
    }

    public final int getThreadEpochStepCount() {
        return this.threadEpochStepCount;
    }

    public final int getThreadPriority() {
        return this.threadPriority;
    }

    public final double getThreadSpawnThreshold() {
        return this.threadSpawnThreshold;
    }

    public final int getThreadWaitingTimeThreshold() {
        return this.threadWaitingTimeThreshold;
    }

    public final long getWorkerReleaseDuration() {
        return this.workerReleaseDuration;
    }

    public final void setThreadEpochStepCount(int r100) {
        this.threadEpochStepCount = r100;
    }

    public ThreadLimitConfig(int r100, int r101, long r102, double r103, int r104, long r105, int r110, int r111, boolean r112) {
        this.threadCoreSize = r100;
        this.threadPriority = r101;
        this.threadCreateDuration = r102;
        this.threadSpawnThreshold = r103;
        this.threadEpochStepCount = r104;
        this.workerReleaseDuration = r105;
        this.threadWaitingTimeThreshold = r110;
        this.netWaitingTimeThreshold = r111;
        this.performanceMonitor = r112;
    }

    public /* synthetic */ ThreadLimitConfig(int r110, int r111, long r112, double r113, int r210, long r211, int r212, int r213, boolean r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 1) == 0) goto L5;
        int r100 = 2;
    L7:
        if ((r215 & 2) == 0) goto L9;
        int r101 = 49;
    L11:
        if ((r215 & 4) == 0) goto L13;
        long r102 = 5;
    L15:
        if ((r215 & 8) == 0) goto L17;
        double r103 = 5.0d;
    L19:
        if ((r215 & 16) == 0) goto L21;
        int r104 = 64;
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r105 = 60;
    L26:
        int r114 = 1000;
        if ((r215 & 64) == 0) goto L29;
        int r115 = 1000;
    L31:
        if ((r215 & 128) != 0) goto L35;
        r114 = r213;
    L35:
        if ((r215 & 256) == 0) goto L37;
        boolean r106 = false;
    L38:
        this(r100, r101, r102, r103, r104, r105, r115, r114, r106);
        return;
    L37:
        r106 = r214;
        goto L38
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L26
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
