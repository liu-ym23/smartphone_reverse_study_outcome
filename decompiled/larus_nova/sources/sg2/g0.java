package sg2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 implements e0.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e0> f541796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f541797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f541798c;

    @Override // sg2.e0.a
    public final a getMessage() {
        return this.f541797b;
    }

    @Override // sg2.e0.a
    public final boolean a(a r100) throws Exception {
        a r101 = r100;
        if (this.f541798c < this.f541796a.size()) goto L5;
        return false;
    L5:
        List<e0> r102 = this.f541796a;
        int r103 = this.f541798c;
        g0 r104 = new g0(r102, r103 + 1, r101);
        return ((e0) ListProtector.get(r102, r103)).a(r104);
    }

    public g0(List<e0> r100, int r101, a r102) {
        this.f541796a = r100;
        this.f541798c = r101;
        this.f541797b = r102;
    }
}
