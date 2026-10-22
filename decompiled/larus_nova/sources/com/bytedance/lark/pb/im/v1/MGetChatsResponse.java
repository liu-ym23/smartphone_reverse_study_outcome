package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChatOptionInfo;
import com.bytedance.lark.pb.basic.v1.Entity;
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
public final class MGetChatsResponse extends Message<MGetChatsResponse, Builder> {
    public static final ProtoAdapter<MGetChatsResponse> ADAPTER = null;
    public static final ProtoAdapter_MGetChatsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ChatOptionInfo> chat_option_info;
    public final Entity entity;

    public static final class Builder extends Message.Builder<MGetChatsResponse, Builder> implements d<MGetChatsResponse> {
        public Map<String, ChatOptionInfo> chat_option_info;
        public Entity entity;

        @Override // com.squareup.wire.Message.Builder
        public MGetChatsResponse build() {
            Entity r100 = this.entity;
            if (r100 == null) goto L7;
            return new MGetChatsResponse(this.entity, this.chat_option_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "entity"});
        }

        public Builder() {
            this.chat_option_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_option_info(Map<String, ChatOptionInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_option_info = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetChatsResponse extends ProtoAdapter<MGetChatsResponse> implements c<MGetChatsResponse> {
        private final ProtoAdapter<Map<String, ChatOptionInfo>> chat_option_info;

        public ProtoAdapter_MGetChatsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetChatsResponse.class);
            this.chat_option_info = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ChatOptionInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetChatsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.chat_option_info.putAll(this.chat_option_info.decode(r100));
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
        public int encodedSize2(MGetChatsResponse r100) {
            return (Entity.ADAPTER.encodedSizeWithTag(1, r100.entity) + this.chat_option_info.encodedSizeWithTag(2, r100.chat_option_info)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetChatsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetChatsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetChatsResponse r101) throws IOException {
            Entity.ADAPTER.encodeWithTag(r100, 1, r101.entity);
            this.chat_option_info.encodeWithTag(r100, 2, r101.chat_option_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetChatsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetChatsResponse r100 = new ProtoAdapter_MGetChatsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity = this.entity;
        r100.chat_option_info = Internal.copyOf("chat_option_info", this.chat_option_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetChatsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetChatsResponse(Entity r100, Map<String, ChatOptionInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MGetChatsResponse(Entity r100, Map<String, ChatOptionInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.entity = r100;
        this.chat_option_info = Internal.immutableCopyOf("chat_option_info", r101);
    }
}
