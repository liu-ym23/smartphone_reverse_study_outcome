package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.ContactSource;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetDoubaoProfileResponse extends Message<GetDoubaoProfileResponse, Builder> {
    public static final ProtoAdapter<GetDoubaoProfileResponse> ADAPTER = null;
    public static final GetDoubaoProfileRequest.DoubaoProfileEdition DEFAULT_EDITION = null;
    public static final ProtoAdapter_GetDoubaoProfileResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<CTAInfo> cta_info_list;
    public final GetDoubaoProfileRequest.DoubaoProfileEdition edition;
    public final UserInfo user_info;

    public static final enum BlockStatus extends Enum<BlockStatus> implements WireEnum {
        private static final /* synthetic */ BlockStatus[] $VALUES = null;
        public static final ProtoAdapter<BlockStatus> ADAPTER = null;
        public static final BlockStatus BLOCK_DUAL = null;
        public static final BlockStatus BLOCK_FORWARD = null;
        public static final BlockStatus BLOCK_NONE = null;
        public static final BlockStatus BLOCK_REVERSE = null;
        public static final BlockStatus BLOCK_UNKNOWN = null;
        private final int value;

        static {
            BlockStatus r100 = new BlockStatus("BLOCK_UNKNOWN", 0, 0);
            BLOCK_UNKNOWN = r100;
            BlockStatus r101 = new BlockStatus("BLOCK_NONE", 1, 1);
            BLOCK_NONE = r101;
            BlockStatus r102 = new BlockStatus("BLOCK_FORWARD", 2, 2);
            BLOCK_FORWARD = r102;
            BlockStatus r103 = new BlockStatus("BLOCK_REVERSE", 3, 3);
            BLOCK_REVERSE = r103;
            BlockStatus r104 = new BlockStatus("BLOCK_DUAL", 4, 4);
            BLOCK_DUAL = r104;
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
            return BLOCK_DUAL;
        L16:
            return BLOCK_REVERSE;
        L18:
            return BLOCK_FORWARD;
        L20:
            return BLOCK_NONE;
        L22:
            return BLOCK_UNKNOWN;
        }

        public static BlockStatus valueOf(String r100) {
            return (BlockStatus) a.a(BlockStatus.class, r100);
        }

        private BlockStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<GetDoubaoProfileResponse, Builder> implements d<GetDoubaoProfileResponse> {
        public List<CTAInfo> cta_info_list;
        public GetDoubaoProfileRequest.DoubaoProfileEdition edition;
        public UserInfo user_info;

        @Override // com.squareup.wire.Message.Builder
        public GetDoubaoProfileResponse build() {
            return new GetDoubaoProfileResponse(this.cta_info_list, this.user_info, this.edition, super.buildUnknownFields());
        }

        public Builder() {
            this.cta_info_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cta_info_list(List<CTAInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.cta_info_list = r100;
            return this;
        }

        public Builder edition(GetDoubaoProfileRequest.DoubaoProfileEdition r100) {
            this.edition = r100;
            return this;
        }

        public Builder user_info(UserInfo r100) {
            this.user_info = r100;
            return this;
        }
    }

    public static final class CTAInfo extends Message<CTAInfo, Builder> {
        public static final ProtoAdapter<CTAInfo> ADAPTER = null;
        public static final CTAType DEFAULT_CTA_TYPE = null;
        public static final DeniedReason DEFAULT_DENIED_REASON = null;
        public static final Boolean DEFAULT_ENABLE = null;
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final CTAType cta_type;
        public final I18nVal denied_description;
        public final DeniedReason denied_reason;
        public final Boolean enable;
        public final I18nVal i18n_name;
        public final String key;

        public static final class Builder extends Message.Builder<CTAInfo, Builder> {
            public CTAType cta_type;
            public I18nVal denied_description;
            public DeniedReason denied_reason;
            public Boolean enable;
            public I18nVal i18n_name;
            public String key;

            @Override // com.squareup.wire.Message.Builder
            public CTAInfo build() {
                return new CTAInfo(this.key, this.i18n_name, this.cta_type, this.enable, this.denied_reason, this.denied_description, super.buildUnknownFields());
            }

            public Builder() {
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

            public Builder denied_reason(DeniedReason r100) {
                this.denied_reason = r100;
                return this;
            }

            public Builder enable(Boolean r100) {
                this.enable = r100;
                return this;
            }

            public Builder i18n_name(I18nVal r100) {
                this.i18n_name = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CTAInfo extends ProtoAdapter<CTAInfo> {
            public ProtoAdapter_CTAInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CTAInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CTAInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.cta_type = CTAType.CHAT;
                r101.enable = Boolean.FALSE;
                r101.denied_reason = DeniedReason.UNKNOWN_REASON;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L21;
                    case 4: goto L12;
                    case 5: goto L23;
                    case 6: goto L7;
                    default: goto L6;
                };
            L21:
                r101.cta_type = CTAType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L23:
                r101.denied_reason = DeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.denied_description = I18nVal.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L17:
                r101.i18n_name = I18nVal.ADAPTER.decode(r100);
                goto L3
            L18:
                r101.key = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(CTAInfo r100) {
                String r101 = r100.key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.i18n_name;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                CTAType r107 = r100.cta_type;
                if (r107 == null) goto L13;
                int r108 = CTAType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.enable;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                DeniedReason r113 = r100.denied_reason;
                if (r113 == null) goto L21;
                int r114 = DeniedReason.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                I18nVal r116 = r100.denied_description;
                if (r116 == null) goto L26;
                r102 = I18nVal.ADAPTER.encodedSizeWithTag(6, r116);
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
            public /* bridge */ /* synthetic */ CTAInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CTAInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CTAInfo r101) throws IOException {
                String r102 = r101.key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.i18n_name;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                CTAType r104 = r101.cta_type;
                if (r104 == null) goto L11;
                CTAType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.enable;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                DeniedReason r106 = r101.denied_reason;
                if (r106 == null) goto L17;
                DeniedReason.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                I18nVal r107 = r101.denied_description;
                if (r107 == null) goto L20;
                I18nVal.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CTAInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CTAInfo();
            DEFAULT_CTA_TYPE = CTAType.CHAT;
            DEFAULT_ENABLE = Boolean.FALSE;
            DEFAULT_DENIED_REASON = DeniedReason.UNKNOWN_REASON;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.i18n_name = this.i18n_name;
            r100.cta_type = this.cta_type;
            r100.enable = this.enable;
            r100.denied_reason = this.denied_reason;
            r100.denied_description = this.denied_description;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CTAInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CTAInfo(String r100, I18nVal r110, CTAType r111, Boolean r112, DeniedReason r113, I18nVal r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public CTAInfo(String r100, I18nVal r101, CTAType r102, Boolean r103, DeniedReason r104, I18nVal r105, ByteString r106) {
            super(ADAPTER, r106);
            this.key = r100;
            this.i18n_name = r101;
            this.cta_type = r102;
            this.enable = r103;
            this.denied_reason = r104;
            this.denied_description = r105;
        }
    }

    public static final enum CTAType extends Enum<CTAType> implements WireEnum {
        private static final /* synthetic */ CTAType[] $VALUES = null;
        public static final ProtoAdapter<CTAType> ADAPTER = null;
        public static final CTAType CHAT = null;
        private final int value;

        static {
            CTAType r100 = new CTAType("CHAT", 0, 1);
            CHAT = r100;
            $VALUES = new CTAType[]{r100};
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
            if (r100 == 1) goto L7;
            return null;
        L7:
            return CHAT;
        }

        public static CTAType valueOf(String r100) {
            return (CTAType) a.a(CTAType.class, r100);
        }

        private CTAType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class CityInfo extends Message<CityInfo, Builder> {
        public static final ProtoAdapter<CityInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal city;

        public static final class Builder extends Message.Builder<CityInfo, Builder> {
            public I18nVal city;

            @Override // com.squareup.wire.Message.Builder
            public CityInfo build() {
                return new CityInfo(this.city, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder city(I18nVal r100) {
                this.city = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CityInfo extends ProtoAdapter<CityInfo> {
            public ProtoAdapter_CityInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CityInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CityInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.city = I18nVal.ADAPTER.decode(r100);
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
            public int encodedSize2(CityInfo r100) {
                I18nVal r101 = r100.city;
                if (r101 == null) goto L5;
                int r102 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CityInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CityInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CityInfo r101) throws IOException {
                I18nVal r102 = r101.city;
                if (r102 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CityInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CityInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.city = this.city;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CityInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CityInfo(I18nVal r100) {
            this(r100, ByteString.EMPTY);
        }

        public CityInfo(I18nVal r100, ByteString r101) {
            super(ADAPTER, r101);
            this.city = r100;
        }
    }

    public static final enum ContactStatus extends Enum<ContactStatus> implements WireEnum {
        private static final /* synthetic */ ContactStatus[] $VALUES = null;
        public static final ProtoAdapter<ContactStatus> ADAPTER = null;
        public static final ContactStatus CONTACT_DUAL = null;
        public static final ContactStatus CONTACT_FORWARD = null;
        public static final ContactStatus CONTACT_NONE = null;
        public static final ContactStatus CONTACT_REVERSE = null;
        public static final ContactStatus CONTACT_UNKNOWN = null;
        private final int value;

        static {
            ContactStatus r100 = new ContactStatus("CONTACT_UNKNOWN", 0, 0);
            CONTACT_UNKNOWN = r100;
            ContactStatus r101 = new ContactStatus("CONTACT_DUAL", 1, 1);
            CONTACT_DUAL = r101;
            ContactStatus r102 = new ContactStatus("CONTACT_FORWARD", 2, 2);
            CONTACT_FORWARD = r102;
            ContactStatus r103 = new ContactStatus("CONTACT_REVERSE", 3, 3);
            CONTACT_REVERSE = r103;
            ContactStatus r104 = new ContactStatus("CONTACT_NONE", 4, 4);
            CONTACT_NONE = r104;
            $VALUES = new ContactStatus[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContactStatus.class);
        }

        public static ContactStatus[] values() {
            return (ContactStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ContactStatus fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return CONTACT_NONE;
        L16:
            return CONTACT_REVERSE;
        L18:
            return CONTACT_FORWARD;
        L20:
            return CONTACT_DUAL;
        L22:
            return CONTACT_UNKNOWN;
        }

        public static ContactStatus valueOf(String r100) {
            return (ContactStatus) a.a(ContactStatus.class, r100);
        }

        private ContactStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum DeniedReason extends Enum<DeniedReason> implements WireEnum {
        private static final /* synthetic */ DeniedReason[] $VALUES = null;
        public static final ProtoAdapter<DeniedReason> ADAPTER = null;
        public static final DeniedReason BE_BLOCKED = null;
        public static final DeniedReason BLOCKED = null;
        public static final DeniedReason CROSS_TENANT_DENY = null;
        public static final DeniedReason CRYPTO_CHAT_DENY = null;
        public static final DeniedReason EXTERNAL_COORDINATE_CTL = null;
        public static final DeniedReason NOT_SUPPORT_AI = null;
        public static final DeniedReason NO_FRIENDSHIP = null;
        public static final DeniedReason PRIVACY_SETTING = null;
        public static final DeniedReason PRIVATE_CALENDAR = null;
        public static final DeniedReason PRIVATE_CHAT_CROSS_TENANT = null;
        public static final DeniedReason PRIVATE_CHAT_DENY = null;
        public static final DeniedReason PRIVATE_CHAT_DISABLED = null;
        public static final DeniedReason PRIVATE_CHAT_KMS_UNAVAILABLE = null;
        public static final DeniedReason SAME_TENANT_DENY = null;
        public static final DeniedReason SEND_SECRET_CHAT_BY_ICON_DENY = null;
        public static final DeniedReason TARGET_EXTERNAL_COORDINATE_CTL = null;
        public static final DeniedReason TARGET_PRIVACY_SETTING = null;
        public static final DeniedReason UNKNOWN_REASON = null;
        private final int value;

        static {
            DeniedReason r100 = new DeniedReason("UNKNOWN_REASON", 0, 0);
            UNKNOWN_REASON = r100;
            DeniedReason r101 = new DeniedReason("BE_BLOCKED", 1, 1);
            BE_BLOCKED = r101;
            DeniedReason r102 = new DeniedReason("CROSS_TENANT_DENY", 2, 2);
            CROSS_TENANT_DENY = r102;
            DeniedReason r103 = new DeniedReason("SAME_TENANT_DENY", 3, 3);
            SAME_TENANT_DENY = r103;
            DeniedReason r104 = new DeniedReason("CRYPTO_CHAT_DENY", 4, 4);
            CRYPTO_CHAT_DENY = r104;
            DeniedReason r105 = new DeniedReason("BLOCKED", 5, 5);
            BLOCKED = r105;
            DeniedReason r110 = new DeniedReason("NO_FRIENDSHIP", 6, 6);
            NO_FRIENDSHIP = r110;
            DeniedReason r111 = new DeniedReason("PRIVACY_SETTING", 7, 7);
            PRIVACY_SETTING = r111;
            DeniedReason r112 = new DeniedReason("TARGET_PRIVACY_SETTING", 8, 8);
            TARGET_PRIVACY_SETTING = r112;
            DeniedReason r113 = new DeniedReason("PRIVATE_CALENDAR", 9, 9);
            PRIVATE_CALENDAR = r113;
            DeniedReason r114 = new DeniedReason("EXTERNAL_COORDINATE_CTL", 10, 10);
            EXTERNAL_COORDINATE_CTL = r114;
            DeniedReason r115 = new DeniedReason("TARGET_EXTERNAL_COORDINATE_CTL", 11, 11);
            TARGET_EXTERNAL_COORDINATE_CTL = r115;
            DeniedReason r106 = new DeniedReason("SEND_SECRET_CHAT_BY_ICON_DENY", 12, 12);
            SEND_SECRET_CHAT_BY_ICON_DENY = r106;
            DeniedReason r107 = new DeniedReason("PRIVATE_CHAT_DISABLED", 13, 15);
            PRIVATE_CHAT_DISABLED = r107;
            DeniedReason r108 = new DeniedReason("PRIVATE_CHAT_KMS_UNAVAILABLE", 14, 16);
            PRIVATE_CHAT_KMS_UNAVAILABLE = r108;
            DeniedReason r109 = new DeniedReason("PRIVATE_CHAT_DENY", 15, 17);
            PRIVATE_CHAT_DENY = r109;
            DeniedReason r116 = new DeniedReason("PRIVATE_CHAT_CROSS_TENANT", 16, 18);
            PRIVATE_CHAT_CROSS_TENANT = r116;
            DeniedReason r117 = new DeniedReason("NOT_SUPPORT_AI", 17, 51);
            NOT_SUPPORT_AI = r117;
            $VALUES = new DeniedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
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
            if (r100 == 51) goto L43;
            switch(r100) {
                case 0: goto L41;
                case 1: goto L39;
                case 2: goto L37;
                case 3: goto L35;
                case 4: goto L33;
                case 5: goto L31;
                case 6: goto L29;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L23;
                case 10: goto L21;
                case 11: goto L19;
                case 12: goto L17;
                default: goto L5;
            };
        L5:
            switch(r100) {
                case 15: goto L15;
                case 16: goto L13;
                case 17: goto L11;
                case 18: goto L9;
                default: goto L6;
            };
        L6:
            return null;
        L9:
            return PRIVATE_CHAT_CROSS_TENANT;
        L11:
            return PRIVATE_CHAT_DENY;
        L13:
            return PRIVATE_CHAT_KMS_UNAVAILABLE;
        L15:
            return PRIVATE_CHAT_DISABLED;
        L17:
            return SEND_SECRET_CHAT_BY_ICON_DENY;
        L19:
            return TARGET_EXTERNAL_COORDINATE_CTL;
        L21:
            return EXTERNAL_COORDINATE_CTL;
        L23:
            return PRIVATE_CALENDAR;
        L25:
            return TARGET_PRIVACY_SETTING;
        L27:
            return PRIVACY_SETTING;
        L29:
            return NO_FRIENDSHIP;
        L31:
            return BLOCKED;
        L33:
            return CRYPTO_CHAT_DENY;
        L35:
            return SAME_TENANT_DENY;
        L37:
            return CROSS_TENANT_DENY;
        L39:
            return BE_BLOCKED;
        L41:
            return UNKNOWN_REASON;
        L43:
            return NOT_SUPPORT_AI;
        }

        public static DeniedReason valueOf(String r100) {
            return (DeniedReason) a.a(DeniedReason.class, r100);
        }

        private DeniedReason(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DepartmentInfo extends Message<DepartmentInfo, Builder> {
        public static final ProtoAdapter<DepartmentInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Department> department_list;

        public static final class Builder extends Message.Builder<DepartmentInfo, Builder> {
            public List<Department> department_list;

            @Override // com.squareup.wire.Message.Builder
            public DepartmentInfo build() {
                return new DepartmentInfo(this.department_list, super.buildUnknownFields());
            }

            public Builder() {
                this.department_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder department_list(List<Department> r100) {
                Internal.checkElementsNotNull(r100);
                this.department_list = r100;
                return this;
            }
        }

        public static final class Department extends Message<Department, Builder> {
            public static final ProtoAdapter<Department> ADAPTER = null;
            public static final String DEFAULT_DEPARTMENT_ID = "";
            private static final long serialVersionUID = 0;
            public final String department_id;
            public final I18nVal department_name;

            public static final class Builder extends Message.Builder<Department, Builder> {
                public String department_id;
                public I18nVal department_name;

                @Override // com.squareup.wire.Message.Builder
                public Department build() {
                    return new Department(this.department_id, this.department_name, super.buildUnknownFields());
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

            public static final class ProtoAdapter_Department extends ProtoAdapter<Department> {
                public ProtoAdapter_Department() {
                    super(FieldEncoding.LENGTH_DELIMITED, Department.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Department decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.department_id = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.department_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.department_name = I18nVal.ADAPTER.decode(r100);
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
                    String r101 = r100.department_id;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    I18nVal r104 = r100.department_name;
                    if (r104 == null) goto L10;
                    r102 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
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
                    String r102 = r101.department_id;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    I18nVal r103 = r101.department_name;
                    if (r103 == null) goto L8;
                    I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
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
                r100.department_id = this.department_id;
                r100.department_name = this.department_name;
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

            public Department(String r100, I18nVal r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public Department(String r100, I18nVal r101, ByteString r102) {
                super(ADAPTER, r102);
                this.department_id = r100;
                this.department_name = r101;
            }
        }

        public static final class ProtoAdapter_DepartmentInfo extends ProtoAdapter<DepartmentInfo> {
            public ProtoAdapter_DepartmentInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DepartmentInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DepartmentInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.department_list.add(Department.ADAPTER.decode(r100));
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
            public int encodedSize2(DepartmentInfo r100) {
                return Department.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.department_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DepartmentInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DepartmentInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DepartmentInfo r101) throws IOException {
                Department.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.department_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DepartmentInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.department_list = Internal.copyOf("department_list", this.department_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DepartmentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DepartmentInfo(List<Department> r100) {
            this(r100, ByteString.EMPTY);
        }

        public DepartmentInfo(List<Department> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.department_list = Internal.immutableCopyOf("department_list", r100);
        }
    }

    public static final class LeaderInfo extends Message<LeaderInfo, Builder> {
        public static final ProtoAdapter<LeaderInfo> ADAPTER = null;
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String user_id;
        public final I18nVal user_name;

        public static final class Builder extends Message.Builder<LeaderInfo, Builder> {
            public String user_id;
            public I18nVal user_name;

            @Override // com.squareup.wire.Message.Builder
            public LeaderInfo build() {
                return new LeaderInfo(this.user_id, this.user_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }

            public Builder user_name(I18nVal r100) {
                this.user_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LeaderInfo extends ProtoAdapter<LeaderInfo> {
            public ProtoAdapter_LeaderInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, LeaderInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LeaderInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.user_name = I18nVal.ADAPTER.decode(r100);
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
            public int encodedSize2(LeaderInfo r100) {
                String r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.user_name;
                if (r104 == null) goto L10;
                r102 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LeaderInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LeaderInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LeaderInfo r101) throws IOException {
                String r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.user_name;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LeaderInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LeaderInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.user_name = this.user_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LeaderInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public LeaderInfo(String r100, I18nVal r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public LeaderInfo(String r100, I18nVal r101, ByteString r102) {
            super(ADAPTER, r102);
            this.user_id = r100;
            this.user_name = r101;
        }
    }

    public static final class ProtoAdapter_GetDoubaoProfileResponse extends ProtoAdapter<GetDoubaoProfileResponse> implements c<GetDoubaoProfileResponse> {
        public ProtoAdapter_GetDoubaoProfileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDoubaoProfileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDoubaoProfileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.edition = GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.cta_info_list.add(CTAInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_info = UserInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.edition = GetDoubaoProfileRequest.DoubaoProfileEdition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(GetDoubaoProfileResponse r100) {
            int r101 = CTAInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.cta_info_list);
            UserInfo r102 = r100.user_info;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = UserInfo.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            GetDoubaoProfileRequest.DoubaoProfileEdition r106 = r100.edition;
            if (r106 == null) goto L10;
            r103 = GetDoubaoProfileRequest.DoubaoProfileEdition.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDoubaoProfileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDoubaoProfileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDoubaoProfileResponse r101) throws IOException {
            CTAInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.cta_info_list);
            UserInfo r102 = r101.user_info;
            if (r102 == null) goto L5;
            UserInfo.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            GetDoubaoProfileRequest.DoubaoProfileEdition r103 = r101.edition;
            if (r103 == null) goto L8;
            GetDoubaoProfileRequest.DoubaoProfileEdition.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDoubaoProfileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TenantInfo extends Message<TenantInfo, Builder> {
        public static final ProtoAdapter<TenantInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal tenant_name;

        public static final class Builder extends Message.Builder<TenantInfo, Builder> {
            public I18nVal tenant_name;

            @Override // com.squareup.wire.Message.Builder
            public TenantInfo build() {
                return new TenantInfo(this.tenant_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder tenant_name(I18nVal r100) {
                this.tenant_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TenantInfo extends ProtoAdapter<TenantInfo> {
            public ProtoAdapter_TenantInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TenantInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TenantInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.tenant_name = I18nVal.ADAPTER.decode(r100);
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
            public int encodedSize2(TenantInfo r100) {
                I18nVal r101 = r100.tenant_name;
                if (r101 == null) goto L5;
                int r102 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TenantInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TenantInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TenantInfo r101) throws IOException {
                I18nVal r102 = r101.tenant_name;
                if (r102 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TenantInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TenantInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tenant_name = this.tenant_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TenantInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TenantInfo(I18nVal r100) {
            this(r100, ByteString.EMPTY);
        }

        public TenantInfo(I18nVal r100, ByteString r101) {
            super(ADAPTER, r101);
            this.tenant_name = r100;
        }
    }

    public static final class UserInfo extends Message<UserInfo, Builder> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final String DEFAULT_ALIAS = "";
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final BlockStatus DEFAULT_BLOCK_STATUS = null;
        public static final String DEFAULT_CONTACT_APPLICATION_ID = "";
        public static final String DEFAULT_CONTACT_APPLICATION_REASON = "";
        public static final ContactSource DEFAULT_CONTACT_SOURCE = null;
        public static final ContactStatus DEFAULT_CONTACT_STATUS = null;
        public static final String DEFAULT_EXTRA_INFO = "";
        public static final Boolean DEFAULT_IS_BLOCKED = null;
        public static final Boolean DEFAULT_IS_FROZEN = null;
        public static final Boolean DEFAULT_IS_RESIGNED = null;
        public static final String DEFAULT_TENANT_ID = "";
        public static final String DEFAULT_USER_ID = "";
        public static final String DEFAULT_USER_NAME = "";
        private static final long serialVersionUID = 0;
        public final String alias;
        public final String avatar_key;
        public final BlockStatus block_status;
        public final List<Chatter.ChatterCustomStatus> chatter_status;
        public final CityInfo city_info;
        public final String contact_application_id;
        public final String contact_application_reason;
        public final I18nVal contact_application_source_text;
        public final ContactSource contact_source;
        public final ContactStatus contact_status;
        public final DepartmentInfo department_info;
        public final Chatter.Description description;
        public final String extra_info;
        public final Boolean is_blocked;
        public final Boolean is_frozen;
        public final Boolean is_resigned;
        public final LeaderInfo leader_info;
        public final String tenant_id;
        public final TenantInfo tenant_info;
        public final String user_id;
        public final String user_name;

        public static final class Builder extends Message.Builder<UserInfo, Builder> {
            public String alias;
            public String avatar_key;
            public BlockStatus block_status;
            public List<Chatter.ChatterCustomStatus> chatter_status;
            public CityInfo city_info;
            public String contact_application_id;
            public String contact_application_reason;
            public I18nVal contact_application_source_text;
            public ContactSource contact_source;
            public ContactStatus contact_status;
            public DepartmentInfo department_info;
            public Chatter.Description description;
            public String extra_info;
            public Boolean is_blocked;
            public Boolean is_frozen;
            public Boolean is_resigned;
            public LeaderInfo leader_info;
            public String tenant_id;
            public TenantInfo tenant_info;
            public String user_id;
            public String user_name;

            @Override // com.squareup.wire.Message.Builder
            public UserInfo build() {
                return new UserInfo(this.is_blocked, this.block_status, this.contact_status, this.contact_application_id, this.contact_source, this.contact_application_reason, this.contact_application_source_text, this.tenant_id, this.tenant_info, this.department_info, this.leader_info, this.city_info, this.user_id, this.user_name, this.avatar_key, this.alias, this.extra_info, this.is_resigned, this.is_frozen, this.description, this.chatter_status, super.buildUnknownFields());
            }

            public Builder() {
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

            public Builder avatar_key(String r100) {
                this.avatar_key = r100;
                return this;
            }

            public Builder block_status(BlockStatus r100) {
                this.block_status = r100;
                return this;
            }

            public Builder chatter_status(List<Chatter.ChatterCustomStatus> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatter_status = r100;
                return this;
            }

            public Builder city_info(CityInfo r100) {
                this.city_info = r100;
                return this;
            }

            public Builder contact_application_id(String r100) {
                this.contact_application_id = r100;
                return this;
            }

            public Builder contact_application_reason(String r100) {
                this.contact_application_reason = r100;
                return this;
            }

            public Builder contact_application_source_text(I18nVal r100) {
                this.contact_application_source_text = r100;
                return this;
            }

            public Builder contact_source(ContactSource r100) {
                this.contact_source = r100;
                return this;
            }

            public Builder contact_status(ContactStatus r100) {
                this.contact_status = r100;
                return this;
            }

            public Builder department_info(DepartmentInfo r100) {
                this.department_info = r100;
                return this;
            }

            public Builder description(Chatter.Description r100) {
                this.description = r100;
                return this;
            }

            public Builder extra_info(String r100) {
                this.extra_info = r100;
                return this;
            }

            public Builder is_blocked(Boolean r100) {
                this.is_blocked = r100;
                return this;
            }

            public Builder is_frozen(Boolean r100) {
                this.is_frozen = r100;
                return this;
            }

            public Builder is_resigned(Boolean r100) {
                this.is_resigned = r100;
                return this;
            }

            public Builder leader_info(LeaderInfo r100) {
                this.leader_info = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }

            public Builder tenant_info(TenantInfo r100) {
                this.tenant_info = r100;
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
        }

        public static final class ProtoAdapter_UserInfo extends ProtoAdapter<UserInfo> {
            public ProtoAdapter_UserInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, UserInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_blocked = r102;
                r101.block_status = BlockStatus.BLOCK_UNKNOWN;
                r101.contact_status = ContactStatus.CONTACT_UNKNOWN;
                r101.contact_application_id = "";
                r101.contact_source = ContactSource.UNKNOWN_SOURCE;
                r101.contact_application_reason = "";
                r101.tenant_id = "";
                r101.user_id = "";
                r101.user_name = "";
                r101.avatar_key = "";
                r101.alias = "";
                r101.extra_info = "";
                r101.is_resigned = r102;
                r101.is_frozen = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L41;
                if (r104 != 61) goto L7;
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                switch(r104) {
                    case 1: goto L39;
                    case 2: goto L45;
                    case 3: goto L47;
                    case 4: goto L30;
                    case 5: goto L43;
                    case 6: goto L25;
                    case 7: goto L24;
                    case 8: goto L23;
                    case 9: goto L22;
                    case 10: goto L21;
                    case 11: goto L20;
                    default: goto L8;
                };
            L43:
                r101.contact_source = ContactSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
            L28:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L45:
                r101.block_status = BlockStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L37
            L37:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L47:
                r101.contact_status = ContactStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
            L33:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L20:
                r101.city_info = CityInfo.ADAPTER.decode(r100);
                goto L3
            L21:
                r101.leader_info = LeaderInfo.ADAPTER.decode(r100);
                goto L3
            L22:
                r101.department_info = DepartmentInfo.ADAPTER.decode(r100);
                goto L3
            L23:
                r101.tenant_info = TenantInfo.ADAPTER.decode(r100);
                goto L3
            L24:
                r101.contact_application_source_text = I18nVal.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.contact_application_reason = ProtoAdapter.STRING.decode(r100);
                goto L3
            L30:
                r101.contact_application_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L39:
                r101.is_blocked = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                switch(r104) {
                    case 50: goto L19;
                    case 51: goto L18;
                    case 52: goto L17;
                    default: goto L9;
                };
            L17:
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.user_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                switch(r104) {
                    case 69: goto L16;
                    case 70: goto L15;
                    case 71: goto L14;
                    case 72: goto L13;
                    case 73: goto L12;
                    case 74: goto L11;
                    default: goto L10;
                };
            L11:
                r101.chatter_status.add(Chatter.ChatterCustomStatus.ADAPTER.decode(r100));
                goto L3
            L12:
                r101.description = Chatter.Description.ADAPTER.decode(r100);
                goto L3
            L13:
                r101.is_frozen = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                r101.is_resigned = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.extra_info = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.alias = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L41:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserInfo r100) {
                Boolean r101 = r100.is_blocked;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                BlockStatus r104 = r100.block_status;
                if (r104 == null) goto L9;
                int r105 = BlockStatus.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ContactStatus r107 = r100.contact_status;
                if (r107 == null) goto L13;
                int r108 = ContactStatus.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.contact_application_id;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ContactSource r113 = r100.contact_source;
                if (r113 == null) goto L21;
                int r114 = ContactSource.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.contact_application_reason;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                I18nVal r119 = r100.contact_application_source_text;
                if (r119 == null) goto L29;
                int r120 = I18nVal.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.tenant_id;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(52, r122);
            L34:
                int r124 = r121 + r123;
                TenantInfo r125 = r100.tenant_info;
                if (r125 == null) goto L37;
                int r126 = TenantInfo.ADAPTER.encodedSizeWithTag(8, r125);
            L38:
                int r127 = r124 + r126;
                DepartmentInfo r128 = r100.department_info;
                if (r128 == null) goto L41;
                int r129 = DepartmentInfo.ADAPTER.encodedSizeWithTag(9, r128);
            L42:
                int r130 = r127 + r129;
                LeaderInfo r131 = r100.leader_info;
                if (r131 == null) goto L45;
                int r132 = LeaderInfo.ADAPTER.encodedSizeWithTag(10, r131);
            L46:
                int r133 = r130 + r132;
                CityInfo r134 = r100.city_info;
                if (r134 == null) goto L49;
                int r135 = CityInfo.ADAPTER.encodedSizeWithTag(11, r134);
            L50:
                int r136 = r133 + r135;
                String r137 = r100.user_id;
                if (r137 == null) goto L53;
                int r138 = ProtoAdapter.STRING.encodedSizeWithTag(50, r137);
            L54:
                int r139 = r136 + r138;
                String r140 = r100.user_name;
                if (r140 == null) goto L57;
                int r141 = ProtoAdapter.STRING.encodedSizeWithTag(51, r140);
            L58:
                int r142 = r139 + r141;
                String r143 = r100.avatar_key;
                if (r143 == null) goto L61;
                int r144 = ProtoAdapter.STRING.encodedSizeWithTag(61, r143);
            L62:
                int r145 = r142 + r144;
                String r146 = r100.alias;
                if (r146 == null) goto L65;
                int r147 = ProtoAdapter.STRING.encodedSizeWithTag(69, r146);
            L66:
                int r148 = r145 + r147;
                String r149 = r100.extra_info;
                if (r149 == null) goto L69;
                int r150 = ProtoAdapter.STRING.encodedSizeWithTag(70, r149);
            L70:
                int r151 = r148 + r150;
                Boolean r152 = r100.is_resigned;
                if (r152 == null) goto L73;
                int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(71, r152);
            L74:
                int r154 = r151 + r153;
                Boolean r155 = r100.is_frozen;
                if (r155 == null) goto L77;
                int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(72, r155);
            L78:
                int r157 = r154 + r156;
                Chatter.Description r158 = r100.description;
                if (r158 == null) goto L82;
                r102 = Chatter.Description.ADAPTER.encodedSizeWithTag(73, r158);
            L82:
                return ((r157 + r102) + Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(74, r100.chatter_status)) + r100.unknownFields().size();
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
                Boolean r102 = r101.is_blocked;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                BlockStatus r103 = r101.block_status;
                if (r103 == null) goto L8;
                BlockStatus.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                ContactStatus r104 = r101.contact_status;
                if (r104 == null) goto L11;
                ContactStatus.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.contact_application_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ContactSource r106 = r101.contact_source;
                if (r106 == null) goto L17;
                ContactSource.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.contact_application_reason;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                I18nVal r108 = r101.contact_application_source_text;
                if (r108 == null) goto L23;
                I18nVal.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.tenant_id;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 52, r109);
            L26:
                TenantInfo r110 = r101.tenant_info;
                if (r110 == null) goto L29;
                TenantInfo.ADAPTER.encodeWithTag(r100, 8, r110);
            L29:
                DepartmentInfo r111 = r101.department_info;
                if (r111 == null) goto L32;
                DepartmentInfo.ADAPTER.encodeWithTag(r100, 9, r111);
            L32:
                LeaderInfo r112 = r101.leader_info;
                if (r112 == null) goto L35;
                LeaderInfo.ADAPTER.encodeWithTag(r100, 10, r112);
            L35:
                CityInfo r113 = r101.city_info;
                if (r113 == null) goto L38;
                CityInfo.ADAPTER.encodeWithTag(r100, 11, r113);
            L38:
                String r114 = r101.user_id;
                if (r114 == null) goto L41;
                ProtoAdapter.STRING.encodeWithTag(r100, 50, r114);
            L41:
                String r115 = r101.user_name;
                if (r115 == null) goto L44;
                ProtoAdapter.STRING.encodeWithTag(r100, 51, r115);
            L44:
                String r116 = r101.avatar_key;
                if (r116 == null) goto L47;
                ProtoAdapter.STRING.encodeWithTag(r100, 61, r116);
            L47:
                String r117 = r101.alias;
                if (r117 == null) goto L50;
                ProtoAdapter.STRING.encodeWithTag(r100, 69, r117);
            L50:
                String r118 = r101.extra_info;
                if (r118 == null) goto L53;
                ProtoAdapter.STRING.encodeWithTag(r100, 70, r118);
            L53:
                Boolean r119 = r101.is_resigned;
                if (r119 == null) goto L56;
                ProtoAdapter.BOOL.encodeWithTag(r100, 71, r119);
            L56:
                Boolean r120 = r101.is_frozen;
                if (r120 == null) goto L59;
                ProtoAdapter.BOOL.encodeWithTag(r100, 72, r120);
            L59:
                Chatter.Description r121 = r101.description;
                if (r121 == null) goto L62;
                Chatter.Description.ADAPTER.encodeWithTag(r100, 73, r121);
            L62:
                Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 74, r101.chatter_status);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserInfo();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_BLOCKED = r100;
            DEFAULT_BLOCK_STATUS = BlockStatus.BLOCK_UNKNOWN;
            DEFAULT_CONTACT_STATUS = ContactStatus.CONTACT_UNKNOWN;
            DEFAULT_CONTACT_SOURCE = ContactSource.UNKNOWN_SOURCE;
            DEFAULT_IS_RESIGNED = r100;
            DEFAULT_IS_FROZEN = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_blocked = this.is_blocked;
            r100.block_status = this.block_status;
            r100.contact_status = this.contact_status;
            r100.contact_application_id = this.contact_application_id;
            r100.contact_source = this.contact_source;
            r100.contact_application_reason = this.contact_application_reason;
            r100.contact_application_source_text = this.contact_application_source_text;
            r100.tenant_id = this.tenant_id;
            r100.tenant_info = this.tenant_info;
            r100.department_info = this.department_info;
            r100.leader_info = this.leader_info;
            r100.city_info = this.city_info;
            r100.user_id = this.user_id;
            r100.user_name = this.user_name;
            r100.avatar_key = this.avatar_key;
            r100.alias = this.alias;
            r100.extra_info = this.extra_info;
            r100.is_resigned = this.is_resigned;
            r100.is_frozen = this.is_frozen;
            r100.description = this.description;
            r100.chatter_status = Internal.copyOf("chatter_status", this.chatter_status);
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

        public UserInfo(Boolean r210, BlockStatus r211, ContactStatus r212, String r213, ContactSource r214, String r215, I18nVal r310, String r311, TenantInfo r312, DepartmentInfo r313, LeaderInfo r314, CityInfo r315, String r316, String r317, String r318, String r319, String r410, Boolean r411, Boolean r412, Chatter.Description r413, List<Chatter.ChatterCustomStatus> r414) {
            this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, ByteString.EMPTY);
        }

        public UserInfo(Boolean r100, BlockStatus r101, ContactStatus r102, String r103, ContactSource r104, String r105, I18nVal r110, String r111, TenantInfo r112, DepartmentInfo r113, LeaderInfo r114, CityInfo r115, String r116, String r117, String r118, String r119, String r210, Boolean r211, Boolean r212, Chatter.Description r213, List<Chatter.ChatterCustomStatus> r214, ByteString r215) {
            super(ADAPTER, r215);
            this.is_blocked = r100;
            this.block_status = r101;
            this.contact_status = r102;
            this.contact_application_id = r103;
            this.contact_source = r104;
            this.contact_application_reason = r105;
            this.contact_application_source_text = r110;
            this.tenant_id = r111;
            this.tenant_info = r112;
            this.department_info = r113;
            this.leader_info = r114;
            this.city_info = r115;
            this.user_id = r116;
            this.user_name = r117;
            this.avatar_key = r118;
            this.alias = r119;
            this.extra_info = r210;
            this.is_resigned = r211;
            this.is_frozen = r212;
            this.description = r213;
            this.chatter_status = Internal.immutableCopyOf("chatter_status", r214);
        }
    }

    static {
        ProtoAdapter_GetDoubaoProfileResponse r100 = new ProtoAdapter_GetDoubaoProfileResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EDITION = GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cta_info_list = Internal.copyOf("cta_info_list", this.cta_info_list);
        r100.user_info = this.user_info;
        r100.edition = this.edition;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDoubaoProfileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDoubaoProfileResponse(List<CTAInfo> r100, UserInfo r101, GetDoubaoProfileRequest.DoubaoProfileEdition r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetDoubaoProfileResponse(List<CTAInfo> r100, UserInfo r101, GetDoubaoProfileRequest.DoubaoProfileEdition r102, ByteString r103) {
        super(ADAPTER, r103);
        this.cta_info_list = Internal.immutableCopyOf("cta_info_list", r100);
        this.user_info = r101;
        this.edition = r102;
    }
}
