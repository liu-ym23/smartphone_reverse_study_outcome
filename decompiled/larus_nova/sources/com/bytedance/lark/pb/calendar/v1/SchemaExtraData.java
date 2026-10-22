package com.bytedance.lark.pb.calendar.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class SchemaExtraData extends Message<SchemaExtraData, Builder> {
    public static final ProtoAdapter<SchemaExtraData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<BizData> biz_data;

    public static final class ApprovalRequest extends Message<ApprovalRequest, Builder> {
        public static final ProtoAdapter<ApprovalRequest> ADAPTER = null;
        public static final String DEFAULT_CREATE_CHATTER_ID = "";
        public static final String DEFAULT_REASON = "";
        private static final long serialVersionUID = 0;
        public final List<String> approver_user_ids;
        public final String create_chatter_id;
        public final String reason;
        public final ApprovalTrigger trigger;

        public static final class Builder extends Message.Builder<ApprovalRequest, Builder> {
            public List<String> approver_user_ids;
            public String create_chatter_id;
            public String reason;
            public ApprovalTrigger trigger;

            @Override // com.squareup.wire.Message.Builder
            public ApprovalRequest build() {
                return new ApprovalRequest(this.reason, this.approver_user_ids, this.create_chatter_id, this.trigger, super.buildUnknownFields());
            }

            public Builder() {
                this.approver_user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder approver_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.approver_user_ids = r100;
                return this;
            }

            public Builder create_chatter_id(String r100) {
                this.create_chatter_id = r100;
                return this;
            }

            public Builder reason(String r100) {
                this.reason = r100;
                return this;
            }

            public Builder trigger(ApprovalTrigger r100) {
                this.trigger = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ApprovalRequest extends ProtoAdapter<ApprovalRequest> {
            public ProtoAdapter_ApprovalRequest() {
                super(FieldEncoding.LENGTH_DELIMITED, ApprovalRequest.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ApprovalRequest decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.reason = "";
                r101.create_chatter_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.reason = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.approver_user_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.create_chatter_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.trigger = ApprovalTrigger.ADAPTER.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ApprovalRequest r100) {
                String r101 = r100.reason;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.approver_user_ids);
                String r106 = r100.create_chatter_id;
                if (r106 == null) goto L9;
                int r107 = r104.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                ApprovalTrigger r109 = r100.trigger;
                if (r109 == null) goto L14;
                r102 = ApprovalTrigger.ADAPTER.encodedSizeWithTag(4, r109);
            L14:
                return (r108 + r102) + r100.unknownFields().size();
            L9:
                r107 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ApprovalRequest decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ApprovalRequest r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ApprovalRequest r101) throws IOException {
                String r102 = r101.reason;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<String> r103 = ProtoAdapter.STRING;
                r103.asRepeated().encodeWithTag(r100, 2, r101.approver_user_ids);
                String r104 = r101.create_chatter_id;
                if (r104 == null) goto L8;
                r103.encodeWithTag(r100, 3, r104);
            L8:
                ApprovalTrigger r105 = r101.trigger;
                if (r105 == null) goto L11;
                ApprovalTrigger.ADAPTER.encodeWithTag(r100, 4, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ApprovalRequest r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ApprovalRequest();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.reason = this.reason;
            r100.approver_user_ids = Internal.copyOf("approver_user_ids", this.approver_user_ids);
            r100.create_chatter_id = this.create_chatter_id;
            r100.trigger = this.trigger;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ApprovalRequest.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ApprovalRequest(String r100, List<String> r101, String r102, ApprovalTrigger r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ApprovalRequest(String r100, List<String> r101, String r102, ApprovalTrigger r103, ByteString r104) {
            super(ADAPTER, r104);
            this.reason = r100;
            this.approver_user_ids = Internal.immutableCopyOf("approver_user_ids", r101);
            this.create_chatter_id = r102;
            this.trigger = r103;
        }
    }

    public static final class ApprovalTrigger extends Message<ApprovalTrigger, Builder> {
        public static final ProtoAdapter<ApprovalTrigger> ADAPTER = null;
        public static final Long DEFAULT_DURATION_TRIGGER = null;
        private static final long serialVersionUID = 0;
        public final Long duration_trigger;

        public static final class Builder extends Message.Builder<ApprovalTrigger, Builder> {
            public Long duration_trigger;

            @Override // com.squareup.wire.Message.Builder
            public ApprovalTrigger build() {
                return new ApprovalTrigger(this.duration_trigger, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder duration_trigger(Long r100) {
                this.duration_trigger = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ApprovalTrigger extends ProtoAdapter<ApprovalTrigger> {
            public ProtoAdapter_ApprovalTrigger() {
                super(FieldEncoding.LENGTH_DELIMITED, ApprovalTrigger.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ApprovalTrigger decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.duration_trigger = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.duration_trigger = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(ApprovalTrigger r100) {
                Long r101 = r100.duration_trigger;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ApprovalTrigger decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ApprovalTrigger r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ApprovalTrigger r101) throws IOException {
                Long r102 = r101.duration_trigger;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ApprovalTrigger r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ApprovalTrigger();
            DEFAULT_DURATION_TRIGGER = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.duration_trigger = this.duration_trigger;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ApprovalTrigger.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ApprovalTrigger(Long r100) {
            this(r100, ByteString.EMPTY);
        }

        public ApprovalTrigger(Long r100, ByteString r101) {
            super(ADAPTER, r101);
            this.duration_trigger = r100;
        }
    }

    public static final class BizData extends Message<BizData, Builder> {
        public static final ProtoAdapter<BizData> ADAPTER = null;
        public static final Type DEFAULT_TYPE = null;
        public static final FieldOptions FIELD_OPTIONS_APPROVAL_REQUEST = null;
        public static final FieldOptions FIELD_OPTIONS_RESOURCE_APPROVAL_INFO = null;
        public static final FieldOptions FIELD_OPTIONS_RESOURCE_CUSTOMIZATION = null;
        public static final FieldOptions FIELD_OPTIONS_RESOURCE_REQUISITION = null;
        public static final FieldOptions FIELD_OPTIONS_RESOURCE_STRATEGY = null;
        private static final long serialVersionUID = 0;
        public final ApprovalRequest approval_request;
        public final ResourceApprovalInfo resource_approval_info;
        public final ResourceCustomization resource_customization;
        public final ResourceRequisition resource_requisition;
        public final ResourceStrategy resource_strategy;
        public final Type type;

        public static final class Builder extends Message.Builder<BizData, Builder> {
            public ApprovalRequest approval_request;
            public ResourceApprovalInfo resource_approval_info;
            public ResourceCustomization resource_customization;
            public ResourceRequisition resource_requisition;
            public ResourceStrategy resource_strategy;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public BizData build() {
                Type r100 = this.type;
                if (r100 == null) goto L7;
                return new BizData(this.type, this.resource_approval_info, this.approval_request, this.resource_strategy, this.resource_requisition, this.resource_customization, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder approval_request(ApprovalRequest r100) {
                this.approval_request = r100;
                this.resource_approval_info = null;
                this.resource_strategy = null;
                this.resource_requisition = null;
                this.resource_customization = null;
                return this;
            }

            public Builder resource_approval_info(ResourceApprovalInfo r100) {
                this.resource_approval_info = r100;
                this.approval_request = null;
                this.resource_strategy = null;
                this.resource_requisition = null;
                this.resource_customization = null;
                return this;
            }

            public Builder resource_customization(ResourceCustomization r100) {
                this.resource_customization = r100;
                this.resource_approval_info = null;
                this.approval_request = null;
                this.resource_strategy = null;
                this.resource_requisition = null;
                return this;
            }

            public Builder resource_requisition(ResourceRequisition r100) {
                this.resource_requisition = r100;
                this.resource_approval_info = null;
                this.approval_request = null;
                this.resource_strategy = null;
                this.resource_customization = null;
                return this;
            }

            public Builder resource_strategy(ResourceStrategy r100) {
                this.resource_strategy = r100;
                this.resource_approval_info = null;
                this.approval_request = null;
                this.resource_requisition = null;
                this.resource_customization = null;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BizData extends ProtoAdapter<BizData> {
            public ProtoAdapter_BizData() {
                super(FieldEncoding.LENGTH_DELIMITED, BizData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BizData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L7;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                switch(r103) {
                    case 100: goto L13;
                    case 101: goto L12;
                    case 102: goto L11;
                    case 103: goto L10;
                    case 104: goto L9;
                    default: goto L8;
                };
            L9:
                r101.resource_customization(ResourceCustomization.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.resource_requisition(ResourceRequisition.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.resource_strategy(ResourceStrategy.ADAPTER.decode(r100));
                goto L3
            L12:
                r101.approval_request(ApprovalRequest.ADAPTER.decode(r100));
                goto L3
            L13:
                r101.resource_approval_info(ResourceApprovalInfo.ADAPTER.decode(r100));
                goto L3
            L8:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(BizData r100) {
                int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
                ResourceApprovalInfo r102 = r100.resource_approval_info;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ResourceApprovalInfo.ADAPTER.encodedSizeWithTag(100, r102);
            L6:
                int r105 = r101 + r104;
                ApprovalRequest r106 = r100.approval_request;
                if (r106 == null) goto L9;
                int r107 = ApprovalRequest.ADAPTER.encodedSizeWithTag(101, r106);
            L10:
                int r108 = r105 + r107;
                ResourceStrategy r109 = r100.resource_strategy;
                if (r109 == null) goto L13;
                int r110 = ResourceStrategy.ADAPTER.encodedSizeWithTag(102, r109);
            L14:
                int r111 = r108 + r110;
                ResourceRequisition r112 = r100.resource_requisition;
                if (r112 == null) goto L17;
                int r113 = ResourceRequisition.ADAPTER.encodedSizeWithTag(103, r112);
            L18:
                int r114 = r111 + r113;
                ResourceCustomization r115 = r100.resource_customization;
                if (r115 == null) goto L22;
                r103 = ResourceCustomization.ADAPTER.encodedSizeWithTag(104, r115);
            L22:
                return (r114 + r103) + r100.unknownFields().size();
            L17:
                r113 = 0;
                goto L18
            L13:
                r110 = 0;
                goto L14
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BizData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BizData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BizData r101) throws IOException {
                Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
                ResourceApprovalInfo r102 = r101.resource_approval_info;
                if (r102 == null) goto L5;
                ResourceApprovalInfo.ADAPTER.encodeWithTag(r100, 100, r102);
            L5:
                ApprovalRequest r103 = r101.approval_request;
                if (r103 == null) goto L8;
                ApprovalRequest.ADAPTER.encodeWithTag(r100, 101, r103);
            L8:
                ResourceStrategy r104 = r101.resource_strategy;
                if (r104 == null) goto L11;
                ResourceStrategy.ADAPTER.encodeWithTag(r100, 102, r104);
            L11:
                ResourceRequisition r105 = r101.resource_requisition;
                if (r105 == null) goto L14;
                ResourceRequisition.ADAPTER.encodeWithTag(r100, 103, r105);
            L14:
                ResourceCustomization r106 = r101.resource_customization;
                if (r106 == null) goto L17;
                ResourceCustomization.ADAPTER.encodeWithTag(r100, 104, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BizData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BizData();
            FIELD_OPTIONS_RESOURCE_APPROVAL_INFO = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_APPROVAL_REQUEST = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_RESOURCE_STRATEGY = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_RESOURCE_REQUISITION = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_RESOURCE_CUSTOMIZATION = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_TYPE = Type.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.resource_approval_info = this.resource_approval_info;
            r100.approval_request = this.approval_request;
            r100.resource_strategy = this.resource_strategy;
            r100.resource_requisition = this.resource_requisition;
            r100.resource_customization = this.resource_customization;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BizData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public BizData(Type r100, ResourceApprovalInfo r110, ApprovalRequest r111, ResourceStrategy r112, ResourceRequisition r113, ResourceCustomization r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public BizData(Type r100, ResourceApprovalInfo r101, ApprovalRequest r102, ResourceStrategy r103, ResourceRequisition r104, ResourceCustomization r105, ByteString r106) {
            super(ADAPTER, r106);
            if (Internal.countNonNull(r101, r102, r103, r104, new Object[]{r105}) > 1) goto L7;
            this.type = r100;
            this.resource_approval_info = r101;
            this.approval_request = r102;
            this.resource_strategy = r103;
            this.resource_requisition = r104;
            this.resource_customization = r105;
            return;
        L7:
            throw new IllegalArgumentException("at most one of resource_approval_info, approval_request, resource_strategy, resource_requisition, resource_customization may be non-null");
        }
    }

    public static final class Builder extends Message.Builder<SchemaExtraData, Builder> {
        public List<BizData> biz_data;

        @Override // com.squareup.wire.Message.Builder
        public SchemaExtraData build() {
            return new SchemaExtraData(this.biz_data, super.buildUnknownFields());
        }

        public Builder() {
            this.biz_data = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_data(List<BizData> r100) {
            Internal.checkElementsNotNull(r100);
            this.biz_data = r100;
            return this;
        }
    }

    public static final class CustomizationData extends Message<CustomizationData, Builder> {
        public static final ProtoAdapter<CustomizationData> ADAPTER = null;
        public static final CustomizationType DEFAULT_CUSTOMIZATION_TYPE = null;
        public static final String DEFAULT_INDEX_KEY = "";
        public static final String DEFAULT_INPUT_CONTENT = "";
        public static final Boolean DEFAULT_IS_REQUIRED = null;
        public static final String DEFAULT_LABEL = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        private static final long serialVersionUID = 0;
        public final List<OptionCondition> conditions;
        public final CustomizationType customization_type;
        public final String index_key;
        public final String input_content;
        public final Boolean is_required;
        public final String label;
        public final List<CustomizationOption> options;
        public final String place_holder;

        public static final class Builder extends Message.Builder<CustomizationData, Builder> {
            public List<OptionCondition> conditions;
            public CustomizationType customization_type;
            public String index_key;
            public String input_content;
            public Boolean is_required;
            public String label;
            public List<CustomizationOption> options;
            public String place_holder;

            @Override // com.squareup.wire.Message.Builder
            public CustomizationData build() {
                return new CustomizationData(this.customization_type, this.is_required, this.label, this.index_key, this.options, this.conditions, this.input_content, this.place_holder, super.buildUnknownFields());
            }

            public Builder() {
                this.options = Internal.newMutableList();
                this.conditions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder conditions(List<OptionCondition> r100) {
                Internal.checkElementsNotNull(r100);
                this.conditions = r100;
                return this;
            }

            public Builder customization_type(CustomizationType r100) {
                this.customization_type = r100;
                return this;
            }

            public Builder index_key(String r100) {
                this.index_key = r100;
                return this;
            }

            public Builder input_content(String r100) {
                this.input_content = r100;
                return this;
            }

            public Builder is_required(Boolean r100) {
                this.is_required = r100;
                return this;
            }

            public Builder label(String r100) {
                this.label = r100;
                return this;
            }

            public Builder options(List<CustomizationOption> r100) {
                Internal.checkElementsNotNull(r100);
                this.options = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.place_holder = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomizationData extends ProtoAdapter<CustomizationData> {
            public ProtoAdapter_CustomizationData() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomizationData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomizationData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.customization_type = CustomizationType.SingleSelect;
                r101.is_required = Boolean.FALSE;
                r101.label = "";
                r101.index_key = "";
                r101.input_content = "";
                r101.place_holder = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                switch(r103) {
                    case 1: goto L20;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L20:
                r101.customization_type = CustomizationType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.place_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.input_content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.conditions.add(OptionCondition.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.options.add(CustomizationOption.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.index_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.label = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.is_required = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CustomizationData r100) {
                CustomizationType r101 = r100.customization_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = CustomizationType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_required;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.label;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.index_key;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = ((r109 + r111) + CustomizationOption.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.options)) + OptionCondition.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.conditions);
                String r113 = r100.input_content;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(7, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.place_holder;
                if (r116 == null) goto L26;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ CustomizationData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomizationData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomizationData r101) throws IOException {
                CustomizationType r102 = r101.customization_type;
                if (r102 == null) goto L5;
                CustomizationType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_required;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.label;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.index_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                CustomizationOption.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.options);
                OptionCondition.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.conditions);
                String r106 = r101.input_content;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r106);
            L17:
                String r107 = r101.place_holder;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomizationData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomizationData();
            DEFAULT_CUSTOMIZATION_TYPE = CustomizationType.SingleSelect;
            DEFAULT_IS_REQUIRED = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.customization_type = this.customization_type;
            r100.is_required = this.is_required;
            r100.label = this.label;
            r100.index_key = this.index_key;
            r100.options = Internal.copyOf("options", this.options);
            r100.conditions = Internal.copyOf("conditions", this.conditions);
            r100.input_content = this.input_content;
            r100.place_holder = this.place_holder;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomizationData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomizationData(CustomizationType r110, Boolean r111, String r112, String r113, List<CustomizationOption> r114, List<OptionCondition> r115, String r116, String r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public CustomizationData(CustomizationType r100, Boolean r101, String r102, String r103, List<CustomizationOption> r104, List<OptionCondition> r105, String r106, String r107, ByteString r110) {
            super(ADAPTER, r110);
            this.customization_type = r100;
            this.is_required = r101;
            this.label = r102;
            this.index_key = r103;
            this.options = Internal.immutableCopyOf("options", r104);
            this.conditions = Internal.immutableCopyOf("conditions", r105);
            this.input_content = r106;
            this.place_holder = r107;
        }
    }

    public static final class CustomizationOption extends Message<CustomizationOption, Builder> {
        public static final ProtoAdapter<CustomizationOption> ADAPTER = null;
        public static final Boolean DEFAULT_IS_OTHERS = null;
        public static final Boolean DEFAULT_IS_SELECTED = null;
        public static final String DEFAULT_OPTION_IMAGE_URL = "";
        public static final String DEFAULT_OPTION_KEY = "";
        public static final String DEFAULT_OPTION_LABEL = "";
        public static final String DEFAULT_OTHERS_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final Boolean is_others;
        public final Boolean is_selected;
        public final String option_image_url;
        public final String option_key;
        public final String option_label;
        public final String others_content;

        public static final class Builder extends Message.Builder<CustomizationOption, Builder> {
            public Boolean is_others;
            public Boolean is_selected;
            public String option_image_url;
            public String option_key;
            public String option_label;
            public String others_content;

            @Override // com.squareup.wire.Message.Builder
            public CustomizationOption build() {
                return new CustomizationOption(this.is_others, this.others_content, this.option_label, this.option_image_url, this.option_key, this.is_selected, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_others(Boolean r100) {
                this.is_others = r100;
                return this;
            }

            public Builder is_selected(Boolean r100) {
                this.is_selected = r100;
                return this;
            }

            public Builder option_image_url(String r100) {
                this.option_image_url = r100;
                return this;
            }

            public Builder option_key(String r100) {
                this.option_key = r100;
                return this;
            }

            public Builder option_label(String r100) {
                this.option_label = r100;
                return this;
            }

            public Builder others_content(String r100) {
                this.others_content = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomizationOption extends ProtoAdapter<CustomizationOption> {
            public ProtoAdapter_CustomizationOption() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomizationOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomizationOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_others = r102;
                r101.others_content = "";
                r101.option_label = "";
                r101.option_image_url = "";
                r101.option_key = "";
                r101.is_selected = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L13;
                switch(r104) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.is_selected = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.option_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.option_image_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.option_label = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.others_content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.is_others = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CustomizationOption r100) {
                Boolean r101 = r100.is_others;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.others_content;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.option_label;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.option_image_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.option_key;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_selected;
                if (r116 == null) goto L26;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ CustomizationOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomizationOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomizationOption r101) throws IOException {
                Boolean r102 = r101.is_others;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.others_content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.option_label;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.option_image_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.option_key;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_selected;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomizationOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomizationOption();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_OTHERS = r100;
            DEFAULT_IS_SELECTED = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_others = this.is_others;
            r100.others_content = this.others_content;
            r100.option_label = this.option_label;
            r100.option_image_url = this.option_image_url;
            r100.option_key = this.option_key;
            r100.is_selected = this.is_selected;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomizationOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomizationOption(Boolean r100, String r110, String r111, String r112, String r113, Boolean r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public CustomizationOption(Boolean r100, String r101, String r102, String r103, String r104, Boolean r105, ByteString r106) {
            super(ADAPTER, r106);
            this.is_others = r100;
            this.others_content = r101;
            this.option_label = r102;
            this.option_image_url = r103;
            this.option_key = r104;
            this.is_selected = r105;
        }
    }

    public static final enum CustomizationType extends Enum<CustomizationType> implements WireEnum {
        private static final /* synthetic */ CustomizationType[] $VALUES = null;
        public static final ProtoAdapter<CustomizationType> ADAPTER = null;
        public static final CustomizationType Input = null;
        public static final CustomizationType MultipleSelect = null;
        public static final CustomizationType SingleSelect = null;
        private final int value;

        static {
            CustomizationType r100 = new CustomizationType("SingleSelect", 0, 1);
            SingleSelect = r100;
            CustomizationType r101 = new CustomizationType("MultipleSelect", 1, 2);
            MultipleSelect = r101;
            CustomizationType r102 = new CustomizationType("Input", 2, 3);
            Input = r102;
            $VALUES = new CustomizationType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CustomizationType.class);
        }

        public static CustomizationType[] values() {
            return (CustomizationType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CustomizationType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return Input;
        L13:
            return MultipleSelect;
        L15:
            return SingleSelect;
        }

        public static CustomizationType valueOf(String r100) {
            return (CustomizationType) a.a(CustomizationType.class, r100);
        }

        private CustomizationType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class OptionCondition extends Message<OptionCondition, Builder> {
        public static final ProtoAdapter<OptionCondition> ADAPTER = null;
        public static final String DEFAULT_CUSTOM_KEY = "";
        private static final long serialVersionUID = 0;
        public final String custom_key;
        public final List<String> option_keys;

        public static final class Builder extends Message.Builder<OptionCondition, Builder> {
            public String custom_key;
            public List<String> option_keys;

            @Override // com.squareup.wire.Message.Builder
            public OptionCondition build() {
                return new OptionCondition(this.custom_key, this.option_keys, super.buildUnknownFields());
            }

            public Builder() {
                this.option_keys = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder custom_key(String r100) {
                this.custom_key = r100;
                return this;
            }

            public Builder option_keys(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.option_keys = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OptionCondition extends ProtoAdapter<OptionCondition> {
            public ProtoAdapter_OptionCondition() {
                super(FieldEncoding.LENGTH_DELIMITED, OptionCondition.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OptionCondition decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.custom_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.custom_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.option_keys.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(OptionCondition r100) {
                String r101 = r100.custom_key;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.option_keys)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OptionCondition decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OptionCondition r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OptionCondition r101) throws IOException {
                String r102 = r101.custom_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.option_keys);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OptionCondition r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OptionCondition();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.custom_key = this.custom_key;
            r100.option_keys = Internal.copyOf("option_keys", this.option_keys);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OptionCondition.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OptionCondition(String r100, List<String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OptionCondition(String r100, List<String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.custom_key = r100;
            this.option_keys = Internal.immutableCopyOf("option_keys", r101);
        }
    }

    public static final class ProtoAdapter_SchemaExtraData extends ProtoAdapter<SchemaExtraData> {
        public ProtoAdapter_SchemaExtraData() {
            super(FieldEncoding.LENGTH_DELIMITED, SchemaExtraData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SchemaExtraData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.biz_data.add(BizData.ADAPTER.decode(r100));
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
        public int encodedSize2(SchemaExtraData r100) {
            return BizData.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.biz_data) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SchemaExtraData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SchemaExtraData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SchemaExtraData r101) throws IOException {
            BizData.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.biz_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SchemaExtraData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ResourceApprovalInfo extends Message<ResourceApprovalInfo, Builder> {
        public static final ProtoAdapter<ResourceApprovalInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> approver_user_ids;
        public final ApprovalTrigger trigger;

        public static final class Builder extends Message.Builder<ResourceApprovalInfo, Builder> {
            public List<String> approver_user_ids;
            public ApprovalTrigger trigger;

            @Override // com.squareup.wire.Message.Builder
            public ResourceApprovalInfo build() {
                return new ResourceApprovalInfo(this.approver_user_ids, this.trigger, super.buildUnknownFields());
            }

            public Builder() {
                this.approver_user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder approver_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.approver_user_ids = r100;
                return this;
            }

            public Builder trigger(ApprovalTrigger r100) {
                this.trigger = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ResourceApprovalInfo extends ProtoAdapter<ResourceApprovalInfo> {
            public ProtoAdapter_ResourceApprovalInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ResourceApprovalInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResourceApprovalInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.approver_user_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.trigger = ApprovalTrigger.ADAPTER.decode(r100);
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
            public int encodedSize2(ResourceApprovalInfo r100) {
                int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.approver_user_ids);
                ApprovalTrigger r102 = r100.trigger;
                if (r102 == null) goto L5;
                int r103 = ApprovalTrigger.ADAPTER.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ResourceApprovalInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResourceApprovalInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResourceApprovalInfo r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.approver_user_ids);
                ApprovalTrigger r102 = r101.trigger;
                if (r102 == null) goto L5;
                ApprovalTrigger.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceApprovalInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResourceApprovalInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.approver_user_ids = Internal.copyOf("approver_user_ids", this.approver_user_ids);
            r100.trigger = this.trigger;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResourceApprovalInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResourceApprovalInfo(List<String> r100, ApprovalTrigger r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ResourceApprovalInfo(List<String> r100, ApprovalTrigger r101, ByteString r102) {
            super(ADAPTER, r102);
            this.approver_user_ids = Internal.immutableCopyOf("approver_user_ids", r100);
            this.trigger = r101;
        }
    }

    public static final class ResourceCustomization extends Message<ResourceCustomization, Builder> {
        public static final ProtoAdapter<ResourceCustomization> ADAPTER = null;
        public static final Long DEFAULT_PREPARATION_TIME = null;
        private static final long serialVersionUID = 0;
        public final List<String> contact_ids;
        public final List<CustomizationData> customization_data;
        public final Long preparation_time;

        public static final class Builder extends Message.Builder<ResourceCustomization, Builder> {
            public List<String> contact_ids;
            public List<CustomizationData> customization_data;
            public Long preparation_time;

            @Override // com.squareup.wire.Message.Builder
            public ResourceCustomization build() {
                return new ResourceCustomization(this.customization_data, this.contact_ids, this.preparation_time, super.buildUnknownFields());
            }

            public Builder() {
                this.customization_data = Internal.newMutableList();
                this.contact_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder contact_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.contact_ids = r100;
                return this;
            }

            public Builder customization_data(List<CustomizationData> r100) {
                Internal.checkElementsNotNull(r100);
                this.customization_data = r100;
                return this;
            }

            public Builder preparation_time(Long r100) {
                this.preparation_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ResourceCustomization extends ProtoAdapter<ResourceCustomization> {
            public ProtoAdapter_ResourceCustomization() {
                super(FieldEncoding.LENGTH_DELIMITED, ResourceCustomization.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResourceCustomization decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.preparation_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.customization_data.add(CustomizationData.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.contact_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.preparation_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(ResourceCustomization r100) {
                int r101 = CustomizationData.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.customization_data) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.contact_ids);
                Long r102 = r100.preparation_time;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ResourceCustomization decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResourceCustomization r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResourceCustomization r101) throws IOException {
                CustomizationData.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.customization_data);
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.contact_ids);
                Long r102 = r101.preparation_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceCustomization r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResourceCustomization();
            DEFAULT_PREPARATION_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.customization_data = Internal.copyOf("customization_data", this.customization_data);
            r100.contact_ids = Internal.copyOf("contact_ids", this.contact_ids);
            r100.preparation_time = this.preparation_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResourceCustomization.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResourceCustomization(List<CustomizationData> r100, List<String> r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ResourceCustomization(List<CustomizationData> r100, List<String> r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.customization_data = Internal.immutableCopyOf("customization_data", r100);
            this.contact_ids = Internal.immutableCopyOf("contact_ids", r101);
            this.preparation_time = r102;
        }
    }

    public static final class ResourceRequisition extends Message<ResourceRequisition, Builder> {
        public static final ProtoAdapter<ResourceRequisition> ADAPTER = null;
        public static final Long DEFAULT_END_TIME = null;
        public static final String DEFAULT_REASON = "";
        public static final Long DEFAULT_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final List<String> contact_ids;
        public final Long end_time;
        public final String reason;
        public final Long start_time;

        public static final class Builder extends Message.Builder<ResourceRequisition, Builder> {
            public List<String> contact_ids;
            public Long end_time;
            public String reason;
            public Long start_time;

            @Override // com.squareup.wire.Message.Builder
            public ResourceRequisition build() {
                return new ResourceRequisition(this.start_time, this.end_time, this.contact_ids, this.reason, super.buildUnknownFields());
            }

            public Builder() {
                this.contact_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder contact_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.contact_ids = r100;
                return this;
            }

            public Builder end_time(Long r100) {
                this.end_time = r100;
                return this;
            }

            public Builder reason(String r100) {
                this.reason = r100;
                return this;
            }

            public Builder start_time(Long r100) {
                this.start_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ResourceRequisition extends ProtoAdapter<ResourceRequisition> {
            public ProtoAdapter_ResourceRequisition() {
                super(FieldEncoding.LENGTH_DELIMITED, ResourceRequisition.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResourceRequisition decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.start_time = 0L;
                r101.end_time = 0L;
                r101.reason = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.start_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.end_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.contact_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.reason = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ResourceRequisition r100) {
                Long r101 = r100.start_time;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.end_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ProtoAdapter<String> r107 = ProtoAdapter.STRING;
                int r108 = r106 + r107.asRepeated().encodedSizeWithTag(3, r100.contact_ids);
                String r109 = r100.reason;
                if (r109 == null) goto L14;
                r102 = r107.encodedSizeWithTag(4, r109);
            L14:
                return (r108 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ResourceRequisition decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResourceRequisition r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResourceRequisition r101) throws IOException {
                Long r102 = r101.start_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.end_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                r104.asRepeated().encodeWithTag(r100, 3, r101.contact_ids);
                String r105 = r101.reason;
                if (r105 == null) goto L11;
                r104.encodeWithTag(r100, 4, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceRequisition r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResourceRequisition();
            DEFAULT_START_TIME = 0L;
            DEFAULT_END_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.start_time = this.start_time;
            r100.end_time = this.end_time;
            r100.contact_ids = Internal.copyOf("contact_ids", this.contact_ids);
            r100.reason = this.reason;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResourceRequisition.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResourceRequisition(Long r100, Long r101, List<String> r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ResourceRequisition(Long r100, Long r101, List<String> r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.start_time = r100;
            this.end_time = r101;
            this.contact_ids = Internal.immutableCopyOf("contact_ids", r102);
            this.reason = r103;
        }
    }

    public static final class ResourceStrategy extends Message<ResourceStrategy, Builder> {
        public static final ProtoAdapter<ResourceStrategy> ADAPTER = null;
        public static final Integer DEFAULT_DAILY_END_TIME = null;
        public static final Integer DEFAULT_DAILY_START_TIME = null;
        public static final Integer DEFAULT_EARLIEST_BOOK_TIME = null;
        public static final Boolean DEFAULT_IS_ENABLE = null;
        public static final MaxReservableType DEFAULT_MAX_RESERVABLE_TYPE = null;
        public static final Integer DEFAULT_MAX_WORKDAY = null;
        public static final Integer DEFAULT_SINGLE_MAX_DURATION = null;
        public static final String DEFAULT_TIMEZONE = "";
        public static final Integer DEFAULT_UNTIL_MAX_DURATION = null;
        private static final long serialVersionUID = 0;
        public final Integer daily_end_time;
        public final Integer daily_start_time;
        public final Integer earliest_book_time;
        public final Boolean is_enable;
        public final MaxReservableType max_reservable_type;
        public final Integer max_workday;
        public final Integer single_max_duration;
        public final String timezone;
        public final Integer until_max_duration;

        public static final class Builder extends Message.Builder<ResourceStrategy, Builder> {
            public Integer daily_end_time;
            public Integer daily_start_time;
            public Integer earliest_book_time;
            public Boolean is_enable;
            public MaxReservableType max_reservable_type;
            public Integer max_workday;
            public Integer single_max_duration;
            public String timezone;
            public Integer until_max_duration;

            @Override // com.squareup.wire.Message.Builder
            public ResourceStrategy build() {
                return new ResourceStrategy(this.single_max_duration, this.until_max_duration, this.daily_start_time, this.daily_end_time, this.timezone, this.is_enable, this.earliest_book_time, this.max_workday, this.max_reservable_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder daily_end_time(Integer r100) {
                this.daily_end_time = r100;
                return this;
            }

            public Builder daily_start_time(Integer r100) {
                this.daily_start_time = r100;
                return this;
            }

            public Builder earliest_book_time(Integer r100) {
                this.earliest_book_time = r100;
                return this;
            }

            public Builder is_enable(Boolean r100) {
                this.is_enable = r100;
                return this;
            }

            public Builder max_reservable_type(MaxReservableType r100) {
                this.max_reservable_type = r100;
                return this;
            }

            public Builder max_workday(Integer r100) {
                this.max_workday = r100;
                return this;
            }

            public Builder single_max_duration(Integer r100) {
                this.single_max_duration = r100;
                return this;
            }

            public Builder timezone(String r100) {
                this.timezone = r100;
                return this;
            }

            public Builder until_max_duration(Integer r100) {
                this.until_max_duration = r100;
                return this;
            }
        }

        public static final enum MaxReservableType extends Enum<MaxReservableType> implements WireEnum {
            private static final /* synthetic */ MaxReservableType[] $VALUES = null;
            public static final ProtoAdapter<MaxReservableType> ADAPTER = null;
            public static final MaxReservableType DAY = null;
            public static final MaxReservableType UNKNOWN = null;
            public static final MaxReservableType WORK_DAY = null;
            private final int value;

            static {
                MaxReservableType r100 = new MaxReservableType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                MaxReservableType r101 = new MaxReservableType("DAY", 1, 1);
                DAY = r101;
                MaxReservableType r102 = new MaxReservableType("WORK_DAY", 2, 2);
                WORK_DAY = r102;
                $VALUES = new MaxReservableType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(MaxReservableType.class);
            }

            public static MaxReservableType[] values() {
                return (MaxReservableType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static MaxReservableType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return WORK_DAY;
            L12:
                return DAY;
            L14:
                return UNKNOWN;
            }

            public static MaxReservableType valueOf(String r100) {
                return (MaxReservableType) a.a(MaxReservableType.class, r100);
            }

            private MaxReservableType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ResourceStrategy extends ProtoAdapter<ResourceStrategy> {
            public ProtoAdapter_ResourceStrategy() {
                super(FieldEncoding.LENGTH_DELIMITED, ResourceStrategy.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResourceStrategy decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.single_max_duration = 0;
                r101.until_max_duration = 0;
                r101.daily_start_time = 0;
                r101.daily_end_time = 0;
                r101.timezone = "";
                r101.is_enable = Boolean.FALSE;
                r101.earliest_book_time = 0;
                r101.max_workday = 0;
                r101.max_reservable_type = MaxReservableType.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L21;
                    default: goto L6;
                };
            L21:
                r101.max_reservable_type = MaxReservableType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.max_workday = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                r101.earliest_book_time = ProtoAdapter.INT32.decode(r100);
                goto L3
            L13:
                r101.is_enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                r101.timezone = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.daily_end_time = ProtoAdapter.INT32.decode(r100);
                goto L3
            L16:
                r101.daily_start_time = ProtoAdapter.INT32.decode(r100);
                goto L3
            L17:
                r101.until_max_duration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L18:
                r101.single_max_duration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L19:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ResourceStrategy r100) {
                Integer r101 = r100.single_max_duration;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.until_max_duration;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.daily_start_time;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Integer r110 = r100.daily_end_time;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.timezone;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_enable;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Integer r119 = r100.earliest_book_time;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Integer r122 = r100.max_workday;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                MaxReservableType r125 = r100.max_reservable_type;
                if (r125 == null) goto L38;
                r102 = MaxReservableType.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                return (r124 + r102) + r100.unknownFields().size();
            L33:
                r123 = 0;
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
            public /* bridge */ /* synthetic */ ResourceStrategy decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResourceStrategy r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResourceStrategy r101) throws IOException {
                Integer r102 = r101.single_max_duration;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.until_max_duration;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.daily_start_time;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                Integer r105 = r101.daily_end_time;
                if (r105 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.timezone;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_enable;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Integer r108 = r101.earliest_book_time;
                if (r108 == null) goto L23;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
            L23:
                Integer r109 = r101.max_workday;
                if (r109 == null) goto L26;
                ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
            L26:
                MaxReservableType r110 = r101.max_reservable_type;
                if (r110 == null) goto L29;
                MaxReservableType.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceStrategy r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResourceStrategy();
            DEFAULT_SINGLE_MAX_DURATION = 0;
            DEFAULT_UNTIL_MAX_DURATION = 0;
            DEFAULT_DAILY_START_TIME = 0;
            DEFAULT_DAILY_END_TIME = 0;
            DEFAULT_IS_ENABLE = Boolean.FALSE;
            DEFAULT_EARLIEST_BOOK_TIME = 0;
            DEFAULT_MAX_WORKDAY = 0;
            DEFAULT_MAX_RESERVABLE_TYPE = MaxReservableType.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.single_max_duration = this.single_max_duration;
            r100.until_max_duration = this.until_max_duration;
            r100.daily_start_time = this.daily_start_time;
            r100.daily_end_time = this.daily_end_time;
            r100.timezone = this.timezone;
            r100.is_enable = this.is_enable;
            r100.earliest_book_time = this.earliest_book_time;
            r100.max_workday = this.max_workday;
            r100.max_reservable_type = this.max_reservable_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResourceStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResourceStrategy(Integer r110, Integer r111, Integer r112, Integer r113, String r114, Boolean r115, Integer r116, Integer r117, MaxReservableType r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public ResourceStrategy(Integer r100, Integer r101, Integer r102, Integer r103, String r104, Boolean r105, Integer r106, Integer r107, MaxReservableType r110, ByteString r111) {
            super(ADAPTER, r111);
            this.single_max_duration = r100;
            this.until_max_duration = r101;
            this.daily_start_time = r102;
            this.daily_end_time = r103;
            this.timezone = r104;
            this.is_enable = r105;
            this.earliest_book_time = r106;
            this.max_workday = r107;
            this.max_reservable_type = r110;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APPROVAL_REQUEST = null;
        public static final Type RESOURCE_APPROVAL_INFO = null;
        public static final Type RESOURCE_CUSTOMIZATION = null;
        public static final Type RESOURCE_REQUISITION = null;
        public static final Type RESOURCE_STRATEGY = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("RESOURCE_APPROVAL_INFO", 1, 1);
            RESOURCE_APPROVAL_INFO = r101;
            Type r102 = new Type("APPROVAL_REQUEST", 2, 2);
            APPROVAL_REQUEST = r102;
            Type r103 = new Type("RESOURCE_STRATEGY", 3, 3);
            RESOURCE_STRATEGY = r103;
            Type r104 = new Type("RESOURCE_REQUISITION", 4, 4);
            RESOURCE_REQUISITION = r104;
            Type r105 = new Type("RESOURCE_CUSTOMIZATION", 5, 5);
            RESOURCE_CUSTOMIZATION = r105;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return RESOURCE_CUSTOMIZATION;
        L18:
            return RESOURCE_REQUISITION;
        L20:
            return RESOURCE_STRATEGY;
        L22:
            return APPROVAL_REQUEST;
        L24:
            return RESOURCE_APPROVAL_INFO;
        L26:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SchemaExtraData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_data = Internal.copyOf("biz_data", this.biz_data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SchemaExtraData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SchemaExtraData(List<BizData> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SchemaExtraData(List<BizData> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.biz_data = Internal.immutableCopyOf("biz_data", r100);
    }
}
