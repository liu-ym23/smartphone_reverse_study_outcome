package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ChatterCustomStatus;
import com.ss.android.lark.pb.entities.TagData;
import com.ss.android.lark.pb.misc.DeniedReason;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UserMeta extends Message<UserMeta, Builder> {
    public static final ProtoAdapter<UserMeta> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final String DEFAULT_ENTERPRISE_MAIL_ADDRESS = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final String DEFAULT_MAIL_ADDRESS = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    public static final FieldOptions FIELD_OPTIONS_MTENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean maccept_sms_phone_urgent;
    public final DeniedReason mblock_status;
    public final String mchat_id;
    public final List<ChatterCustomStatus> mcustom_statuses;
    public final String mdescription;
    public final Long mdo_not_disturb_end_time;
    public final EmployeeKind memployee_kind;
    public final String menterprise_mail_address;
    public final ExtraFields mextraFields;
    public final Map<String, String> mi18n_names;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_registered;
    public final String mmail_address;
    public final TagData mrelation_tag;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<UserMeta, Builder> {
        public Boolean maccept_sms_phone_urgent;
        public DeniedReason mblock_status;
        public String mchat_id;
        public List<ChatterCustomStatus> mcustom_statuses;
        public String mdescription;
        public Long mdo_not_disturb_end_time;
        public EmployeeKind memployee_kind;
        public String menterprise_mail_address;
        public ExtraFields mextraFields;
        public Map<String, String> mi18n_names;
        public String mid;
        public Boolean mis_cross_tenant;
        public Boolean mis_registered;
        public String mmail_address;
        public TagData mrelation_tag;
        public String mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public UserMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new UserMeta(this.mid, this.mis_registered, this.mtenant_id, this.mmail_address, this.mdo_not_disturb_end_time, this.maccept_sms_phone_urgent, this.mchat_id, this.mextraFields, this.menterprise_mail_address, this.mcustom_statuses, this.mi18n_names, this.mis_cross_tenant, this.mrelation_tag, this.mblock_status, this.mdescription, this.memployee_kind, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mcustom_statuses = Internal.newMutableList();
            this.mi18n_names = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accept_sms_phone_urgent(Boolean r100) {
            this.maccept_sms_phone_urgent = r100;
            return this;
        }

        public Builder block_status(DeniedReason r100) {
            this.mblock_status = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder custom_statuses(List<ChatterCustomStatus> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcustom_statuses = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.mdo_not_disturb_end_time = r100;
            return this;
        }

        public Builder employee_kind(EmployeeKind r100) {
            this.memployee_kind = r100;
            return this;
        }

        public Builder enterprise_mail_address(String r100) {
            this.menterprise_mail_address = r100;
            return this;
        }

        public Builder extraFields(ExtraFields r100) {
            this.mextraFields = r100;
            return this;
        }

        public Builder i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_names = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.mis_cross_tenant = r100;
            return this;
        }

        public Builder is_registered(Boolean r100) {
            this.mis_registered = r100;
            return this;
        }

        public Builder mail_address(String r100) {
            this.mmail_address = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.mrelation_tag = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ExtraFields extends Message<ExtraFields, Builder> {
        public static final ProtoAdapter<ExtraFields> ADAPTER = null;
        public static final Boolean DEFAULT_IS_DIRECTLY_IN_TEAM = null;
        public static final Boolean DEFAULT_IS_IN_CHAT = null;
        public static final Boolean DEFAULT_IS_READ_MESSAGE = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_directly_in_team;
        public final Boolean mis_in_chat;
        public final Boolean mis_read_message;

        public static final class Builder extends Message.Builder<ExtraFields, Builder> {
            public Boolean mis_directly_in_team;
            public Boolean mis_in_chat;
            public Boolean mis_read_message;

            @Override // com.squareup.wire.Message.Builder
            public ExtraFields build() {
                return new ExtraFields(this.mis_in_chat, this.mis_read_message, this.mis_directly_in_team, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_directly_in_team(Boolean r100) {
                this.mis_directly_in_team = r100;
                return this;
            }

            public Builder is_in_chat(Boolean r100) {
                this.mis_in_chat = r100;
                return this;
            }

            public Builder is_read_message(Boolean r100) {
                this.mis_read_message = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtraFields extends ProtoAdapter<ExtraFields> {
            public ProtoAdapter_ExtraFields() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtraFields.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtraFields decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.mis_in_chat = r102;
                r101.mis_read_message = r102;
                r101.mis_directly_in_team = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.mis_in_chat = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.mis_read_message = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.mis_directly_in_team = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ExtraFields r100) {
                Boolean r101 = r100.mis_in_chat;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mis_read_message;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.mis_directly_in_team;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtraFields decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtraFields r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtraFields r101) throws IOException {
                Boolean r102 = r101.mis_in_chat;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mis_read_message;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.mis_directly_in_team;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraFields r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtraFields();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_IN_CHAT = r100;
            DEFAULT_IS_READ_MESSAGE = r100;
            DEFAULT_IS_DIRECTLY_IN_TEAM = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_in_chat = this.mis_in_chat;
            r100.mis_read_message = this.mis_read_message;
            r100.mis_directly_in_team = this.mis_directly_in_team;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtraFields.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtraFields(Boolean r100, Boolean r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ExtraFields(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mis_in_chat = r100;
            this.mis_read_message = r101;
            this.mis_directly_in_team = r102;
        }
    }

    public static final class ProtoAdapter_UserMeta extends ProtoAdapter<UserMeta> {
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_UserMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, UserMeta.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_registered = r102;
            r101.mtenant_id = "";
            r101.mmail_address = "";
            r101.mdo_not_disturb_end_time = 0L;
            r101.maccept_sms_phone_urgent = r102;
            r101.mchat_id = "";
            r101.menterprise_mail_address = "";
            r101.mis_cross_tenant = r102;
            r101.mdescription = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L29;
            switch(r104) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L33;
                case 15: goto L11;
                case 16: goto L31;
                default: goto L6;
            };
        L31:
            r101.memployee_kind = EmployeeKind.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r101.mblock_status = DeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mrelation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mis_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.mi18n_names.putAll(this.mi18n_names.decode(r100));
            goto L3
        L19:
            r101.mcustom_statuses.add(ChatterCustomStatus.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.menterprise_mail_address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.mextraFields = ExtraFields.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.maccept_sms_phone_urgent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.mdo_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L25:
            r101.mmail_address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.mtenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.mis_registered = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L28:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            Boolean r103 = r100.mis_registered;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mtenant_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.mmail_address;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.mdo_not_disturb_end_time;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.maccept_sms_phone_urgent;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mchat_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            ExtraFields r122 = r100.mextraFields;
            if (r122 == null) goto L29;
            int r123 = ExtraFields.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.menterprise_mail_address;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(9, r125);
        L34:
            int r127 = ((r124 + r126) + ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.mcustom_statuses)) + this.mi18n_names.encodedSizeWithTag(11, r100.mi18n_names);
            Boolean r128 = r100.mis_cross_tenant;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            TagData r131 = r100.mrelation_tag;
            if (r131 == null) goto L41;
            int r132 = TagData.ADAPTER.encodedSizeWithTag(13, r131);
        L42:
            int r133 = r130 + r132;
            DeniedReason r134 = r100.mblock_status;
            if (r134 == null) goto L45;
            int r135 = DeniedReason.ADAPTER.encodedSizeWithTag(14, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.mdescription;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(15, r137);
        L50:
            int r139 = r136 + r138;
            EmployeeKind r140 = r100.memployee_kind;
            if (r140 == null) goto L54;
            r104 = EmployeeKind.ADAPTER.encodedSizeWithTag(16, r140);
        L54:
            return (r139 + r104) + r100.unknownFields().size();
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            Boolean r103 = r101.mis_registered;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mtenant_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.mmail_address;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Long r106 = r101.mdo_not_disturb_end_time;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.maccept_sms_phone_urgent;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mchat_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            ExtraFields r109 = r101.mextraFields;
            if (r109 == null) goto L23;
            ExtraFields.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.menterprise_mail_address;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.mcustom_statuses);
            this.mi18n_names.encodeWithTag(r100, 11, r101.mi18n_names);
            Boolean r111 = r101.mis_cross_tenant;
            if (r111 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r111);
        L29:
            TagData r112 = r101.mrelation_tag;
            if (r112 == null) goto L32;
            TagData.ADAPTER.encodeWithTag(r100, 13, r112);
        L32:
            DeniedReason r113 = r101.mblock_status;
            if (r113 == null) goto L35;
            DeniedReason.ADAPTER.encodeWithTag(r100, 14, r113);
        L35:
            String r114 = r101.mdescription;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 15, r114);
        L38:
            EmployeeKind r115 = r101.memployee_kind;
            if (r115 == null) goto L41;
            EmployeeKind.ADAPTER.encodeWithTag(r100, 16, r115);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserMeta();
        FIELD_OPTIONS_MID = new FieldOptions.Builder().id("user_id").build();
        FIELD_OPTIONS_MTENANT_ID = new FieldOptions.Builder().id("tenant_id").build();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().id("chat_id").build();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_REGISTERED = r100;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r100;
        DEFAULT_IS_CROSS_TENANT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mis_registered = this.mis_registered;
        r100.mtenant_id = this.mtenant_id;
        r100.mmail_address = this.mmail_address;
        r100.mdo_not_disturb_end_time = this.mdo_not_disturb_end_time;
        r100.maccept_sms_phone_urgent = this.maccept_sms_phone_urgent;
        r100.mchat_id = this.mchat_id;
        r100.mextraFields = this.mextraFields;
        r100.menterprise_mail_address = this.menterprise_mail_address;
        r100.mcustom_statuses = Internal.copyOf("mcustom_statuses", this.mcustom_statuses);
        r100.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r100.mis_cross_tenant = this.mis_cross_tenant;
        r100.mrelation_tag = this.mrelation_tag;
        r100.mblock_status = this.mblock_status;
        r100.mdescription = this.mdescription;
        r100.memployee_kind = this.memployee_kind;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserMeta(String r110, Boolean r210, String r211, String r212, Long r213, Boolean r214, String r215, ExtraFields r216, String r217, List<ChatterCustomStatus> r218, Map<String, String> r219, Boolean r310, TagData r311, DeniedReason r312, String r313, EmployeeKind r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public UserMeta(String r100, Boolean r101, String r102, String r103, Long r104, Boolean r105, String r110, ExtraFields r111, String r112, List<ChatterCustomStatus> r113, Map<String, String> r114, Boolean r115, TagData r116, DeniedReason r117, String r118, EmployeeKind r119, ByteString r210) {
        super(ADAPTER, r210);
        this.mid = r100;
        this.mis_registered = r101;
        this.mtenant_id = r102;
        this.mmail_address = r103;
        this.mdo_not_disturb_end_time = r104;
        this.maccept_sms_phone_urgent = r105;
        this.mchat_id = r110;
        this.mextraFields = r111;
        this.menterprise_mail_address = r112;
        this.mcustom_statuses = Internal.immutableCopyOf("mcustom_statuses", r113);
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r114);
        this.mis_cross_tenant = r115;
        this.mrelation_tag = r116;
        this.mblock_status = r117;
        this.mdescription = r118;
        this.memployee_kind = r119;
    }
}
