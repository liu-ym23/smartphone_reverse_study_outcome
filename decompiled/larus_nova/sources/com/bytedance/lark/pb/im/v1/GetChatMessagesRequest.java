package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChannelDataIncompleteStrategy;
import com.bytedance.lark.pb.basic.v1.ChannelDataScene;
import com.bytedance.lark.pb.basic.v1.MessageWeight;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatMessagesRequest extends Message<GetChatMessagesRequest, Builder> {
    public static final ProtoAdapter<GetChatMessagesRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_NEED_RESPONSE = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_PRELOAD_COUNT = null;
    public static final Integer DEFAULT_REDUNDANCY_COUNT = null;
    public static final Integer DEFAULT_REDUNDANCY_WEIGHTS_FOR_FILTER = null;
    public static final ChannelDataScene DEFAULT_SCENE = null;
    public static final ChannelDataIncompleteStrategy DEFAULT_STRATEGY = null;
    public static final Boolean DEFAULT_SUBSCRIB_CHAT_EVENT = null;
    public static final Integer DEFAULT_WEIGHTS_FOR_FILTER = null;
    public static final ProtoAdapter_GetChatMessagesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer count;
    public final MessageWeight message_weight;
    public final Boolean need_response;
    public final Integer position;
    public final Integer preload_count;
    public final Integer redundancy_count;
    public final Integer redundancy_weights_for_filter;
    public final ChannelDataScene scene;
    public final ChannelDataIncompleteStrategy strategy;
    public final Boolean subscrib_chat_event;
    public final Integer weights_for_filter;

    public static final class Builder extends Message.Builder<GetChatMessagesRequest, Builder> implements d<GetChatMessagesRequest> {
        public String chat_id;
        public Integer count;
        public MessageWeight message_weight;
        public Boolean need_response;
        public Integer position;
        public Integer preload_count;
        public Integer redundancy_count;
        public Integer redundancy_weights_for_filter;
        public ChannelDataScene scene;
        public ChannelDataIncompleteStrategy strategy;
        public Boolean subscrib_chat_event;
        public Integer weights_for_filter;

        @Override // com.squareup.wire.Message.Builder
        public GetChatMessagesRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new GetChatMessagesRequest(this.chat_id, this.scene, this.redundancy_count, this.position, this.count, this.strategy, this.subscrib_chat_event, this.preload_count, this.need_response, this.weights_for_filter, this.redundancy_weights_for_filter, this.message_weight, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder message_weight(MessageWeight r100) {
            this.message_weight = r100;
            return this;
        }

        public Builder need_response(Boolean r100) {
            this.need_response = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder preload_count(Integer r100) {
            this.preload_count = r100;
            return this;
        }

        public Builder redundancy_count(Integer r100) {
            this.redundancy_count = r100;
            return this;
        }

        public Builder redundancy_weights_for_filter(Integer r100) {
            this.redundancy_weights_for_filter = r100;
            return this;
        }

        public Builder scene(ChannelDataScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder strategy(ChannelDataIncompleteStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder subscrib_chat_event(Boolean r100) {
            this.subscrib_chat_event = r100;
            return this;
        }

        public Builder weights_for_filter(Integer r100) {
            this.weights_for_filter = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatMessagesRequest extends ProtoAdapter<GetChatMessagesRequest> implements c<GetChatMessagesRequest> {
        public ProtoAdapter_GetChatMessagesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatMessagesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatMessagesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.scene = ChannelDataScene.FIRST_SCREEN;
            r101.redundancy_count = 5;
            r101.position = 0;
            r101.count = 20;
            r101.strategy = ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
            r101.subscrib_chat_event = Boolean.FALSE;
            r101.preload_count = 30;
            r101.need_response = Boolean.TRUE;
            r101.weights_for_filter = 0;
            r101.redundancy_weights_for_filter = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L25;
            switch(r103) {
                case 1: goto L24;
                case 2: goto L27;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L29;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L27:
            r101.scene = ChannelDataScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.strategy = ChannelDataIncompleteStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.message_weight = MessageWeight.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.redundancy_weights_for_filter = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.weights_for_filter = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.need_response = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.preload_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.subscrib_chat_event = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.redundancy_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L24:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatMessagesRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id);
            ChannelDataScene r102 = r100.scene;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ChannelDataScene.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.redundancy_count;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.position;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Integer r112 = r100.count;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.INT32.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            ChannelDataIncompleteStrategy r115 = r100.strategy;
            if (r115 == null) goto L21;
            int r116 = ChannelDataIncompleteStrategy.ADAPTER.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.subscrib_chat_event;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            Integer r121 = r100.preload_count;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.INT32.encodedSizeWithTag(8, r121);
        L30:
            int r123 = r120 + r122;
            Boolean r124 = r100.need_response;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r124);
        L34:
            int r126 = r123 + r125;
            Integer r127 = r100.weights_for_filter;
            if (r127 == null) goto L37;
            int r128 = ProtoAdapter.INT32.encodedSizeWithTag(10, r127);
        L38:
            int r129 = r126 + r128;
            Integer r130 = r100.redundancy_weights_for_filter;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.INT32.encodedSizeWithTag(11, r130);
        L42:
            int r132 = r129 + r131;
            MessageWeight r133 = r100.message_weight;
            if (r133 == null) goto L46;
            r103 = MessageWeight.ADAPTER.encodedSizeWithTag(12, r133);
        L46:
            return (r132 + r103) + r100.unknownFields().size();
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ GetChatMessagesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatMessagesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatMessagesRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            ChannelDataScene r102 = r101.scene;
            if (r102 == null) goto L5;
            ChannelDataScene.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.redundancy_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.position;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            Integer r105 = r101.count;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L14:
            ChannelDataIncompleteStrategy r106 = r101.strategy;
            if (r106 == null) goto L17;
            ChannelDataIncompleteStrategy.ADAPTER.encodeWithTag(r100, 6, r106);
        L17:
            Boolean r107 = r101.subscrib_chat_event;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L20:
            Integer r108 = r101.preload_count;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r108);
        L23:
            Boolean r109 = r101.need_response;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
        L26:
            Integer r110 = r101.weights_for_filter;
            if (r110 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r110);
        L29:
            Integer r111 = r101.redundancy_weights_for_filter;
            if (r111 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r111);
        L32:
            MessageWeight r112 = r101.message_weight;
            if (r112 == null) goto L35;
            MessageWeight.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatMessagesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatMessagesRequest r100 = new ProtoAdapter_GetChatMessagesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = ChannelDataScene.FIRST_SCREEN;
        DEFAULT_REDUNDANCY_COUNT = 5;
        DEFAULT_POSITION = 0;
        DEFAULT_COUNT = 20;
        DEFAULT_STRATEGY = ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
        DEFAULT_SUBSCRIB_CHAT_EVENT = Boolean.FALSE;
        DEFAULT_PRELOAD_COUNT = 30;
        DEFAULT_NEED_RESPONSE = Boolean.TRUE;
        DEFAULT_WEIGHTS_FOR_FILTER = 0;
        DEFAULT_REDUNDANCY_WEIGHTS_FOR_FILTER = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.scene = this.scene;
        r100.redundancy_count = this.redundancy_count;
        r100.position = this.position;
        r100.count = this.count;
        r100.strategy = this.strategy;
        r100.subscrib_chat_event = this.subscrib_chat_event;
        r100.preload_count = this.preload_count;
        r100.need_response = this.need_response;
        r100.weights_for_filter = this.weights_for_filter;
        r100.redundancy_weights_for_filter = this.redundancy_weights_for_filter;
        r100.message_weight = this.message_weight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatMessagesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatMessagesRequest(String r110, ChannelDataScene r111, Integer r112, Integer r113, Integer r114, ChannelDataIncompleteStrategy r210, Boolean r211, Integer r212, Boolean r213, Integer r214, Integer r215, MessageWeight r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public GetChatMessagesRequest(String r100, ChannelDataScene r101, Integer r102, Integer r103, Integer r104, ChannelDataIncompleteStrategy r105, Boolean r106, Integer r107, Boolean r110, Integer r111, Integer r112, MessageWeight r113, ByteString r114) {
        super(ADAPTER, r114);
        this.chat_id = r100;
        this.scene = r101;
        this.redundancy_count = r102;
        this.position = r103;
        this.count = r104;
        this.strategy = r105;
        this.subscrib_chat_event = r106;
        this.preload_count = r107;
        this.need_response = r110;
        this.weights_for_filter = r111;
        this.redundancy_weights_for_filter = r112;
        this.message_weight = r113;
    }
}
