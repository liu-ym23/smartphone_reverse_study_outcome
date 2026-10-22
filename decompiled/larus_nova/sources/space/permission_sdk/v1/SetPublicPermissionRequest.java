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
public final class SetPublicPermissionRequest extends Message<SetPublicPermissionRequest, Builder> {
    public static final ProtoAdapter<SetPublicPermissionRequest> ADAPTER = null;
    public static final String DEFAULT_REQUEST_JSON = "";
    public static final ProtoAdapter_SetPublicPermissionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String request_json;

    public static final class Builder extends Message.Builder<SetPublicPermissionRequest, Builder> implements d<SetPublicPermissionRequest> {
        public String request_json;

        @Override // com.squareup.wire.Message.Builder
        public SetPublicPermissionRequest build() {
            String r100 = this.request_json;
            if (r100 == null) goto L7;
            return new SetPublicPermissionRequest(this.request_json, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "request_json"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder request_json(String r100) {
            this.request_json = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetPublicPermissionRequest extends ProtoAdapter<SetPublicPermissionRequest> implements c<SetPublicPermissionRequest> {
        public ProtoAdapter_SetPublicPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetPublicPermissionRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public SetPublicPermissionRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.request_json = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.request_json = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetPublicPermissionRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.request_json) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetPublicPermissionRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetPublicPermissionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetPublicPermissionRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.request_json);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetPublicPermissionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetPublicPermissionRequest r100 = new ProtoAdapter_SetPublicPermissionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.request_json = this.request_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetPublicPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetPublicPermissionRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetPublicPermissionRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.request_json = r100;
    }
}
