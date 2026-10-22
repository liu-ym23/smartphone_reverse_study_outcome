package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatJoinLeaveHistory extends com.squareup.wire.Message<ChatJoinLeaveHistory, Builder> {
    public static final ProtoAdapter<ChatJoinLeaveHistory> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_CHATTER_NAME = "";
    public static final ChatterType DEFAULT_CHATTER_TYPE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final EventType DEFAULT_EVENT = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final Action action;
    public final String avatar_key;
    public final String chat_id;
    public final String chatter_id;
    public final String chatter_name;
    public final ChatterType chatter_type;
    public final Long create_time;
    public final EventType event;
    public final HistoryExtra extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253449id;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action JOIN = null;
        public static final Action LEAVE = null;
        public static final Action UNKNOWN_ACTION = null;
        private final int value;

        static {
            Action r100 = new Action("UNKNOWN_ACTION", 0, 0);
            UNKNOWN_ACTION = r100;
            Action r101 = new Action("JOIN", 1, 1);
            JOIN = r101;
            Action r102 = new Action("LEAVE", 2, 2);
            LEAVE = r102;
            $VALUES = new Action[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return LEAVE;
        L12:
            return JOIN;
        L14:
            return UNKNOWN_ACTION;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatJoinLeaveHistory, Builder> {
        public Action action;
        public String avatar_key;
        public String chat_id;
        public String chatter_id;
        public String chatter_name;
        public ChatterType chatter_type;
        public Long create_time;
        public EventType event;
        public HistoryExtra extra;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253450id;

        @Override // com.squareup.wire.Message.Builder
        public ChatJoinLeaveHistory build() {
            return new ChatJoinLeaveHistory(this.f253450id, this.action, this.event, this.chatter_id, this.avatar_key, this.chatter_name, this.chat_id, this.create_time, this.extra, this.chatter_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.action = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder chatter_name(String r100) {
            this.chatter_name = r100;
            return this;
        }

        public Builder chatter_type(ChatterType r100) {
            this.chatter_type = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder event(EventType r100) {
            this.event = r100;
            return this;
        }

        public Builder extra(HistoryExtra r100) {
            this.extra = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253450id = r100;
            return this;
        }
    }

    public static final enum ChatterType extends Enum<ChatterType> implements WireEnum {
        private static final /* synthetic */ ChatterType[] $VALUES = null;
        public static final ProtoAdapter<ChatterType> ADAPTER = null;
        public static final ChatterType BOT = null;
        public static final ChatterType UNKNOWN = null;
        public static final ChatterType USER = null;
        private final int value;

        static {
            ChatterType r100 = new ChatterType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatterType r101 = new ChatterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            ChatterType r102 = new ChatterType("BOT", 2, 2);
            BOT = r102;
            $VALUES = new ChatterType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatterType.class);
        }

        public static ChatterType[] values() {
            return (ChatterType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatterType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BOT;
        L12:
            return USER;
        L14:
            return UNKNOWN;
        }

        public static ChatterType valueOf(String r100) {
            return (ChatterType) a.a(ChatterType.class, r100);
        }

        private ChatterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ContentValue extends com.squareup.wire.Message<ContentValue, Builder> {
        public static final ProtoAdapter<ContentValue> ADAPTER = null;
        public static final String DEFAULT_DISPLAY_TEXT = "";
        public static final String DEFAULT_DOC_URL = "";
        public static final String DEFAULT_ID = "";
        public static final ValueType DEFAULT_TYPE = null;
        public static final Boolean DEFAULT_UNAUTHORIZED_DOC = null;
        private static final long serialVersionUID = 0;
        public final String display_text;
        public final String doc_url;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253451id;
        public final ValueType type;
        public final Boolean unauthorized_doc;

        public static final class Builder extends com.squareup.wire.Message.Builder<ContentValue, Builder> {
            public String display_text;
            public String doc_url;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253452id;
            public ValueType type;
            public Boolean unauthorized_doc;

            @Override // com.squareup.wire.Message.Builder
            public ContentValue build() {
                return new ContentValue(this.f253452id, this.doc_url, this.type, this.display_text, this.unauthorized_doc, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder display_text(String r100) {
                this.display_text = r100;
                return this;
            }

            public Builder doc_url(String r100) {
                this.doc_url = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253452id = r100;
                return this;
            }

            public Builder type(ValueType r100) {
                this.type = r100;
                return this;
            }

            public Builder unauthorized_doc(Boolean r100) {
                this.unauthorized_doc = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ContentValue extends ProtoAdapter<ContentValue> {
            public ProtoAdapter_ContentValue() {
                super(FieldEncoding.LENGTH_DELIMITED, ContentValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ContentValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253452id = "";
                r101.doc_url = "";
                r101.type = ValueType.UNKNOWN_VALUE_TYPE;
                r101.display_text = "";
                r101.unauthorized_doc = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.f253452id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.doc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.type = ValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.display_text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.unauthorized_doc = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(ContentValue r100) {
                String r101 = r100.f253451id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.doc_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ValueType r107 = r100.type;
                if (r107 == null) goto L13;
                int r108 = ValueType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.display_text;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.unauthorized_doc;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ ContentValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ContentValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ContentValue r101) throws IOException {
                String r102 = r101.f253451id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.doc_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ValueType r104 = r101.type;
                if (r104 == null) goto L11;
                ValueType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.display_text;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.unauthorized_doc;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContentValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum ValueType extends Enum<ValueType> implements WireEnum {
            private static final /* synthetic */ ValueType[] $VALUES = null;
            public static final ProtoAdapter<ValueType> ADAPTER = null;
            public static final ValueType BOT = null;
            public static final ValueType CHAT = null;
            public static final ValueType DEP = null;
            public static final ValueType DOC = null;
            public static final ValueType TEAM = null;
            public static final ValueType UNKNOWN_VALUE_TYPE = null;
            public static final ValueType USER = null;
            private final int value;

            static {
                ValueType r100 = new ValueType("UNKNOWN_VALUE_TYPE", 0, 0);
                UNKNOWN_VALUE_TYPE = r100;
                ValueType r101 = new ValueType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
                USER = r101;
                ValueType r102 = new ValueType("BOT", 2, 2);
                BOT = r102;
                ValueType r103 = new ValueType("CHAT", 3, 3);
                CHAT = r103;
                ValueType r104 = new ValueType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 4, 4);
                DOC = r104;
                ValueType r105 = new ValueType("TEAM", 5, 5);
                TEAM = r105;
                ValueType r110 = new ValueType("DEP", 6, 6);
                DEP = r110;
                $VALUES = new ValueType[]{r100, r101, r102, r103, r104, r105, r110};
                ADAPTER = ProtoAdapter.newEnumAdapter(ValueType.class);
            }

            public static ValueType[] values() {
                return (ValueType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ValueType fromValue(int r100) {
                switch(r100) {
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L14;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L8;
                    case 6: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DEP;
            L8:
                return TEAM;
            L10:
                return DOC;
            L12:
                return CHAT;
            L14:
                return BOT;
            L16:
                return USER;
            L18:
                return UNKNOWN_VALUE_TYPE;
            }

            public static ValueType valueOf(String r100) {
                return (ValueType) a.a(ValueType.class, r100);
            }

            private ValueType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContentValue();
            DEFAULT_TYPE = ValueType.UNKNOWN_VALUE_TYPE;
            DEFAULT_UNAUTHORIZED_DOC = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253452id = this.f253451id;
            r100.doc_url = this.doc_url;
            r100.type = this.type;
            r100.display_text = this.display_text;
            r100.unauthorized_doc = this.unauthorized_doc;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ContentValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ContentValue(String r100, String r101, ValueType r110, String r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ContentValue(String r100, String r101, ValueType r102, String r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.f253451id = r100;
            this.doc_url = r101;
            this.type = r102;
            this.display_text = r103;
            this.unauthorized_doc = r104;
        }
    }

    public static final enum EventType extends Enum<EventType> implements WireEnum {
        private static final /* synthetic */ EventType[] $VALUES = null;
        public static final ProtoAdapter<EventType> ADAPTER = null;
        public static final EventType DEL_ADMIN = null;
        public static final EventType DEL_FROM_DEP = null;
        public static final EventType DEL_SELF = null;
        public static final EventType INV_CHATTER = null;
        public static final EventType INV_DOC = null;
        public static final EventType INV_FROM_DEP = null;
        public static final EventType INV_FROM_TEAM = null;
        public static final EventType INV_GROUP_CHAT = null;
        public static final EventType INV_MESSAGE_CARD = null;
        public static final EventType INV_P2P_CHAT = null;
        public static final EventType INV_QR_CODE = null;
        public static final EventType INV_SEARCH = null;
        public static final EventType INV_SELF = null;
        public static final EventType LINKED_PAGE = null;
        public static final EventType UNKNOWN_TYPE = null;
        private final int value;

        static {
            EventType r100 = new EventType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            EventType r101 = new EventType("DEL_SELF", 1, 1);
            DEL_SELF = r101;
            EventType r102 = new EventType("DEL_ADMIN", 2, 2);
            DEL_ADMIN = r102;
            EventType r103 = new EventType("INV_MESSAGE_CARD", 3, 10);
            INV_MESSAGE_CARD = r103;
            EventType r104 = new EventType("INV_QR_CODE", 4, 11);
            INV_QR_CODE = r104;
            EventType r110 = new EventType("INV_CHATTER", 5, 12);
            INV_CHATTER = r110;
            EventType r111 = new EventType("INV_DOC", 6, 13);
            INV_DOC = r111;
            EventType r112 = new EventType("INV_SEARCH", 7, 14);
            INV_SEARCH = r112;
            EventType r113 = new EventType("INV_SELF", 8, 15);
            INV_SELF = r113;
            EventType r105 = new EventType("INV_P2P_CHAT", 9, 16);
            INV_P2P_CHAT = r105;
            EventType r106 = new EventType("INV_GROUP_CHAT", 10, 17);
            INV_GROUP_CHAT = r106;
            EventType r107 = new EventType("INV_FROM_TEAM", 11, 19);
            INV_FROM_TEAM = r107;
            EventType r108 = new EventType("INV_FROM_DEP", 12, 20);
            INV_FROM_DEP = r108;
            EventType r109 = new EventType("DEL_FROM_DEP", 13, 21);
            DEL_FROM_DEP = r109;
            EventType r114 = new EventType("LINKED_PAGE", 14, 22);
            LINKED_PAGE = r114;
            $VALUES = new EventType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r106, r107, r108, r109, r114};
            ADAPTER = ProtoAdapter.newEnumAdapter(EventType.class);
        }

        public static EventType[] values() {
            return (EventType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EventType fromValue(int r100) {
            if (r100 == 0) goto L40;
            if (r100 == 1) goto L38;
            if (r100 == 2) goto L36;
            switch(r100) {
                case 10: goto L34;
                case 11: goto L32;
                case 12: goto L30;
                case 13: goto L28;
                case 14: goto L26;
                case 15: goto L24;
                case 16: goto L22;
                case 17: goto L20;
                default: goto L8;
            };
        L8:
            switch(r100) {
                case 19: goto L18;
                case 20: goto L16;
                case 21: goto L14;
                case 22: goto L12;
                default: goto L9;
            };
        L9:
            return null;
        L12:
            return LINKED_PAGE;
        L14:
            return DEL_FROM_DEP;
        L16:
            return INV_FROM_DEP;
        L18:
            return INV_FROM_TEAM;
        L20:
            return INV_GROUP_CHAT;
        L22:
            return INV_P2P_CHAT;
        L24:
            return INV_SELF;
        L26:
            return INV_SEARCH;
        L28:
            return INV_DOC;
        L30:
            return INV_CHATTER;
        L32:
            return INV_QR_CODE;
        L34:
            return INV_MESSAGE_CARD;
        L36:
            return DEL_ADMIN;
        L38:
            return DEL_SELF;
        L40:
            return UNKNOWN_TYPE;
        }

        public static EventType valueOf(String r100) {
            return (EventType) a.a(EventType.class, r100);
        }

        private EventType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class HistoryExtra extends com.squareup.wire.Message<HistoryExtra, Builder> {
        public static final ProtoAdapter<HistoryExtra> ADAPTER = null;
        public static final String DEFAULT_TEMPLATE = "";
        private static final long serialVersionUID = 0;
        public final Map<String, ContentValue> content_values;
        public final String template;

        public static final class Builder extends com.squareup.wire.Message.Builder<HistoryExtra, Builder> {
            public Map<String, ContentValue> content_values;
            public String template;

            @Override // com.squareup.wire.Message.Builder
            public HistoryExtra build() {
                return new HistoryExtra(this.template, this.content_values, super.buildUnknownFields());
            }

            public Builder() {
                this.content_values = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content_values(Map<String, ContentValue> r100) {
                Internal.checkElementsNotNull(r100);
                this.content_values = r100;
                return this;
            }

            public Builder template(String r100) {
                this.template = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_HistoryExtra extends ProtoAdapter<HistoryExtra> {
            private final ProtoAdapter<Map<String, ContentValue>> content_values;

            public ProtoAdapter_HistoryExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, HistoryExtra.class);
                this.content_values = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ContentValue.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HistoryExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.template = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.template = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.content_values.putAll(this.content_values.decode(r100));
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
            public int encodedSize2(HistoryExtra r100) {
                String r101 = r100.template;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + this.content_values.encodedSizeWithTag(2, r100.content_values)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HistoryExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HistoryExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HistoryExtra r101) throws IOException {
                String r102 = r101.template;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                this.content_values.encodeWithTag(r100, 2, r101.content_values);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HistoryExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HistoryExtra();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.template = this.template;
            r100.content_values = Internal.copyOf("content_values", this.content_values);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HistoryExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public HistoryExtra(String r100, Map<String, ContentValue> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public HistoryExtra(String r100, Map<String, ContentValue> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.template = r100;
            this.content_values = Internal.immutableCopyOf("content_values", r101);
        }
    }

    public static final class ProtoAdapter_ChatJoinLeaveHistory extends ProtoAdapter<ChatJoinLeaveHistory> {
        public ProtoAdapter_ChatJoinLeaveHistory() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatJoinLeaveHistory.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatJoinLeaveHistory decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253450id = "";
            r101.action = Action.UNKNOWN_ACTION;
            r101.event = EventType.UNKNOWN_TYPE;
            r101.chatter_id = "";
            r101.avatar_key = "";
            r101.chatter_name = "";
            r101.chat_id = "";
            r101.create_time = 0L;
            r101.chatter_type = ChatterType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L30;
                case 3: goto L32;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L28;
                default: goto L6;
            };
        L28:
            r101.chatter_type = ChatterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.action = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L32:
            r101.event = EventType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.extra = HistoryExtra.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.chatter_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.f253450id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatJoinLeaveHistory r100) {
            String r101 = r100.f253449id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Action r104 = r100.action;
            if (r104 == null) goto L9;
            int r105 = Action.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            EventType r107 = r100.event;
            if (r107 == null) goto L13;
            int r108 = EventType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.chatter_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.avatar_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.chatter_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.chat_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.create_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            HistoryExtra r125 = r100.extra;
            if (r125 == null) goto L37;
            int r126 = HistoryExtra.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            ChatterType r128 = r100.chatter_type;
            if (r128 == null) goto L42;
            r102 = ChatterType.ADAPTER.encodedSizeWithTag(10, r128);
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
        public /* bridge */ /* synthetic */ ChatJoinLeaveHistory decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatJoinLeaveHistory r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatJoinLeaveHistory r101) throws IOException {
            String r102 = r101.f253449id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Action r103 = r101.action;
            if (r103 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            EventType r104 = r101.event;
            if (r104 == null) goto L11;
            EventType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.chatter_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.avatar_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.chatter_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.chat_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.create_time;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            HistoryExtra r110 = r101.extra;
            if (r110 == null) goto L29;
            HistoryExtra.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            ChatterType r111 = r101.chatter_type;
            if (r111 == null) goto L32;
            ChatterType.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatJoinLeaveHistory r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatJoinLeaveHistory();
        DEFAULT_ACTION = Action.UNKNOWN_ACTION;
        DEFAULT_EVENT = EventType.UNKNOWN_TYPE;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_CHATTER_TYPE = ChatterType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253450id = this.f253449id;
        r100.action = this.action;
        r100.event = this.event;
        r100.chatter_id = this.chatter_id;
        r100.avatar_key = this.avatar_key;
        r100.chatter_name = this.chatter_name;
        r100.chat_id = this.chat_id;
        r100.create_time = this.create_time;
        r100.extra = this.extra;
        r100.chatter_type = this.chatter_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatJoinLeaveHistory.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatJoinLeaveHistory(String r110, Action r111, EventType r112, String r113, String r114, String r115, String r116, Long r210, HistoryExtra r211, ChatterType r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public ChatJoinLeaveHistory(String r100, Action r101, EventType r102, String r103, String r104, String r105, String r106, Long r107, HistoryExtra r110, ChatterType r111, ByteString r112) {
        super(ADAPTER, r112);
        this.f253449id = r100;
        this.action = r101;
        this.event = r102;
        this.chatter_id = r103;
        this.avatar_key = r104;
        this.chatter_name = r105;
        this.chat_id = r106;
        this.create_time = r107;
        this.extra = r110;
        this.chatter_type = r111;
    }
}
