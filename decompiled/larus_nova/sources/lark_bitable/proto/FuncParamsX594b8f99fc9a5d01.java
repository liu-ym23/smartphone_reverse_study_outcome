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
public final class FuncParamsX594b8f99fc9a5d01 extends Message<FuncParamsX594b8f99fc9a5d01, Builder> {
    public static final ProtoAdapter<FuncParamsX594b8f99fc9a5d01> ADAPTER = null;
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final String DEFAULT_SPACE_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final String doc_token;
    public final String space_token;

    public static final class Builder extends Message.Builder<FuncParamsX594b8f99fc9a5d01, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public String doc_token;
        public String space_token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX594b8f99fc9a5d01 build() {
            String r100 = this.space_token;
            if (r100 == null) goto L11;
            if (this.doc_token == null) goto L11;
            if (this.callback == null) goto L11;
            return new FuncParamsX594b8f99fc9a5d01(this.space_token, this.doc_token, this.callback, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "space_token", this.doc_token, "doc_token", this.callback, "callback"});
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

        public Builder callback(MoltenFfiInstanceMsg r100) {
            this.callback = r100;
            return this;
        }

        public Builder doc_token(String r100) {
            this.doc_token = r100;
            return this;
        }

        public Builder space_token(String r100) {
            this.space_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX594b8f99fc9a5d01 extends ProtoAdapter<FuncParamsX594b8f99fc9a5d01> {
        public ProtoAdapter_FuncParamsX594b8f99fc9a5d01() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX594b8f99fc9a5d01.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX594b8f99fc9a5d01 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.space_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX594b8f99fc9a5d01 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.space_token) + r101.encodedSizeWithTag(2, r100.doc_token)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(3, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX594b8f99fc9a5d01 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX594b8f99fc9a5d01 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX594b8f99fc9a5d01 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.space_token);
            r102.encodeWithTag(r100, 2, r101.doc_token);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 3, r101.callback);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX594b8f99fc9a5d01 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX594b8f99fc9a5d01();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.space_token = this.space_token;
        r100.doc_token = this.doc_token;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX594b8f99fc9a5d01.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX594b8f99fc9a5d01(String r100, String r101, MoltenFfiInstanceMsg r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX594b8f99fc9a5d01(String r100, String r101, MoltenFfiInstanceMsg r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.space_token = r100;
        this.doc_token = r101;
        this.callback = r102;
        this._molten_ctx = r103;
    }
}
