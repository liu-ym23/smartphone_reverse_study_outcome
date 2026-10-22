package mq6;

import com.bytedance.locallife.dito.utils.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f514893a;

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final mq6.a f514894a = null;

        static {
            f514894a = new mq6.a();
        }
    }

    public c() {
        this.f514893a = new HashMap();
    }

    public final void e(HashMap r100) {
        if (r100 == null) goto L5;
        ((HashMap) this.f514893a).putAll(r100);
        return;
    }

    public final void f(Map r100) {
        if (r100 == null) goto L5;
        ((HashMap) this.f514893a).putAll(r100);
        return;
    }

    public final void a(String r100, int r101) {
        String r102 = String.valueOf(r101);
        mq6.a r103 = a.f514894a;
        g(r100, r102);
    }

    public final void b(String r100, long r101) {
        String r102 = String.valueOf(r101);
        mq6.a r103 = a.f514894a;
        g(r100, r102);
    }

    public final void c(String r100, Object r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((r101 instanceof String) == false) goto L8;
        d(r100, (String) r101);
        return;
    L8:
        if ((r101 instanceof Integer) == false) goto L12;
        a(r100, ((Integer) r101).intValue());
        return;
    L12:
        if ((r101 instanceof Long) == false) goto L15;
        b(r100, ((Long) r101).longValue());
        return;
    L15:
        d(r100, GsonProtectorUtils.toJson(q.a(), r101));
    }

    public final void d(String r100, String r101) {
        mq6.a r102 = a.f514894a;
        g(r100, r101);
    }

    public final void g(String r100, String r101) {
        mq6.a r102 = a.f514894a;
        Map<String, String> r103 = this.f514893a;
        HashMap r104 = (HashMap) r103;
        r104.put(r100, r102.a(r101));
    }

    public final c h(String r100, String r101) {
        if (r101 == null) goto L4;
        mq6.a r102 = a.f514894a;
        g(r100, r101);
    L4:
        return this;
    }
}
