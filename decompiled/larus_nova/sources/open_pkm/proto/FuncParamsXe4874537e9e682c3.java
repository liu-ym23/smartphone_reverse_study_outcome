package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXe4874537e9e682c3 extends Message<FuncParamsXe4874537e9e682c3, Builder> {
    public static final ProtoAdapter<FuncParamsXe4874537e9e682c3> ADAPTER = null;
    public static final Long DEFAULT_EXPECTED_SIZE = null;
    public static final Long DEFAULT_RECEIVED_SIZE = null;
    public static final String DEFAULT_URL = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Long expected_size;
    public final Long received_size;
    public final String url;

    public static final class Builder extends Message.Builder<FuncParamsXe4874537e9e682c3, Builder> {
        public ByteString _molten_ctx;
        public Long expected_size;
        public Long received_size;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXe4874537e9e682c3 build() {
            Long r100 = this.received_size;
            if (r100 == null) goto L11;
            if (this.expected_size == null) goto L11;
            if (this.url == null) goto L11;
            return new FuncParamsXe4874537e9e682c3(this.received_size, this.expected_size, this.url, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "received_size", this.expected_size, "expected_size", this.url, "url"});
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

        public Builder expected_size(Long r100) {
            this.expected_size = r100;
            return this;
        }

        public Builder received_size(Long r100) {
            this.received_size = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXe4874537e9e682c3 extends ProtoAdapter<FuncParamsXe4874537e9e682c3> {
        public ProtoAdapter_FuncParamsXe4874537e9e682c3() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXe4874537e9e682c3.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXe4874537e9e682c3 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.received_size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.expected_size = ProtoAdapter.INT64.decode(r100);
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
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXe4874537e9e682c3 r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = (r101.encodedSizeWithTag(1, r100.received_size) + r101.encodedSizeWithTag(2, r100.expected_size)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.url);
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
        public /* bridge */ /* synthetic */ FuncParamsXe4874537e9e682c3 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXe4874537e9e682c3 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXe4874537e9e682c3 r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.received_size);
            r102.encodeWithTag(r100, 2, r101.expected_size);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.url);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXe4874537e9e682c3 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXe4874537e9e682c3();
        DEFAULT_RECEIVED_SIZE = 0L;
        DEFAULT_EXPECTED_SIZE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.received_size = this.received_size;
        r100.expected_size = this.expected_size;
        r100.url = this.url;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXe4874537e9e682c3.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXe4874537e9e682c3(Long r100, Long r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXe4874537e9e682c3(Long r100, Long r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.received_size = r100;
        this.expected_size = r101;
        this.url = r102;
        this._molten_ctx = r103;
    }
}
