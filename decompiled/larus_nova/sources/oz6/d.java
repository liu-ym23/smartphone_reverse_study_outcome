package oz6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends f<sz6.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final sz6.c f527211g;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<xz6.a<sz6.c>> r100) {
        super(r100);
        int r101 = 0;
        sz6.c r102 = (sz6.c) ((xz6.a) ListProtector.get(r100, 0)).f565527b;
        if (r102 == null) goto L6;
        r101 = r102.f543953b.length;
    L6:
        this.f527211g = new sz6.c(new float[r101], new int[r101]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oz6.a
    public final Object f(xz6.a r100, float r101) {
        sz6.c r102 = this.f527211g;
        sz6.c r103 = (sz6.c) r100.f565527b;
        sz6.c r104 = (sz6.c) r100.f565528c;
        r102.getClass();
        if (r103.f543953b.length != r104.f543953b.length) goto L11;
        int r105 = 0;
    L5:
        int[] r106 = r103.f543953b;
        if (r105 >= r106.length) goto L9;
        float[] r107 = r102.f543952a;
        float r108 = r103.f543952a[r105];
        r107[r105] = r108 + ((r104.f543952a[r105] - r108) * r101);
        r102.f543953b[r105] = wz6.c.c(r101, r106[r105], r104.f543953b[r105]);
        r105 = r105 + 1;
        goto L5
    L9:
        return this.f527211g;
    L11:
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + r103.f543953b.length + " vs " + r104.f543953b.length + ")");
    }
}
