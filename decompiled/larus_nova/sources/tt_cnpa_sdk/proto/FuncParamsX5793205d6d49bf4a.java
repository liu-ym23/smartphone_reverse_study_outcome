package tt_cnpa_sdk.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class FuncParamsX5793205d6d49bf4a extends Message<FuncParamsX5793205d6d49bf4a, Builder> {
    public static final ProtoAdapter<FuncParamsX5793205d6d49bf4a> ADAPTER = null;
    public static final String DEFAULT_INPUT_PATH = "";
    public static final String DEFAULT_MANIFEST_JSON = "";
    public static final String DEFAULT_OUTPUT_PATH = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String input_path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String manifest_json;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String output_path;

    public static final class Builder extends Message.Builder<FuncParamsX5793205d6d49bf4a, Builder> {
        public String input_path;
        public String manifest_json;
        public String output_path;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX5793205d6d49bf4a build() {
            String r100 = this.input_path;
            if (r100 == null) goto L11;
            if (this.output_path == null) goto L11;
            if (this.manifest_json == null) goto L11;
            return new FuncParamsX5793205d6d49bf4a(this.input_path, this.output_path, this.manifest_json, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "input_path", this.output_path, "output_path", this.manifest_json, "manifest_json"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder input_path(String r100) {
            this.input_path = r100;
            return this;
        }

        public Builder manifest_json(String r100) {
            this.manifest_json = r100;
            return this;
        }

        public Builder output_path(String r100) {
            this.output_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX5793205d6d49bf4a extends ProtoAdapter<FuncParamsX5793205d6d49bf4a> {
        public ProtoAdapter_FuncParamsX5793205d6d49bf4a() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX5793205d6d49bf4a.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX5793205d6d49bf4a decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.input_path(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.output_path(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.manifest_json(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(FuncParamsX5793205d6d49bf4a r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.input_path) + r101.encodedSizeWithTag(2, r100.output_path)) + r101.encodedSizeWithTag(3, r100.manifest_json)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX5793205d6d49bf4a redact2(FuncParamsX5793205d6d49bf4a r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX5793205d6d49bf4a decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX5793205d6d49bf4a r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX5793205d6d49bf4a redact(FuncParamsX5793205d6d49bf4a r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX5793205d6d49bf4a r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.input_path);
            r102.encodeWithTag(r100, 2, r101.output_path);
            r102.encodeWithTag(r100, 3, r101.manifest_json);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX5793205d6d49bf4a r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX5793205d6d49bf4a();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((unknownFields().hashCode() * 37) + this.input_path.hashCode()) * 37) + this.output_path.hashCode()) * 37) + this.manifest_json.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.input_path = this.input_path;
        r100.output_path = this.output_path;
        r100.manifest_json = this.manifest_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", input_path=");
        r100.append(this.input_path);
        r100.append(", output_path=");
        r100.append(this.output_path);
        r100.append(", manifest_json=");
        r100.append(this.manifest_json);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX5793205d6d49bf4a{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FuncParamsX5793205d6d49bf4a) == true) goto L8;
        return false;
    L8:
        FuncParamsX5793205d6d49bf4a r101 = (FuncParamsX5793205d6d49bf4a) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.input_path.equals(r101.input_path) == false) goto L17;
        if (this.output_path.equals(r101.output_path) == false) goto L17;
        if (this.manifest_json.equals(r101.manifest_json) == false) goto L17;
        return true;
    }

    public FuncParamsX5793205d6d49bf4a(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX5793205d6d49bf4a(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.input_path = r100;
        this.output_path = r101;
        this.manifest_json = r102;
    }
}
