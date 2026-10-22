package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.AvatarMeta;
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
public final class GetChatAvatarMetaResponse extends Message<GetChatAvatarMetaResponse, Builder> {
    public static final ProtoAdapter<GetChatAvatarMetaResponse> ADAPTER = null;
    public static final ProtoAdapter_GetChatAvatarMetaResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AvatarMeta avatar_meta;

    public static final class Builder extends Message.Builder<GetChatAvatarMetaResponse, Builder> implements d<GetChatAvatarMetaResponse> {
        public AvatarMeta avatar_meta;

        @Override // com.squareup.wire.Message.Builder
        public GetChatAvatarMetaResponse build() {
            AvatarMeta r100 = this.avatar_meta;
            if (r100 == null) goto L7;
            return new GetChatAvatarMetaResponse(this.avatar_meta, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "avatar_meta"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_meta(AvatarMeta r100) {
            this.avatar_meta = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatAvatarMetaResponse extends ProtoAdapter<GetChatAvatarMetaResponse> implements c<GetChatAvatarMetaResponse> {
        public ProtoAdapter_GetChatAvatarMetaResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatAvatarMetaResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatAvatarMetaResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.avatar_meta = AvatarMeta.ADAPTER.decode(r100);
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
        public int encodedSize2(GetChatAvatarMetaResponse r100) {
            return AvatarMeta.ADAPTER.encodedSizeWithTag(1, r100.avatar_meta) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatAvatarMetaResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatAvatarMetaResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatAvatarMetaResponse r101) throws IOException {
            AvatarMeta.ADAPTER.encodeWithTag(r100, 1, r101.avatar_meta);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatAvatarMetaResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatAvatarMetaResponse r100 = new ProtoAdapter_GetChatAvatarMetaResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.avatar_meta = this.avatar_meta;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatAvatarMetaResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatAvatarMetaResponse(AvatarMeta r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetChatAvatarMetaResponse(AvatarMeta r100, ByteString r101) {
        super(ADAPTER, r101);
        this.avatar_meta = r100;
    }
}
