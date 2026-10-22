package message_gateway.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HttpResponse extends com.squareup.wire.Message<HttpResponse, Builder> {
    public static final ProtoAdapter<HttpResponse> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final Integer DEFAULT_STATUS_CODE = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final List<Header> headers;
    public final Integer status_code;

    public static final class Builder extends com.squareup.wire.Message.Builder<HttpResponse, Builder> {
        public ByteString body;
        public List<Header> headers;
        public Integer status_code;

        @Override // com.squareup.wire.Message.Builder
        public HttpResponse build() {
            return new HttpResponse(this.status_code, this.headers, this.body, super.buildUnknownFields());
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

        public Builder status_code(Integer r100) {
            this.status_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HttpResponse extends ProtoAdapter<HttpResponse> {
        public ProtoAdapter_HttpResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, HttpResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HttpResponse decode2(ProtoReader r100) throws IOException {
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
            r101.headers.add(Header.ADAPTER.decode(r100));
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
        public int encodedSize2(HttpResponse r100) {
            Integer r101 = r100.status_code;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + Header.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.headers);
            ByteString r105 = r100.body;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HttpResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HttpResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HttpResponse r101) throws IOException {
            Integer r102 = r101.status_code;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Header.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.headers);
            ByteString r103 = r101.body;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HttpResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HttpResponse();
        DEFAULT_STATUS_CODE = 0;
        DEFAULT_BODY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status_code = this.status_code;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.body = this.body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HttpResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public HttpResponse(Integer r100, List<Header> r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public HttpResponse(Integer r100, List<Header> r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.status_code = r100;
        this.headers = Internal.immutableCopyOf("headers", r101);
        this.body = r102;
    }
}
