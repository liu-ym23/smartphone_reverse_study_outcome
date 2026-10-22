package xc8;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements hi9.a<ei9.f> {
    public j() {
    }

    @Override // hi9.a
    public final boolean a(ei9.f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return true;
    }

    @Override // hi9.a
    public final int b(ei9.f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return 0;
    }
}
