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
public final class FuncParamsX2c13f0017e641cc2 extends Message<FuncParamsX2c13f0017e641cc2, Builder> {
    public static final ProtoAdapter<FuncParamsX2c13f0017e641cc2> ADAPTER = null;
    public static final ByteString DEFAULT_SRC_BYTES = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tt_cnpa_sdk.proto.TtCnpaManifest#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final TtCnpaManifest manifest;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.REQUIRED, tag = 1)
    public final ByteString src_bytes;

    public static final class Builder extends Message.Builder<FuncParamsX2c13f0017e641cc2, Builder> {
        public TtCnpaManifest manifest;
        public ByteString src_bytes;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX2c13f0017e641cc2 build() {
            ByteString r100 = this.src_bytes;
            if (r100 == null) goto L9;
            if (this.manifest == null) goto L9;
            return new FuncParamsX2c13f0017e641cc2(this.src_bytes, this.manifest, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "src_bytes", this.manifest, ErrorType.MANIFEST});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder manifest(TtCnpaManifest r100) {
            this.manifest = r100;
            return this;
        }

        public Builder src_bytes(ByteString r100) {
            this.src_bytes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX2c13f0017e641cc2 extends ProtoAdapter<FuncParamsX2c13f0017e641cc2> {
        public ProtoAdapter_FuncParamsX2c13f0017e641cc2() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX2c13f0017e641cc2.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX2c13f0017e641cc2 decode2(ProtoReader r100) throws IOException {
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
            r101.manifest(TtCnpaManifest.ADAPTER.decode(r100));
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
        public int encodedSize2(FuncParamsX2c13f0017e641cc2 r100) {
            return (ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.src_bytes) + TtCnpaManifest.ADAPTER.encodedSizeWithTag(2, r100.manifest)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX2c13f0017e641cc2 redact2(FuncParamsX2c13f0017e641cc2 r100) {
            Builder r101 = r100.newBuilder();
            r101.manifest = TtCnpaManifest.ADAPTER.redact(r101.manifest);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX2c13f0017e641cc2 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX2c13f0017e641cc2 r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX2c13f0017e641cc2 redact(FuncParamsX2c13f0017e641cc2 r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX2c13f0017e641cc2 r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.src_bytes);
            TtCnpaManifest.ADAPTER.encodeWithTag(r100, 2, r101.manifest);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX2c13f0017e641cc2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX2c13f0017e641cc2();
        DEFAULT_SRC_BYTES = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((unknownFields().hashCode() * 37) + this.src_bytes.hashCode()) * 37) + this.manifest.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.src_bytes = this.src_bytes;
        r100.manifest = this.manifest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", src_bytes=");
        r100.append(this.src_bytes);
        r100.append(", manifest=");
        r100.append(this.manifest);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX2c13f0017e641cc2{");
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
        if ((r100 instanceof FuncParamsX2c13f0017e641cc2) == true) goto L8;
        return false;
    L8:
        FuncParamsX2c13f0017e641cc2 r101 = (FuncParamsX2c13f0017e641cc2) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.src_bytes.equals(r101.src_bytes) == false) goto L15;
        if (this.manifest.equals(r101.manifest) == false) goto L15;
        return true;
    }

    public FuncParamsX2c13f0017e641cc2(ByteString r100, TtCnpaManifest r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX2c13f0017e641cc2(ByteString r100, TtCnpaManifest r101, ByteString r102) {
        super(ADAPTER, r102);
        this.src_bytes = r100;
        this.manifest = r101;
    }
}
