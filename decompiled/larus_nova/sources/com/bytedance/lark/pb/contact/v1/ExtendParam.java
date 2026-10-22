package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.ActionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ExtendParam extends Message<ExtendParam, Builder> {
    public static final ProtoAdapter<ExtendParam> ADAPTER = null;
    public static final ActionType DEFAULT_ACTION_TYPE = null;
    public static final Boolean DEFAULT_CAN_INVITE_SAME_CHAT_TAG = null;
    public static final Long DEFAULT_CHECK_MAIL_GROUP_ID = null;
    public static final CheckMailGroupRole DEFAULT_CHECK_MAIL_GROUP_ROLE = null;
    public static final Boolean DEFAULT_HAS_LEAD_PERM = null;
    public static final String DEFAULT_IN_CHAT_ID = "";
    public static final Boolean DEFAULT_NEED_USER_PROFILE_FIELDS = null;
    public static final Boolean DEFAULT_SELECT_ENTERPRISE_EMAIL = null;
    private static final long serialVersionUID = 0;
    public final ActionType action_type;
    public final Boolean can_invite_same_chat_tag;
    public final Long check_mail_group_id;
    public final CheckMailGroupRole check_mail_group_role;
    public final Boolean has_lead_perm;
    public final String in_chat_id;
    public final Boolean need_user_profile_fields;
    public final Boolean select_enterprise_email;

    public static final class Builder extends Message.Builder<ExtendParam, Builder> {
        public ActionType action_type;
        public Boolean can_invite_same_chat_tag;
        public Long check_mail_group_id;
        public CheckMailGroupRole check_mail_group_role;
        public Boolean has_lead_perm;
        public String in_chat_id;
        public Boolean need_user_profile_fields;
        public Boolean select_enterprise_email;

        @Override // com.squareup.wire.Message.Builder
        public ExtendParam build() {
            return new ExtendParam(this.in_chat_id, this.can_invite_same_chat_tag, this.action_type, this.has_lead_perm, this.need_user_profile_fields, this.select_enterprise_email, this.check_mail_group_id, this.check_mail_group_role, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder can_invite_same_chat_tag(Boolean r100) {
            this.can_invite_same_chat_tag = r100;
            return this;
        }

        public Builder check_mail_group_id(Long r100) {
            this.check_mail_group_id = r100;
            return this;
        }

        public Builder check_mail_group_role(CheckMailGroupRole r100) {
            this.check_mail_group_role = r100;
            return this;
        }

        public Builder has_lead_perm(Boolean r100) {
            this.has_lead_perm = r100;
            return this;
        }

        public Builder in_chat_id(String r100) {
            this.in_chat_id = r100;
            return this;
        }

        public Builder need_user_profile_fields(Boolean r100) {
            this.need_user_profile_fields = r100;
            return this;
        }

        public Builder select_enterprise_email(Boolean r100) {
            this.select_enterprise_email = r100;
            return this;
        }
    }

    public static final enum CheckMailGroupRole extends Enum<CheckMailGroupRole> implements WireEnum {
        private static final /* synthetic */ CheckMailGroupRole[] $VALUES = null;
        public static final ProtoAdapter<CheckMailGroupRole> ADAPTER = null;
        public static final CheckMailGroupRole MANAGER = null;
        public static final CheckMailGroupRole MEMBER = null;
        public static final CheckMailGroupRole PERMISSION = null;
        private final int value;

        static {
            CheckMailGroupRole r100 = new CheckMailGroupRole("MEMBER", 0, 0);
            MEMBER = r100;
            CheckMailGroupRole r101 = new CheckMailGroupRole("MANAGER", 1, 1);
            MANAGER = r101;
            CheckMailGroupRole r102 = new CheckMailGroupRole("PERMISSION", 2, 2);
            PERMISSION = r102;
            $VALUES = new CheckMailGroupRole[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CheckMailGroupRole.class);
        }

        public static CheckMailGroupRole[] values() {
            return (CheckMailGroupRole[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CheckMailGroupRole fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PERMISSION;
        L12:
            return MANAGER;
        L14:
            return MEMBER;
        }

        public static CheckMailGroupRole valueOf(String r100) {
            return (CheckMailGroupRole) a.a(CheckMailGroupRole.class, r100);
        }

        private CheckMailGroupRole(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ExtendParam extends ProtoAdapter<ExtendParam> {
        public ProtoAdapter_ExtendParam() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtendParam.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtendParam decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.in_chat_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.can_invite_same_chat_tag = r102;
            r101.action_type = ActionType.UNKNOWN_ACTION;
            r101.has_lead_perm = r102;
            r101.need_user_profile_fields = r102;
            r101.select_enterprise_email = r102;
            r101.check_mail_group_id = 0L;
            r101.check_mail_group_role = CheckMailGroupRole.MEMBER;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            switch(r104) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L25;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L23;
                default: goto L6;
            };
        L23:
            r101.check_mail_group_role = CheckMailGroupRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L25:
            r101.action_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.check_mail_group_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.select_enterprise_email = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.need_user_profile_fields = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.has_lead_perm = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.can_invite_same_chat_tag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.in_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExtendParam r100) {
            String r101 = r100.in_chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.can_invite_same_chat_tag;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ActionType r107 = r100.action_type;
            if (r107 == null) goto L13;
            int r108 = ActionType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.has_lead_perm;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.need_user_profile_fields;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.select_enterprise_email;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.check_mail_group_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            CheckMailGroupRole r122 = r100.check_mail_group_role;
            if (r122 == null) goto L34;
            r102 = CheckMailGroupRole.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ExtendParam decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtendParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtendParam r101) throws IOException {
            String r102 = r101.in_chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.can_invite_same_chat_tag;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            ActionType r104 = r101.action_type;
            if (r104 == null) goto L11;
            ActionType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.has_lead_perm;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.need_user_profile_fields;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.select_enterprise_email;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.check_mail_group_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            CheckMailGroupRole r109 = r101.check_mail_group_role;
            if (r109 == null) goto L26;
            CheckMailGroupRole.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtendParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtendParam();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CAN_INVITE_SAME_CHAT_TAG = r100;
        DEFAULT_ACTION_TYPE = ActionType.UNKNOWN_ACTION;
        DEFAULT_HAS_LEAD_PERM = r100;
        DEFAULT_NEED_USER_PROFILE_FIELDS = r100;
        DEFAULT_SELECT_ENTERPRISE_EMAIL = r100;
        DEFAULT_CHECK_MAIL_GROUP_ID = 0L;
        DEFAULT_CHECK_MAIL_GROUP_ROLE = CheckMailGroupRole.MEMBER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.in_chat_id = this.in_chat_id;
        r100.can_invite_same_chat_tag = this.can_invite_same_chat_tag;
        r100.action_type = this.action_type;
        r100.has_lead_perm = this.has_lead_perm;
        r100.need_user_profile_fields = this.need_user_profile_fields;
        r100.select_enterprise_email = this.select_enterprise_email;
        r100.check_mail_group_id = this.check_mail_group_id;
        r100.check_mail_group_role = this.check_mail_group_role;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtendParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtendParam(String r110, Boolean r111, ActionType r112, Boolean r113, Boolean r114, Boolean r115, Long r116, CheckMailGroupRole r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public ExtendParam(String r100, Boolean r101, ActionType r102, Boolean r103, Boolean r104, Boolean r105, Long r106, CheckMailGroupRole r107, ByteString r110) {
        super(ADAPTER, r110);
        this.in_chat_id = r100;
        this.can_invite_same_chat_tag = r101;
        this.action_type = r102;
        this.has_lead_perm = r103;
        this.need_user_profile_fields = r104;
        this.select_enterprise_email = r105;
        this.check_mail_group_id = r106;
        this.check_mail_group_role = r107;
    }
}
