package os0;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f526492a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f526492a = new HashMap();
    }

    public final void a(JSONObject r100) {
        Map<String, String> r101 = this.f526492a;
        HashMap r102 = (HashMap) r101;
        r102.put("ad_extra_data", r100.toString());
    }

    public final void b(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        ((HashMap) this.f526492a).putAll(r100);
        return;
    }
}
