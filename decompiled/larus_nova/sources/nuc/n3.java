package nuc;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class n3 implements juc.d<Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n3 f520741b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1<Unit> f520742a;

    static {
        f520741b = new n3();
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520742a.getDescriptor();
    }

    public n3() {
        this.f520742a = new u1(Unit.INSTANCE);
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        this.f520742a.deserialize(r100);
        return Unit.INSTANCE;
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        Unit r102 = (Unit) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f520742a.serialize(r100, r102);
    }
}
