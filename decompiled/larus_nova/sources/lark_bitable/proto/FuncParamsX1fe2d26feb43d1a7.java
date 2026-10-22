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
public final class FuncParamsX1fe2d26feb43d1a7 extends Message<FuncParamsX1fe2d26feb43d1a7, Builder> {
    public static final ProtoAdapter<FuncParamsX1fe2d26feb43d1a7> ADAPTER = null;
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final Integer DEFAULT_DOC_TYPE = null;
    public static final Boolean DEFAULT_REMOVE_RECENT = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String doc_token;
    public final Integer doc_type;
    public final Boolean remove_recent;

    public static final class Builder extends Message.Builder<FuncParamsX1fe2d26feb43d1a7, Builder> {
        public ByteString _molten_ctx;
        public String doc_token;
        public Integer doc_type;
        public Boolean remove_recent;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX1fe2d26feb43d1a7 build() {
            String r100 = this.doc_token;
            if (r100 == null) goto L11;
            if (this.doc_type == null) goto L11;
            if (this.remove_recent == null) goto L11;
            return new FuncParamsX1fe2d26feb43d1a7(this.doc_token, this.doc_type, this.remove_recent, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "doc_token", this.doc_type, "doc_type", this.remove_recent, "remove_recent"});
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

        public Builder remove_recent(Boolean r100) {
            this.remove_recent = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX1fe2d26feb43d1a7 extends ProtoAdapter<FuncParamsX1fe2d26feb43d1a7> {
        public ProtoAdapter_FuncParamsX1fe2d26feb43d1a7() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX1fe2d26feb43d1a7.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX1fe2d26feb43d1a7 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.doc_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.remove_recent = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(FuncParamsX1fe2d26feb43d1a7 r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.doc_token) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.doc_type)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.remove_recent);
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
        public /* bridge */ /* synthetic */ FuncParamsX1fe2d26feb43d1a7 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX1fe2d26feb43d1a7 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX1fe2d26feb43d1a7 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.doc_token);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.doc_type);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.remove_recent);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX1fe2d26feb43d1a7 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX1fe2d26feb43d1a7();
        DEFAULT_DOC_TYPE = 0;
        DEFAULT_REMOVE_RECENT = Boolean.FALSE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_token = this.doc_token;
        r100.doc_type = this.doc_type;
        r100.remove_recent = this.remove_recent;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX1fe2d26feb43d1a7.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX1fe2d26feb43d1a7(String r100, Integer r101, Boolean r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX1fe2d26feb43d1a7(String r100, Integer r101, Boolean r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.doc_token = r100;
        this.doc_type = r101;
        this.remove_recent = r102;
        this._molten_ctx = r103;
    }
}
