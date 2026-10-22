package qx8;

import gx8.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f535165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535166b;

    @Override // gx8.d
    public final JSONObject a() {
        JSONObject r100 = this.f535165a;
        if (r100 == null) goto L6;
        r100.put("camera_type", this.f535166b);
        return r100;
    L6:
        return new JSONObject();
    }

    public b() {
        this.f535166b = "";
    }

    public static String b(String r100) {
        if (fx8.a.f479114e.contains(r100) == false) goto L6;
        return "edu";
    L6:
        if (fx8.a.f479111b.contains(r100) == false) goto L9;
        return "scan";
    L9:
        if (fx8.a.f479112c.contains(r100) == false) goto L11;
        return "health";
    L11:
        return "general";
    }
}
