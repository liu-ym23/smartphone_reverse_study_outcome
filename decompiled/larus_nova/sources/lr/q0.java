package lr;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class q0 implements IEntranceInfoService {
    public q0() {
    }

    @Override // com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService
    public final List<String> fetchFilteredEntranceInfo(List<String> r100) {
        return null;
    }

    @Override // com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService
    public final String filterEntranceInfoInLocalTest(String r100) {
        return "";
    }

    @Override // com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService
    public final gl.a initEntranceInfo(EntranceInfoScene r100, String r101) {
        return null;
    }
}
