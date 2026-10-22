package com.larus.voicecall.impl.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.n0;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u001c\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t*\u0002)9\u0018\u0000 q2\u00020\u0001:\u0003qrsB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\u0010J(\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0014J\u0018\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0014J\u000e\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\nJ\u0006\u0010G\u001a\u00020\u0015J<\u0010H\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\n2\b\b\u0002\u0010L\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020\nJ\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J\b\u0010P\u001a\u00020\u0017H\u0002J\u000e\u00107\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u0017J\u0006\u0010R\u001a\u00020\u0015J\u000e\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020UJ*\u0010V\u001a\u00020\u00152\b\u0010W\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010X\u001a\u00020\u00172\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010Y\u001a\u00020\u00152\u0006\u0010W\u001a\u00020\u0012H\u0002J\u0010\u0010Z\u001a\u00020\u00152\b\b\u0001\u0010[\u001a\u00020\nJ\u000e\u0010Z\u001a\u00020\u00152\u0006\u0010\\\u001a\u00020\rJ\u0006\u0010]\u001a\u00020\u0015J\u0018\u0010X\u001a\u00020\u00152\u0006\u0010^\u001a\u00020_2\b\b\u0002\u0010`\u001a\u00020\u0017J\u0010\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\rH\u0002J \u0010c\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\u0017H\u0002J\b\u0010g\u001a\u00020\u0015H\u0014J\b\u0010h\u001a\u00020\u0015H\u0014J\u0010\u0010i\u001a\u00020\u00152\u0006\u0010j\u001a\u00020kH\u0014J(\u0010l\u001a\u00020\u00152\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020UH\u0002J(\u0010p\u001a\u00020\u00152\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020UH\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0010\u0010'\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006t"}, d2 = {"Lcom/larus/voicecall/impl/ui/VoiceCallVideoView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wrapLog", "", "message", "surfaceReadyCallback", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$SurfaceReadyCallback;", "pendingVideo", "Lcom/larus/voicecall/impl/util/RealtimeDiskExt$VoiceVideo;", "pendingOnRenderStart", "Lkotlin/Function0;", "", "isCircle", "", "path", "Landroid/graphics/Path;", "mSurface", "Landroid/view/Surface;", "onRenderStart", "isSurfaceReady", "()Z", "setSurfaceReady", "(Z)V", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "getMVideoController", "()Lcom/larus/platform/api/IVideoController;", "mVideoController$delegate", "Lkotlin/Lazy;", "mVideo", "mVideoView", "com/larus/voicecall/impl/ui/VoiceCallVideoView$mVideoView$1", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$mVideoView$1;", "mFrameView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mCoverView", "Landroid/view/View;", "shadowBlurPaint", "Landroid/graphics/Paint;", "coverBlurPaint", "staticBlur", "blurShader", "Landroid/graphics/BitmapShader;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "autoReleaseVideoController", "mSurfaceTextureListener", "com/larus/voicecall/impl/ui/VoiceCallVideoView$mSurfaceTextureListener$1", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$mSurfaceTextureListener$1;", "setSurfaceReadyCallback", "callback", "onSizeChanged", "w", "h", "oldw", "oldh", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateBlurCoverColor", "coverColor", "resetVideoState", "enableBlur", "isImmersive", "isDarkMode", "immersiveColor", "darkCoverColor", "lightCoverColor", "createBlurPaint", "isBlurMode", "enableBlurCover", "enable", "releaseVideoController", "setSpeed", "speed", "", "play", "video", "showCover", "startVideoPlayback", "showFrame", "firstFrame", "firstFrameUrl", "stop", "cover", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$Cover;", "withAnim", "fitVideoIfNeed", "from", "applyVideoTransform", "containerWidth", "containerHeight", "centerCrop", "onAttachedToWindow", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "renderOnBlur", "width", "height", "radius", "renderOnNormal", "Companion", "SurfaceReadyCallback", "Cover", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallVideoView extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f379338p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f379339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t0.b f379340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f379341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f379342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f379343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Surface f379344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f379345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f379346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f379347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t0.b f379348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f379349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SimpleDraweeView f379350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f379351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CoroutineScope f379352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f379353o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f379354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f379355b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f379354a == r101.f379354a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f379355b, r101.f379355b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f379354a * 31) + Float.floatToIntBits(this.f379355b);
        }

        public final String toString() {
            return "Cover(color=" + this.f379354a + ", alpha=" + this.f379355b + ')';
        }

        public b(int r100, float r101) {
            this.f379354a = r100;
            this.f379355b = r101;
        }
    }

    public interface c {
        void onSurfaceDestroyed();

        void onSurfaceReady();
    }

    public static final class d implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceCallVideoView f379356a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public d(VoiceCallVideoView r100) {
            this.f379356a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            FLogger r101 = FLogger.f375446a;
            VoiceCallVideoView r102 = this.f379356a;
            int r103 = VoiceCallVideoView.f379338p;
            r101.d("VoiceCallVideoView", r102.j("onSurfaceTextureDestroyed"));
            Surface r104 = this.f379356a.f379344f;
            if (r104 != null) goto L5;
        L7:
            boolean r105 = false;
        L8:
            if (r105 == false) goto L16;
            this.f379356a.setSurfaceReady(false);
            c r106 = this.f379356a.f379339a;
            if (r106 == null) goto L12;
            r106.onSurfaceDestroyed();
        L12:
            r100.release();
            Surface r107 = this.f379356a.f379344f;
            if (r107 == null) goto L15;
            r107.release();
        L15:
            VoiceCallVideoView r108 = this.f379356a;
            r108.f379344f = null;
            r101.d("VoiceCallVideoView", r108.j("Surface destroyed and resources cleaned"));
        L16:
            return true;
        L5:
            if (r104.isValid() != true) goto L7;
            r105 = true;
            goto L8
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            FLogger r103 = FLogger.f375446a;
            VoiceCallVideoView r104 = this.f379356a;
            String r105 = "onSurfaceTextureAvailable: width=" + r101 + ", height=" + r102;
            int r106 = VoiceCallVideoView.f379338p;
            r103.d("VoiceCallVideoView", r104.j(r105));
            Surface r107 = this.f379356a.f379344f;
            if (r107 != null) goto L5;
        L7:
            boolean r108 = false;
        L8:
            if (r108 == true) goto L19;
            this.f379356a.f379344f = new Surface(r100);
            this.f379356a.setSurfaceReady(true);
            VoiceCallVideoView r109 = this.f379356a;
            t0.b r110 = r109.f379340b;
            if (r110 == null) goto L15;
            r103.d("VoiceCallVideoView", r109.j("Playing pending video after surface ready"));
            com.larus.utils.t0.c(new j0(r110, r109));
            Function0<Unit> r111 = r109.f379341c;
            if (r111 == null) goto L14;
            r109.f379345g = r111;
        L14:
            r109.f379340b = null;
            r109.f379341c = null;
        L15:
            c r112 = this.f379356a.f379339a;
            if (r112 == null) goto L20;
            r112.onSurfaceReady();
            return;
        L20:
            return;
        L19:
            return;
        L5:
            if (r107.isValid() != true) goto L7;
            r108 = true;
            goto L8
        }
    }

    public static final class e implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceCallVideoView f379357a;

        @Override // com.larus.platform.api.n0
        public final void b(Integer r100, Integer r101) {
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
            e1.o(this.f379357a.f379350l);
            this.f379357a.getClass();
            FLogger.f375446a.i("VoiceCallVideoView", this.f379357a.j("onRenderStart"));
            Function0<Unit> r100 = this.f379357a.f379345g;
            if (r100 == null) goto L5;
            r100.invoke();
        L5:
            this.f379357a.f379345g = null;
        }

        public e(VoiceCallVideoView r100) {
            this.f379357a = r100;
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
            FLogger.f375446a.e("VoiceCallVideoView", "onVideoStatusException status=" + r100);
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            FLogger.f375446a.e("VoiceCallVideoView", "onError code=" + r100 + " internalCode=" + r101);
        }
    }

    public static final class f extends TextureView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function0<Unit> f379358a;

        @Override // android.view.View
        public final void invalidate() {
            super.invalidate();
            this.f379358a.invoke();
        }

        public final Function0<Unit> getOnTextureLayerUpdate() {
            return this.f379358a;
        }

        public f(Context r100) {
            super(r100);
            this.f379358a = new l0();
        }

        public final void setOnTextureLayerUpdate(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f379358a = r100;
        }
    }

    static {
    }

    private final IVideoController getMVideoController() {
        return (IVideoController) this.f379347i.getValue();
    }

    public final void i() {
        FLogger.f375446a.d("VoiceCallVideoView", j("stop"));
        IVideoController r100 = getMVideoController();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L12;
        IVideoController r102 = getMVideoController();
        if (r102 == null) goto L13;
        r102.stop();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r100.p3() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void g() {
        IVideoController r100 = getMVideoController();
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        IVideoController r101 = getMVideoController();
        if (r101 == null) goto L8;
        r101.l();
    L8:
        IVideoController r102 = getMVideoController();
        if (r102 == null) goto L11;
        r102.release();
    L11:
        CoroutineScopeKt.cancel$default(this.f379352n, null, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.f375446a.d("VoiceCallVideoView", j("onAttachedToWindow"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.d("VoiceCallVideoView", j("onDetachedFromWindow"));
        if (this.f379353o == false) goto L6;
        g();
        return;
    }

    public VoiceCallVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void d(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L13
        r102.i("VoiceCallVideoView", j("fitVideoIfNeed, from:" + r100 + ",video:" + this.f379348j));     // Catch: Throwable -> L13
        t0.b r103 = this.f379348j;     // Catch: Throwable -> L13
        if (r103 == null) goto L8;
        boolean r104 = true;
        if (r103.a() != true) goto L8;
    L9:
        if (r104 == true) goto L11;
        return;
    L11:
        int r105 = getWidth();     // Catch: Throwable -> L13
        int r106 = getHeight();     // Catch: Throwable -> L13
        c(r105, r106, e2.f365734a.isPad());     // Catch: Throwable -> L13
        r102.i("VoiceCallVideoView", j("fitVideoIfNeed, viewWidth:" + r105 + ",viewHeight:" + r106 + ",videoWidth:" + r103.f379487c + ",videoHeight:" + r103.f379488d + ",resultWidth:" + this.f379349k.getWidth() + ",resultHeight:" + this.f379349k.getHeight()));     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L13
    L15:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L18;
        r107 = r108;
    L18:
        ((Boolean) r107).booleanValue();
        return;
    L8:
        r104 = false;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f379342d == true) goto L15;
        super.dispatchDraw(r100);
        return;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        int r102 = getWidth();     // Catch: Throwable -> L8
        int r103 = getHeight();     // Catch: Throwable -> L8
        float r104 = (float) ((Math.min(r102, r103) / ((double) 2)) - ((double) i5.b()));     // Catch: Throwable -> L8
        this.f379343e.reset();     // Catch: Throwable -> L8
        this.f379343e.addCircle(r102 / 2, r103 / 2, r104, Path.Direction.CW);     // Catch: Throwable -> L8
        r100.save();     // Catch: Throwable -> L8
        r100.clipPath(this.f379343e);     // Catch: Throwable -> L8
        super.dispatchDraw(r100);     // Catch: Throwable -> L8
        r100.restore();     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        FLogger.f375446a.e("VoiceCallVideoView", "dispatchDraw failed:" + r106);
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final String j(String r100) {
        return hashCode() + " - " + r100;
    }

    public final void setSpeed(final float r100) {
        com.larus.utils.t0.c(new f0(this, r100));
    }

    public final void setSurfaceReady(boolean r100) {
        this.f379346h = r100;
    }

    public final void setSurfaceReadyCallback(c r100) {
        this.f379339a = r100;
    }

    public VoiceCallVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static void a(t0.b r100, VoiceCallVideoView r101) {
        String r102 = r100.f379489e;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L15;
        IVideoController r104 = r101.getMVideoController();
        if (r104 == null) goto L14;
        r104.setDirectURL(r100.f379489e);
    L14:
        FLogger.f375446a.d("VoiceCallVideoView", r101.j("Setting network URL: " + r100.f379489e));
    L19:
        IVideoController r105 = r101.getMVideoController();
        if (r105 == null) goto L22;
        r105.play();
    L22:
        FLogger.f375446a.d("VoiceCallVideoView", r101.j("Play command sent"));
        return;
    L15:
        IVideoController r106 = r101.getMVideoController();
        if (r106 == null) goto L18;
        r106.setLocalURL(r100.f379485a);
    L18:
        FLogger.f375446a.d("VoiceCallVideoView", r101.j("Setting local URI: " + r100.f379485a));
        goto L19
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public static void b(VoiceCallVideoView r100, float r101) {
        IVideoController r102 = r100.getMVideoController();
        if (r102 == null) goto L8;
        com.larus.platform.api.n r103 = r102.a();
        if (r103 == null) goto L9;
        r103.f365214a = r101;
        return;
    L9:
        return;
    }

    public static /* synthetic */ void f(VoiceCallVideoView r100, t0.b r101) {
        r100.e(r101, true, new e0());
    }

    public static void h(VoiceCallVideoView r100, b r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "cover");
        r100.f379351m.setBackgroundColor(r101.f379354a);
        r100.f379351m.setAlpha(r101.f379355b);
        e1.x(r100.f379351m);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (e2.f365734a.isPad() == true) goto L5;
        c(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101), false);
    L5:
        super.onMeasure(r100, r101);
    }

    public VoiceCallVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f379343e = new Path();
        this.f379345g = new g0();
        this.f379347i = LazyKt.lazy(new h0(this));
        f r103 = new f(getContext());
        this.f379349k = r103;
        SimpleDraweeView r104 = new SimpleDraweeView(getContext());
        r104.setScaleType(ImageView.ScaleType.CENTER_CROP);
        e1.o(r104);
        this.f379350l = r104;
        View r105 = new View(getContext());
        e1.o(r105);
        this.f379351m = r105;
        this.f379352n = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("VoiceCallVideoView"))).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f379353o = true;
        d r106 = new d(this);
        if (r101 == null) goto L5;
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_is_circle});
        this.f379342d = r107.getBoolean(0, false);
        r107.recycle();
    L5:
        setBackgroundColor(ContextCompat.getColor(r100, android.R.color.transparent));
        r103.setSurfaceTextureListener(r106);
        addView(r103, -1, -1);
        addView(r104, -1, -1);
        addView(r105, -1, -1);
        r103.setOnTextureLayerUpdate(new i0(this));
    }

    public final void c(int r100, int r101, boolean r102) {
        t0.b r103 = this.f379348j;
        if (r100 <= 0) goto L23;
        if (r101 > 0) goto L6;
        return;
    L6:
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L25;
        float r105 = r100;
        float r106 = r105 / r103.f379487c;
        float r107 = r101;
        float r108 = r107 / r103.f379488d;
        float r109 = Math.max(r106, r108);
        if (r102 == false) goto L16;
        float r110 = r109 / r106;
        float r111 = r109 / r108;
    L17:
        Matrix r112 = new Matrix();
        if (r102 == false) goto L20;
        r112.setScale(r110, r111, r105 / 2.0f, r107 / 2.0f);
    L21:
        this.f379349k.setTransform(r112);
        return;
    L20:
        r112.setScale(r110, r111);
        goto L21
    L16:
        float r113 = (((int) (r103.f379487c * r109)) + 1) / r105;
        r111 = (((int) (r103.f379488d * r109)) + 1) / r107;
        r110 = r113;
        goto L17
    L25:
        return;
    L8:
        if (r103.a() != true) goto L10;
        r104 = true;
        goto L11
    }

    public final void e(t0.b r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "onRenderStart");
        FLogger r103 = FLogger.f375446a;
        r103.d("VoiceCallVideoView", j("play, video=" + r100));
        this.f379348j = r100;
        this.f379345g = r102;
        boolean r104 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L24;
        if (r101 == false) goto L18;
        String r106 = r100.f379490f;
        if (r106 != null) goto L13;
    L14:
        r104 = true;
    L15:
        if (r104 == true) goto L17;
        String r107 = r100.f379490f;
        Intrinsics.checkNotNullParameter(r107, "firstFrameUrl");
        e1.x(this.f379350l);
        ImageLoaderKt.u(this.f379350l, r107, "realtime_call_bot_avatar");
        goto L18
    L17:
        int r108 = r100.f379486b;
        e1.x(this.f379350l);
        this.f379350l.setImageResource(r108);
        goto L18
    L13:
        if (r106.length() != 0) goto L15;
    L18:
        d("play");
        if (this.f379346h == true) goto L22;
        r103.w("VoiceCallVideoView", j("Surface not ready, caching video for later playback"));
        this.f379340b = r100;
        this.f379341c = r102;
        return;
    L22:
        com.larus.utils.t0.c(new j0(r100, this));
        return;
    L24:
        return;
    L5:
        if (r100.a() != true) goto L7;
        r105 = true;
        goto L8
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d("onSizeChanged");
    }
}
