package z67;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void onRequestFailed(String r100, String r101, String r102, String r103, long r104);

    void onRequestFailed(String r100, String r101, String r102, String r103, long r104, JSONObject r105);

    void onRequestSuccess(String r100, String r101, String r102, long r103);

    void onRequestSuccess(String r100, String r101, String r102, long r103, JSONObject r104);
}
