package com.bytedance.lighten.loader;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.core.ScaleType;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes20.dex */
public class SmartImageView extends SimpleDraweeView implements df6.l, df6.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<hf6.a> f254701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f254702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public df6.t f254703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f254704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f254705e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PipelineDraweeControllerBuilder f254706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartImageView f254707b;

        @Override // java.lang.Runnable
        public final void run() {
            AbstractDraweeController r100 = this.f254706a.build();     // Catch: Throwable -> L4
            this.f254707b.setController(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SmartImageView r100, PipelineDraweeControllerBuilder r101) {
            this.f254707b = r100;
            this.f254706a = r101;
        }
    }

    public String getAnimPreviewFrameCacheKey() {
        return null;
    }

    public df6.k getSmartHierarchy() {
        return this;
    }

    public void j() {
    }

    public final void n() {
        if (getController() == null) goto L23;
        e r100 = this.f254702b;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f254704d == true) goto L10;
        return;
    L10:
        if (r100.f254728e == true) goto L12;
        return;
    L12:
        if (this.f254705e == false) goto L26;
        Animatable r101 = getController().getAnimatable();
        if (r101 != null) goto L16;
        return;
    L16:
        if (r101.isRunning() == true) goto L28;
        r101.start();
        WeakReference<hf6.a> r102 = this.f254701a;
        if (r102 != null) goto L20;
        return;
    L20:
        if (r102.get() == null) goto L30;
        this.f254701a.get().a();
        return;
    L30:
        return;
    L28:
        return;
    L26:
        return;
    }

    public final void o() {
        if (getController() != null) goto L5;
        return;
    L5:
        Animatable r100 = getController().getAnimatable();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isRunning() == false) goto L16;
        r100.stop();
        WeakReference<hf6.a> r101 = this.f254701a;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.get() == null) goto L18;
        this.f254701a.get().b();
        return;
    L18:
        return;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public final void onDetach() {
        super.onDetach();
    }

    public SmartImageView(Context r100) {
        super(r100);
        j();
    }

    public void f(df6.t r100) {
        df6.s r101 = df6.s.f468248a;     // Catch: Exception -> L4
        df6.q.a().getClass();     // Catch: Exception -> L4
    L5:
        this.f254703c = r100;
        r100.getClass();
        ImageRequest r102 = m.b(r100, null);
        ef6.a r103 = r100.E;
        if (r103 != null) goto L8;
    L16:
        k(m.b(r100, r100.f468249a), r102);
    L17:
        TextUtils.isEmpty(null);
        return;
    L8:
        if (r103.a() == true) goto L16;
        df6.s r104 = df6.s.f468248a;
        if (df6.s.a().intValue() <= 0) goto L15;
        ImageRequest r105 = m.f(r100);
        if (r105 == null) goto L14;
        k(r105, r102);
        goto L17
    L14:
        m(m.d(r100), r102);
        goto L17
    L15:
        m(m.d(r100), r102);
        goto L17
    }

    public void setActualImageScaleType(ScaleType r100) {
        if (r100 == null) goto L5;
        getHierarchy().setActualImageScaleType(y.a(r100));
        return;
    }

    public void setAnimationListener(hf6.a r100) {
        this.f254701a = new WeakReference(r100);
    }

    public void setAttached(boolean r100) {
        this.f254704d = r100;
    }

    public void setCircleOptions(CircleOptions r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (getHierarchy().getRoundingParams() == null) goto L7;
        RoundingParams r101 = getHierarchy().getRoundingParams();
    L8:
        r101.setRoundAsCircle(r100.f254603c);
        r101.setCornersRadius(r100.f254604d);
        r101.setBorderWidth(r100.f254601a);
        r101.setBorderColor(r100.f254602b);
        r101.setOverlayColor(0);
        r101.setPadding(0.0f);
        if (r100.f254605e != CircleOptions.RoundingMethod.OVERLAY_COLOR) goto L11;
        RoundingParams.RoundingMethod r102 = RoundingParams.RoundingMethod.OVERLAY_COLOR;
    L12:
        r101.setRoundingMethod(r102);
        getHierarchy().setRoundingParams(r101);
        return;
    L11:
        r102 = RoundingParams.RoundingMethod.BITMAP_ONLY;
        goto L12
    L7:
        r101 = new RoundingParams();
        goto L8
    }

    public void setImageDisplayListener(hf6.f r100) {
        e r101 = this.f254702b;
        if (r101 == null) goto L6;
        r101.f254725b = r100;
        return;
    }

    public void setPlaceholderImage(int r100) {
        if (r100 <= 0) goto L5;
        getHierarchy().setPlaceholderImage(r100);
        return;
    }

    public void setUserVisibleHint(boolean r100) {
        this.f254705e = r100;
    }

    public void setPlaceholderImage(Drawable r100) {
        getHierarchy().setPlaceholderImage(r100);
    }

    public SmartImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        j();
    }

    public final void k(ImageRequest r100, ImageRequest r101) {
        PipelineDraweeControllerBuilder r102 = Fresco.newDraweeControllerBuilder().setOldController(getController()).setAutoPlayAnimations(this.f254703c.f468251c);
        this.f254703c.getClass();
        PipelineDraweeControllerBuilder r103 = r102.setTapToRetryEnabled(false).setImageRequest(r100);
        if (r101 == null) goto L6;
        r103.setLowResImageRequest(r101);
    L6:
        if (TextUtils.isEmpty(this.f254703c.f468272x) == true) goto L8;
        r103.setCallerContext(this.f254703c.f468272x);
    L8:
        e r104 = this.f254702b;
        if (r104 == null) goto L11;
        r104.a(this.f254703c);
        r103.setControllerListener(this.f254702b).setImageOriginListener(this.f254702b);
    L12:
        com.bytedance.lighten.core.utils.b.a.f254686a.execute(new a(this, r103));
        return;
    L11:
        e r105 = new e();
        this.f254702b = r105;
        r105.a(this.f254703c);
        r103.setControllerListener(this.f254702b).setImageOriginListener(this.f254702b);
        goto L12
    }

    public final void m(ImageRequest[] r100, ImageRequest r101) {
        if (r100.length == 0) goto L17;
        PipelineDraweeControllerBuilder r102 = Fresco.newDraweeControllerBuilder().setOldController(getController()).setAutoPlayAnimations(this.f254703c.f468251c);
        this.f254703c.getClass();
        PipelineDraweeControllerBuilder r103 = r102.setTapToRetryEnabled(false).setCallerContext(this.f254703c.f468272x).setFirstAvailableImageRequests(r100, true);
        if (r101 == null) goto L9;
        r103.setLowResImageRequest(r101);
    L9:
        if (TextUtils.isEmpty(this.f254703c.f468272x) == true) goto L11;
        r103.setCallerContext(this.f254703c.f468272x);
    L11:
        e r104 = this.f254702b;
        if (r104 == null) goto L14;
        r104.a(this.f254703c);
        r103.setControllerListener(this.f254702b).setImageOriginListener(this.f254702b);
    L15:
        com.bytedance.lighten.core.utils.b.a.f254686a.execute(new d0(this, r103));
        return;
    L14:
        e r105 = new e();
        this.f254702b = r105;
        r105.a(this.f254703c);
        r103.setControllerListener(this.f254702b).setImageOriginListener(this.f254702b);
        goto L15
    }

    public SmartImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        j();
    }
}
