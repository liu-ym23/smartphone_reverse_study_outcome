package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class IndexFactorValue extends Message<IndexFactorValue, Builder> {
    public static final ProtoAdapter<IndexFactorValue> ADAPTER = null;
    public static final String DEFAULT_ADVICE = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String advice;
    public final List<String> index_factor_values;
    public final String tenant_id;

    public static final class Builder extends Message.Builder<IndexFactorValue, Builder> {
        public String advice;
        public List<String> index_factor_values;
        public String tenant_id;

        @Override // com.squareup.wire.Message.Builder
        public IndexFactorValue build() {
            String r100 = this.tenant_id;
            if (r100 == null) goto L9;
            if (this.advice == null) goto L9;
            return new IndexFactorValue(this.tenant_id, this.advice, this.index_factor_values, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "tenant_id", this.advice, "advice"});
        }

        public Builder() {
            this.index_factor_values = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder advice(String r100) {
            this.advice = r100;
            return this;
        }

        public Builder index_factor_values(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.index_factor_values = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IndexFactorValue extends ProtoAdapter<IndexFactorValue> {
        public ProtoAdapter_IndexFactorValue() {
            super(FieldEncoding.LENGTH_DELIMITED, IndexFactorValue.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public IndexFactorValue decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.tenant_id = "";
            r101.advice = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.advice = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.index_factor_values.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(IndexFactorValue r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.tenant_id) + r101.encodedSizeWithTag(2, r100.advice)) + r101.asRepeated().encodedSizeWithTag(3, r100.index_factor_values)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ IndexFactorValue decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IndexFactorValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IndexFactorValue r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.tenant_id);
            r102.encodeWithTag(r100, 2, r101.advice);
            r102.asRepeated().encodeWithTag(r100, 3, r101.index_factor_values);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IndexFactorValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IndexFactorValue();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tenant_id = this.tenant_id;
        r100.advice = this.advice;
        r100.index_factor_values = Internal.copyOf("index_factor_values", this.index_factor_values);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IndexFactorValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IndexFactorValue(String r100, String r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public IndexFactorValue(String r100, String r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.tenant_id = r100;
        this.advice = r101;
        this.index_factor_values = Internal.immutableCopyOf("index_factor_values", r102);
    }
}
