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
public final class TtCnpaManifest extends Message<TtCnpaManifest, Builder> {
    public static final ProtoAdapter<TtCnpaManifest> ADAPTER = null;
    public static final String DEFAULT_CONTENT_PRODUCER = "";
    public static final String DEFAULT_CONTENT_PROPAGATOR = "";
    public static final String DEFAULT_LABEL = "";
    public static final String DEFAULT_PRODUCE_ID = "";
    public static final String DEFAULT_PROPAGATE_ID = "";
    public static final String DEFAULT_RESERVED_CODE1 = "";
    public static final String DEFAULT_RESERVED_CODE2 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String content_producer;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 5)
    public final String content_propagator;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String produce_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 6)
    public final String propagate_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 4)
    public final String reserved_code1;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 7)
    public final String reserved_code2;

    public static final class Builder extends Message.Builder<TtCnpaManifest, Builder> {
        public String content_producer;
        public String content_propagator;
        public String label;
        public String produce_id;
        public String propagate_id;
        public String reserved_code1;
        public String reserved_code2;

        @Override // com.squareup.wire.Message.Builder
        public TtCnpaManifest build() {
            String r100 = this.label;
            if (r100 == null) goto L19;
            if (this.content_producer == null) goto L19;
            if (this.produce_id == null) goto L19;
            if (this.reserved_code1 == null) goto L19;
            if (this.content_propagator == null) goto L19;
            if (this.propagate_id == null) goto L19;
            if (this.reserved_code2 == null) goto L19;
            return new TtCnpaManifest(this.label, this.content_producer, this.produce_id, this.reserved_code1, this.content_propagator, this.propagate_id, this.reserved_code2, super.buildUnknownFields());
        L19:
            throw Internal.missingRequiredFields(new Object[]{r100, "label", this.content_producer, "content_producer", this.produce_id, "produce_id", this.reserved_code1, "reserved_code1", this.content_propagator, "content_propagator", this.propagate_id, "propagate_id", this.reserved_code2, "reserved_code2"});
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

        public Builder label(String r100) {
            this.label = r100;
            return this;
        }

        public Builder produce_id(String r100) {
            this.produce_id = r100;
            return this;
        }

        public Builder propagate_id(String r100) {
            this.propagate_id = r100;
            return this;
        }

        public Builder reserved_code1(String r100) {
            this.reserved_code1 = r100;
            return this;
        }

        public Builder reserved_code2(String r100) {
            this.reserved_code2 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TtCnpaManifest extends ProtoAdapter<TtCnpaManifest> {
        public ProtoAdapter_TtCnpaManifest() {
            super(FieldEncoding.LENGTH_DELIMITED, TtCnpaManifest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TtCnpaManifest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.reserved_code2(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.propagate_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.content_propagator(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.reserved_code1(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.produce_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.content_producer(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.label(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TtCnpaManifest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((((r101.encodedSizeWithTag(1, r100.label) + r101.encodedSizeWithTag(2, r100.content_producer)) + r101.encodedSizeWithTag(3, r100.produce_id)) + r101.encodedSizeWithTag(4, r100.reserved_code1)) + r101.encodedSizeWithTag(5, r100.content_propagator)) + r101.encodedSizeWithTag(6, r100.propagate_id)) + r101.encodedSizeWithTag(7, r100.reserved_code2)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TtCnpaManifest redact2(TtCnpaManifest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCnpaManifest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TtCnpaManifest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCnpaManifest redact(TtCnpaManifest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TtCnpaManifest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.label);
            r102.encodeWithTag(r100, 2, r101.content_producer);
            r102.encodeWithTag(r100, 3, r101.produce_id);
            r102.encodeWithTag(r100, 4, r101.reserved_code1);
            r102.encodeWithTag(r100, 5, r101.content_propagator);
            r102.encodeWithTag(r100, 6, r101.propagate_id);
            r102.encodeWithTag(r100, 7, r101.reserved_code2);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TtCnpaManifest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TtCnpaManifest();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((((((((((unknownFields().hashCode() * 37) + this.label.hashCode()) * 37) + this.content_producer.hashCode()) * 37) + this.produce_id.hashCode()) * 37) + this.reserved_code1.hashCode()) * 37) + this.content_propagator.hashCode()) * 37) + this.propagate_id.hashCode()) * 37) + this.reserved_code2.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.label = this.label;
        r100.content_producer = this.content_producer;
        r100.produce_id = this.produce_id;
        r100.reserved_code1 = this.reserved_code1;
        r100.content_propagator = this.content_propagator;
        r100.propagate_id = this.propagate_id;
        r100.reserved_code2 = this.reserved_code2;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", label=");
        r100.append(this.label);
        r100.append(", content_producer=");
        r100.append(this.content_producer);
        r100.append(", produce_id=");
        r100.append(this.produce_id);
        r100.append(", reserved_code1=");
        r100.append(this.reserved_code1);
        r100.append(", content_propagator=");
        r100.append(this.content_propagator);
        r100.append(", propagate_id=");
        r100.append(this.propagate_id);
        r100.append(", reserved_code2=");
        r100.append(this.reserved_code2);
        StringBuilder r101 = r100.replace(0, 2, "TtCnpaManifest{");
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
        if ((r100 instanceof TtCnpaManifest) == true) goto L8;
        return false;
    L8:
        TtCnpaManifest r101 = (TtCnpaManifest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (this.label.equals(r101.label) == false) goto L25;
        if (this.content_producer.equals(r101.content_producer) == false) goto L25;
        if (this.produce_id.equals(r101.produce_id) == false) goto L25;
        if (this.reserved_code1.equals(r101.reserved_code1) == false) goto L25;
        if (this.content_propagator.equals(r101.content_propagator) == false) goto L25;
        if (this.propagate_id.equals(r101.propagate_id) == false) goto L25;
        if (this.reserved_code2.equals(r101.reserved_code2) == false) goto L25;
        return true;
    }

    public TtCnpaManifest(String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public TtCnpaManifest(String r100, String r101, String r102, String r103, String r104, String r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.label = r100;
        this.content_producer = r101;
        this.produce_id = r102;
        this.reserved_code1 = r103;
        this.content_propagator = r104;
        this.propagate_id = r105;
        this.reserved_code2 = r106;
    }
}
