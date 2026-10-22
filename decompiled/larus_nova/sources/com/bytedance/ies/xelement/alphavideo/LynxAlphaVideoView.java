package com.bytedance.ies.xelement.alphavideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.amap.api.col.s.ce;
import com.lynx.tasm.behavior.ui.view.a;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\"\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0007\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000bR\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/bytedance/ies/xelement/alphavideo/LynxAlphaVideoView;", "Lcom/lynx/tasm/behavior/ui/view/a;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMAutoPlay", "()Z", "setMAutoPlay", "(Z)V", "mAutoPlay", "b", "getMIgnoreAttachStatus", "setMIgnoreAttachStatus", "mIgnoreAttachStatus", "Landroidx/lifecycle/LifecycleRegistry;", "c", "Landroidx/lifecycle/LifecycleRegistry;", "getMLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "setMLifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "mLifecycleRegistry", "Landroid/graphics/Bitmap;", "d", "Landroid/graphics/Bitmap;", "getMPoster", "()Landroid/graphics/Bitmap;", "setMPoster", "(Landroid/graphics/Bitmap;)V", "mPoster", "e", "getMLastFrame", "setMLastFrame", "mLastFrame", "f", "getMIsShowLastFrame", "setMIsShowLastFrame", "mIsShowLastFrame", ce.f26391f, "getMIsShowPoster", "setMIsShowPoster", "mIsShowPoster", "Landroid/graphics/Paint;", "h", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "mPaint", "Landroid/graphics/RectF;", RXScreenCaptureService.KEY_INDEX, "Landroid/graphics/RectF;", "getMRectF", "()Landroid/graphics/RectF;", "setMRectF", "(Landroid/graphics/RectF;)V", "mRectF", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-alpha-video_release"}, k = 1, mv = {1, 6, 0})
public final class LynxAlphaVideoView extends a implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LifecycleRegistry f249725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f249726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f249727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f249730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f249731i;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f249724b == false) goto L6;
        return;
    L6:
        if (this.f249723a == false) goto L9;
        this.f249725c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f249724b == false) goto L5;
        return;
    L5:
        this.f249725c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f249725c;
    }

    public final boolean getMAutoPlay() {
        return this.f249723a;
    }

    public final boolean getMIgnoreAttachStatus() {
        return this.f249724b;
    }

    public final boolean getMIsShowLastFrame() {
        return this.f249728f;
    }

    public final boolean getMIsShowPoster() {
        return this.f249729g;
    }

    public final Bitmap getMLastFrame() {
        return this.f249727e;
    }

    public final LifecycleRegistry getMLifecycleRegistry() {
        return this.f249725c;
    }

    public final Paint getMPaint() {
        return this.f249730h;
    }

    public final Bitmap getMPoster() {
        return this.f249726d;
    }

    public final RectF getMRectF() {
        return this.f249731i;
    }

    public LynxAlphaVideoView(Context r100) {
        new LinkedHashMap();
        super(r100);
        setWillNotDraw(false);
        this.f249725c = new LifecycleRegistry(this);
        this.f249730h = new Paint();
        this.f249731i = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f249726d == null) goto L8;
        if (this.f249729g == false) goto L8;
        this.f249731i.set(0.0f, 0.0f, getWidth(), getHeight());
        Intrinsics.checkNotNull(r100);
        Bitmap r101 = this.f249726d;
        Intrinsics.checkNotNull(r101);
        r100.drawBitmap(r101, null, this.f249731i, this.f249730h);
        return;
    L8:
        if (this.f249727e != null) goto L10;
        return;
    L10:
        if (this.f249728f == false) goto L15;
        this.f249731i.set(0.0f, 0.0f, getWidth(), getHeight());
        Intrinsics.checkNotNull(r100);
        Bitmap r102 = this.f249727e;
        Intrinsics.checkNotNull(r102);
        r100.drawBitmap(r102, null, this.f249731i, this.f249730h);
        return;
    }

    public final void setMAutoPlay(boolean r100) {
        this.f249723a = r100;
    }

    public final void setMIgnoreAttachStatus(boolean r100) {
        this.f249724b = r100;
    }

    public final void setMIsShowLastFrame(boolean r100) {
        this.f249728f = r100;
    }

    public final void setMIsShowPoster(boolean r100) {
        this.f249729g = r100;
    }

    public final void setMLastFrame(Bitmap r100) {
        this.f249727e = r100;
    }

    public final void setMLifecycleRegistry(LifecycleRegistry r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f249725c = r100;
    }

    public final void setMPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f249730h = r100;
    }

    public final void setMPoster(Bitmap r100) {
        this.f249726d = r100;
    }

    public final void setMRectF(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f249731i = r100;
    }
}
