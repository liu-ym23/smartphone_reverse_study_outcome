package muc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public abstract class a implements e, c {
    public a() {
    }

    @Override // muc.e
    public c beginStructure(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return this;
    }

    @Override // muc.e
    public e decodeInline(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return this;
    }

    @Override // muc.e
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // muc.e
    public Void decodeNull() {
        return null;
    }

    @Override // muc.c
    @ExperimentalSerializationApi
    public boolean decodeSequentially() {
        return false;
    }

    public void endStructure(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
    }

    public Object decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // muc.e
    public boolean decodeBoolean() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) r100).booleanValue();
    }

    @Override // muc.e
    public byte decodeByte() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) r100).byteValue();
    }

    @Override // muc.e
    public char decodeChar() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) r100).charValue();
    }

    @Override // muc.e
    public double decodeDouble() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) r100).doubleValue();
    }

    @Override // muc.e
    public float decodeFloat() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) r100).floatValue();
    }

    @Override // muc.e
    public int decodeInt() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r100).intValue();
    }

    @Override // muc.e
    public long decodeLong() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) r100).longValue();
    }

    @Override // muc.e
    public short decodeShort() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) r100).shortValue();
    }

    @Override // muc.e
    public String decodeString() {
        Object r100 = decodeValue();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.String");
        return (String) r100;
    }

    @Override // muc.c
    public int decodeCollectionSize(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return -1;
    }

    @Override // muc.e
    public int decodeEnum(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "enumDescriptor");
        Object r101 = decodeValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r101).intValue();
    }

    @ExperimentalSerializationApi
    public <T> T decodeNullableSerializableValue(juc.c<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        if (r100.getDescriptor().a() == true) goto L9;
        if (decodeNotNullMark() == true) goto L9;
        return (T) decodeNull();
    L9:
        return (T) decodeSerializableValue(r100);
    }

    @Override // muc.e
    public <T> T decodeSerializableValue(juc.c<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        return r100.deserialize(this);
    }

    @Override // muc.c
    public final boolean decodeBooleanElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeBoolean();
    }

    @Override // muc.c
    public final byte decodeByteElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeByte();
    }

    @Override // muc.c
    public final char decodeCharElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeChar();
    }

    @Override // muc.c
    public final double decodeDoubleElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeDouble();
    }

    @Override // muc.c
    public final float decodeFloatElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeFloat();
    }

    @Override // muc.c
    public e decodeInlineElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeInline(r100.h(r101));
    }

    @Override // muc.c
    public final int decodeIntElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeInt();
    }

    @Override // muc.c
    public final long decodeLongElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeLong();
    }

    public <T> T decodeSerializableValue(juc.c<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        return (T) decodeSerializableValue(r100);
    }

    @Override // muc.c
    public final short decodeShortElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeShort();
    }

    @Override // muc.c
    public final String decodeStringElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return decodeString();
    }

    @Override // muc.c
    public final <T> T decodeNullableSerializableElement(luc.f r100, int r101, juc.c<? extends T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "deserializer");
        if (r102.getDescriptor().a() == true) goto L9;
        if (decodeNotNullMark() == true) goto L9;
        return (T) decodeNull();
    L9:
        return (T) decodeSerializableValue(r102, r103);
    }

    public <T> T decodeSerializableElement(luc.f r100, int r101, juc.c<? extends T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "deserializer");
        return (T) decodeSerializableValue(r102, r103);
    }

    public static /* synthetic */ Object decodeSerializableValue$default(a r100, juc.c r101, Object r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        return r100.decodeSerializableValue(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
    }
}
