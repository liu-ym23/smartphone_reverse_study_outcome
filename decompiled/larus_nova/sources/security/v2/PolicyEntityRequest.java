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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class PolicyEntityRequest extends Message<PolicyEntityRequest, Builder> {
    public static final ProtoAdapter<PolicyEntityRequest> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_PolicyEntityRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<PolicyPairEntity> policy_pairs;

    public static final class Builder extends Message.Builder<PolicyEntityRequest, Builder> implements d<PolicyEntityRequest> {
        public List<PolicyPairEntity> policy_pairs;

        @Override // com.squareup.wire.Message.Builder
        public PolicyEntityRequest build() {
            return new PolicyEntityRequest(this.policy_pairs, super.buildUnknownFields());
        }

        public Builder() {
            this.policy_pairs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder policy_pairs(List<PolicyPairEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.policy_pairs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PolicyEntityRequest extends ProtoAdapter<PolicyEntityRequest> implements c<PolicyEntityRequest> {
        public ProtoAdapter_PolicyEntityRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PolicyEntityRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PolicyEntityRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.policy_pairs.add(PolicyPairEntity.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PolicyEntityRequest r100) {
            return PolicyPairEntity.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.policy_pairs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PolicyEntityRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PolicyEntityRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PolicyEntityRequest r101) throws IOException {
            PolicyPairEntity.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.policy_pairs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PolicyEntityRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PolicyEntityRequest r100 = new ProtoAdapter_PolicyEntityRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.policy_pairs = Internal.copyOf("policy_pairs", this.policy_pairs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PolicyEntityRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PolicyEntityRequest(List<PolicyPairEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PolicyEntityRequest(List<PolicyPairEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.policy_pairs = Internal.immutableCopyOf("policy_pairs", r100);
    }
}
