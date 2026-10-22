package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SendHttpResponse extends com.squareup.wire.Message<SendHttpResponse, Builder> {
    public static final ProtoAdapter<SendHttpResponse> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final Integer DEFAULT_HTTP_STATUS_CODE = null;
    public static final String DEFAULT_JSON_BODY = "";
    public static final Status DEFAULT_STATUS = null;
    public static final String DEFAULT_UNKNOWN_ERROR = "";
    public static final ProtoAdapter_SendHttpResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final Map<String, String> headers;
    public final Integer http_status_code;
    public final String json_body;
    public final Status status;
    public final String unknown_error;

    public static final class Builder extends com.squareup.wire.Message.Builder<SendHttpResponse, Builder> implements b<SendHttpResponse> {
        public ByteString body;
        public Map<String, String> headers;
        public Integer http_status_code;
        public String json_body;
        public Status status;
        public String unknown_error;

        @Override // com.squareup.wire.Message.Builder
        public SendHttpResponse build() {
            Status r100 = this.status;
            if (r100 == null) goto L7;
            return new SendHttpResponse(this.status, this.headers, this.http_status_code, this.body, this.unknown_error, this.json_body, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "status"});
        }

        public Builder() {
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder http_status_code(Integer r100) {
            this.http_status_code = r100;
            return this;
        }

        public Builder json_body(String r100) {
            this.json_body = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder unknown_error(String r100) {
            this.unknown_error = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendHttpResponse extends ProtoAdapter<SendHttpResponse> implements a<SendHttpResponse> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_SendHttpResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendHttpResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendHttpResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = Status.Normal;
            r101.http_status_code = 0;
            r101.body = ByteString.EMPTY;
            r101.unknown_error = "";
            r101.json_body = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.http_status_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.unknown_error = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            if (r103 != 1001) goto L17;
            r101.json_body = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendHttpResponse r100) {
            int r101 = Status.ADAPTER.encodedSizeWithTag(1, r100.status) + this.headers.encodedSizeWithTag(2, r100.headers);
            Integer r102 = r100.http_status_code;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            ByteString r106 = r100.body;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.unknown_error;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.json_body;
            if (r112 == null) goto L18;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(1001, r112);
        L18:
            return (r111 + r103) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendHttpResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendHttpResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendHttpResponse r101) throws IOException {
            Status.ADAPTER.encodeWithTag(r100, 1, r101.status);
            this.headers.encodeWithTag(r100, 2, r101.headers);
            Integer r102 = r101.http_status_code;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r102);
        L5:
            ByteString r103 = r101.body;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r103);
        L8:
            String r104 = r101.unknown_error;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L11:
            String r105 = r101.json_body;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 1001, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendHttpResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status Normal = null;
        public static final Status Timeout = null;
        public static final Status UnknownError = null;
        private final int value;

        static {
            Status r100 = new Status("Normal", 0, 1);
            Normal = r100;
            Status r101 = new Status("Timeout", 1, 2);
            Timeout = r101;
            Status r102 = new Status("UnknownError", 2, 3);
            UnknownError = r102;
            $VALUES = new Status[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return UnknownError;
        L13:
            return Timeout;
        L15:
            return Normal;
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_SendHttpResponse r100 = new ProtoAdapter_SendHttpResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = Status.Normal;
        DEFAULT_HTTP_STATUS_CODE = 0;
        DEFAULT_BODY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.http_status_code = this.http_status_code;
        r100.body = this.body;
        r100.unknown_error = this.unknown_error;
        r100.json_body = this.json_body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendHttpResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendHttpResponse(Status r100, Map<String, String> r110, Integer r111, ByteString r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SendHttpResponse(Status r100, Map<String, String> r101, Integer r102, ByteString r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.status = r100;
        this.headers = Internal.immutableCopyOf("headers", r101);
        this.http_status_code = r102;
        this.body = r103;
        this.unknown_error = r104;
        this.json_body = r105;
    }
}
