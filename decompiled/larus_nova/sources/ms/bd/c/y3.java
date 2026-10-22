package ms.bd.c;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class y3 implements SDKMonitor.IGetExtendParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f515442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f515443b;

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final Map getCommonParams() {
        HashMap r100 = new HashMap();
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ffa594", new byte[]{120, 114, 23, 83, 21, 38, 100});     // Catch: JSONException -> L9
        if (JSONObjectProtectorUtils.getBoolean(this.f515442a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "37a3b2", new byte[]{45, 35, 23, 85, 78, 32, 49})) == false) goto L6;
        Object r102 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1f64af", new byte[]{113});     // Catch: JSONException -> L9
    L7:
        r100.put(r101, (String) r102);     // Catch: JSONException -> L9
    L10:
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ecc023", new byte[]{124, 110, 3, 80, 50, 37, 111, 70}), this.f515443b);
        return r100;
    L6:
        r102 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "515e11", new byte[]{116});     // Catch: JSONException -> L9
    L9:
        String r103 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9ad9f4", new byte[]{59, 102, 26, 114, 94, 48});
        goto L10
    }

    public y3(JSONObject r100, String r101) {
        this.f515442a = r100;
        this.f515443b = r101;
    }
}
