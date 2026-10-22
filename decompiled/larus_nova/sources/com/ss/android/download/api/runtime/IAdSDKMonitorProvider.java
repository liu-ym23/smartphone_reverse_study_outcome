package com.ss.android.download.api.runtime;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.heytap.mcssdk.constant.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH&J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J*\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0019"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdSDKMonitorProvider;", "", "registerSDKMonitor", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "sdkAid", "", b.C, "", "extraHeads", "", "reportUrls", "", "configUrls", "ttMonitorDuration", "", "serviceName", "duration", "Lorg/json/JSONObject;", "logExtra", "ttMonitorEvent", "category", "metric", "ttMonitorStatusAndDuration", "status", "ttMonitorStatusRate", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAdSDKMonitorProvider {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SDKMonitor registerSDKMonitor$default(IAdSDKMonitorProvider r100, int r101, String r102, Map r110, List r111, List r112, int r113, Object r114) {
            if (r114 != null) goto L18;
            if ((r113 & 4) == 0) goto L6;
            Map r103 = null;
        L8:
            if ((r113 & 8) == 0) goto L10;
            List r104 = null;
        L12:
            if ((r113 & 16) == 0) goto L14;
            List r105 = null;
        L16:
            return r100.registerSDKMonitor(r101, r102, r103, r104, r105);
        L14:
            r105 = r112;
            goto L16
        L10:
            r104 = r111;
            goto L12
        L6:
            r103 = r110;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerSDKMonitor");
        }
    }

    SDKMonitor registerSDKMonitor(int r100, String r101, Map<String, String> r102, List<String> r103, List<String> r104);

    void ttMonitorDuration(String r100, JSONObject r101, JSONObject r102);

    void ttMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void ttMonitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void ttMonitorStatusRate(String r100, int r101, JSONObject r102);
}
