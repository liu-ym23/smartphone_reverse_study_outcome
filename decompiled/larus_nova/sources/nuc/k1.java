package nuc;

import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class k1<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<Key> f520724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final juc.d<Value> f520725b;

    @Override // juc.d, juc.n, juc.c
    public abstract luc.f getDescriptor();

    public k1(juc.d r100, juc.d r101) {
        this.f520724a = r100;
        this.f520725b = r101;
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Collection r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        int r102 = e(r101);
        luc.f r103 = getDescriptor();
        muc.d r104 = r100.beginCollection(r103, r102);
        Iterator<Map.Entry<? extends Key, ? extends Value>> r105 = d(r101);
        int r106 = 0;
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry<? extends Key, ? extends Value> r107 = r105.next();
        Key r108 = r107.getKey();
        Value r109 = r107.getValue();
        int r110 = r106 + 1;
        r104.encodeSerializableElement(getDescriptor(), r106, this.f520724a, r108);
        r104.encodeSerializableElement(getDescriptor(), r110, this.f520725b, r109);
        r106 = r110 + 1;
        goto L4
    L6:
        r104.endStructure(r103);
    }

    @Override // nuc.a
    public final void g(muc.c r100, Object r101, int r102, int r103) {
        Map r104 = (Map) r101;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        if (r103 < 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L17;
        IntProgression r106 = RangesKt.step(RangesKt.until(0, r103 * 2), 2);
        int r107 = r106.getFirst();
        int r108 = r106.getLast();
        int r109 = r106.getStep();
        if (r109 <= 0) goto L10;
        if (r107 > r108) goto L10;
    L12:
        k(r100, r102 + r107, r104, false);
        if (r107 == r108) goto L21;
        r107 = r107 + r109;
        goto L12
    L21:
        return;
    L10:
        if (r109 >= 0) goto L15;
        if (r108 <= r107) goto L12;
        return;
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    L5:
        r105 = false;
        goto L6
    }

    @Override // nuc.a
    public final /* bridge */ /* synthetic */ void h(muc.c r100, int r101, Object r102, boolean r103) {
        k(r100, r101, (Map) r102, r103);
    }

    public final void k(muc.c r100, int r101, Builder r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r102, "builder");
        Object r104 = r100.decodeSerializableElement(getDescriptor(), r101, this.f520724a, null);
        boolean r105 = true;
        if (r103 == false) goto L12;
        int r106 = r100.decodeElementIndex(getDescriptor());
        if (r106 == (r101 + 1)) goto L8;
        r105 = false;
    L8:
        if (r105 == true) goto L14;
        throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + r101 + ", returned index for value: " + r106).toString());
    L14:
        if (r102.containsKey(r104) == true) goto L16;
    L18:
        Object r107 = r100.decodeSerializableElement(getDescriptor(), r106, this.f520725b, null);
    L19:
        r102.put(r104, r107);
        return;
    L16:
        if ((this.f520725b.getDescriptor().getKind() instanceof luc.e) == true) goto L18;
        r107 = r100.decodeSerializableElement(getDescriptor(), r106, this.f520725b, MapsKt.getValue(r102, r104));
        goto L19
    L12:
        r106 = r101 + 1;
        goto L14
    }
}
