package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UrlPreviewEntity extends com.squareup.wire.Message<UrlPreviewEntity, Builder> {
    public static final ProtoAdapter<UrlPreviewEntity> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SDK_PREVIEW = null;
    public static final Boolean DEFAULT_NEED_RELOAD = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_SDK_DESCRIPTION = "";
    public static final String DEFAULT_SDK_DOMAIN = "";
    public static final String DEFAULT_SDK_FAVICON_URL = "";
    public static final String DEFAULT_SDK_ICON_URL = "";
    public static final String DEFAULT_SDK_IFRAME_URL = "";
    public static final String DEFAULT_SDK_SITE_NAME = "";
    public static final URLPreviewComponent.VideoProperty.Site DEFAULT_SDK_SITE_TYPE = null;
    public static final String DEFAULT_SDK_TITLE = "";
    public static final String DEFAULT_SDK_VIDEO_ID = "";
    public static final String DEFAULT_SERVER_ICON_KEY = "";
    public static final String DEFAULT_SERVER_TAG = "";
    public static final String DEFAULT_SERVER_TITLE = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final Boolean DEFAULT_USE_COLOR_ICON = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final AppInfo app_info;
    public final ExtInfo ext_info;
    public final Boolean is_sdk_preview;
    public final Boolean need_reload;
    public final URLPreviewBody preview_body;
    public final String preview_id;
    public final RenderRouterEntity render_router_entity;
    public final String sdk_description;
    public final String sdk_domain;
    public final String sdk_favicon_url;
    public final String sdk_icon_url;
    public final String sdk_iframe_url;
    public final String sdk_site_name;
    public final URLPreviewComponent.VideoProperty.Site sdk_site_type;
    public final String sdk_title;
    public final String sdk_video_id;
    public final ImageSetPassThrough server_icon_image;
    public final String server_icon_key;
    public final String server_tag;
    public final String server_title;
    public final String source_id;
    public final UDIcon ud_icon;
    public final UnifiedHeader unified_header;
    public final URL url;
    public final Boolean use_color_icon;
    public final Integer version;

    public static final class AppInfo extends com.squareup.wire.Message<AppInfo, Builder> {
        public static final ProtoAdapter<AppInfo> ADAPTER = null;
        public static final Long DEFAULT_APP_ID = null;
        public static final Long DEFAULT_SCENE_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Long app_id;
        public final Long scene_type;

        public static final class Builder extends com.squareup.wire.Message.Builder<AppInfo, Builder> {
            public Long app_id;
            public Long scene_type;

            @Override // com.squareup.wire.Message.Builder
            public AppInfo build() {
                return new AppInfo(this.app_id, this.scene_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder app_id(Long r100) {
                this.app_id = r100;
                return this;
            }

            public Builder scene_type(Long r100) {
                this.scene_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AppInfo extends ProtoAdapter<AppInfo> {
            public ProtoAdapter_AppInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AppInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AppInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.app_id = 0L;
                r101.scene_type = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.app_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.scene_type = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(AppInfo r100) {
                Long r101 = r100.app_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.scene_type;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AppInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AppInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AppInfo r101) throws IOException {
                Long r102 = r101.app_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.scene_type;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppInfo();
            DEFAULT_APP_ID = 0L;
            DEFAULT_SCENE_TYPE = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.app_id = this.app_id;
            r100.scene_type = this.scene_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AppInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AppInfo(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AppInfo(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.app_id = r100;
            this.scene_type = r101;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<UrlPreviewEntity, Builder> {
        public AppInfo app_info;
        public ExtInfo ext_info;
        public Boolean is_sdk_preview;
        public Boolean need_reload;
        public URLPreviewBody preview_body;
        public String preview_id;
        public RenderRouterEntity render_router_entity;
        public String sdk_description;
        public String sdk_domain;
        public String sdk_favicon_url;
        public String sdk_icon_url;
        public String sdk_iframe_url;
        public String sdk_site_name;
        public URLPreviewComponent.VideoProperty.Site sdk_site_type;
        public String sdk_title;
        public String sdk_video_id;
        public ImageSetPassThrough server_icon_image;
        public String server_icon_key;
        public String server_tag;
        public String server_title;
        public String source_id;
        public UDIcon ud_icon;
        public UnifiedHeader unified_header;
        public URL url;
        public Boolean use_color_icon;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public UrlPreviewEntity build() {
            String r100 = this.source_id;
            if (r100 == null) goto L9;
            if (this.preview_id == null) goto L9;
            return new UrlPreviewEntity(this.app_info, this.source_id, this.preview_id, this.url, this.server_icon_key, this.server_title, this.server_tag, this.ud_icon, this.server_icon_image, this.use_color_icon, this.version, this.preview_body, this.render_router_entity, this.unified_header, this.is_sdk_preview, this.sdk_icon_url, this.sdk_title, this.sdk_description, this.sdk_favicon_url, this.sdk_domain, this.sdk_iframe_url, this.sdk_site_name, this.sdk_site_type, this.sdk_video_id, this.need_reload, this.ext_info, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_id", this.preview_id, "preview_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_info(AppInfo r100) {
            this.app_info = r100;
            return this;
        }

        public Builder ext_info(ExtInfo r100) {
            this.ext_info = r100;
            return this;
        }

        public Builder is_sdk_preview(Boolean r100) {
            this.is_sdk_preview = r100;
            return this;
        }

        public Builder need_reload(Boolean r100) {
            this.need_reload = r100;
            return this;
        }

        public Builder preview_body(URLPreviewBody r100) {
            this.preview_body = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }

        public Builder render_router_entity(RenderRouterEntity r100) {
            this.render_router_entity = r100;
            return this;
        }

        public Builder sdk_description(String r100) {
            this.sdk_description = r100;
            return this;
        }

        public Builder sdk_domain(String r100) {
            this.sdk_domain = r100;
            return this;
        }

        public Builder sdk_favicon_url(String r100) {
            this.sdk_favicon_url = r100;
            return this;
        }

        public Builder sdk_icon_url(String r100) {
            this.sdk_icon_url = r100;
            return this;
        }

        public Builder sdk_iframe_url(String r100) {
            this.sdk_iframe_url = r100;
            return this;
        }

        public Builder sdk_site_name(String r100) {
            this.sdk_site_name = r100;
            return this;
        }

        public Builder sdk_site_type(URLPreviewComponent.VideoProperty.Site r100) {
            this.sdk_site_type = r100;
            return this;
        }

        public Builder sdk_title(String r100) {
            this.sdk_title = r100;
            return this;
        }

        public Builder sdk_video_id(String r100) {
            this.sdk_video_id = r100;
            return this;
        }

        public Builder server_icon_image(ImageSetPassThrough r100) {
            this.server_icon_image = r100;
            return this;
        }

        public Builder server_icon_key(String r100) {
            this.server_icon_key = r100;
            return this;
        }

        public Builder server_tag(String r100) {
            this.server_tag = r100;
            return this;
        }

        public Builder server_title(String r100) {
            this.server_title = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder ud_icon(UDIcon r100) {
            this.ud_icon = r100;
            return this;
        }

        public Builder unified_header(UnifiedHeader r100) {
            this.unified_header = r100;
            return this;
        }

        public Builder url(URL r100) {
            this.url = r100;
            return this;
        }

        public Builder use_color_icon(Boolean r100) {
            this.use_color_icon = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ColorIcon extends com.squareup.wire.Message<ColorIcon, Builder> {
        public static final ProtoAdapter<ColorIcon> ADAPTER = null;
        public static final String DEFAULT_FAVICON_URL = "";
        private static final long serialVersionUID = 0;
        public final String favicon_url;
        public final ImageSet icon;
        public final ThemeColor icon_color;
        public final UDIcon ud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColorIcon, Builder> {
            public String favicon_url;
            public ImageSet icon;
            public ThemeColor icon_color;
            public UDIcon ud_icon;

            @Override // com.squareup.wire.Message.Builder
            public ColorIcon build() {
                return new ColorIcon(this.icon, this.favicon_url, this.icon_color, this.ud_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder favicon_url(String r100) {
                this.favicon_url = r100;
                return this;
            }

            public Builder icon(ImageSet r100) {
                this.icon = r100;
                return this;
            }

            public Builder icon_color(ThemeColor r100) {
                this.icon_color = r100;
                return this;
            }

            public Builder ud_icon(UDIcon r100) {
                this.ud_icon = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ColorIcon extends ProtoAdapter<ColorIcon> {
            public ProtoAdapter_ColorIcon() {
                super(FieldEncoding.LENGTH_DELIMITED, ColorIcon.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ColorIcon decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.favicon_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.icon = ImageSet.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.favicon_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.icon_color = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ColorIcon r100) {
                ImageSet r101 = r100.icon;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.favicon_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ThemeColor r107 = r100.icon_color;
                if (r107 == null) goto L13;
                int r108 = ThemeColor.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                UDIcon r110 = r100.ud_icon;
                if (r110 == null) goto L18;
                r102 = UDIcon.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ColorIcon decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ColorIcon r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ColorIcon r101) throws IOException {
                ImageSet r102 = r101.icon;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.favicon_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ThemeColor r104 = r101.icon_color;
                if (r104 == null) goto L11;
                ThemeColor.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                UDIcon r105 = r101.ud_icon;
                if (r105 == null) goto L14;
                UDIcon.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ColorIcon r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColorIcon();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon = this.icon;
            r100.favicon_url = this.favicon_url;
            r100.icon_color = this.icon_color;
            r100.ud_icon = this.ud_icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ColorIcon.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ColorIcon(ImageSet r100, String r101, ThemeColor r102, UDIcon r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ColorIcon(ImageSet r100, String r101, ThemeColor r102, UDIcon r103, ByteString r104) {
            super(ADAPTER, r104);
            this.icon = r100;
            this.favicon_url = r101;
            this.icon_color = r102;
            this.ud_icon = r103;
        }
    }

    public static final class ComponentRootDisplayVariant extends com.squareup.wire.Message<ComponentRootDisplayVariant, Builder> {
        public static final ProtoAdapter<ComponentRootDisplayVariant> ADAPTER = null;
        public static final String DEFAULT_COMPACT_ROOT_ID = "";
        public static final String DEFAULT_DEFAULT_ROOT_ID = "";
        private static final long serialVersionUID = 0;
        public final String compact_root_id;
        public final String default_root_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<ComponentRootDisplayVariant, Builder> {
            public String compact_root_id;
            public String default_root_id;

            @Override // com.squareup.wire.Message.Builder
            public ComponentRootDisplayVariant build() {
                return new ComponentRootDisplayVariant(this.default_root_id, this.compact_root_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder compact_root_id(String r100) {
                this.compact_root_id = r100;
                return this;
            }

            public Builder default_root_id(String r100) {
                this.default_root_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ComponentRootDisplayVariant extends ProtoAdapter<ComponentRootDisplayVariant> {
            public ProtoAdapter_ComponentRootDisplayVariant() {
                super(FieldEncoding.LENGTH_DELIMITED, ComponentRootDisplayVariant.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ComponentRootDisplayVariant decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.default_root_id = "";
                r101.compact_root_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.default_root_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.compact_root_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(ComponentRootDisplayVariant r100) {
                String r101 = r100.default_root_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.compact_root_id;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ComponentRootDisplayVariant decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ComponentRootDisplayVariant r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ComponentRootDisplayVariant r101) throws IOException {
                String r102 = r101.default_root_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.compact_root_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ComponentRootDisplayVariant r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ComponentRootDisplayVariant();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.default_root_id = this.default_root_id;
            r100.compact_root_id = this.compact_root_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ComponentRootDisplayVariant.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ComponentRootDisplayVariant(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ComponentRootDisplayVariant(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.default_root_id = r100;
            this.compact_root_id = r101;
        }
    }

    public static final class DocInfo extends com.squareup.wire.Message<DocInfo, Builder> {
        public static final ProtoAdapter<DocInfo> ADAPTER = null;
        public static final String DEFAULT_FILE_NAME = "";
        public static final String DEFAULT_FILE_TOKEN = "";
        public static final Long DEFAULT_FILE_TYPE = null;
        public static final String DEFAULT_MOUNT_POINT = "";
        private static final long serialVersionUID = 0;
        public final String file_name;
        public final String file_token;
        public final Long file_type;
        public final String mount_point;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocInfo, Builder> {
            public String file_name;
            public String file_token;
            public Long file_type;
            public String mount_point;

            @Override // com.squareup.wire.Message.Builder
            public DocInfo build() {
                return new DocInfo(this.file_token, this.mount_point, this.file_name, this.file_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder file_name(String r100) {
                this.file_name = r100;
                return this;
            }

            public Builder file_token(String r100) {
                this.file_token = r100;
                return this;
            }

            public Builder file_type(Long r100) {
                this.file_type = r100;
                return this;
            }

            public Builder mount_point(String r100) {
                this.mount_point = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocInfo extends ProtoAdapter<DocInfo> {
            public ProtoAdapter_DocInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DocInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.file_token = "";
                r101.mount_point = "";
                r101.file_name = "";
                r101.file_type = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.file_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mount_point = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.file_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.file_type = ProtoAdapter.INT64.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DocInfo r100) {
                String r101 = r100.file_token;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mount_point;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.file_name;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Long r110 = r100.file_type;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ DocInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocInfo r101) throws IOException {
                String r102 = r101.file_token;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mount_point;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.file_name;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Long r105 = r101.file_type;
                if (r105 == null) goto L14;
                ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocInfo();
            DEFAULT_FILE_TYPE = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.file_token = this.file_token;
            r100.mount_point = this.mount_point;
            r100.file_name = this.file_name;
            r100.file_type = this.file_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocInfo(String r100, String r101, String r102, Long r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public DocInfo(String r100, String r101, String r102, Long r103, ByteString r104) {
            super(ADAPTER, r104);
            this.file_token = r100;
            this.mount_point = r101;
            this.file_name = r102;
            this.file_type = r103;
        }
    }

    public static final class ExtInfo extends com.squareup.wire.Message<ExtInfo, Builder> {
        public static final ProtoAdapter<ExtInfo> ADAPTER = null;
        public static final SingleCardMode DEFAULT_SINGLE_CARD_MODE = null;
        private static final long serialVersionUID = 0;
        public final ComponentRootDisplayVariant component_root_display_variant;
        public final DocInfo doc_info;
        public final LastUpdateInfo last_update_info;
        public final SingleCardMode single_card_mode;
        public final TranslateInfo translate_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<ExtInfo, Builder> {
            public ComponentRootDisplayVariant component_root_display_variant;
            public DocInfo doc_info;
            public LastUpdateInfo last_update_info;
            public SingleCardMode single_card_mode;
            public TranslateInfo translate_info;

            @Override // com.squareup.wire.Message.Builder
            public ExtInfo build() {
                return new ExtInfo(this.last_update_info, this.translate_info, this.single_card_mode, this.doc_info, this.component_root_display_variant, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder component_root_display_variant(ComponentRootDisplayVariant r100) {
                this.component_root_display_variant = r100;
                return this;
            }

            public Builder doc_info(DocInfo r100) {
                this.doc_info = r100;
                return this;
            }

            public Builder last_update_info(LastUpdateInfo r100) {
                this.last_update_info = r100;
                return this;
            }

            public Builder single_card_mode(SingleCardMode r100) {
                this.single_card_mode = r100;
                return this;
            }

            public Builder translate_info(TranslateInfo r100) {
                this.translate_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtInfo extends ProtoAdapter<ExtInfo> {
            public ProtoAdapter_ExtInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.single_card_mode = SingleCardMode.AUTO;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.last_update_info = LastUpdateInfo.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.translate_info = TranslateInfo.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.single_card_mode = SingleCardMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.doc_info = DocInfo.ADAPTER.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.component_root_display_variant = ComponentRootDisplayVariant.ADAPTER.decode(r100);
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
            public int encodedSize2(ExtInfo r100) {
                LastUpdateInfo r101 = r100.last_update_info;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = LastUpdateInfo.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                TranslateInfo r104 = r100.translate_info;
                if (r104 == null) goto L9;
                int r105 = TranslateInfo.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                SingleCardMode r107 = r100.single_card_mode;
                if (r107 == null) goto L13;
                int r108 = SingleCardMode.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                DocInfo r110 = r100.doc_info;
                if (r110 == null) goto L17;
                int r111 = DocInfo.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ComponentRootDisplayVariant r113 = r100.component_root_display_variant;
                if (r113 == null) goto L22;
                r102 = ComponentRootDisplayVariant.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ ExtInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtInfo r101) throws IOException {
                LastUpdateInfo r102 = r101.last_update_info;
                if (r102 == null) goto L5;
                LastUpdateInfo.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                TranslateInfo r103 = r101.translate_info;
                if (r103 == null) goto L8;
                TranslateInfo.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                SingleCardMode r104 = r101.single_card_mode;
                if (r104 == null) goto L11;
                SingleCardMode.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                DocInfo r105 = r101.doc_info;
                if (r105 == null) goto L14;
                DocInfo.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                ComponentRootDisplayVariant r106 = r101.component_root_display_variant;
                if (r106 == null) goto L17;
                ComponentRootDisplayVariant.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtInfo();
            DEFAULT_SINGLE_CARD_MODE = SingleCardMode.AUTO;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.last_update_info = this.last_update_info;
            r100.translate_info = this.translate_info;
            r100.single_card_mode = this.single_card_mode;
            r100.doc_info = this.doc_info;
            r100.component_root_display_variant = this.component_root_display_variant;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtInfo(LastUpdateInfo r100, TranslateInfo r101, SingleCardMode r110, DocInfo r111, ComponentRootDisplayVariant r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ExtInfo(LastUpdateInfo r100, TranslateInfo r101, SingleCardMode r102, DocInfo r103, ComponentRootDisplayVariant r104, ByteString r105) {
            super(ADAPTER, r105);
            this.last_update_info = r100;
            this.translate_info = r101;
            this.single_card_mode = r102;
            this.doc_info = r103;
            this.component_root_display_variant = r104;
        }
    }

    public static final class LastUpdateInfo extends com.squareup.wire.Message<LastUpdateInfo, Builder> {
        public static final ProtoAdapter<LastUpdateInfo> ADAPTER = null;
        public static final Long DEFAULT_LAST_UPDATE_TIMESTAMP = null;
        public static final Boolean DEFAULT_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final Long last_update_timestamp;
        public final ThemeColor text_color;
        public final Boolean visible;

        public static final class Builder extends com.squareup.wire.Message.Builder<LastUpdateInfo, Builder> {
            public Long last_update_timestamp;
            public ThemeColor text_color;
            public Boolean visible;

            @Override // com.squareup.wire.Message.Builder
            public LastUpdateInfo build() {
                return new LastUpdateInfo(this.text_color, this.last_update_timestamp, this.visible, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder last_update_timestamp(Long r100) {
                this.last_update_timestamp = r100;
                return this;
            }

            public Builder text_color(ThemeColor r100) {
                this.text_color = r100;
                return this;
            }

            public Builder visible(Boolean r100) {
                this.visible = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LastUpdateInfo extends ProtoAdapter<LastUpdateInfo> {
            public ProtoAdapter_LastUpdateInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, LastUpdateInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LastUpdateInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.last_update_timestamp = 0L;
                r101.visible = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 2) goto L8;
                r101.text_color = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 3) goto L10;
                r101.last_update_timestamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 4) goto L11;
                r101.visible = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(LastUpdateInfo r100) {
                ThemeColor r101 = r100.text_color;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r101);
            L6:
                Long r104 = r100.last_update_timestamp;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(3, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.visible;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LastUpdateInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LastUpdateInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LastUpdateInfo r101) throws IOException {
                ThemeColor r102 = r101.text_color;
                if (r102 == null) goto L5;
                ThemeColor.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                Long r103 = r101.last_update_timestamp;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
            L8:
                Boolean r104 = r101.visible;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LastUpdateInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LastUpdateInfo();
            DEFAULT_LAST_UPDATE_TIMESTAMP = 0L;
            DEFAULT_VISIBLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text_color = this.text_color;
            r100.last_update_timestamp = this.last_update_timestamp;
            r100.visible = this.visible;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LastUpdateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LastUpdateInfo(ThemeColor r100, Long r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public LastUpdateInfo(ThemeColor r100, Long r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.text_color = r100;
            this.last_update_timestamp = r101;
            this.visible = r102;
        }
    }

    public static final class ProtoAdapter_UrlPreviewEntity extends ProtoAdapter<UrlPreviewEntity> {
        public ProtoAdapter_UrlPreviewEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, UrlPreviewEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UrlPreviewEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.preview_id = "";
            r101.server_icon_key = "";
            r101.server_title = "";
            r101.server_tag = "";
            Boolean r102 = Boolean.FALSE;
            r101.use_color_icon = r102;
            r101.version = 0;
            r101.is_sdk_preview = r102;
            r101.sdk_icon_url = "";
            r101.sdk_title = "";
            r101.sdk_description = "";
            r101.sdk_favicon_url = "";
            r101.sdk_domain = "";
            r101.sdk_iframe_url = "";
            r101.sdk_site_name = "";
            r101.sdk_site_type = URLPreviewComponent.VideoProperty.Site.UNKNOWN;
            r101.sdk_video_id = "";
            r101.need_reload = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L36;
            switch(r104) {
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                case 17: goto L19;
                case 18: goto L38;
                case 19: goto L14;
                case 20: goto L13;
                case 21: goto L12;
                case 22: goto L11;
                case 23: goto L10;
                case 24: goto L9;
                case 25: goto L8;
                case 26: goto L7;
                default: goto L6;
            };
        L38:
            r101.sdk_site_type = URLPreviewComponent.VideoProperty.Site.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.ext_info = ExtInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.use_color_icon = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.render_router_entity = RenderRouterEntity.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.unified_header = UnifiedHeader.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.app_info = AppInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.need_reload = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.is_sdk_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.sdk_video_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.sdk_site_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.sdk_iframe_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.server_icon_image = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.ud_icon = UDIcon.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.sdk_domain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.sdk_favicon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.sdk_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.sdk_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.sdk_icon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.preview_body = URLPreviewBody.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L30:
            r101.url = URL.ADAPTER.decode(r100);
            goto L3
        L31:
            r101.server_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.server_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.server_icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L36:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UrlPreviewEntity r100) {
            AppInfo r101 = r100.app_info;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AppInfo.ADAPTER.encodedSizeWithTag(22, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = (r103 + r104.encodedSizeWithTag(1, r100.source_id)) + r104.encodedSizeWithTag(2, r100.preview_id);
            URL r106 = r100.url;
            if (r106 == null) goto L9;
            int r107 = URL.ADAPTER.encodedSizeWithTag(6, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.server_icon_key;
            if (r109 == null) goto L13;
            int r110 = r104.encodedSizeWithTag(3, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.server_title;
            if (r112 == null) goto L17;
            int r113 = r104.encodedSizeWithTag(4, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.server_tag;
            if (r115 == null) goto L21;
            int r116 = r104.encodedSizeWithTag(5, r115);
        L22:
            int r117 = r114 + r116;
            UDIcon r118 = r100.ud_icon;
            if (r118 == null) goto L25;
            int r119 = UDIcon.ADAPTER.encodedSizeWithTag(14, r118);
        L26:
            int r120 = r117 + r119;
            ImageSetPassThrough r121 = r100.server_icon_image;
            if (r121 == null) goto L29;
            int r122 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(15, r121);
        L30:
            int r123 = r120 + r122;
            Boolean r124 = r100.use_color_icon;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r124);
        L34:
            int r126 = r123 + r125;
            Integer r127 = r100.version;
            if (r127 == null) goto L37;
            int r128 = ProtoAdapter.INT32.encodedSizeWithTag(7, r127);
        L38:
            int r129 = r126 + r128;
            URLPreviewBody r130 = r100.preview_body;
            if (r130 == null) goto L41;
            int r131 = URLPreviewBody.ADAPTER.encodedSizeWithTag(8, r130);
        L42:
            int r132 = r129 + r131;
            RenderRouterEntity r133 = r100.render_router_entity;
            if (r133 == null) goto L45;
            int r134 = RenderRouterEntity.ADAPTER.encodedSizeWithTag(24, r133);
        L46:
            int r135 = r132 + r134;
            UnifiedHeader r136 = r100.unified_header;
            if (r136 == null) goto L49;
            int r137 = UnifiedHeader.ADAPTER.encodedSizeWithTag(23, r136);
        L50:
            int r138 = r135 + r137;
            Boolean r139 = r100.is_sdk_preview;
            if (r139 == null) goto L53;
            int r140 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r139);
        L54:
            int r141 = r138 + r140;
            String r142 = r100.sdk_icon_url;
            if (r142 == null) goto L57;
            int r143 = r104.encodedSizeWithTag(9, r142);
        L58:
            int r144 = r141 + r143;
            String r145 = r100.sdk_title;
            if (r145 == null) goto L61;
            int r146 = r104.encodedSizeWithTag(10, r145);
        L62:
            int r147 = r144 + r146;
            String r148 = r100.sdk_description;
            if (r148 == null) goto L65;
            int r149 = r104.encodedSizeWithTag(11, r148);
        L66:
            int r150 = r147 + r149;
            String r151 = r100.sdk_favicon_url;
            if (r151 == null) goto L69;
            int r152 = r104.encodedSizeWithTag(12, r151);
        L70:
            int r153 = r150 + r152;
            String r154 = r100.sdk_domain;
            if (r154 == null) goto L73;
            int r155 = r104.encodedSizeWithTag(13, r154);
        L74:
            int r156 = r153 + r155;
            String r157 = r100.sdk_iframe_url;
            if (r157 == null) goto L77;
            int r158 = r104.encodedSizeWithTag(16, r157);
        L78:
            int r159 = r156 + r158;
            String r160 = r100.sdk_site_name;
            if (r160 == null) goto L81;
            int r161 = r104.encodedSizeWithTag(17, r160);
        L82:
            int r162 = r159 + r161;
            URLPreviewComponent.VideoProperty.Site r163 = r100.sdk_site_type;
            if (r163 == null) goto L85;
            int r164 = URLPreviewComponent.VideoProperty.Site.ADAPTER.encodedSizeWithTag(18, r163);
        L86:
            int r165 = r162 + r164;
            String r166 = r100.sdk_video_id;
            if (r166 == null) goto L89;
            int r167 = r104.encodedSizeWithTag(19, r166);
        L90:
            int r168 = r165 + r167;
            Boolean r169 = r100.need_reload;
            if (r169 == null) goto L93;
            int r170 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r169);
        L94:
            int r171 = r168 + r170;
            ExtInfo r172 = r100.ext_info;
            if (r172 == null) goto L98;
            r102 = ExtInfo.ADAPTER.encodedSizeWithTag(26, r172);
        L98:
            return (r171 + r102) + r100.unknownFields().size();
        L93:
            r170 = 0;
            goto L94
        L89:
            r167 = 0;
            goto L90
        L85:
            r164 = 0;
            goto L86
        L81:
            r161 = 0;
            goto L82
        L77:
            r158 = 0;
            goto L78
        L73:
            r155 = 0;
            goto L74
        L69:
            r152 = 0;
            goto L70
        L65:
            r149 = 0;
            goto L66
        L61:
            r146 = 0;
            goto L62
        L57:
            r143 = 0;
            goto L58
        L53:
            r140 = 0;
            goto L54
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
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
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UrlPreviewEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UrlPreviewEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UrlPreviewEntity r101) throws IOException {
            AppInfo r102 = r101.app_info;
            if (r102 == null) goto L5;
            AppInfo.ADAPTER.encodeWithTag(r100, 22, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 1, r101.source_id);
            r103.encodeWithTag(r100, 2, r101.preview_id);
            URL r104 = r101.url;
            if (r104 == null) goto L8;
            URL.ADAPTER.encodeWithTag(r100, 6, r104);
        L8:
            String r105 = r101.server_icon_key;
            if (r105 == null) goto L11;
            r103.encodeWithTag(r100, 3, r105);
        L11:
            String r106 = r101.server_title;
            if (r106 == null) goto L14;
            r103.encodeWithTag(r100, 4, r106);
        L14:
            String r107 = r101.server_tag;
            if (r107 == null) goto L17;
            r103.encodeWithTag(r100, 5, r107);
        L17:
            UDIcon r108 = r101.ud_icon;
            if (r108 == null) goto L20;
            UDIcon.ADAPTER.encodeWithTag(r100, 14, r108);
        L20:
            ImageSetPassThrough r109 = r101.server_icon_image;
            if (r109 == null) goto L23;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 15, r109);
        L23:
            Boolean r110 = r101.use_color_icon;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 25, r110);
        L26:
            Integer r111 = r101.version;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r111);
        L29:
            URLPreviewBody r112 = r101.preview_body;
            if (r112 == null) goto L32;
            URLPreviewBody.ADAPTER.encodeWithTag(r100, 8, r112);
        L32:
            RenderRouterEntity r113 = r101.render_router_entity;
            if (r113 == null) goto L35;
            RenderRouterEntity.ADAPTER.encodeWithTag(r100, 24, r113);
        L35:
            UnifiedHeader r114 = r101.unified_header;
            if (r114 == null) goto L38;
            UnifiedHeader.ADAPTER.encodeWithTag(r100, 23, r114);
        L38:
            Boolean r115 = r101.is_sdk_preview;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 20, r115);
        L41:
            String r116 = r101.sdk_icon_url;
            if (r116 == null) goto L44;
            r103.encodeWithTag(r100, 9, r116);
        L44:
            String r117 = r101.sdk_title;
            if (r117 == null) goto L47;
            r103.encodeWithTag(r100, 10, r117);
        L47:
            String r118 = r101.sdk_description;
            if (r118 == null) goto L50;
            r103.encodeWithTag(r100, 11, r118);
        L50:
            String r119 = r101.sdk_favicon_url;
            if (r119 == null) goto L53;
            r103.encodeWithTag(r100, 12, r119);
        L53:
            String r120 = r101.sdk_domain;
            if (r120 == null) goto L56;
            r103.encodeWithTag(r100, 13, r120);
        L56:
            String r121 = r101.sdk_iframe_url;
            if (r121 == null) goto L59;
            r103.encodeWithTag(r100, 16, r121);
        L59:
            String r122 = r101.sdk_site_name;
            if (r122 == null) goto L62;
            r103.encodeWithTag(r100, 17, r122);
        L62:
            URLPreviewComponent.VideoProperty.Site r123 = r101.sdk_site_type;
            if (r123 == null) goto L65;
            URLPreviewComponent.VideoProperty.Site.ADAPTER.encodeWithTag(r100, 18, r123);
        L65:
            String r124 = r101.sdk_video_id;
            if (r124 == null) goto L68;
            r103.encodeWithTag(r100, 19, r124);
        L68:
            Boolean r125 = r101.need_reload;
            if (r125 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r125);
        L71:
            ExtInfo r126 = r101.ext_info;
            if (r126 == null) goto L74;
            ExtInfo.ADAPTER.encodeWithTag(r100, 26, r126);
        L74:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrlPreviewEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SingleCardMode extends Enum<SingleCardMode> implements WireEnum {
        private static final /* synthetic */ SingleCardMode[] $VALUES = null;
        public static final ProtoAdapter<SingleCardMode> ADAPTER = null;
        public static final SingleCardMode AUTO = null;
        public static final SingleCardMode INLINE_DISPLAY = null;
        public static final SingleCardMode INLINE_NOT_DISPLAY = null;
        private final int value;

        static {
            SingleCardMode r100 = new SingleCardMode("AUTO", 0, 0);
            AUTO = r100;
            SingleCardMode r101 = new SingleCardMode("INLINE_NOT_DISPLAY", 1, 1);
            INLINE_NOT_DISPLAY = r101;
            SingleCardMode r102 = new SingleCardMode("INLINE_DISPLAY", 2, 2);
            INLINE_DISPLAY = r102;
            $VALUES = new SingleCardMode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SingleCardMode.class);
        }

        public static SingleCardMode[] values() {
            return (SingleCardMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SingleCardMode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return INLINE_DISPLAY;
        L12:
            return INLINE_NOT_DISPLAY;
        L14:
            return AUTO;
        }

        public static SingleCardMode valueOf(String r100) {
            return (SingleCardMode) a.a(SingleCardMode.class, r100);
        }

        private SingleCardMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TranslateInfo extends com.squareup.wire.Message<TranslateInfo, Builder> {
        public static final ProtoAdapter<TranslateInfo> ADAPTER = null;
        public static final String DEFAULT_INLINE_REPLACEMENT_ELEMENT_ID = "";
        public static final String DEFAULT_INLINE_REPLACEMENT_ENGINE_PROPERTY_PATH = "";
        private static final long serialVersionUID = 0;
        public final String inline_replacement_element_id;
        public final String inline_replacement_engine_property_path;

        public static final class Builder extends com.squareup.wire.Message.Builder<TranslateInfo, Builder> {
            public String inline_replacement_element_id;
            public String inline_replacement_engine_property_path;

            @Override // com.squareup.wire.Message.Builder
            public TranslateInfo build() {
                return new TranslateInfo(this.inline_replacement_element_id, this.inline_replacement_engine_property_path, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder inline_replacement_element_id(String r100) {
                this.inline_replacement_element_id = r100;
                return this;
            }

            public Builder inline_replacement_engine_property_path(String r100) {
                this.inline_replacement_engine_property_path = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TranslateInfo extends ProtoAdapter<TranslateInfo> {
            public ProtoAdapter_TranslateInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TranslateInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TranslateInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.inline_replacement_element_id = "";
                r101.inline_replacement_engine_property_path = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.inline_replacement_element_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.inline_replacement_engine_property_path = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TranslateInfo r100) {
                String r101 = r100.inline_replacement_element_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.inline_replacement_engine_property_path;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TranslateInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TranslateInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TranslateInfo r101) throws IOException {
                String r102 = r101.inline_replacement_element_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.inline_replacement_engine_property_path;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TranslateInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.inline_replacement_element_id = this.inline_replacement_element_id;
            r100.inline_replacement_engine_property_path = this.inline_replacement_engine_property_path;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TranslateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TranslateInfo(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TranslateInfo(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.inline_replacement_element_id = r100;
            this.inline_replacement_engine_property_path = r101;
        }
    }

    public static final class UnifiedHeader extends com.squareup.wire.Message<UnifiedHeader, Builder> {
        public static final ProtoAdapter<UnifiedHeader> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ColorIcon icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<UnifiedHeader, Builder> {
            public ColorIcon icon;

            @Override // com.squareup.wire.Message.Builder
            public UnifiedHeader build() {
                return new UnifiedHeader(this.icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder icon(ColorIcon r100) {
                this.icon = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UnifiedHeader extends ProtoAdapter<UnifiedHeader> {
            public ProtoAdapter_UnifiedHeader() {
                super(FieldEncoding.LENGTH_DELIMITED, UnifiedHeader.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UnifiedHeader decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.icon = ColorIcon.ADAPTER.decode(r100);
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
            public int encodedSize2(UnifiedHeader r100) {
                ColorIcon r101 = r100.icon;
                if (r101 == null) goto L5;
                int r102 = ColorIcon.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UnifiedHeader decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UnifiedHeader r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UnifiedHeader r101) throws IOException {
                ColorIcon r102 = r101.icon;
                if (r102 == null) goto L5;
                ColorIcon.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UnifiedHeader r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UnifiedHeader();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon = this.icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UnifiedHeader.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UnifiedHeader(ColorIcon r100) {
            this(r100, ByteString.EMPTY);
        }

        public UnifiedHeader(ColorIcon r100, ByteString r101) {
            super(ADAPTER, r101);
            this.icon = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UrlPreviewEntity();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_USE_COLOR_ICON = r100;
        DEFAULT_VERSION = 0;
        DEFAULT_IS_SDK_PREVIEW = r100;
        DEFAULT_SDK_SITE_TYPE = URLPreviewComponent.VideoProperty.Site.UNKNOWN;
        DEFAULT_NEED_RELOAD = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_info = this.app_info;
        r100.source_id = this.source_id;
        r100.preview_id = this.preview_id;
        r100.url = this.url;
        r100.server_icon_key = this.server_icon_key;
        r100.server_title = this.server_title;
        r100.server_tag = this.server_tag;
        r100.ud_icon = this.ud_icon;
        r100.server_icon_image = this.server_icon_image;
        r100.use_color_icon = this.use_color_icon;
        r100.version = this.version;
        r100.preview_body = this.preview_body;
        r100.render_router_entity = this.render_router_entity;
        r100.unified_header = this.unified_header;
        r100.is_sdk_preview = this.is_sdk_preview;
        r100.sdk_icon_url = this.sdk_icon_url;
        r100.sdk_title = this.sdk_title;
        r100.sdk_description = this.sdk_description;
        r100.sdk_favicon_url = this.sdk_favicon_url;
        r100.sdk_domain = this.sdk_domain;
        r100.sdk_iframe_url = this.sdk_iframe_url;
        r100.sdk_site_name = this.sdk_site_name;
        r100.sdk_site_type = this.sdk_site_type;
        r100.sdk_video_id = this.sdk_video_id;
        r100.need_reload = this.need_reload;
        r100.ext_info = this.ext_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UrlPreviewEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UrlPreviewEntity(AppInfo r210, String r310, String r311, URL r312, String r313, String r314, String r315, UDIcon r316, ImageSetPassThrough r317, Boolean r318, Integer r319, URLPreviewBody r410, RenderRouterEntity r411, UnifiedHeader r412, Boolean r413, String r414, String r415, String r416, String r417, String r418, String r419, String r510, URLPreviewComponent.VideoProperty.Site r511, String r512, Boolean r513, ExtInfo r514) {
        this(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, ByteString.EMPTY);
    }

    public UrlPreviewEntity(AppInfo r100, String r101, String r102, URL r103, String r104, String r105, String r110, UDIcon r111, ImageSetPassThrough r112, Boolean r113, Integer r114, URLPreviewBody r115, RenderRouterEntity r116, UnifiedHeader r117, Boolean r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, URLPreviewComponent.VideoProperty.Site r216, String r217, Boolean r218, ExtInfo r219, ByteString r310) {
        super(ADAPTER, r310);
        this.app_info = r100;
        this.source_id = r101;
        this.preview_id = r102;
        this.url = r103;
        this.server_icon_key = r104;
        this.server_title = r105;
        this.server_tag = r110;
        this.ud_icon = r111;
        this.server_icon_image = r112;
        this.use_color_icon = r113;
        this.version = r114;
        this.preview_body = r115;
        this.render_router_entity = r116;
        this.unified_header = r117;
        this.is_sdk_preview = r118;
        this.sdk_icon_url = r119;
        this.sdk_title = r210;
        this.sdk_description = r211;
        this.sdk_favicon_url = r212;
        this.sdk_domain = r213;
        this.sdk_iframe_url = r214;
        this.sdk_site_name = r215;
        this.sdk_site_type = r216;
        this.sdk_video_id = r217;
        this.need_reload = r218;
        this.ext_info = r219;
    }
}
