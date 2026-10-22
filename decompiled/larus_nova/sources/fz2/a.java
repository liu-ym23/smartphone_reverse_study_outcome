package fz2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {
    public a() {
    }

    public abstract void fillInJsonObject(JSONObject r100);

    public JSONObject toJsonObject() {
        JSONObject r100 = new JSONObject();
        fillInJsonObject(r100);
        return r100;
    }
}
