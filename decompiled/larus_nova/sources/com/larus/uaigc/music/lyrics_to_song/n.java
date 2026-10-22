package com.larus.uaigc.music.lyrics_to_song;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements hi9.a<g> {
    public n() {
    }

    @Override // hi9.a
    public final boolean a(ei9.f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (((g) r100).f563233a.getContentType() != 70) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // hi9.a
    public final int b(ei9.f r100) {
        hi9.a.C6150a.a((g) r100);
        return 0;
    }
}
