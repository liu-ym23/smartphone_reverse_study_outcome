package security.v2;

import annotation.OptionsExt;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
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
public final class PointCut extends Message<PointCut, Builder> {
    public static final ProtoAdapter<PointCut> ADAPTER = null;
    public static final Integer DEFAULT_FALLBACK_STRATEGY = null;
    public static final String DEFAULT_IDENTIFIER = "";
    public static final Integer DEFAULT_INTERCEPT_PERCENTAGE = null;
    public static final Integer DEFAULT_TIMEOUT_MS = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<String> applied_policy_types;
    public final Map<String, String> context_derivation;
    public final List<String> fallback_actions;
    public final Integer fallback_strategy;
    public final String identifier;
    public final Integer intercept_percentage;
    public final Map<String, String> tags;
    public final Integer timeout_ms;

    public static final class Builder extends Message.Builder<PointCut, Builder> {
        public List<String> applied_policy_types;
        public Map<String, String> context_derivation;
        public List<String> fallback_actions;
        public Integer fallback_strategy;
        public String identifier;
        public Integer intercept_percentage;
        public Map<String, String> tags;
        public Integer timeout_ms;

        @Override // com.squareup.wire.Message.Builder
        public PointCut build() {
            return new PointCut(this.identifier, this.tags, this.context_derivation, this.fallback_strategy, this.intercept_percentage, this.timeout_ms, this.applied_policy_types, this.fallback_actions, super.buildUnknownFields());
        }

        public Builder() {
            this.tags = Internal.newMutableMap();
            this.context_derivation = Internal.newMutableMap();
            this.applied_policy_types = Internal.newMutableList();
            this.fallback_actions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder applied_policy_types(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.applied_policy_types = r100;
            return this;
        }

        public Builder context_derivation(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.context_derivation = r100;
            return this;
        }

        public Builder fallback_actions(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fallback_actions = r100;
            return this;
        }

        public Builder fallback_strategy(Integer r100) {
            this.fallback_strategy = r100;
            return this;
        }

        public Builder identifier(String r100) {
            this.identifier = r100;
            return this;
        }

        public Builder intercept_percentage(Integer r100) {
            this.intercept_percentage = r100;
            return this;
        }

        public Builder tags(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder timeout_ms(Integer r100) {
            this.timeout_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PointCut extends ProtoAdapter<PointCut> {
        private final ProtoAdapter<Map<String, String>> context_derivation;
        private final ProtoAdapter<Map<String, String>> tags;

        public ProtoAdapter_PointCut() {
            super(FieldEncoding.LENGTH_DELIMITED, PointCut.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.tags = ProtoAdapter.newMapAdapter(r100, r100);
            this.context_derivation = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PointCut decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.identifier = "";
            r101.fallback_strategy = 0;
            r101.intercept_percentage = 0;
            r101.timeout_ms = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.fallback_actions.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.applied_policy_types.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.timeout_ms = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.intercept_percentage = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.fallback_strategy = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.context_derivation.putAll(this.context_derivation.decode(r100));
            goto L3
        L13:
            r101.tags.putAll(this.tags.decode(r100));
            goto L3
        L14:
            r101.identifier = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PointCut r100) {
            String r101 = r100.identifier;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + this.tags.encodedSizeWithTag(2, r100.tags)) + this.context_derivation.encodedSizeWithTag(3, r100.context_derivation);
            Integer r105 = r100.fallback_strategy;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT32.encodedSizeWithTag(4, r105);
        L10:
            int r107 = r104 + r106;
            Integer r108 = r100.intercept_percentage;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT32.encodedSizeWithTag(5, r108);
        L14:
            int r110 = r107 + r109;
            Integer r111 = r100.timeout_ms;
            if (r111 == null) goto L17;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(6, r111);
        L17:
            int r112 = r110 + r102;
            ProtoAdapter<String> r113 = ProtoAdapter.STRING;
            return ((r112 + r113.asRepeated().encodedSizeWithTag(7, r100.applied_policy_types)) + r113.asRepeated().encodedSizeWithTag(8, r100.fallback_actions)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PointCut decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PointCut r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PointCut r101) throws IOException {
            String r102 = r101.identifier;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.tags.encodeWithTag(r100, 2, r101.tags);
            this.context_derivation.encodeWithTag(r100, 3, r101.context_derivation);
            Integer r103 = r101.fallback_strategy;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r103);
        L8:
            Integer r104 = r101.intercept_percentage;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L11:
            Integer r105 = r101.timeout_ms;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r105);
        L14:
            ProtoAdapter<String> r106 = ProtoAdapter.STRING;
            r106.asRepeated().encodeWithTag(r100, 7, r101.applied_policy_types);
            r106.asRepeated().encodeWithTag(r100, 8, r101.fallback_actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PointCut r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PointCut();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_FALLBACK_STRATEGY = 0;
        DEFAULT_INTERCEPT_PERCENTAGE = 0;
        DEFAULT_TIMEOUT_MS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.identifier = this.identifier;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.context_derivation = Internal.copyOf("context_derivation", this.context_derivation);
        r100.fallback_strategy = this.fallback_strategy;
        r100.intercept_percentage = this.intercept_percentage;
        r100.timeout_ms = this.timeout_ms;
        r100.applied_policy_types = Internal.copyOf("applied_policy_types", this.applied_policy_types);
        r100.fallback_actions = Internal.copyOf("fallback_actions", this.fallback_actions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PointCut.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PointCut(String r110, Map<String, String> r111, Map<String, String> r112, Integer r113, Integer r114, Integer r115, List<String> r116, List<String> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public PointCut(String r100, Map<String, String> r101, Map<String, String> r102, Integer r103, Integer r104, Integer r105, List<String> r106, List<String> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.identifier = r100;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r101);
        this.context_derivation = Internal.immutableCopyOf("context_derivation", r102);
        this.fallback_strategy = r103;
        this.intercept_percentage = r104;
        this.timeout_ms = r105;
        this.applied_policy_types = Internal.immutableCopyOf("applied_policy_types", r106);
        this.fallback_actions = Internal.immutableCopyOf("fallback_actions", r107);
    }
}
