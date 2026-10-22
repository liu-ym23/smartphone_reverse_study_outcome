package my5;

import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.event.AdEventHandler;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f516387a = 0;

    static {
    }

    public static void b(Map r100) {
        AdDownloadModel r101 = new AdDownloadModel.Builder().setIsAd(false).build();
        AdDownloadEventConfig r102 = new AdDownloadEventConfig.Builder().setClickButtonTag("game_res").setClickItemTag("game_res").setIsEnableV3Event(true).setIsEnableClickEvent(false).build();
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L16
        Iterator r104 = r100.entrySet().iterator();     // Catch: Throwable -> L16
    L5:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L16
        if (((CharSequence) r105.getKey()).length() <= 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L5;
        if (r105.getValue() == null) goto L5;
        r103.putOpt((String) r105.getKey(), r105.getValue());     // Catch: Throwable -> L16
        goto L5
    L9:
        r106 = false;
        goto L10
    L14:
        r103.put("biz_type", "douyingame");     // Catch: Throwable -> L16
        r103.put("product_type", BaseConstants.GAME_INFO_LIVE_UNION);     // Catch: Throwable -> L16
        AdEventHandler.getInstance().sendEvent("game_res", "pre_download_remove_res", r103, r101, r102, new AdDownloadController.Builder().build());     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(String r110, String r111, int r112) {
        AdDownloadModel r100 = new AdDownloadModel.Builder().setIsAd(false).build();
        AdDownloadEventConfig r101 = new AdDownloadEventConfig.Builder().setClickButtonTag("game_res").setClickItemTag("game_res").setIsEnableV3Event(true).setIsEnableClickEvent(false).build();
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L8
        if (r111 == null) goto L6;
        JSONObject r103 = new JSONObject(r111);     // Catch: Throwable -> L8
        r102.put("game_id", r103.optString("game_id"));     // Catch: Throwable -> L8
        r102.put("type", r103.optInt("type"));     // Catch: Throwable -> L8
    L6:
        r102.put("fail_reason", r112);     // Catch: Throwable -> L8
        r102.put("biz_type", "douyingame");     // Catch: Throwable -> L8
        r102.put("product_type", BaseConstants.GAME_INFO_LIVE_UNION);     // Catch: Throwable -> L8
        AdEventHandler.getInstance().sendEvent("game_res", r110, r102, r100, r101, new AdDownloadController.Builder().build());     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }
}
