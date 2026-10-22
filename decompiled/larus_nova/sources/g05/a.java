package g05;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f479462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f479463b;

    /* JADX INFO: renamed from: g05.a$a, reason: collision with other inner class name */
    public static final class C5974a {
    }

    static {
    }

    public a(d r100) {
        this.f479462a = r100;
        this.f479463b = new HashMap();
        StringBuilder r101 = new StringBuilder("analyticService null: ");
        if (r100 != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("AssociatedAnalytic", r101.toString());
        if (r100 == null) goto L9;
        HashMap<String, Object> r103 = r100.m("docCommonParams");
    L10:
        if (r103 == null) goto L15;
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, Object> r105 = r104.next();
        this.f479463b.put(r105.getKey(), r105.getValue());
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
        ((HashMap) r101).putAll(this.f479463b);
        tt5.a.b("AssociatedAnalytic", "reportEventV2: event = " + r100 + ", params = " + r101);
        d r102 = this.f479462a;
        if (r102 == null) goto L6;
        r102.n(r100, r101);
        return;
    }
}
