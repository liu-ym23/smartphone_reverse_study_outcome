package com.ss.ugc.live.barrage.barrage;

import com.ss.ugc.live.barrage.controller.ScrollBarrageController;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends e implements ScrollBarrageController.e, ScrollBarrageController.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f458086v;

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.e
    public final void e() {
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.d
    public final boolean a() {
        float r100 = 0;
        if ((this.f458058f.right + r100) <= r100) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.e
    public final int[] b() {
        int[] r100 = this.f458086v;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new int[0];
    }
}
