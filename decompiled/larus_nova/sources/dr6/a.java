package dr6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Ldr6/a;", "", "", "enableSpeedUpBoost", "I", "getEnableSpeedUpBoost", "()I", "enableDisableVerify", "getEnableDisableVerify", "enableThreadOpt", "getEnableThreadOpt", "threadPriority", "getThreadPriority", "buildViewTreeInMainThread", "getBuildViewTreeInMainThread", "buildViewTreeForceInThread", "getBuildViewTreeForceInThread", "buildViewTreeForceInThreadV2", "getBuildViewTreeForceInThreadV2", "buildViewTreeInMainThreadForFirstCard", "getBuildViewTreeInMainThreadForFirstCard", "loadAsyncForFirstCard", "getLoadAsyncForFirstCard", "loadAsync", "getLoadAsync", "backMainThreadOpt", "getBackMainThreadOpt", "forceDoFrame", "getForceDoFrame", "nextFrameDoTempTask", "getNextFrameDoTempTask", "enableParallelBuild", "getEnableParallelBuild", "enableImproveScrollFps", "getEnableImproveScrollFps", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("tempo_load_back_mainthread_opt")
    private final int backMainThreadOpt;

    @SerializedName("build_viewtree_in_thread")
    private final int buildViewTreeForceInThread;

    @SerializedName("build_viewtree_in_thread_v2")
    private final int buildViewTreeForceInThreadV2;

    @SerializedName("build_viewtree_in_mainthread")
    private final int buildViewTreeInMainThread;

    @SerializedName("build_viewtree_in_mainthread_for_fist_card")
    private final int buildViewTreeInMainThreadForFirstCard;

    @SerializedName("enable_disable_verify")
    private final int enableDisableVerify;

    @SerializedName("enable_improve_scroll_fps")
    private final int enableImproveScrollFps;

    @SerializedName("enable_parallel_viewtree_build")
    private final int enableParallelBuild;

    @SerializedName("enable_speed_up_boost")
    private final int enableSpeedUpBoost;

    @SerializedName("enable_thread_opt")
    private final int enableThreadOpt;

    @SerializedName("tempo_load_force_do_frame")
    private final int forceDoFrame;

    @SerializedName("tempo_load_is_async")
    private final int loadAsync;

    @SerializedName("tempo_load_is_async_for_first_card")
    private final int loadAsyncForFirstCard;

    @SerializedName("tempo_next_frame_do_temp_task")
    private final int nextFrameDoTempTask;

    @SerializedName("set_thread_priority")
    private final int threadPriority;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enableSpeedUpBoost == r101.enableSpeedUpBoost) goto L12;
        return false;
    L12:
        if (this.enableDisableVerify == r101.enableDisableVerify) goto L15;
        return false;
    L15:
        if (this.enableThreadOpt == r101.enableThreadOpt) goto L18;
        return false;
    L18:
        if (this.threadPriority == r101.threadPriority) goto L21;
        return false;
    L21:
        if (this.buildViewTreeInMainThread == r101.buildViewTreeInMainThread) goto L24;
        return false;
    L24:
        if (this.buildViewTreeForceInThread == r101.buildViewTreeForceInThread) goto L27;
        return false;
    L27:
        if (this.buildViewTreeForceInThreadV2 == r101.buildViewTreeForceInThreadV2) goto L30;
        return false;
    L30:
        if (this.buildViewTreeInMainThreadForFirstCard == r101.buildViewTreeInMainThreadForFirstCard) goto L33;
        return false;
    L33:
        if (this.loadAsyncForFirstCard == r101.loadAsyncForFirstCard) goto L36;
        return false;
    L36:
        if (this.loadAsync == r101.loadAsync) goto L39;
        return false;
    L39:
        if (this.backMainThreadOpt == r101.backMainThreadOpt) goto L42;
        return false;
    L42:
        if (this.forceDoFrame == r101.forceDoFrame) goto L45;
        return false;
    L45:
        if (this.nextFrameDoTempTask == r101.nextFrameDoTempTask) goto L48;
        return false;
    L48:
        if (this.enableParallelBuild == r101.enableParallelBuild) goto L51;
        return false;
    L51:
        if (this.enableImproveScrollFps == r101.enableImproveScrollFps) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((this.enableSpeedUpBoost * 31) + this.enableDisableVerify) * 31) + this.enableThreadOpt) * 31) + this.threadPriority) * 31) + this.buildViewTreeInMainThread) * 31) + this.buildViewTreeForceInThread) * 31) + this.buildViewTreeForceInThreadV2) * 31) + this.buildViewTreeInMainThreadForFirstCard) * 31) + this.loadAsyncForFirstCard) * 31) + this.loadAsync) * 31) + this.backMainThreadOpt) * 31) + this.forceDoFrame) * 31) + this.nextFrameDoTempTask) * 31) + this.enableParallelBuild) * 31) + this.enableImproveScrollFps;
    }

    public final String toString() {
        return "Config(enableSpeedUpBoost=" + this.enableSpeedUpBoost + ", enableDisableVerify=" + this.enableDisableVerify + ", enableThreadOpt=" + this.enableThreadOpt + ", threadPriority=" + this.threadPriority + ", buildViewTreeInMainThread=" + this.buildViewTreeInMainThread + ", buildViewTreeForceInThread=" + this.buildViewTreeForceInThread + ", buildViewTreeForceInThreadV2=" + this.buildViewTreeForceInThreadV2 + ", buildViewTreeInMainThreadForFirstCard=" + this.buildViewTreeInMainThreadForFirstCard + ", loadAsyncForFirstCard=" + this.loadAsyncForFirstCard + ", loadAsync=" + this.loadAsync + ", backMainThreadOpt=" + this.backMainThreadOpt + ", forceDoFrame=" + this.forceDoFrame + ", nextFrameDoTempTask=" + this.nextFrameDoTempTask + ", enableParallelBuild=" + this.enableParallelBuild + ", enableImproveScrollFps=" + this.enableImproveScrollFps + ')';
    }

    public a() {
        this.enableSpeedUpBoost = 1;
        this.enableDisableVerify = 1;
        this.enableThreadOpt = 1;
        this.threadPriority = -20;
        this.buildViewTreeInMainThread = 0;
        this.buildViewTreeForceInThread = 0;
        this.buildViewTreeForceInThreadV2 = 0;
        this.buildViewTreeInMainThreadForFirstCard = 0;
        this.loadAsyncForFirstCard = 0;
        this.loadAsync = 0;
        this.backMainThreadOpt = 0;
        this.forceDoFrame = 0;
        this.nextFrameDoTempTask = 0;
        this.enableParallelBuild = 0;
        this.enableImproveScrollFps = 0;
    }
}
