package tt_cnpa_sdk.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class TtCnpaResult extends Message<TtCnpaResult, Builder> {
    public static final ProtoAdapter<TtCnpaResult> ADAPTER = null;
    public static final Long DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_DESC = "";
    public static final String DEFAULT_RAW_JSON_MANIFEST = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long error_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String error_desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 4)
    public final String raw_json_manifest;

    @WireField(adapter = "tt_cnpa_sdk.proto.TtCnpaManifest#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final TtCnpaManifest result_manifest;

    public static final class Builder extends Message.Builder<TtCnpaResult, Builder> {
        public Long error_code;
        public String error_desc;
        public String raw_json_manifest;
        public TtCnpaManifest result_manifest;

        @Override // com.squareup.wire.Message.Builder
        public TtCnpaResult build() {
            Long r100 = this.error_code;
            if (r100 == null) goto L13;
            if (this.error_desc == null) goto L13;
            if (this.result_manifest == null) goto L13;
            if (this.raw_json_manifest == null) goto L13;
            return new TtCnpaResult(this.error_code, this.error_desc, this.result_manifest, this.raw_json_manifest, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "error_code", this.error_desc, GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, this.result_manifest, "result_manifest", this.raw_json_manifest, "raw_json_manifest"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error_code(Long r100) {
            this.error_code = r100;
            return this;
        }

        public Builder error_desc(String r100) {
            this.error_desc = r100;
            return this;
        }

        public Builder raw_json_manifest(String r100) {
            this.raw_json_manifest = r100;
            return this;
        }

        public Builder result_manifest(TtCnpaManifest r100) {
            this.result_manifest = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TtCnpaResult extends ProtoAdapter<TtCnpaResult> {
        public ProtoAdapter_TtCnpaResult() {
            super(FieldEncoding.LENGTH_DELIMITED, TtCnpaResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TtCnpaResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.error_code(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.error_desc(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.result_manifest(TtCnpaManifest.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.raw_json_manifest(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(TtCnpaResult r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.error_code);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return (((r101 + r102.encodedSizeWithTag(2, r100.error_desc)) + TtCnpaManifest.ADAPTER.encodedSizeWithTag(3, r100.result_manifest)) + r102.encodedSizeWithTag(4, r100.raw_json_manifest)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TtCnpaResult redact2(TtCnpaResult r100) {
            Builder r101 = r100.newBuilder();
            r101.result_manifest = TtCnpaManifest.ADAPTER.redact(r101.result_manifest);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCnpaResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TtCnpaResult r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCnpaResult redact(TtCnpaResult r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TtCnpaResult r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.error_code);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.error_desc);
            TtCnpaManifest.ADAPTER.encodeWithTag(r100, 3, r101.result_manifest);
            r102.encodeWithTag(r100, 4, r101.raw_json_manifest);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TtCnpaResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TtCnpaResult();
        DEFAULT_ERROR_CODE = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((((unknownFields().hashCode() * 37) + this.error_code.hashCode()) * 37) + this.error_desc.hashCode()) * 37) + this.result_manifest.hashCode()) * 37) + this.raw_json_manifest.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.error_code = this.error_code;
        r100.error_desc = this.error_desc;
        r100.result_manifest = this.result_manifest;
        r100.raw_json_manifest = this.raw_json_manifest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", error_code=");
        r100.append(this.error_code);
        r100.append(", error_desc=");
        r100.append(this.error_desc);
        r100.append(", result_manifest=");
        r100.append(this.result_manifest);
        r100.append(", raw_json_manifest=");
        r100.append(this.raw_json_manifest);
        StringBuilder r101 = r100.replace(0, 2, "TtCnpaResult{");
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
        if ((r100 instanceof TtCnpaResult) == true) goto L8;
        return false;
    L8:
        TtCnpaResult r101 = (TtCnpaResult) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (this.error_code.equals(r101.error_code) == false) goto L19;
        if (this.error_desc.equals(r101.error_desc) == false) goto L19;
        if (this.result_manifest.equals(r101.result_manifest) == false) goto L19;
        if (this.raw_json_manifest.equals(r101.raw_json_manifest) == false) goto L19;
        return true;
    }

    public TtCnpaResult(Long r100, String r101, TtCnpaManifest r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TtCnpaResult(Long r100, String r101, TtCnpaManifest r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.error_code = r100;
        this.error_desc = r101;
        this.result_manifest = r102;
        this.raw_json_manifest = r103;
    }
}
