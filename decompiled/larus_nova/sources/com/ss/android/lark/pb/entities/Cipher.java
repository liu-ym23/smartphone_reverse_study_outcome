package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Cipher extends com.squareup.wire.Message<Cipher, Builder> {
    public static final ProtoAdapter<Cipher> ADAPTER = null;
    public static final ByteString DEFAULT_ADDITIONAL_DATA = null;
    public static final ByteString DEFAULT_NONCE = null;
    public static final ByteString DEFAULT_SECRET = null;
    private static final long serialVersionUID = 0;
    public final ByteString madditional_data;
    public final ByteString mnonce;
    public final ByteString msecret;

    public static final class Builder extends com.squareup.wire.Message.Builder<Cipher, Builder> {
        public ByteString madditional_data;
        public ByteString mnonce;
        public ByteString msecret;

        @Override // com.squareup.wire.Message.Builder
        public Cipher build() {
            return new Cipher(this.msecret, this.mnonce, this.madditional_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder additional_data(ByteString r100) {
            this.madditional_data = r100;
            return this;
        }

        public Builder nonce(ByteString r100) {
            this.mnonce = r100;
            return this;
        }

        public Builder secret(ByteString r100) {
            this.msecret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Cipher extends ProtoAdapter<Cipher> {
        public ProtoAdapter_Cipher() {
            super(FieldEncoding.LENGTH_DELIMITED, Cipher.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Cipher decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.msecret = r102;
            r101.mnonce = r102;
            r101.madditional_data = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.msecret = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mnonce = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.madditional_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Cipher r100) {
            ByteString r101 = r100.msecret;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.mnonce;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.madditional_data;
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
        public /* bridge */ /* synthetic */ Cipher decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Cipher r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Cipher r101) throws IOException {
            ByteString r102 = r101.msecret;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.mnonce;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.madditional_data;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Cipher r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Cipher();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_SECRET = r100;
        DEFAULT_NONCE = r100;
        DEFAULT_ADDITIONAL_DATA = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msecret = this.msecret;
        r100.mnonce = this.mnonce;
        r100.madditional_data = this.madditional_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Cipher.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Cipher(ByteString r100, ByteString r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Cipher(ByteString r100, ByteString r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.msecret = r100;
        this.mnonce = r101;
        this.madditional_data = r102;
    }
}
