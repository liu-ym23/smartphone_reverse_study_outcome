package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
public final class u1<T> implements juc.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f520781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends Annotation> f520782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f520783c;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return (luc.f) this.f520783c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u1(Unit r100) {
        Intrinsics.checkNotNullParameter("kotlin.Unit", "serialName");
        Intrinsics.checkNotNullParameter(r100, "objectInstance");
        this.f520781a = r100;
        this.f520782b = CollectionsKt.emptyList();
        this.f520783c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s1(this));
    }

    @Override // juc.c
    public final T deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        luc.f r101 = getDescriptor();
        muc.c r102 = r100.beginStructure(r101);
        if (r102.decodeSequentially() == true) goto L7;
        int r103 = r102.decodeElementIndex(getDescriptor());
        if (r103 == (-1)) goto L7;
        throw new SerializationException("Unexpected index " + r103);
    L7:
        Unit r104 = Unit.INSTANCE;
        r102.endStructure(r101);
        return this.f520781a;
    }

    @Override // juc.n
    public final void serialize(muc.f r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
