package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.r0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i0<T> implements juc.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<T> f526857a;

    public abstract i a(i r100);

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f526857a.getDescriptor();
    }

    public i0(juc.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "tSerializer");
        this.f526857a = r100;
    }

    @Override // juc.c
    public final T deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        h r101 = t.a(r100);
        i r102 = r101.a();
        return (T) r101.getJson().b(this.f526857a, a(r102));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        u r102 = t.b(r100);
        i r103 = r0.a(r102.getJson(), r101, this.f526857a);
        Intrinsics.checkNotNullParameter(r103, "element");
        r102.a(r103);
    }
}
