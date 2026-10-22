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
public final class FuncParamsXa8ad6510a6f5e22c extends Message<FuncParamsXa8ad6510a6f5e22c, Builder> {
    public static final ProtoAdapter<FuncParamsXa8ad6510a6f5e22c> ADAPTER = null;
    public static final String DEFAULT_CONTENT_PRODUCER = "";
    public static final String DEFAULT_CONTENT_PROPAGATOR = "";
    public static final Boolean DEFAULT_ENABLE_WRITE_XMP = null;
    public static final String DEFAULT_LOCAL_CONFIG_DIR = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String content_producer;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String content_propagator;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 4)
    public final Boolean enable_write_xmp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String local_config_dir;

    public static final class Builder extends Message.Builder<FuncParamsXa8ad6510a6f5e22c, Builder> {
        public String content_producer;
        public String content_propagator;
        public Boolean enable_write_xmp;
        public String local_config_dir;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXa8ad6510a6f5e22c build() {
            String r100 = this.local_config_dir;
            if (r100 == null) goto L13;
            if (this.content_producer == null) goto L13;
            if (this.content_propagator == null) goto L13;
            if (this.enable_write_xmp == null) goto L13;
            return new FuncParamsXa8ad6510a6f5e22c(this.local_config_dir, this.content_producer, this.content_propagator, this.enable_write_xmp, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "local_config_dir", this.content_producer, "content_producer", this.content_propagator, "content_propagator", this.enable_write_xmp, "enable_write_xmp"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content_producer(String r100) {
            this.content_producer = r100;
            return this;
        }

        public Builder content_propagator(String r100) {
            this.content_propagator = r100;
            return this;
        }

        public Builder enable_write_xmp(Boolean r100) {
            this.enable_write_xmp = r100;
            return this;
        }

        public Builder local_config_dir(String r100) {
            this.local_config_dir = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXa8ad6510a6f5e22c extends ProtoAdapter<FuncParamsXa8ad6510a6f5e22c> {
        public ProtoAdapter_FuncParamsXa8ad6510a6f5e22c() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXa8ad6510a6f5e22c.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXa8ad6510a6f5e22c decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.local_config_dir(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content_producer(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.content_propagator(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.enable_write_xmp(ProtoAdapter.BOOL.decode(r100));
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
        public int encodedSize2(FuncParamsXa8ad6510a6f5e22c r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.local_config_dir) + r101.encodedSizeWithTag(2, r100.content_producer)) + r101.encodedSizeWithTag(3, r100.content_propagator)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r100.enable_write_xmp)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsXa8ad6510a6f5e22c redact2(FuncParamsXa8ad6510a6f5e22c r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXa8ad6510a6f5e22c decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXa8ad6510a6f5e22c r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXa8ad6510a6f5e22c redact(FuncParamsXa8ad6510a6f5e22c r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXa8ad6510a6f5e22c r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.local_config_dir);
            r102.encodeWithTag(r100, 2, r101.content_producer);
            r102.encodeWithTag(r100, 3, r101.content_propagator);
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r101.enable_write_xmp);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXa8ad6510a6f5e22c r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXa8ad6510a6f5e22c();
        DEFAULT_ENABLE_WRITE_XMP = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((((unknownFields().hashCode() * 37) + this.local_config_dir.hashCode()) * 37) + this.content_producer.hashCode()) * 37) + this.content_propagator.hashCode()) * 37) + this.enable_write_xmp.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.local_config_dir = this.local_config_dir;
        r100.content_producer = this.content_producer;
        r100.content_propagator = this.content_propagator;
        r100.enable_write_xmp = this.enable_write_xmp;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", local_config_dir=");
        r100.append(this.local_config_dir);
        r100.append(", content_producer=");
        r100.append(this.content_producer);
        r100.append(", content_propagator=");
        r100.append(this.content_propagator);
        r100.append(", enable_write_xmp=");
        r100.append(this.enable_write_xmp);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsXa8ad6510a6f5e22c{");
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
        if ((r100 instanceof FuncParamsXa8ad6510a6f5e22c) == true) goto L8;
        return false;
    L8:
        FuncParamsXa8ad6510a6f5e22c r101 = (FuncParamsXa8ad6510a6f5e22c) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (this.local_config_dir.equals(r101.local_config_dir) == false) goto L19;
        if (this.content_producer.equals(r101.content_producer) == false) goto L19;
        if (this.content_propagator.equals(r101.content_propagator) == false) goto L19;
        if (this.enable_write_xmp.equals(r101.enable_write_xmp) == false) goto L19;
        return true;
    }

    public FuncParamsXa8ad6510a6f5e22c(String r100, String r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXa8ad6510a6f5e22c(String r100, String r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.local_config_dir = r100;
        this.content_producer = r101;
        this.content_propagator = r102;
        this.enable_write_xmp = r103;
    }
}
