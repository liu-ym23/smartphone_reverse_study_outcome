package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public abstract E fromValue(int r100);

    public EnumAdapter(Class<E> r100) {
        super(FieldEncoding.VARINT, r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r100) throws IOException {
        int r101 = r100.readVarint32();
        E r102 = (E) fromValue(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r101, this.javaType);
    }

    public final int encodedSize(E r100) {
        return ProtoWriter.varint32Size(r100.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r100) throws IOException {
        return decode(r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r100) {
        return encodedSize((WireEnum) r100);
    }

    public final void encode(ProtoWriter r100, E r101) throws IOException {
        r100.writeVarint32(r101.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Object r101) throws IOException {
        encode(r100, (WireEnum) r101);
    }
}
