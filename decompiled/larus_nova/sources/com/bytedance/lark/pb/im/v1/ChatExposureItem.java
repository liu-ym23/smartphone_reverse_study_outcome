package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatExposureItem extends Message<ChatExposureItem, Builder> {
    public static final ProtoAdapter<ChatExposureItem> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final ChatExposureScene DEFAULT_SCENE = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final ChatExposureScene scene;

    public static final class Builder extends Message.Builder<ChatExposureItem, Builder> {
        public Long chat_id;
        public ChatExposureScene scene;

        @Override // com.squareup.wire.Message.Builder
        public ChatExposureItem build() {
            return new ChatExposureItem(this.chat_id, this.scene, super.buildUnknownFields());
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

        public Builder scene(ChatExposureScene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatExposureItem extends ProtoAdapter<ChatExposureItem> {
        public ProtoAdapter_ChatExposureItem() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatExposureItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatExposureItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.scene = ChatExposureScene.Unkown;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene = ChatExposureScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(ChatExposureItem r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ChatExposureScene r104 = r100.scene;
            if (r104 == null) goto L10;
            r102 = ChatExposureScene.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatExposureItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatExposureItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatExposureItem r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ChatExposureScene r103 = r101.scene;
            if (r103 == null) goto L8;
            ChatExposureScene.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatExposureItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatExposureItem();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_SCENE = ChatExposureScene.Unkown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatExposureItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatExposureItem(Long r100, ChatExposureScene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ChatExposureItem(Long r100, ChatExposureScene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_id = r100;
        this.scene = r101;
    }
}
