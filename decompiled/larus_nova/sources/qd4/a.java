package qd4;

import android.content.Intent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface a {
    void closeWebView(int r100);

    void closeWebviews(List<String> r100);

    void disableHistory();

    void executeBackBlock(String r100, String r101, int r102, String r103, String r104, String r105);

    String getAppId();

    Object getHostInfo();

    HashMap<String, JSONObject> getMegaJSONObjectMap();

    String getMerchantId();

    String getSchema();

    Map<String, String> getSecurityHeader();

    String getUrl();

    Intent getViewOpenIntent(Object r100, Object r101);

    void hideLoadingView();

    boolean isHybridkitKernel();

    boolean isSaasPage();

    boolean isSupportScheme(String r100);

    void loginFailure(ld4.a r100);

    void notifyEvent(kd4.a r100);

    void onExecuteCloseCallback(String r100);

    void openPageByscheme(Object r100);

    void sendPageStatus(int r100, String r101, String r102);

    void setBlockNativeBack();

    void showLoadingView();

    void upateSwitchDragback(int r100);

    void updateWebViewVisibility();

    void updateWebviewInfo(String r100);

    Map<String, String> updateWebviewTitle(String r100, String r101);
}
