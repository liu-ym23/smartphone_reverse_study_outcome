package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 implements t39.n {
    public p0() {
    }

    @Override // t39.n
    public final void e(int r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "productName");
        FLogger.f375446a.i("ThumbnailManager", "onDoraLinkChanged, state: " + r100 + ", productId: " + r101 + ", productName: " + r102 + ", fwVersion: " + r103);
        if (r100 != 0) goto L6;
        ThumbnailManager.f292767e.clear();
        ThumbnailManager.f292769g.clear();
        return;
    }
}
