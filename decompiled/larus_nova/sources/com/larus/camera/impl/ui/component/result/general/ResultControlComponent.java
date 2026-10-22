package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public class ResultControlComponent extends com.larus.camera.impl.ui.base.j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f322140n = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ResultConfirmControlStyle f322141m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        new f(j(), getContext(), k(), r(), new g(this)).a();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.isInCropMode(), new ResultControlComponent$onViewCreated$2(this, null)), k());
    }

    public ResultControlComponent() {
        this.f322141m = ResultConfirmControlStyle.GENERAL;
    }

    public ResultConfirmControlStyle r() {
        return this.f322141m;
    }
}
