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
public final class FuncParamsX17154e3229a0d50a extends Message<FuncParamsX17154e3229a0d50a, Builder> {
    public static final ProtoAdapter<FuncParamsX17154e3229a0d50a> ADAPTER = null;
    public static final String DEFAULT_OPUS_FILE = "";
    public static final String DEFAULT_WAV_FILE = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String opus_file;
    public final String wav_file;

    public static final class Builder extends Message.Builder<FuncParamsX17154e3229a0d50a, Builder> {
        public ByteString _molten_ctx;
        public String opus_file;
        public String wav_file;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX17154e3229a0d50a build() {
            String r100 = this.opus_file;
            if (r100 == null) goto L9;
            if (this.wav_file == null) goto L9;
            return new FuncParamsX17154e3229a0d50a(this.opus_file, this.wav_file, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "opus_file", this.wav_file, "wav_file"});
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

        public Builder opus_file(String r100) {
            this.opus_file = r100;
            return this;
        }

        public Builder wav_file(String r100) {
            this.wav_file = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX17154e3229a0d50a extends ProtoAdapter<FuncParamsX17154e3229a0d50a> {
        public ProtoAdapter_FuncParamsX17154e3229a0d50a() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX17154e3229a0d50a.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX17154e3229a0d50a decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.opus_file = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.wav_file = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsX17154e3229a0d50a r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.opus_file) + r101.encodedSizeWithTag(2, r100.wav_file);
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
        public /* bridge */ /* synthetic */ FuncParamsX17154e3229a0d50a decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX17154e3229a0d50a r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX17154e3229a0d50a r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.opus_file);
            r102.encodeWithTag(r100, 2, r101.wav_file);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX17154e3229a0d50a r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX17154e3229a0d50a();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.opus_file = this.opus_file;
        r100.wav_file = this.wav_file;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX17154e3229a0d50a.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX17154e3229a0d50a(String r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX17154e3229a0d50a(String r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.opus_file = r100;
        this.wav_file = r101;
        this._molten_ctx = r102;
    }
}
