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
public final class FuncParamsX831b424ecc7bf6a5 extends Message<FuncParamsX831b424ecc7bf6a5, Builder> {
    public static final ProtoAdapter<FuncParamsX831b424ecc7bf6a5> ADAPTER = null;
    public static final String DEFAULT_LABEL = "";
    public static final Boolean DEFAULT_NEED_SIGN = null;
    public static final Boolean DEFAULT_OVERWRITE_EXIST = null;
    public static final String DEFAULT_P_ID = "";
    public static final ByteString DEFAULT_SRC_BYTES = null;
    public static final Boolean DEFAULT_WRITE_AS_PRODUCER = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 6)
    public final Boolean need_sign;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 5)
    public final Boolean overwrite_exist;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String p_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.REQUIRED, tag = 1)
    public final ByteString src_bytes;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 4)
    public final Boolean write_as_producer;

    public static final class Builder extends Message.Builder<FuncParamsX831b424ecc7bf6a5, Builder> {
        public String label;
        public Boolean need_sign;
        public Boolean overwrite_exist;
        public String p_id;
        public ByteString src_bytes;
        public Boolean write_as_producer;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX831b424ecc7bf6a5 build() {
            ByteString r100 = this.src_bytes;
            if (r100 == null) goto L17;
            if (this.label == null) goto L17;
            if (this.p_id == null) goto L17;
            if (this.write_as_producer == null) goto L17;
            if (this.overwrite_exist == null) goto L17;
            if (this.need_sign == null) goto L17;
            return new FuncParamsX831b424ecc7bf6a5(this.src_bytes, this.label, this.p_id, this.write_as_producer, this.overwrite_exist, this.need_sign, super.buildUnknownFields());
        L17:
            throw Internal.missingRequiredFields(new Object[]{r100, "src_bytes", this.label, "label", this.p_id, "p_id", this.write_as_producer, "write_as_producer", this.overwrite_exist, "overwrite_exist", this.need_sign, "need_sign"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder label(String r100) {
            this.label = r100;
            return this;
        }

        public Builder need_sign(Boolean r100) {
            this.need_sign = r100;
            return this;
        }

        public Builder overwrite_exist(Boolean r100) {
            this.overwrite_exist = r100;
            return this;
        }

        public Builder p_id(String r100) {
            this.p_id = r100;
            return this;
        }

        public Builder src_bytes(ByteString r100) {
            this.src_bytes = r100;
            return this;
        }

        public Builder write_as_producer(Boolean r100) {
            this.write_as_producer = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX831b424ecc7bf6a5 extends ProtoAdapter<FuncParamsX831b424ecc7bf6a5> {
        public ProtoAdapter_FuncParamsX831b424ecc7bf6a5() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX831b424ecc7bf6a5.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX831b424ecc7bf6a5 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.need_sign(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            r101.overwrite_exist(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L9:
            r101.write_as_producer(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L10:
            r101.p_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.label(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.src_bytes(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX831b424ecc7bf6a5 r100) {
            int r101 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.src_bytes);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.label)) + r102.encodedSizeWithTag(3, r100.p_id);
            ProtoAdapter<Boolean> r104 = ProtoAdapter.BOOL;
            return (((r103 + r104.encodedSizeWithTag(4, r100.write_as_producer)) + r104.encodedSizeWithTag(5, r100.overwrite_exist)) + r104.encodedSizeWithTag(6, r100.need_sign)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX831b424ecc7bf6a5 redact2(FuncParamsX831b424ecc7bf6a5 r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX831b424ecc7bf6a5 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX831b424ecc7bf6a5 r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX831b424ecc7bf6a5 redact(FuncParamsX831b424ecc7bf6a5 r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX831b424ecc7bf6a5 r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.src_bytes);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.label);
            r102.encodeWithTag(r100, 3, r101.p_id);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            r103.encodeWithTag(r100, 4, r101.write_as_producer);
            r103.encodeWithTag(r100, 5, r101.overwrite_exist);
            r103.encodeWithTag(r100, 6, r101.need_sign);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX831b424ecc7bf6a5 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX831b424ecc7bf6a5();
        DEFAULT_SRC_BYTES = ByteString.EMPTY;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_WRITE_AS_PRODUCER = r100;
        DEFAULT_OVERWRITE_EXIST = r100;
        DEFAULT_NEED_SIGN = r100;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((((((((unknownFields().hashCode() * 37) + this.src_bytes.hashCode()) * 37) + this.label.hashCode()) * 37) + this.p_id.hashCode()) * 37) + this.write_as_producer.hashCode()) * 37) + this.overwrite_exist.hashCode()) * 37) + this.need_sign.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.src_bytes = this.src_bytes;
        r100.label = this.label;
        r100.p_id = this.p_id;
        r100.write_as_producer = this.write_as_producer;
        r100.overwrite_exist = this.overwrite_exist;
        r100.need_sign = this.need_sign;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", src_bytes=");
        r100.append(this.src_bytes);
        r100.append(", label=");
        r100.append(this.label);
        r100.append(", p_id=");
        r100.append(this.p_id);
        r100.append(", write_as_producer=");
        r100.append(this.write_as_producer);
        r100.append(", overwrite_exist=");
        r100.append(this.overwrite_exist);
        r100.append(", need_sign=");
        r100.append(this.need_sign);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX831b424ecc7bf6a5{");
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
        if ((r100 instanceof FuncParamsX831b424ecc7bf6a5) == true) goto L8;
        return false;
    L8:
        FuncParamsX831b424ecc7bf6a5 r101 = (FuncParamsX831b424ecc7bf6a5) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (this.src_bytes.equals(r101.src_bytes) == false) goto L23;
        if (this.label.equals(r101.label) == false) goto L23;
        if (this.p_id.equals(r101.p_id) == false) goto L23;
        if (this.write_as_producer.equals(r101.write_as_producer) == false) goto L23;
        if (this.overwrite_exist.equals(r101.overwrite_exist) == false) goto L23;
        if (this.need_sign.equals(r101.need_sign) == false) goto L23;
        return true;
    }

    public FuncParamsX831b424ecc7bf6a5(ByteString r100, String r110, String r111, Boolean r112, Boolean r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FuncParamsX831b424ecc7bf6a5(ByteString r100, String r101, String r102, Boolean r103, Boolean r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.src_bytes = r100;
        this.label = r101;
        this.p_id = r102;
        this.write_as_producer = r103;
        this.overwrite_exist = r104;
        this.need_sign = r105;
    }
}
