package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SelfHelpContext extends Message<SelfHelpContext, Builder> {
    public static final ProtoAdapter<SelfHelpContext> ADAPTER = null;
    public static final Boolean DEFAULT_ENCRYPTED = null;
    public static final Integer DEFAULT_HEADER_LEN = null;
    public static final ByteString DEFAULT_KEY = null;
    public static final ByteString DEFAULT_NONCE = null;
    private static final long serialVersionUID = 0;
    public final Boolean encrypted;
    public final Integer header_len;
    public final ByteString key;
    public final ByteString nonce;

    public static final class Builder extends Message.Builder<SelfHelpContext, Builder> {
        public Boolean encrypted;
        public Integer header_len;
        public ByteString key;
        public ByteString nonce;

        @Override // com.squareup.wire.Message.Builder
        public SelfHelpContext build() {
            return new SelfHelpContext(this.encrypted, this.key, this.nonce, this.header_len, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder encrypted(Boolean r100) {
            this.encrypted = r100;
            return this;
        }

        public Builder header_len(Integer r100) {
            this.header_len = r100;
            return this;
        }

        public Builder key(ByteString r100) {
            this.key = r100;
            return this;
        }

        public Builder nonce(ByteString r100) {
            this.nonce = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SelfHelpContext extends ProtoAdapter<SelfHelpContext> {
        public ProtoAdapter_SelfHelpContext() {
            super(FieldEncoding.LENGTH_DELIMITED, SelfHelpContext.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SelfHelpContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.encrypted = Boolean.FALSE;
            ByteString r102 = ByteString.EMPTY;
            r101.key = r102;
            r101.nonce = r102;
            r101.header_len = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.encrypted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.key = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.nonce = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.header_len = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SelfHelpContext r100) {
            Boolean r101 = r100.encrypted;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.nonce;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.header_len;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.UINT32.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SelfHelpContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SelfHelpContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SelfHelpContext r101) throws IOException {
            Boolean r102 = r101.encrypted;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.key;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.nonce;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.header_len;
            if (r105 == null) goto L14;
            ProtoAdapter.UINT32.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelfHelpContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SelfHelpContext();
        DEFAULT_ENCRYPTED = Boolean.FALSE;
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_KEY = r100;
        DEFAULT_NONCE = r100;
        DEFAULT_HEADER_LEN = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.encrypted = this.encrypted;
        r100.key = this.key;
        r100.nonce = this.nonce;
        r100.header_len = this.header_len;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SelfHelpContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SelfHelpContext(Boolean r100, ByteString r101, ByteString r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SelfHelpContext(Boolean r100, ByteString r101, ByteString r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.encrypted = r100;
        this.key = r101;
        this.nonce = r102;
        this.header_len = r103;
    }
}
