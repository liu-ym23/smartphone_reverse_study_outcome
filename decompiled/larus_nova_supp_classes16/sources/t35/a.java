package t35;

import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final d a;
    public final Map<String, Object> b;

    /* JADX INFO: renamed from: t35.a$a, reason: collision with other inner class name */
    public static final class C0295a {
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
        tt5.a.h("ShareWordsAnalytic", r0.toString());
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
        tt5.a.b("ShareWordsAnalytic", "reportEventV2: event = " + r3 + ", params = " + r4);
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.n(r3, r4);
        return;
    }

    public final void b(String r6, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r6, "loadStage");
        long r0 = System.currentTimeMillis();
        HashMap r2 = new HashMap();
        r2.put(JSEventListener.ACTION, "send_im_load_stage");
        r2.put("load_stage", r6);
        r2.put("total_run_time", Long.valueOf(r0 - r7));
        if (r9 <= 0) goto L5;
        r2.put("run_time", Long.valueOf(r0 - r9));
    L5:
        a("ccm_docx_send_im_dev", r2);
    }
}
