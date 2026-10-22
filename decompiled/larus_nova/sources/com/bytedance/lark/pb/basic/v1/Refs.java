package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Refs extends com.squareup.wire.Message<Refs, Builder> {
    public static final ProtoAdapter<Refs> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Ref> refs;

    public static final class Builder extends com.squareup.wire.Message.Builder<Refs, Builder> {
        public List<Ref> refs;

        @Override // com.squareup.wire.Message.Builder
        public Refs build() {
            return new Refs(this.refs, super.buildUnknownFields());
        }

        public Builder() {
            this.refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder refs(List<Ref> r100) {
            Internal.checkElementsNotNull(r100);
            this.refs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Refs extends ProtoAdapter<Refs> {
        public ProtoAdapter_Refs() {
            super(FieldEncoding.LENGTH_DELIMITED, Refs.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Refs decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.refs.add(Ref.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Refs r100) {
            return Ref.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.refs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Refs decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Refs r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Refs r101) throws IOException {
            Ref.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Refs r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Refs();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.refs = Internal.copyOf("refs", this.refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Refs.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Refs(List<Ref> r100) {
        this(r100, ByteString.EMPTY);
    }

    public Refs(List<Ref> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.refs = Internal.immutableCopyOf("refs", r100);
    }
}
