package security.v2;

import annotation.OptionsExt;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class PolicyLog extends Message<PolicyLog, Builder> {
    public static final ProtoAdapter<PolicyLog> ADAPTER = null;
    public static final String DEFAULT_ADVICE = "";
    public static final String DEFAULT_CONTEXT_PARAM = "";
    public static final String DEFAULT_EFFECT = "";
    public static final String DEFAULT_EVALUATE_TIME = "";
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_POLICY_TYPE = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<String> actions;
    public final String advice;
    public final String context_param;
    public final String effect;
    public final List<EnablePolicy> enable_policies;
    public final String evaluate_time;
    public final Map<String, String> extra;
    public final String logid;
    public final String policy_type;
    public final String tenant_id;

    public static final class Builder extends Message.Builder<PolicyLog, Builder> {
        public List<String> actions;
        public String advice;
        public String context_param;
        public String effect;
        public List<EnablePolicy> enable_policies;
        public String evaluate_time;
        public Map<String, String> extra;
        public String logid;
        public String policy_type;
        public String tenant_id;

        @Override // com.squareup.wire.Message.Builder
        public PolicyLog build() {
            return new PolicyLog(this.tenant_id, this.enable_policies, this.context_param, this.evaluate_time, this.logid, this.policy_type, this.effect, this.actions, this.advice, this.extra, super.buildUnknownFields());
        }

        public Builder() {
            this.enable_policies = Internal.newMutableList();
            this.actions = Internal.newMutableList();
            this.extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder actions(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }

        public Builder advice(String r100) {
            this.advice = r100;
            return this;
        }

        public Builder context_param(String r100) {
            this.context_param = r100;
            return this;
        }

        public Builder effect(String r100) {
            this.effect = r100;
            return this;
        }

        public Builder enable_policies(List<EnablePolicy> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_policies = r100;
            return this;
        }

        public Builder evaluate_time(String r100) {
            this.evaluate_time = r100;
            return this;
        }

        public Builder extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra = r100;
            return this;
        }

        public Builder logid(String r100) {
            this.logid = r100;
            return this;
        }

        public Builder policy_type(String r100) {
            this.policy_type = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PolicyLog extends ProtoAdapter<PolicyLog> {
        private final ProtoAdapter<Map<String, String>> extra;

        public ProtoAdapter_PolicyLog() {
            super(FieldEncoding.LENGTH_DELIMITED, PolicyLog.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extra = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PolicyLog decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.tenant_id = "";
            r101.context_param = "";
            r101.evaluate_time = "";
            r101.logid = "";
            r101.policy_type = "";
            r101.effect = "";
            r101.advice = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.extra.putAll(this.extra.decode(r100));
            goto L3
        L8:
            r101.advice = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.actions.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.effect = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.policy_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.logid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.evaluate_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.context_param = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.enable_policies.add(EnablePolicy.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PolicyLog r100) {
            String r101 = r100.tenant_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + EnablePolicy.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.enable_policies);
            String r105 = r100.context_param;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.evaluate_time;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            String r111 = r100.logid;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.STRING.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            String r114 = r100.policy_type;
            if (r114 == null) goto L21;
            int r115 = ProtoAdapter.STRING.encodedSizeWithTag(6, r114);
        L22:
            int r116 = r113 + r115;
            String r117 = r100.effect;
            if (r117 == null) goto L25;
            int r118 = ProtoAdapter.STRING.encodedSizeWithTag(7, r117);
        L26:
            int r119 = r116 + r118;
            ProtoAdapter<String> r120 = ProtoAdapter.STRING;
            int r121 = r119 + r120.asRepeated().encodedSizeWithTag(8, r100.actions);
            String r122 = r100.advice;
            if (r122 == null) goto L30;
            r102 = r120.encodedSizeWithTag(9, r122);
        L30:
            return ((r121 + r102) + this.extra.encodedSizeWithTag(10, r100.extra)) + r100.unknownFields().size();
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PolicyLog decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PolicyLog r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PolicyLog r101) throws IOException {
            String r102 = r101.tenant_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            EnablePolicy.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.enable_policies);
            String r103 = r101.context_param;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.evaluate_time;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.logid;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.policy_type;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.effect;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            ProtoAdapter<String> r108 = ProtoAdapter.STRING;
            r108.asRepeated().encodeWithTag(r100, 8, r101.actions);
            String r109 = r101.advice;
            if (r109 == null) goto L23;
            r108.encodeWithTag(r100, 9, r109);
        L23:
            this.extra.encodeWithTag(r100, 10, r101.extra);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PolicyLog r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PolicyLog();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tenant_id = this.tenant_id;
        r100.enable_policies = Internal.copyOf("enable_policies", this.enable_policies);
        r100.context_param = this.context_param;
        r100.evaluate_time = this.evaluate_time;
        r100.logid = this.logid;
        r100.policy_type = this.policy_type;
        r100.effect = this.effect;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.advice = this.advice;
        r100.extra = Internal.copyOf("extra", this.extra);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PolicyLog.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PolicyLog(String r110, List<EnablePolicy> r111, String r112, String r113, String r114, String r115, String r116, List<String> r210, String r211, Map<String, String> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public PolicyLog(String r100, List<EnablePolicy> r101, String r102, String r103, String r104, String r105, String r106, List<String> r107, String r110, Map<String, String> r111, ByteString r112) {
        super(ADAPTER, r112);
        this.tenant_id = r100;
        this.enable_policies = Internal.immutableCopyOf("enable_policies", r101);
        this.context_param = r102;
        this.evaluate_time = r103;
        this.logid = r104;
        this.policy_type = r105;
        this.effect = r106;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r107);
        this.advice = r110;
        this.extra = Internal.immutableCopyOf("extra", r111);
    }
}
