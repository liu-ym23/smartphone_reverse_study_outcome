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
public final class CalendarEventDisplayInfo extends Message<CalendarEventDisplayInfo, Builder> {
    public static final ProtoAdapter<CalendarEventDisplayInfo> ADAPTER = null;
    public static final ButtonDisplayType DEFAULT_DELETE_BTN_DISPLAY_TYPE = null;
    public static final ButtonDisplayType DEFAULT_EDIT_BTN_DISPLAY_TYPE = null;
    public static final Boolean DEFAULT_IS_COPY_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_DELETABLE_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_EDITABLE_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_EVENT_CREATOR_SHOW = null;
    public static final Boolean DEFAULT_IS_EVENT_NOTE_SHOW = null;
    public static final Boolean DEFAULT_IS_EVENT_ORGANIZER_SHOW = null;
    public static final Boolean DEFAULT_IS_INDIVIDUAL_ATTENDEE_SYNCING = null;
    public static final Boolean DEFAULT_IS_MEETING_CHAT_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_MEETING_MINUTES_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_REPORT_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_SHARABLE_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_TRANSFER_BTN_SHOW = null;
    public static final Boolean DEFAULT_IS_VIDEO_MEETING_BTN_SHOW = null;
    public static final ButtonDisplayType DEFAULT_MEETING_CHAT_BTN_DISPLAY_TYPE = null;
    public static final ButtonDisplayType DEFAULT_MEETING_MINUTES_BTN_DISPLAY_TYPE = null;
    public static final ShareButtonDisplayType DEFAULT_SHARE_BTN_DISPLAY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final ButtonDisplayType delete_btn_display_type;
    public final CalendarEventDisplayExtraData display_extra_data;
    public final ButtonDisplayType edit_btn_display_type;
    public final Boolean is_copy_btn_show;
    public final Boolean is_deletable_btn_show;
    public final Boolean is_editable_btn_show;
    public final Boolean is_event_creator_show;
    public final Boolean is_event_note_show;
    public final Boolean is_event_organizer_show;
    public final Boolean is_individual_attendee_syncing;
    public final Boolean is_meeting_chat_btn_show;
    public final Boolean is_meeting_minutes_btn_show;
    public final Boolean is_report_btn_show;
    public final Boolean is_sharable_btn_show;
    public final Boolean is_transfer_btn_show;
    public final Boolean is_video_meeting_btn_show;
    public final ButtonDisplayType meeting_chat_btn_display_type;
    public final ButtonDisplayType meeting_minutes_btn_display_type;
    public final ShareButtonDisplayType share_btn_display_type;

    public static final class Builder extends Message.Builder<CalendarEventDisplayInfo, Builder> {
        public ButtonDisplayType delete_btn_display_type;
        public CalendarEventDisplayExtraData display_extra_data;
        public ButtonDisplayType edit_btn_display_type;
        public Boolean is_copy_btn_show;
        public Boolean is_deletable_btn_show;
        public Boolean is_editable_btn_show;
        public Boolean is_event_creator_show;
        public Boolean is_event_note_show;
        public Boolean is_event_organizer_show;
        public Boolean is_individual_attendee_syncing;
        public Boolean is_meeting_chat_btn_show;
        public Boolean is_meeting_minutes_btn_show;
        public Boolean is_report_btn_show;
        public Boolean is_sharable_btn_show;
        public Boolean is_transfer_btn_show;
        public Boolean is_video_meeting_btn_show;
        public ButtonDisplayType meeting_chat_btn_display_type;
        public ButtonDisplayType meeting_minutes_btn_display_type;
        public ShareButtonDisplayType share_btn_display_type;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventDisplayInfo build() {
            return new CalendarEventDisplayInfo(this.is_editable_btn_show, this.is_sharable_btn_show, this.is_deletable_btn_show, this.is_transfer_btn_show, this.is_meeting_chat_btn_show, this.is_video_meeting_btn_show, this.is_meeting_minutes_btn_show, this.is_report_btn_show, this.is_event_creator_show, this.is_event_organizer_show, this.edit_btn_display_type, this.delete_btn_display_type, this.meeting_chat_btn_display_type, this.meeting_minutes_btn_display_type, this.is_copy_btn_show, this.is_individual_attendee_syncing, this.is_event_note_show, this.share_btn_display_type, this.display_extra_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder delete_btn_display_type(ButtonDisplayType r100) {
            this.delete_btn_display_type = r100;
            return this;
        }

        public Builder display_extra_data(CalendarEventDisplayExtraData r100) {
            this.display_extra_data = r100;
            return this;
        }

        public Builder edit_btn_display_type(ButtonDisplayType r100) {
            this.edit_btn_display_type = r100;
            return this;
        }

        public Builder is_copy_btn_show(Boolean r100) {
            this.is_copy_btn_show = r100;
            return this;
        }

        public Builder is_deletable_btn_show(Boolean r100) {
            this.is_deletable_btn_show = r100;
            return this;
        }

        public Builder is_editable_btn_show(Boolean r100) {
            this.is_editable_btn_show = r100;
            return this;
        }

        public Builder is_event_creator_show(Boolean r100) {
            this.is_event_creator_show = r100;
            return this;
        }

        public Builder is_event_note_show(Boolean r100) {
            this.is_event_note_show = r100;
            return this;
        }

        public Builder is_event_organizer_show(Boolean r100) {
            this.is_event_organizer_show = r100;
            return this;
        }

        public Builder is_individual_attendee_syncing(Boolean r100) {
            this.is_individual_attendee_syncing = r100;
            return this;
        }

        public Builder is_meeting_chat_btn_show(Boolean r100) {
            this.is_meeting_chat_btn_show = r100;
            return this;
        }

        public Builder is_meeting_minutes_btn_show(Boolean r100) {
            this.is_meeting_minutes_btn_show = r100;
            return this;
        }

        public Builder is_report_btn_show(Boolean r100) {
            this.is_report_btn_show = r100;
            return this;
        }

        public Builder is_sharable_btn_show(Boolean r100) {
            this.is_sharable_btn_show = r100;
            return this;
        }

        public Builder is_transfer_btn_show(Boolean r100) {
            this.is_transfer_btn_show = r100;
            return this;
        }

        public Builder is_video_meeting_btn_show(Boolean r100) {
            this.is_video_meeting_btn_show = r100;
            return this;
        }

        public Builder meeting_chat_btn_display_type(ButtonDisplayType r100) {
            this.meeting_chat_btn_display_type = r100;
            return this;
        }

        public Builder meeting_minutes_btn_display_type(ButtonDisplayType r100) {
            this.meeting_minutes_btn_display_type = r100;
            return this;
        }

        public Builder share_btn_display_type(ShareButtonDisplayType r100) {
            this.share_btn_display_type = r100;
            return this;
        }
    }

    public static final enum ButtonDisplayType extends Enum<ButtonDisplayType> implements WireEnum {
        private static final /* synthetic */ ButtonDisplayType[] $VALUES = null;
        public static final ProtoAdapter<ButtonDisplayType> ADAPTER = null;
        public static final ButtonDisplayType HIDDEN = null;
        public static final ButtonDisplayType SHOWN = null;
        public static final ButtonDisplayType SHOWN_ATTENDEE_LIST_INVISIBLE = null;
        public static final ButtonDisplayType SHOWN_CHAT_OPEN_ENTRY_AUTH = null;
        public static final ButtonDisplayType SHOWN_EXTERNAL_ACCOUNT_EXPIRED = null;
        public static final ButtonDisplayType SHOWN_NOT_ALLOW_CREATE_CHAT = null;
        public static final ButtonDisplayType SHOWN_NOT_IN_BIND_CHAT = null;
        public static final ButtonDisplayType UNKNOWN_TYPE = null;
        private final int value;

        static {
            ButtonDisplayType r100 = new ButtonDisplayType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            ButtonDisplayType r101 = new ButtonDisplayType("HIDDEN", 1, 1);
            HIDDEN = r101;
            ButtonDisplayType r102 = new ButtonDisplayType("SHOWN", 2, 2);
            SHOWN = r102;
            ButtonDisplayType r103 = new ButtonDisplayType("SHOWN_EXTERNAL_ACCOUNT_EXPIRED", 3, 3);
            SHOWN_EXTERNAL_ACCOUNT_EXPIRED = r103;
            ButtonDisplayType r104 = new ButtonDisplayType("SHOWN_ATTENDEE_LIST_INVISIBLE", 4, 4);
            SHOWN_ATTENDEE_LIST_INVISIBLE = r104;
            ButtonDisplayType r105 = new ButtonDisplayType("SHOWN_CHAT_OPEN_ENTRY_AUTH", 5, 5);
            SHOWN_CHAT_OPEN_ENTRY_AUTH = r105;
            ButtonDisplayType r110 = new ButtonDisplayType("SHOWN_NOT_ALLOW_CREATE_CHAT", 6, 6);
            SHOWN_NOT_ALLOW_CREATE_CHAT = r110;
            ButtonDisplayType r111 = new ButtonDisplayType("SHOWN_NOT_IN_BIND_CHAT", 7, 7);
            SHOWN_NOT_IN_BIND_CHAT = r111;
            $VALUES = new ButtonDisplayType[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(ButtonDisplayType.class);
        }

        public static ButtonDisplayType[] values() {
            return (ButtonDisplayType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ButtonDisplayType fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SHOWN_NOT_IN_BIND_CHAT;
        L8:
            return SHOWN_NOT_ALLOW_CREATE_CHAT;
        L10:
            return SHOWN_CHAT_OPEN_ENTRY_AUTH;
        L12:
            return SHOWN_ATTENDEE_LIST_INVISIBLE;
        L14:
            return SHOWN_EXTERNAL_ACCOUNT_EXPIRED;
        L16:
            return SHOWN;
        L18:
            return HIDDEN;
        L20:
            return UNKNOWN_TYPE;
        }

        public static ButtonDisplayType valueOf(String r100) {
            return (ButtonDisplayType) a.a(ButtonDisplayType.class, r100);
        }

        private ButtonDisplayType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class CalendarEventDisplayExtraData extends Message<CalendarEventDisplayExtraData, Builder> {
        public static final ProtoAdapter<CalendarEventDisplayExtraData> ADAPTER = null;
        public static final Boolean DEFAULT_HAS_EVENT_CREATOR_RESIGNED = null;
        private static final long serialVersionUID = 0;
        public final Boolean has_event_creator_resigned;

        public static final class Builder extends Message.Builder<CalendarEventDisplayExtraData, Builder> {
            public Boolean has_event_creator_resigned;

            @Override // com.squareup.wire.Message.Builder
            public CalendarEventDisplayExtraData build() {
                return new CalendarEventDisplayExtraData(this.has_event_creator_resigned, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder has_event_creator_resigned(Boolean r100) {
                this.has_event_creator_resigned = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CalendarEventDisplayExtraData extends ProtoAdapter<CalendarEventDisplayExtraData> {
            public ProtoAdapter_CalendarEventDisplayExtraData() {
                super(FieldEncoding.LENGTH_DELIMITED, CalendarEventDisplayExtraData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CalendarEventDisplayExtraData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.has_event_creator_resigned = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.has_event_creator_resigned = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(CalendarEventDisplayExtraData r100) {
                Boolean r101 = r100.has_event_creator_resigned;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CalendarEventDisplayExtraData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CalendarEventDisplayExtraData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CalendarEventDisplayExtraData r101) throws IOException {
                Boolean r102 = r101.has_event_creator_resigned;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventDisplayExtraData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CalendarEventDisplayExtraData();
            DEFAULT_HAS_EVENT_CREATOR_RESIGNED = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.has_event_creator_resigned = this.has_event_creator_resigned;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CalendarEventDisplayExtraData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CalendarEventDisplayExtraData(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public CalendarEventDisplayExtraData(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.has_event_creator_resigned = r100;
        }
    }

    public static final class ProtoAdapter_CalendarEventDisplayInfo extends ProtoAdapter<CalendarEventDisplayInfo> {
        public ProtoAdapter_CalendarEventDisplayInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventDisplayInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventDisplayInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_editable_btn_show = r102;
            r101.is_sharable_btn_show = r102;
            r101.is_deletable_btn_show = r102;
            r101.is_transfer_btn_show = r102;
            r101.is_meeting_chat_btn_show = r102;
            r101.is_video_meeting_btn_show = r102;
            r101.is_meeting_minutes_btn_show = r102;
            r101.is_report_btn_show = r102;
            Boolean r103 = Boolean.TRUE;
            r101.is_event_creator_show = r103;
            r101.is_event_organizer_show = r103;
            ButtonDisplayType r104 = ButtonDisplayType.UNKNOWN_TYPE;
            r101.edit_btn_display_type = r104;
            r101.delete_btn_display_type = r104;
            r101.meeting_chat_btn_display_type = r104;
            r101.meeting_minutes_btn_display_type = r104;
            r101.is_copy_btn_show = r102;
            r101.is_individual_attendee_syncing = r102;
            r101.is_event_note_show = r103;
            r101.share_btn_display_type = ShareButtonDisplayType.HIDDEN;
            long r105 = r100.beginMessage();
        L3:
            int r106 = r100.nextTag();
            if (r106 == (-1)) goto L43;
            if (r106 != 100) goto L7;
            r101.display_extra_data = CalendarEventDisplayExtraData.ADAPTER.decode(r100);
            goto L3
        L7:
            switch(r106) {
                case 1: goto L41;
                case 2: goto L40;
                case 3: goto L39;
                case 4: goto L38;
                case 5: goto L37;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L32;
                case 11: goto L51;
                case 12: goto L47;
                case 13: goto L49;
                case 14: goto L53;
                case 15: goto L15;
                case 16: goto L14;
                case 17: goto L13;
                case 18: goto L45;
                default: goto L8;
            };
        L45:
            r101.share_btn_display_type = ShareButtonDisplayType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L47:
            r101.delete_btn_display_type = ButtonDisplayType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L49:
            r101.meeting_chat_btn_display_type = ButtonDisplayType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L51:
            r101.edit_btn_display_type = ButtonDisplayType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
        L30:
            e = move-exception;
            r101.addUnknownField(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L53:
            r101.meeting_minutes_btn_display_type = ButtonDisplayType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.is_event_note_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.is_individual_attendee_syncing = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.is_copy_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L32:
            r101.is_event_organizer_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L33:
            r101.is_event_creator_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L34:
            r101.is_report_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.is_meeting_minutes_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L36:
            r101.is_video_meeting_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L37:
            r101.is_meeting_chat_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L38:
            r101.is_transfer_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L39:
            r101.is_deletable_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L40:
            r101.is_sharable_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L41:
            r101.is_editable_btn_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            FieldEncoding r107 = r100.peekFieldEncoding();
            r101.addUnknownField(r106, r107, r107.rawProtoAdapter().decode(r100));
            goto L3
        L43:
            r100.endMessage(r105);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEventDisplayInfo r100) {
            Boolean r101 = r100.is_editable_btn_show;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_sharable_btn_show;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_deletable_btn_show;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_transfer_btn_show;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_meeting_chat_btn_show;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_video_meeting_btn_show;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_meeting_minutes_btn_show;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_report_btn_show;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_event_creator_show;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.is_event_organizer_show;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            ButtonDisplayType r131 = r100.edit_btn_display_type;
            if (r131 == null) goto L45;
            int r132 = ButtonDisplayType.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            ButtonDisplayType r134 = r100.delete_btn_display_type;
            if (r134 == null) goto L49;
            int r135 = ButtonDisplayType.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            ButtonDisplayType r137 = r100.meeting_chat_btn_display_type;
            if (r137 == null) goto L53;
            int r138 = ButtonDisplayType.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            ButtonDisplayType r140 = r100.meeting_minutes_btn_display_type;
            if (r140 == null) goto L57;
            int r141 = ButtonDisplayType.ADAPTER.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            Boolean r143 = r100.is_copy_btn_show;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            Boolean r146 = r100.is_individual_attendee_syncing;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            Boolean r149 = r100.is_event_note_show;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            ShareButtonDisplayType r152 = r100.share_btn_display_type;
            if (r152 == null) goto L73;
            int r153 = ShareButtonDisplayType.ADAPTER.encodedSizeWithTag(18, r152);
        L74:
            int r154 = r151 + r153;
            CalendarEventDisplayExtraData r155 = r100.display_extra_data;
            if (r155 == null) goto L78;
            r102 = CalendarEventDisplayExtraData.ADAPTER.encodedSizeWithTag(100, r155);
        L78:
            return (r154 + r102) + r100.unknownFields().size();
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
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
        public /* bridge */ /* synthetic */ CalendarEventDisplayInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventDisplayInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventDisplayInfo r101) throws IOException {
            Boolean r102 = r101.is_editable_btn_show;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_sharable_btn_show;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_deletable_btn_show;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_transfer_btn_show;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_meeting_chat_btn_show;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.is_video_meeting_btn_show;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_meeting_minutes_btn_show;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_report_btn_show;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.is_event_creator_show;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.is_event_organizer_show;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            ButtonDisplayType r112 = r101.edit_btn_display_type;
            if (r112 == null) goto L35;
            ButtonDisplayType.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            ButtonDisplayType r113 = r101.delete_btn_display_type;
            if (r113 == null) goto L38;
            ButtonDisplayType.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            ButtonDisplayType r114 = r101.meeting_chat_btn_display_type;
            if (r114 == null) goto L41;
            ButtonDisplayType.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            ButtonDisplayType r115 = r101.meeting_minutes_btn_display_type;
            if (r115 == null) goto L44;
            ButtonDisplayType.ADAPTER.encodeWithTag(r100, 14, r115);
        L44:
            Boolean r116 = r101.is_copy_btn_show;
            if (r116 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r116);
        L47:
            Boolean r117 = r101.is_individual_attendee_syncing;
            if (r117 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r117);
        L50:
            Boolean r118 = r101.is_event_note_show;
            if (r118 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r118);
        L53:
            ShareButtonDisplayType r119 = r101.share_btn_display_type;
            if (r119 == null) goto L56;
            ShareButtonDisplayType.ADAPTER.encodeWithTag(r100, 18, r119);
        L56:
            CalendarEventDisplayExtraData r120 = r101.display_extra_data;
            if (r120 == null) goto L59;
            CalendarEventDisplayExtraData.ADAPTER.encodeWithTag(r100, 100, r120);
        L59:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventDisplayInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventDisplayInfo();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_EDITABLE_BTN_SHOW = r100;
        DEFAULT_IS_SHARABLE_BTN_SHOW = r100;
        DEFAULT_IS_DELETABLE_BTN_SHOW = r100;
        DEFAULT_IS_TRANSFER_BTN_SHOW = r100;
        DEFAULT_IS_MEETING_CHAT_BTN_SHOW = r100;
        DEFAULT_IS_VIDEO_MEETING_BTN_SHOW = r100;
        DEFAULT_IS_MEETING_MINUTES_BTN_SHOW = r100;
        DEFAULT_IS_REPORT_BTN_SHOW = r100;
        Boolean r101 = Boolean.TRUE;
        DEFAULT_IS_EVENT_CREATOR_SHOW = r101;
        DEFAULT_IS_EVENT_ORGANIZER_SHOW = r101;
        ButtonDisplayType r102 = ButtonDisplayType.UNKNOWN_TYPE;
        DEFAULT_EDIT_BTN_DISPLAY_TYPE = r102;
        DEFAULT_DELETE_BTN_DISPLAY_TYPE = r102;
        DEFAULT_MEETING_CHAT_BTN_DISPLAY_TYPE = r102;
        DEFAULT_MEETING_MINUTES_BTN_DISPLAY_TYPE = r102;
        DEFAULT_IS_COPY_BTN_SHOW = r100;
        DEFAULT_IS_INDIVIDUAL_ATTENDEE_SYNCING = r100;
        DEFAULT_IS_EVENT_NOTE_SHOW = r101;
        DEFAULT_SHARE_BTN_DISPLAY_TYPE = ShareButtonDisplayType.HIDDEN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_editable_btn_show = this.is_editable_btn_show;
        r100.is_sharable_btn_show = this.is_sharable_btn_show;
        r100.is_deletable_btn_show = this.is_deletable_btn_show;
        r100.is_transfer_btn_show = this.is_transfer_btn_show;
        r100.is_meeting_chat_btn_show = this.is_meeting_chat_btn_show;
        r100.is_video_meeting_btn_show = this.is_video_meeting_btn_show;
        r100.is_meeting_minutes_btn_show = this.is_meeting_minutes_btn_show;
        r100.is_report_btn_show = this.is_report_btn_show;
        r100.is_event_creator_show = this.is_event_creator_show;
        r100.is_event_organizer_show = this.is_event_organizer_show;
        r100.edit_btn_display_type = this.edit_btn_display_type;
        r100.delete_btn_display_type = this.delete_btn_display_type;
        r100.meeting_chat_btn_display_type = this.meeting_chat_btn_display_type;
        r100.meeting_minutes_btn_display_type = this.meeting_minutes_btn_display_type;
        r100.is_copy_btn_show = this.is_copy_btn_show;
        r100.is_individual_attendee_syncing = this.is_individual_attendee_syncing;
        r100.is_event_note_show = this.is_event_note_show;
        r100.share_btn_display_type = this.share_btn_display_type;
        r100.display_extra_data = this.display_extra_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventDisplayInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventDisplayInfo(Boolean r210, Boolean r211, Boolean r212, Boolean r213, Boolean r214, Boolean r215, Boolean r216, Boolean r217, Boolean r310, Boolean r311, ButtonDisplayType r312, ButtonDisplayType r313, ButtonDisplayType r314, ButtonDisplayType r315, Boolean r316, Boolean r317, Boolean r318, ShareButtonDisplayType r319, CalendarEventDisplayExtraData r410) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, ByteString.EMPTY);
    }

    public CalendarEventDisplayInfo(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Boolean r110, Boolean r111, Boolean r112, Boolean r113, ButtonDisplayType r114, ButtonDisplayType r115, ButtonDisplayType r116, ButtonDisplayType r117, Boolean r118, Boolean r119, Boolean r210, ShareButtonDisplayType r211, CalendarEventDisplayExtraData r212, ByteString r213) {
        super(ADAPTER, r213);
        this.is_editable_btn_show = r100;
        this.is_sharable_btn_show = r101;
        this.is_deletable_btn_show = r102;
        this.is_transfer_btn_show = r103;
        this.is_meeting_chat_btn_show = r104;
        this.is_video_meeting_btn_show = r105;
        this.is_meeting_minutes_btn_show = r110;
        this.is_report_btn_show = r111;
        this.is_event_creator_show = r112;
        this.is_event_organizer_show = r113;
        this.edit_btn_display_type = r114;
        this.delete_btn_display_type = r115;
        this.meeting_chat_btn_display_type = r116;
        this.meeting_minutes_btn_display_type = r117;
        this.is_copy_btn_show = r118;
        this.is_individual_attendee_syncing = r119;
        this.is_event_note_show = r210;
        this.share_btn_display_type = r211;
        this.display_extra_data = r212;
    }
}
