package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.lark.pb.basic.v1.Entity;
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
public final class PushMessageResponse extends Message<PushMessageResponse, Builder> {
    public static final ProtoAdapter<PushMessageResponse> ADAPTER = null;
    public static final ProtoAdapter_PushMessageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<AIRoundInfo> ai_last_round_infos;
    public final Entity entity;
    public final List<MessageItem> message_items;

    public static final class Builder extends Message.Builder<PushMessageResponse, Builder> implements d<PushMessageResponse> {
        public List<AIRoundInfo> ai_last_round_infos;
        public Entity entity;
        public List<MessageItem> message_items;

        @Override // com.squareup.wire.Message.Builder
        public PushMessageResponse build() {
            Entity r100 = this.entity;
            if (r100 == null) goto L7;
            return new PushMessageResponse(this.message_items, this.entity, this.ai_last_round_infos, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "entity"});
        }

        public Builder() {
            this.message_items = Internal.newMutableList();
            this.ai_last_round_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_last_round_infos(List<AIRoundInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.ai_last_round_infos = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder message_items(List<MessageItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_items = r100;
            return this;
        }
    }

    public static final class MessageItem extends Message<MessageItem, Builder> {
        public static final ProtoAdapter<MessageItem> ADAPTER = null;
        public static final String DEFAULT_ITEM_ID = "";
        public static final ItemType DEFAULT_ITEM_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String item_id;
        public final ItemType item_type;

        public static final class Builder extends Message.Builder<MessageItem, Builder> {
            public String item_id;
            public ItemType item_type;

            @Override // com.squareup.wire.Message.Builder
            public MessageItem build() {
                String r100 = this.item_id;
                if (r100 == null) goto L9;
                if (this.item_type == null) goto L9;
                return new MessageItem(this.item_id, this.item_type, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "item_id", this.item_type, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder item_id(String r100) {
                this.item_id = r100;
                return this;
            }

            public Builder item_type(ItemType r100) {
                this.item_type = r100;
                return this;
            }
        }

        public static final enum ItemType extends Enum<ItemType> implements WireEnum {
            private static final /* synthetic */ ItemType[] $VALUES = null;
            public static final ProtoAdapter<ItemType> ADAPTER = null;
            public static final ItemType EPHEMERAL_MESSAGE = null;
            public static final ItemType MESSAGE_FOLD = null;
            public static final ItemType NORMAL_MESSAGE = null;
            public static final ItemType QUASI_MESSAGE = null;
            public static final ItemType UNKNOWN_MESSAGE = null;
            private final int value;

            static {
                ItemType r100 = new ItemType("UNKNOWN_MESSAGE", 0, 0);
                UNKNOWN_MESSAGE = r100;
                ItemType r101 = new ItemType("NORMAL_MESSAGE", 1, 1);
                NORMAL_MESSAGE = r101;
                ItemType r102 = new ItemType("QUASI_MESSAGE", 2, 2);
                QUASI_MESSAGE = r102;
                ItemType r103 = new ItemType("EPHEMERAL_MESSAGE", 3, 3);
                EPHEMERAL_MESSAGE = r103;
                ItemType r104 = new ItemType("MESSAGE_FOLD", 4, 4);
                MESSAGE_FOLD = r104;
                $VALUES = new ItemType[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(ItemType.class);
            }

            public static ItemType[] values() {
                return (ItemType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ItemType fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return MESSAGE_FOLD;
            L16:
                return EPHEMERAL_MESSAGE;
            L18:
                return QUASI_MESSAGE;
            L20:
                return NORMAL_MESSAGE;
            L22:
                return UNKNOWN_MESSAGE;
            }

            public static ItemType valueOf(String r100) {
                return (ItemType) a.a(ItemType.class, r100);
            }

            private ItemType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MessageItem extends ProtoAdapter<MessageItem> {
            public ProtoAdapter_MessageItem() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.item_id = "";
                r101.item_type = ItemType.UNKNOWN_MESSAGE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.item_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.item_type = ItemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageItem r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.item_id) + ItemType.ADAPTER.encodedSizeWithTag(2, r100.item_type)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageItem r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.item_id);
                ItemType.ADAPTER.encodeWithTag(r100, 2, r101.item_type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageItem();
            DEFAULT_ITEM_TYPE = ItemType.UNKNOWN_MESSAGE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.item_id = this.item_id;
            r100.item_type = this.item_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageItem(String r100, ItemType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MessageItem(String r100, ItemType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.item_id = r100;
            this.item_type = r101;
        }
    }

    public static final class ProtoAdapter_PushMessageResponse extends ProtoAdapter<PushMessageResponse> implements c<PushMessageResponse> {
        public ProtoAdapter_PushMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMessageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.message_items.add(MessageItem.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.ai_last_round_infos.add(AIRoundInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(PushMessageResponse r100) {
            return ((MessageItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.message_items) + Entity.ADAPTER.encodedSizeWithTag(2, r100.entity)) + AIRoundInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.ai_last_round_infos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushMessageResponse r101) throws IOException {
            MessageItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.message_items);
            Entity.ADAPTER.encodeWithTag(r100, 2, r101.entity);
            AIRoundInfo.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.ai_last_round_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushMessageResponse r100 = new ProtoAdapter_PushMessageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_items = Internal.copyOf("message_items", this.message_items);
        r100.entity = this.entity;
        r100.ai_last_round_infos = Internal.copyOf("ai_last_round_infos", this.ai_last_round_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushMessageResponse(List<MessageItem> r100, Entity r101, List<AIRoundInfo> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushMessageResponse(List<MessageItem> r100, Entity r101, List<AIRoundInfo> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_items = Internal.immutableCopyOf("message_items", r100);
        this.entity = r101;
        this.ai_last_round_infos = Internal.immutableCopyOf("ai_last_round_infos", r102);
    }
}
