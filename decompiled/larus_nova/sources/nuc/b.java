package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class b<T> implements juc.d<T> {
    public b() {
    }

    public abstract KClass<T> c();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // juc.c
    public final T deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        luc.f r101 = getDescriptor();
        muc.c r102 = r100.beginStructure(r101);
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        if (r102.decodeSequentially() == false) goto L5;
        T r104 = (T) r102.decodeSerializableElement(getDescriptor(), 1, juc.h.a(this, r102, r102.decodeStringElement(getDescriptor(), 0)), null);
    L23:
        r102.endStructure(r101);
        return r104;
    L5:
        Object r105 = null;
    L6:
        int r106 = r102.decodeElementIndex(getDescriptor());
        if (r106 == (-1)) goto L21;
        if (r106 != 0) goto L9;
        r103.element = (T) r102.decodeStringElement(getDescriptor(), r106);
        goto L6
    L9:
        if (r106 != 1) goto L10;
        T r107 = r103.element;
        if (r107 == 0) goto L19;
        r103.element = r107;
        r105 = r102.decodeSerializableElement(getDescriptor(), r106, juc.h.a(this, r102, (String) r107), null);
        goto L6
    L19:
        throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
    L10:
        StringBuilder r108 = new StringBuilder("Invalid index in polymorphic deserialization of ");
        String r109 = (String) r103.element;
        if (r109 != null) goto L13;
        r109 = "unknown class";
    L13:
        r108.append(r109);
        r108.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
        r108.append(r106);
        throw new SerializationException(r108.toString());
    L21:
        if (r105 == null) goto L26;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
        r104 = (T) r105;
        goto L23
    L26:
        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) r103.element)).toString());
    }

    @InternalSerializationApi
    public juc.c<T> a(muc.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return r100.getSerializersModule().e(c(), r101);
    }

    @InternalSerializationApi
    public juc.n<T> b(muc.f r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        return r100.getSerializersModule().f(c(), r101);
    }

    @Override // juc.n
    public final void serialize(muc.f r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        juc.n<? super T> r102 = juc.h.b(this, r100, r101);
        luc.f r103 = getDescriptor();
        muc.d r104 = r100.beginStructure(r103);
        r104.encodeStringElement(getDescriptor(), 0, r102.getDescriptor().f());
        luc.f r105 = getDescriptor();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        r104.encodeSerializableElement(r105, 1, r102, r101);
        r104.endStructure(r103);
    }
}
