package com.bytedance.ies.xelement.video.base;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.byted.cast.common.CastMonitor;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.ies.xelement.v;
import com.bytedance.ies.xelement.video.base.view.RemoteImageView;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nic.l;
import nic.p;
import oic.f;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0088\u0001\b\u0017\u0018\u0000 \u008f\u00012\u00020\u00012\u00020\u0002:\u0002\u0090\u0001B\u0013\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0017H\u0002J\u0016\u0010\u001d\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016Jc\u0010%\u001a\u00020\u00032Y\u0010$\u001aU\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fH\u0016J\u0012\u0010'\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u00020,H\u0016J\u0010\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u00020\bH\u0016J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\bH\u0016J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\fH\u0016J\u0010\u0010A\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\fH\u0016J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\bH\u0016J\b\u0010D\u001a\u00020\u0003H\u0016J\b\u0010E\u001a\u00020\u0003H\u0016J\b\u0010F\u001a\u00020\u0003H\u0016J\b\u0010G\u001a\u00020\u0003H\u0016J\u0018\u0010H\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0016J\u0018\u0010K\u001a\u00020\u00032\u0006\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\bH\u0016J\b\u0010L\u001a\u00020,H\u0016J\u0012\u0010O\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010R\u001a\u00020\u00032\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010U\u001a\u00020\u00032\u0006\u0010T\u001a\u00020SH\u0007J\u0010\u0010V\u001a\u00020\u00032\u0006\u0010T\u001a\u00020SH\u0007J\b\u0010W\u001a\u00020\u0003H\u0007J\b\u0010X\u001a\u00020\u0003H\u0016R\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010`R\u0016\u0010e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010`R\u0016\u0010f\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010cR\u0016\u0010i\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010`R\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010`R\u0016\u0010k\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010ZR\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010ZR\u0016\u0010m\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010`R\u0016\u0010n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010`R\u0016\u0010o\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010`R\u0016\u0010p\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010`R\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010`R\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010cR\u0016\u0010|\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010cRi\u0010}\u001aU\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u007f\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R!\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010ZR\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010ZR\u0018\u0010\u0085\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010`R\u0018\u0010\u0086\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010`R\u0018\u0010\u0087\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010`R\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u0091\u0001"}, d2 = {"Lcom/bytedance/ies/xelement/video/base/DeclarativeVideoPlayBoxViewBaseImpl;", "Lcom/bytedance/ies/xelement/DeclarativeVideoPlayBoxViewDelegate;", "Landroidx/lifecycle/LifecycleObserver;", "", "initDetachListener", "initLifecycle", "initVideoContainer", "initPoster", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "detect", "loadVideoResource", "", "src", "", "parseSrc", "renderOnceWithParams", "hidePoster", "Lkotlin/Function0;", "playCB", "legacyPlay", "adjustAudio", "newState", "", "data", "notifyStateChange", "Lf76/a;", "Lf76/c;", "loader", "setResourceLoader", "setSrc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "viewBox", "reporter", "setStateChangeReporter", "tag", "setVideoTag", "autoPlay", "setAutoPlay", "preload", "setPreload", "", "initTime", "setInitTime", "loop", "setLoop", "muted", "setMuted", "", ITTVideoEngineEventSource.KEY_VOLUME, "setVolume", "rate", "setRate", "singlePlayer", "setSinglePlayer", "autoLifecycle", "setAutoLifecycle", "enablePlayListener", "setEnablePlayListener", "poster", "setPoster", "objectFit", "setObjectFit", "deviceChangeAware", "setDeviceChangeAware", "onPropsUpdateOnce", "pause", "performZoom", "performZoomOut", "playReal", "position", "play", "seek", "getDuration", "", "borderRadius", "setBorderRadius", "Landroid/graphics/Canvas;", "canvas", "draw", "Landroidx/lifecycle/LifecycleOwner;", "source", "onHostResume", "onHostPause", "onHostDestroy", MapMonitorConst.EVENT_DESTROY, "mVideoUrl", "Ljava/lang/String;", "mVid", "Landroid/net/Uri;", "mUri", "Landroid/net/Uri;", "mAutoPlay", "Z", "mPreload", "mInitTime", "I", "mLoop", "mMuted", "mVolume", FaceService.girlLabel, "mRate", "mAutoLifecycle", "mEnablePlayListener", "mPoster", "mObjectFit", "mDeviceChangeAware", "mNeedReRender", "mNeedVideoReRender", "mShouldContinuePlay", "mPropUpdated", "Lcom/bytedance/ies/xelement/video/base/view/RemoteImageView;", "mPosterView", "Lcom/bytedance/ies/xelement/video/base/view/RemoteImageView;", "Landroid/widget/ImageView;", "mPlayIcon", "Landroid/widget/ImageView;", "Lcom/ss/android/videoshop/mediaview/SimpleMediaView;", "mVideoContainer", "Lcom/ss/android/videoshop/mediaview/SimpleMediaView;", "mTextureLayout", "mPageStatus", "mReporter", "Lkotlin/jvm/functions/Function3;", "mBorderRadius", "[F", "mResourceLoader", "Lf76/a;", "mLocalPath", "mVideoTag", "mVisible", "mEnableOffline", "mNewPlay", "com/bytedance/ies/xelement/video/base/DeclarativeVideoPlayBoxViewBaseImpl$c", "mPlayListener", "Lcom/bytedance/ies/xelement/video/base/DeclarativeVideoPlayBoxViewBaseImpl$c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-video-base_release"}, k = 1, mv = {1, 6, 0})
public class DeclarativeVideoPlayBoxViewBaseImpl extends DeclarativeVideoPlayBoxViewDelegate implements LifecycleObserver {
    public static final a Companion = null;
    private static final int PAGE_STATUS_DESTROYED = 3;
    private static final int PAGE_STATUS_INIT = 0;
    private static final int PAGE_STATUS_PAUSED = 2;
    private static final int PAGE_STATUS_RESUMED = 1;
    private static final int SAMPLE_FREQUENCY = 166;
    private static final String TAG = "DeclarativeVideoPlayBoxViewBaseImpl";
    public Map<Integer, View> _$_findViewCache;
    private boolean mAutoLifecycle;
    private boolean mAutoPlay;
    private float[] mBorderRadius;
    private boolean mDeviceChangeAware;
    private boolean mEnableOffline;
    private boolean mEnablePlayListener;
    private int mInitTime;
    private String mLocalPath;
    private boolean mLoop;
    private boolean mMuted;
    private boolean mNeedReRender;
    private boolean mNeedVideoReRender;
    private boolean mNewPlay;
    private String mObjectFit;
    private int mPageStatus;
    private ImageView mPlayIcon;
    private final c mPlayListener;
    private String mPoster;
    private RemoteImageView mPosterView;
    private boolean mPreload;
    private boolean mPropUpdated;
    private int mRate;
    private Function3<? super String, ? super Map<String, ? extends Object>, ? super DeclarativeVideoPlayBoxViewDelegate, Unit> mReporter;
    private f76.a<f76.c> mResourceLoader;
    private boolean mShouldContinuePlay;
    private int mTextureLayout;
    private Uri mUri;
    private String mVid;
    private final SimpleMediaView mVideoContainer;
    private String mVideoTag;
    private String mVideoUrl;
    private boolean mVisible;
    private float mVolume;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements nic.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeclarativeVideoPlayBoxViewBaseImpl f250391a;

        @Override // nic.a
        public final void b(SimpleMediaView r100) {
        }

        @Override // nic.a
        public final void c(SimpleMediaView r100) {
        }

        public b(DeclarativeVideoPlayBoxViewBaseImpl r100) {
            this.f250391a = r100;
        }

        @Override // nic.a
        public final void a(SimpleMediaView r100, boolean r101) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMVisible$p(this.f250391a) == r101) goto L9;
            DeclarativeVideoPlayBoxViewBaseImpl.access$setMVisible$p(this.f250391a, r101);
            if (r101 == false) goto L7;
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250391a, LynxVideoManagerLite.EVENT_ON_APPEAR, new HashMap());
            return;
        L7:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250391a, LynxVideoManagerLite.EVENT_ON_DISAPPEAR, new HashMap());
            return;
        }
    }

    public static final class c extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeclarativeVideoPlayBoxViewBaseImpl f250392a;

        public c(DeclarativeVideoPlayBoxViewBaseImpl r100) {
            this.f250392a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void B(p r100, tic.a r101) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onRenderStart due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl.access$hidePoster(this.f250392a);
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, new HashMap());
            p86.a.a("onRenderStart");
        }

        @Override // nic.l.a, nic.h
        public final void W(f r100, tic.a r101) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onVideoPlay due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, LynxVideoManagerLite.EVENT_ON_PLAY, new HashMap());
            p86.a.a("onVideoPlay");
        }

        @Override // nic.l.a, nic.h
        public final void b(f r100, tic.a r101) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L7;
            p86.a.a("abort notify onVideoCompleted due to playListener is disabled");
            return;
        L7:
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMLoop$p(this.f250392a) == true) goto L9;
        L11:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED, new HashMap());
            p86.a.a("onVideoCompleted");
            return;
        L9:
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMPageStatus$p(this.f250392a) != 1) goto L11;
            DeclarativeVideoPlayBoxViewBaseImpl.access$adjustAudio(this.f250392a);
            DeclarativeVideoPlayBoxViewBaseImpl.access$getMVideoContainer$p(this.f250392a).k();
            goto L11
        }

        @Override // nic.l.a, nic.h
        public final void s(f r100, tic.a r101) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onVideoPause due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, "onPause", new HashMap());
            p86.a.a("onVideoPause");
        }

        @Override // nic.l.a, nic.h
        public final void Q(f r100, tic.a r101, int r102) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onBufferingUpdate due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, LynxVideoManagerLite.EVENT_ON_BUFFER, new HashMap());
            p86.a.a("onBufferingUpdate");
        }

        @Override // nic.l.a, nic.h
        public final void v(f r100, tic.a r101, Error r102) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onError due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, LynxVideoManagerLite.EVENT_ON_ERROR, new HashMap());
            StringBuilder r103 = new StringBuilder("onError: ");
            String r104 = null;
            if (r102 == null) goto L9;
            Integer r105 = Integer.valueOf(r102.code);
        L10:
            r103.append(r105);
            r103.append(tb2.c.DEFAULT_TEXT);
            if (r102 == null) goto L13;
            r104 = r102.description;
        L13:
            r103.append(r104);
            p86.a.a(r103.toString());
            return;
        L9:
            r105 = null;
            goto L10
        }

        @Override // nic.l.a, nic.h
        public final void q(f r100, tic.a r101, int r102, int r103) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onProgressUpdate due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl r104 = this.f250392a;
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(r104, LynxVideoManagerLite.EVENT_ON_PROGRESS_CHANGE, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("progress", Integer.valueOf(DeclarativeVideoPlayBoxViewBaseImpl.access$getMVideoContainer$p(r104).getCurrentPosition()))}));
            p86.a.a("onProgressUpdate");
        }

        @Override // nic.l.a, nic.b
        public final void O(p r100, tic.a r101, boolean r102, int r103, boolean r104, boolean r105) {
            if (DeclarativeVideoPlayBoxViewBaseImpl.access$getMEnablePlayListener$p(this.f250392a) == true) goto L6;
            p86.a.a("abort notify onFullScreen due to playListener is disabled");
            return;
        L6:
            DeclarativeVideoPlayBoxViewBaseImpl.access$notifyStateChange(this.f250392a, LynxVideoManagerLite.EVENT_ON_ZOOM_CHANGE, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("fullscreen", Integer.valueOf(r102 ? 1 : 0))}));
            p86.a.a("onFullScreen");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(DeclarativeVideoPlayBoxViewBaseImpl r100, View r101) {
        m8368initPoster$lambda7$lambda6(r100, r101);
    }

    public static /* synthetic */ void b(DeclarativeVideoPlayBoxViewBaseImpl r100, View r101) {
        m8367initPoster$lambda5$lambda4(r100, r101);
    }

    public static /* synthetic */ void c(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        m8369seek$lambda19(r100);
    }

    private final void loadVideoResource() {
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public View _$_findCachedViewById(int r100) {
        Map<Integer, View> r101 = this._$_findViewCache;
        View r102 = r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L9;
        View r103 = findViewById(r100);
        if (r103 == null) goto L7;
        r101.put(Integer.valueOf(r100), r103);
        return r103;
    L7:
        return null;
    L9:
        return r102;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostDestroy() {
        this.mPageStatus = 3;
        destroy();
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void onPropsUpdateOnce() {
        this.mPropUpdated = true;
        this.mPageStatus = 1;
        if (this.mNeedReRender == false) goto L6;
        renderOnceWithParams();
        return;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setResourceLoader(f76.a<f76.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setSinglePlayer(boolean r100) {
    }

    private final void adjustAudio() {
        this.mVideoContainer.setMute(this.mMuted);
    }

    private final void hidePoster() {
        RemoteImageView r100 = this.mPosterView;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        ImageView r101 = this.mPlayIcon;
        if (r101 == null) goto L11;
        r101.setVisibility(8);
        return;
    }

    private final void initDetachListener() {
        this.mVideoContainer.setAttachListener(new b(this));
    }

    private final void initPoster() {
        RemoteImageView r100 = new RemoteImageView(getContext());
        addView(r100, -1, -1);
        r100.setOnClickListener(new com.bytedance.ies.xelement.video.base.a(this));
        r100.setVisibility(8);
        this.mPosterView = r100;
        ImageView r101 = new ImageView(getContext());
        addView(r101, -2, -2);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        ((RelativeLayout.LayoutParams) r102).addRule(13);
        r101.setOnClickListener(new com.bytedance.ies.xelement.video.base.b(this));
        r101.setVisibility(8);
        this.mPlayIcon = r101;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final void initVideoContainer() {
        String r100 = this.mObjectFit;
        boolean r101 = false;
        if (Intrinsics.areEqual(r100, LynxVideoManagerLite.CONTAIN) == false) goto L6;
        int r102 = 0;
    L9:
        this.mTextureLayout = r102;
        tic.a r103 = new tic.a();
        if (v.a(this.mLocalPath) == false) goto L13;
        r103.f546368f = this.mLocalPath;
    L18:
        String r104 = this.mVideoTag;
        if (r104 == null) goto L21;
        r103.f546373k = r104;
    L21:
        int r105 = this.mInitTime;
        r103.f546365c = r105;
        ejc.b.a r106 = new ejc.b.a();
        r106.f472912a = this.mTextureLayout;
        r106.f472919h = 14;
        if (r105 != 0) goto L24;
        r101 = true;
    L24:
        r106.f472914c = r101;
        r106.f472918g = 2;
        r103.f546377o = new ejc.b(r106);
        SimpleMediaView r107 = this.mVideoContainer;
        c r108 = this.mPlayListener;
        VideoContext r109 = r107.f455994e;
        if (r109 == null) goto L27;
        r109.D0(r108);
    L27:
        r107.setPlayUrlConstructor(new sic.a());
        r107.setPlayEntity(r103);
        r107.setAsyncRelease(true);
        return;
    L13:
        if (v.a(this.mVid) == false) goto L16;
        r103.f546363a = this.mVid;
        goto L18
    L16:
        if (v.a(this.mVideoUrl) == false) goto L18;
        r103.f546367e = this.mVideoUrl;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100, "cover") == false) goto L8;
        r102 = 2;
        goto L9
    L8:
        r102 = 1;
        goto L9
    }

    private final void renderOnceWithParams() {
        if (v.a(this.mVid) == false) goto L5;
    L10:
        boolean r100 = true;
    L12:
        if (this.mNeedVideoReRender == true) goto L14;
    L52:
        adjustAudio();
    L53:
        this.mNeedReRender = false;
        this.mNeedVideoReRender = false;
        return;
    L14:
        if (this.mPropUpdated == false) goto L52;
        if (r100 == false) goto L52;
        this.mVideoContainer.m();
        requestLayout();
        initVideoContainer();
        String r101 = this.mPoster;
        RemoteImageView r102 = this.mPosterView;
        if (r102 == null) goto L19;
        Object r103 = r102.getTag();
    L20:
        if (r103 == null) goto L22;
    L24:
        boolean r104 = false;
    L25:
        if (r104 == true) goto L28;
        r101 = null;
    L28:
        if (r101 == null) goto L50;
        RemoteImageView r105 = this.mPosterView;
        if (r105 == null) goto L46;
        r105.setVisibility(0);
        String r106 = this.mObjectFit;
        if (Intrinsics.areEqual(r106, LynxVideoManagerLite.CONTAIN) == false) goto L35;
        ImageView.ScaleType r107 = ImageView.ScaleType.FIT_CENTER;
    L38:
        r105.setScaleType(r107);
        String r108 = this.mPoster;
        Bitmap.Config r109 = Bitmap.Config.ARGB_8888;
        if (TextUtils.isEmpty(r108) == true) goto L45;
        ImageRequestBuilder r110 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r108));
        if (r109 == null) goto L44;
        ImageDecodeOptionsBuilder r111 = new ImageDecodeOptionsBuilder();
        r111.setBitmapConfig(r109);
        r110.setImageDecodeOptions(new ImageDecodeOptions(r111));
    L44:
        r105.setController(Fresco.newDraweeControllerBuilder().setOldController(r105.getController()).setImageRequest(r110.build()).build());
    L45:
        r105.setTag(this.mPoster);
        goto L46
    L35:
        if (Intrinsics.areEqual(r106, "cover") == false) goto L37;
        r107 = ImageView.ScaleType.CENTER_CROP;
        goto L38
    L37:
        r107 = ImageView.ScaleType.FIT_XY;
    L46:
        ImageView r112 = this.mPlayIcon;
        if (r112 == null) goto L50;
        r112.setVisibility(0);
    L50:
        if (this.mAutoPlay == false) goto L53;
        hidePoster();
        DeclarativeVideoPlayBoxViewDelegate.playReal$default(this, null, 1, null);
        goto L53
    L22:
        if (TextUtils.isEmpty(this.mPoster) == true) goto L24;
        r104 = true;
        goto L25
    L19:
        r103 = null;
        goto L20
    L5:
        if (v.a(this.mVideoUrl) == true) goto L10;
        if (v.a(this.mLocalPath) == true) goto L10;
        r100 = false;
        goto L12
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public int getDuration() {
        return this.mVideoContainer.getDuration();
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void pause() {
        if (this.mVideoContainer.h() == false) goto L6;
        this.mVideoContainer.j();
        return;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void performZoom() {
        if (this.mVideoContainer.f() == true) goto L10;
        LayerHostMediaLayout r100 = this.mVideoContainer.f455992c;
        if (r100 == null) goto L11;
        VideoContext r101 = r100.M;
        if (r101 == null) goto L12;
        r101.k0();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void performZoomOut() {
        if (this.mVideoContainer.f() == false) goto L6;
        this.mVideoContainer.c();
        return;
    }

    private final void initLifecycle() {
        Context r100 = getContext();
        LifecycleOwner r101 = null;
        if ((r100 instanceof ContextWrapper) == false) goto L5;
        ContextWrapper r102 = (ContextWrapper) r100;
    L6:
        if (r102 == null) goto L8;
        Context r103 = r102.getBaseContext();
    L10:
        if ((r103 instanceof LifecycleOwner) == false) goto L12;
        r101 = (LifecycleOwner) r103;
    L12:
        if (r101 == null) goto L15;
        r101.getLifecycle().addObserver(this);
        return;
    L15:
        return;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void destroy() {
        super.destroy();
        this.mVideoContainer.p(this.mPlayListener);
        this.mVideoContainer.m();
        Context r100 = getContext();
        LifecycleOwner r101 = null;
        if ((r100 instanceof ContextWrapper) == false) goto L5;
        ContextWrapper r102 = (ContextWrapper) r100;
    L6:
        if (r102 == null) goto L8;
        Context r103 = r102.getBaseContext();
    L10:
        if ((r103 instanceof LifecycleOwner) == false) goto L12;
        r101 = (LifecycleOwner) r103;
    L12:
        if (r101 == null) goto L17;
        Lifecycle r104 = r101.getLifecycle();
        if (r104 == null) goto L18;
        r104.removeObserver(this);
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public DeclarativeVideoPlayBoxViewBaseImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this._$_findViewCache = new LinkedHashMap();
        super(r100, null, 0, 6, null);
        this.mVideoUrl = "";
        this.mVid = "";
        this.mVolume = -1.0f;
        this.mRate = 166;
        this.mEnablePlayListener = true;
        this.mPoster = "";
        this.mObjectFit = LynxVideoManagerLite.CONTAIN;
        SimpleMediaView r101 = new SimpleMediaView(r100);
        this.mVideoContainer = r101;
        this.mLocalPath = "";
        this.mVisible = true;
        addView(r101, -1, -1);
        initPoster();
        initLifecycle();
        initDetachListener();
        this.mPlayListener = new c(this);
    }

    public static final /* synthetic */ void access$adjustAudio(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        r100.adjustAudio();
    }

    public static final /* synthetic */ boolean access$getMEnablePlayListener$p(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        return r100.mEnablePlayListener;
    }

    public static final /* synthetic */ boolean access$getMLoop$p(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        return r100.mLoop;
    }

    public static final /* synthetic */ int access$getMPageStatus$p(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        return r100.mPageStatus;
    }

    public static final /* synthetic */ SimpleMediaView access$getMVideoContainer$p(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        return r100.mVideoContainer;
    }

    public static final /* synthetic */ String access$getMVideoUrl$p(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        return r100.mVideoUrl;
    }

    public static final /* synthetic */ boolean access$getMVisible$p(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        return r100.mVisible;
    }

    public static final /* synthetic */ void access$hidePoster(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        r100.hidePoster();
    }

    public static final /* synthetic */ void access$initVideoContainer(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        r100.initVideoContainer();
    }

    public static final /* synthetic */ void access$renderOnceWithParams(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        r100.renderOnceWithParams();
    }

    private final boolean detect(boolean r100) {
        if (r100 == false) goto L4;
        this.mNeedReRender = true;
    L4:
        return r100;
    }

    private final void legacyPlay(Function0<Unit> r100) {
        if (this.mPageStatus == 1) goto L5;
        return;
    L5:
        if (this.mVideoContainer.h() == true) goto L13;
        adjustAudio();
        this.mVideoContainer.k();
        if (r100 == null) goto L12;
        r100.invoke();
        return;
    L12:
        return;
    }

    private final Object parseSrc(String r100) {
        Object r101 = null;
        if (r100 == null) goto L18;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        if (StringsKt.startsWith$default(r100, "video://", false, 2, null) == false) goto L17;
        return UriProtector.parse(r100);
    L17:
        return null;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Object r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r104) == true) goto L14;
        r101 = r104;
    L14:
        return (Void) r101;
    L18:
        return null;
    }

    /* JADX INFO: renamed from: seek$lambda-19, reason: not valid java name */
    private static final void m8369seek$lambda19(DeclarativeVideoPlayBoxViewBaseImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.mVideoContainer.j();
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        if (r100 == null) goto L7;
        float[] r101 = this.mBorderRadius;
        if (r101 == null) goto L7;
        r100.saveLayer(new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight()), null, 31);
        Path r102 = new Path();
        r102.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom()), r101, Path.Direction.CW);
        r100.clipPath(r102);
        super.draw(r100);
        r100.restore();
        return;
    L7:
        super.draw(r100);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onHostPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.mPageStatus = 2;
        SimpleMediaView r101 = this.mVideoContainer;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.h() == true) goto L7;
        return;
    L7:
        if (this.mAutoLifecycle == false) goto L12;
        this.mShouldContinuePlay = true;
        r101.j();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onHostResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.mPageStatus = 1;
        SimpleMediaView r101 = this.mVideoContainer;
        if (r101.g() == true) goto L5;
        return;
    L5:
        if (this.mAutoLifecycle == true) goto L7;
        return;
    L7:
        if (this.mShouldContinuePlay == false) goto L12;
        r101.k();
        this.mShouldContinuePlay = false;
        return;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void playReal(Function0<Unit> r100) {
        if (this.mNewPlay == true) goto L5;
        legacyPlay(r100);
        return;
    L5:
        if (v.a(this.mLocalPath) == false) goto L7;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L17;
        initVideoContainer();
        legacyPlay(r100);
        return;
    L17:
        return;
    L7:
        if (v.a(this.mVid) == true) goto L12;
        if (v.a(this.mVideoUrl) == true) goto L12;
        r101 = false;
        goto L13
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setAutoLifecycle(boolean r100) {
        this.mAutoLifecycle = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setAutoPlay(boolean r100) {
        if (this.mAutoPlay == r100) goto L5;
        boolean r101 = true;
    L7:
        if (detect(r101) == false) goto L9;
        this.mNeedVideoReRender = true;
    L9:
        this.mAutoPlay = r100;
        return;
    L5:
        r101 = false;
        goto L7
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setBorderRadius(float[] r100) {
        detect(!Intrinsics.areEqual(this.mBorderRadius, r100));
        this.mBorderRadius = r100;
        invalidate();
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setDeviceChangeAware(boolean r100) {
        this.mDeviceChangeAware = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setEnablePlayListener(boolean r100) {
        this.mEnablePlayListener = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setInitTime(int r100) {
        if (this.mInitTime == r100) goto L5;
        boolean r101 = true;
    L6:
        detect(r101);
        this.mInitTime = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setLoop(boolean r100) {
        this.mLoop = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setMuted(boolean r100) {
        if (this.mMuted == r100) goto L5;
        boolean r101 = true;
    L6:
        detect(r101);
        this.mMuted = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setObjectFit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objectFit");
        this.mObjectFit = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setPoster(String r100) {
        Intrinsics.checkNotNullParameter(r100, "poster");
        detect(!Intrinsics.areEqual(this.mPoster, r100));
        this.mPoster = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setPreload(boolean r100) {
        this.mPreload = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setRate(int r100) {
        this.mRate = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setSrc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Object r101 = parseSrc(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof Uri) == true) goto L7;
        return;
    L7:
        if (detect(!Intrinsics.areEqual(this.mUri, r101)) == false) goto L9;
        this.mNeedVideoReRender = true;
    L9:
        Uri r102 = (Uri) r101;
        String r103 = UriProtector.getQueryParameter(r102, "play_url");
        String r104 = "";
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        boolean r105 = r102.getBooleanQueryParameter("enableOffline", false);
        this.mEnableOffline = r105;
        this.mUri = r102;
        if (r105 == false) goto L16;
        r103 = "";
    L16:
        this.mVideoUrl = r103;
        String r106 = UriProtector.getQueryParameter(r102, "video_id");
        if (r106 == null) goto L20;
        r104 = r106;
    L20:
        this.mVid = r104;
        this.mNewPlay = r102.getBooleanQueryParameter("newPlay", false);
        if (this.mEnableOffline == false) goto L24;
        return;
    L24:
        if (TextUtils.isEmpty(this.mVideoUrl) == true) goto L29;
        loadVideoResource();
        return;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setStateChangeReporter(Function3<? super String, ? super Map<String, ? extends Object>, ? super DeclarativeVideoPlayBoxViewDelegate, Unit> r100) {
        this.mReporter = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setVideoTag(String r100) {
        this.mVideoTag = r100;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void setVolume(float r100) {
        if (this.mVolume != r100) goto L5;
        boolean r101 = true;
    L6:
        detect(!r101);
        this.mVolume = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$detect(DeclarativeVideoPlayBoxViewBaseImpl r100, boolean r101) {
        return r100.detect(r101);
    }

    public static final /* synthetic */ void access$legacyPlay(DeclarativeVideoPlayBoxViewBaseImpl r100, Function0 r101) {
        r100.legacyPlay(r101);
    }

    public static final /* synthetic */ void access$setMLocalPath$p(DeclarativeVideoPlayBoxViewBaseImpl r100, String r101) {
        r100.mLocalPath = r101;
    }

    public static final /* synthetic */ void access$setMNeedVideoReRender$p(DeclarativeVideoPlayBoxViewBaseImpl r100, boolean r101) {
        r100.mNeedVideoReRender = r101;
    }

    public static final /* synthetic */ void access$setMVideoUrl$p(DeclarativeVideoPlayBoxViewBaseImpl r100, String r101) {
        r100.mVideoUrl = r101;
    }

    public static final /* synthetic */ void access$setMVisible$p(DeclarativeVideoPlayBoxViewBaseImpl r100, boolean r101) {
        r100.mVisible = r101;
    }

    /* JADX INFO: renamed from: initPoster$lambda-5$lambda-4, reason: not valid java name */
    private static final void m8367initPoster$lambda5$lambda4(DeclarativeVideoPlayBoxViewBaseImpl r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.hidePoster();
        DeclarativeVideoPlayBoxViewDelegate.playReal$default(r100, null, 1, null);
    }

    /* JADX INFO: renamed from: initPoster$lambda-7$lambda-6, reason: not valid java name */
    private static final void m8368initPoster$lambda7$lambda6(DeclarativeVideoPlayBoxViewBaseImpl r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.hidePoster();
        DeclarativeVideoPlayBoxViewDelegate.playReal$default(r100, null, 1, null);
    }

    private final void notifyStateChange(String r100, Map<String, ? extends Object> r101) {
        Function3<? super String, ? super Map<String, ? extends Object>, ? super DeclarativeVideoPlayBoxViewDelegate, Unit> r102 = this.mReporter;
        if (r102 == null) goto L6;
        r102.invoke(r100, r101, this);
        return;
    }

    @Override // com.bytedance.ies.xelement.DeclarativeVideoPlayBoxViewDelegate
    public void seek(int r100, boolean r101) {
        this.mInitTime = r100;
        this.mVideoContainer.n(r100);
        if (r101 == false) goto L5;
        DeclarativeVideoPlayBoxViewDelegate.playReal$default(this, null, 1, null);
        return;
    L5:
        postDelayed(new com.bytedance.ies.xelement.video.base.c(this), 500);
    }

    public static final /* synthetic */ void access$notifyStateChange(DeclarativeVideoPlayBoxViewBaseImpl r100, String r101, Map r102) {
        r100.notifyStateChange(r101, r102);
    }
}
