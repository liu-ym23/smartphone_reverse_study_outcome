package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class NavigationAppInfo extends com.squareup.wire.Message<NavigationAppInfo, Builder> {
    public static final ProtoAdapter<NavigationAppInfo> ADAPTER = null;
    public static final NavigationAppType DEFAULT_APPTYPE = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final Boolean DEFAULT_ERASABLE = null;
    public static final Integer DEFAULT_EXPIRES = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_KEY = "";
    public static final NavigationOpenMode DEFAULT_OPEN_MODE = null;
    public static final Boolean DEFAULT_PRIMARY_ONLY = null;
    public static final NavigationSource DEFAULT_SOURCE = null;
    public static final String DEFAULT_SUBTITLE = "";
    public static final String DEFAULT_UNIQUE_ID = "";
    public static final Boolean DEFAULT_UNMOVABLE = null;
    private static final long serialVersionUID = 0;
    public final NavigationAppType appType;
    public final String display_name;
    public final Boolean erasable;
    public final Integer expires;
    public final Map<String, String> extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253521id;
    public final String key;
    public final Logo logo;
    public final Map<String, String> name;
    public final NavigationOpenMode open_mode;
    public final List<PlatformInfo> platforms;
    public final Boolean primary_only;
    public final NavigationSource source;
    public final String subtitle;
    public final String unique_id;
    public final Boolean unmovable;

    public static final enum BizType extends Enum<BizType> implements WireEnum {
        private static final /* synthetic */ BizType[] $VALUES = null;
        public static final ProtoAdapter<BizType> ADAPTER = null;
        public static final BizType CCM = null;
        public static final BizType MEEGO = null;
        public static final BizType MINI_APP = null;
        public static final BizType PROFILE = null;
        public static final BizType UNKNOWN_TYPE = null;
        public static final BizType WEB = null;
        public static final BizType WEB_APP = null;
        private final int value;

        static {
            BizType r100 = new BizType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            BizType r101 = new BizType("CCM", 1, 1);
            CCM = r101;
            BizType r102 = new BizType("MINI_APP", 2, 2);
            MINI_APP = r102;
            BizType r103 = new BizType("WEB_APP", 3, 3);
            WEB_APP = r103;
            BizType r104 = new BizType("MEEGO", 4, 4);
            MEEGO = r104;
            BizType r105 = new BizType("WEB", 5, 5);
            WEB = r105;
            BizType r110 = new BizType("PROFILE", 6, 6);
            PROFILE = r110;
            $VALUES = new BizType[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(BizType.class);
        }

        public static BizType[] values() {
            return (BizType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BizType fromValue(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return PROFILE;
        L8:
            return WEB;
        L10:
            return MEEGO;
        L12:
            return WEB_APP;
        L14:
            return MINI_APP;
        L16:
            return CCM;
        L18:
            return UNKNOWN_TYPE;
        }

        public static BizType valueOf(String r100) {
            return (BizType) a.a(BizType.class, r100);
        }

        private BizType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<NavigationAppInfo, Builder> {
        public NavigationAppType appType;
        public String display_name;
        public Boolean erasable;
        public Integer expires;
        public Map<String, String> extra;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253522id;
        public String key;
        public Logo logo;
        public Map<String, String> name;
        public NavigationOpenMode open_mode;
        public List<PlatformInfo> platforms;
        public Boolean primary_only;
        public NavigationSource source;
        public String subtitle;
        public String unique_id;
        public Boolean unmovable;

        @Override // com.squareup.wire.Message.Builder
        public NavigationAppInfo build() {
            String r100 = this.key;
            if (r100 == null) goto L9;
            if (this.appType == null) goto L9;
            return new NavigationAppInfo(this.f253522id, this.key, this.appType, this.name, this.logo, this.platforms, this.extra, this.expires, this.unique_id, this.primary_only, this.unmovable, this.erasable, this.open_mode, this.source, this.display_name, this.subtitle, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.appType, "appType"});
        }

        public Builder() {
            this.name = Internal.newMutableMap();
            this.platforms = Internal.newMutableList();
            this.extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder appType(NavigationAppType r100) {
            this.appType = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder erasable(Boolean r100) {
            this.erasable = r100;
            return this;
        }

        public Builder expires(Integer r100) {
            this.expires = r100;
            return this;
        }

        public Builder extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253522id = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder logo(Logo r100) {
            this.logo = r100;
            return this;
        }

        public Builder name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.name = r100;
            return this;
        }

        public Builder open_mode(NavigationOpenMode r100) {
            this.open_mode = r100;
            return this;
        }

        public Builder platforms(List<PlatformInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.platforms = r100;
            return this;
        }

        public Builder primary_only(Boolean r100) {
            this.primary_only = r100;
            return this;
        }

        public Builder source(NavigationSource r100) {
            this.source = r100;
            return this;
        }

        public Builder subtitle(String r100) {
            this.subtitle = r100;
            return this;
        }

        public Builder unique_id(String r100) {
            this.unique_id = r100;
            return this;
        }

        public Builder unmovable(Boolean r100) {
            this.unmovable = r100;
            return this;
        }
    }

    public static final class CustomNavigationAppLogo extends com.squareup.wire.Message<CustomNavigationAppLogo, Builder> {
        public static final ProtoAdapter<CustomNavigationAppLogo> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final CustomNavigationAppLogoType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final CustomNavigationAppLogoType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<CustomNavigationAppLogo, Builder> {
            public String content;
            public CustomNavigationAppLogoType type;

            @Override // com.squareup.wire.Message.Builder
            public CustomNavigationAppLogo build() {
                return new CustomNavigationAppLogo(this.content, this.type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder type(CustomNavigationAppLogoType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomNavigationAppLogo extends ProtoAdapter<CustomNavigationAppLogo> {
            public ProtoAdapter_CustomNavigationAppLogo() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomNavigationAppLogo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomNavigationAppLogo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.type = CustomNavigationAppLogoType.APP_LOGO_TYPE_UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.type = CustomNavigationAppLogoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(CustomNavigationAppLogo r100) {
                String r101 = r100.content;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                CustomNavigationAppLogoType r104 = r100.type;
                if (r104 == null) goto L10;
                r102 = CustomNavigationAppLogoType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CustomNavigationAppLogo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomNavigationAppLogo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomNavigationAppLogo r101) throws IOException {
                String r102 = r101.content;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                CustomNavigationAppLogoType r103 = r101.type;
                if (r103 == null) goto L8;
                CustomNavigationAppLogoType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomNavigationAppLogo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomNavigationAppLogo();
            DEFAULT_TYPE = CustomNavigationAppLogoType.APP_LOGO_TYPE_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.type = this.type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomNavigationAppLogo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomNavigationAppLogo(String r100, CustomNavigationAppLogoType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CustomNavigationAppLogo(String r100, CustomNavigationAppLogoType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.content = r100;
            this.type = r101;
        }
    }

    public static final enum CustomNavigationAppLogoType extends Enum<CustomNavigationAppLogoType> implements WireEnum {
        private static final /* synthetic */ CustomNavigationAppLogoType[] $VALUES = null;
        public static final ProtoAdapter<CustomNavigationAppLogoType> ADAPTER = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_AVATAR = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_CCM_ICON = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_IMAGE_KEY = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_UD_TOKEN = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_UNKNOWN = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_URL = null;
        private final int value;

        static {
            CustomNavigationAppLogoType r100 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_UNKNOWN", 0, 0);
            APP_LOGO_TYPE_UNKNOWN = r100;
            CustomNavigationAppLogoType r101 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_UD_TOKEN", 1, 1);
            APP_LOGO_TYPE_UD_TOKEN = r101;
            CustomNavigationAppLogoType r102 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_URL", 2, 2);
            APP_LOGO_TYPE_URL = r102;
            CustomNavigationAppLogoType r103 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_IMAGE_KEY", 3, 3);
            APP_LOGO_TYPE_IMAGE_KEY = r103;
            CustomNavigationAppLogoType r104 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_CCM_ICON", 4, 4);
            APP_LOGO_TYPE_CCM_ICON = r104;
            CustomNavigationAppLogoType r105 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_AVATAR", 5, 5);
            APP_LOGO_TYPE_AVATAR = r105;
            $VALUES = new CustomNavigationAppLogoType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(CustomNavigationAppLogoType.class);
        }

        public static CustomNavigationAppLogoType[] values() {
            return (CustomNavigationAppLogoType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CustomNavigationAppLogoType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return APP_LOGO_TYPE_AVATAR;
        L18:
            return APP_LOGO_TYPE_CCM_ICON;
        L20:
            return APP_LOGO_TYPE_IMAGE_KEY;
        L22:
            return APP_LOGO_TYPE_URL;
        L24:
            return APP_LOGO_TYPE_UD_TOKEN;
        L26:
            return APP_LOGO_TYPE_UNKNOWN;
        }

        public static CustomNavigationAppLogoType valueOf(String r100) {
            return (CustomNavigationAppLogoType) a.a(CustomNavigationAppLogoType.class, r100);
        }

        private CustomNavigationAppLogoType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Logo extends com.squareup.wire.Message<Logo, Builder> {
        public static final ProtoAdapter<Logo> ADAPTER = null;
        public static final LogoStyle DEFAULT_LOGO_STYLE = null;
        public static final String DEFAULT_MOBILE_PRIMARY_DEFAULT_PNG = "";
        public static final String DEFAULT_MOBILE_PRIMARY_SELECTED_PNG = "";
        public static final String DEFAULT_PC_PRIMARY_COLOR_SVG = "";
        public static final String DEFAULT_PRIMARY_COLOR_PNG = "";
        public static final String DEFAULT_PRIMARY_DEFAULT = "";
        public static final String DEFAULT_PRIMARY_DEFAULT_SVG = "";
        public static final String DEFAULT_PRIMARY_SELECTED = "";
        public static final String DEFAULT_SHORTCUT_DEFAULT = "";
        private static final long serialVersionUID = 0;
        public final CustomNavigationAppLogo custom_navigation_app_logo;
        public final LogoStyle logo_style;
        public final String mobile_primary_default_png;
        public final String mobile_primary_selected_png;
        public final String pc_primary_color_svg;
        public final String primary_color_png;
        public final String primary_default;
        public final String primary_default_svg;
        public final String primary_selected;
        public final String shortcut_default;

        public static final class Builder extends com.squareup.wire.Message.Builder<Logo, Builder> {
            public CustomNavigationAppLogo custom_navigation_app_logo;
            public LogoStyle logo_style;
            public String mobile_primary_default_png;
            public String mobile_primary_selected_png;
            public String pc_primary_color_svg;
            public String primary_color_png;
            public String primary_default;
            public String primary_default_svg;
            public String primary_selected;
            public String shortcut_default;

            @Override // com.squareup.wire.Message.Builder
            public Logo build() {
                return new Logo(this.primary_default, this.primary_selected, this.shortcut_default, this.primary_default_svg, this.primary_color_png, this.pc_primary_color_svg, this.mobile_primary_default_png, this.mobile_primary_selected_png, this.custom_navigation_app_logo, this.logo_style, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder custom_navigation_app_logo(CustomNavigationAppLogo r100) {
                this.custom_navigation_app_logo = r100;
                return this;
            }

            public Builder logo_style(LogoStyle r100) {
                this.logo_style = r100;
                return this;
            }

            public Builder mobile_primary_default_png(String r100) {
                this.mobile_primary_default_png = r100;
                return this;
            }

            public Builder mobile_primary_selected_png(String r100) {
                this.mobile_primary_selected_png = r100;
                return this;
            }

            public Builder pc_primary_color_svg(String r100) {
                this.pc_primary_color_svg = r100;
                return this;
            }

            public Builder primary_color_png(String r100) {
                this.primary_color_png = r100;
                return this;
            }

            public Builder primary_default(String r100) {
                this.primary_default = r100;
                return this;
            }

            public Builder primary_default_svg(String r100) {
                this.primary_default_svg = r100;
                return this;
            }

            public Builder primary_selected(String r100) {
                this.primary_selected = r100;
                return this;
            }

            public Builder shortcut_default(String r100) {
                this.shortcut_default = r100;
                return this;
            }
        }

        public static final enum LogoStyle extends Enum<LogoStyle> implements WireEnum {
            private static final /* synthetic */ LogoStyle[] $VALUES = null;
            public static final ProtoAdapter<LogoStyle> ADAPTER = null;
            public static final LogoStyle Background = null;
            public static final LogoStyle Fill = null;
            public static final LogoStyle Unknown = null;
            private final int value;

            static {
                LogoStyle r100 = new LogoStyle("Unknown", 0, 0);
                Unknown = r100;
                LogoStyle r101 = new LogoStyle("Fill", 1, 1);
                Fill = r101;
                LogoStyle r102 = new LogoStyle("Background", 2, 2);
                Background = r102;
                $VALUES = new LogoStyle[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(LogoStyle.class);
            }

            public static LogoStyle[] values() {
                return (LogoStyle[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static LogoStyle fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return Background;
            L12:
                return Fill;
            L14:
                return Unknown;
            }

            public static LogoStyle valueOf(String r100) {
                return (LogoStyle) a.a(LogoStyle.class, r100);
            }

            private LogoStyle(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_Logo extends ProtoAdapter<Logo> {
            public ProtoAdapter_Logo() {
                super(FieldEncoding.LENGTH_DELIMITED, Logo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Logo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.primary_default = "";
                r101.primary_selected = "";
                r101.shortcut_default = "";
                r101.primary_default_svg = "";
                r101.primary_color_png = "";
                r101.pc_primary_color_svg = "";
                r101.mobile_primary_default_png = "";
                r101.mobile_primary_selected_png = "";
                r101.logo_style = LogoStyle.Unknown;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L20;
                switch(r103) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    case 10: goto L22;
                    default: goto L6;
                };
            L22:
                r101.logo_style = LogoStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.custom_navigation_app_logo = CustomNavigationAppLogo.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.mobile_primary_selected_png = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.mobile_primary_default_png = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.pc_primary_color_svg = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.primary_color_png = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.primary_default_svg = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.shortcut_default = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.primary_selected = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.primary_default = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L20:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Logo r100) {
                String r101 = r100.primary_default;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.primary_selected;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.shortcut_default;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.primary_default_svg;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.primary_color_png;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.pc_primary_color_svg;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.mobile_primary_default_png;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.mobile_primary_selected_png;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                CustomNavigationAppLogo r125 = r100.custom_navigation_app_logo;
                if (r125 == null) goto L37;
                int r126 = CustomNavigationAppLogo.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                LogoStyle r128 = r100.logo_style;
                if (r128 == null) goto L42;
                r102 = LogoStyle.ADAPTER.encodedSizeWithTag(10, r128);
            L42:
                return (r127 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Logo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Logo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Logo r101) throws IOException {
                String r102 = r101.primary_default;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.primary_selected;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.shortcut_default;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.primary_default_svg;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.primary_color_png;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.pc_primary_color_svg;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.mobile_primary_default_png;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.mobile_primary_selected_png;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
            L26:
                CustomNavigationAppLogo r110 = r101.custom_navigation_app_logo;
                if (r110 == null) goto L29;
                CustomNavigationAppLogo.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                LogoStyle r111 = r101.logo_style;
                if (r111 == null) goto L32;
                LogoStyle.ADAPTER.encodeWithTag(r100, 10, r111);
            L32:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Logo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Logo();
            DEFAULT_LOGO_STYLE = LogoStyle.Unknown;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.primary_default = this.primary_default;
            r100.primary_selected = this.primary_selected;
            r100.shortcut_default = this.shortcut_default;
            r100.primary_default_svg = this.primary_default_svg;
            r100.primary_color_png = this.primary_color_png;
            r100.pc_primary_color_svg = this.pc_primary_color_svg;
            r100.mobile_primary_default_png = this.mobile_primary_default_png;
            r100.mobile_primary_selected_png = this.mobile_primary_selected_png;
            r100.custom_navigation_app_logo = this.custom_navigation_app_logo;
            r100.logo_style = this.logo_style;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Logo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Logo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, CustomNavigationAppLogo r211, LogoStyle r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public Logo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, CustomNavigationAppLogo r110, LogoStyle r111, ByteString r112) {
            super(ADAPTER, r112);
            this.primary_default = r100;
            this.primary_selected = r101;
            this.shortcut_default = r102;
            this.primary_default_svg = r103;
            this.primary_color_png = r104;
            this.pc_primary_color_svg = r105;
            this.mobile_primary_default_png = r106;
            this.mobile_primary_selected_png = r107;
            this.custom_navigation_app_logo = r110;
            this.logo_style = r111;
        }
    }

    public static final enum NavigationOpenMode extends Enum<NavigationOpenMode> implements WireEnum {
        private static final /* synthetic */ NavigationOpenMode[] $VALUES = null;
        public static final ProtoAdapter<NavigationOpenMode> ADAPTER = null;
        public static final NavigationOpenMode PUSH_MODE = null;
        public static final NavigationOpenMode SWITCH_MODE = null;
        public static final NavigationOpenMode UNKNOWN_MODE = null;
        private final int value;

        static {
            NavigationOpenMode r100 = new NavigationOpenMode("UNKNOWN_MODE", 0, 0);
            UNKNOWN_MODE = r100;
            NavigationOpenMode r101 = new NavigationOpenMode("SWITCH_MODE", 1, 1);
            SWITCH_MODE = r101;
            NavigationOpenMode r102 = new NavigationOpenMode("PUSH_MODE", 2, 2);
            PUSH_MODE = r102;
            $VALUES = new NavigationOpenMode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(NavigationOpenMode.class);
        }

        public static NavigationOpenMode[] values() {
            return (NavigationOpenMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NavigationOpenMode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PUSH_MODE;
        L12:
            return SWITCH_MODE;
        L14:
            return UNKNOWN_MODE;
        }

        public static NavigationOpenMode valueOf(String r100) {
            return (NavigationOpenMode) a.a(NavigationOpenMode.class, r100);
        }

        private NavigationOpenMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum NavigationSource extends Enum<NavigationSource> implements WireEnum {
        private static final /* synthetic */ NavigationSource[] $VALUES = null;
        public static final ProtoAdapter<NavigationSource> ADAPTER = null;
        public static final NavigationSource SOURCE_UNKNOWN = null;
        public static final NavigationSource TENANT_SOURCE = null;
        public static final NavigationSource USER_SOURCE = null;
        private final int value;

        static {
            NavigationSource r100 = new NavigationSource("SOURCE_UNKNOWN", 0, 0);
            SOURCE_UNKNOWN = r100;
            NavigationSource r101 = new NavigationSource("TENANT_SOURCE", 1, 1);
            TENANT_SOURCE = r101;
            NavigationSource r102 = new NavigationSource("USER_SOURCE", 2, 2);
            USER_SOURCE = r102;
            $VALUES = new NavigationSource[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(NavigationSource.class);
        }

        public static NavigationSource[] values() {
            return (NavigationSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NavigationSource fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return USER_SOURCE;
        L12:
            return TENANT_SOURCE;
        L14:
            return SOURCE_UNKNOWN;
        }

        public static NavigationSource valueOf(String r100) {
            return (NavigationSource) a.a(NavigationSource.class, r100);
        }

        private NavigationSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Platform extends Enum<Platform> implements WireEnum {
        private static final /* synthetic */ Platform[] $VALUES = null;
        public static final ProtoAdapter<Platform> ADAPTER = null;
        public static final Platform Android = null;
        public static final Platform Harmony = null;
        public static final Platform IPad = null;
        public static final Platform IPhone = null;
        public static final Platform Linux = null;
        public static final Platform Mac = null;
        public static final Platform Unknown = null;
        public static final Platform Windows = null;
        private final int value;

        static {
            Platform r100 = new Platform("Unknown", 0, 0);
            Unknown = r100;
            Platform r101 = new Platform("Mac", 1, 1);
            Mac = r101;
            Platform r102 = new Platform("Windows", 2, 2);
            Windows = r102;
            Platform r103 = new Platform("Android", 3, 3);
            Android = r103;
            Platform r104 = new Platform("IPhone", 4, 4);
            IPhone = r104;
            Platform r105 = new Platform("IPad", 5, 5);
            IPad = r105;
            Platform r110 = new Platform("Linux", 6, 6);
            Linux = r110;
            Platform r111 = new Platform("Harmony", 7, 7);
            Harmony = r111;
            $VALUES = new Platform[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Platform.class);
        }

        public static Platform[] values() {
            return (Platform[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Platform fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return Harmony;
        L8:
            return Linux;
        L10:
            return IPad;
        L12:
            return IPhone;
        L14:
            return Android;
        L16:
            return Windows;
        L18:
            return Mac;
        L20:
            return Unknown;
        }

        public static Platform valueOf(String r100) {
            return (Platform) a.a(Platform.class, r100);
        }

        private Platform(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class PlatformInfo extends com.squareup.wire.Message<PlatformInfo, Builder> {
        public static final ProtoAdapter<PlatformInfo> ADAPTER = null;
        public static final Platform DEFAULT_PLATFORM = null;
        private static final long serialVersionUID = 0;
        public final Version min_version;
        public final Platform platform;

        public static final class Builder extends com.squareup.wire.Message.Builder<PlatformInfo, Builder> {
            public Version min_version;
            public Platform platform;

            @Override // com.squareup.wire.Message.Builder
            public PlatformInfo build() {
                return new PlatformInfo(this.platform, this.min_version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder min_version(Version r100) {
                this.min_version = r100;
                return this;
            }

            public Builder platform(Platform r100) {
                this.platform = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PlatformInfo extends ProtoAdapter<PlatformInfo> {
            public ProtoAdapter_PlatformInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PlatformInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PlatformInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.platform = Platform.Unknown;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.platform = Platform.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.min_version = Version.ADAPTER.decode(r100);
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
            public int encodedSize2(PlatformInfo r100) {
                Platform r101 = r100.platform;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Platform.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Version r104 = r100.min_version;
                if (r104 == null) goto L10;
                r102 = Version.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PlatformInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PlatformInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PlatformInfo r101) throws IOException {
                Platform r102 = r101.platform;
                if (r102 == null) goto L5;
                Platform.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Version r103 = r101.min_version;
                if (r103 == null) goto L8;
                Version.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PlatformInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PlatformInfo();
            DEFAULT_PLATFORM = Platform.Unknown;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.platform = this.platform;
            r100.min_version = this.min_version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PlatformInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PlatformInfo(Platform r100, Version r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public PlatformInfo(Platform r100, Version r101, ByteString r102) {
            super(ADAPTER, r102);
            this.platform = r100;
            this.min_version = r101;
        }
    }

    public static final class ProtoAdapter_NavigationAppInfo extends ProtoAdapter<NavigationAppInfo> {
        private final ProtoAdapter<Map<String, String>> extra;
        private final ProtoAdapter<Map<String, String>> name;

        public ProtoAdapter_NavigationAppInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, NavigationAppInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.name = ProtoAdapter.newMapAdapter(r100, r100);
            this.extra = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NavigationAppInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253522id = 0L;
            r101.key = "";
            r101.appType = NavigationAppType.APP_TYPE_LARK_NATIVE;
            r101.expires = 0;
            r101.unique_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.primary_only = r102;
            r101.unmovable = r102;
            r101.erasable = r102;
            r101.open_mode = NavigationOpenMode.UNKNOWN_MODE;
            r101.source = NavigationSource.SOURCE_UNKNOWN;
            r101.display_name = "";
            r101.subtitle = "";
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
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                default: goto L6;
            };
        L39:
            r101.appType = NavigationAppType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L21:
            r101.unique_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.expires = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L23:
            r101.extra.putAll(this.extra.decode(r100));
            goto L3
        L24:
            r101.platforms.add(PlatformInfo.ADAPTER.decode(r100));
            goto L3
        L25:
            r101.logo = Logo.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.name.putAll(this.name.decode(r100));
            goto L3
        L31:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.f253522id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            switch(r104) {
                case 30: goto L20;
                case 31: goto L19;
                case 32: goto L18;
                case 33: goto L35;
                case 34: goto L37;
                case 35: goto L9;
                case 36: goto L8;
                default: goto L7;
            };
        L35:
            r101.open_mode = NavigationOpenMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.source = NavigationSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r101.subtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.erasable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.unmovable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.primary_only = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L7:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L33:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NavigationAppInfo r100) {
            Long r101 = r100.f253521id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = ((r103 + r104.encodedSizeWithTag(2, r100.key)) + NavigationAppType.ADAPTER.encodedSizeWithTag(3, r100.appType)) + this.name.encodedSizeWithTag(4, r100.name);
            Logo r106 = r100.logo;
            if (r106 == null) goto L9;
            int r107 = Logo.ADAPTER.encodedSizeWithTag(5, r106);
        L10:
            int r108 = ((r105 + r107) + PlatformInfo.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.platforms)) + this.extra.encodedSizeWithTag(7, r100.extra);
            Integer r109 = r100.expires;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.UINT32.encodedSizeWithTag(8, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.unique_id;
            if (r112 == null) goto L17;
            int r113 = r104.encodedSizeWithTag(9, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.primary_only;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.unmovable;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r118);
        L26:
            int r120 = r117 + r119;
            Boolean r121 = r100.erasable;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r121);
        L30:
            int r123 = r120 + r122;
            NavigationOpenMode r124 = r100.open_mode;
            if (r124 == null) goto L33;
            int r125 = NavigationOpenMode.ADAPTER.encodedSizeWithTag(33, r124);
        L34:
            int r126 = r123 + r125;
            NavigationSource r127 = r100.source;
            if (r127 == null) goto L37;
            int r128 = NavigationSource.ADAPTER.encodedSizeWithTag(34, r127);
        L38:
            int r129 = r126 + r128;
            String r130 = r100.display_name;
            if (r130 == null) goto L41;
            int r131 = r104.encodedSizeWithTag(35, r130);
        L42:
            int r132 = r129 + r131;
            String r133 = r100.subtitle;
            if (r133 == null) goto L46;
            r102 = r104.encodedSizeWithTag(36, r133);
        L46:
            return (r132 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ NavigationAppInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NavigationAppInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NavigationAppInfo r101) throws IOException {
            Long r102 = r101.f253521id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 2, r101.key);
            NavigationAppType.ADAPTER.encodeWithTag(r100, 3, r101.appType);
            this.name.encodeWithTag(r100, 4, r101.name);
            Logo r104 = r101.logo;
            if (r104 == null) goto L8;
            Logo.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            PlatformInfo.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.platforms);
            this.extra.encodeWithTag(r100, 7, r101.extra);
            Integer r105 = r101.expires;
            if (r105 == null) goto L11;
            ProtoAdapter.UINT32.encodeWithTag(r100, 8, r105);
        L11:
            String r106 = r101.unique_id;
            if (r106 == null) goto L14;
            r103.encodeWithTag(r100, 9, r106);
        L14:
            Boolean r107 = r101.primary_only;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 30, r107);
        L17:
            Boolean r108 = r101.unmovable;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r108);
        L20:
            Boolean r109 = r101.erasable;
            if (r109 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32, r109);
        L23:
            NavigationOpenMode r110 = r101.open_mode;
            if (r110 == null) goto L26;
            NavigationOpenMode.ADAPTER.encodeWithTag(r100, 33, r110);
        L26:
            NavigationSource r111 = r101.source;
            if (r111 == null) goto L29;
            NavigationSource.ADAPTER.encodeWithTag(r100, 34, r111);
        L29:
            String r112 = r101.display_name;
            if (r112 == null) goto L32;
            r103.encodeWithTag(r100, 35, r112);
        L32:
            String r113 = r101.subtitle;
            if (r113 == null) goto L35;
            r103.encodeWithTag(r100, 36, r113);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NavigationAppInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Version extends com.squareup.wire.Message<Version, Builder> {
        public static final ProtoAdapter<Version> ADAPTER = null;
        public static final Integer DEFAULT_MAJOR = null;
        public static final Integer DEFAULT_MINOR = null;
        public static final Integer DEFAULT_PATCH = null;
        private static final long serialVersionUID = 0;
        public final Integer major;
        public final Integer minor;
        public final Integer patch;

        public static final class Builder extends com.squareup.wire.Message.Builder<Version, Builder> {
            public Integer major;
            public Integer minor;
            public Integer patch;

            @Override // com.squareup.wire.Message.Builder
            public Version build() {
                return new Version(this.major, this.minor, this.patch, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder major(Integer r100) {
                this.major = r100;
                return this;
            }

            public Builder minor(Integer r100) {
                this.minor = r100;
                return this;
            }

            public Builder patch(Integer r100) {
                this.patch = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Version extends ProtoAdapter<Version> {
            public ProtoAdapter_Version() {
                super(FieldEncoding.LENGTH_DELIMITED, Version.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Version decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.major = 0;
                r101.minor = 0;
                r101.patch = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.major = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.minor = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.patch = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Version r100) {
                Integer r101 = r100.major;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.minor;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.patch;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ Version decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Version r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Version r101) throws IOException {
                Integer r102 = r101.major;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.minor;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.patch;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Version r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Version();
            DEFAULT_MAJOR = 0;
            DEFAULT_MINOR = 0;
            DEFAULT_PATCH = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.major = this.major;
            r100.minor = this.minor;
            r100.patch = this.patch;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Version.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Version(Integer r100, Integer r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Version(Integer r100, Integer r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.major = r100;
            this.minor = r101;
            this.patch = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NavigationAppInfo();
        DEFAULT_ID = 0L;
        DEFAULT_APPTYPE = NavigationAppType.APP_TYPE_LARK_NATIVE;
        DEFAULT_EXPIRES = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_PRIMARY_ONLY = r100;
        DEFAULT_UNMOVABLE = r100;
        DEFAULT_ERASABLE = r100;
        DEFAULT_OPEN_MODE = NavigationOpenMode.UNKNOWN_MODE;
        DEFAULT_SOURCE = NavigationSource.SOURCE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253522id = this.f253521id;
        r100.key = this.key;
        r100.appType = this.appType;
        r100.name = Internal.copyOf("name", this.name);
        r100.logo = this.logo;
        r100.platforms = Internal.copyOf("platforms", this.platforms);
        r100.extra = Internal.copyOf("extra", this.extra);
        r100.expires = this.expires;
        r100.unique_id = this.unique_id;
        r100.primary_only = this.primary_only;
        r100.unmovable = this.unmovable;
        r100.erasable = this.erasable;
        r100.open_mode = this.open_mode;
        r100.source = this.source;
        r100.display_name = this.display_name;
        r100.subtitle = this.subtitle;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NavigationAppInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public NavigationAppInfo(Long r110, String r210, NavigationAppType r211, Map<String, String> r212, Logo r213, List<PlatformInfo> r214, Map<String, String> r215, Integer r216, String r217, Boolean r218, Boolean r219, Boolean r310, NavigationOpenMode r311, NavigationSource r312, String r313, String r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public NavigationAppInfo(Long r100, String r101, NavigationAppType r102, Map<String, String> r103, Logo r104, List<PlatformInfo> r105, Map<String, String> r110, Integer r111, String r112, Boolean r113, Boolean r114, Boolean r115, NavigationOpenMode r116, NavigationSource r117, String r118, String r119, ByteString r210) {
        super(ADAPTER, r210);
        this.f253521id = r100;
        this.key = r101;
        this.appType = r102;
        this.name = Internal.immutableCopyOf("name", r103);
        this.logo = r104;
        this.platforms = Internal.immutableCopyOf("platforms", r105);
        this.extra = Internal.immutableCopyOf("extra", r110);
        this.expires = r111;
        this.unique_id = r112;
        this.primary_only = r113;
        this.unmovable = r114;
        this.erasable = r115;
        this.open_mode = r116;
        this.source = r117;
        this.display_name = r118;
        this.subtitle = r119;
    }
}
