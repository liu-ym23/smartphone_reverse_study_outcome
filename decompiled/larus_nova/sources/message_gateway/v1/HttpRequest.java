package message_gateway.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final class HttpRequest extends com.squareup.wire.Message<HttpRequest, Builder> {
    public static final ProtoAdapter<HttpRequest> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final Method DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_RETRY = null;
    public static final Boolean DEFAULT_SEND_BY_HTTP = null;
    public static final Integer DEFAULT_SERVICE = null;
    public static final Long DEFAULT_TIMEOUT = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final List<Header> headers;
    public final Method method;
    public final Boolean retry;
    public final Boolean send_by_http;
    public final Integer service;
    public final Long timeout;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<HttpRequest, Builder> {
        public ByteString body;
        public List<Header> headers;
        public Method method;
        public Boolean retry;
        public Boolean send_by_http;
        public Integer service;
        public Long timeout;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public HttpRequest build() {
            return new HttpRequest(this.service, this.url, this.method, this.headers, this.body, this.timeout, this.retry, this.send_by_http, super.buildUnknownFields());
        }

        public Builder() {
            this.headers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder headers(List<Header> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder retry(Boolean r100) {
            this.retry = r100;
            return this;
        }

        public Builder send_by_http(Boolean r100) {
            this.send_by_http = r100;
            return this;
        }

        public Builder service(Integer r100) {
            this.service = r100;
            return this;
        }

        public Builder timeout(Long r100) {
            this.timeout = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method GET = null;
        public static final Method POST = null;
        private final int value;

        static {
            Method r100 = new Method("GET", 0, 1);
            GET = r100;
            Method r101 = new Method("POST", 1, 2);
            POST = r101;
            $VALUES = new Method[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return POST;
        L11:
            return GET;
        }

        public static Method valueOf(String r100) {
            return (Method) a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_HttpRequest extends ProtoAdapter<HttpRequest> {
        public ProtoAdapter_HttpRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, HttpRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HttpRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.service = 0;
            r101.url = "";
            r101.method = Method.GET;
            r101.body = ByteString.EMPTY;
            r101.timeout = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.retry = r102;
            r101.send_by_http = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            switch(r104) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L20;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.send_by_http = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.retry = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.timeout = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            r101.headers.add(Header.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.service = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HttpRequest r100) {
            Integer r101 = r100.service;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Method r107 = r100.method;
            if (r107 == null) goto L13;
            int r108 = Method.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + Header.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.headers);
            ByteString r110 = r100.body;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.timeout;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.UINT64.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.retry;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.send_by_http;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ HttpRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HttpRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HttpRequest r101) throws IOException {
            Integer r102 = r101.service;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Method r104 = r101.method;
            if (r104 == null) goto L11;
            Method.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Header.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.headers);
            ByteString r105 = r101.body;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r105);
        L14:
            Long r106 = r101.timeout;
            if (r106 == null) goto L17;
            ProtoAdapter.UINT64.encodeWithTag(r100, 6, r106);
        L17:
            Boolean r107 = r101.retry;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L20:
            Boolean r108 = r101.send_by_http;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HttpRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HttpRequest();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = Method.GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_TIMEOUT = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_RETRY = r100;
        DEFAULT_SEND_BY_HTTP = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.service = this.service;
        r100.url = this.url;
        r100.method = this.method;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.body = this.body;
        r100.timeout = this.timeout;
        r100.retry = this.retry;
        r100.send_by_http = this.send_by_http;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HttpRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public HttpRequest(Integer r110, String r111, Method r112, List<Header> r113, ByteString r114, Long r115, Boolean r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public HttpRequest(Integer r100, String r101, Method r102, List<Header> r103, ByteString r104, Long r105, Boolean r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.service = r100;
        this.url = r101;
        this.method = r102;
        this.headers = Internal.immutableCopyOf("headers", r103);
        this.body = r104;
        this.timeout = r105;
        this.retry = r106;
        this.send_by_http = r107;
    }
}
