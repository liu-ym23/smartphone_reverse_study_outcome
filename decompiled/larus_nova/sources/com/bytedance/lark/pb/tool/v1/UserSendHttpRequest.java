package com.bytedance.lark.pb.tool.v1;

import com.alipay.sdk.m.p.e;
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
public final class UserSendHttpRequest extends Message<UserSendHttpRequest, Builder> {
    public static final ProtoAdapter<UserSendHttpRequest> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final Boolean DEFAULT_DISABLE_COOKIE = null;
    public static final String DEFAULT_DOWNLOAD_FILE_PATH = "";
    public static final HttpMethod DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_NO_FOLLOW_REDIRECTION = null;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final Integer DEFAULT_TIMEOUT_S = null;
    public static final String DEFAULT_UPLOAD_FILE_PATH = "";
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_UserSendHttpRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final Boolean disable_cookie;
    public final String download_file_path;
    public final HttpHeaderMap headers;
    public final HttpMethod method;
    public final Boolean no_follow_redirection;
    public final String request_id;
    public final Integer timeout_s;
    public final String upload_file_path;
    public final String url;

    public static final class Builder extends Message.Builder<UserSendHttpRequest, Builder> implements d<UserSendHttpRequest> {
        public ByteString body;
        public Boolean disable_cookie;
        public String download_file_path;
        public HttpHeaderMap headers;
        public HttpMethod method;
        public Boolean no_follow_redirection;
        public String request_id;
        public Integer timeout_s;
        public String upload_file_path;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public UserSendHttpRequest build() {
            String r100 = this.url;
            if (r100 == null) goto L11;
            if (this.method == null) goto L11;
            if (this.headers == null) goto L11;
            return new UserSendHttpRequest(this.url, this.method, this.headers, this.body, this.download_file_path, this.upload_file_path, this.request_id, this.timeout_s, this.no_follow_redirection, this.disable_cookie, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.method, e.f25671s, this.headers, "headers"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder disable_cookie(Boolean r100) {
            this.disable_cookie = r100;
            return this;
        }

        public Builder download_file_path(String r100) {
            this.download_file_path = r100;
            return this;
        }

        public Builder headers(HttpHeaderMap r100) {
            this.headers = r100;
            return this;
        }

        public Builder method(HttpMethod r100) {
            this.method = r100;
            return this;
        }

        public Builder no_follow_redirection(Boolean r100) {
            this.no_follow_redirection = r100;
            return this;
        }

        public Builder request_id(String r100) {
            this.request_id = r100;
            return this;
        }

        public Builder timeout_s(Integer r100) {
            this.timeout_s = r100;
            return this;
        }

        public Builder upload_file_path(String r100) {
            this.upload_file_path = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserSendHttpRequest extends ProtoAdapter<UserSendHttpRequest> implements c<UserSendHttpRequest> {
        public ProtoAdapter_UserSendHttpRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UserSendHttpRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserSendHttpRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.method = HttpMethod.GET;
            r101.body = ByteString.EMPTY;
            r101.download_file_path = "";
            r101.upload_file_path = "";
            r101.request_id = "";
            r101.timeout_s = 0;
            Boolean r102 = Boolean.FALSE;
            r101.no_follow_redirection = r102;
            r101.disable_cookie = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            switch(r104) {
                case 1: goto L19;
                case 2: goto L22;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.method = HttpMethod.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.disable_cookie = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.no_follow_redirection = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.timeout_s = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.request_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.upload_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.download_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            r101.headers = HttpHeaderMap.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserSendHttpRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.url) + HttpMethod.ADAPTER.encodedSizeWithTag(2, r100.method)) + HttpHeaderMap.ADAPTER.encodedSizeWithTag(3, r100.headers);
            ByteString r103 = r100.body;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.download_file_path;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.upload_file_path;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.request_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.timeout_s;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.no_follow_redirection;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            Boolean r122 = r100.disable_cookie;
            if (r122 == null) goto L30;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserSendHttpRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserSendHttpRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserSendHttpRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            HttpMethod.ADAPTER.encodeWithTag(r100, 2, r101.method);
            HttpHeaderMap.ADAPTER.encodeWithTag(r100, 3, r101.headers);
            ByteString r103 = r101.body;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.download_file_path;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.upload_file_path;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            String r106 = r101.request_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 7, r106);
        L14:
            Integer r107 = r101.timeout_s;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r107);
        L17:
            Boolean r108 = r101.no_follow_redirection;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r108);
        L20:
            Boolean r109 = r101.disable_cookie;
            if (r109 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserSendHttpRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UserSendHttpRequest r100 = new ProtoAdapter_UserSendHttpRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_METHOD = HttpMethod.GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_TIMEOUT_S = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NO_FOLLOW_REDIRECTION = r101;
        DEFAULT_DISABLE_COOKIE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.method = this.method;
        r100.headers = this.headers;
        r100.body = this.body;
        r100.download_file_path = this.download_file_path;
        r100.upload_file_path = this.upload_file_path;
        r100.request_id = this.request_id;
        r100.timeout_s = this.timeout_s;
        r100.no_follow_redirection = this.no_follow_redirection;
        r100.disable_cookie = this.disable_cookie;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserSendHttpRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserSendHttpRequest(String r110, HttpMethod r111, HttpHeaderMap r112, ByteString r113, String r114, String r115, String r116, Integer r210, Boolean r211, Boolean r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public UserSendHttpRequest(String r100, HttpMethod r101, HttpHeaderMap r102, ByteString r103, String r104, String r105, String r106, Integer r107, Boolean r110, Boolean r111, ByteString r112) {
        super(ADAPTER, r112);
        this.url = r100;
        this.method = r101;
        this.headers = r102;
        this.body = r103;
        this.download_file_path = r104;
        this.upload_file_path = r105;
        this.request_id = r106;
        this.timeout_s = r107;
        this.no_follow_redirection = r110;
        this.disable_cookie = r111;
    }
}
