package muc;

import juc.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import nuc.o1;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public abstract class b implements f, d {
    public b() {
    }

    @Override // muc.f
    public d beginStructure(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return this;
    }

    public boolean encodeElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return true;
    }

    @Override // muc.f
    public f encodeInline(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return this;
    }

    @Override // muc.f
    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
    }

    public void endStructure(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
    }

    @Override // muc.f
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // muc.f
    public void encodeBoolean(boolean r100) {
        encodeValue(Boolean.valueOf(r100));
    }

    @Override // muc.f
    public void encodeByte(byte r100) {
        encodeValue(Byte.valueOf(r100));
    }

    @Override // muc.f
    public void encodeChar(char r100) {
        encodeValue(Character.valueOf(r100));
    }

    @Override // muc.f
    public void encodeDouble(double r100) {
        encodeValue(Double.valueOf(r100));
    }

    @Override // muc.f
    public void encodeFloat(float r100) {
        encodeValue(Float.valueOf(r100));
    }

    @Override // muc.f
    public void encodeInt(int r100) {
        encodeValue(Integer.valueOf(r100));
    }

    @Override // muc.f
    public void encodeLong(long r100) {
        encodeValue(Long.valueOf(r100));
    }

    @Override // muc.f
    public void encodeShort(short r100) {
        encodeValue(Short.valueOf(r100));
    }

    @Override // muc.f
    public void encodeString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        encodeValue(r100);
    }

    public void encodeValue(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(r100.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    @Override // muc.f
    public d beginCollection(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return beginStructure(r100);
    }

    @Override // muc.f
    public void encodeEnum(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "enumDescriptor");
        encodeValue(Integer.valueOf(r101));
    }

    @Override // muc.d
    public final f encodeInlineElement(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        return encodeInline(r100.h(r101));
    L6:
        return o1.f520745a;
    }

    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(n<? super T> r100, T r101) {
        f.a.a(this, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // muc.f
    public <T> void encodeSerializableValue(n<? super T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "serializer");
        r100.serialize(this, r101);
    }

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return true;
    }

    @Override // muc.d
    public final void encodeBooleanElement(luc.f r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeBoolean(r102);
        return;
    }

    @Override // muc.d
    public final void encodeByteElement(luc.f r100, int r101, byte r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeByte(r102);
        return;
    }

    @Override // muc.d
    public final void encodeCharElement(luc.f r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeChar(r102);
        return;
    }

    @Override // muc.d
    public final void encodeDoubleElement(luc.f r100, int r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeDouble(r102);
        return;
    }

    @Override // muc.d
    public final void encodeFloatElement(luc.f r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeFloat(r102);
        return;
    }

    @Override // muc.d
    public final void encodeIntElement(luc.f r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeInt(r102);
        return;
    }

    @Override // muc.d
    public final void encodeLongElement(luc.f r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeLong(r102);
        return;
    }

    @Override // muc.d
    public final void encodeShortElement(luc.f r100, int r101, short r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeShort(r102);
        return;
    }

    @Override // muc.d
    public final void encodeStringElement(luc.f r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeString(r102);
        return;
    }

    public <T> void encodeNullableSerializableElement(luc.f r100, int r101, n<? super T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "serializer");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeNullableSerializableValue(r102, r103);
        return;
    }

    @Override // muc.d
    public <T> void encodeSerializableElement(luc.f r100, int r101, n<? super T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "serializer");
        if (encodeElement(r100, r101) == false) goto L6;
        encodeSerializableValue(r102, r103);
        return;
    }
}
