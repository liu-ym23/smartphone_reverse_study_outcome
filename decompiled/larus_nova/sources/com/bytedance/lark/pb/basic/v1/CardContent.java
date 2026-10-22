package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CardContent extends com.squareup.wire.Message<CardContent, Builder> {
    public static final ProtoAdapter<CardContent> ADAPTER = null;
    public static final String DEFAULT_ACTION_URL = "";
    public static final String DEFAULT_BIZ_ID = "";
    public static final String DEFAULT_CARD_ID = "";
    public static final Integer DEFAULT_CARD_VERSION = null;
    public static final Boolean DEFAULT_COMPACT_WIDTH = null;
    public static final Boolean DEFAULT_ENABLE_FORWARD = null;
    public static final ExtraType DEFAULT_EXTRA = null;
    public static final String DEFAULT_JSON_BODY = "";
    public static final String DEFAULT_JSON_CARD_HEADER_THEME = "";
    public static final Boolean DEFAULT_STREAMING_MODE = null;
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_UNIVERSAL_HOST_CARD_ID = "";
    public static final String DEFAULT_VERSION = "";
    public static final Boolean DEFAULT_WIDE_SCREEN_MODE = null;
    public static final String DEFAULT_WIDTH_MODE = "";
    private static final long serialVersionUID = 0;
    public final String action_url;
    public final Map<String, CardAction> actions;
    public final CardAppInfo app_info;
    public final String biz_id;
    public final CardHeader card_header;
    public final String card_id;
    public final Integer card_version;
    public final Boolean compact_width;
    public final Boolean enable_forward;
    public final ExtraType extra;
    public final ExtraInfo extra_info;
    public final JsonAttachment json_attachment;
    public final String json_body;
    public final String json_card_header_theme;
    public final List<Url> json_card_urls;
    public final PatchInfo patch_info;
    public final RichText richtext;
    public final UniversalCardEntity.StreamingConfig streaming_config;
    public final Boolean streaming_mode;
    public final Type type;
    public final UniversalCardEntity universal_card_entity;
    public final String universal_host_card_id;
    public final String version;
    public final Boolean wide_screen_mode;
    public final String width_mode;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardContent, Builder> {
        public String action_url;
        public Map<String, CardAction> actions;
        public CardAppInfo app_info;
        public String biz_id;
        public CardHeader card_header;
        public String card_id;
        public Integer card_version;
        public Boolean compact_width;
        public Boolean enable_forward;
        public ExtraType extra;
        public ExtraInfo extra_info;
        public JsonAttachment json_attachment;
        public String json_body;
        public String json_card_header_theme;
        public List<Url> json_card_urls;
        public PatchInfo patch_info;
        public RichText richtext;
        public UniversalCardEntity.StreamingConfig streaming_config;
        public Boolean streaming_mode;
        public Type type;
        public UniversalCardEntity universal_card_entity;
        public String universal_host_card_id;
        public String version;
        public Boolean wide_screen_mode;
        public String width_mode;

        @Override // com.squareup.wire.Message.Builder
        public CardContent build() {
            Type r100 = this.type;
            if (r100 == null) goto L9;
            if (this.richtext == null) goto L9;
            return new CardContent(this.type, this.richtext, this.actions, this.extra, this.card_version, this.card_header, this.wide_screen_mode, this.extra_info, this.enable_forward, this.compact_width, this.json_body, this.json_attachment, this.width_mode, this.app_info, this.card_id, this.version, this.streaming_mode, this.json_card_header_theme, this.streaming_config, this.json_card_urls, this.patch_info, this.universal_host_card_id, this.universal_card_entity, this.biz_id, this.action_url, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "type", this.richtext, GXViewKey.VIEW_TYPE_RICH_TEXT});
        }

        public Builder() {
            this.actions = Internal.newMutableMap();
            this.json_card_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_url(String r100) {
            this.action_url = r100;
            return this;
        }

        public Builder actions(Map<String, CardAction> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }

        public Builder app_info(CardAppInfo r100) {
            this.app_info = r100;
            return this;
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder card_header(CardHeader r100) {
            this.card_header = r100;
            return this;
        }

        public Builder card_id(String r100) {
            this.card_id = r100;
            return this;
        }

        public Builder card_version(Integer r100) {
            this.card_version = r100;
            return this;
        }

        public Builder compact_width(Boolean r100) {
            this.compact_width = r100;
            return this;
        }

        public Builder enable_forward(Boolean r100) {
            this.enable_forward = r100;
            return this;
        }

        public Builder extra(ExtraType r100) {
            this.extra = r100;
            return this;
        }

        public Builder extra_info(ExtraInfo r100) {
            this.extra_info = r100;
            return this;
        }

        public Builder json_attachment(JsonAttachment r100) {
            this.json_attachment = r100;
            return this;
        }

        public Builder json_body(String r100) {
            this.json_body = r100;
            return this;
        }

        public Builder json_card_header_theme(String r100) {
            this.json_card_header_theme = r100;
            return this;
        }

        public Builder json_card_urls(List<Url> r100) {
            Internal.checkElementsNotNull(r100);
            this.json_card_urls = r100;
            return this;
        }

        public Builder patch_info(PatchInfo r100) {
            this.patch_info = r100;
            return this;
        }

        public Builder richtext(RichText r100) {
            this.richtext = r100;
            return this;
        }

        public Builder streaming_config(UniversalCardEntity.StreamingConfig r100) {
            this.streaming_config = r100;
            return this;
        }

        public Builder streaming_mode(Boolean r100) {
            this.streaming_mode = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder universal_card_entity(UniversalCardEntity r100) {
            this.universal_card_entity = r100;
            return this;
        }

        public Builder universal_host_card_id(String r100) {
            this.universal_host_card_id = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }

        public Builder wide_screen_mode(Boolean r100) {
            this.wide_screen_mode = r100;
            return this;
        }

        public Builder width_mode(String r100) {
            this.width_mode = r100;
            return this;
        }
    }

    public static final class CardHeader extends com.squareup.wire.Message<CardHeader, Builder> {
        public static final ProtoAdapter<CardHeader> ADAPTER = null;
        public static final String DEFAULT_MAIN_TITLE = "";
        public static final String DEFAULT_MAIN_TITLE_I18N_KEY = "";
        public static final String DEFAULT_SUBTITLE = "";
        public static final String DEFAULT_SUBTITLE_I18N_KEY = "";
        public static final String DEFAULT_THEME = "";
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_TITLE_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final RichTextElement.ImageProperty icon;
        public final String main_title;
        public final String main_title_i18n_key;
        public final Map<String, String> style;
        public final String subtitle;
        public final String subtitle_i18n_key;
        public final String theme;
        public final String title;
        public final String title_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<CardHeader, Builder> {
            public RichTextElement.ImageProperty icon;
            public String main_title;
            public String main_title_i18n_key;
            public Map<String, String> style;
            public String subtitle;
            public String subtitle_i18n_key;
            public String theme;
            public String title;
            public String title_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public CardHeader build() {
                return new CardHeader(this.title, this.title_i18n_key, this.style, this.theme, this.icon, this.subtitle, this.subtitle_i18n_key, this.main_title, this.main_title_i18n_key, super.buildUnknownFields());
            }

            public Builder() {
                this.style = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder icon(RichTextElement.ImageProperty r100) {
                this.icon = r100;
                return this;
            }

            public Builder main_title(String r100) {
                this.main_title = r100;
                return this;
            }

            public Builder main_title_i18n_key(String r100) {
                this.main_title_i18n_key = r100;
                return this;
            }

            public Builder style(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.style = r100;
                return this;
            }

            public Builder subtitle(String r100) {
                this.subtitle = r100;
                return this;
            }

            public Builder subtitle_i18n_key(String r100) {
                this.subtitle_i18n_key = r100;
                return this;
            }

            public Builder theme(String r100) {
                this.theme = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder title_i18n_key(String r100) {
                this.title_i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CardHeader extends ProtoAdapter<CardHeader> {
            private final ProtoAdapter<Map<String, String>> style;

            public ProtoAdapter_CardHeader() {
                super(FieldEncoding.LENGTH_DELIMITED, CardHeader.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.style = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CardHeader decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.title_i18n_key = "";
                r101.theme = "";
                r101.subtitle = "";
                r101.subtitle_i18n_key = "";
                r101.main_title = "";
                r101.main_title_i18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L7:
                r101.main_title_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.main_title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.subtitle_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.subtitle = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.icon = RichTextElement.ImageProperty.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.theme = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.style.putAll(this.style.decode(r100));
                goto L3
            L14:
                r101.title_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.title = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(CardHeader r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.title_i18n_key;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = (r103 + r105) + this.style.encodedSizeWithTag(3, r100.style);
                String r107 = r100.theme;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
            L14:
                int r109 = r106 + r108;
                RichTextElement.ImageProperty r110 = r100.icon;
                if (r110 == null) goto L17;
                int r111 = RichTextElement.ImageProperty.ADAPTER.encodedSizeWithTag(5, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.subtitle;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.subtitle_i18n_key;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.main_title;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.main_title_i18n_key;
                if (r122 == null) goto L34;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r122);
            L34:
                return (r121 + r102) + r100.unknownFields().size();
            L29:
                r120 = 0;
                goto L30
            L25:
                r117 = 0;
                goto L26
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
            public /* bridge */ /* synthetic */ CardHeader decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CardHeader r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CardHeader r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.title_i18n_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                this.style.encodeWithTag(r100, 3, r101.style);
                String r104 = r101.theme;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                RichTextElement.ImageProperty r105 = r101.icon;
                if (r105 == null) goto L14;
                RichTextElement.ImageProperty.ADAPTER.encodeWithTag(r100, 5, r105);
            L14:
                String r106 = r101.subtitle;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
            L17:
                String r107 = r101.subtitle_i18n_key;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
            L20:
                String r108 = r101.main_title;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
            L23:
                String r109 = r101.main_title_i18n_key;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardHeader r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CardHeader();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.title_i18n_key = this.title_i18n_key;
            r100.style = Internal.copyOf("style", this.style);
            r100.theme = this.theme;
            r100.icon = this.icon;
            r100.subtitle = this.subtitle;
            r100.subtitle_i18n_key = this.subtitle_i18n_key;
            r100.main_title = this.main_title;
            r100.main_title_i18n_key = this.main_title_i18n_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CardHeader.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CardHeader(String r110, String r111, Map<String, String> r112, String r113, RichTextElement.ImageProperty r114, String r115, String r116, String r117, String r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public CardHeader(String r100, String r101, Map<String, String> r102, String r103, RichTextElement.ImageProperty r104, String r105, String r106, String r107, String r110, ByteString r111) {
            super(ADAPTER, r111);
            this.title = r100;
            this.title_i18n_key = r101;
            this.style = Internal.immutableCopyOf("style", r102);
            this.theme = r103;
            this.icon = r104;
            this.subtitle = r105;
            this.subtitle_i18n_key = r106;
            this.main_title = r107;
            this.main_title_i18n_key = r110;
        }
    }

    public static final class CustomConfig extends com.squareup.wire.Message<CustomConfig, Builder> {
        public static final ProtoAdapter<CustomConfig> ADAPTER = null;
        public static final String DEFAULT_ANALYTICS_DATA = "";
        public static final Boolean DEFAULT_ENABLE_TRANSLATE = null;
        public static final Boolean DEFAULT_USE_CUSTOM_TRANSLATION = null;
        private static final long serialVersionUID = 0;
        public final String analytics_data;
        public final Boolean enable_translate;
        public final Boolean use_custom_translation;

        public static final class Builder extends com.squareup.wire.Message.Builder<CustomConfig, Builder> {
            public String analytics_data;
            public Boolean enable_translate;
            public Boolean use_custom_translation;

            @Override // com.squareup.wire.Message.Builder
            public CustomConfig build() {
                return new CustomConfig(this.analytics_data, this.use_custom_translation, this.enable_translate, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder analytics_data(String r100) {
                this.analytics_data = r100;
                return this;
            }

            public Builder enable_translate(Boolean r100) {
                this.enable_translate = r100;
                return this;
            }

            public Builder use_custom_translation(Boolean r100) {
                this.use_custom_translation = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomConfig extends ProtoAdapter<CustomConfig> {
            public ProtoAdapter_CustomConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.analytics_data = "";
                Boolean r102 = Boolean.FALSE;
                r101.use_custom_translation = r102;
                r101.enable_translate = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.analytics_data = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.use_custom_translation = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.enable_translate = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CustomConfig r100) {
                String r101 = r100.analytics_data;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.use_custom_translation;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.enable_translate;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ CustomConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomConfig r101) throws IOException {
                String r102 = r101.analytics_data;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.use_custom_translation;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.enable_translate;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomConfig();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_USE_CUSTOM_TRANSLATION = r100;
            DEFAULT_ENABLE_TRANSLATE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.analytics_data = this.analytics_data;
            r100.use_custom_translation = this.use_custom_translation;
            r100.enable_translate = this.enable_translate;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomConfig(String r100, Boolean r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public CustomConfig(String r100, Boolean r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.analytics_data = r100;
            this.use_custom_translation = r101;
            this.enable_translate = r102;
        }
    }

    public static final enum DataSource extends Enum<DataSource> implements WireEnum {
        private static final /* synthetic */ DataSource[] $VALUES = null;
        public static final ProtoAdapter<DataSource> ADAPTER = null;
        public static final DataSource CARD = null;
        public static final DataSource IM = null;
        private final int value;

        static {
            DataSource r100 = new DataSource("IM", 0, 1);
            IM = r100;
            DataSource r101 = new DataSource("CARD", 1, 2);
            CARD = r101;
            $VALUES = new DataSource[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataSource.class);
        }

        public static DataSource[] values() {
            return (DataSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataSource fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return CARD;
        L11:
            return IM;
        }

        public static DataSource valueOf(String r100) {
            return (DataSource) a.a(DataSource.class, r100);
        }

        private DataSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ExtraInfo extends com.squareup.wire.Message<ExtraInfo, Builder> {
        public static final ProtoAdapter<ExtraInfo> ADAPTER = null;
        public static final String DEFAULT_CUSTOM_PARAMETER = "";
        private static final long serialVersionUID = 0;
        public final CustomConfig custom_config;
        public final String custom_parameter;
        public final GadgetConfig gadget_config;
        public final MeegoConfig meego_config;

        public static final class Builder extends com.squareup.wire.Message.Builder<ExtraInfo, Builder> {
            public CustomConfig custom_config;
            public String custom_parameter;
            public GadgetConfig gadget_config;
            public MeegoConfig meego_config;

            @Override // com.squareup.wire.Message.Builder
            public ExtraInfo build() {
                return new ExtraInfo(this.gadget_config, this.custom_config, this.meego_config, this.custom_parameter, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder custom_config(CustomConfig r100) {
                this.custom_config = r100;
                return this;
            }

            public Builder custom_parameter(String r100) {
                this.custom_parameter = r100;
                return this;
            }

            public Builder gadget_config(GadgetConfig r100) {
                this.gadget_config = r100;
                return this;
            }

            public Builder meego_config(MeegoConfig r100) {
                this.meego_config = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtraInfo extends ProtoAdapter<ExtraInfo> {
            public ProtoAdapter_ExtraInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtraInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtraInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.custom_parameter = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.gadget_config = GadgetConfig.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.custom_config = CustomConfig.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.meego_config = MeegoConfig.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.custom_parameter = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(ExtraInfo r100) {
                GadgetConfig r101 = r100.gadget_config;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = GadgetConfig.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                CustomConfig r104 = r100.custom_config;
                if (r104 == null) goto L9;
                int r105 = CustomConfig.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                MeegoConfig r107 = r100.meego_config;
                if (r107 == null) goto L13;
                int r108 = MeegoConfig.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.custom_parameter;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ ExtraInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtraInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtraInfo r101) throws IOException {
                GadgetConfig r102 = r101.gadget_config;
                if (r102 == null) goto L5;
                GadgetConfig.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                CustomConfig r103 = r101.custom_config;
                if (r103 == null) goto L8;
                CustomConfig.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                MeegoConfig r104 = r101.meego_config;
                if (r104 == null) goto L11;
                MeegoConfig.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.custom_parameter;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtraInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.gadget_config = this.gadget_config;
            r100.custom_config = this.custom_config;
            r100.meego_config = this.meego_config;
            r100.custom_parameter = this.custom_parameter;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtraInfo(GadgetConfig r100, CustomConfig r101, MeegoConfig r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ExtraInfo(GadgetConfig r100, CustomConfig r101, MeegoConfig r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.gadget_config = r100;
            this.custom_config = r101;
            this.meego_config = r102;
            this.custom_parameter = r103;
        }
    }

    public static final enum ExtraType extends Enum<ExtraType> implements WireEnum {
        private static final /* synthetic */ ExtraType[] $VALUES = null;
        public static final ProtoAdapter<ExtraType> ADAPTER = null;
        public static final ExtraType SENDER_CANNOT_CLICK = null;
        public static final ExtraType UNKNOWN = null;
        private final int value;

        static {
            ExtraType r100 = new ExtraType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ExtraType r101 = new ExtraType("SENDER_CANNOT_CLICK", 1, 1);
            SENDER_CANNOT_CLICK = r101;
            $VALUES = new ExtraType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExtraType.class);
        }

        public static ExtraType[] values() {
            return (ExtraType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ExtraType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return SENDER_CANNOT_CLICK;
        L10:
            return UNKNOWN;
        }

        public static ExtraType valueOf(String r100) {
            return (ExtraType) a.a(ExtraType.class, r100);
        }

        private ExtraType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class GadgetConfig extends com.squareup.wire.Message<GadgetConfig, Builder> {
        public static final ProtoAdapter<GadgetConfig> ADAPTER = null;
        public static final Boolean DEFAULT_IS_PRELOAD = null;
        private static final long serialVersionUID = 0;
        public final List<String> cli_ids;
        public final Boolean is_preload;

        public static final class Builder extends com.squareup.wire.Message.Builder<GadgetConfig, Builder> {
            public List<String> cli_ids;
            public Boolean is_preload;

            @Override // com.squareup.wire.Message.Builder
            public GadgetConfig build() {
                return new GadgetConfig(this.is_preload, this.cli_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.cli_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder cli_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.cli_ids = r100;
                return this;
            }

            public Builder is_preload(Boolean r100) {
                this.is_preload = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_GadgetConfig extends ProtoAdapter<GadgetConfig> {
            public ProtoAdapter_GadgetConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, GadgetConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GadgetConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_preload = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.is_preload = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.cli_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(GadgetConfig r100) {
                Boolean r101 = r100.is_preload;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.cli_ids)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ GadgetConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(GadgetConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, GadgetConfig r101) throws IOException {
                Boolean r102 = r101.is_preload;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.cli_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GadgetConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_GadgetConfig();
            DEFAULT_IS_PRELOAD = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_preload = this.is_preload;
            r100.cli_ids = Internal.copyOf("cli_ids", this.cli_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return GadgetConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public GadgetConfig(Boolean r100, List<String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public GadgetConfig(Boolean r100, List<String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.is_preload = r100;
            this.cli_ids = Internal.immutableCopyOf("cli_ids", r101);
        }
    }

    public static final class JsonAttachment extends com.squareup.wire.Message<JsonAttachment, Builder> {
        public static final ProtoAdapter<JsonAttachment> ADAPTER = null;
        public static final String DEFAULT_CARD_SIMPLE_SUMMARY = "";
        public static final Boolean DEFAULT_IS_FORWARD = null;
        private static final long serialVersionUID = 0;
        public final Map<String, RichTextElement.AtProperty> at_users;
        public final Map<String, AudioInfo> audios;
        public final String card_simple_summary;
        public final Map<String, String> component_status_by_name;
        public final Map<String, RichTextElement.ImageProperty> images;
        public final Boolean is_forward;
        public final Map<String, OptionUser> option_users;
        public final Map<String, PersonInfo> persons;
        public final SummaryContent summary;
        public final Map<String, VideoInfo> videos;

        public static final class AudioInfo extends com.squareup.wire.Message<AudioInfo, Builder> {
            public static final ProtoAdapter<AudioInfo> ADAPTER = null;
            public static final Integer DEFAULT_DURATION = null;
            public static final String DEFAULT_KEY = "";
            public static final Long DEFAULT_SIZE = null;
            private static final long serialVersionUID = 0;
            public final Integer duration;
            public final String key;
            public final Long size;
            public final CardVisitInfo visit_info;

            public static final class Builder extends com.squareup.wire.Message.Builder<AudioInfo, Builder> {
                public Integer duration;
                public String key;
                public Long size;
                public CardVisitInfo visit_info;

                @Override // com.squareup.wire.Message.Builder
                public AudioInfo build() {
                    return new AudioInfo(this.key, this.duration, this.size, this.visit_info, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder duration(Integer r100) {
                    this.duration = r100;
                    return this;
                }

                public Builder key(String r100) {
                    this.key = r100;
                    return this;
                }

                public Builder size(Long r100) {
                    this.size = r100;
                    return this;
                }

                public Builder visit_info(CardVisitInfo r100) {
                    this.visit_info = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_AudioInfo extends ProtoAdapter<AudioInfo> {
                public ProtoAdapter_AudioInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, AudioInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public AudioInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.key = "";
                    r101.duration = 0;
                    r101.size = 0L;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.duration = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.size = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.visit_info = CardVisitInfo.ADAPTER.decode(r100);
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
                public int encodedSize2(AudioInfo r100) {
                    String r101 = r100.key;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.duration;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    Long r107 = r100.size;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    CardVisitInfo r110 = r100.visit_info;
                    if (r110 == null) goto L18;
                    r102 = CardVisitInfo.ADAPTER.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ AudioInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(AudioInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, AudioInfo r101) throws IOException {
                    String r102 = r101.key;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.duration;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    Long r104 = r101.size;
                    if (r104 == null) goto L11;
                    ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
                L11:
                    CardVisitInfo r105 = r101.visit_info;
                    if (r105 == null) goto L14;
                    CardVisitInfo.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AudioInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_AudioInfo();
                DEFAULT_DURATION = 0;
                DEFAULT_SIZE = 0L;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.key = this.key;
                r100.duration = this.duration;
                r100.size = this.size;
                r100.visit_info = this.visit_info;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return AudioInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public AudioInfo(String r100, Integer r101, Long r102, CardVisitInfo r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public AudioInfo(String r100, Integer r101, Long r102, CardVisitInfo r103, ByteString r104) {
                super(ADAPTER, r104);
                this.key = r100;
                this.duration = r101;
                this.size = r102;
                this.visit_info = r103;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<JsonAttachment, Builder> {
            public Map<String, RichTextElement.AtProperty> at_users;
            public Map<String, AudioInfo> audios;
            public String card_simple_summary;
            public Map<String, String> component_status_by_name;
            public Map<String, RichTextElement.ImageProperty> images;
            public Boolean is_forward;
            public Map<String, OptionUser> option_users;
            public Map<String, PersonInfo> persons;
            public SummaryContent summary;
            public Map<String, VideoInfo> videos;

            @Override // com.squareup.wire.Message.Builder
            public JsonAttachment build() {
                return new JsonAttachment(this.images, this.at_users, this.option_users, this.summary, this.is_forward, this.component_status_by_name, this.persons, this.audios, this.card_simple_summary, this.videos, super.buildUnknownFields());
            }

            public Builder() {
                this.images = Internal.newMutableMap();
                this.at_users = Internal.newMutableMap();
                this.option_users = Internal.newMutableMap();
                this.component_status_by_name = Internal.newMutableMap();
                this.persons = Internal.newMutableMap();
                this.audios = Internal.newMutableMap();
                this.videos = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder at_users(Map<String, RichTextElement.AtProperty> r100) {
                Internal.checkElementsNotNull(r100);
                this.at_users = r100;
                return this;
            }

            public Builder audios(Map<String, AudioInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.audios = r100;
                return this;
            }

            public Builder card_simple_summary(String r100) {
                this.card_simple_summary = r100;
                return this;
            }

            public Builder component_status_by_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.component_status_by_name = r100;
                return this;
            }

            public Builder images(Map<String, RichTextElement.ImageProperty> r100) {
                Internal.checkElementsNotNull(r100);
                this.images = r100;
                return this;
            }

            public Builder is_forward(Boolean r100) {
                this.is_forward = r100;
                return this;
            }

            public Builder option_users(Map<String, OptionUser> r100) {
                Internal.checkElementsNotNull(r100);
                this.option_users = r100;
                return this;
            }

            public Builder persons(Map<String, PersonInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.persons = r100;
                return this;
            }

            public Builder summary(SummaryContent r100) {
                this.summary = r100;
                return this;
            }

            public Builder videos(Map<String, VideoInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.videos = r100;
                return this;
            }
        }

        public static final class OptionUser extends com.squareup.wire.Message<OptionUser, Builder> {
            public static final ProtoAdapter<OptionUser> ADAPTER = null;
            public static final String DEFAULT_AVATAR_KEY = "";
            public static final String DEFAULT_CONTENT = "";
            public static final String DEFAULT_USER_ID = "";
            private static final long serialVersionUID = 0;
            public final String avatar_key;
            public final String content;
            public final String user_id;

            public static final class Builder extends com.squareup.wire.Message.Builder<OptionUser, Builder> {
                public String avatar_key;
                public String content;
                public String user_id;

                @Override // com.squareup.wire.Message.Builder
                public OptionUser build() {
                    return new OptionUser(this.user_id, this.content, this.avatar_key, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder avatar_key(String r100) {
                    this.avatar_key = r100;
                    return this;
                }

                public Builder content(String r100) {
                    this.content = r100;
                    return this;
                }

                public Builder user_id(String r100) {
                    this.user_id = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_OptionUser extends ProtoAdapter<OptionUser> {
                public ProtoAdapter_OptionUser() {
                    super(FieldEncoding.LENGTH_DELIMITED, OptionUser.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public OptionUser decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.user_id = "";
                    r101.content = "";
                    r101.avatar_key = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.user_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.content = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.avatar_key = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(OptionUser r100) {
                    String r101 = r100.user_id;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.content;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.avatar_key;
                    if (r107 == null) goto L14;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
                public /* bridge */ /* synthetic */ OptionUser decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(OptionUser r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, OptionUser r101) throws IOException {
                    String r102 = r101.user_id;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.content;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.avatar_key;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OptionUser r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_OptionUser();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.user_id = this.user_id;
                r100.content = this.content;
                r100.avatar_key = this.avatar_key;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return OptionUser.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public OptionUser(String r100, String r101, String r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public OptionUser(String r100, String r101, String r102, ByteString r103) {
                super(ADAPTER, r103);
                this.user_id = r100;
                this.content = r101;
                this.avatar_key = r102;
            }
        }

        public static final class PersonInfo extends com.squareup.wire.Message<PersonInfo, Builder> {
            public static final ProtoAdapter<PersonInfo> ADAPTER = null;
            public static final String DEFAULT_AVATAR_KEY = "";
            public static final String DEFAULT_CONTENT = "";
            public static final String DEFAULT_PERSON_ID = "";
            public static final Type DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            public final String avatar_key;
            public final String content;
            public final String person_id;
            public final Type type;

            public static final class Builder extends com.squareup.wire.Message.Builder<PersonInfo, Builder> {
                public String avatar_key;
                public String content;
                public String person_id;
                public Type type;

                @Override // com.squareup.wire.Message.Builder
                public PersonInfo build() {
                    String r100 = this.person_id;
                    if (r100 == null) goto L9;
                    if (this.type == null) goto L9;
                    return new PersonInfo(this.person_id, this.type, this.content, this.avatar_key, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r100, "person_id", this.type, "type"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder avatar_key(String r100) {
                    this.avatar_key = r100;
                    return this;
                }

                public Builder content(String r100) {
                    this.content = r100;
                    return this;
                }

                public Builder person_id(String r100) {
                    this.person_id = r100;
                    return this;
                }

                public Builder type(Type r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_PersonInfo extends ProtoAdapter<PersonInfo> {
                public ProtoAdapter_PersonInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, PersonInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public PersonInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.person_id = "";
                    r101.type = Type.UNKNOWN;
                    r101.content = "";
                    r101.avatar_key = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L21;
                    if (r103 != 1) goto L8;
                    r101.person_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                L18:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.content = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L21:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(PersonInfo r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    int r102 = r101.encodedSizeWithTag(1, r100.person_id) + Type.ADAPTER.encodedSizeWithTag(2, r100.type);
                    String r103 = r100.content;
                    int r104 = 0;
                    if (r103 == null) goto L5;
                    int r105 = r101.encodedSizeWithTag(3, r103);
                L6:
                    int r106 = r102 + r105;
                    String r107 = r100.avatar_key;
                    if (r107 == null) goto L10;
                    r104 = r101.encodedSizeWithTag(4, r107);
                L10:
                    return (r106 + r104) + r100.unknownFields().size();
                L5:
                    r105 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ PersonInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(PersonInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, PersonInfo r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.person_id);
                    Type.ADAPTER.encodeWithTag(r100, 2, r101.type);
                    String r103 = r101.content;
                    if (r103 == null) goto L5;
                    r102.encodeWithTag(r100, 3, r103);
                L5:
                    String r104 = r101.avatar_key;
                    if (r104 == null) goto L8;
                    r102.encodeWithTag(r100, 4, r104);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PersonInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            public static final enum Type extends Enum<Type> implements WireEnum {
                private static final /* synthetic */ Type[] $VALUES = null;
                public static final ProtoAdapter<Type> ADAPTER = null;
                public static final Type CHAT = null;
                public static final Type UNKNOWN = null;
                public static final Type USER = null;
                private final int value;

                static {
                    Type r100 = new Type("UNKNOWN", 0, 0);
                    UNKNOWN = r100;
                    Type r101 = new Type(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
                    USER = r101;
                    Type r102 = new Type("CHAT", 2, 2);
                    CHAT = r102;
                    $VALUES = new Type[]{r100, r101, r102};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
                }

                public static Type[] values() {
                    return (Type[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static Type fromValue(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return CHAT;
                L12:
                    return USER;
                L14:
                    return UNKNOWN;
                }

                public static Type valueOf(String r100) {
                    return (Type) a.a(Type.class, r100);
                }

                private Type(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_PersonInfo();
                DEFAULT_TYPE = Type.UNKNOWN;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.person_id = this.person_id;
                r100.type = this.type;
                r100.content = this.content;
                r100.avatar_key = this.avatar_key;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return PersonInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public PersonInfo(String r100, Type r101, String r102, String r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public PersonInfo(String r100, Type r101, String r102, String r103, ByteString r104) {
                super(ADAPTER, r104);
                this.person_id = r100;
                this.type = r101;
                this.content = r102;
                this.avatar_key = r103;
            }
        }

        public static final class ProtoAdapter_JsonAttachment extends ProtoAdapter<JsonAttachment> {
            private final ProtoAdapter<Map<String, RichTextElement.AtProperty>> at_users;
            private final ProtoAdapter<Map<String, AudioInfo>> audios;
            private final ProtoAdapter<Map<String, String>> component_status_by_name;
            private final ProtoAdapter<Map<String, RichTextElement.ImageProperty>> images;
            private final ProtoAdapter<Map<String, OptionUser>> option_users;
            private final ProtoAdapter<Map<String, PersonInfo>> persons;
            private final ProtoAdapter<Map<String, VideoInfo>> videos;

            public ProtoAdapter_JsonAttachment() {
                super(FieldEncoding.LENGTH_DELIMITED, JsonAttachment.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.images = ProtoAdapter.newMapAdapter(r100, RichTextElement.ImageProperty.ADAPTER);
                this.at_users = ProtoAdapter.newMapAdapter(r100, RichTextElement.AtProperty.ADAPTER);
                this.option_users = ProtoAdapter.newMapAdapter(r100, OptionUser.ADAPTER);
                this.component_status_by_name = ProtoAdapter.newMapAdapter(r100, r100);
                this.persons = ProtoAdapter.newMapAdapter(r100, PersonInfo.ADAPTER);
                this.audios = ProtoAdapter.newMapAdapter(r100, AudioInfo.ADAPTER);
                this.videos = ProtoAdapter.newMapAdapter(r100, VideoInfo.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public JsonAttachment decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_forward = Boolean.FALSE;
                r101.card_simple_summary = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L17;
                switch(r103) {
                    case 1: goto L16;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    case 7: goto L10;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L7:
                r101.videos.putAll(this.videos.decode(r100));
                goto L3
            L8:
                r101.card_simple_summary = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.audios.putAll(this.audios.decode(r100));
                goto L3
            L10:
                r101.persons.putAll(this.persons.decode(r100));
                goto L3
            L11:
                r101.component_status_by_name.putAll(this.component_status_by_name.decode(r100));
                goto L3
            L12:
                r101.is_forward = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.summary = SummaryContent.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.option_users.putAll(this.option_users.decode(r100));
                goto L3
            L15:
                r101.at_users.putAll(this.at_users.decode(r100));
                goto L3
            L16:
                r101.images.putAll(this.images.decode(r100));
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L17:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(JsonAttachment r100) {
                int r101 = (this.images.encodedSizeWithTag(1, r100.images) + this.at_users.encodedSizeWithTag(2, r100.at_users)) + this.option_users.encodedSizeWithTag(3, r100.option_users);
                SummaryContent r102 = r100.summary;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = SummaryContent.ADAPTER.encodedSizeWithTag(4, r102);
            L6:
                int r105 = r101 + r104;
                Boolean r106 = r100.is_forward;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r106);
            L10:
                int r108 = (((r105 + r107) + this.component_status_by_name.encodedSizeWithTag(6, r100.component_status_by_name)) + this.persons.encodedSizeWithTag(7, r100.persons)) + this.audios.encodedSizeWithTag(8, r100.audios);
                String r109 = r100.card_simple_summary;
                if (r109 == null) goto L14;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(9, r109);
            L14:
                return ((r108 + r103) + this.videos.encodedSizeWithTag(10, r100.videos)) + r100.unknownFields().size();
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ JsonAttachment decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(JsonAttachment r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, JsonAttachment r101) throws IOException {
                this.images.encodeWithTag(r100, 1, r101.images);
                this.at_users.encodeWithTag(r100, 2, r101.at_users);
                this.option_users.encodeWithTag(r100, 3, r101.option_users);
                SummaryContent r102 = r101.summary;
                if (r102 == null) goto L5;
                SummaryContent.ADAPTER.encodeWithTag(r100, 4, r102);
            L5:
                Boolean r103 = r101.is_forward;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
            L8:
                this.component_status_by_name.encodeWithTag(r100, 6, r101.component_status_by_name);
                this.persons.encodeWithTag(r100, 7, r101.persons);
                this.audios.encodeWithTag(r100, 8, r101.audios);
                String r104 = r101.card_simple_summary;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r104);
            L11:
                this.videos.encodeWithTag(r100, 10, r101.videos);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, JsonAttachment r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class SummaryContent extends com.squareup.wire.Message<SummaryContent, Builder> {
            public static final ProtoAdapter<SummaryContent> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<Item> items;

            public static final class Builder extends com.squareup.wire.Message.Builder<SummaryContent, Builder> {
                public List<Item> items;

                @Override // com.squareup.wire.Message.Builder
                public SummaryContent build() {
                    return new SummaryContent(this.items, super.buildUnknownFields());
                }

                public Builder() {
                    this.items = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder items(List<Item> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.items = r100;
                    return this;
                }
            }

            public static final class Item extends com.squareup.wire.Message<Item, Builder> {
                public static final ProtoAdapter<Item> ADAPTER = null;
                public static final String DEFAULT_TEXT = "";
                public static final FieldOptions FIELD_OPTIONS_AT_USER = null;
                public static final FieldOptions FIELD_OPTIONS_EMOTION = null;
                public static final FieldOptions FIELD_OPTIONS_I18N_CONTENT = null;
                public static final FieldOptions FIELD_OPTIONS_IMAGE = null;
                public static final FieldOptions FIELD_OPTIONS_PERSON_LIST = null;
                public static final FieldOptions FIELD_OPTIONS_TEXT = null;
                private static final long serialVersionUID = 0;
                public final RichTextElement.AtProperty at_user;
                public final Emotion emotion;
                public final I18NContent i18n_content;
                public final Image image;
                public final PersonList person_list;
                public final String text;

                public static final class Builder extends com.squareup.wire.Message.Builder<Item, Builder> {
                    public RichTextElement.AtProperty at_user;
                    public Emotion emotion;
                    public I18NContent i18n_content;
                    public Image image;
                    public PersonList person_list;
                    public String text;

                    @Override // com.squareup.wire.Message.Builder
                    public Item build() {
                        return new Item(this.text, this.image, this.at_user, this.emotion, this.person_list, this.i18n_content, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }

                    public Builder at_user(RichTextElement.AtProperty r100) {
                        this.at_user = r100;
                        this.text = null;
                        this.image = null;
                        this.emotion = null;
                        this.person_list = null;
                        this.i18n_content = null;
                        return this;
                    }

                    public Builder emotion(Emotion r100) {
                        this.emotion = r100;
                        this.text = null;
                        this.image = null;
                        this.at_user = null;
                        this.person_list = null;
                        this.i18n_content = null;
                        return this;
                    }

                    public Builder i18n_content(I18NContent r100) {
                        this.i18n_content = r100;
                        this.text = null;
                        this.image = null;
                        this.at_user = null;
                        this.emotion = null;
                        this.person_list = null;
                        return this;
                    }

                    public Builder image(Image r100) {
                        this.image = r100;
                        this.text = null;
                        this.at_user = null;
                        this.emotion = null;
                        this.person_list = null;
                        this.i18n_content = null;
                        return this;
                    }

                    public Builder person_list(PersonList r100) {
                        this.person_list = r100;
                        this.text = null;
                        this.image = null;
                        this.at_user = null;
                        this.emotion = null;
                        this.i18n_content = null;
                        return this;
                    }

                    public Builder text(String r100) {
                        this.text = r100;
                        this.image = null;
                        this.at_user = null;
                        this.emotion = null;
                        this.person_list = null;
                        this.i18n_content = null;
                        return this;
                    }
                }

                public static final class Emotion extends com.squareup.wire.Message<Emotion, Builder> {
                    public static final ProtoAdapter<Emotion> ADAPTER = null;
                    public static final String DEFAULT_KEY = "";
                    private static final long serialVersionUID = 0;
                    public final String key;

                    public static final class Builder extends com.squareup.wire.Message.Builder<Emotion, Builder> {
                        public String key;

                        @Override // com.squareup.wire.Message.Builder
                        public Emotion build() {
                            String r100 = this.key;
                            if (r100 == null) goto L7;
                            return new Emotion(this.key, super.buildUnknownFields());
                        L7:
                            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
                        }

                        public Builder() {
                        }

                        @Override // com.squareup.wire.Message.Builder
                        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                            return build();
                        }

                        public Builder key(String r100) {
                            this.key = r100;
                            return this;
                        }
                    }

                    public static final class ProtoAdapter_Emotion extends ProtoAdapter<Emotion> {
                        public ProtoAdapter_Emotion() {
                            super(FieldEncoding.LENGTH_DELIMITED, Emotion.class);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.squareup.wire.ProtoAdapter
                        public Emotion decode(ProtoReader r100) throws IOException {
                            Builder r101 = new Builder();
                            r101.key = "";
                            long r102 = r100.beginMessage();
                        L3:
                            int r103 = r100.nextTag();
                            if (r103 == (-1)) goto L9;
                            if (r103 != 1) goto L7;
                            r101.key = ProtoAdapter.STRING.decode(r100);
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
                        public int encodedSize2(Emotion r100) {
                            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + r100.unknownFields().size();
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ Emotion decode(ProtoReader r100) throws IOException {
                            return decode(r100);
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ int encodedSize(Emotion r100) {
                            return encodedSize2(r100);
                        }

                        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                        public void encode2(ProtoWriter r100, Emotion r101) throws IOException {
                            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
                            r100.writeBytes(r101.unknownFields());
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Emotion r101) throws IOException {
                            encode2(r100, r101);
                        }
                    }

                    static {
                        ADAPTER = new ProtoAdapter_Emotion();
                    }

                    @Override // com.squareup.wire.Message
                    public Builder newBuilder() {
                        Builder r100 = new Builder();
                        r100.key = this.key;
                        r100.addUnknownFields(unknownFields());
                        return r100;
                    }

                    @Override // com.squareup.wire.Message
                    public String toString() {
                        return Emotion.class.getName() + "@" + Integer.toHexString(hashCode());
                    }

                    @Override // com.squareup.wire.Message
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                        return newBuilder();
                    }

                    public Emotion(String r100) {
                        this(r100, ByteString.EMPTY);
                    }

                    public Emotion(String r100, ByteString r101) {
                        super(ADAPTER, r101);
                        this.key = r100;
                    }
                }

                public static final class I18NContent extends com.squareup.wire.Message<I18NContent, Builder> {
                    public static final ProtoAdapter<I18NContent> ADAPTER = null;
                    public static final String DEFAULT_DEFAULTVALUE = "";
                    public static final String DEFAULT_KEY = "";
                    private static final long serialVersionUID = 0;
                    public final String defaultValue;
                    public final String key;

                    public static final class Builder extends com.squareup.wire.Message.Builder<I18NContent, Builder> {
                        public String defaultValue;
                        public String key;

                        @Override // com.squareup.wire.Message.Builder
                        public I18NContent build() {
                            String r100 = this.key;
                            if (r100 == null) goto L7;
                            return new I18NContent(this.key, this.defaultValue, super.buildUnknownFields());
                        L7:
                            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
                        }

                        public Builder() {
                        }

                        @Override // com.squareup.wire.Message.Builder
                        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                            return build();
                        }

                        public Builder defaultValue(String r100) {
                            this.defaultValue = r100;
                            return this;
                        }

                        public Builder key(String r100) {
                            this.key = r100;
                            return this;
                        }
                    }

                    public static final class ProtoAdapter_I18NContent extends ProtoAdapter<I18NContent> {
                        public ProtoAdapter_I18NContent() {
                            super(FieldEncoding.LENGTH_DELIMITED, I18NContent.class);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.squareup.wire.ProtoAdapter
                        public I18NContent decode(ProtoReader r100) throws IOException {
                            Builder r101 = new Builder();
                            r101.key = "";
                            r101.defaultValue = "";
                            long r102 = r100.beginMessage();
                        L3:
                            int r103 = r100.nextTag();
                            if (r103 == (-1)) goto L12;
                            if (r103 != 1) goto L8;
                            r101.key = ProtoAdapter.STRING.decode(r100);
                            goto L3
                        L8:
                            if (r103 != 2) goto L9;
                            r101.defaultValue = ProtoAdapter.STRING.decode(r100);
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
                        public int encodedSize2(I18NContent r100) {
                            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                            int r102 = r101.encodedSizeWithTag(1, r100.key);
                            String r103 = r100.defaultValue;
                            if (r103 == null) goto L5;
                            int r104 = r101.encodedSizeWithTag(2, r103);
                        L7:
                            return (r102 + r104) + r100.unknownFields().size();
                        L5:
                            r104 = 0;
                            goto L7
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ I18NContent decode(ProtoReader r100) throws IOException {
                            return decode(r100);
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ int encodedSize(I18NContent r100) {
                            return encodedSize2(r100);
                        }

                        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                        public void encode2(ProtoWriter r100, I18NContent r101) throws IOException {
                            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                            r102.encodeWithTag(r100, 1, r101.key);
                            String r103 = r101.defaultValue;
                            if (r103 == null) goto L5;
                            r102.encodeWithTag(r100, 2, r103);
                        L5:
                            r100.writeBytes(r101.unknownFields());
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18NContent r101) throws IOException {
                            encode2(r100, r101);
                        }
                    }

                    static {
                        ADAPTER = new ProtoAdapter_I18NContent();
                    }

                    @Override // com.squareup.wire.Message
                    public Builder newBuilder() {
                        Builder r100 = new Builder();
                        r100.key = this.key;
                        r100.defaultValue = this.defaultValue;
                        r100.addUnknownFields(unknownFields());
                        return r100;
                    }

                    @Override // com.squareup.wire.Message
                    public String toString() {
                        return I18NContent.class.getName() + "@" + Integer.toHexString(hashCode());
                    }

                    @Override // com.squareup.wire.Message
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                        return newBuilder();
                    }

                    public I18NContent(String r100, String r101) {
                        this(r100, r101, ByteString.EMPTY);
                    }

                    public I18NContent(String r100, String r101, ByteString r102) {
                        super(ADAPTER, r102);
                        this.key = r100;
                        this.defaultValue = r101;
                    }
                }

                public static final class Image extends com.squareup.wire.Message<Image, Builder> {
                    public static final ProtoAdapter<Image> ADAPTER = null;
                    private static final long serialVersionUID = 0;

                    public static final class Builder extends com.squareup.wire.Message.Builder<Image, Builder> {
                        @Override // com.squareup.wire.Message.Builder
                        public Image build() {
                            return new Image(super.buildUnknownFields());
                        }

                        public Builder() {
                        }

                        @Override // com.squareup.wire.Message.Builder
                        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                            return build();
                        }
                    }

                    public static final class ProtoAdapter_Image extends ProtoAdapter<Image> {
                        public ProtoAdapter_Image() {
                            super(FieldEncoding.LENGTH_DELIMITED, Image.class);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.squareup.wire.ProtoAdapter
                        public Image decode(ProtoReader r100) throws IOException {
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
                        public int encodedSize2(Image r100) {
                            return r100.unknownFields().size();
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ Image decode(ProtoReader r100) throws IOException {
                            return decode(r100);
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ int encodedSize(Image r100) {
                            return encodedSize2(r100);
                        }

                        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                        public void encode2(ProtoWriter r100, Image r101) throws IOException {
                            r100.writeBytes(r101.unknownFields());
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Image r101) throws IOException {
                            encode2(r100, r101);
                        }
                    }

                    static {
                        ADAPTER = new ProtoAdapter_Image();
                    }

                    public Image() {
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
                        return Image.class.getName() + "@" + Integer.toHexString(hashCode());
                    }

                    @Override // com.squareup.wire.Message
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                        return newBuilder();
                    }

                    public Image(ByteString r100) {
                        super(ADAPTER, r100);
                    }
                }

                public static final class PersonList extends com.squareup.wire.Message<PersonList, Builder> {
                    public static final ProtoAdapter<PersonList> ADAPTER = null;
                    private static final long serialVersionUID = 0;
                    public final List<PersonInfo> persons;

                    public static final class Builder extends com.squareup.wire.Message.Builder<PersonList, Builder> {
                        public List<PersonInfo> persons;

                        @Override // com.squareup.wire.Message.Builder
                        public PersonList build() {
                            return new PersonList(this.persons, super.buildUnknownFields());
                        }

                        public Builder() {
                            this.persons = Internal.newMutableList();
                        }

                        @Override // com.squareup.wire.Message.Builder
                        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                            return build();
                        }

                        public Builder persons(List<PersonInfo> r100) {
                            Internal.checkElementsNotNull(r100);
                            this.persons = r100;
                            return this;
                        }
                    }

                    public static final class ProtoAdapter_PersonList extends ProtoAdapter<PersonList> {
                        public ProtoAdapter_PersonList() {
                            super(FieldEncoding.LENGTH_DELIMITED, PersonList.class);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.squareup.wire.ProtoAdapter
                        public PersonList decode(ProtoReader r100) throws IOException {
                            Builder r101 = new Builder();
                            long r102 = r100.beginMessage();
                        L3:
                            int r103 = r100.nextTag();
                            if (r103 == (-1)) goto L9;
                            if (r103 != 1) goto L7;
                            r101.persons.add(PersonInfo.ADAPTER.decode(r100));
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
                        public int encodedSize2(PersonList r100) {
                            return PersonInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.persons) + r100.unknownFields().size();
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ PersonList decode(ProtoReader r100) throws IOException {
                            return decode(r100);
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ int encodedSize(PersonList r100) {
                            return encodedSize2(r100);
                        }

                        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                        public void encode2(ProtoWriter r100, PersonList r101) throws IOException {
                            PersonInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.persons);
                            r100.writeBytes(r101.unknownFields());
                        }

                        @Override // com.squareup.wire.ProtoAdapter
                        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PersonList r101) throws IOException {
                            encode2(r100, r101);
                        }
                    }

                    static {
                        ADAPTER = new ProtoAdapter_PersonList();
                    }

                    @Override // com.squareup.wire.Message
                    public Builder newBuilder() {
                        Builder r100 = new Builder();
                        r100.persons = Internal.copyOf("persons", this.persons);
                        r100.addUnknownFields(unknownFields());
                        return r100;
                    }

                    @Override // com.squareup.wire.Message
                    public String toString() {
                        return PersonList.class.getName() + "@" + Integer.toHexString(hashCode());
                    }

                    @Override // com.squareup.wire.Message
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                        return newBuilder();
                    }

                    public PersonList(List<PersonInfo> r100) {
                        this(r100, ByteString.EMPTY);
                    }

                    public PersonList(List<PersonInfo> r100, ByteString r101) {
                        super(ADAPTER, r101);
                        this.persons = Internal.immutableCopyOf("persons", r100);
                    }
                }

                public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
                    public ProtoAdapter_Item() {
                        super(FieldEncoding.LENGTH_DELIMITED, Item.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public Item decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.text("");
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
                        r101.i18n_content(I18NContent.ADAPTER.decode(r100));
                        goto L3
                    L8:
                        r101.person_list(PersonList.ADAPTER.decode(r100));
                        goto L3
                    L9:
                        r101.emotion(Emotion.ADAPTER.decode(r100));
                        goto L3
                    L10:
                        r101.at_user(RichTextElement.AtProperty.ADAPTER.decode(r100));
                        goto L3
                    L11:
                        r101.image(Image.ADAPTER.decode(r100));
                        goto L3
                    L12:
                        r101.text(ProtoAdapter.STRING.decode(r100));
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
                    public int encodedSize2(Item r100) {
                        String r101 = r100.text;
                        int r102 = 0;
                        if (r101 == null) goto L5;
                        int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                    L6:
                        Image r104 = r100.image;
                        if (r104 == null) goto L9;
                        int r105 = Image.ADAPTER.encodedSizeWithTag(2, r104);
                    L10:
                        int r106 = r103 + r105;
                        RichTextElement.AtProperty r107 = r100.at_user;
                        if (r107 == null) goto L13;
                        int r108 = RichTextElement.AtProperty.ADAPTER.encodedSizeWithTag(3, r107);
                    L14:
                        int r109 = r106 + r108;
                        Emotion r110 = r100.emotion;
                        if (r110 == null) goto L17;
                        int r111 = Emotion.ADAPTER.encodedSizeWithTag(4, r110);
                    L18:
                        int r112 = r109 + r111;
                        PersonList r113 = r100.person_list;
                        if (r113 == null) goto L21;
                        int r114 = PersonList.ADAPTER.encodedSizeWithTag(5, r113);
                    L22:
                        int r115 = r112 + r114;
                        I18NContent r116 = r100.i18n_content;
                        if (r116 == null) goto L26;
                        r102 = I18NContent.ADAPTER.encodedSizeWithTag(6, r116);
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
                    public /* bridge */ /* synthetic */ Item decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(Item r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, Item r101) throws IOException {
                        String r102 = r101.text;
                        if (r102 == null) goto L5;
                        ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                    L5:
                        Image r103 = r101.image;
                        if (r103 == null) goto L8;
                        Image.ADAPTER.encodeWithTag(r100, 2, r103);
                    L8:
                        RichTextElement.AtProperty r104 = r101.at_user;
                        if (r104 == null) goto L11;
                        RichTextElement.AtProperty.ADAPTER.encodeWithTag(r100, 3, r104);
                    L11:
                        Emotion r105 = r101.emotion;
                        if (r105 == null) goto L14;
                        Emotion.ADAPTER.encodeWithTag(r100, 4, r105);
                    L14:
                        PersonList r106 = r101.person_list;
                        if (r106 == null) goto L17;
                        PersonList.ADAPTER.encodeWithTag(r100, 5, r106);
                    L17:
                        I18NContent r107 = r101.i18n_content;
                        if (r107 == null) goto L20;
                        I18NContent.ADAPTER.encodeWithTag(r100, 6, r107);
                    L20:
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Item r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_Item();
                    FIELD_OPTIONS_TEXT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                    FIELD_OPTIONS_IMAGE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                    FIELD_OPTIONS_AT_USER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                    FIELD_OPTIONS_EMOTION = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                    FIELD_OPTIONS_PERSON_LIST = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                    FIELD_OPTIONS_I18N_CONTENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.text = this.text;
                    r100.image = this.image;
                    r100.at_user = this.at_user;
                    r100.emotion = this.emotion;
                    r100.person_list = this.person_list;
                    r100.i18n_content = this.i18n_content;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return Item.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public Item(String r100, Image r110, RichTextElement.AtProperty r111, Emotion r112, PersonList r113, I18NContent r114) {
                    this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
                }

                public Item(String r100, Image r101, RichTextElement.AtProperty r102, Emotion r103, PersonList r104, I18NContent r105, ByteString r106) {
                    super(ADAPTER, r106);
                    if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105}) > 1) goto L7;
                    this.text = r100;
                    this.image = r101;
                    this.at_user = r102;
                    this.emotion = r103;
                    this.person_list = r104;
                    this.i18n_content = r105;
                    return;
                L7:
                    throw new IllegalArgumentException("at most one of text, image, at_user, emotion, person_list, i18n_content may be non-null");
                }
            }

            public static final class ProtoAdapter_SummaryContent extends ProtoAdapter<SummaryContent> {
                public ProtoAdapter_SummaryContent() {
                    super(FieldEncoding.LENGTH_DELIMITED, SummaryContent.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public SummaryContent decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.items.add(Item.ADAPTER.decode(r100));
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
                public int encodedSize2(SummaryContent r100) {
                    return Item.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.items) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ SummaryContent decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(SummaryContent r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, SummaryContent r101) throws IOException {
                    Item.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.items);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SummaryContent r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_SummaryContent();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.items = Internal.copyOf("items", this.items);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return SummaryContent.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public SummaryContent(List<Item> r100) {
                this(r100, ByteString.EMPTY);
            }

            public SummaryContent(List<Item> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.items = Internal.immutableCopyOf("items", r100);
            }
        }

        public static final class VideoInfo extends com.squareup.wire.Message<VideoInfo, Builder> {
            public static final ProtoAdapter<VideoInfo> ADAPTER = null;
            public static final Integer DEFAULT_DURATION = null;
            public static final String DEFAULT_FS_UNIT = "";
            public static final String DEFAULT_KEY = "";
            public static final String DEFAULT_MIME = "";
            public static final Long DEFAULT_SIZE = null;
            public static final String DEFAULT_URL = "";
            private static final long serialVersionUID = 0;
            public final Integer duration;
            public final String fs_unit;
            public final String key;
            public final String mime;
            public final Long size;
            public final String url;
            public final CardVisitInfo visit_info;

            public static final class Builder extends com.squareup.wire.Message.Builder<VideoInfo, Builder> {
                public Integer duration;
                public String fs_unit;
                public String key;
                public String mime;
                public Long size;
                public String url;
                public CardVisitInfo visit_info;

                @Override // com.squareup.wire.Message.Builder
                public VideoInfo build() {
                    return new VideoInfo(this.key, this.duration, this.size, this.url, this.mime, this.fs_unit, this.visit_info, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder duration(Integer r100) {
                    this.duration = r100;
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

                public Builder mime(String r100) {
                    this.mime = r100;
                    return this;
                }

                public Builder size(Long r100) {
                    this.size = r100;
                    return this;
                }

                public Builder url(String r100) {
                    this.url = r100;
                    return this;
                }

                public Builder visit_info(CardVisitInfo r100) {
                    this.visit_info = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_VideoInfo extends ProtoAdapter<VideoInfo> {
                public ProtoAdapter_VideoInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, VideoInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public VideoInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.key = "";
                    r101.duration = 0;
                    r101.size = 0L;
                    r101.url = "";
                    r101.mime = "";
                    r101.fs_unit = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L14;
                    switch(r103) {
                        case 1: goto L13;
                        case 2: goto L12;
                        case 3: goto L11;
                        case 4: goto L10;
                        case 5: goto L9;
                        case 6: goto L8;
                        case 7: goto L7;
                        default: goto L6;
                    };
                L7:
                    r101.visit_info = CardVisitInfo.ADAPTER.decode(r100);
                    goto L3
                L8:
                    r101.fs_unit = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L9:
                    r101.mime = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    r101.url = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L11:
                    r101.size = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L12:
                    r101.duration = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L13:
                    r101.key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L14:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(VideoInfo r100) {
                    String r101 = r100.key;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.duration;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    Long r107 = r100.size;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    String r110 = r100.url;
                    if (r110 == null) goto L17;
                    int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
                L18:
                    int r112 = r109 + r111;
                    String r113 = r100.mime;
                    if (r113 == null) goto L21;
                    int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
                L22:
                    int r115 = r112 + r114;
                    String r116 = r100.fs_unit;
                    if (r116 == null) goto L25;
                    int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
                L26:
                    int r118 = r115 + r117;
                    CardVisitInfo r119 = r100.visit_info;
                    if (r119 == null) goto L30;
                    r102 = CardVisitInfo.ADAPTER.encodedSizeWithTag(7, r119);
                L30:
                    return (r118 + r102) + r100.unknownFields().size();
                L25:
                    r117 = 0;
                    goto L26
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
                public /* bridge */ /* synthetic */ VideoInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(VideoInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, VideoInfo r101) throws IOException {
                    String r102 = r101.key;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.duration;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    Long r104 = r101.size;
                    if (r104 == null) goto L11;
                    ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
                L11:
                    String r105 = r101.url;
                    if (r105 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
                L14:
                    String r106 = r101.mime;
                    if (r106 == null) goto L17;
                    ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
                L17:
                    String r107 = r101.fs_unit;
                    if (r107 == null) goto L20;
                    ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
                L20:
                    CardVisitInfo r108 = r101.visit_info;
                    if (r108 == null) goto L23;
                    CardVisitInfo.ADAPTER.encodeWithTag(r100, 7, r108);
                L23:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_VideoInfo();
                DEFAULT_DURATION = 0;
                DEFAULT_SIZE = 0L;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.key = this.key;
                r100.duration = this.duration;
                r100.size = this.size;
                r100.url = this.url;
                r100.mime = this.mime;
                r100.fs_unit = this.fs_unit;
                r100.visit_info = this.visit_info;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return VideoInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public VideoInfo(String r110, Integer r111, Long r112, String r113, String r114, String r115, CardVisitInfo r116) {
                this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
            }

            public VideoInfo(String r100, Integer r101, Long r102, String r103, String r104, String r105, CardVisitInfo r106, ByteString r107) {
                super(ADAPTER, r107);
                this.key = r100;
                this.duration = r101;
                this.size = r102;
                this.url = r103;
                this.mime = r104;
                this.fs_unit = r105;
                this.visit_info = r106;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_JsonAttachment();
            DEFAULT_IS_FORWARD = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.images = Internal.copyOf("images", this.images);
            r100.at_users = Internal.copyOf("at_users", this.at_users);
            r100.option_users = Internal.copyOf("option_users", this.option_users);
            r100.summary = this.summary;
            r100.is_forward = this.is_forward;
            r100.component_status_by_name = Internal.copyOf("component_status_by_name", this.component_status_by_name);
            r100.persons = Internal.copyOf("persons", this.persons);
            r100.audios = Internal.copyOf("audios", this.audios);
            r100.card_simple_summary = this.card_simple_summary;
            r100.videos = Internal.copyOf("videos", this.videos);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return JsonAttachment.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public JsonAttachment(Map<String, RichTextElement.ImageProperty> r110, Map<String, RichTextElement.AtProperty> r111, Map<String, OptionUser> r112, SummaryContent r113, Boolean r114, Map<String, String> r115, Map<String, PersonInfo> r116, Map<String, AudioInfo> r210, String r211, Map<String, VideoInfo> r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public JsonAttachment(Map<String, RichTextElement.ImageProperty> r100, Map<String, RichTextElement.AtProperty> r101, Map<String, OptionUser> r102, SummaryContent r103, Boolean r104, Map<String, String> r105, Map<String, PersonInfo> r106, Map<String, AudioInfo> r107, String r110, Map<String, VideoInfo> r111, ByteString r112) {
            super(ADAPTER, r112);
            this.images = Internal.immutableCopyOf("images", r100);
            this.at_users = Internal.immutableCopyOf("at_users", r101);
            this.option_users = Internal.immutableCopyOf("option_users", r102);
            this.summary = r103;
            this.is_forward = r104;
            this.component_status_by_name = Internal.immutableCopyOf("component_status_by_name", r105);
            this.persons = Internal.immutableCopyOf("persons", r106);
            this.audios = Internal.immutableCopyOf("audios", r107);
            this.card_simple_summary = r110;
            this.videos = Internal.immutableCopyOf("videos", r111);
        }
    }

    public static final class MeegoConfig extends com.squareup.wire.Message<MeegoConfig, Builder> {
        public static final ProtoAdapter<MeegoConfig> ADAPTER = null;
        public static final Boolean DEFAULT_IS_PRELOAD = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_preload;

        public static final class Builder extends com.squareup.wire.Message.Builder<MeegoConfig, Builder> {
            public Boolean is_preload;

            @Override // com.squareup.wire.Message.Builder
            public MeegoConfig build() {
                return new MeegoConfig(this.is_preload, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder is_preload(Boolean r100) {
                this.is_preload = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MeegoConfig extends ProtoAdapter<MeegoConfig> {
            public ProtoAdapter_MeegoConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, MeegoConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MeegoConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_preload = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.is_preload = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(MeegoConfig r100) {
                Boolean r101 = r100.is_preload;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MeegoConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MeegoConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MeegoConfig r101) throws IOException {
                Boolean r102 = r101.is_preload;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeegoConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MeegoConfig();
            DEFAULT_IS_PRELOAD = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_preload = this.is_preload;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MeegoConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MeegoConfig(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public MeegoConfig(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.is_preload = r100;
        }
    }

    public static final class PatchInfo extends com.squareup.wire.Message<PatchInfo, Builder> {
        public static final ProtoAdapter<PatchInfo> ADAPTER = null;
        public static final DataSource DEFAULT_DATA_SOURCE = null;
        public static final Long DEFAULT_PATCH_VERSION = null;
        public static final Long DEFAULT_TARGET_VERSION = null;
        private static final long serialVersionUID = 0;
        public final DataSource data_source;
        public final Long patch_version;
        public final Long target_version;

        public static final class Builder extends com.squareup.wire.Message.Builder<PatchInfo, Builder> {
            public DataSource data_source;
            public Long patch_version;
            public Long target_version;

            @Override // com.squareup.wire.Message.Builder
            public PatchInfo build() {
                Long r100 = this.target_version;
                if (r100 == null) goto L11;
                if (this.patch_version == null) goto L11;
                if (this.data_source == null) goto L11;
                return new PatchInfo(this.target_version, this.patch_version, this.data_source, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "target_version", this.patch_version, "patch_version", this.data_source, "data_source"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder data_source(DataSource r100) {
                this.data_source = r100;
                return this;
            }

            public Builder patch_version(Long r100) {
                this.patch_version = r100;
                return this;
            }

            public Builder target_version(Long r100) {
                this.target_version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PatchInfo extends ProtoAdapter<PatchInfo> {
            public ProtoAdapter_PatchInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PatchInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PatchInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.target_version = 0L;
                r101.patch_version = 0L;
                r101.data_source = DataSource.IM;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.target_version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.patch_version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.data_source = DataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PatchInfo r100) {
                ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
                return ((r101.encodedSizeWithTag(1, r100.target_version) + r101.encodedSizeWithTag(2, r100.patch_version)) + DataSource.ADAPTER.encodedSizeWithTag(3, r100.data_source)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PatchInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PatchInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PatchInfo r101) throws IOException {
                ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
                r102.encodeWithTag(r100, 1, r101.target_version);
                r102.encodeWithTag(r100, 2, r101.patch_version);
                DataSource.ADAPTER.encodeWithTag(r100, 3, r101.data_source);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PatchInfo();
            DEFAULT_TARGET_VERSION = 0L;
            DEFAULT_PATCH_VERSION = 0L;
            DEFAULT_DATA_SOURCE = DataSource.IM;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.target_version = this.target_version;
            r100.patch_version = this.patch_version;
            r100.data_source = this.data_source;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PatchInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PatchInfo(Long r100, Long r101, DataSource r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public PatchInfo(Long r100, Long r101, DataSource r102, ByteString r103) {
            super(ADAPTER, r103);
            this.target_version = r100;
            this.patch_version = r101;
            this.data_source = r102;
        }
    }

    public static final class ProtoAdapter_CardContent extends ProtoAdapter<CardContent> {
        private final ProtoAdapter<Map<String, CardAction>> actions;

        public ProtoAdapter_CardContent() {
            super(FieldEncoding.LENGTH_DELIMITED, CardContent.class);
            this.actions = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, CardAction.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN_TYPE;
            r101.extra = ExtraType.UNKNOWN;
            r101.card_version = 0;
            Boolean r102 = Boolean.FALSE;
            r101.wide_screen_mode = r102;
            r101.enable_forward = r102;
            r101.compact_width = r102;
            r101.json_body = "";
            r101.width_mode = "";
            r101.card_id = "";
            r101.version = "";
            r101.streaming_mode = r102;
            r101.json_card_header_theme = "";
            r101.universal_host_card_id = "";
            r101.biz_id = "";
            r101.action_url = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L38;
            switch(r104) {
                case 1: goto L42;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L40;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L6;
                case 12: goto L6;
                case 13: goto L6;
                case 14: goto L6;
                case 15: goto L21;
                case 16: goto L20;
                case 17: goto L19;
                case 18: goto L18;
                case 19: goto L17;
                case 20: goto L16;
                case 21: goto L15;
                case 22: goto L14;
                case 23: goto L13;
                case 24: goto L12;
                case 25: goto L11;
                case 26: goto L10;
                case 27: goto L9;
                case 28: goto L8;
                case 29: goto L7;
                default: goto L6;
            };
        L40:
            r101.extra = ExtraType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
        L30:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L42:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.action_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.universal_card_entity = UniversalCardEntity.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.universal_host_card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.patch_info = PatchInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.json_card_urls.add(Url.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.streaming_config = UniversalCardEntity.StreamingConfig.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.json_card_header_theme = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.streaming_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.app_info = CardAppInfo.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.width_mode = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.json_attachment = JsonAttachment.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.json_body = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.compact_width = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.enable_forward = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.extra_info = ExtraInfo.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.wide_screen_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.card_header = CardHeader.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.card_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L32:
            r101.actions.putAll(this.actions.decode(r100));
            goto L3
        L33:
            r101.richtext = RichText.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L38:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CardContent r100) {
            int r101 = (Type.ADAPTER.encodedSizeWithTag(1, r100.type) + RichText.ADAPTER.encodedSizeWithTag(2, r100.richtext)) + this.actions.encodedSizeWithTag(3, r100.actions);
            ExtraType r102 = r100.extra;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ExtraType.ADAPTER.encodedSizeWithTag(4, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.card_version;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(5, r106);
        L10:
            int r108 = r105 + r107;
            CardHeader r109 = r100.card_header;
            if (r109 == null) goto L13;
            int r110 = CardHeader.ADAPTER.encodedSizeWithTag(6, r109);
        L14:
            int r111 = r108 + r110;
            Boolean r112 = r100.wide_screen_mode;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r112);
        L18:
            int r114 = r111 + r113;
            ExtraInfo r115 = r100.extra_info;
            if (r115 == null) goto L21;
            int r116 = ExtraInfo.ADAPTER.encodedSizeWithTag(8, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.enable_forward;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r118);
        L26:
            int r120 = r117 + r119;
            Boolean r121 = r100.compact_width;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r121);
        L30:
            int r123 = r120 + r122;
            String r124 = r100.json_body;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.STRING.encodedSizeWithTag(15, r124);
        L34:
            int r126 = r123 + r125;
            JsonAttachment r127 = r100.json_attachment;
            if (r127 == null) goto L37;
            int r128 = JsonAttachment.ADAPTER.encodedSizeWithTag(16, r127);
        L38:
            int r129 = r126 + r128;
            String r130 = r100.width_mode;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.STRING.encodedSizeWithTag(17, r130);
        L42:
            int r132 = r129 + r131;
            CardAppInfo r133 = r100.app_info;
            if (r133 == null) goto L45;
            int r134 = CardAppInfo.ADAPTER.encodedSizeWithTag(18, r133);
        L46:
            int r135 = r132 + r134;
            String r136 = r100.card_id;
            if (r136 == null) goto L49;
            int r137 = ProtoAdapter.STRING.encodedSizeWithTag(19, r136);
        L50:
            int r138 = r135 + r137;
            String r139 = r100.version;
            if (r139 == null) goto L53;
            int r140 = ProtoAdapter.STRING.encodedSizeWithTag(20, r139);
        L54:
            int r141 = r138 + r140;
            Boolean r142 = r100.streaming_mode;
            if (r142 == null) goto L57;
            int r143 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r142);
        L58:
            int r144 = r141 + r143;
            String r145 = r100.json_card_header_theme;
            if (r145 == null) goto L61;
            int r146 = ProtoAdapter.STRING.encodedSizeWithTag(22, r145);
        L62:
            int r147 = r144 + r146;
            UniversalCardEntity.StreamingConfig r148 = r100.streaming_config;
            if (r148 == null) goto L65;
            int r149 = UniversalCardEntity.StreamingConfig.ADAPTER.encodedSizeWithTag(23, r148);
        L66:
            int r150 = (r147 + r149) + Url.ADAPTER.asRepeated().encodedSizeWithTag(24, r100.json_card_urls);
            PatchInfo r151 = r100.patch_info;
            if (r151 == null) goto L69;
            int r152 = PatchInfo.ADAPTER.encodedSizeWithTag(25, r151);
        L70:
            int r153 = r150 + r152;
            String r154 = r100.universal_host_card_id;
            if (r154 == null) goto L73;
            int r155 = ProtoAdapter.STRING.encodedSizeWithTag(26, r154);
        L74:
            int r156 = r153 + r155;
            UniversalCardEntity r157 = r100.universal_card_entity;
            if (r157 == null) goto L77;
            int r158 = UniversalCardEntity.ADAPTER.encodedSizeWithTag(27, r157);
        L78:
            int r159 = r156 + r158;
            String r160 = r100.biz_id;
            if (r160 == null) goto L81;
            int r161 = ProtoAdapter.STRING.encodedSizeWithTag(28, r160);
        L82:
            int r162 = r159 + r161;
            String r163 = r100.action_url;
            if (r163 == null) goto L86;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(29, r163);
        L86:
            return (r162 + r103) + r100.unknownFields().size();
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
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CardContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardContent r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            RichText.ADAPTER.encodeWithTag(r100, 2, r101.richtext);
            this.actions.encodeWithTag(r100, 3, r101.actions);
            ExtraType r102 = r101.extra;
            if (r102 == null) goto L5;
            ExtraType.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            Integer r103 = r101.card_version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r103);
        L8:
            CardHeader r104 = r101.card_header;
            if (r104 == null) goto L11;
            CardHeader.ADAPTER.encodeWithTag(r100, 6, r104);
        L11:
            Boolean r105 = r101.wide_screen_mode;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L14:
            ExtraInfo r106 = r101.extra_info;
            if (r106 == null) goto L17;
            ExtraInfo.ADAPTER.encodeWithTag(r100, 8, r106);
        L17:
            Boolean r107 = r101.enable_forward;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
        L20:
            Boolean r108 = r101.compact_width;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r108);
        L23:
            String r109 = r101.json_body;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r109);
        L26:
            JsonAttachment r110 = r101.json_attachment;
            if (r110 == null) goto L29;
            JsonAttachment.ADAPTER.encodeWithTag(r100, 16, r110);
        L29:
            String r111 = r101.width_mode;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 17, r111);
        L32:
            CardAppInfo r112 = r101.app_info;
            if (r112 == null) goto L35;
            CardAppInfo.ADAPTER.encodeWithTag(r100, 18, r112);
        L35:
            String r113 = r101.card_id;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 19, r113);
        L38:
            String r114 = r101.version;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 20, r114);
        L41:
            Boolean r115 = r101.streaming_mode;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r115);
        L44:
            String r116 = r101.json_card_header_theme;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 22, r116);
        L47:
            UniversalCardEntity.StreamingConfig r117 = r101.streaming_config;
            if (r117 == null) goto L50;
            UniversalCardEntity.StreamingConfig.ADAPTER.encodeWithTag(r100, 23, r117);
        L50:
            Url.ADAPTER.asRepeated().encodeWithTag(r100, 24, r101.json_card_urls);
            PatchInfo r118 = r101.patch_info;
            if (r118 == null) goto L53;
            PatchInfo.ADAPTER.encodeWithTag(r100, 25, r118);
        L53:
            String r119 = r101.universal_host_card_id;
            if (r119 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r100, 26, r119);
        L56:
            UniversalCardEntity r120 = r101.universal_card_entity;
            if (r120 == null) goto L59;
            UniversalCardEntity.ADAPTER.encodeWithTag(r100, 27, r120);
        L59:
            String r121 = r101.biz_id;
            if (r121 == null) goto L62;
            ProtoAdapter.STRING.encodeWithTag(r100, 28, r121);
        L62:
            String r122 = r101.action_url;
            if (r122 == null) goto L65;
            ProtoAdapter.STRING.encodeWithTag(r100, 29, r122);
        L65:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type OPEN_CARD = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final Type VCHAT = null;
        public static final Type VOTE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("VOTE", 1, 1);
            VOTE = r101;
            Type r102 = new Type(CardAdapter.TEXT, 2, 2);
            TEXT = r102;
            Type r103 = new Type("VCHAT", 3, 3);
            VCHAT = r103;
            Type r104 = new Type("OPEN_CARD", 4, 4);
            OPEN_CARD = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return OPEN_CARD;
        L16:
            return VCHAT;
        L18:
            return TEXT;
        L20:
            return VOTE;
        L22:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Url extends com.squareup.wire.Message<Url, Builder> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String android_url;
        public final String ios_url;
        public final String pc_url;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<Url, Builder> {
            public String android_url;
            public String ios_url;
            public String pc_url;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public Url build() {
                return new Url(this.url, this.ios_url, this.android_url, this.pc_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.android_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.ios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.pc_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Url extends ProtoAdapter<Url> {
            public ProtoAdapter_Url() {
                super(FieldEncoding.LENGTH_DELIMITED, Url.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Url decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.ios_url = "";
                r101.android_url = "";
                r101.pc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.ios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.android_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.pc_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Url r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.ios_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.android_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.pc_url;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ Url decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Url r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Url r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.ios_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.android_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.pc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Url r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Url();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.ios_url = this.ios_url;
            r100.android_url = this.android_url;
            r100.pc_url = this.pc_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Url.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Url(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Url(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.url = r100;
            this.ios_url = r101;
            this.android_url = r102;
            this.pc_url = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardContent();
        DEFAULT_TYPE = Type.UNKNOWN_TYPE;
        DEFAULT_EXTRA = ExtraType.UNKNOWN;
        DEFAULT_CARD_VERSION = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_WIDE_SCREEN_MODE = r100;
        DEFAULT_ENABLE_FORWARD = r100;
        DEFAULT_COMPACT_WIDTH = r100;
        DEFAULT_STREAMING_MODE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.richtext = this.richtext;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.extra = this.extra;
        r100.card_version = this.card_version;
        r100.card_header = this.card_header;
        r100.wide_screen_mode = this.wide_screen_mode;
        r100.extra_info = this.extra_info;
        r100.enable_forward = this.enable_forward;
        r100.compact_width = this.compact_width;
        r100.json_body = this.json_body;
        r100.json_attachment = this.json_attachment;
        r100.width_mode = this.width_mode;
        r100.app_info = this.app_info;
        r100.card_id = this.card_id;
        r100.version = this.version;
        r100.streaming_mode = this.streaming_mode;
        r100.json_card_header_theme = this.json_card_header_theme;
        r100.streaming_config = this.streaming_config;
        r100.json_card_urls = Internal.copyOf("json_card_urls", this.json_card_urls);
        r100.patch_info = this.patch_info;
        r100.universal_host_card_id = this.universal_host_card_id;
        r100.universal_card_entity = this.universal_card_entity;
        r100.biz_id = this.biz_id;
        r100.action_url = this.action_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardContent(Type r210, RichText r211, Map<String, CardAction> r310, ExtraType r311, Integer r312, CardHeader r313, Boolean r314, ExtraInfo r315, Boolean r316, Boolean r317, String r318, JsonAttachment r319, String r410, CardAppInfo r411, String r412, String r413, Boolean r414, String r415, UniversalCardEntity.StreamingConfig r416, List<Url> r417, PatchInfo r418, String r419, UniversalCardEntity r510, String r511, String r512) {
        this(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, ByteString.EMPTY);
    }

    public CardContent(Type r100, RichText r101, Map<String, CardAction> r102, ExtraType r103, Integer r104, CardHeader r105, Boolean r110, ExtraInfo r111, Boolean r112, Boolean r113, String r114, JsonAttachment r115, String r116, CardAppInfo r117, String r118, String r119, Boolean r210, String r211, UniversalCardEntity.StreamingConfig r212, List<Url> r213, PatchInfo r214, String r215, UniversalCardEntity r216, String r217, String r218, ByteString r219) {
        super(ADAPTER, r219);
        this.type = r100;
        this.richtext = r101;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r102);
        this.extra = r103;
        this.card_version = r104;
        this.card_header = r105;
        this.wide_screen_mode = r110;
        this.extra_info = r111;
        this.enable_forward = r112;
        this.compact_width = r113;
        this.json_body = r114;
        this.json_attachment = r115;
        this.width_mode = r116;
        this.app_info = r117;
        this.card_id = r118;
        this.version = r119;
        this.streaming_mode = r210;
        this.json_card_header_theme = r211;
        this.streaming_config = r212;
        this.json_card_urls = Internal.immutableCopyOf("json_card_urls", r213);
        this.patch_info = r214;
        this.universal_host_card_id = r215;
        this.universal_card_entity = r216;
        this.biz_id = r217;
        this.action_url = r218;
    }
}
