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

/* JADX INFO: loaded from: classes.dex */
public interface ICronetClient {

    public interface ICronetBootFailureCheckerProvider {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetThreadStackOptFailureCheckerProvider {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    void addClientOpaqueData(String[] r100, byte[] r101, byte[] r102, long r103, long r104);

    void bindBigCore(TTNetThreadConfig.ThreadType r100) throws Exception;

    void bindLittleCore(TTNetThreadConfig.ThreadType r100) throws Exception;

    void clearClientOpaqueData();

    void enableTTBizHttpDns(boolean r100, String r101, String r102, String r103, boolean r104, String r105) throws Exception;

    int getCronetInternalErrorCode(HttpURLConnection r100);

    String getCronetVersion();

    int getEffectiveConnectionType() throws Exception;

    int getEffectiveHttpRttMs() throws Exception;

    int getEffectiveRxThroughputKbps() throws Exception;

    int getEffectiveTransportRttMs() throws Exception;

    Map<String, NetworkQuality> getGroupRttEstimates() throws Exception;

    void getMappingRequestState(String r100);

    NetworkQuality getNetworkQuality() throws Exception;

    int getNetworkQualityLevel() throws Exception;

    PacketLossMetrics getPacketLossRateMetrics(int r100) throws Exception;

    boolean isCronetHttpURLConnection(HttpURLConnection r100);

    void notifyStoreRegionUpdated(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111) throws Exception;

    void notifyTNCConfigUpdated(String r100, String r101, String r102, String r103, String r104, String r105) throws Exception;

    HttpURLConnection openConnection(Context r100, String r101, boolean r102, String r103, BaseHttpRequestInfo r104, ICronetAppProvider r105) throws IOException;

    void preconnectUrl(String r100, Map<String, String> r101) throws Exception;

    void removeClientOpaqueData(String r100);

    void reportNetDiagnosisUserLog(String r100) throws Exception;

    void resetCoreBind(TTNetThreadConfig.ThreadType r100) throws Exception;

    void runInBackGround(boolean r100);

    void setAlogFuncAddr(long r100) throws Exception;

    void setAppStartUpState(int r100) throws Exception;

    void setBestHostWithRouteSelectionName(String r100, String r101) throws Exception;

    void setCookieInitCompleted();

    void setCronetBootFailureCheckerProvider(ICronetBootFailureCheckerProvider r100);

    void setCronetThreadStackOptFailureCheckerProvider(ICronetThreadStackOptFailureCheckerProvider r100);

    void setHostResolverRules(String r100) throws Exception;

    void setHttpDnsForTesting(boolean r100, boolean r101, boolean r102) throws Exception;

    void setProxy(String r100) throws Exception;

    void setSlaSamplingSetting(JSONObject r100) throws Exception;

    void setZstdFuncAddr(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112) throws Exception;

    void startThrottle(String[] r100, int r101, long r102);

    void stopThrottle(String[] r100, int r101);

    void triggerGetDomain(boolean r100);

    void tryCreateCronetEngine(Context r100, boolean r101, boolean r102, boolean r103, boolean r104, String r105, boolean r106, ICronetAppProvider r107);

    void tryStartNetDetect(String[] r100, int r101, int r102) throws Exception;

    void ttDnsResolve(String r100, int r101, String r102, Map<String, String> r103) throws Exception;

    TTDispatchResult ttUrlDispatch(String r100, int r101, boolean r102) throws Exception;
}
