package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class PolicySetResult extends Message<PolicySetResult, Builder> {
    public static final ProtoAdapter<PolicySetResult> ADAPTER = null;
    public static final Boolean DEFAULT_IS_EVALUATED = null;
    public static final String DEFAULT_POLICY_SET_KEY = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_evaluated;
    public final String policy_set_key;

    public static final class Builder extends Message.Builder<PolicySetResult, Builder> {
        public Boolean is_evaluated;
        public String policy_set_key;

        @Override // com.squareup.wire.Message.Builder
        public PolicySetResult build() {
            return new PolicySetResult(this.policy_set_key, this.is_evaluated, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_evaluated(Boolean r100) {
            this.is_evaluated = r100;
            return this;
        }

        public Builder policy_set_key(String r100) {
            this.policy_set_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PolicySetResult extends ProtoAdapter<PolicySetResult> {
        public ProtoAdapter_PolicySetResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PolicySetResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PolicySetResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.policy_set_key = "";
            r101.is_evaluated = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.policy_set_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_evaluated = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PolicySetResult r100) {
            String r101 = r100.policy_set_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_evaluated;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PolicySetResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PolicySetResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PolicySetResult r101) throws IOException {
            String r102 = r101.policy_set_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_evaluated;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PolicySetResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PolicySetResult();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_IS_EVALUATED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.policy_set_key = this.policy_set_key;
        r100.is_evaluated = this.is_evaluated;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PolicySetResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PolicySetResult(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PolicySetResult(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.policy_set_key = r100;
        this.is_evaluated = r101;
    }
}
