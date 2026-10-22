package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class r extends muc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f505455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.modules.d f505456b;

    @Override // muc.a, muc.e
    public final byte decodeByte() {
        a r100 = this.f505455a;
        String r101 = r100.j();
        return UStringsKt.toUByte(r101);
    L5:
        a.m(r100, "Failed to parse type 'UByte' for input '" + r101 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final int decodeInt() {
        a r100 = this.f505455a;
        String r101 = r100.j();
        return UStringsKt.toUInt(r101);
    L5:
        a.m(r100, "Failed to parse type 'UInt' for input '" + r101 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final long decodeLong() {
        a r100 = this.f505455a;
        String r101 = r100.j();
        return UStringsKt.toULong(r101);
    L5:
        a.m(r100, "Failed to parse type 'ULong' for input '" + r101 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final short decodeShort() {
        a r100 = this.f505455a;
        String r101 = r100.j();
        return UStringsKt.toUShort(r101);
    L5:
        a.m(r100, "Failed to parse type 'UShort' for input '" + r101 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.e, muc.c
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.f505456b;
    }

    @Override // muc.c
    public final int decodeElementIndex(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    public r(a r100, ouc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "lexer");
        Intrinsics.checkNotNullParameter(r101, "json");
        this.f505455a = r100;
        this.f505456b = r101.f526800b;
    }
}
