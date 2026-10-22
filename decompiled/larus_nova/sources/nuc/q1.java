package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
public final class q1 implements juc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f520759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p1 f520760b = null;

    public q1() {
    }

    static {
        f520759a = new q1();
        f520760b = p1.f520751a;
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520760b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter((Void) r101, "value");
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }
}
