package com.larus.camera.impl.ui.component.capture.scan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.i0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import v19.j5;

/* JADX INFO: loaded from: classes26.dex */
public final class ScanCaptureTipComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f322027m;

    public ScanCaptureTipComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321811b, 1);
        this.f322027m = fx8.a.f479111b;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        ((TextView) h(R.id.tip_text)).setText(j5.a(getContext(), R.string.app_string_name_dola_url, R.string.larus_dola_Login_with_QR_code_scan_tip_cc_global));
    L6:
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L9;
        return;
    L9:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getCaptureModeStatus(), new ScanCaptureTipComponent$onViewCreated$1(this, null)), k());
        return;
    L5:
        ((TextView) h(R.id.tip_text)).setVisibility(8);
        goto L6
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f322027m;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = new CameraContainer.b(-1, -1);
        ((FrameLayout.LayoutParams) r101).gravity = 17;
        i0.f375410a.getClass();
        ((ViewGroup.MarginLayoutParams) r101).bottomMargin = i0.e();
        return r101;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = r100.inflate(R.layout.larus_layout_view_scan_tip_component, r101, false);
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tip_text)) == null) goto L7;
        return (ConstraintLayout) r102;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.tip_text)));
    }
}
