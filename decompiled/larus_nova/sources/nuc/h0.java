package nuc;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
public final class h0<T extends Enum<T>> implements juc.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f520698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final luc.f f520699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f520700c;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return (luc.f) this.f520700c.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().f() + Typography.greater;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        int r101 = r100.decodeEnum(getDescriptor());
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        return this.f520698a[r101];
    L12:
        throw new SerializationException(r101 + " is not among valid " + getDescriptor().f() + " enum values, values size is " + this.f520698a.length);
    L5:
        if (r101 >= this.f520698a.length) goto L7;
        r102 = true;
        goto L8
    }

    public h0(final String r100, T[] r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "values");
        this.f520698a = r101;
        this.f520700c = LazyKt.lazy(new g0(this, r100));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        Enum r102 = (Enum) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        int r103 = ArraysKt.indexOf(this.f520698a, r102);
        if (r103 == (-1)) goto L7;
        r100.encodeEnum(getDescriptor(), r103);
        return;
    L7:
        throw new SerializationException(r102 + " is not a valid enum " + getDescriptor().f() + ", must be one of " + Arrays.toString(this.f520698a));
    }

    public h0(String r100, Enum[] r101, f0 r102) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "values");
        Intrinsics.checkNotNullParameter(r102, "descriptor");
        this(r100, r101);
        this.f520699b = r102;
    }
}
