package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class x2<Tag> implements muc.f, muc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Tag> f520801a;

    public abstract void b(Tag r100, boolean r101);

    public abstract void c(Tag r100, byte r101);

    public abstract void d(Tag r100, char r101);

    public abstract void e(Tag r100, double r101);

    @Override // muc.f
    public abstract <T> void encodeSerializableValue(juc.n<? super T> r100, T r101);

    public abstract void f(Tag r100, luc.f r101, int r102);

    public abstract void g(Tag r100, float r101);

    public abstract muc.f h(Tag r100, luc.f r101);

    public abstract void i(Tag r100, int r101);

    public abstract void j(Tag r100, long r101);

    public abstract void k(Tag r100, short r101);

    public abstract void l(Tag r100, String r101);

    public abstract void m(luc.f r100);

    public abstract Tag n(luc.f r100, int r101);

    public final Tag o() {
        if ((!this.f520801a.isEmpty()) == false) goto L7;
        ArrayList<Tag> r100 = this.f520801a;
        return (Tag) ListProtector.remove(r100, CollectionsKt.getLastIndex(r100));
    L7:
        throw new SerializationException("No tag in stack for requested element");
    }

    public x2() {
        this.f520801a = new ArrayList();
    }

    @Override // muc.f
    public final void encodeBoolean(boolean r100) {
        b(o(), r100);
    }

    @Override // muc.f
    public final void encodeByte(byte r100) {
        c(o(), r100);
    }

    @Override // muc.f
    public final void encodeChar(char r100) {
        d(o(), r100);
    }

    @Override // muc.f
    public final void encodeDouble(double r100) {
        e(o(), r100);
    }

    @Override // muc.f
    public final void encodeFloat(float r100) {
        g(o(), r100);
    }

    @Override // muc.f
    public muc.f encodeInline(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return h(o(), r100);
    }

    @Override // muc.f
    public final void encodeInt(int r100) {
        i(o(), r100);
    }

    @Override // muc.f
    public final void encodeLong(long r100) {
        j(o(), r100);
    }

    @Override // muc.f
    public final void encodeShort(short r100) {
        k(o(), r100);
    }

    @Override // muc.f
    public final void encodeString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        l(o(), r100);
    }

    @Override // muc.d
    public final void endStructure(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if ((!this.f520801a.isEmpty()) == false) goto L5;
        o();
    L5:
        m(r100);
    }

    @Override // muc.f
    public final muc.d beginCollection(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return beginStructure(r100);
    }

    @Override // muc.f
    public final void encodeEnum(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "enumDescriptor");
        f(o(), r100, r101);
    }

    @Override // muc.d
    public final muc.f encodeInlineElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return h(n(r100, r101), ((d1) r100).h(r101));
    }

    @Override // muc.d
    public final void encodeBooleanElement(luc.f r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        b(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeByteElement(luc.f r100, int r101, byte r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        c(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeCharElement(luc.f r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        d(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeDoubleElement(luc.f r100, int r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        e(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeFloatElement(luc.f r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        g(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeIntElement(luc.f r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        i(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeLongElement(luc.f r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        j(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeShortElement(luc.f r100, int r101, short r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        k(n(r100, r101), r102);
    }

    @Override // muc.d
    public final void encodeStringElement(luc.f r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "value");
        l(n(r100, r101), r102);
    }

    public <T> void encodeNullableSerializableElement(luc.f r100, int r101, juc.n<? super T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "serializer");
        Tag r104 = n(r100, r101);
        this.f520801a.add(r104);
        muc.f.a.a(this, r102, r103);
    }

    @Override // muc.d
    public final <T> void encodeSerializableElement(luc.f r100, int r101, juc.n<? super T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "serializer");
        Tag r104 = n(r100, r101);
        this.f520801a.add(r104);
        encodeSerializableValue(r102, r103);
    }
}
