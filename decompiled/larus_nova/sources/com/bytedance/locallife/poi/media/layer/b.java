package com.bytedance.locallife.poi.media.layer;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.locallife.poi.media.api.PlayerLayerPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends AbsLynxLayer {
    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void p() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void q() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void s() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void t() {
    }

    @Override // hy6.d
    public final int j() {
        return PlayerLayerPosition.POSITION_INFO.getPosition();
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final ViewGroup.LayoutParams l() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -2);
        r100.gravity = 80;
        return r100;
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void r() {
        iy6.c r100 = this.f262675f;
        if (r100 == null) goto L8;
        iy6.d r101 = r100.b();
        if (r101 == null) goto L9;
        f(r101);
        return;
    L9:
        return;
    }

    public b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
    }
}
