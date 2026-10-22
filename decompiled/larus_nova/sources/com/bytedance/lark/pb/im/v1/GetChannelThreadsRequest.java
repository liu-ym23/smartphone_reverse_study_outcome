package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Channel;
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
public final class GetChannelThreadsRequest extends Message<GetChannelThreadsRequest, Builder> {
    public static final ProtoAdapter<GetChannelThreadsRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_NEED_REPLY_PROMPT = null;
    public static final Boolean DEFAULT_NEED_RESPONSE = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_PRELOAD_COUNT = null;
    public static final Integer DEFAULT_REDUNDANCY_COUNT = null;
    public static final Integer DEFAULT_REDUNDANCY_WEIGHTS_FOR_FILTER = null;
    public static final ChannelDataScene DEFAULT_SCENE = null;
    public static final ChannelDataIncompleteStrategy DEFAULT_STRATEGY = null;
    public static final Integer DEFAULT_WEIGHTS_FOR_FILTER = null;
    public static final ProtoAdapter_GetChannelThreadsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final Integer count;
    public final MessageWeight message_weight;
    public final Boolean need_reply_prompt;
    public final Boolean need_response;
    public final Integer position;
    public final Integer preload_count;
    public final Integer redundancy_count;
    public final Integer redundancy_weights_for_filter;
    public final ChannelDataScene scene;
    public final ChannelDataIncompleteStrategy strategy;
    public final Integer weights_for_filter;

    public static final class Builder extends Message.Builder<GetChannelThreadsRequest, Builder> implements d<GetChannelThreadsRequest> {
        public Channel channel;
        public Integer count;
        public MessageWeight message_weight;
        public Boolean need_reply_prompt;
        public Boolean need_response;
        public Integer position;
        public Integer preload_count;
        public Integer redundancy_count;
        public Integer redundancy_weights_for_filter;
        public ChannelDataScene scene;
        public ChannelDataIncompleteStrategy strategy;
        public Integer weights_for_filter;

        @Override // com.squareup.wire.Message.Builder
        public GetChannelThreadsRequest build() {
            Channel r100 = this.channel;
            if (r100 == null) goto L7;
            return new GetChannelThreadsRequest(this.channel, this.scene, this.redundancy_count, this.position, this.count, this.strategy, this.preload_count, this.need_response, this.weights_for_filter, this.redundancy_weights_for_filter, this.need_reply_prompt, this.message_weight, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
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

        public Builder need_reply_prompt(Boolean r100) {
            this.need_reply_prompt = r100;
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

        public Builder weights_for_filter(Integer r100) {
            this.weights_for_filter = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChannelThreadsRequest extends ProtoAdapter<GetChannelThreadsRequest> implements c<GetChannelThreadsRequest> {
        public ProtoAdapter_GetChannelThreadsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChannelThreadsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChannelThreadsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = ChannelDataScene.FIRST_SCREEN;
            r101.redundancy_count = 5;
            r101.position = 0;
            r101.count = 20;
            r101.strategy = ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
            r101.preload_count = 30;
            r101.need_response = Boolean.TRUE;
            r101.weights_for_filter = 0;
            r101.redundancy_weights_for_filter = 0;
            r101.need_reply_prompt = Boolean.FALSE;
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
            r101.need_reply_prompt = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.redundancy_weights_for_filter = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.weights_for_filter = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.need_response = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.preload_count = ProtoAdapter.INT32.decode(r100);
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
            r101.channel = Channel.ADAPTER.decode(r100);
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
        public int encodedSize2(GetChannelThreadsRequest r100) {
            int r101 = Channel.ADAPTER.encodedSizeWithTag(1, r100.channel);
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
            Integer r118 = r100.preload_count;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.INT32.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            Boolean r121 = r100.need_response;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r121);
        L30:
            int r123 = r120 + r122;
            Integer r124 = r100.weights_for_filter;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.INT32.encodedSizeWithTag(9, r124);
        L34:
            int r126 = r123 + r125;
            Integer r127 = r100.redundancy_weights_for_filter;
            if (r127 == null) goto L37;
            int r128 = ProtoAdapter.INT32.encodedSizeWithTag(10, r127);
        L38:
            int r129 = r126 + r128;
            Boolean r130 = r100.need_reply_prompt;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r130);
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
        public /* bridge */ /* synthetic */ GetChannelThreadsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChannelThreadsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChannelThreadsRequest r101) throws IOException {
            Channel.ADAPTER.encodeWithTag(r100, 1, r101.channel);
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
            Integer r107 = r101.preload_count;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
        L20:
            Boolean r108 = r101.need_response;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L23:
            Integer r109 = r101.weights_for_filter;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r109);
        L26:
            Integer r110 = r101.redundancy_weights_for_filter;
            if (r110 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r110);
        L29:
            Boolean r111 = r101.need_reply_prompt;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L32:
            MessageWeight r112 = r101.message_weight;
            if (r112 == null) goto L35;
            MessageWeight.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChannelThreadsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChannelThreadsRequest r100 = new ProtoAdapter_GetChannelThreadsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = ChannelDataScene.FIRST_SCREEN;
        DEFAULT_REDUNDANCY_COUNT = 5;
        DEFAULT_POSITION = 0;
        DEFAULT_COUNT = 20;
        DEFAULT_STRATEGY = ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
        DEFAULT_PRELOAD_COUNT = 30;
        DEFAULT_NEED_RESPONSE = Boolean.TRUE;
        DEFAULT_WEIGHTS_FOR_FILTER = 0;
        DEFAULT_REDUNDANCY_WEIGHTS_FOR_FILTER = 0;
        DEFAULT_NEED_REPLY_PROMPT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel = this.channel;
        r100.scene = this.scene;
        r100.redundancy_count = this.redundancy_count;
        r100.position = this.position;
        r100.count = this.count;
        r100.strategy = this.strategy;
        r100.preload_count = this.preload_count;
        r100.need_response = this.need_response;
        r100.weights_for_filter = this.weights_for_filter;
        r100.redundancy_weights_for_filter = this.redundancy_weights_for_filter;
        r100.need_reply_prompt = this.need_reply_prompt;
        r100.message_weight = this.message_weight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChannelThreadsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChannelThreadsRequest(Channel r110, ChannelDataScene r111, Integer r112, Integer r113, Integer r114, ChannelDataIncompleteStrategy r210, Integer r211, Boolean r212, Integer r213, Integer r214, Boolean r215, MessageWeight r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public GetChannelThreadsRequest(Channel r100, ChannelDataScene r101, Integer r102, Integer r103, Integer r104, ChannelDataIncompleteStrategy r105, Integer r106, Boolean r107, Integer r110, Integer r111, Boolean r112, MessageWeight r113, ByteString r114) {
        super(ADAPTER, r114);
        this.channel = r100;
        this.scene = r101;
        this.redundancy_count = r102;
        this.position = r103;
        this.count = r104;
        this.strategy = r105;
        this.preload_count = r106;
        this.need_response = r107;
        this.weights_for_filter = r110;
        this.redundancy_weights_for_filter = r111;
        this.need_reply_prompt = r112;
        this.message_weight = r113;
    }
}
