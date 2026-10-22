package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatSetting extends com.squareup.wire.Message<ChatSetting, Builder> {
    public static final ProtoAdapter<ChatSetting> ADAPTER = null;
    public static final Long DEFAULT_ANONYMOUS_USER_ID = null;
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATE = null;
    public static final Long DEFAULT_IS_AUTO_TRANSLATE_VERSION = null;
    public static final Boolean DEFAULT_IS_HIDDEN_NICKNAME = null;
    public static final Boolean DEFAULT_IS_MUTE_AT_ALL = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long manonymous_user_id;
    public final ChatNameTranslateEntity mchat_name_translate;
    public final CheckMessagePositionSetting.Enum mcheck_message_position;
    public final Boolean mis_auto_translate;
    public final Long mis_auto_translate_version;
    public final Boolean mis_hidden_nickname;
    public final Boolean mis_mute_at_all;
    public final Boolean mis_remind;
    public final TypingTranslateEntity mtyping_translate;
    public final Long mupdate_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatSetting, Builder> {
        public Long manonymous_user_id;
        public ChatNameTranslateEntity mchat_name_translate;
        public CheckMessagePositionSetting.Enum mcheck_message_position;
        public Boolean mis_auto_translate;
        public Long mis_auto_translate_version;
        public Boolean mis_hidden_nickname;
        public Boolean mis_mute_at_all;
        public Boolean mis_remind;
        public TypingTranslateEntity mtyping_translate;
        public Long mupdate_time;

        @Override // com.squareup.wire.Message.Builder
        public ChatSetting build() {
            return new ChatSetting(this.mis_remind, this.mupdate_time, this.mcheck_message_position, this.mis_auto_translate, this.mis_hidden_nickname, this.mis_auto_translate_version, this.manonymous_user_id, this.mis_mute_at_all, this.mtyping_translate, this.mchat_name_translate, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder anonymous_user_id(Long r100) {
            this.manonymous_user_id = r100;
            return this;
        }

        public Builder chat_name_translate(ChatNameTranslateEntity r100) {
            this.mchat_name_translate = r100;
            return this;
        }

        public Builder check_message_position(CheckMessagePositionSetting.Enum r100) {
            this.mcheck_message_position = r100;
            return this;
        }

        public Builder is_auto_translate(Boolean r100) {
            this.mis_auto_translate = r100;
            return this;
        }

        public Builder is_auto_translate_version(Long r100) {
            this.mis_auto_translate_version = r100;
            return this;
        }

        public Builder is_hidden_nickname(Boolean r100) {
            this.mis_hidden_nickname = r100;
            return this;
        }

        public Builder is_mute_at_all(Boolean r100) {
            this.mis_mute_at_all = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.mis_remind = r100;
            return this;
        }

        public Builder typing_translate(TypingTranslateEntity r100) {
            this.mtyping_translate = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.mupdate_time = r100;
            return this;
        }
    }

    public static final class ChatNameTranslateEntity extends com.squareup.wire.Message<ChatNameTranslateEntity, Builder> {
        public static final ProtoAdapter<ChatNameTranslateEntity> ADAPTER = null;
        public static final String DEFAULT_CHAT_NAME_TARGET_LANGUAGE = "";
        public static final Boolean DEFAULT_IS_MANUAL_TRANSLATE_CHAT_NAME = null;
        private static final long serialVersionUID = 0;
        public final String mchat_name_target_language;
        public final DisplayRule mdisplay_rule;
        public final Boolean mis_manual_translate_chat_name;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatNameTranslateEntity, Builder> {
            public String mchat_name_target_language;
            public DisplayRule mdisplay_rule;
            public Boolean mis_manual_translate_chat_name;

            @Override // com.squareup.wire.Message.Builder
            public ChatNameTranslateEntity build() {
                return new ChatNameTranslateEntity(this.mis_manual_translate_chat_name, this.mdisplay_rule, this.mchat_name_target_language, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chat_name_target_language(String r100) {
                this.mchat_name_target_language = r100;
                return this;
            }

            public Builder display_rule(DisplayRule r100) {
                this.mdisplay_rule = r100;
                return this;
            }

            public Builder is_manual_translate_chat_name(Boolean r100) {
                this.mis_manual_translate_chat_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatNameTranslateEntity extends ProtoAdapter<ChatNameTranslateEntity> {
            public ProtoAdapter_ChatNameTranslateEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatNameTranslateEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatNameTranslateEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mis_manual_translate_chat_name = Boolean.FALSE;
                r101.mchat_name_target_language = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mis_manual_translate_chat_name = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mdisplay_rule = DisplayRule.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mchat_name_target_language = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatNameTranslateEntity r100) {
                Boolean r101 = r100.mis_manual_translate_chat_name;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                DisplayRule r104 = r100.mdisplay_rule;
                if (r104 == null) goto L9;
                int r105 = DisplayRule.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mchat_name_target_language;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ChatNameTranslateEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatNameTranslateEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatNameTranslateEntity r101) throws IOException {
                Boolean r102 = r101.mis_manual_translate_chat_name;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                DisplayRule r103 = r101.mdisplay_rule;
                if (r103 == null) goto L8;
                DisplayRule.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mchat_name_target_language;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatNameTranslateEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatNameTranslateEntity();
            DEFAULT_IS_MANUAL_TRANSLATE_CHAT_NAME = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_manual_translate_chat_name = this.mis_manual_translate_chat_name;
            r100.mdisplay_rule = this.mdisplay_rule;
            r100.mchat_name_target_language = this.mchat_name_target_language;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatNameTranslateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatNameTranslateEntity(Boolean r100, DisplayRule r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ChatNameTranslateEntity(Boolean r100, DisplayRule r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mis_manual_translate_chat_name = r100;
            this.mdisplay_rule = r101;
            this.mchat_name_target_language = r102;
        }
    }

    public static final class CheckMessagePositionSetting extends com.squareup.wire.Message<CheckMessagePositionSetting, Builder> {
        public static final ProtoAdapter<CheckMessagePositionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CheckMessagePositionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public CheckMessagePositionSetting build() {
                return new CheckMessagePositionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum NEWEST_UNREAD = null;
            public static final Enum RECENT_LEFT = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("RECENT_LEFT", 1, 1);
                RECENT_LEFT = r101;
                Enum r102 = new Enum("NEWEST_UNREAD", 2, 2);
                NEWEST_UNREAD = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return NEWEST_UNREAD;
            L12:
                return RECENT_LEFT;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_CheckMessagePositionSetting extends ProtoAdapter<CheckMessagePositionSetting> {
            public ProtoAdapter_CheckMessagePositionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CheckMessagePositionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CheckMessagePositionSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CheckMessagePositionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CheckMessagePositionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CheckMessagePositionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CheckMessagePositionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckMessagePositionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CheckMessagePositionSetting();
        }

        public CheckMessagePositionSetting() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CheckMessagePositionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CheckMessagePositionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final enum Field extends Enum<Field> implements WireEnum {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Field CAN_AUTO_OPEN_V1 = null;
        public static final Field CAN_AUTO_OPEN_V3 = null;
        public static final Field CHAT_NAME_TRANSLATE = null;
        public static final Field CHECK_MESSAGE_POSITION = null;
        public static final Field ENABLE_USE_TRANSLATE_ORIGINAL = null;
        public static final Field IS_AUTO_TRANSLATE = null;
        public static final Field IS_HIDDEN_NICKNAME = null;
        public static final Field IS_MUTE_AT_ALL = null;
        public static final Field IS_REMIND = null;
        public static final Field TYPING_TRANSLATE = null;
        public static final Field UNKNOWN = null;
        public static final Field UPDATE_TIME = null;
        private final int value;

        static {
            Field r100 = new Field("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Field r101 = new Field("IS_REMIND", 1, 1);
            IS_REMIND = r101;
            Field r102 = new Field("UPDATE_TIME", 2, 2);
            UPDATE_TIME = r102;
            Field r103 = new Field("CHECK_MESSAGE_POSITION", 3, 3);
            CHECK_MESSAGE_POSITION = r103;
            Field r104 = new Field("IS_AUTO_TRANSLATE", 4, 4);
            IS_AUTO_TRANSLATE = r104;
            Field r105 = new Field("IS_HIDDEN_NICKNAME", 5, 5);
            IS_HIDDEN_NICKNAME = r105;
            Field r110 = new Field("IS_MUTE_AT_ALL", 6, 6);
            IS_MUTE_AT_ALL = r110;
            Field r111 = new Field("TYPING_TRANSLATE", 7, 7);
            TYPING_TRANSLATE = r111;
            Field r112 = new Field("ENABLE_USE_TRANSLATE_ORIGINAL", 8, 8);
            ENABLE_USE_TRANSLATE_ORIGINAL = r112;
            Field r113 = new Field("CAN_AUTO_OPEN_V1", 9, 9);
            CAN_AUTO_OPEN_V1 = r113;
            Field r114 = new Field("CAN_AUTO_OPEN_V3", 10, 10);
            CAN_AUTO_OPEN_V3 = r114;
            Field r115 = new Field("CHAT_NAME_TRANSLATE", 11, 11);
            CHAT_NAME_TRANSLATE = r115;
            $VALUES = new Field[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
            ADAPTER = ProtoAdapter.newEnumAdapter(Field.class);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Field fromValue(int r100) {
            switch(r100) {
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L18;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L10;
                case 10: goto L8;
                case 11: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CHAT_NAME_TRANSLATE;
        L8:
            return CAN_AUTO_OPEN_V3;
        L10:
            return CAN_AUTO_OPEN_V1;
        L12:
            return ENABLE_USE_TRANSLATE_ORIGINAL;
        L14:
            return TYPING_TRANSLATE;
        L16:
            return IS_MUTE_AT_ALL;
        L18:
            return IS_HIDDEN_NICKNAME;
        L20:
            return IS_AUTO_TRANSLATE;
        L22:
            return CHECK_MESSAGE_POSITION;
        L24:
            return UPDATE_TIME;
        L26:
            return IS_REMIND;
        L28:
            return UNKNOWN;
        }

        public static Field valueOf(String r100) {
            return (Field) a.a(Field.class, r100);
        }

        private Field(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ChatSetting extends ProtoAdapter<ChatSetting> {
        public ProtoAdapter_ChatSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_remind = Boolean.TRUE;
            r101.mupdate_time = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.mis_auto_translate = r102;
            r101.mis_hidden_nickname = r102;
            r101.mis_auto_translate_version = 0L;
            r101.manonymous_user_id = 0L;
            r101.mis_mute_at_all = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            switch(r104) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.mcheck_message_position = CheckMessagePositionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mchat_name_translate = ChatNameTranslateEntity.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mtyping_translate = TypingTranslateEntity.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mis_mute_at_all = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.manonymous_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.mis_auto_translate_version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.mis_hidden_nickname = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mis_auto_translate = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.mis_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatSetting r100) {
            Boolean r101 = r100.mis_remind;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mupdate_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CheckMessagePositionSetting.Enum r107 = r100.mcheck_message_position;
            if (r107 == null) goto L13;
            int r108 = CheckMessagePositionSetting.Enum.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_auto_translate;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mis_hidden_nickname;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.mis_auto_translate_version;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.manonymous_user_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.mis_mute_at_all;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            TypingTranslateEntity r125 = r100.mtyping_translate;
            if (r125 == null) goto L37;
            int r126 = TypingTranslateEntity.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            ChatNameTranslateEntity r128 = r100.mchat_name_translate;
            if (r128 == null) goto L42;
            r102 = ChatNameTranslateEntity.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ChatSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatSetting r101) throws IOException {
            Boolean r102 = r101.mis_remind;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mupdate_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            CheckMessagePositionSetting.Enum r104 = r101.mcheck_message_position;
            if (r104 == null) goto L11;
            CheckMessagePositionSetting.Enum.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mis_auto_translate;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.mis_hidden_nickname;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.mis_auto_translate_version;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.manonymous_user_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.mis_mute_at_all;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            TypingTranslateEntity r110 = r101.mtyping_translate;
            if (r110 == null) goto L29;
            TypingTranslateEntity.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            ChatNameTranslateEntity r111 = r101.mchat_name_translate;
            if (r111 == null) goto L32;
            ChatNameTranslateEntity.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TypingTranslateEntity extends com.squareup.wire.Message<TypingTranslateEntity, Builder> {
        public static final ProtoAdapter<TypingTranslateEntity> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN_V1 = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN_V3 = null;
        public static final Boolean DEFAULT_ENABLE_USE_TRANSLATE_ORIGINAL = null;
        public static final Boolean DEFAULT_IS_OPEN = null;
        public static final String DEFAULT_LOCALE = "";
        public static final Long DEFAULT_UPDATE_TIME_NS = null;
        private static final long serialVersionUID = 0;
        public final Boolean mcan_auto_open;
        public final Boolean mcan_auto_open_v1;
        public final Boolean mcan_auto_open_v3;
        public final AutoOpenCloseMode mclose_mode;
        public final Boolean menable_use_translate_original;
        public final Boolean mis_open;
        public final String mlocale;
        public final OpenMode mopen_mode;
        public final Long mupdate_time_ns;

        public static final enum AutoOpenCloseMode extends Enum<AutoOpenCloseMode> implements WireEnum {
            private static final /* synthetic */ AutoOpenCloseMode[] $VALUES = null;
            public static final ProtoAdapter<AutoOpenCloseMode> ADAPTER = null;
            public static final AutoOpenCloseMode CLOSE_DIRECTLY = null;
            public static final AutoOpenCloseMode CLOSE_NO_LONGER_OPEN = null;
            public static final AutoOpenCloseMode CLOSE_POPUP = null;
            public static final AutoOpenCloseMode CLOSE_UNKNOWN = null;
            private final int value;

            static {
                AutoOpenCloseMode r100 = new AutoOpenCloseMode("CLOSE_UNKNOWN", 0, 0);
                CLOSE_UNKNOWN = r100;
                AutoOpenCloseMode r101 = new AutoOpenCloseMode("CLOSE_DIRECTLY", 1, 1);
                CLOSE_DIRECTLY = r101;
                AutoOpenCloseMode r102 = new AutoOpenCloseMode("CLOSE_POPUP", 2, 2);
                CLOSE_POPUP = r102;
                AutoOpenCloseMode r103 = new AutoOpenCloseMode("CLOSE_NO_LONGER_OPEN", 3, 3);
                CLOSE_NO_LONGER_OPEN = r103;
                $VALUES = new AutoOpenCloseMode[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(AutoOpenCloseMode.class);
            }

            public static AutoOpenCloseMode[] values() {
                return (AutoOpenCloseMode[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static AutoOpenCloseMode fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return CLOSE_NO_LONGER_OPEN;
            L14:
                return CLOSE_POPUP;
            L16:
                return CLOSE_DIRECTLY;
            L18:
                return CLOSE_UNKNOWN;
            }

            public static AutoOpenCloseMode valueOf(String r100) {
                return (AutoOpenCloseMode) a.a(AutoOpenCloseMode.class, r100);
            }

            private AutoOpenCloseMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<TypingTranslateEntity, Builder> {
            public Boolean mcan_auto_open;
            public Boolean mcan_auto_open_v1;
            public Boolean mcan_auto_open_v3;
            public AutoOpenCloseMode mclose_mode;
            public Boolean menable_use_translate_original;
            public Boolean mis_open;
            public String mlocale;
            public OpenMode mopen_mode;
            public Long mupdate_time_ns;

            @Override // com.squareup.wire.Message.Builder
            public TypingTranslateEntity build() {
                return new TypingTranslateEntity(this.mis_open, this.mopen_mode, this.mlocale, this.mcan_auto_open, this.menable_use_translate_original, this.mupdate_time_ns, this.mcan_auto_open_v1, this.mcan_auto_open_v3, this.mclose_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder can_auto_open(Boolean r100) {
                this.mcan_auto_open = r100;
                return this;
            }

            public Builder can_auto_open_v1(Boolean r100) {
                this.mcan_auto_open_v1 = r100;
                return this;
            }

            public Builder can_auto_open_v3(Boolean r100) {
                this.mcan_auto_open_v3 = r100;
                return this;
            }

            public Builder close_mode(AutoOpenCloseMode r100) {
                this.mclose_mode = r100;
                return this;
            }

            public Builder enable_use_translate_original(Boolean r100) {
                this.menable_use_translate_original = r100;
                return this;
            }

            public Builder is_open(Boolean r100) {
                this.mis_open = r100;
                return this;
            }

            public Builder locale(String r100) {
                this.mlocale = r100;
                return this;
            }

            public Builder open_mode(OpenMode r100) {
                this.mopen_mode = r100;
                return this;
            }

            public Builder update_time_ns(Long r100) {
                this.mupdate_time_ns = r100;
                return this;
            }
        }

        public static final enum OpenMode extends Enum<OpenMode> implements WireEnum {
            private static final /* synthetic */ OpenMode[] $VALUES = null;
            public static final ProtoAdapter<OpenMode> ADAPTER = null;
            public static final OpenMode AUTO = null;
            public static final OpenMode MANUAL = null;
            public static final OpenMode UNKNOWN = null;
            private final int value;

            static {
                OpenMode r100 = new OpenMode("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                OpenMode r101 = new OpenMode("MANUAL", 1, 1);
                MANUAL = r101;
                OpenMode r102 = new OpenMode("AUTO", 2, 2);
                AUTO = r102;
                $VALUES = new OpenMode[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(OpenMode.class);
            }

            public static OpenMode[] values() {
                return (OpenMode[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static OpenMode fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return AUTO;
            L12:
                return MANUAL;
            L14:
                return UNKNOWN;
            }

            public static OpenMode valueOf(String r100) {
                return (OpenMode) a.a(OpenMode.class, r100);
            }

            private OpenMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_TypingTranslateEntity extends ProtoAdapter<TypingTranslateEntity> {
            public ProtoAdapter_TypingTranslateEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, TypingTranslateEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TypingTranslateEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.mis_open = r102;
                r101.mlocale = "";
                Boolean r103 = Boolean.TRUE;
                r101.mcan_auto_open = r103;
                r101.menable_use_translate_original = r102;
                r101.mupdate_time_ns = 0L;
                r101.mcan_auto_open_v1 = r103;
                r101.mcan_auto_open_v3 = r103;
                long r104 = r100.beginMessage();
            L3:
                int r105 = r100.nextTag();
                if (r105 == (-1)) goto L22;
                switch(r105) {
                    case 1: goto L21;
                    case 2: goto L24;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L6;
                    case 10: goto L26;
                    default: goto L6;
                };
            L24:
                r101.mopen_mode = OpenMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L26:
                r101.mclose_mode = AutoOpenCloseMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.mcan_auto_open_v3 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.mcan_auto_open_v1 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.mupdate_time_ns = ProtoAdapter.INT64.decode(r100);
                goto L3
            L14:
                r101.menable_use_translate_original = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.mcan_auto_open = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.mlocale = ProtoAdapter.STRING.decode(r100);
                goto L3
            L21:
                r101.mis_open = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r106 = r100.peekFieldEncoding();
                r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
                goto L3
            L22:
                r100.endMessage(r104);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TypingTranslateEntity r100) {
                Boolean r101 = r100.mis_open;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                OpenMode r104 = r100.mopen_mode;
                if (r104 == null) goto L9;
                int r105 = OpenMode.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mlocale;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.mcan_auto_open;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.menable_use_translate_original;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Long r116 = r100.mupdate_time_ns;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.mcan_auto_open_v1;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.mcan_auto_open_v3;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                AutoOpenCloseMode r125 = r100.mclose_mode;
                if (r125 == null) goto L38;
                r102 = AutoOpenCloseMode.ADAPTER.encodedSizeWithTag(10, r125);
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
            public /* bridge */ /* synthetic */ TypingTranslateEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TypingTranslateEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TypingTranslateEntity r101) throws IOException {
                Boolean r102 = r101.mis_open;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                OpenMode r103 = r101.mopen_mode;
                if (r103 == null) goto L8;
                OpenMode.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mlocale;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.mcan_auto_open;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.menable_use_translate_original;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                Long r107 = r101.mupdate_time_ns;
                if (r107 == null) goto L20;
                ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.mcan_auto_open_v1;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                Boolean r109 = r101.mcan_auto_open_v3;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
            L26:
                AutoOpenCloseMode r110 = r101.mclose_mode;
                if (r110 == null) goto L29;
                AutoOpenCloseMode.ADAPTER.encodeWithTag(r100, 10, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TypingTranslateEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TypingTranslateEntity();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_OPEN = r100;
            Boolean r101 = Boolean.TRUE;
            DEFAULT_CAN_AUTO_OPEN = r101;
            DEFAULT_ENABLE_USE_TRANSLATE_ORIGINAL = r100;
            DEFAULT_UPDATE_TIME_NS = 0L;
            DEFAULT_CAN_AUTO_OPEN_V1 = r101;
            DEFAULT_CAN_AUTO_OPEN_V3 = r101;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_open = this.mis_open;
            r100.mopen_mode = this.mopen_mode;
            r100.mlocale = this.mlocale;
            r100.mcan_auto_open = this.mcan_auto_open;
            r100.menable_use_translate_original = this.menable_use_translate_original;
            r100.mupdate_time_ns = this.mupdate_time_ns;
            r100.mcan_auto_open_v1 = this.mcan_auto_open_v1;
            r100.mcan_auto_open_v3 = this.mcan_auto_open_v3;
            r100.mclose_mode = this.mclose_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TypingTranslateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TypingTranslateEntity(Boolean r110, OpenMode r111, String r112, Boolean r113, Boolean r114, Long r115, Boolean r116, Boolean r117, AutoOpenCloseMode r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public TypingTranslateEntity(Boolean r100, OpenMode r101, String r102, Boolean r103, Boolean r104, Long r105, Boolean r106, Boolean r107, AutoOpenCloseMode r110, ByteString r111) {
            super(ADAPTER, r111);
            this.mis_open = r100;
            this.mopen_mode = r101;
            this.mlocale = r102;
            this.mcan_auto_open = r103;
            this.menable_use_translate_original = r104;
            this.mupdate_time_ns = r105;
            this.mcan_auto_open_v1 = r106;
            this.mcan_auto_open_v3 = r107;
            this.mclose_mode = r110;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatSetting();
        DEFAULT_IS_REMIND = Boolean.TRUE;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_AUTO_TRANSLATE = r100;
        DEFAULT_IS_HIDDEN_NICKNAME = r100;
        DEFAULT_IS_AUTO_TRANSLATE_VERSION = 0L;
        DEFAULT_ANONYMOUS_USER_ID = 0L;
        DEFAULT_IS_MUTE_AT_ALL = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_remind = this.mis_remind;
        r100.mupdate_time = this.mupdate_time;
        r100.mcheck_message_position = this.mcheck_message_position;
        r100.mis_auto_translate = this.mis_auto_translate;
        r100.mis_hidden_nickname = this.mis_hidden_nickname;
        r100.mis_auto_translate_version = this.mis_auto_translate_version;
        r100.manonymous_user_id = this.manonymous_user_id;
        r100.mis_mute_at_all = this.mis_mute_at_all;
        r100.mtyping_translate = this.mtyping_translate;
        r100.mchat_name_translate = this.mchat_name_translate;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatSetting(Boolean r110, Long r111, CheckMessagePositionSetting.Enum r112, Boolean r113, Boolean r114, Long r115, Long r116, Boolean r210, TypingTranslateEntity r211, ChatNameTranslateEntity r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public ChatSetting(Boolean r100, Long r101, CheckMessagePositionSetting.Enum r102, Boolean r103, Boolean r104, Long r105, Long r106, Boolean r107, TypingTranslateEntity r110, ChatNameTranslateEntity r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mis_remind = r100;
        this.mupdate_time = r101;
        this.mcheck_message_position = r102;
        this.mis_auto_translate = r103;
        this.mis_hidden_nickname = r104;
        this.mis_auto_translate_version = r105;
        this.manonymous_user_id = r106;
        this.mis_mute_at_all = r107;
        this.mtyping_translate = r110;
        this.mchat_name_translate = r111;
    }
}
