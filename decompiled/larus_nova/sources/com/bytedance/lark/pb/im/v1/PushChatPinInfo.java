package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushChatPinInfo extends Message<PushChatPinInfo, Builder> {
    public static final ProtoAdapter<PushChatPinInfo> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_VERSION = null;
    public static final ProtoAdapter_PushChatPinInfo RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final Entity entity;
    public final List<ChatPinInfo> infos;
    public final Long version;

    public static final class Builder extends Message.Builder<PushChatPinInfo, Builder> implements d<PushChatPinInfo> {
        public Long chat_id;
        public Entity entity;
        public List<ChatPinInfo> infos;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public PushChatPinInfo build() {
            return new PushChatPinInfo(this.infos, this.chat_id, this.version, this.entity, super.buildUnknownFields());
        }

        public Builder() {
            this.infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder infos(List<ChatPinInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.infos = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushChatPinInfo extends ProtoAdapter<PushChatPinInfo> implements c<PushChatPinInfo> {
        public ProtoAdapter_PushChatPinInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PushChatPinInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushChatPinInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            if (r103 != 1) goto L7;
            r101.infos.add(ChatPinInfo.ADAPTER.decode(r100));
            goto L3
        L7:
            switch(r103) {
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                default: goto L8;
            };
        L9:
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushChatPinInfo r100) {
            int r101 = ChatPinInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.infos);
            Long r102 = r100.chat_id;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(11, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.version;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT64.encodedSizeWithTag(12, r106);
        L10:
            int r108 = r105 + r107;
            Entity r109 = r100.entity;
            if (r109 == null) goto L14;
            r103 = Entity.ADAPTER.encodedSizeWithTag(13, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushChatPinInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushChatPinInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushChatPinInfo r101) throws IOException {
            ChatPinInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.infos);
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r102);
        L5:
            Long r103 = r101.version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r103);
        L8:
            Entity r104 = r101.entity;
            if (r104 == null) goto L11;
            Entity.ADAPTER.encodeWithTag(r100, 13, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushChatPinInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushChatPinInfo r100 = new ProtoAdapter_PushChatPinInfo();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.infos = Internal.copyOf("infos", this.infos);
        r100.chat_id = this.chat_id;
        r100.version = this.version;
        r100.entity = this.entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushChatPinInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushChatPinInfo(List<ChatPinInfo> r100, Long r101, Long r102, Entity r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushChatPinInfo(List<ChatPinInfo> r100, Long r101, Long r102, Entity r103, ByteString r104) {
        super(ADAPTER, r104);
        this.infos = Internal.immutableCopyOf("infos", r100);
        this.chat_id = r101;
        this.version = r102;
        this.entity = r103;
    }
}
