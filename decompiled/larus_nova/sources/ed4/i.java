package ed4;

import android.net.Uri;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface i {
    void onDataUpdated(g r100);

    void onFirstLoadPerfReady(g r100, JSONObject r101);

    void onFirstScreen(g r100);

    void onLoadFail(Uri r100, Throwable r101, g r102);

    void onLoadFailed(g r100, e r101);

    void onLoadStart(Uri r100, g r101);

    void onLoadUriSuccess(Uri r100, g r101);

    void onModuleMethodInvoked(String r100, String r101, int r102);

    void onPageStart(g r100, String r101);

    void onPageUpdate(g r100);

    void onReceivedError(g r100, e r101);

    void onRuntimeReady(g r100);

    void onTimingSetup(Map<String, Object> r100);

    void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102);

    void onUpdatePerfReady(g r100, JSONObject r101);

    String shouldRedirectImageUrl(String r100);
}
