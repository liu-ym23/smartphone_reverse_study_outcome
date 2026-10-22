package j0;

import java.util.Collections;

/* JADX INFO: loaded from: classes28.dex */
public final class p<K, A> extends a<K, A> {
    @Override // j0.a
    public final float c() {
        return 1.0f;
    }

    @Override // j0.a
    public final A g() {
        v0.c<A> r100 = this.f496750f;
        float r101 = this.f496749e;
        return r100.b(0.0f, 0.0f, null, null, r101, r101, r101);
    }

    @Override // j0.a
    public final void i() {
        if (this.f496750f == null) goto L6;
        super.i();
        return;
    }

    public p(v0.c<A> r100) {
        super(Collections.emptyList());
        k(r100);
    }

    @Override // j0.a
    public final A h(v0.a<K> r100, float r101) {
        return g();
    }
}
