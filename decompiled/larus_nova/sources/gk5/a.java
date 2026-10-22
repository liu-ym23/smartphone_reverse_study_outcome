package gk5;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    void onCancel();

    void onEvent(JSONObject r100);

    void onFailure(int r100, String r101);

    void onSuccess(JSONObject r100);
}
