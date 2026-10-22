package fi9;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements hi9.a<f> {
    public b() {
    }

    @Override // hi9.a
    public final boolean a(f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return true;
    }

    @Override // hi9.a
    public final int b(f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return 0;
    }
}
