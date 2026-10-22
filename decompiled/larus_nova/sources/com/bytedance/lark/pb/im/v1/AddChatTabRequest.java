package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class AddChatTabRequest extends Message<AddChatTabRequest, Builder> {
    public static final ProtoAdapter<AddChatTabRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_NAME = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_JSON = "";
    public static final ChatTab.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_AddChatTabRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final String name;
    public final ByteString payload;
    public final String payload_json;
    public final ChatTab.Type type;

    public static final class Builder extends Message.Builder<AddChatTabRequest, Builder> implements d<AddChatTabRequest> {
        public Long chat_id;
        public String name;
        public ByteString payload;
        public String payload_json;
        public ChatTab.Type type;

        @Override // com.squareup.wire.Message.Builder
        public AddChatTabRequest build() {
            return new AddChatTabRequest(this.chat_id, this.type, this.name, this.payload, this.payload_json, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder payload_json(String r100) {
            this.payload_json = r100;
            return this;
        }

        public Builder type(ChatTab.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AddChatTabRequest extends ProtoAdapter<AddChatTabRequest> implements c<AddChatTabRequest> {
        public ProtoAdapter_AddChatTabRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, AddChatTabRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AddChatTabRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.type = ChatTab.Type.Unknown;
            r101.name = "";
            r101.payload = ByteString.EMPTY;
            r101.payload_json = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = ChatTab.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.payload_json = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AddChatTabRequest r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ChatTab.Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = ChatTab.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ByteString r110 = r100.payload;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.payload_json;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ AddChatTabRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AddChatTabRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AddChatTabRequest r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ChatTab.Type r103 = r101.type;
            if (r103 == null) goto L8;
            ChatTab.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ByteString r105 = r101.payload;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.payload_json;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddChatTabRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AddChatTabRequest r100 = new ProtoAdapter_AddChatTabRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_TYPE = ChatTab.Type.Unknown;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.type = this.type;
        r100.name = this.name;
        r100.payload = this.payload;
        r100.payload_json = this.payload_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AddChatTabRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AddChatTabRequest(Long r100, ChatTab.Type r101, String r110, ByteString r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AddChatTabRequest(Long r100, ChatTab.Type r101, String r102, ByteString r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.chat_id = r100;
        this.type = r101;
        this.name = r102;
        this.payload = r103;
        this.payload_json = r104;
    }
}
