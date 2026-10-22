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
public final class FuncParamsXd1fd78384beee20d extends Message<FuncParamsXd1fd78384beee20d, Builder> {
    public static final ProtoAdapter<FuncParamsXd1fd78384beee20d> ADAPTER = null;
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final Integer DEFAULT_DOC_TYPE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String doc_token;
    public final Integer doc_type;

    public static final class Builder extends Message.Builder<FuncParamsXd1fd78384beee20d, Builder> {
        public ByteString _molten_ctx;
        public String doc_token;
        public Integer doc_type;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXd1fd78384beee20d build() {
            String r100 = this.doc_token;
            if (r100 == null) goto L9;
            if (this.doc_type == null) goto L9;
            return new FuncParamsXd1fd78384beee20d(this.doc_token, this.doc_type, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "doc_token", this.doc_type, "doc_type"});
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

        public Builder doc_token(String r100) {
            this.doc_token = r100;
            return this;
        }

        public Builder doc_type(Integer r100) {
            this.doc_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXd1fd78384beee20d extends ProtoAdapter<FuncParamsXd1fd78384beee20d> {
        public ProtoAdapter_FuncParamsXd1fd78384beee20d() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXd1fd78384beee20d.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXd1fd78384beee20d decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.doc_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsXd1fd78384beee20d r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.doc_token) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.doc_type);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXd1fd78384beee20d decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXd1fd78384beee20d r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXd1fd78384beee20d r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.doc_token);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.doc_type);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXd1fd78384beee20d r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXd1fd78384beee20d();
        DEFAULT_DOC_TYPE = 0;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_token = this.doc_token;
        r100.doc_type = this.doc_type;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXd1fd78384beee20d.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXd1fd78384beee20d(String r100, Integer r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXd1fd78384beee20d(String r100, Integer r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.doc_token = r100;
        this.doc_type = r101;
        this._molten_ctx = r102;
    }
}
