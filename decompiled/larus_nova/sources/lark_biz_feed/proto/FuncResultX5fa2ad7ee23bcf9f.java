package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncResultX5fa2ad7ee23bcf9f extends Message<FuncResultX5fa2ad7ee23bcf9f, Builder> {
    public static final ProtoAdapter<FuncResultX5fa2ad7ee23bcf9f> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final FuncErrorXb20506848349f8f4 err;
    public final FuncReturnXfa2575f514facd38 ret;

    public static final class Builder extends Message.Builder<FuncResultX5fa2ad7ee23bcf9f, Builder> {
        public ByteString _molten_ctx;
        public FuncErrorXb20506848349f8f4 err;
        public FuncReturnXfa2575f514facd38 ret;

        @Override // com.squareup.wire.Message.Builder
        public FuncResultX5fa2ad7ee23bcf9f build() {
            return new FuncResultX5fa2ad7ee23bcf9f(this.ret, this.err, this._molten_ctx, super.buildUnknownFields());
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

        public Builder err(FuncErrorXb20506848349f8f4 r100) {
            this.err = r100;
            return this;
        }

        public Builder ret(FuncReturnXfa2575f514facd38 r100) {
            this.ret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncResultX5fa2ad7ee23bcf9f extends ProtoAdapter<FuncResultX5fa2ad7ee23bcf9f> {
        public ProtoAdapter_FuncResultX5fa2ad7ee23bcf9f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncResultX5fa2ad7ee23bcf9f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncResultX5fa2ad7ee23bcf9f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.ret = FuncReturnXfa2575f514facd38.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.err = FuncErrorXb20506848349f8f4.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncResultX5fa2ad7ee23bcf9f r100) {
            FuncReturnXfa2575f514facd38 r101 = r100.ret;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FuncReturnXfa2575f514facd38.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FuncErrorXb20506848349f8f4 r104 = r100.err;
            if (r104 == null) goto L9;
            int r105 = FuncErrorXb20506848349f8f4.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100._molten_ctx;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r107);
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
        public /* bridge */ /* synthetic */ FuncResultX5fa2ad7ee23bcf9f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncResultX5fa2ad7ee23bcf9f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncResultX5fa2ad7ee23bcf9f r101) throws IOException {
            FuncReturnXfa2575f514facd38 r102 = r101.ret;
            if (r102 == null) goto L5;
            FuncReturnXfa2575f514facd38.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FuncErrorXb20506848349f8f4 r103 = r101.err;
            if (r103 == null) goto L8;
            FuncErrorXb20506848349f8f4.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncResultX5fa2ad7ee23bcf9f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncResultX5fa2ad7ee23bcf9f();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ret = this.ret;
        r100.err = this.err;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncResultX5fa2ad7ee23bcf9f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncResultX5fa2ad7ee23bcf9f(FuncReturnXfa2575f514facd38 r100, FuncErrorXb20506848349f8f4 r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncResultX5fa2ad7ee23bcf9f(FuncReturnXfa2575f514facd38 r100, FuncErrorXb20506848349f8f4 r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ret = r100;
        this.err = r101;
        this._molten_ctx = r102;
    }
}
