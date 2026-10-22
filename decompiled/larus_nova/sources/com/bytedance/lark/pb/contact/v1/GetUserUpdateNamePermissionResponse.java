package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserUpdateNamePermissionResponse extends Message<GetUserUpdateNamePermissionResponse, Builder> {
    public static final ProtoAdapter<GetUserUpdateNamePermissionResponse> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE = null;
    public static final Boolean DEFAULT_ENABLE_ANOTHER_NAME = null;
    public static final ProtoAdapter_GetUserUpdateNamePermissionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable;
    public final Boolean enable_another_name;

    public static final class Builder extends Message.Builder<GetUserUpdateNamePermissionResponse, Builder> implements d<GetUserUpdateNamePermissionResponse> {
        public Boolean enable;
        public Boolean enable_another_name;

        @Override // com.squareup.wire.Message.Builder
        public GetUserUpdateNamePermissionResponse build() {
            return new GetUserUpdateNamePermissionResponse(this.enable, this.enable_another_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable(Boolean r100) {
            this.enable = r100;
            return this;
        }

        public Builder enable_another_name(Boolean r100) {
            this.enable_another_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserUpdateNamePermissionResponse extends ProtoAdapter<GetUserUpdateNamePermissionResponse> implements c<GetUserUpdateNamePermissionResponse> {
        public ProtoAdapter_GetUserUpdateNamePermissionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserUpdateNamePermissionResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserUpdateNamePermissionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.enable = r102;
            r101.enable_another_name = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.enable_another_name = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserUpdateNamePermissionResponse r100) {
            Boolean r101 = r100.enable;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.enable_another_name;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserUpdateNamePermissionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserUpdateNamePermissionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserUpdateNamePermissionResponse r101) throws IOException {
            Boolean r102 = r101.enable;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.enable_another_name;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserUpdateNamePermissionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserUpdateNamePermissionResponse r100 = new ProtoAdapter_GetUserUpdateNamePermissionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_ENABLE = r101;
        DEFAULT_ENABLE_ANOTHER_NAME = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.enable = this.enable;
        r100.enable_another_name = this.enable_another_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserUpdateNamePermissionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserUpdateNamePermissionResponse(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUserUpdateNamePermissionResponse(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.enable = r100;
        this.enable_another_name = r101;
    }
}
