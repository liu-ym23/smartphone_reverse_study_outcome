package r1;

import com.apm.lite.ICommonParams;
import com.apm.lite.MonitorCrash;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes39.dex */
public final class h implements ICommonParams {
    public h() {
    }

    @Override // com.apm.lite.ICommonParams
    public final Map<String, Object> getCommonParams() {
        return new HashMap();
    }

    @Override // com.apm.lite.ICommonParams
    public final String getDeviceId() {
        ConcurrentHashMap<String, MonitorCrash> r100 = com.apm.lite.d.f29907b;
        return "";
    }

    @Override // com.apm.lite.ICommonParams
    public final List<String> getPatchInfo() {
        return null;
    }

    @Override // com.apm.lite.ICommonParams
    public final Map<String, Integer> getPluginInfo() {
        return null;
    }

    @Override // com.apm.lite.ICommonParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.apm.lite.ICommonParams
    public final long getUserId() {
        return 0;
    }
}
