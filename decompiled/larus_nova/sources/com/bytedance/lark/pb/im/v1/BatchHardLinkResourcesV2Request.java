package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class BatchHardLinkResourcesV2Request extends Message<BatchHardLinkResourcesV2Request, Builder> {
    public static final ProtoAdapter<BatchHardLinkResourcesV2Request> ADAPTER = null;
    public static final ProtoAdapter_BatchHardLinkResourcesV2Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ResourceEntity> resource_entities;

    public static final class Builder extends Message.Builder<BatchHardLinkResourcesV2Request, Builder> implements d<BatchHardLinkResourcesV2Request> {
        public List<ResourceEntity> resource_entities;

        @Override // com.squareup.wire.Message.Builder
        public BatchHardLinkResourcesV2Request build() {
            return new BatchHardLinkResourcesV2Request(this.resource_entities, super.buildUnknownFields());
        }

        public Builder() {
            this.resource_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resource_entities(List<ResourceEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.resource_entities = r100;
            return this;
        }
    }

    public static final enum CopyType extends Enum<CopyType> implements WireEnum {
        private static final /* synthetic */ CopyType[] $VALUES = null;
        public static final ProtoAdapter<CopyType> ADAPTER = null;
        public static final CopyType CopyFile = null;
        public static final CopyType CopyImg = null;
        public static final CopyType CopyVideo = null;
        private final int value;

        static {
            CopyType r100 = new CopyType("CopyImg", 0, 1);
            CopyImg = r100;
            CopyType r101 = new CopyType("CopyVideo", 1, 2);
            CopyVideo = r101;
            CopyType r102 = new CopyType("CopyFile", 2, 3);
            CopyFile = r102;
            $VALUES = new CopyType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CopyType.class);
        }

        public static CopyType[] values() {
            return (CopyType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CopyType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return CopyFile;
        L13:
            return CopyVideo;
        L15:
            return CopyImg;
        }

        public static CopyType valueOf(String r100) {
            return (CopyType) a.a(CopyType.class, r100);
        }

        private CopyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_BatchHardLinkResourcesV2Request extends ProtoAdapter<BatchHardLinkResourcesV2Request> implements c<BatchHardLinkResourcesV2Request> {
        public ProtoAdapter_BatchHardLinkResourcesV2Request() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchHardLinkResourcesV2Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BatchHardLinkResourcesV2Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.resource_entities.add(ResourceEntity.ADAPTER.decode(r100));
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
        public int encodedSize2(BatchHardLinkResourcesV2Request r100) {
            return ResourceEntity.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.resource_entities) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BatchHardLinkResourcesV2Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BatchHardLinkResourcesV2Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BatchHardLinkResourcesV2Request r101) throws IOException {
            ResourceEntity.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.resource_entities);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BatchHardLinkResourcesV2Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ResourceEntity extends Message<ResourceEntity, Builder> {
        public static final ProtoAdapter<ResourceEntity> ADAPTER = null;
        public static final String DEFAULT_BIZ = "";
        public static final CopyType DEFAULT_COPY_TYPE = null;
        public static final String DEFAULT_DUP_ID = "";
        public static final String DEFAULT_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final String biz;
        public final CopyType copy_type;
        public final String dup_id;
        public final VisitInfo src_visit_info;
        public final String token;

        public static final class Builder extends Message.Builder<ResourceEntity, Builder> {
            public String biz;
            public CopyType copy_type;
            public String dup_id;
            public VisitInfo src_visit_info;
            public String token;

            @Override // com.squareup.wire.Message.Builder
            public ResourceEntity build() {
                return new ResourceEntity(this.token, this.biz, this.copy_type, this.src_visit_info, this.dup_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder biz(String r100) {
                this.biz = r100;
                return this;
            }

            public Builder copy_type(CopyType r100) {
                this.copy_type = r100;
                return this;
            }

            public Builder dup_id(String r100) {
                this.dup_id = r100;
                return this;
            }

            public Builder src_visit_info(VisitInfo r100) {
                this.src_visit_info = r100;
                return this;
            }

            public Builder token(String r100) {
                this.token = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ResourceEntity extends ProtoAdapter<ResourceEntity> {
            public ProtoAdapter_ResourceEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, ResourceEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResourceEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.token = "";
                r101.biz = "";
                r101.copy_type = CopyType.CopyImg;
                r101.dup_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.biz = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.copy_type = CopyType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.src_visit_info = VisitInfo.ADAPTER.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.dup_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ResourceEntity r100) {
                String r101 = r100.token;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.biz;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                CopyType r107 = r100.copy_type;
                if (r107 == null) goto L13;
                int r108 = CopyType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                VisitInfo r110 = r100.src_visit_info;
                if (r110 == null) goto L17;
                int r111 = VisitInfo.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.dup_id;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ResourceEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResourceEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResourceEntity r101) throws IOException {
                String r102 = r101.token;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.biz;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                CopyType r104 = r101.copy_type;
                if (r104 == null) goto L11;
                CopyType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                VisitInfo r105 = r101.src_visit_info;
                if (r105 == null) goto L14;
                VisitInfo.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.dup_id;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResourceEntity();
            DEFAULT_COPY_TYPE = CopyType.CopyImg;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.token = this.token;
            r100.biz = this.biz;
            r100.copy_type = this.copy_type;
            r100.src_visit_info = this.src_visit_info;
            r100.dup_id = this.dup_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResourceEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResourceEntity(String r100, String r101, CopyType r110, VisitInfo r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ResourceEntity(String r100, String r101, CopyType r102, VisitInfo r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.token = r100;
            this.biz = r101;
            this.copy_type = r102;
            this.src_visit_info = r103;
            this.dup_id = r104;
        }
    }

    static {
        ProtoAdapter_BatchHardLinkResourcesV2Request r100 = new ProtoAdapter_BatchHardLinkResourcesV2Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resource_entities = Internal.copyOf("resource_entities", this.resource_entities);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BatchHardLinkResourcesV2Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BatchHardLinkResourcesV2Request(List<ResourceEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public BatchHardLinkResourcesV2Request(List<ResourceEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.resource_entities = Internal.immutableCopyOf("resource_entities", r100);
    }
}
