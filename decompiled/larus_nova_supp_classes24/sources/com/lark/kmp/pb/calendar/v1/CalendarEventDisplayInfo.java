package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00041234B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u000200H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR \u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\nR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0011\u0010\nR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0013\u0010\nR \u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0014\u0010\nR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0016\u0010\nR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0017\u0010\nR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0018\u0010\nR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010!\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0015\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b#\u0010\nR\u0015\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b$\u0010\nR\u0015\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b%\u0010\nR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00065"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$Builder;Lokio/ByteString;)V", "is_editable_btn_show", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_sharable_btn_show", "is_sharable_btn_show$annotations", "()V", "is_deletable_btn_show", "is_transfer_btn_show", "is_meeting_chat_btn_show", "is_meeting_chat_btn_show$annotations", "is_video_meeting_btn_show", "is_meeting_minutes_btn_show", "is_meeting_minutes_btn_show$annotations", "is_report_btn_show", "is_event_creator_show", "is_event_organizer_show", "edit_btn_display_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$ButtonDisplayType;", "getEdit_btn_display_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$ButtonDisplayType;", "delete_btn_display_type", "getDelete_btn_display_type", "meeting_chat_btn_display_type", "getMeeting_chat_btn_display_type", "meeting_minutes_btn_display_type", "getMeeting_minutes_btn_display_type", "is_copy_btn_show", "is_individual_attendee_syncing", "is_event_note_show", "share_btn_display_type", "Lcom/lark/kmp/pb/calendar/v1/ShareButtonDisplayType;", "getShare_btn_display_type", "()Lcom/lark/kmp/pb/calendar/v1/ShareButtonDisplayType;", "display_extra_data", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$CalendarEventDisplayExtraData;", "getDisplay_extra_data", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$CalendarEventDisplayExtraData;", "newBuilder", "toString", "", "Builder", "Companion", "CalendarEventDisplayExtraData", "ButtonDisplayType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventDisplayInfo extends Message<CalendarEventDisplayInfo, a> {
    public static final ProtoAdapter<CalendarEventDisplayInfo> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_IS_COPY_BTN_SHOW = false;
    public static final boolean DEFAULT_IS_DELETABLE_BTN_SHOW = false;
    public static final boolean DEFAULT_IS_EDITABLE_BTN_SHOW = false;
    public static final boolean DEFAULT_IS_EVENT_CREATOR_SHOW = true;
    public static final boolean DEFAULT_IS_EVENT_NOTE_SHOW = true;
    public static final boolean DEFAULT_IS_EVENT_ORGANIZER_SHOW = true;
    public static final boolean DEFAULT_IS_INDIVIDUAL_ATTENDEE_SYNCING = false;
    public static final boolean DEFAULT_IS_REPORT_BTN_SHOW = false;
    public static final boolean DEFAULT_IS_TRANSFER_BTN_SHOW = false;
    public static final boolean DEFAULT_IS_VIDEO_MEETING_BTN_SHOW = false;
    public static final ShareButtonDisplayType DEFAULT_SHARE_BTN_DISPLAY_TYPE = null;
    private static final long serialVersionUID = 0;
    private final ButtonDisplayType delete_btn_display_type;
    private final CalendarEventDisplayExtraData display_extra_data;
    private final ButtonDisplayType edit_btn_display_type;
    private final Boolean is_copy_btn_show;
    private final Boolean is_deletable_btn_show;
    private final Boolean is_editable_btn_show;
    private final Boolean is_event_creator_show;
    private final Boolean is_event_note_show;
    private final Boolean is_event_organizer_show;
    private final Boolean is_individual_attendee_syncing;
    private final Boolean is_meeting_chat_btn_show;
    private final Boolean is_meeting_minutes_btn_show;
    private final Boolean is_report_btn_show;
    private final Boolean is_sharable_btn_show;
    private final Boolean is_transfer_btn_show;
    private final Boolean is_video_meeting_btn_show;
    private final ButtonDisplayType meeting_chat_btn_display_type;
    private final ButtonDisplayType meeting_minutes_btn_display_type;
    private final ShareButtonDisplayType share_btn_display_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$ButtonDisplayType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "HIDDEN", "SHOWN", "SHOWN_EXTERNAL_ACCOUNT_EXPIRED", "SHOWN_ATTENDEE_LIST_INVISIBLE", "SHOWN_CHAT_OPEN_ENTRY_AUTH", "SHOWN_NOT_ALLOW_CREATE_CHAT", "SHOWN_NOT_IN_BIND_CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ButtonDisplayType extends Enum<ButtonDisplayType> implements o0 {
        public static final ProtoAdapter<ButtonDisplayType> ADAPTER = null;
        public static final b Companion = null;
        public static final ButtonDisplayType HIDDEN = null;
        public static final ButtonDisplayType SHOWN = null;
        public static final ButtonDisplayType SHOWN_ATTENDEE_LIST_INVISIBLE = null;
        public static final ButtonDisplayType SHOWN_CHAT_OPEN_ENTRY_AUTH = null;
        public static final ButtonDisplayType SHOWN_EXTERNAL_ACCOUNT_EXPIRED = null;
        public static final ButtonDisplayType SHOWN_NOT_ALLOW_CREATE_CHAT = null;
        public static final ButtonDisplayType SHOWN_NOT_IN_BIND_CHAT = null;
        public static final ButtonDisplayType UNKNOWN_TYPE = null;
        public static final /* synthetic */ ButtonDisplayType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ButtonDisplayType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ButtonDisplayType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<ButtonDisplayType> r1, Syntax r2, ButtonDisplayType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static ButtonDisplayType a(int r0) {
                switch(r0) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L3;
                };
            L3:
                return null;
            L14:
                return ButtonDisplayType.SHOWN_NOT_IN_BIND_CHAT;
            L15:
                return ButtonDisplayType.SHOWN_NOT_ALLOW_CREATE_CHAT;
            L16:
                return ButtonDisplayType.SHOWN_CHAT_OPEN_ENTRY_AUTH;
            L17:
                return ButtonDisplayType.SHOWN_ATTENDEE_LIST_INVISIBLE;
            L18:
                return ButtonDisplayType.SHOWN_EXTERNAL_ACCOUNT_EXPIRED;
            L19:
                return ButtonDisplayType.SHOWN;
            L20:
                return ButtonDisplayType.HIDDEN;
            L12:
                return ButtonDisplayType.UNKNOWN_TYPE;
            }
        }

        @JvmStatic
        public static final ButtonDisplayType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<ButtonDisplayType> getEntries() {
            return b;
        }

        static {
            ButtonDisplayType r0 = new ButtonDisplayType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            ButtonDisplayType r1 = new ButtonDisplayType("HIDDEN", 1, 1);
            HIDDEN = r1;
            ButtonDisplayType r3 = new ButtonDisplayType("SHOWN", 2, 2);
            SHOWN = r3;
            ButtonDisplayType r5 = new ButtonDisplayType("SHOWN_EXTERNAL_ACCOUNT_EXPIRED", 3, 3);
            SHOWN_EXTERNAL_ACCOUNT_EXPIRED = r5;
            ButtonDisplayType r7 = new ButtonDisplayType("SHOWN_ATTENDEE_LIST_INVISIBLE", 4, 4);
            SHOWN_ATTENDEE_LIST_INVISIBLE = r7;
            ButtonDisplayType r9 = new ButtonDisplayType("SHOWN_CHAT_OPEN_ENTRY_AUTH", 5, 5);
            SHOWN_CHAT_OPEN_ENTRY_AUTH = r9;
            ButtonDisplayType r11 = new ButtonDisplayType("SHOWN_NOT_ALLOW_CREATE_CHAT", 6, 6);
            SHOWN_NOT_ALLOW_CREATE_CHAT = r11;
            ButtonDisplayType r13 = new ButtonDisplayType("SHOWN_NOT_IN_BIND_CHAT", 7, 7);
            SHOWN_NOT_IN_BIND_CHAT = r13;
            ButtonDisplayType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ButtonDisplayType.class), Syntax.PROTO_2, r0);
        }

        public static ButtonDisplayType[] values() {
            return (ButtonDisplayType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static ButtonDisplayType valueOf(String r1) {
            return (ButtonDisplayType) r27.a.a(ButtonDisplayType.class, r1);
        }

        public ButtonDisplayType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$CalendarEventDisplayExtraData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$CalendarEventDisplayExtraData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventDisplayInfo$CalendarEventDisplayExtraData$Builder;Lokio/ByteString;)V", "has_event_creator_resigned", "", "getHas_event_creator_resigned", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CalendarEventDisplayExtraData extends Message<CalendarEventDisplayExtraData, a> {
        public static final ProtoAdapter<CalendarEventDisplayExtraData> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_HAS_EVENT_CREATOR_RESIGNED = false;
        private static final long serialVersionUID = 0;
        private final Boolean has_event_creator_resigned;

        public static final class a extends Message.a<CalendarEventDisplayExtraData, a> {
            public Boolean d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CalendarEventDisplayExtraData(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CalendarEventDisplayExtraData> {
            @Override // com.lark.wire.ProtoAdapter
            public final CalendarEventDisplayExtraData c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                return new CalendarEventDisplayExtraData(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CalendarEventDisplayExtraData r4) {
                CalendarEventDisplayExtraData r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.g.l(1, r5.getHas_event_creator_resigned());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CalendarEventDisplayExtraData r5) {
                CalendarEventDisplayExtraData r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.getHas_event_creator_resigned());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, CalendarEventDisplayExtraData r4) {
                CalendarEventDisplayExtraData r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.g.j(r3, 1, r5.getHas_event_creator_resigned());
            }

            public b(FieldEncoding r7, KClass<CalendarEventDisplayExtraData> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventDisplayInfo.CalendarEventDisplayExtraData", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CalendarEventDisplayExtraData(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventDisplayExtraData.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.has_event_creator_resigned;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CalendarEventDisplayExtraData.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getHas_event_creator_resigned() {
            return this.has_event_creator_resigned;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CalendarEventDisplayExtraData(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.has_event_creator_resigned = r2.d;
        }

        public /* synthetic */ CalendarEventDisplayExtraData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<CalendarEventDisplayInfo, a> {
        public Boolean d;
        public Boolean e;
        public Boolean f;
        public Boolean g;
        public Boolean h;
        public Boolean i;
        public Boolean j;
        public Boolean k;
        public Boolean l;
        public Boolean m;
        public ButtonDisplayType n;
        public ButtonDisplayType o;
        public ButtonDisplayType p;
        public ButtonDisplayType q;
        public Boolean r;
        public Boolean s;
        public Boolean t;
        public ShareButtonDisplayType u;
        public CalendarEventDisplayExtraData v;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventDisplayInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventDisplayInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventDisplayInfo c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L44;
            if (r3 != 100) goto L7;
            r0.v = CalendarEventDisplayExtraData.ADAPTER.c(r9);
            goto L3
        L7:
            switch(r3) {
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
                case 12: goto L53;
                case 13: goto L45;
                case 14: goto L47;
                case 15: goto L15;
                case 16: goto L14;
                case 17: goto L13;
                case 18: goto L49;
                default: goto L8;
            };
        L45:
            r0.p = ButtonDisplayType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L47:
            r0.q = ButtonDisplayType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L49:
            r0.u = ShareButtonDisplayType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L51:
            r0.n = ButtonDisplayType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
        L30:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L53:
            r0.o = ButtonDisplayType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L13:
            r0.t = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L14:
            r0.s = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L15:
            r0.r = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L32:
            r0.m = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L33:
            r0.l = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L34:
            r0.k = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L35:
            r0.j = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L36:
            r0.i = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L37:
            r0.h = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L38:
            r0.g = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L39:
            r0.f = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L40:
            r0.e = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L41:
            r0.d = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L8:
            r9.j(r3);
            Unit r10 = Unit.INSTANCE;
            goto L3
        L44:
            return new CalendarEventDisplayInfo(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventDisplayInfo r6) {
            CalendarEventDisplayInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            l r1 = ProtoAdapter.g;
            int r2 = (((((((((r0 + r1.l(1, r7.is_editable_btn_show())) + r1.l(2, r7.is_sharable_btn_show())) + r1.l(3, r7.is_deletable_btn_show())) + r1.l(4, r7.is_transfer_btn_show())) + r1.l(5, r7.is_meeting_chat_btn_show())) + r1.l(6, r7.is_video_meeting_btn_show())) + r1.l(7, r7.is_meeting_minutes_btn_show())) + r1.l(8, r7.is_report_btn_show())) + r1.l(9, r7.is_event_creator_show())) + r1.l(10, r7.is_event_organizer_show());
            ProtoAdapter<ButtonDisplayType> r3 = ButtonDisplayType.ADAPTER;
            return ((((((((r2 + r3.l(11, r7.getEdit_btn_display_type())) + r3.l(12, r7.getDelete_btn_display_type())) + r3.l(13, r7.getMeeting_chat_btn_display_type())) + r3.l(14, r7.getMeeting_minutes_btn_display_type())) + r1.l(15, r7.is_copy_btn_show())) + r1.l(16, r7.is_individual_attendee_syncing())) + r1.l(17, r7.is_event_note_show())) + ShareButtonDisplayType.ADAPTER.l(18, r7.getShare_btn_display_type())) + CalendarEventDisplayExtraData.ADAPTER.l(100, r7.getDisplay_extra_data());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, CalendarEventDisplayInfo r6) {
            CalendarEventDisplayInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            l r0 = ProtoAdapter.g;
            r0.i(r5, 1, r7.is_editable_btn_show());
            r0.i(r5, 2, r7.is_sharable_btn_show());
            r0.i(r5, 3, r7.is_deletable_btn_show());
            r0.i(r5, 4, r7.is_transfer_btn_show());
            r0.i(r5, 5, r7.is_meeting_chat_btn_show());
            r0.i(r5, 6, r7.is_video_meeting_btn_show());
            r0.i(r5, 7, r7.is_meeting_minutes_btn_show());
            r0.i(r5, 8, r7.is_report_btn_show());
            r0.i(r5, 9, r7.is_event_creator_show());
            r0.i(r5, 10, r7.is_event_organizer_show());
            ProtoAdapter<ButtonDisplayType> r1 = ButtonDisplayType.ADAPTER;
            r1.i(r5, 11, r7.getEdit_btn_display_type());
            r1.i(r5, 12, r7.getDelete_btn_display_type());
            r1.i(r5, 13, r7.getMeeting_chat_btn_display_type());
            r1.i(r5, 14, r7.getMeeting_minutes_btn_display_type());
            r0.i(r5, 15, r7.is_copy_btn_show());
            r0.i(r5, 16, r7.is_individual_attendee_syncing());
            r0.i(r5, 17, r7.is_event_note_show());
            ShareButtonDisplayType.ADAPTER.i(r5, 18, r7.getShare_btn_display_type());
            CalendarEventDisplayExtraData.ADAPTER.i(r5, 100, r7.getDisplay_extra_data());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, CalendarEventDisplayInfo r6) {
            CalendarEventDisplayInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            CalendarEventDisplayExtraData.ADAPTER.j(r5, 100, r7.getDisplay_extra_data());
            ShareButtonDisplayType.ADAPTER.j(r5, 18, r7.getShare_btn_display_type());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 17, r7.is_event_note_show());
            r0.j(r5, 16, r7.is_individual_attendee_syncing());
            r0.j(r5, 15, r7.is_copy_btn_show());
            ProtoAdapter<ButtonDisplayType> r1 = ButtonDisplayType.ADAPTER;
            r1.j(r5, 14, r7.getMeeting_minutes_btn_display_type());
            r1.j(r5, 13, r7.getMeeting_chat_btn_display_type());
            r1.j(r5, 12, r7.getDelete_btn_display_type());
            r1.j(r5, 11, r7.getEdit_btn_display_type());
            r0.j(r5, 10, r7.is_event_organizer_show());
            r0.j(r5, 9, r7.is_event_creator_show());
            r0.j(r5, 8, r7.is_report_btn_show());
            r0.j(r5, 7, r7.is_meeting_minutes_btn_show());
            r0.j(r5, 6, r7.is_video_meeting_btn_show());
            r0.j(r5, 5, r7.is_meeting_chat_btn_show());
            r0.j(r5, 4, r7.is_transfer_btn_show());
            r0.j(r5, 3, r7.is_deletable_btn_show());
            r0.j(r5, 2, r7.is_sharable_btn_show());
            r0.j(r5, 1, r7.is_editable_btn_show());
        }

        public b(FieldEncoding r7, KClass<CalendarEventDisplayInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventDisplayInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventDisplayInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "is_meeting_chat_btn_show is deprecated")
    public static /* synthetic */ void is_meeting_chat_btn_show$annotations() {
    }

    @Deprecated(message = "is_meeting_minutes_btn_show is deprecated")
    public static /* synthetic */ void is_meeting_minutes_btn_show$annotations() {
    }

    @Deprecated(message = "is_sharable_btn_show is deprecated")
    public static /* synthetic */ void is_sharable_btn_show$annotations() {
    }

    static {
        Companion = new c();
        DEFAULT_SHARE_BTN_DISPLAY_TYPE = ShareButtonDisplayType.HIDDEN;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventDisplayInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.is_editable_btn_show;
        r0.e = this.is_sharable_btn_show;
        r0.f = this.is_deletable_btn_show;
        r0.g = this.is_transfer_btn_show;
        r0.h = this.is_meeting_chat_btn_show;
        r0.i = this.is_video_meeting_btn_show;
        r0.j = this.is_meeting_minutes_btn_show;
        r0.k = this.is_report_btn_show;
        r0.l = this.is_event_creator_show;
        r0.m = this.is_event_organizer_show;
        r0.n = this.edit_btn_display_type;
        r0.o = this.delete_btn_display_type;
        r0.p = this.meeting_chat_btn_display_type;
        r0.q = this.meeting_minutes_btn_display_type;
        r0.r = this.is_copy_btn_show;
        r0.s = this.is_individual_attendee_syncing;
        r0.t = this.is_event_note_show;
        r0.u = this.share_btn_display_type;
        r0.v = this.display_extra_data;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventDisplayInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final ButtonDisplayType getDelete_btn_display_type() {
        return this.delete_btn_display_type;
    }

    public final CalendarEventDisplayExtraData getDisplay_extra_data() {
        return this.display_extra_data;
    }

    public final ButtonDisplayType getEdit_btn_display_type() {
        return this.edit_btn_display_type;
    }

    public final ButtonDisplayType getMeeting_chat_btn_display_type() {
        return this.meeting_chat_btn_display_type;
    }

    public final ButtonDisplayType getMeeting_minutes_btn_display_type() {
        return this.meeting_minutes_btn_display_type;
    }

    public final ShareButtonDisplayType getShare_btn_display_type() {
        return this.share_btn_display_type;
    }

    public final Boolean is_copy_btn_show() {
        return this.is_copy_btn_show;
    }

    public final Boolean is_deletable_btn_show() {
        return this.is_deletable_btn_show;
    }

    public final Boolean is_editable_btn_show() {
        return this.is_editable_btn_show;
    }

    public final Boolean is_event_creator_show() {
        return this.is_event_creator_show;
    }

    public final Boolean is_event_note_show() {
        return this.is_event_note_show;
    }

    public final Boolean is_event_organizer_show() {
        return this.is_event_organizer_show;
    }

    public final Boolean is_individual_attendee_syncing() {
        return this.is_individual_attendee_syncing;
    }

    public final Boolean is_meeting_chat_btn_show() {
        return this.is_meeting_chat_btn_show;
    }

    public final Boolean is_meeting_minutes_btn_show() {
        return this.is_meeting_minutes_btn_show;
    }

    public final Boolean is_report_btn_show() {
        return this.is_report_btn_show;
    }

    public final Boolean is_sharable_btn_show() {
        return this.is_sharable_btn_show;
    }

    public final Boolean is_transfer_btn_show() {
        return this.is_transfer_btn_show;
    }

    public final Boolean is_video_meeting_btn_show() {
        return this.is_video_meeting_btn_show;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventDisplayInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.is_editable_btn_show = r2.d;
        this.is_sharable_btn_show = r2.e;
        this.is_deletable_btn_show = r2.f;
        this.is_transfer_btn_show = r2.g;
        this.is_meeting_chat_btn_show = r2.h;
        this.is_video_meeting_btn_show = r2.i;
        this.is_meeting_minutes_btn_show = r2.j;
        this.is_report_btn_show = r2.k;
        this.is_event_creator_show = r2.l;
        this.is_event_organizer_show = r2.m;
        this.edit_btn_display_type = r2.n;
        this.delete_btn_display_type = r2.o;
        this.meeting_chat_btn_display_type = r2.p;
        this.meeting_minutes_btn_display_type = r2.q;
        this.is_copy_btn_show = r2.r;
        this.is_individual_attendee_syncing = r2.s;
        this.is_event_note_show = r2.t;
        this.share_btn_display_type = r2.u;
        this.display_extra_data = r2.v;
    }

    public /* synthetic */ CalendarEventDisplayInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
