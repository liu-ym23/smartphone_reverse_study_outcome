package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public class CaptureTitleComponent extends com.larus.camera.impl.ui.base.k implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f321866m;

    public void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "captureMode");
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public void m() {
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getCaptureModeStatus(), new CaptureTitleComponent$onViewCreated$1(this, null)), k());
        if (r100.multiCaptureStatusFlow().getValue().booleanValue() == false) goto L8;
        p(new h2(r100));
    L9:
        s(r100);
        Function1 r101 = new j2();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(h(R.id.title_ic));
        Function1 r102 = new k2();
        Intrinsics.checkNotNullParameter(r102, "config");
        r102.invoke(h(R.id.title_bold));
        Function1 r103 = new l2();
        Intrinsics.checkNotNullParameter(r103, "config");
        r103.invoke(h(R.id.title));
        CameraData r104 = r100.getCameraData();
        if (r104.getEnableCaptureTitle() == false) goto L18;
        final String r105 = r104.getCameraNameUrl();
        if (com.larus.utils.o0.d(r105) == false) goto L15;
        Function1 r106 = new m2(r105);
        Intrinsics.checkNotNullParameter(r106, "config");
        r106.invoke(h(R.id.title_ic));
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r100, "doubao_camera", null, 2, null);
        goto L18
    L15:
        final String r107 = r104.getCameraName();
        if (com.larus.utils.o0.d(r107) == false) goto L18;
        Function1 r108 = new n2(r107);
        Intrinsics.checkNotNullParameter(r108, "config");
        r108.invoke(h(R.id.title_bold));
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r100, "doubao_camera", null, 2, null);
    L18:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getOnOrientationChanged(), new CaptureTitleComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.multiCaptureStatusFlow(), new CaptureTitleComponent$onViewCreated$3(this, r100, null)), k());
        return;
    L8:
        p(new i2(r100));
        goto L9
    }

    public CaptureTitleComponent() {
        List<String> r100 = fx8.a.f479110a;
        this.f321866m = CollectionsKt.plus(fx8.a.f479110a, fx8.a.f479112c);
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public List<String> d() {
        return this.f321866m;
    }

    public void s(final CameraCaptureViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        r100.initFlashStatus();
        q(new c2(r100, this));
    }
}
