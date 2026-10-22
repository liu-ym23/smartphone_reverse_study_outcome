package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.PickEntities;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class AddChatChattersRequest extends Message<AddChatChattersRequest, Builder> {
    public static final ProtoAdapter<AddChatChattersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_INVITER_ID = "";
    public static final String DEFAULT_JOIN_TOKEN = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Source DEFAULT_SOURCE = null;
    public static final Long DEFAULT_TEAM_ID = null;
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_AddChatChattersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final List<String> chatter_ids;
    public final ChatPageContext from_page;
    public final String inviter_id;
    public final String join_token;
    public final String message_id;
    public final List<PickEntities> pick_entities;
    public final Source source;
    public final Long team_id;
    public final Type type;

    public static final class Builder extends Message.Builder<AddChatChattersRequest, Builder> implements d<AddChatChattersRequest> {
        public String chat_id;
        public List<String> chatter_ids;
        public ChatPageContext from_page;
        public String inviter_id;
        public String join_token;
        public String message_id;
        public List<PickEntities> pick_entities;
        public Source source;
        public Long team_id;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public AddChatChattersRequest build() {
            return new AddChatChattersRequest(this.type, this.chat_id, this.chatter_ids, this.pick_entities, this.join_token, this.message_id, this.inviter_id, this.source, this.team_id, this.from_page, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
            this.pick_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder from_page(ChatPageContext r100) {
            this.from_page = r100;
            return this;
        }

        public Builder inviter_id(String r100) {
            this.inviter_id = r100;
            return this;
        }

        public Builder join_token(String r100) {
            this.join_token = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r100) {
            Internal.checkElementsNotNull(r100);
            this.pick_entities = r100;
            return this;
        }

        public Builder source(Source r100) {
            this.source = r100;
            return this;
        }

        public Builder team_id(Long r100) {
            this.team_id = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AddChatChattersRequest extends ProtoAdapter<AddChatChattersRequest> implements c<AddChatChattersRequest> {
        public ProtoAdapter_AddChatChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, AddChatChattersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AddChatChattersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.INVITATION;
            r101.chat_id = "";
            r101.join_token = "";
            r101.message_id = "";
            r101.inviter_id = "";
            r101.source = Source.Unknown;
            r101.team_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L27;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L6;
                case 9: goto L25;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L25:
            r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.from_page = ChatPageContext.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.team_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.pick_entities.add(PickEntities.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.inviter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.join_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L18:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AddChatChattersRequest r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ProtoAdapter<String> r107 = ProtoAdapter.STRING;
            int r108 = (r106 + r107.asRepeated().encodedSizeWithTag(3, r100.chatter_ids)) + PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.pick_entities);
            String r109 = r100.join_token;
            if (r109 == null) goto L13;
            int r110 = r107.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.message_id;
            if (r112 == null) goto L17;
            int r113 = r107.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.inviter_id;
            if (r115 == null) goto L21;
            int r116 = r107.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            Source r118 = r100.source;
            if (r118 == null) goto L25;
            int r119 = Source.ADAPTER.encodedSizeWithTag(9, r118);
        L26:
            int r120 = r117 + r119;
            Long r121 = r100.team_id;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.INT64.encodedSizeWithTag(10, r121);
        L30:
            int r123 = r120 + r122;
            ChatPageContext r124 = r100.from_page;
            if (r124 == null) goto L34;
            r102 = ChatPageContext.ADAPTER.encodedSizeWithTag(11, r124);
        L34:
            return (r123 + r102) + r100.unknownFields().size();
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
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AddChatChattersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AddChatChattersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AddChatChattersRequest r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            r104.asRepeated().encodeWithTag(r100, 3, r101.chatter_ids);
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.pick_entities);
            String r105 = r101.join_token;
            if (r105 == null) goto L11;
            r104.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.message_id;
            if (r106 == null) goto L14;
            r104.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.inviter_id;
            if (r107 == null) goto L17;
            r104.encodeWithTag(r100, 6, r107);
        L17:
            Source r108 = r101.source;
            if (r108 == null) goto L20;
            Source.ADAPTER.encodeWithTag(r100, 9, r108);
        L20:
            Long r109 = r101.team_id;
            if (r109 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r109);
        L23:
            ChatPageContext r110 = r101.from_page;
            if (r110 == null) goto L26;
            ChatPageContext.ADAPTER.encodeWithTag(r100, 11, r110);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddChatChattersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source ChatLinkedPage = null;
        public static final Source ChatTemplate = null;
        public static final Source Unknown = null;
        private final int value;

        static {
            Source r100 = new Source("Unknown", 0, 0);
            Unknown = r100;
            Source r101 = new Source("ChatTemplate", 1, 10);
            ChatTemplate = r101;
            Source r102 = new Source("ChatLinkedPage", 2, 11);
            ChatLinkedPage = r102;
            $VALUES = new Source[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 10) goto L12;
            if (r100 == 11) goto L10;
            return null;
        L10:
            return ChatLinkedPage;
        L12:
            return ChatTemplate;
        L14:
            return Unknown;
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type INVITATION = null;
        public static final Type LINKED_PAGE = null;
        public static final Type MENTION_INVITATION = null;
        public static final Type OPEN_CHAT = null;
        public static final Type QRCODE = null;
        public static final Type SHARE = null;
        private final int value;

        static {
            Type r100 = new Type("INVITATION", 0, 1);
            INVITATION = r100;
            Type r101 = new Type("SHARE", 1, 2);
            SHARE = r101;
            Type r102 = new Type("QRCODE", 2, 3);
            QRCODE = r102;
            Type r103 = new Type("MENTION_INVITATION", 3, 4);
            MENTION_INVITATION = r103;
            Type r104 = new Type("OPEN_CHAT", 4, 5);
            OPEN_CHAT = r104;
            Type r110 = new Type("LINKED_PAGE", 5, 6);
            LINKED_PAGE = r110;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r110};
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
            switch(r100) {
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
            return LINKED_PAGE;
        L8:
            return OPEN_CHAT;
        L10:
            return MENTION_INVITATION;
        L12:
            return QRCODE;
        L14:
            return SHARE;
        L16:
            return INVITATION;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_AddChatChattersRequest r100 = new ProtoAdapter_AddChatChattersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Type.INVITATION;
        DEFAULT_SOURCE = Source.Unknown;
        DEFAULT_TEAM_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.chat_id = this.chat_id;
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.pick_entities = Internal.copyOf("pick_entities", this.pick_entities);
        r100.join_token = this.join_token;
        r100.message_id = this.message_id;
        r100.inviter_id = this.inviter_id;
        r100.source = this.source;
        r100.team_id = this.team_id;
        r100.from_page = this.from_page;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AddChatChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AddChatChattersRequest(Type r110, String r111, List<String> r112, List<PickEntities> r113, String r114, String r115, String r116, Source r210, Long r211, ChatPageContext r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public AddChatChattersRequest(Type r100, String r101, List<String> r102, List<PickEntities> r103, String r104, String r105, String r106, Source r107, Long r110, ChatPageContext r111, ByteString r112) {
        super(ADAPTER, r112);
        this.type = r100;
        this.chat_id = r101;
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r102);
        this.pick_entities = Internal.immutableCopyOf("pick_entities", r103);
        this.join_token = r104;
        this.message_id = r105;
        this.inviter_id = r106;
        this.source = r107;
        this.team_id = r110;
        this.from_page = r111;
    }
}
