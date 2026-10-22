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
public final class FuncParamsX87d80ad0bc53ee0c extends Message<FuncParamsX87d80ad0bc53ee0c, Builder> {
    public static final ProtoAdapter<FuncParamsX87d80ad0bc53ee0c> ADAPTER = null;
    public static final String DEFAULT_INPUT_FILE_PATH = "";
    public static final String DEFAULT_OUTPUT_FILE_PATH = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String input_file_path;
    public final RawOpusOptions options;
    public final String output_file_path;

    public static final class Builder extends Message.Builder<FuncParamsX87d80ad0bc53ee0c, Builder> {
        public ByteString _molten_ctx;
        public String input_file_path;
        public RawOpusOptions options;
        public String output_file_path;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX87d80ad0bc53ee0c build() {
            String r100 = this.input_file_path;
            if (r100 == null) goto L9;
            if (this.output_file_path == null) goto L9;
            return new FuncParamsX87d80ad0bc53ee0c(this.input_file_path, this.output_file_path, this.options, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "input_file_path", this.output_file_path, "output_file_path"});
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

        public Builder input_file_path(String r100) {
            this.input_file_path = r100;
            return this;
        }

        public Builder options(RawOpusOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder output_file_path(String r100) {
            this.output_file_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX87d80ad0bc53ee0c extends ProtoAdapter<FuncParamsX87d80ad0bc53ee0c> {
        public ProtoAdapter_FuncParamsX87d80ad0bc53ee0c() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX87d80ad0bc53ee0c.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX87d80ad0bc53ee0c decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.input_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.output_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.options = RawOpusOptions.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX87d80ad0bc53ee0c r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.input_file_path) + r101.encodedSizeWithTag(2, r100.output_file_path);
            RawOpusOptions r103 = r100.options;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = RawOpusOptions.ADAPTER.encodedSizeWithTag(3, r103);
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
        public /* bridge */ /* synthetic */ FuncParamsX87d80ad0bc53ee0c decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX87d80ad0bc53ee0c r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX87d80ad0bc53ee0c r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.input_file_path);
            r102.encodeWithTag(r100, 2, r101.output_file_path);
            RawOpusOptions r103 = r101.options;
            if (r103 == null) goto L5;
            RawOpusOptions.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX87d80ad0bc53ee0c r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX87d80ad0bc53ee0c();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.input_file_path = this.input_file_path;
        r100.output_file_path = this.output_file_path;
        r100.options = this.options;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX87d80ad0bc53ee0c.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX87d80ad0bc53ee0c(String r100, String r101, RawOpusOptions r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX87d80ad0bc53ee0c(String r100, String r101, RawOpusOptions r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.input_file_path = r100;
        this.output_file_path = r101;
        this.options = r102;
        this._molten_ctx = r103;
    }
}
