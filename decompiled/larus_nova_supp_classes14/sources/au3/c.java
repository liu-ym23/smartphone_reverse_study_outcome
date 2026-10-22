package au3;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import pu3.a;
import xu3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends a {
    public final int b;
    public final List<String> c;
    public final boolean d;

    public final JSONObject d() {
        return null;
    }

    public final String f() {
        return "fd";
    }

    public final boolean isValid() {
        return true;
    }

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("fd_count", this.b);     // Catch: Exception -> L19
        if (e.b(this.c) == true) goto L18;
        List<String> r2 = this.c;     // Catch: Exception -> L19
        if (r2 != null) goto L8;
        String r3 = null;
    L17:
        r0.put("fd_detail", r3);     // Catch: Exception -> L19
        goto L18
    L8:
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L19
        Iterator<String> r5 = r2.iterator();     // Catch: Exception -> L19
        boolean r6 = true;
    L10:
        if (r5.hasNext() == false) goto L16;
        String r7 = r5.next();     // Catch: Exception -> L19
        if (r6 == false) goto L14;
        r6 = false;
    L15:
        r4.append(r7.toString());     // Catch: Exception -> L19
        goto L10
    L14:
        r4.append("\n");     // Catch: Exception -> L19
        goto L15
    L16:
        r3 = r4.toString();     // Catch: Exception -> L19
    L18:
        return r0;
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("scene", ou3.a.a().e());     // Catch: Throwable -> L4
        r0.put("process_name", du3.a.e());     // Catch: Throwable -> L4
        r0.put("is_main_process", du3.a.o());     // Catch: Throwable -> L4
    L5:
        if (r0 == null) goto L12;
    L7:
        r0.put("is_front", this.d);     // Catch: Exception -> L9
    L8:
        return r0;
    L12:
        r0 = new JSONObject();     // Catch: Exception -> L9
    L4:
        r0 = null;
        goto L5
    }

    public final JSONObject e() {
        return ou3.a.a().b();
    }

    public c(int r1, List<String> r2, boolean r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
