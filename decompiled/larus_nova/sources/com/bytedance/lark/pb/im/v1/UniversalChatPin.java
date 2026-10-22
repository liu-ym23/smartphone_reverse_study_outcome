package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
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
public final class UniversalChatPin extends Message<UniversalChatPin, Builder> {
    public static final ProtoAdapter<UniversalChatPin> ADAPTER = null;
    public static final Long DEFAULT_CHATTER_ID = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_ID = null;
    public static final Boolean DEFAULT_IS_TOP = null;
    public static final Long DEFAULT_POSITION = null;
    public static final QueueType DEFAULT_QUEUE_TYPE = null;
    public static final Long DEFAULT_TOP_CHATTER_ID = null;
    public static final Long DEFAULT_TOP_POSITION = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final AnnouncementPin announcement_pin_data;
    public final Long chat_id;
    public final Long chatter_id;
    public final Long create_time;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253663id;
    public final Boolean is_top;
    public final MessagePin message_pin_data;
    public final Long position;
    public final QueueType queue_type;
    public final Long top_chatter_id;
    public final Long top_position;
    public final Type type;
    public final UnknownData unknown_data;
    public final UrlPin url_pin_data;

    public static final class AnnouncementPin extends Message<AnnouncementPin, Builder> {
        public static final ProtoAdapter<AnnouncementPin> ADAPTER = null;
        public static final String DEFAULT_URL = "";
        public static final Boolean DEFAULT_USE_OPENDOC = null;
        private static final long serialVersionUID = 0;
        public final String url;
        public final PreviewHangPoint url_preview_hang_point;
        public final Boolean use_opendoc;

        public static final class Builder extends Message.Builder<AnnouncementPin, Builder> {
            public String url;
            public PreviewHangPoint url_preview_hang_point;
            public Boolean use_opendoc;

            @Override // com.squareup.wire.Message.Builder
            public AnnouncementPin build() {
                return new AnnouncementPin(this.use_opendoc, this.url, this.url_preview_hang_point, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }

            public Builder url_preview_hang_point(PreviewHangPoint r100) {
                this.url_preview_hang_point = r100;
                return this;
            }

            public Builder use_opendoc(Boolean r100) {
                this.use_opendoc = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AnnouncementPin extends ProtoAdapter<AnnouncementPin> {
            public ProtoAdapter_AnnouncementPin() {
                super(FieldEncoding.LENGTH_DELIMITED, AnnouncementPin.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnnouncementPin decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.use_opendoc = Boolean.FALSE;
                r101.url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.use_opendoc = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.url_preview_hang_point = PreviewHangPoint.ADAPTER.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AnnouncementPin r100) {
                Boolean r101 = r100.use_opendoc;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                PreviewHangPoint r107 = r100.url_preview_hang_point;
                if (r107 == null) goto L14;
                r102 = PreviewHangPoint.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ AnnouncementPin decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AnnouncementPin r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AnnouncementPin r101) throws IOException {
                Boolean r102 = r101.use_opendoc;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                PreviewHangPoint r104 = r101.url_preview_hang_point;
                if (r104 == null) goto L11;
                PreviewHangPoint.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AnnouncementPin r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnnouncementPin();
            DEFAULT_USE_OPENDOC = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.use_opendoc = this.use_opendoc;
            r100.url = this.url;
            r100.url_preview_hang_point = this.url_preview_hang_point;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AnnouncementPin.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AnnouncementPin(Boolean r100, String r101, PreviewHangPoint r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public AnnouncementPin(Boolean r100, String r101, PreviewHangPoint r102, ByteString r103) {
            super(ADAPTER, r103);
            this.use_opendoc = r100;
            this.url = r101;
            this.url_preview_hang_point = r102;
        }
    }

    public static final class Builder extends Message.Builder<UniversalChatPin, Builder> {
        public AnnouncementPin announcement_pin_data;
        public Long chat_id;
        public Long chatter_id;
        public Long create_time;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253664id;
        public Boolean is_top;
        public MessagePin message_pin_data;
        public Long position;
        public QueueType queue_type;
        public Long top_chatter_id;
        public Long top_position;
        public Type type;
        public UnknownData unknown_data;
        public UrlPin url_pin_data;

        @Override // com.squareup.wire.Message.Builder
        public UniversalChatPin build() {
            return new UniversalChatPin(this.f253664id, this.type, this.chat_id, this.create_time, this.chatter_id, this.position, this.unknown_data, this.message_pin_data, this.url_pin_data, this.announcement_pin_data, this.is_top, this.top_chatter_id, this.top_position, this.queue_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder announcement_pin_data(AnnouncementPin r100) {
            this.announcement_pin_data = r100;
            return this;
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_id(Long r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253664id = r100;
            return this;
        }

        public Builder is_top(Boolean r100) {
            this.is_top = r100;
            return this;
        }

        public Builder message_pin_data(MessagePin r100) {
            this.message_pin_data = r100;
            return this;
        }

        public Builder position(Long r100) {
            this.position = r100;
            return this;
        }

        public Builder queue_type(QueueType r100) {
            this.queue_type = r100;
            return this;
        }

        public Builder top_chatter_id(Long r100) {
            this.top_chatter_id = r100;
            return this;
        }

        public Builder top_position(Long r100) {
            this.top_position = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder unknown_data(UnknownData r100) {
            this.unknown_data = r100;
            return this;
        }

        public Builder url_pin_data(UrlPin r100) {
            this.url_pin_data = r100;
            return this;
        }
    }

    public static final class MessagePin extends Message<MessagePin, Builder> {
        public static final ProtoAdapter<MessagePin> ADAPTER = null;
        public static final Long DEFAULT_MESSAGE_ID = null;
        private static final long serialVersionUID = 0;
        public final Long message_id;

        public static final class Builder extends Message.Builder<MessagePin, Builder> {
            public Long message_id;

            @Override // com.squareup.wire.Message.Builder
            public MessagePin build() {
                return new MessagePin(this.message_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder message_id(Long r100) {
                this.message_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessagePin extends ProtoAdapter<MessagePin> {
            public ProtoAdapter_MessagePin() {
                super(FieldEncoding.LENGTH_DELIMITED, MessagePin.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessagePin decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.message_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.message_id = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(MessagePin r100) {
                Long r101 = r100.message_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessagePin decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessagePin r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessagePin r101) throws IOException {
                Long r102 = r101.message_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessagePin r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessagePin();
            DEFAULT_MESSAGE_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.message_id = this.message_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessagePin.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessagePin(Long r100) {
            this(r100, ByteString.EMPTY);
        }

        public MessagePin(Long r100, ByteString r101) {
            super(ADAPTER, r101);
            this.message_id = r100;
        }
    }

    public static final class ProtoAdapter_UniversalChatPin extends ProtoAdapter<UniversalChatPin> {
        public ProtoAdapter_UniversalChatPin() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalChatPin.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalChatPin decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253664id = 0L;
            r101.type = Type.UNKNOWN;
            r101.chat_id = 0L;
            r101.create_time = 0L;
            r101.chatter_id = 0L;
            r101.position = 0L;
            r101.is_top = Boolean.FALSE;
            r101.top_chatter_id = 0L;
            r101.top_position = 0L;
            r101.queue_type = QueueType.UNKNOWN_QUEUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L31;
            if (r103 != 40) goto L7;
            r101.queue_type = QueueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            switch(r103) {
                case 1: goto L26;
                case 2: goto L35;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                default: goto L8;
            };
        L35:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L18:
            r101.position = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.chatter_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L21:
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L26:
            r101.f253664id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            switch(r103) {
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                default: goto L9;
            };
        L14:
            r101.announcement_pin_data = AnnouncementPin.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.url_pin_data = UrlPin.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.message_pin_data = MessagePin.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.unknown_data = UnknownData.ADAPTER.decode(r100);
            goto L3
        L9:
            switch(r103) {
                case 30: goto L13;
                case 31: goto L12;
                case 32: goto L11;
                default: goto L10;
            };
        L11:
            r101.top_position = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.top_chatter_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.is_top = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniversalChatPin r100) {
            Long r101 = r100.f253663id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.chat_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.create_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.chatter_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.position;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            UnknownData r119 = r100.unknown_data;
            if (r119 == null) goto L29;
            int r120 = UnknownData.ADAPTER.encodedSizeWithTag(10, r119);
        L30:
            int r121 = r118 + r120;
            MessagePin r122 = r100.message_pin_data;
            if (r122 == null) goto L33;
            int r123 = MessagePin.ADAPTER.encodedSizeWithTag(11, r122);
        L34:
            int r124 = r121 + r123;
            UrlPin r125 = r100.url_pin_data;
            if (r125 == null) goto L37;
            int r126 = UrlPin.ADAPTER.encodedSizeWithTag(12, r125);
        L38:
            int r127 = r124 + r126;
            AnnouncementPin r128 = r100.announcement_pin_data;
            if (r128 == null) goto L41;
            int r129 = AnnouncementPin.ADAPTER.encodedSizeWithTag(13, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.is_top;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.top_chatter_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(31, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.top_position;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(32, r137);
        L54:
            int r139 = r136 + r138;
            QueueType r140 = r100.queue_type;
            if (r140 == null) goto L58;
            r102 = QueueType.ADAPTER.encodedSizeWithTag(40, r140);
        L58:
            return (r139 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UniversalChatPin decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalChatPin r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalChatPin r101) throws IOException {
            Long r102 = r101.f253663id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Type r103 = r101.type;
            if (r103 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.create_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.chatter_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.position;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            UnknownData r108 = r101.unknown_data;
            if (r108 == null) goto L23;
            UnknownData.ADAPTER.encodeWithTag(r100, 10, r108);
        L23:
            MessagePin r109 = r101.message_pin_data;
            if (r109 == null) goto L26;
            MessagePin.ADAPTER.encodeWithTag(r100, 11, r109);
        L26:
            UrlPin r110 = r101.url_pin_data;
            if (r110 == null) goto L29;
            UrlPin.ADAPTER.encodeWithTag(r100, 12, r110);
        L29:
            AnnouncementPin r111 = r101.announcement_pin_data;
            if (r111 == null) goto L32;
            AnnouncementPin.ADAPTER.encodeWithTag(r100, 13, r111);
        L32:
            Boolean r112 = r101.is_top;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 30, r112);
        L35:
            Long r113 = r101.top_chatter_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 31, r113);
        L38:
            Long r114 = r101.top_position;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 32, r114);
        L41:
            QueueType r115 = r101.queue_type;
            if (r115 == null) goto L44;
            QueueType.ADAPTER.encodeWithTag(r100, 40, r115);
        L44:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalChatPin r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum QueueType extends Enum<QueueType> implements WireEnum {
        private static final /* synthetic */ QueueType[] $VALUES = null;
        public static final ProtoAdapter<QueueType> ADAPTER = null;
        public static final QueueType NORMAL_QUEUE = null;
        public static final QueueType OLD_MSG_QUEUE = null;
        public static final QueueType TOP_QUEUE = null;
        public static final QueueType UNKNOWN_QUEUE = null;
        private final int value;

        static {
            QueueType r100 = new QueueType("UNKNOWN_QUEUE", 0, 0);
            UNKNOWN_QUEUE = r100;
            QueueType r101 = new QueueType("TOP_QUEUE", 1, 1);
            TOP_QUEUE = r101;
            QueueType r102 = new QueueType("NORMAL_QUEUE", 2, 2);
            NORMAL_QUEUE = r102;
            QueueType r103 = new QueueType("OLD_MSG_QUEUE", 3, 3);
            OLD_MSG_QUEUE = r103;
            $VALUES = new QueueType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(QueueType.class);
        }

        public static QueueType[] values() {
            return (QueueType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static QueueType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return OLD_MSG_QUEUE;
        L14:
            return NORMAL_QUEUE;
        L16:
            return TOP_QUEUE;
        L18:
            return UNKNOWN_QUEUE;
        }

        public static QueueType valueOf(String r100) {
            return (QueueType) a.a(QueueType.class, r100);
        }

        private QueueType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ANNOUNCEMENT_PIN = null;
        public static final Type MESSAGE_PIN = null;
        public static final Type UNKNOWN = null;
        public static final Type URL_PIN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("MESSAGE_PIN", 1, 1);
            MESSAGE_PIN = r101;
            Type r102 = new Type("URL_PIN", 2, 2);
            URL_PIN = r102;
            Type r103 = new Type("ANNOUNCEMENT_PIN", 3, 3);
            ANNOUNCEMENT_PIN = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return ANNOUNCEMENT_PIN;
        L14:
            return URL_PIN;
        L16:
            return MESSAGE_PIN;
        L18:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class UnknownData extends Message<UnknownData, Builder> {
        public static final ProtoAdapter<UnknownData> ADAPTER = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final UniversalChatPinIcon icon;
        public final String title;

        public static final class Builder extends Message.Builder<UnknownData, Builder> {
            public UniversalChatPinIcon icon;
            public String title;

            @Override // com.squareup.wire.Message.Builder
            public UnknownData build() {
                return new UnknownData(this.title, this.icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder icon(UniversalChatPinIcon r100) {
                this.icon = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UnknownData extends ProtoAdapter<UnknownData> {
            public ProtoAdapter_UnknownData() {
                super(FieldEncoding.LENGTH_DELIMITED, UnknownData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UnknownData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 3) goto L9;
                r101.icon = UniversalChatPinIcon.ADAPTER.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UnknownData r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                UniversalChatPinIcon r104 = r100.icon;
                if (r104 == null) goto L10;
                r102 = UniversalChatPinIcon.ADAPTER.encodedSizeWithTag(3, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UnknownData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UnknownData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UnknownData r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                UniversalChatPinIcon r103 = r101.icon;
                if (r103 == null) goto L8;
                UniversalChatPinIcon.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UnknownData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UnknownData();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.icon = this.icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UnknownData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UnknownData(String r100, UniversalChatPinIcon r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public UnknownData(String r100, UniversalChatPinIcon r101, ByteString r102) {
            super(ADAPTER, r102);
            this.title = r100;
            this.icon = r101;
        }
    }

    public static final class UrlPin extends Message<UrlPin, Builder> {
        public static final ProtoAdapter<UrlPin> ADAPTER = null;
        public static final Long DEFAULT_FROM_TEMPLATE_ID = null;
        public static final Boolean DEFAULT_ICON_UPDATED = null;
        public static final String DEFAULT_TITLE = "";
        public static final Boolean DEFAULT_TITLE_UPDATED = null;
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final Long from_template_id;
        public final UniversalChatPinIcon icon;
        public final Boolean icon_updated;
        public final String title;
        public final Boolean title_updated;
        public final String url;
        public final PreviewHangPoint url_preview_hang_point;

        public static final class Builder extends Message.Builder<UrlPin, Builder> {
            public Long from_template_id;
            public UniversalChatPinIcon icon;
            public Boolean icon_updated;
            public String title;
            public Boolean title_updated;
            public String url;
            public PreviewHangPoint url_preview_hang_point;

            @Override // com.squareup.wire.Message.Builder
            public UrlPin build() {
                return new UrlPin(this.url, this.icon, this.title, this.url_preview_hang_point, this.from_template_id, this.title_updated, this.icon_updated, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder from_template_id(Long r100) {
                this.from_template_id = r100;
                return this;
            }

            public Builder icon(UniversalChatPinIcon r100) {
                this.icon = r100;
                return this;
            }

            public Builder icon_updated(Boolean r100) {
                this.icon_updated = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder title_updated(Boolean r100) {
                this.title_updated = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }

            public Builder url_preview_hang_point(PreviewHangPoint r100) {
                this.url_preview_hang_point = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UrlPin extends ProtoAdapter<UrlPin> {
            public ProtoAdapter_UrlPin() {
                super(FieldEncoding.LENGTH_DELIMITED, UrlPin.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UrlPin decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.title = "";
                r101.from_template_id = 0L;
                Boolean r102 = Boolean.FALSE;
                r101.title_updated = r102;
                r101.icon_updated = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L14;
                switch(r104) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L6;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r101.icon_updated = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.title_updated = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.from_template_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                r101.url_preview_hang_point = PreviewHangPoint.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.icon = UniversalChatPinIcon.ADAPTER.decode(r100);
                goto L3
            L13:
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UrlPin r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                UniversalChatPinIcon r104 = r100.icon;
                if (r104 == null) goto L9;
                int r105 = UniversalChatPinIcon.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.title;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                PreviewHangPoint r110 = r100.url_preview_hang_point;
                if (r110 == null) goto L17;
                int r111 = PreviewHangPoint.ADAPTER.encodedSizeWithTag(5, r110);
            L18:
                int r112 = r109 + r111;
                Long r113 = r100.from_template_id;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.INT64.encodedSizeWithTag(6, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.title_updated;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.icon_updated;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
            L30:
                return (r118 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ UrlPin decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UrlPin r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UrlPin r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                UniversalChatPinIcon r103 = r101.icon;
                if (r103 == null) goto L8;
                UniversalChatPinIcon.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.title;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                PreviewHangPoint r105 = r101.url_preview_hang_point;
                if (r105 == null) goto L14;
                PreviewHangPoint.ADAPTER.encodeWithTag(r100, 5, r105);
            L14:
                Long r106 = r101.from_template_id;
                if (r106 == null) goto L17;
                ProtoAdapter.INT64.encodeWithTag(r100, 6, r106);
            L17:
                Boolean r107 = r101.title_updated;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
            L20:
                Boolean r108 = r101.icon_updated;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrlPin r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UrlPin();
            DEFAULT_FROM_TEMPLATE_ID = 0L;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_TITLE_UPDATED = r100;
            DEFAULT_ICON_UPDATED = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.icon = this.icon;
            r100.title = this.title;
            r100.url_preview_hang_point = this.url_preview_hang_point;
            r100.from_template_id = this.from_template_id;
            r100.title_updated = this.title_updated;
            r100.icon_updated = this.icon_updated;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UrlPin.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UrlPin(String r110, UniversalChatPinIcon r111, String r112, PreviewHangPoint r113, Long r114, Boolean r115, Boolean r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public UrlPin(String r100, UniversalChatPinIcon r101, String r102, PreviewHangPoint r103, Long r104, Boolean r105, Boolean r106, ByteString r107) {
            super(ADAPTER, r107);
            this.url = r100;
            this.icon = r101;
            this.title = r102;
            this.url_preview_hang_point = r103;
            this.from_template_id = r104;
            this.title_updated = r105;
            this.icon_updated = r106;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalChatPin();
        DEFAULT_ID = 0L;
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_CHATTER_ID = 0L;
        DEFAULT_POSITION = 0L;
        DEFAULT_IS_TOP = Boolean.FALSE;
        DEFAULT_TOP_CHATTER_ID = 0L;
        DEFAULT_TOP_POSITION = 0L;
        DEFAULT_QUEUE_TYPE = QueueType.UNKNOWN_QUEUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253664id = this.f253663id;
        r100.type = this.type;
        r100.chat_id = this.chat_id;
        r100.create_time = this.create_time;
        r100.chatter_id = this.chatter_id;
        r100.position = this.position;
        r100.unknown_data = this.unknown_data;
        r100.message_pin_data = this.message_pin_data;
        r100.url_pin_data = this.url_pin_data;
        r100.announcement_pin_data = this.announcement_pin_data;
        r100.is_top = this.is_top;
        r100.top_chatter_id = this.top_chatter_id;
        r100.top_position = this.top_position;
        r100.queue_type = this.queue_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalChatPin.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalChatPin(Long r110, Type r111, Long r112, Long r210, Long r211, Long r212, UnknownData r213, MessagePin r214, UrlPin r215, AnnouncementPin r216, Boolean r217, Long r218, Long r219, QueueType r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public UniversalChatPin(Long r100, Type r101, Long r102, Long r103, Long r104, Long r105, UnknownData r110, MessagePin r111, UrlPin r112, AnnouncementPin r113, Boolean r114, Long r115, Long r116, QueueType r117, ByteString r118) {
        super(ADAPTER, r118);
        this.f253663id = r100;
        this.type = r101;
        this.chat_id = r102;
        this.create_time = r103;
        this.chatter_id = r104;
        this.position = r105;
        this.unknown_data = r110;
        this.message_pin_data = r111;
        this.url_pin_data = r112;
        this.announcement_pin_data = r113;
        this.is_top = r114;
        this.top_chatter_id = r115;
        this.top_position = r116;
        this.queue_type = r117;
    }
}
