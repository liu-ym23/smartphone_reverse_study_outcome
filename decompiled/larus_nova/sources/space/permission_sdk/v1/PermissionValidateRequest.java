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
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class PermissionValidateRequest extends Message<PermissionValidateRequest, Builder> {
    public static final ProtoAdapter<PermissionValidateRequest> ADAPTER = null;
    public static final String DEFAULT_BACKEND_RAW_DATA = "";
    public static final EntityDomain DEFAULT_ENTITY_DOMAIN = null;
    public static final FileBizDomain DEFAULT_FILE_BIZ_DOMAIN = null;
    public static final FieldOptions FIELD_OPTIONS_BACKEND_RAW_DATA = null;
    public static final FieldOptions FIELD_OPTIONS_DOCUMENT = null;
    public static final FieldOptions FIELD_OPTIONS_DRIVE_EXTRA = null;
    public static final FieldOptions FIELD_OPTIONS_IM_EXTRA = null;
    public static final FieldOptions FIELD_OPTIONS_OPERATIONS = null;
    public static final FieldOptions FIELD_OPTIONS_PARENT = null;
    public static final ProtoAdapter_PermissionValidateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String backend_raw_data;
    public final DocID document;
    public final DriveExtraInfo drive_extra;
    public final EntityDomain entity_domain;
    public final FileBizDomain file_biz_domain;
    public final IMExtraInfo im_extra;
    public final List<Operation> operations;
    public final DocID parent;

    public static final class Builder extends Message.Builder<PermissionValidateRequest, Builder> implements d<PermissionValidateRequest> {
        public String backend_raw_data;
        public DocID document;
        public DriveExtraInfo drive_extra;
        public EntityDomain entity_domain;
        public FileBizDomain file_biz_domain;
        public IMExtraInfo im_extra;
        public List<Operation> operations;
        public DocID parent;

        @Override // com.squareup.wire.Message.Builder
        public PermissionValidateRequest build() {
            DocID r100 = this.document;
            if (r100 == null) goto L7;
            return new PermissionValidateRequest(this.operations, this.document, this.parent, this.entity_domain, this.file_biz_domain, this.backend_raw_data, this.drive_extra, this.im_extra, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "document"});
        }

        public Builder() {
            this.operations = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder backend_raw_data(String r100) {
            this.backend_raw_data = r100;
            return this;
        }

        public Builder document(DocID r100) {
            this.document = r100;
            return this;
        }

        public Builder drive_extra(DriveExtraInfo r100) {
            this.drive_extra = r100;
            this.im_extra = null;
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

        public Builder im_extra(IMExtraInfo r100) {
            this.im_extra = r100;
            this.drive_extra = null;
            return this;
        }

        public Builder operations(List<Operation> r100) {
            Internal.checkElementsNotNull(r100);
            this.operations = r100;
            return this;
        }

        public Builder parent(DocID r100) {
            this.parent = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PermissionValidateRequest extends ProtoAdapter<PermissionValidateRequest> implements c<PermissionValidateRequest> {
        public ProtoAdapter_PermissionValidateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionValidateRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PermissionValidateRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.entity_domain = EntityDomain.ED_UNKNOW;
            r101.file_biz_domain = FileBizDomain.FBD_UNKNOW;
            r101.backend_raw_data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            switch(r103) {
                case 1: goto L30;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L28;
                case 5: goto L26;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L26:
            r101.file_biz_domain = FileBizDomain.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r101.entity_domain = EntityDomain.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.operations.add(Operation.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.backend_raw_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.im_extra(IMExtraInfo.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.drive_extra(DriveExtraInfo.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.parent = DocID.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.document = DocID.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PermissionValidateRequest r100) {
            int r101 = Operation.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.operations);
            ProtoAdapter<DocID> r102 = DocID.ADAPTER;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.document);
            DocID r104 = r100.parent;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            EntityDomain r108 = r100.entity_domain;
            if (r108 == null) goto L9;
            int r109 = EntityDomain.ADAPTER.encodedSizeWithTag(4, r108);
        L10:
            int r110 = r107 + r109;
            FileBizDomain r111 = r100.file_biz_domain;
            if (r111 == null) goto L13;
            int r112 = FileBizDomain.ADAPTER.encodedSizeWithTag(5, r111);
        L14:
            int r113 = r110 + r112;
            String r114 = r100.backend_raw_data;
            if (r114 == null) goto L17;
            int r115 = ProtoAdapter.STRING.encodedSizeWithTag(8, r114);
        L18:
            int r116 = r113 + r115;
            DriveExtraInfo r117 = r100.drive_extra;
            if (r117 == null) goto L21;
            int r118 = DriveExtraInfo.ADAPTER.encodedSizeWithTag(6, r117);
        L22:
            int r119 = r116 + r118;
            IMExtraInfo r120 = r100.im_extra;
            if (r120 == null) goto L26;
            r105 = IMExtraInfo.ADAPTER.encodedSizeWithTag(7, r120);
        L26:
            return (r119 + r105) + r100.unknownFields().size();
        L21:
            r118 = 0;
            goto L22
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PermissionValidateRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PermissionValidateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PermissionValidateRequest r101) throws IOException {
            Operation.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.operations);
            ProtoAdapter<DocID> r102 = DocID.ADAPTER;
            r102.encodeWithTag(r100, 2, r101.document);
            DocID r103 = r101.parent;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            EntityDomain r104 = r101.entity_domain;
            if (r104 == null) goto L8;
            EntityDomain.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            FileBizDomain r105 = r101.file_biz_domain;
            if (r105 == null) goto L11;
            FileBizDomain.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.backend_raw_data;
            if (r106 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r106);
        L14:
            DriveExtraInfo r107 = r101.drive_extra;
            if (r107 == null) goto L17;
            DriveExtraInfo.ADAPTER.encodeWithTag(r100, 6, r107);
        L17:
            IMExtraInfo r108 = r101.im_extra;
            if (r108 == null) goto L20;
            IMExtraInfo.ADAPTER.encodeWithTag(r100, 7, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionValidateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PermissionValidateRequest r100 = new ProtoAdapter_PermissionValidateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_OPERATIONS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DOCUMENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_PARENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_BACKEND_RAW_DATA = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DRIVE_EXTRA = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IM_EXTRA = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_ENTITY_DOMAIN = EntityDomain.ED_UNKNOW;
        DEFAULT_FILE_BIZ_DOMAIN = FileBizDomain.FBD_UNKNOW;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.operations = Internal.copyOf("operations", this.operations);
        r100.document = this.document;
        r100.parent = this.parent;
        r100.entity_domain = this.entity_domain;
        r100.file_biz_domain = this.file_biz_domain;
        r100.backend_raw_data = this.backend_raw_data;
        r100.drive_extra = this.drive_extra;
        r100.im_extra = this.im_extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PermissionValidateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PermissionValidateRequest(List<Operation> r110, DocID r111, DocID r112, EntityDomain r113, FileBizDomain r114, String r115, DriveExtraInfo r116, IMExtraInfo r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public PermissionValidateRequest(List<Operation> r100, DocID r101, DocID r102, EntityDomain r103, FileBizDomain r104, String r105, DriveExtraInfo r106, IMExtraInfo r107, ByteString r110) {
        super(ADAPTER, r110);
        if (Internal.countNonNull(r106, r107) > 1) goto L7;
        this.operations = Internal.immutableCopyOf("operations", r100);
        this.document = r101;
        this.parent = r102;
        this.entity_domain = r103;
        this.file_biz_domain = r104;
        this.backend_raw_data = r105;
        this.drive_extra = r106;
        this.im_extra = r107;
        return;
    L7:
        throw new IllegalArgumentException("at most one of drive_extra, im_extra may be non-null");
    }
}
