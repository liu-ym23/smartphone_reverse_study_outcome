package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetV2;
import com.ss.android.lark.pb.entities.MediaContent;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ResourceMeta extends Message<ResourceMeta, Builder> {
    public static final ProtoAdapter<ResourceMeta> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_RESOURCE_ACCESS_AUTH = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Long DEFAULT_SCENE_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_resource_access_auth;
    public final String mid;
    public final ImageSetV2 mimage;
    public final Boolean mis_destroyed;
    public final MediaContent mmedia_content;
    public final MessageRelatedInfo mmessage_related_info;
    public final ResourceType mresourceType;
    public final Long mscene_id;

    public static final class Builder extends Message.Builder<ResourceMeta, Builder> {
        public Boolean mhas_resource_access_auth;
        public String mid;
        public ImageSetV2 mimage;
        public Boolean mis_destroyed;
        public MediaContent mmedia_content;
        public MessageRelatedInfo mmessage_related_info;
        public ResourceType mresourceType;
        public Long mscene_id;

        @Override // com.squareup.wire.Message.Builder
        public ResourceMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new ResourceMeta(this.mid, this.mresourceType, this.mmessage_related_info, this.mmedia_content, this.mimage, this.mhas_resource_access_auth, this.mis_destroyed, this.mscene_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_resource_access_auth(Boolean r100) {
            this.mhas_resource_access_auth = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder image(ImageSetV2 r100) {
            this.mimage = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.mis_destroyed = r100;
            return this;
        }

        public Builder media_content(MediaContent r100) {
            this.mmedia_content = r100;
            return this;
        }

        public Builder message_related_info(MessageRelatedInfo r100) {
            this.mmessage_related_info = r100;
            return this;
        }

        public Builder resourceType(ResourceType r100) {
            this.mresourceType = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.mscene_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ResourceMeta extends ProtoAdapter<ResourceMeta> {
        public ProtoAdapter_ResourceMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ResourceMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResourceMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            Boolean r102 = Boolean.FALSE;
            r101.mhas_resource_access_auth = r102;
            r101.mis_destroyed = r102;
            r101.mscene_id = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            switch(r104) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.mresourceType = ResourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mscene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.mis_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.mhas_resource_access_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mimage = ImageSetV2.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mmedia_content = MediaContent.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mmessage_related_info = MessageRelatedInfo.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResourceMeta r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mid);
            ResourceType r102 = r100.mresourceType;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ResourceType.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            MessageRelatedInfo r106 = r100.mmessage_related_info;
            if (r106 == null) goto L9;
            int r107 = MessageRelatedInfo.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            MediaContent r109 = r100.mmedia_content;
            if (r109 == null) goto L13;
            int r110 = MediaContent.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            ImageSetV2 r112 = r100.mimage;
            if (r112 == null) goto L17;
            int r113 = ImageSetV2.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.mhas_resource_access_auth;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.mis_destroyed;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            Long r121 = r100.mscene_id;
            if (r121 == null) goto L30;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(8, r121);
        L30:
            return (r120 + r103) + r100.unknownFields().size();
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResourceMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResourceMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResourceMeta r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mid);
            ResourceType r102 = r101.mresourceType;
            if (r102 == null) goto L5;
            ResourceType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            MessageRelatedInfo r103 = r101.mmessage_related_info;
            if (r103 == null) goto L8;
            MessageRelatedInfo.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            MediaContent r104 = r101.mmedia_content;
            if (r104 == null) goto L11;
            MediaContent.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            ImageSetV2 r105 = r101.mimage;
            if (r105 == null) goto L14;
            ImageSetV2.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.mhas_resource_access_auth;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            Boolean r107 = r101.mis_destroyed;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L20:
            Long r108 = r101.mscene_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> implements WireEnum {
        private static final /* synthetic */ ResourceType[] $VALUES = null;
        public static final ProtoAdapter<ResourceType> ADAPTER = null;
        public static final ResourceType IMAGE = null;
        public static final ResourceType UNKNOWN = null;
        public static final ResourceType VIDEO = null;
        private final int value;

        static {
            ResourceType r100 = new ResourceType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ResourceType r101 = new ResourceType("IMAGE", 1, 1);
            IMAGE = r101;
            ResourceType r102 = new ResourceType("VIDEO", 2, 2);
            VIDEO = r102;
            $VALUES = new ResourceType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ResourceType.class);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ResourceType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return VIDEO;
        L12:
            return IMAGE;
        L14:
            return UNKNOWN;
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) a.a(ResourceType.class, r100);
        }

        private ResourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResourceMeta();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_HAS_RESOURCE_ACCESS_AUTH = r100;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mresourceType = this.mresourceType;
        r100.mmessage_related_info = this.mmessage_related_info;
        r100.mmedia_content = this.mmedia_content;
        r100.mimage = this.mimage;
        r100.mhas_resource_access_auth = this.mhas_resource_access_auth;
        r100.mis_destroyed = this.mis_destroyed;
        r100.mscene_id = this.mscene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResourceMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResourceMeta(String r110, ResourceType r111, MessageRelatedInfo r112, MediaContent r113, ImageSetV2 r114, Boolean r115, Boolean r116, Long r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public ResourceMeta(String r100, ResourceType r101, MessageRelatedInfo r102, MediaContent r103, ImageSetV2 r104, Boolean r105, Boolean r106, Long r107, ByteString r110) {
        super(ADAPTER, r110);
        this.mid = r100;
        this.mresourceType = r101;
        this.mmessage_related_info = r102;
        this.mmedia_content = r103;
        this.mimage = r104;
        this.mhas_resource_access_auth = r105;
        this.mis_destroyed = r106;
        this.mscene_id = r107;
    }
}
