package lr;

import com.bytedance.android.ec.adapter.api.net.IECNetMonitorService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class c0 implements IECNetMonitorService {
    public c0() {
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final boolean canRecord() {
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final List<Object> interceptors() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final Object netMonitorInterceptor() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final JSONObject netReportParams(String r100, Long r101) {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final void preloadMonitorInterceptors() {
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final void reportECCommonNetRequestEvent(boolean r100, int r101, String r102, int r103, String r104, long r105, je.a r106, String r107) {
    }
}
