package ny2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a implements f {
    public a() {
    }

    public abstract void b(JSONObject r100);

    @Override // ny2.f
    public JSONObject a() {
        JSONObject r100 = new JSONObject();
        b(r100);
        return r100;
    }
}
