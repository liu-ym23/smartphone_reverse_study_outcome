package ny;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f521111d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f521112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f521113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f521114c;

    public static final class a {
        public static c a(JsonObject r100) {
            c r101 = new c();
            int r102 = 0;
            if (r100 == null) goto L7;
            JsonElement r103 = r100.get("width");
            if (r103 == null) goto L7;
            int r104 = r103.getAsInt();
        L8:
            r101.f521112a = r104;
            if (r100 == null) goto L13;
            JsonElement r105 = r100.get("height");
            if (r105 == null) goto L13;
            r102 = r105.getAsInt();
        L13:
            r101.f521113b = r102;
            if (r100 == null) goto L18;
            JsonElement r106 = r100.get("backgroundColor");
            if (r106 == null) goto L18;
            String r107 = r106.getAsString();
        L19:
            r101.f521114c = r107;
            return r101;
        L18:
            r107 = null;
        L7:
            r104 = 0;
            goto L8
        }
    }

    static {
    }

    public c() {
    }

    public final String toString() {
        return "Canvas(width=" + this.f521112a + ", height=" + this.f521113b + ", backgroundColor=" + this.f521114c + ')';
    }
}
