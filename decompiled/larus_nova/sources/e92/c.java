package e92;

import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f471447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f471448b;

    public c(b r100) {
        this.f471447a = 0;
        this.f471448b = r100;
    }

    public static SeiAppData a(JSONObject r110) throws JSONException {
        SeiAppData r100 = new SeiAppData();
        r100.setTimestamp(r110.optLong("timestamp"));
        r100.setVersion(r110.optInt("ver"));
        r100.setStyle(r110.optInt("style"));
        r100.setVendor(r110.optString(Constants.OperatorKey.KEY_VENDOR));
        r100.setChannelId(r110.optString("channel_id"));
        r100.setSubScene(r110.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE));
        String r101 = r110.optString("grids");
        r100.setCount(r110.optLong("count", 0));
        r100.setEventParams(r110.optJSONObject("event_params"));
        JSONObject r111 = r110.optJSONObject("anchor_interact_info");     // Catch: Exception -> L36
        if (r111 == null) goto L6;
        AnchorInteractInfo r112 = new AnchorInteractInfo();     // Catch: Exception -> L36
        r112.setFocusID(r111.optString("focus_id"));     // Catch: Exception -> L36
        r112.setLayoutType(r111.optInt("layout_type"));     // Catch: Exception -> L36
        r112.setOwnerIndex(r111.optInt("owner_index"));     // Catch: Exception -> L36
        r100.setAnchorInteractInfo(r112);     // Catch: Exception -> L36
    L6:
        JSONArray r113 = new JSONArray(r101);     // Catch: Exception -> L36
        int r102 = r113.length();     // Catch: Exception -> L36
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L36
        int r115 = 0;
    L7:
        if (r115 >= r102) goto L34;
        JSONObject r116 = (JSONObject) r113.opt(r115);     // Catch: Exception -> L36
        int r117 = r102;
        JSONArray r118 = r113;
        int r119 = r115;
        SeiRegion r103 = new SeiRegion().setType(r116.optInt("type")).setX(r116.optDouble("x")).setY(r116.optDouble("y")).setWidth(r116.optDouble("w")).setHeight(r116.optDouble("h"));     // Catch: Exception -> L36
        r103.setAccount(r116.optLong("account"));     // Catch: Exception -> L36
        if (r116.has("p") == false) goto L12;
        r103.setPosition(r116.optInt("p"));     // Catch: Exception -> L36
    L12:
        if (r116.has("uid") == false) goto L15;
        r103.setUid(r116.optInt("uid"));     // Catch: Exception -> L36
    L15:
        if (r116.has("uid_str") == false) goto L18;
        r103.setUidStr(r116.optString("uid_str"));     // Catch: Exception -> L36
    L18:
        if (r116.has("talk") == false) goto L21;
        r103.setTalk(r116.optInt("talk"));     // Catch: Exception -> L36
    L21:
        if (r116.has("mute_audio") == false) goto L24;
        r103.setMuteAudio(r116.optInt("mute_audio"));     // Catch: Exception -> L36
    L24:
        if (r116.has("talk_volume") == false) goto L27;
        r103.setTalkVolume(r116.optInt("talk_volume"));     // Catch: Exception -> L36
    L27:
        if (r116.has("loading") == false) goto L33;
        boolean r120 = true;
        if (r116.optInt("loading") == 1) goto L32;
        r120 = false;
    L32:
        r103.setIsLocal(r120);     // Catch: Exception -> L36
    L33:
        r103.setStatus(r116.optInt(CloudControlInf.STAT));     // Catch: Exception -> L36
        r114.add(r103);     // Catch: Exception -> L36
        r115 = r119 + 1;     // Catch: Exception -> L36
        r113 = r118;
        r102 = r117;
        goto L7
    L34:
        r100.setGrids(r114);     // Catch: Exception -> L36
    L38:
        JSONObject r104 = r110.optJSONObject("canvas");
        if (r104 == null) goto L41;
        SeiCanvas r105 = new SeiCanvas();
        r105.setWidth(r104.optInt("width"));
        r105.setHeight(r104.optInt("height"));
        r105.setBackground(r104.optString("background"));
        r100.setCanvas(r105);
    L41:
        return r100;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    }
}
