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
public final class GetChatPinInfoResponse extends Message<GetChatPinInfoResponse, Builder> {
    public static final ProtoAdapter<GetChatPinInfoResponse> ADAPTER = null;
    public static final Long DEFAULT_VERSION = null;
    public static final ProtoAdapter_GetChatPinInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity entity;
    public final List<ChatPinInfo> infos;
    public final Long version;

    public static final class Builder extends Message.Builder<GetChatPinInfoResponse, Builder> implements d<GetChatPinInfoResponse> {
        public Entity entity;
        public List<ChatPinInfo> infos;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public GetChatPinInfoResponse build() {
            return new GetChatPinInfoResponse(this.version, this.infos, this.entity, super.buildUnknownFields());
        }

        public Builder() {
            this.infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
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

    public static final class ProtoAdapter_GetChatPinInfoResponse extends ProtoAdapter<GetChatPinInfoResponse> implements c<GetChatPinInfoResponse> {
        public ProtoAdapter_GetChatPinInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatPinInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatPinInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.infos.add(ChatPinInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 11) goto L11;
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatPinInfoResponse r100) {
            Long r101 = r100.version;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ChatPinInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.infos);
            Entity r105 = r100.entity;
            if (r105 == null) goto L10;
            r102 = Entity.ADAPTER.encodedSizeWithTag(11, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatPinInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatPinInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatPinInfoResponse r101) throws IOException {
            Long r102 = r101.version;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ChatPinInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.infos);
            Entity r103 = r101.entity;
            if (r103 == null) goto L8;
            Entity.ADAPTER.encodeWithTag(r100, 11, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatPinInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatPinInfoResponse r100 = new ProtoAdapter_GetChatPinInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.infos = Internal.copyOf("infos", this.infos);
        r100.entity = this.entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatPinInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatPinInfoResponse(Long r100, List<ChatPinInfo> r101, Entity r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetChatPinInfoResponse(Long r100, List<ChatPinInfo> r101, Entity r102, ByteString r103) {
        super(ADAPTER, r103);
        this.version = r100;
        this.infos = Internal.immutableCopyOf("infos", r101);
        this.entity = r102;
    }
}
