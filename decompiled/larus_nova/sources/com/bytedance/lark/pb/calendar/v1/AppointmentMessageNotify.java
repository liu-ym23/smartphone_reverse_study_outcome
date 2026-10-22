package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AppointmentMessageNotify extends Message<AppointmentMessageNotify, Builder> {
    public static final ProtoAdapter<AppointmentMessageNotify> ADAPTER = null;
    public static final AppointmentAction DEFAULT_ACTION = null;
    public static final String DEFAULT_APPOINTMENT_ID = "";
    public static final AppointmentMessageCancelReason DEFAULT_CANCEL_REASON = null;
    public static final String DEFAULT_CREATOR_ID = "";
    public static final Long DEFAULT_END_TIME = null;
    public static final String DEFAULT_EVENT_LINK = "";
    public static final AppointmentMessageExpiredReason DEFAULT_EXPIRED_REASON = null;
    public static final String DEFAULT_GUEST_EMAIL = "";
    public static final String DEFAULT_GUEST_NAME = "";
    public static final String DEFAULT_HOST_ID = "";
    public static final String DEFAULT_HOST_NAME = "";
    public static final Boolean DEFAULT_IS_EXTERNAL = null;
    public static final Boolean DEFAULT_IS_FORWARD_MSG = null;
    public static final String DEFAULT_MESSAGE = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final String DEFAULT_OPERATOR_NAME = "";
    public static final Long DEFAULT_ORIGIN_MESSAGE_ID = null;
    public static final String DEFAULT_SCHEDULER_ID = "";
    public static final String DEFAULT_SCHEDULER_NAME = "";
    public static final Scheduler.Type DEFAULT_SCHEDULER_TYPE = null;
    public static final Long DEFAULT_START_TIME = null;
    public static final AppointmentMessageStatus DEFAULT_STATUS = null;
    public static final String DEFAULT_TIMEZONE = "";
    private static final long serialVersionUID = 0;
    public final AppointmentAction action;
    public final String appointment_id;
    public final AppointmentMessageCancelReason cancel_reason;
    public final String creator_id;
    public final Long end_time;
    public final String event_link;
    public final AppointmentMessageExpiredReason expired_reason;
    public final String guest_email;
    public final String guest_name;
    public final String host_id;
    public final String host_name;
    public final Boolean is_external;
    public final Boolean is_forward_msg;
    public final String message;
    public final String operator_id;
    public final String operator_name;
    public final Long origin_message_id;
    public final String scheduler_id;
    public final String scheduler_name;
    public final Scheduler.Type scheduler_type;
    public final Long start_time;
    public final AppointmentMessageStatus status;
    public final String timezone;

    public static final class Builder extends Message.Builder<AppointmentMessageNotify, Builder> {
        public AppointmentAction action;
        public String appointment_id;
        public AppointmentMessageCancelReason cancel_reason;
        public String creator_id;
        public Long end_time;
        public String event_link;
        public AppointmentMessageExpiredReason expired_reason;
        public String guest_email;
        public String guest_name;
        public String host_id;
        public String host_name;
        public Boolean is_external;
        public Boolean is_forward_msg;
        public String message;
        public String operator_id;
        public String operator_name;
        public Long origin_message_id;
        public String scheduler_id;
        public String scheduler_name;
        public Scheduler.Type scheduler_type;
        public Long start_time;
        public AppointmentMessageStatus status;
        public String timezone;

        @Override // com.squareup.wire.Message.Builder
        public AppointmentMessageNotify build() {
            return new AppointmentMessageNotify(this.status, this.action, this.operator_id, this.scheduler_id, this.scheduler_type, this.scheduler_name, this.appointment_id, this.creator_id, this.host_id, this.guest_name, this.guest_email, this.timezone, this.start_time, this.end_time, this.message, this.expired_reason, this.event_link, this.is_external, this.host_name, this.operator_name, this.is_forward_msg, this.origin_message_id, this.cancel_reason, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(AppointmentAction r100) {
            this.action = r100;
            return this;
        }

        public Builder appointment_id(String r100) {
            this.appointment_id = r100;
            return this;
        }

        public Builder cancel_reason(AppointmentMessageCancelReason r100) {
            this.cancel_reason = r100;
            return this;
        }

        public Builder creator_id(String r100) {
            this.creator_id = r100;
            return this;
        }

        public Builder end_time(Long r100) {
            this.end_time = r100;
            return this;
        }

        public Builder event_link(String r100) {
            this.event_link = r100;
            return this;
        }

        public Builder expired_reason(AppointmentMessageExpiredReason r100) {
            this.expired_reason = r100;
            return this;
        }

        public Builder guest_email(String r100) {
            this.guest_email = r100;
            return this;
        }

        public Builder guest_name(String r100) {
            this.guest_name = r100;
            return this;
        }

        public Builder host_id(String r100) {
            this.host_id = r100;
            return this;
        }

        public Builder host_name(String r100) {
            this.host_name = r100;
            return this;
        }

        public Builder is_external(Boolean r100) {
            this.is_external = r100;
            return this;
        }

        public Builder is_forward_msg(Boolean r100) {
            this.is_forward_msg = r100;
            return this;
        }

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }

        public Builder operator_id(String r100) {
            this.operator_id = r100;
            return this;
        }

        public Builder operator_name(String r100) {
            this.operator_name = r100;
            return this;
        }

        public Builder origin_message_id(Long r100) {
            this.origin_message_id = r100;
            return this;
        }

        public Builder scheduler_id(String r100) {
            this.scheduler_id = r100;
            return this;
        }

        public Builder scheduler_name(String r100) {
            this.scheduler_name = r100;
            return this;
        }

        public Builder scheduler_type(Scheduler.Type r100) {
            this.scheduler_type = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.start_time = r100;
            return this;
        }

        public Builder status(AppointmentMessageStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppointmentMessageNotify extends ProtoAdapter<AppointmentMessageNotify> {
        public ProtoAdapter_AppointmentMessageNotify() {
            super(FieldEncoding.LENGTH_DELIMITED, AppointmentMessageNotify.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppointmentMessageNotify decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = AppointmentMessageStatus.STATUS_UNKNOWN;
            r101.action = AppointmentAction.ACTION_UNKNOWN;
            r101.operator_id = "";
            r101.scheduler_id = "";
            r101.scheduler_type = Scheduler.Type.UNKNOWN_TYPE;
            r101.scheduler_name = "";
            r101.appointment_id = "";
            r101.creator_id = "";
            r101.host_id = "";
            r101.guest_name = "";
            r101.guest_email = "";
            r101.timezone = "";
            r101.start_time = 0L;
            r101.end_time = 0L;
            r101.message = "";
            r101.expired_reason = AppointmentMessageExpiredReason.EXPIRED_REASON_UNKNOWN;
            r101.event_link = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_external = r102;
            r101.host_name = "";
            r101.operator_name = "";
            r101.is_forward_msg = r102;
            r101.origin_message_id = 0L;
            r101.cancel_reason = AppointmentMessageCancelReason.CANCEL_REASON_UNKNOWN;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L45;
            switch(r104) {
                case 1: goto L49;
                case 2: goto L51;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L47;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L55;
                case 17: goto L16;
                case 18: goto L15;
                case 19: goto L14;
                case 20: goto L13;
                case 21: goto L12;
                case 22: goto L11;
                case 23: goto L53;
                default: goto L6;
            };
        L47:
            r101.scheduler_type = Scheduler.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L49:
            r101.status = AppointmentMessageStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L43
        L43:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L51:
            r101.action = AppointmentAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L39
        L39:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L53:
            r101.cancel_reason = AppointmentMessageCancelReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L55:
            r101.expired_reason = AppointmentMessageExpiredReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.origin_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.is_forward_msg = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.operator_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.host_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.is_external = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.event_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L24:
            r101.timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.guest_email = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.guest_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.host_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.creator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.appointment_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.scheduler_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.scheduler_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.operator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L45:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppointmentMessageNotify r100) {
            AppointmentMessageStatus r101 = r100.status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AppointmentMessageStatus.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            AppointmentAction r104 = r100.action;
            if (r104 == null) goto L9;
            int r105 = AppointmentAction.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.operator_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.scheduler_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Scheduler.Type r113 = r100.scheduler_type;
            if (r113 == null) goto L21;
            int r114 = Scheduler.Type.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.scheduler_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.appointment_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.creator_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.host_id;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.guest_name;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.guest_email;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.timezone;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.start_time;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Long r140 = r100.end_time;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.INT64.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.message;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            AppointmentMessageExpiredReason r146 = r100.expired_reason;
            if (r146 == null) goto L65;
            int r147 = AppointmentMessageExpiredReason.ADAPTER.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            String r149 = r100.event_link;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.STRING.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            Boolean r152 = r100.is_external;
            if (r152 == null) goto L73;
            int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r152);
        L74:
            int r154 = r151 + r153;
            String r155 = r100.host_name;
            if (r155 == null) goto L77;
            int r156 = ProtoAdapter.STRING.encodedSizeWithTag(19, r155);
        L78:
            int r157 = r154 + r156;
            String r158 = r100.operator_name;
            if (r158 == null) goto L81;
            int r159 = ProtoAdapter.STRING.encodedSizeWithTag(20, r158);
        L82:
            int r160 = r157 + r159;
            Boolean r161 = r100.is_forward_msg;
            if (r161 == null) goto L85;
            int r162 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r161);
        L86:
            int r163 = r160 + r162;
            Long r164 = r100.origin_message_id;
            if (r164 == null) goto L89;
            int r165 = ProtoAdapter.INT64.encodedSizeWithTag(22, r164);
        L90:
            int r166 = r163 + r165;
            AppointmentMessageCancelReason r167 = r100.cancel_reason;
            if (r167 == null) goto L94;
            r102 = AppointmentMessageCancelReason.ADAPTER.encodedSizeWithTag(23, r167);
        L94:
            return (r166 + r102) + r100.unknownFields().size();
        L89:
            r165 = 0;
            goto L90
        L85:
            r162 = 0;
            goto L86
        L81:
            r159 = 0;
            goto L82
        L77:
            r156 = 0;
            goto L78
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
        public /* bridge */ /* synthetic */ AppointmentMessageNotify decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppointmentMessageNotify r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppointmentMessageNotify r101) throws IOException {
            AppointmentMessageStatus r102 = r101.status;
            if (r102 == null) goto L5;
            AppointmentMessageStatus.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            AppointmentAction r103 = r101.action;
            if (r103 == null) goto L8;
            AppointmentAction.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.operator_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.scheduler_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Scheduler.Type r106 = r101.scheduler_type;
            if (r106 == null) goto L17;
            Scheduler.Type.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.scheduler_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.appointment_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.creator_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.host_id;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.guest_name;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.guest_email;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            String r113 = r101.timezone;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
        L38:
            Long r114 = r101.start_time;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r114);
        L41:
            Long r115 = r101.end_time;
            if (r115 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r115);
        L44:
            String r116 = r101.message;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r116);
        L47:
            AppointmentMessageExpiredReason r117 = r101.expired_reason;
            if (r117 == null) goto L50;
            AppointmentMessageExpiredReason.ADAPTER.encodeWithTag(r100, 16, r117);
        L50:
            String r118 = r101.event_link;
            if (r118 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r100, 17, r118);
        L53:
            Boolean r119 = r101.is_external;
            if (r119 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r119);
        L56:
            String r120 = r101.host_name;
            if (r120 == null) goto L59;
            ProtoAdapter.STRING.encodeWithTag(r100, 19, r120);
        L59:
            String r121 = r101.operator_name;
            if (r121 == null) goto L62;
            ProtoAdapter.STRING.encodeWithTag(r100, 20, r121);
        L62:
            Boolean r122 = r101.is_forward_msg;
            if (r122 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r122);
        L65:
            Long r123 = r101.origin_message_id;
            if (r123 == null) goto L68;
            ProtoAdapter.INT64.encodeWithTag(r100, 22, r123);
        L68:
            AppointmentMessageCancelReason r124 = r101.cancel_reason;
            if (r124 == null) goto L71;
            AppointmentMessageCancelReason.ADAPTER.encodeWithTag(r100, 23, r124);
        L71:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppointmentMessageNotify r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppointmentMessageNotify();
        DEFAULT_STATUS = AppointmentMessageStatus.STATUS_UNKNOWN;
        DEFAULT_ACTION = AppointmentAction.ACTION_UNKNOWN;
        DEFAULT_SCHEDULER_TYPE = Scheduler.Type.UNKNOWN_TYPE;
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
        DEFAULT_EXPIRED_REASON = AppointmentMessageExpiredReason.EXPIRED_REASON_UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_EXTERNAL = r100;
        DEFAULT_IS_FORWARD_MSG = r100;
        DEFAULT_ORIGIN_MESSAGE_ID = 0L;
        DEFAULT_CANCEL_REASON = AppointmentMessageCancelReason.CANCEL_REASON_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.action = this.action;
        r100.operator_id = this.operator_id;
        r100.scheduler_id = this.scheduler_id;
        r100.scheduler_type = this.scheduler_type;
        r100.scheduler_name = this.scheduler_name;
        r100.appointment_id = this.appointment_id;
        r100.creator_id = this.creator_id;
        r100.host_id = this.host_id;
        r100.guest_name = this.guest_name;
        r100.guest_email = this.guest_email;
        r100.timezone = this.timezone;
        r100.start_time = this.start_time;
        r100.end_time = this.end_time;
        r100.message = this.message;
        r100.expired_reason = this.expired_reason;
        r100.event_link = this.event_link;
        r100.is_external = this.is_external;
        r100.host_name = this.host_name;
        r100.operator_name = this.operator_name;
        r100.is_forward_msg = this.is_forward_msg;
        r100.origin_message_id = this.origin_message_id;
        r100.cancel_reason = this.cancel_reason;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppointmentMessageNotify.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppointmentMessageNotify(AppointmentMessageStatus r210, AppointmentAction r211, String r212, String r213, Scheduler.Type r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, Long r318, Long r319, String r410, AppointmentMessageExpiredReason r411, String r412, Boolean r413, String r414, String r415, Boolean r416, Long r417, AppointmentMessageCancelReason r418) {
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, ByteString.EMPTY);
    }

    public AppointmentMessageNotify(AppointmentMessageStatus r100, AppointmentAction r101, String r102, String r103, Scheduler.Type r104, String r105, String r110, String r111, String r112, String r113, String r114, String r115, Long r116, Long r117, String r118, AppointmentMessageExpiredReason r119, String r210, Boolean r211, String r212, String r213, Boolean r214, Long r215, AppointmentMessageCancelReason r216, ByteString r217) {
        super(ADAPTER, r217);
        this.status = r100;
        this.action = r101;
        this.operator_id = r102;
        this.scheduler_id = r103;
        this.scheduler_type = r104;
        this.scheduler_name = r105;
        this.appointment_id = r110;
        this.creator_id = r111;
        this.host_id = r112;
        this.guest_name = r113;
        this.guest_email = r114;
        this.timezone = r115;
        this.start_time = r116;
        this.end_time = r117;
        this.message = r118;
        this.expired_reason = r119;
        this.event_link = r210;
        this.is_external = r211;
        this.host_name = r212;
        this.operator_name = r213;
        this.is_forward_msg = r214;
        this.origin_message_id = r215;
        this.cancel_reason = r216;
    }
}
