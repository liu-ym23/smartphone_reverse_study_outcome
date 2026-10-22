package u15;

import com.bytedance.ee.bear.contract.d;
import du5.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final d a;
    public final Map<String, Object> b;

    /* JADX INFO: renamed from: u15.a$a, reason: collision with other inner class name */
    public static final class C0303a {
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
        tt5.a.h("EditImageAnalytic", r0.toString());
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

    public final void a(String r3, String r4) {
        ((HashMap) this.b).put("click", r3);
        ((HashMap) this.b).put("target", "none");
        Map<String, Object> r5 = this.b;
        HashMap r6 = (HashMap) r5;
        r6.put("object_id", b.g(r4));
        ((HashMap) this.b).put("object_file_type", "png");
        ((HashMap) this.b).put("preview_viable", 1);
        d r7 = this.a;
        if (r7 == null) goto L6;
        r7.n("ccm_drive_page_click", this.b);
        return;
    }
}
