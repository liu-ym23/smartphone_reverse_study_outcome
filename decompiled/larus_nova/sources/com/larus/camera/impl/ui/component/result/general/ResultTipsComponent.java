package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class ResultTipsComponent extends com.larus.camera.impl.ui.arch.b {
    public ResultTipsComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getOnDetectResultChanged(), new ResultTipsComponent$onViewCreated$1(this, null)), k());
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
        return r100.inflate(R.layout.larus_layout_view_preview_tips_component, r101, false);
    }
}
