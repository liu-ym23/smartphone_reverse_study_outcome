package g64;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements o64.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SDKMonitor f480160a;

    /* JADX INFO: renamed from: g64.a$a, reason: collision with other inner class name */
    public class C5989a implements SDKMonitor.IGetExtendParams {
        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final String getSessionId() {
            return null;
        }

        public C5989a() {
        }
    }

    public a(Context r100, String r101, JSONObject r102, List<String> r103) {
        SDKMonitorUtils.setConfigUrl(r101, r103);
        ArrayList r104 = new ArrayList();
        r104.add(ReportConstant.DEFAULT_URL_REPORT);
        SDKMonitorUtils.setDefaultReportUrl(r101, r104);
        SDKMonitorUtils.initMonitor(r100, r101, r102, new C5989a());
        this.f480160a = SDKMonitorUtils.getInstance(r101);
    }
}
