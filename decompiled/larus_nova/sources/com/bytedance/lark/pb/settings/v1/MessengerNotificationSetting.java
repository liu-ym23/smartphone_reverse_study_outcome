package com.bytedance.lark.pb.settings.v1;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
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
public final class MessengerNotificationSetting extends Message<MessengerNotificationSetting, Builder> {
    public static final ProtoAdapter<MessengerNotificationSetting> ADAPTER = null;
    public static final Boolean DEFAULT_BUZZ_OPEN = null;
    public static final Boolean DEFAULT_GROUP_CHAT_OPEN = null;
    public static final Boolean DEFAULT_MENTION_ALL_OPEN = null;
    public static final Boolean DEFAULT_MENTION_OPEN = null;
    public static final Boolean DEFAULT_P2P_CHAT_OPEN = null;
    public static final Boolean DEFAULT_REACTION_OPEN = null;
    public static final Boolean DEFAULT_SPECIAL_FOCUS_OPEN = null;
    public static final SwithState DEFAULT_SWITCH_STATE = null;
    public static final Boolean DEFAULT_USER_P2P_CHAT_OPEN = null;
    private static final long serialVersionUID = 0;
    public final Boolean buzz_open;
    public final Boolean group_chat_open;
    public final Boolean mention_all_open;
    public final Boolean mention_open;
    public final Boolean p2p_chat_open;
    public final Boolean reaction_open;
    public final Boolean special_focus_open;
    public final SpecialFocus special_focus_setting;
    public final SwithState switch_state;
    public final Boolean user_p2p_chat_open;

    public static final class Builder extends Message.Builder<MessengerNotificationSetting, Builder> {
        public Boolean buzz_open;
        public Boolean group_chat_open;
        public Boolean mention_all_open;
        public Boolean mention_open;
        public Boolean p2p_chat_open;
        public Boolean reaction_open;
        public Boolean special_focus_open;
        public SpecialFocus special_focus_setting;
        public SwithState switch_state;
        public Boolean user_p2p_chat_open;

        @Override // com.squareup.wire.Message.Builder
        public MessengerNotificationSetting build() {
            SwithState r100 = this.switch_state;
            if (r100 == null) goto L7;
            return new MessengerNotificationSetting(this.switch_state, this.buzz_open, this.reaction_open, this.mention_open, this.p2p_chat_open, this.group_chat_open, this.user_p2p_chat_open, this.mention_all_open, this.special_focus_open, this.special_focus_setting, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "switch_state"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder buzz_open(Boolean r100) {
            this.buzz_open = r100;
            return this;
        }

        public Builder group_chat_open(Boolean r100) {
            this.group_chat_open = r100;
            return this;
        }

        public Builder mention_all_open(Boolean r100) {
            this.mention_all_open = r100;
            return this;
        }

        public Builder mention_open(Boolean r100) {
            this.mention_open = r100;
            return this;
        }

        public Builder p2p_chat_open(Boolean r100) {
            this.p2p_chat_open = r100;
            return this;
        }

        public Builder reaction_open(Boolean r100) {
            this.reaction_open = r100;
            return this;
        }

        public Builder special_focus_open(Boolean r100) {
            this.special_focus_open = r100;
            return this;
        }

        public Builder special_focus_setting(SpecialFocus r100) {
            this.special_focus_setting = r100;
            return this;
        }

        public Builder switch_state(SwithState r100) {
            this.switch_state = r100;
            return this;
        }

        public Builder user_p2p_chat_open(Boolean r100) {
            this.user_p2p_chat_open = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessengerNotificationSetting extends ProtoAdapter<MessengerNotificationSetting> {
        public ProtoAdapter_MessengerNotificationSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, MessengerNotificationSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessengerNotificationSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.switch_state = SwithState.UNKNOWN_STATE;
            Boolean r102 = Boolean.FALSE;
            r101.buzz_open = r102;
            r101.reaction_open = r102;
            r101.mention_open = r102;
            r101.p2p_chat_open = r102;
            r101.group_chat_open = r102;
            r101.user_p2p_chat_open = r102;
            r101.mention_all_open = r102;
            r101.special_focus_open = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L22;
            if (r104 != 20) goto L7;
            r101.special_focus_setting = SpecialFocus.ADAPTER.decode(r100);
            goto L3
        L7:
            switch(r104) {
                case 1: goto L24;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                default: goto L8;
            };
        L24:
            r101.switch_state = SwithState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.special_focus_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mention_all_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.user_p2p_chat_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.group_chat_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.p2p_chat_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.mention_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.reaction_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.buzz_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessengerNotificationSetting r100) {
            int r101 = SwithState.ADAPTER.encodedSizeWithTag(1, r100.switch_state);
            Boolean r102 = r100.buzz_open;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.reaction_open;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.mention_open;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Boolean r112 = r100.p2p_chat_open;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.group_chat_open;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.user_p2p_chat_open;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            Boolean r121 = r100.mention_all_open;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r121);
        L30:
            int r123 = r120 + r122;
            Boolean r124 = r100.special_focus_open;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r124);
        L34:
            int r126 = r123 + r125;
            SpecialFocus r127 = r100.special_focus_setting;
            if (r127 == null) goto L38;
            r103 = SpecialFocus.ADAPTER.encodedSizeWithTag(20, r127);
        L38:
            return (r126 + r103) + r100.unknownFields().size();
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ MessengerNotificationSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessengerNotificationSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessengerNotificationSetting r101) throws IOException {
            SwithState.ADAPTER.encodeWithTag(r100, 1, r101.switch_state);
            Boolean r102 = r101.buzz_open;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.reaction_open;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.mention_open;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.p2p_chat_open;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.group_chat_open;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            Boolean r107 = r101.user_p2p_chat_open;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L20:
            Boolean r108 = r101.mention_all_open;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L23:
            Boolean r109 = r101.special_focus_open;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
        L26:
            SpecialFocus r110 = r101.special_focus_setting;
            if (r110 == null) goto L29;
            SpecialFocus.ADAPTER.encodeWithTag(r100, 20, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessengerNotificationSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SpecialFocus extends Message<SpecialFocus, Builder> {
        public static final ProtoAdapter<SpecialFocus> ADAPTER = null;
        public static final Boolean DEFAULT_NOTICE_IN_CHAT_BOX = null;
        public static final Boolean DEFAULT_NOTICE_IN_MUTE_CHAT = null;
        public static final Boolean DEFAULT_NOTICE_IN_MUTE_MODE = null;
        private static final long serialVersionUID = 0;
        public final Boolean notice_in_chat_box;
        public final Boolean notice_in_mute_chat;
        public final Boolean notice_in_mute_mode;

        public static final class Builder extends Message.Builder<SpecialFocus, Builder> {
            public Boolean notice_in_chat_box;
            public Boolean notice_in_mute_chat;
            public Boolean notice_in_mute_mode;

            @Override // com.squareup.wire.Message.Builder
            public SpecialFocus build() {
                return new SpecialFocus(this.notice_in_mute_chat, this.notice_in_mute_mode, this.notice_in_chat_box, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder notice_in_chat_box(Boolean r100) {
                this.notice_in_chat_box = r100;
                return this;
            }

            public Builder notice_in_mute_chat(Boolean r100) {
                this.notice_in_mute_chat = r100;
                return this;
            }

            public Builder notice_in_mute_mode(Boolean r100) {
                this.notice_in_mute_mode = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SpecialFocus extends ProtoAdapter<SpecialFocus> {
            public ProtoAdapter_SpecialFocus() {
                super(FieldEncoding.LENGTH_DELIMITED, SpecialFocus.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpecialFocus decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.notice_in_mute_chat = r102;
                r101.notice_in_mute_mode = r102;
                r101.notice_in_chat_box = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.notice_in_mute_chat = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.notice_in_mute_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.notice_in_chat_box = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(SpecialFocus r100) {
                Boolean r101 = r100.notice_in_mute_chat;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.notice_in_mute_mode;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.notice_in_chat_box;
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
            public /* bridge */ /* synthetic */ SpecialFocus decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SpecialFocus r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SpecialFocus r101) throws IOException {
                Boolean r102 = r101.notice_in_mute_chat;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.notice_in_mute_mode;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.notice_in_chat_box;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpecialFocus r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpecialFocus();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_NOTICE_IN_MUTE_CHAT = r100;
            DEFAULT_NOTICE_IN_MUTE_MODE = r100;
            DEFAULT_NOTICE_IN_CHAT_BOX = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.notice_in_mute_chat = this.notice_in_mute_chat;
            r100.notice_in_mute_mode = this.notice_in_mute_mode;
            r100.notice_in_chat_box = this.notice_in_chat_box;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SpecialFocus.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SpecialFocus(Boolean r100, Boolean r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SpecialFocus(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.notice_in_mute_chat = r100;
            this.notice_in_mute_mode = r101;
            this.notice_in_chat_box = r102;
        }
    }

    public static final enum SwithState extends Enum<SwithState> implements WireEnum {
        private static final /* synthetic */ SwithState[] $VALUES = null;
        public static final ProtoAdapter<SwithState> ADAPTER = null;
        public static final SwithState CLOSED = null;
        public static final SwithState HALF_OPEN = null;
        public static final SwithState OPEN = null;
        public static final SwithState UNKNOWN_STATE = null;
        private final int value;

        static {
            SwithState r100 = new SwithState("UNKNOWN_STATE", 0, 0);
            UNKNOWN_STATE = r100;
            SwithState r101 = new SwithState(ErrorCode.CLOSED, 1, 1);
            CLOSED = r101;
            SwithState r102 = new SwithState("HALF_OPEN", 2, 2);
            HALF_OPEN = r102;
            SwithState r103 = new SwithState("OPEN", 3, 3);
            OPEN = r103;
            $VALUES = new SwithState[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SwithState.class);
        }

        public static SwithState[] values() {
            return (SwithState[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SwithState fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return OPEN;
        L14:
            return HALF_OPEN;
        L16:
            return CLOSED;
        L18:
            return UNKNOWN_STATE;
        }

        public static SwithState valueOf(String r100) {
            return (SwithState) a.a(SwithState.class, r100);
        }

        private SwithState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessengerNotificationSetting();
        DEFAULT_SWITCH_STATE = SwithState.UNKNOWN_STATE;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_BUZZ_OPEN = r100;
        DEFAULT_REACTION_OPEN = r100;
        DEFAULT_MENTION_OPEN = r100;
        DEFAULT_P2P_CHAT_OPEN = r100;
        DEFAULT_GROUP_CHAT_OPEN = r100;
        DEFAULT_USER_P2P_CHAT_OPEN = r100;
        DEFAULT_MENTION_ALL_OPEN = r100;
        DEFAULT_SPECIAL_FOCUS_OPEN = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.switch_state = this.switch_state;
        r100.buzz_open = this.buzz_open;
        r100.reaction_open = this.reaction_open;
        r100.mention_open = this.mention_open;
        r100.p2p_chat_open = this.p2p_chat_open;
        r100.group_chat_open = this.group_chat_open;
        r100.user_p2p_chat_open = this.user_p2p_chat_open;
        r100.mention_all_open = this.mention_all_open;
        r100.special_focus_open = this.special_focus_open;
        r100.special_focus_setting = this.special_focus_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessengerNotificationSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessengerNotificationSetting(SwithState r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, Boolean r116, Boolean r210, Boolean r211, SpecialFocus r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public MessengerNotificationSetting(SwithState r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, Boolean r107, Boolean r110, SpecialFocus r111, ByteString r112) {
        super(ADAPTER, r112);
        this.switch_state = r100;
        this.buzz_open = r101;
        this.reaction_open = r102;
        this.mention_open = r103;
        this.p2p_chat_open = r104;
        this.group_chat_open = r105;
        this.user_p2p_chat_open = r106;
        this.mention_all_open = r107;
        this.special_focus_open = r110;
        this.special_focus_setting = r111;
    }
}
