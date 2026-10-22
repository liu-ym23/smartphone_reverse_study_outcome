package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface ICronetClient {

    public interface ICronetBootFailureCheckerProvider {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetThreadStackOptFailureCheckerProvider {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    void addClientOpaqueData(String[] r1, byte[] r2, byte[] r3, long r4, long r6);

    void bindBigCore(TTNetThreadConfig.ThreadType r1) throws Exception;

    void bindLittleCore(TTNetThreadConfig.ThreadType r1) throws Exception;

    void clearClientOpaqueData();

    void enableTTBizHttpDns(boolean r1, String r2, String r3, String r4, boolean r5, String r6) throws Exception;

    int getCronetInternalErrorCode(HttpURLConnection r1);

    String getCronetVersion();

    int getEffectiveConnectionType() throws Exception;

    int getEffectiveHttpRttMs() throws Exception;

    int getEffectiveRxThroughputKbps() throws Exception;

    int getEffectiveTransportRttMs() throws Exception;

    Map<String, NetworkQuality> getGroupRttEstimates() throws Exception;

    void getMappingRequestState(String r1);

    NetworkQuality getNetworkQuality() throws Exception;

    int getNetworkQualityLevel() throws Exception;

    PacketLossMetrics getPacketLossRateMetrics(int r1) throws Exception;

    boolean isCronetHttpURLConnection(HttpURLConnection r1);

    void notifyStoreRegionUpdated(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) throws Exception;

    void notifyTNCConfigUpdated(String r1, String r2, String r3, String r4, String r5, String r6) throws Exception;

    HttpURLConnection openConnection(Context r1, String r2, boolean r3, String r4, BaseHttpRequestInfo r5, ICronetAppProvider r6) throws IOException;

    void preconnectUrl(String r1, Map<String, String> r2) throws Exception;

    void removeClientOpaqueData(String r1);

    void reportNetDiagnosisUserLog(String r1) throws Exception;

    void resetCoreBind(TTNetThreadConfig.ThreadType r1) throws Exception;

    void runInBackGround(boolean r1);

    void setAlogFuncAddr(long r1) throws Exception;

    void setAppStartUpState(int r1) throws Exception;

    void setBestHostWithRouteSelectionName(String r1, String r2) throws Exception;

    void setCookieInitCompleted();

    void setCronetBootFailureCheckerProvider(ICronetBootFailureCheckerProvider r1);

    void setCronetThreadStackOptFailureCheckerProvider(ICronetThreadStackOptFailureCheckerProvider r1);

    void setHostResolverRules(String r1) throws Exception;

    void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) throws Exception;

    void setProxy(String r1) throws Exception;

    void setSlaSamplingSetting(JSONObject r1) throws Exception;

    void setZstdFuncAddr(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15) throws Exception;

    void startThrottle(String[] r1, int r2, long r3);

    void stopThrottle(String[] r1, int r2);

    void triggerGetDomain(boolean r1);

    void tryCreateCronetEngine(Context r1, boolean r2, boolean r3, boolean r4, boolean r5, String r6, boolean r7, ICronetAppProvider r8);

    void tryStartNetDetect(String[] r1, int r2, int r3) throws Exception;

    void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) throws Exception;

    TTDispatchResult ttUrlDispatch(String r1, int r2, boolean r3) throws Exception;
}
