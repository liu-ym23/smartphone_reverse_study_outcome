package com.bytedance.lark.pb.media.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class GetResourceUrlsRequest extends Message<GetResourceUrlsRequest, Builder> {
    public static final ProtoAdapter<GetResourceUrlsRequest> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_KEY = "";
    public static final ProtoAdapter_GetResourceUrlsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AvatarFsUnitParams avatar_fs_unit_params;
    public final String fs_unit;
    public final String key;

    public static final class Builder extends Message.Builder<GetResourceUrlsRequest, Builder> implements d<GetResourceUrlsRequest> {
        public AvatarFsUnitParams avatar_fs_unit_params;
        public String fs_unit;
        public String key;

        @Override // com.squareup.wire.Message.Builder
        public GetResourceUrlsRequest build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new GetResourceUrlsRequest(this.key, this.avatar_fs_unit_params, this.fs_unit, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_fs_unit_params(AvatarFsUnitParams r100) {
            this.avatar_fs_unit_params = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetResourceUrlsRequest extends ProtoAdapter<GetResourceUrlsRequest> implements c<GetResourceUrlsRequest> {
        public ProtoAdapter_GetResourceUrlsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetResourceUrlsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetResourceUrlsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.fs_unit = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.avatar_fs_unit_params = AvatarFsUnitParams.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetResourceUrlsRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.key);
            AvatarFsUnitParams r103 = r100.avatar_fs_unit_params;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = AvatarFsUnitParams.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.fs_unit;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetResourceUrlsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetResourceUrlsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetResourceUrlsRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            AvatarFsUnitParams r103 = r101.avatar_fs_unit_params;
            if (r103 == null) goto L5;
            AvatarFsUnitParams.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.fs_unit;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetResourceUrlsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetResourceUrlsRequest r100 = new ProtoAdapter_GetResourceUrlsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.avatar_fs_unit_params = this.avatar_fs_unit_params;
        r100.fs_unit = this.fs_unit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetResourceUrlsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetResourceUrlsRequest(String r100, AvatarFsUnitParams r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetResourceUrlsRequest(String r100, AvatarFsUnitParams r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.key = r100;
        this.avatar_fs_unit_params = r101;
        this.fs_unit = r102;
    }
}
