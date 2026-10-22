package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DomainSettings extends com.squareup.wire.Message<DomainSettings, Builder> {
    public static final ProtoAdapter<DomainSettings> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_PAIRS = null;
    private static final long serialVersionUID = 0;
    public final List<Pair> pairs;

    public static final enum Alias extends Enum<Alias> implements WireEnum {
        private static final /* synthetic */ Alias[] $VALUES = null;
        public static final ProtoAdapter<Alias> ADAPTER = null;
        public static final Alias API = null;
        public static final Alias APPLINK_PEER = null;
        public static final Alias BASIC_MODE = null;
        public static final Alias CDN = null;
        public static final Alias CJ_HONGBAO = null;
        public static final Alias CONTACT = null;
        public static final Alias DEVICE = null;
        public static final Alias DOCS = null;
        public static final Alias DOCS_ACCOUNT_DELETE_NOTICE = null;
        public static final Alias DOCS_API = null;
        public static final Alias DOCS_DRIVE = null;
        public static final Alias DOCS_FEED = null;
        public static final Alias DOCS_FE_RESOURCE_HOTFIX = null;
        public static final Alias DOCS_FRONTIER = null;
        public static final Alias DOCS_HOME = null;
        public static final Alias DOCS_LONG = null;
        public static final Alias DOCS_MAIN_DOMAIN = null;
        public static final Alias DOCS_PEER = null;
        public static final Alias DRIVE = null;
        public static final Alias EMAIL = null;
        public static final Alias EMAIL_BFF = null;
        public static final Alias EMAIL_IMAP = null;
        public static final Alias EMAIL_SMTP = null;
        public static final Alias FILE = null;
        public static final Alias GROUP_QR_CODE = null;
        public static final Alias HELPDESK = null;
        public static final Alias HELP_CENTER = null;
        public static final Alias HELP_DOCUMENT = null;
        public static final Alias INTERNAL_API = null;
        public static final Alias LOG = null;
        public static final Alias LONG = null;
        public static final Alias LONG_RTC = null;
        public static final Alias MINA = null;
        public static final Alias MOCK_GATEWAY = null;
        public static final Alias MP_APPLINK = null;
        public static final Alias MP_CONFIG = null;
        public static final Alias MP_REFER = null;
        public static final Alias MP_TT = null;
        public static final Alias NTP = null;
        public static final Alias OAPI = null;
        public static final Alias OPEN = null;
        public static final Alias OPEN_API_LOGIN = null;
        public static final Alias OPEN_APPCENTER1 = null;
        public static final Alias OPEN_APPCENTER2 = null;
        public static final Alias OPEN_APPCENTER3 = null;
        public static final Alias OPEN_APPCENTER_CARDJUMP = null;
        public static final Alias OPEN_APPLINK_SCHEMA_ENABLE_HOST = null;
        public static final Alias OPEN_APPSTORE = null;
        public static final Alias OPEN_APP_FEED = null;
        public static final Alias OPEN_APP_INTERFACE = null;
        public static final Alias OPEN_JSSDK_CONFIG = null;
        public static final Alias OPEN_MOMENT = null;
        public static final Alias OPEN_MSG_CARD = null;
        public static final Alias PANO = null;
        public static final Alias PASSPORT = null;
        public static final Alias PASSPORT_CAPTCHA = null;
        public static final Alias PEOPLE = null;
        public static final Alias PRIVACY = null;
        public static final Alias RTC_DECISION = null;
        public static final Alias RTC_DEFAULTIPS = null;
        public static final Alias RTC_FRONTIER = null;
        public static final Alias SENTRY = null;
        public static final Alias SHORT_RTC = null;
        public static final Alias SUITE_ADMIN = null;
        public static final Alias SUITE_ANDROID_HOTFIX = null;
        public static final Alias SUITE_APPCONFIG = null;
        public static final Alias SUITE_IMAGE_CDN = null;
        public static final Alias SUITE_MAIN_DOMAIN = null;
        public static final Alias SUITE_PAN_CDN = null;
        public static final Alias SUITE_REPORT = null;
        public static final Alias SUITE_SAFETYNET = null;
        public static final Alias SUITE_SECSDK = null;
        public static final Alias SUITE_SECURITY_LINK = null;
        public static final Alias SUITE_TKLOG = null;
        public static final Alias TTPUSH = null;
        public static final Alias TT_ABTEST = null;
        public static final Alias TT_APPLOG = null;
        public static final Alias TT_CDN = null;
        public static final Alias TT_ET = null;
        public static final Alias TT_GRAYLOG = null;
        public static final Alias TT_MUSICAL = null;
        public static final Alias TT_NPTH = null;
        public static final Alias TT_SLARDAR = null;
        public static final Alias TT_SLARDAR_CRASH_HOST_IOS = null;
        public static final Alias TT_SLARDAR_EXCEPTION = null;
        public static final Alias TT_SLARDAR_EXCEPTION_HOST_IOS = null;
        public static final Alias TT_SLARDAR_REPORT = null;
        public static final Alias TT_SLARDAR_SETTING = null;
        public static final Alias UG_ACTIVITY = null;
        public static final Alias UNKNOWN = null;
        public static final Alias VC_MM = null;
        public static final Alias VC_PRIVACY = null;
        public static final Alias VOD = null;
        private final int value;

        static {
            Alias r100 = new Alias("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Alias r101 = new Alias("API", 1, 1);
            API = r101;
            Alias r102 = new Alias("FILE", 2, 2);
            FILE = r102;
            Alias r103 = new Alias(DocTabPayload.VALUE_OPAI, 3, 3);
            OAPI = r103;
            Alias r104 = new Alias("DRIVE", 4, 4);
            DRIVE = r104;
            Alias r105 = new Alias("DOCS", 5, 5);
            DOCS = r105;
            Alias r110 = new Alias("MINA", 6, 6);
            MINA = r110;
            Alias r111 = new Alias("OPEN", 7, 7);
            OPEN = r111;
            Alias r112 = new Alias("DOCS_API", 8, 8);
            DOCS_API = r112;
            Alias r113 = new Alias("PASSPORT", 9, 9);
            PASSPORT = r113;
            Alias r114 = new Alias("INTERNAL_API", 10, 10);
            INTERNAL_API = r114;
            Alias r115 = new Alias("GROUP_QR_CODE", 11, 11);
            GROUP_QR_CODE = r115;
            Alias r106 = new Alias("HELPDESK", 12, 12);
            HELPDESK = r106;
            Alias r107 = new Alias("CONTACT", 13, 13);
            CONTACT = r107;
            Alias r108 = new Alias("PRIVACY", 14, 14);
            PRIVACY = r108;
            Alias r109 = new Alias("HELP_DOCUMENT", 15, 15);
            HELP_DOCUMENT = r109;
            Alias r116 = new Alias("DOCS_LONG", 16, 16);
            DOCS_LONG = r116;
            Alias r117 = new Alias("CJ_HONGBAO", 17, 17);
            CJ_HONGBAO = r117;
            Alias r118 = new Alias(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, 18, 18);
            DEVICE = r118;
            Alias r119 = new Alias("CDN", 19, 19);
            CDN = r119;
            Alias r120 = new Alias("SENTRY", 20, 20);
            SENTRY = r120;
            Alias r121 = new Alias("TTPUSH", 21, 21);
            TTPUSH = r121;
            Alias r122 = new Alias("LOG", 22, 22);
            LOG = r122;
            Alias r123 = new Alias("DOCS_DRIVE", 23, 23);
            DOCS_DRIVE = r123;
            Alias r124 = new Alias("LONG", 24, 24);
            LONG = r124;
            Alias r125 = new Alias("PEOPLE", 25, 25);
            PEOPLE = r125;
            Alias r126 = new Alias("VOD", 26, 26);
            VOD = r126;
            Alias r127 = new Alias("SHORT_RTC", 27, 27);
            SHORT_RTC = r127;
            Alias r128 = new Alias("LONG_RTC", 28, 29);
            LONG_RTC = r128;
            Alias r129 = new Alias("MP_APPLINK", 29, 30);
            MP_APPLINK = r129;
            Alias r130 = new Alias("MP_REFER", 30, 31);
            MP_REFER = r130;
            Alias r131 = new Alias("MP_CONFIG", 31, 32);
            MP_CONFIG = r131;
            Alias r132 = new Alias("MP_TT", 32, 33);
            MP_TT = r132;
            Alias r133 = new Alias("OPEN_APP_FEED", 33, 34);
            OPEN_APP_FEED = r133;
            Alias r134 = new Alias("OPEN_MSG_CARD", 34, 35);
            OPEN_MSG_CARD = r134;
            Alias r135 = new Alias("OPEN_APPCENTER1", 35, 36);
            OPEN_APPCENTER1 = r135;
            Alias r136 = new Alias("OPEN_APPCENTER2", 36, 37);
            OPEN_APPCENTER2 = r136;
            Alias r137 = new Alias("OPEN_MOMENT", 37, 38);
            OPEN_MOMENT = r137;
            Alias r138 = new Alias("OPEN_API_LOGIN", 38, 39);
            OPEN_API_LOGIN = r138;
            Alias r139 = new Alias("SUITE_IMAGE_CDN", 39, 40);
            SUITE_IMAGE_CDN = r139;
            Alias r140 = new Alias("TT_CDN", 40, 41);
            TT_CDN = r140;
            Alias r141 = new Alias("SUITE_REPORT", 41, 42);
            SUITE_REPORT = r141;
            Alias r142 = new Alias("OPEN_APPCENTER_CARDJUMP", 42, 43);
            OPEN_APPCENTER_CARDJUMP = r142;
            Alias r143 = new Alias("DOCS_HOME", 43, 44);
            DOCS_HOME = r143;
            Alias r144 = new Alias("SUITE_ANDROID_HOTFIX", 44, 45);
            SUITE_ANDROID_HOTFIX = r144;
            Alias r145 = new Alias("TT_MUSICAL", 45, 46);
            TT_MUSICAL = r145;
            Alias r146 = new Alias("DOCS_ACCOUNT_DELETE_NOTICE", 46, 47);
            DOCS_ACCOUNT_DELETE_NOTICE = r146;
            Alias r147 = new Alias("SUITE_MAIN_DOMAIN", 47, 48);
            SUITE_MAIN_DOMAIN = r147;
            Alias r148 = new Alias("PASSPORT_CAPTCHA", 48, 49);
            PASSPORT_CAPTCHA = r148;
            Alias r149 = new Alias("OPEN_APPCENTER3", 49, 50);
            OPEN_APPCENTER3 = r149;
            Alias r150 = new Alias("OPEN_JSSDK_CONFIG", 50, 51);
            OPEN_JSSDK_CONFIG = r150;
            Alias r151 = new Alias("SUITE_SAFETYNET", 51, 52);
            SUITE_SAFETYNET = r151;
            Alias r152 = new Alias("OPEN_APP_INTERFACE", 52, 53);
            OPEN_APP_INTERFACE = r152;
            Alias r153 = new Alias("SUITE_SECURITY_LINK", 53, 54);
            SUITE_SECURITY_LINK = r153;
            Alias r154 = new Alias("DOCS_MAIN_DOMAIN", 54, 55);
            DOCS_MAIN_DOMAIN = r154;
            Alias r155 = new Alias("DOCS_FE_RESOURCE_HOTFIX", 55, 56);
            DOCS_FE_RESOURCE_HOTFIX = r155;
            Alias r156 = new Alias("SUITE_SECSDK", 56, 57);
            SUITE_SECSDK = r156;
            Alias r157 = new Alias("HELP_CENTER", 57, 58);
            HELP_CENTER = r157;
            Alias r158 = new Alias("TT_ET", 58, 59);
            TT_ET = r158;
            Alias r159 = new Alias("SUITE_TKLOG", 59, 60);
            SUITE_TKLOG = r159;
            Alias r160 = new Alias(CommonConstant.RETKEY.EMAIL, 60, 61);
            EMAIL = r160;
            Alias r161 = new Alias("DOCS_PEER", 61, 62);
            DOCS_PEER = r161;
            Alias r162 = new Alias("APPLINK_PEER", 62, 63);
            APPLINK_PEER = r162;
            Alias r163 = new Alias("DOCS_FEED", 63, 64);
            DOCS_FEED = r163;
            Alias r164 = new Alias("TT_GRAYLOG", 64, 65);
            TT_GRAYLOG = r164;
            Alias r165 = new Alias("SUITE_PAN_CDN", 65, 66);
            SUITE_PAN_CDN = r165;
            Alias r166 = new Alias("UG_ACTIVITY", 66, 67);
            UG_ACTIVITY = r166;
            Alias r167 = new Alias("TT_APPLOG", 67, 68);
            TT_APPLOG = r167;
            Alias r168 = new Alias("TT_NPTH", 68, 69);
            TT_NPTH = r168;
            Alias r169 = new Alias("TT_SLARDAR_SETTING", 69, 70);
            TT_SLARDAR_SETTING = r169;
            Alias r170 = new Alias("TT_SLARDAR_REPORT", 70, 71);
            TT_SLARDAR_REPORT = r170;
            Alias r171 = new Alias("TT_SLARDAR_EXCEPTION", 71, 72);
            TT_SLARDAR_EXCEPTION = r171;
            Alias r172 = new Alias("TT_ABTEST", 72, 73);
            TT_ABTEST = r172;
            Alias r173 = new Alias("VC_PRIVACY", 73, 74);
            VC_PRIVACY = r173;
            Alias r174 = new Alias("SUITE_APPCONFIG", 74, 75);
            SUITE_APPCONFIG = r174;
            Alias r175 = new Alias("TT_SLARDAR_CRASH_HOST_IOS", 75, 76);
            TT_SLARDAR_CRASH_HOST_IOS = r175;
            Alias r176 = new Alias("TT_SLARDAR_EXCEPTION_HOST_IOS", 76, 77);
            TT_SLARDAR_EXCEPTION_HOST_IOS = r176;
            Alias r177 = new Alias("OPEN_APPSTORE", 77, 78);
            OPEN_APPSTORE = r177;
            Alias r178 = new Alias("TT_SLARDAR", 78, 79);
            TT_SLARDAR = r178;
            Alias r179 = new Alias("OPEN_APPLINK_SCHEMA_ENABLE_HOST", 79, 80);
            OPEN_APPLINK_SCHEMA_ENABLE_HOST = r179;
            Alias r180 = new Alias("VC_MM", 80, 81);
            VC_MM = r180;
            Alias r181 = new Alias("DOCS_FRONTIER", 81, 82);
            DOCS_FRONTIER = r181;
            Alias r182 = new Alias("PANO", 82, 83);
            PANO = r182;
            Alias r183 = new Alias("SUITE_ADMIN", 83, 84);
            SUITE_ADMIN = r183;
            Alias r184 = new Alias("RTC_FRONTIER", 84, 85);
            RTC_FRONTIER = r184;
            Alias r185 = new Alias("RTC_DECISION", 85, 86);
            RTC_DECISION = r185;
            Alias r186 = new Alias("RTC_DEFAULTIPS", 86, 87);
            RTC_DEFAULTIPS = r186;
            Alias r187 = new Alias("NTP", 87, 88);
            NTP = r187;
            Alias r188 = new Alias("MOCK_GATEWAY", 88, 89);
            MOCK_GATEWAY = r188;
            Alias r189 = new Alias("BASIC_MODE", 89, 90);
            BASIC_MODE = r189;
            Alias r190 = new Alias("EMAIL_BFF", 90, 91);
            EMAIL_BFF = r190;
            Alias r191 = new Alias("EMAIL_SMTP", 91, 92);
            EMAIL_SMTP = r191;
            Alias r192 = new Alias("EMAIL_IMAP", 92, 93);
            EMAIL_IMAP = r192;
            $VALUES = new Alias[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192};
            ADAPTER = ProtoAdapter.newEnumAdapter(Alias.class);
        }

        public static Alias[] values() {
            return (Alias[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Alias fromValue(int r100) {
            switch(r100) {
                case 0: goto L190;
                case 1: goto L188;
                case 2: goto L186;
                case 3: goto L184;
                case 4: goto L182;
                case 5: goto L180;
                case 6: goto L178;
                case 7: goto L176;
                case 8: goto L174;
                case 9: goto L172;
                case 10: goto L170;
                case 11: goto L168;
                case 12: goto L166;
                case 13: goto L164;
                case 14: goto L162;
                case 15: goto L160;
                case 16: goto L158;
                case 17: goto L156;
                case 18: goto L154;
                case 19: goto L152;
                case 20: goto L150;
                case 21: goto L148;
                case 22: goto L146;
                case 23: goto L144;
                case 24: goto L142;
                case 25: goto L140;
                case 26: goto L138;
                case 27: goto L136;
                case 28: goto L3;
                case 29: goto L134;
                case 30: goto L132;
                case 31: goto L130;
                case 32: goto L128;
                case 33: goto L126;
                case 34: goto L124;
                case 35: goto L122;
                case 36: goto L120;
                case 37: goto L118;
                case 38: goto L116;
                case 39: goto L114;
                case 40: goto L112;
                case 41: goto L110;
                case 42: goto L108;
                case 43: goto L106;
                case 44: goto L104;
                case 45: goto L102;
                case 46: goto L100;
                case 47: goto L98;
                case 48: goto L96;
                case 49: goto L94;
                case 50: goto L92;
                case 51: goto L90;
                case 52: goto L88;
                case 53: goto L86;
                case 54: goto L84;
                case 55: goto L82;
                case 56: goto L80;
                case 57: goto L78;
                case 58: goto L76;
                case 59: goto L74;
                case 60: goto L72;
                case 61: goto L70;
                case 62: goto L68;
                case 63: goto L66;
                case 64: goto L64;
                case 65: goto L62;
                case 66: goto L60;
                case 67: goto L58;
                case 68: goto L56;
                case 69: goto L54;
                case 70: goto L52;
                case 71: goto L50;
                case 72: goto L48;
                case 73: goto L46;
                case 74: goto L44;
                case 75: goto L42;
                case 76: goto L40;
                case 77: goto L38;
                case 78: goto L36;
                case 79: goto L34;
                case 80: goto L32;
                case 81: goto L30;
                case 82: goto L28;
                case 83: goto L26;
                case 84: goto L24;
                case 85: goto L22;
                case 86: goto L20;
                case 87: goto L18;
                case 88: goto L16;
                case 89: goto L14;
                case 90: goto L12;
                case 91: goto L10;
                case 92: goto L8;
                case 93: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return EMAIL_IMAP;
        L8:
            return EMAIL_SMTP;
        L10:
            return EMAIL_BFF;
        L12:
            return BASIC_MODE;
        L14:
            return MOCK_GATEWAY;
        L16:
            return NTP;
        L18:
            return RTC_DEFAULTIPS;
        L20:
            return RTC_DECISION;
        L22:
            return RTC_FRONTIER;
        L24:
            return SUITE_ADMIN;
        L26:
            return PANO;
        L28:
            return DOCS_FRONTIER;
        L30:
            return VC_MM;
        L32:
            return OPEN_APPLINK_SCHEMA_ENABLE_HOST;
        L34:
            return TT_SLARDAR;
        L36:
            return OPEN_APPSTORE;
        L38:
            return TT_SLARDAR_EXCEPTION_HOST_IOS;
        L40:
            return TT_SLARDAR_CRASH_HOST_IOS;
        L42:
            return SUITE_APPCONFIG;
        L44:
            return VC_PRIVACY;
        L46:
            return TT_ABTEST;
        L48:
            return TT_SLARDAR_EXCEPTION;
        L50:
            return TT_SLARDAR_REPORT;
        L52:
            return TT_SLARDAR_SETTING;
        L54:
            return TT_NPTH;
        L56:
            return TT_APPLOG;
        L58:
            return UG_ACTIVITY;
        L60:
            return SUITE_PAN_CDN;
        L62:
            return TT_GRAYLOG;
        L64:
            return DOCS_FEED;
        L66:
            return APPLINK_PEER;
        L68:
            return DOCS_PEER;
        L70:
            return EMAIL;
        L72:
            return SUITE_TKLOG;
        L74:
            return TT_ET;
        L76:
            return HELP_CENTER;
        L78:
            return SUITE_SECSDK;
        L80:
            return DOCS_FE_RESOURCE_HOTFIX;
        L82:
            return DOCS_MAIN_DOMAIN;
        L84:
            return SUITE_SECURITY_LINK;
        L86:
            return OPEN_APP_INTERFACE;
        L88:
            return SUITE_SAFETYNET;
        L90:
            return OPEN_JSSDK_CONFIG;
        L92:
            return OPEN_APPCENTER3;
        L94:
            return PASSPORT_CAPTCHA;
        L96:
            return SUITE_MAIN_DOMAIN;
        L98:
            return DOCS_ACCOUNT_DELETE_NOTICE;
        L100:
            return TT_MUSICAL;
        L102:
            return SUITE_ANDROID_HOTFIX;
        L104:
            return DOCS_HOME;
        L106:
            return OPEN_APPCENTER_CARDJUMP;
        L108:
            return SUITE_REPORT;
        L110:
            return TT_CDN;
        L112:
            return SUITE_IMAGE_CDN;
        L114:
            return OPEN_API_LOGIN;
        L116:
            return OPEN_MOMENT;
        L118:
            return OPEN_APPCENTER2;
        L120:
            return OPEN_APPCENTER1;
        L122:
            return OPEN_MSG_CARD;
        L124:
            return OPEN_APP_FEED;
        L126:
            return MP_TT;
        L128:
            return MP_CONFIG;
        L130:
            return MP_REFER;
        L132:
            return MP_APPLINK;
        L134:
            return LONG_RTC;
        L136:
            return SHORT_RTC;
        L138:
            return VOD;
        L140:
            return PEOPLE;
        L142:
            return LONG;
        L144:
            return DOCS_DRIVE;
        L146:
            return LOG;
        L148:
            return TTPUSH;
        L150:
            return SENTRY;
        L152:
            return CDN;
        L154:
            return DEVICE;
        L156:
            return CJ_HONGBAO;
        L158:
            return DOCS_LONG;
        L160:
            return HELP_DOCUMENT;
        L162:
            return PRIVACY;
        L164:
            return CONTACT;
        L166:
            return HELPDESK;
        L168:
            return GROUP_QR_CODE;
        L170:
            return INTERNAL_API;
        L172:
            return PASSPORT;
        L174:
            return DOCS_API;
        L176:
            return OPEN;
        L178:
            return MINA;
        L180:
            return DOCS;
        L182:
            return DRIVE;
        L184:
            return OAPI;
        L186:
            return FILE;
        L188:
            return API;
        L190:
            return UNKNOWN;
        }

        public static Alias valueOf(String r100) {
            return (Alias) a.a(Alias.class, r100);
        }

        private Alias(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<DomainSettings, Builder> {
        public List<Pair> pairs;

        @Override // com.squareup.wire.Message.Builder
        public DomainSettings build() {
            return new DomainSettings(this.pairs, super.buildUnknownFields());
        }

        public Builder() {
            this.pairs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder pairs(List<Pair> r100) {
            Internal.checkElementsNotNull(r100);
            this.pairs = r100;
            return this;
        }
    }

    public static final class Pair extends com.squareup.wire.Message<Pair, Builder> {
        public static final ProtoAdapter<Pair> ADAPTER = null;
        public static final Alias DEFAULT_ALIAS = null;
        public static final String DEFAULT_ALIAS_STR = "";
        public static final String DEFAULT_DOMAIN = "";
        public static final FieldOptions FIELD_OPTIONS_ALIAS_STR = null;
        public static final FieldOptions FIELD_OPTIONS_DOMAINS = null;
        private static final long serialVersionUID = 0;
        public final Alias alias;
        public final String alias_str;
        public final String domain;
        public final List<String> domains;

        public static final class Builder extends com.squareup.wire.Message.Builder<Pair, Builder> {
            public Alias alias;
            public String alias_str;
            public String domain;
            public List<String> domains;

            @Override // com.squareup.wire.Message.Builder
            public Pair build() {
                Alias r100 = this.alias;
                if (r100 == null) goto L9;
                if (this.domain == null) goto L9;
                return new Pair(this.alias, this.domain, this.domains, this.alias_str, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "alias", this.domain, "domain"});
            }

            public Builder() {
                this.domains = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder alias(Alias r100) {
                this.alias = r100;
                return this;
            }

            public Builder alias_str(String r100) {
                this.alias_str = r100;
                return this;
            }

            public Builder domain(String r100) {
                this.domain = r100;
                return this;
            }

            public Builder domains(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.domains = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Pair extends ProtoAdapter<Pair> {
            public ProtoAdapter_Pair() {
                super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Pair decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.alias = Alias.UNKNOWN;
                r101.domain = "";
                r101.alias_str = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.alias = Alias.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.domain = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.domains.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.alias_str = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Pair r100) {
                int r101 = Alias.ADAPTER.encodedSizeWithTag(1, r100.alias);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                int r103 = (r101 + r102.encodedSizeWithTag(2, r100.domain)) + r102.asRepeated().encodedSizeWithTag(3, r100.domains);
                String r104 = r100.alias_str;
                if (r104 == null) goto L5;
                int r105 = r102.encodedSizeWithTag(4, r104);
            L7:
                return (r103 + r105) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Pair decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Pair r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Pair r101) throws IOException {
                Alias.ADAPTER.encodeWithTag(r100, 1, r101.alias);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 2, r101.domain);
                r102.asRepeated().encodeWithTag(r100, 3, r101.domains);
                String r103 = r101.alias_str;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 4, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Pair r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Pair();
            FIELD_OPTIONS_DOMAINS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_ALIAS_STR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_ALIAS = Alias.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.alias = this.alias;
            r100.domain = this.domain;
            r100.domains = Internal.copyOf("domains", this.domains);
            r100.alias_str = this.alias_str;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Pair.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Pair(Alias r100, String r101, List<String> r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Pair(Alias r100, String r101, List<String> r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.alias = r100;
            this.domain = r101;
            this.domains = Internal.immutableCopyOf("domains", r102);
            this.alias_str = r103;
        }
    }

    public static final class ProtoAdapter_DomainSettings extends ProtoAdapter<DomainSettings> {
        public ProtoAdapter_DomainSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, DomainSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DomainSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.pairs.add(Pair.ADAPTER.decode(r100));
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
        public int encodedSize2(DomainSettings r100) {
            return Pair.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.pairs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DomainSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DomainSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DomainSettings r101) throws IOException {
            Pair.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.pairs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DomainSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DomainSettings();
        FIELD_OPTIONS_PAIRS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pairs = Internal.copyOf("pairs", this.pairs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DomainSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DomainSettings(List<Pair> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DomainSettings(List<Pair> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.pairs = Internal.immutableCopyOf("pairs", r100);
    }
}
