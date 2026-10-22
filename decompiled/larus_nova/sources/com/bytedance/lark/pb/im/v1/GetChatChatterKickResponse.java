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
public final class GetChatChatterKickResponse extends Message<GetChatChatterKickResponse, Builder> {
    public static final ProtoAdapter<GetChatChatterKickResponse> ADAPTER = null;
    public static final ProtoAdapter_GetChatChatterKickResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChatChatterKickInfo chat_chatter_kick_info;

    public static final class Builder extends Message.Builder<GetChatChatterKickResponse, Builder> implements d<GetChatChatterKickResponse> {
        public ChatChatterKickInfo chat_chatter_kick_info;

        @Override // com.squareup.wire.Message.Builder
        public GetChatChatterKickResponse build() {
            return new GetChatChatterKickResponse(this.chat_chatter_kick_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_chatter_kick_info(ChatChatterKickInfo r100) {
            this.chat_chatter_kick_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatChatterKickResponse extends ProtoAdapter<GetChatChatterKickResponse> implements c<GetChatChatterKickResponse> {
        public ProtoAdapter_GetChatChatterKickResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatChatterKickResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatChatterKickResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chat_chatter_kick_info = ChatChatterKickInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(GetChatChatterKickResponse r100) {
            ChatChatterKickInfo r101 = r100.chat_chatter_kick_info;
            if (r101 == null) goto L5;
            int r102 = ChatChatterKickInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatChatterKickResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatChatterKickResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatChatterKickResponse r101) throws IOException {
            ChatChatterKickInfo r102 = r101.chat_chatter_kick_info;
            if (r102 == null) goto L5;
            ChatChatterKickInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatChatterKickResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatChatterKickResponse r100 = new ProtoAdapter_GetChatChatterKickResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_chatter_kick_info = this.chat_chatter_kick_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatChatterKickResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatChatterKickResponse(ChatChatterKickInfo r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetChatChatterKickResponse(ChatChatterKickInfo r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chat_chatter_kick_info = r100;
    }
}
