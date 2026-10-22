package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Team extends com.squareup.wire.Message<Team, Builder> {
    public static final ProtoAdapter<Team> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_ID = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_OWNER_ID = null;
    public static final Status DEFAULT_STATUS = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final Long create_time;
    public final Long default_chat_id;
    public final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253573id;
    public final Integer member_count;
    public final String name;
    public final Long owner_id;
    public final TeamSetting setting;
    public final Status status;
    public final TeamUserEntity user_entity;
    public final Long version;

    public static final class Builder extends com.squareup.wire.Message.Builder<Team, Builder> {
        public String avatar_key;
        public Long create_time;
        public Long default_chat_id;
        public String description;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253574id;
        public Integer member_count;
        public String name;
        public Long owner_id;
        public TeamSetting setting;
        public Status status;
        public TeamUserEntity user_entity;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public Team build() {
            return new Team(this.f253574id, this.name, this.status, this.owner_id, this.member_count, this.default_chat_id, this.description, this.avatar_key, this.create_time, this.version, this.setting, this.user_entity, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder default_chat_id(Long r100) {
            this.default_chat_id = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253574id = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.member_count = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder owner_id(Long r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder setting(TeamSetting r100) {
            this.setting = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder user_entity(TeamUserEntity r100) {
            this.user_entity = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Team extends ProtoAdapter<Team> {
        public ProtoAdapter_Team() {
            super(FieldEncoding.LENGTH_DELIMITED, Team.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Team decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253574id = 0L;
            r101.name = "";
            r101.status = Status.UNKNOWN;
            r101.owner_id = 0L;
            r101.member_count = 0;
            r101.default_chat_id = 0L;
            r101.description = "";
            r101.avatar_key = "";
            r101.create_time = 0L;
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 20) goto L8;
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 21) goto L10;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 100) goto L12;
            r101.setting = TeamSetting.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 101) goto L13;
            r101.user_entity = TeamUserEntity.ADAPTER.decode(r100);
            goto L3
        L13:
            switch(r103) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L32;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L14;
            };
        L32:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.default_chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.member_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.owner_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L24:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.f253574id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Team r100) {
            Long r101 = r100.f253573id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Status r107 = r100.status;
            if (r107 == null) goto L13;
            int r108 = Status.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.owner_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.member_count;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.default_chat_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.description;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.avatar_key;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.create_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(20, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.version;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(21, r128);
        L42:
            int r130 = r127 + r129;
            TeamSetting r131 = r100.setting;
            if (r131 == null) goto L45;
            int r132 = TeamSetting.ADAPTER.encodedSizeWithTag(100, r131);
        L46:
            int r133 = r130 + r132;
            TeamUserEntity r134 = r100.user_entity;
            if (r134 == null) goto L50;
            r102 = TeamUserEntity.ADAPTER.encodedSizeWithTag(101, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ Team decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Team r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Team r101) throws IOException {
            Long r102 = r101.f253573id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Status r104 = r101.status;
            if (r104 == null) goto L11;
            Status.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.owner_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.member_count;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.default_chat_id;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.description;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.avatar_key;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.create_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 20, r110);
        L29:
            Long r111 = r101.version;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 21, r111);
        L32:
            TeamSetting r112 = r101.setting;
            if (r112 == null) goto L35;
            TeamSetting.ADAPTER.encodeWithTag(r100, 100, r112);
        L35:
            TeamUserEntity r113 = r101.user_entity;
            if (r113 == null) goto L38;
            TeamUserEntity.ADAPTER.encodeWithTag(r100, 101, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Team r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ACTIVE = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DISSOLVED = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("ACTIVE", 1, 1);
            ACTIVE = r101;
            Status r102 = new Status("DISSOLVED", 2, 2);
            DISSOLVED = r102;
            $VALUES = new Status[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DISSOLVED;
        L12:
            return ACTIVE;
        L14:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Team();
        DEFAULT_ID = 0L;
        DEFAULT_STATUS = Status.UNKNOWN;
        DEFAULT_OWNER_ID = 0L;
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_DEFAULT_CHAT_ID = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253574id = this.f253573id;
        r100.name = this.name;
        r100.status = this.status;
        r100.owner_id = this.owner_id;
        r100.member_count = this.member_count;
        r100.default_chat_id = this.default_chat_id;
        r100.description = this.description;
        r100.avatar_key = this.avatar_key;
        r100.create_time = this.create_time;
        r100.version = this.version;
        r100.setting = this.setting;
        r100.user_entity = this.user_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Team.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Team(Long r110, String r111, Status r112, Long r113, Integer r114, Long r210, String r211, String r212, Long r213, Long r214, TeamSetting r215, TeamUserEntity r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public Team(Long r100, String r101, Status r102, Long r103, Integer r104, Long r105, String r106, String r107, Long r110, Long r111, TeamSetting r112, TeamUserEntity r113, ByteString r114) {
        super(ADAPTER, r114);
        this.f253573id = r100;
        this.name = r101;
        this.status = r102;
        this.owner_id = r103;
        this.member_count = r104;
        this.default_chat_id = r105;
        this.description = r106;
        this.avatar_key = r107;
        this.create_time = r110;
        this.version = r111;
        this.setting = r112;
        this.user_entity = r113;
    }
}
