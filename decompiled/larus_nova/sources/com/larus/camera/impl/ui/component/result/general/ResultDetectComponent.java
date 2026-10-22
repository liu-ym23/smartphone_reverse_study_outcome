package com.larus.camera.impl.ui.component.result.general;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.camera.impl.databinding.LarusLayoutViewResultDetectComponentBinding;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0006H\u0014J\b\u0010#\u001a\u00020\u0006H\u0014J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0003J\u0014\u0010/\u001a\u00020\u0006*\u00020\u000f2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000104H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00066"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultDetectComponent;", "Lcom/larus/camera/impl/ui/arch/LayerComponent;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutViewResultDetectComponentBinding;", "startLoadingAnimationJob", "Lkotlinx/coroutines/Job;", "mainCameraDetectConfig", "Lcom/larus/platform/model/camera/MainCameraDetectConfig;", "getMainCameraDetectConfig", "()Lcom/larus/platform/model/camera/MainCameraDetectConfig;", "mainCameraDetectConfig$delegate", "Lkotlin/Lazy;", "createView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createLayoutParams", "Lcom/larus/camera/impl/ui/arch/CameraContainer$LayoutParams;", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "onViewCreated", "onViewDestroyed", "init", "onDetectStarted", "launchStartLoadingAnimationJob", "showLoadingThresholdMs", "", "startDetectAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopDetectAnimation", "interceptTouchEvent", "intercept", "", "adjustDetectAnimationViewBounds", "previewBounds", "Landroid/graphics/Rect;", "onDetectCompleted", "intentDetectResult", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultDetectComponent extends com.larus.camera.impl.ui.arch.b implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f322150p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LarusLayoutViewResultDetectComponentBinding f322151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f322152n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f322153o;

    public static final class a {
    }

    static {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    public ResultDetectComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
        this.f322153o = LazyKt.lazy(new m());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        i().addObserver(this);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getResultDetectionStatus(), new ResultDetectComponent$onViewCreated$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getResultPreviewBounds(), new ResultDetectComponent$onViewCreated$2(this, null)), k());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        Job r100 = this.f322152n;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f322152n = null;
        LarusLayoutViewResultDetectComponentBinding r101 = this.f322151m;
        if (r101 == null) goto L14;
        ResultDetectAnimationView r102 = r101.f321532b;
        if (r102 == null) goto L15;
        Animator r103 = r102.f322145a;
        if (r103 == null) goto L12;
        r103.cancel();
    L12:
        r102.f322145a = null;
        return;
    L15:
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = -1;
        return r101;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = r100.inflate(R.layout.larus_layout_view_result_detect_component, r101, false);
        ResultDetectAnimationView r103 = (ResultDetectAnimationView) ViewBindings.findChildViewById(r102, R.id.detect_animation_view);
        if (r103 == null) goto L7;
        FrameLayout r104 = (FrameLayout) r102;
        this.f322151m = new LarusLayoutViewResultDetectComponentBinding(r104, r103);
        return r104;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.detect_animation_view)));
    }
}
