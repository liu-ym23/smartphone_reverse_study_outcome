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
public final class FuncParamsX1564c1b4b2eaf93e extends Message<FuncParamsX1564c1b4b2eaf93e, Builder> {
    public static final ProtoAdapter<FuncParamsX1564c1b4b2eaf93e> ADAPTER = null;
    public static final String DEFAULT_CONFIG_ID = "";
    public static final ByteString DEFAULT_PCM_DATA = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String config_id;
    public final OggOpusEncoderInputInfo info;
    public final ByteString pcm_data;

    public static final class Builder extends Message.Builder<FuncParamsX1564c1b4b2eaf93e, Builder> {
        public ByteString _molten_ctx;
        public String config_id;
        public OggOpusEncoderInputInfo info;
        public ByteString pcm_data;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX1564c1b4b2eaf93e build() {
            ByteString r100 = this.pcm_data;
            if (r100 == null) goto L9;
            if (this.info == null) goto L9;
            return new FuncParamsX1564c1b4b2eaf93e(this.pcm_data, this.info, this.config_id, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "pcm_data", this.info, "info"});
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

        public Builder pcm_data(ByteString r100) {
            this.pcm_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX1564c1b4b2eaf93e extends ProtoAdapter<FuncParamsX1564c1b4b2eaf93e> {
        public ProtoAdapter_FuncParamsX1564c1b4b2eaf93e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX1564c1b4b2eaf93e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX1564c1b4b2eaf93e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.pcm_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.info = OggOpusEncoderInputInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.config_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsX1564c1b4b2eaf93e r100) {
            ProtoAdapter<ByteString> r101 = ProtoAdapter.BYTES;
            int r102 = r101.encodedSizeWithTag(1, r100.pcm_data) + OggOpusEncoderInputInfo.ADAPTER.encodedSizeWithTag(2, r100.info);
            String r103 = r100.config_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            ByteString r107 = r100._molten_ctx;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(255, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX1564c1b4b2eaf93e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX1564c1b4b2eaf93e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX1564c1b4b2eaf93e r101) throws IOException {
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 1, r101.pcm_data);
            OggOpusEncoderInputInfo.ADAPTER.encodeWithTag(r100, 2, r101.info);
            String r103 = r101.config_id;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L5:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 255, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX1564c1b4b2eaf93e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX1564c1b4b2eaf93e();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_PCM_DATA = r100;
        DEFAULT__MOLTEN_CTX = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pcm_data = this.pcm_data;
        r100.info = this.info;
        r100.config_id = this.config_id;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX1564c1b4b2eaf93e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX1564c1b4b2eaf93e(ByteString r100, OggOpusEncoderInputInfo r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX1564c1b4b2eaf93e(ByteString r100, OggOpusEncoderInputInfo r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.pcm_data = r100;
        this.info = r101;
        this.config_id = r102;
        this._molten_ctx = r103;
    }
}
