package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class q0 implements b98.d {
    public q0() {
    }

    @Override // b98.d
    public final void a(int r100, int r101) {
        FLogger.f375446a.i("ThumbnailManager", "Dora scene state changed, scene=" + r100 + ", state=" + r101);
        if (CollectionsKt.listOf(new Integer[]{1, 5, 4, 7}).contains(Integer.valueOf(r100)) == false) goto L8;
        if (r101 != 2) goto L9;
        ThumbnailManager r102 = ThumbnailManager.f292763a;
        ThumbnailManager.s("Exit FlowDoraScene(" + r100 + ')');
        return;
    L9:
        return;
    }
}
