package com.bytedance.lark.pb.contact.v2;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.WorkStatus;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserProfileResponse extends Message<GetUserProfileResponse, Builder> {
    public static final ProtoAdapter<GetUserProfileResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUserProfileResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<CTA> cta_orders;
    public final List<Field> field_orders;
    public final Permission permission;
    public final List<TabInfo> tab_orders;
    public final UserInfo user_info;

    public static final class Builder extends Message.Builder<GetUserProfileResponse, Builder> implements d<GetUserProfileResponse> {
        public List<CTA> cta_orders;
        public List<Field> field_orders;
        public Permission permission;
        public List<TabInfo> tab_orders;
        public UserInfo user_info;

        @Override // com.squareup.wire.Message.Builder
        public GetUserProfileResponse build() {
            UserInfo r100 = this.user_info;
            if (r100 == null) goto L7;
            return new GetUserProfileResponse(this.user_info, this.cta_orders, this.field_orders, this.permission, this.tab_orders, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_info"});
        }

        public Builder() {
            this.cta_orders = Internal.newMutableList();
            this.field_orders = Internal.newMutableList();
            this.tab_orders = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cta_orders(List<CTA> r100) {
            Internal.checkElementsNotNull(r100);
            this.cta_orders = r100;
            return this;
        }

        public Builder field_orders(List<Field> r100) {
            Internal.checkElementsNotNull(r100);
            this.field_orders = r100;
            return this;
        }

        public Builder permission(Permission r100) {
            this.permission = r100;
            return this;
        }

        public Builder tab_orders(List<TabInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.tab_orders = r100;
            return this;
        }

        public Builder user_info(UserInfo r100) {
            this.user_info = r100;
            return this;
        }
    }

    public static final class CTA extends Message<CTA, Builder> {
        public static final ProtoAdapter<CTA> ADAPTER = null;
        public static final CTAType DEFAULT_CTA_TYPE = null;
        public static final com.bytedance.lark.pb.basic.v1.DeniedReason DEFAULT_DENIED_REASON = null;
        public static final DeniedReason DEFAULT_DENY_REASON = null;
        public static final Boolean DEFAULT_ENABLE = null;
        public static final String DEFAULT_ICON_KEY = "";
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_LINK = "";
        private static final long serialVersionUID = 0;
        public final CTAType cta_type;
        public final I18nVal denied_description;
        public final com.bytedance.lark.pb.basic.v1.DeniedReason denied_reason;
        public final DeniedReason deny_reason;
        public final Boolean enable;
        public final I18nVal i18n_names;
        public final String icon_key;
        public final String key;
        public final String link;
        public final List<CTA> sub_ctas;

        public static final class Builder extends Message.Builder<CTA, Builder> {
            public CTAType cta_type;
            public I18nVal denied_description;
            public com.bytedance.lark.pb.basic.v1.DeniedReason denied_reason;
            public DeniedReason deny_reason;
            public Boolean enable;
            public I18nVal i18n_names;
            public String icon_key;
            public String key;
            public String link;
            public List<CTA> sub_ctas;

            @Override // com.squareup.wire.Message.Builder
            public CTA build() {
                String r100 = this.key;
                if (r100 == null) goto L13;
                if (this.i18n_names == null) goto L13;
                if (this.enable == null) goto L13;
                if (this.cta_type == null) goto L13;
                return new CTA(this.key, this.i18n_names, this.enable, this.cta_type, this.icon_key, this.link, this.deny_reason, this.denied_reason, this.denied_description, this.sub_ctas, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r100, "key", this.i18n_names, "i18n_names", this.enable, "enable", this.cta_type, "cta_type"});
            }

            public Builder() {
                this.sub_ctas = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder cta_type(CTAType r100) {
                this.cta_type = r100;
                return this;
            }

            public Builder denied_description(I18nVal r100) {
                this.denied_description = r100;
                return this;
            }

            public Builder denied_reason(com.bytedance.lark.pb.basic.v1.DeniedReason r100) {
                this.denied_reason = r100;
                return this;
            }

            public Builder deny_reason(DeniedReason r100) {
                this.deny_reason = r100;
                return this;
            }

            public Builder enable(Boolean r100) {
                this.enable = r100;
                return this;
            }

            public Builder i18n_names(I18nVal r100) {
                this.i18n_names = r100;
                return this;
            }

            public Builder icon_key(String r100) {
                this.icon_key = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder link(String r100) {
                this.link = r100;
                return this;
            }

            public Builder sub_ctas(List<CTA> r100) {
                Internal.checkElementsNotNull(r100);
                this.sub_ctas = r100;
                return this;
            }
        }

        public static final enum CTAType extends Enum<CTAType> implements WireEnum {
            private static final /* synthetic */ CTAType[] $VALUES = null;
            public static final ProtoAdapter<CTAType> ADAPTER = null;
            public static final CTAType BLOCK_SETTING = null;
            public static final CTAType CHAT = null;
            public static final CTAType COLLABORATION_PERMISSION_SETTING = null;
            public static final CTAType CRYPTO_CHAT = null;
            public static final CTAType LINK = null;
            public static final CTAType S_PRIVATE_MODE = null;
            public static final CTAType S_VOICE_EPHONE = null;
            public static final CTAType S_VOICE_PHONE = null;
            public static final CTAType UNKNOWN = null;
            public static final CTAType USER_CARD = null;
            public static final CTAType VIDEO = null;
            public static final CTAType VOICE = null;
            public final Boolean deprecated;
            private final int value;

            static {
                CTAType r100 = new CTAType("UNKNOWN", 0, 0, null);
                UNKNOWN = r100;
                CTAType r101 = new CTAType("LINK", 1, 1, null);
                LINK = r101;
                CTAType r102 = new CTAType("CHAT", 2, 10, null);
                CHAT = r102;
                CTAType r103 = new CTAType("CRYPTO_CHAT", 3, 11, null);
                CRYPTO_CHAT = r103;
                CTAType r104 = new CTAType("VOICE", 4, 12, null);
                VOICE = r104;
                CTAType r110 = new CTAType("VIDEO", 5, 13, null);
                VIDEO = r110;
                CTAType r111 = new CTAType("USER_CARD", 6, 14, null);
                USER_CARD = r111;
                Boolean r112 = Boolean.TRUE;
                CTAType r113 = new CTAType("BLOCK_SETTING", 7, 15, r112);
                BLOCK_SETTING = r113;
                CTAType r105 = new CTAType("COLLABORATION_PERMISSION_SETTING", 8, 16, r112);
                COLLABORATION_PERMISSION_SETTING = r105;
                CTAType r106 = new CTAType("S_VOICE_EPHONE", 9, 17, null);
                S_VOICE_EPHONE = r106;
                CTAType r107 = new CTAType("S_VOICE_PHONE", 10, 18, null);
                S_VOICE_PHONE = r107;
                CTAType r114 = new CTAType("S_PRIVATE_MODE", 11, 19, null);
                S_PRIVATE_MODE = r114;
                $VALUES = new CTAType[]{r100, r101, r102, r103, r104, r110, r111, r113, r105, r106, r107, r114};
                ADAPTER = ProtoAdapter.newEnumAdapter(CTAType.class);
            }

            public static CTAType[] values() {
                return (CTAType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static CTAType fromValue(int r100) {
                if (r100 == 0) goto L31;
                if (r100 == 1) goto L29;
                switch(r100) {
                    case 10: goto L27;
                    case 11: goto L25;
                    case 12: goto L23;
                    case 13: goto L21;
                    case 14: goto L19;
                    case 15: goto L17;
                    case 16: goto L15;
                    case 17: goto L13;
                    case 18: goto L11;
                    case 19: goto L9;
                    default: goto L6;
                };
            L6:
                return null;
            L9:
                return S_PRIVATE_MODE;
            L11:
                return S_VOICE_PHONE;
            L13:
                return S_VOICE_EPHONE;
            L15:
                return COLLABORATION_PERMISSION_SETTING;
            L17:
                return BLOCK_SETTING;
            L19:
                return USER_CARD;
            L21:
                return VIDEO;
            L23:
                return VOICE;
            L25:
                return CRYPTO_CHAT;
            L27:
                return CHAT;
            L29:
                return LINK;
            L31:
                return UNKNOWN;
            }

            public static CTAType valueOf(String r100) {
                return (CTAType) a.a(CTAType.class, r100);
            }

            private CTAType(String r100, int r101, int r102, Boolean r103) {
                super(r100, r101);
                this.value = r102;
                this.deprecated = r103;
            }
        }

        public static final enum DeniedReason extends Enum<DeniedReason> implements WireEnum {
            private static final /* synthetic */ DeniedReason[] $VALUES = null;
            public static final ProtoAdapter<DeniedReason> ADAPTER = null;
            public static final DeniedReason CROSS_TENANT_BLOCKED = null;
            public static final DeniedReason CROSS_TENANT_DENY = null;
            public static final DeniedReason SAME_TENANT_DENY = null;
            public static final DeniedReason UNKNOWN_REASON = null;
            private final int value;

            static {
                DeniedReason r100 = new DeniedReason("UNKNOWN_REASON", 0, 0);
                UNKNOWN_REASON = r100;
                DeniedReason r101 = new DeniedReason("CROSS_TENANT_BLOCKED", 1, 1);
                CROSS_TENANT_BLOCKED = r101;
                DeniedReason r102 = new DeniedReason("CROSS_TENANT_DENY", 2, 2);
                CROSS_TENANT_DENY = r102;
                DeniedReason r103 = new DeniedReason("SAME_TENANT_DENY", 3, 3);
                SAME_TENANT_DENY = r103;
                $VALUES = new DeniedReason[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(DeniedReason.class);
            }

            public static DeniedReason[] values() {
                return (DeniedReason[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static DeniedReason fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return SAME_TENANT_DENY;
            L14:
                return CROSS_TENANT_DENY;
            L16:
                return CROSS_TENANT_BLOCKED;
            L18:
                return UNKNOWN_REASON;
            }

            public static DeniedReason valueOf(String r100) {
                return (DeniedReason) a.a(DeniedReason.class, r100);
            }

            private DeniedReason(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_CTA extends ProtoAdapter<CTA> {
            public ProtoAdapter_CTA() {
                super(FieldEncoding.LENGTH_DELIMITED, CTA.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CTA decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.enable = Boolean.FALSE;
                r101.cta_type = CTAType.UNKNOWN;
                r101.icon_key = "";
                r101.link = "";
                r101.deny_reason = DeniedReason.UNKNOWN_REASON;
                r101.denied_reason = com.bytedance.lark.pb.basic.v1.DeniedReason.UNKNOWN_REASON;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L26;
                switch(r103) {
                    case 1: goto L25;
                    case 2: goto L24;
                    case 3: goto L23;
                    case 4: goto L30;
                    case 5: goto L18;
                    case 6: goto L17;
                    case 7: goto L32;
                    case 8: goto L28;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L28:
                r101.denied_reason = com.bytedance.lark.pb.basic.v1.DeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r101.cta_type = CTAType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.deny_reason = DeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.sub_ctas.add(CTA.ADAPTER.decode(r100));
                goto L3
            L8:
                r101.denied_description = I18nVal.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.icon_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L23:
                r101.enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L24:
                r101.i18n_names = I18nVal.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L26:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CTA r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.key);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                int r104 = ((r102 + r103.encodedSizeWithTag(2, r100.i18n_names)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.enable)) + CTAType.ADAPTER.encodedSizeWithTag(4, r100.cta_type);
                String r105 = r100.icon_key;
                int r106 = 0;
                if (r105 == null) goto L5;
                int r107 = r101.encodedSizeWithTag(5, r105);
            L6:
                int r108 = r104 + r107;
                String r109 = r100.link;
                if (r109 == null) goto L9;
                int r110 = r101.encodedSizeWithTag(6, r109);
            L10:
                int r111 = r108 + r110;
                DeniedReason r112 = r100.deny_reason;
                if (r112 == null) goto L13;
                int r113 = DeniedReason.ADAPTER.encodedSizeWithTag(7, r112);
            L14:
                int r114 = r111 + r113;
                com.bytedance.lark.pb.basic.v1.DeniedReason r115 = r100.denied_reason;
                if (r115 == null) goto L17;
                int r116 = com.bytedance.lark.pb.basic.v1.DeniedReason.ADAPTER.encodedSizeWithTag(8, r115);
            L18:
                int r117 = r114 + r116;
                I18nVal r118 = r100.denied_description;
                if (r118 == null) goto L22;
                r106 = r103.encodedSizeWithTag(9, r118);
            L22:
                return ((r117 + r106) + CTA.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.sub_ctas)) + r100.unknownFields().size();
            L17:
                r116 = 0;
                goto L18
            L13:
                r113 = 0;
                goto L14
            L9:
                r110 = 0;
                goto L10
            L5:
                r107 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CTA decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CTA r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CTA r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.key);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                r103.encodeWithTag(r100, 2, r101.i18n_names);
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.enable);
                CTAType.ADAPTER.encodeWithTag(r100, 4, r101.cta_type);
                String r104 = r101.icon_key;
                if (r104 == null) goto L5;
                r102.encodeWithTag(r100, 5, r104);
            L5:
                String r105 = r101.link;
                if (r105 == null) goto L8;
                r102.encodeWithTag(r100, 6, r105);
            L8:
                DeniedReason r106 = r101.deny_reason;
                if (r106 == null) goto L11;
                DeniedReason.ADAPTER.encodeWithTag(r100, 7, r106);
            L11:
                com.bytedance.lark.pb.basic.v1.DeniedReason r107 = r101.denied_reason;
                if (r107 == null) goto L14;
                com.bytedance.lark.pb.basic.v1.DeniedReason.ADAPTER.encodeWithTag(r100, 8, r107);
            L14:
                I18nVal r108 = r101.denied_description;
                if (r108 == null) goto L17;
                r103.encodeWithTag(r100, 9, r108);
            L17:
                CTA.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.sub_ctas);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CTA r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CTA();
            DEFAULT_ENABLE = Boolean.FALSE;
            DEFAULT_CTA_TYPE = CTAType.UNKNOWN;
            DEFAULT_DENY_REASON = DeniedReason.UNKNOWN_REASON;
            DEFAULT_DENIED_REASON = com.bytedance.lark.pb.basic.v1.DeniedReason.UNKNOWN_REASON;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.i18n_names = this.i18n_names;
            r100.enable = this.enable;
            r100.cta_type = this.cta_type;
            r100.icon_key = this.icon_key;
            r100.link = this.link;
            r100.deny_reason = this.deny_reason;
            r100.denied_reason = this.denied_reason;
            r100.denied_description = this.denied_description;
            r100.sub_ctas = Internal.copyOf("sub_ctas", this.sub_ctas);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CTA.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CTA(String r110, I18nVal r111, Boolean r112, CTAType r113, String r114, String r115, DeniedReason r116, com.bytedance.lark.pb.basic.v1.DeniedReason r210, I18nVal r211, List<CTA> r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public CTA(String r100, I18nVal r101, Boolean r102, CTAType r103, String r104, String r105, DeniedReason r106, com.bytedance.lark.pb.basic.v1.DeniedReason r107, I18nVal r110, List<CTA> r111, ByteString r112) {
            super(ADAPTER, r112);
            this.key = r100;
            this.i18n_names = r101;
            this.enable = r102;
            this.cta_type = r103;
            this.icon_key = r104;
            this.link = r105;
            this.deny_reason = r106;
            this.denied_reason = r107;
            this.denied_description = r110;
            this.sub_ctas = Internal.immutableCopyOf("sub_ctas", r111);
        }
    }

    public static final class CustomImage extends Message<CustomImage, Builder> {
        public static final ProtoAdapter<CustomImage> ADAPTER = null;
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String resource_key;

        public static final class Builder extends Message.Builder<CustomImage, Builder> {
            public String resource_key;

            @Override // com.squareup.wire.Message.Builder
            public CustomImage build() {
                return new CustomImage(this.resource_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder resource_key(String r100) {
                this.resource_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomImage extends ProtoAdapter<CustomImage> {
            public ProtoAdapter_CustomImage() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomImage.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomImage decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.resource_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.resource_key = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(CustomImage r100) {
                String r101 = r100.resource_key;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CustomImage decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomImage r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomImage r101) throws IOException {
                String r102 = r101.resource_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomImage r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomImage();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.resource_key = this.resource_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomImage.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomImage(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public CustomImage(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.resource_key = r100;
        }
    }

    public static final class CustomPhone extends Message<CustomPhone, Builder> {
        public static final ProtoAdapter<CustomPhone> ADAPTER = null;
        public static final String DEFAULT_EXTENSION_NUMBER = "";
        public static final String DEFAULT_PHONE_NUMBER = "";
        private static final long serialVersionUID = 0;
        public final String extension_number;
        public final String phone_number;

        public static final class Builder extends Message.Builder<CustomPhone, Builder> {
            public String extension_number;
            public String phone_number;

            @Override // com.squareup.wire.Message.Builder
            public CustomPhone build() {
                return new CustomPhone(this.phone_number, this.extension_number, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder extension_number(String r100) {
                this.extension_number = r100;
                return this;
            }

            public Builder phone_number(String r100) {
                this.phone_number = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomPhone extends ProtoAdapter<CustomPhone> {
            public ProtoAdapter_CustomPhone() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomPhone.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomPhone decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.phone_number = "";
                r101.extension_number = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.phone_number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.extension_number = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(CustomPhone r100) {
                String r101 = r100.phone_number;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.extension_number;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CustomPhone decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomPhone r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomPhone r101) throws IOException {
                String r102 = r101.phone_number;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.extension_number;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomPhone r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomPhone();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.phone_number = this.phone_number;
            r100.extension_number = this.extension_number;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomPhone.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomPhone(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CustomPhone(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.phone_number = r100;
            this.extension_number = r101;
        }
    }

    public static final class Department extends Message<Department, Builder> {
        public static final ProtoAdapter<Department> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<DepartmentPath> department_paths;
        public final GroupedManagedDepartments grouped_managed_departments;

        public static final class Builder extends Message.Builder<Department, Builder> {
            public List<DepartmentPath> department_paths;
            public GroupedManagedDepartments grouped_managed_departments;

            @Override // com.squareup.wire.Message.Builder
            public Department build() {
                return new Department(this.department_paths, this.grouped_managed_departments, super.buildUnknownFields());
            }

            public Builder() {
                this.department_paths = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder department_paths(List<DepartmentPath> r100) {
                Internal.checkElementsNotNull(r100);
                this.department_paths = r100;
                return this;
            }

            public Builder grouped_managed_departments(GroupedManagedDepartments r100) {
                this.grouped_managed_departments = r100;
                return this;
            }
        }

        public static final class DepartmentPath extends Message<DepartmentPath, Builder> {
            public static final ProtoAdapter<DepartmentPath> ADAPTER = null;
            public static final Boolean DEFAULT_ACCESSIBLE = null;
            public static final String DEFAULT_REDIRECT_LINK = "";
            private static final long serialVersionUID = 0;
            public final Boolean accessible;
            public final List<DepartmentNode> department_nodes;
            public final I18nVal no_access_description;
            public final String redirect_link;

            public static final class Builder extends Message.Builder<DepartmentPath, Builder> {
                public Boolean accessible;
                public List<DepartmentNode> department_nodes;
                public I18nVal no_access_description;
                public String redirect_link;

                @Override // com.squareup.wire.Message.Builder
                public DepartmentPath build() {
                    return new DepartmentPath(this.department_nodes, this.accessible, this.redirect_link, this.no_access_description, super.buildUnknownFields());
                }

                public Builder() {
                    this.department_nodes = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder accessible(Boolean r100) {
                    this.accessible = r100;
                    return this;
                }

                public Builder department_nodes(List<DepartmentNode> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.department_nodes = r100;
                    return this;
                }

                public Builder no_access_description(I18nVal r100) {
                    this.no_access_description = r100;
                    return this;
                }

                public Builder redirect_link(String r100) {
                    this.redirect_link = r100;
                    return this;
                }
            }

            public static final class DepartmentNode extends Message<DepartmentNode, Builder> {
                public static final ProtoAdapter<DepartmentNode> ADAPTER = null;
                public static final String DEFAULT_DEPARTMENT_ID = "";
                private static final long serialVersionUID = 0;
                public final String department_id;
                public final I18nVal department_name;

                public static final class Builder extends Message.Builder<DepartmentNode, Builder> {
                    public String department_id;
                    public I18nVal department_name;

                    @Override // com.squareup.wire.Message.Builder
                    public DepartmentNode build() {
                        return new DepartmentNode(this.department_name, this.department_id, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ Message build() {
                        return build();
                    }

                    public Builder department_id(String r100) {
                        this.department_id = r100;
                        return this;
                    }

                    public Builder department_name(I18nVal r100) {
                        this.department_name = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_DepartmentNode extends ProtoAdapter<DepartmentNode> {
                    public ProtoAdapter_DepartmentNode() {
                        super(FieldEncoding.LENGTH_DELIMITED, DepartmentNode.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public DepartmentNode decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.department_id = "";
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L12;
                        if (r103 != 1) goto L8;
                        r101.department_name = I18nVal.ADAPTER.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.department_id = ProtoAdapter.STRING.decode(r100);
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
                    public int encodedSize2(DepartmentNode r100) {
                        I18nVal r101 = r100.department_name;
                        int r102 = 0;
                        if (r101 == null) goto L5;
                        int r103 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
                    L6:
                        String r104 = r100.department_id;
                        if (r104 == null) goto L10;
                        r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                    L10:
                        return (r103 + r102) + r100.unknownFields().size();
                    L5:
                        r103 = 0;
                        goto L6
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ DepartmentNode decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(DepartmentNode r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, DepartmentNode r101) throws IOException {
                        I18nVal r102 = r101.department_name;
                        if (r102 == null) goto L5;
                        I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
                    L5:
                        String r103 = r101.department_id;
                        if (r103 == null) goto L8;
                        ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                    L8:
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentNode r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_DepartmentNode();
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.department_name = this.department_name;
                    r100.department_id = this.department_id;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return DepartmentNode.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return newBuilder();
                }

                public DepartmentNode(I18nVal r100, String r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public DepartmentNode(I18nVal r100, String r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.department_name = r100;
                    this.department_id = r101;
                }
            }

            public static final class ProtoAdapter_DepartmentPath extends ProtoAdapter<DepartmentPath> {
                public ProtoAdapter_DepartmentPath() {
                    super(FieldEncoding.LENGTH_DELIMITED, DepartmentPath.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DepartmentPath decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.accessible = Boolean.FALSE;
                    r101.redirect_link = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.department_nodes.add(DepartmentNode.ADAPTER.decode(r100));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.accessible = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.redirect_link = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.no_access_description = I18nVal.ADAPTER.decode(r100);
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
                public int encodedSize2(DepartmentPath r100) {
                    int r101 = DepartmentNode.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.department_nodes);
                    Boolean r102 = r100.accessible;
                    int r103 = 0;
                    if (r102 == null) goto L5;
                    int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
                L6:
                    int r105 = r101 + r104;
                    String r106 = r100.redirect_link;
                    if (r106 == null) goto L9;
                    int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
                L10:
                    int r108 = r105 + r107;
                    I18nVal r109 = r100.no_access_description;
                    if (r109 == null) goto L14;
                    r103 = I18nVal.ADAPTER.encodedSizeWithTag(4, r109);
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
                public /* bridge */ /* synthetic */ DepartmentPath decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DepartmentPath r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DepartmentPath r101) throws IOException {
                    DepartmentNode.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.department_nodes);
                    Boolean r102 = r101.accessible;
                    if (r102 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
                L5:
                    String r103 = r101.redirect_link;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
                L8:
                    I18nVal r104 = r101.no_access_description;
                    if (r104 == null) goto L11;
                    I18nVal.ADAPTER.encodeWithTag(r100, 4, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentPath r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DepartmentPath();
                DEFAULT_ACCESSIBLE = Boolean.FALSE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.department_nodes = Internal.copyOf("department_nodes", this.department_nodes);
                r100.accessible = this.accessible;
                r100.redirect_link = this.redirect_link;
                r100.no_access_description = this.no_access_description;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DepartmentPath.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public DepartmentPath(List<DepartmentNode> r100, Boolean r101, String r102, I18nVal r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public DepartmentPath(List<DepartmentNode> r100, Boolean r101, String r102, I18nVal r103, ByteString r104) {
                super(ADAPTER, r104);
                this.department_nodes = Internal.immutableCopyOf("department_nodes", r100);
                this.accessible = r101;
                this.redirect_link = r102;
                this.no_access_description = r103;
            }
        }

        public static final class ProtoAdapter_Department extends ProtoAdapter<Department> {
            public ProtoAdapter_Department() {
                super(FieldEncoding.LENGTH_DELIMITED, Department.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Department decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.department_paths.add(DepartmentPath.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.grouped_managed_departments = GroupedManagedDepartments.ADAPTER.decode(r100);
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
            public int encodedSize2(Department r100) {
                int r101 = DepartmentPath.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.department_paths);
                GroupedManagedDepartments r102 = r100.grouped_managed_departments;
                if (r102 == null) goto L5;
                int r103 = GroupedManagedDepartments.ADAPTER.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Department decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Department r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Department r101) throws IOException {
                DepartmentPath.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.department_paths);
                GroupedManagedDepartments r102 = r101.grouped_managed_departments;
                if (r102 == null) goto L5;
                GroupedManagedDepartments.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Department r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Department();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.department_paths = Internal.copyOf("department_paths", this.department_paths);
            r100.grouped_managed_departments = this.grouped_managed_departments;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Department.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Department(List<DepartmentPath> r100, GroupedManagedDepartments r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Department(List<DepartmentPath> r100, GroupedManagedDepartments r101, ByteString r102) {
            super(ADAPTER, r102);
            this.department_paths = Internal.immutableCopyOf("department_paths", r100);
            this.grouped_managed_departments = r101;
        }
    }

    public static final class Field extends Message<Field, Builder> {
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final FieldType DEFAULT_FIELD_TYPE = null;
        public static final ByteString DEFAULT_FIELD_VAL = null;
        public static final String DEFAULT_JSON_FIELD_VAL = "";
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final MemoDescription client_memo_description;
        public final FieldType field_type;
        public final ByteString field_val;
        public final I18nVal i18n_names;
        public final I18nVal i18n_tip;
        public final String json_field_val;
        public final String key;

        public static final class Builder extends Message.Builder<Field, Builder> {
            public MemoDescription client_memo_description;
            public FieldType field_type;
            public ByteString field_val;
            public I18nVal i18n_names;
            public I18nVal i18n_tip;
            public String json_field_val;
            public String key;

            @Override // com.squareup.wire.Message.Builder
            public Field build() {
                String r100 = this.key;
                if (r100 == null) goto L11;
                if (this.i18n_names == null) goto L11;
                if (this.field_type == null) goto L11;
                return new Field(this.key, this.i18n_names, this.field_type, this.field_val, this.json_field_val, this.client_memo_description, this.i18n_tip, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "key", this.i18n_names, "i18n_names", this.field_type, "field_type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder client_memo_description(MemoDescription r100) {
                this.client_memo_description = r100;
                return this;
            }

            public Builder field_type(FieldType r100) {
                this.field_type = r100;
                return this;
            }

            public Builder field_val(ByteString r100) {
                this.field_val = r100;
                return this;
            }

            public Builder i18n_names(I18nVal r100) {
                this.i18n_names = r100;
                return this;
            }

            public Builder i18n_tip(I18nVal r100) {
                this.i18n_tip = r100;
                return this;
            }

            public Builder json_field_val(String r100) {
                this.json_field_val = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }
        }

        public static final enum FieldType extends Enum<FieldType> implements WireEnum {
            private static final /* synthetic */ FieldType[] $VALUES = null;
            public static final ProtoAdapter<FieldType> ADAPTER = null;
            public static final FieldType ALIAS_AND_MEMO = null;
            public static final FieldType CUSTOM_FIELD_IMAGE = null;
            public static final FieldType CUSTOM_PHONE = null;
            public static final FieldType C_ALIAS = null;
            public static final FieldType C_DESCRIPTION = null;
            public static final FieldType LINK = null;
            public static final FieldType LINK_LIST = null;
            public static final FieldType MEMO_DESCRIPTION = null;
            public static final FieldType S_DEPARTMENT = null;
            public static final FieldType S_FRIEND_LINK = null;
            public static final FieldType S_PHONE_NUMBER = null;
            public static final FieldType TEXT = null;
            public static final FieldType TEXT_LIST = null;
            public static final FieldType UNKNOWN = null;
            private final int value;

            static {
                FieldType r100 = new FieldType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                FieldType r101 = new FieldType(CardAdapter.TEXT, 1, 1);
                TEXT = r101;
                FieldType r102 = new FieldType("LINK", 2, 2);
                LINK = r102;
                FieldType r103 = new FieldType("TEXT_LIST", 3, 3);
                TEXT_LIST = r103;
                FieldType r104 = new FieldType("LINK_LIST", 4, 4);
                LINK_LIST = r104;
                FieldType r105 = new FieldType("CUSTOM_PHONE", 5, 9);
                CUSTOM_PHONE = r105;
                FieldType r110 = new FieldType("C_ALIAS", 6, 50);
                C_ALIAS = r110;
                FieldType r111 = new FieldType("C_DESCRIPTION", 7, 51);
                C_DESCRIPTION = r111;
                FieldType r112 = new FieldType("S_DEPARTMENT", 8, 100);
                S_DEPARTMENT = r112;
                FieldType r113 = new FieldType("S_PHONE_NUMBER", 9, 101);
                S_PHONE_NUMBER = r113;
                FieldType r106 = new FieldType("S_FRIEND_LINK", 10, 102);
                S_FRIEND_LINK = r106;
                FieldType r114 = new FieldType("CUSTOM_FIELD_IMAGE", 11, 103);
                CUSTOM_FIELD_IMAGE = r114;
                FieldType r107 = new FieldType("ALIAS_AND_MEMO", 12, 104);
                ALIAS_AND_MEMO = r107;
                FieldType r108 = new FieldType("MEMO_DESCRIPTION", 13, 105);
                MEMO_DESCRIPTION = r108;
                $VALUES = new FieldType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r114, r107, r108};
                ADAPTER = ProtoAdapter.newEnumAdapter(FieldType.class);
            }

            public static FieldType[] values() {
                return (FieldType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FieldType fromValue(int r100) {
                if (r100 == 0) goto L47;
                if (r100 == 1) goto L45;
                if (r100 == 2) goto L43;
                if (r100 == 3) goto L41;
                if (r100 == 4) goto L39;
                if (r100 == 9) goto L37;
                if (r100 == 50) goto L35;
                if (r100 == 51) goto L33;
                switch(r100) {
                    case 100: goto L31;
                    case 101: goto L29;
                    case 102: goto L27;
                    case 103: goto L25;
                    case 104: goto L23;
                    case 105: goto L21;
                    default: goto L18;
                };
            L18:
                return null;
            L21:
                return MEMO_DESCRIPTION;
            L23:
                return ALIAS_AND_MEMO;
            L25:
                return CUSTOM_FIELD_IMAGE;
            L27:
                return S_FRIEND_LINK;
            L29:
                return S_PHONE_NUMBER;
            L31:
                return S_DEPARTMENT;
            L33:
                return C_DESCRIPTION;
            L35:
                return C_ALIAS;
            L37:
                return CUSTOM_PHONE;
            L39:
                return LINK_LIST;
            L41:
                return TEXT_LIST;
            L43:
                return LINK;
            L45:
                return TEXT;
            L47:
                return UNKNOWN;
            }

            public static FieldType valueOf(String r100) {
                return (FieldType) a.a(FieldType.class, r100);
            }

            private FieldType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_Field extends ProtoAdapter<Field> {
            public ProtoAdapter_Field() {
                super(FieldEncoding.LENGTH_DELIMITED, Field.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Field decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.field_type = FieldType.UNKNOWN;
                r101.field_val = ByteString.EMPTY;
                r101.json_field_val = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                if (r103 != 10) goto L7;
                r101.i18n_tip = I18nVal.ADAPTER.decode(r100);
                goto L3
            L7:
                switch(r103) {
                    case 1: goto L17;
                    case 2: goto L16;
                    case 3: goto L21;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    default: goto L8;
                };
            L21:
                r101.field_type = FieldType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                r101.client_memo_description = MemoDescription.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.json_field_val = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.field_val = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L16:
                r101.i18n_names = I18nVal.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L19:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Field r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.key);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                int r104 = (r102 + r103.encodedSizeWithTag(2, r100.i18n_names)) + FieldType.ADAPTER.encodedSizeWithTag(3, r100.field_type);
                ByteString r105 = r100.field_val;
                int r106 = 0;
                if (r105 == null) goto L5;
                int r107 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r105);
            L6:
                int r108 = r104 + r107;
                String r109 = r100.json_field_val;
                if (r109 == null) goto L9;
                int r110 = r101.encodedSizeWithTag(5, r109);
            L10:
                int r111 = r108 + r110;
                MemoDescription r112 = r100.client_memo_description;
                if (r112 == null) goto L13;
                int r113 = MemoDescription.ADAPTER.encodedSizeWithTag(6, r112);
            L14:
                int r114 = r111 + r113;
                I18nVal r115 = r100.i18n_tip;
                if (r115 == null) goto L18;
                r106 = r103.encodedSizeWithTag(10, r115);
            L18:
                return (r114 + r106) + r100.unknownFields().size();
            L13:
                r113 = 0;
                goto L14
            L9:
                r110 = 0;
                goto L10
            L5:
                r107 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Field decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Field r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Field r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.key);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                r103.encodeWithTag(r100, 2, r101.i18n_names);
                FieldType.ADAPTER.encodeWithTag(r100, 3, r101.field_type);
                ByteString r104 = r101.field_val;
                if (r104 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r100, 4, r104);
            L5:
                String r105 = r101.json_field_val;
                if (r105 == null) goto L8;
                r102.encodeWithTag(r100, 5, r105);
            L8:
                MemoDescription r106 = r101.client_memo_description;
                if (r106 == null) goto L11;
                MemoDescription.ADAPTER.encodeWithTag(r100, 6, r106);
            L11:
                I18nVal r107 = r101.i18n_tip;
                if (r107 == null) goto L14;
                r103.encodeWithTag(r100, 10, r107);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Field r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Field();
            DEFAULT_FIELD_TYPE = FieldType.UNKNOWN;
            DEFAULT_FIELD_VAL = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.i18n_names = this.i18n_names;
            r100.field_type = this.field_type;
            r100.field_val = this.field_val;
            r100.json_field_val = this.json_field_val;
            r100.client_memo_description = this.client_memo_description;
            r100.i18n_tip = this.i18n_tip;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Field.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Field(String r110, I18nVal r111, FieldType r112, ByteString r113, String r114, MemoDescription r115, I18nVal r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public Field(String r100, I18nVal r101, FieldType r102, ByteString r103, String r104, MemoDescription r105, I18nVal r106, ByteString r107) {
            super(ADAPTER, r107);
            this.key = r100;
            this.i18n_names = r101;
            this.field_type = r102;
            this.field_val = r103;
            this.json_field_val = r104;
            this.client_memo_description = r105;
            this.i18n_tip = r106;
        }
    }

    public static final class Href extends Message<Href, Builder> {
        public static final ProtoAdapter<Href> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal link;
        public final Style style;
        public final I18nVal title;

        public static final class Builder extends Message.Builder<Href, Builder> {
            public I18nVal link;
            public Style style;
            public I18nVal title;

            @Override // com.squareup.wire.Message.Builder
            public Href build() {
                return new Href(this.title, this.link, this.style, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder link(I18nVal r100) {
                this.link = r100;
                return this;
            }

            public Builder style(Style r100) {
                this.style = r100;
                return this;
            }

            public Builder title(I18nVal r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Href extends ProtoAdapter<Href> {
            public ProtoAdapter_Href() {
                super(FieldEncoding.LENGTH_DELIMITED, Href.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Href decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.title = I18nVal.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.link = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.style = Style.ADAPTER.decode(r100);
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
            public int encodedSize2(Href r100) {
                I18nVal r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.link;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Style r107 = r100.style;
                if (r107 == null) goto L14;
                r102 = Style.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ Href decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Href r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Href r101) throws IOException {
                I18nVal r102 = r101.title;
                if (r102 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.link;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Style r104 = r101.style;
                if (r104 == null) goto L11;
                Style.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Href r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Href();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.link = this.link;
            r100.style = this.style;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Href.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Href(I18nVal r100, I18nVal r101, Style r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Href(I18nVal r100, I18nVal r101, Style r102, ByteString r103) {
            super(ADAPTER, r103);
            this.title = r100;
            this.link = r101;
            this.style = r102;
        }
    }

    public static final class HrefList extends Message<HrefList, Builder> {
        public static final ProtoAdapter<HrefList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Href> href_list;

        public static final class Builder extends Message.Builder<HrefList, Builder> {
            public List<Href> href_list;

            @Override // com.squareup.wire.Message.Builder
            public HrefList build() {
                return new HrefList(this.href_list, super.buildUnknownFields());
            }

            public Builder() {
                this.href_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder href_list(List<Href> r100) {
                Internal.checkElementsNotNull(r100);
                this.href_list = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_HrefList extends ProtoAdapter<HrefList> {
            public ProtoAdapter_HrefList() {
                super(FieldEncoding.LENGTH_DELIMITED, HrefList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HrefList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.href_list.add(Href.ADAPTER.decode(r100));
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
            public int encodedSize2(HrefList r100) {
                return Href.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.href_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HrefList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HrefList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HrefList r101) throws IOException {
                Href.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.href_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HrefList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HrefList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.href_list = Internal.copyOf("href_list", this.href_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HrefList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public HrefList(List<Href> r100) {
            this(r100, ByteString.EMPTY);
        }

        public HrefList(List<Href> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.href_list = Internal.immutableCopyOf("href_list", r100);
        }
    }

    public static final class I18nVal extends Message<I18nVal, Builder> {
        public static final ProtoAdapter<I18nVal> ADAPTER = null;
        public static final String DEFAULT_DEFAULT_VAL = "";
        private static final long serialVersionUID = 0;
        public final String default_val;
        public final Map<String, String> i18n_vals;

        public static final class Builder extends Message.Builder<I18nVal, Builder> {
            public String default_val;
            public Map<String, String> i18n_vals;

            @Override // com.squareup.wire.Message.Builder
            public I18nVal build() {
                String r100 = this.default_val;
                if (r100 == null) goto L7;
                return new I18nVal(this.default_val, this.i18n_vals, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "default_val"});
            }

            public Builder() {
                this.i18n_vals = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder default_val(String r100) {
                this.default_val = r100;
                return this;
            }

            public Builder i18n_vals(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.i18n_vals = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_I18nVal extends ProtoAdapter<I18nVal> {
            private final ProtoAdapter<Map<String, String>> i18n_vals;

            public ProtoAdapter_I18nVal() {
                super(FieldEncoding.LENGTH_DELIMITED, I18nVal.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.i18n_vals = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public I18nVal decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.default_val = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.default_val = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.i18n_vals.putAll(this.i18n_vals.decode(r100));
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
            public int encodedSize2(I18nVal r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.default_val) + this.i18n_vals.encodedSizeWithTag(2, r100.i18n_vals)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ I18nVal decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(I18nVal r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, I18nVal r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.default_val);
                this.i18n_vals.encodeWithTag(r100, 2, r101.i18n_vals);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nVal r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_I18nVal();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.default_val = this.default_val;
            r100.i18n_vals = Internal.copyOf("i18n_vals", this.i18n_vals);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return I18nVal.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public I18nVal(String r100, Map<String, String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public I18nVal(String r100, Map<String, String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.default_val = r100;
            this.i18n_vals = Internal.immutableCopyOf("i18n_vals", r101);
        }
    }

    public static final class Medal extends Message<Medal, Builder> {
        public static final ProtoAdapter<Medal> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal i18n_name;
        public final ImageSetPassThrough image;

        public static final class Builder extends Message.Builder<Medal, Builder> {
            public I18nVal i18n_name;
            public ImageSetPassThrough image;

            @Override // com.squareup.wire.Message.Builder
            public Medal build() {
                return new Medal(this.image, this.i18n_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder i18n_name(I18nVal r100) {
                this.i18n_name = r100;
                return this;
            }

            public Builder image(ImageSetPassThrough r100) {
                this.image = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Medal extends ProtoAdapter<Medal> {
            public ProtoAdapter_Medal() {
                super(FieldEncoding.LENGTH_DELIMITED, Medal.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Medal decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.image = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.i18n_name = I18nVal.ADAPTER.decode(r100);
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
            public int encodedSize2(Medal r100) {
                ImageSetPassThrough r101 = r100.image;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.i18n_name;
                if (r104 == null) goto L10;
                r102 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Medal decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Medal r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Medal r101) throws IOException {
                ImageSetPassThrough r102 = r101.image;
                if (r102 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.i18n_name;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Medal r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Medal();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.image = this.image;
            r100.i18n_name = this.i18n_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Medal.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Medal(ImageSetPassThrough r100, I18nVal r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Medal(ImageSetPassThrough r100, I18nVal r101, ByteString r102) {
            super(ADAPTER, r102);
            this.image = r100;
            this.i18n_name = r101;
        }
    }

    public static final class MedalList extends Message<MedalList, Builder> {
        public static final ProtoAdapter<MedalList> ADAPTER = null;
        public static final Integer DEFAULT_TOTAL_NUM = null;
        private static final long serialVersionUID = 0;
        public final List<Medal> medal_meta;
        public final Integer total_num;

        public static final class Builder extends Message.Builder<MedalList, Builder> {
            public List<Medal> medal_meta;
            public Integer total_num;

            @Override // com.squareup.wire.Message.Builder
            public MedalList build() {
                return new MedalList(this.medal_meta, this.total_num, super.buildUnknownFields());
            }

            public Builder() {
                this.medal_meta = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder medal_meta(List<Medal> r100) {
                Internal.checkElementsNotNull(r100);
                this.medal_meta = r100;
                return this;
            }

            public Builder total_num(Integer r100) {
                this.total_num = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MedalList extends ProtoAdapter<MedalList> {
            public ProtoAdapter_MedalList() {
                super(FieldEncoding.LENGTH_DELIMITED, MedalList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MedalList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.total_num = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.medal_meta.add(Medal.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.total_num = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(MedalList r100) {
                int r101 = Medal.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.medal_meta);
                Integer r102 = r100.total_num;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MedalList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MedalList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MedalList r101) throws IOException {
                Medal.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.medal_meta);
                Integer r102 = r101.total_num;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MedalList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MedalList();
            DEFAULT_TOTAL_NUM = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.medal_meta = Internal.copyOf("medal_meta", this.medal_meta);
            r100.total_num = this.total_num;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MedalList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MedalList(List<Medal> r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MedalList(List<Medal> r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.medal_meta = Internal.immutableCopyOf("medal_meta", r100);
            this.total_num = r101;
        }
    }

    public static final class MemoDescription extends Message<MemoDescription, Builder> {
        public static final ProtoAdapter<MemoDescription> ADAPTER = null;
        public static final String DEFAULT_MEMO_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Map<String, PreviewHangPoint> anchor_id_2_preview_hang_point;
        public final ImageSetPassThrough memo_picture;
        public final List<ImageSetPassThrough> memo_picture_v2;
        public final String memo_text;
        public final RichText memo_text_v2;
        public final Map<String, UrlPreviewEntity> preview_id_2_preview_entity;

        public static final class Builder extends Message.Builder<MemoDescription, Builder> {
            public Map<String, PreviewHangPoint> anchor_id_2_preview_hang_point;
            public ImageSetPassThrough memo_picture;
            public List<ImageSetPassThrough> memo_picture_v2;
            public String memo_text;
            public RichText memo_text_v2;
            public Map<String, UrlPreviewEntity> preview_id_2_preview_entity;

            @Override // com.squareup.wire.Message.Builder
            public MemoDescription build() {
                return new MemoDescription(this.memo_text, this.memo_picture, this.memo_text_v2, this.memo_picture_v2, this.anchor_id_2_preview_hang_point, this.preview_id_2_preview_entity, super.buildUnknownFields());
            }

            public Builder() {
                this.memo_picture_v2 = Internal.newMutableList();
                this.anchor_id_2_preview_hang_point = Internal.newMutableMap();
                this.preview_id_2_preview_entity = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder anchor_id_2_preview_hang_point(Map<String, PreviewHangPoint> r100) {
                Internal.checkElementsNotNull(r100);
                this.anchor_id_2_preview_hang_point = r100;
                return this;
            }

            public Builder memo_picture(ImageSetPassThrough r100) {
                this.memo_picture = r100;
                return this;
            }

            public Builder memo_picture_v2(List<ImageSetPassThrough> r100) {
                Internal.checkElementsNotNull(r100);
                this.memo_picture_v2 = r100;
                return this;
            }

            public Builder memo_text(String r100) {
                this.memo_text = r100;
                return this;
            }

            public Builder memo_text_v2(RichText r100) {
                this.memo_text_v2 = r100;
                return this;
            }

            public Builder preview_id_2_preview_entity(Map<String, UrlPreviewEntity> r100) {
                Internal.checkElementsNotNull(r100);
                this.preview_id_2_preview_entity = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MemoDescription extends ProtoAdapter<MemoDescription> {
            private final ProtoAdapter<Map<String, PreviewHangPoint>> anchor_id_2_preview_hang_point;
            private final ProtoAdapter<Map<String, UrlPreviewEntity>> preview_id_2_preview_entity;

            public ProtoAdapter_MemoDescription() {
                super(FieldEncoding.LENGTH_DELIMITED, MemoDescription.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.anchor_id_2_preview_hang_point = ProtoAdapter.newMapAdapter(r100, PreviewHangPoint.ADAPTER);
                this.preview_id_2_preview_entity = ProtoAdapter.newMapAdapter(r100, UrlPreviewEntity.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MemoDescription decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.memo_text = "";
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
                r101.preview_id_2_preview_entity.putAll(this.preview_id_2_preview_entity.decode(r100));
                goto L3
            L8:
                r101.anchor_id_2_preview_hang_point.putAll(this.anchor_id_2_preview_hang_point.decode(r100));
                goto L3
            L9:
                r101.memo_picture_v2.add(ImageSetPassThrough.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.memo_text_v2 = RichText.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.memo_picture = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.memo_text = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(MemoDescription r100) {
                String r101 = r100.memo_text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ImageSetPassThrough r104 = r100.memo_picture;
                if (r104 == null) goto L9;
                int r105 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                RichText r107 = r100.memo_text_v2;
                if (r107 == null) goto L14;
                r102 = RichText.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return ((((r106 + r102) + ImageSetPassThrough.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.memo_picture_v2)) + this.anchor_id_2_preview_hang_point.encodedSizeWithTag(5, r100.anchor_id_2_preview_hang_point)) + this.preview_id_2_preview_entity.encodedSizeWithTag(6, r100.preview_id_2_preview_entity)) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MemoDescription decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MemoDescription r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MemoDescription r101) throws IOException {
                String r102 = r101.memo_text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ImageSetPassThrough r103 = r101.memo_picture;
                if (r103 == null) goto L8;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                RichText r104 = r101.memo_text_v2;
                if (r104 == null) goto L11;
                RichText.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ImageSetPassThrough.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.memo_picture_v2);
                this.anchor_id_2_preview_hang_point.encodeWithTag(r100, 5, r101.anchor_id_2_preview_hang_point);
                this.preview_id_2_preview_entity.encodeWithTag(r100, 6, r101.preview_id_2_preview_entity);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MemoDescription r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MemoDescription();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.memo_text = this.memo_text;
            r100.memo_picture = this.memo_picture;
            r100.memo_text_v2 = this.memo_text_v2;
            r100.memo_picture_v2 = Internal.copyOf("memo_picture_v2", this.memo_picture_v2);
            r100.anchor_id_2_preview_hang_point = Internal.copyOf("anchor_id_2_preview_hang_point", this.anchor_id_2_preview_hang_point);
            r100.preview_id_2_preview_entity = Internal.copyOf("preview_id_2_preview_entity", this.preview_id_2_preview_entity);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MemoDescription.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MemoDescription(String r100, ImageSetPassThrough r110, RichText r111, List<ImageSetPassThrough> r112, Map<String, PreviewHangPoint> r113, Map<String, UrlPreviewEntity> r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public MemoDescription(String r100, ImageSetPassThrough r101, RichText r102, List<ImageSetPassThrough> r103, Map<String, PreviewHangPoint> r104, Map<String, UrlPreviewEntity> r105, ByteString r106) {
            super(ADAPTER, r106);
            this.memo_text = r100;
            this.memo_picture = r101;
            this.memo_text_v2 = r102;
            this.memo_picture_v2 = Internal.immutableCopyOf("memo_picture_v2", r103);
            this.anchor_id_2_preview_hang_point = Internal.immutableCopyOf("anchor_id_2_preview_hang_point", r104);
            this.preview_id_2_preview_entity = Internal.immutableCopyOf("preview_id_2_preview_entity", r105);
        }
    }

    public static final class Permission extends Message<Permission, Builder> {
        public static final ProtoAdapter<Permission> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_FIND = null;
        public static final Boolean DEFAULT_CAN_NOT_FIND = null;
        private static final long serialVersionUID = 0;
        public final Boolean can_find;
        public final Boolean can_not_find;

        public static final class Builder extends Message.Builder<Permission, Builder> {
            public Boolean can_find;
            public Boolean can_not_find;

            @Override // com.squareup.wire.Message.Builder
            public Permission build() {
                return new Permission(this.can_find, this.can_not_find, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder can_find(Boolean r100) {
                this.can_find = r100;
                return this;
            }

            public Builder can_not_find(Boolean r100) {
                this.can_not_find = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Permission extends ProtoAdapter<Permission> {
            public ProtoAdapter_Permission() {
                super(FieldEncoding.LENGTH_DELIMITED, Permission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Permission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.can_find = r102;
                r101.can_not_find = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.can_find = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.can_not_find = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Permission r100) {
                Boolean r101 = r100.can_find;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.can_not_find;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Permission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Permission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Permission r101) throws IOException {
                Boolean r102 = r101.can_find;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.can_not_find;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Permission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Permission();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_CAN_FIND = r100;
            DEFAULT_CAN_NOT_FIND = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.can_find = this.can_find;
            r100.can_not_find = this.can_not_find;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Permission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Permission(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Permission(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.can_find = r100;
            this.can_not_find = r101;
        }
    }

    public static final class PhoneNumber extends Message<PhoneNumber, Builder> {
        public static final ProtoAdapter<PhoneNumber> ADAPTER = null;
        public static final String DEFAULT_COUNTRY_CODE = "";
        public static final Boolean DEFAULT_IS_PLAIN = null;
        public static final String DEFAULT_NUMBER = "";
        public static final Boolean DEFAULT_RATE_LIMITED = null;
        private static final long serialVersionUID = 0;
        public final String country_code;
        public final Boolean is_plain;
        public final String number;
        public final Boolean rate_limited;

        public static final class Builder extends Message.Builder<PhoneNumber, Builder> {
            public String country_code;
            public Boolean is_plain;
            public String number;
            public Boolean rate_limited;

            @Override // com.squareup.wire.Message.Builder
            public PhoneNumber build() {
                return new PhoneNumber(this.number, this.country_code, this.rate_limited, this.is_plain, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder country_code(String r100) {
                this.country_code = r100;
                return this;
            }

            public Builder is_plain(Boolean r100) {
                this.is_plain = r100;
                return this;
            }

            public Builder number(String r100) {
                this.number = r100;
                return this;
            }

            public Builder rate_limited(Boolean r100) {
                this.rate_limited = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PhoneNumber extends ProtoAdapter<PhoneNumber> {
            public ProtoAdapter_PhoneNumber() {
                super(FieldEncoding.LENGTH_DELIMITED, PhoneNumber.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PhoneNumber decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.number = "";
                r101.country_code = "";
                Boolean r102 = Boolean.FALSE;
                r101.rate_limited = r102;
                r101.is_plain = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.country_code = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.rate_limited = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.is_plain = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(PhoneNumber r100) {
                String r101 = r100.number;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.country_code;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.rate_limited;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_plain;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ PhoneNumber decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PhoneNumber r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PhoneNumber r101) throws IOException {
                String r102 = r101.number;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.country_code;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.rate_limited;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.is_plain;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PhoneNumber r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PhoneNumber();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_RATE_LIMITED = r100;
            DEFAULT_IS_PLAIN = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.number = this.number;
            r100.country_code = this.country_code;
            r100.rate_limited = this.rate_limited;
            r100.is_plain = this.is_plain;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PhoneNumber.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PhoneNumber(String r100, String r101, Boolean r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public PhoneNumber(String r100, String r101, Boolean r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.number = r100;
            this.country_code = r101;
            this.rate_limited = r102;
            this.is_plain = r103;
        }
    }

    public static final class ProtoAdapter_GetUserProfileResponse extends ProtoAdapter<GetUserProfileResponse> implements c<GetUserProfileResponse> {
        public ProtoAdapter_GetUserProfileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserProfileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserProfileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user_info = UserInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cta_orders.add(CTA.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.field_orders.add(Field.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.permission = Permission.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.tab_orders.add(TabInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(GetUserProfileResponse r100) {
            int r101 = (UserInfo.ADAPTER.encodedSizeWithTag(1, r100.user_info) + CTA.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.cta_orders)) + Field.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.field_orders);
            Permission r102 = r100.permission;
            if (r102 == null) goto L5;
            int r103 = Permission.ADAPTER.encodedSizeWithTag(4, r102);
        L7:
            return ((r101 + r103) + TabInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.tab_orders)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserProfileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserProfileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserProfileResponse r101) throws IOException {
            UserInfo.ADAPTER.encodeWithTag(r100, 1, r101.user_info);
            CTA.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.cta_orders);
            Field.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.field_orders);
            Permission r102 = r101.permission;
            if (r102 == null) goto L5;
            Permission.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            TabInfo.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.tab_orders);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserProfileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ShareInfo extends Message<ShareInfo, Builder> {
        public static final ProtoAdapter<ShareInfo> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE = null;
        private static final long serialVersionUID = 0;
        public final I18nVal denied_description;
        public final Boolean enable;
        public final I18nVal i18n_names;

        public static final class Builder extends Message.Builder<ShareInfo, Builder> {
            public I18nVal denied_description;
            public Boolean enable;
            public I18nVal i18n_names;

            @Override // com.squareup.wire.Message.Builder
            public ShareInfo build() {
                return new ShareInfo(this.enable, this.i18n_names, this.denied_description, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder denied_description(I18nVal r100) {
                this.denied_description = r100;
                return this;
            }

            public Builder enable(Boolean r100) {
                this.enable = r100;
                return this;
            }

            public Builder i18n_names(I18nVal r100) {
                this.i18n_names = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShareInfo extends ProtoAdapter<ShareInfo> {
            public ProtoAdapter_ShareInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShareInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.enable = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.i18n_names = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.denied_description = I18nVal.ADAPTER.decode(r100);
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
            public int encodedSize2(ShareInfo r100) {
                Boolean r101 = r100.enable;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.i18n_names;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                I18nVal r107 = r100.denied_description;
                if (r107 == null) goto L14;
                r102 = I18nVal.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ShareInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShareInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShareInfo r101) throws IOException {
                Boolean r102 = r101.enable;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.i18n_names;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                I18nVal r104 = r101.denied_description;
                if (r104 == null) goto L11;
                I18nVal.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareInfo();
            DEFAULT_ENABLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.enable = this.enable;
            r100.i18n_names = this.i18n_names;
            r100.denied_description = this.denied_description;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShareInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShareInfo(Boolean r100, I18nVal r101, I18nVal r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ShareInfo(Boolean r100, I18nVal r101, I18nVal r102, ByteString r103) {
            super(ADAPTER, r103);
            this.enable = r100;
            this.i18n_names = r101;
            this.denied_description = r102;
        }
    }

    public static final class SingleFieldTabInfo extends Message<SingleFieldTabInfo, Builder> {
        public static final ProtoAdapter<SingleFieldTabInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Field single_field;

        public static final class Builder extends Message.Builder<SingleFieldTabInfo, Builder> {
            public Field single_field;

            @Override // com.squareup.wire.Message.Builder
            public SingleFieldTabInfo build() {
                return new SingleFieldTabInfo(this.single_field, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder single_field(Field r100) {
                this.single_field = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SingleFieldTabInfo extends ProtoAdapter<SingleFieldTabInfo> {
            public ProtoAdapter_SingleFieldTabInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, SingleFieldTabInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SingleFieldTabInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.single_field = Field.ADAPTER.decode(r100);
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
            public int encodedSize2(SingleFieldTabInfo r100) {
                Field r101 = r100.single_field;
                if (r101 == null) goto L5;
                int r102 = Field.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SingleFieldTabInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SingleFieldTabInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SingleFieldTabInfo r101) throws IOException {
                Field r102 = r101.single_field;
                if (r102 == null) goto L5;
                Field.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SingleFieldTabInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SingleFieldTabInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.single_field = this.single_field;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SingleFieldTabInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SingleFieldTabInfo(Field r100) {
            this(r100, ByteString.EMPTY);
        }

        public SingleFieldTabInfo(Field r100, ByteString r101) {
            super(ADAPTER, r101);
            this.single_field = r100;
        }
    }

    public static final class Style extends Message<Style, Builder> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final String DEFAULT_COLOR = "";
        public static final Boolean DEFAULT_EXPANDABLE = null;
        public static final Integer DEFAULT_MAX_LINES = null;
        private static final long serialVersionUID = 0;
        public final String color;
        public final Boolean expandable;
        public final Integer max_lines;

        public static final class Builder extends Message.Builder<Style, Builder> {
            public String color;
            public Boolean expandable;
            public Integer max_lines;

            @Override // com.squareup.wire.Message.Builder
            public Style build() {
                return new Style(this.max_lines, this.expandable, this.color, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder color(String r100) {
                this.color = r100;
                return this;
            }

            public Builder expandable(Boolean r100) {
                this.expandable = r100;
                return this;
            }

            public Builder max_lines(Integer r100) {
                this.max_lines = r100;
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
                r101.max_lines = 0;
                r101.expandable = Boolean.FALSE;
                r101.color = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.max_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.expandable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.color = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Style r100) {
                Integer r101 = r100.max_lines;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.expandable;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.color;
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
            public /* bridge */ /* synthetic */ Style decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Style r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Style r101) throws IOException {
                Integer r102 = r101.max_lines;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.expandable;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.color;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Style r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Style();
            DEFAULT_MAX_LINES = 0;
            DEFAULT_EXPANDABLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.max_lines = this.max_lines;
            r100.expandable = this.expandable;
            r100.color = this.color;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Style.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Style(Integer r100, Boolean r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Style(Integer r100, Boolean r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.max_lines = r100;
            this.expandable = r101;
            this.color = r102;
        }
    }

    public static final class TabInfo extends Message<TabInfo, Builder> {
        public static final ProtoAdapter<TabInfo> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_KEY = "";
        public static final TabType DEFAULT_TAB_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final String key;
        public final I18nVal name;
        public final TabType tab_type;

        public static final class Builder extends Message.Builder<TabInfo, Builder> {
            public String content;
            public String key;
            public I18nVal name;
            public TabType tab_type;

            @Override // com.squareup.wire.Message.Builder
            public TabInfo build() {
                return new TabInfo(this.key, this.name, this.tab_type, this.content, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder name(I18nVal r100) {
                this.name = r100;
                return this;
            }

            public Builder tab_type(TabType r100) {
                this.tab_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TabInfo extends ProtoAdapter<TabInfo> {
            public ProtoAdapter_TabInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TabInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TabInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.tab_type = TabType.F_UNKNOWN;
                r101.content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.name = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.tab_type = TabType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.content = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TabInfo r100) {
                String r101 = r100.key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.name;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TabType r107 = r100.tab_type;
                if (r107 == null) goto L13;
                int r108 = TabType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.content;
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
            public /* bridge */ /* synthetic */ TabInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TabInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TabInfo r101) throws IOException {
                String r102 = r101.key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.name;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                TabType r104 = r101.tab_type;
                if (r104 == null) goto L11;
                TabType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.content;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TabInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TabType extends Enum<TabType> implements WireEnum {
            private static final /* synthetic */ TabType[] $VALUES = null;
            public static final ProtoAdapter<TabType> ADAPTER = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_ACTIVITY = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_OVERVIEW = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE = null;
            public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY = null;
            public static final TabType F_COMMON_INFO = null;
            public static final TabType F_COMMUNITY = null;
            public static final TabType F_OPEN_SECTION_CLUSTER = null;
            public static final TabType F_SECTION_CLUSTER = null;
            public static final TabType F_SINGLE_FIELD = null;
            public static final TabType F_UNKNOWN = null;
            private final int value;

            static {
                TabType r100 = new TabType("F_UNKNOWN", 0, 0);
                F_UNKNOWN = r100;
                TabType r101 = new TabType("F_COMMON_INFO", 1, 1);
                F_COMMON_INFO = r101;
                TabType r102 = new TabType("F_COMMUNITY", 2, 2);
                F_COMMUNITY = r102;
                TabType r103 = new TabType("F_SINGLE_FIELD", 3, 3);
                F_SINGLE_FIELD = r103;
                TabType r104 = new TabType("F_SECTION_CLUSTER", 4, 4);
                F_SECTION_CLUSTER = r104;
                TabType r105 = new TabType("F_OPEN_SECTION_CLUSTER", 5, 5);
                F_OPEN_SECTION_CLUSTER = r105;
                TabType r110 = new TabType("F_BUILT_IN_PROFILE_MANAGE_ACTIVITY", 6, 6);
                F_BUILT_IN_PROFILE_MANAGE_ACTIVITY = r110;
                TabType r111 = new TabType("F_BUILT_IN_PROFILE_MANAGE_OVERVIEW", 7, 7);
                F_BUILT_IN_PROFILE_MANAGE_OVERVIEW = r111;
                TabType r112 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY", 8, 8);
                F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY = r112;
                TabType r113 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION", 9, 9);
                F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION = r113;
                TabType r114 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY", 10, 10);
                F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY = r114;
                TabType r115 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION", 11, 11);
                F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION = r115;
                TabType r106 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY", 12, 12);
                F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY = r106;
                TabType r107 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE", 13, 13);
                F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE = r107;
                TabType r108 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT", 14, 14);
                F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT = r108;
                TabType r109 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE", 15, 15);
                F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE = r109;
                TabType r116 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT", 16, 16);
                F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT = r116;
                $VALUES = new TabType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
                ADAPTER = ProtoAdapter.newEnumAdapter(TabType.class);
            }

            public static TabType[] values() {
                return (TabType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TabType fromValue(int r100) {
                switch(r100) {
                    case 0: goto L38;
                    case 1: goto L36;
                    case 2: goto L34;
                    case 3: goto L32;
                    case 4: goto L30;
                    case 5: goto L28;
                    case 6: goto L26;
                    case 7: goto L24;
                    case 8: goto L22;
                    case 9: goto L20;
                    case 10: goto L18;
                    case 11: goto L16;
                    case 12: goto L14;
                    case 13: goto L12;
                    case 14: goto L10;
                    case 15: goto L8;
                    case 16: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT;
            L8:
                return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE;
            L10:
                return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT;
            L12:
                return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE;
            L14:
                return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY;
            L16:
                return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION;
            L18:
                return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY;
            L20:
                return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION;
            L22:
                return F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY;
            L24:
                return F_BUILT_IN_PROFILE_MANAGE_OVERVIEW;
            L26:
                return F_BUILT_IN_PROFILE_MANAGE_ACTIVITY;
            L28:
                return F_OPEN_SECTION_CLUSTER;
            L30:
                return F_SECTION_CLUSTER;
            L32:
                return F_SINGLE_FIELD;
            L34:
                return F_COMMUNITY;
            L36:
                return F_COMMON_INFO;
            L38:
                return F_UNKNOWN;
            }

            public static TabType valueOf(String r100) {
                return (TabType) a.a(TabType.class, r100);
            }

            private TabType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TabInfo();
            DEFAULT_TAB_TYPE = TabType.F_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.name = this.name;
            r100.tab_type = this.tab_type;
            r100.content = this.content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TabInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TabInfo(String r100, I18nVal r101, TabType r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public TabInfo(String r100, I18nVal r101, TabType r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.key = r100;
            this.name = r101;
            this.tab_type = r102;
            this.content = r103;
        }
    }

    public static final class Text extends Message<Text, Builder> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Style style;
        public final I18nVal text;

        public static final class Builder extends Message.Builder<Text, Builder> {
            public Style style;
            public I18nVal text;

            @Override // com.squareup.wire.Message.Builder
            public Text build() {
                return new Text(this.text, this.style, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder style(Style r100) {
                this.style = r100;
                return this;
            }

            public Builder text(I18nVal r100) {
                this.text = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Text extends ProtoAdapter<Text> {
            public ProtoAdapter_Text() {
                super(FieldEncoding.LENGTH_DELIMITED, Text.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Text decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.text = I18nVal.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.style = Style.ADAPTER.decode(r100);
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
            public int encodedSize2(Text r100) {
                I18nVal r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Style r104 = r100.style;
                if (r104 == null) goto L10;
                r102 = Style.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Text decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Text r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Text r101) throws IOException {
                I18nVal r102 = r101.text;
                if (r102 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Style r103 = r101.style;
                if (r103 == null) goto L8;
                Style.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Text r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Text();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.style = this.style;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Text.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Text(I18nVal r100, Style r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Text(I18nVal r100, Style r101, ByteString r102) {
            super(ADAPTER, r102);
            this.text = r100;
            this.style = r101;
        }
    }

    public static final class TextList extends Message<TextList, Builder> {
        public static final ProtoAdapter<TextList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Text> text_list;

        public static final class Builder extends Message.Builder<TextList, Builder> {
            public List<Text> text_list;

            @Override // com.squareup.wire.Message.Builder
            public TextList build() {
                return new TextList(this.text_list, super.buildUnknownFields());
            }

            public Builder() {
                this.text_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder text_list(List<Text> r100) {
                Internal.checkElementsNotNull(r100);
                this.text_list = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TextList extends ProtoAdapter<TextList> {
            public ProtoAdapter_TextList() {
                super(FieldEncoding.LENGTH_DELIMITED, TextList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TextList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.text_list.add(Text.ADAPTER.decode(r100));
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
            public int encodedSize2(TextList r100) {
                return Text.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.text_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TextList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TextList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TextList r101) throws IOException {
                Text.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.text_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text_list = Internal.copyOf("text_list", this.text_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TextList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TextList(List<Text> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TextList(List<Text> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.text_list = Internal.immutableCopyOf("text_list", r100);
        }
    }

    public static final class UserInfo extends Message<UserInfo, Builder> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final String DEFAULT_ALIAS = "";
        public static final String DEFAULT_ANOTHER_NAME = "";
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final BlockStatus DEFAULT_BLOCK_STATUS = null;
        public static final Boolean DEFAULT_CAN_BLOCK = null;
        public static final Boolean DEFAULT_CAN_SET_STRANGER = null;
        public static final Long DEFAULT_CONTACT_APPLICATION_ID = null;
        public static final String DEFAULT_CONTACT_TOKEN = "";
        public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
        public static final Boolean DEFAULT_ENABLE_ADD_BY_CONTACT_TOKEN = null;
        public static final FriendStatus DEFAULT_FRIEND_STATUS = null;
        public static final Gender DEFAULT_GENDER = null;
        public static final String DEFAULT_GENDER_PRONOUNS = "";
        public static final Boolean DEFAULT_HAS_TENANT_CERTIFICATION = null;
        public static final Boolean DEFAULT_HIDE_ADD_CONNECT_BUTTON = null;
        public static final Boolean DEFAULT_IS_BLOCKED = null;
        public static final Boolean DEFAULT_IS_DEFAULT_AVATAR = null;
        public static final Boolean DEFAULT_IS_FROZEN = null;
        public static final Boolean DEFAULT_IS_REGISTERED = null;
        public static final Boolean DEFAULT_IS_RESIGNED = null;
        public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
        public static final Boolean DEFAULT_IS_STRANGER = null;
        public static final Boolean DEFAULT_IS_TENANT_CERTIFICATION = null;
        public static final String DEFAULT_LEADER_ID = "";
        public static final String DEFAULT_NAME_WITH_ANOTHER_NAME = "";
        public static final String DEFAULT_PROFILE_USER_NAME = "";
        public static final String DEFAULT_STR_CONTACT_APPLICATION_ID = "";
        public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
        public static final String DEFAULT_TENANT_ID = "";
        public static final TenantNameStatus DEFAULT_TENANT_NAME_STATUS = null;
        public static final String DEFAULT_USER_ID = "";
        public static final String DEFAULT_USER_NAME = "";
        public static final UserTag DEFAULT_USER_TAG = null;
        private static final long serialVersionUID = 0;
        public final String alias;
        public final String another_name;
        public final ApplyCommunication apply_communication;
        public final String avatar_key;
        public final AvatarMedal avatar_medal;
        public final BlockStatus block_status;
        public final Boolean can_block;
        public final Boolean can_set_stranger;
        public final CertificationInfo certification_info;
        public final List<Chatter.ChatterCustomStatus> chatter_status;
        public final Long contact_application_id;
        public final String contact_token;
        public final List<Field> custom_tag_fields;
        public final Chatter.Description description;
        public final Long do_not_disturb_end_time;
        public final Boolean enable_add_by_contact_token;
        public final FriendStatus friend_status;
        public final Gender gender;
        public final String gender_pronouns;
        public final Boolean has_tenant_certification;
        public final Boolean hide_add_connect_button;
        public final Boolean is_blocked;
        public final Boolean is_default_avatar;
        public final Boolean is_frozen;
        public final Boolean is_registered;
        public final Boolean is_resigned;
        public final Boolean is_special_focus;
        public final Boolean is_stranger;
        public final Boolean is_tenant_certification;
        public final String leader_id;
        public final MedalList medal_list;
        public final I18nVal meta_unit_description;
        public final String name_with_another_name;
        public final String profile_user_name;
        public final ShareInfo share_info;
        public final String str_contact_application_id;
        public final String tenant_certification_url;
        public final String tenant_id;
        public final I18nVal tenant_name;
        public final TenantNameStatus tenant_name_status;
        public final ImageSetPassThrough top_image;
        public final String user_id;
        public final String user_name;
        public final UserTag user_tag;
        public final WorkStatus work_status;

        public static final class ApplyCommunication extends Message<ApplyCommunication, Builder> {
            public static final ProtoAdapter<ApplyCommunication> ADAPTER = null;
            public static final ApplyCommunicationStatus DEFAULT_OPPOSITE_APPLY_STATUS = null;
            public static final ApplyCommunicationStatus DEFAULT_SELF_APPLY_STATUS = null;
            private static final long serialVersionUID = 0;
            public final ApplyCommunicationStatus opposite_apply_status;
            public final ApplyCommunicationStatus self_apply_status;

            public static final class Builder extends Message.Builder<ApplyCommunication, Builder> {
                public ApplyCommunicationStatus opposite_apply_status;
                public ApplyCommunicationStatus self_apply_status;

                @Override // com.squareup.wire.Message.Builder
                public ApplyCommunication build() {
                    return new ApplyCommunication(this.self_apply_status, this.opposite_apply_status, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder opposite_apply_status(ApplyCommunicationStatus r100) {
                    this.opposite_apply_status = r100;
                    return this;
                }

                public Builder self_apply_status(ApplyCommunicationStatus r100) {
                    this.self_apply_status = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ApplyCommunication extends ProtoAdapter<ApplyCommunication> {
                public ProtoAdapter_ApplyCommunication() {
                    super(FieldEncoding.LENGTH_DELIMITED, ApplyCommunication.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ApplyCommunication decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    ApplyCommunicationStatus r102 = ApplyCommunicationStatus.APPLY_UNKNOWN;
                    r101.self_apply_status = r102;
                    r101.opposite_apply_status = r102;
                    long r103 = r100.beginMessage();
                L3:
                    int r104 = r100.nextTag();
                    if (r104 == (-1)) goto L18;
                    if (r104 != 1) goto L8;
                    r101.self_apply_status = ApplyCommunicationStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r104 != 2) goto L9;
                    r101.opposite_apply_status = ApplyCommunicationStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                L12:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L9:
                    FieldEncoding r105 = r100.peekFieldEncoding();
                    r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r103);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(ApplyCommunication r100) {
                    ApplyCommunicationStatus r101 = r100.self_apply_status;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ApplyCommunicationStatus.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    ApplyCommunicationStatus r104 = r100.opposite_apply_status;
                    if (r104 == null) goto L10;
                    r102 = ApplyCommunicationStatus.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ApplyCommunication decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ApplyCommunication r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ApplyCommunication r101) throws IOException {
                    ApplyCommunicationStatus r102 = r101.self_apply_status;
                    if (r102 == null) goto L5;
                    ApplyCommunicationStatus.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    ApplyCommunicationStatus r103 = r101.opposite_apply_status;
                    if (r103 == null) goto L8;
                    ApplyCommunicationStatus.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ApplyCommunication r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ApplyCommunication();
                ApplyCommunicationStatus r100 = ApplyCommunicationStatus.APPLY_UNKNOWN;
                DEFAULT_SELF_APPLY_STATUS = r100;
                DEFAULT_OPPOSITE_APPLY_STATUS = r100;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.self_apply_status = this.self_apply_status;
                r100.opposite_apply_status = this.opposite_apply_status;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ApplyCommunication.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public ApplyCommunication(ApplyCommunicationStatus r100, ApplyCommunicationStatus r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public ApplyCommunication(ApplyCommunicationStatus r100, ApplyCommunicationStatus r101, ByteString r102) {
                super(ADAPTER, r102);
                this.self_apply_status = r100;
                this.opposite_apply_status = r101;
            }
        }

        public static final enum ApplyCommunicationStatus extends Enum<ApplyCommunicationStatus> implements WireEnum {
            private static final /* synthetic */ ApplyCommunicationStatus[] $VALUES = null;
            public static final ProtoAdapter<ApplyCommunicationStatus> ADAPTER = null;
            public static final ApplyCommunicationStatus APPLYING_CANNOT_APPLY = null;
            public static final ApplyCommunicationStatus APPLYING_CAN_APPLY = null;
            public static final ApplyCommunicationStatus APPLY_UNKNOWN = null;
            public static final ApplyCommunicationStatus CAN_APPLY = null;
            public static final ApplyCommunicationStatus CAN_NOT_APPLY = null;
            public static final ApplyCommunicationStatus PASS = null;
            private final int value;

            static {
                ApplyCommunicationStatus r100 = new ApplyCommunicationStatus("APPLY_UNKNOWN", 0, 0);
                APPLY_UNKNOWN = r100;
                ApplyCommunicationStatus r101 = new ApplyCommunicationStatus("PASS", 1, 1);
                PASS = r101;
                ApplyCommunicationStatus r102 = new ApplyCommunicationStatus("CAN_APPLY", 2, 2);
                CAN_APPLY = r102;
                ApplyCommunicationStatus r103 = new ApplyCommunicationStatus("APPLYING_CANNOT_APPLY", 3, 3);
                APPLYING_CANNOT_APPLY = r103;
                ApplyCommunicationStatus r104 = new ApplyCommunicationStatus("APPLYING_CAN_APPLY", 4, 4);
                APPLYING_CAN_APPLY = r104;
                ApplyCommunicationStatus r105 = new ApplyCommunicationStatus("CAN_NOT_APPLY", 5, 5);
                CAN_NOT_APPLY = r105;
                $VALUES = new ApplyCommunicationStatus[]{r100, r101, r102, r103, r104, r105};
                ADAPTER = ProtoAdapter.newEnumAdapter(ApplyCommunicationStatus.class);
            }

            public static ApplyCommunicationStatus[] values() {
                return (ApplyCommunicationStatus[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ApplyCommunicationStatus fromValue(int r100) {
                if (r100 == 0) goto L26;
                if (r100 == 1) goto L24;
                if (r100 == 2) goto L22;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L18;
                if (r100 == 5) goto L16;
                return null;
            L16:
                return CAN_NOT_APPLY;
            L18:
                return APPLYING_CAN_APPLY;
            L20:
                return APPLYING_CANNOT_APPLY;
            L22:
                return CAN_APPLY;
            L24:
                return PASS;
            L26:
                return APPLY_UNKNOWN;
            }

            public static ApplyCommunicationStatus valueOf(String r100) {
                return (ApplyCommunicationStatus) a.a(ApplyCommunicationStatus.class, r100);
            }

            private ApplyCommunicationStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum BlockStatus extends Enum<BlockStatus> implements WireEnum {
            private static final /* synthetic */ BlockStatus[] $VALUES = null;
            public static final ProtoAdapter<BlockStatus> ADAPTER = null;
            public static final BlockStatus B_DOUBLE = null;
            public static final BlockStatus B_FORWARD = null;
            public static final BlockStatus B_NONE = null;
            public static final BlockStatus B_REVERSE = null;
            public static final BlockStatus B_UNKNOWN = null;
            private final int value;

            static {
                BlockStatus r100 = new BlockStatus("B_UNKNOWN", 0, 0);
                B_UNKNOWN = r100;
                BlockStatus r101 = new BlockStatus("B_NONE", 1, 1);
                B_NONE = r101;
                BlockStatus r102 = new BlockStatus("B_FORWARD", 2, 2);
                B_FORWARD = r102;
                BlockStatus r103 = new BlockStatus("B_REVERSE", 3, 3);
                B_REVERSE = r103;
                BlockStatus r104 = new BlockStatus("B_DOUBLE", 4, 4);
                B_DOUBLE = r104;
                $VALUES = new BlockStatus[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(BlockStatus.class);
            }

            public static BlockStatus[] values() {
                return (BlockStatus[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static BlockStatus fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return B_DOUBLE;
            L16:
                return B_REVERSE;
            L18:
                return B_FORWARD;
            L20:
                return B_NONE;
            L22:
                return B_UNKNOWN;
            }

            public static BlockStatus valueOf(String r100) {
                return (BlockStatus) a.a(BlockStatus.class, r100);
            }

            private BlockStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Builder extends Message.Builder<UserInfo, Builder> {
            public String alias;
            public String another_name;
            public ApplyCommunication apply_communication;
            public String avatar_key;
            public AvatarMedal avatar_medal;
            public BlockStatus block_status;
            public Boolean can_block;
            public Boolean can_set_stranger;
            public CertificationInfo certification_info;
            public List<Chatter.ChatterCustomStatus> chatter_status;
            public Long contact_application_id;
            public String contact_token;
            public List<Field> custom_tag_fields;
            public Chatter.Description description;
            public Long do_not_disturb_end_time;
            public Boolean enable_add_by_contact_token;
            public FriendStatus friend_status;
            public Gender gender;
            public String gender_pronouns;
            public Boolean has_tenant_certification;
            public Boolean hide_add_connect_button;
            public Boolean is_blocked;
            public Boolean is_default_avatar;
            public Boolean is_frozen;
            public Boolean is_registered;
            public Boolean is_resigned;
            public Boolean is_special_focus;
            public Boolean is_stranger;
            public Boolean is_tenant_certification;
            public String leader_id;
            public MedalList medal_list;
            public I18nVal meta_unit_description;
            public String name_with_another_name;
            public String profile_user_name;
            public ShareInfo share_info;
            public String str_contact_application_id;
            public String tenant_certification_url;
            public String tenant_id;
            public I18nVal tenant_name;
            public TenantNameStatus tenant_name_status;
            public ImageSetPassThrough top_image;
            public String user_id;
            public String user_name;
            public UserTag user_tag;
            public WorkStatus work_status;

            @Override // com.squareup.wire.Message.Builder
            public UserInfo build() {
                return new UserInfo(this.friend_status, this.gender, this.tenant_name, this.contact_token, this.contact_application_id, this.enable_add_by_contact_token, this.leader_id, this.str_contact_application_id, this.is_blocked, this.block_status, this.user_tag, this.certification_info, this.is_tenant_certification, this.tenant_certification_url, this.has_tenant_certification, this.custom_tag_fields, this.top_image, this.share_info, this.medal_list, this.is_special_focus, this.gender_pronouns, this.meta_unit_description, this.can_block, this.apply_communication, this.hide_add_connect_button, this.can_set_stranger, this.is_stranger, this.user_id, this.user_name, this.tenant_id, this.is_resigned, this.do_not_disturb_end_time, this.work_status, this.avatar_key, this.is_registered, this.is_frozen, this.description, this.chatter_status, this.avatar_medal, this.name_with_another_name, this.another_name, this.alias, this.is_default_avatar, this.tenant_name_status, this.profile_user_name, super.buildUnknownFields());
            }

            public Builder() {
                this.custom_tag_fields = Internal.newMutableList();
                this.chatter_status = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder alias(String r100) {
                this.alias = r100;
                return this;
            }

            public Builder another_name(String r100) {
                this.another_name = r100;
                return this;
            }

            public Builder apply_communication(ApplyCommunication r100) {
                this.apply_communication = r100;
                return this;
            }

            public Builder avatar_key(String r100) {
                this.avatar_key = r100;
                return this;
            }

            public Builder avatar_medal(AvatarMedal r100) {
                this.avatar_medal = r100;
                return this;
            }

            public Builder block_status(BlockStatus r100) {
                this.block_status = r100;
                return this;
            }

            public Builder can_block(Boolean r100) {
                this.can_block = r100;
                return this;
            }

            public Builder can_set_stranger(Boolean r100) {
                this.can_set_stranger = r100;
                return this;
            }

            public Builder certification_info(CertificationInfo r100) {
                this.certification_info = r100;
                return this;
            }

            public Builder chatter_status(List<Chatter.ChatterCustomStatus> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatter_status = r100;
                return this;
            }

            public Builder contact_application_id(Long r100) {
                this.contact_application_id = r100;
                return this;
            }

            public Builder contact_token(String r100) {
                this.contact_token = r100;
                return this;
            }

            public Builder custom_tag_fields(List<Field> r100) {
                Internal.checkElementsNotNull(r100);
                this.custom_tag_fields = r100;
                return this;
            }

            public Builder description(Chatter.Description r100) {
                this.description = r100;
                return this;
            }

            public Builder do_not_disturb_end_time(Long r100) {
                this.do_not_disturb_end_time = r100;
                return this;
            }

            public Builder enable_add_by_contact_token(Boolean r100) {
                this.enable_add_by_contact_token = r100;
                return this;
            }

            public Builder friend_status(FriendStatus r100) {
                this.friend_status = r100;
                return this;
            }

            public Builder gender(Gender r100) {
                this.gender = r100;
                return this;
            }

            public Builder gender_pronouns(String r100) {
                this.gender_pronouns = r100;
                return this;
            }

            public Builder has_tenant_certification(Boolean r100) {
                this.has_tenant_certification = r100;
                return this;
            }

            public Builder hide_add_connect_button(Boolean r100) {
                this.hide_add_connect_button = r100;
                return this;
            }

            public Builder is_blocked(Boolean r100) {
                this.is_blocked = r100;
                return this;
            }

            public Builder is_default_avatar(Boolean r100) {
                this.is_default_avatar = r100;
                return this;
            }

            public Builder is_frozen(Boolean r100) {
                this.is_frozen = r100;
                return this;
            }

            public Builder is_registered(Boolean r100) {
                this.is_registered = r100;
                return this;
            }

            public Builder is_resigned(Boolean r100) {
                this.is_resigned = r100;
                return this;
            }

            public Builder is_special_focus(Boolean r100) {
                this.is_special_focus = r100;
                return this;
            }

            public Builder is_stranger(Boolean r100) {
                this.is_stranger = r100;
                return this;
            }

            public Builder is_tenant_certification(Boolean r100) {
                this.is_tenant_certification = r100;
                return this;
            }

            public Builder leader_id(String r100) {
                this.leader_id = r100;
                return this;
            }

            public Builder medal_list(MedalList r100) {
                this.medal_list = r100;
                return this;
            }

            public Builder meta_unit_description(I18nVal r100) {
                this.meta_unit_description = r100;
                return this;
            }

            public Builder name_with_another_name(String r100) {
                this.name_with_another_name = r100;
                return this;
            }

            public Builder profile_user_name(String r100) {
                this.profile_user_name = r100;
                return this;
            }

            public Builder share_info(ShareInfo r100) {
                this.share_info = r100;
                return this;
            }

            public Builder str_contact_application_id(String r100) {
                this.str_contact_application_id = r100;
                return this;
            }

            public Builder tenant_certification_url(String r100) {
                this.tenant_certification_url = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }

            public Builder tenant_name(I18nVal r100) {
                this.tenant_name = r100;
                return this;
            }

            public Builder tenant_name_status(TenantNameStatus r100) {
                this.tenant_name_status = r100;
                return this;
            }

            public Builder top_image(ImageSetPassThrough r100) {
                this.top_image = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }

            public Builder user_name(String r100) {
                this.user_name = r100;
                return this;
            }

            public Builder user_tag(UserTag r100) {
                this.user_tag = r100;
                return this;
            }

            public Builder work_status(WorkStatus r100) {
                this.work_status = r100;
                return this;
            }
        }

        public static final enum CertificateStatus extends Enum<CertificateStatus> implements WireEnum {
            private static final /* synthetic */ CertificateStatus[] $VALUES = null;
            public static final ProtoAdapter<CertificateStatus> ADAPTER = null;
            public static final CertificateStatus CERTIFICATED = null;
            public static final CertificateStatus EXPIRED = null;
            public static final CertificateStatus TEAM_CERTIFICATED = null;
            public static final CertificateStatus UNCERTIFICATED = null;
            private final int value;

            static {
                CertificateStatus r100 = new CertificateStatus("UNCERTIFICATED", 0, 0);
                UNCERTIFICATED = r100;
                CertificateStatus r101 = new CertificateStatus("CERTIFICATED", 1, 1);
                CERTIFICATED = r101;
                CertificateStatus r102 = new CertificateStatus("EXPIRED", 2, 2);
                EXPIRED = r102;
                CertificateStatus r103 = new CertificateStatus("TEAM_CERTIFICATED", 3, 3);
                TEAM_CERTIFICATED = r103;
                $VALUES = new CertificateStatus[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(CertificateStatus.class);
            }

            public static CertificateStatus[] values() {
                return (CertificateStatus[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static CertificateStatus fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return TEAM_CERTIFICATED;
            L14:
                return EXPIRED;
            L16:
                return CERTIFICATED;
            L18:
                return UNCERTIFICATED;
            }

            public static CertificateStatus valueOf(String r100) {
                return (CertificateStatus) a.a(CertificateStatus.class, r100);
            }

            private CertificateStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class CertificationInfo extends Message<CertificationInfo, Builder> {
            public static final ProtoAdapter<CertificationInfo> ADAPTER = null;
            public static final CertificateStatus DEFAULT_CERTIFICATE_STATUS = null;
            public static final Boolean DEFAULT_IS_SHOW_CERT_SIGN = null;
            public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
            private static final long serialVersionUID = 0;
            public final CertificateStatus certificate_status;
            public final Boolean is_show_cert_sign;
            public final String tenant_certification_url;

            public static final class Builder extends Message.Builder<CertificationInfo, Builder> {
                public CertificateStatus certificate_status;
                public Boolean is_show_cert_sign;
                public String tenant_certification_url;

                @Override // com.squareup.wire.Message.Builder
                public CertificationInfo build() {
                    return new CertificationInfo(this.is_show_cert_sign, this.certificate_status, this.tenant_certification_url, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder certificate_status(CertificateStatus r100) {
                    this.certificate_status = r100;
                    return this;
                }

                public Builder is_show_cert_sign(Boolean r100) {
                    this.is_show_cert_sign = r100;
                    return this;
                }

                public Builder tenant_certification_url(String r100) {
                    this.tenant_certification_url = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_CertificationInfo extends ProtoAdapter<CertificationInfo> {
                public ProtoAdapter_CertificationInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, CertificationInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public CertificationInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.is_show_cert_sign = Boolean.FALSE;
                    r101.certificate_status = CertificateStatus.UNCERTIFICATED;
                    r101.tenant_certification_url = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.is_show_cert_sign = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.certificate_status = CertificateStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.tenant_certification_url = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(CertificationInfo r100) {
                    Boolean r101 = r100.is_show_cert_sign;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
                L6:
                    CertificateStatus r104 = r100.certificate_status;
                    if (r104 == null) goto L9;
                    int r105 = CertificateStatus.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.tenant_certification_url;
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
                public /* bridge */ /* synthetic */ CertificationInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(CertificationInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, CertificationInfo r101) throws IOException {
                    Boolean r102 = r101.is_show_cert_sign;
                    if (r102 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
                L5:
                    CertificateStatus r103 = r101.certificate_status;
                    if (r103 == null) goto L8;
                    CertificateStatus.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.tenant_certification_url;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CertificationInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_CertificationInfo();
                DEFAULT_IS_SHOW_CERT_SIGN = Boolean.FALSE;
                DEFAULT_CERTIFICATE_STATUS = CertificateStatus.UNCERTIFICATED;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.is_show_cert_sign = this.is_show_cert_sign;
                r100.certificate_status = this.certificate_status;
                r100.tenant_certification_url = this.tenant_certification_url;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return CertificationInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public CertificationInfo(Boolean r100, CertificateStatus r101, String r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public CertificationInfo(Boolean r100, CertificateStatus r101, String r102, ByteString r103) {
                super(ADAPTER, r103);
                this.is_show_cert_sign = r100;
                this.certificate_status = r101;
                this.tenant_certification_url = r102;
            }
        }

        public static final enum FriendStatus extends Enum<FriendStatus> implements WireEnum {
            private static final /* synthetic */ FriendStatus[] $VALUES = null;
            public static final ProtoAdapter<FriendStatus> ADAPTER = null;
            public static final FriendStatus DOUBLE = null;
            public static final FriendStatus FORWARD = null;
            public static final FriendStatus NONE = null;
            public static final FriendStatus REVERSE = null;
            public static final FriendStatus UNKNOWN = null;
            private final int value;

            static {
                FriendStatus r100 = new FriendStatus("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                FriendStatus r101 = new FriendStatus("DOUBLE", 1, 1);
                DOUBLE = r101;
                FriendStatus r102 = new FriendStatus("FORWARD", 2, 2);
                FORWARD = r102;
                FriendStatus r103 = new FriendStatus("REVERSE", 3, 3);
                REVERSE = r103;
                FriendStatus r104 = new FriendStatus(UserProfileEvent.POSITION_NONE, 4, 4);
                NONE = r104;
                $VALUES = new FriendStatus[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(FriendStatus.class);
            }

            public static FriendStatus[] values() {
                return (FriendStatus[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FriendStatus fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return NONE;
            L16:
                return REVERSE;
            L18:
                return FORWARD;
            L20:
                return DOUBLE;
            L22:
                return UNKNOWN;
            }

            public static FriendStatus valueOf(String r100) {
                return (FriendStatus) a.a(FriendStatus.class, r100);
            }

            private FriendStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum Gender extends Enum<Gender> implements WireEnum {
            private static final /* synthetic */ Gender[] $VALUES = null;
            public static final ProtoAdapter<Gender> ADAPTER = null;
            public static final Gender DEFAULT = null;
            public static final Gender MAN = null;
            public static final Gender WOMAN = null;
            private final int value;

            static {
                Gender r100 = new Gender("DEFAULT", 0, 0);
                DEFAULT = r100;
                Gender r101 = new Gender(HTTP.MAN, 1, 1);
                MAN = r101;
                Gender r102 = new Gender("WOMAN", 2, 2);
                WOMAN = r102;
                $VALUES = new Gender[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Gender.class);
            }

            public static Gender[] values() {
                return (Gender[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Gender fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return WOMAN;
            L12:
                return MAN;
            L14:
                return DEFAULT;
            }

            public static Gender valueOf(String r100) {
                return (Gender) a.a(Gender.class, r100);
            }

            private Gender(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_UserInfo extends ProtoAdapter<UserInfo> {
            public ProtoAdapter_UserInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, UserInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.friend_status = FriendStatus.UNKNOWN;
                r101.gender = Gender.DEFAULT;
                r101.contact_token = "";
                r101.contact_application_id = 0L;
                Boolean r102 = Boolean.FALSE;
                r101.enable_add_by_contact_token = r102;
                r101.leader_id = "";
                r101.str_contact_application_id = "";
                r101.is_blocked = r102;
                r101.block_status = BlockStatus.B_UNKNOWN;
                r101.user_tag = UserTag.U_Default;
                r101.is_tenant_certification = r102;
                r101.tenant_certification_url = "";
                r101.has_tenant_certification = r102;
                r101.is_special_focus = r102;
                r101.gender_pronouns = "";
                r101.can_block = r102;
                r101.hide_add_connect_button = r102;
                r101.can_set_stranger = r102;
                r101.is_stranger = r102;
                r101.user_id = "";
                r101.user_name = "";
                r101.tenant_id = "";
                r101.is_resigned = r102;
                r101.do_not_disturb_end_time = 0L;
                r101.avatar_key = "";
                r101.is_registered = r102;
                r101.is_frozen = r102;
                r101.name_with_another_name = "";
                r101.another_name = "";
                r101.alias = "";
                r101.is_default_avatar = r102;
                r101.tenant_name_status = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
                r101.profile_user_name = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L76;
                if (r104 != 56) goto L8;
                r101.is_resigned = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 57) goto L10;
                r101.do_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r104 != 111) goto L11;
                r101.certification_info = CertificationInfo.ADAPTER.decode(r100);
                goto L3
            L11:
                switch(r104) {
                    case 1: goto L80;
                    case 2: goto L84;
                    case 3: goto L64;
                    case 4: goto L63;
                    case 5: goto L62;
                    case 6: goto L61;
                    case 7: goto L60;
                    case 8: goto L59;
                    case 9: goto L58;
                    case 10: goto L82;
                    case 11: goto L78;
                    case 12: goto L49;
                    case 13: goto L48;
                    case 14: goto L47;
                    case 15: goto L46;
                    case 16: goto L45;
                    case 17: goto L44;
                    case 18: goto L43;
                    case 19: goto L42;
                    case 20: goto L41;
                    case 21: goto L40;
                    default: goto L12;
                };
            L78:
                r101.user_tag = UserTag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L52
            L52:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L80:
                r101.friend_status = FriendStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L71
            L71:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L82:
                r101.block_status = BlockStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L56
            L56:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L84:
                r101.gender = Gender.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L67
            L67:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L40:
                r101.meta_unit_description = I18nVal.ADAPTER.decode(r100);
                goto L3
            L41:
                r101.gender_pronouns = ProtoAdapter.STRING.decode(r100);
                goto L3
            L42:
                r101.is_special_focus = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L43:
                r101.medal_list = MedalList.ADAPTER.decode(r100);
                goto L3
            L44:
                r101.share_info = ShareInfo.ADAPTER.decode(r100);
                goto L3
            L45:
                r101.top_image = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L46:
                r101.custom_tag_fields.add(Field.ADAPTER.decode(r100));
                goto L3
            L47:
                r101.has_tenant_certification = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L48:
                r101.tenant_certification_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L49:
                r101.is_tenant_certification = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L58:
                r101.is_blocked = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L59:
                r101.str_contact_application_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L60:
                r101.leader_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L61:
                r101.enable_add_by_contact_token = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L62:
                r101.contact_application_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L63:
                r101.contact_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L64:
                r101.tenant_name = I18nVal.ADAPTER.decode(r100);
                goto L3
            L12:
                switch(r104) {
                    case 23: goto L39;
                    case 24: goto L38;
                    case 25: goto L37;
                    case 26: goto L36;
                    case 27: goto L35;
                    default: goto L13;
                };
            L35:
                r101.is_stranger = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L36:
                r101.can_set_stranger = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L37:
                r101.hide_add_connect_button = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L38:
                r101.can_block = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L39:
                r101.apply_communication = ApplyCommunication.ADAPTER.decode(r100);
                goto L3
            L13:
                switch(r104) {
                    case 50: goto L34;
                    case 51: goto L33;
                    case 52: goto L32;
                    default: goto L14;
                };
            L32:
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L33:
                r101.user_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L34:
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                switch(r104) {
                    case 60: goto L31;
                    case 61: goto L30;
                    case 62: goto L29;
                    case 63: goto L28;
                    case 64: goto L27;
                    case 65: goto L26;
                    case 66: goto L25;
                    case 67: goto L24;
                    case 68: goto L23;
                    case 69: goto L22;
                    case 70: goto L21;
                    case 71: goto L86;
                    case 72: goto L16;
                    default: goto L15;
                };
            L86:
                r101.tenant_name_status = TenantNameStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L16:
                r101.profile_user_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L21:
                r101.is_default_avatar = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L22:
                r101.alias = ProtoAdapter.STRING.decode(r100);
                goto L3
            L23:
                r101.another_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L24:
                r101.name_with_another_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L25:
                r101.avatar_medal = AvatarMedal.ADAPTER.decode(r100);
                goto L3
            L26:
                r101.chatter_status.add(Chatter.ChatterCustomStatus.ADAPTER.decode(r100));
                goto L3
            L27:
                r101.description = Chatter.Description.ADAPTER.decode(r100);
                goto L3
            L28:
                r101.is_frozen = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L29:
                r101.is_registered = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L30:
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L31:
                r101.work_status = WorkStatus.ADAPTER.decode(r100);
                goto L3
            L15:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L76:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserInfo r100) {
                FriendStatus r101 = r100.friend_status;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = FriendStatus.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Gender r104 = r100.gender;
                if (r104 == null) goto L9;
                int r105 = Gender.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                I18nVal r107 = r100.tenant_name;
                if (r107 == null) goto L13;
                int r108 = I18nVal.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.contact_token;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Long r113 = r100.contact_application_id;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.enable_add_by_contact_token;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.leader_id;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.str_contact_application_id;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Boolean r125 = r100.is_blocked;
                if (r125 == null) goto L37;
                int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                BlockStatus r128 = r100.block_status;
                if (r128 == null) goto L41;
                int r129 = BlockStatus.ADAPTER.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                UserTag r131 = r100.user_tag;
                if (r131 == null) goto L45;
                int r132 = UserTag.ADAPTER.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                CertificationInfo r134 = r100.certification_info;
                if (r134 == null) goto L49;
                int r135 = CertificationInfo.ADAPTER.encodedSizeWithTag(111, r134);
            L50:
                int r136 = r133 + r135;
                Boolean r137 = r100.is_tenant_certification;
                if (r137 == null) goto L53;
                int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r137);
            L54:
                int r139 = r136 + r138;
                String r140 = r100.tenant_certification_url;
                if (r140 == null) goto L57;
                int r141 = ProtoAdapter.STRING.encodedSizeWithTag(13, r140);
            L58:
                int r142 = r139 + r141;
                Boolean r143 = r100.has_tenant_certification;
                if (r143 == null) goto L61;
                int r144 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r143);
            L62:
                int r145 = (r142 + r144) + Field.ADAPTER.asRepeated().encodedSizeWithTag(15, r100.custom_tag_fields);
                ImageSetPassThrough r146 = r100.top_image;
                if (r146 == null) goto L65;
                int r147 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(16, r146);
            L66:
                int r148 = r145 + r147;
                ShareInfo r149 = r100.share_info;
                if (r149 == null) goto L69;
                int r150 = ShareInfo.ADAPTER.encodedSizeWithTag(17, r149);
            L70:
                int r151 = r148 + r150;
                MedalList r152 = r100.medal_list;
                if (r152 == null) goto L73;
                int r153 = MedalList.ADAPTER.encodedSizeWithTag(18, r152);
            L74:
                int r154 = r151 + r153;
                Boolean r155 = r100.is_special_focus;
                if (r155 == null) goto L77;
                int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r155);
            L78:
                int r157 = r154 + r156;
                String r158 = r100.gender_pronouns;
                if (r158 == null) goto L81;
                int r159 = ProtoAdapter.STRING.encodedSizeWithTag(20, r158);
            L82:
                int r160 = r157 + r159;
                I18nVal r161 = r100.meta_unit_description;
                if (r161 == null) goto L85;
                int r162 = I18nVal.ADAPTER.encodedSizeWithTag(21, r161);
            L86:
                int r163 = r160 + r162;
                Boolean r164 = r100.can_block;
                if (r164 == null) goto L89;
                int r165 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r164);
            L90:
                int r166 = r163 + r165;
                ApplyCommunication r167 = r100.apply_communication;
                if (r167 == null) goto L93;
                int r168 = ApplyCommunication.ADAPTER.encodedSizeWithTag(23, r167);
            L94:
                int r169 = r166 + r168;
                Boolean r170 = r100.hide_add_connect_button;
                if (r170 == null) goto L97;
                int r171 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r170);
            L98:
                int r172 = r169 + r171;
                Boolean r173 = r100.can_set_stranger;
                if (r173 == null) goto L101;
                int r174 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r173);
            L102:
                int r175 = r172 + r174;
                Boolean r176 = r100.is_stranger;
                if (r176 == null) goto L105;
                int r177 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r176);
            L106:
                int r178 = r175 + r177;
                String r179 = r100.user_id;
                if (r179 == null) goto L109;
                int r180 = ProtoAdapter.STRING.encodedSizeWithTag(50, r179);
            L110:
                int r181 = r178 + r180;
                String r182 = r100.user_name;
                if (r182 == null) goto L113;
                int r183 = ProtoAdapter.STRING.encodedSizeWithTag(51, r182);
            L114:
                int r184 = r181 + r183;
                String r185 = r100.tenant_id;
                if (r185 == null) goto L117;
                int r186 = ProtoAdapter.STRING.encodedSizeWithTag(52, r185);
            L118:
                int r187 = r184 + r186;
                Boolean r188 = r100.is_resigned;
                if (r188 == null) goto L121;
                int r189 = ProtoAdapter.BOOL.encodedSizeWithTag(56, r188);
            L122:
                int r190 = r187 + r189;
                Long r191 = r100.do_not_disturb_end_time;
                if (r191 == null) goto L125;
                int r192 = ProtoAdapter.INT64.encodedSizeWithTag(57, r191);
            L126:
                int r193 = r190 + r192;
                WorkStatus r194 = r100.work_status;
                if (r194 == null) goto L129;
                int r195 = WorkStatus.ADAPTER.encodedSizeWithTag(60, r194);
            L130:
                int r196 = r193 + r195;
                String r197 = r100.avatar_key;
                if (r197 == null) goto L133;
                int r198 = ProtoAdapter.STRING.encodedSizeWithTag(61, r197);
            L134:
                int r199 = r196 + r198;
                Boolean r200 = r100.is_registered;
                if (r200 == null) goto L137;
                int r201 = ProtoAdapter.BOOL.encodedSizeWithTag(62, r200);
            L138:
                int r202 = r199 + r201;
                Boolean r203 = r100.is_frozen;
                if (r203 == null) goto L141;
                int r204 = ProtoAdapter.BOOL.encodedSizeWithTag(63, r203);
            L142:
                int r205 = r202 + r204;
                Chatter.Description r206 = r100.description;
                if (r206 == null) goto L145;
                int r207 = Chatter.Description.ADAPTER.encodedSizeWithTag(64, r206);
            L146:
                int r208 = (r205 + r207) + Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(65, r100.chatter_status);
                AvatarMedal r209 = r100.avatar_medal;
                if (r209 == null) goto L149;
                int r210 = AvatarMedal.ADAPTER.encodedSizeWithTag(66, r209);
            L150:
                int r211 = r208 + r210;
                String r212 = r100.name_with_another_name;
                if (r212 == null) goto L153;
                int r213 = ProtoAdapter.STRING.encodedSizeWithTag(67, r212);
            L154:
                int r214 = r211 + r213;
                String r215 = r100.another_name;
                if (r215 == null) goto L157;
                int r216 = ProtoAdapter.STRING.encodedSizeWithTag(68, r215);
            L158:
                int r217 = r214 + r216;
                String r218 = r100.alias;
                if (r218 == null) goto L161;
                int r219 = ProtoAdapter.STRING.encodedSizeWithTag(69, r218);
            L162:
                int r220 = r217 + r219;
                Boolean r221 = r100.is_default_avatar;
                if (r221 == null) goto L165;
                int r222 = ProtoAdapter.BOOL.encodedSizeWithTag(70, r221);
            L166:
                int r223 = r220 + r222;
                TenantNameStatus r224 = r100.tenant_name_status;
                if (r224 == null) goto L169;
                int r225 = TenantNameStatus.ADAPTER.encodedSizeWithTag(71, r224);
            L170:
                int r226 = r223 + r225;
                String r227 = r100.profile_user_name;
                if (r227 == null) goto L174;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(72, r227);
            L174:
                return (r226 + r102) + r100.unknownFields().size();
            L169:
                r225 = 0;
                goto L170
            L165:
                r222 = 0;
                goto L166
            L161:
                r219 = 0;
                goto L162
            L157:
                r216 = 0;
                goto L158
            L153:
                r213 = 0;
                goto L154
            L149:
                r210 = 0;
                goto L150
            L145:
                r207 = 0;
                goto L146
            L141:
                r204 = 0;
                goto L142
            L137:
                r201 = 0;
                goto L138
            L133:
                r198 = 0;
                goto L134
            L129:
                r195 = 0;
                goto L130
            L125:
                r192 = 0;
                goto L126
            L121:
                r189 = 0;
                goto L122
            L117:
                r186 = 0;
                goto L118
            L113:
                r183 = 0;
                goto L114
            L109:
                r180 = 0;
                goto L110
            L105:
                r177 = 0;
                goto L106
            L101:
                r174 = 0;
                goto L102
            L97:
                r171 = 0;
                goto L98
            L93:
                r168 = 0;
                goto L94
            L89:
                r165 = 0;
                goto L90
            L85:
                r162 = 0;
                goto L86
            L81:
                r159 = 0;
                goto L82
            L77:
                r156 = 0;
                goto L78
            L73:
                r153 = 0;
                goto L74
            L69:
                r150 = 0;
                goto L70
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
            public /* bridge */ /* synthetic */ UserInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserInfo r101) throws IOException {
                FriendStatus r102 = r101.friend_status;
                if (r102 == null) goto L5;
                FriendStatus.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Gender r103 = r101.gender;
                if (r103 == null) goto L8;
                Gender.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                I18nVal r104 = r101.tenant_name;
                if (r104 == null) goto L11;
                I18nVal.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.contact_token;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Long r106 = r101.contact_application_id;
                if (r106 == null) goto L17;
                ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.enable_add_by_contact_token;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.leader_id;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.str_contact_application_id;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
            L26:
                Boolean r110 = r101.is_blocked;
                if (r110 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
            L29:
                BlockStatus r111 = r101.block_status;
                if (r111 == null) goto L32;
                BlockStatus.ADAPTER.encodeWithTag(r100, 10, r111);
            L32:
                UserTag r112 = r101.user_tag;
                if (r112 == null) goto L35;
                UserTag.ADAPTER.encodeWithTag(r100, 11, r112);
            L35:
                CertificationInfo r113 = r101.certification_info;
                if (r113 == null) goto L38;
                CertificationInfo.ADAPTER.encodeWithTag(r100, 111, r113);
            L38:
                Boolean r114 = r101.is_tenant_certification;
                if (r114 == null) goto L41;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r114);
            L41:
                String r115 = r101.tenant_certification_url;
                if (r115 == null) goto L44;
                ProtoAdapter.STRING.encodeWithTag(r100, 13, r115);
            L44:
                Boolean r116 = r101.has_tenant_certification;
                if (r116 == null) goto L47;
                ProtoAdapter.BOOL.encodeWithTag(r100, 14, r116);
            L47:
                Field.ADAPTER.asRepeated().encodeWithTag(r100, 15, r101.custom_tag_fields);
                ImageSetPassThrough r117 = r101.top_image;
                if (r117 == null) goto L50;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 16, r117);
            L50:
                ShareInfo r118 = r101.share_info;
                if (r118 == null) goto L53;
                ShareInfo.ADAPTER.encodeWithTag(r100, 17, r118);
            L53:
                MedalList r119 = r101.medal_list;
                if (r119 == null) goto L56;
                MedalList.ADAPTER.encodeWithTag(r100, 18, r119);
            L56:
                Boolean r120 = r101.is_special_focus;
                if (r120 == null) goto L59;
                ProtoAdapter.BOOL.encodeWithTag(r100, 19, r120);
            L59:
                String r121 = r101.gender_pronouns;
                if (r121 == null) goto L62;
                ProtoAdapter.STRING.encodeWithTag(r100, 20, r121);
            L62:
                I18nVal r122 = r101.meta_unit_description;
                if (r122 == null) goto L65;
                I18nVal.ADAPTER.encodeWithTag(r100, 21, r122);
            L65:
                Boolean r123 = r101.can_block;
                if (r123 == null) goto L68;
                ProtoAdapter.BOOL.encodeWithTag(r100, 24, r123);
            L68:
                ApplyCommunication r124 = r101.apply_communication;
                if (r124 == null) goto L71;
                ApplyCommunication.ADAPTER.encodeWithTag(r100, 23, r124);
            L71:
                Boolean r125 = r101.hide_add_connect_button;
                if (r125 == null) goto L74;
                ProtoAdapter.BOOL.encodeWithTag(r100, 25, r125);
            L74:
                Boolean r126 = r101.can_set_stranger;
                if (r126 == null) goto L77;
                ProtoAdapter.BOOL.encodeWithTag(r100, 26, r126);
            L77:
                Boolean r127 = r101.is_stranger;
                if (r127 == null) goto L80;
                ProtoAdapter.BOOL.encodeWithTag(r100, 27, r127);
            L80:
                String r128 = r101.user_id;
                if (r128 == null) goto L83;
                ProtoAdapter.STRING.encodeWithTag(r100, 50, r128);
            L83:
                String r129 = r101.user_name;
                if (r129 == null) goto L86;
                ProtoAdapter.STRING.encodeWithTag(r100, 51, r129);
            L86:
                String r130 = r101.tenant_id;
                if (r130 == null) goto L89;
                ProtoAdapter.STRING.encodeWithTag(r100, 52, r130);
            L89:
                Boolean r131 = r101.is_resigned;
                if (r131 == null) goto L92;
                ProtoAdapter.BOOL.encodeWithTag(r100, 56, r131);
            L92:
                Long r132 = r101.do_not_disturb_end_time;
                if (r132 == null) goto L95;
                ProtoAdapter.INT64.encodeWithTag(r100, 57, r132);
            L95:
                WorkStatus r133 = r101.work_status;
                if (r133 == null) goto L98;
                WorkStatus.ADAPTER.encodeWithTag(r100, 60, r133);
            L98:
                String r134 = r101.avatar_key;
                if (r134 == null) goto L101;
                ProtoAdapter.STRING.encodeWithTag(r100, 61, r134);
            L101:
                Boolean r135 = r101.is_registered;
                if (r135 == null) goto L104;
                ProtoAdapter.BOOL.encodeWithTag(r100, 62, r135);
            L104:
                Boolean r136 = r101.is_frozen;
                if (r136 == null) goto L107;
                ProtoAdapter.BOOL.encodeWithTag(r100, 63, r136);
            L107:
                Chatter.Description r137 = r101.description;
                if (r137 == null) goto L110;
                Chatter.Description.ADAPTER.encodeWithTag(r100, 64, r137);
            L110:
                Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 65, r101.chatter_status);
                AvatarMedal r138 = r101.avatar_medal;
                if (r138 == null) goto L113;
                AvatarMedal.ADAPTER.encodeWithTag(r100, 66, r138);
            L113:
                String r139 = r101.name_with_another_name;
                if (r139 == null) goto L116;
                ProtoAdapter.STRING.encodeWithTag(r100, 67, r139);
            L116:
                String r140 = r101.another_name;
                if (r140 == null) goto L119;
                ProtoAdapter.STRING.encodeWithTag(r100, 68, r140);
            L119:
                String r141 = r101.alias;
                if (r141 == null) goto L122;
                ProtoAdapter.STRING.encodeWithTag(r100, 69, r141);
            L122:
                Boolean r142 = r101.is_default_avatar;
                if (r142 == null) goto L125;
                ProtoAdapter.BOOL.encodeWithTag(r100, 70, r142);
            L125:
                TenantNameStatus r143 = r101.tenant_name_status;
                if (r143 == null) goto L128;
                TenantNameStatus.ADAPTER.encodeWithTag(r100, 71, r143);
            L128:
                String r144 = r101.profile_user_name;
                if (r144 == null) goto L131;
                ProtoAdapter.STRING.encodeWithTag(r100, 72, r144);
            L131:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum UserTag extends Enum<UserTag> implements WireEnum {
            private static final /* synthetic */ UserTag[] $VALUES = null;
            public static final ProtoAdapter<UserTag> ADAPTER = null;
            public static final UserTag U_Default = null;
            public static final UserTag U_Parent = null;
            public static final UserTag U_Student = null;
            private final int value;

            static {
                UserTag r100 = new UserTag("U_Default", 0, 0);
                U_Default = r100;
                UserTag r101 = new UserTag("U_Student", 1, 1);
                U_Student = r101;
                UserTag r102 = new UserTag("U_Parent", 2, 2);
                U_Parent = r102;
                $VALUES = new UserTag[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(UserTag.class);
            }

            public static UserTag[] values() {
                return (UserTag[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static UserTag fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return U_Parent;
            L12:
                return U_Student;
            L14:
                return U_Default;
            }

            public static UserTag valueOf(String r100) {
                return (UserTag) a.a(UserTag.class, r100);
            }

            private UserTag(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserInfo();
            DEFAULT_FRIEND_STATUS = FriendStatus.UNKNOWN;
            DEFAULT_GENDER = Gender.DEFAULT;
            DEFAULT_CONTACT_APPLICATION_ID = 0L;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ENABLE_ADD_BY_CONTACT_TOKEN = r100;
            DEFAULT_IS_BLOCKED = r100;
            DEFAULT_BLOCK_STATUS = BlockStatus.B_UNKNOWN;
            DEFAULT_USER_TAG = UserTag.U_Default;
            DEFAULT_IS_TENANT_CERTIFICATION = r100;
            DEFAULT_HAS_TENANT_CERTIFICATION = r100;
            DEFAULT_IS_SPECIAL_FOCUS = r100;
            DEFAULT_CAN_BLOCK = r100;
            DEFAULT_HIDE_ADD_CONNECT_BUTTON = r100;
            DEFAULT_CAN_SET_STRANGER = r100;
            DEFAULT_IS_STRANGER = r100;
            DEFAULT_IS_RESIGNED = r100;
            DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
            DEFAULT_IS_REGISTERED = r100;
            DEFAULT_IS_FROZEN = r100;
            DEFAULT_IS_DEFAULT_AVATAR = r100;
            DEFAULT_TENANT_NAME_STATUS = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.friend_status = this.friend_status;
            r100.gender = this.gender;
            r100.tenant_name = this.tenant_name;
            r100.contact_token = this.contact_token;
            r100.contact_application_id = this.contact_application_id;
            r100.enable_add_by_contact_token = this.enable_add_by_contact_token;
            r100.leader_id = this.leader_id;
            r100.str_contact_application_id = this.str_contact_application_id;
            r100.is_blocked = this.is_blocked;
            r100.block_status = this.block_status;
            r100.user_tag = this.user_tag;
            r100.certification_info = this.certification_info;
            r100.is_tenant_certification = this.is_tenant_certification;
            r100.tenant_certification_url = this.tenant_certification_url;
            r100.has_tenant_certification = this.has_tenant_certification;
            r100.custom_tag_fields = Internal.copyOf("custom_tag_fields", this.custom_tag_fields);
            r100.top_image = this.top_image;
            r100.share_info = this.share_info;
            r100.medal_list = this.medal_list;
            r100.is_special_focus = this.is_special_focus;
            r100.gender_pronouns = this.gender_pronouns;
            r100.meta_unit_description = this.meta_unit_description;
            r100.can_block = this.can_block;
            r100.apply_communication = this.apply_communication;
            r100.hide_add_connect_button = this.hide_add_connect_button;
            r100.can_set_stranger = this.can_set_stranger;
            r100.is_stranger = this.is_stranger;
            r100.user_id = this.user_id;
            r100.user_name = this.user_name;
            r100.tenant_id = this.tenant_id;
            r100.is_resigned = this.is_resigned;
            r100.do_not_disturb_end_time = this.do_not_disturb_end_time;
            r100.work_status = this.work_status;
            r100.avatar_key = this.avatar_key;
            r100.is_registered = this.is_registered;
            r100.is_frozen = this.is_frozen;
            r100.description = this.description;
            r100.chatter_status = Internal.copyOf("chatter_status", this.chatter_status);
            r100.avatar_medal = this.avatar_medal;
            r100.name_with_another_name = this.name_with_another_name;
            r100.another_name = this.another_name;
            r100.alias = this.alias;
            r100.is_default_avatar = this.is_default_avatar;
            r100.tenant_name_status = this.tenant_name_status;
            r100.profile_user_name = this.profile_user_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserInfo(FriendStatus r410, Gender r411, I18nVal r510, String r511, Long r512, Boolean r513, String r514, String r515, Boolean r516, BlockStatus r517, UserTag r518, CertificationInfo r519, Boolean r610, String r611, Boolean r612, List<Field> r613, ImageSetPassThrough r614, ShareInfo r615, MedalList r616, Boolean r617, String r618, I18nVal r619, Boolean r710, ApplyCommunication r711, Boolean r712, Boolean r713, Boolean r714, String r715, String r716, String r717, Boolean r718, Long r719, WorkStatus r810, String r811, Boolean r812, Boolean r813, Chatter.Description r814, List<Chatter.ChatterCustomStatus> r815, AvatarMedal r816, String r817, String r818, String r819, Boolean r910, TenantNameStatus r911, String r912) {
            this(r410, r411, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, ByteString.EMPTY);
        }

        public UserInfo(FriendStatus r100, Gender r101, I18nVal r102, String r103, Long r104, Boolean r105, String r110, String r111, Boolean r112, BlockStatus r113, UserTag r114, CertificationInfo r115, Boolean r116, String r117, Boolean r118, List<Field> r119, ImageSetPassThrough r210, ShareInfo r211, MedalList r212, Boolean r213, String r214, I18nVal r215, Boolean r216, ApplyCommunication r217, Boolean r218, Boolean r219, Boolean r310, String r311, String r312, String r313, Boolean r314, Long r315, WorkStatus r316, String r317, Boolean r318, Boolean r319, Chatter.Description r410, List<Chatter.ChatterCustomStatus> r411, AvatarMedal r412, String r413, String r414, String r415, Boolean r416, TenantNameStatus r417, String r418, ByteString r419) {
            super(ADAPTER, r419);
            this.friend_status = r100;
            this.gender = r101;
            this.tenant_name = r102;
            this.contact_token = r103;
            this.contact_application_id = r104;
            this.enable_add_by_contact_token = r105;
            this.leader_id = r110;
            this.str_contact_application_id = r111;
            this.is_blocked = r112;
            this.block_status = r113;
            this.user_tag = r114;
            this.certification_info = r115;
            this.is_tenant_certification = r116;
            this.tenant_certification_url = r117;
            this.has_tenant_certification = r118;
            this.custom_tag_fields = Internal.immutableCopyOf("custom_tag_fields", r119);
            this.top_image = r210;
            this.share_info = r211;
            this.medal_list = r212;
            this.is_special_focus = r213;
            this.gender_pronouns = r214;
            this.meta_unit_description = r215;
            this.can_block = r216;
            this.apply_communication = r217;
            this.hide_add_connect_button = r218;
            this.can_set_stranger = r219;
            this.is_stranger = r310;
            this.user_id = r311;
            this.user_name = r312;
            this.tenant_id = r313;
            this.is_resigned = r314;
            this.do_not_disturb_end_time = r315;
            this.work_status = r316;
            this.avatar_key = r317;
            this.is_registered = r318;
            this.is_frozen = r319;
            this.description = r410;
            this.chatter_status = Internal.immutableCopyOf("chatter_status", r411);
            this.avatar_medal = r412;
            this.name_with_another_name = r413;
            this.another_name = r414;
            this.alias = r415;
            this.is_default_avatar = r416;
            this.tenant_name_status = r417;
            this.profile_user_name = r418;
        }
    }

    static {
        ProtoAdapter_GetUserProfileResponse r100 = new ProtoAdapter_GetUserProfileResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_info = this.user_info;
        r100.cta_orders = Internal.copyOf("cta_orders", this.cta_orders);
        r100.field_orders = Internal.copyOf("field_orders", this.field_orders);
        r100.permission = this.permission;
        r100.tab_orders = Internal.copyOf("tab_orders", this.tab_orders);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserProfileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserProfileResponse(UserInfo r100, List<CTA> r101, List<Field> r110, Permission r111, List<TabInfo> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetUserProfileResponse(UserInfo r100, List<CTA> r101, List<Field> r102, Permission r103, List<TabInfo> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.user_info = r100;
        this.cta_orders = Internal.immutableCopyOf("cta_orders", r101);
        this.field_orders = Internal.immutableCopyOf("field_orders", r102);
        this.permission = r103;
        this.tab_orders = Internal.immutableCopyOf("tab_orders", r104);
    }
}
