package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX22d4957386f22642 extends Message<FuncParamsX22d4957386f22642, Builder> {
    public static final ProtoAdapter<FuncParamsX22d4957386f22642> ADAPTER = null;
    public static final BitableDocumentType DEFAULT_DOCUMENT_TYPE = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_URL = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final BitableDocumentType document_type;
    public final String token;
    public final String url;

    public static final class Builder extends Message.Builder<FuncParamsX22d4957386f22642, Builder> {
        public ByteString _molten_ctx;
        public BitableDocumentType document_type;
        public String token;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX22d4957386f22642 build() {
            String r100 = this.token;
            if (r100 == null) goto L11;
            if (this.document_type == null) goto L11;
            if (this.url == null) goto L11;
            return new FuncParamsX22d4957386f22642(this.token, this.document_type, this.url, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "token", this.document_type, "document_type", this.url, "url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder document_type(BitableDocumentType r100) {
            this.document_type = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX22d4957386f22642 extends ProtoAdapter<FuncParamsX22d4957386f22642> {
        public ProtoAdapter_FuncParamsX22d4957386f22642() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX22d4957386f22642.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX22d4957386f22642 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.document_type = BitableDocumentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX22d4957386f22642 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.token) + BitableDocumentType.ADAPTER.encodedSizeWithTag(2, r100.document_type)) + r101.encodedSizeWithTag(3, r100.url);
            ByteString r103 = r100._molten_ctx;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX22d4957386f22642 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX22d4957386f22642 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX22d4957386f22642 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.token);
            BitableDocumentType.ADAPTER.encodeWithTag(r100, 2, r101.document_type);
            r102.encodeWithTag(r100, 3, r101.url);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX22d4957386f22642 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX22d4957386f22642();
        DEFAULT_DOCUMENT_TYPE = BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_MAIN;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.document_type = this.document_type;
        r100.url = this.url;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX22d4957386f22642.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX22d4957386f22642(String r100, BitableDocumentType r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX22d4957386f22642(String r100, BitableDocumentType r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.token = r100;
        this.document_type = r101;
        this.url = r102;
        this._molten_ctx = r103;
    }
}
