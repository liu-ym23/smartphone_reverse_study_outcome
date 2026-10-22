package com.bytedance.lark.pb.tool.v1;

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
public final class UserSendHttpResponse extends Message<UserSendHttpResponse, Builder> {
    public static final ProtoAdapter<UserSendHttpResponse> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final Integer DEFAULT_STATUS_CODE = null;
    public static final ProtoAdapter_UserSendHttpResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final HttpHeaderMap headers;
    public final Integer status_code;

    public static final class Builder extends Message.Builder<UserSendHttpResponse, Builder> implements d<UserSendHttpResponse> {
        public ByteString body;
        public HttpHeaderMap headers;
        public Integer status_code;

        @Override // com.squareup.wire.Message.Builder
        public UserSendHttpResponse build() {
            Integer r100 = this.status_code;
            if (r100 == null) goto L9;
            if (this.headers == null) goto L9;
            return new UserSendHttpResponse(this.status_code, this.headers, this.body, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "status_code", this.headers, "headers"});
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

        public Builder headers(HttpHeaderMap r100) {
            this.headers = r100;
            return this;
        }

        public Builder status_code(Integer r100) {
            this.status_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserSendHttpResponse extends ProtoAdapter<UserSendHttpResponse> implements c<UserSendHttpResponse> {
        public ProtoAdapter_UserSendHttpResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UserSendHttpResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserSendHttpResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status_code = 0;
            r101.body = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.status_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.headers = HttpHeaderMap.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.body = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(UserSendHttpResponse r100) {
            int r101 = ProtoAdapter.INT32.encodedSizeWithTag(1, r100.status_code) + HttpHeaderMap.ADAPTER.encodedSizeWithTag(2, r100.headers);
            ByteString r102 = r100.body;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserSendHttpResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserSendHttpResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserSendHttpResponse r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.status_code);
            HttpHeaderMap.ADAPTER.encodeWithTag(r100, 2, r101.headers);
            ByteString r102 = r101.body;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserSendHttpResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UserSendHttpResponse r100 = new ProtoAdapter_UserSendHttpResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS_CODE = 0;
        DEFAULT_BODY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status_code = this.status_code;
        r100.headers = this.headers;
        r100.body = this.body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserSendHttpResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserSendHttpResponse(Integer r100, HttpHeaderMap r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UserSendHttpResponse(Integer r100, HttpHeaderMap r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.status_code = r100;
        this.headers = r101;
        this.body = r102;
    }
}
