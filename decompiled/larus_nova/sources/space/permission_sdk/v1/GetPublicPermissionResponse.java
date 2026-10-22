package space.permission_sdk.v1;

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

/* JADX INFO: loaded from: classes41.dex */
public final class GetPublicPermissionResponse extends Message<GetPublicPermissionResponse, Builder> {
    public static final ProtoAdapter<GetPublicPermissionResponse> ADAPTER = null;
    public static final String DEFAULT_RESULT_JSON = "";
    public static final ProtoAdapter_GetPublicPermissionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String result_json;

    public static final class Builder extends Message.Builder<GetPublicPermissionResponse, Builder> implements d<GetPublicPermissionResponse> {
        public String result_json;

        @Override // com.squareup.wire.Message.Builder
        public GetPublicPermissionResponse build() {
            String r100 = this.result_json;
            if (r100 == null) goto L7;
            return new GetPublicPermissionResponse(this.result_json, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "result_json"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result_json(String r100) {
            this.result_json = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPublicPermissionResponse extends ProtoAdapter<GetPublicPermissionResponse> implements c<GetPublicPermissionResponse> {
        public ProtoAdapter_GetPublicPermissionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPublicPermissionResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetPublicPermissionResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.result_json = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.result_json = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPublicPermissionResponse r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.result_json) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPublicPermissionResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPublicPermissionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPublicPermissionResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.result_json);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPublicPermissionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPublicPermissionResponse r100 = new ProtoAdapter_GetPublicPermissionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result_json = this.result_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPublicPermissionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPublicPermissionResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetPublicPermissionResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.result_json = r100;
    }
}
