package com.bytedance.lark.pb.calendar.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarMember extends Message<CalendarMember, Builder> {
    public static final ProtoAdapter<CalendarMember> ADAPTER = null;
    public static final Calendar.AccessRole DEFAULT_ACCESS_ROLE = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_CALENDAR_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_CHAT_MEMBER_COUNT = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_USER_COUNT_VISIBLE = null;
    public static final String DEFAULT_LOCALIZED_NAME = "";
    public static final CalendarMemberType DEFAULT_MEMBER_TYPE = null;
    public static final String DEFAULT_NAME = "";
    public static final RelationType DEFAULT_RELATION_TYPE = null;
    public static final Calendar.Status DEFAULT_STATUS = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final Boolean DEFAULT_USE_SERVER_MEMBER_NUM = null;
    private static final long serialVersionUID = 0;
    public final Calendar.AccessRole access_role;
    public final ImageSet avatar;
    public final String avatar_key;
    public final String avatar_path;
    public final String calendar_id;
    public final String chat_id;
    public final Integer chat_member_count;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253601id;
    public final Boolean is_cross_tenant;
    public final Boolean is_user_count_visible;
    public final String localized_name;
    public final CalendarMemberType member_type;
    public final String name;
    public final TagData relation_tag;
    public final RelationType relation_type;
    public final Calendar.Status status;
    public final String tenant_id;
    public final Boolean use_server_member_num;
    public final String user_id;

    public static final class Builder extends Message.Builder<CalendarMember, Builder> {
        public Calendar.AccessRole access_role;
        public ImageSet avatar;
        public String avatar_key;
        public String avatar_path;
        public String calendar_id;
        public String chat_id;
        public Integer chat_member_count;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253602id;
        public Boolean is_cross_tenant;
        public Boolean is_user_count_visible;
        public String localized_name;
        public CalendarMemberType member_type;
        public String name;
        public TagData relation_tag;
        public RelationType relation_type;
        public Calendar.Status status;
        public String tenant_id;
        public Boolean use_server_member_num;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public CalendarMember build() {
            String r100 = this.f253602id;
            if (r100 == null) goto L11;
            if (this.calendar_id == null) goto L11;
            if (this.user_id == null) goto L11;
            return new CalendarMember(this.f253602id, this.calendar_id, this.user_id, this.access_role, this.status, this.name, this.avatar, this.avatar_key, this.localized_name, this.member_type, this.chat_id, this.chat_member_count, this.avatar_path, this.tenant_id, this.is_cross_tenant, this.use_server_member_num, this.relation_tag, this.relation_type, this.is_user_count_visible, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.calendar_id, "calendar_id", this.user_id, "user_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder access_role(Calendar.AccessRole r100) {
            this.access_role = r100;
            return this;
        }

        public Builder avatar(ImageSet r100) {
            this.avatar = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder calendar_id(String r100) {
            this.calendar_id = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_member_count(Integer r100) {
            this.chat_member_count = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253602id = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_user_count_visible(Boolean r100) {
            this.is_user_count_visible = r100;
            return this;
        }

        public Builder localized_name(String r100) {
            this.localized_name = r100;
            return this;
        }

        public Builder member_type(CalendarMemberType r100) {
            this.member_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.relation_tag = r100;
            return this;
        }

        public Builder relation_type(RelationType r100) {
            this.relation_type = r100;
            return this;
        }

        public Builder status(Calendar.Status r100) {
            this.status = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder use_server_member_num(Boolean r100) {
            this.use_server_member_num = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final enum CalendarMemberType extends Enum<CalendarMemberType> implements WireEnum {
        private static final /* synthetic */ CalendarMemberType[] $VALUES = null;
        public static final ProtoAdapter<CalendarMemberType> ADAPTER = null;
        public static final CalendarMemberType GROUP = null;
        public static final CalendarMemberType INDIVIDUAL = null;
        private final int value;

        static {
            CalendarMemberType r100 = new CalendarMemberType("INDIVIDUAL", 0, 1);
            INDIVIDUAL = r100;
            CalendarMemberType r101 = new CalendarMemberType("GROUP", 1, 2);
            GROUP = r101;
            $VALUES = new CalendarMemberType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(CalendarMemberType.class);
        }

        public static CalendarMemberType[] values() {
            return (CalendarMemberType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CalendarMemberType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return GROUP;
        L11:
            return INDIVIDUAL;
        }

        public static CalendarMemberType valueOf(String r100) {
            return (CalendarMemberType) a.a(CalendarMemberType.class, r100);
        }

        private CalendarMemberType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CalendarMember extends ProtoAdapter<CalendarMember> {
        public ProtoAdapter_CalendarMember() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarMember.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarMember decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253602id = "";
            r101.calendar_id = "";
            r101.user_id = "";
            r101.access_role = Calendar.AccessRole.READER;
            r101.status = Calendar.Status.DEFAULT;
            r101.name = "";
            r101.avatar_key = "";
            r101.localized_name = "";
            r101.member_type = CalendarMemberType.INDIVIDUAL;
            r101.chat_id = "";
            r101.chat_member_count = 0;
            r101.avatar_path = "";
            r101.tenant_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_cross_tenant = r102;
            r101.use_server_member_num = r102;
            r101.relation_type = RelationType.INTERNAL;
            r101.is_user_count_visible = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L38;
            switch(r104) {
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L46;
                case 5: goto L40;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L44;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L13;
                case 17: goto L12;
                case 18: goto L42;
                case 19: goto L7;
                default: goto L6;
            };
        L40:
            r101.status = Calendar.Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L42:
            r101.relation_type = RelationType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.member_type = CalendarMemberType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L46:
            r101.access_role = Calendar.AccessRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_user_count_visible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.relation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.use_server_member_num = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.chat_member_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.localized_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.avatar = ImageSet.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.f253602id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L38:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarMember r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.f253601id) + r101.encodedSizeWithTag(2, r100.calendar_id)) + r101.encodedSizeWithTag(3, r100.user_id);
            Calendar.AccessRole r103 = r100.access_role;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Calendar.AccessRole.ADAPTER.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Calendar.Status r107 = r100.status;
            if (r107 == null) goto L9;
            int r108 = Calendar.Status.ADAPTER.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.name;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            ImageSet r113 = r100.avatar;
            if (r113 == null) goto L17;
            int r114 = ImageSet.ADAPTER.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.avatar_key;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.localized_name;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            CalendarMemberType r122 = r100.member_type;
            if (r122 == null) goto L29;
            int r123 = CalendarMemberType.ADAPTER.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.chat_id;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            Integer r128 = r100.chat_member_count;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.avatar_path;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(13, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.tenant_id;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(14, r134);
        L46:
            int r136 = r133 + r135;
            Boolean r137 = r100.is_cross_tenant;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r137);
        L50:
            int r139 = r136 + r138;
            Boolean r140 = r100.use_server_member_num;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r140);
        L54:
            int r142 = r139 + r141;
            TagData r143 = r100.relation_tag;
            if (r143 == null) goto L57;
            int r144 = TagData.ADAPTER.encodedSizeWithTag(17, r143);
        L58:
            int r145 = r142 + r144;
            RelationType r146 = r100.relation_type;
            if (r146 == null) goto L61;
            int r147 = RelationType.ADAPTER.encodedSizeWithTag(18, r146);
        L62:
            int r148 = r145 + r147;
            Boolean r149 = r100.is_user_count_visible;
            if (r149 == null) goto L66;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r149);
        L66:
            return (r148 + r104) + r100.unknownFields().size();
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
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
        public /* bridge */ /* synthetic */ CalendarMember decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarMember r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarMember r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253601id);
            r102.encodeWithTag(r100, 2, r101.calendar_id);
            r102.encodeWithTag(r100, 3, r101.user_id);
            Calendar.AccessRole r103 = r101.access_role;
            if (r103 == null) goto L5;
            Calendar.AccessRole.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            Calendar.Status r104 = r101.status;
            if (r104 == null) goto L8;
            Calendar.Status.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.name;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            ImageSet r106 = r101.avatar;
            if (r106 == null) goto L14;
            ImageSet.ADAPTER.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.avatar_key;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            String r108 = r101.localized_name;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 9, r108);
        L20:
            CalendarMemberType r109 = r101.member_type;
            if (r109 == null) goto L23;
            CalendarMemberType.ADAPTER.encodeWithTag(r100, 10, r109);
        L23:
            String r110 = r101.chat_id;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 11, r110);
        L26:
            Integer r111 = r101.chat_member_count;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r111);
        L29:
            String r112 = r101.avatar_path;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 13, r112);
        L32:
            String r113 = r101.tenant_id;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 14, r113);
        L35:
            Boolean r114 = r101.is_cross_tenant;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r114);
        L38:
            Boolean r115 = r101.use_server_member_num;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r115);
        L41:
            TagData r116 = r101.relation_tag;
            if (r116 == null) goto L44;
            TagData.ADAPTER.encodeWithTag(r100, 17, r116);
        L44:
            RelationType r117 = r101.relation_type;
            if (r117 == null) goto L47;
            RelationType.ADAPTER.encodeWithTag(r100, 18, r117);
        L47:
            Boolean r118 = r101.is_user_count_visible;
            if (r118 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r118);
        L50:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarMember r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RelationType extends Enum<RelationType> implements WireEnum {
        private static final /* synthetic */ RelationType[] $VALUES = null;
        public static final ProtoAdapter<RelationType> ADAPTER = null;
        public static final RelationType EXTERNAL = null;
        public static final RelationType INTERNAL = null;
        private final int value;

        static {
            RelationType r100 = new RelationType("INTERNAL", 0, 0);
            INTERNAL = r100;
            RelationType r101 = new RelationType("EXTERNAL", 1, 1);
            EXTERNAL = r101;
            $VALUES = new RelationType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(RelationType.class);
        }

        public static RelationType[] values() {
            return (RelationType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RelationType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return EXTERNAL;
        L10:
            return INTERNAL;
        }

        public static RelationType valueOf(String r100) {
            return (RelationType) a.a(RelationType.class, r100);
        }

        private RelationType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarMember();
        DEFAULT_ACCESS_ROLE = Calendar.AccessRole.READER;
        DEFAULT_STATUS = Calendar.Status.DEFAULT;
        DEFAULT_MEMBER_TYPE = CalendarMemberType.INDIVIDUAL;
        DEFAULT_CHAT_MEMBER_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_USE_SERVER_MEMBER_NUM = r100;
        DEFAULT_RELATION_TYPE = RelationType.INTERNAL;
        DEFAULT_IS_USER_COUNT_VISIBLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253602id = this.f253601id;
        r100.calendar_id = this.calendar_id;
        r100.user_id = this.user_id;
        r100.access_role = this.access_role;
        r100.status = this.status;
        r100.name = this.name;
        r100.avatar = this.avatar;
        r100.avatar_key = this.avatar_key;
        r100.localized_name = this.localized_name;
        r100.member_type = this.member_type;
        r100.chat_id = this.chat_id;
        r100.chat_member_count = this.chat_member_count;
        r100.avatar_path = this.avatar_path;
        r100.tenant_id = this.tenant_id;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.use_server_member_num = this.use_server_member_num;
        r100.relation_tag = this.relation_tag;
        r100.relation_type = this.relation_type;
        r100.is_user_count_visible = this.is_user_count_visible;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarMember.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarMember(String r210, String r211, String r212, Calendar.AccessRole r213, Calendar.Status r214, String r215, ImageSet r216, String r217, String r310, CalendarMemberType r311, String r312, Integer r313, String r314, String r315, Boolean r316, Boolean r317, TagData r318, RelationType r319, Boolean r410) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, ByteString.EMPTY);
    }

    public CalendarMember(String r100, String r101, String r102, Calendar.AccessRole r103, Calendar.Status r104, String r105, ImageSet r110, String r111, String r112, CalendarMemberType r113, String r114, Integer r115, String r116, String r117, Boolean r118, Boolean r119, TagData r210, RelationType r211, Boolean r212, ByteString r213) {
        super(ADAPTER, r213);
        this.f253601id = r100;
        this.calendar_id = r101;
        this.user_id = r102;
        this.access_role = r103;
        this.status = r104;
        this.name = r105;
        this.avatar = r110;
        this.avatar_key = r111;
        this.localized_name = r112;
        this.member_type = r113;
        this.chat_id = r114;
        this.chat_member_count = r115;
        this.avatar_path = r116;
        this.tenant_id = r117;
        this.is_cross_tenant = r118;
        this.use_server_member_num = r119;
        this.relation_tag = r210;
        this.relation_type = r211;
        this.is_user_count_visible = r212;
    }
}
