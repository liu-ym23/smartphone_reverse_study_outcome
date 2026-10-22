package com.bytedance.lark.pb.calendar.v1;

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
public final class MeetingChatConfig extends Message<MeetingChatConfig, Builder> {
    public static final ProtoAdapter<MeetingChatConfig> ADAPTER = null;
    public static final String DEFAULT_ASSOCIATE_CHAT_ID = "";
    public static final String DEFAULT_BIND_CHAT_ID = "";
    public static final String DEFAULT_BIND_USER_ID = "";
    public static final Boolean DEFAULT_FORBID_CREATE_CHAT = null;
    public static final MeetingChatSettingType DEFAULT_MEETING_CHAT_SETTING_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String associate_chat_id;
    public final String bind_chat_id;
    public final String bind_user_id;
    public final Boolean forbid_create_chat;
    public final MeetingChatSettingType meeting_chat_setting_type;

    public static final class Builder extends Message.Builder<MeetingChatConfig, Builder> {
        public String associate_chat_id;
        public String bind_chat_id;
        public String bind_user_id;
        public Boolean forbid_create_chat;
        public MeetingChatSettingType meeting_chat_setting_type;

        @Override // com.squareup.wire.Message.Builder
        public MeetingChatConfig build() {
            return new MeetingChatConfig(this.forbid_create_chat, this.meeting_chat_setting_type, this.bind_chat_id, this.bind_user_id, this.associate_chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder associate_chat_id(String r100) {
            this.associate_chat_id = r100;
            return this;
        }

        public Builder bind_chat_id(String r100) {
            this.bind_chat_id = r100;
            return this;
        }

        public Builder bind_user_id(String r100) {
            this.bind_user_id = r100;
            return this;
        }

        public Builder forbid_create_chat(Boolean r100) {
            this.forbid_create_chat = r100;
            return this;
        }

        public Builder meeting_chat_setting_type(MeetingChatSettingType r100) {
            this.meeting_chat_setting_type = r100;
            return this;
        }
    }

    public static final enum MeetingChatSettingType extends Enum<MeetingChatSettingType> implements WireEnum {
        private static final /* synthetic */ MeetingChatSettingType[] $VALUES = null;
        public static final ProtoAdapter<MeetingChatSettingType> ADAPTER = null;
        public static final MeetingChatSettingType ALLOW_CREATE_CHAT = null;
        public static final MeetingChatSettingType BIND_CHAT = null;
        public static final MeetingChatSettingType FORBID_CREATE_CHAT = null;
        public static final MeetingChatSettingType UNKNOWN = null;
        private final int value;

        static {
            MeetingChatSettingType r100 = new MeetingChatSettingType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            MeetingChatSettingType r101 = new MeetingChatSettingType("ALLOW_CREATE_CHAT", 1, 1);
            ALLOW_CREATE_CHAT = r101;
            MeetingChatSettingType r102 = new MeetingChatSettingType("FORBID_CREATE_CHAT", 2, 2);
            FORBID_CREATE_CHAT = r102;
            MeetingChatSettingType r103 = new MeetingChatSettingType("BIND_CHAT", 3, 3);
            BIND_CHAT = r103;
            $VALUES = new MeetingChatSettingType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(MeetingChatSettingType.class);
        }

        public static MeetingChatSettingType[] values() {
            return (MeetingChatSettingType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MeetingChatSettingType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return BIND_CHAT;
        L14:
            return FORBID_CREATE_CHAT;
        L16:
            return ALLOW_CREATE_CHAT;
        L18:
            return UNKNOWN;
        }

        public static MeetingChatSettingType valueOf(String r100) {
            return (MeetingChatSettingType) a.a(MeetingChatSettingType.class, r100);
        }

        private MeetingChatSettingType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_MeetingChatConfig extends ProtoAdapter<MeetingChatConfig> {
        public ProtoAdapter_MeetingChatConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingChatConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingChatConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.forbid_create_chat = Boolean.FALSE;
            r101.meeting_chat_setting_type = MeetingChatSettingType.UNKNOWN;
            r101.bind_chat_id = "";
            r101.bind_user_id = "";
            r101.associate_chat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.forbid_create_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.meeting_chat_setting_type = MeetingChatSettingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.bind_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.bind_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.associate_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MeetingChatConfig r100) {
            Boolean r101 = r100.forbid_create_chat;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            MeetingChatSettingType r104 = r100.meeting_chat_setting_type;
            if (r104 == null) goto L9;
            int r105 = MeetingChatSettingType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.bind_chat_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.bind_user_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.associate_chat_id;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MeetingChatConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingChatConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingChatConfig r101) throws IOException {
            Boolean r102 = r101.forbid_create_chat;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            MeetingChatSettingType r103 = r101.meeting_chat_setting_type;
            if (r103 == null) goto L8;
            MeetingChatSettingType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.bind_chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.bind_user_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.associate_chat_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingChatConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingChatConfig();
        DEFAULT_FORBID_CREATE_CHAT = Boolean.FALSE;
        DEFAULT_MEETING_CHAT_SETTING_TYPE = MeetingChatSettingType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.forbid_create_chat = this.forbid_create_chat;
        r100.meeting_chat_setting_type = this.meeting_chat_setting_type;
        r100.bind_chat_id = this.bind_chat_id;
        r100.bind_user_id = this.bind_user_id;
        r100.associate_chat_id = this.associate_chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingChatConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingChatConfig(Boolean r100, MeetingChatSettingType r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MeetingChatConfig(Boolean r100, MeetingChatSettingType r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.forbid_create_chat = r100;
        this.meeting_chat_setting_type = r101;
        this.bind_chat_id = r102;
        this.bind_user_id = r103;
        this.associate_chat_id = r104;
    }
}
