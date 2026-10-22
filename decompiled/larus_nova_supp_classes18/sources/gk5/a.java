package gk5;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void onCancel();

    void onEvent(JSONObject r1);

    void onFailure(int r1, String r2);

    void onSuccess(JSONObject r1);
}
