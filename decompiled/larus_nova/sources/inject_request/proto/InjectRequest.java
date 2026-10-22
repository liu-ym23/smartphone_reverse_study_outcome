package inject_request.proto;

import com.alipay.sdk.m.p.e;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class InjectRequest extends Message<InjectRequest, Builder> {
    public static final ProtoAdapter<InjectRequest> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final RequestMethod DEFAULT_METHOD = null;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final Integer DEFAULT_TIMEOUT = null;
    public static final String DEFAULT_URL = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final List<InjectRequestHandler> handler;
    public final Map<String, String> headers;
    public final RequestMethod method;
    public final String request_id;
    public final Integer timeout;
    public final String url;
    public final Long user_id;

    public static final class Builder extends Message.Builder<InjectRequest, Builder> {
        public ByteString body;
        public List<InjectRequestHandler> handler;
        public Map<String, String> headers;
        public RequestMethod method;
        public String request_id;
        public Integer timeout;
        public String url;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public InjectRequest build() {
            String r100 = this.request_id;
            if (r100 == null) goto L13;
            if (this.user_id == null) goto L13;
            if (this.url == null) goto L13;
            if (this.method == null) goto L13;
            return new InjectRequest(this.request_id, this.user_id, this.url, this.method, this.headers, this.handler, this.body, this.timeout, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "request_id", this.user_id, "user_id", this.url, "url", this.method, e.f25671s});
        }

        public Builder() {
            this.headers = Internal.newMutableMap();
            this.handler = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder handler(List<InjectRequestHandler> r100) {
            Internal.checkElementsNotNull(r100);
            this.handler = r100;
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder method(RequestMethod r100) {
            this.method = r100;
            return this;
        }

        public Builder request_id(String r100) {
            this.request_id = r100;
            return this;
        }

        public Builder timeout(Integer r100) {
            this.timeout = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InjectRequest extends ProtoAdapter<InjectRequest> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_InjectRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, InjectRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InjectRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L20;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.method = RequestMethod.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.timeout = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            r101.handler.add(InjectRequestHandler.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L15:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L17:
            r101.request_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InjectRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((((r101.encodedSizeWithTag(1, r100.request_id) + ProtoAdapter.UINT64.encodedSizeWithTag(2, r100.user_id)) + r101.encodedSizeWithTag(3, r100.url)) + RequestMethod.ADAPTER.encodedSizeWithTag(4, r100.method)) + this.headers.encodedSizeWithTag(5, r100.headers)) + InjectRequestHandler.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.handler);
            ByteString r103 = r100.body;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(7, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.timeout;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.UINT32.encodedSizeWithTag(8, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InjectRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InjectRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InjectRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.request_id);
            ProtoAdapter.UINT64.encodeWithTag(r100, 2, r101.user_id);
            r102.encodeWithTag(r100, 3, r101.url);
            RequestMethod.ADAPTER.encodeWithTag(r100, 4, r101.method);
            this.headers.encodeWithTag(r100, 5, r101.headers);
            InjectRequestHandler.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.handler);
            ByteString r103 = r101.body;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 7, r103);
        L5:
            Integer r104 = r101.timeout;
            if (r104 == null) goto L8;
            ProtoAdapter.UINT32.encodeWithTag(r100, 8, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InjectRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InjectRequest();
        DEFAULT_USER_ID = 0L;
        DEFAULT_METHOD = RequestMethod.VAR_REQUEST_METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_TIMEOUT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.request_id = this.request_id;
        r100.user_id = this.user_id;
        r100.url = this.url;
        r100.method = this.method;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.handler = Internal.copyOf("handler", this.handler);
        r100.body = this.body;
        r100.timeout = this.timeout;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InjectRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InjectRequest(String r110, Long r111, String r112, RequestMethod r113, Map<String, String> r114, List<InjectRequestHandler> r115, ByteString r116, Integer r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public InjectRequest(String r100, Long r101, String r102, RequestMethod r103, Map<String, String> r104, List<InjectRequestHandler> r105, ByteString r106, Integer r107, ByteString r110) {
        super(ADAPTER, r110);
        this.request_id = r100;
        this.user_id = r101;
        this.url = r102;
        this.method = r103;
        this.headers = Internal.immutableCopyOf("headers", r104);
        this.handler = Internal.immutableCopyOf("handler", r105);
        this.body = r106;
        this.timeout = r107;
    }
}
