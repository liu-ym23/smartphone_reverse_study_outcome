package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.ThemeColor;
import com.bytedance.lark.pb.basic.v1.UDIcon;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalChatPinIcon extends Message<UniversalChatPinIcon, Builder> {
    public static final ProtoAdapter<UniversalChatPinIcon> ADAPTER = null;
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final ChatPinIconType DEFAULT_TYPE = null;
    public static final String DEFAULT_UD_ICON = "";
    public static final Boolean DEFAULT_USE_ORIGIN_COLOR = null;
    private static final long serialVersionUID = 0;
    public final ColorIcon color_icon;
    public final String icon_key;
    public final String icon_url;
    public final ImageSetPassThrough image_set_pass_through;
    public final ChatPinIconType type;
    public final String ud_icon;
    public final Boolean use_origin_color;

    public static final class Builder extends Message.Builder<UniversalChatPinIcon, Builder> {
        public ColorIcon color_icon;
        public String icon_key;
        public String icon_url;
        public ImageSetPassThrough image_set_pass_through;
        public ChatPinIconType type;
        public String ud_icon;
        public Boolean use_origin_color;

        @Override // com.squareup.wire.Message.Builder
        public UniversalChatPinIcon build() {
            return new UniversalChatPinIcon(this.type, this.ud_icon, this.icon_key, this.icon_url, this.image_set_pass_through, this.use_origin_color, this.color_icon, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder color_icon(ColorIcon r100) {
            this.color_icon = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder icon_url(String r100) {
            this.icon_url = r100;
            return this;
        }

        public Builder image_set_pass_through(ImageSetPassThrough r100) {
            this.image_set_pass_through = r100;
            return this;
        }

        public Builder type(ChatPinIconType r100) {
            this.type = r100;
            return this;
        }

        public Builder ud_icon(String r100) {
            this.ud_icon = r100;
            return this;
        }

        public Builder use_origin_color(Boolean r100) {
            this.use_origin_color = r100;
            return this;
        }
    }

    public static final enum ChatPinIconType extends Enum<ChatPinIconType> implements WireEnum {
        private static final /* synthetic */ ChatPinIconType[] $VALUES = null;
        public static final ProtoAdapter<ChatPinIconType> ADAPTER = null;
        public static final ChatPinIconType CUSTOM = null;
        public static final ChatPinIconType DOC_TYPE_BITABLE = null;
        public static final ChatPinIconType DOC_TYPE_DOC = null;
        public static final ChatPinIconType DOC_TYPE_DOCX = null;
        public static final ChatPinIconType DOC_TYPE_FILE = null;
        public static final ChatPinIconType DOC_TYPE_MINDNOTE = null;
        public static final ChatPinIconType DOC_TYPE_SHEET = null;
        public static final ChatPinIconType DOC_TYPE_SLIDE = null;
        public static final ChatPinIconType DOC_TYPE_SLIDES = null;
        public static final ChatPinIconType DOC_TYPE_WIKI = null;
        public static final ChatPinIconType TASK_LIST = null;
        public static final ChatPinIconType UNKNOWN = null;
        private final int value;

        static {
            ChatPinIconType r100 = new ChatPinIconType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatPinIconType r101 = new ChatPinIconType("CUSTOM", 1, 1);
            CUSTOM = r101;
            ChatPinIconType r102 = new ChatPinIconType("DOC_TYPE_DOC", 2, 11);
            DOC_TYPE_DOC = r102;
            ChatPinIconType r103 = new ChatPinIconType("DOC_TYPE_SHEET", 3, 12);
            DOC_TYPE_SHEET = r103;
            ChatPinIconType r104 = new ChatPinIconType("DOC_TYPE_BITABLE", 4, 13);
            DOC_TYPE_BITABLE = r104;
            ChatPinIconType r110 = new ChatPinIconType("DOC_TYPE_MINDNOTE", 5, 14);
            DOC_TYPE_MINDNOTE = r110;
            ChatPinIconType r111 = new ChatPinIconType("DOC_TYPE_FILE", 6, 15);
            DOC_TYPE_FILE = r111;
            ChatPinIconType r112 = new ChatPinIconType("DOC_TYPE_SLIDE", 7, 16);
            DOC_TYPE_SLIDE = r112;
            ChatPinIconType r113 = new ChatPinIconType("DOC_TYPE_WIKI", 8, 17);
            DOC_TYPE_WIKI = r113;
            ChatPinIconType r105 = new ChatPinIconType("DOC_TYPE_DOCX", 9, 18);
            DOC_TYPE_DOCX = r105;
            ChatPinIconType r106 = new ChatPinIconType("DOC_TYPE_SLIDES", 10, 19);
            DOC_TYPE_SLIDES = r106;
            ChatPinIconType r107 = new ChatPinIconType("TASK_LIST", 11, 51);
            TASK_LIST = r107;
            $VALUES = new ChatPinIconType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r106, r107};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatPinIconType.class);
        }

        public static ChatPinIconType[] values() {
            return (ChatPinIconType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatPinIconType fromValue(int r100) {
            if (r100 == 0) goto L33;
            if (r100 == 1) goto L31;
            if (r100 == 51) goto L29;
            switch(r100) {
                case 11: goto L27;
                case 12: goto L25;
                case 13: goto L23;
                case 14: goto L21;
                case 15: goto L19;
                case 16: goto L17;
                case 17: goto L15;
                case 18: goto L13;
                case 19: goto L11;
                default: goto L8;
            };
        L8:
            return null;
        L11:
            return DOC_TYPE_SLIDES;
        L13:
            return DOC_TYPE_DOCX;
        L15:
            return DOC_TYPE_WIKI;
        L17:
            return DOC_TYPE_SLIDE;
        L19:
            return DOC_TYPE_FILE;
        L21:
            return DOC_TYPE_MINDNOTE;
        L23:
            return DOC_TYPE_BITABLE;
        L25:
            return DOC_TYPE_SHEET;
        L27:
            return DOC_TYPE_DOC;
        L29:
            return TASK_LIST;
        L31:
            return CUSTOM;
        L33:
            return UNKNOWN;
        }

        public static ChatPinIconType valueOf(String r100) {
            return (ChatPinIconType) a.a(ChatPinIconType.class, r100);
        }

        private ChatPinIconType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ColorIcon extends Message<ColorIcon, Builder> {
        public static final ProtoAdapter<ColorIcon> ADAPTER = null;
        public static final String DEFAULT_FAVICON_URL = "";
        private static final long serialVersionUID = 0;
        public final String favicon_url;
        public final ThemeColor icon_color;
        public final ImageSet image_set;
        public final UDIcon ud_icon;

        public static final class Builder extends Message.Builder<ColorIcon, Builder> {
            public String favicon_url;
            public ThemeColor icon_color;
            public ImageSet image_set;
            public UDIcon ud_icon;

            @Override // com.squareup.wire.Message.Builder
            public ColorIcon build() {
                return new ColorIcon(this.image_set, this.icon_color, this.ud_icon, this.favicon_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder favicon_url(String r100) {
                this.favicon_url = r100;
                return this;
            }

            public Builder icon_color(ThemeColor r100) {
                this.icon_color = r100;
                return this;
            }

            public Builder image_set(ImageSet r100) {
                this.image_set = r100;
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
                r101.image_set = ImageSet.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.icon_color = ThemeColor.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.ud_icon = UDIcon.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.favicon_url = ProtoAdapter.STRING.decode(r100);
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
                ImageSet r101 = r100.image_set;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSet.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ThemeColor r104 = r100.icon_color;
                if (r104 == null) goto L9;
                int r105 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                UDIcon r107 = r100.ud_icon;
                if (r107 == null) goto L13;
                int r108 = UDIcon.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.favicon_url;
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
            public /* bridge */ /* synthetic */ ColorIcon decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ColorIcon r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ColorIcon r101) throws IOException {
                ImageSet r102 = r101.image_set;
                if (r102 == null) goto L5;
                ImageSet.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ThemeColor r103 = r101.icon_color;
                if (r103 == null) goto L8;
                ThemeColor.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                UDIcon r104 = r101.ud_icon;
                if (r104 == null) goto L11;
                UDIcon.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.favicon_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
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
            r100.image_set = this.image_set;
            r100.icon_color = this.icon_color;
            r100.ud_icon = this.ud_icon;
            r100.favicon_url = this.favicon_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ColorIcon.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ColorIcon(ImageSet r100, ThemeColor r101, UDIcon r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ColorIcon(ImageSet r100, ThemeColor r101, UDIcon r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.image_set = r100;
            this.icon_color = r101;
            this.ud_icon = r102;
            this.favicon_url = r103;
        }
    }

    public static final class ProtoAdapter_UniversalChatPinIcon extends ProtoAdapter<UniversalChatPinIcon> {
        public ProtoAdapter_UniversalChatPinIcon() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalChatPinIcon.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalChatPinIcon decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = ChatPinIconType.UNKNOWN;
            r101.ud_icon = "";
            r101.icon_key = "";
            r101.icon_url = "";
            r101.use_origin_color = Boolean.FALSE;
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
            r101.type = ChatPinIconType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.color_icon = ColorIcon.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.use_origin_color = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.image_set_pass_through = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.icon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.ud_icon = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UniversalChatPinIcon r100) {
            ChatPinIconType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ChatPinIconType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.ud_icon;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.icon_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.icon_url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ImageSetPassThrough r113 = r100.image_set_pass_through;
            if (r113 == null) goto L21;
            int r114 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.use_origin_color;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ColorIcon r119 = r100.color_icon;
            if (r119 == null) goto L30;
            r102 = ColorIcon.ADAPTER.encodedSizeWithTag(7, r119);
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
        public /* bridge */ /* synthetic */ UniversalChatPinIcon decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalChatPinIcon r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalChatPinIcon r101) throws IOException {
            ChatPinIconType r102 = r101.type;
            if (r102 == null) goto L5;
            ChatPinIconType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.ud_icon;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.icon_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.icon_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            ImageSetPassThrough r106 = r101.image_set_pass_through;
            if (r106 == null) goto L17;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.use_origin_color;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            ColorIcon r108 = r101.color_icon;
            if (r108 == null) goto L23;
            ColorIcon.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalChatPinIcon r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalChatPinIcon();
        DEFAULT_TYPE = ChatPinIconType.UNKNOWN;
        DEFAULT_USE_ORIGIN_COLOR = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.ud_icon = this.ud_icon;
        r100.icon_key = this.icon_key;
        r100.icon_url = this.icon_url;
        r100.image_set_pass_through = this.image_set_pass_through;
        r100.use_origin_color = this.use_origin_color;
        r100.color_icon = this.color_icon;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalChatPinIcon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalChatPinIcon(ChatPinIconType r110, String r111, String r112, String r113, ImageSetPassThrough r114, Boolean r115, ColorIcon r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public UniversalChatPinIcon(ChatPinIconType r100, String r101, String r102, String r103, ImageSetPassThrough r104, Boolean r105, ColorIcon r106, ByteString r107) {
        super(ADAPTER, r107);
        this.type = r100;
        this.ud_icon = r101;
        this.icon_key = r102;
        this.icon_url = r103;
        this.image_set_pass_through = r104;
        this.use_origin_color = r105;
        this.color_icon = r106;
    }
}
