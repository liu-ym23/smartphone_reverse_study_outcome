package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes5.dex */
public final class c0 implements juc.d<Duration> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f520648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520649b = null;

    public c0() {
    }

    static {
        f520648a = new c0();
        f520649b = new m2("kotlin.time.Duration", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520649b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Duration.m10791boximpl(Duration.Companion.m10913parseIsoStringUwyO8pc(r100.decodeString()));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        long r102 = ((Duration) r101).m10848unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeString(Duration.m10838toIsoStringimpl(r102));
    }
}
