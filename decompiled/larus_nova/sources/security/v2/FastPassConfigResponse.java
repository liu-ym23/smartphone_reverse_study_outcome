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
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class FastPassConfigResponse extends Message<FastPassConfigResponse, Builder> {
    public static final ProtoAdapter<FastPassConfigResponse> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_FastPassConfigResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, IndexFactorDetail> index_factor_detail;
    public final Map<String, PolicyTenants> policy_type_tenants;

    public static final class Builder extends Message.Builder<FastPassConfigResponse, Builder> implements d<FastPassConfigResponse> {
        public Map<String, IndexFactorDetail> index_factor_detail;
        public Map<String, PolicyTenants> policy_type_tenants;

        @Override // com.squareup.wire.Message.Builder
        public FastPassConfigResponse build() {
            return new FastPassConfigResponse(this.policy_type_tenants, this.index_factor_detail, super.buildUnknownFields());
        }

        public Builder() {
            this.policy_type_tenants = Internal.newMutableMap();
            this.index_factor_detail = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder index_factor_detail(Map<String, IndexFactorDetail> r100) {
            Internal.checkElementsNotNull(r100);
            this.index_factor_detail = r100;
            return this;
        }

        public Builder policy_type_tenants(Map<String, PolicyTenants> r100) {
            Internal.checkElementsNotNull(r100);
            this.policy_type_tenants = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FastPassConfigResponse extends ProtoAdapter<FastPassConfigResponse> implements c<FastPassConfigResponse> {
        private final ProtoAdapter<Map<String, IndexFactorDetail>> index_factor_detail;
        private final ProtoAdapter<Map<String, PolicyTenants>> policy_type_tenants;

        public ProtoAdapter_FastPassConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FastPassConfigResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.policy_type_tenants = ProtoAdapter.newMapAdapter(r100, PolicyTenants.ADAPTER);
            this.index_factor_detail = ProtoAdapter.newMapAdapter(r100, IndexFactorDetail.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FastPassConfigResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.policy_type_tenants.putAll(this.policy_type_tenants.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.index_factor_detail.putAll(this.index_factor_detail.decode(r100));
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
        public int encodedSize2(FastPassConfigResponse r100) {
            return (this.policy_type_tenants.encodedSizeWithTag(1, r100.policy_type_tenants) + this.index_factor_detail.encodedSizeWithTag(2, r100.index_factor_detail)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FastPassConfigResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FastPassConfigResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FastPassConfigResponse r101) throws IOException {
            this.policy_type_tenants.encodeWithTag(r100, 1, r101.policy_type_tenants);
            this.index_factor_detail.encodeWithTag(r100, 2, r101.index_factor_detail);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FastPassConfigResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FastPassConfigResponse r100 = new ProtoAdapter_FastPassConfigResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.policy_type_tenants = Internal.copyOf("policy_type_tenants", this.policy_type_tenants);
        r100.index_factor_detail = Internal.copyOf("index_factor_detail", this.index_factor_detail);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FastPassConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FastPassConfigResponse(Map<String, PolicyTenants> r100, Map<String, IndexFactorDetail> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FastPassConfigResponse(Map<String, PolicyTenants> r100, Map<String, IndexFactorDetail> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.policy_type_tenants = Internal.immutableCopyOf("policy_type_tenants", r100);
        this.index_factor_detail = Internal.immutableCopyOf("index_factor_detail", r101);
    }
}
