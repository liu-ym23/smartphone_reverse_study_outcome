package eh4;

import com.bytedance.crash.entity.Header;
import com.bytedance.crash.util.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f472653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Header f472654b;

    public a() {
        this.f472653a = new JSONObject();
        this.f472654b = new Header();
    }

    public final void a(String r100, Object r101) {
        j.h(this.f472653a, r100, r101);
    }

    public static void b(JSONObject r100, String r101, String r102, Object r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r104 = r100.optJSONObject(r101);
        if (r104 != null) goto L7;
        r104 = new JSONObject();
        j.h(r100, r101, r104);
    L7:
        j.h(r104, r102, r103);
    }
}
