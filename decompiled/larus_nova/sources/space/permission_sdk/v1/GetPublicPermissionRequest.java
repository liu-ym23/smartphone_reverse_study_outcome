package space.permission_sdk.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
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
public final class GetPublicPermissionRequest extends Message<GetPublicPermissionRequest, Builder> {
    public static final ProtoAdapter<GetPublicPermissionRequest> ADAPTER = null;
    public static final EntityDomain DEFAULT_ENTITY_DOMAIN = null;
    public static final FileBizDomain DEFAULT_FILE_BIZ_DOMAIN = null;
    public static final FieldOptions FIELD_OPTIONS_DOCUMENT = null;
    public static final FieldOptions FIELD_OPTIONS_ENTITY_DOMAIN = null;
    public static final FieldOptions FIELD_OPTIONS_FILE_BIZ_DOMAIN = null;
    public static final ProtoAdapter_GetPublicPermissionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DocID document;
    public final EntityDomain entity_domain;
    public final FileBizDomain file_biz_domain;

    public static final class Builder extends Message.Builder<GetPublicPermissionRequest, Builder> implements d<GetPublicPermissionRequest> {
        public DocID document;
        public EntityDomain entity_domain;
        public FileBizDomain file_biz_domain;

        @Override // com.squareup.wire.Message.Builder
        public GetPublicPermissionRequest build() {
            DocID r100 = this.document;
            if (r100 == null) goto L7;
            return new GetPublicPermissionRequest(this.document, this.entity_domain, this.file_biz_domain, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "document"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder document(DocID r100) {
            this.document = r100;
            return this;
        }

        public Builder entity_domain(EntityDomain r100) {
            this.entity_domain = r100;
            return this;
        }

        public Builder file_biz_domain(FileBizDomain r100) {
            this.file_biz_domain = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPublicPermissionRequest extends ProtoAdapter<GetPublicPermissionRequest> implements c<GetPublicPermissionRequest> {
        public ProtoAdapter_GetPublicPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPublicPermissionRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetPublicPermissionRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.entity_domain = EntityDomain.ED_UNKNOW;
            r101.file_biz_domain = FileBizDomain.FBD_UNKNOW;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.document = DocID.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_domain = EntityDomain.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.file_biz_domain = FileBizDomain.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPublicPermissionRequest r100) {
            int r101 = DocID.ADAPTER.encodedSizeWithTag(1, r100.document);
            EntityDomain r102 = r100.entity_domain;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = EntityDomain.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            FileBizDomain r106 = r100.file_biz_domain;
            if (r106 == null) goto L10;
            r103 = FileBizDomain.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPublicPermissionRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPublicPermissionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPublicPermissionRequest r101) throws IOException {
            DocID.ADAPTER.encodeWithTag(r100, 1, r101.document);
            EntityDomain r102 = r101.entity_domain;
            if (r102 == null) goto L5;
            EntityDomain.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            FileBizDomain r103 = r101.file_biz_domain;
            if (r103 == null) goto L8;
            FileBizDomain.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPublicPermissionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPublicPermissionRequest r100 = new ProtoAdapter_GetPublicPermissionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_DOCUMENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ENTITY_DOMAIN = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_FILE_BIZ_DOMAIN = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_ENTITY_DOMAIN = EntityDomain.ED_UNKNOW;
        DEFAULT_FILE_BIZ_DOMAIN = FileBizDomain.FBD_UNKNOW;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.document = this.document;
        r100.entity_domain = this.entity_domain;
        r100.file_biz_domain = this.file_biz_domain;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPublicPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPublicPermissionRequest(DocID r100, EntityDomain r101, FileBizDomain r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetPublicPermissionRequest(DocID r100, EntityDomain r101, FileBizDomain r102, ByteString r103) {
        super(ADAPTER, r103);
        this.document = r100;
        this.entity_domain = r101;
        this.file_biz_domain = r102;
    }
}
