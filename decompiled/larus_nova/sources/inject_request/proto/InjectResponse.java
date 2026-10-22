package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class InjectResponse extends Message<InjectResponse, Builder> {
    public static final ProtoAdapter<InjectResponse> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final String DEFAULT_MSG = "";
    private static final long serialVersionUID = 0;
    public final Integer code;
    public final String msg;
    public final ResponseContent resp;

    public static final class Builder extends Message.Builder<InjectResponse, Builder> {
        public Integer code;
        public String msg;
        public ResponseContent resp;

        @Override // com.squareup.wire.Message.Builder
        public InjectResponse build() {
            Integer r100 = this.code;
            if (r100 == null) goto L7;
            return new InjectResponse(this.code, this.msg, this.resp, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "code"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Integer r100) {
            this.code = r100;
            return this;
        }

        public Builder msg(String r100) {
            this.msg = r100;
            return this;
        }

        public Builder resp(ResponseContent r100) {
            this.resp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InjectResponse extends ProtoAdapter<InjectResponse> {
        public ProtoAdapter_InjectResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, InjectResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InjectResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.resp = ResponseContent.ADAPTER.decode(r100);
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
        public int encodedSize2(InjectResponse r100) {
            int r101 = ProtoAdapter.INT32.encodedSizeWithTag(1, r100.code);
            String r102 = r100.msg;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ResponseContent r106 = r100.resp;
            if (r106 == null) goto L10;
            r103 = ResponseContent.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InjectResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InjectResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InjectResponse r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.code);
            String r102 = r101.msg;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            ResponseContent r103 = r101.resp;
            if (r103 == null) goto L8;
            ResponseContent.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InjectResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InjectResponse();
        DEFAULT_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.code = this.code;
        r100.msg = this.msg;
        r100.resp = this.resp;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InjectResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InjectResponse(Integer r100, String r101, ResponseContent r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public InjectResponse(Integer r100, String r101, ResponseContent r102, ByteString r103) {
        super(ADAPTER, r103);
        this.code = r100;
        this.msg = r101;
        this.resp = r102;
    }
}
