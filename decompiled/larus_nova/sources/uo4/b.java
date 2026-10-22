package uo4;

import com.bytedance.ee.bear.bitable.baseadd.model.SubmitPollStrategy;
import com.bytedance.ee.bear.bitable.baseadd.model.SubmitRecordData;
import com.bytedance.ee.bear.bitable.baseadd.model.SubmitRecordResponse;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements NetService.c<SubmitRecordResponse> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L27:
        e = move-exception;
        tt5.a.e("BaseAddSubmitParser", "parse err ", e, false);
        throw new NetService.ParseException();
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L27
        if (r101 != null) goto L9;
        r101 = new JSONObject();     // Catch: Exception -> L27
    L9:
        JSONObject r102 = r101.optJSONObject("pollStrategy");     // Catch: Exception -> L27
        SubmitPollStrategy r103 = new SubmitPollStrategy();     // Catch: Exception -> L27
        int r104 = 1;
        if (r102 == null) goto L12;
        r104 = r102.optInt(VideoThumbInfo.KEY_INTERVAL, 1);     // Catch: Exception -> L27
    L12:
        r103.setInterval(r104);     // Catch: Exception -> L27
        int r105 = 5;
        if (r102 == null) goto L15;
        r105 = r102.optInt("maxCount", 5);     // Catch: Exception -> L27
    L15:
        r103.setMaxCount(r105);     // Catch: Exception -> L27
        JSONArray r106 = r101.optJSONArray("permittedFields");     // Catch: Exception -> L27
        ArrayList<String> r107 = new ArrayList();     // Catch: Exception -> L27
        if (r106 == null) goto L20;
        int r108 = r106.length();     // Catch: Exception -> L27
        int r109 = 0;
    L18:
        if (r109 >= r108) goto L20;
        r107.add(JSONArrayProtectorUtils.getString(r106, r109));     // Catch: Exception -> L27
        r109 = r109 + 1;     // Catch: Exception -> L27
    L20:
        JSONArray r110 = r101.optJSONArray("changedFields");     // Catch: Exception -> L27
        ArrayList<String> r111 = new ArrayList();     // Catch: Exception -> L27
        if (r110 == null) goto L25;
        int r112 = r110.length();     // Catch: Exception -> L27
        int r113 = 0;
    L23:
        if (r113 >= r112) goto L25;
        r111.add(JSONArrayProtectorUtils.getString(r110, r113));     // Catch: Exception -> L27
        r113 = r113 + 1;     // Catch: Exception -> L27
    L25:
        SubmitRecordData r114 = new SubmitRecordData();     // Catch: Exception -> L27
        r114.setRecordID(r101.optString("recordID"));     // Catch: Exception -> L27
        r114.setTaskID(Integer.valueOf(r101.optInt(com.heytap.mcssdk.constant.b.f276354d)));     // Catch: Exception -> L27
        r114.setTaskIDStr(r101.optString("taskIDStr"));     // Catch: Exception -> L27
        r114.setPollStrategy(r103);     // Catch: Exception -> L27
        r114.setPermittedFields(r107);     // Catch: Exception -> L27
        r114.setChangedFields(r111);     // Catch: Exception -> L27
        return new SubmitRecordResponse(r114);
    }
}
