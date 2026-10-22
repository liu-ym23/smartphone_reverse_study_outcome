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
public final class GetChatLinkTokenResponse extends Message<GetChatLinkTokenResponse, Builder> {
    public static final ProtoAdapter<GetChatLinkTokenResponse> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final String DEFAULT_PASTE_TEXT = "";
    public static final String DEFAULT_SHARED_URL = "";
    public static final String DEFAULT_SHARE_TOKEN = "";
    public static final ProtoAdapter_GetChatLinkTokenResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long expire_time;
    public final String paste_text;
    public final String share_token;
    public final String shared_url;

    public static final class Builder extends Message.Builder<GetChatLinkTokenResponse, Builder> implements d<GetChatLinkTokenResponse> {
        public Long expire_time;
        public String paste_text;
        public String share_token;
        public String shared_url;

        @Override // com.squareup.wire.Message.Builder
        public GetChatLinkTokenResponse build() {
            return new GetChatLinkTokenResponse(this.share_token, this.expire_time, this.shared_url, this.paste_text, super.buildUnknownFields());
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

        public Builder paste_text(String r100) {
            this.paste_text = r100;
            return this;
        }

        public Builder share_token(String r100) {
            this.share_token = r100;
            return this;
        }

        public Builder shared_url(String r100) {
            this.shared_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatLinkTokenResponse extends ProtoAdapter<GetChatLinkTokenResponse> implements c<GetChatLinkTokenResponse> {
        public ProtoAdapter_GetChatLinkTokenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatLinkTokenResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatLinkTokenResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.share_token = "";
            r101.expire_time = 0L;
            r101.shared_url = "";
            r101.paste_text = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.share_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.expire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.shared_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.paste_text = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetChatLinkTokenResponse r100) {
            String r101 = r100.share_token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.expire_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.shared_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.paste_text;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ GetChatLinkTokenResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatLinkTokenResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatLinkTokenResponse r101) throws IOException {
            String r102 = r101.share_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.expire_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.shared_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.paste_text;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatLinkTokenResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatLinkTokenResponse r100 = new ProtoAdapter_GetChatLinkTokenResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EXPIRE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.share_token = this.share_token;
        r100.expire_time = this.expire_time;
        r100.shared_url = this.shared_url;
        r100.paste_text = this.paste_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatLinkTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatLinkTokenResponse(String r100, Long r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetChatLinkTokenResponse(String r100, Long r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.share_token = r100;
        this.expire_time = r101;
        this.shared_url = r102;
        this.paste_text = r103;
    }
}
