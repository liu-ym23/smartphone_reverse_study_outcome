package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements ny8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ky8.d f323328a;

    @Override // ny8.c
    public final void onCancel() {
        FLogger.f375446a.i("CanvasGenerator", "onCancel, localId = " + this.f323328a.f506692a);
        this.f323328a.f506695d.onCancel();
    }

    public e(ky8.d r100) {
        this.f323328a = r100;
    }

    @Override // ny8.c
    public final void a(List<CanvasBlock> r100) {
        Intrinsics.checkNotNullParameter(r100, "canvasBlocks");
        FLogger.f375446a.i("CanvasGenerator", "onUpdate, localId = " + this.f323328a.f506692a);
        this.f323328a.f506695d.a(r100);
    }

    @Override // ny8.c
    public final void b(List<CanvasBlock> r100) {
        Intrinsics.checkNotNullParameter(r100, "canvasBlocks");
        FLogger.f375446a.i("CanvasGenerator", "onFinish, localId = " + this.f323328a.f506692a);
        h r101 = h.f323332a;
        ky8.d r102 = this.f323328a;
        h.d(r102.f506692a, r102.f506695d, r100);
    }

    @Override // ny8.c
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("CanvasGenerator", "onError, localId = " + this.f323328a.f506692a + ", code = " + r100 + ", msg = " + r101);
        this.f323328a.f506695d.onError(r100, r101);
    }
}
