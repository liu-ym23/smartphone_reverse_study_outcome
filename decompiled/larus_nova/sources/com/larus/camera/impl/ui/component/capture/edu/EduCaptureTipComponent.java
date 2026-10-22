package com.larus.camera.impl.ui.component.capture.edu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.EduCaptureTipView;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class EduCaptureTipComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EduCaptureTipView f321895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f321896n;

    public EduCaptureTipComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321811b, 1);
        this.f321896n = fx8.a.f479113d;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r100, (ConstraintLayout) h(R.id.camera_container), 0, null, 6, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getCaptureModeStatus(), new EduCaptureTipComponent$onViewCreated$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getOnOrientationChanged(), new EduCaptureTipComponent$onViewCreated$2(this, null)), k());
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f321896n;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = new CameraContainer.b(-1, -1);
        ((FrameLayout.LayoutParams) r101).gravity = 17;
        return r101;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        com.larus.camera.impl.utils.u.a();
        View r102 = r100.inflate(R.layout.larus_layout_view_edu_capture_tip_component, r101, false);
        int r103 = R.id.bottom_line;
        if (((Guideline) ViewBindings.findChildViewById(r102, R.id.bottom_line)) == null) goto L16;
        ConstraintLayout r104 = (ConstraintLayout) r102;
        EduCaptureTipView r105 = (EduCaptureTipView) ViewBindings.findChildViewById(r102, R.id.edu_tip_view);
        if (r105 != null) goto L7;
        r103 = R.id.edu_tip_view;
        goto L16
    L7:
        if (((FrameLayout) ViewBindings.findChildViewById(r102, R.id.tip_view_container)) != null) goto L9;
        r103 = R.id.tip_view_container;
        goto L16
    L9:
        if (((Guideline) ViewBindings.findChildViewById(r102, R.id.top_line)) == null) goto L12;
        this.f321895m = r105;
        return r104;
    L12:
        r103 = R.id.top_line;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
