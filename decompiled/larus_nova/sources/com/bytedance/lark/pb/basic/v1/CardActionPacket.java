package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CardActionPacket extends com.squareup.wire.Message<CardActionPacket, Builder> {
    public static final ProtoAdapter<CardActionPacket> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    private static final long serialVersionUID = 0;
    public final String cid;
    public final CardAction.Parameters parameters;
    public final ByteString payload;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardActionPacket, Builder> {
        public String cid;
        public CardAction.Parameters parameters;
        public ByteString payload;

        @Override // com.squareup.wire.Message.Builder
        public CardActionPacket build() {
            return new CardActionPacket(this.cid, this.parameters, this.payload, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder parameters(CardAction.Parameters r100) {
            this.parameters = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CardActionPacket extends ProtoAdapter<CardActionPacket> {
        public ProtoAdapter_CardActionPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, CardActionPacket.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardActionPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            r101.payload = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.parameters = CardAction.Parameters.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CardActionPacket r100) {
            String r101 = r100.cid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            CardAction.Parameters r104 = r100.parameters;
            if (r104 == null) goto L9;
            int r105 = CardAction.Parameters.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.payload;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CardActionPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardActionPacket r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardActionPacket r101) throws IOException {
            String r102 = r101.cid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            CardAction.Parameters r103 = r101.parameters;
            if (r103 == null) goto L8;
            CardAction.Parameters.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.payload;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardActionPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardActionPacket();
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.parameters = this.parameters;
        r100.payload = this.payload;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardActionPacket.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardActionPacket(String r100, CardAction.Parameters r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CardActionPacket(String r100, CardAction.Parameters r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.cid = r100;
        this.parameters = r101;
        this.payload = r102;
    }
}
