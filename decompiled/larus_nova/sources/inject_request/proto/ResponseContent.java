package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class ResponseContent extends Message<ResponseContent, Builder> {
    public static final ProtoAdapter<ResponseContent> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final String DEFAULT_EXTENSION_INFO = "";
    public static final String DEFAULT_REQUEST_ID = "";
    public static final Integer DEFAULT_STATUS_CODE = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final String extension_info;
    public final List<HeaderPair> header;
    public final String request_id;
    public final Integer status_code;

    public static final class Builder extends Message.Builder<ResponseContent, Builder> {
        public ByteString body;
        public String extension_info;
        public List<HeaderPair> header;
        public String request_id;
        public Integer status_code;

        @Override // com.squareup.wire.Message.Builder
        public ResponseContent build() {
            String r100 = this.request_id;
            if (r100 == null) goto L9;
            if (this.status_code == null) goto L9;
            return new ResponseContent(this.request_id, this.status_code, this.header, this.body, this.extension_info, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "request_id", this.status_code, "status_code"});
        }

        public Builder() {
            this.header = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder extension_info(String r100) {
            this.extension_info = r100;
            return this;
        }

        public Builder header(List<HeaderPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.header = r100;
            return this;
        }

        public Builder request_id(String r100) {
            this.request_id = r100;
            return this;
        }

        public Builder status_code(Integer r100) {
            this.status_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ResponseContent extends ProtoAdapter<ResponseContent> {
        public ProtoAdapter_ResponseContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResponseContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.request_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.status_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.header.add(HeaderPair.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.extension_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResponseContent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.request_id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.status_code)) + HeaderPair.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.header);
            ByteString r103 = r100.body;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.extension_info;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(5, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResponseContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResponseContent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.request_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.status_code);
            HeaderPair.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.header);
            ByteString r103 = r101.body;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.extension_info;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResponseContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResponseContent();
        DEFAULT_STATUS_CODE = 0;
        DEFAULT_BODY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.request_id = this.request_id;
        r100.status_code = this.status_code;
        r100.header = Internal.copyOf("header", this.header);
        r100.body = this.body;
        r100.extension_info = this.extension_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResponseContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResponseContent(String r100, Integer r101, List<HeaderPair> r110, ByteString r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ResponseContent(String r100, Integer r101, List<HeaderPair> r102, ByteString r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.request_id = r100;
        this.status_code = r101;
        this.header = Internal.immutableCopyOf("header", r102);
        this.body = r103;
        this.extension_info = r104;
    }
}
