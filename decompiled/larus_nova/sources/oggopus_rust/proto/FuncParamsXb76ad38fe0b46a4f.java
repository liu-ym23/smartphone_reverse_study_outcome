package oggopus_rust.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXb76ad38fe0b46a4f extends Message<FuncParamsXb76ad38fe0b46a4f, Builder> {
    public static final ProtoAdapter<FuncParamsXb76ad38fe0b46a4f> ADAPTER = null;
    public static final String DEFAULT_CONFIG_ID = "";
    public static final String DEFAULT_ENCODED_PATH = "";
    public static final Long DEFAULT_MAX_MS_PER_PAGE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String config_id;
    public final String encoded_path;
    public final OggOpusEncoderInputInfo info;
    public final Long max_ms_per_page;

    public static final class Builder extends Message.Builder<FuncParamsXb76ad38fe0b46a4f, Builder> {
        public ByteString _molten_ctx;
        public String config_id;
        public String encoded_path;
        public OggOpusEncoderInputInfo info;
        public Long max_ms_per_page;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXb76ad38fe0b46a4f build() {
            OggOpusEncoderInputInfo r100 = this.info;
            if (r100 == null) goto L9;
            if (this.max_ms_per_page == null) goto L9;
            return new FuncParamsXb76ad38fe0b46a4f(this.info, this.max_ms_per_page, this.encoded_path, this.config_id, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "info", this.max_ms_per_page, "max_ms_per_page"});
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

        public Builder config_id(String r100) {
            this.config_id = r100;
            return this;
        }

        public Builder encoded_path(String r100) {
            this.encoded_path = r100;
            return this;
        }

        public Builder info(OggOpusEncoderInputInfo r100) {
            this.info = r100;
            return this;
        }

        public Builder max_ms_per_page(Long r100) {
            this.max_ms_per_page = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXb76ad38fe0b46a4f extends ProtoAdapter<FuncParamsXb76ad38fe0b46a4f> {
        public ProtoAdapter_FuncParamsXb76ad38fe0b46a4f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXb76ad38fe0b46a4f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXb76ad38fe0b46a4f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.info = OggOpusEncoderInputInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.max_ms_per_page = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.encoded_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.config_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsXb76ad38fe0b46a4f r100) {
            int r101 = OggOpusEncoderInputInfo.ADAPTER.encodedSizeWithTag(1, r100.info) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.max_ms_per_page);
            String r102 = r100.encoded_path;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.config_id;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            ByteString r109 = r100._molten_ctx;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXb76ad38fe0b46a4f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXb76ad38fe0b46a4f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXb76ad38fe0b46a4f r101) throws IOException {
            OggOpusEncoderInputInfo.ADAPTER.encodeWithTag(r100, 1, r101.info);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.max_ms_per_page);
            String r102 = r101.encoded_path;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            String r103 = r101.config_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXb76ad38fe0b46a4f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXb76ad38fe0b46a4f();
        DEFAULT_MAX_MS_PER_PAGE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.info = this.info;
        r100.max_ms_per_page = this.max_ms_per_page;
        r100.encoded_path = this.encoded_path;
        r100.config_id = this.config_id;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXb76ad38fe0b46a4f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXb76ad38fe0b46a4f(OggOpusEncoderInputInfo r100, Long r101, String r110, String r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsXb76ad38fe0b46a4f(OggOpusEncoderInputInfo r100, Long r101, String r102, String r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.info = r100;
        this.max_ms_per_page = r101;
        this.encoded_path = r102;
        this.config_id = r103;
        this._molten_ctx = r104;
    }
}
