package com.larus.community.impl.detail.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailVideoLayoutBinding;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001H\u0018\u0000 a2\u00020\u0001:\u0001aB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u00103\u001a\u00020\n2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0018H\u0002J\u000e\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u001eJ\f\u00109\u001a\u00020\u001c*\u00020\u001cH\u0002J\u001a\u0010:\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010<\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\nH\u0002J\u000e\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0018J6\u0010D\u001a\u00020\n2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0012\u0010E\u001a\u00020\u00182\b\u00104\u001a\u0004\u0018\u00010FH\u0016J\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020\nJ\u0006\u0010N\u001a\u00020\nJ\u0006\u0010O\u001a\u00020\nJ\u0006\u0010P\u001a\u00020\nJ\u0010\u0010L\u001a\u00020\n2\b\b\u0002\u0010Q\u001a\u00020\u0018J\b\u0010R\u001a\u00020\nH\u0014J\b\u0010S\u001a\u00020\nH\u0014J\u0016\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020\u0018J\u001f\u0010W\u001a\u00020\n2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\n0Y¢\u0006\u0002\b[J\b\u0010\\\u001a\u00020\nH\u0002J\u0006\u0010]\u001a\u00020\u0018J\n\u0010^\u001a\u0004\u0018\u00010\u001aH\u0002J\n\u0010_\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010`\u001a\u00020\nH\u0002R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R\u000e\u0010>\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00102\u001a\u0004\bI\u0010J¨\u0006b"}, d2 = {"Lcom/larus/community/impl/detail/video/CreationDetailVideoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onImageLongPressListener", "Lkotlin/Function0;", "", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "onImageDoubleTapListener", "getOnImageDoubleTapListener", "setOnImageDoubleTapListener", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailVideoLayoutBinding;", "videoEngineLeakFixEnabled", "", "videoPlayerEngine", "Lcom/larus/platform/api/IVideoController;", "currentVideoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "currentUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "trackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "reportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "playSessionActive", "segmentStartTs", "", "accumulatedDuration", "playCompleteCount", "", "hasReportedThisSession", "savedPlaybackTimeMs", "wasPlayingBeforeDetach", "lastKnownPlaybackTimeMs", "lastKnownPlaying", "videoFocusFixEnabled", "getVideoFocusFixEnabled", "()Z", "videoFocusFixEnabled$delegate", "Lkotlin/Lazy;", "logPlayback", "event", "", "debugOnly", "bindVideoData", "userCreation", "withVideoModelCoverSize", "setVideoReportParams", "helper", "reportAiVideoPlay", "reportPlayTimeIfNeeded", "draging", "latestDragSeekTime", "maxRatio", "", "adjustContainerSize", "hasExtraList", "bindAction", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "gestureDetector", "com/larus/community/impl/detail/video/CreationDetailVideoView$gestureDetector$2$1", "getGestureDetector", "()Lcom/larus/community/impl/detail/video/CreationDetailVideoView$gestureDetector$2$1;", "gestureDetector$delegate", "onPause", "onResume", "onResumeAfterPause", LiveCommonConstants.REASON_ON_DEDTROY, "releaseVideoPlayerForReuse", "byUser", "onAttachedToWindow", "onDetachedFromWindow", "updateProgress", "percent", "smooth", "configProgressView", "config", "Lkotlin/Function1;", "Lcom/larus/common_ui/video/progress/PlayerProgressView;", "Lkotlin/ExtensionFunctionType;", "initSeekbar", "isValid", "createVideoPlayerEngine", "getOrCreateVideoPlayerEngine", "releaseVideoPlayer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailVideoView extends ConstraintLayout {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f329498y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f329499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f329500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f329501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusCommunityCreationDetailVideoLayoutBinding f329502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f329503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IVideoController f329504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public nr9.g f329505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UserCreation f329506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zp9.g f329507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p29.b f329508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f329509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f329510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f329511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f329512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f329513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f329514p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f329515q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f329516r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f329517s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f329518t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f329519u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f329520v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f329521w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f329522x;

    public static final class a {
    }

    public static final class b extends GestureDetector {
        public b(Context r100, c r101) {
            super(r100, r101);
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailVideoView f329523a;

        public c(CreationDetailVideoView r100) {
            this.f329523a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            Function0<Unit> r101 = this.f329523a.getOnImageDoubleTapListener();
            if (r101 == null) goto L7;
            r101.invoke();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            super.onLongPress(r100);
            Function0<Unit> r101 = this.f329523a.getOnImageLongPressListener();
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            CreationDetailVideoView r101 = this.f329523a;
            int r102 = CreationDetailVideoView.f329498y;
            r101.b6();
            this.f329523a.f329502d.f329077d.x();
            return super.onSingleTapConfirmed(r100);
        }
    }

    static {
    }

    public static IVideoController U5() {
        IVideoController r100 = q3.b("ugc_video", null, 6);
        if (r100 == null) goto L6;
        com.larus.video.impl.sdk.o r101 = (com.larus.video.impl.sdk.o) r100;
        r101.setSubTag("immersive_preview");
        r101.I(true);
        r101.y(z2.f365865a.j1(), "CreationDetailVideoView");
        return r100;
    L6:
        return null;
    }

    private final b getGestureDetector() {
        return (b) this.f329522x.getValue();
    }

    private final IVideoController getOrCreateVideoPlayerEngine() {
        IVideoController r100 = this.f329504f;
        if (r100 != null) goto L5;
    L10:
        IVideoController r101 = U5();
        this.f329504f = r101;
        return r101;
    L5:
        if (r100.isReleased() == false) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        return r100;
    }

    private final boolean getVideoFocusFixEnabled() {
        return ((Boolean) this.f329518t.getValue()).booleanValue();
    }

    public final void Z5() {
        IVideoController r100 = this.f329504f;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f329504f = null;
        this.f329502d.f329077d.D();     // Catch: Throwable -> L11
        if (r100.isReleased() == true) goto L18;
        r100.release();
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (r100.isReleased() == true) goto L15;
        r100.release();
    L15:
        throw th;
    }

    public final void b6() {
        if (this.f329509k == true) goto L5;
        return;
    L5:
        if (this.f329513o == true) goto L70;
        long r100 = this.f329511m + (SystemClock.elapsedRealtime() - this.f329510l);
        this.f329511m = r100;
        UserCreation r101 = this.f329506h;
        if (r101 != null) goto L10;
        return;
    L10:
        nr9.g r102 = this.f329505g;
        zp9.g r103 = this.f329507i;
        p29.b r104 = this.f329508j;
        if (r104 == null) goto L66;
        if (r102 == null) goto L14;
        String r105 = r102.f520257a;
    L15:
        if (r103 == null) goto L18;
        String r106 = r103.f573249c;
        if (r106 == null) goto L18;
    L22:
        Boolean r110 = Boolean.TRUE;
        if (r103 == null) goto L25;
        String r111 = r103.f573254h;
    L26:
        Long r107 = Long.valueOf(r100);
        if (this.f329512n <= 0) goto L29;
        boolean r108 = true;
    L30:
        Boolean r112 = Boolean.valueOf(r108);
        if (r103 == null) goto L33;
        String r113 = r103.f573247a;
    L34:
        UserCreationContent r109 = r101.f364991e;
        if (r109 == null) goto L39;
        VideoContentFromChat r114 = r109.f365011f;
        if (r114 == null) goto L39;
        String r115 = r114.f365057a;
    L40:
        if (r102 == null) goto L42;
        String r116 = r102.f520258b;
    L43:
        Boolean r117 = Boolean.valueOf(a4.a(r116));
        Boolean r118 = Boolean.valueOf(a4.b(AppHost.f326268a.getApplication(), Boolean.valueOf(this.f329502d.f329077d.f327998s)));
        UserCreationTrackParams r119 = r101.f365000n;
        if (r119 == null) goto L46;
        String r120 = r119.f365043d;
    L47:
        if (r119 == null) goto L49;
        String r210 = r119.f365044e;
    L50:
        if (r103 == null) goto L52;
        String r211 = r103.f573255i;
    L53:
        if (r103 == null) goto L58;
        String r121 = r103.f573256j;
        if (r121 == null) goto L58;
        String r122 = r121;
    L61:
        String r212 = zp9.d.b(r101);
        String r213 = zp9.d.c(r101);
        String r214 = zp9.d.d(r101);
        String r123 = r101.f364987a;
        String r124 = r101.f364995i;
        UserCreationTrackParams r125 = r101.f365000n;
        if (r125 == null) goto L64;
        String r215 = r125.f365040a;
    L65:
        String r126 = r115;
        boolean r127 = true;
        p29.b.b(r104, r105, r106, r110, r111, r107, r112, r113, r126, r117, r118, r120, r210, r211, r122, r212, r213, r214, r123, r124, r215);
    L67:
        this.f329513o = r127;
        this.f329509k = false;
        return;
    L64:
        r215 = null;
    L58:
        if (r103 == null) goto L60;
        r122 = r103.f573248b;
        goto L61
    L60:
        r122 = null;
        goto L61
    L52:
        r211 = null;
        goto L53
    L49:
        r210 = null;
        goto L50
    L46:
        r120 = null;
        goto L47
    L42:
        r116 = null;
    L39:
        r115 = null;
        goto L40
    L33:
        r113 = null;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r111 = null;
    L18:
        UserCreationTrackParams r128 = r101.f365000n;
        if (r128 == null) goto L21;
        r106 = r128.f365046g;
        goto L22
    L21:
        r106 = null;
        goto L22
    L14:
        r105 = null;
        goto L15
    L66:
        r127 = true;
        goto L67
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        V5("detach", true);
        if (getVideoFocusFixEnabled() == true) goto L7;
        super.onDetachedFromWindow();
        return;
    L7:
        if (this.f329505g == null) goto L23;
        int r100 = (int) this.f329502d.f329077d.getCurrentPlaybackTime();
        boolean r101 = this.f329502d.f329077d.r();
        if (r100 <= 0) goto L11;
        int r102 = r100;
    L12:
        if (r101 == false) goto L14;
    L17:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L22;
        if (r102 <= 0) goto L22;
        this.f329515q = true;
        this.f329514p = r102;
        FLogger.f375446a.i("CreationDetailVideoView", "[onDetachedFromWindow] save state, playing=true, pos=" + r102 + "ms (livePos=" + r100 + ", cachedPos=" + this.f329516r + ", livePlaying=" + r101 + ", cachedPlaying=" + this.f329517s + ')');
    L22:
        FLogger.f375446a.i("CreationDetailVideoView", "[onDetachedFromWindow] no save, playing=" + r103 + ", pos=" + r102 + "ms");
        goto L23
    L14:
        if (this.f329517s == true) goto L17;
        r103 = false;
        goto L19
    L11:
        r102 = this.f329516r;
    L23:
        super.onDetachedFromWindow();
    }

    public final void onPause() {
        V5("page_pause", false);
        b6();
        if (getVideoFocusFixEnabled() == false) goto L5;
        this.f329517s = false;
    L5:
        VideoPlayView.z(this.f329502d.f329077d, 0, 3);
    }

    public final void onResume() {
        V5("page_resume", false);
        if (getVideoFocusFixEnabled() == true) goto L6;
        this.f329502d.f329077d.M();
        return;
    L6:
        int r100 = this.f329514p;
        if (this.f329515q == false) goto L10;
        if (r100 <= 0) goto L10;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L22;
        FLogger.f375446a.i("CreationDetailVideoView", "[onResume] resume from saved position " + r100 + "ms");
        IVideoController r102 = this.f329504f;
        if (r102 == null) goto L16;
        r102.setStartTime(r100);
    L16:
        nr9.g r103 = this.f329505g;
        if (r103 == null) goto L19;
        VideoPlayView.e(this.f329502d.f329077d, this.f329504f, r103.f520258b, r103.f520264h, null, null, null, 56);
    L19:
        this.f329515q = false;
        this.f329514p = 0;
        this.f329502d.f329077d.M();
        return;
    L22:
        if (this.f329502d.f329077d.r() == false) goto L25;
        FLogger.f375446a.i("CreationDetailVideoView", "[onResume] already playing, skip start()");
        return;
    L25:
        this.f329502d.f329077d.M();
        return;
    L10:
        r101 = false;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        V5(LynxViewpagerItem.BIND_ON_ATTACH, true);
        if (getVideoFocusFixEnabled() == true) goto L6;
        return;
    L6:
        if (this.f329515q == true) goto L8;
        return;
    L8:
        if (this.f329505g == null) goto L12;
        FLogger.f375446a.i("CreationDetailVideoView", "[onAttachedToWindow] trigger resume, saved=" + this.f329514p + "ms");
        onResume();
        return;
    }

    public final Function0<Unit> getOnImageDoubleTapListener() {
        return this.f329501c;
    }

    public final Function0<Unit> getOnImageLongPressListener() {
        return this.f329499a;
    }

    public final Function0<Unit> getOnImageScaleListener() {
        return this.f329500b;
    }

    public CreationDetailVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void T5(UserCreation r110) {
        UserCreation r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "userCreation");
        AuthorInfo r101 = r100.f364993g;
        Bitmap r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f364897b;
    L7:
        if (Intrinsics.areEqual(r103, AccountService.f365697a.getUserId()) == true) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L17;
        UserCreation r105 = CreationNoWatermarkManager.f373832a.f0(r100, false);
        if (r105 == null) goto L17;
        r100 = r105;
    L17:
        this.f329506h = r100;
        switch(r100.f364988b) {
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            default: goto L39;
        };
    L20:
        UserCreationContent r106 = r100.f364991e;
        if (r106 == null) goto L23;
        VideoUserContent r107 = r106.f365010e;
    L24:
        if (r104 == false) goto L27;
        if (r107 == null) goto L30;
        nr9.g r108 = os8.c.c(r107);
    L29:
        nr9.g r109 = r108;
    L31:
        if (r109 == null) goto L39;
        CreationNoWatermarkManager r111 = CreationNoWatermarkManager.f373832a;
        String r112 = r109.f520258b;
        r111.getClass();
        CreationNoWatermarkManager.h r113 = CreationNoWatermarkManager.J(r112);
        if (r113 == null) goto L40;
        nr9.f r114 = r109.f520263g;
        if (r114 == null) goto L40;
        r109 = nr9.g.a(r109, null, null, null, null, null, null, nr9.f.a(r114, null, null, Integer.valueOf(r113.f373872b), Integer.valueOf(r113.f373871a), null, 39), 959);
    L40:
        this.f329505g = r109;
        V5("bind", false);
        Function1 r115 = new n(this);
        Intrinsics.checkNotNullParameter(r115, "config");
        r115.invoke(this.f329502d.f329076c);
        nr9.g r116 = this.f329505g;
        if (r116 != null) goto L43;
        return;
    L43:
        if (this.f329503e == false) goto L45;
        IVideoController r117 = getOrCreateVideoPlayerEngine();
    L46:
        VideoPlayView.e(this.f329502d.f329077d, r117, r116.f520258b, r116.f520264h, null, null, null, 56);
        VideoPlayView r118 = this.f329502d.f329077d;
        nr9.f r119 = r116.f520263g;
        if (r119 == null) goto L49;
        String r120 = r119.f520251a;
    L50:
        if (r119 == null) goto L52;
        String r121 = r119.f520252b;
    L53:
        if (r119 == null) goto L55;
        String r122 = r119.f520253c;
    L56:
        if (r119 == null) goto L58;
        Integer r123 = r119.f520254d;
    L59:
        if (r119 == null) goto L61;
        Integer r124 = r119.f520255e;
    L62:
        if (r119 == null) goto L64;
        r102 = r119.f520256f;
    L64:
        VideoPlayView.p(r118, r120, r121, r122, r123, r124, r102, null, null, 192);
        final VideoPlayView r125 = this.f329502d.f329077d;
        r125.w(new l(this, r125));
        r125.f327977d = new m(this);
        return;
    L61:
        r124 = null;
        goto L62
    L58:
        r123 = null;
        goto L59
    L55:
        r122 = null;
        goto L56
    L52:
        r121 = null;
        goto L53
    L49:
        r120 = null;
        goto L50
    L45:
        r117 = this.f329504f;
    L30:
        r109 = null;
        goto L31
    L27:
        if (r107 == null) goto L30;
        r108 = os8.c.d(r107);
        goto L29
    L23:
        r107 = null;
    L39:
        r109 = null;
        goto L40
    L9:
        if (CreationNoWatermarkManager.f373832a.D() == false) goto L11;
        r104 = true;
        goto L12
    L5:
        r103 = null;
        goto L7
    }

    public final void Y5(boolean r100) {
        V5("pause byUser=false", false);
        b6();
        if (getVideoFocusFixEnabled() == false) goto L5;
        this.f329517s = false;
    L5:
        VideoPlayView.z(this.f329502d.f329077d, 0, 2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        r100.getAction();
        r100.getActionMasked();
        boolean r101 = super.dispatchTouchEvent(r100);
        getGestureDetector().onTouchEvent(r100);
        return r101;
    }

    public final void setOnImageDoubleTapListener(Function0<Unit> r100) {
        this.f329501c = r100;
    }

    public final void setOnImageLongPressListener(Function0<Unit> r100) {
        this.f329499a = r100;
    }

    public final void setOnImageScaleListener(Function0<Unit> r100) {
        this.f329500b = r100;
    }

    public CreationDetailVideoView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_creation_detail_video_layout, this);
        int r102 = R.id.container;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.container);
        if (r103 == null) goto L15;
        r102 = R.id.player_progress;
        PlayerProgressView r104 = (PlayerProgressView) ViewBindings.findChildViewById(this, R.id.player_progress);
        if (r104 == null) goto L15;
        r102 = R.id.video_view;
        VideoPlayView r105 = (VideoPlayView) ViewBindings.findChildViewById(this, R.id.video_view);
        if (r105 == null) goto L15;
        this.f329502d = new LarusCommunityCreationDetailVideoLayoutBinding(this, r103, r104, r105);
        boolean r106 = z2.f365865a.creationDetailVideoEngineLeakFix();
        this.f329503e = r106;
        if (r106 == false) goto L11;
        IVideoController r107 = null;
    L12:
        this.f329504f = r107;
        this.f329518t = LazyKt.lazy(new j());
        r105.setParentSlideDirection(1);
        r105.setBackgroundColor(ContextCompat.getColor(r100, R.color.larus_base_1));
        r105.setEnabled(false);
        r105.setBanInnerDismiss(true);
        r104.setSupportTouch(false);
        setClickable(true);
        this.f329521w = 0.74f;
        this.f329522x = LazyKt.lazy(new k(this, r100));
        return;
    L11:
        r107 = U5();
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public static String R5(String r100, CreationDetailVideoView r101) {
        StringBuilder r102 = new StringBuilder("[playback] ");
        r102.append(r100);
        r102.append(" owner=");
        r102.append(r101.hashCode());
        r102.append(" view=");
        r102.append(r101.f329502d.f329077d.hashCode());
        r102.append(" controller=");
        IVideoController r103 = r101.f329504f;
        String r104 = null;
        if (r103 == null) goto L5;
        Integer r105 = Integer.valueOf(r103.hashCode());
    L6:
        r102.append(r105);
        r102.append(" creation=");
        UserCreation r106 = r101.f329506h;
        if (r106 == null) goto L9;
        String r107 = r106.f364987a;
    L10:
        r102.append(r107);
        r102.append(" vid=");
        nr9.g r108 = r101.f329505g;
        if (r108 == null) goto L13;
        r104 = r108.f520257a;
    L13:
        r102.append(r104);
        r102.append(" attached=");
        r102.append(r101.isAttachedToWindow());
        r102.append(" playing=");
        r102.append(r101.f329502d.f329077d.r());
        r102.append(" focusFix=");
        r102.append(r101.getVideoFocusFixEnabled());
        r102.append(" engineFix=");
        r102.append(r101.f329503e);
        return r102.toString();
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public final void V5(final String r100, boolean r101) {
        Function0<String> r102 = new i(r100, this);
        if (r101 == false) goto L5;
        FLogger.f375446a.g("CreationDetailVideoView", r102);
        return;
    L5:
        FLogger.f375446a.i("CreationDetailVideoView", r102);
    }

    public static Unit S5(CreationDetailVideoView r100, VideoPlayView r101, int r110) {
        if (r100.getVideoFocusFixEnabled() == false) goto L18;
        int r102 = (int) r101.getCurrentPlaybackTime();
        if (r102 <= 0) goto L7;
        r100.f329516r = r102;
    L16:
        r100.f329517s = r101.r();
        goto L18
    L7:
        int r103 = (int) r101.getDuration();
        if (r103 <= 0) goto L16;
        if (r110 >= 0) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L16;
        r100.f329516r = (r103 * r110) / 100;
        goto L16
    L11:
        if (r110 >= 101) goto L13;
        r104 = true;
    L18:
        if (r100.f329519u == false) goto L21;
        return Unit.INSTANCE;
    L21:
        if (r100.f329520v > (System.currentTimeMillis() - ((long) 500))) goto L26;
        r100.f329502d.f329076c.J1(r110, false);
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    }
}
