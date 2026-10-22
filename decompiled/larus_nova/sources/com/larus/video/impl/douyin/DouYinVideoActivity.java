package com.larus.video.impl.douyin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.audio.ttsV2.TtsClientDelegate;
import com.larus.bmhome.chat.api.MultimodalTraceDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.z3;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003,/2\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u000bJ\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0015J\b\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J\b\u0010<\u001a\u000205H\u0002J\b\u0010=\u001a\u000205H\u0002J\b\u0010>\u001a\u000205H\u0002J\b\u0010?\u001a\u000205H\u0002J\u0010\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020BH\u0002J<\u0010C\u001a\u0002052\u0006\u0010A\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0F2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH\u0002J\u0010\u0010I\u001a\u0002052\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u000205H\u0002J\b\u0010M\u001a\u000205H\u0003J\b\u0010N\u001a\u000205H\u0014J\b\u0010O\u001a\u000205H\u0002J\b\u0010P\u001a\u000205H\u0014J\b\u0010Q\u001a\u000205H\u0016J\b\u0010R\u001a\u000205H\u0002J\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u000205H\u0002J\b\u0010W\u001a\u000205H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006Y"}, d2 = {"Lcom/larus/video/impl/douyin/DouYinVideoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "douyinVideoModel", "Lcom/larus/video/impl/douyin/DouYinActivityVideoModel;", "isExitTransitionRunning", "", "mEnterTime", "", "mLatestAid", "", "iOperateFeedFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "isFirstFramePlayed", "firstFrameLoadFinishTimeStamp", "Ljava/lang/Long;", "firstFrameLoadDuration", "staticBlackColor", "", "getStaticBlackColor", "()I", "staticBlackColor$delegate", "Lkotlin/Lazy;", "douYinVideoDataManager", "Lcom/larus/video/impl/douyin/DouYinVideoDataManager;", "getDouYinVideoDataManager", "()Lcom/larus/video/impl/douyin/DouYinVideoDataManager;", "douYinVideoDataManager$delegate", "getPoiTrackParams", "Lorg/json/JSONObject;", "getPoiTrackParams$impl_mainlandRelease", "getCurrentMessageId", "douYinVideoUIOperator", "Lcom/larus/video/impl/douyin/DouYinVideoUIOperator;", "getDouYinVideoUIOperator", "()Lcom/larus/video/impl/douyin/DouYinVideoUIOperator;", "douYinVideoUIOperator$delegate", "douYinVideoActivityTracker", "Lcom/larus/video/impl/douyin/DouYinVideoActivityTracker;", "getDouYinVideoActivityTracker", "()Lcom/larus/video/impl/douyin/DouYinVideoActivityTracker;", "douYinVideoActivityTracker$delegate", "sendEventCallback", "com/larus/video/impl/douyin/DouYinVideoActivity$sendEventCallback$1", "Lcom/larus/video/impl/douyin/DouYinVideoActivity$sendEventCallback$1;", "getMoreListener", "com/larus/video/impl/douyin/DouYinVideoActivity$getMoreListener$1", "Lcom/larus/video/impl/douyin/DouYinVideoActivity$getMoreListener$1;", "customIFeedPageListener", "com/larus/video/impl/douyin/DouYinVideoActivity$customIFeedPageListener$1", "Lcom/larus/video/impl/douyin/DouYinVideoActivity$customIFeedPageListener$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "validateEssentialData", "setUpVideoModel", "trackActivityCreationTime", "setupPerformanceMonitoring", "mutePage", "setupWindowConfig", "registerGlobalListeners", "reportLeave", "tryLoadMoreItemIdList", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "handleLoadMoreResult", "haveMore", "loadMoreItemIdList", "", "ext", "", "beforeEnterInitCacheData", "enterDouYinSdkParam", "Lcom/larus/video/impl/douyin/EnterDouYinSdkParam;", "addVideoFeedFragment", "dispatchTouchEventToSeekBar", "onPause", "saveUnConsumedPlayList", "onResume", "onAttachedToWindow", "applySystemBarColor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refreshLayoutForConfigurationChanged", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouYinVideoActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f375691p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DouYinActivityVideoModel f375692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f375693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f375694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f375695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public pr9.h f375696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f375697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f375698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f375699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f375700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f375701j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f375702k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f375703l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f375704m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f375705n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f375706o;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f375707a = null;

        static {
            int[] r100 = new int[VideoParam.RecommendType.values().length];
            r100[VideoParam.RecommendType.Search.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VideoParam.RecommendType.AwemeFeed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f375707a = r100;
        }
    }

    public static final class c implements pr9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DouYinVideoActivity f375708a;

        @Override // pr9.b
        public final pr9.d a() {
            return null;
        }

        @Override // pr9.b
        public final void onLoadSuccess() {
            FLogger.f375446a.i("DouYinVideoActivity", "onLoadSuccess");
            DouYinVideoActivity r100 = this.f375708a;
            int r101 = DouYinVideoActivity.f375691p;
            n r102 = r100.z1();
            r102.getClass();
            MultimodalTraceDelegate r103 = MultimodalTraceDelegate.f297171b;
            String r104 = (String) r102.f375753b.getValue();
            DouYinVideoDataManager r105 = r102.f375752a;
            String r106 = r105.E;
            String r107 = r105.f375736y;
            r103.c(r104, r106, r102.a(), r107);
        }

        public c(DouYinVideoActivity r100) {
            this.f375708a = r100;
        }

        @Override // pr9.b
        public final void b(CustomFeedPlayerEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            boolean r101 = true;
            if ((r100 instanceof CustomFeedPlayerEvent.FirstFrame) == false) goto L7;
            DouYinVideoActivity r102 = this.f375708a;
            r102.f375697f = true;
            if (r102.f375698g != null) goto L7;
            r102.f375698g = Long.valueOf(System.currentTimeMillis());
        L7:
            FLogger.f375446a.i("DouYinVideoActivity", "onPlayerEvent: " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + ", aid = " + r100.getAwemeId() + ", type = " + r100.getAwemeType() + ", ext = " + r100.getExtra());
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Map<String, Object> r103 = r100.getExtra();
            Object r104 = null;
            if (r103 == null) goto L10;
            Object r105 = r103.get("reason");
        L12:
            if ((r100 instanceof CustomFeedPlayerEvent.PausePlay) == true) goto L14;
        L16:
            boolean r106 = false;
        L17:
            if (r106 == false) goto L21;
            DouYinVideoActivity r107 = this.f375708a;
            if (r107.f375693b == true) goto L21;
            r107.z1().b("paused");
            return;
        L21:
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Map<String, Object> r108 = r100.getExtra();
            if (r108 == null) goto L25;
            r104 = r108.get("reason");
        L25:
            if ((r100 instanceof CustomFeedPlayerEvent.ResumePlay) == true) goto L27;
        L29:
            r101 = false;
        L30:
            if (r101 == false) goto L34;
            DouYinVideoActivity r109 = this.f375708a;
            int r110 = DouYinVideoActivity.f375691p;
            r109.z1().b("play");
            return;
        L34:
            return;
        L27:
            if (Intrinsics.areEqual(r104, 1) == false) goto L29;
        L14:
            if (Intrinsics.areEqual(r105, 1) == false) goto L16;
            r106 = true;
            goto L17
        L10:
            r105 = null;
            goto L12
        }

        @Override // pr9.b
        public final void onLoadError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            FLogger.f375446a.i("DouYinVideoActivity", "onLoadError, code = 21002, msg = ".concat(r100));
            DouYinVideoActivity r101 = this.f375708a;
            int r102 = DouYinVideoActivity.f375691p;
            n r103 = r101.z1();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r100, "msg");
            MultimodalTraceDelegate r104 = MultimodalTraceDelegate.f297171b;
            String r105 = (String) r103.f375753b.getValue();
            DouYinVideoDataManager r106 = r103.f375752a;
            String r107 = r106.E;
            String r108 = r106.f375736y;
            String r109 = r103.a();
            JSONObject r110 = new JSONObject();
            r110.put("err_code", 21002);
            r110.put(LocationMonitorConst.ERR_MSG, r100);
            r104.a(r105, r107, r110.toString(), r109, r108);
        }

        @Override // pr9.b
        public final void c(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "aid");
            FLogger.f375446a.i("DouYinVideoActivity", "notifyFeedChange, isPlayNext = " + r100 + ", aid = " + r101);
            DouYinVideoActivity r102 = this.f375708a;
            int r103 = DouYinVideoActivity.f375691p;
            v r104 = (v) r102.f375702k.getValue();
            r104.getClass();
            Intrinsics.checkNotNullParameter(r101, "aid");
            DouYinVideoDataManager r105 = r104.f375763b;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r101, "itemId");
            ArrayList<MediaEntity> r106 = r105.L;
            if (r106 == null) goto L8;
            MediaEntity r107 = (MediaEntity) CollectionsKt.getOrNull(r106, 0);
            if (r107 == null) goto L8;
            String r108 = r107.getItem_id();
            if (r108 == null) goto L8;
        L10:
            if (Intrinsics.areEqual(r108, r101) == true) goto L12;
        L14:
            ((TextView) r104.f375764c.getValue()).setVisibility(8);
            ((View) r104.f375765d.getValue()).setVisibility(8);
        L15:
            this.f375708a.A1().B.add(r101);
            String r109 = l2a.b.f507171a;
            Intrinsics.checkNotNullParameter(r101, "itemId");
            l2a.b.f507171a = r101;
            DouYinVideoActivity r110 = this.f375708a;
            r110.f375695d = r101;
            VideoParam.RecommendType r111 = r110.A1().M;
            Map<String, CopyOnWriteArrayList<com.larus.bmhome.video.g>> r112 = com.larus.bmhome.video.e.f315241a;
            com.larus.bmhome.video.e.a(r111.name(), CollectionsKt.listOf(r101));
            this.f375708a.B1();
            return;
        L12:
            if (r104.f375763b.O == false) goto L14;
            ((TextView) r104.f375764c.getValue()).setText(r104.f375762a.getResources().getString(R.string.larus_slide_up_guide));
            ((TextView) r104.f375764c.getValue()).setVisibility(0);
            ((View) r104.f375765d.getValue()).setVisibility(0);
        L8:
            r108 = "";
            goto L10
        }
    }

    public static final class d implements pr9.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DouYinVideoActivity f375709a;

        public d(DouYinVideoActivity r100) {
            this.f375709a = r100;
        }

        @Override // pr9.g
        public final void a(com.larus.api.bussiness.j r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            DouYinVideoActivity r101 = this.f375709a;
            int r102 = DouYinVideoActivity.f375691p;
            r101.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r101), null, null, new DouYinVideoActivity$tryLoadMoreItemIdList$1(r101, r100, null), 3, null);
        }
    }

    public static final class e implements pr9.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DouYinVideoActivity f375710a;

        public e(DouYinVideoActivity r100) {
            this.f375710a = r100;
        }

        @Override // pr9.i
        public final void a(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "params");
            DouYinVideoActivity r102 = this.f375710a;
            int r103 = DouYinVideoActivity.f375691p;
            DouYinVideoDataManager r104 = r102.A1();
            r104.getClass();
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "params");
            if (Intrinsics.areEqual(r100, HistoryTableOperate.HISTORY_PLAY_TIME) == false) goto L17;
            int r105 = JSONObjectProtectorUtils.getInt(r101, "duration");     // Catch: Exception -> L13
            String r106 = JSONObjectProtectorUtils.getString(r101, "group_id");     // Catch: Exception -> L13
            Integer r107 = r104.f375733v.get(r106);     // Catch: Exception -> L13
            int r108 = 0;
            if (r107 == null) goto L7;
            int r109 = r107.intValue();     // Catch: Exception -> L13
        L8:
            r104.f375733v.put(r106, Integer.valueOf(r109 + r105));     // Catch: Exception -> L13
            RecommendVideoApi r110 = RecommendVideoApi.f315177a;     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r106);     // Catch: Exception -> L13
            Intrinsics.checkNotNullParameter(r106, "videoId");     // Catch: Exception -> L13
            ConcurrentHashMap<String, Integer> r111 = RecommendVideoApi.f315186j;     // Catch: Exception -> L13
            Integer r112 = r111.get(r106);     // Catch: Exception -> L13
            if (r112 == null) goto L11;
            r108 = r112.intValue();     // Catch: Exception -> L13
        L11:
            r111.put(r106, Integer.valueOf(r108 + r105));     // Catch: Exception -> L13
            return;
        L7:
            r109 = 0;
        L13:
            FLogger.f375446a.d("DouYinVideoDataParser", "read play duration and group id error");
            return;
        }
    }

    static {
    }

    public final DouYinVideoDataManager A1() {
        return (DouYinVideoDataManager) this.f375701j.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DouYinVideoActivity.class.getName()));
    L5:
        String r100 = A1().U;
        if (r100 == null) goto L10;
        new m2a.f();
        Intrinsics.checkNotNullParameter(r100, "token");
        cy6.a r101 = cy6.c.a(r100);
        if (r101 == null) goto L10;
        r101.release();
    L10:
        PrefetchRecommendVideoParam r102 = A1().P;
        if (r102 != null) goto L13;
    L15:
        IBTMService r103 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r103 == null) goto L18;
        r103.q(this);
    L18:
        super.onDestroy();
        if (A1().M == VideoParam.RecommendType.Non) goto L21;
        Map<String, CopyOnWriteArrayList<com.larus.bmhome.video.g>> r104 = com.larus.bmhome.video.e.f315241a;
        com.larus.bmhome.video.e.d(A1().M.name());
    L21:
        this.f375696e = null;
        com.larus.platform.service.k r105 = com.larus.platform.service.k.f365753a;
        IAppletJsbEventService.TriggeredEvent r106 = IAppletJsbEventService.TriggeredEvent.LEAVE_AWENME_VIDEO;
        com.larus.platform.service.k.f365753a.a(r106, null);
        l2a.b.f507171a = "";
        com.larus.platform.service.g.f365738a.g("VIDEO_ACTIVITY");
        FLogger.f375446a.j("VIDEO_ACTIVITY", "DouYinVideoActivity onDestroy");
        VideoFeedProviderDelegate.f365695b.c(this.f375704m);
        return;
    L13:
        if (r102.getEnterFromRelatedVideoFlow() == true) goto L15;
        com.larus.video.impl.sdk.f.f375796a.g(PrefetchRecommendVideoParam.copy$default(r102, null, null, null, null, null, CachedVideosPreloadFrom.REFRESH_VIDEO, null, new i(this), null, null, false, null, null, false, null, 32607, null));
        goto L15
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.f375699h != null) goto L9;
        Long r100 = this.f375698g;
        if (r100 == null) goto L7;
        Long r101 = Long.valueOf(r100.longValue() - this.f375694c);
    L8:
        this.f375699h = r101;
        goto L9
    L7:
        r101 = null;
    L9:
        n r102 = z1();
        Intent r103 = getIntent();
        String r104 = this.f375695d;
        long r105 = this.f375694c;
        boolean r106 = this.f375697f;
        Long r107 = this.f375699h;
        Map<String, String> r108 = r102.f375752a.F;
        if (r104 != null) goto L12;
        String r110 = "";
    L13:
        String r109 = (String) ((LinkedHashMap) r108).get(r110);
        if (r109 != null) goto L16;
        r109 = "";
    L16:
        DouYinVideoDataManager r111 = r102.f375752a;
        if (r104 != null) goto L19;
        String r112 = "";
    L20:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "itemId");
        String r113 = (String) ((LinkedHashMap) r111.G).get(r112);
        String r114 = r102.f375752a.I;
        if (r114 != null) goto L23;
    L26:
        boolean r115 = true;
    L27:
        if (r115 == false) goto L29;
        String r116 = r102.f375752a.H;
    L30:
        com.larus.platform.service.o r117 = com.larus.platform.service.o.f365780a;
        JSONObject r118 = new JSONObject();
        if (r104 != null) goto L33;
        String r119 = "";
    L34:
        r118.put("video_id", r119);
        r118.put("duration", System.currentTimeMillis() - r105);
        r118.put("cnt", r102.f375752a.B.size());
        r118.put("req_id", r109);
        String r120 = "1";
        if (r113 == null) goto L41;
        r118.put("channel_id", r113);
        if (Intrinsics.areEqual(r113, "416") == false) goto L39;
        Object r121 = "1";
    L40:
        r118.put("is_inner_video", r121);
        goto L41
    L39:
        r121 = "0";
    L41:
        String r122 = r102.f375752a.A;
        if (r122 != null) goto L44;
        r122 = "";
    L44:
        r118.put("conversation_id", r122);
        String r123 = r102.f375752a.D;
        if (r123 != null) goto L47;
        r123 = "";
    L47:
        r118.put("bot_id", r123);
        String r124 = r102.f375752a.E;
        if (r124 != null) goto L50;
        r124 = "";
    L50:
        r118.put(MusicAppletPage.KEY_MESSAGE_ID, r124);
        if (r103 == null) goto L55;
        Bundle r125 = r103.getExtras();
        if (r125 == null) goto L55;
        String r126 = r125.getString("slidemode");
    L56:
        r118.put("slidemode", r126);
        if (r103 == null) goto L61;
        Bundle r127 = r103.getExtras();
        if (r127 == null) goto L61;
        String r128 = r127.getString("host_enter_from");
    L62:
        r118.put("host_enter_from", r128);
        if (r103 == null) goto L67;
        Bundle r129 = r103.getExtras();
        if (r129 == null) goto L67;
        String r130 = r129.getString(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION);
    L68:
        r118.put(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, r130);
        if (r103 == null) goto L73;
        Bundle r131 = r103.getExtras();
        if (r131 == null) goto L73;
        String r132 = r131.getString("card_sub_position");
    L74:
        r118.put("card_sub_position", r132);
        if (r104 != null) goto L77;
        r104 = "";
    L77:
        r118.put("group_id", r104);
        r118.put(NoticeInfo.KEY_REPLY_ID, r102.f375752a.f375737z);
        r118.put("search_id", r116);
        r118.put("agent_id", r102.f375752a.K);
        if (r106 == true) goto L81;
        r120 = "0";
    L81:
        r118.put("is_first_frame_played", r120);
        if (r107 == null) goto L84;
        r118.put("first_frame_load_duration", r107.longValue());
    L84:
        Unit r133 = Unit.INSTANCE;
        r117.reportEvent("leave_video_layer", r118);
        A1().B.clear();
        B1();
        VideoFeedProviderDelegate.f365695b.g(this.f375705n);
        return;
    L73:
        r132 = null;
    L67:
        r130 = null;
    L61:
        r128 = null;
    L55:
        r126 = null;
        goto L56
    L33:
        r119 = r104;
        goto L34
    L29:
        r116 = r102.f375752a.I;
        goto L30
    L23:
        if (StringsKt.isBlank(r114) == true) goto L26;
        r115 = false;
        goto L27
    L19:
        r112 = r104;
        goto L20
    L12:
        r110 = r104;
        goto L13
    }

    public final n z1() {
        return (n) this.f375703l.getValue();
    }

    public DouYinVideoActivity() {
        this.f375700i = LazyKt.lazy(new com.larus.video.impl.douyin.d(this));
        this.f375701j = LazyKt.lazy(new com.larus.video.impl.douyin.e());
        this.f375702k = LazyKt.lazy(new f(this));
        this.f375703l = LazyKt.lazy(new g(this));
        this.f375704m = new e(this);
        this.f375705n = new d(this);
        this.f375706o = new c(this);
    }

    public final void B1() {
        PrefetchRecommendVideoParam r100 = A1().P;
        if (r100 == null) goto L46;
        Map<String, CopyOnWriteArrayList<com.larus.bmhome.video.g>> r101 = com.larus.bmhome.video.e.f315241a;
        String r102 = A1().M.name();
        Intrinsics.checkNotNullParameter(r102, "scene");
        List r103 = (CopyOnWriteArrayList) ((LinkedHashMap) com.larus.bmhome.video.e.f315242b).get(r102);
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        ArrayList r104 = new ArrayList(r103);
        List r105 = (CopyOnWriteArraySet) ((LinkedHashMap) com.larus.bmhome.video.e.f315243c).get(r102);
        if (r105 != null) goto L12;
        r105 = CollectionsKt.emptyList();
    L12:
        Set r106 = CollectionsKt.toSet(new ArrayList(r105));
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        if (r106.contains((String) r109) == true) goto L14;
        r107.add(r109);
        goto L14
    L18:
        String r110 = r100.getMessageId();
        if (r110 != null) goto L21;
        String r111 = "";
    L22:
        HashMap r112 = new HashMap();
        HashMap r113 = new HashMap();
        Iterator r114 = r107.iterator();
    L24:
        if (r114.hasNext() == false) goto L32;
        String r115 = (String) r114.next();
        DouYinVideoDataManager r116 = A1();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r115, "itemId");
        String r117 = (String) ((LinkedHashMap) r116.F).get(r115);
        if (r117 != null) goto L28;
        r117 = "";
    L28:
        r112.put(r115, r117);
        DouYinVideoDataManager r118 = A1();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r115, "itemId");
        String r119 = (String) ((LinkedHashMap) r118.G).get(r115);
        if (r119 != null) goto L31;
        r119 = "416";
    L31:
        r113.put(r115, r119);
        goto L24
    L32:
        com.larus.platform.api.k r120 = new com.larus.platform.api.k(r112, r111, AppHost.f326268a.getAppClock().currentTimeMillis(), new ArrayList(r107), CachedVideosPreloadFrom.UN_CONSUMED, r100.getImprIndex(), r113);
        IFlowSdkDepend r121 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r121 == null) goto L47;
        r2 r122 = r121.A0();
        if (r122 == null) goto L48;
        r122.o(r120, r100.getEnterFromRelatedVideoFlow());
        return;
    L48:
        return;
    L47:
        return;
    L21:
        r111 = r110;
        goto L22
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(DouYinVideoActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setStatusBarColor(((Number) this.f375700i.getValue()).intValue());
        getWindow().setNavigationBarColor(((Number) this.f375700i.getValue()).intValue());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f375694c = System.currentTimeMillis();
        VideoFeedProviderDelegate.f365695b.e(this.f375705n);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:DouYinVideoActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        FLogger.f375446a.i("DouYinVideoActivity", "onConfigurationChanged, orientation = " + r100.orientation + ", screenLayout = " + r100.screenLayout + ", smallestScreenWidthDp = " + r100.smallestScreenWidthDp);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        getWindow().setStatusBarColor(((Number) this.f375700i.getValue()).intValue());
        getWindow().setNavigationBarColor(((Number) this.f375700i.getValue()).intValue());
        View r103 = y1(getWindow()).findViewById(R.id.root_view);
        if (r103 == null) goto L22;
        e1.x(r103);
        r103.requestApplyInsets();
        r103.requestLayout();
    L22:
        View r104 = findViewById(R.id.fragment_container);
        if (r104 == null) goto L25;
        r104.requestLayout();
    L25:
        pr9.h r105 = this.f375696e;
        if (r105 == null) goto L35;
        Fragment r106 = r105.f();
        if (r106 == null) goto L36;
        View r107 = r106.getView();
        if (r107 == null) goto L37;
        r107.requestLayout();
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Type inference failed for: r4v21, types: [com.larus.video.impl.douyin.j] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.video.impl.douyin.p] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        v19.f.a(getTheme());
        super.onCreate(r110);
        IBTMService r100 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r100 == null) goto L14;
        r100.i(this, getIntent());
    L14:
        String r101 = getIntent().getStringExtra(PhotoEnterModel.SOURCE_BTM_TOKEN);
        IBTMService r102 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r102 == null) goto L17;
        r102.registerBtmPageOnCreate(this, "a35794.b109331", r101);
    L17:
        this.f375694c = System.currentTimeMillis();
        com.larus.platform.service.g.f365738a.e("VIDEO_ACTIVITY");
        FLogger.f375446a.j("VIDEO_ACTIVITY", "DouYinVideoActivity onCreate");
        com.larus.platform.service.k r103 = com.larus.platform.service.k.f365753a;
        com.larus.platform.service.k.f365753a.a(IAppletJsbEventService.TriggeredEvent.ENTER_AWENME_VIDEO, null);
        TtsClientDelegate.f289868b.cancel("DouYinVideoActivity onCreate", false);
        Lazy r104 = q3.f365794a;
        z3 r105 = q3.a();
        if (r105 == null) goto L20;
        r105.n(null);
    L20:
        DouYinVideoDataManager r106 = A1();
        Intent r107 = getIntent();
        r106.getClass();
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r111 = "";
        if (r107 == null) goto L342;
        Bundle r108 = r107.getExtras();
        if (r108 == null) goto L25;
        String r109 = r108.getString("media_error_msg");
    L26:
        if (r109 != null) goto L28;
    L31:
        boolean r112 = true;
    L32:
        if (r112 == true) goto L39;
        t19.s r113 = t19.s.f544207a;
        Bundle r114 = r107.getExtras();
        if (r114 == null) goto L37;
        String r115 = r114.getString("media_error_msg");
        if (r115 == null) goto L37;
    L38:
        r113.getClass();
        t19.s.c(this, r115);
    L358:
        boolean r116 = false;
    L360:
        if (r116 == true) goto L362;
        finish();
        boolean r117 = false;
    L363:
        if (r117 == false) goto L616;
        setContentView(R.layout.larus_activity_douyin_video);
        DouYinVideoDataManager r118 = A1();
        ArrayList<MediaEntity> r119 = r118.L;
        if (r119 == null) goto L370;
        MediaEntity r120 = (MediaEntity) CollectionsKt.getOrNull(r119, r118.f375717f);
        if (r120 == null) goto L370;
        String r121 = r120.getItem_id();
    L371:
        if (r121 != null) goto L373;
        r121 = "";
    L373:
        r118.f375731t = r121;
        ArrayList r122 = new ArrayList();
        ArrayList r123 = new ArrayList();
        ArrayList<MediaEntity> r124 = r118.L;
        if (r124 == null) goto L401;
        Iterator<T> r125 = r124.iterator();
    L377:
        if (r125.hasNext() == false) goto L401;
        MediaEntity r126 = (MediaEntity) r125.next();
        if (r126 == null) goto L381;
        String r127 = r126.getItem_id();
    L382:
        if (r126 == null) goto L384;
        String r128 = r126.getInteractive_rec_info();
    L385:
        if (r127 != null) goto L387;
    L390:
        boolean r129 = true;
    L391:
        if (r129 == true) goto L377;
        r122.add(r127);
        if (r128 != null) goto L395;
    L398:
        boolean r130 = true;
    L399:
        if (r130 == true) goto L377;
        r123.add(TuplesKt.to(r127, r128));
        goto L377
    L395:
        if (r128.length() == 0) goto L398;
        r130 = false;
        goto L399
    L387:
        if (r127.length() == 0) goto L390;
        r129 = false;
        goto L391
    L384:
        r128 = null;
        goto L385
    L381:
        r127 = null;
    L401:
        Map<String, CopyOnWriteArrayList<com.larus.bmhome.video.g>> r131 = com.larus.bmhome.video.e.f315241a;
        com.larus.bmhome.video.e.a(r118.M.name(), r122);
        VideoParam.RecommendType r132 = r118.M;
        if (r132 == VideoParam.RecommendType.Search) goto L406;
        if (r132 == VideoParam.RecommendType.AwemeFeed) goto L406;
    L424:
        w r133 = new w(r121, r122, r123);
        VideoParam.RecommendType r134 = A1().M;
        if (r134 == VideoParam.RecommendType.Non) goto L463;
        DouYinVideoDataManager r135 = A1();
        int r136 = b.f375707a[r134.ordinal()];
        if (r136 == 1) goto L431;
        if (r136 == 2) goto L431;
    L462:
        com.larus.bmhome.video.e.c(r134.name(), r133.f375769b);
    L431:
        FirstFramePreloadVideoData r137 = r135.Q;
        if (r137 == null) goto L436;
        ArrayList<String> r138 = r137.getPreLoadFirstRequestItemIdList();
        if (r138 == null) goto L436;
        List r139 = CollectionsKt.filterNotNull(r138);
    L437:
        if (r139 != null) goto L439;
        r139 = CollectionsKt.emptyList();
    L439:
        String r140 = r134.name();
        List<String> r141 = r133.f375769b;
        ArrayList r142 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r141, 10));
        Iterator<T> r143 = r141.iterator();
    L441:
        if (r143.hasNext() == false) goto L461;
        String r144 = (String) r143.next();
        if (r139.contains(r144) == false) goto L450;
        FirstFramePreloadVideoData r145 = r135.Q;
        if (r145 == null) goto L449;
        Map<String, String> r146 = r145.getPreLoadFirstRequestItemIdToRequestIdMap();
        if (r146 == null) goto L449;
        String r147 = r146.get(r144);
    L452:
        if (r139.contains(r144) == false) goto L459;
        FirstFramePreloadVideoData r148 = r135.Q;
        if (r148 == null) goto L458;
        Map<String, String> r149 = r148.getPreLoadFirstRequestItemIdToChannelIdMap();
        if (r149 == null) goto L458;
        String r150 = r149.get(r144);
    L460:
        r142.add(new com.larus.bmhome.video.g(r144, r147, r150));
    L458:
        r150 = null;
        goto L460
    L459:
        r150 = r135.f375711J;
    L449:
        r147 = null;
        goto L452
    L450:
        r147 = r135.H;
        goto L452
    L461:
        com.larus.bmhome.video.e.b(r140, r142);
    L436:
        r139 = null;
    L463:
        DouYinVideoDataManager r151 = A1();
        Intent r152 = getIntent();
        r151.getClass();
        Intrinsics.checkNotNullParameter(r133, "enterDouYinSdkParam");
        or9.d r153 = new or9.d();
        List<String> r154 = r133.f375769b;
        Intrinsics.checkNotNullParameter(r154, "itemIDList");
        r153.f524975b = r154;
        JSONObject r155 = new JSONObject();
        r155.put("req_id", r151.H);
        String r156 = r151.A;
        if (r156 != null) goto L466;
        r156 = "";
    L466:
        r155.put("conversation_id", r156);
        String r157 = r151.D;
        if (r157 != null) goto L469;
        r157 = "";
    L469:
        r155.put("bot_id", r157);
        String r158 = r151.E;
        if (r158 != null) goto L472;
        r158 = "";
    L472:
        r155.put(MusicAppletPage.KEY_MESSAGE_ID, r158);
        Intrinsics.checkNotNullParameter(r155, "jsonObject");
        r153.f524976c = r155;
        r153.f524977d = true;
        List<Pair<String, String>> r159 = r133.f375770c;
        Intrinsics.checkNotNullParameter(r159, "interactiveRecInfoList");
        r153.f524978e = r159;
        r153.f524984k = r151.f375720i;
        EnterVideoMethod r160 = or9.a.a(r151.f375736y);     // Catch: Exception -> L475
    L476:
        Intrinsics.checkNotNullParameter(r160, "enterVideoMethod");
        r153.f524974a = r160;
        r153.f524983j = r151.f375719h;
        String r161 = r133.f375768a;
        Intrinsics.checkNotNullParameter(r161, "enterItemID");
        r153.f524991r = r161;
        r153.f524993t = false;
        r153.f524996w = 0;
        String r162 = r151.f375721j;
        Intrinsics.checkNotNullParameter(r162, "sceneID");
        r153.f524989p = r162;
        r153.f524998y = r151.f375722k;
        Long r163 = StringsKt.toLongOrNull(AccountService.f365697a.getUserId());
        if (r163 == null) goto L479;
        long r164 = r163.longValue();
    L480:
        r153.f524990q = r164;
        r153.f524985l = r151.f375724m;
        r153.f524986m = r151.f375723l;
        r153.f524980g = false;
        JSONObject r165 = new JSONObject();
        String r166 = r151.E;
        if (r166 != null) goto L483;
        r166 = "";
    L483:
        r165.put("host_message_id", r166);
        r165.put("host_conversation_id", r151.A);
        String r167 = r151.f375725n;
        if (r167 != null) goto L486;
        r167 = "";
    L486:
        r165.put("host_last_message_id", r167);
        r165.put("host_enter_from_group_id", r151.f375727p);
        String r168 = r151.K;
        if (r168 != null) goto L489;
        r168 = "";
    L489:
        r165.put("host_agent_id", r168);
        r165.put("host_impr_index", r151.f375728q);
        if (o0.d(r151.f375726o) == false) goto L492;
        r165.put("host_enter_from", r151.f375726o);
    L492:
        r165.put("host_rank", r151.f375730s);
        String r169 = r151.D;
        if (r169 != null) goto L495;
        r169 = "";
    L495:
        r165.put("host_bot_id", r169);
        String r170 = r151.f375713b;
        if (r170 != null) goto L498;
        r170 = "";
    L498:
        r165.put("host_section_id", r170);
        String r171 = r151.H;
        if (r171 != null) goto L501;
        r171 = "";
    L501:
        r165.put("host_req_id", r171);
        String r172 = r151.f375737z;
        if (r172 != null) goto L504;
        r172 = "";
    L504:
        r165.put("host_reply_id", r172);
        String r173 = r151.f375714c;
        if (r173 == null) goto L508;
        r111 = r173;
    L508:
        r165.put("host_chat_type", r111);
        r165.put("host_recommend_type", r151.M.name());
        if (r152 == null) goto L513;
        Bundle r174 = r152.getExtras();
        if (r174 == null) goto L513;
        String r175 = r174.getString("slidemode");
    L514:
        r165.put("host_slidemode", r175);
        if (r152 == null) goto L519;
        Bundle r176 = r152.getExtras();
        if (r176 == null) goto L519;
        String r177 = r176.getString(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION);
    L520:
        r165.put("host_card_position", r177);
        if (r152 == null) goto L525;
        Bundle r178 = r152.getExtras();
        if (r178 == null) goto L525;
        String r179 = r178.getString("card_sub_position");
    L526:
        r165.put("host_card_sub_position", r179);
        if (r152 == null) goto L531;
        Bundle r180 = r152.getExtras();
        if (r180 == null) goto L531;
        String r181 = r180.getString("rich_media_type");
    L532:
        r165.put("host_rich_media_type", r181);
        if (r152 == null) goto L537;
        Bundle r182 = r152.getExtras();
        if (r182 == null) goto L537;
        String r183 = r182.getString("module_source");
    L538:
        r165.put("host_module_source", r183);
        if (r152 == null) goto L543;
        Bundle r184 = r152.getExtras();
        if (r184 == null) goto L543;
        String r185 = r184.getString("module_position");
    L544:
        r165.put("host_module_position", r185);
        r165.put("host_incoming_video_ids", r133.f375769b.toString());
        if (r152 == null) goto L551;
        Bundle r186 = r152.getExtras();
        if (r186 == null) goto L551;
        String r187 = r186.getString("host_key_search_id");
        if (r187 == null) goto L551;
        r165.put("host_key_search_id", r187);
    L551:
        JSONObject r188 = r151.T;
        if (r188 == null) goto L562;
        Iterator<String> r189 = r188.keys();
        if (r189 == null) goto L562;
    L556:
        if (r189.hasNext() == false) goto L562;
        String r190 = r189.next();
        JSONObject r191 = r151.T;
        if (r191 == null) goto L560;
        Object r192 = r191.opt(r190);
    L561:
        r165.putOpt(r190, r192);
        goto L556
    L560:
        r192 = null;
    L562:
        Intrinsics.checkNotNullParameter(r165, "trackParams");
        r153.f524988o = r165;
        r153.f524994u = c7.b(50);
        r153.f524992s = false;
        r153.A = r151.f375718g;
        VideoFeedConfigure r193 = r153.a();
        VideoFeedProviderDelegate r194 = VideoFeedProviderDelegate.f365695b;
        pr9.h r195 = r194.i(r193);
        this.f375696e = r195;
        Fragment r196 = r195.f();
        r196.setArguments(getIntent().getExtras());
        FragmentTransaction r197 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r197, r196, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L566;
        r197 = r197.replace(R.id.fragment_container, r196);
    L566:
        r197.commitAllowingStateLoss();
        y1(getWindow()).setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        int r198 = com.larus.utils.d.f375378a;
        com.larus.utils.d.a(this, new l2a.c(), new l2a.d(), new j(this), null, 16);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DouYinVideoActivity$setupWindowConfig$2(this, null), 3, null);
        pr9.h r199 = this.f375696e;
        if (r199 == null) goto L569;
        r199.xQ(this.f375706o);
    L569:
        r194.e(this.f375705n);
        r194.h(this.f375704m);
        final v r200 = (v) this.f375702k.getValue();
        pr9.h r201 = this.f375696e;
        r200.getClass();
        final DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1 r202 = new DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1(r201, r200);
        r200.f375762a.getOnBackPressedDispatcher().addCallback(r200.f375762a, r202);
        ImageView r203 = (ImageView) r200.f375766e.getValue();
        if (r203 == null) goto L572;
        e1.d(r203, new q(r202));
    L572:
        z2 r204 = z2.f365865a;
        final int r205 = r204.networkAutoSwitch().f486681b;
        if (r204.networkAutoSwitch().f486680a == false) goto L577;
        if (r205 <= 0) goto L577;
        final Keva r206 = Keva.getRepo("network_auto_switch");
        final Ref.LongRef r207 = new Ref.LongRef();
        com.larus.network.ttnet.c.f360221a.getClass();
        com.larus.network.ttnet.c.f360224d.observe(r200.f375762a, new v.a(new p(r207, r206, r205, r200)));
    L577:
        DouYinActivityVideoModel r208 = new DouYinActivityVideoModel();
        this.f375692a = r208;
        r208.updateLoadMoreParamsFromVideoSource(A1().C);
        View r209 = findViewById(R.id.layout_up_slide);
        if (r209 == null) goto L580;
        r209.setOnTouchListener(new h(this));
    L580:
        n r210 = z1();
        r210.getClass();
        MultimodalTraceDelegate.f297171b.b((String) r210.f375753b.getValue(), r210.f375752a.A);
        return;
    L543:
        r185 = null;
    L537:
        r183 = null;
    L531:
        r181 = null;
    L525:
        r179 = null;
    L519:
        r177 = null;
    L513:
        r175 = null;
        goto L514
    L479:
        r164 = -1;
    L475:
        r160 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
    L406:
        if (r118.f375715d != 0) goto L424;
        if (r118.N == true) goto L410;
        r122.clear();
        r122.add(r121);
    L410:
        FirstFramePreloadVideoData r1100 = r118.Q;
        if (r1100 == null) goto L424;
        ArrayList<String> r1101 = r1100.getPreLoadFirstRequestItemIdList();
        if (r1101 == null) goto L424;
        List r1102 = CollectionsKt.filterNotNull(r1101);
        if (r1102 == null) goto L424;
        List r1103 = r1102;
        if ((!r1103.isEmpty()) == false) goto L424;
        r122.addAll(r1103);
        Intrinsics.checkNotNullParameter(r1102, "videoIdList");
        com.larus.bmhome.video.e.f315244d.addAll(r1103);
        r118.f375732u = true;
        FirstFramePreloadVideoData r211 = r118.Q;
        if (r211 == null) goto L421;
        boolean r212 = Intrinsics.areEqual(r211.getInnerLoadMoreRequestFromSecondRun(), Boolean.TRUE);
    L422:
        if (r212 == false) goto L424;
        r118.W = 2;
        goto L424
    L421:
        r212 = false;
    L370:
        r121 = null;
        goto L371
    L616:
        return;
    L362:
        r117 = true;
    L37:
        r115 = "";
        goto L38
    L39:
        Bundle r213 = r107.getExtras();
        if (r213 == null) goto L42;
        Serializable r214 = r213.getSerializable("_media_arg_key");
    L43:
        if (r214 != null) goto L45;
        boolean r215 = true;
    L46:
        if (r215 == false) goto L342;
        Bundle r216 = r107.getExtras();
        if (r216 == null) goto L50;
        Serializable r217 = r216.getSerializable("_media_arg_key");
    L51:
        if (r217 != null) goto L53;
        boolean r218 = true;
    L54:
        if (r218 == false) goto L342;
        Bundle r219 = r107.getExtras();
        if (r219 == null) goto L58;
        Serializable r220 = r219.getSerializable("_media_arg_key");
    L59:
        r106.L = (ArrayList) r220;
        Bundle r221 = r107.getExtras();
        if (r221 == null) goto L62;
        Serializable r222 = r221.getSerializable("key_reply_item_ids");
    L64:
        if ((r222 instanceof ArrayList) == false) goto L66;
        ArrayList<String> r223 = (ArrayList) r222;
    L67:
        r106.R = r223;
        Bundle r224 = r107.getExtras();
        if (r224 == null) goto L70;
        Serializable r225 = r224.getSerializable("extra_item_id_list");
    L71:
        r106.f375712a = (ArrayList) r225;
        Bundle r226 = r107.getExtras();
        if (r226 == null) goto L74;
        Serializable r227 = r226.getSerializable("_media_container_key");
    L76:
        if ((r227 instanceof MediaEntityContainer) == false) goto L78;
        MediaEntityContainer r228 = (MediaEntityContainer) r227;
    L79:
        r106.C = r228;
        Bundle r229 = r107.getExtras();
        if (r229 == null) goto L82;
        String r230 = r229.getString("key_bot_id");
    L83:
        r106.D = r230;
        Bundle r231 = r107.getExtras();
        if (r231 == null) goto L86;
        String r232 = r231.getString("section_id");
    L87:
        r106.f375713b = r232;
        Bundle r233 = r107.getExtras();
        if (r233 == null) goto L90;
        String r234 = r233.getString("req_id");
    L91:
        r106.H = r234;
        Bundle r235 = r107.getExtras();
        if (r235 == null) goto L94;
        String r236 = r235.getString("host_key_search_id");
    L95:
        r106.I = r236;
        Bundle r237 = r107.getExtras();
        if (r237 == null) goto L98;
        String r238 = r237.getString("key_channel_id");
    L99:
        r106.f375711J = r238;
        Bundle r239 = r107.getExtras();
        if (r239 == null) goto L102;
        String r240 = r239.getString("key_chat_type");
    L103:
        r106.f375714c = r240;
        Bundle r241 = r107.getExtras();
        if (r241 == null) goto L106;
        String r242 = r241.getString("key_message_id");
    L107:
        r106.E = r242;
        Bundle r243 = r107.getExtras();
        if (r243 == null) goto L110;
        String r244 = r243.getString("key_last_message_id");
    L111:
        r106.f375725n = r244;
        Bundle r245 = r107.getExtras();
        if (r245 == null) goto L114;
        String r246 = r245.getString("host_enter_from");
    L115:
        r106.f375726o = r246;
        Bundle r247 = r107.getExtras();
        if (r247 == null) goto L118;
        String r248 = r247.getString("enter_from_group_id");
    L119:
        r106.f375727p = r248;
        Bundle r249 = r107.getExtras();
        if (r249 == null) goto L122;
        String r250 = r249.getString("agent_id");
    L123:
        r106.K = r250;
        Bundle r251 = r107.getExtras();
        if (r251 == null) goto L126;
        Integer r252 = Integer.valueOf(r251.getInt("impr_index"));
    L127:
        r106.f375728q = r252;
        Bundle r253 = r107.getExtras();
        if (r253 == null) goto L130;
        Integer r254 = Integer.valueOf(r253.getInt("key_stream_index"));
    L131:
        r106.f375729r = r254;
        Bundle r255 = r107.getExtras();
        if (r255 == null) goto L134;
        Integer r256 = Integer.valueOf(r255.getInt("rank"));
    L135:
        r106.f375730s = r256;
        Bundle r257 = r107.getExtras();
        if (r257 == null) goto L138;
        String r258 = r257.getString("key_conversation_id");
    L139:
        r106.A = r258;
        Bundle r259 = r107.getExtras();
        if (r259 == null) goto L142;
        int r260 = r259.getInt("key_video_index");
    L143:
        r106.f375717f = r260;
        Bundle r261 = r107.getExtras();
        if (r261 == null) goto L146;
        long r1104 = r261.getLong("key_start_play_position", 0);
    L147:
        r106.f375718g = RangesKt.coerceAtLeast(r1104, 0);
        Bundle r262 = r107.getExtras();
        if (r262 == null) goto L150;
        boolean r263 = r262.getBoolean("key_need_custom_load_more");
    L151:
        r106.f375719h = r263;
        Bundle r264 = r107.getExtras();
        if (r264 == null) goto L154;
        boolean r265 = r264.getBoolean("key_need_custom_refresh");
    L155:
        r106.f375720i = r265;
        Bundle r266 = r107.getExtras();
        if (r266 == null) goto L158;
        boolean r267 = r266.getBoolean("key_need_load_more", true);
    L159:
        r106.f375735x = r267;
        Bundle r268 = r107.getExtras();
        if (r268 == null) goto L163;
        String r269 = r268.getString("key_enter_method");
        if (r269 == null) goto L163;
    L164:
        r106.f375736y = r269;
        Bundle r270 = r107.getExtras();
        if (r270 == null) goto L168;
        String r271 = r270.getString("key_dou_yin_scene_id");
        if (r271 == null) goto L168;
    L169:
        r106.f375721j = r271;
        Bundle r272 = r107.getExtras();
        if (r272 == null) goto L173;
        String r273 = r272.getString("key_dou_yin_video_image_cover");
        if (r273 == null) goto L173;
    L174:
        r106.f375722k = r273;
        Bundle r274 = r107.getExtras();
        if (r274 == null) goto L177;
        int r275 = r274.getInt("key_dou_yin_video_image_cover_width");
    L178:
        r106.f375724m = r275;
        Bundle r276 = r107.getExtras();
        if (r276 == null) goto L181;
        int r277 = r276.getInt("key_dou_yin_video_image_cover_height");
    L182:
        r106.f375723l = r277;
        Bundle r278 = r107.getExtras();
        if (r278 == null) goto L185;
        String r279 = r278.getString("key_reply_id");
    L186:
        r106.f375737z = r279;
        Bundle r280 = r107.getExtras();
        if (r280 == null) goto L189;
        Serializable r281 = r280.getSerializable("key_video_recommend_type");
    L191:
        if ((r281 instanceof VideoParam.RecommendType) == false) goto L193;
        VideoParam.RecommendType r282 = (VideoParam.RecommendType) r281;
    L194:
        if (r282 != null) goto L196;
        r282 = VideoParam.RecommendType.Non;
    L196:
        r106.M = r282;
        Bundle r283 = r107.getExtras();
        if (r283 == null) goto L199;
        boolean r284 = r283.getBoolean("key_keep_all_outer_aid_when_recommend");
    L200:
        r106.N = r284;
        Bundle r285 = r107.getExtras();
        if (r285 == null) goto L203;
        int r286 = r285.getInt("key_ugc_video_scene");
    L204:
        r106.f375715d = r286;
        Bundle r287 = r107.getExtras();
        if (r287 == null) goto L207;
        ArrayList<String> r288 = r287.getStringArrayList("key_query");
    L208:
        r106.f375716e = r288;
        Bundle r289 = r107.getExtras();
        if (r289 == null) goto L211;
        boolean r290 = r289.getBoolean("key_force_preload_recommend");
    L212:
        r106.S = r290;
        Bundle r291 = r107.getExtras();
        if (r291 == null) goto L224;
        String r292 = r291.getString("key_host_track_params");
        if (r292 == null) goto L224;
        Result.Companion r1105 = Result.Companion;     // Catch: Throwable -> L218
        Object r293 = Result.m9449constructorimpl(new JSONObject(r292));     // Catch: Throwable -> L218
    L221:
        if (Result.m9455isFailureimpl(r293) == false) goto L223;
        r293 = null;
    L223:
        JSONObject r294 = (JSONObject) r293;
    L225:
        r106.T = r294;
        Bundle r295 = r107.getExtras();
        if (r295 == null) goto L228;
        Serializable r296 = r295.getSerializable("key_first_frame_preload_cache");
    L230:
        if ((r296 instanceof FirstFramePreloadVideoData) == false) goto L232;
        FirstFramePreloadVideoData r297 = (FirstFramePreloadVideoData) r296;
    L233:
        r106.Q = r297;
        Bundle r298 = r107.getExtras();
        if (r298 == null) goto L236;
        Serializable r299 = r298.getSerializable("key_preload_request_param");
    L238:
        if ((r299 instanceof PrefetchRecommendVideoParam) == false) goto L240;
        PrefetchRecommendVideoParam r300 = (PrefetchRecommendVideoParam) r299;
    L241:
        r106.P = r300;
        ArrayList<MediaEntity> r301 = r106.L;
        if (r301 == null) goto L273;
        Iterator<T> r302 = r301.iterator();
    L245:
        if (r302.hasNext() == false) goto L273;
        MediaEntity r1106 = (MediaEntity) r302.next();
        Map<String, String> r1107 = r106.F;
        if (r1106 == null) goto L249;
        String r1108 = r1106.getItem_id();
    L250:
        if (r1108 != null) goto L252;
        r1108 = "";
    L252:
        String r1109 = r106.H;
        if (r1109 != null) goto L255;
        r1109 = "";
    L255:
        r1107.put(r1108, r1109);
        FirstFramePreloadVideoData r1110 = r106.Q;
        if (r1110 == null) goto L245;
        Map<String, String> r1111 = r1110.getPreLoadFirstRequestItemIdToChannelIdMap();
        if (r1111 == null) goto L245;
        if (r1106 == null) goto L261;
        String r1112 = r1106.getItem_id();
    L262:
        if (r1112 != null) goto L264;
        r1112 = "";
    L264:
        String r1113 = r1111.get(r1112);
        if (r1113 == null) goto L245;
        Map<String, String> r1114 = r106.G;
        if (r1106 == null) goto L269;
        String r1115 = r1106.getItem_id();
    L270:
        if (r1115 != null) goto L272;
        r1115 = "";
    L272:
        r1114.put(r1115, r1113);
        goto L245
    L269:
        r1115 = null;
        goto L270
    L261:
        r1112 = null;
        goto L262
    L249:
        r1108 = null;
    L273:
        FirstFramePreloadVideoData r303 = r106.Q;
        if (r303 == null) goto L298;
        ArrayList<String> r304 = r303.getPreLoadFirstRequestItemIdList();
        if (r304 == null) goto L298;
        List r305 = CollectionsKt.filterNotNull(r304);
        if (r305 == null) goto L298;
        Iterator r306 = r305.iterator();
    L281:
        if (r306.hasNext() == false) goto L298;
        String r1116 = (String) r306.next();
        Map<String, String> r1117 = r106.F;
        FirstFramePreloadVideoData r1118 = r106.Q;
        if (r1118 == null) goto L287;
        Map<String, String> r1119 = r1118.getPreLoadFirstRequestItemIdToRequestIdMap();
        if (r1119 == null) goto L287;
        String r1120 = r1119.get(r1116);
    L288:
        if (r1120 != null) goto L290;
        r1120 = "";
    L290:
        r1117.put(r1116, r1120);
        Map<String, String> r1121 = r106.G;
        FirstFramePreloadVideoData r1122 = r106.Q;
        if (r1122 == null) goto L296;
        Map<String, String> r1123 = r1122.getPreLoadFirstRequestItemIdToChannelIdMap();
        if (r1123 == null) goto L296;
        String r1124 = r1123.get(r1116);
        if (r1124 == null) goto L296;
    L297:
        r1121.put(r1116, r1124);
    L296:
        r1124 = "414";
    L287:
        r1120 = null;
    L298:
        ArrayList<MediaEntity> r307 = r106.L;
        if (r307 != null) goto L301;
    L304:
        boolean r308 = true;
    L305:
        if (r308 == true) goto L313;
        ArrayList<MediaEntity> r309 = r106.L;
        if (r309 != null) goto L309;
    L311:
        boolean r310 = false;
    L312:
        if (r310 == true) goto L313;
    L314:
        Bundle r311 = r107.getExtras();
        if (r311 == null) goto L317;
        String r312 = r311.getString("key_poi_feed_provider_token");
    L318:
        r106.U = r312;
        Bundle r313 = r107.getExtras();
        if (r313 == null) goto L321;
        r313.getString("key_poi_enter_aweme_id");
    L321:
        Bundle r314 = r107.getExtras();
        if (r314 == null) goto L324;
        r314.getString("key_poi_id");
    L324:
        Bundle r315 = r107.getExtras();
        if (r315 == null) goto L339;
        String r316 = r315.getString("key_poi_track_params_json");
        if (r316 == null) goto L339;
        Result.Companion r317 = Result.Companion;     // Catch: Throwable -> L330
        Object r318 = Result.m9449constructorimpl(new JSONObject(r316));     // Catch: Throwable -> L330
    L332:
        Throwable r319 = Result.m9452exceptionOrNullimpl(r318);
        if (r319 == null) goto L336;
        FLogger.f375446a.e("DouYinVideoDataParser", "parse POI track params failed: " + r319.getMessage());
    L336:
        if (Result.m9455isFailureimpl(r318) == false) goto L338;
        r318 = null;
    L338:
        JSONObject r320 = (JSONObject) r318;
    L340:
        r106.V = r320;
    L330:
        th = move-exception;
        Result.Companion r321 = Result.Companion;
        r318 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L339:
        r320 = null;
        goto L340
    L317:
        r312 = null;
        goto L318
    L309:
        if (r309.size() != 1) goto L311;
        r310 = true;
    L313:
        r106.O = false;
        goto L314
    L301:
        if (r307.isEmpty() == true) goto L304;
        r308 = false;
        goto L305
    L240:
        r300 = null;
        goto L241
    L236:
        r299 = null;
        goto L238
    L232:
        r297 = null;
        goto L233
    L228:
        r296 = null;
    L218:
        th = move-exception;
        Result.Companion r1125 = Result.Companion;
        r293 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L224:
        r294 = null;
        goto L225
    L211:
        r290 = false;
        goto L212
    L207:
        r288 = null;
        goto L208
    L203:
        r286 = 0;
        goto L204
    L199:
        r284 = false;
        goto L200
    L193:
        r282 = null;
        goto L194
    L189:
        r281 = null;
        goto L191
    L185:
        r279 = null;
        goto L186
    L181:
        r277 = 10;
        goto L182
    L177:
        r275 = 10;
    L173:
        r273 = "";
    L168:
        r271 = "false";
    L163:
        r269 = "";
        goto L164
    L158:
        r267 = true;
        goto L159
    L154:
        r265 = false;
        goto L155
    L150:
        r263 = false;
        goto L151
    L146:
        r1104 = 0;
        goto L147
    L142:
        r260 = 0;
        goto L143
    L138:
        r258 = null;
        goto L139
    L134:
        r256 = null;
        goto L135
    L130:
        r254 = null;
        goto L131
    L126:
        r252 = null;
        goto L127
    L122:
        r250 = null;
        goto L123
    L118:
        r248 = null;
        goto L119
    L114:
        r246 = null;
        goto L115
    L110:
        r244 = null;
        goto L111
    L106:
        r242 = null;
        goto L107
    L102:
        r240 = null;
        goto L103
    L98:
        r238 = null;
        goto L99
    L94:
        r236 = null;
        goto L95
    L90:
        r234 = null;
        goto L91
    L86:
        r232 = null;
        goto L87
    L82:
        r230 = null;
        goto L83
    L78:
        r228 = null;
        goto L79
    L74:
        r227 = null;
        goto L76
    L70:
        r225 = null;
        goto L71
    L66:
        r223 = null;
        goto L67
    L62:
        r222 = null;
        goto L64
    L58:
        r220 = null;
        goto L59
    L53:
        r218 = r217 instanceof ArrayList;
        goto L54
    L50:
        r217 = null;
        goto L51
    L45:
        r215 = r214 instanceof ArrayList;
        goto L46
    L42:
        r214 = null;
        goto L43
    L28:
        if (r109.length() == 0) goto L31;
        r112 = false;
        goto L32
    L25:
        r109 = null;
    L342:
        if (r106.M == VideoParam.RecommendType.Non) goto L345;
        r106.f375719h = true;
    L345:
        if (r106.f375735x == true) goto L347;
        r106.f375719h = true;
    L347:
        ArrayList<MediaEntity> r322 = r106.L;
        if (r322 != null) goto L350;
    L353:
        boolean r323 = true;
    L354:
        if (r323 == true) goto L358;
        if (r106.C == null) goto L358;
        r116 = true;
        goto L360
    L350:
        if (r322.isEmpty() == true) goto L353;
        r323 = false;
        goto L354
    }
}
