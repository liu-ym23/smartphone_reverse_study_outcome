package j96;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f497791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f497792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f497793c;

    public b(JSONObject r100, c r101, e r102) {
        this.f497792b = r101;
        this.f497793c = r102;
        this.f497791a = new HashMap();
        if (r100 == null) goto L5;
        Iterator<String> r103 = r100.keys();
    L6:
        if (r103 == null) goto L10;
        if (r103.hasNext() != true) goto L14;
        String r104 = r103.next();
        String r105 = r100.optString(r104);
        this.f497791a.put(r104, r105);
        goto L6
    L14:
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
