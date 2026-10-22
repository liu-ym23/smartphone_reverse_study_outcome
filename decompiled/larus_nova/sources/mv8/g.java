package mv8;

import com.bytedance.android.btm.api.BtmSDK;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements zc.c {
    public g() {
    }

    @Override // zc.c
    public void onEventV1(com.bytedance.android.btm.api.model.j r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    @Override // zc.c
    public void onEventV3(com.bytedance.android.btm.api.model.k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r101 = r100.f42066a;
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.android.btm.api.model.k r102 = new com.bytedance.android.btm.api.model.k(r101, r100.f42067b);
        com.bytedance.android.btm.api.model.k r103 = BtmSDK.INSTANCE.addBtmEventParam(r102);
        o r104 = o.f365780a;
        String r105 = r103.f42066a;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r104.reportEvent(r105, r103.f42067b);
    }
}
