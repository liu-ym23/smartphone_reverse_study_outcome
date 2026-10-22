package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.sheet.fab.FabItem;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class URLPreviewComponent extends com.squareup.wire.Message<URLPreviewComponent, Builder> {
    public static final ProtoAdapter<URLPreviewComponent> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_SKIP_WHEN_UNKNOWN = null;
    public static final Boolean DEFAULT_IS_FONT_ZOOMABLE = null;
    public static final Type DEFAULT_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_AVATAR = null;
    public static final FieldOptions FIELD_OPTIONS_BUTTON = null;
    public static final FieldOptions FIELD_OPTIONS_CARD_CONTAINER = null;
    public static final FieldOptions FIELD_OPTIONS_CHATTERS_PREVIEW = null;
    public static final FieldOptions FIELD_OPTIONS_DOC_IMAGE = null;
    public static final FieldOptions FIELD_OPTIONS_DOC_STATE_BUTTON = null;
    public static final FieldOptions FIELD_OPTIONS_EMPTY = null;
    public static final FieldOptions FIELD_OPTIONS_ENGINE = null;
    public static final FieldOptions FIELD_OPTIONS_FLEX_LAYOUT = null;
    public static final FieldOptions FIELD_OPTIONS_HEADER = null;
    public static final FieldOptions FIELD_OPTIONS_ICON_BUTTON = null;
    public static final FieldOptions FIELD_OPTIONS_IMAGE = null;
    public static final FieldOptions FIELD_OPTIONS_IMAGE_CONTAINER = null;
    public static final FieldOptions FIELD_OPTIONS_LINEAR_LAYOUT = null;
    public static final FieldOptions FIELD_OPTIONS_LOADING = null;
    public static final FieldOptions FIELD_OPTIONS_OVERSIZED_TEXT = null;
    public static final FieldOptions FIELD_OPTIONS_RICHTEXT = null;
    public static final FieldOptions FIELD_OPTIONS_SPIN_BUTTON = null;
    public static final FieldOptions FIELD_OPTIONS_TAG_LIST = null;
    public static final FieldOptions FIELD_OPTIONS_TEXT = null;
    public static final FieldOptions FIELD_OPTIONS_TEXT_BUTTON = null;
    public static final FieldOptions FIELD_OPTIONS_TIME = null;
    public static final FieldOptions FIELD_OPTIONS_TIME_ZONE = null;
    public static final FieldOptions FIELD_OPTIONS_VIDEO = null;
    private static final long serialVersionUID = 0;
    public final AvatarProperty avatar;
    public final ButtonProperty button;
    public final Boolean can_skip_when_unknown;
    public final CardContainerProperty card_container;
    public final ChattersPreviewProperty chatters_preview;
    public final List<String> child_ids;
    public final DocImageProperty doc_image;
    public final DocStateButtonProperty doc_state_button;
    public final EmptyProperty empty;
    public final EngineProperty engine;
    public final FlexLayoutProperty flex_layout;
    public final PreviewHeaderProperty header;
    public final IconButtonProperty icon_button;
    public final ImageProperty image;
    public final ImageContainerProperty image_container;
    public final Boolean is_font_zoomable;
    public final LinearLayoutProperty linear_layout;
    public final LoadingProperty loading;
    public final OversizedTextProperty oversized_text;
    public final RichTextProperty richtext;
    public final SpinButtonProperty spin_button;
    public final Style style;
    public final TagListProperty tag_list;
    public final TextProperty text;
    public final TextButtonProperty text_button;
    public final TimeProperty time;
    public final TimeZoneProperty time_zone;
    public final Type type;
    public final VideoProperty video;

    public static final enum Align extends Enum<Align> implements WireEnum {
        private static final /* synthetic */ Align[] $VALUES = null;
        public static final ProtoAdapter<Align> ADAPTER = null;
        public static final Align BASELINE = null;
        public static final Align BOTTOM = null;
        public static final Align MIDDLE = null;
        public static final Align STRETCH = null;
        public static final Align TOP = null;
        private final int value;

        static {
            Align r100 = new Align("TOP", 0, 0);
            TOP = r100;
            Align r101 = new Align("MIDDLE", 1, 1);
            MIDDLE = r101;
            Align r102 = new Align("BOTTOM", 2, 2);
            BOTTOM = r102;
            Align r103 = new Align("STRETCH", 3, 3);
            STRETCH = r103;
            Align r104 = new Align("BASELINE", 4, 4);
            BASELINE = r104;
            $VALUES = new Align[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Align.class);
        }

        public static Align[] values() {
            return (Align[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Align fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return BASELINE;
        L16:
            return STRETCH;
        L18:
            return BOTTOM;
        L20:
            return MIDDLE;
        L22:
            return TOP;
        }

        public static Align valueOf(String r100) {
            return (Align) a.a(Align.class, r100);
        }

        private Align(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class AvatarProperty extends com.squareup.wire.Message<AvatarProperty, Builder> {
        public static final ProtoAdapter<AvatarProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ChatterInfo chatter_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<AvatarProperty, Builder> {
            public ChatterInfo chatter_info;

            @Override // com.squareup.wire.Message.Builder
            public AvatarProperty build() {
                return new AvatarProperty(this.chatter_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_info(ChatterInfo r100) {
                this.chatter_info = r100;
                return this;
            }
        }

        public static final class ChatterInfo extends com.squareup.wire.Message<ChatterInfo, Builder> {
            public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
            public static final String DEFAULT_AVATAR_KEY = "";
            public static final String DEFAULT_CHATTER_ID = "";
            private static final long serialVersionUID = 0;
            public final String avatar_key;
            public final String chatter_id;

            public static final class Builder extends com.squareup.wire.Message.Builder<ChatterInfo, Builder> {
                public String avatar_key;
                public String chatter_id;

                @Override // com.squareup.wire.Message.Builder
                public ChatterInfo build() {
                    return new ChatterInfo(this.avatar_key, this.chatter_id, super.buildUnknownFields());
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

                public Builder chatter_id(String r100) {
                    this.chatter_id = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ChatterInfo extends ProtoAdapter<ChatterInfo> {
                public ProtoAdapter_ChatterInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, ChatterInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ChatterInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.avatar_key = "";
                    r101.chatter_id = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.chatter_id = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(ChatterInfo r100) {
                    String r101 = r100.avatar_key;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.chatter_id;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ChatterInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ChatterInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ChatterInfo r101) throws IOException {
                    String r102 = r101.avatar_key;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.chatter_id;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ChatterInfo();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.avatar_key = this.avatar_key;
                r100.chatter_id = this.chatter_id;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public ChatterInfo(String r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public ChatterInfo(String r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.avatar_key = r100;
                this.chatter_id = r101;
            }
        }

        public static final class ProtoAdapter_AvatarProperty extends ProtoAdapter<AvatarProperty> {
            public ProtoAdapter_AvatarProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AvatarProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AvatarProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.chatter_info = ChatterInfo.ADAPTER.decode(r100);
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
            public int encodedSize2(AvatarProperty r100) {
                ChatterInfo r101 = r100.chatter_info;
                if (r101 == null) goto L5;
                int r102 = ChatterInfo.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AvatarProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AvatarProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AvatarProperty r101) throws IOException {
                ChatterInfo r102 = r101.chatter_info;
                if (r102 == null) goto L5;
                ChatterInfo.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AvatarProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AvatarProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_info = this.chatter_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AvatarProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AvatarProperty(ChatterInfo r100) {
            this(r100, ByteString.EMPTY);
        }

        public AvatarProperty(ChatterInfo r100, ByteString r101) {
            super(ADAPTER, r101);
            this.chatter_info = r100;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<URLPreviewComponent, Builder> {
        public AvatarProperty avatar;
        public ButtonProperty button;
        public Boolean can_skip_when_unknown;
        public CardContainerProperty card_container;
        public ChattersPreviewProperty chatters_preview;
        public List<String> child_ids;
        public DocImageProperty doc_image;
        public DocStateButtonProperty doc_state_button;
        public EmptyProperty empty;
        public EngineProperty engine;
        public FlexLayoutProperty flex_layout;
        public PreviewHeaderProperty header;
        public IconButtonProperty icon_button;
        public ImageProperty image;
        public ImageContainerProperty image_container;
        public Boolean is_font_zoomable;
        public LinearLayoutProperty linear_layout;
        public LoadingProperty loading;
        public OversizedTextProperty oversized_text;
        public RichTextProperty richtext;
        public SpinButtonProperty spin_button;
        public Style style;
        public TagListProperty tag_list;
        public TextProperty text;
        public TextButtonProperty text_button;
        public TimeProperty time;
        public TimeZoneProperty time_zone;
        public Type type;
        public VideoProperty video;

        @Override // com.squareup.wire.Message.Builder
        public URLPreviewComponent build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new URLPreviewComponent(this.type, this.can_skip_when_unknown, this.style, this.child_ids, this.is_font_zoomable, this.empty, this.linear_layout, this.flex_layout, this.header, this.richtext, this.image, this.chatters_preview, this.button, this.icon_button, this.text_button, this.time, this.text, this.tag_list, this.spin_button, this.avatar, this.video, this.card_container, this.doc_image, this.loading, this.time_zone, this.oversized_text, this.engine, this.doc_state_button, this.image_container, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.child_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar(AvatarProperty r100) {
            this.avatar = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder button(ButtonProperty r100) {
            this.button = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder can_skip_when_unknown(Boolean r100) {
            this.can_skip_when_unknown = r100;
            return this;
        }

        public Builder card_container(CardContainerProperty r100) {
            this.card_container = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder chatters_preview(ChattersPreviewProperty r100) {
            this.chatters_preview = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder child_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.child_ids = r100;
            return this;
        }

        public Builder doc_image(DocImageProperty r100) {
            this.doc_image = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder doc_state_button(DocStateButtonProperty r100) {
            this.doc_state_button = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.image_container = null;
            return this;
        }

        public Builder empty(EmptyProperty r100) {
            this.empty = r100;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder engine(EngineProperty r100) {
            this.engine = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder flex_layout(FlexLayoutProperty r100) {
            this.flex_layout = r100;
            this.empty = null;
            this.linear_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder header(PreviewHeaderProperty r100) {
            this.header = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder icon_button(IconButtonProperty r100) {
            this.icon_button = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder image(ImageProperty r100) {
            this.image = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder image_container(ImageContainerProperty r100) {
            this.image_container = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            return this;
        }

        public Builder is_font_zoomable(Boolean r100) {
            this.is_font_zoomable = r100;
            return this;
        }

        public Builder linear_layout(LinearLayoutProperty r100) {
            this.linear_layout = r100;
            this.empty = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder loading(LoadingProperty r100) {
            this.loading = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder oversized_text(OversizedTextProperty r100) {
            this.oversized_text = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder richtext(RichTextProperty r100) {
            this.richtext = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder spin_button(SpinButtonProperty r100) {
            this.spin_button = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder style(Style r100) {
            this.style = r100;
            return this;
        }

        public Builder tag_list(TagListProperty r100) {
            this.tag_list = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder text(TextProperty r100) {
            this.text = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder text_button(TextButtonProperty r100) {
            this.text_button = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder time(TimeProperty r100) {
            this.time = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder time_zone(TimeZoneProperty r100) {
            this.time_zone = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.video = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder video(VideoProperty r100) {
            this.video = r100;
            this.empty = null;
            this.linear_layout = null;
            this.flex_layout = null;
            this.header = null;
            this.richtext = null;
            this.image = null;
            this.chatters_preview = null;
            this.button = null;
            this.icon_button = null;
            this.text_button = null;
            this.time = null;
            this.text = null;
            this.tag_list = null;
            this.spin_button = null;
            this.avatar = null;
            this.card_container = null;
            this.doc_image = null;
            this.loading = null;
            this.time_zone = null;
            this.oversized_text = null;
            this.engine = null;
            this.doc_state_button = null;
            this.image_container = null;
            return this;
        }
    }

    public static final class ButtonProperty extends com.squareup.wire.Message<ButtonProperty, Builder> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Direction DEFAULT_DIRECTION = null;
        public static final Boolean DEFAULT_IS_DISABLE = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final Direction direction;
        public final ImageSet icon;
        public final Boolean is_disable;
        public final String text;
        public final UDIcon ud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonProperty, Builder> {
            public String action_id;
            public Direction direction;
            public ImageSet icon;
            public Boolean is_disable;
            public String text;
            public UDIcon ud_icon;

            @Override // com.squareup.wire.Message.Builder
            public ButtonProperty build() {
                return new ButtonProperty(this.icon, this.text, this.direction, this.action_id, this.is_disable, this.ud_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder direction(Direction r100) {
                this.direction = r100;
                return this;
            }

            public Builder icon(ImageSet r100) {
                this.icon = r100;
                return this;
            }

            public Builder is_disable(Boolean r100) {
                this.is_disable = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder ud_icon(UDIcon r100) {
                this.ud_icon = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonProperty extends ProtoAdapter<ButtonProperty> {
            public ProtoAdapter_ButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ButtonProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.direction = Direction.LTR;
                r101.action_id = "";
                r101.is_disable = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L18;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r101.direction = Direction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.is_disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.icon = ImageSet.ADAPTER.decode(r100);
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
            public int encodedSize2(ButtonProperty r100) {
                ImageSet r101 = r100.icon;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.text;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Direction r107 = r100.direction;
                if (r107 == null) goto L13;
                int r108 = Direction.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.action_id;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.is_disable;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                UDIcon r116 = r100.ud_icon;
                if (r116 == null) goto L26;
                r102 = UDIcon.ADAPTER.encodedSizeWithTag(6, r116);
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
            public /* bridge */ /* synthetic */ ButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ButtonProperty r101) throws IOException {
                ImageSet r102 = r101.icon;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.text;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Direction r104 = r101.direction;
                if (r104 == null) goto L11;
                Direction.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.action_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.is_disable;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                UDIcon r107 = r101.ud_icon;
                if (r107 == null) goto L20;
                UDIcon.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonProperty();
            DEFAULT_DIRECTION = Direction.LTR;
            DEFAULT_IS_DISABLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon = this.icon;
            r100.text = this.text;
            r100.direction = this.direction;
            r100.action_id = this.action_id;
            r100.is_disable = this.is_disable;
            r100.ud_icon = this.ud_icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ButtonProperty(ImageSet r100, String r110, Direction r111, String r112, Boolean r113, UDIcon r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ButtonProperty(ImageSet r100, String r101, Direction r102, String r103, Boolean r104, UDIcon r105, ByteString r106) {
            super(ADAPTER, r106);
            this.icon = r100;
            this.text = r101;
            this.direction = r102;
            this.action_id = r103;
            this.is_disable = r104;
            this.ud_icon = r105;
        }
    }

    public static final class CardContainerProperty extends com.squareup.wire.Message<CardContainerProperty, Builder> {
        public static final ProtoAdapter<CardContainerProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ThemeColor mask_color;

        public static final class Builder extends com.squareup.wire.Message.Builder<CardContainerProperty, Builder> {
            public ThemeColor mask_color;

            @Override // com.squareup.wire.Message.Builder
            public CardContainerProperty build() {
                return new CardContainerProperty(this.mask_color, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder mask_color(ThemeColor r100) {
                this.mask_color = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CardContainerProperty extends ProtoAdapter<CardContainerProperty> {
            public ProtoAdapter_CardContainerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, CardContainerProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CardContainerProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mask_color = ThemeColor.ADAPTER.decode(r100);
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
            public int encodedSize2(CardContainerProperty r100) {
                ThemeColor r101 = r100.mask_color;
                if (r101 == null) goto L5;
                int r102 = ThemeColor.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CardContainerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CardContainerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CardContainerProperty r101) throws IOException {
                ThemeColor r102 = r101.mask_color;
                if (r102 == null) goto L5;
                ThemeColor.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardContainerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CardContainerProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mask_color = this.mask_color;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CardContainerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CardContainerProperty(ThemeColor r100) {
            this(r100, ByteString.EMPTY);
        }

        public CardContainerProperty(ThemeColor r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mask_color = r100;
        }
    }

    public static final class ChattersPreviewProperty extends com.squareup.wire.Message<ChattersPreviewProperty, Builder> {
        public static final ProtoAdapter<ChattersPreviewProperty> ADAPTER = null;
        public static final Integer DEFAULT_CHATTERS_COUNT = null;
        public static final ChattersMode DEFAULT_CHATTERS_MODE = null;
        public static final Integer DEFAULT_MAX_SHOW_COUNT = null;
        public static final Theme DEFAULT_THEME = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final List<ChatterInfo> chatter_infos;
        public final Integer chatters_count;
        public final ChattersMode chatters_mode;
        public final Integer max_show_count;
        public final Theme theme;
        public final String title;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChattersPreviewProperty, Builder> {
            public List<ChatterInfo> chatter_infos;
            public Integer chatters_count;
            public ChattersMode chatters_mode;
            public Integer max_show_count;
            public Theme theme;
            public String title;

            @Override // com.squareup.wire.Message.Builder
            public ChattersPreviewProperty build() {
                return new ChattersPreviewProperty(this.theme, this.chatters_count, this.chatter_infos, this.max_show_count, this.chatters_mode, this.title, super.buildUnknownFields());
            }

            public Builder() {
                this.chatter_infos = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_infos(List<ChatterInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatter_infos = r100;
                return this;
            }

            public Builder chatters_count(Integer r100) {
                this.chatters_count = r100;
                return this;
            }

            public Builder chatters_mode(ChattersMode r100) {
                this.chatters_mode = r100;
                return this;
            }

            public Builder max_show_count(Integer r100) {
                this.max_show_count = r100;
                return this;
            }

            public Builder theme(Theme r100) {
                this.theme = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class ChatterInfo extends com.squareup.wire.Message<ChatterInfo, Builder> {
            public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
            public static final String DEFAULT_AVATAR_KEY = "";
            public static final String DEFAULT_CHATTER_ID = "";
            public static final String DEFAULT_NAME = "";
            public static final ChatterType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            public final String avatar_key;
            public final String chatter_id;
            public final String name;
            public final ChatterType type;

            public static final class Builder extends com.squareup.wire.Message.Builder<ChatterInfo, Builder> {
                public String avatar_key;
                public String chatter_id;
                public String name;
                public ChatterType type;

                @Override // com.squareup.wire.Message.Builder
                public ChatterInfo build() {
                    return new ChatterInfo(this.avatar_key, this.chatter_id, this.name, this.type, super.buildUnknownFields());
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

                public Builder chatter_id(String r100) {
                    this.chatter_id = r100;
                    return this;
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }

                public Builder type(ChatterType r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ChatterInfo extends ProtoAdapter<ChatterInfo> {
                public ProtoAdapter_ChatterInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, ChatterInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ChatterInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.avatar_key = "";
                    r101.chatter_id = "";
                    r101.name = "";
                    r101.type = ChatterType.USER;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L21;
                    if (r103 != 1) goto L8;
                    r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.chatter_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.type = ChatterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
                public int encodedSize2(ChatterInfo r100) {
                    String r101 = r100.avatar_key;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.chatter_id;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.name;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    ChatterType r110 = r100.type;
                    if (r110 == null) goto L18;
                    r102 = ChatterType.ADAPTER.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ ChatterInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ChatterInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ChatterInfo r101) throws IOException {
                    String r102 = r101.avatar_key;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.chatter_id;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.name;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    ChatterType r105 = r101.type;
                    if (r105 == null) goto L14;
                    ChatterType.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ChatterInfo();
                DEFAULT_TYPE = ChatterType.USER;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.avatar_key = this.avatar_key;
                r100.chatter_id = this.chatter_id;
                r100.name = this.name;
                r100.type = this.type;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public ChatterInfo(String r100, String r101, String r102, ChatterType r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public ChatterInfo(String r100, String r101, String r102, ChatterType r103, ByteString r104) {
                super(ADAPTER, r104);
                this.avatar_key = r100;
                this.chatter_id = r101;
                this.name = r102;
                this.type = r103;
            }
        }

        public static final enum ChatterType extends Enum<ChatterType> implements WireEnum {
            private static final /* synthetic */ ChatterType[] $VALUES = null;
            public static final ProtoAdapter<ChatterType> ADAPTER = null;
            public static final ChatterType UNKNOWN = null;
            public static final ChatterType USER = null;
            private final int value;

            static {
                ChatterType r100 = new ChatterType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                ChatterType r101 = new ChatterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
                USER = r101;
                $VALUES = new ChatterType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChatterType.class);
            }

            public static ChatterType[] values() {
                return (ChatterType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ChatterType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return USER;
            L10:
                return UNKNOWN;
            }

            public static ChatterType valueOf(String r100) {
                return (ChatterType) a.a(ChatterType.class, r100);
            }

            private ChatterType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum ChattersMode extends Enum<ChattersMode> implements WireEnum {
            private static final /* synthetic */ ChattersMode[] $VALUES = null;
            public static final ProtoAdapter<ChattersMode> ADAPTER = null;
            public static final ChattersMode DYNAMIC = null;
            public static final ChattersMode STATIC = null;
            private final int value;

            static {
                ChattersMode r100 = new ChattersMode("STATIC", 0, 0);
                STATIC = r100;
                ChattersMode r101 = new ChattersMode(BannerBizName.DYNAMIC, 1, 1);
                DYNAMIC = r101;
                $VALUES = new ChattersMode[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChattersMode.class);
            }

            public static ChattersMode[] values() {
                return (ChattersMode[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ChattersMode fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return DYNAMIC;
            L10:
                return STATIC;
            }

            public static ChattersMode valueOf(String r100) {
                return (ChattersMode) a.a(ChattersMode.class, r100);
            }

            private ChattersMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ChattersPreviewProperty extends ProtoAdapter<ChattersPreviewProperty> {
            public ProtoAdapter_ChattersPreviewProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ChattersPreviewProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChattersPreviewProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.theme = Theme.LIGHT;
                r101.chatters_count = 0;
                r101.max_show_count = 5;
                r101.chatters_mode = ChattersMode.DYNAMIC;
                r101.title = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L23;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L21;
                    case 6: goto L7;
                    default: goto L6;
                };
            L21:
                r101.chatters_mode = ChattersMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L23:
                r101.theme = Theme.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.max_show_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L13:
                r101.chatter_infos.add(ChatterInfo.ADAPTER.decode(r100));
                goto L3
            L14:
                r101.chatters_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L19:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChattersPreviewProperty r100) {
                Theme r101 = r100.theme;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Theme.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.chatters_count;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = (r103 + r105) + ChatterInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.chatter_infos);
                Integer r107 = r100.max_show_count;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(4, r107);
            L14:
                int r109 = r106 + r108;
                ChattersMode r110 = r100.chatters_mode;
                if (r110 == null) goto L17;
                int r111 = ChattersMode.ADAPTER.encodedSizeWithTag(5, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.title;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
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
            public /* bridge */ /* synthetic */ ChattersPreviewProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChattersPreviewProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChattersPreviewProperty r101) throws IOException {
                Theme r102 = r101.theme;
                if (r102 == null) goto L5;
                Theme.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.chatters_count;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ChatterInfo.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.chatter_infos);
                Integer r104 = r101.max_show_count;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
            L11:
                ChattersMode r105 = r101.chatters_mode;
                if (r105 == null) goto L14;
                ChattersMode.ADAPTER.encodeWithTag(r100, 5, r105);
            L14:
                String r106 = r101.title;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChattersPreviewProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChattersPreviewProperty();
            DEFAULT_THEME = Theme.LIGHT;
            DEFAULT_CHATTERS_COUNT = 0;
            DEFAULT_MAX_SHOW_COUNT = 5;
            DEFAULT_CHATTERS_MODE = ChattersMode.DYNAMIC;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.theme = this.theme;
            r100.chatters_count = this.chatters_count;
            r100.chatter_infos = Internal.copyOf("chatter_infos", this.chatter_infos);
            r100.max_show_count = this.max_show_count;
            r100.chatters_mode = this.chatters_mode;
            r100.title = this.title;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChattersPreviewProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChattersPreviewProperty(Theme r100, Integer r110, List<ChatterInfo> r111, Integer r112, ChattersMode r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ChattersPreviewProperty(Theme r100, Integer r101, List<ChatterInfo> r102, Integer r103, ChattersMode r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.theme = r100;
            this.chatters_count = r101;
            this.chatter_infos = Internal.immutableCopyOf("chatter_infos", r102);
            this.max_show_count = r103;
            this.chatters_mode = r104;
            this.title = r105;
        }
    }

    public static final enum Direction extends Enum<Direction> implements WireEnum {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final ProtoAdapter<Direction> ADAPTER = null;
        public static final Direction LTR = null;
        public static final Direction RTL = null;
        private final int value;

        static {
            Direction r100 = new Direction("LTR", 0, 0);
            LTR = r100;
            Direction r101 = new Direction("RTL", 1, 1);
            RTL = r101;
            $VALUES = new Direction[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Direction.class);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Direction fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return RTL;
        L10:
            return LTR;
        }

        public static Direction valueOf(String r100) {
            return (Direction) a.a(Direction.class, r100);
        }

        private Direction(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DocImageProperty extends com.squareup.wire.Message<DocImageProperty, Builder> {
        public static final ProtoAdapter<DocImageProperty> ADAPTER = null;
        public static final Doc.Type DEFAULT_DOC_TYPE = null;
        public static final String DEFAULT_SECRET_KEY = "";
        public static final String DEFAULT_SECRET_NONCE = "";
        public static final Integer DEFAULT_SECRET_TYPE = null;
        public static final String DEFAULT_SECRET_URL = "";
        public static final Boolean DEFAULT_SUPPORT_PREVIEW = null;
        public static final String DEFAULT_THUMBNAIL_URL = "";
        private static final long serialVersionUID = 0;
        public final Doc.Type doc_type;
        public final String secret_key;
        public final String secret_nonce;
        public final Integer secret_type;
        public final String secret_url;
        public final Boolean support_preview;
        public final String thumbnail_url;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocImageProperty, Builder> {
            public Doc.Type doc_type;
            public String secret_key;
            public String secret_nonce;
            public Integer secret_type;
            public String secret_url;
            public Boolean support_preview;
            public String thumbnail_url;

            @Override // com.squareup.wire.Message.Builder
            public DocImageProperty build() {
                return new DocImageProperty(this.doc_type, this.thumbnail_url, this.secret_url, this.secret_type, this.secret_key, this.secret_nonce, this.support_preview, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder doc_type(Doc.Type r100) {
                this.doc_type = r100;
                return this;
            }

            public Builder secret_key(String r100) {
                this.secret_key = r100;
                return this;
            }

            public Builder secret_nonce(String r100) {
                this.secret_nonce = r100;
                return this;
            }

            public Builder secret_type(Integer r100) {
                this.secret_type = r100;
                return this;
            }

            public Builder secret_url(String r100) {
                this.secret_url = r100;
                return this;
            }

            public Builder support_preview(Boolean r100) {
                this.support_preview = r100;
                return this;
            }

            public Builder thumbnail_url(String r100) {
                this.thumbnail_url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocImageProperty extends ProtoAdapter<DocImageProperty> {
            public ProtoAdapter_DocImageProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DocImageProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocImageProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.doc_type = Doc.Type.UNKNOWN;
                r101.thumbnail_url = "";
                r101.secret_url = "";
                r101.secret_type = 0;
                r101.secret_key = "";
                r101.secret_nonce = "";
                r101.support_preview = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L17;
                switch(r103) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r101.doc_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.support_preview = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.secret_nonce = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.secret_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.secret_type = ProtoAdapter.INT32.decode(r100);
                goto L3
            L11:
                r101.secret_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.thumbnail_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(DocImageProperty r100) {
                Doc.Type r101 = r100.doc_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Doc.Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.thumbnail_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.secret_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Integer r110 = r100.secret_type;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.secret_key;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.secret_nonce;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.support_preview;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ DocImageProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocImageProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocImageProperty r101) throws IOException {
                Doc.Type r102 = r101.doc_type;
                if (r102 == null) goto L5;
                Doc.Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.thumbnail_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.secret_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Integer r105 = r101.secret_type;
                if (r105 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.secret_key;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.secret_nonce;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.support_preview;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocImageProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocImageProperty();
            DEFAULT_DOC_TYPE = Doc.Type.UNKNOWN;
            DEFAULT_SECRET_TYPE = 0;
            DEFAULT_SUPPORT_PREVIEW = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.doc_type = this.doc_type;
            r100.thumbnail_url = this.thumbnail_url;
            r100.secret_url = this.secret_url;
            r100.secret_type = this.secret_type;
            r100.secret_key = this.secret_key;
            r100.secret_nonce = this.secret_nonce;
            r100.support_preview = this.support_preview;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocImageProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocImageProperty(Doc.Type r110, String r111, String r112, Integer r113, String r114, String r115, Boolean r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public DocImageProperty(Doc.Type r100, String r101, String r102, Integer r103, String r104, String r105, Boolean r106, ByteString r107) {
            super(ADAPTER, r107);
            this.doc_type = r100;
            this.thumbnail_url = r101;
            this.secret_url = r102;
            this.secret_type = r103;
            this.secret_key = r104;
            this.secret_nonce = r105;
            this.support_preview = r106;
        }
    }

    public static final class DocStateButtonProperty extends com.squareup.wire.Message<DocStateButtonProperty, Builder> {
        public static final ProtoAdapter<DocStateButtonProperty> ADAPTER = null;
        public static final String DEFAULT_CURR_STATE = "";
        private static final long serialVersionUID = 0;
        public final String curr_state;
        public final Map<String, DocState> state_map;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocStateButtonProperty, Builder> {
            public String curr_state;
            public Map<String, DocState> state_map;

            @Override // com.squareup.wire.Message.Builder
            public DocStateButtonProperty build() {
                return new DocStateButtonProperty(this.curr_state, this.state_map, super.buildUnknownFields());
            }

            public Builder() {
                this.state_map = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder curr_state(String r100) {
                this.curr_state = r100;
                return this;
            }

            public Builder state_map(Map<String, DocState> r100) {
                Internal.checkElementsNotNull(r100);
                this.state_map = r100;
                return this;
            }
        }

        public static final class DocState extends com.squareup.wire.Message<DocState, Builder> {
            public static final ProtoAdapter<DocState> ADAPTER = null;
            public static final String DEFAULT_ALT = "";
            public static final Boolean DEFAULT_LOADING = null;
            public static final String DEFAULT_NEXT_STATE = "";
            public static final Boolean DEFAULT_SELECTED = null;
            public static final String DEFAULT_UD_BTN_COLOR = "";
            private static final long serialVersionUID = 0;
            public final String alt;
            public final Boolean loading;
            public final String next_state;
            public final Boolean selected;
            public final String ud_btn_color;
            public final UDIcon ud_icon;

            public static final class Builder extends com.squareup.wire.Message.Builder<DocState, Builder> {
                public String alt;
                public Boolean loading;
                public String next_state;
                public Boolean selected;
                public String ud_btn_color;
                public UDIcon ud_icon;

                @Override // com.squareup.wire.Message.Builder
                public DocState build() {
                    return new DocState(this.alt, this.ud_icon, this.next_state, this.ud_btn_color, this.loading, this.selected, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder alt(String r100) {
                    this.alt = r100;
                    return this;
                }

                public Builder loading(Boolean r100) {
                    this.loading = r100;
                    return this;
                }

                public Builder next_state(String r100) {
                    this.next_state = r100;
                    return this;
                }

                public Builder selected(Boolean r100) {
                    this.selected = r100;
                    return this;
                }

                public Builder ud_btn_color(String r100) {
                    this.ud_btn_color = r100;
                    return this;
                }

                public Builder ud_icon(UDIcon r100) {
                    this.ud_icon = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_DocState extends ProtoAdapter<DocState> {
                public ProtoAdapter_DocState() {
                    super(FieldEncoding.LENGTH_DELIMITED, DocState.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DocState decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.alt = "";
                    r101.next_state = "";
                    r101.ud_btn_color = "";
                    Boolean r102 = Boolean.FALSE;
                    r101.loading = r102;
                    r101.selected = r102;
                    long r103 = r100.beginMessage();
                L3:
                    int r104 = r100.nextTag();
                    if (r104 == (-1)) goto L13;
                    switch(r104) {
                        case 1: goto L12;
                        case 2: goto L11;
                        case 3: goto L10;
                        case 4: goto L9;
                        case 5: goto L8;
                        case 6: goto L7;
                        default: goto L6;
                    };
                L7:
                    r101.selected = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L8:
                    r101.loading = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L9:
                    r101.ud_btn_color = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    r101.next_state = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L11:
                    r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                    goto L3
                L12:
                    r101.alt = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r105 = r100.peekFieldEncoding();
                    r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                    goto L3
                L13:
                    r100.endMessage(r103);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(DocState r100) {
                    String r101 = r100.alt;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    UDIcon r104 = r100.ud_icon;
                    if (r104 == null) goto L9;
                    int r105 = UDIcon.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.next_state;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    String r110 = r100.ud_btn_color;
                    if (r110 == null) goto L17;
                    int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
                L18:
                    int r112 = r109 + r111;
                    Boolean r113 = r100.loading;
                    if (r113 == null) goto L21;
                    int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
                L22:
                    int r115 = r112 + r114;
                    Boolean r116 = r100.selected;
                    if (r116 == null) goto L26;
                    r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
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
                public /* bridge */ /* synthetic */ DocState decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DocState r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DocState r101) throws IOException {
                    String r102 = r101.alt;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    UDIcon r103 = r101.ud_icon;
                    if (r103 == null) goto L8;
                    UDIcon.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.next_state;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    String r105 = r101.ud_btn_color;
                    if (r105 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
                L14:
                    Boolean r106 = r101.loading;
                    if (r106 == null) goto L17;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
                L17:
                    Boolean r107 = r101.selected;
                    if (r107 == null) goto L20;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
                L20:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocState r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DocState();
                Boolean r100 = Boolean.FALSE;
                DEFAULT_LOADING = r100;
                DEFAULT_SELECTED = r100;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.alt = this.alt;
                r100.ud_icon = this.ud_icon;
                r100.next_state = this.next_state;
                r100.ud_btn_color = this.ud_btn_color;
                r100.loading = this.loading;
                r100.selected = this.selected;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DocState.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public DocState(String r100, UDIcon r110, String r111, String r112, Boolean r113, Boolean r114) {
                this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
            }

            public DocState(String r100, UDIcon r101, String r102, String r103, Boolean r104, Boolean r105, ByteString r106) {
                super(ADAPTER, r106);
                this.alt = r100;
                this.ud_icon = r101;
                this.next_state = r102;
                this.ud_btn_color = r103;
                this.loading = r104;
                this.selected = r105;
            }
        }

        public static final class ProtoAdapter_DocStateButtonProperty extends ProtoAdapter<DocStateButtonProperty> {
            private final ProtoAdapter<Map<String, DocState>> state_map;

            public ProtoAdapter_DocStateButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DocStateButtonProperty.class);
                this.state_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DocState.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocStateButtonProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.curr_state = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.curr_state = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.state_map.putAll(this.state_map.decode(r100));
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
            public int encodedSize2(DocStateButtonProperty r100) {
                String r101 = r100.curr_state;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + this.state_map.encodedSizeWithTag(2, r100.state_map)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocStateButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocStateButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocStateButtonProperty r101) throws IOException {
                String r102 = r101.curr_state;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                this.state_map.encodeWithTag(r100, 2, r101.state_map);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocStateButtonProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocStateButtonProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.curr_state = this.curr_state;
            r100.state_map = Internal.copyOf("state_map", this.state_map);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocStateButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocStateButtonProperty(String r100, Map<String, DocState> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DocStateButtonProperty(String r100, Map<String, DocState> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.curr_state = r100;
            this.state_map = Internal.immutableCopyOf("state_map", r101);
        }
    }

    public static final class EmptyProperty extends com.squareup.wire.Message<EmptyProperty, Builder> {
        public static final ProtoAdapter<EmptyProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_CONTAINER_STYLE = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ThemeColor active;
        public final String container_style;
        public final ThemeColor hover;

        public static final class Builder extends com.squareup.wire.Message.Builder<EmptyProperty, Builder> {
            public String action_id;
            public ThemeColor active;
            public String container_style;
            public ThemeColor hover;

            @Override // com.squareup.wire.Message.Builder
            public EmptyProperty build() {
                return new EmptyProperty(this.action_id, this.hover, this.active, this.container_style, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder active(ThemeColor r100) {
                this.active = r100;
                return this;
            }

            public Builder container_style(String r100) {
                this.container_style = r100;
                return this;
            }

            public Builder hover(ThemeColor r100) {
                this.hover = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EmptyProperty extends ProtoAdapter<EmptyProperty> {
            public ProtoAdapter_EmptyProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EmptyProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EmptyProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.container_style = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.hover = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.active = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.container_style = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(EmptyProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ThemeColor r104 = r100.hover;
                if (r104 == null) goto L9;
                int r105 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ThemeColor r107 = r100.active;
                if (r107 == null) goto L13;
                int r108 = ThemeColor.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.container_style;
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
            public /* bridge */ /* synthetic */ EmptyProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EmptyProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EmptyProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ThemeColor r103 = r101.hover;
                if (r103 == null) goto L8;
                ThemeColor.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                ThemeColor r104 = r101.active;
                if (r104 == null) goto L11;
                ThemeColor.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.container_style;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmptyProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EmptyProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.hover = this.hover;
            r100.active = this.active;
            r100.container_style = this.container_style;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EmptyProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EmptyProperty(String r100, ThemeColor r101, ThemeColor r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public EmptyProperty(String r100, ThemeColor r101, ThemeColor r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.action_id = r100;
            this.hover = r101;
            this.active = r102;
            this.container_style = r103;
        }
    }

    public static final class EngineProperty extends com.squareup.wire.Message<EngineProperty, Builder> {
        public static final ProtoAdapter<EngineProperty> ADAPTER = null;
        public static final ByteString DEFAULT_BODY = null;
        public static final EngineType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final ByteString body;
        public final TurtleCanvasContent turtle_canvas;
        public final EngineType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<EngineProperty, Builder> {
            public ByteString body;
            public TurtleCanvasContent turtle_canvas;
            public EngineType type;

            @Override // com.squareup.wire.Message.Builder
            public EngineProperty build() {
                return new EngineProperty(this.type, this.body, this.turtle_canvas, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder body(ByteString r100) {
                this.body = r100;
                return this;
            }

            public Builder turtle_canvas(TurtleCanvasContent r100) {
                this.turtle_canvas = r100;
                return this;
            }

            public Builder type(EngineType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final enum EngineType extends Enum<EngineType> implements WireEnum {
            private static final /* synthetic */ EngineType[] $VALUES = null;
            public static final ProtoAdapter<EngineType> ADAPTER = null;
            public static final EngineType DOC_COMPONENT = null;
            public static final EngineType MESSAGE = null;
            public static final EngineType TURTLE_CANVAS = null;
            private final int value;

            static {
                EngineType r100 = new EngineType("MESSAGE", 0, 0);
                MESSAGE = r100;
                EngineType r101 = new EngineType("DOC_COMPONENT", 1, 1);
                DOC_COMPONENT = r101;
                EngineType r102 = new EngineType("TURTLE_CANVAS", 2, 2);
                TURTLE_CANVAS = r102;
                $VALUES = new EngineType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(EngineType.class);
            }

            public static EngineType[] values() {
                return (EngineType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static EngineType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return TURTLE_CANVAS;
            L12:
                return DOC_COMPONENT;
            L14:
                return MESSAGE;
            }

            public static EngineType valueOf(String r100) {
                return (EngineType) a.a(EngineType.class, r100);
            }

            private EngineType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_EngineProperty extends ProtoAdapter<EngineProperty> {
            public ProtoAdapter_EngineProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EngineProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EngineProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = EngineType.MESSAGE;
                r101.body = ByteString.EMPTY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.type = EngineType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.body = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L10:
                if (r103 != 100) goto L11;
                r101.turtle_canvas(TurtleCanvasContent.ADAPTER.decode(r100));
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
            public int encodedSize2(EngineProperty r100) {
                EngineType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = EngineType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ByteString r104 = r100.body;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TurtleCanvasContent r107 = r100.turtle_canvas;
                if (r107 == null) goto L14;
                r102 = TurtleCanvasContent.ADAPTER.encodedSizeWithTag(100, r107);
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
            public /* bridge */ /* synthetic */ EngineProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EngineProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EngineProperty r101) throws IOException {
                EngineType r102 = r101.type;
                if (r102 == null) goto L5;
                EngineType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ByteString r103 = r101.body;
                if (r103 == null) goto L8;
                ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
            L8:
                TurtleCanvasContent r104 = r101.turtle_canvas;
                if (r104 == null) goto L11;
                TurtleCanvasContent.ADAPTER.encodeWithTag(r100, 100, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EngineProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EngineProperty();
            DEFAULT_TYPE = EngineType.MESSAGE;
            DEFAULT_BODY = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.body = this.body;
            r100.turtle_canvas = this.turtle_canvas;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EngineProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EngineProperty(EngineType r100, ByteString r101, TurtleCanvasContent r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public EngineProperty(EngineType r100, ByteString r101, TurtleCanvasContent r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.body = r101;
            this.turtle_canvas = r102;
        }
    }

    public static final class FlexLayoutProperty extends com.squareup.wire.Message<FlexLayoutProperty, Builder> {
        public static final ProtoAdapter<FlexLayoutProperty> ADAPTER = null;
        public static final Align DEFAULT_CROSS_AXIS_ALIGN = null;
        public static final Float DEFAULT_CROSS_AXIS_SPACING = null;
        public static final FlexWrap DEFAULT_FLEX_WRAP = null;
        public static final Boolean DEFAULT_FORCE_USE_COMPACT_MODE = null;
        public static final Justify DEFAULT_MAIN_AXIS_JUSTIFY = null;
        public static final Float DEFAULT_MAIN_AXIS_SPACING = null;
        public static final Orientation DEFAULT_ORIENTATION = null;
        private static final long serialVersionUID = 0;
        public final Align cross_axis_align;
        public final Float cross_axis_spacing;
        public final FlexWrap flex_wrap;
        public final Boolean force_use_compact_mode;
        public final Justify main_axis_justify;
        public final Float main_axis_spacing;
        public final Orientation orientation;
        public final Padding padding;

        public static final class Builder extends com.squareup.wire.Message.Builder<FlexLayoutProperty, Builder> {
            public Align cross_axis_align;
            public Float cross_axis_spacing;
            public FlexWrap flex_wrap;
            public Boolean force_use_compact_mode;
            public Justify main_axis_justify;
            public Float main_axis_spacing;
            public Orientation orientation;
            public Padding padding;

            @Override // com.squareup.wire.Message.Builder
            public FlexLayoutProperty build() {
                return new FlexLayoutProperty(this.orientation, this.flex_wrap, this.main_axis_spacing, this.cross_axis_spacing, this.padding, this.main_axis_justify, this.cross_axis_align, this.force_use_compact_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder cross_axis_align(Align r100) {
                this.cross_axis_align = r100;
                return this;
            }

            public Builder cross_axis_spacing(Float r100) {
                this.cross_axis_spacing = r100;
                return this;
            }

            public Builder flex_wrap(FlexWrap r100) {
                this.flex_wrap = r100;
                return this;
            }

            public Builder force_use_compact_mode(Boolean r100) {
                this.force_use_compact_mode = r100;
                return this;
            }

            public Builder main_axis_justify(Justify r100) {
                this.main_axis_justify = r100;
                return this;
            }

            public Builder main_axis_spacing(Float r100) {
                this.main_axis_spacing = r100;
                return this;
            }

            public Builder orientation(Orientation r100) {
                this.orientation = r100;
                return this;
            }

            public Builder padding(Padding r100) {
                this.padding = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FlexLayoutProperty extends ProtoAdapter<FlexLayoutProperty> {
            public ProtoAdapter_FlexLayoutProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, FlexLayoutProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FlexLayoutProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.orientation = Orientation.ROW;
                r101.flex_wrap = FlexWrap.NO_WRAP;
                Float r102 = Float.valueOf(0.0f);
                r101.main_axis_spacing = r102;
                r101.cross_axis_spacing = r102;
                r101.main_axis_justify = Justify.START;
                r101.cross_axis_align = Align.TOP;
                r101.force_use_compact_mode = Boolean.FALSE;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L27;
                switch(r104) {
                    case 1: goto L33;
                    case 2: goto L35;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L29;
                    case 7: goto L31;
                    case 8: goto L7;
                    default: goto L6;
                };
            L29:
                r101.main_axis_justify = Justify.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L31:
                r101.cross_axis_align = Align.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L33:
                r101.orientation = Orientation.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L35:
                r101.flex_wrap = FlexWrap.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.force_use_compact_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.padding = Padding.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.cross_axis_spacing = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L18:
                r101.main_axis_spacing = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L27:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FlexLayoutProperty r100) {
                Orientation r101 = r100.orientation;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Orientation.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                FlexWrap r104 = r100.flex_wrap;
                if (r104 == null) goto L9;
                int r105 = FlexWrap.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Float r107 = r100.main_axis_spacing;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Float r110 = r100.cross_axis_spacing;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Padding r113 = r100.padding;
                if (r113 == null) goto L21;
                int r114 = Padding.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Justify r116 = r100.main_axis_justify;
                if (r116 == null) goto L25;
                int r117 = Justify.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Align r119 = r100.cross_axis_align;
                if (r119 == null) goto L29;
                int r120 = Align.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.force_use_compact_mode;
                if (r122 == null) goto L34;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
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
            public /* bridge */ /* synthetic */ FlexLayoutProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FlexLayoutProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FlexLayoutProperty r101) throws IOException {
                Orientation r102 = r101.orientation;
                if (r102 == null) goto L5;
                Orientation.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                FlexWrap r103 = r101.flex_wrap;
                if (r103 == null) goto L8;
                FlexWrap.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Float r104 = r101.main_axis_spacing;
                if (r104 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
            L11:
                Float r105 = r101.cross_axis_spacing;
                if (r105 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
            L14:
                Padding r106 = r101.padding;
                if (r106 == null) goto L17;
                Padding.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Justify r107 = r101.main_axis_justify;
                if (r107 == null) goto L20;
                Justify.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Align r108 = r101.cross_axis_align;
                if (r108 == null) goto L23;
                Align.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                Boolean r109 = r101.force_use_compact_mode;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FlexLayoutProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FlexLayoutProperty();
            DEFAULT_ORIENTATION = Orientation.ROW;
            DEFAULT_FLEX_WRAP = FlexWrap.NO_WRAP;
            Float r100 = Float.valueOf(0.0f);
            DEFAULT_MAIN_AXIS_SPACING = r100;
            DEFAULT_CROSS_AXIS_SPACING = r100;
            DEFAULT_MAIN_AXIS_JUSTIFY = Justify.START;
            DEFAULT_CROSS_AXIS_ALIGN = Align.TOP;
            DEFAULT_FORCE_USE_COMPACT_MODE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.orientation = this.orientation;
            r100.flex_wrap = this.flex_wrap;
            r100.main_axis_spacing = this.main_axis_spacing;
            r100.cross_axis_spacing = this.cross_axis_spacing;
            r100.padding = this.padding;
            r100.main_axis_justify = this.main_axis_justify;
            r100.cross_axis_align = this.cross_axis_align;
            r100.force_use_compact_mode = this.force_use_compact_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FlexLayoutProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public FlexLayoutProperty(Orientation r110, FlexWrap r111, Float r112, Float r113, Padding r114, Justify r115, Align r116, Boolean r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public FlexLayoutProperty(Orientation r100, FlexWrap r101, Float r102, Float r103, Padding r104, Justify r105, Align r106, Boolean r107, ByteString r110) {
            super(ADAPTER, r110);
            this.orientation = r100;
            this.flex_wrap = r101;
            this.main_axis_spacing = r102;
            this.cross_axis_spacing = r103;
            this.padding = r104;
            this.main_axis_justify = r105;
            this.cross_axis_align = r106;
            this.force_use_compact_mode = r107;
        }
    }

    public static final enum FlexWrap extends Enum<FlexWrap> implements WireEnum {
        private static final /* synthetic */ FlexWrap[] $VALUES = null;
        public static final ProtoAdapter<FlexWrap> ADAPTER = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;
        private final int value;

        static {
            FlexWrap r100 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r100;
            FlexWrap r101 = new FlexWrap("WRAP", 1, 1);
            WRAP = r101;
            FlexWrap r102 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r102;
            FlexWrap r103 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r103;
            $VALUES = new FlexWrap[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FlexWrap.class);
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FlexWrap fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return LINEAR_WRAP;
        L14:
            return WRAP_REVERSE;
        L16:
            return WRAP;
        L18:
            return NO_WRAP;
        }

        public static FlexWrap valueOf(String r100) {
            return (FlexWrap) a.a(FlexWrap.class, r100);
        }

        private FlexWrap(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class FontLevel extends com.squareup.wire.Message<FontLevel, Builder> {
        public static final ProtoAdapter<FontLevel> ADAPTER = null;
        public static final Integer DEFAULT_LEVEL = null;
        public static final FontType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Integer level;
        public final FontType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<FontLevel, Builder> {
            public Integer level;
            public FontType type;

            @Override // com.squareup.wire.Message.Builder
            public FontLevel build() {
                return new FontLevel(this.type, this.level, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder level(Integer r100) {
                this.level = r100;
                return this;
            }

            public Builder type(FontType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FontLevel extends ProtoAdapter<FontLevel> {
            public ProtoAdapter_FontLevel() {
                super(FieldEncoding.LENGTH_DELIMITED, FontLevel.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FontLevel decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = FontType.CAPTION;
                r101.level = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = FontType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.level = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FontLevel r100) {
                FontType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = FontType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.level;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FontLevel decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FontLevel r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FontLevel r101) throws IOException {
                FontType r102 = r101.type;
                if (r102 == null) goto L5;
                FontType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.level;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FontLevel r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FontLevel();
            DEFAULT_TYPE = FontType.CAPTION;
            DEFAULT_LEVEL = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.level = this.level;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FontLevel.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public FontLevel(FontType r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public FontLevel(FontType r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.level = r101;
        }
    }

    public static final enum FontType extends Enum<FontType> implements WireEnum {
        private static final /* synthetic */ FontType[] $VALUES = null;
        public static final ProtoAdapter<FontType> ADAPTER = null;
        public static final FontType BODY = null;
        public static final FontType CAPTION = null;
        public static final FontType HEADLINE = null;
        public static final FontType TITLE = null;
        private final int value;

        static {
            FontType r100 = new FontType("TITLE", 0, 0);
            TITLE = r100;
            FontType r101 = new FontType("HEADLINE", 1, 1);
            HEADLINE = r101;
            FontType r102 = new FontType("BODY", 2, 2);
            BODY = r102;
            FontType r103 = new FontType("CAPTION", 3, 3);
            CAPTION = r103;
            $VALUES = new FontType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FontType.class);
        }

        public static FontType[] values() {
            return (FontType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FontType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return CAPTION;
        L14:
            return BODY;
        L16:
            return HEADLINE;
        L18:
            return TITLE;
        }

        public static FontType valueOf(String r100) {
            return (FontType) a.a(FontType.class, r100);
        }

        private FontType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class IconButtonProperty extends com.squareup.wire.Message<IconButtonProperty, Builder> {
        public static final ProtoAdapter<IconButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_ALT = "";
        public static final Boolean DEFAULT_IS_DISABLE = null;
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final String alt;
        public final ImageSet icon;
        public final Boolean is_disable;
        public final UDIcon ud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<IconButtonProperty, Builder> {
            public String action_id;
            public String alt;
            public ImageSet icon;
            public Boolean is_disable;
            public UDIcon ud_icon;

            @Override // com.squareup.wire.Message.Builder
            public IconButtonProperty build() {
                return new IconButtonProperty(this.icon, this.action_id, this.is_disable, this.alt, this.ud_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder alt(String r100) {
                this.alt = r100;
                return this;
            }

            public Builder icon(ImageSet r100) {
                this.icon = r100;
                return this;
            }

            public Builder is_disable(Boolean r100) {
                this.is_disable = r100;
                return this;
            }

            public Builder ud_icon(UDIcon r100) {
                this.ud_icon = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_IconButtonProperty extends ProtoAdapter<IconButtonProperty> {
            public ProtoAdapter_IconButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, IconButtonProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public IconButtonProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.is_disable = Boolean.FALSE;
                r101.alt = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.icon = ImageSet.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.is_disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.alt = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(IconButtonProperty r100) {
                ImageSet r101 = r100.icon;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.action_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_disable;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.alt;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                UDIcon r113 = r100.ud_icon;
                if (r113 == null) goto L22;
                r102 = UDIcon.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ IconButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(IconButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, IconButtonProperty r101) throws IOException {
                ImageSet r102 = r101.icon;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.action_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_disable;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.alt;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                UDIcon r106 = r101.ud_icon;
                if (r106 == null) goto L17;
                UDIcon.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IconButtonProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_IconButtonProperty();
            DEFAULT_IS_DISABLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon = this.icon;
            r100.action_id = this.action_id;
            r100.is_disable = this.is_disable;
            r100.alt = this.alt;
            r100.ud_icon = this.ud_icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return IconButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public IconButtonProperty(ImageSet r100, String r101, Boolean r110, String r111, UDIcon r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public IconButtonProperty(ImageSet r100, String r101, Boolean r102, String r103, UDIcon r104, ByteString r105) {
            super(ADAPTER, r105);
            this.icon = r100;
            this.action_id = r101;
            this.is_disable = r102;
            this.alt = r103;
            this.ud_icon = r104;
        }
    }

    public static final class ImageContainerProperty extends com.squareup.wire.Message<ImageContainerProperty, Builder> {
        public static final ProtoAdapter<ImageContainerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final ContentMode DEFAULT_CONTENT_MODE = null;
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ImageSet background;
        public final ContentMode content_mode;
        public final ImageSet dm_background;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageContainerProperty, Builder> {
            public String action_id;
            public ImageSet background;
            public ContentMode content_mode;
            public ImageSet dm_background;

            @Override // com.squareup.wire.Message.Builder
            public ImageContainerProperty build() {
                return new ImageContainerProperty(this.background, this.action_id, this.content_mode, this.dm_background, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder background(ImageSet r100) {
                this.background = r100;
                return this;
            }

            public Builder content_mode(ContentMode r100) {
                this.content_mode = r100;
                return this;
            }

            public Builder dm_background(ImageSet r100) {
                this.dm_background = r100;
                return this;
            }
        }

        public static final enum ContentMode extends Enum<ContentMode> implements WireEnum {
            private static final /* synthetic */ ContentMode[] $VALUES = null;
            public static final ProtoAdapter<ContentMode> ADAPTER = null;
            public static final ContentMode CENTER = null;
            public static final ContentMode SCALE_ASPECT_FILL = null;
            public static final ContentMode SCALE_ASPECT_FIT = null;
            public static final ContentMode SCALE_TO_FILL = null;
            private final int value;

            static {
                ContentMode r100 = new ContentMode("SCALE_TO_FILL", 0, 0);
                SCALE_TO_FILL = r100;
                ContentMode r101 = new ContentMode("SCALE_ASPECT_FIT", 1, 1);
                SCALE_ASPECT_FIT = r101;
                ContentMode r102 = new ContentMode("SCALE_ASPECT_FILL", 2, 2);
                SCALE_ASPECT_FILL = r102;
                ContentMode r103 = new ContentMode("CENTER", 3, 3);
                CENTER = r103;
                $VALUES = new ContentMode[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContentMode.class);
            }

            public static ContentMode[] values() {
                return (ContentMode[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ContentMode fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return CENTER;
            L14:
                return SCALE_ASPECT_FILL;
            L16:
                return SCALE_ASPECT_FIT;
            L18:
                return SCALE_TO_FILL;
            }

            public static ContentMode valueOf(String r100) {
                return (ContentMode) a.a(ContentMode.class, r100);
            }

            private ContentMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ImageContainerProperty extends ProtoAdapter<ImageContainerProperty> {
            public ProtoAdapter_ImageContainerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageContainerProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageContainerProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.content_mode = ContentMode.SCALE_TO_FILL;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.background = ImageSet.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.content_mode = ContentMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.dm_background = ImageSet.ADAPTER.decode(r100);
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
            public int encodedSize2(ImageContainerProperty r100) {
                ImageSet r101 = r100.background;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.action_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ContentMode r107 = r100.content_mode;
                if (r107 == null) goto L13;
                int r108 = ContentMode.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ImageSet r110 = r100.dm_background;
                if (r110 == null) goto L18;
                r102 = ImageSet.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ ImageContainerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageContainerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageContainerProperty r101) throws IOException {
                ImageSet r102 = r101.background;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.action_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ContentMode r104 = r101.content_mode;
                if (r104 == null) goto L11;
                ContentMode.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ImageSet r105 = r101.dm_background;
                if (r105 == null) goto L14;
                ImageSet.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageContainerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageContainerProperty();
            DEFAULT_CONTENT_MODE = ContentMode.SCALE_TO_FILL;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.background = this.background;
            r100.action_id = this.action_id;
            r100.content_mode = this.content_mode;
            r100.dm_background = this.dm_background;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageContainerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageContainerProperty(ImageSet r100, String r101, ContentMode r102, ImageSet r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ImageContainerProperty(ImageSet r100, String r101, ContentMode r102, ImageSet r103, ByteString r104) {
            super(ADAPTER, r104);
            this.background = r100;
            this.action_id = r101;
            this.content_mode = r102;
            this.dm_background = r103;
        }
    }

    public static final class ImageProperty extends com.squareup.wire.Message<ImageProperty, Builder> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final String DEFAULT_ALT = "";
        public static final String DEFAULT_DM_IMAGE_URL = "";
        public static final String DEFAULT_IMAGE_URL = "";
        private static final long serialVersionUID = 0;
        public final String alt;
        public final ImageSet dm_image;
        public final String dm_image_url;
        public final ImageSet image;
        public final String image_url;
        public final UDIcon ud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageProperty, Builder> {
            public String alt;
            public ImageSet dm_image;
            public String dm_image_url;
            public ImageSet image;
            public String image_url;
            public UDIcon ud_icon;

            @Override // com.squareup.wire.Message.Builder
            public ImageProperty build() {
                return new ImageProperty(this.image, this.alt, this.ud_icon, this.image_url, this.dm_image, this.dm_image_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder alt(String r100) {
                this.alt = r100;
                return this;
            }

            public Builder dm_image(ImageSet r100) {
                this.dm_image = r100;
                return this;
            }

            public Builder dm_image_url(String r100) {
                this.dm_image_url = r100;
                return this;
            }

            public Builder image(ImageSet r100) {
                this.image = r100;
                return this;
            }

            public Builder image_url(String r100) {
                this.image_url = r100;
                return this;
            }

            public Builder ud_icon(UDIcon r100) {
                this.ud_icon = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageProperty extends ProtoAdapter<ImageProperty> {
            public ProtoAdapter_ImageProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.alt = "";
                r101.image_url = "";
                r101.dm_image_url = "";
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
                r101.dm_image_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.dm_image = ImageSet.ADAPTER.decode(r100);
                goto L3
            L9:
                r101.image_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.alt = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.image = ImageSet.ADAPTER.decode(r100);
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
            public int encodedSize2(ImageProperty r100) {
                ImageSet r101 = r100.image;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.alt;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                UDIcon r107 = r100.ud_icon;
                if (r107 == null) goto L13;
                int r108 = UDIcon.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.image_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ImageSet r113 = r100.dm_image;
                if (r113 == null) goto L21;
                int r114 = ImageSet.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.dm_image_url;
                if (r116 == null) goto L26;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
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
            public /* bridge */ /* synthetic */ ImageProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageProperty r101) throws IOException {
                ImageSet r102 = r101.image;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.alt;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                UDIcon r104 = r101.ud_icon;
                if (r104 == null) goto L11;
                UDIcon.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.image_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ImageSet r106 = r101.dm_image;
                if (r106 == null) goto L17;
                ImageSet.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.dm_image_url;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.image = this.image;
            r100.alt = this.alt;
            r100.ud_icon = this.ud_icon;
            r100.image_url = this.image_url;
            r100.dm_image = this.dm_image;
            r100.dm_image_url = this.dm_image_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageProperty(ImageSet r100, String r110, UDIcon r111, String r112, ImageSet r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ImageProperty(ImageSet r100, String r101, UDIcon r102, String r103, ImageSet r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.image = r100;
            this.alt = r101;
            this.ud_icon = r102;
            this.image_url = r103;
            this.dm_image = r104;
            this.dm_image_url = r105;
        }
    }

    public static final class Item extends com.squareup.wire.Message<Item, Builder> {
        public static final ProtoAdapter<Item> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final String text;

        public static final class Builder extends com.squareup.wire.Message.Builder<Item, Builder> {
            public String action_id;
            public String text;

            @Override // com.squareup.wire.Message.Builder
            public Item build() {
                return new Item(this.action_id, this.text, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
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
                r101.action_id = "";
                r101.text = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.text = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Item r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.text;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
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
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.text;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Item r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Item();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.text = this.text;
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

        public Item(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Item(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.action_id = r100;
            this.text = r101;
        }
    }

    public static final enum Justify extends Enum<Justify> implements WireEnum {
        private static final /* synthetic */ Justify[] $VALUES = null;
        public static final ProtoAdapter<Justify> ADAPTER = null;
        public static final Justify CENTER = null;
        public static final Justify END = null;
        public static final Justify SPACE_ARROUND = null;
        public static final Justify SPACE_BETWEEN = null;
        public static final Justify SPACE_EVENLY = null;
        public static final Justify START = null;
        private final int value;

        static {
            Justify r100 = new Justify(GXAnimation.STATE_START, 0, 0);
            START = r100;
            Justify r101 = new Justify("CENTER", 1, 1);
            CENTER = r101;
            Justify r102 = new Justify(GXAnimation.STATE_END, 2, 2);
            END = r102;
            Justify r103 = new Justify("SPACE_BETWEEN", 3, 3);
            SPACE_BETWEEN = r103;
            Justify r104 = new Justify("SPACE_ARROUND", 4, 4);
            SPACE_ARROUND = r104;
            Justify r105 = new Justify("SPACE_EVENLY", 5, 5);
            SPACE_EVENLY = r105;
            $VALUES = new Justify[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(Justify.class);
        }

        public static Justify[] values() {
            return (Justify[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Justify fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return SPACE_EVENLY;
        L18:
            return SPACE_ARROUND;
        L20:
            return SPACE_BETWEEN;
        L22:
            return END;
        L24:
            return CENTER;
        L26:
            return START;
        }

        public static Justify valueOf(String r100) {
            return (Justify) a.a(Justify.class, r100);
        }

        private Justify(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class LinearLayoutProperty extends com.squareup.wire.Message<LinearLayoutProperty, Builder> {
        public static final ProtoAdapter<LinearLayoutProperty> ADAPTER = null;
        public static final Align DEFAULT_CROSS_AXIS_ALIGN = null;
        public static final Justify DEFAULT_MAIN_AXIS_JUSTIFY = null;
        public static final Orientation DEFAULT_ORIENTATION = null;
        public static final Float DEFAULT_PADDING = null;
        public static final Float DEFAULT_SPACING = null;
        public static final Float DEFAULT_WRAP_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final Align cross_axis_align;
        public final Justify main_axis_justify;
        public final Orientation orientation;
        public final Float padding;
        public final Padding side_padding;
        public final Float spacing;
        public final Float wrap_width;

        public static final class Builder extends com.squareup.wire.Message.Builder<LinearLayoutProperty, Builder> {
            public Align cross_axis_align;
            public Justify main_axis_justify;
            public Orientation orientation;
            public Float padding;
            public Padding side_padding;
            public Float spacing;
            public Float wrap_width;

            @Override // com.squareup.wire.Message.Builder
            public LinearLayoutProperty build() {
                return new LinearLayoutProperty(this.orientation, this.spacing, this.wrap_width, this.padding, this.main_axis_justify, this.cross_axis_align, this.side_padding, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder cross_axis_align(Align r100) {
                this.cross_axis_align = r100;
                return this;
            }

            public Builder main_axis_justify(Justify r100) {
                this.main_axis_justify = r100;
                return this;
            }

            public Builder orientation(Orientation r100) {
                this.orientation = r100;
                return this;
            }

            public Builder padding(Float r100) {
                this.padding = r100;
                return this;
            }

            public Builder side_padding(Padding r100) {
                this.side_padding = r100;
                return this;
            }

            public Builder spacing(Float r100) {
                this.spacing = r100;
                return this;
            }

            public Builder wrap_width(Float r100) {
                this.wrap_width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LinearLayoutProperty extends ProtoAdapter<LinearLayoutProperty> {
            public ProtoAdapter_LinearLayoutProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LinearLayoutProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LinearLayoutProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.orientation = Orientation.ROW;
                Float r102 = Float.valueOf(0.0f);
                r101.spacing = r102;
                r101.wrap_width = r102;
                r101.padding = r102;
                r101.main_axis_justify = Justify.START;
                r101.cross_axis_align = Align.TOP;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L23;
                switch(r104) {
                    case 1: goto L27;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L29;
                    case 6: goto L25;
                    case 7: goto L7;
                    default: goto L6;
                };
            L25:
                r101.cross_axis_align = Align.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L27:
                r101.orientation = Orientation.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L29:
                r101.main_axis_justify = Justify.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.side_padding = Padding.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.padding = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L17:
                r101.wrap_width = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L18:
                r101.spacing = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L23:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LinearLayoutProperty r100) {
                Orientation r101 = r100.orientation;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Orientation.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Float r104 = r100.spacing;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Float r107 = r100.wrap_width;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Float r110 = r100.padding;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Justify r113 = r100.main_axis_justify;
                if (r113 == null) goto L21;
                int r114 = Justify.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Align r116 = r100.cross_axis_align;
                if (r116 == null) goto L25;
                int r117 = Align.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Padding r119 = r100.side_padding;
                if (r119 == null) goto L30;
                r102 = Padding.ADAPTER.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ LinearLayoutProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LinearLayoutProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LinearLayoutProperty r101) throws IOException {
                Orientation r102 = r101.orientation;
                if (r102 == null) goto L5;
                Orientation.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Float r103 = r101.spacing;
                if (r103 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
            L8:
                Float r104 = r101.wrap_width;
                if (r104 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
            L11:
                Float r105 = r101.padding;
                if (r105 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
            L14:
                Justify r106 = r101.main_axis_justify;
                if (r106 == null) goto L17;
                Justify.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Align r107 = r101.cross_axis_align;
                if (r107 == null) goto L20;
                Align.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Padding r108 = r101.side_padding;
                if (r108 == null) goto L23;
                Padding.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinearLayoutProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LinearLayoutProperty();
            DEFAULT_ORIENTATION = Orientation.ROW;
            Float r100 = Float.valueOf(0.0f);
            DEFAULT_SPACING = r100;
            DEFAULT_WRAP_WIDTH = r100;
            DEFAULT_PADDING = r100;
            DEFAULT_MAIN_AXIS_JUSTIFY = Justify.START;
            DEFAULT_CROSS_AXIS_ALIGN = Align.TOP;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.orientation = this.orientation;
            r100.spacing = this.spacing;
            r100.wrap_width = this.wrap_width;
            r100.padding = this.padding;
            r100.main_axis_justify = this.main_axis_justify;
            r100.cross_axis_align = this.cross_axis_align;
            r100.side_padding = this.side_padding;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LinearLayoutProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LinearLayoutProperty(Orientation r110, Float r111, Float r112, Float r113, Justify r114, Align r115, Padding r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public LinearLayoutProperty(Orientation r100, Float r101, Float r102, Float r103, Justify r104, Align r105, Padding r106, ByteString r107) {
            super(ADAPTER, r107);
            this.orientation = r100;
            this.spacing = r101;
            this.wrap_width = r102;
            this.padding = r103;
            this.main_axis_justify = r104;
            this.cross_axis_align = r105;
            this.side_padding = r106;
        }
    }

    public static final class LoadingProperty extends com.squareup.wire.Message<LoadingProperty, Builder> {
        public static final ProtoAdapter<LoadingProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<LoadingProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public LoadingProperty build() {
                return new LoadingProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_LoadingProperty extends ProtoAdapter<LoadingProperty> {
            public ProtoAdapter_LoadingProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LoadingProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoadingProperty decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(LoadingProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LoadingProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LoadingProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LoadingProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LoadingProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LoadingProperty();
        }

        public LoadingProperty() {
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
            return LoadingProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LoadingProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final enum Orientation extends Enum<Orientation> implements WireEnum {
        private static final /* synthetic */ Orientation[] $VALUES = null;
        public static final ProtoAdapter<Orientation> ADAPTER = null;
        public static final Orientation COLUMN = null;
        public static final Orientation COLUMN_REVERSE = null;
        public static final Orientation ROW = null;
        public static final Orientation ROW_REVERSE = null;
        private final int value;

        static {
            Orientation r100 = new Orientation(FabItem.FabSheetItem.CellType.ROW, 0, 0);
            ROW = r100;
            Orientation r101 = new Orientation("COLUMN", 1, 1);
            COLUMN = r101;
            Orientation r102 = new Orientation("ROW_REVERSE", 2, 2);
            ROW_REVERSE = r102;
            Orientation r103 = new Orientation("COLUMN_REVERSE", 3, 3);
            COLUMN_REVERSE = r103;
            $VALUES = new Orientation[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Orientation.class);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Orientation fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return COLUMN_REVERSE;
        L14:
            return ROW_REVERSE;
        L16:
            return COLUMN;
        L18:
            return ROW;
        }

        public static Orientation valueOf(String r100) {
            return (Orientation) a.a(Orientation.class, r100);
        }

        private Orientation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class OversizedTextProperty extends com.squareup.wire.Message<OversizedTextProperty, Builder> {
        public static final ProtoAdapter<OversizedTextProperty> ADAPTER = null;
        public static final Integer DEFAULT_FONT_SIZE = null;
        public static final FontWeight DEFAULT_FONT_WEIGHT = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Integer font_size;
        public final FontWeight font_weight;
        public final Integer number_of_lines;
        public final String text;

        public static final class Builder extends com.squareup.wire.Message.Builder<OversizedTextProperty, Builder> {
            public Integer font_size;
            public FontWeight font_weight;
            public Integer number_of_lines;
            public String text;

            @Override // com.squareup.wire.Message.Builder
            public OversizedTextProperty build() {
                return new OversizedTextProperty(this.text, this.number_of_lines, this.font_size, this.font_weight, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder font_size(Integer r100) {
                this.font_size = r100;
                return this;
            }

            public Builder font_weight(FontWeight r100) {
                this.font_weight = r100;
                return this;
            }

            public Builder number_of_lines(Integer r100) {
                this.number_of_lines = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }
        }

        public static final enum FontWeight extends Enum<FontWeight> implements WireEnum {
            private static final /* synthetic */ FontWeight[] $VALUES = null;
            public static final ProtoAdapter<FontWeight> ADAPTER = null;
            public static final FontWeight REGULAR = null;
            public static final FontWeight SEMI_BOLD = null;
            private final int value;

            static {
                FontWeight r100 = new FontWeight("REGULAR", 0, 0);
                REGULAR = r100;
                FontWeight r101 = new FontWeight("SEMI_BOLD", 1, 1);
                SEMI_BOLD = r101;
                $VALUES = new FontWeight[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(FontWeight.class);
            }

            public static FontWeight[] values() {
                return (FontWeight[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FontWeight fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return SEMI_BOLD;
            L10:
                return REGULAR;
            }

            public static FontWeight valueOf(String r100) {
                return (FontWeight) a.a(FontWeight.class, r100);
            }

            private FontWeight(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_OversizedTextProperty extends ProtoAdapter<OversizedTextProperty> {
            public ProtoAdapter_OversizedTextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, OversizedTextProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OversizedTextProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.number_of_lines = 0;
                r101.font_size = 36;
                r101.font_weight = FontWeight.REGULAR;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.number_of_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.font_size = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.font_weight = FontWeight.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(OversizedTextProperty r100) {
                String r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.number_of_lines;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.font_size;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                FontWeight r110 = r100.font_weight;
                if (r110 == null) goto L18;
                r102 = FontWeight.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ OversizedTextProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OversizedTextProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OversizedTextProperty r101) throws IOException {
                String r102 = r101.text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.number_of_lines;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.font_size;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                FontWeight r105 = r101.font_weight;
                if (r105 == null) goto L14;
                FontWeight.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OversizedTextProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OversizedTextProperty();
            DEFAULT_NUMBER_OF_LINES = 0;
            DEFAULT_FONT_SIZE = 36;
            DEFAULT_FONT_WEIGHT = FontWeight.REGULAR;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.number_of_lines = this.number_of_lines;
            r100.font_size = this.font_size;
            r100.font_weight = this.font_weight;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OversizedTextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public OversizedTextProperty(String r100, Integer r101, Integer r102, FontWeight r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public OversizedTextProperty(String r100, Integer r101, Integer r102, FontWeight r103, ByteString r104) {
            super(ADAPTER, r104);
            this.text = r100;
            this.number_of_lines = r101;
            this.font_size = r102;
            this.font_weight = r103;
        }
    }

    public static final class Padding extends com.squareup.wire.Message<Padding, Builder> {
        public static final ProtoAdapter<Padding> ADAPTER = null;
        public static final Float DEFAULT_BOTTOM = null;
        public static final Float DEFAULT_LEFT = null;
        public static final Float DEFAULT_RIGHT = null;
        public static final Float DEFAULT_TOP = null;
        private static final long serialVersionUID = 0;
        public final Float bottom;
        public final Float left;
        public final Float right;
        public final Float top;

        public static final class Builder extends com.squareup.wire.Message.Builder<Padding, Builder> {
            public Float bottom;
            public Float left;
            public Float right;
            public Float top;

            @Override // com.squareup.wire.Message.Builder
            public Padding build() {
                return new Padding(this.top, this.right, this.bottom, this.left, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder bottom(Float r100) {
                this.bottom = r100;
                return this;
            }

            public Builder left(Float r100) {
                this.left = r100;
                return this;
            }

            public Builder right(Float r100) {
                this.right = r100;
                return this;
            }

            public Builder top(Float r100) {
                this.top = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Padding extends ProtoAdapter<Padding> {
            public ProtoAdapter_Padding() {
                super(FieldEncoding.LENGTH_DELIMITED, Padding.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Padding decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Float r102 = Float.valueOf(0.0f);
                r101.top = r102;
                r101.right = r102;
                r101.bottom = r102;
                r101.left = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.top = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.right = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.bottom = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.left = ProtoAdapter.FLOAT.decode(r100);
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
            public int encodedSize2(Padding r100) {
                Float r101 = r100.top;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
            L6:
                Float r104 = r100.right;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Float r107 = r100.bottom;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Float r110 = r100.left;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ Padding decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Padding r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Padding r101) throws IOException {
                Float r102 = r101.top;
                if (r102 == null) goto L5;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
            L5:
                Float r103 = r101.right;
                if (r103 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
            L8:
                Float r104 = r101.bottom;
                if (r104 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
            L11:
                Float r105 = r101.left;
                if (r105 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Padding r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Padding();
            Float r100 = Float.valueOf(0.0f);
            DEFAULT_TOP = r100;
            DEFAULT_RIGHT = r100;
            DEFAULT_BOTTOM = r100;
            DEFAULT_LEFT = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.top = this.top;
            r100.right = this.right;
            r100.bottom = this.bottom;
            r100.left = this.left;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Padding.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Padding(Float r100, Float r101, Float r102, Float r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Padding(Float r100, Float r101, Float r102, Float r103, ByteString r104) {
            super(ADAPTER, r104);
            this.top = r100;
            this.right = r101;
            this.bottom = r102;
            this.left = r103;
        }
    }

    public static final class PreviewHeaderProperty extends com.squareup.wire.Message<PreviewHeaderProperty, Builder> {
        public static final ProtoAdapter<PreviewHeaderProperty> ADAPTER = null;
        public static final String DEFAULT_CHILD_COMPONENT_ID = "";
        public static final String DEFAULT_FAVICON_URL = "";
        public static final String DEFAULT_HEADER_TAG = "";
        public static final Integer DEFAULT_ICON_SIZE = null;
        public static final Boolean DEFAULT_IS_NEED_CLOSE = null;
        public static final Boolean DEFAULT_IS_NEED_COPY_LINK = null;
        public static final Tag DEFAULT_LARK_TAG = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final Theme DEFAULT_THEME = null;
        public static final String DEFAULT_TITLE = "";
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String child_component_id;
        public final ImageSet dm_icon;
        public final String favicon_url;
        public final String header_tag;
        public final ThemeColor icon_color;
        public final ImageSet icon_key;
        public final Integer icon_size;
        public final Boolean is_need_close;
        public final Boolean is_need_copy_link;
        public final Tag lark_tag;
        public final Integer number_of_lines;
        public final ThemeColor tag_color;
        public final ThemeColor tag_text_color;
        public final Theme theme;
        public final String title;
        public final Type type;
        public final UDIcon ud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<PreviewHeaderProperty, Builder> {
            public String child_component_id;
            public ImageSet dm_icon;
            public String favicon_url;
            public String header_tag;
            public ThemeColor icon_color;
            public ImageSet icon_key;
            public Integer icon_size;
            public Boolean is_need_close;
            public Boolean is_need_copy_link;
            public Tag lark_tag;
            public Integer number_of_lines;
            public ThemeColor tag_color;
            public ThemeColor tag_text_color;
            public Theme theme;
            public String title;
            public Type type;
            public UDIcon ud_icon;

            @Override // com.squareup.wire.Message.Builder
            public PreviewHeaderProperty build() {
                return new PreviewHeaderProperty(this.icon_key, this.title, this.lark_tag, this.child_component_id, this.is_need_copy_link, this.is_need_close, this.theme, this.type, this.tag_color, this.tag_text_color, this.header_tag, this.favicon_url, this.icon_color, this.ud_icon, this.number_of_lines, this.icon_size, this.dm_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder child_component_id(String r100) {
                this.child_component_id = r100;
                return this;
            }

            public Builder dm_icon(ImageSet r100) {
                this.dm_icon = r100;
                return this;
            }

            public Builder favicon_url(String r100) {
                this.favicon_url = r100;
                return this;
            }

            public Builder header_tag(String r100) {
                this.header_tag = r100;
                return this;
            }

            public Builder icon_color(ThemeColor r100) {
                this.icon_color = r100;
                return this;
            }

            public Builder icon_key(ImageSet r100) {
                this.icon_key = r100;
                return this;
            }

            public Builder icon_size(Integer r100) {
                this.icon_size = r100;
                return this;
            }

            public Builder is_need_close(Boolean r100) {
                this.is_need_close = r100;
                return this;
            }

            public Builder is_need_copy_link(Boolean r100) {
                this.is_need_copy_link = r100;
                return this;
            }

            public Builder lark_tag(Tag r100) {
                this.lark_tag = r100;
                return this;
            }

            public Builder number_of_lines(Integer r100) {
                this.number_of_lines = r100;
                return this;
            }

            public Builder tag_color(ThemeColor r100) {
                this.tag_color = r100;
                return this;
            }

            public Builder tag_text_color(ThemeColor r100) {
                this.tag_text_color = r100;
                return this;
            }

            public Builder theme(Theme r100) {
                this.theme = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }

            public Builder ud_icon(UDIcon r100) {
                this.ud_icon = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PreviewHeaderProperty extends ProtoAdapter<PreviewHeaderProperty> {
            public ProtoAdapter_PreviewHeaderProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, PreviewHeaderProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PreviewHeaderProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.lark_tag = Tag.UNKNOWN_TAG;
                r101.child_component_id = "";
                Boolean r102 = Boolean.TRUE;
                r101.is_need_copy_link = r102;
                r101.is_need_close = r102;
                r101.theme = Theme.LIGHT;
                r101.type = Type.NORMAL;
                r101.header_tag = "";
                r101.favicon_url = "";
                r101.number_of_lines = 3;
                r101.icon_size = 0;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L33;
                switch(r104) {
                    case 1: goto L32;
                    case 2: goto L31;
                    case 3: goto L39;
                    case 4: goto L26;
                    case 5: goto L25;
                    case 6: goto L24;
                    case 7: goto L37;
                    case 8: goto L35;
                    case 9: goto L15;
                    case 10: goto L14;
                    case 11: goto L13;
                    case 12: goto L12;
                    case 13: goto L11;
                    case 14: goto L10;
                    case 15: goto L9;
                    case 16: goto L8;
                    case 17: goto L7;
                    default: goto L6;
                };
            L35:
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L37:
                r101.theme = Theme.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L39:
                r101.lark_tag = Tag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.dm_icon = ImageSet.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.icon_size = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                r101.number_of_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.icon_color = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.favicon_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.header_tag = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.tag_text_color = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L15:
                r101.tag_color = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L24:
                r101.is_need_close = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L25:
                r101.is_need_copy_link = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L26:
                r101.child_component_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L31:
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L32:
                r101.icon_key = ImageSet.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L33:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PreviewHeaderProperty r100) {
                ImageSet r101 = r100.icon_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.title;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Tag r107 = r100.lark_tag;
                if (r107 == null) goto L13;
                int r108 = Tag.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.child_component_id;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.is_need_copy_link;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_need_close;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Theme r119 = r100.theme;
                if (r119 == null) goto L29;
                int r120 = Theme.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Type r122 = r100.type;
                if (r122 == null) goto L33;
                int r123 = Type.ADAPTER.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                ThemeColor r125 = r100.tag_color;
                if (r125 == null) goto L37;
                int r126 = ThemeColor.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                ThemeColor r128 = r100.tag_text_color;
                if (r128 == null) goto L41;
                int r129 = ThemeColor.ADAPTER.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                String r131 = r100.header_tag;
                if (r131 == null) goto L45;
                int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                String r134 = r100.favicon_url;
                if (r134 == null) goto L49;
                int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
            L50:
                int r136 = r133 + r135;
                ThemeColor r137 = r100.icon_color;
                if (r137 == null) goto L53;
                int r138 = ThemeColor.ADAPTER.encodedSizeWithTag(13, r137);
            L54:
                int r139 = r136 + r138;
                UDIcon r140 = r100.ud_icon;
                if (r140 == null) goto L57;
                int r141 = UDIcon.ADAPTER.encodedSizeWithTag(14, r140);
            L58:
                int r142 = r139 + r141;
                Integer r143 = r100.number_of_lines;
                if (r143 == null) goto L61;
                int r144 = ProtoAdapter.INT32.encodedSizeWithTag(15, r143);
            L62:
                int r145 = r142 + r144;
                Integer r146 = r100.icon_size;
                if (r146 == null) goto L65;
                int r147 = ProtoAdapter.INT32.encodedSizeWithTag(16, r146);
            L66:
                int r148 = r145 + r147;
                ImageSet r149 = r100.dm_icon;
                if (r149 == null) goto L70;
                r102 = ImageSet.ADAPTER.encodedSizeWithTag(17, r149);
            L70:
                return (r148 + r102) + r100.unknownFields().size();
            L65:
                r147 = 0;
                goto L66
            L61:
                r144 = 0;
                goto L62
            L57:
                r141 = 0;
                goto L58
            L53:
                r138 = 0;
                goto L54
            L49:
                r135 = 0;
                goto L50
            L45:
                r132 = 0;
                goto L46
            L41:
                r129 = 0;
                goto L42
            L37:
                r126 = 0;
                goto L38
            L33:
                r123 = 0;
                goto L34
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
            public /* bridge */ /* synthetic */ PreviewHeaderProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PreviewHeaderProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PreviewHeaderProperty r101) throws IOException {
                ImageSet r102 = r101.icon_key;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.title;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Tag r104 = r101.lark_tag;
                if (r104 == null) goto L11;
                Tag.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.child_component_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.is_need_copy_link;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_need_close;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Theme r108 = r101.theme;
                if (r108 == null) goto L23;
                Theme.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                Type r109 = r101.type;
                if (r109 == null) goto L26;
                Type.ADAPTER.encodeWithTag(r100, 8, r109);
            L26:
                ThemeColor r110 = r101.tag_color;
                if (r110 == null) goto L29;
                ThemeColor.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                ThemeColor r111 = r101.tag_text_color;
                if (r111 == null) goto L32;
                ThemeColor.ADAPTER.encodeWithTag(r100, 10, r111);
            L32:
                String r112 = r101.header_tag;
                if (r112 == null) goto L35;
                ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
            L35:
                String r113 = r101.favicon_url;
                if (r113 == null) goto L38;
                ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
            L38:
                ThemeColor r114 = r101.icon_color;
                if (r114 == null) goto L41;
                ThemeColor.ADAPTER.encodeWithTag(r100, 13, r114);
            L41:
                UDIcon r115 = r101.ud_icon;
                if (r115 == null) goto L44;
                UDIcon.ADAPTER.encodeWithTag(r100, 14, r115);
            L44:
                Integer r116 = r101.number_of_lines;
                if (r116 == null) goto L47;
                ProtoAdapter.INT32.encodeWithTag(r100, 15, r116);
            L47:
                Integer r117 = r101.icon_size;
                if (r117 == null) goto L50;
                ProtoAdapter.INT32.encodeWithTag(r100, 16, r117);
            L50:
                ImageSet r118 = r101.dm_icon;
                if (r118 == null) goto L53;
                ImageSet.ADAPTER.encodeWithTag(r100, 17, r118);
            L53:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewHeaderProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type HEADLINES = null;
            public static final Type NORMAL = null;
            private final int value;

            static {
                Type r100 = new Type(EffectConstants.NORMAL, 0, 0);
                NORMAL = r100;
                Type r101 = new Type("HEADLINES", 1, 1);
                HEADLINES = r101;
                $VALUES = new Type[]{r100, r101};
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
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return HEADLINES;
            L10:
                return NORMAL;
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
            ADAPTER = new ProtoAdapter_PreviewHeaderProperty();
            DEFAULT_LARK_TAG = Tag.UNKNOWN_TAG;
            Boolean r100 = Boolean.TRUE;
            DEFAULT_IS_NEED_COPY_LINK = r100;
            DEFAULT_IS_NEED_CLOSE = r100;
            DEFAULT_THEME = Theme.LIGHT;
            DEFAULT_TYPE = Type.NORMAL;
            DEFAULT_NUMBER_OF_LINES = 3;
            DEFAULT_ICON_SIZE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon_key = this.icon_key;
            r100.title = this.title;
            r100.lark_tag = this.lark_tag;
            r100.child_component_id = this.child_component_id;
            r100.is_need_copy_link = this.is_need_copy_link;
            r100.is_need_close = this.is_need_close;
            r100.theme = this.theme;
            r100.type = this.type;
            r100.tag_color = this.tag_color;
            r100.tag_text_color = this.tag_text_color;
            r100.header_tag = this.header_tag;
            r100.favicon_url = this.favicon_url;
            r100.icon_color = this.icon_color;
            r100.ud_icon = this.ud_icon;
            r100.number_of_lines = this.number_of_lines;
            r100.icon_size = this.icon_size;
            r100.dm_icon = this.dm_icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PreviewHeaderProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PreviewHeaderProperty(ImageSet r210, String r211, Tag r212, String r213, Boolean r214, Boolean r215, Theme r216, Type r217, ThemeColor r218, ThemeColor r219, String r310, String r311, ThemeColor r312, UDIcon r313, Integer r314, Integer r315, ImageSet r316) {
            this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, ByteString.EMPTY);
        }

        public PreviewHeaderProperty(ImageSet r100, String r101, Tag r102, String r103, Boolean r104, Boolean r105, Theme r110, Type r111, ThemeColor r112, ThemeColor r113, String r114, String r115, ThemeColor r116, UDIcon r117, Integer r118, Integer r119, ImageSet r210, ByteString r211) {
            super(ADAPTER, r211);
            this.icon_key = r100;
            this.title = r101;
            this.lark_tag = r102;
            this.child_component_id = r103;
            this.is_need_copy_link = r104;
            this.is_need_close = r105;
            this.theme = r110;
            this.type = r111;
            this.tag_color = r112;
            this.tag_text_color = r113;
            this.header_tag = r114;
            this.favicon_url = r115;
            this.icon_color = r116;
            this.ud_icon = r117;
            this.number_of_lines = r118;
            this.icon_size = r119;
            this.dm_icon = r210;
        }
    }

    public static final class ProtoAdapter_URLPreviewComponent extends ProtoAdapter<URLPreviewComponent> {
        public ProtoAdapter_URLPreviewComponent() {
            super(FieldEncoding.LENGTH_DELIMITED, URLPreviewComponent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public URLPreviewComponent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.EMPTY;
            Boolean r102 = Boolean.TRUE;
            r101.can_skip_when_unknown = r102;
            r101.is_font_zoomable = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L50;
            if (r104 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
        L48:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.can_skip_when_unknown = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.style = Style.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.child_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.is_font_zoomable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            switch(r104) {
                case 1000: goto L41;
                case 1001: goto L40;
                case 1002: goto L39;
                default: goto L16;
            };
        L39:
            r101.flex_layout(FlexLayoutProperty.ADAPTER.decode(r100));
            goto L3
        L40:
            r101.linear_layout(LinearLayoutProperty.ADAPTER.decode(r100));
            goto L3
        L41:
            r101.empty(EmptyProperty.ADAPTER.decode(r100));
            goto L3
        L16:
            switch(r104) {
                case 1501: goto L38;
                case 1502: goto L37;
                case 1503: goto L36;
                case 1504: goto L35;
                case 1505: goto L34;
                case 1506: goto L33;
                case 1507: goto L32;
                case 1508: goto L31;
                case 1509: goto L30;
                case 1510: goto L29;
                case 1511: goto L28;
                case 1512: goto L27;
                case 1513: goto L26;
                case 1514: goto L25;
                case 1515: goto L24;
                case 1516: goto L23;
                case 1517: goto L22;
                case 1518: goto L21;
                case 1519: goto L20;
                case 1520: goto L19;
                case 1521: goto L18;
                default: goto L17;
            };
        L18:
            r101.image_container(ImageContainerProperty.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.doc_state_button(DocStateButtonProperty.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.engine(EngineProperty.ADAPTER.decode(r100));
            goto L3
        L21:
            r101.oversized_text(OversizedTextProperty.ADAPTER.decode(r100));
            goto L3
        L22:
            r101.time_zone(TimeZoneProperty.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.loading(LoadingProperty.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.doc_image(DocImageProperty.ADAPTER.decode(r100));
            goto L3
        L25:
            r101.card_container(CardContainerProperty.ADAPTER.decode(r100));
            goto L3
        L26:
            r101.video(VideoProperty.ADAPTER.decode(r100));
            goto L3
        L27:
            r101.avatar(AvatarProperty.ADAPTER.decode(r100));
            goto L3
        L28:
            r101.spin_button(SpinButtonProperty.ADAPTER.decode(r100));
            goto L3
        L29:
            r101.tag_list(TagListProperty.ADAPTER.decode(r100));
            goto L3
        L30:
            r101.text(TextProperty.ADAPTER.decode(r100));
            goto L3
        L31:
            r101.time(TimeProperty.ADAPTER.decode(r100));
            goto L3
        L32:
            r101.text_button(TextButtonProperty.ADAPTER.decode(r100));
            goto L3
        L33:
            r101.icon_button(IconButtonProperty.ADAPTER.decode(r100));
            goto L3
        L34:
            r101.button(ButtonProperty.ADAPTER.decode(r100));
            goto L3
        L35:
            r101.chatters_preview(ChattersPreviewProperty.ADAPTER.decode(r100));
            goto L3
        L36:
            r101.image(ImageProperty.ADAPTER.decode(r100));
            goto L3
        L37:
            r101.richtext(RichTextProperty.ADAPTER.decode(r100));
            goto L3
        L38:
            r101.header(PreviewHeaderProperty.ADAPTER.decode(r100));
            goto L3
        L17:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L50:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(URLPreviewComponent r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
            Boolean r102 = r100.can_skip_when_unknown;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Style r106 = r100.style;
            if (r106 == null) goto L9;
            int r107 = Style.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = (r105 + r107) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(4, r100.child_ids);
            Boolean r109 = r100.is_font_zoomable;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            EmptyProperty r112 = r100.empty;
            if (r112 == null) goto L17;
            int r113 = EmptyProperty.ADAPTER.encodedSizeWithTag(1000, r112);
        L18:
            int r114 = r111 + r113;
            LinearLayoutProperty r115 = r100.linear_layout;
            if (r115 == null) goto L21;
            int r116 = LinearLayoutProperty.ADAPTER.encodedSizeWithTag(1001, r115);
        L22:
            int r117 = r114 + r116;
            FlexLayoutProperty r118 = r100.flex_layout;
            if (r118 == null) goto L25;
            int r119 = FlexLayoutProperty.ADAPTER.encodedSizeWithTag(1002, r118);
        L26:
            int r120 = r117 + r119;
            PreviewHeaderProperty r121 = r100.header;
            if (r121 == null) goto L29;
            int r122 = PreviewHeaderProperty.ADAPTER.encodedSizeWithTag(1501, r121);
        L30:
            int r123 = r120 + r122;
            RichTextProperty r124 = r100.richtext;
            if (r124 == null) goto L33;
            int r125 = RichTextProperty.ADAPTER.encodedSizeWithTag(1502, r124);
        L34:
            int r126 = r123 + r125;
            ImageProperty r127 = r100.image;
            if (r127 == null) goto L37;
            int r128 = ImageProperty.ADAPTER.encodedSizeWithTag(1503, r127);
        L38:
            int r129 = r126 + r128;
            ChattersPreviewProperty r130 = r100.chatters_preview;
            if (r130 == null) goto L41;
            int r131 = ChattersPreviewProperty.ADAPTER.encodedSizeWithTag(1504, r130);
        L42:
            int r132 = r129 + r131;
            ButtonProperty r133 = r100.button;
            if (r133 == null) goto L45;
            int r134 = ButtonProperty.ADAPTER.encodedSizeWithTag(1505, r133);
        L46:
            int r135 = r132 + r134;
            IconButtonProperty r136 = r100.icon_button;
            if (r136 == null) goto L49;
            int r137 = IconButtonProperty.ADAPTER.encodedSizeWithTag(1506, r136);
        L50:
            int r138 = r135 + r137;
            TextButtonProperty r139 = r100.text_button;
            if (r139 == null) goto L53;
            int r140 = TextButtonProperty.ADAPTER.encodedSizeWithTag(1507, r139);
        L54:
            int r141 = r138 + r140;
            TimeProperty r142 = r100.time;
            if (r142 == null) goto L57;
            int r143 = TimeProperty.ADAPTER.encodedSizeWithTag(1508, r142);
        L58:
            int r144 = r141 + r143;
            TextProperty r145 = r100.text;
            if (r145 == null) goto L61;
            int r146 = TextProperty.ADAPTER.encodedSizeWithTag(1509, r145);
        L62:
            int r147 = r144 + r146;
            TagListProperty r148 = r100.tag_list;
            if (r148 == null) goto L65;
            int r149 = TagListProperty.ADAPTER.encodedSizeWithTag(1510, r148);
        L66:
            int r150 = r147 + r149;
            SpinButtonProperty r151 = r100.spin_button;
            if (r151 == null) goto L69;
            int r152 = SpinButtonProperty.ADAPTER.encodedSizeWithTag(1511, r151);
        L70:
            int r153 = r150 + r152;
            AvatarProperty r154 = r100.avatar;
            if (r154 == null) goto L73;
            int r155 = AvatarProperty.ADAPTER.encodedSizeWithTag(1512, r154);
        L74:
            int r156 = r153 + r155;
            VideoProperty r157 = r100.video;
            if (r157 == null) goto L77;
            int r158 = VideoProperty.ADAPTER.encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_CHECK_URL, r157);
        L78:
            int r159 = r156 + r158;
            CardContainerProperty r160 = r100.card_container;
            if (r160 == null) goto L81;
            int r161 = CardContainerProperty.ADAPTER.encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_COOKIE_TOKEN_CHECK_LEVEL, r160);
        L82:
            int r162 = r159 + r161;
            DocImageProperty r163 = r100.doc_image;
            if (r163 == null) goto L85;
            int r164 = DocImageProperty.ADAPTER.encodedSizeWithTag(1515, r163);
        L86:
            int r165 = r162 + r164;
            LoadingProperty r166 = r100.loading;
            if (r166 == null) goto L89;
            int r167 = LoadingProperty.ADAPTER.encodedSizeWithTag(1516, r166);
        L90:
            int r168 = r165 + r167;
            TimeZoneProperty r169 = r100.time_zone;
            if (r169 == null) goto L93;
            int r170 = TimeZoneProperty.ADAPTER.encodedSizeWithTag(1517, r169);
        L94:
            int r171 = r168 + r170;
            OversizedTextProperty r172 = r100.oversized_text;
            if (r172 == null) goto L97;
            int r173 = OversizedTextProperty.ADAPTER.encodedSizeWithTag(1518, r172);
        L98:
            int r174 = r171 + r173;
            EngineProperty r175 = r100.engine;
            if (r175 == null) goto L101;
            int r176 = EngineProperty.ADAPTER.encodedSizeWithTag(1519, r175);
        L102:
            int r177 = r174 + r176;
            DocStateButtonProperty r178 = r100.doc_state_button;
            if (r178 == null) goto L105;
            int r179 = DocStateButtonProperty.ADAPTER.encodedSizeWithTag(1520, r178);
        L106:
            int r180 = r177 + r179;
            ImageContainerProperty r181 = r100.image_container;
            if (r181 == null) goto L110;
            r103 = ImageContainerProperty.ADAPTER.encodedSizeWithTag(1521, r181);
        L110:
            return (r180 + r103) + r100.unknownFields().size();
        L105:
            r179 = 0;
            goto L106
        L101:
            r176 = 0;
            goto L102
        L97:
            r173 = 0;
            goto L98
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
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ URLPreviewComponent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(URLPreviewComponent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, URLPreviewComponent r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            Boolean r102 = r101.can_skip_when_unknown;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Style r103 = r101.style;
            if (r103 == null) goto L8;
            Style.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 4, r101.child_ids);
            Boolean r104 = r101.is_font_zoomable;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L11:
            EmptyProperty r105 = r101.empty;
            if (r105 == null) goto L14;
            EmptyProperty.ADAPTER.encodeWithTag(r100, 1000, r105);
        L14:
            LinearLayoutProperty r106 = r101.linear_layout;
            if (r106 == null) goto L17;
            LinearLayoutProperty.ADAPTER.encodeWithTag(r100, 1001, r106);
        L17:
            FlexLayoutProperty r107 = r101.flex_layout;
            if (r107 == null) goto L20;
            FlexLayoutProperty.ADAPTER.encodeWithTag(r100, 1002, r107);
        L20:
            PreviewHeaderProperty r108 = r101.header;
            if (r108 == null) goto L23;
            PreviewHeaderProperty.ADAPTER.encodeWithTag(r100, 1501, r108);
        L23:
            RichTextProperty r109 = r101.richtext;
            if (r109 == null) goto L26;
            RichTextProperty.ADAPTER.encodeWithTag(r100, 1502, r109);
        L26:
            ImageProperty r110 = r101.image;
            if (r110 == null) goto L29;
            ImageProperty.ADAPTER.encodeWithTag(r100, 1503, r110);
        L29:
            ChattersPreviewProperty r111 = r101.chatters_preview;
            if (r111 == null) goto L32;
            ChattersPreviewProperty.ADAPTER.encodeWithTag(r100, 1504, r111);
        L32:
            ButtonProperty r112 = r101.button;
            if (r112 == null) goto L35;
            ButtonProperty.ADAPTER.encodeWithTag(r100, 1505, r112);
        L35:
            IconButtonProperty r113 = r101.icon_button;
            if (r113 == null) goto L38;
            IconButtonProperty.ADAPTER.encodeWithTag(r100, 1506, r113);
        L38:
            TextButtonProperty r114 = r101.text_button;
            if (r114 == null) goto L41;
            TextButtonProperty.ADAPTER.encodeWithTag(r100, 1507, r114);
        L41:
            TimeProperty r115 = r101.time;
            if (r115 == null) goto L44;
            TimeProperty.ADAPTER.encodeWithTag(r100, 1508, r115);
        L44:
            TextProperty r116 = r101.text;
            if (r116 == null) goto L47;
            TextProperty.ADAPTER.encodeWithTag(r100, 1509, r116);
        L47:
            TagListProperty r117 = r101.tag_list;
            if (r117 == null) goto L50;
            TagListProperty.ADAPTER.encodeWithTag(r100, 1510, r117);
        L50:
            SpinButtonProperty r118 = r101.spin_button;
            if (r118 == null) goto L53;
            SpinButtonProperty.ADAPTER.encodeWithTag(r100, 1511, r118);
        L53:
            AvatarProperty r119 = r101.avatar;
            if (r119 == null) goto L56;
            AvatarProperty.ADAPTER.encodeWithTag(r100, 1512, r119);
        L56:
            VideoProperty r120 = r101.video;
            if (r120 == null) goto L59;
            VideoProperty.ADAPTER.encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_CHECK_URL, r120);
        L59:
            CardContainerProperty r121 = r101.card_container;
            if (r121 == null) goto L62;
            CardContainerProperty.ADAPTER.encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_COOKIE_TOKEN_CHECK_LEVEL, r121);
        L62:
            DocImageProperty r122 = r101.doc_image;
            if (r122 == null) goto L65;
            DocImageProperty.ADAPTER.encodeWithTag(r100, 1515, r122);
        L65:
            LoadingProperty r123 = r101.loading;
            if (r123 == null) goto L68;
            LoadingProperty.ADAPTER.encodeWithTag(r100, 1516, r123);
        L68:
            TimeZoneProperty r124 = r101.time_zone;
            if (r124 == null) goto L71;
            TimeZoneProperty.ADAPTER.encodeWithTag(r100, 1517, r124);
        L71:
            OversizedTextProperty r125 = r101.oversized_text;
            if (r125 == null) goto L74;
            OversizedTextProperty.ADAPTER.encodeWithTag(r100, 1518, r125);
        L74:
            EngineProperty r126 = r101.engine;
            if (r126 == null) goto L77;
            EngineProperty.ADAPTER.encodeWithTag(r100, 1519, r126);
        L77:
            DocStateButtonProperty r127 = r101.doc_state_button;
            if (r127 == null) goto L80;
            DocStateButtonProperty.ADAPTER.encodeWithTag(r100, 1520, r127);
        L80:
            ImageContainerProperty r128 = r101.image_container;
            if (r128 == null) goto L83;
            ImageContainerProperty.ADAPTER.encodeWithTag(r100, 1521, r128);
        L83:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLPreviewComponent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RichTextProperty extends com.squareup.wire.Message<RichTextProperty, Builder> {
        public static final ProtoAdapter<RichTextProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final Boolean DEFAULT_SHOW_UPDATE_TIME = null;
        public static final RichTextTheme DEFAULT_THEME = null;
        private static final long serialVersionUID = 0;
        public final List<String> at_out_chatter_ids;
        public final Integer number_of_lines;
        public final RichText richtext;
        public final Boolean show_update_time;
        public final RichTextTheme theme;

        public static final class Builder extends com.squareup.wire.Message.Builder<RichTextProperty, Builder> {
            public List<String> at_out_chatter_ids;
            public Integer number_of_lines;
            public RichText richtext;
            public Boolean show_update_time;
            public RichTextTheme theme;

            @Override // com.squareup.wire.Message.Builder
            public RichTextProperty build() {
                return new RichTextProperty(this.richtext, this.number_of_lines, this.at_out_chatter_ids, this.show_update_time, this.theme, super.buildUnknownFields());
            }

            public Builder() {
                this.at_out_chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder at_out_chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.at_out_chatter_ids = r100;
                return this;
            }

            public Builder number_of_lines(Integer r100) {
                this.number_of_lines = r100;
                return this;
            }

            public Builder richtext(RichText r100) {
                this.richtext = r100;
                return this;
            }

            public Builder show_update_time(Boolean r100) {
                this.show_update_time = r100;
                return this;
            }

            public Builder theme(RichTextTheme r100) {
                this.theme = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RichTextProperty extends ProtoAdapter<RichTextProperty> {
            public ProtoAdapter_RichTextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, RichTextProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RichTextProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.number_of_lines = 0;
                r101.show_update_time = Boolean.FALSE;
                r101.theme = RichTextTheme.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.richtext = RichText.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.number_of_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.at_out_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.show_update_time = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.theme = RichTextTheme.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(RichTextProperty r100) {
                RichText r101 = r100.richtext;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.number_of_lines;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = (r103 + r105) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.at_out_chatter_ids);
                Boolean r107 = r100.show_update_time;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
            L14:
                int r109 = r106 + r108;
                RichTextTheme r110 = r100.theme;
                if (r110 == null) goto L18;
                r102 = RichTextTheme.ADAPTER.encodedSizeWithTag(5, r110);
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
            public /* bridge */ /* synthetic */ RichTextProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RichTextProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RichTextProperty r101) throws IOException {
                RichText r102 = r101.richtext;
                if (r102 == null) goto L5;
                RichText.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.number_of_lines;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.at_out_chatter_ids);
                Boolean r104 = r101.show_update_time;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L11:
                RichTextTheme r105 = r101.theme;
                if (r105 == null) goto L14;
                RichTextTheme.ADAPTER.encodeWithTag(r100, 5, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichTextProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum RichTextTheme extends Enum<RichTextTheme> implements WireEnum {
            private static final /* synthetic */ RichTextTheme[] $VALUES = null;
            public static final ProtoAdapter<RichTextTheme> ADAPTER = null;
            public static final RichTextTheme DARK = null;
            public static final RichTextTheme DEFAULT = null;
            public static final RichTextTheme LIGHT = null;
            private final int value;

            static {
                RichTextTheme r100 = new RichTextTheme("DEFAULT", 0, 0);
                DEFAULT = r100;
                RichTextTheme r101 = new RichTextTheme("DARK", 1, 1);
                DARK = r101;
                RichTextTheme r102 = new RichTextTheme("LIGHT", 2, 2);
                LIGHT = r102;
                $VALUES = new RichTextTheme[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(RichTextTheme.class);
            }

            public static RichTextTheme[] values() {
                return (RichTextTheme[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static RichTextTheme fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return LIGHT;
            L12:
                return DARK;
            L14:
                return DEFAULT;
            }

            public static RichTextTheme valueOf(String r100) {
                return (RichTextTheme) a.a(RichTextTheme.class, r100);
            }

            private RichTextTheme(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RichTextProperty();
            DEFAULT_NUMBER_OF_LINES = 0;
            DEFAULT_SHOW_UPDATE_TIME = Boolean.FALSE;
            DEFAULT_THEME = RichTextTheme.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.richtext = this.richtext;
            r100.number_of_lines = this.number_of_lines;
            r100.at_out_chatter_ids = Internal.copyOf("at_out_chatter_ids", this.at_out_chatter_ids);
            r100.show_update_time = this.show_update_time;
            r100.theme = this.theme;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RichTextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public RichTextProperty(RichText r100, Integer r101, List<String> r110, Boolean r111, RichTextTheme r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public RichTextProperty(RichText r100, Integer r101, List<String> r102, Boolean r103, RichTextTheme r104, ByteString r105) {
            super(ADAPTER, r105);
            this.richtext = r100;
            this.number_of_lines = r101;
            this.at_out_chatter_ids = Internal.immutableCopyOf("at_out_chatter_ids", r102);
            this.show_update_time = r103;
            this.theme = r104;
        }
    }

    public static final enum SizeLevel extends Enum<SizeLevel> implements WireEnum {
        private static final /* synthetic */ SizeLevel[] $VALUES = null;
        public static final ProtoAdapter<SizeLevel> ADAPTER = null;
        public static final SizeLevel LARGE = null;
        public static final SizeLevel NORMAL = null;
        public static final SizeLevel SMALL = null;
        private final int value;

        static {
            SizeLevel r100 = new SizeLevel(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            SizeLevel r101 = new SizeLevel("SMALL", 1, 1);
            SMALL = r101;
            SizeLevel r102 = new SizeLevel("LARGE", 2, 2);
            LARGE = r102;
            $VALUES = new SizeLevel[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SizeLevel.class);
        }

        public static SizeLevel[] values() {
            return (SizeLevel[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SizeLevel fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return LARGE;
        L12:
            return SMALL;
        L14:
            return NORMAL;
        }

        public static SizeLevel valueOf(String r100) {
            return (SizeLevel) a.a(SizeLevel.class, r100);
        }

        private SizeLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class SpinButtonProperty extends com.squareup.wire.Message<SpinButtonProperty, Builder> {
        public static final ProtoAdapter<SpinButtonProperty> ADAPTER = null;
        public static final Direction DEFAULT_DIRECTION = null;
        public static final Long DEFAULT_SELECTED_INDEX = null;
        private static final long serialVersionUID = 0;
        public final Direction direction;
        public final ImageSet icon;
        public final List<Item> items;
        public final Long selected_index;

        public static final class Builder extends com.squareup.wire.Message.Builder<SpinButtonProperty, Builder> {
            public Direction direction;
            public ImageSet icon;
            public List<Item> items;
            public Long selected_index;

            @Override // com.squareup.wire.Message.Builder
            public SpinButtonProperty build() {
                return new SpinButtonProperty(this.icon, this.items, this.selected_index, this.direction, super.buildUnknownFields());
            }

            public Builder() {
                this.items = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder direction(Direction r100) {
                this.direction = r100;
                return this;
            }

            public Builder icon(ImageSet r100) {
                this.icon = r100;
                return this;
            }

            public Builder items(List<Item> r100) {
                Internal.checkElementsNotNull(r100);
                this.items = r100;
                return this;
            }

            public Builder selected_index(Long r100) {
                this.selected_index = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SpinButtonProperty extends ProtoAdapter<SpinButtonProperty> {
            public ProtoAdapter_SpinButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, SpinButtonProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpinButtonProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.selected_index = 0L;
                r101.direction = Direction.LTR;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.icon = ImageSet.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.items.add(Item.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.selected_index = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.direction = Direction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(SpinButtonProperty r100) {
                ImageSet r101 = r100.icon;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + Item.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.items);
                Long r105 = r100.selected_index;
                if (r105 == null) goto L9;
                int r106 = ProtoAdapter.INT64.encodedSizeWithTag(3, r105);
            L10:
                int r107 = r104 + r106;
                Direction r108 = r100.direction;
                if (r108 == null) goto L14;
                r102 = Direction.ADAPTER.encodedSizeWithTag(4, r108);
            L14:
                return (r107 + r102) + r100.unknownFields().size();
            L9:
                r106 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SpinButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SpinButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SpinButtonProperty r101) throws IOException {
                ImageSet r102 = r101.icon;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Item.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.items);
                Long r103 = r101.selected_index;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
            L8:
                Direction r104 = r101.direction;
                if (r104 == null) goto L11;
                Direction.ADAPTER.encodeWithTag(r100, 4, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpinButtonProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpinButtonProperty();
            DEFAULT_SELECTED_INDEX = 0L;
            DEFAULT_DIRECTION = Direction.LTR;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon = this.icon;
            r100.items = Internal.copyOf("items", this.items);
            r100.selected_index = this.selected_index;
            r100.direction = this.direction;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SpinButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SpinButtonProperty(ImageSet r100, List<Item> r101, Long r102, Direction r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public SpinButtonProperty(ImageSet r100, List<Item> r101, Long r102, Direction r103, ByteString r104) {
            super(ADAPTER, r104);
            this.icon = r100;
            this.items = Internal.immutableCopyOf("items", r101);
            this.selected_index = r102;
            this.direction = r103;
        }
    }

    public static final class Style extends com.squareup.wire.Message<Style, Builder> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final Align DEFAULT_ALIGN_SELF = null;
        public static final Integer DEFAULT_ASPECT_RATIO = null;
        public static final Integer DEFAULT_GROW_WEIGHT = null;
        public static final Integer DEFAULT_SHRINK_WEIGHT = null;
        public static final SizeLevel DEFAULT_SIZE_LEVEL = null;
        private static final long serialVersionUID = 0;
        public final Align align_self;
        public final Integer aspect_ratio;
        public final Gradient background_color;
        public final Border border;
        public final FontLevel font_level;
        public final Integer grow_weight;
        public final Value height;
        public final Value max_height;
        public final Value max_width;
        public final Value min_height;
        public final Value min_width;
        public final Integer shrink_weight;
        public final SizeLevel size_level;
        public final ThemeColor text_color_v2;
        public final Value width;

        public static final class Builder extends com.squareup.wire.Message.Builder<Style, Builder> {
            public Align align_self;
            public Integer aspect_ratio;
            public Gradient background_color;
            public Border border;
            public FontLevel font_level;
            public Integer grow_weight;
            public Value height;
            public Value max_height;
            public Value max_width;
            public Value min_height;
            public Value min_width;
            public Integer shrink_weight;
            public SizeLevel size_level;
            public ThemeColor text_color_v2;
            public Value width;

            @Override // com.squareup.wire.Message.Builder
            public Style build() {
                return new Style(this.size_level, this.text_color_v2, this.background_color, this.width, this.height, this.max_width, this.max_height, this.min_width, this.min_height, this.grow_weight, this.shrink_weight, this.font_level, this.border, this.aspect_ratio, this.align_self, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder align_self(Align r100) {
                this.align_self = r100;
                return this;
            }

            public Builder aspect_ratio(Integer r100) {
                this.aspect_ratio = r100;
                return this;
            }

            public Builder background_color(Gradient r100) {
                this.background_color = r100;
                return this;
            }

            public Builder border(Border r100) {
                this.border = r100;
                return this;
            }

            public Builder font_level(FontLevel r100) {
                this.font_level = r100;
                return this;
            }

            public Builder grow_weight(Integer r100) {
                this.grow_weight = r100;
                return this;
            }

            public Builder height(Value r100) {
                this.height = r100;
                return this;
            }

            public Builder max_height(Value r100) {
                this.max_height = r100;
                return this;
            }

            public Builder max_width(Value r100) {
                this.max_width = r100;
                return this;
            }

            public Builder min_height(Value r100) {
                this.min_height = r100;
                return this;
            }

            public Builder min_width(Value r100) {
                this.min_width = r100;
                return this;
            }

            public Builder shrink_weight(Integer r100) {
                this.shrink_weight = r100;
                return this;
            }

            public Builder size_level(SizeLevel r100) {
                this.size_level = r100;
                return this;
            }

            public Builder text_color_v2(ThemeColor r100) {
                this.text_color_v2 = r100;
                return this;
            }

            public Builder width(Value r100) {
                this.width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Style extends ProtoAdapter<Style> {
            public ProtoAdapter_Style() {
                super(FieldEncoding.LENGTH_DELIMITED, Style.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Style decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.size_level = SizeLevel.NORMAL;
                r101.grow_weight = 0;
                r101.shrink_weight = 0;
                r101.aspect_ratio = 0;
                r101.align_self = Align.TOP;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L28;
                switch(r103) {
                    case 1: goto L32;
                    case 2: goto L6;
                    case 3: goto L23;
                    case 4: goto L22;
                    case 5: goto L21;
                    case 6: goto L20;
                    case 7: goto L19;
                    case 8: goto L18;
                    case 9: goto L17;
                    case 10: goto L16;
                    case 11: goto L15;
                    case 12: goto L14;
                    case 13: goto L13;
                    case 14: goto L12;
                    case 15: goto L11;
                    case 16: goto L30;
                    default: goto L6;
                };
            L30:
                r101.align_self = Align.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.size_level = SizeLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
            L26:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.aspect_ratio = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                r101.text_color_v2 = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L13:
                r101.border = Border.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.font_level = FontLevel.ADAPTER.decode(r100);
                goto L3
            L15:
                r101.shrink_weight = ProtoAdapter.INT32.decode(r100);
                goto L3
            L16:
                r101.grow_weight = ProtoAdapter.INT32.decode(r100);
                goto L3
            L17:
                r101.min_height = Value.ADAPTER.decode(r100);
                goto L3
            L18:
                r101.min_width = Value.ADAPTER.decode(r100);
                goto L3
            L19:
                r101.max_height = Value.ADAPTER.decode(r100);
                goto L3
            L20:
                r101.max_width = Value.ADAPTER.decode(r100);
                goto L3
            L21:
                r101.height = Value.ADAPTER.decode(r100);
                goto L3
            L22:
                r101.width = Value.ADAPTER.decode(r100);
                goto L3
            L23:
                r101.background_color = Gradient.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L28:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Style r100) {
                SizeLevel r101 = r100.size_level;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = SizeLevel.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ThemeColor r104 = r100.text_color_v2;
                if (r104 == null) goto L9;
                int r105 = ThemeColor.ADAPTER.encodedSizeWithTag(14, r104);
            L10:
                int r106 = r103 + r105;
                Gradient r107 = r100.background_color;
                if (r107 == null) goto L13;
                int r108 = Gradient.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Value r110 = r100.width;
                if (r110 == null) goto L17;
                int r111 = Value.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Value r113 = r100.height;
                if (r113 == null) goto L21;
                int r114 = Value.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Value r116 = r100.max_width;
                if (r116 == null) goto L25;
                int r117 = Value.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Value r119 = r100.max_height;
                if (r119 == null) goto L29;
                int r120 = Value.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Value r122 = r100.min_width;
                if (r122 == null) goto L33;
                int r123 = Value.ADAPTER.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Value r125 = r100.min_height;
                if (r125 == null) goto L37;
                int r126 = Value.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                Integer r128 = r100.grow_weight;
                if (r128 == null) goto L41;
                int r129 = ProtoAdapter.INT32.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                Integer r131 = r100.shrink_weight;
                if (r131 == null) goto L45;
                int r132 = ProtoAdapter.INT32.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                FontLevel r134 = r100.font_level;
                if (r134 == null) goto L49;
                int r135 = FontLevel.ADAPTER.encodedSizeWithTag(12, r134);
            L50:
                int r136 = r133 + r135;
                Border r137 = r100.border;
                if (r137 == null) goto L53;
                int r138 = Border.ADAPTER.encodedSizeWithTag(13, r137);
            L54:
                int r139 = r136 + r138;
                Integer r140 = r100.aspect_ratio;
                if (r140 == null) goto L57;
                int r141 = ProtoAdapter.INT32.encodedSizeWithTag(15, r140);
            L58:
                int r142 = r139 + r141;
                Align r143 = r100.align_self;
                if (r143 == null) goto L62;
                r102 = Align.ADAPTER.encodedSizeWithTag(16, r143);
            L62:
                return (r142 + r102) + r100.unknownFields().size();
            L57:
                r141 = 0;
                goto L58
            L53:
                r138 = 0;
                goto L54
            L49:
                r135 = 0;
                goto L50
            L45:
                r132 = 0;
                goto L46
            L41:
                r129 = 0;
                goto L42
            L37:
                r126 = 0;
                goto L38
            L33:
                r123 = 0;
                goto L34
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
            public /* bridge */ /* synthetic */ Style decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Style r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Style r101) throws IOException {
                SizeLevel r102 = r101.size_level;
                if (r102 == null) goto L5;
                SizeLevel.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ThemeColor r103 = r101.text_color_v2;
                if (r103 == null) goto L8;
                ThemeColor.ADAPTER.encodeWithTag(r100, 14, r103);
            L8:
                Gradient r104 = r101.background_color;
                if (r104 == null) goto L11;
                Gradient.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Value r105 = r101.width;
                if (r105 == null) goto L14;
                Value.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                Value r106 = r101.height;
                if (r106 == null) goto L17;
                Value.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Value r107 = r101.max_width;
                if (r107 == null) goto L20;
                Value.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Value r108 = r101.max_height;
                if (r108 == null) goto L23;
                Value.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                Value r109 = r101.min_width;
                if (r109 == null) goto L26;
                Value.ADAPTER.encodeWithTag(r100, 8, r109);
            L26:
                Value r110 = r101.min_height;
                if (r110 == null) goto L29;
                Value.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                Integer r111 = r101.grow_weight;
                if (r111 == null) goto L32;
                ProtoAdapter.INT32.encodeWithTag(r100, 10, r111);
            L32:
                Integer r112 = r101.shrink_weight;
                if (r112 == null) goto L35;
                ProtoAdapter.INT32.encodeWithTag(r100, 11, r112);
            L35:
                FontLevel r113 = r101.font_level;
                if (r113 == null) goto L38;
                FontLevel.ADAPTER.encodeWithTag(r100, 12, r113);
            L38:
                Border r114 = r101.border;
                if (r114 == null) goto L41;
                Border.ADAPTER.encodeWithTag(r100, 13, r114);
            L41:
                Integer r115 = r101.aspect_ratio;
                if (r115 == null) goto L44;
                ProtoAdapter.INT32.encodeWithTag(r100, 15, r115);
            L44:
                Align r116 = r101.align_self;
                if (r116 == null) goto L47;
                Align.ADAPTER.encodeWithTag(r100, 16, r116);
            L47:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Style r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Style();
            DEFAULT_SIZE_LEVEL = SizeLevel.NORMAL;
            DEFAULT_GROW_WEIGHT = 0;
            DEFAULT_SHRINK_WEIGHT = 0;
            DEFAULT_ASPECT_RATIO = 0;
            DEFAULT_ALIGN_SELF = Align.TOP;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.size_level = this.size_level;
            r100.text_color_v2 = this.text_color_v2;
            r100.background_color = this.background_color;
            r100.width = this.width;
            r100.height = this.height;
            r100.max_width = this.max_width;
            r100.max_height = this.max_height;
            r100.min_width = this.min_width;
            r100.min_height = this.min_height;
            r100.grow_weight = this.grow_weight;
            r100.shrink_weight = this.shrink_weight;
            r100.font_level = this.font_level;
            r100.border = this.border;
            r100.aspect_ratio = this.aspect_ratio;
            r100.align_self = this.align_self;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Style.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Style(SizeLevel r110, ThemeColor r111, Gradient r210, Value r211, Value r212, Value r213, Value r214, Value r215, Value r216, Integer r217, Integer r218, FontLevel r219, Border r310, Integer r311, Align r312) {
            this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
        }

        public Style(SizeLevel r100, ThemeColor r101, Gradient r102, Value r103, Value r104, Value r105, Value r110, Value r111, Value r112, Integer r113, Integer r114, FontLevel r115, Border r116, Integer r117, Align r118, ByteString r119) {
            super(ADAPTER, r119);
            this.size_level = r100;
            this.text_color_v2 = r101;
            this.background_color = r102;
            this.width = r103;
            this.height = r104;
            this.max_width = r105;
            this.max_height = r110;
            this.min_width = r111;
            this.min_height = r112;
            this.grow_weight = r113;
            this.shrink_weight = r114;
            this.font_level = r115;
            this.border = r116;
            this.aspect_ratio = r117;
            this.align_self = r118;
        }
    }

    public static final class TagListProperty extends com.squareup.wire.Message<TagListProperty, Builder> {
        public static final ProtoAdapter<TagListProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        private static final long serialVersionUID = 0;
        public final List<Tag> mixed_tags;
        public final Integer number_of_lines;
        public final List<String> tags;

        public static final class Builder extends com.squareup.wire.Message.Builder<TagListProperty, Builder> {
            public List<Tag> mixed_tags;
            public Integer number_of_lines;
            public List<String> tags;

            @Override // com.squareup.wire.Message.Builder
            public TagListProperty build() {
                return new TagListProperty(this.tags, this.mixed_tags, this.number_of_lines, super.buildUnknownFields());
            }

            public Builder() {
                this.tags = Internal.newMutableList();
                this.mixed_tags = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder mixed_tags(List<Tag> r100) {
                Internal.checkElementsNotNull(r100);
                this.mixed_tags = r100;
                return this;
            }

            public Builder number_of_lines(Integer r100) {
                this.number_of_lines = r100;
                return this;
            }

            public Builder tags(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.tags = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TagListProperty extends ProtoAdapter<TagListProperty> {
            public ProtoAdapter_TagListProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TagListProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TagListProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.number_of_lines = 1;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L14;
                if (r103 != 1) goto L7;
                r101.tags.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                if (r103 != 2) goto L9;
                r101.mixed_tags.add(Tag.ADAPTER.decode(r100));
                goto L3
            L9:
                if (r103 != 3) goto L10;
                r101.number_of_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TagListProperty r100) {
                int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.tags) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mixed_tags);
                Integer r102 = r100.number_of_lines;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(3, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TagListProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TagListProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TagListProperty r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.tags);
                Tag.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mixed_tags);
                Integer r102 = r101.number_of_lines;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagListProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class Tag extends com.squareup.wire.Message<Tag, Builder> {
            public static final ProtoAdapter<Tag> ADAPTER = null;
            public static final String DEFAULT_TAG = "";
            private static final long serialVersionUID = 0;
            public final ThemeColor background_color;
            public final String tag;
            public final ThemeColor text_color;

            public static final class Builder extends com.squareup.wire.Message.Builder<Tag, Builder> {
                public ThemeColor background_color;
                public String tag;
                public ThemeColor text_color;

                @Override // com.squareup.wire.Message.Builder
                public Tag build() {
                    return new Tag(this.tag, this.text_color, this.background_color, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder background_color(ThemeColor r100) {
                    this.background_color = r100;
                    return this;
                }

                public Builder tag(String r100) {
                    this.tag = r100;
                    return this;
                }

                public Builder text_color(ThemeColor r100) {
                    this.text_color = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Tag extends ProtoAdapter<Tag> {
                public ProtoAdapter_Tag() {
                    super(FieldEncoding.LENGTH_DELIMITED, Tag.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Tag decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.tag = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.tag = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.text_color = ThemeColor.ADAPTER.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.background_color = ThemeColor.ADAPTER.decode(r100);
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
                public int encodedSize2(Tag r100) {
                    String r101 = r100.tag;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    ThemeColor r104 = r100.text_color;
                    if (r104 == null) goto L9;
                    int r105 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    ThemeColor r107 = r100.background_color;
                    if (r107 == null) goto L14;
                    r102 = ThemeColor.ADAPTER.encodedSizeWithTag(3, r107);
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
                public /* bridge */ /* synthetic */ Tag decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Tag r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Tag r101) throws IOException {
                    String r102 = r101.tag;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    ThemeColor r103 = r101.text_color;
                    if (r103 == null) goto L8;
                    ThemeColor.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    ThemeColor r104 = r101.background_color;
                    if (r104 == null) goto L11;
                    ThemeColor.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Tag r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Tag();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.tag = this.tag;
                r100.text_color = this.text_color;
                r100.background_color = this.background_color;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Tag.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Tag(String r100, ThemeColor r101, ThemeColor r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public Tag(String r100, ThemeColor r101, ThemeColor r102, ByteString r103) {
                super(ADAPTER, r103);
                this.tag = r100;
                this.text_color = r101;
                this.background_color = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TagListProperty();
            DEFAULT_NUMBER_OF_LINES = 1;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
            r100.mixed_tags = Internal.copyOf("mixed_tags", this.mixed_tags);
            r100.number_of_lines = this.number_of_lines;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TagListProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TagListProperty(List<String> r100, List<Tag> r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TagListProperty(List<String> r100, List<Tag> r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r100);
            this.mixed_tags = Internal.immutableCopyOf("mixed_tags", r101);
            this.number_of_lines = r102;
        }
    }

    public static final class TextButtonProperty extends com.squareup.wire.Message<TextButtonProperty, Builder> {
        public static final ProtoAdapter<TextButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_IS_DISABLE = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final Boolean is_disable;
        public final String text;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextButtonProperty, Builder> {
            public String action_id;
            public Boolean is_disable;
            public String text;

            @Override // com.squareup.wire.Message.Builder
            public TextButtonProperty build() {
                return new TextButtonProperty(this.text, this.action_id, this.is_disable, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder is_disable(Boolean r100) {
                this.is_disable = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TextButtonProperty extends ProtoAdapter<TextButtonProperty> {
            public ProtoAdapter_TextButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextButtonProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TextButtonProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.action_id = "";
                r101.is_disable = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.is_disable = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(TextButtonProperty r100) {
                String r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.action_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_disable;
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
            public /* bridge */ /* synthetic */ TextButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TextButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TextButtonProperty r101) throws IOException {
                String r102 = r101.text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.action_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_disable;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextButtonProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextButtonProperty();
            DEFAULT_IS_DISABLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.action_id = this.action_id;
            r100.is_disable = this.is_disable;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TextButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TextButtonProperty(String r100, String r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TextButtonProperty(String r100, String r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.text = r100;
            this.action_id = r101;
            this.is_disable = r102;
        }
    }

    public static final class TextProperty extends com.squareup.wire.Message<TextProperty, Builder> {
        public static final ProtoAdapter<TextProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final Integer number_of_lines;
        public final String text;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextProperty, Builder> {
            public String action_id;
            public Integer number_of_lines;
            public String text;

            @Override // com.squareup.wire.Message.Builder
            public TextProperty build() {
                return new TextProperty(this.text, this.number_of_lines, this.action_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder number_of_lines(Integer r100) {
                this.number_of_lines = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TextProperty extends ProtoAdapter<TextProperty> {
            public ProtoAdapter_TextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TextProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.number_of_lines = 0;
                r101.action_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.number_of_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TextProperty r100) {
                String r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.number_of_lines;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.action_id;
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
            public /* bridge */ /* synthetic */ TextProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TextProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TextProperty r101) throws IOException {
                String r102 = r101.text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.number_of_lines;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.action_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextProperty();
            DEFAULT_NUMBER_OF_LINES = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.number_of_lines = this.number_of_lines;
            r100.action_id = this.action_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TextProperty(String r100, Integer r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TextProperty(String r100, Integer r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.text = r100;
            this.number_of_lines = r101;
            this.action_id = r102;
        }
    }

    public static final enum Theme extends Enum<Theme> implements WireEnum {
        private static final /* synthetic */ Theme[] $VALUES = null;
        public static final ProtoAdapter<Theme> ADAPTER = null;
        public static final Theme DARK = null;
        public static final Theme LIGHT = null;
        private final int value;

        static {
            Theme r100 = new Theme("LIGHT", 0, 0);
            LIGHT = r100;
            Theme r101 = new Theme("DARK", 1, 1);
            DARK = r101;
            $VALUES = new Theme[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Theme.class);
        }

        public static Theme[] values() {
            return (Theme[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Theme fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return DARK;
        L10:
            return LIGHT;
        }

        public static Theme valueOf(String r100) {
            return (Theme) a.a(Theme.class, r100);
        }

        private Theme(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TimeProperty extends com.squareup.wire.Message<TimeProperty, Builder> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final Long DEFAULT_END_TIME_STAMP = null;
        public static final Boolean DEFAULT_IS_COUNTDOWN = null;
        public static final Boolean DEFAULT_IS_END = null;
        public static final String DEFAULT_NTP_ACTION_ID = "";
        public static final Long DEFAULT_START_TIME_STAMP = null;
        private static final long serialVersionUID = 0;
        public final Long end_time_stamp;
        public final Boolean is_countdown;
        public final Boolean is_end;
        public final String ntp_action_id;
        public final Long start_time_stamp;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeProperty, Builder> {
            public Long end_time_stamp;
            public Boolean is_countdown;
            public Boolean is_end;
            public String ntp_action_id;
            public Long start_time_stamp;

            @Override // com.squareup.wire.Message.Builder
            public TimeProperty build() {
                Long r100 = this.start_time_stamp;
                if (r100 == null) goto L7;
                return new TimeProperty(this.start_time_stamp, this.is_countdown, this.ntp_action_id, this.is_end, this.end_time_stamp, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "start_time_stamp"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder end_time_stamp(Long r100) {
                this.end_time_stamp = r100;
                return this;
            }

            public Builder is_countdown(Boolean r100) {
                this.is_countdown = r100;
                return this;
            }

            public Builder is_end(Boolean r100) {
                this.is_end = r100;
                return this;
            }

            public Builder ntp_action_id(String r100) {
                this.ntp_action_id = r100;
                return this;
            }

            public Builder start_time_stamp(Long r100) {
                this.start_time_stamp = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeProperty extends ProtoAdapter<TimeProperty> {
            public ProtoAdapter_TimeProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.start_time_stamp = 0L;
                Boolean r102 = Boolean.FALSE;
                r101.is_countdown = r102;
                r101.ntp_action_id = "";
                r101.is_end = r102;
                r101.end_time_stamp = 0L;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                if (r104 != 1) goto L8;
                r101.start_time_stamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.is_countdown = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.ntp_action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L14;
                r101.is_end = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r104 != 5) goto L15;
                r101.end_time_stamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L15:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TimeProperty r100) {
                ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
                int r102 = r101.encodedSizeWithTag(1, r100.start_time_stamp);
                Boolean r103 = r100.is_countdown;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.ntp_action_id;
                if (r107 == null) goto L9;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_end;
                if (r110 == null) goto L13;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L14:
                int r112 = r109 + r111;
                Long r113 = r100.end_time_stamp;
                if (r113 == null) goto L18;
                r104 = r101.encodedSizeWithTag(5, r113);
            L18:
                return (r112 + r104) + r100.unknownFields().size();
            L13:
                r111 = 0;
                goto L14
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TimeProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeProperty r101) throws IOException {
                ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
                r102.encodeWithTag(r100, 1, r101.start_time_stamp);
                Boolean r103 = r101.is_countdown;
                if (r103 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L5:
                String r104 = r101.ntp_action_id;
                if (r104 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L8:
                Boolean r105 = r101.is_end;
                if (r105 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L11:
                Long r106 = r101.end_time_stamp;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 5, r106);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeProperty();
            DEFAULT_START_TIME_STAMP = 0L;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_COUNTDOWN = r100;
            DEFAULT_IS_END = r100;
            DEFAULT_END_TIME_STAMP = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.start_time_stamp = this.start_time_stamp;
            r100.is_countdown = this.is_countdown;
            r100.ntp_action_id = this.ntp_action_id;
            r100.is_end = this.is_end;
            r100.end_time_stamp = this.end_time_stamp;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeProperty(Long r100, Boolean r101, String r110, Boolean r111, Long r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public TimeProperty(Long r100, Boolean r101, String r102, Boolean r103, Long r104, ByteString r105) {
            super(ADAPTER, r105);
            this.start_time_stamp = r100;
            this.is_countdown = r101;
            this.ntp_action_id = r102;
            this.is_end = r103;
            this.end_time_stamp = r104;
        }
    }

    public static final class TimeZoneProperty extends com.squareup.wire.Message<TimeZoneProperty, Builder> {
        public static final ProtoAdapter<TimeZoneProperty> ADAPTER = null;
        public static final DatePrecisionType DEFAULT_DATE_PRECISION_TYPE = null;
        public static final DateStatusType DEFAULT_DATE_STATUS_TYPE = null;
        public static final Boolean DEFAULT_ENABLE_GMT = null;
        public static final Long DEFAULT_END_TIME_STAMP = null;
        public static final FormatType DEFAULT_FORMAT_TYPE = null;
        public static final Long DEFAULT_START_TIME_STAMP = null;
        public static final TimePrecisionType DEFAULT_TIME_PRECISION_TYPE = null;
        public static final TimeStyle DEFAULT_TIME_STYLE = null;
        public static final TimeZoneType DEFAULT_TIME_ZONE_TYPE = null;
        private static final long serialVersionUID = 0;
        public final DatePrecisionType date_precision_type;
        public final DateStatusType date_status_type;
        public final Boolean enable_gmt;
        public final Long end_time_stamp;
        public final FormatType format_type;
        public final Long start_time_stamp;
        public final TimePrecisionType time_precision_type;
        public final TimeStyle time_style;
        public final TimeZoneType time_zone_type;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeZoneProperty, Builder> {
            public DatePrecisionType date_precision_type;
            public DateStatusType date_status_type;
            public Boolean enable_gmt;
            public Long end_time_stamp;
            public FormatType format_type;
            public Long start_time_stamp;
            public TimePrecisionType time_precision_type;
            public TimeStyle time_style;
            public TimeZoneType time_zone_type;

            @Override // com.squareup.wire.Message.Builder
            public TimeZoneProperty build() {
                return new TimeZoneProperty(this.time_zone_type, this.format_type, this.time_precision_type, this.time_style, this.date_precision_type, this.date_status_type, this.start_time_stamp, this.end_time_stamp, this.enable_gmt, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder date_precision_type(DatePrecisionType r100) {
                this.date_precision_type = r100;
                return this;
            }

            public Builder date_status_type(DateStatusType r100) {
                this.date_status_type = r100;
                return this;
            }

            public Builder enable_gmt(Boolean r100) {
                this.enable_gmt = r100;
                return this;
            }

            public Builder end_time_stamp(Long r100) {
                this.end_time_stamp = r100;
                return this;
            }

            public Builder format_type(FormatType r100) {
                this.format_type = r100;
                return this;
            }

            public Builder start_time_stamp(Long r100) {
                this.start_time_stamp = r100;
                return this;
            }

            public Builder time_precision_type(TimePrecisionType r100) {
                this.time_precision_type = r100;
                return this;
            }

            public Builder time_style(TimeStyle r100) {
                this.time_style = r100;
                return this;
            }

            public Builder time_zone_type(TimeZoneType r100) {
                this.time_zone_type = r100;
                return this;
            }
        }

        public static final enum DatePrecisionType extends Enum<DatePrecisionType> implements WireEnum {
            private static final /* synthetic */ DatePrecisionType[] $VALUES = null;
            public static final ProtoAdapter<DatePrecisionType> ADAPTER = null;
            public static final DatePrecisionType DAY_TYPE = null;
            public static final DatePrecisionType MONTH_TYPE = null;
            private final int value;

            static {
                DatePrecisionType r100 = new DatePrecisionType("DAY_TYPE", 0, 0);
                DAY_TYPE = r100;
                DatePrecisionType r101 = new DatePrecisionType("MONTH_TYPE", 1, 1);
                MONTH_TYPE = r101;
                $VALUES = new DatePrecisionType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(DatePrecisionType.class);
            }

            public static DatePrecisionType[] values() {
                return (DatePrecisionType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static DatePrecisionType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return MONTH_TYPE;
            L10:
                return DAY_TYPE;
            }

            public static DatePrecisionType valueOf(String r100) {
                return (DatePrecisionType) a.a(DatePrecisionType.class, r100);
            }

            private DatePrecisionType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum DateStatusType extends Enum<DateStatusType> implements WireEnum {
            private static final /* synthetic */ DateStatusType[] $VALUES = null;
            public static final DateStatusType ABSOLUTE = null;
            public static final ProtoAdapter<DateStatusType> ADAPTER = null;
            public static final DateStatusType RELATIVE = null;
            private final int value;

            static {
                DateStatusType r100 = new DateStatusType("ABSOLUTE", 0, 0);
                ABSOLUTE = r100;
                DateStatusType r101 = new DateStatusType("RELATIVE", 1, 1);
                RELATIVE = r101;
                $VALUES = new DateStatusType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(DateStatusType.class);
            }

            public static DateStatusType[] values() {
                return (DateStatusType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static DateStatusType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return RELATIVE;
            L10:
                return ABSOLUTE;
            }

            public static DateStatusType valueOf(String r100) {
                return (DateStatusType) a.a(DateStatusType.class, r100);
            }

            private DateStatusType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum FormatType extends Enum<FormatType> implements WireEnum {
            private static final /* synthetic */ FormatType[] $VALUES = null;
            public static final ProtoAdapter<FormatType> ADAPTER = null;
            public static final FormatType LONG = null;
            public static final FormatType SHORT = null;
            private final int value;

            static {
                FormatType r100 = new FormatType("SHORT", 0, 0);
                SHORT = r100;
                FormatType r101 = new FormatType("LONG", 1, 1);
                LONG = r101;
                $VALUES = new FormatType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(FormatType.class);
            }

            public static FormatType[] values() {
                return (FormatType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FormatType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return LONG;
            L10:
                return SHORT;
            }

            public static FormatType valueOf(String r100) {
                return (FormatType) a.a(FormatType.class, r100);
            }

            private FormatType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_TimeZoneProperty extends ProtoAdapter<TimeZoneProperty> {
            public ProtoAdapter_TimeZoneProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeZoneProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeZoneProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.time_zone_type = TimeZoneType.FULL_DATE_TIME;
                r101.format_type = FormatType.LONG;
                r101.time_precision_type = TimePrecisionType.MINUTE;
                r101.time_style = TimeStyle.DEFAULT;
                r101.date_precision_type = DatePrecisionType.DAY_TYPE;
                r101.date_status_type = DateStatusType.RELATIVE;
                r101.start_time_stamp = 0L;
                r101.end_time_stamp = 0L;
                r101.enable_gmt = Boolean.TRUE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L34;
                switch(r103) {
                    case 1: goto L46;
                    case 2: goto L38;
                    case 3: goto L40;
                    case 4: goto L42;
                    case 5: goto L36;
                    case 6: goto L44;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L36:
                r101.date_precision_type = DatePrecisionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L38:
                r101.format_type = FormatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
            L28:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L40:
                r101.time_precision_type = TimePrecisionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L42:
                r101.time_style = TimeStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L44:
                r101.date_status_type = DateStatusType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L46:
                r101.time_zone_type = TimeZoneType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
            L32:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.enable_gmt = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.end_time_stamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                r101.start_time_stamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L34:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TimeZoneProperty r100) {
                TimeZoneType r101 = r100.time_zone_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TimeZoneType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                FormatType r104 = r100.format_type;
                if (r104 == null) goto L9;
                int r105 = FormatType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TimePrecisionType r107 = r100.time_precision_type;
                if (r107 == null) goto L13;
                int r108 = TimePrecisionType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                TimeStyle r110 = r100.time_style;
                if (r110 == null) goto L17;
                int r111 = TimeStyle.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                DatePrecisionType r113 = r100.date_precision_type;
                if (r113 == null) goto L21;
                int r114 = DatePrecisionType.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                DateStatusType r116 = r100.date_status_type;
                if (r116 == null) goto L25;
                int r117 = DateStatusType.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Long r119 = r100.start_time_stamp;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Long r122 = r100.end_time_stamp;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Boolean r125 = r100.enable_gmt;
                if (r125 == null) goto L38;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
            L38:
                return (r124 + r102) + r100.unknownFields().size();
            L33:
                r123 = 0;
                goto L34
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
            public /* bridge */ /* synthetic */ TimeZoneProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeZoneProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeZoneProperty r101) throws IOException {
                TimeZoneType r102 = r101.time_zone_type;
                if (r102 == null) goto L5;
                TimeZoneType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                FormatType r103 = r101.format_type;
                if (r103 == null) goto L8;
                FormatType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                TimePrecisionType r104 = r101.time_precision_type;
                if (r104 == null) goto L11;
                TimePrecisionType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                TimeStyle r105 = r101.time_style;
                if (r105 == null) goto L14;
                TimeStyle.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                DatePrecisionType r106 = r101.date_precision_type;
                if (r106 == null) goto L17;
                DatePrecisionType.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                DateStatusType r107 = r101.date_status_type;
                if (r107 == null) goto L20;
                DateStatusType.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Long r108 = r101.start_time_stamp;
                if (r108 == null) goto L23;
                ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
            L23:
                Long r109 = r101.end_time_stamp;
                if (r109 == null) goto L26;
                ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
            L26:
                Boolean r110 = r101.enable_gmt;
                if (r110 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeZoneProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TimePrecisionType extends Enum<TimePrecisionType> implements WireEnum {
            private static final /* synthetic */ TimePrecisionType[] $VALUES = null;
            public static final ProtoAdapter<TimePrecisionType> ADAPTER = null;
            public static final TimePrecisionType HOUR = null;
            public static final TimePrecisionType MINUTE = null;
            public static final TimePrecisionType SECOND = null;
            private final int value;

            static {
                TimePrecisionType r100 = new TimePrecisionType("SECOND", 0, 0);
                SECOND = r100;
                TimePrecisionType r101 = new TimePrecisionType("MINUTE", 1, 1);
                MINUTE = r101;
                TimePrecisionType r102 = new TimePrecisionType("HOUR", 2, 2);
                HOUR = r102;
                $VALUES = new TimePrecisionType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimePrecisionType.class);
            }

            public static TimePrecisionType[] values() {
                return (TimePrecisionType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TimePrecisionType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return HOUR;
            L12:
                return MINUTE;
            L14:
                return SECOND;
            }

            public static TimePrecisionType valueOf(String r100) {
                return (TimePrecisionType) a.a(TimePrecisionType.class, r100);
            }

            private TimePrecisionType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum TimeStyle extends Enum<TimeStyle> implements WireEnum {
            private static final /* synthetic */ TimeStyle[] $VALUES = null;
            public static final ProtoAdapter<TimeStyle> ADAPTER = null;
            public static final TimeStyle BY_12_HOUR = null;
            public static final TimeStyle BY_24_HOUR = null;
            public static final TimeStyle DEFAULT = null;
            private final int value;

            static {
                TimeStyle r100 = new TimeStyle("DEFAULT", 0, 0);
                DEFAULT = r100;
                TimeStyle r101 = new TimeStyle("BY_12_HOUR", 1, 1);
                BY_12_HOUR = r101;
                TimeStyle r102 = new TimeStyle("BY_24_HOUR", 2, 2);
                BY_24_HOUR = r102;
                $VALUES = new TimeStyle[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeStyle.class);
            }

            public static TimeStyle[] values() {
                return (TimeStyle[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TimeStyle fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return BY_24_HOUR;
            L12:
                return BY_12_HOUR;
            L14:
                return DEFAULT;
            }

            public static TimeStyle valueOf(String r100) {
                return (TimeStyle) a.a(TimeStyle.class, r100);
            }

            private TimeStyle(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum TimeZoneType extends Enum<TimeZoneType> implements WireEnum {
            private static final /* synthetic */ TimeZoneType[] $VALUES = null;
            public static final ProtoAdapter<TimeZoneType> ADAPTER = null;
            public static final TimeZoneType DATE = null;
            public static final TimeZoneType DATE_RANGE = null;
            public static final TimeZoneType DATE_TIME = null;
            public static final TimeZoneType DATE_TIME_RANGE = null;
            public static final TimeZoneType FULL_DATE = null;
            public static final TimeZoneType FULL_DATE_TIME = null;
            public static final TimeZoneType MERIDIEM = null;
            public static final TimeZoneType MONTH = null;
            public static final TimeZoneType TIME = null;
            public static final TimeZoneType WEEK = null;
            private final int value;

            static {
                TimeZoneType r100 = new TimeZoneType("MERIDIEM", 0, 0);
                MERIDIEM = r100;
                TimeZoneType r101 = new TimeZoneType("WEEK", 1, 1);
                WEEK = r101;
                TimeZoneType r102 = new TimeZoneType("MONTH", 2, 2);
                MONTH = r102;
                TimeZoneType r103 = new TimeZoneType("TIME", 3, 3);
                TIME = r103;
                TimeZoneType r104 = new TimeZoneType("DATE", 4, 4);
                DATE = r104;
                TimeZoneType r105 = new TimeZoneType("FULL_DATE", 5, 5);
                FULL_DATE = r105;
                TimeZoneType r110 = new TimeZoneType("DATE_TIME", 6, 6);
                DATE_TIME = r110;
                TimeZoneType r111 = new TimeZoneType("FULL_DATE_TIME", 7, 7);
                FULL_DATE_TIME = r111;
                TimeZoneType r112 = new TimeZoneType("DATE_RANGE", 8, 8);
                DATE_RANGE = r112;
                TimeZoneType r113 = new TimeZoneType("DATE_TIME_RANGE", 9, 9);
                DATE_TIME_RANGE = r113;
                $VALUES = new TimeZoneType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeZoneType.class);
            }

            public static TimeZoneType[] values() {
                return (TimeZoneType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TimeZoneType fromValue(int r100) {
                switch(r100) {
                    case 0: goto L24;
                    case 1: goto L22;
                    case 2: goto L20;
                    case 3: goto L18;
                    case 4: goto L16;
                    case 5: goto L14;
                    case 6: goto L12;
                    case 7: goto L10;
                    case 8: goto L8;
                    case 9: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DATE_TIME_RANGE;
            L8:
                return DATE_RANGE;
            L10:
                return FULL_DATE_TIME;
            L12:
                return DATE_TIME;
            L14:
                return FULL_DATE;
            L16:
                return DATE;
            L18:
                return TIME;
            L20:
                return MONTH;
            L22:
                return WEEK;
            L24:
                return MERIDIEM;
            }

            public static TimeZoneType valueOf(String r100) {
                return (TimeZoneType) a.a(TimeZoneType.class, r100);
            }

            private TimeZoneType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeZoneProperty();
            DEFAULT_TIME_ZONE_TYPE = TimeZoneType.FULL_DATE_TIME;
            DEFAULT_FORMAT_TYPE = FormatType.LONG;
            DEFAULT_TIME_PRECISION_TYPE = TimePrecisionType.MINUTE;
            DEFAULT_TIME_STYLE = TimeStyle.DEFAULT;
            DEFAULT_DATE_PRECISION_TYPE = DatePrecisionType.DAY_TYPE;
            DEFAULT_DATE_STATUS_TYPE = DateStatusType.RELATIVE;
            DEFAULT_START_TIME_STAMP = 0L;
            DEFAULT_END_TIME_STAMP = 0L;
            DEFAULT_ENABLE_GMT = Boolean.TRUE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.time_zone_type = this.time_zone_type;
            r100.format_type = this.format_type;
            r100.time_precision_type = this.time_precision_type;
            r100.time_style = this.time_style;
            r100.date_precision_type = this.date_precision_type;
            r100.date_status_type = this.date_status_type;
            r100.start_time_stamp = this.start_time_stamp;
            r100.end_time_stamp = this.end_time_stamp;
            r100.enable_gmt = this.enable_gmt;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeZoneProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeZoneProperty(TimeZoneType r110, FormatType r111, TimePrecisionType r112, TimeStyle r113, DatePrecisionType r114, DateStatusType r115, Long r116, Long r117, Boolean r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public TimeZoneProperty(TimeZoneType r100, FormatType r101, TimePrecisionType r102, TimeStyle r103, DatePrecisionType r104, DateStatusType r105, Long r106, Long r107, Boolean r110, ByteString r111) {
            super(ADAPTER, r111);
            this.time_zone_type = r100;
            this.format_type = r101;
            this.time_precision_type = r102;
            this.time_style = r103;
            this.date_precision_type = r104;
            this.date_status_type = r105;
            this.start_time_stamp = r106;
            this.end_time_stamp = r107;
            this.enable_gmt = r110;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AVATAR = null;
        public static final Type BUTTON = null;
        public static final Type CARD_CONTAINER = null;
        public static final Type CHATTERS_PREVIEW = null;
        public static final Type DOC_IMAGE = null;
        public static final Type DOC_STATE_BUTTON = null;
        public static final Type EMPTY = null;
        public static final Type ENGINE = null;
        public static final Type FLEX_LAYOUT = null;
        public static final Type HEADER = null;
        public static final Type ICON_BUTTON = null;
        public static final Type IMAGE = null;
        public static final Type IMAGE_CONTAINER = null;
        public static final Type LINEAR_LAYOUT = null;
        public static final Type LOADING = null;
        public static final Type OVERSIZED_TEXT = null;
        public static final Type RICHTEXT = null;
        public static final Type SPIN_BUTTON = null;
        public static final Type TAG_LIST = null;
        public static final Type TEXT = null;
        public static final Type TEXT_BUTTON = null;
        public static final Type TIME = null;
        public static final Type TIME_ZONE = null;
        public static final Type VIDEO = null;
        private final int value;

        static {
            Type r100 = new Type("EMPTY", 0, 0);
            EMPTY = r100;
            Type r101 = new Type("LINEAR_LAYOUT", 1, 1);
            LINEAR_LAYOUT = r101;
            Type r102 = new Type("FLEX_LAYOUT", 2, 2);
            FLEX_LAYOUT = r102;
            Type r103 = new Type("HEADER", 3, 501);
            HEADER = r103;
            Type r104 = new Type("RICHTEXT", 4, 502);
            RICHTEXT = r104;
            Type r105 = new Type("IMAGE", 5, 503);
            IMAGE = r105;
            Type r110 = new Type("CHATTERS_PREVIEW", 6, 504);
            CHATTERS_PREVIEW = r110;
            Type r111 = new Type("BUTTON", 7, 505);
            BUTTON = r111;
            Type r112 = new Type("ICON_BUTTON", 8, 506);
            ICON_BUTTON = r112;
            Type r113 = new Type("TEXT_BUTTON", 9, 507);
            TEXT_BUTTON = r113;
            Type r114 = new Type("TIME", 10, 508);
            TIME = r114;
            Type r106 = new Type(CardAdapter.TEXT, 11, 509);
            TEXT = r106;
            Type r107 = new Type("TAG_LIST", 12, 510);
            TAG_LIST = r107;
            Type r108 = new Type("SPIN_BUTTON", 13, 511);
            SPIN_BUTTON = r108;
            Type r109 = new Type("AVATAR", 14, 512);
            AVATAR = r109;
            Type r115 = new Type("VIDEO", 15, 513);
            VIDEO = r115;
            Type r116 = new Type("CARD_CONTAINER", 16, 514);
            CARD_CONTAINER = r116;
            Type r117 = new Type("DOC_IMAGE", 17, 515);
            DOC_IMAGE = r117;
            Type r118 = new Type("LOADING", 18, 516);
            LOADING = r118;
            Type r119 = new Type("TIME_ZONE", 19, 517);
            TIME_ZONE = r119;
            Type r120 = new Type("OVERSIZED_TEXT", 20, 518);
            OVERSIZED_TEXT = r120;
            Type r121 = new Type("ENGINE", 21, 519);
            ENGINE = r121;
            Type r122 = new Type("DOC_STATE_BUTTON", 22, 520);
            DOC_STATE_BUTTON = r122;
            Type r123 = new Type("IMAGE_CONTAINER", 23, 521);
            IMAGE_CONTAINER = r123;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123};
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
            if (r100 == 0) goto L57;
            if (r100 == 1) goto L55;
            if (r100 == 2) goto L53;
            switch(r100) {
                case 501: goto L51;
                case 502: goto L49;
                case 503: goto L47;
                case 504: goto L45;
                case 505: goto L43;
                case 506: goto L41;
                case 507: goto L39;
                case 508: goto L37;
                case 509: goto L35;
                case 510: goto L33;
                case 511: goto L31;
                case 512: goto L29;
                case 513: goto L27;
                case 514: goto L25;
                case 515: goto L23;
                case 516: goto L21;
                case 517: goto L19;
                case 518: goto L17;
                case 519: goto L15;
                case 520: goto L13;
                case 521: goto L11;
                default: goto L8;
            };
        L8:
            return null;
        L11:
            return IMAGE_CONTAINER;
        L13:
            return DOC_STATE_BUTTON;
        L15:
            return ENGINE;
        L17:
            return OVERSIZED_TEXT;
        L19:
            return TIME_ZONE;
        L21:
            return LOADING;
        L23:
            return DOC_IMAGE;
        L25:
            return CARD_CONTAINER;
        L27:
            return VIDEO;
        L29:
            return AVATAR;
        L31:
            return SPIN_BUTTON;
        L33:
            return TAG_LIST;
        L35:
            return TEXT;
        L37:
            return TIME;
        L39:
            return TEXT_BUTTON;
        L41:
            return ICON_BUTTON;
        L43:
            return BUTTON;
        L45:
            return CHATTERS_PREVIEW;
        L47:
            return IMAGE;
        L49:
            return RICHTEXT;
        L51:
            return HEADER;
        L53:
            return FLEX_LAYOUT;
        L55:
            return LINEAR_LAYOUT;
        L57:
            return EMPTY;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Value extends com.squareup.wire.Message<Value, Builder> {
        public static final ProtoAdapter<Value> ADAPTER = null;
        public static final ValueType DEFAULT_TYPE = null;
        public static final Float DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final ValueType type;
        public final Float value;

        public static final class Builder extends com.squareup.wire.Message.Builder<Value, Builder> {
            public ValueType type;
            public Float value;

            @Override // com.squareup.wire.Message.Builder
            public Value build() {
                return new Value(this.type, this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder type(ValueType r100) {
                this.type = r100;
                return this;
            }

            public Builder value(Float r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Value extends ProtoAdapter<Value> {
            public ProtoAdapter_Value() {
                super(FieldEncoding.LENGTH_DELIMITED, Value.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Value decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ValueType.AUTO;
                r101.value = Float.valueOf(0.0f);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = ValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.value = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Value r100) {
                ValueType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ValueType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Float r104 = r100.value;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Value decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Value r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Value r101) throws IOException {
                ValueType r102 = r101.type;
                if (r102 == null) goto L5;
                ValueType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Float r103 = r101.value;
                if (r103 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Value r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Value();
            DEFAULT_TYPE = ValueType.AUTO;
            DEFAULT_VALUE = Float.valueOf(0.0f);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Value.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Value(ValueType r100, Float r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Value(ValueType r100, Float r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.value = r101;
        }
    }

    public static final enum ValueType extends Enum<ValueType> implements WireEnum {
        private static final /* synthetic */ ValueType[] $VALUES = null;
        public static final ProtoAdapter<ValueType> ADAPTER = null;
        public static final ValueType AUTO = null;
        public static final ValueType PERCENTAGE = null;
        public static final ValueType POINT = null;
        private final int value;

        static {
            ValueType r100 = new ValueType("AUTO", 0, 0);
            AUTO = r100;
            ValueType r101 = new ValueType("POINT", 1, 1);
            POINT = r101;
            ValueType r102 = new ValueType("PERCENTAGE", 2, 2);
            PERCENTAGE = r102;
            $VALUES = new ValueType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ValueType.class);
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ValueType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PERCENTAGE;
        L12:
            return POINT;
        L14:
            return AUTO;
        }

        public static ValueType valueOf(String r100) {
            return (ValueType) a.a(ValueType.class, r100);
        }

        private ValueType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class VideoProperty extends com.squareup.wire.Message<VideoProperty, Builder> {
        public static final ProtoAdapter<VideoProperty> ADAPTER = null;
        public static final String DEFAULT_COVER_IMAGE_URL = "";
        public static final Long DEFAULT_DURATION = null;
        public static final String DEFAULT_IFRAME_URL = "";
        public static final Site DEFAULT_SITE = null;
        public static final String DEFAULT_SRC_URL = "";
        public static final String DEFAULT_VID = "";
        private static final long serialVersionUID = 0;
        public final ImageSet cover_image;
        public final String cover_image_url;
        public final Long duration;
        public final String iframe_url;
        public final Site site;
        public final String src_url;
        public final String vid;

        public static final class Builder extends com.squareup.wire.Message.Builder<VideoProperty, Builder> {
            public ImageSet cover_image;
            public String cover_image_url;
            public Long duration;
            public String iframe_url;
            public Site site;
            public String src_url;
            public String vid;

            @Override // com.squareup.wire.Message.Builder
            public VideoProperty build() {
                return new VideoProperty(this.site, this.cover_image, this.duration, this.src_url, this.vid, this.iframe_url, this.cover_image_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder cover_image(ImageSet r100) {
                this.cover_image = r100;
                return this;
            }

            public Builder cover_image_url(String r100) {
                this.cover_image_url = r100;
                return this;
            }

            public Builder duration(Long r100) {
                this.duration = r100;
                return this;
            }

            public Builder iframe_url(String r100) {
                this.iframe_url = r100;
                return this;
            }

            public Builder site(Site r100) {
                this.site = r100;
                return this;
            }

            public Builder src_url(String r100) {
                this.src_url = r100;
                return this;
            }

            public Builder vid(String r100) {
                this.vid = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_VideoProperty extends ProtoAdapter<VideoProperty> {
            public ProtoAdapter_VideoProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, VideoProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public VideoProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.site = Site.UNKNOWN;
                r101.duration = 0L;
                r101.src_url = "";
                r101.vid = "";
                r101.iframe_url = "";
                r101.cover_image_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L17;
                switch(r103) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r101.site = Site.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.cover_image_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.iframe_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.vid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.src_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.duration = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                r101.cover_image = ImageSet.ADAPTER.decode(r100);
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
            public int encodedSize2(VideoProperty r100) {
                Site r101 = r100.site;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Site.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ImageSet r104 = r100.cover_image;
                if (r104 == null) goto L9;
                int r105 = ImageSet.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.duration;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.src_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.vid;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.iframe_url;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.cover_image_url;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ VideoProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(VideoProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, VideoProperty r101) throws IOException {
                Site r102 = r101.site;
                if (r102 == null) goto L5;
                Site.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ImageSet r103 = r101.cover_image;
                if (r103 == null) goto L8;
                ImageSet.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.duration;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.src_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.vid;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.iframe_url;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.cover_image_url;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Site extends Enum<Site> implements WireEnum {
            private static final /* synthetic */ Site[] $VALUES = null;
            public static final ProtoAdapter<Site> ADAPTER = null;
            public static final Site DOUYIN = null;
            public static final Site HUOSHAN = null;
            public static final Site UNKNOWN = null;
            public static final Site XIGUA = null;
            public static final Site YOUTUBE = null;
            private final int value;

            static {
                Site r100 = new Site("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Site r101 = new Site("XIGUA", 1, 1);
                XIGUA = r101;
                Site r102 = new Site("DOUYIN", 2, 2);
                DOUYIN = r102;
                Site r103 = new Site("HUOSHAN", 3, 3);
                HUOSHAN = r103;
                Site r104 = new Site("YOUTUBE", 4, 4);
                YOUTUBE = r104;
                $VALUES = new Site[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(Site.class);
            }

            public static Site[] values() {
                return (Site[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Site fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return YOUTUBE;
            L16:
                return HUOSHAN;
            L18:
                return DOUYIN;
            L20:
                return XIGUA;
            L22:
                return UNKNOWN;
            }

            public static Site valueOf(String r100) {
                return (Site) a.a(Site.class, r100);
            }

            private Site(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VideoProperty();
            DEFAULT_SITE = Site.UNKNOWN;
            DEFAULT_DURATION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.site = this.site;
            r100.cover_image = this.cover_image;
            r100.duration = this.duration;
            r100.src_url = this.src_url;
            r100.vid = this.vid;
            r100.iframe_url = this.iframe_url;
            r100.cover_image_url = this.cover_image_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return VideoProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public VideoProperty(Site r110, ImageSet r111, Long r112, String r113, String r114, String r115, String r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public VideoProperty(Site r100, ImageSet r101, Long r102, String r103, String r104, String r105, String r106, ByteString r107) {
            super(ADAPTER, r107);
            this.site = r100;
            this.cover_image = r101;
            this.duration = r102;
            this.src_url = r103;
            this.vid = r104;
            this.iframe_url = r105;
            this.cover_image_url = r106;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLPreviewComponent();
        FIELD_OPTIONS_EMPTY = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_LINEAR_LAYOUT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_FLEX_LAYOUT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_HEADER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_RICHTEXT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IMAGE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CHATTERS_PREVIEW = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_BUTTON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ICON_BUTTON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TEXT_BUTTON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TIME = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TEXT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TAG_LIST = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SPIN_BUTTON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_AVATAR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_VIDEO = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CARD_CONTAINER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DOC_IMAGE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_LOADING = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TIME_ZONE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_OVERSIZED_TEXT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ENGINE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DOC_STATE_BUTTON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IMAGE_CONTAINER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_TYPE = Type.EMPTY;
        Boolean r100 = Boolean.TRUE;
        DEFAULT_CAN_SKIP_WHEN_UNKNOWN = r100;
        DEFAULT_IS_FONT_ZOOMABLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.can_skip_when_unknown = this.can_skip_when_unknown;
        r100.style = this.style;
        r100.child_ids = Internal.copyOf("child_ids", this.child_ids);
        r100.is_font_zoomable = this.is_font_zoomable;
        r100.empty = this.empty;
        r100.linear_layout = this.linear_layout;
        r100.flex_layout = this.flex_layout;
        r100.header = this.header;
        r100.richtext = this.richtext;
        r100.image = this.image;
        r100.chatters_preview = this.chatters_preview;
        r100.button = this.button;
        r100.icon_button = this.icon_button;
        r100.text_button = this.text_button;
        r100.time = this.time;
        r100.text = this.text;
        r100.tag_list = this.tag_list;
        r100.spin_button = this.spin_button;
        r100.avatar = this.avatar;
        r100.video = this.video;
        r100.card_container = this.card_container;
        r100.doc_image = this.doc_image;
        r100.loading = this.loading;
        r100.time_zone = this.time_zone;
        r100.oversized_text = this.oversized_text;
        r100.engine = this.engine;
        r100.doc_state_button = this.doc_state_button;
        r100.image_container = this.image_container;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URLPreviewComponent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public URLPreviewComponent(Type r310, Boolean r311, Style r312, List<String> r313, Boolean r314, EmptyProperty r315, LinearLayoutProperty r316, FlexLayoutProperty r317, PreviewHeaderProperty r410, RichTextProperty r411, ImageProperty r412, ChattersPreviewProperty r413, ButtonProperty r414, IconButtonProperty r415, TextButtonProperty r416, TimeProperty r417, TextProperty r418, TagListProperty r419, SpinButtonProperty r510, AvatarProperty r511, VideoProperty r512, CardContainerProperty r513, DocImageProperty r514, LoadingProperty r515, TimeZoneProperty r516, OversizedTextProperty r517, EngineProperty r518, DocStateButtonProperty r519, ImageContainerProperty r610) {
        this(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, ByteString.EMPTY);
    }

    public URLPreviewComponent(Type r110, Boolean r111, Style r210, List<String> r211, Boolean r212, EmptyProperty r213, LinearLayoutProperty r214, FlexLayoutProperty r215, PreviewHeaderProperty r216, RichTextProperty r217, ImageProperty r218, ChattersPreviewProperty r219, ButtonProperty r310, IconButtonProperty r311, TextButtonProperty r312, TimeProperty r313, TextProperty r314, TagListProperty r315, SpinButtonProperty r316, AvatarProperty r317, VideoProperty r318, CardContainerProperty r319, DocImageProperty r410, LoadingProperty r411, TimeZoneProperty r412, OversizedTextProperty r413, EngineProperty r414, DocStateButtonProperty r415, ImageContainerProperty r416, ByteString r417) {
        super(ADAPTER, r417);
        if (Internal.countNonNull(r213, r214, r215, r216, new Object[]{r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416}) > 1) goto L7;
        this.type = r110;
        this.can_skip_when_unknown = r111;
        this.style = r210;
        this.child_ids = Internal.immutableCopyOf("child_ids", r211);
        this.is_font_zoomable = r212;
        this.empty = r213;
        this.linear_layout = r214;
        this.flex_layout = r215;
        this.header = r216;
        this.richtext = r217;
        this.image = r218;
        this.chatters_preview = r219;
        this.button = r310;
        this.icon_button = r311;
        this.text_button = r312;
        this.time = r313;
        this.text = r314;
        this.tag_list = r315;
        this.spin_button = r316;
        this.avatar = r317;
        this.video = r318;
        this.card_container = r319;
        this.doc_image = r410;
        this.loading = r411;
        this.time_zone = r412;
        this.oversized_text = r413;
        this.engine = r414;
        this.doc_state_button = r415;
        this.image_container = r416;
        return;
    L7:
        throw new IllegalArgumentException("at most one of empty, linear_layout, flex_layout, header, richtext, image, chatters_preview, button, icon_button, text_button, time, text, tag_list, spin_button, avatar, video, card_container, doc_image, loading, time_zone, oversized_text, engine, doc_state_button, image_container may be non-null");
    }
}
