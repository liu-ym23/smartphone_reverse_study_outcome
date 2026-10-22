package j0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class d extends f<o0.c> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o0.c f496761k;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<v0.a<o0.c>> r100) {
        super(r100);
        int r101 = 0;
        o0.c r102 = (o0.c) ((v0.a) ListProtector.get(r100, 0)).f552275b;
        if (r102 == null) goto L6;
        r101 = r102.f521574b.length;
    L6:
        this.f496761k = new o0.c(new float[r101], new int[r101]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.a
    public final Object h(v0.a r100, float r110) {
        o0.c r101 = this.f496761k;
        o0.c r102 = (o0.c) r100.f552275b;
        o0.c r103 = (o0.c) r100.f552276c;
        r101.getClass();
        if (r102.f521574b.length != r103.f521574b.length) goto L11;
        int r104 = 0;
    L5:
        int[] r105 = r102.f521574b;
        if (r104 >= r105.length) goto L9;
        float[] r106 = r101.f521573a;
        float r107 = r102.f521573a[r104];
        float r108 = r103.f521573a[r104];
        u0.e.a r109 = u0.e.f548111a;
        r106[r104] = r107 + ((r108 - r107) * r110);
        r101.f521574b[r104] = u0.b.c(r110, r105[r104], r103.f521574b[r104]);
        r104 = r104 + 1;
        goto L5
    L9:
        return this.f496761k;
    L11:
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + r102.f521574b.length + " vs " + r103.f521574b.length + ")");
    }
}
