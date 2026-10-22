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
public final class GetChatQRCodeTokenResponse extends Message<GetChatQRCodeTokenResponse, Builder> {
    public static final ProtoAdapter<GetChatQRCodeTokenResponse> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GetChatQRCodeTokenResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long expire_time;
    public final Boolean is_unlimited;
    public final String token;
    public final String url;

    public static final class Builder extends Message.Builder<GetChatQRCodeTokenResponse, Builder> implements d<GetChatQRCodeTokenResponse> {
        public Long expire_time;
        public Boolean is_unlimited;
        public String token;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GetChatQRCodeTokenResponse build() {
            return new GetChatQRCodeTokenResponse(this.token, this.url, this.expire_time, this.is_unlimited, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder expire_time(Long r100) {
            this.expire_time = r100;
            return this;
        }

        public Builder is_unlimited(Boolean r100) {
            this.is_unlimited = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatQRCodeTokenResponse extends ProtoAdapter<GetChatQRCodeTokenResponse> implements c<GetChatQRCodeTokenResponse> {
        public ProtoAdapter_GetChatQRCodeTokenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatQRCodeTokenResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatQRCodeTokenResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.url = "";
            r101.expire_time = 0L;
            r101.is_unlimited = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.expire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.is_unlimited = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatQRCodeTokenResponse r100) {
            String r101 = r100.token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.expire_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_unlimited;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetChatQRCodeTokenResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatQRCodeTokenResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatQRCodeTokenResponse r101) throws IOException {
            String r102 = r101.token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.expire_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_unlimited;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatQRCodeTokenResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatQRCodeTokenResponse r100 = new ProtoAdapter_GetChatQRCodeTokenResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EXPIRE_TIME = 0L;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.url = this.url;
        r100.expire_time = this.expire_time;
        r100.is_unlimited = this.is_unlimited;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatQRCodeTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatQRCodeTokenResponse(String r100, String r101, Long r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetChatQRCodeTokenResponse(String r100, String r101, Long r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.token = r100;
        this.url = r101;
        this.expire_time = r102;
        this.is_unlimited = r103;
    }
}
