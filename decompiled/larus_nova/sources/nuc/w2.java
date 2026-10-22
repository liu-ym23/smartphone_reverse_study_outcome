package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class w2<Tag> implements muc.e, muc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Tag> f520795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f520796b;

    public abstract boolean b(Tag r100);

    public abstract byte c(Tag r100);

    public abstract char d(Tag r100);

    @Override // muc.e
    public final Void decodeNull() {
        return null;
    }

    @Override // muc.c
    @ExperimentalSerializationApi
    public final boolean decodeSequentially() {
        return false;
    }

    @Override // muc.e
    public abstract <T> T decodeSerializableValue(juc.c<? extends T> r100);

    public abstract double e(Tag r100);

    public abstract int f(Tag r100, luc.f r101);

    public abstract float g(Tag r100);

    public abstract muc.e h(Tag r100, luc.f r101);

    public abstract int i(Tag r100);

    public abstract long j(Tag r100);

    public abstract short k(Tag r100);

    public abstract String l(Tag r100);

    public abstract Tag m(luc.f r100, int r101);

    public final Tag n() {
        ArrayList<Tag> r100 = this.f520795a;
        Tag r101 = (Tag) ListProtector.remove(r100, CollectionsKt.getLastIndex(r100));
        this.f520796b = true;
        return r101;
    }

    public w2() {
        this.f520795a = new ArrayList();
    }

    @Override // muc.e
    public final boolean decodeBoolean() {
        return b(n());
    }

    @Override // muc.e
    public final byte decodeByte() {
        return c(n());
    }

    @Override // muc.e
    public final char decodeChar() {
        return d(n());
    }

    @Override // muc.e
    public final double decodeDouble() {
        return e(n());
    }

    @Override // muc.e
    public final float decodeFloat() {
        return g(n());
    }

    @Override // muc.e
    public final int decodeInt() {
        return i(n());
    }

    @Override // muc.e
    public final long decodeLong() {
        return j(n());
    }

    @Override // muc.e
    public final short decodeShort() {
        return k(n());
    }

    @Override // muc.e
    public final String decodeString() {
        return l(n());
    }

    @Override // muc.c
    public final int decodeCollectionSize(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return -1;
    }

    @Override // muc.e
    public final int decodeEnum(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "enumDescriptor");
        return f(n(), r100);
    }

    @Override // muc.e
    public muc.e decodeInline(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return h(n(), r100);
    }

    @Override // muc.c
    public final boolean decodeBooleanElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return b(m(r100, r101));
    }

    @Override // muc.c
    public final byte decodeByteElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return c(m(r100, r101));
    }

    @Override // muc.c
    public final char decodeCharElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return d(m(r100, r101));
    }

    @Override // muc.c
    public final double decodeDoubleElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return e(m(r100, r101));
    }

    @Override // muc.c
    public final float decodeFloatElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return g(m(r100, r101));
    }

    @Override // muc.c
    public final muc.e decodeInlineElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return h(m(r100, r101), ((d1) r100).h(r101));
    }

    @Override // muc.c
    public final int decodeIntElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return i(m(r100, r101));
    }

    @Override // muc.c
    public final long decodeLongElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return j(m(r100, r101));
    }

    @Override // muc.c
    public final short decodeShortElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return k(m(r100, r101));
    }

    @Override // muc.c
    public final String decodeStringElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return l(m(r100, r101));
    }

    @Override // muc.c
    public final <T> T decodeNullableSerializableElement(luc.f r100, int r101, juc.c<? extends T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "deserializer");
        this.f520795a.add(m(r100, r101));
        Intrinsics.checkNotNullParameter(this, "this$0");
        Intrinsics.checkNotNullParameter(r102, "$deserializer");
        if (r102.getDescriptor().a() == false) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r102, "deserializer");
        T r104 = (T) decodeSerializableValue(r102);
    L10:
        if (this.f520796b == true) goto L12;
        n();
    L12:
        this.f520796b = false;
        return r104;
    L5:
        if (decodeNotNullMark() == true) goto L8;
        r104 = null;
        goto L10
    }

    @Override // muc.c
    public final <T> T decodeSerializableElement(luc.f r100, int r101, juc.c<? extends T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "deserializer");
        Tag r104 = m(r100, r101);
        this.f520795a.add(r104);
        Intrinsics.checkNotNullParameter(this, "this$0");
        Intrinsics.checkNotNullParameter(r102, "$deserializer");
        Intrinsics.checkNotNullParameter(r102, "deserializer");
        T r105 = (T) decodeSerializableValue(r102);
        if (this.f520796b == true) goto L5;
        n();
    L5:
        this.f520796b = false;
        return r105;
    }
}
