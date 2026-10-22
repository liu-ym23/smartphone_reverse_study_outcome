package lr;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class l0 implements IECUserTrackerService {
    public l0() {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void enterPage(of.b r100) {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void leavePage(of.b r100) {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final of.a getMarketingService() {
        return new k0();
    }
}
