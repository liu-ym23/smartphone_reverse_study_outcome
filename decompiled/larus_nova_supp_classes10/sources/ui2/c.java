package ui2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ui2.a {
    public final List<List<?>> a;
    public final List<a> b;

    public interface a {
        void d();
    }

    public final int b() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= ((ArrayList) this.a).size()) goto L11;
        List r2 = (List) ListProtector.get(this.a, r0);
        a r3 = (a) ListProtector.get(this.b, r0);
        if (r3 == null) goto L10;
        r3.d();
        if (r2 == null) goto L10;
        r1 = r1 + r2.size();
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    public c() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final Object a(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.a).size()) goto L15;
        List r1 = (List) ListProtector.get(this.a, r0);
        a r2 = (a) ListProtector.get(this.b, r0);
        if (r2 == null) goto L14;
        r2.d();
        if (r1 == null) goto L14;
        if (r4 < r1.size()) goto L12;
        r4 = r4 - r1.size();
        goto L14
    L12:
        return ListProtector.get(r1, r4);
    L14:
        r0 = r0 + 1;
        goto L4
    L15:
        return null;
    }
}
