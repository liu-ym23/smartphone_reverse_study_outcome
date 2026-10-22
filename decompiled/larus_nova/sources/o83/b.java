package o83;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f522363f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f522364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f522365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f522366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f522367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f522368e;

    public static final class a {
        public static JSONObject a(JSONObject r100, boolean r101) {
            if (r100 != null) goto L5;
            return null;
        L5:
            JSONObject r102 = new JSONObject();
            r102.put("id", r100.opt("id"));
            r102.put("address_type", r100.opt("address_type"));
            r102.put("extra", r100.opt("extra"));
            if (r101 == false) goto L8;
            r102.put("log_extra", r100.opt("log_extra"));
        L8:
            return r102;
        }
    }

    static {
    }

    public b(JSONObject r100, boolean r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r101 = false;
    L8:
        this.f522364a = r100;
        this.f522365b = null;
        this.f522366c = 0;
        this.f522367d = r101;
        this.f522368e = r102;
    }
}
