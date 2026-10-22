package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetP2PChatsByChatterIdsResponse extends Message<GetP2PChatsByChatterIdsResponse, Builder> {
    public static final ProtoAdapter<GetP2PChatsByChatterIdsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetP2PChatsByChatterIdsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Chat> chatter_id2chat;

    public static final class Builder extends Message.Builder<GetP2PChatsByChatterIdsResponse, Builder> implements d<GetP2PChatsByChatterIdsResponse> {
        public Map<String, Chat> chatter_id2chat;

        @Override // com.squareup.wire.Message.Builder
        public GetP2PChatsByChatterIdsResponse build() {
            return new GetP2PChatsByChatterIdsResponse(this.chatter_id2chat, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_id2chat = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_id2chat(Map<String, Chat> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_id2chat = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetP2PChatsByChatterIdsResponse extends ProtoAdapter<GetP2PChatsByChatterIdsResponse> implements c<GetP2PChatsByChatterIdsResponse> {
        private final ProtoAdapter<Map<String, Chat>> chatter_id2chat;

        public ProtoAdapter_GetP2PChatsByChatterIdsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetP2PChatsByChatterIdsResponse.class);
            this.chatter_id2chat = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Chat.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetP2PChatsByChatterIdsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chatter_id2chat.putAll(this.chatter_id2chat.decode(r100));
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
        public int encodedSize2(GetP2PChatsByChatterIdsResponse r100) {
            return this.chatter_id2chat.encodedSizeWithTag(1, r100.chatter_id2chat) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetP2PChatsByChatterIdsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetP2PChatsByChatterIdsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetP2PChatsByChatterIdsResponse r101) throws IOException {
            this.chatter_id2chat.encodeWithTag(r100, 1, r101.chatter_id2chat);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetP2PChatsByChatterIdsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetP2PChatsByChatterIdsResponse r100 = new ProtoAdapter_GetP2PChatsByChatterIdsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_id2chat = Internal.copyOf("chatter_id2chat", this.chatter_id2chat);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetP2PChatsByChatterIdsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetP2PChatsByChatterIdsResponse(Map<String, Chat> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetP2PChatsByChatterIdsResponse(Map<String, Chat> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chatter_id2chat = Internal.immutableCopyOf("chatter_id2chat", r100);
    }
}
