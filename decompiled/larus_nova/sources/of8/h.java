package of8;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements hi9.a<i> {
    public h() {
    }

    @Override // hi9.a
    public final boolean a(ei9.f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return true;
    }

    @Override // hi9.a
    public final int b(ei9.f r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return r101.e() + 1;
    }
}
