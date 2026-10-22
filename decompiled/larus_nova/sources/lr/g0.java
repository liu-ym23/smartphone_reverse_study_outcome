package lr;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.host.api.core.api.IECRouterService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class g0 implements IECRouterService {
    public g0() {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECRouterService
    public final boolean match(Uri r100, boolean r101) {
        return false;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECRouterService
    public final boolean open(Context r100, Uri r101, boolean r102, boolean r103) {
        return false;
    }
}
