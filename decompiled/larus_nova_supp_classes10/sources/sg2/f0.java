package sg2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0 implements e0.a<ee.b> {
    public final List<e0> a;
    public final ee.b b;
    public final int c;

    @Override // sg2.e0.a
    public final ee.b getMessage() {
        return this.b;
    }

    @Override // sg2.e0.a
    public final /* bridge */ /* synthetic */ boolean a(ee.b r1) throws Exception {
        return b(r1);
    }

    public final boolean b(ee.b r5) throws Exception {
        if (this.c < this.a.size()) goto L6;
        return false;
    L6:
        List<e0> r1 = this.a;
        int r2 = this.c;
        f0 r0 = new f0(r1, r2 + 1, r5);
        return ((e0) ListProtector.get(r1, r2)).a(r0);
    }

    public f0(List<e0> r1, int r2, ee.b r3) {
        this.a = r1;
        this.c = r2;
        this.b = r3;
    }
}
