package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class o1 extends muc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f520745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.serialization.modules.c f520746b = null;

    @Override // muc.b, muc.f
    public final void encodeBoolean(boolean r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeByte(byte r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeChar(char r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeDouble(double r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeEnum(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "enumDescriptor");
    }

    @Override // muc.b, muc.f
    public final void encodeFloat(float r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeInt(int r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeLong(long r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeNull() {
    }

    @Override // muc.b, muc.f
    public final void encodeShort(short r100) {
    }

    @Override // muc.b, muc.f
    public final void encodeString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
    }

    @Override // muc.b
    public final void encodeValue(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
    }

    static {
        f520745a = new o1();
        f520746b = kotlinx.serialization.modules.i.f505488a;
    }

    public o1() {
    }

    @Override // muc.f
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return f520746b;
    }
}
