package com.larus.bmhome.chat.list.cell.video;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements hi9.a<u> {
    public y() {
    }

    @Override // hi9.a
    public final boolean a(ei9.f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof u) == true) goto L7;
        return false;
    L7:
        return !((u) r100).i();
    }

    @Override // hi9.a
    public final int b(ei9.f r100) {
        hi9.a.C6150a.a((u) r100);
        return 0;
    }
}
