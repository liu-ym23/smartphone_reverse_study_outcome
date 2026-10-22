package com.bytedance.locallife.poi.media.layer;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.locallife.poi.media.api.PlayerLayerPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends AbsLynxLayer {
    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void p() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void q() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void r() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void s() {
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final void t() {
    }

    @Override // hy6.d
    public final int j() {
        return PlayerLayerPosition.POSITION_STICKY_HEADER.getPosition();
    }

    @Override // com.bytedance.locallife.poi.media.layer.AbsLynxLayer
    public final ViewGroup.LayoutParams l() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
    }
}
