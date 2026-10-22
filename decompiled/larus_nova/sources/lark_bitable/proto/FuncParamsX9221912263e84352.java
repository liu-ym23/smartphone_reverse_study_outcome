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
public final class FuncParamsX9221912263e84352 extends Message<FuncParamsX9221912263e84352, Builder> {
    public static final ProtoAdapter<FuncParamsX9221912263e84352> ADAPTER = null;
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final String DEFAULT_SOURCE_SPACE_TOKEN = "";
    public static final String DEFAULT_TARGET_SPACE_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final String doc_token;
    public final String source_space_token;
    public final String target_space_token;

    public static final class Builder extends Message.Builder<FuncParamsX9221912263e84352, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public String doc_token;
        public String source_space_token;
        public String target_space_token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX9221912263e84352 build() {
            String r100 = this.doc_token;
            if (r100 == null) goto L13;
            if (this.source_space_token == null) goto L13;
            if (this.target_space_token == null) goto L13;
            if (this.callback == null) goto L13;
            return new FuncParamsX9221912263e84352(this.doc_token, this.source_space_token, this.target_space_token, this.callback, this._molten_ctx, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "doc_token", this.source_space_token, "source_space_token", this.target_space_token, "target_space_token", this.callback, "callback"});
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

        public Builder source_space_token(String r100) {
            this.source_space_token = r100;
            return this;
        }

        public Builder target_space_token(String r100) {
            this.target_space_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX9221912263e84352 extends ProtoAdapter<FuncParamsX9221912263e84352> {
        public ProtoAdapter_FuncParamsX9221912263e84352() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX9221912263e84352.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX9221912263e84352 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_space_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.target_space_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 255) goto L15;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX9221912263e84352 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.doc_token) + r101.encodedSizeWithTag(2, r100.source_space_token)) + r101.encodedSizeWithTag(3, r100.target_space_token)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(4, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX9221912263e84352 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX9221912263e84352 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX9221912263e84352 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.doc_token);
            r102.encodeWithTag(r100, 2, r101.source_space_token);
            r102.encodeWithTag(r100, 3, r101.target_space_token);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 4, r101.callback);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX9221912263e84352 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX9221912263e84352();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_token = this.doc_token;
        r100.source_space_token = this.source_space_token;
        r100.target_space_token = this.target_space_token;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX9221912263e84352.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX9221912263e84352(String r100, String r101, String r110, MoltenFfiInstanceMsg r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsX9221912263e84352(String r100, String r101, String r102, MoltenFfiInstanceMsg r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.doc_token = r100;
        this.source_space_token = r101;
        this.target_space_token = r102;
        this.callback = r103;
        this._molten_ctx = r104;
    }
}
