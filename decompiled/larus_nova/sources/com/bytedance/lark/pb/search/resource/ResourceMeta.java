package com.bytedance.lark.pb.search.resource;

import annotation.Debug;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.MediaContent;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ResourceMeta extends Message<ResourceMeta, Builder> {
    public static final ProtoAdapter<ResourceMeta> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_RESOURCE_ACCESS_AUTH = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final ResourceType DEFAULT_RESOURCE_TYPE = null;
    public static final Long DEFAULT_SCENE_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_resource_access_auth;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253679id;
    public final Boolean is_destroyed;
    public final MessageRelatedInfo message_related_info;
    public final ResourceContent resource_content;
    public final ResourceType resource_type;
    public final Long scene_id;

    public static final class Builder extends Message.Builder<ResourceMeta, Builder> {
        public Boolean has_resource_access_auth;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253680id;
        public Boolean is_destroyed;
        public MessageRelatedInfo message_related_info;
        public ResourceContent resource_content;
        public ResourceType resource_type;
        public Long scene_id;

        @Override // com.squareup.wire.Message.Builder
        public ResourceMeta build() {
            String r100 = this.f253680id;
            if (r100 == null) goto L7;
            return new ResourceMeta(this.f253680id, this.resource_type, this.message_related_info, this.resource_content, this.has_resource_access_auth, this.is_destroyed, this.scene_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_resource_access_auth(Boolean r100) {
            this.has_resource_access_auth = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253680id = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.is_destroyed = r100;
            return this;
        }

        public Builder message_related_info(MessageRelatedInfo r100) {
            this.message_related_info = r100;
            return this;
        }

        public Builder resource_content(ResourceContent r100) {
            this.resource_content = r100;
            return this;
        }

        public Builder resource_type(ResourceType r100) {
            this.resource_type = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.scene_id = r100;
            return this;
        }
    }

    public static final class ImageContent extends Message<ImageContent, Builder> {
        public static final ProtoAdapter<ImageContent> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ImageSet image;

        public static final class Builder extends Message.Builder<ImageContent, Builder> {
            public ImageSet image;

            @Override // com.squareup.wire.Message.Builder
            public ImageContent build() {
                ImageSet r100 = this.image;
                if (r100 == null) goto L7;
                return new ImageContent(this.image, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "image"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder image(ImageSet r100) {
                this.image = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageContent extends ProtoAdapter<ImageContent> {
            public ProtoAdapter_ImageContent() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.image = ImageSet.ADAPTER.decode(r100);
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
            public int encodedSize2(ImageContent r100) {
                return ImageSet.ADAPTER.encodedSizeWithTag(1, r100.image) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ImageContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageContent r101) throws IOException {
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r101.image);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageContent();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.image = this.image;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageContent(ImageSet r100) {
            this(r100, ByteString.EMPTY);
        }

        public ImageContent(ImageSet r100, ByteString r101) {
            super(ADAPTER, r101);
            this.image = r100;
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
            r101.f253680id = "";
            r101.resource_type = ResourceType.UNKNOWN;
            Boolean r102 = Boolean.FALSE;
            r101.has_resource_access_auth = r102;
            r101.is_destroyed = r102;
            r101.scene_id = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L6;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L19:
            r101.resource_type = ResourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.scene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.is_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.has_resource_access_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.resource_content = ResourceContent.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.message_related_info = MessageRelatedInfo.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.f253680id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResourceMeta r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253679id);
            ResourceType r102 = r100.resource_type;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ResourceType.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            MessageRelatedInfo r106 = r100.message_related_info;
            if (r106 == null) goto L9;
            int r107 = MessageRelatedInfo.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            ResourceContent r109 = r100.resource_content;
            if (r109 == null) goto L13;
            int r110 = ResourceContent.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Boolean r112 = r100.has_resource_access_auth;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.is_destroyed;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            Long r118 = r100.scene_id;
            if (r118 == null) goto L26;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(8, r118);
        L26:
            return (r117 + r103) + r100.unknownFields().size();
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
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253679id);
            ResourceType r102 = r101.resource_type;
            if (r102 == null) goto L5;
            ResourceType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            MessageRelatedInfo r103 = r101.message_related_info;
            if (r103 == null) goto L8;
            MessageRelatedInfo.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            ResourceContent r104 = r101.resource_content;
            if (r104 == null) goto L11;
            ResourceContent.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.has_resource_access_auth;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.is_destroyed;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L17:
            Long r107 = r101.scene_id;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ResourceContent extends Message<ResourceContent, Builder> {
        public static final ProtoAdapter<ResourceContent> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_IMAGE_CONTENT = null;
        public static final FieldOptions FIELD_OPTIONS_VIDEO_CONTENT = null;
        private static final long serialVersionUID = 0;
        public final ImageContent image_content;
        public final VideoContent video_content;

        public static final class Builder extends Message.Builder<ResourceContent, Builder> {
            public ImageContent image_content;
            public VideoContent video_content;

            @Override // com.squareup.wire.Message.Builder
            public ResourceContent build() {
                return new ResourceContent(this.image_content, this.video_content, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder image_content(ImageContent r100) {
                this.image_content = r100;
                this.video_content = null;
                return this;
            }

            public Builder video_content(VideoContent r100) {
                this.video_content = r100;
                this.image_content = null;
                return this;
            }
        }

        public static final class ProtoAdapter_ResourceContent extends ProtoAdapter<ResourceContent> {
            public ProtoAdapter_ResourceContent() {
                super(FieldEncoding.LENGTH_DELIMITED, ResourceContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResourceContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.image_content(ImageContent.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.video_content(VideoContent.ADAPTER.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ResourceContent r100) {
                ImageContent r101 = r100.image_content;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageContent.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                VideoContent r104 = r100.video_content;
                if (r104 == null) goto L10;
                r102 = VideoContent.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ResourceContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResourceContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResourceContent r101) throws IOException {
                ImageContent r102 = r101.image_content;
                if (r102 == null) goto L5;
                ImageContent.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                VideoContent r103 = r101.video_content;
                if (r103 == null) goto L8;
                VideoContent.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResourceContent();
            FIELD_OPTIONS_IMAGE_CONTENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_VIDEO_CONTENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.image_content = this.image_content;
            r100.video_content = this.video_content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResourceContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResourceContent(ImageContent r100, VideoContent r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ResourceContent(ImageContent r100, VideoContent r101, ByteString r102) {
            super(ADAPTER, r102);
            if (Internal.countNonNull(r100, r101) > 1) goto L7;
            this.image_content = r100;
            this.video_content = r101;
            return;
        L7:
            throw new IllegalArgumentException("at most one of image_content, video_content may be non-null");
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

    public static final class VideoContent extends Message<VideoContent, Builder> {
        public static final ProtoAdapter<VideoContent> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final MediaContent media;

        public static final class Builder extends Message.Builder<VideoContent, Builder> {
            public MediaContent media;

            @Override // com.squareup.wire.Message.Builder
            public VideoContent build() {
                MediaContent r100 = this.media;
                if (r100 == null) goto L7;
                return new VideoContent(this.media, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "media"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder media(MediaContent r100) {
                this.media = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_VideoContent extends ProtoAdapter<VideoContent> {
            public ProtoAdapter_VideoContent() {
                super(FieldEncoding.LENGTH_DELIMITED, VideoContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public VideoContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.media = MediaContent.ADAPTER.decode(r100);
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
            public int encodedSize2(VideoContent r100) {
                return MediaContent.ADAPTER.encodedSizeWithTag(1, r100.media) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ VideoContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(VideoContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, VideoContent r101) throws IOException {
                MediaContent.ADAPTER.encodeWithTag(r100, 1, r101.media);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VideoContent();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.media = this.media;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return VideoContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public VideoContent(MediaContent r100) {
            this(r100, ByteString.EMPTY);
        }

        public VideoContent(MediaContent r100, ByteString r101) {
            super(ADAPTER, r101);
            this.media = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResourceMeta();
        DEFAULT_RESOURCE_TYPE = ResourceType.UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_HAS_RESOURCE_ACCESS_AUTH = r100;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253680id = this.f253679id;
        r100.resource_type = this.resource_type;
        r100.message_related_info = this.message_related_info;
        r100.resource_content = this.resource_content;
        r100.has_resource_access_auth = this.has_resource_access_auth;
        r100.is_destroyed = this.is_destroyed;
        r100.scene_id = this.scene_id;
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

    public ResourceMeta(String r110, ResourceType r111, MessageRelatedInfo r112, ResourceContent r113, Boolean r114, Boolean r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ResourceMeta(String r100, ResourceType r101, MessageRelatedInfo r102, ResourceContent r103, Boolean r104, Boolean r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.f253679id = r100;
        this.resource_type = r101;
        this.message_related_info = r102;
        this.resource_content = r103;
        this.has_resource_access_auth = r104;
        this.is_destroyed = r105;
        this.scene_id = r106;
    }
}
