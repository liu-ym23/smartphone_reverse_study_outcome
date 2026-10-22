package g05;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final d a;
    public final Map<String, Object> b;

    /* JADX INFO: renamed from: g05.a$a, reason: collision with other inner class name */
    public static final class C0231a {
    }

    static {
    }

    public a(d r4) {
        this.a = r4;
        this.b = new HashMap();
        StringBuilder r0 = new StringBuilder("analyticService null: ");
        if (r4 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("AssociatedAnalytic", r0.toString());
        if (r4 == null) goto L9;
        HashMap<String, Object> r5 = r4.m("docCommonParams");
    L10:
        if (r5 == null) goto L15;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Map.Entry<String, Object> r2 = r6.next();
        this.b.put(r2.getKey(), r2.getValue());
        goto L13
    L17:
        return;
    L15:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final void a(String r3, Map<String, Object> r4) {
        ((HashMap) r4).putAll(this.b);
        tt5.a.b("AssociatedAnalytic", "reportEventV2: event = " + r3 + ", params = " + r4);
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.n(r3, r4);
        return;
    }
}
