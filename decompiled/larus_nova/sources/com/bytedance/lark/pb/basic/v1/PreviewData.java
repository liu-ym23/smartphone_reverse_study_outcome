package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PreviewData extends com.squareup.wire.Message<PreviewData, Builder> {
    public static final ProtoAdapter<PreviewData> ADAPTER = null;
    public static final Boolean DEFAULT_B = null;
    public static final Float DEFAULT_F = null;
    public static final Integer DEFAULT_I32 = null;
    public static final Long DEFAULT_I64 = null;
    public static final String DEFAULT_STR = "";
    public static final FieldOptions FIELD_OPTIONS_B = null;
    public static final FieldOptions FIELD_OPTIONS_CHATTER_INFO = null;
    public static final FieldOptions FIELD_OPTIONS_CHATTER_INFOS = null;
    public static final FieldOptions FIELD_OPTIONS_F = null;
    public static final FieldOptions FIELD_OPTIONS_FONT_LEVEL = null;
    public static final FieldOptions FIELD_OPTIONS_I32 = null;
    public static final FieldOptions FIELD_OPTIONS_I64 = null;
    public static final FieldOptions FIELD_OPTIONS_IMAGE_SET = null;
    public static final FieldOptions FIELD_OPTIONS_ITEMS = null;
    public static final FieldOptions FIELD_OPTIONS_LAYOUT_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_PADDING = null;
    public static final FieldOptions FIELD_OPTIONS_STR = null;
    public static final FieldOptions FIELD_OPTIONS_STRING_LIST = null;
    public static final FieldOptions FIELD_OPTIONS_TAG_LIST = null;
    public static final FieldOptions FIELD_OPTIONS_THEME_COLOR = null;
    public static final FieldOptions FIELD_OPTIONS_THEME_COLORS = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f253529b;
    public final URLPreviewComponent.AvatarProperty.ChatterInfo chatter_info;
    public final ChatterInfos chatter_infos;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float f253530f;
    public final URLPreviewComponent.FontLevel font_level;

    /* JADX INFO: renamed from: i32, reason: collision with root package name */
    public final Integer f253531i32;

    /* JADX INFO: renamed from: i64, reason: collision with root package name */
    public final Long f253532i64;
    public final ImageSet image_set;
    public final Items items;
    public final URLPreviewComponent.Value layout_value;
    public final URLPreviewComponent.Padding padding;
    public final String str;
    public final StringList string_list;
    public final TagList tag_list;
    public final ThemeColor theme_color;
    public final ThemeColors theme_colors;

    public static final class Builder extends com.squareup.wire.Message.Builder<PreviewData, Builder> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f253533b;
        public URLPreviewComponent.AvatarProperty.ChatterInfo chatter_info;
        public ChatterInfos chatter_infos;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Float f253534f;
        public URLPreviewComponent.FontLevel font_level;

        /* JADX INFO: renamed from: i32, reason: collision with root package name */
        public Integer f253535i32;

        /* JADX INFO: renamed from: i64, reason: collision with root package name */
        public Long f253536i64;
        public ImageSet image_set;
        public Items items;
        public URLPreviewComponent.Value layout_value;
        public URLPreviewComponent.Padding padding;
        public String str;
        public StringList string_list;
        public TagList tag_list;
        public ThemeColor theme_color;
        public ThemeColors theme_colors;

        @Override // com.squareup.wire.Message.Builder
        public PreviewData build() {
            return new PreviewData(this.str, this.f253535i32, this.f253536i64, this.f253533b, this.f253534f, this.image_set, this.items, this.theme_color, this.padding, this.theme_colors, this.layout_value, this.chatter_infos, this.string_list, this.chatter_info, this.font_level, this.tag_list, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder b(Boolean r100) {
            this.f253533b = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder chatter_info(URLPreviewComponent.AvatarProperty.ChatterInfo r100) {
            this.chatter_info = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder chatter_infos(ChatterInfos r100) {
            this.chatter_infos = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder f(Float r100) {
            this.f253534f = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder font_level(URLPreviewComponent.FontLevel r100) {
            this.font_level = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.tag_list = null;
            return this;
        }

        public Builder i32(Integer r100) {
            this.f253535i32 = r100;
            this.str = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder i64(Long r100) {
            this.f253536i64 = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder image_set(ImageSet r100) {
            this.image_set = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder items(Items r100) {
            this.items = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder layout_value(URLPreviewComponent.Value r100) {
            this.layout_value = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder padding(URLPreviewComponent.Padding r100) {
            this.padding = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder str(String r100) {
            this.str = r100;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder string_list(StringList r100) {
            this.string_list = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder tag_list(TagList r100) {
            this.tag_list = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            return this;
        }

        public Builder theme_color(ThemeColor r100) {
            this.theme_color = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.padding = null;
            this.theme_colors = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }

        public Builder theme_colors(ThemeColors r100) {
            this.theme_colors = r100;
            this.str = null;
            this.f253535i32 = null;
            this.f253536i64 = null;
            this.f253533b = null;
            this.f253534f = null;
            this.image_set = null;
            this.items = null;
            this.theme_color = null;
            this.padding = null;
            this.layout_value = null;
            this.chatter_infos = null;
            this.string_list = null;
            this.chatter_info = null;
            this.font_level = null;
            this.tag_list = null;
            return this;
        }
    }

    public static final class ChatterInfos extends com.squareup.wire.Message<ChatterInfos, Builder> {
        public static final ProtoAdapter<ChatterInfos> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> chatter_infos;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatterInfos, Builder> {
            public List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> chatter_infos;

            @Override // com.squareup.wire.Message.Builder
            public ChatterInfos build() {
                return new ChatterInfos(this.chatter_infos, super.buildUnknownFields());
            }

            public Builder() {
                this.chatter_infos = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_infos(List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatter_infos = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterInfos extends ProtoAdapter<ChatterInfos> {
            public ProtoAdapter_ChatterInfos() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterInfos.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatterInfos decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.chatter_infos.add(URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.decode(r100));
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
            public int encodedSize2(ChatterInfos r100) {
                return URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chatter_infos) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatterInfos decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatterInfos r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatterInfos r101) throws IOException {
                URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chatter_infos);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterInfos r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterInfos();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_infos = Internal.copyOf("chatter_infos", this.chatter_infos);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatterInfos.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatterInfos(List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ChatterInfos(List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.chatter_infos = Internal.immutableCopyOf("chatter_infos", r100);
        }
    }

    public static final class Items extends com.squareup.wire.Message<Items, Builder> {
        public static final ProtoAdapter<Items> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<URLPreviewComponent.Item> items;

        public static final class Builder extends com.squareup.wire.Message.Builder<Items, Builder> {
            public List<URLPreviewComponent.Item> items;

            @Override // com.squareup.wire.Message.Builder
            public Items build() {
                return new Items(this.items, super.buildUnknownFields());
            }

            public Builder() {
                this.items = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder items(List<URLPreviewComponent.Item> r100) {
                Internal.checkElementsNotNull(r100);
                this.items = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Items extends ProtoAdapter<Items> {
            public ProtoAdapter_Items() {
                super(FieldEncoding.LENGTH_DELIMITED, Items.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Items decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.items.add(URLPreviewComponent.Item.ADAPTER.decode(r100));
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
            public int encodedSize2(Items r100) {
                return URLPreviewComponent.Item.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.items) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Items decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Items r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Items r101) throws IOException {
                URLPreviewComponent.Item.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.items);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Items r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Items();
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
            return Items.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Items(List<URLPreviewComponent.Item> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Items(List<URLPreviewComponent.Item> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.items = Internal.immutableCopyOf("items", r100);
        }
    }

    public static final class ProtoAdapter_PreviewData extends ProtoAdapter<PreviewData> {
        public ProtoAdapter_PreviewData() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreviewData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.str("");
            r101.i32(0);
            r101.i64(0L);
            r101.b(Boolean.FALSE);
            r101.f(Float.valueOf(0.0f));
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r101.tag_list(TagList.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.font_level(URLPreviewComponent.FontLevel.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.chatter_info(URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.string_list(StringList.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.chatter_infos(ChatterInfos.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.layout_value(URLPreviewComponent.Value.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.theme_colors(ThemeColors.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.padding(URLPreviewComponent.Padding.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.theme_color(ThemeColor.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.items(Items.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.image_set(ImageSet.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.f(ProtoAdapter.FLOAT.decode(r100));
            goto L3
        L19:
            r101.b(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L20:
            r101.i64(ProtoAdapter.INT64.decode(r100));
            goto L3
        L21:
            r101.i32(ProtoAdapter.INT32.decode(r100));
            goto L3
        L22:
            r101.str(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PreviewData r100) {
            String r101 = r100.str;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.f253531i32;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.f253532i64;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.f253529b;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Float r113 = r100.f253530f;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.FLOAT.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ImageSet r116 = r100.image_set;
            if (r116 == null) goto L25;
            int r117 = ImageSet.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Items r119 = r100.items;
            if (r119 == null) goto L29;
            int r120 = Items.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            ThemeColor r122 = r100.theme_color;
            if (r122 == null) goto L33;
            int r123 = ThemeColor.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            URLPreviewComponent.Padding r125 = r100.padding;
            if (r125 == null) goto L37;
            int r126 = URLPreviewComponent.Padding.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            ThemeColors r128 = r100.theme_colors;
            if (r128 == null) goto L41;
            int r129 = ThemeColors.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            URLPreviewComponent.Value r131 = r100.layout_value;
            if (r131 == null) goto L45;
            int r132 = URLPreviewComponent.Value.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            ChatterInfos r134 = r100.chatter_infos;
            if (r134 == null) goto L49;
            int r135 = ChatterInfos.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            StringList r137 = r100.string_list;
            if (r137 == null) goto L53;
            int r138 = StringList.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            URLPreviewComponent.AvatarProperty.ChatterInfo r140 = r100.chatter_info;
            if (r140 == null) goto L57;
            int r141 = URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            URLPreviewComponent.FontLevel r143 = r100.font_level;
            if (r143 == null) goto L61;
            int r144 = URLPreviewComponent.FontLevel.ADAPTER.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            TagList r146 = r100.tag_list;
            if (r146 == null) goto L66;
            r102 = TagList.ADAPTER.encodedSizeWithTag(16, r146);
        L66:
            return (r145 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PreviewData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreviewData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreviewData r101) throws IOException {
            String r102 = r101.str;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.f253531i32;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.f253532i64;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.f253529b;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Float r106 = r101.f253530f;
            if (r106 == null) goto L17;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 5, r106);
        L17:
            ImageSet r107 = r101.image_set;
            if (r107 == null) goto L20;
            ImageSet.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Items r108 = r101.items;
            if (r108 == null) goto L23;
            Items.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            ThemeColor r109 = r101.theme_color;
            if (r109 == null) goto L26;
            ThemeColor.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            URLPreviewComponent.Padding r110 = r101.padding;
            if (r110 == null) goto L29;
            URLPreviewComponent.Padding.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            ThemeColors r111 = r101.theme_colors;
            if (r111 == null) goto L32;
            ThemeColors.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            URLPreviewComponent.Value r112 = r101.layout_value;
            if (r112 == null) goto L35;
            URLPreviewComponent.Value.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            ChatterInfos r113 = r101.chatter_infos;
            if (r113 == null) goto L38;
            ChatterInfos.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            StringList r114 = r101.string_list;
            if (r114 == null) goto L41;
            StringList.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            URLPreviewComponent.AvatarProperty.ChatterInfo r115 = r101.chatter_info;
            if (r115 == null) goto L44;
            URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.encodeWithTag(r100, 14, r115);
        L44:
            URLPreviewComponent.FontLevel r116 = r101.font_level;
            if (r116 == null) goto L47;
            URLPreviewComponent.FontLevel.ADAPTER.encodeWithTag(r100, 15, r116);
        L47:
            TagList r117 = r101.tag_list;
            if (r117 == null) goto L50;
            TagList.ADAPTER.encodeWithTag(r100, 16, r117);
        L50:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class StringList extends com.squareup.wire.Message<StringList, Builder> {
        public static final ProtoAdapter<StringList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> string_list;

        public static final class Builder extends com.squareup.wire.Message.Builder<StringList, Builder> {
            public List<String> string_list;

            @Override // com.squareup.wire.Message.Builder
            public StringList build() {
                return new StringList(this.string_list, super.buildUnknownFields());
            }

            public Builder() {
                this.string_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder string_list(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.string_list = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StringList extends ProtoAdapter<StringList> {
            public ProtoAdapter_StringList() {
                super(FieldEncoding.LENGTH_DELIMITED, StringList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StringList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.string_list.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(StringList r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.string_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StringList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StringList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StringList r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.string_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StringList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StringList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.string_list = Internal.copyOf("string_list", this.string_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StringList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public StringList(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public StringList(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.string_list = Internal.immutableCopyOf("string_list", r100);
        }
    }

    public static final class TagList extends com.squareup.wire.Message<TagList, Builder> {
        public static final ProtoAdapter<TagList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<URLPreviewComponent.TagListProperty.Tag> mixed_tags;

        public static final class Builder extends com.squareup.wire.Message.Builder<TagList, Builder> {
            public List<URLPreviewComponent.TagListProperty.Tag> mixed_tags;

            @Override // com.squareup.wire.Message.Builder
            public TagList build() {
                return new TagList(this.mixed_tags, super.buildUnknownFields());
            }

            public Builder() {
                this.mixed_tags = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder mixed_tags(List<URLPreviewComponent.TagListProperty.Tag> r100) {
                Internal.checkElementsNotNull(r100);
                this.mixed_tags = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TagList extends ProtoAdapter<TagList> {
            public ProtoAdapter_TagList() {
                super(FieldEncoding.LENGTH_DELIMITED, TagList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TagList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mixed_tags.add(URLPreviewComponent.TagListProperty.Tag.ADAPTER.decode(r100));
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
            public int encodedSize2(TagList r100) {
                return URLPreviewComponent.TagListProperty.Tag.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mixed_tags) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TagList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TagList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TagList r101) throws IOException {
                URLPreviewComponent.TagListProperty.Tag.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mixed_tags);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TagList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mixed_tags = Internal.copyOf("mixed_tags", this.mixed_tags);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TagList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TagList(List<URLPreviewComponent.TagListProperty.Tag> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TagList(List<URLPreviewComponent.TagListProperty.Tag> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mixed_tags = Internal.immutableCopyOf("mixed_tags", r100);
        }
    }

    public static final class ThemeColors extends com.squareup.wire.Message<ThemeColors, Builder> {
        public static final ProtoAdapter<ThemeColors> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<ThemeColor> colors;

        public static final class Builder extends com.squareup.wire.Message.Builder<ThemeColors, Builder> {
            public List<ThemeColor> colors;

            @Override // com.squareup.wire.Message.Builder
            public ThemeColors build() {
                return new ThemeColors(this.colors, super.buildUnknownFields());
            }

            public Builder() {
                this.colors = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder colors(List<ThemeColor> r100) {
                Internal.checkElementsNotNull(r100);
                this.colors = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThemeColors extends ProtoAdapter<ThemeColors> {
            public ProtoAdapter_ThemeColors() {
                super(FieldEncoding.LENGTH_DELIMITED, ThemeColors.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThemeColors decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.colors.add(ThemeColor.ADAPTER.decode(r100));
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
            public int encodedSize2(ThemeColors r100) {
                return ThemeColor.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.colors) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThemeColors decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThemeColors r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThemeColors r101) throws IOException {
                ThemeColor.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.colors);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThemeColors r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThemeColors();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.colors = Internal.copyOf("colors", this.colors);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThemeColors.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThemeColors(List<ThemeColor> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ThemeColors(List<ThemeColor> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.colors = Internal.immutableCopyOf("colors", r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewData();
        FIELD_OPTIONS_STR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_I32 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_I64 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_B = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_F = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IMAGE_SET = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ITEMS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_THEME_COLOR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_PADDING = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_THEME_COLORS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_LAYOUT_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CHATTER_INFOS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_STRING_LIST = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CHATTER_INFO = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_FONT_LEVEL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TAG_LIST = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_I32 = 0;
        DEFAULT_I64 = 0L;
        DEFAULT_B = Boolean.FALSE;
        DEFAULT_F = Float.valueOf(0.0f);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.str = this.str;
        r100.f253535i32 = this.f253531i32;
        r100.f253536i64 = this.f253532i64;
        r100.f253533b = this.f253529b;
        r100.f253534f = this.f253530f;
        r100.image_set = this.image_set;
        r100.items = this.items;
        r100.theme_color = this.theme_color;
        r100.padding = this.padding;
        r100.theme_colors = this.theme_colors;
        r100.layout_value = this.layout_value;
        r100.chatter_infos = this.chatter_infos;
        r100.string_list = this.string_list;
        r100.chatter_info = this.chatter_info;
        r100.font_level = this.font_level;
        r100.tag_list = this.tag_list;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreviewData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreviewData(String r110, Integer r210, Long r211, Boolean r212, Float r213, ImageSet r214, Items r215, ThemeColor r216, URLPreviewComponent.Padding r217, ThemeColors r218, URLPreviewComponent.Value r219, ChatterInfos r310, StringList r311, URLPreviewComponent.AvatarProperty.ChatterInfo r312, URLPreviewComponent.FontLevel r313, TagList r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public PreviewData(String r110, Integer r111, Long r210, Boolean r211, Float r212, ImageSet r213, Items r214, ThemeColor r215, URLPreviewComponent.Padding r216, ThemeColors r217, URLPreviewComponent.Value r218, ChatterInfos r219, StringList r310, URLPreviewComponent.AvatarProperty.ChatterInfo r311, URLPreviewComponent.FontLevel r312, TagList r313, ByteString r314) {
        super(ADAPTER, r314);
        if (Internal.countNonNull(r110, r111, r210, r211, new Object[]{r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313}) > 1) goto L7;
        this.str = r110;
        this.f253531i32 = r111;
        this.f253532i64 = r210;
        this.f253529b = r211;
        this.f253530f = r212;
        this.image_set = r213;
        this.items = r214;
        this.theme_color = r215;
        this.padding = r216;
        this.theme_colors = r217;
        this.layout_value = r218;
        this.chatter_infos = r219;
        this.string_list = r310;
        this.chatter_info = r311;
        this.font_level = r312;
        this.tag_list = r313;
        return;
    L7:
        throw new IllegalArgumentException("at most one of str, i32, i64, b, f, image_set, items, theme_color, padding, theme_colors, layout_value, chatter_infos, string_list, chatter_info, font_level, tag_list may be non-null");
    }
}
