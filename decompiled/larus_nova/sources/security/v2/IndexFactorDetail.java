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
public final class IndexFactorDetail extends Message<IndexFactorDetail, Builder> {
    public static final ProtoAdapter<IndexFactorDetail> ADAPTER = null;
    public static final String DEFAULT_INDEX_FACTOR_KEY = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String index_factor_key;
    public final List<IndexFactorValue> index_factor_values;

    public static final class Builder extends Message.Builder<IndexFactorDetail, Builder> {
        public String index_factor_key;
        public List<IndexFactorValue> index_factor_values;

        @Override // com.squareup.wire.Message.Builder
        public IndexFactorDetail build() {
            String r100 = this.index_factor_key;
            if (r100 == null) goto L7;
            return new IndexFactorDetail(this.index_factor_key, this.index_factor_values, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "index_factor_key"});
        }

        public Builder() {
            this.index_factor_values = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder index_factor_key(String r100) {
            this.index_factor_key = r100;
            return this;
        }

        public Builder index_factor_values(List<IndexFactorValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.index_factor_values = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IndexFactorDetail extends ProtoAdapter<IndexFactorDetail> {
        public ProtoAdapter_IndexFactorDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, IndexFactorDetail.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public IndexFactorDetail decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.index_factor_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.index_factor_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.index_factor_values.add(IndexFactorValue.ADAPTER.decode(r100));
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
        public int encodedSize2(IndexFactorDetail r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.index_factor_key) + IndexFactorValue.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.index_factor_values)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ IndexFactorDetail decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IndexFactorDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IndexFactorDetail r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.index_factor_key);
            IndexFactorValue.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.index_factor_values);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IndexFactorDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IndexFactorDetail();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.index_factor_key = this.index_factor_key;
        r100.index_factor_values = Internal.copyOf("index_factor_values", this.index_factor_values);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IndexFactorDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IndexFactorDetail(String r100, List<IndexFactorValue> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public IndexFactorDetail(String r100, List<IndexFactorValue> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.index_factor_key = r100;
        this.index_factor_values = Internal.immutableCopyOf("index_factor_values", r101);
    }
}
