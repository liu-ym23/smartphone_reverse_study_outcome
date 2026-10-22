package com.bytedance.locallife.live.anchor;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.experiment.z;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.k0;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/live/anchor/LiveLocalLifeAnchorAnimatedWebpWidget;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/locallife/live/anchor/a;", "", "getLayoutId", "Landroid/view/View;", "getView", "Lcom/bytedance/locallife/live/anchor/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/locallife/live/anchor/g;", "getController", "()Lcom/bytedance/locallife/live/anchor/g;", "setController", "(Lcom/bytedance/locallife/live/anchor/g;)V", "controller", "Lcom/bytedance/lighten/loader/SmartImageView;", "b", "Lcom/bytedance/lighten/loader/SmartImageView;", "getEcnivAnimated", "()Lcom/bytedance/lighten/loader/SmartImageView;", "ecnivAnimated", "c", "getIvStatic", "ivStatic", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeAnchorAnimatedWebpWidget extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f259101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SmartImageView f259102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SmartImageView f259103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageRequest[] f259104d;

    public LiveLocalLifeAnchorAnimatedWebpWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLocalLifeAnchorAnimatedWebpWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getLayoutId() {
        return R.layout.saas_poi_live_local_life_anchor_webp_anim_v2;
    }

    public View getView() {
        return this;
    }

    @Override // com.bytedance.locallife.live.anchor.a
    public final void playAnimation() {
        g r100 = getController();
        if (r100 == null) goto L37;
        c r101 = r100.a();
        if (r101 == null) goto L42;
        int r102 = j0.c(66);
        ViewGroup.LayoutParams r103 = this.f259102b.getLayoutParams();
        if (r103.width == r102) goto L11;
        r103.width = r102;
        r103.height = r102;
        this.f259102b.setLayoutParams(r103);
    L11:
        if (z.a() == false) goto L35;
        ImageRequest[] r104 = (ImageRequest[]) r101.a();
        ImageRequest[] r105 = this.f259104d;
        if (r105 == null) goto L15;
        ImageRequest r106 = (ImageRequest) ArraysKt.firstOrNull(r105);
    L16:
        if (r104 == null) goto L18;
        ImageRequest r107 = (ImageRequest) ArraysKt.firstOrNull(r104);
    L19:
        if (r106 == null) goto L21;
        Uri r108 = r106.getSourceUri();
    L22:
        if (r107 == null) goto L24;
        Uri r109 = r107.getSourceUri();
    L25:
        boolean r110 = !Intrinsics.areEqual(r108, r109);
        if (this.f259102b.getController() == null) goto L34;
        if (r110 == true) goto L34;
        DraweeController r111 = this.f259102b.getController();
        if (r111 == null) goto L38;
        Animatable r112 = r111.getAnimatable();
        if (r112 == null) goto L39;
        r112.start();
        return;
    L39:
        return;
    L38:
        return;
    L34:
        SmartImageView r113 = this.f259102b;
        PipelineDraweeControllerBuilder r114 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r104);
        Function0<Unit> r115 = new LiveLocalLifeAnchorAnimatedWebpWidget$playAnimationImpl$1(this);
        LiveLocalLifeAnchorAnimatedWebpWidget$playAnimationImpl$2 r116 = LiveLocalLifeAnchorAnimatedWebpWidget$playAnimationImpl$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r115, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r116, "onEnd");
        r113.setController(r114.setControllerListener(new k0(null, r115, r116, null)).build());
        this.f259104d = r104;
        return;
    L24:
        r109 = null;
        goto L25
    L21:
        r108 = null;
        goto L22
    L18:
        r107 = null;
        goto L19
    L15:
        r106 = null;
        goto L16
    L35:
        SmartImageView r117 = this.f259102b;
        PipelineDraweeControllerBuilder r118 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests((Object[]) r101.a());
        Function0<Unit> r119 = new LiveLocalLifeAnchorAnimatedWebpWidget$playAnimationImpl$3(this);
        Function0<Unit> r120 = new LiveLocalLifeAnchorAnimatedWebpWidget$playAnimationImpl$4(this);
        Intrinsics.checkNotNullParameter(r119, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r120, "onEnd");
        r117.setController(r118.setControllerListener(new k0(null, r119, r120, null)).build());
        return;
    L42:
        return;
    }

    public g getController() {
        return this.f259101a;
    }

    public final SmartImageView getEcnivAnimated() {
        return this.f259102b;
    }

    public final SmartImageView getIvStatic() {
        return this.f259103c;
    }

    @Override // com.bytedance.locallife.live.anchor.a
    public void setController(g r100) {
        this.f259101a = r100;
    }

    public LiveLocalLifeAnchorAnimatedWebpWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        new LinkedHashMap();
        LayoutInflater.from(r100).inflate(getLayoutId(), this);
        SmartImageView r103 = (SmartImageView) findViewById(R.id.ecniv_animated);
        this.f259102b = r103;
        this.f259103c = (SmartImageView) findViewById(R.id.iv_static);
        r103.getHierarchy().setFadeDuration(0);
        setClipChildren(false);
    }

    public /* synthetic */ LiveLocalLifeAnchorAnimatedWebpWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
