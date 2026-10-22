package zf9;

import android.net.Uri;
import com.bytedance.apm.ApmAgent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.larus.utils.y0;
import com.optimize.statistics.FrescoMonitorConst;
import com.optimize.statistics.ImageTraceListener;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements ImageTraceListener {
    public t() {
    }

    @Override // com.optimize.statistics.ImageTraceListener
    public final void imageNetCallBack(long r100, long r101, String r102, HttpRequestInfo r103, Throwable r104, JSONObject r105) {
    }

    @Override // com.optimize.statistics.ImageTraceListener
    public final void onImageLoaded(boolean r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        JSONObject r103 = r102.optJSONObject(FrescoMonitorConst.IMAGEX_CUSTOM_PARAM);     // Catch: Exception -> L12
        if (r103 != null) goto L6;
        r103 = new JSONObject();     // Catch: Exception -> L12
    L6:
        Uri r104 = y0.j(r102.optString("uri"));     // Catch: Exception -> L12
        if (r104 == null) goto L9;
        r103.put("rcl", UriProtector.getQueryParameter(r104, "rcl"));     // Catch: Exception -> L12
        r103.put("rrcfp", UriProtector.getQueryParameter(r104, "rrcfp"));     // Catch: Exception -> L12
        r103.put("lrcfp", UriProtector.getQueryParameter(r104, "lrcfp"));     // Catch: Exception -> L12
    L9:
        r102.put(FrescoMonitorConst.IMAGEX_CUSTOM_PARAM, r103);     // Catch: Exception -> L12
    L10:
        ApmAgent.monitorCommonLog(FrescoMonitorConst.MONITOR_IMAGE_V2, r102);
    }
}
