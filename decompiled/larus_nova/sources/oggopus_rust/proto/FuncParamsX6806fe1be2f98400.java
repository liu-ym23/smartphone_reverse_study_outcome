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
public final class FuncParamsX6806fe1be2f98400 extends Message<FuncParamsX6806fe1be2f98400, Builder> {
    public static final ProtoAdapter<FuncParamsX6806fe1be2f98400> ADAPTER = null;
    public static final String DEFAULT_CONFIG_ID = "";
    public static final String DEFAULT_OPUS_FILE = "";
    public static final String DEFAULT_PCM_FILE = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String config_id;
    public final OggOpusEncoderInputInfo info;
    public final String opus_file;
    public final String pcm_file;

    public static final class Builder extends Message.Builder<FuncParamsX6806fe1be2f98400, Builder> {
        public ByteString _molten_ctx;
        public String config_id;
        public OggOpusEncoderInputInfo info;
        public String opus_file;
        public String pcm_file;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX6806fe1be2f98400 build() {
            String r100 = this.pcm_file;
            if (r100 == null) goto L11;
            if (this.opus_file == null) goto L11;
            if (this.info == null) goto L11;
            return new FuncParamsX6806fe1be2f98400(this.pcm_file, this.opus_file, this.info, this.config_id, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "pcm_file", this.opus_file, "opus_file", this.info, "info"});
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

        public Builder info(OggOpusEncoderInputInfo r100) {
            this.info = r100;
            return this;
        }

        public Builder opus_file(String r100) {
            this.opus_file = r100;
            return this;
        }

        public Builder pcm_file(String r100) {
            this.pcm_file = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX6806fe1be2f98400 extends ProtoAdapter<FuncParamsX6806fe1be2f98400> {
        public ProtoAdapter_FuncParamsX6806fe1be2f98400() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX6806fe1be2f98400.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX6806fe1be2f98400 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.pcm_file = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.opus_file = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.info = OggOpusEncoderInputInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX6806fe1be2f98400 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.pcm_file) + r101.encodedSizeWithTag(2, r100.opus_file)) + OggOpusEncoderInputInfo.ADAPTER.encodedSizeWithTag(3, r100.info);
            String r103 = r100.config_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            ByteString r107 = r100._molten_ctx;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX6806fe1be2f98400 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX6806fe1be2f98400 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX6806fe1be2f98400 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.pcm_file);
            r102.encodeWithTag(r100, 2, r101.opus_file);
            OggOpusEncoderInputInfo.ADAPTER.encodeWithTag(r100, 3, r101.info);
            String r103 = r101.config_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX6806fe1be2f98400 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX6806fe1be2f98400();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pcm_file = this.pcm_file;
        r100.opus_file = this.opus_file;
        r100.info = this.info;
        r100.config_id = this.config_id;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX6806fe1be2f98400.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX6806fe1be2f98400(String r100, String r101, OggOpusEncoderInputInfo r110, String r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsX6806fe1be2f98400(String r100, String r101, OggOpusEncoderInputInfo r102, String r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.pcm_file = r100;
        this.opus_file = r101;
        this.info = r102;
        this.config_id = r103;
        this._molten_ctx = r104;
    }
}
