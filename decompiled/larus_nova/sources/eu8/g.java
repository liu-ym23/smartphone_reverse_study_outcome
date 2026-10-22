package eu8;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f474106a;

    @Override // eu8.d
    public final Object execute() {
        if (this.f474106a == null) goto L14;
        JSONObject r100 = new JSONObject();
        nu8.a.d(String.format("Exe cmd %s", new Object[]{this.f474106a.toString()}));
        Object r101 = this.f474106a.execute();
        r100.put("cmd", this.f474106a.toString());     // Catch: JSONException -> L7
        r100.put("result", r101.toString());     // Catch: JSONException -> L7
    L9:
        nu8.a.d(String.format("Exe cmd %s result %s", new Object[]{this.f474106a.toString(), r101.toString()}));
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L14:
        return null;
    }

    public g(a r100) {
        this.f474106a = r100;
    }
}
