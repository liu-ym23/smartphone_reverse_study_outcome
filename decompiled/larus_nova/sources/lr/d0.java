package lr;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.adapter.api.pad.IECPadSplitOuterService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class d0 implements IECPadSplitOuterService {
    public d0() {
    }

    @Override // com.bytedance.android.ec.adapter.api.pad.IECPadSplitOuterService
    public final Uri handleWideScreenAdaptParams(Uri r100) {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.pad.IECPadSplitOuterService
    public final boolean isEnableWideScreenAdapt() {
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.pad.IECPadSplitOuterService
    public final boolean showInSplit(Context r100, Uri r101) {
        return false;
    }
}
