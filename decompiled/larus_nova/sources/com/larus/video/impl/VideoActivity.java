package com.larus.video.impl;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.audio.ttsV2.TtsClientDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.home.impl.utils.c;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.d;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.larus.video.impl.widget.PagerLayoutManager;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l2a.g;
import l2a.h;
import l2a.i;
import l2a.k;
import l2a.l;
import l2a.m;
import l2a.o;
import l2a.p;
import org.json.JSONObject;
import t19.s;
import v19.f;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00102\u001a\u00020\u0011H\u0016J\b\u00103\u001a\u00020\u0011H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0015J\b\u00109\u001a\u000206H\u0014J\b\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u000206H\u0016J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\u000e\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u001eJ\u001e\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u001eJ\b\u0010F\u001a\u000206H\u0014J\b\u0010G\u001a\u000206H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b/\u00100¨\u0006H"}, d2 = {"Lcom/larus/video/impl/VideoActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "mStatusView", "Lcom/larus/common_ui/widget/LoadingWithRetryView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Lcom/larus/video/impl/VideoDetailAdapter;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "mItemListener", "Lcom/larus/video/impl/ITikTokItemListener;", "mBackBtn", "Landroid/widget/ImageView;", "mIsPlaying", "", "mItems", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "mMediaContainer", "Lcom/larus/platform/uimodel/MediaEntityContainer;", "mSourceFrom", "", "Ljava/lang/Integer;", "mEnterTime", "", "mBotId", "", "mMessageId", "mConversationId", "mVideoIndex", "mEnterMethod", "mRecordBrowserVideo", "", "mUseNewApiGetVideoModel", "mMainHandler", "Landroid/os/Handler;", "getMMainHandler", "()Landroid/os/Handler;", "mMainHandler$delegate", "Lkotlin/Lazy;", "mUseShareAnim", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "getMVideoController", "()Lcom/larus/platform/api/IVideoController;", "mVideoController$delegate", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "getBackgroundResource", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "initData", "initView", "onAttachedToWindow", "tryInitVideoView", "updateViewByNetwork", DyPayConstant.KEY_SHOW_LOADING, "initVideo", "reportClickVideoPlayer", "status", "reportSwipeVideo", "lastPosition", "curPosition", "onPause", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LoadingWithRetryView f375659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f375660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoDetailAdapter f375661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommonVideoModel f375662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public o f375663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f375664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<MediaEntity> f375665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MediaEntityContainer f375666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f375667o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f375668p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f375669q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f375670r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f375671s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f375672t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f375673u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Set<String> f375674v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f375675w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f375676x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f375677y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f375678z;

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final int C1() {
        return R.color.transparent;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return !this.f375677y;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        return !this.f375677y;
    }

    public final IVideoController O1() {
        return (IVideoController) this.f375678z.getValue();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VideoActivity.class.getName()));
    L5:
        super.onDestroy();
        RecyclerView r100 = this.f375660h;
        if (r100 == null) goto L8;
        r100.setKeepScreenOn(false);
    L8:
        CommonVideoModel r101 = this.f375662j;
        if (r101 == null) goto L13;
        ArrayList<MediaEntity> r102 = r101.getItems();
        if (r102 == null) goto L13;
        int r103 = r102.size();
    L14:
        if (r103 <= 0) goto L25;
        Set<String> r104 = this.f375674v;
        CommonVideoModel r105 = this.f375662j;
        if (r105 == null) goto L23;
        ArrayList<MediaEntity> r106 = r105.getItems();
        if (r106 == null) goto L23;
        MediaEntity r107 = (MediaEntity) ListProtector.get(r106, 0);
        if (r107 == null) goto L23;
        String r108 = r107.getItem_id();
        if (r108 == null) goto L23;
    L24:
        r104.add(r108);
    L23:
        r108 = "";
    L25:
        ((Handler) this.f375676x.getValue()).removeCallbacksAndMessages(null);
        O1().I(false);
        O1().release();
        return;
    L13:
        r103 = 0;
        goto L14
    }

    public VideoActivity() {
        this.f375674v = new LinkedHashSet();
        this.f375676x = LazyKt.lazy(new g(this));
        this.f375678z = LazyKt.lazy(new h());
    }

    public final void R1() {
        boolean r100 = false;
        if (NetworkUtils.isNetworkAvailable(this) == true) goto L14;
        LoadingWithRetryView r101 = this.f375659g;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        LoadingWithRetryView r102 = this.f375659g;
        if (r102 == null) goto L10;
        r102.b();
    L10:
        LoadingWithRetryView r103 = this.f375659g;
        if (r103 == null) goto L13;
        r103.setOnRetryListener(new l(this));
    L13:
        ((Handler) this.f375676x.getValue()).postDelayed(new k(this), 340);
        return;
    L14:
        LoadingWithRetryView r104 = this.f375659g;
        if (r104 == null) goto L17;
        e1.o(r104);
    L17:
        ArrayList<MediaEntity> r105 = this.f375665m;
        if (r105 != null) goto L20;
    L21:
        r100 = true;
    L22:
        if (r100 == false) goto L29;
        LoadingWithRetryView r106 = this.f375659g;
        if (r106 == null) goto L26;
        r106.c(Integer.valueOf(com.larus.nova.R.string.larus_photo_loading_retry));
    L26:
        LoadingWithRetryView r107 = this.f375659g;
        if (r107 == null) goto L51;
        e1.x(r107);
        return;
    L51:
        return;
    L29:
        RecyclerView r108 = this.f375660h;
        if (r108 == null) goto L32;
        PagerLayoutManager r109 = new PagerLayoutManager(this);
        r109.f375936g = true;
        r109.setRecycleChildrenOnDetach(true);
        r109.f375937h = new m(this);
        r108.setLayoutManager(r109);
    L32:
        this.f375663k = new o(this);
        CommonVideoModel r110 = new CommonVideoModel(this.f375665m);
        this.f375662j = r110;
        r110.setSource(this.f375667o);
        CommonVideoModel r111 = this.f375662j;
        if (r111 == null) goto L35;
        r111.setLoadMoreContainer(this.f375666n);
    L35:
        CommonVideoModel r112 = this.f375662j;
        if (r112 == null) goto L38;
        r112.setUseNewApiGetVideoModel(this.f375675w);
    L38:
        VideoDetailAdapter r113 = new VideoDetailAdapter(new WeakReference(this.f375660h), this.f375662j, this.f375663k, this, O1());
        this.f375661i = r113;
        RecyclerView r114 = this.f375660h;
        if (r114 == null) goto L41;
        r114.setAdapter(r113);
    L41:
        VideoDetailAdapter r115 = this.f375661i;
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r115 = null;
    L44:
        r115.f375685g = new p(this);
        int r116 = this.f375672t;
        if (r116 <= 0) goto L53;
        RecyclerView r117 = this.f375660h;
        if (r117 == null) goto L54;
        r117.scrollToPosition(r116);
        return;
    L54:
        return;
    L53:
        return;
    L20:
        if (r105.isEmpty() == false) goto L22;
        goto L21
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(VideoActivity.class.getName()));
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
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
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
        getWindow().setNavigationBarColor(getResources().getColor(com.larus.nova.R.color.larus_static_black));
        getWindow().setStatusBarColor(getResources().getColor(com.larus.nova.R.color.larus_static_black));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (IVideoController.PlayType.PLAY != O1().d()) goto L5;
        boolean r100 = true;
    L6:
        this.f375664l = r100;
        O1().b();
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        String r103 = this.f375669q;
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r102.put("bot_id", r103);
        String r105 = this.f375670r;
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r105);
        String r106 = this.f375671s;
        if (r106 == null) goto L16;
        r104 = r106;
    L16:
        r102.put("conversation_id", r104);
        r102.put("duration", System.currentTimeMillis() - this.f375668p);
        r102.put("cnt", this.f375674v.size());
        r102.put("enter_method", this.f375673u);
        ArrayList<MediaEntity> r107 = this.f375665m;
        if (r107 == null) goto L21;
        MediaEntity r108 = (MediaEntity) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L21;
        String r109 = r108.getItem_id();
    L22:
        r102.put("video_id", r109);
        Unit r110 = Unit.INSTANCE;
        r101.reportEvent("leave_video_layer", r102);
        return;
    L21:
        r109 = null;
        goto L22
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f375664l == false) goto L6;
        O1().play();
        this.f375664l = false;
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View N1(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void P1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        String r103 = this.f375669q;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("bot_id", r103);
        String r105 = this.f375670r;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r105);
        String r106 = this.f375671s;
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        r102.put("conversation_id", r104);
        r102.put("to_status", r100);
        Unit r107 = Unit.INSTANCE;
        r101.reportEvent("click_video_player", r102);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [l2a.f] */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        N1(getWindow()).setBackgroundColor(getResources().getColor(R.color.transparent));
        setRootView(N1(getWindow()));
        int r101 = d.f375378a;
        d.a(this, new l2a.c(), new l2a.d(), null, new l2a.f(this), 8);
        u.f(this, false);
        Lazy r102 = q3.f365794a;
        z3 r103 = q3.a();
        String r104 = null;
        if (r103 == null) goto L13;
        r103.n(null);
    L13:
        Intent r105 = getIntent();
        if (r105 == null) goto L88;
        Bundle r106 = r105.getExtras();
        if (r106 == null) goto L18;
        String r107 = r106.getString("media_error_msg");
    L19:
        if (r107 != null) goto L21;
    L24:
        boolean r108 = true;
    L25:
        String r109 = "";
        if (r108 == true) goto L34;
        s r110 = s.f544207a;
        Bundle r111 = r105.getExtras();
        if (r111 == null) goto L33;
        String r112 = r111.getString("media_error_msg");
        if (r112 == null) goto L33;
        r109 = r112;
    L33:
        r110.getClass();
        s.c(this, r109);
    L99:
        boolean r113 = false;
    L101:
        if (r113 == true) goto L103;
        finish();
        return;
    L103:
        setContentView(com.larus.nova.R.layout.larus_activity_video);
        this.f375659g = (LoadingWithRetryView) findViewById(com.larus.nova.R.id.status_view);
        this.f375660h = (RecyclerView) findViewById(com.larus.nova.R.id.recycler_view);
        ImageView r114 = (ImageView) findViewById(com.larus.nova.R.id.back_btn);
        if (r114 == null) goto L106;
        r114.setOnClickListener(new i(this));
    L106:
        R1();
        RecyclerView r115 = this.f375660h;
        if (r115 == null) goto L109;
        r115.setKeepScreenOn(true);
    L109:
        TtsClientDelegate.f289868b.cancel("VideoActivity onCreate", false);
        this.f375668p = System.currentTimeMillis();
        return;
    L34:
        Bundle r116 = r105.getExtras();
        if (r116 == null) goto L37;
        Serializable r117 = r116.getSerializable("_media_arg_key");
    L38:
        if (r117 != null) goto L40;
        boolean r118 = true;
    L41:
        if (r118 == false) goto L88;
        Bundle r119 = r105.getExtras();
        if (r119 == null) goto L45;
        Serializable r120 = r119.getSerializable("_media_arg_key");
    L46:
        this.f375665m = (ArrayList) r120;
        Bundle r121 = r105.getExtras();
        if (r121 == null) goto L49;
        Serializable r122 = r121.getSerializable("_media_container_key");
    L51:
        if ((r122 instanceof MediaEntityContainer) == false) goto L53;
        MediaEntityContainer r123 = (MediaEntityContainer) r122;
    L54:
        this.f375666n = r123;
        Bundle r124 = r105.getExtras();
        if (r124 == null) goto L57;
        Integer r125 = Integer.valueOf(r124.getInt("_media_video_source_key"));
    L58:
        this.f375667o = r125;
        Bundle r126 = r105.getExtras();
        if (r126 == null) goto L61;
        String r127 = r126.getString("key_bot_id");
    L62:
        this.f375669q = r127;
        Bundle r128 = r105.getExtras();
        if (r128 == null) goto L65;
        String r129 = r128.getString("key_message_id");
    L66:
        this.f375670r = r129;
        Bundle r130 = r105.getExtras();
        if (r130 == null) goto L69;
        r104 = r130.getString("key_conversation_id");
    L69:
        this.f375671s = r104;
        Bundle r131 = r105.getExtras();
        if (r131 == null) goto L72;
        int r132 = r131.getInt("key_video_index");
    L73:
        this.f375672t = r132;
        Bundle r133 = r105.getExtras();
        if (r133 == null) goto L79;
        String r134 = r133.getString("key_enter_method");
        if (r134 == null) goto L79;
        r109 = r134;
    L79:
        this.f375673u = r109;
        Bundle r135 = r105.getExtras();
        if (r135 == null) goto L82;
        boolean r136 = r135.getBoolean("key_api_post_video_model");
    L83:
        this.f375675w = r136;
        Intent r137 = getIntent();
        if (r137 == null) goto L86;
        boolean r138 = r137.getBooleanExtra("key_use_share_anim", false);
    L87:
        this.f375677y = r138;
        goto L88
    L86:
        r138 = false;
        goto L87
    L82:
        r136 = false;
        goto L83
    L72:
        r132 = 0;
        goto L73
    L65:
        r129 = null;
        goto L66
    L61:
        r127 = null;
        goto L62
    L57:
        r125 = null;
        goto L58
    L53:
        r123 = null;
        goto L54
    L49:
        r122 = null;
        goto L51
    L45:
        r120 = null;
        goto L46
    L40:
        r118 = r117 instanceof ArrayList;
        goto L41
    L37:
        r117 = null;
        goto L38
    L21:
        if (r107.length() == 0) goto L24;
        r108 = false;
        goto L25
    L18:
        r107 = null;
    L88:
        ArrayList<MediaEntity> r139 = this.f375665m;
        if (r139 != null) goto L91;
    L94:
        boolean r140 = true;
    L95:
        if (r140 == true) goto L99;
        if (this.f375666n == null) goto L99;
        r113 = true;
        goto L101
    L91:
        if (r139.isEmpty() == true) goto L94;
        r140 = false;
        goto L95
    }

    public final void Q1(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "status");
        if (r100 != r101) goto L5;
        return;
    L5:
        CommonVideoModel r103 = this.f375662j;
        if (r103 == null) goto L10;
        ArrayList<MediaEntity> r104 = r103.getItems();
        if (r104 == null) goto L10;
        int r105 = r104.size();
    L11:
        String r106 = "";
        if (r105 <= r101) goto L23;
        Set<String> r107 = this.f375674v;
        CommonVideoModel r108 = this.f375662j;
        if (r108 == null) goto L21;
        ArrayList<MediaEntity> r109 = r108.getItems();
        if (r109 == null) goto L21;
        MediaEntity r110 = (MediaEntity) ListProtector.get(r109, r101);
        if (r110 == null) goto L21;
        String r111 = r110.getItem_id();
        if (r111 == null) goto L21;
    L22:
        r107.add(r111);
    L21:
        r111 = "";
    L23:
        com.larus.platform.service.o r112 = com.larus.platform.service.o.f365780a;
        JSONObject r113 = new JSONObject();
        String r114 = this.f375669q;
        if (r114 != null) goto L26;
        r114 = "";
    L26:
        r113.put("bot_id", r114);
        String r115 = this.f375670r;
        if (r115 != null) goto L29;
        r115 = "";
    L29:
        r113.put(MusicAppletPage.KEY_MESSAGE_ID, r115);
        String r116 = this.f375671s;
        if (r116 == null) goto L33;
        r106 = r116;
    L33:
        r113.put("conversation_id", r106);
        r113.put("status", r102);
        Unit r117 = Unit.INSTANCE;
        r112.reportEvent("swipe_video", r113);
        return;
    L10:
        r105 = 0;
        goto L11
    }
}
