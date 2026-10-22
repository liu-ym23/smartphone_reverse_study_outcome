package com.bytedance.locallife.poi.experiment;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiTempo2JsonConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f262578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f262579b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f262580c = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001a\u00105\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001a\u00107\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006R\u001a\u00109\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\u001a\u0010;\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006R(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020>\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$a;", "", "", "enable", "I", "getEnable", "()I", "enableTempoPreloadOpt", "getEnableTempoPreloadOpt", "enableStaticLoad", "getEnableStaticLoad", "enableIsAsync", "getEnableIsAsync", "enableStretchParallelBuild", "getEnableStretchParallelBuild", "enableForceMain", "getEnableForceMain", "forceMainWhenBuildTree", "getForceMainWhenBuildTree", "", "preCreateViewMode", "Ljava/lang/String;", "getPreCreateViewMode", "()Ljava/lang/String;", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$c;", "jatoOpt", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$c;", "getJatoOpt", "()Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$c;", "forceDoFrameWhenLoad", "Ljava/lang/Integer;", "getForceDoFrameWhenLoad", "()Ljava/lang/Integer;", "backMainThreadOpt", "getBackMainThreadOpt", "nextFrameDoTempTask", "getNextFrameDoTempTask", "enableTextViewV2", "getEnableTextViewV2", "enableTextViewV2ForPoiName", "getEnableTextViewV2ForPoiName", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$b;", "imageOpt", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$b;", "getImageOpt", "()Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$b;", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$e;", "viewTreeBuildParallelConfig", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$e;", "getViewTreeBuildParallelConfig", "()Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$e;", "precreateViewWhenPrecreateNodeHolder", "getPrecreateViewWhenPrecreateNodeHolder", "disablePreloadOnFragmentCreateFor75", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "disablePreloadOnRouterFor75", "b", "createTempoViewWhenPreload", "getCreateTempoViewWhenPreload", "enableAheadEvaluateJs", "getEnableAheadEvaluateJs", "", "Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$d;", "updateConfig", "Ljava/util/Map;", "getUpdateConfig", "()Ljava/util/Map;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("back_main_thread_opt")
        private final Integer backMainThreadOpt;

        @SerializedName("create_tempo_view_when_preload")
        private final int createTempoViewWhenPreload;

        @SerializedName("disable_preload_on_fragment_create_for_75")
        private final int disablePreloadOnFragmentCreateFor75;

        @SerializedName("disable_preload_on_router_for_75")
        private final int disablePreloadOnRouterFor75;

        @SerializedName("enable")
        private final int enable;

        @SerializedName("enable_ahead_evaluate_js")
        private final int enableAheadEvaluateJs;

        @SerializedName("enable_force_main")
        private final int enableForceMain;

        @SerializedName("enable_is_async")
        private final int enableIsAsync;

        @SerializedName("enable_static_load")
        private final int enableStaticLoad;

        @SerializedName("enable_stretch_parallel_build")
        private final int enableStretchParallelBuild;

        @SerializedName("enable_tempo_preload_opt")
        private final int enableTempoPreloadOpt;

        @SerializedName("enable_text_view_v2")
        private final int enableTextViewV2;

        @SerializedName("enable_text_view_v2_for_poi_name")
        private final int enableTextViewV2ForPoiName;

        @SerializedName("force_do_frame_when_load")
        private final Integer forceDoFrameWhenLoad;

        @SerializedName("force_main_when_build_tree")
        private final int forceMainWhenBuildTree;

        @SerializedName("image_opt")
        private final b imageOpt;

        @SerializedName("jato_opt")
        private final c jatoOpt;

        @SerializedName("next_frame_do_temp_task")
        private final Integer nextFrameDoTempTask;

        @SerializedName("pre_create_view_mode")
        private final String preCreateViewMode;

        @SerializedName("enable_precreate_view_when_precreate_nodeholder")
        private final int precreateViewWhenPrecreateNodeHolder;

        @SerializedName("update_config")
        private final Map<String, d> updateConfig;

        @SerializedName("view_tree_build_parallel_config")
        private final e viewTreeBuildParallelConfig;

        public a() {
            this(null);
        }

        public final int a() {
            return this.disablePreloadOnFragmentCreateFor75;
        }

        public final int b() {
            return this.disablePreloadOnRouterFor75;
        }

        public a(Object r100) {
            c r101 = new c(true, -8, 1000L);
            e r102 = new e(1, 1);
            this.enable = 0;
            this.enableTempoPreloadOpt = 0;
            this.enableStaticLoad = 0;
            this.enableIsAsync = 1;
            this.enableStretchParallelBuild = 1;
            this.enableForceMain = 0;
            this.forceMainWhenBuildTree = 0;
            this.preCreateViewMode = UserProfileEvent.POSITION_NONE;
            this.jatoOpt = r101;
            this.forceDoFrameWhenLoad = 1;
            this.backMainThreadOpt = 1;
            this.nextFrameDoTempTask = 1;
            this.enableTextViewV2 = 1;
            this.enableTextViewV2ForPoiName = 0;
            this.imageOpt = null;
            this.viewTreeBuildParallelConfig = r102;
            this.precreateViewWhenPrecreateNodeHolder = 1;
            this.disablePreloadOnFragmentCreateFor75 = 0;
            this.disablePreloadOnRouterFor75 = 0;
            this.createTempoViewWhenPreload = 1;
            this.enableAheadEvaluateJs = 1;
            this.updateConfig = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$b;", "", "", "enable", "I", "getEnable", "()I", "prefetchStrategy", "getPrefetchStrategy", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("enable")
        private final int enable;

        @SerializedName("prefetch_strategy")
        private final int prefetchStrategy;

        public b() {
            this.enable = 0;
            this.prefetchStrategy = 0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$c;", "", "", "threadOpt", "Z", "getThreadOpt", "()Z", "", "threadPriority", "Ljava/lang/Integer;", "getThreadPriority", "()Ljava/lang/Integer;", "", "boostDurationWhenLoad", "Ljava/lang/Long;", "getBoostDurationWhenLoad", "()Ljava/lang/Long;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("boost_duration_when_load")
        private final Long boostDurationWhenLoad;

        @SerializedName("thread_opt")
        private final boolean threadOpt;

        @SerializedName(IVideoEventLogger.FEATURE_KEY_THREAD_PRIORITY)
        private final Integer threadPriority;

        public c() {
            this(false, null, null);
        }

        public c(boolean r100, Integer r101, Long r102) {
            this.threadOpt = r100;
            this.threadPriority = r101;
            this.boostDurationWhenLoad = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$d;", "", "", "enableDiff", "I", "getEnableDiff", "()I", "enableMetricsUpload", "getEnableMetricsUpload", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("enable_diff")
        private final int enableDiff;

        @SerializedName("enable_metrics_upload")
        private final int enableMetricsUpload;

        public d() {
            this.enableDiff = 0;
            this.enableMetricsUpload = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiTempo2JsonConfig$e;", "", "", "enable", "I", "getEnable", "()I", "eachGroupNum", "getEachGroupNum", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("number")
        private final int eachGroupNum;

        @SerializedName("enable")
        private final int enable;

        public e() {
            this(0, 1);
        }

        public e(int r100, int r101) {
            this.enable = r100;
            this.eachGroupNum = r101;
        }
    }

    static {
        f262578a = new a(null);
        f262579b = LazyKt.lazy(PoiTempo2JsonConfig$valueJson$2.INSTANCE);
        f262580c = LazyKt.lazy(PoiTempo2JsonConfig$value$2.INSTANCE);
    }
}
