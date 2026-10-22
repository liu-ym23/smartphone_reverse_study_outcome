package t35;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f544438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f544439b;

    /* JADX INFO: renamed from: t35.a$a, reason: collision with other inner class name */
    public static final class C7681a {
    }

    static {
    }

    public a(d r100) {
        this.f544438a = r100;
        this.f544439b = new HashMap();
        StringBuilder r101 = new StringBuilder("analyticService null: ");
        if (r100 != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("ShareWordsAnalytic", r101.toString());
        if (r100 == null) goto L9;
        HashMap<String, Object> r103 = r100.m("docCommonParams");
    L10:
        if (r103 == null) goto L15;
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, Object> r105 = r104.next();
        this.f544439b.put(r105.getKey(), r105.getValue());
        goto L13
    L17:
        return;
    L15:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final void a(String r100, Map<String, Object> r101) {
        ((HashMap) r101).putAll(this.f544439b);
        tt5.a.b("ShareWordsAnalytic", "reportEventV2: event = " + r100 + ", params = " + r101);
        d r102 = this.f544438a;
        if (r102 == null) goto L6;
        r102.n(r100, r101);
        return;
    }

    public final void b(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "loadStage");
        long r103 = System.currentTimeMillis();
        HashMap r104 = new HashMap();
        r104.put("action", "send_im_load_stage");
        r104.put("load_stage", r100);
        r104.put("total_run_time", Long.valueOf(r103 - r101));
        if (r102 <= 0) goto L5;
        r104.put("run_time", Long.valueOf(r103 - r102));
    L5:
        a("ccm_docx_send_im_dev", r104);
    }
}
