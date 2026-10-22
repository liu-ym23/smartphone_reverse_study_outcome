package sg2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 implements e0.a<a> {
    public final List<e0> a;
    public final a b;
    public final int c;

    @Override // sg2.e0.a
    public final a getMessage() {
        return this.b;
    }

    @Override // sg2.e0.a
    public final boolean a(a r5) throws Exception {
        a r6 = r5;
        if (this.c < this.a.size()) goto L5;
        return false;
    L5:
        List<e0> r1 = this.a;
        int r2 = this.c;
        g0 r0 = new g0(r1, r2 + 1, r6);
        return ((e0) ListProtector.get(r1, r2)).a(r0);
    }

    public g0(List<e0> r1, int r2, a r3) {
        this.a = r1;
        this.c = r2;
        this.b = r3;
    }
}
