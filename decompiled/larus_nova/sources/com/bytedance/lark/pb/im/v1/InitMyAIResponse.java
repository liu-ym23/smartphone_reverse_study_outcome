package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Chat;
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
public final class InitMyAIResponse extends Message<InitMyAIResponse, Builder> {
    public static final ProtoAdapter<InitMyAIResponse> ADAPTER = null;
    public static final Long DEFAULT_SHADOW_ID = null;
    public static final ProtoAdapter_InitMyAIResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Chat chat;
    public final Long shadow_id;

    public static final class Builder extends Message.Builder<InitMyAIResponse, Builder> implements d<InitMyAIResponse> {
        public Chat chat;
        public Long shadow_id;

        @Override // com.squareup.wire.Message.Builder
        public InitMyAIResponse build() {
            return new InitMyAIResponse(this.shadow_id, this.chat, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat(Chat r100) {
            this.chat = r100;
            return this;
        }

        public Builder shadow_id(Long r100) {
            this.shadow_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InitMyAIResponse extends ProtoAdapter<InitMyAIResponse> implements c<InitMyAIResponse> {
        public ProtoAdapter_InitMyAIResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, InitMyAIResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InitMyAIResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.shadow_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.shadow_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.chat = Chat.ADAPTER.decode(r100);
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
        public int encodedSize2(InitMyAIResponse r100) {
            Long r101 = r100.shadow_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Chat r104 = r100.chat;
            if (r104 == null) goto L10;
            r102 = Chat.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InitMyAIResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InitMyAIResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InitMyAIResponse r101) throws IOException {
            Long r102 = r101.shadow_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Chat r103 = r101.chat;
            if (r103 == null) goto L8;
            Chat.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InitMyAIResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_InitMyAIResponse r100 = new ProtoAdapter_InitMyAIResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SHADOW_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.shadow_id = this.shadow_id;
        r100.chat = this.chat;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InitMyAIResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InitMyAIResponse(Long r100, Chat r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public InitMyAIResponse(Long r100, Chat r101, ByteString r102) {
        super(ADAPTER, r102);
        this.shadow_id = r100;
        this.chat = r101;
    }
}
