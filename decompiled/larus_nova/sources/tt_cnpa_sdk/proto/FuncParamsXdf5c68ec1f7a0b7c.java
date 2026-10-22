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
public final class FuncParamsXdf5c68ec1f7a0b7c extends Message<FuncParamsXdf5c68ec1f7a0b7c, Builder> {
    public static final ProtoAdapter<FuncParamsXdf5c68ec1f7a0b7c> ADAPTER = null;
    public static final String DEFAULT_MANIFEST_JSON = "";
    public static final ByteString DEFAULT_SRC_BYTES = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String manifest_json;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.REQUIRED, tag = 1)
    public final ByteString src_bytes;

    public static final class Builder extends Message.Builder<FuncParamsXdf5c68ec1f7a0b7c, Builder> {
        public String manifest_json;
        public ByteString src_bytes;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXdf5c68ec1f7a0b7c build() {
            ByteString r100 = this.src_bytes;
            if (r100 == null) goto L9;
            if (this.manifest_json == null) goto L9;
            return new FuncParamsXdf5c68ec1f7a0b7c(this.src_bytes, this.manifest_json, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "src_bytes", this.manifest_json, "manifest_json"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder manifest_json(String r100) {
            this.manifest_json = r100;
            return this;
        }

        public Builder src_bytes(ByteString r100) {
            this.src_bytes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXdf5c68ec1f7a0b7c extends ProtoAdapter<FuncParamsXdf5c68ec1f7a0b7c> {
        public ProtoAdapter_FuncParamsXdf5c68ec1f7a0b7c() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXdf5c68ec1f7a0b7c.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXdf5c68ec1f7a0b7c decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.src_bytes(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.manifest_json(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXdf5c68ec1f7a0b7c r100) {
            return (ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.src_bytes) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.manifest_json)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsXdf5c68ec1f7a0b7c redact2(FuncParamsXdf5c68ec1f7a0b7c r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXdf5c68ec1f7a0b7c decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXdf5c68ec1f7a0b7c r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXdf5c68ec1f7a0b7c redact(FuncParamsXdf5c68ec1f7a0b7c r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXdf5c68ec1f7a0b7c r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.src_bytes);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.manifest_json);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXdf5c68ec1f7a0b7c r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXdf5c68ec1f7a0b7c();
        DEFAULT_SRC_BYTES = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((unknownFields().hashCode() * 37) + this.src_bytes.hashCode()) * 37) + this.manifest_json.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.src_bytes = this.src_bytes;
        r100.manifest_json = this.manifest_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", src_bytes=");
        r100.append(this.src_bytes);
        r100.append(", manifest_json=");
        r100.append(this.manifest_json);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsXdf5c68ec1f7a0b7c{");
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
        if ((r100 instanceof FuncParamsXdf5c68ec1f7a0b7c) == true) goto L8;
        return false;
    L8:
        FuncParamsXdf5c68ec1f7a0b7c r101 = (FuncParamsXdf5c68ec1f7a0b7c) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.src_bytes.equals(r101.src_bytes) == false) goto L15;
        if (this.manifest_json.equals(r101.manifest_json) == false) goto L15;
        return true;
    }

    public FuncParamsXdf5c68ec1f7a0b7c(ByteString r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsXdf5c68ec1f7a0b7c(ByteString r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.src_bytes = r100;
        this.manifest_json = r101;
    }
}
