package sg2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class f0 implements e0.a<ee.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e0> f541791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ee.b f541792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f541793c;

    @Override // sg2.e0.a
    public final ee.b getMessage() {
        return this.f541792b;
    }

    @Override // sg2.e0.a
    public final /* bridge */ /* synthetic */ boolean a(ee.b r100) throws Exception {
        return b(r100);
    }

    public final boolean b(ee.b r100) throws Exception {
        if (this.f541793c < this.f541791a.size()) goto L6;
        return false;
    L6:
        List<e0> r101 = this.f541791a;
        int r102 = this.f541793c;
        f0 r103 = new f0(r101, r102 + 1, r100);
        return ((e0) ListProtector.get(r101, r102)).a(r103);
    }

    public f0(List<e0> r100, int r101, ee.b r102) {
        this.f541791a = r100;
        this.f541793c = r101;
        this.f541792b = r102;
    }
}
