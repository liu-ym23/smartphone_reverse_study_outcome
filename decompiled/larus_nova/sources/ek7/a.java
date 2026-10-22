package ek7;

import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.xbridge.XBridgeMethod;
import gk7.g;
import java.util.List;
import ll7.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public interface a {
    void dialogEnqueueShow(f r100);

    String getSDKVersionName();

    List<Class<? extends XBridgeMethod>> getXBridge();

    void handleFeedbackData(JSONObject r100);

    boolean isSDKPluginInited();

    void onDeviceIdUpdate(String r100);

    void onDogPluginReady(hk7.a r100, g r101);

    void onHostRouteFail(String r100);

    void onHostRouteStart(String r100);

    void onHostRouteSuccess(String r100);

    void onProcessPopupDialog(ll7.b r100, f r101, String r102);

    void onTokenSuccess(boolean r100);

    void registerBridgeV3(WebView r100, Lifecycle r101);

    void registerTimeTask(String r100, int r101);

    void showPopupDialog(f r100);

    void updateSettings(JSONObject r100);
}
