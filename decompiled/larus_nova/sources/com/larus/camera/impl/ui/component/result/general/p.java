package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class p extends com.larus.camera.impl.ui.arch.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f322327o = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f322328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f322329n;

    public static final class a {
    }

    static {
    }

    public p() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
        this.f322328m = LazyKt.lazy(new o(this));
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r100, (ConstraintLayout) h(R.id.container), 0, null, 6, null);
        CameraResultViewModel r101 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.resultSupportMark() == true) goto L12;
        return;
    L12:
        if (AppHost.f326268a.isOversea() == true) goto L17;
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == false) goto L17;
        p().setText(R.string.larus_LarkIM_Chat_ImageSelectMark_Text);
    L17:
        if (r101.shouldUseMarkSelectMode() == false) goto L20;
        FLogger.f375446a.i("ResultMarkedTipsComponent", "initMarkedTipsView shouldUseMarkSelectMode");
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new kotlinx.coroutines.flow.v0(r101.isInMarkSelectMode(), r101.isInCropMode(), new ResultMarkedTipsComponent$initMarkedTipsView$1(null)), new ResultMarkedTipsComponent$initMarkedTipsView$2(r101, this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.getCurrentBitmap(), new ResultMarkedTipsComponent$initMarkedTipsView$3(r101, this, null)), k());
        return;
    L20:
        if (r101.enableResultDetect() == false) goto L22;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.getOnDetectResultChanged(), new ResultMarkedTipsComponent$initMarkedTipsView$4(this, null)), k());
    L23:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.isInCropMode(), new ResultMarkedTipsComponent$initMarkedTipsView$5(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.getCurrentBitmap(), new ResultMarkedTipsComponent$initMarkedTipsView$6(r101, this, null)), k());
        return;
    L22:
        r();
        goto L23
    }

    public final TextView p() {
        return (TextView) this.f322328m.getValue();
    }

    public final void q() {
        Job r100 = this.f322329n;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        p().clearAnimation();
        p().setAlpha(1.0f);
        com.larus.utils.e1.x(p());
        this.f322329n = BuildersKt.launch$default(k(), null, null, new ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1(this, null), 3, null);
    }

    public final void r() {
        p().setAlpha(1.0f);
        boolean r100 = com.larus.camera.impl.utils.l.f322789a;
        boolean r101 = com.larus.camera.impl.utils.l.f322789a;
        if (r101 == true) goto L5;
        com.larus.camera.impl.utils.l.f322789a = true;
    L5:
        FLogger.f375446a.i("ResultMarkedTipsComponent", "tryShowMarkedTips isAlreadyShow=" + r101);
        if (r101 == false) goto L8;
        com.larus.utils.e1.o(p());
        return;
    L8:
        q();
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
        return r100.inflate(R.layout.larus_layout_view_marked_tips_component, r101, false);
    }
}
