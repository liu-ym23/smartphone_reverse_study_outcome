package tt_cnpa_sdk.proto;

import com.bytedance.pia.core.metrics.ErrorType;
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
public final class FuncParamsX9d78a9352267336e extends Message<FuncParamsX9d78a9352267336e, Builder> {
    public static final ProtoAdapter<FuncParamsX9d78a9352267336e> ADAPTER = null;
    public static final String DEFAULT_INPUT_PATH = "";
    public static final String DEFAULT_OUTPUT_PATH = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String input_path;

    @WireField(adapter = "tt_cnpa_sdk.proto.TtCnpaManifest#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final TtCnpaManifest manifest;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String output_path;

    public static final class Builder extends Message.Builder<FuncParamsX9d78a9352267336e, Builder> {
        public String input_path;
        public TtCnpaManifest manifest;
        public String output_path;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX9d78a9352267336e build() {
            String r100 = this.input_path;
            if (r100 == null) goto L11;
            if (this.output_path == null) goto L11;
            if (this.manifest == null) goto L11;
            return new FuncParamsX9d78a9352267336e(this.input_path, this.output_path, this.manifest, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "input_path", this.output_path, "output_path", this.manifest, ErrorType.MANIFEST});
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

        public Builder manifest(TtCnpaManifest r100) {
            this.manifest = r100;
            return this;
        }

        public Builder output_path(String r100) {
            this.output_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX9d78a9352267336e extends ProtoAdapter<FuncParamsX9d78a9352267336e> {
        public ProtoAdapter_FuncParamsX9d78a9352267336e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX9d78a9352267336e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX9d78a9352267336e decode2(ProtoReader r100) throws IOException {
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
            r101.manifest(TtCnpaManifest.ADAPTER.decode(r100));
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
        public int encodedSize2(FuncParamsX9d78a9352267336e r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.input_path) + r101.encodedSizeWithTag(2, r100.output_path)) + TtCnpaManifest.ADAPTER.encodedSizeWithTag(3, r100.manifest)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX9d78a9352267336e redact2(FuncParamsX9d78a9352267336e r100) {
            Builder r101 = r100.newBuilder();
            r101.manifest = TtCnpaManifest.ADAPTER.redact(r101.manifest);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX9d78a9352267336e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX9d78a9352267336e r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX9d78a9352267336e redact(FuncParamsX9d78a9352267336e r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX9d78a9352267336e r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.input_path);
            r102.encodeWithTag(r100, 2, r101.output_path);
            TtCnpaManifest.ADAPTER.encodeWithTag(r100, 3, r101.manifest);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX9d78a9352267336e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX9d78a9352267336e();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((unknownFields().hashCode() * 37) + this.input_path.hashCode()) * 37) + this.output_path.hashCode()) * 37) + this.manifest.hashCode();
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
        r100.manifest = this.manifest;
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
        r100.append(", manifest=");
        r100.append(this.manifest);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX9d78a9352267336e{");
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
        if ((r100 instanceof FuncParamsX9d78a9352267336e) == true) goto L8;
        return false;
    L8:
        FuncParamsX9d78a9352267336e r101 = (FuncParamsX9d78a9352267336e) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.input_path.equals(r101.input_path) == false) goto L17;
        if (this.output_path.equals(r101.output_path) == false) goto L17;
        if (this.manifest.equals(r101.manifest) == false) goto L17;
        return true;
    }

    public FuncParamsX9d78a9352267336e(String r100, String r101, TtCnpaManifest r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX9d78a9352267336e(String r100, String r101, TtCnpaManifest r102, ByteString r103) {
        super(ADAPTER, r103);
        this.input_path = r100;
        this.output_path = r101;
        this.manifest = r102;
    }
}
