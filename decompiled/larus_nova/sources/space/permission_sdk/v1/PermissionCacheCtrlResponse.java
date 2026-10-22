package space.permission_sdk.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class PermissionCacheCtrlResponse extends Message<PermissionCacheCtrlResponse, Builder> {
    public static final ProtoAdapter<PermissionCacheCtrlResponse> ADAPTER = null;
    public static final ProtoAdapter_PermissionCacheCtrlResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<PermissionCacheCtrlResponse, Builder> implements d<PermissionCacheCtrlResponse> {
        @Override // com.squareup.wire.Message.Builder
        public PermissionCacheCtrlResponse build() {
            return new PermissionCacheCtrlResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_PermissionCacheCtrlResponse extends ProtoAdapter<PermissionCacheCtrlResponse> implements c<PermissionCacheCtrlResponse> {
        public ProtoAdapter_PermissionCacheCtrlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionCacheCtrlResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PermissionCacheCtrlResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PermissionCacheCtrlResponse r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PermissionCacheCtrlResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PermissionCacheCtrlResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PermissionCacheCtrlResponse r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionCacheCtrlResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PermissionCacheCtrlResponse r100 = new ProtoAdapter_PermissionCacheCtrlResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    public PermissionCacheCtrlResponse() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PermissionCacheCtrlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PermissionCacheCtrlResponse(ByteString r100) {
        super(ADAPTER, r100);
    }
}
