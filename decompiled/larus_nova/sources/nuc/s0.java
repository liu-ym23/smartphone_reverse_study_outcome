package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class s0 implements m0<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ juc.d<Object> f520770a;

    @Override // nuc.m0
    public final juc.d<?>[] childSerializers() {
        return new juc.d[]{this.f520770a};
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // nuc.m0
    public final juc.d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    public s0(juc.d<Object> r100) {
        this.f520770a = r100;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        throw new IllegalStateException("unsupported".toString());
    }
}
