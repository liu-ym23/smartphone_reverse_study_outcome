package sx5;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    void onStoreIdcChanged(String r100, String r101, String r102, String r103, String r104, String r105);

    void sendFeedbackLog(String r100, String r101);

    boolean updateTncConfig(JSONObject r100, String r101, String r102, boolean r103);
}
