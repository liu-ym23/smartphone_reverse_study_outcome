package com.bytedance.lark.pb.contact.v1;

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
public final class GetDefaultAvatarResponse extends Message<GetDefaultAvatarResponse, Builder> {
    public static final ProtoAdapter<GetDefaultAvatarResponse> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_RESET_TOKEN = "";
    public static final ProtoAdapter_GetDefaultAvatarResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String default_avatar_key;
    public final String reset_token;

    public static final class Builder extends Message.Builder<GetDefaultAvatarResponse, Builder> implements d<GetDefaultAvatarResponse> {
        public String default_avatar_key;
        public String reset_token;

        @Override // com.squareup.wire.Message.Builder
        public GetDefaultAvatarResponse build() {
            String r100 = this.default_avatar_key;
            if (r100 == null) goto L9;
            if (this.reset_token == null) goto L9;
            return new GetDefaultAvatarResponse(this.default_avatar_key, this.reset_token, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "default_avatar_key", this.reset_token, "reset_token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder default_avatar_key(String r100) {
            this.default_avatar_key = r100;
            return this;
        }

        public Builder reset_token(String r100) {
            this.reset_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDefaultAvatarResponse extends ProtoAdapter<GetDefaultAvatarResponse> implements c<GetDefaultAvatarResponse> {
        public ProtoAdapter_GetDefaultAvatarResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDefaultAvatarResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDefaultAvatarResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_avatar_key = "";
            r101.reset_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.default_avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.reset_token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetDefaultAvatarResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.default_avatar_key) + r101.encodedSizeWithTag(2, r100.reset_token)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDefaultAvatarResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDefaultAvatarResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDefaultAvatarResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.default_avatar_key);
            r102.encodeWithTag(r100, 2, r101.reset_token);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDefaultAvatarResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDefaultAvatarResponse r100 = new ProtoAdapter_GetDefaultAvatarResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.default_avatar_key = this.default_avatar_key;
        r100.reset_token = this.reset_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDefaultAvatarResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDefaultAvatarResponse(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetDefaultAvatarResponse(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.default_avatar_key = r100;
        this.reset_token = r101;
    }
}
