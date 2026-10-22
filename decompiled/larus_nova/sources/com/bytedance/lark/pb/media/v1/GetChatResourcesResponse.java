package com.bytedance.lark.pb.media.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.MediaContent;
import com.bytedance.lark.pb.basic.v1.ResourceCleanScene;
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

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatResourcesResponse extends Message<GetChatResourcesResponse, Builder> {
    public static final ProtoAdapter<GetChatResourcesResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE_AFTER = null;
    public static final Boolean DEFAULT_HAS_MORE_BEFORE = null;
    public static final Integer DEFAULT_MESSAGE_INDEX = null;
    public static final ProtoAdapter_GetChatResourcesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more_after;
    public final Boolean has_more_before;
    public final Integer message_index;
    public final List<MessageMeta> messages;

    public static final class Builder extends Message.Builder<GetChatResourcesResponse, Builder> implements d<GetChatResourcesResponse> {
        public Boolean has_more_after;
        public Boolean has_more_before;
        public Integer message_index;
        public List<MessageMeta> messages;

        @Override // com.squareup.wire.Message.Builder
        public GetChatResourcesResponse build() {
            return new GetChatResourcesResponse(this.messages, this.message_index, this.has_more_before, this.has_more_after, super.buildUnknownFields());
        }

        public Builder() {
            this.messages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more_after(Boolean r100) {
            this.has_more_after = r100;
            return this;
        }

        public Builder has_more_before(Boolean r100) {
            this.has_more_before = r100;
            return this;
        }

        public Builder message_index(Integer r100) {
            this.message_index = r100;
            return this;
        }

        public Builder messages(List<MessageMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.messages = r100;
            return this;
        }
    }

    public static final class MessageMeta extends Message<MessageMeta, Builder> {
        public static final ProtoAdapter<MessageMeta> ADAPTER = null;
        public static final Long DEFAULT_CREATE_TIME = null;
        public static final String DEFAULT_ID = "";
        public static final Integer DEFAULT_POSITION = null;
        public static final String DEFAULT_THREAD_ID = "";
        public static final Integer DEFAULT_THREAD_POSITION = null;
        private static final long serialVersionUID = 0;
        public final Long create_time;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253671id;
        public final Integer position;
        public final List<Resource> resources;
        public final String thread_id;
        public final Integer thread_position;

        public static final class Builder extends Message.Builder<MessageMeta, Builder> {
            public Long create_time;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253672id;
            public Integer position;
            public List<Resource> resources;
            public String thread_id;
            public Integer thread_position;

            @Override // com.squareup.wire.Message.Builder
            public MessageMeta build() {
                String r100 = this.f253672id;
                if (r100 == null) goto L9;
                if (this.create_time == null) goto L9;
                return new MessageMeta(this.f253672id, this.position, this.create_time, this.resources, this.thread_position, this.thread_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "id", this.create_time, "create_time"});
            }

            public Builder() {
                this.resources = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder create_time(Long r100) {
                this.create_time = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253672id = r100;
                return this;
            }

            public Builder position(Integer r100) {
                this.position = r100;
                return this;
            }

            public Builder resources(List<Resource> r100) {
                Internal.checkElementsNotNull(r100);
                this.resources = r100;
                return this;
            }

            public Builder thread_id(String r100) {
                this.thread_id = r100;
                return this;
            }

            public Builder thread_position(Integer r100) {
                this.thread_position = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageMeta extends ProtoAdapter<MessageMeta> {
            public ProtoAdapter_MessageMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253672id = "";
                r101.position = 0;
                r101.create_time = 0L;
                r101.thread_position = 0;
                r101.thread_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L13;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.thread_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.thread_position = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                r101.resources.add(Resource.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.create_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L11:
                r101.position = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                r101.f253672id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageMeta r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.f253671id);
                Integer r103 = r100.position;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
            L6:
                int r106 = ((r102 + r105) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.create_time)) + Resource.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.resources);
                Integer r107 = r100.thread_position;
                if (r107 == null) goto L9;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(5, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.thread_id;
                if (r110 == null) goto L14;
                r104 = r101.encodedSizeWithTag(6, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageMeta r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.f253671id);
                Integer r103 = r101.position;
                if (r103 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L5:
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.create_time);
                Resource.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.resources);
                Integer r104 = r101.thread_position;
                if (r104 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
            L8:
                String r105 = r101.thread_id;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 6, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageMeta();
            DEFAULT_POSITION = 0;
            DEFAULT_CREATE_TIME = 0L;
            DEFAULT_THREAD_POSITION = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253672id = this.f253671id;
            r100.position = this.position;
            r100.create_time = this.create_time;
            r100.resources = Internal.copyOf("resources", this.resources);
            r100.thread_position = this.thread_position;
            r100.thread_id = this.thread_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageMeta(String r100, Integer r110, Long r111, List<Resource> r112, Integer r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public MessageMeta(String r100, Integer r101, Long r102, List<Resource> r103, Integer r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.f253671id = r100;
            this.position = r101;
            this.create_time = r102;
            this.resources = Internal.immutableCopyOf("resources", r103);
            this.thread_position = r104;
            this.thread_id = r105;
        }
    }

    public static final class ProtoAdapter_GetChatResourcesResponse extends ProtoAdapter<GetChatResourcesResponse> implements c<GetChatResourcesResponse> {
        public ProtoAdapter_GetChatResourcesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatResourcesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatResourcesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_index = 0;
            Boolean r102 = Boolean.FALSE;
            r101.has_more_before = r102;
            r101.has_more_after = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.messages.add(MessageMeta.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.message_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.has_more_before = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.has_more_after = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatResourcesResponse r100) {
            int r101 = MessageMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.messages);
            Integer r102 = r100.message_index;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more_before;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.has_more_after;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatResourcesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatResourcesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatResourcesResponse r101) throws IOException {
            MessageMeta.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.messages);
            Integer r102 = r101.message_index;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.has_more_before;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.has_more_after;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatResourcesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Resource extends Message<Resource, Builder> {
        public static final ProtoAdapter<Resource> ADAPTER = null;
        public static final Boolean DEFAULT_IS_ORIGIN_SOURCE = null;
        public static final Long DEFAULT_ORIGIN_SIZE = null;
        public static final ChatResourceType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final ResourceCleanScene clean_resource_scene;
        public final ImageSet image;
        public final Boolean is_origin_source;
        public final Long origin_size;
        public final ChatResourceType type;
        public final MediaMeta video;

        public static final class Builder extends Message.Builder<Resource, Builder> {
            public ResourceCleanScene clean_resource_scene;
            public ImageSet image;
            public Boolean is_origin_source;
            public Long origin_size;
            public ChatResourceType type;
            public MediaMeta video;

            @Override // com.squareup.wire.Message.Builder
            public Resource build() {
                return new Resource(this.type, this.image, this.video, this.is_origin_source, this.origin_size, this.clean_resource_scene, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder clean_resource_scene(ResourceCleanScene r100) {
                this.clean_resource_scene = r100;
                return this;
            }

            public Builder image(ImageSet r100) {
                this.image = r100;
                return this;
            }

            public Builder is_origin_source(Boolean r100) {
                this.is_origin_source = r100;
                return this;
            }

            public Builder origin_size(Long r100) {
                this.origin_size = r100;
                return this;
            }

            public Builder type(ChatResourceType r100) {
                this.type = r100;
                return this;
            }

            public Builder video(MediaMeta r100) {
                this.video = r100;
                return this;
            }
        }

        public static final class MediaMeta extends Message<MediaMeta, Builder> {
            public static final ProtoAdapter<MediaMeta> ADAPTER = null;
            public static final String DEFAULT_FILE_PATH = "";
            private static final long serialVersionUID = 0;
            public final String file_path;
            public final MediaContent media_content;

            public static final class Builder extends Message.Builder<MediaMeta, Builder> {
                public String file_path;
                public MediaContent media_content;

                @Override // com.squareup.wire.Message.Builder
                public MediaMeta build() {
                    MediaContent r100 = this.media_content;
                    if (r100 == null) goto L7;
                    return new MediaMeta(this.media_content, this.file_path, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "media_content"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder file_path(String r100) {
                    this.file_path = r100;
                    return this;
                }

                public Builder media_content(MediaContent r100) {
                    this.media_content = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_MediaMeta extends ProtoAdapter<MediaMeta> {
                public ProtoAdapter_MediaMeta() {
                    super(FieldEncoding.LENGTH_DELIMITED, MediaMeta.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public MediaMeta decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.file_path = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.media_content = MediaContent.ADAPTER.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.file_path = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(MediaMeta r100) {
                    int r101 = MediaContent.ADAPTER.encodedSizeWithTag(1, r100.media_content);
                    String r102 = r100.file_path;
                    if (r102 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
                L7:
                    return (r101 + r103) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ MediaMeta decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(MediaMeta r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, MediaMeta r101) throws IOException {
                    MediaContent.ADAPTER.encodeWithTag(r100, 1, r101.media_content);
                    String r102 = r101.file_path;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MediaMeta r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_MediaMeta();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.media_content = this.media_content;
                r100.file_path = this.file_path;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return MediaMeta.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public MediaMeta(MediaContent r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public MediaMeta(MediaContent r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.media_content = r100;
                this.file_path = r101;
            }
        }

        public static final class ProtoAdapter_Resource extends ProtoAdapter<Resource> {
            public ProtoAdapter_Resource() {
                super(FieldEncoding.LENGTH_DELIMITED, Resource.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Resource decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ChatResourceType.IMAGE;
                r101.is_origin_source = Boolean.FALSE;
                r101.origin_size = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r101.type = ChatResourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.clean_resource_scene = ResourceCleanScene.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.origin_size = ProtoAdapter.UINT64.decode(r100);
                goto L3
            L9:
                r101.is_origin_source = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                r101.video = MediaMeta.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.image = ImageSet.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L16:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Resource r100) {
                ChatResourceType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ChatResourceType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ImageSet r104 = r100.image;
                if (r104 == null) goto L9;
                int r105 = ImageSet.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                MediaMeta r107 = r100.video;
                if (r107 == null) goto L13;
                int r108 = MediaMeta.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_origin_source;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Long r113 = r100.origin_size;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.UINT64.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                ResourceCleanScene r116 = r100.clean_resource_scene;
                if (r116 == null) goto L26;
                r102 = ResourceCleanScene.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
            L21:
                r114 = 0;
                goto L22
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
            public /* bridge */ /* synthetic */ Resource decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Resource r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Resource r101) throws IOException {
                ChatResourceType r102 = r101.type;
                if (r102 == null) goto L5;
                ChatResourceType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ImageSet r103 = r101.image;
                if (r103 == null) goto L8;
                ImageSet.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                MediaMeta r104 = r101.video;
                if (r104 == null) goto L11;
                MediaMeta.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.is_origin_source;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                Long r106 = r101.origin_size;
                if (r106 == null) goto L17;
                ProtoAdapter.UINT64.encodeWithTag(r100, 5, r106);
            L17:
                ResourceCleanScene r107 = r101.clean_resource_scene;
                if (r107 == null) goto L20;
                ResourceCleanScene.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Resource r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Resource();
            DEFAULT_TYPE = ChatResourceType.IMAGE;
            DEFAULT_IS_ORIGIN_SOURCE = Boolean.FALSE;
            DEFAULT_ORIGIN_SIZE = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.image = this.image;
            r100.video = this.video;
            r100.is_origin_source = this.is_origin_source;
            r100.origin_size = this.origin_size;
            r100.clean_resource_scene = this.clean_resource_scene;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Resource.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Resource(ChatResourceType r100, ImageSet r110, MediaMeta r111, Boolean r112, Long r113, ResourceCleanScene r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public Resource(ChatResourceType r100, ImageSet r101, MediaMeta r102, Boolean r103, Long r104, ResourceCleanScene r105, ByteString r106) {
            super(ADAPTER, r106);
            this.type = r100;
            this.image = r101;
            this.video = r102;
            this.is_origin_source = r103;
            this.origin_size = r104;
            this.clean_resource_scene = r105;
        }
    }

    static {
        ProtoAdapter_GetChatResourcesResponse r100 = new ProtoAdapter_GetChatResourcesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MESSAGE_INDEX = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_HAS_MORE_BEFORE = r101;
        DEFAULT_HAS_MORE_AFTER = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.messages = Internal.copyOf("messages", this.messages);
        r100.message_index = this.message_index;
        r100.has_more_before = this.has_more_before;
        r100.has_more_after = this.has_more_after;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatResourcesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatResourcesResponse(List<MessageMeta> r100, Integer r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetChatResourcesResponse(List<MessageMeta> r100, Integer r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.messages = Internal.immutableCopyOf("messages", r100);
        this.message_index = r101;
        this.has_more_before = r102;
        this.has_more_after = r103;
    }
}
