package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatPinInfo extends Message<ChatPinInfo, Builder> {
    public static final ProtoAdapter<ChatPinInfo> ADAPTER = null;
    public static final Long DEFAULT_CHATTER_ID = null;
    public static final Long DEFAULT_MESSAGE_ID = null;
    public static final Long DEFAULT_PIN_ID = null;
    public static final UniversalChatPin.Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long chatter_id;
    public final Long message_id;
    public final Long pin_id;
    public final UniversalChatPin.Type type;

    public static final class Builder extends Message.Builder<ChatPinInfo, Builder> {
        public Long chatter_id;
        public Long message_id;
        public Long pin_id;
        public UniversalChatPin.Type type;

        @Override // com.squareup.wire.Message.Builder
        public ChatPinInfo build() {
            return new ChatPinInfo(this.pin_id, this.type, this.chatter_id, this.message_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_id(Long r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder message_id(Long r100) {
            this.message_id = r100;
            return this;
        }

        public Builder pin_id(Long r100) {
            this.pin_id = r100;
            return this;
        }

        public Builder type(UniversalChatPin.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatPinInfo extends ProtoAdapter<ChatPinInfo> {
        public ProtoAdapter_ChatPinInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatPinInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatPinInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.pin_id = 0L;
            r101.type = UniversalChatPin.Type.UNKNOWN;
            r101.chatter_id = 0L;
            r101.message_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.pin_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = UniversalChatPin.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.chatter_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 10) goto L13;
            r101.message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatPinInfo r100) {
            Long r101 = r100.pin_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            UniversalChatPin.Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = UniversalChatPin.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.chatter_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.message_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ChatPinInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatPinInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatPinInfo r101) throws IOException {
            Long r102 = r101.pin_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            UniversalChatPin.Type r103 = r101.type;
            if (r103 == null) goto L8;
            UniversalChatPin.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.chatter_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.message_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatPinInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatPinInfo();
        DEFAULT_PIN_ID = 0L;
        DEFAULT_TYPE = UniversalChatPin.Type.UNKNOWN;
        DEFAULT_CHATTER_ID = 0L;
        DEFAULT_MESSAGE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pin_id = this.pin_id;
        r100.type = this.type;
        r100.chatter_id = this.chatter_id;
        r100.message_id = this.message_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatPinInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatPinInfo(Long r100, UniversalChatPin.Type r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ChatPinInfo(Long r100, UniversalChatPin.Type r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.pin_id = r100;
        this.type = r101;
        this.chatter_id = r102;
        this.message_id = r103;
    }
}
