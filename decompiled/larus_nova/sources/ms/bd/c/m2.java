package ms.bd.c;

import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface m2 {
    Map frameSign(String r100, int r101);

    Map getFeatureHash(String r100, byte[] r101);

    Map getReportRaw(String r100, int r101, Map r102);

    String getToken();

    void postEventMessage(MSManagerUtils.MSBusinessHelper r100);

    void qurryMsRiskInfo(String r100, MSManagerUtils.IMsBundleCallback r101);

    void report(String r100, String r101);

    void setBDDeviceID(String r100);

    void setCollectMode(int r100);

    void setCustomInfo(Map r100, boolean r101);

    void setDeviceID(String r100);

    void setInstallID(String r100);

    void setMsSettingConfig(String r100);

    void setSessionID(String r100);
}
