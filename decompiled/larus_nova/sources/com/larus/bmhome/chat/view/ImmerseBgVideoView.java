package com.larus.bmhome.chat.view;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.api.n0;
import com.larus.platform.service.q3;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import po8.q;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e*\u0003\u001c!$\u0018\u0000 42\u00020\u0001:\u00014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\b\u0010,\u001a\u00020'H\u0014J\b\u0010-\u001a\u00020'H\u0014J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020'H\u0002J\u0018\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u000e\u00102\u001a\u00020'2\u0006\u00101\u001a\u00020\u000bJ\u0006\u00103\u001a\u00020'R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/view/ImmerseBgVideoView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tag", "", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "mVideoView", "Landroid/view/TextureView;", "mSurface", "Landroid/view/Surface;", "mVideoWidth", "", "mVideoHeight", "mViewAspectRatio", "mVideoAspectRatio", "needPause", "", "isPauseInFirstFrame", "currentVideoModel", "mSurfaceTextureListener", "com/larus/bmhome/chat/view/ImmerseBgVideoView$mSurfaceTextureListener$1", "Lcom/larus/bmhome/chat/view/ImmerseBgVideoView$mSurfaceTextureListener$1;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "videoStateCallback", "com/larus/bmhome/chat/view/ImmerseBgVideoView$videoStateCallback$1", "Lcom/larus/bmhome/chat/view/ImmerseBgVideoView$videoStateCallback$1;", "videoModelPreloadCallback", "com/larus/bmhome/chat/view/ImmerseBgVideoView$videoModelPreloadCallback$1", "Lcom/larus/bmhome/chat/view/ImmerseBgVideoView$videoModelPreloadCallback$1;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "isSurfaceValid", "fitVideoViewSizeCenterCrop", "parseVideoModelAndPlay", "videoModel", "resumePlay", "stop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImmerseBgVideoView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f310361m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IVideoController f310363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextureView f310364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f310365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f310366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f310367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f310368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f310369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f310370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f310371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q f310372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f310373l;

    public static final class a {
    }

    public static final class b implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmerseBgVideoView f310374a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public b(ImmerseBgVideoView r100) {
            this.f310374a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            r100.release();
            FLogger.f375446a.d(this.f310374a.f310362a, "onSurfaceTextureDestroyed");
            Surface r101 = this.f310374a.f310365d;
            if (r101 == null) goto L5;
            r101.release();
        L5:
            this.f310374a.f310365d = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            Surface r103 = this.f310374a.f310365d;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.isValid() != true) goto L7;
        L8:
            if (r104 == true) goto L10;
            ImmerseBgVideoView r105 = this.f310374a;
            r105.f310365d = new Surface(r100);
        L10:
            ImmerseBgVideoView r106 = this.f310374a;
            IVideoController r107 = r106.f310363b;
            if (r107 == null) goto L13;
            r107.setSurface(r106.f310365d);
        L13:
            FLogger.f375446a.d(this.f310374a.f310362a, "onSurfaceTextureAvailable");
            return;
        L7:
            r104 = false;
            goto L8
        }
    }

    public static final class c implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f310375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmerseBgVideoView f310376b;

        public c(String r100, ImmerseBgVideoView r101) {
            this.f310375a = r100;
            this.f310376b = r101;
        }

        @Override // com.larus.platform.api.l4
        public final void a(String r100, com.larus.video.impl.sdk.a r101) {
            if (Intrinsics.areEqual(this.f310375a, r100) == false) goto L18;
            if (r101 == null) goto L19;
            ImmerseBgVideoView r102 = this.f310376b;
            r102.f310366e = r101.b();
            float r103 = r101.a();
            r102.f310367f = r103;
            float r104 = r102.f310366e / r103;
        L9:
            r102.f310369h = r104;
            FLogger.f375446a.d(r102.f310362a, "mVideoAspectRatio = " + r102.f310369h);
            IVideoController r105 = r102.f310363b;
            if (r105 == null) goto L12;
            r105.j(r101, false);
        L12:
            IVideoController r106 = r102.f310363b;
            if (r106 == null) goto L20;
            r106.play();
            return;
        L20:
            return;
        L8:
            r104 = 0.0f;
            goto L9
        L19:
            return;
        }
    }

    public static final class d implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmerseBgVideoView f310377a;

        @Override // com.larus.platform.api.n0
        public final void b(Integer r100, Integer r101) {
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
            ImmerseBgVideoView r100 = this.f310377a;
            r100.f310371j = false;
            FLogger.f375446a.d(r100.f310362a, "onCompletion, gone");
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
            FLogger.f375446a.d(this.f310377a.f310362a, "onPrepare");
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
            e1.x(this.f310377a);
            FLogger.f375446a.d(this.f310377a.f310362a, "onPrepared");
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
            ImmerseBgVideoView r100 = this.f310377a;
            if (r100.f310370i == false) goto L8;
            IVideoController r101 = r100.f310363b;
            if (r101 == null) goto L7;
            r101.b();
        L7:
            ImmerseBgVideoView r102 = this.f310377a;
            r102.f310371j = true;
            FLogger.f375446a.d(r102.f310362a, "onRenderStart, pause video");
        L8:
            FLogger.f375446a.d(this.f310377a.f310362a, "onRenderStart");
        }

        public d(ImmerseBgVideoView r100) {
            this.f310377a = r100;
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
            FLogger.f375446a.d(this.f310377a.f310362a, "playbackState = " + r100);
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
            FLogger.f375446a.d(this.f310377a.f310362a, "loadState = " + r100);
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
            FLogger.f375446a.d(this.f310377a.f310362a, "status = " + r100);
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            FLogger.f375446a.e(this.f310377a.f310362a, "code = " + r100 + ", internalCode = " + r101);
        }
    }

    static {
    }

    public ImmerseBgVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImmerseBgVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        boolean r100 = true;
        if (this.f310368g != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (this.f310369h == 0.0f) goto L11;
        r100 = false;
    L11:
        if (r100 == true) goto L16;
        int r102 = getHeight();
        int r103 = getWidth();
        FLogger r104 = FLogger.f375446a;
        r104.d(this.f310362a, "fitVideoViewSize, displayWidth = " + this.f310366e + ", displayHeight = " + this.f310367f + ", containerWidth = " + r103 + ", containerHeight = " + r102);
        float r105 = (float) r103;
        float r106 = r105 / this.f310366e;
        float r107 = (float) r102;
        float r108 = r107 / this.f310367f;
        float r109 = Math.max(r106, r108);
        float r110 = r109 / r106;
        float r111 = r109 / r108;
        r104.d(this.f310362a, "fitVideoViewSizeV2, scaleX = " + r110 + ", scaleY = " + r111);
        Matrix r112 = new Matrix();
        r112.setScale(r110, r111, r105 / 2.0f, r107 / 2.0f);
        this.f310364c.setTransform(r112);
        r104.d(this.f310362a, "fitVideoViewSize, resultWidth = " + this.f310364c.getWidth() + ", resultHeight = " + this.f310364c.getHeight());
        return;
    L16:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IVideoController r100 = this.f310363b;
        if (r100 == null) goto L5;
        r100.p(this.f310373l);
    L5:
        getViewTreeObserver().addOnPreDrawListener(this.f310372k);
        FLogger.f375446a.d(this.f310362a, "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.d(this.f310362a, "onDetachedFromWindow, release video controller");
        getViewTreeObserver().removeOnPreDrawListener(this.f310372k);
        IVideoController r100 = this.f310363b;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        IVideoController r101 = this.f310363b;
        if (r101 == null) goto L8;
        r101.l();
    L8:
        IVideoController r102 = this.f310363b;
        if (r102 == null) goto L12;
        r102.release();
        return;
    }

    public final void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "videoModel");
        FLogger.f375446a.d(this.f310362a, "parseVideoModelAndPlay, needPause=" + r101);
        IVideoController r102 = this.f310363b;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.p3() != true) goto L7;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        this.f310370i = r101;
        IVideoController r104 = this.f310363b;
        if (r104 == null) goto L14;
        r104.f(r100, new c(r100, this));
        return;
    L14:
        return;
    L7:
        r103 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [po8.q] */
    public ImmerseBgVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        String r103 = "ImmerseBgVideoView-" + hashCode();
        this.f310362a = r103;
        IVideoController r104 = q3.b(r103, null, 6);
        this.f310363b = r104;
        TextureView r105 = new TextureView(r100);
        this.f310364c = r105;
        b r106 = new b(this);
        this.f310372k = new q(this);
        this.f310373l = new d(this);
        setBackgroundColor(ContextCompat.getColor(r100, R.color.transparent));
        addView(r105, -1, -1);
        r105.setSurfaceTextureListener(r106);
        if (r104 == null) goto L6;
        ((o) r104).C(true);
        return;
    }

    public /* synthetic */ ImmerseBgVideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        FLogger.f375446a.d(this.f310362a, "onSizeChanged");
        a();
    }
}
