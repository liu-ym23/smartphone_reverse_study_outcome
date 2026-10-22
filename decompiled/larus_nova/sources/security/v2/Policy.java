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
public final class Policy extends Message<Policy, Builder> {
    public static final ProtoAdapter<Policy> ADAPTER = null;
    public static final String DEFAULT_ADVICE = "";
    public static final String DEFAULT_BASED_ON = "";
    public static final String DEFAULT_COMBINE_ALGORITHM = "";
    public static final Long DEFAULT_CREATED_AT = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_STRATEGY_TYPE = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final Long DEFAULT_UPDATED_AT = null;
    public static final String DEFAULT_VERSION = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String advice;
    public final String based_on;
    public final String combine_algorithm;
    public final Long created_at;
    public final FilterCondition filter_condition;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f541672id;
    public final String name;
    public final List<String> ref_factors;
    public final List<Rule> rules;
    public final String strategy_type;
    public final String tenant_id;
    public final Long updated_at;
    public final String version;

    public static final class Builder extends Message.Builder<Policy, Builder> {
        public String advice;
        public String based_on;
        public String combine_algorithm;
        public Long created_at;
        public FilterCondition filter_condition;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f541673id;
        public String name;
        public List<String> ref_factors;
        public List<Rule> rules;
        public String strategy_type;
        public String tenant_id;
        public Long updated_at;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public Policy build() {
            return new Policy(this.f541673id, this.name, this.tenant_id, this.strategy_type, this.advice, this.filter_condition, this.rules, this.combine_algorithm, this.ref_factors, this.version, this.created_at, this.updated_at, this.based_on, super.buildUnknownFields());
        }

        public Builder() {
            this.rules = Internal.newMutableList();
            this.ref_factors = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder advice(String r100) {
            this.advice = r100;
            return this;
        }

        public Builder based_on(String r100) {
            this.based_on = r100;
            return this;
        }

        public Builder combine_algorithm(String r100) {
            this.combine_algorithm = r100;
            return this;
        }

        public Builder created_at(Long r100) {
            this.created_at = r100;
            return this;
        }

        public Builder filter_condition(FilterCondition r100) {
            this.filter_condition = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f541673id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder ref_factors(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ref_factors = r100;
            return this;
        }

        public Builder rules(List<Rule> r100) {
            Internal.checkElementsNotNull(r100);
            this.rules = r100;
            return this;
        }

        public Builder strategy_type(String r100) {
            this.strategy_type = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder updated_at(Long r100) {
            this.updated_at = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Policy extends ProtoAdapter<Policy> {
        public ProtoAdapter_Policy() {
            super(FieldEncoding.LENGTH_DELIMITED, Policy.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Policy decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f541673id = "";
            r101.name = "";
            r101.tenant_id = "";
            r101.strategy_type = "";
            r101.advice = "";
            r101.combine_algorithm = "";
            r101.version = "";
            r101.created_at = 0L;
            r101.updated_at = 0L;
            r101.based_on = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r101.based_on = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.updated_at = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L9:
            r101.created_at = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.ref_factors.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.combine_algorithm = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.rules.add(Rule.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.filter_condition = FilterCondition.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.advice = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.strategy_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.f541673id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Policy r100) {
            String r101 = r100.f541672id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.tenant_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.strategy_type;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.advice;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            FilterCondition r116 = r100.filter_condition;
            if (r116 == null) goto L25;
            int r117 = FilterCondition.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = (r115 + r117) + Rule.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.rules);
            String r119 = r100.combine_algorithm;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            ProtoAdapter<String> r122 = ProtoAdapter.STRING;
            int r123 = r121 + r122.asRepeated().encodedSizeWithTag(9, r100.ref_factors);
            String r124 = r100.version;
            if (r124 == null) goto L33;
            int r125 = r122.encodedSizeWithTag(10, r124);
        L34:
            int r126 = r123 + r125;
            Long r127 = r100.created_at;
            if (r127 == null) goto L37;
            int r128 = ProtoAdapter.UINT64.encodedSizeWithTag(11, r127);
        L38:
            int r129 = r126 + r128;
            Long r130 = r100.updated_at;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.UINT64.encodedSizeWithTag(12, r130);
        L42:
            int r132 = r129 + r131;
            String r133 = r100.based_on;
            if (r133 == null) goto L46;
            r102 = r122.encodedSizeWithTag(13, r133);
        L46:
            return (r132 + r102) + r100.unknownFields().size();
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Policy decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Policy r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Policy r101) throws IOException {
            String r102 = r101.f541672id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.tenant_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.strategy_type;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.advice;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            FilterCondition r107 = r101.filter_condition;
            if (r107 == null) goto L20;
            FilterCondition.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Rule.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.rules);
            String r108 = r101.combine_algorithm;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            ProtoAdapter<String> r109 = ProtoAdapter.STRING;
            r109.asRepeated().encodeWithTag(r100, 9, r101.ref_factors);
            String r110 = r101.version;
            if (r110 == null) goto L26;
            r109.encodeWithTag(r100, 10, r110);
        L26:
            Long r111 = r101.created_at;
            if (r111 == null) goto L29;
            ProtoAdapter.UINT64.encodeWithTag(r100, 11, r111);
        L29:
            Long r112 = r101.updated_at;
            if (r112 == null) goto L32;
            ProtoAdapter.UINT64.encodeWithTag(r100, 12, r112);
        L32:
            String r113 = r101.based_on;
            if (r113 == null) goto L35;
            r109.encodeWithTag(r100, 13, r113);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Policy r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Policy();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_CREATED_AT = 0L;
        DEFAULT_UPDATED_AT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f541673id = this.f541672id;
        r100.name = this.name;
        r100.tenant_id = this.tenant_id;
        r100.strategy_type = this.strategy_type;
        r100.advice = this.advice;
        r100.filter_condition = this.filter_condition;
        r100.rules = Internal.copyOf("rules", this.rules);
        r100.combine_algorithm = this.combine_algorithm;
        r100.ref_factors = Internal.copyOf("ref_factors", this.ref_factors);
        r100.version = this.version;
        r100.created_at = this.created_at;
        r100.updated_at = this.updated_at;
        r100.based_on = this.based_on;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Policy.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Policy(String r110, String r111, String r112, String r113, String r210, FilterCondition r211, List<Rule> r212, String r213, List<String> r214, String r215, Long r216, Long r217, String r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public Policy(String r100, String r101, String r102, String r103, String r104, FilterCondition r105, List<Rule> r106, String r107, List<String> r110, String r111, Long r112, Long r113, String r114, ByteString r115) {
        super(ADAPTER, r115);
        this.f541672id = r100;
        this.name = r101;
        this.tenant_id = r102;
        this.strategy_type = r103;
        this.advice = r104;
        this.filter_condition = r105;
        this.rules = Internal.immutableCopyOf("rules", r106);
        this.combine_algorithm = r107;
        this.ref_factors = Internal.immutableCopyOf("ref_factors", r110);
        this.version = r111;
        this.created_at = r112;
        this.updated_at = r113;
        this.based_on = r114;
    }
}
