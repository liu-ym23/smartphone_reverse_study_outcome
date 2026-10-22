package com.ss.android.lark.pb.users;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Gender;
import com.ss.android.lark.pb.entities.Image;
import com.ss.android.lark.pb.entities.ImageSetPassThrough;
import com.ss.android.lark.pb.entities.RichText;
import com.ss.android.lark.pb.entities.TenantNameStatus;
import com.ss.android.lark.pb.url_preview.PreviewHangPoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class Profile extends Message<Profile, Builder> {
    public static final ProtoAdapter<Profile> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<CTA> mctas;
    public final List<Field> mfields;
    public final List<TabInfo> mtabs;
    public final UserInfo muser_info;

    public static final class ApplyCommunication extends Message<ApplyCommunication, Builder> {
        public static final ProtoAdapter<ApplyCommunication> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ApplyCommunicationStatus mopposite_apply_status;
        public final ApplyCommunicationStatus mself_apply_status;

        public static final class Builder extends Message.Builder<ApplyCommunication, Builder> {
            public ApplyCommunicationStatus mopposite_apply_status;
            public ApplyCommunicationStatus mself_apply_status;

            @Override // com.squareup.wire.Message.Builder
            public ApplyCommunication build() {
                return new ApplyCommunication(this.mself_apply_status, this.mopposite_apply_status, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder opposite_apply_status(ApplyCommunicationStatus r100) {
                this.mopposite_apply_status = r100;
                return this;
            }

            public Builder self_apply_status(ApplyCommunicationStatus r100) {
                this.mself_apply_status = r100;
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
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mself_apply_status = ApplyCommunicationStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mopposite_apply_status = ApplyCommunicationStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ApplyCommunication r100) {
                ApplyCommunicationStatus r101 = r100.mself_apply_status;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ApplyCommunicationStatus.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ApplyCommunicationStatus r104 = r100.mopposite_apply_status;
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
                ApplyCommunicationStatus r102 = r101.mself_apply_status;
                if (r102 == null) goto L5;
                ApplyCommunicationStatus.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ApplyCommunicationStatus r103 = r101.mopposite_apply_status;
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mself_apply_status = this.mself_apply_status;
            r100.mopposite_apply_status = this.mopposite_apply_status;
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
            this.mself_apply_status = r100;
            this.mopposite_apply_status = r101;
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
        public static final BlockStatus B_Double = null;
        public static final BlockStatus B_Forward = null;
        public static final BlockStatus B_None = null;
        public static final BlockStatus B_Reverse = null;
        public static final BlockStatus B_UNKNOWN = null;
        private final int value;

        static {
            BlockStatus r100 = new BlockStatus("B_UNKNOWN", 0, 0);
            B_UNKNOWN = r100;
            BlockStatus r101 = new BlockStatus("B_None", 1, 1);
            B_None = r101;
            BlockStatus r102 = new BlockStatus("B_Forward", 2, 2);
            B_Forward = r102;
            BlockStatus r103 = new BlockStatus("B_Reverse", 3, 3);
            B_Reverse = r103;
            BlockStatus r104 = new BlockStatus("B_Double", 4, 4);
            B_Double = r104;
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
            return B_Double;
        L16:
            return B_Reverse;
        L18:
            return B_Forward;
        L20:
            return B_None;
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

    public static final class Builder extends Message.Builder<Profile, Builder> {
        public List<CTA> mctas;
        public List<Field> mfields;
        public List<TabInfo> mtabs;
        public UserInfo muser_info;

        @Override // com.squareup.wire.Message.Builder
        public Profile build() {
            return new Profile(this.muser_info, this.mctas, this.mfields, this.mtabs, super.buildUnknownFields());
        }

        public Builder() {
            this.mctas = Internal.newMutableList();
            this.mfields = Internal.newMutableList();
            this.mtabs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ctas(List<CTA> r100) {
            Internal.checkElementsNotNull(r100);
            this.mctas = r100;
            return this;
        }

        public Builder fields(List<Field> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfields = r100;
            return this;
        }

        public Builder tabs(List<TabInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtabs = r100;
            return this;
        }

        public Builder user_info(UserInfo r100) {
            this.muser_info = r100;
            return this;
        }
    }

    public static final class CTA extends Message<CTA, Builder> {
        public static final ProtoAdapter<CTA> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_LINK = "";
        private static final long serialVersionUID = 0;
        public final CTAType mcta_type;
        public final I18nVal mdenied_description;
        public final com.ss.android.lark.pb.misc.DeniedReason mdenied_reason;
        public final DeniedReason mdeny_reason;
        public final Boolean menable;
        public final I18nVal mi18n_names;
        public final Image micon;
        public final String mkey;
        public final String mlink;
        public final List<CTA> msub_ctas;

        public static final class Builder extends Message.Builder<CTA, Builder> {
            public CTAType mcta_type;
            public I18nVal mdenied_description;
            public com.ss.android.lark.pb.misc.DeniedReason mdenied_reason;
            public DeniedReason mdeny_reason;
            public Boolean menable;
            public I18nVal mi18n_names;
            public Image micon;
            public String mkey;
            public String mlink;
            public List<CTA> msub_ctas;

            @Override // com.squareup.wire.Message.Builder
            public CTA build() {
                String r100 = this.mkey;
                if (r100 == null) goto L13;
                if (this.mi18n_names == null) goto L13;
                if (this.menable == null) goto L13;
                if (this.mcta_type == null) goto L13;
                return new CTA(this.mkey, this.mi18n_names, this.menable, this.mcta_type, this.micon, this.mlink, this.mdeny_reason, this.mdenied_reason, this.mdenied_description, this.msub_ctas, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r100, "mkey", this.mi18n_names, "mi18n_names", this.menable, "menable", this.mcta_type, "mcta_type"});
            }

            public Builder() {
                this.msub_ctas = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder cta_type(CTAType r100) {
                this.mcta_type = r100;
                return this;
            }

            public Builder denied_description(I18nVal r100) {
                this.mdenied_description = r100;
                return this;
            }

            public Builder denied_reason(com.ss.android.lark.pb.misc.DeniedReason r100) {
                this.mdenied_reason = r100;
                return this;
            }

            public Builder deny_reason(DeniedReason r100) {
                this.mdeny_reason = r100;
                return this;
            }

            public Builder enable(Boolean r100) {
                this.menable = r100;
                return this;
            }

            public Builder i18n_names(I18nVal r100) {
                this.mi18n_names = r100;
                return this;
            }

            public Builder icon(Image r100) {
                this.micon = r100;
                return this;
            }

            public Builder key(String r100) {
                this.mkey = r100;
                return this;
            }

            public Builder link(String r100) {
                this.mlink = r100;
                return this;
            }

            public Builder sub_ctas(List<CTA> r100) {
                Internal.checkElementsNotNull(r100);
                this.msub_ctas = r100;
                return this;
            }
        }

        public static final enum CTAType extends Enum<CTAType> implements WireEnum {
            private static final /* synthetic */ CTAType[] $VALUES = null;
            public static final ProtoAdapter<CTAType> ADAPTER = null;
            public static final CTAType LINK = null;
            public static final CTAType S_BLOCK_SETTING = null;
            public static final CTAType S_CHAT = null;
            public static final CTAType S_COLLABORATION_PERMISSION_SETTING = null;
            public static final CTAType S_CRYPTO_CHAT = null;
            public static final CTAType S_PRIVATE_MODE = null;
            public static final CTAType S_USER_CARD = null;
            public static final CTAType S_VIDEO = null;
            public static final CTAType S_VOICE = null;
            public static final CTAType S_VOICE_EPHONE = null;
            public static final CTAType S_VOICE_PHONE = null;
            public static final CTAType UNKNOWN = null;
            private final int value;

            static {
                CTAType r100 = new CTAType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                CTAType r101 = new CTAType("LINK", 1, 1);
                LINK = r101;
                CTAType r102 = new CTAType("S_CHAT", 2, 10);
                S_CHAT = r102;
                CTAType r103 = new CTAType("S_CRYPTO_CHAT", 3, 11);
                S_CRYPTO_CHAT = r103;
                CTAType r104 = new CTAType("S_VOICE", 4, 12);
                S_VOICE = r104;
                CTAType r110 = new CTAType("S_VIDEO", 5, 13);
                S_VIDEO = r110;
                CTAType r111 = new CTAType("S_USER_CARD", 6, 14);
                S_USER_CARD = r111;
                CTAType r112 = new CTAType("S_BLOCK_SETTING", 7, 15);
                S_BLOCK_SETTING = r112;
                CTAType r105 = new CTAType("S_COLLABORATION_PERMISSION_SETTING", 8, 16);
                S_COLLABORATION_PERMISSION_SETTING = r105;
                CTAType r106 = new CTAType("S_VOICE_EPHONE", 9, 17);
                S_VOICE_EPHONE = r106;
                CTAType r107 = new CTAType("S_VOICE_PHONE", 10, 18);
                S_VOICE_PHONE = r107;
                CTAType r108 = new CTAType("S_PRIVATE_MODE", 11, 19);
                S_PRIVATE_MODE = r108;
                $VALUES = new CTAType[]{r100, r101, r102, r103, r104, r110, r111, r112, r105, r106, r107, r108};
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
                return S_COLLABORATION_PERMISSION_SETTING;
            L17:
                return S_BLOCK_SETTING;
            L19:
                return S_USER_CARD;
            L21:
                return S_VIDEO;
            L23:
                return S_VOICE;
            L25:
                return S_CRYPTO_CHAT;
            L27:
                return S_CHAT;
            L29:
                return LINK;
            L31:
                return UNKNOWN;
            }

            public static CTAType valueOf(String r100) {
                return (CTAType) a.a(CTAType.class, r100);
            }

            private CTAType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
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
                r101.mkey = "";
                r101.menable = Boolean.FALSE;
                r101.mlink = "";
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
                r101.mdenied_reason = com.ss.android.lark.pb.misc.DeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r101.mcta_type = CTAType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.mdeny_reason = DeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.msub_ctas.add(CTA.ADAPTER.decode(r100));
                goto L3
            L8:
                r101.mdenied_description = I18nVal.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.mlink = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.micon = Image.ADAPTER.decode(r100);
                goto L3
            L23:
                r101.menable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L24:
                r101.mi18n_names = I18nVal.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.mkey = ProtoAdapter.STRING.decode(r100);
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
                int r102 = r101.encodedSizeWithTag(1, r100.mkey);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                int r104 = ((r102 + r103.encodedSizeWithTag(2, r100.mi18n_names)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.menable)) + CTAType.ADAPTER.encodedSizeWithTag(4, r100.mcta_type);
                Image r105 = r100.micon;
                int r106 = 0;
                if (r105 == null) goto L5;
                int r107 = Image.ADAPTER.encodedSizeWithTag(5, r105);
            L6:
                int r108 = r104 + r107;
                String r109 = r100.mlink;
                if (r109 == null) goto L9;
                int r110 = r101.encodedSizeWithTag(6, r109);
            L10:
                int r111 = r108 + r110;
                DeniedReason r112 = r100.mdeny_reason;
                if (r112 == null) goto L13;
                int r113 = DeniedReason.ADAPTER.encodedSizeWithTag(7, r112);
            L14:
                int r114 = r111 + r113;
                com.ss.android.lark.pb.misc.DeniedReason r115 = r100.mdenied_reason;
                if (r115 == null) goto L17;
                int r116 = com.ss.android.lark.pb.misc.DeniedReason.ADAPTER.encodedSizeWithTag(8, r115);
            L18:
                int r117 = r114 + r116;
                I18nVal r118 = r100.mdenied_description;
                if (r118 == null) goto L22;
                r106 = r103.encodedSizeWithTag(9, r118);
            L22:
                return ((r117 + r106) + CTA.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.msub_ctas)) + r100.unknownFields().size();
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
                r102.encodeWithTag(r100, 1, r101.mkey);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                r103.encodeWithTag(r100, 2, r101.mi18n_names);
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.menable);
                CTAType.ADAPTER.encodeWithTag(r100, 4, r101.mcta_type);
                Image r104 = r101.micon;
                if (r104 == null) goto L5;
                Image.ADAPTER.encodeWithTag(r100, 5, r104);
            L5:
                String r105 = r101.mlink;
                if (r105 == null) goto L8;
                r102.encodeWithTag(r100, 6, r105);
            L8:
                DeniedReason r106 = r101.mdeny_reason;
                if (r106 == null) goto L11;
                DeniedReason.ADAPTER.encodeWithTag(r100, 7, r106);
            L11:
                com.ss.android.lark.pb.misc.DeniedReason r107 = r101.mdenied_reason;
                if (r107 == null) goto L14;
                com.ss.android.lark.pb.misc.DeniedReason.ADAPTER.encodeWithTag(r100, 8, r107);
            L14:
                I18nVal r108 = r101.mdenied_description;
                if (r108 == null) goto L17;
                r103.encodeWithTag(r100, 9, r108);
            L17:
                CTA.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.msub_ctas);
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mkey = this.mkey;
            r100.mi18n_names = this.mi18n_names;
            r100.menable = this.menable;
            r100.mcta_type = this.mcta_type;
            r100.micon = this.micon;
            r100.mlink = this.mlink;
            r100.mdeny_reason = this.mdeny_reason;
            r100.mdenied_reason = this.mdenied_reason;
            r100.mdenied_description = this.mdenied_description;
            r100.msub_ctas = Internal.copyOf("msub_ctas", this.msub_ctas);
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

        public CTA(String r110, I18nVal r111, Boolean r112, CTAType r113, Image r114, String r115, DeniedReason r116, com.ss.android.lark.pb.misc.DeniedReason r210, I18nVal r211, List<CTA> r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public CTA(String r100, I18nVal r101, Boolean r102, CTAType r103, Image r104, String r105, DeniedReason r106, com.ss.android.lark.pb.misc.DeniedReason r107, I18nVal r110, List<CTA> r111, ByteString r112) {
            super(ADAPTER, r112);
            this.mkey = r100;
            this.mi18n_names = r101;
            this.menable = r102;
            this.mcta_type = r103;
            this.micon = r104;
            this.mlink = r105;
            this.mdeny_reason = r106;
            this.mdenied_reason = r107;
            this.mdenied_description = r110;
            this.msub_ctas = Internal.immutableCopyOf("msub_ctas", r111);
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
        public static final Boolean DEFAULT_IS_SHOW_CERT_SIGN = null;
        public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
        private static final long serialVersionUID = 0;
        public final CertificateStatus mcertificate_status;
        public final Boolean mis_show_cert_sign;
        public final String mtenant_certification_url;

        public static final class Builder extends Message.Builder<CertificationInfo, Builder> {
            public CertificateStatus mcertificate_status;
            public Boolean mis_show_cert_sign;
            public String mtenant_certification_url;

            @Override // com.squareup.wire.Message.Builder
            public CertificationInfo build() {
                return new CertificationInfo(this.mis_show_cert_sign, this.mcertificate_status, this.mtenant_certification_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder certificate_status(CertificateStatus r100) {
                this.mcertificate_status = r100;
                return this;
            }

            public Builder is_show_cert_sign(Boolean r100) {
                this.mis_show_cert_sign = r100;
                return this;
            }

            public Builder tenant_certification_url(String r100) {
                this.mtenant_certification_url = r100;
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
                r101.mis_show_cert_sign = Boolean.FALSE;
                r101.mtenant_certification_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mis_show_cert_sign = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mcertificate_status = CertificateStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mtenant_certification_url = ProtoAdapter.STRING.decode(r100);
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
                Boolean r101 = r100.mis_show_cert_sign;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                CertificateStatus r104 = r100.mcertificate_status;
                if (r104 == null) goto L9;
                int r105 = CertificateStatus.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mtenant_certification_url;
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
                Boolean r102 = r101.mis_show_cert_sign;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                CertificateStatus r103 = r101.mcertificate_status;
                if (r103 == null) goto L8;
                CertificateStatus.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mtenant_certification_url;
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_show_cert_sign = this.mis_show_cert_sign;
            r100.mcertificate_status = this.mcertificate_status;
            r100.mtenant_certification_url = this.mtenant_certification_url;
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
            this.mis_show_cert_sign = r100;
            this.mcertificate_status = r101;
            this.mtenant_certification_url = r102;
        }
    }

    public static final class CustomImage extends Message<CustomImage, Builder> {
        public static final ProtoAdapter<CustomImage> ADAPTER = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        public static final String DEFAULT_RESOURCE_URL = "";
        private static final long serialVersionUID = 0;
        public final String mfs_unit;
        public final String mresource_key;
        public final String mresource_url;

        public static final class Builder extends Message.Builder<CustomImage, Builder> {
            public String mfs_unit;
            public String mresource_key;
            public String mresource_url;

            @Override // com.squareup.wire.Message.Builder
            public CustomImage build() {
                return new CustomImage(this.mresource_key, this.mfs_unit, this.mresource_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder fs_unit(String r100) {
                this.mfs_unit = r100;
                return this;
            }

            public Builder resource_key(String r100) {
                this.mresource_key = r100;
                return this;
            }

            public Builder resource_url(String r100) {
                this.mresource_url = r100;
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
                r101.mresource_key = "";
                r101.mfs_unit = "";
                r101.mresource_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mresource_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mresource_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(CustomImage r100) {
                String r101 = r100.mresource_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mfs_unit;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mresource_url;
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
            public /* bridge */ /* synthetic */ CustomImage decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomImage r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomImage r101) throws IOException {
                String r102 = r101.mresource_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mfs_unit;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mresource_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
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
            r100.mresource_key = this.mresource_key;
            r100.mfs_unit = this.mfs_unit;
            r100.mresource_url = this.mresource_url;
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

        public CustomImage(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public CustomImage(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mresource_key = r100;
            this.mfs_unit = r101;
            this.mresource_url = r102;
        }
    }

    public static final class CustomPhone extends Message<CustomPhone, Builder> {
        public static final ProtoAdapter<CustomPhone> ADAPTER = null;
        public static final String DEFAULT_EXTENSION_NUMBER = "";
        public static final String DEFAULT_PHONE_NUMBER = "";
        private static final long serialVersionUID = 0;
        public final String mextension_number;
        public final String mphone_number;

        public static final class Builder extends Message.Builder<CustomPhone, Builder> {
            public String mextension_number;
            public String mphone_number;

            @Override // com.squareup.wire.Message.Builder
            public CustomPhone build() {
                return new CustomPhone(this.mphone_number, this.mextension_number, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder extension_number(String r100) {
                this.mextension_number = r100;
                return this;
            }

            public Builder phone_number(String r100) {
                this.mphone_number = r100;
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
                r101.mphone_number = "";
                r101.mextension_number = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mphone_number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mextension_number = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.mphone_number;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mextension_number;
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
                String r102 = r101.mphone_number;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mextension_number;
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
            r100.mphone_number = this.mphone_number;
            r100.mextension_number = this.mextension_number;
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
            this.mphone_number = r100;
            this.mextension_number = r101;
        }
    }

    public static final class Department extends Message<Department, Builder> {
        public static final ProtoAdapter<Department> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<DepartmentPath> mdepartment_paths;
        public final GroupedManagedDepartments mgrouped_managed_departments;

        public static final class Builder extends Message.Builder<Department, Builder> {
            public List<DepartmentPath> mdepartment_paths;
            public GroupedManagedDepartments mgrouped_managed_departments;

            @Override // com.squareup.wire.Message.Builder
            public Department build() {
                return new Department(this.mdepartment_paths, this.mgrouped_managed_departments, super.buildUnknownFields());
            }

            public Builder() {
                this.mdepartment_paths = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder department_paths(List<DepartmentPath> r100) {
                Internal.checkElementsNotNull(r100);
                this.mdepartment_paths = r100;
                return this;
            }

            public Builder grouped_managed_departments(GroupedManagedDepartments r100) {
                this.mgrouped_managed_departments = r100;
                return this;
            }
        }

        public static final class DepartmentPath extends Message<DepartmentPath, Builder> {
            public static final ProtoAdapter<DepartmentPath> ADAPTER = null;
            public static final Boolean DEFAULT_ACCESSIBLE = null;
            public static final String DEFAULT_REDIRECT_LINK = "";
            private static final long serialVersionUID = 0;
            public final Boolean maccessible;
            public final List<DepartmentNode> mdepartment_nodes;
            public final I18nVal mno_access_description;
            public final String mredirect_link;

            public static final class Builder extends Message.Builder<DepartmentPath, Builder> {
                public Boolean maccessible;
                public List<DepartmentNode> mdepartment_nodes;
                public I18nVal mno_access_description;
                public String mredirect_link;

                @Override // com.squareup.wire.Message.Builder
                public DepartmentPath build() {
                    return new DepartmentPath(this.mdepartment_nodes, this.maccessible, this.mredirect_link, this.mno_access_description, super.buildUnknownFields());
                }

                public Builder() {
                    this.mdepartment_nodes = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder accessible(Boolean r100) {
                    this.maccessible = r100;
                    return this;
                }

                public Builder department_nodes(List<DepartmentNode> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.mdepartment_nodes = r100;
                    return this;
                }

                public Builder no_access_description(I18nVal r100) {
                    this.mno_access_description = r100;
                    return this;
                }

                public Builder redirect_link(String r100) {
                    this.mredirect_link = r100;
                    return this;
                }
            }

            public static final class DepartmentNode extends Message<DepartmentNode, Builder> {
                public static final ProtoAdapter<DepartmentNode> ADAPTER = null;
                public static final String DEFAULT_DEPARTMENT_ID = "";
                private static final long serialVersionUID = 0;
                public final String mdepartment_id;
                public final I18nVal mdepartment_name;

                public static final class Builder extends Message.Builder<DepartmentNode, Builder> {
                    public String mdepartment_id;
                    public I18nVal mdepartment_name;

                    @Override // com.squareup.wire.Message.Builder
                    public DepartmentNode build() {
                        return new DepartmentNode(this.mdepartment_name, this.mdepartment_id, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ Message build() {
                        return build();
                    }

                    public Builder department_id(String r100) {
                        this.mdepartment_id = r100;
                        return this;
                    }

                    public Builder department_name(I18nVal r100) {
                        this.mdepartment_name = r100;
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
                        r101.mdepartment_id = "";
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L12;
                        if (r103 != 1) goto L8;
                        r101.mdepartment_name = I18nVal.ADAPTER.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.mdepartment_id = ProtoAdapter.STRING.decode(r100);
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
                        I18nVal r101 = r100.mdepartment_name;
                        int r102 = 0;
                        if (r101 == null) goto L5;
                        int r103 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
                    L6:
                        String r104 = r100.mdepartment_id;
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
                        I18nVal r102 = r101.mdepartment_name;
                        if (r102 == null) goto L5;
                        I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
                    L5:
                        String r103 = r101.mdepartment_id;
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
                    r100.mdepartment_name = this.mdepartment_name;
                    r100.mdepartment_id = this.mdepartment_id;
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
                    this.mdepartment_name = r100;
                    this.mdepartment_id = r101;
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
                    r101.maccessible = Boolean.FALSE;
                    r101.mredirect_link = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.mdepartment_nodes.add(DepartmentNode.ADAPTER.decode(r100));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.maccessible = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.mredirect_link = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.mno_access_description = I18nVal.ADAPTER.decode(r100);
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
                    int r101 = DepartmentNode.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mdepartment_nodes);
                    Boolean r102 = r100.maccessible;
                    int r103 = 0;
                    if (r102 == null) goto L5;
                    int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
                L6:
                    int r105 = r101 + r104;
                    String r106 = r100.mredirect_link;
                    if (r106 == null) goto L9;
                    int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
                L10:
                    int r108 = r105 + r107;
                    I18nVal r109 = r100.mno_access_description;
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
                    DepartmentNode.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mdepartment_nodes);
                    Boolean r102 = r101.maccessible;
                    if (r102 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
                L5:
                    String r103 = r101.mredirect_link;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
                L8:
                    I18nVal r104 = r101.mno_access_description;
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
                r100.mdepartment_nodes = Internal.copyOf("mdepartment_nodes", this.mdepartment_nodes);
                r100.maccessible = this.maccessible;
                r100.mredirect_link = this.mredirect_link;
                r100.mno_access_description = this.mno_access_description;
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
                this.mdepartment_nodes = Internal.immutableCopyOf("mdepartment_nodes", r100);
                this.maccessible = r101;
                this.mredirect_link = r102;
                this.mno_access_description = r103;
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
                r101.mdepartment_paths.add(DepartmentPath.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mgrouped_managed_departments = GroupedManagedDepartments.ADAPTER.decode(r100);
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
                int r101 = DepartmentPath.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mdepartment_paths);
                GroupedManagedDepartments r102 = r100.mgrouped_managed_departments;
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
                DepartmentPath.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mdepartment_paths);
                GroupedManagedDepartments r102 = r101.mgrouped_managed_departments;
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
            r100.mdepartment_paths = Internal.copyOf("mdepartment_paths", this.mdepartment_paths);
            r100.mgrouped_managed_departments = this.mgrouped_managed_departments;
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
            this.mdepartment_paths = Internal.immutableCopyOf("mdepartment_paths", r100);
            this.mgrouped_managed_departments = r101;
        }
    }

    public static final class Field extends Message<Field, Builder> {
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Boolean DEFAULT_EDITABLE = null;
        public static final ByteString DEFAULT_FIELD_VAL = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_STR_FIELD_VAL = "";
        public static final Boolean DEFAULT_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final Boolean meditable;
        public final ByteString mfield_val;
        public final FieldValueType mfield_value_type;
        public final I18nVal mi18n_names;
        public final I18nVal mi18n_tip;
        public final String mkey;
        public final String mstr_field_val;
        public final UserFieldSource muser_field_source;
        public final Boolean mvisible;

        public static final class Builder extends Message.Builder<Field, Builder> {
            public Boolean meditable;
            public ByteString mfield_val;
            public FieldValueType mfield_value_type;
            public I18nVal mi18n_names;
            public I18nVal mi18n_tip;
            public String mkey;
            public String mstr_field_val;
            public UserFieldSource muser_field_source;
            public Boolean mvisible;

            @Override // com.squareup.wire.Message.Builder
            public Field build() {
                String r100 = this.mkey;
                if (r100 == null) goto L13;
                if (this.mi18n_names == null) goto L13;
                if (this.mvisible == null) goto L13;
                if (this.mfield_value_type == null) goto L13;
                return new Field(this.mkey, this.mi18n_names, this.mvisible, this.mfield_value_type, this.mfield_val, this.mstr_field_val, this.meditable, this.muser_field_source, this.mi18n_tip, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r100, "mkey", this.mi18n_names, "mi18n_names", this.mvisible, "mvisible", this.mfield_value_type, "mfield_value_type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder editable(Boolean r100) {
                this.meditable = r100;
                return this;
            }

            public Builder field_val(ByteString r100) {
                this.mfield_val = r100;
                return this;
            }

            public Builder field_value_type(FieldValueType r100) {
                this.mfield_value_type = r100;
                return this;
            }

            public Builder i18n_names(I18nVal r100) {
                this.mi18n_names = r100;
                return this;
            }

            public Builder i18n_tip(I18nVal r100) {
                this.mi18n_tip = r100;
                return this;
            }

            public Builder key(String r100) {
                this.mkey = r100;
                return this;
            }

            public Builder str_field_val(String r100) {
                this.mstr_field_val = r100;
                return this;
            }

            public Builder user_field_source(UserFieldSource r100) {
                this.muser_field_source = r100;
                return this;
            }

            public Builder visible(Boolean r100) {
                this.mvisible = r100;
                return this;
            }
        }

        public static final enum FieldValueType extends Enum<FieldValueType> implements WireEnum {
            private static final /* synthetic */ FieldValueType[] $VALUES = null;
            public static final ProtoAdapter<FieldValueType> ADAPTER = null;
            public static final FieldValueType ALIAS_AND_MEMO = null;
            public static final FieldValueType CUSTOM_FIELD_IMAGE = null;
            public static final FieldValueType CUSTOM_PHONE = null;
            public static final FieldValueType C_ALIAS = null;
            public static final FieldValueType ENUMERATION = null;
            public static final FieldValueType GENERIC_USER = null;
            public static final FieldValueType LINK = null;
            public static final FieldValueType LINK_LIST = null;
            public static final FieldValueType MEMO_DESCRIPTION = null;
            public static final FieldValueType S_DEPARTMENT = null;
            public static final FieldValueType S_FRIEND_LINK = null;
            public static final FieldValueType S_PHONE_NUMBER = null;
            public static final FieldValueType TEXT = null;
            public static final FieldValueType TEXT_LIST = null;
            public static final FieldValueType UNKNOWN = null;
            private final int value;

            static {
                FieldValueType r100 = new FieldValueType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                FieldValueType r101 = new FieldValueType(CardAdapter.TEXT, 1, 1);
                TEXT = r101;
                FieldValueType r102 = new FieldValueType("LINK", 2, 2);
                LINK = r102;
                FieldValueType r103 = new FieldValueType("TEXT_LIST", 3, 3);
                TEXT_LIST = r103;
                FieldValueType r104 = new FieldValueType("LINK_LIST", 4, 4);
                LINK_LIST = r104;
                FieldValueType r105 = new FieldValueType("ENUMERATION", 5, 5);
                ENUMERATION = r105;
                FieldValueType r110 = new FieldValueType("GENERIC_USER", 6, 6);
                GENERIC_USER = r110;
                FieldValueType r111 = new FieldValueType("CUSTOM_PHONE", 7, 9);
                CUSTOM_PHONE = r111;
                FieldValueType r112 = new FieldValueType("C_ALIAS", 8, 50);
                C_ALIAS = r112;
                FieldValueType r113 = new FieldValueType("S_DEPARTMENT", 9, 100);
                S_DEPARTMENT = r113;
                FieldValueType r106 = new FieldValueType("S_PHONE_NUMBER", 10, 101);
                S_PHONE_NUMBER = r106;
                FieldValueType r114 = new FieldValueType("S_FRIEND_LINK", 11, 102);
                S_FRIEND_LINK = r114;
                FieldValueType r107 = new FieldValueType("CUSTOM_FIELD_IMAGE", 12, 103);
                CUSTOM_FIELD_IMAGE = r107;
                FieldValueType r108 = new FieldValueType("ALIAS_AND_MEMO", 13, 104);
                ALIAS_AND_MEMO = r108;
                FieldValueType r109 = new FieldValueType("MEMO_DESCRIPTION", 14, 105);
                MEMO_DESCRIPTION = r109;
                $VALUES = new FieldValueType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r114, r107, r108, r109};
                ADAPTER = ProtoAdapter.newEnumAdapter(FieldValueType.class);
            }

            public static FieldValueType[] values() {
                return (FieldValueType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FieldValueType fromValue(int r100) {
                if (r100 == 9) goto L39;
                if (r100 == 50) goto L37;
                switch(r100) {
                    case 0: goto L35;
                    case 1: goto L33;
                    case 2: goto L31;
                    case 3: goto L29;
                    case 4: goto L27;
                    case 5: goto L25;
                    case 6: goto L23;
                    default: goto L7;
                };
            L7:
                switch(r100) {
                    case 100: goto L21;
                    case 101: goto L19;
                    case 102: goto L17;
                    case 103: goto L15;
                    case 104: goto L13;
                    case 105: goto L11;
                    default: goto L8;
                };
            L8:
                return null;
            L11:
                return MEMO_DESCRIPTION;
            L13:
                return ALIAS_AND_MEMO;
            L15:
                return CUSTOM_FIELD_IMAGE;
            L17:
                return S_FRIEND_LINK;
            L19:
                return S_PHONE_NUMBER;
            L21:
                return S_DEPARTMENT;
            L23:
                return GENERIC_USER;
            L25:
                return ENUMERATION;
            L27:
                return LINK_LIST;
            L29:
                return TEXT_LIST;
            L31:
                return LINK;
            L33:
                return TEXT;
            L35:
                return UNKNOWN;
            L37:
                return C_ALIAS;
            L39:
                return CUSTOM_PHONE;
            }

            public static FieldValueType valueOf(String r100) {
                return (FieldValueType) a.a(FieldValueType.class, r100);
            }

            private FieldValueType(String r100, int r101, int r102) {
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
                r101.mkey = "";
                Boolean r102 = Boolean.FALSE;
                r101.mvisible = r102;
                r101.mfield_val = ByteString.EMPTY;
                r101.mstr_field_val = "";
                r101.meditable = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L22;
                switch(r104) {
                    case 1: goto L21;
                    case 2: goto L20;
                    case 3: goto L19;
                    case 4: goto L6;
                    case 5: goto L24;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L26;
                    case 10: goto L7;
                    default: goto L6;
                };
            L24:
                r101.mfield_value_type = FieldValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L26:
                r101.muser_field_source = UserFieldSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mi18n_tip = I18nVal.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.meditable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.mstr_field_val = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.mfield_val = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L19:
                r101.mvisible = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L20:
                r101.mi18n_names = I18nVal.ADAPTER.decode(r100);
                goto L3
            L21:
                r101.mkey = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L22:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Field r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.mkey);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                int r104 = r102 + r103.encodedSizeWithTag(2, r100.mi18n_names);
                ProtoAdapter<Boolean> r105 = ProtoAdapter.BOOL;
                int r106 = (r104 + r105.encodedSizeWithTag(3, r100.mvisible)) + FieldValueType.ADAPTER.encodedSizeWithTag(5, r100.mfield_value_type);
                ByteString r107 = r100.mfield_val;
                int r108 = 0;
                if (r107 == null) goto L5;
                int r109 = ProtoAdapter.BYTES.encodedSizeWithTag(6, r107);
            L6:
                int r110 = r106 + r109;
                String r111 = r100.mstr_field_val;
                if (r111 == null) goto L9;
                int r112 = r101.encodedSizeWithTag(7, r111);
            L10:
                int r113 = r110 + r112;
                Boolean r114 = r100.meditable;
                if (r114 == null) goto L13;
                int r115 = r105.encodedSizeWithTag(8, r114);
            L14:
                int r116 = r113 + r115;
                UserFieldSource r117 = r100.muser_field_source;
                if (r117 == null) goto L17;
                int r118 = UserFieldSource.ADAPTER.encodedSizeWithTag(9, r117);
            L18:
                int r119 = r116 + r118;
                I18nVal r120 = r100.mi18n_tip;
                if (r120 == null) goto L22;
                r108 = r103.encodedSizeWithTag(10, r120);
            L22:
                return (r119 + r108) + r100.unknownFields().size();
            L17:
                r118 = 0;
                goto L18
            L13:
                r115 = 0;
                goto L14
            L9:
                r112 = 0;
                goto L10
            L5:
                r109 = 0;
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
                r102.encodeWithTag(r100, 1, r101.mkey);
                ProtoAdapter<I18nVal> r103 = I18nVal.ADAPTER;
                r103.encodeWithTag(r100, 2, r101.mi18n_names);
                ProtoAdapter<Boolean> r104 = ProtoAdapter.BOOL;
                r104.encodeWithTag(r100, 3, r101.mvisible);
                FieldValueType.ADAPTER.encodeWithTag(r100, 5, r101.mfield_value_type);
                ByteString r105 = r101.mfield_val;
                if (r105 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r100, 6, r105);
            L5:
                String r106 = r101.mstr_field_val;
                if (r106 == null) goto L8;
                r102.encodeWithTag(r100, 7, r106);
            L8:
                Boolean r107 = r101.meditable;
                if (r107 == null) goto L11;
                r104.encodeWithTag(r100, 8, r107);
            L11:
                UserFieldSource r108 = r101.muser_field_source;
                if (r108 == null) goto L14;
                UserFieldSource.ADAPTER.encodeWithTag(r100, 9, r108);
            L14:
                I18nVal r109 = r101.mi18n_tip;
                if (r109 == null) goto L17;
                r103.encodeWithTag(r100, 10, r109);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Field r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum UserFieldSource extends Enum<UserFieldSource> implements WireEnum {
            private static final /* synthetic */ UserFieldSource[] $VALUES = null;
            public static final ProtoAdapter<UserFieldSource> ADAPTER = null;
            public static final UserFieldSource UserFieldSource_BUILTIN = null;
            public static final UserFieldSource UserFieldSource_CUSTOM = null;
            private final int value;

            static {
                UserFieldSource r100 = new UserFieldSource("UserFieldSource_BUILTIN", 0, 1);
                UserFieldSource_BUILTIN = r100;
                UserFieldSource r101 = new UserFieldSource("UserFieldSource_CUSTOM", 1, 2);
                UserFieldSource_CUSTOM = r101;
                $VALUES = new UserFieldSource[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(UserFieldSource.class);
            }

            public static UserFieldSource[] values() {
                return (UserFieldSource[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static UserFieldSource fromValue(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return null;
            L9:
                return UserFieldSource_CUSTOM;
            L11:
                return UserFieldSource_BUILTIN;
            }

            public static UserFieldSource valueOf(String r100) {
                return (UserFieldSource) a.a(UserFieldSource.class, r100);
            }

            private UserFieldSource(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Field();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_VISIBLE = r100;
            DEFAULT_FIELD_VAL = ByteString.EMPTY;
            DEFAULT_EDITABLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mkey = this.mkey;
            r100.mi18n_names = this.mi18n_names;
            r100.mvisible = this.mvisible;
            r100.mfield_value_type = this.mfield_value_type;
            r100.mfield_val = this.mfield_val;
            r100.mstr_field_val = this.mstr_field_val;
            r100.meditable = this.meditable;
            r100.muser_field_source = this.muser_field_source;
            r100.mi18n_tip = this.mi18n_tip;
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

        public Field(String r110, I18nVal r111, Boolean r112, FieldValueType r113, ByteString r114, String r115, Boolean r116, UserFieldSource r117, I18nVal r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public Field(String r100, I18nVal r101, Boolean r102, FieldValueType r103, ByteString r104, String r105, Boolean r106, UserFieldSource r107, I18nVal r110, ByteString r111) {
            super(ADAPTER, r111);
            this.mkey = r100;
            this.mi18n_names = r101;
            this.mvisible = r102;
            this.mfield_value_type = r103;
            this.mfield_val = r104;
            this.mstr_field_val = r105;
            this.meditable = r106;
            this.muser_field_source = r107;
            this.mi18n_tip = r110;
        }
    }

    public static final enum FriendStatus extends Enum<FriendStatus> implements WireEnum {
        private static final /* synthetic */ FriendStatus[] $VALUES = null;
        public static final ProtoAdapter<FriendStatus> ADAPTER = null;
        public static final FriendStatus Double = null;
        public static final FriendStatus Forward = null;
        public static final FriendStatus None = null;
        public static final FriendStatus Reverse = null;
        public static final FriendStatus UNKNOWN = null;
        private final int value;

        static {
            FriendStatus r100 = new FriendStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FriendStatus r101 = new FriendStatus("Double", 1, 1);
            Double = r101;
            FriendStatus r102 = new FriendStatus("Forward", 2, 2);
            Forward = r102;
            FriendStatus r103 = new FriendStatus("Reverse", 3, 3);
            Reverse = r103;
            FriendStatus r104 = new FriendStatus("None", 4, 4);
            None = r104;
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
            return None;
        L16:
            return Reverse;
        L18:
            return Forward;
        L20:
            return Double;
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

    public static final class Href extends Message<Href, Builder> {
        public static final ProtoAdapter<Href> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal mlink;
        public final Style mstyle;
        public final I18nVal mtitle;

        public static final class Builder extends Message.Builder<Href, Builder> {
            public I18nVal mlink;
            public Style mstyle;
            public I18nVal mtitle;

            @Override // com.squareup.wire.Message.Builder
            public Href build() {
                return new Href(this.mtitle, this.mlink, this.mstyle, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder link(I18nVal r100) {
                this.mlink = r100;
                return this;
            }

            public Builder style(Style r100) {
                this.mstyle = r100;
                return this;
            }

            public Builder title(I18nVal r100) {
                this.mtitle = r100;
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
                r101.mtitle = I18nVal.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mlink = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mstyle = Style.ADAPTER.decode(r100);
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
                I18nVal r101 = r100.mtitle;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.mlink;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Style r107 = r100.mstyle;
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
                I18nVal r102 = r101.mtitle;
                if (r102 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.mlink;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Style r104 = r101.mstyle;
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
            r100.mtitle = this.mtitle;
            r100.mlink = this.mlink;
            r100.mstyle = this.mstyle;
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
            this.mtitle = r100;
            this.mlink = r101;
            this.mstyle = r102;
        }
    }

    public static final class HrefList extends Message<HrefList, Builder> {
        public static final ProtoAdapter<HrefList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Href> mhref_list;

        public static final class Builder extends Message.Builder<HrefList, Builder> {
            public List<Href> mhref_list;

            @Override // com.squareup.wire.Message.Builder
            public HrefList build() {
                return new HrefList(this.mhref_list, super.buildUnknownFields());
            }

            public Builder() {
                this.mhref_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder href_list(List<Href> r100) {
                Internal.checkElementsNotNull(r100);
                this.mhref_list = r100;
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
                r101.mhref_list.add(Href.ADAPTER.decode(r100));
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
                return Href.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mhref_list) + r100.unknownFields().size();
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
                Href.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mhref_list);
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
            r100.mhref_list = Internal.copyOf("mhref_list", this.mhref_list);
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
            this.mhref_list = Internal.immutableCopyOf("mhref_list", r100);
        }
    }

    public static final class Medal extends Message<Medal, Builder> {
        public static final ProtoAdapter<Medal> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal mi18n_name;
        public final ImageSetPassThrough mimage;

        public static final class Builder extends Message.Builder<Medal, Builder> {
            public I18nVal mi18n_name;
            public ImageSetPassThrough mimage;

            @Override // com.squareup.wire.Message.Builder
            public Medal build() {
                return new Medal(this.mimage, this.mi18n_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder i18n_name(I18nVal r100) {
                this.mi18n_name = r100;
                return this;
            }

            public Builder image(ImageSetPassThrough r100) {
                this.mimage = r100;
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
                r101.mimage = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mi18n_name = I18nVal.ADAPTER.decode(r100);
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
                ImageSetPassThrough r101 = r100.mimage;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.mi18n_name;
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
                ImageSetPassThrough r102 = r101.mimage;
                if (r102 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.mi18n_name;
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
            r100.mimage = this.mimage;
            r100.mi18n_name = this.mi18n_name;
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
            this.mimage = r100;
            this.mi18n_name = r101;
        }
    }

    public static final class MedalList extends Message<MedalList, Builder> {
        public static final ProtoAdapter<MedalList> ADAPTER = null;
        public static final Integer DEFAULT_TOTAL_NUM = null;
        private static final long serialVersionUID = 0;
        public final List<Medal> mmedal_meta;
        public final Integer mtotal_num;

        public static final class Builder extends Message.Builder<MedalList, Builder> {
            public List<Medal> mmedal_meta;
            public Integer mtotal_num;

            @Override // com.squareup.wire.Message.Builder
            public MedalList build() {
                return new MedalList(this.mmedal_meta, this.mtotal_num, super.buildUnknownFields());
            }

            public Builder() {
                this.mmedal_meta = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder medal_meta(List<Medal> r100) {
                Internal.checkElementsNotNull(r100);
                this.mmedal_meta = r100;
                return this;
            }

            public Builder total_num(Integer r100) {
                this.mtotal_num = r100;
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
                r101.mtotal_num = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mmedal_meta.add(Medal.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mtotal_num = ProtoAdapter.INT32.decode(r100);
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
                int r101 = Medal.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mmedal_meta);
                Integer r102 = r100.mtotal_num;
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
                Medal.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mmedal_meta);
                Integer r102 = r101.mtotal_num;
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
            r100.mmedal_meta = Internal.copyOf("mmedal_meta", this.mmedal_meta);
            r100.mtotal_num = this.mtotal_num;
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
            this.mmedal_meta = Internal.immutableCopyOf("mmedal_meta", r100);
            this.mtotal_num = r101;
        }
    }

    public static final class MemoDescription extends Message<MemoDescription, Builder> {
        public static final ProtoAdapter<MemoDescription> ADAPTER = null;
        public static final String DEFAULT_MEMO_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Map<String, PreviewHangPoint> manchor_id_2_preview_hang_point;
        public final ImageSetPassThrough mmemo_picture;
        public final List<ImageSetPassThrough> mmemo_picture_v2;
        public final String mmemo_text;
        public final RichText mmemo_text_v2;

        public static final class Builder extends Message.Builder<MemoDescription, Builder> {
            public Map<String, PreviewHangPoint> manchor_id_2_preview_hang_point;
            public ImageSetPassThrough mmemo_picture;
            public List<ImageSetPassThrough> mmemo_picture_v2;
            public String mmemo_text;
            public RichText mmemo_text_v2;

            @Override // com.squareup.wire.Message.Builder
            public MemoDescription build() {
                return new MemoDescription(this.mmemo_text, this.mmemo_picture, this.mmemo_text_v2, this.mmemo_picture_v2, this.manchor_id_2_preview_hang_point, super.buildUnknownFields());
            }

            public Builder() {
                this.mmemo_picture_v2 = Internal.newMutableList();
                this.manchor_id_2_preview_hang_point = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder anchor_id_2_preview_hang_point(Map<String, PreviewHangPoint> r100) {
                Internal.checkElementsNotNull(r100);
                this.manchor_id_2_preview_hang_point = r100;
                return this;
            }

            public Builder memo_picture(ImageSetPassThrough r100) {
                this.mmemo_picture = r100;
                return this;
            }

            public Builder memo_picture_v2(List<ImageSetPassThrough> r100) {
                Internal.checkElementsNotNull(r100);
                this.mmemo_picture_v2 = r100;
                return this;
            }

            public Builder memo_text(String r100) {
                this.mmemo_text = r100;
                return this;
            }

            public Builder memo_text_v2(RichText r100) {
                this.mmemo_text_v2 = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MemoDescription extends ProtoAdapter<MemoDescription> {
            private final ProtoAdapter<Map<String, PreviewHangPoint>> manchor_id_2_preview_hang_point;

            public ProtoAdapter_MemoDescription() {
                super(FieldEncoding.LENGTH_DELIMITED, MemoDescription.class);
                this.manchor_id_2_preview_hang_point = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, PreviewHangPoint.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MemoDescription decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mmemo_text = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mmemo_text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mmemo_picture = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mmemo_text_v2 = RichText.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.mmemo_picture_v2.add(ImageSetPassThrough.ADAPTER.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.manchor_id_2_preview_hang_point.putAll(this.manchor_id_2_preview_hang_point.decode(r100));
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
            public int encodedSize2(MemoDescription r100) {
                String r101 = r100.mmemo_text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ImageSetPassThrough r104 = r100.mmemo_picture;
                if (r104 == null) goto L9;
                int r105 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                RichText r107 = r100.mmemo_text_v2;
                if (r107 == null) goto L14;
                r102 = RichText.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (((r106 + r102) + ImageSetPassThrough.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mmemo_picture_v2)) + this.manchor_id_2_preview_hang_point.encodedSizeWithTag(5, r100.manchor_id_2_preview_hang_point)) + r100.unknownFields().size();
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
                String r102 = r101.mmemo_text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ImageSetPassThrough r103 = r101.mmemo_picture;
                if (r103 == null) goto L8;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                RichText r104 = r101.mmemo_text_v2;
                if (r104 == null) goto L11;
                RichText.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ImageSetPassThrough.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mmemo_picture_v2);
                this.manchor_id_2_preview_hang_point.encodeWithTag(r100, 5, r101.manchor_id_2_preview_hang_point);
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
            r100.mmemo_text = this.mmemo_text;
            r100.mmemo_picture = this.mmemo_picture;
            r100.mmemo_text_v2 = this.mmemo_text_v2;
            r100.mmemo_picture_v2 = Internal.copyOf("mmemo_picture_v2", this.mmemo_picture_v2);
            r100.manchor_id_2_preview_hang_point = Internal.copyOf("manchor_id_2_preview_hang_point", this.manchor_id_2_preview_hang_point);
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

        public MemoDescription(String r100, ImageSetPassThrough r101, RichText r110, List<ImageSetPassThrough> r111, Map<String, PreviewHangPoint> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public MemoDescription(String r100, ImageSetPassThrough r101, RichText r102, List<ImageSetPassThrough> r103, Map<String, PreviewHangPoint> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.mmemo_text = r100;
            this.mmemo_picture = r101;
            this.mmemo_text_v2 = r102;
            this.mmemo_picture_v2 = Internal.immutableCopyOf("mmemo_picture_v2", r103);
            this.manchor_id_2_preview_hang_point = Internal.immutableCopyOf("manchor_id_2_preview_hang_point", r104);
        }
    }

    public static final class OpenSectionInfo extends Message<OpenSectionInfo, Builder> {
        public static final ProtoAdapter<OpenSectionInfo> ADAPTER = null;
        public static final String DEFAULT_SECTION_CONTENT = "";
        public static final String DEFAULT_SECTION_ID = "";
        private static final long serialVersionUID = 0;
        public final String msection_content;
        public final String msection_id;
        public final OpenSectionType msection_type;

        public static final class Builder extends Message.Builder<OpenSectionInfo, Builder> {
            public String msection_content;
            public String msection_id;
            public OpenSectionType msection_type;

            @Override // com.squareup.wire.Message.Builder
            public OpenSectionInfo build() {
                return new OpenSectionInfo(this.msection_id, this.msection_type, this.msection_content, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder section_content(String r100) {
                this.msection_content = r100;
                return this;
            }

            public Builder section_id(String r100) {
                this.msection_id = r100;
                return this;
            }

            public Builder section_type(OpenSectionType r100) {
                this.msection_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenSectionInfo extends ProtoAdapter<OpenSectionInfo> {
            public ProtoAdapter_OpenSectionInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenSectionInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OpenSectionInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.msection_id = "";
                r101.msection_content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.msection_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.msection_type = OpenSectionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.msection_content = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(OpenSectionInfo r100) {
                String r101 = r100.msection_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                OpenSectionType r104 = r100.msection_type;
                if (r104 == null) goto L9;
                int r105 = OpenSectionType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.msection_content;
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
            public /* bridge */ /* synthetic */ OpenSectionInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OpenSectionInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OpenSectionInfo r101) throws IOException {
                String r102 = r101.msection_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                OpenSectionType r103 = r101.msection_type;
                if (r103 == null) goto L8;
                OpenSectionType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.msection_content;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenSectionInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenSectionInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.msection_id = this.msection_id;
            r100.msection_type = this.msection_type;
            r100.msection_content = this.msection_content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OpenSectionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OpenSectionInfo(String r100, OpenSectionType r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public OpenSectionInfo(String r100, OpenSectionType r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.msection_id = r100;
            this.msection_type = r101;
            this.msection_content = r102;
        }
    }

    public static final class OpenSectionInfoList extends Message<OpenSectionInfoList, Builder> {
        public static final ProtoAdapter<OpenSectionInfoList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<OpenSectionInfo> mopen_section_list;

        public static final class Builder extends Message.Builder<OpenSectionInfoList, Builder> {
            public List<OpenSectionInfo> mopen_section_list;

            @Override // com.squareup.wire.Message.Builder
            public OpenSectionInfoList build() {
                return new OpenSectionInfoList(this.mopen_section_list, super.buildUnknownFields());
            }

            public Builder() {
                this.mopen_section_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder open_section_list(List<OpenSectionInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.mopen_section_list = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenSectionInfoList extends ProtoAdapter<OpenSectionInfoList> {
            public ProtoAdapter_OpenSectionInfoList() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenSectionInfoList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OpenSectionInfoList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mopen_section_list.add(OpenSectionInfo.ADAPTER.decode(r100));
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
            public int encodedSize2(OpenSectionInfoList r100) {
                return OpenSectionInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mopen_section_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OpenSectionInfoList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OpenSectionInfoList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OpenSectionInfoList r101) throws IOException {
                OpenSectionInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mopen_section_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenSectionInfoList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenSectionInfoList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mopen_section_list = Internal.copyOf("mopen_section_list", this.mopen_section_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OpenSectionInfoList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OpenSectionInfoList(List<OpenSectionInfo> r100) {
            this(r100, ByteString.EMPTY);
        }

        public OpenSectionInfoList(List<OpenSectionInfo> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mopen_section_list = Internal.immutableCopyOf("mopen_section_list", r100);
        }
    }

    public static final enum OpenSectionType extends Enum<OpenSectionType> implements WireEnum {
        private static final /* synthetic */ OpenSectionType[] $VALUES = null;
        public static final ProtoAdapter<OpenSectionType> ADAPTER = null;
        public static final OpenSectionType S_CARD = null;
        public static final OpenSectionType S_UNKNOWN = null;
        private final int value;

        static {
            OpenSectionType r100 = new OpenSectionType("S_UNKNOWN", 0, 0);
            S_UNKNOWN = r100;
            OpenSectionType r101 = new OpenSectionType("S_CARD", 1, 1);
            S_CARD = r101;
            $VALUES = new OpenSectionType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(OpenSectionType.class);
        }

        public static OpenSectionType[] values() {
            return (OpenSectionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OpenSectionType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return S_CARD;
        L10:
            return S_UNKNOWN;
        }

        public static OpenSectionType valueOf(String r100) {
            return (OpenSectionType) a.a(OpenSectionType.class, r100);
        }

        private OpenSectionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class PhoneNumber extends Message<PhoneNumber, Builder> {
        public static final ProtoAdapter<PhoneNumber> ADAPTER = null;
        public static final String DEFAULT_COUNTRY_CODE = "";
        public static final Boolean DEFAULT_IS_PLAIN = null;
        public static final String DEFAULT_NUMBER = "";
        public static final Boolean DEFAULT_RATE_LIMITED = null;
        private static final long serialVersionUID = 0;
        public final String mcountry_code;
        public final Boolean mis_plain;
        public final String mnumber;
        public final Boolean mrate_limited;

        public static final class Builder extends Message.Builder<PhoneNumber, Builder> {
            public String mcountry_code;
            public Boolean mis_plain;
            public String mnumber;
            public Boolean mrate_limited;

            @Override // com.squareup.wire.Message.Builder
            public PhoneNumber build() {
                return new PhoneNumber(this.mnumber, this.mcountry_code, this.mrate_limited, this.mis_plain, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder country_code(String r100) {
                this.mcountry_code = r100;
                return this;
            }

            public Builder is_plain(Boolean r100) {
                this.mis_plain = r100;
                return this;
            }

            public Builder number(String r100) {
                this.mnumber = r100;
                return this;
            }

            public Builder rate_limited(Boolean r100) {
                this.mrate_limited = r100;
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
                r101.mnumber = "";
                r101.mcountry_code = "";
                Boolean r102 = Boolean.FALSE;
                r101.mrate_limited = r102;
                r101.mis_plain = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.mnumber = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.mcountry_code = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.mrate_limited = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.mis_plain = ProtoAdapter.BOOL.decode(r100);
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
                String r101 = r100.mnumber;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mcountry_code;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.mrate_limited;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.mis_plain;
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
                String r102 = r101.mnumber;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mcountry_code;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.mrate_limited;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.mis_plain;
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
            r100.mnumber = this.mnumber;
            r100.mcountry_code = this.mcountry_code;
            r100.mrate_limited = this.mrate_limited;
            r100.mis_plain = this.mis_plain;
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
            this.mnumber = r100;
            this.mcountry_code = r101;
            this.mrate_limited = r102;
            this.mis_plain = r103;
        }
    }

    public static final class ProtoAdapter_Profile extends ProtoAdapter<Profile> {
        public ProtoAdapter_Profile() {
            super(FieldEncoding.LENGTH_DELIMITED, Profile.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Profile decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.muser_info = UserInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mctas.add(CTA.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mfields.add(Field.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mtabs.add(TabInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(Profile r100) {
            UserInfo r101 = r100.muser_info;
            if (r101 == null) goto L5;
            int r102 = UserInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (((r102 + CTA.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mctas)) + Field.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mfields)) + TabInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mtabs)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Profile decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Profile r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Profile r101) throws IOException {
            UserInfo r102 = r101.muser_info;
            if (r102 == null) goto L5;
            UserInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CTA.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mctas);
            Field.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mfields);
            TabInfo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mtabs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Profile r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ShareInfo extends Message<ShareInfo, Builder> {
        public static final ProtoAdapter<ShareInfo> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE = null;
        private static final long serialVersionUID = 0;
        public final I18nVal mdenied_description;
        public final Boolean menable;
        public final I18nVal mi18n_names;

        public static final class Builder extends Message.Builder<ShareInfo, Builder> {
            public I18nVal mdenied_description;
            public Boolean menable;
            public I18nVal mi18n_names;

            @Override // com.squareup.wire.Message.Builder
            public ShareInfo build() {
                return new ShareInfo(this.menable, this.mi18n_names, this.mdenied_description, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder denied_description(I18nVal r100) {
                this.mdenied_description = r100;
                return this;
            }

            public Builder enable(Boolean r100) {
                this.menable = r100;
                return this;
            }

            public Builder i18n_names(I18nVal r100) {
                this.mi18n_names = r100;
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
                r101.menable = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.menable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mi18n_names = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mdenied_description = I18nVal.ADAPTER.decode(r100);
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
                Boolean r101 = r100.menable;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.mi18n_names;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                I18nVal r107 = r100.mdenied_description;
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
                Boolean r102 = r101.menable;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.mi18n_names;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                I18nVal r104 = r101.mdenied_description;
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
            r100.menable = this.menable;
            r100.mi18n_names = this.mi18n_names;
            r100.mdenied_description = this.mdenied_description;
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
            this.menable = r100;
            this.mi18n_names = r101;
            this.mdenied_description = r102;
        }
    }

    public static final class SingleFieldTabInfo extends Message<SingleFieldTabInfo, Builder> {
        public static final ProtoAdapter<SingleFieldTabInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Field msingle_field;

        public static final class Builder extends Message.Builder<SingleFieldTabInfo, Builder> {
            public Field msingle_field;

            @Override // com.squareup.wire.Message.Builder
            public SingleFieldTabInfo build() {
                return new SingleFieldTabInfo(this.msingle_field, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder single_field(Field r100) {
                this.msingle_field = r100;
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
                r101.msingle_field = Field.ADAPTER.decode(r100);
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
                Field r101 = r100.msingle_field;
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
                Field r102 = r101.msingle_field;
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
            r100.msingle_field = this.msingle_field;
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
            this.msingle_field = r100;
        }
    }

    public static final class Style extends Message<Style, Builder> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final String DEFAULT_COLOR = "";
        public static final Boolean DEFAULT_EXPANDABLE = null;
        public static final Integer DEFAULT_MAX_LINES = null;
        private static final long serialVersionUID = 0;
        public final String mcolor;
        public final Boolean mexpandable;
        public final Integer mmax_lines;

        public static final class Builder extends Message.Builder<Style, Builder> {
            public String mcolor;
            public Boolean mexpandable;
            public Integer mmax_lines;

            @Override // com.squareup.wire.Message.Builder
            public Style build() {
                return new Style(this.mmax_lines, this.mexpandable, this.mcolor, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder color(String r100) {
                this.mcolor = r100;
                return this;
            }

            public Builder expandable(Boolean r100) {
                this.mexpandable = r100;
                return this;
            }

            public Builder max_lines(Integer r100) {
                this.mmax_lines = r100;
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
                r101.mmax_lines = 0;
                r101.mexpandable = Boolean.FALSE;
                r101.mcolor = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mmax_lines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mexpandable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mcolor = ProtoAdapter.STRING.decode(r100);
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
                Integer r101 = r100.mmax_lines;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mexpandable;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mcolor;
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
                Integer r102 = r101.mmax_lines;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mexpandable;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mcolor;
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
            r100.mmax_lines = this.mmax_lines;
            r100.mexpandable = this.mexpandable;
            r100.mcolor = this.mcolor;
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
            this.mmax_lines = r100;
            this.mexpandable = r101;
            this.mcolor = r102;
        }
    }

    public static final class TabInfo extends Message<TabInfo, Builder> {
        public static final ProtoAdapter<TabInfo> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mkey;
        public final I18nVal mname;
        public final TabType mtab_type;

        public static final class Builder extends Message.Builder<TabInfo, Builder> {
            public String mcontent;
            public String mkey;
            public I18nVal mname;
            public TabType mtab_type;

            @Override // com.squareup.wire.Message.Builder
            public TabInfo build() {
                return new TabInfo(this.mkey, this.mname, this.mtab_type, this.mcontent, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder key(String r100) {
                this.mkey = r100;
                return this;
            }

            public Builder name(I18nVal r100) {
                this.mname = r100;
                return this;
            }

            public Builder tab_type(TabType r100) {
                this.mtab_type = r100;
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
                r101.mkey = "";
                r101.mcontent = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mkey = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mname = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mtab_type = TabType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.mkey;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.mname;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TabType r107 = r100.mtab_type;
                if (r107 == null) goto L13;
                int r108 = TabType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mcontent;
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
                String r102 = r101.mkey;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.mname;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                TabType r104 = r101.mtab_type;
                if (r104 == null) goto L11;
                TabType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mcontent;
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

        static {
            ADAPTER = new ProtoAdapter_TabInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mkey = this.mkey;
            r100.mname = this.mname;
            r100.mtab_type = this.mtab_type;
            r100.mcontent = this.mcontent;
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
            this.mkey = r100;
            this.mname = r101;
            this.mtab_type = r102;
            this.mcontent = r103;
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

    public static final class Text extends Message<Text, Builder> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Style mstyle;
        public final I18nVal mtext;

        public static final class Builder extends Message.Builder<Text, Builder> {
            public Style mstyle;
            public I18nVal mtext;

            @Override // com.squareup.wire.Message.Builder
            public Text build() {
                return new Text(this.mtext, this.mstyle, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder style(Style r100) {
                this.mstyle = r100;
                return this;
            }

            public Builder text(I18nVal r100) {
                this.mtext = r100;
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
                r101.mtext = I18nVal.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mstyle = Style.ADAPTER.decode(r100);
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
                I18nVal r101 = r100.mtext;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = I18nVal.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Style r104 = r100.mstyle;
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
                I18nVal r102 = r101.mtext;
                if (r102 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Style r103 = r101.mstyle;
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
            r100.mtext = this.mtext;
            r100.mstyle = this.mstyle;
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
            this.mtext = r100;
            this.mstyle = r101;
        }
    }

    public static final class TextList extends Message<TextList, Builder> {
        public static final ProtoAdapter<TextList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Text> mtext_list;

        public static final class Builder extends Message.Builder<TextList, Builder> {
            public List<Text> mtext_list;

            @Override // com.squareup.wire.Message.Builder
            public TextList build() {
                return new TextList(this.mtext_list, super.buildUnknownFields());
            }

            public Builder() {
                this.mtext_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder text_list(List<Text> r100) {
                Internal.checkElementsNotNull(r100);
                this.mtext_list = r100;
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
                r101.mtext_list.add(Text.ADAPTER.decode(r100));
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
                return Text.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mtext_list) + r100.unknownFields().size();
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
                Text.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mtext_list);
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
            r100.mtext_list = Internal.copyOf("mtext_list", this.mtext_list);
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
            this.mtext_list = Internal.immutableCopyOf("mtext_list", r100);
        }
    }

    public static final class UserInfo extends Message<UserInfo, Builder> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_BLOCK = null;
        public static final Boolean DEFAULT_CAN_SET_STRANGER = null;
        public static final Long DEFAULT_CONTACT_APPLICATION_ID = null;
        public static final String DEFAULT_CONTACT_TOKEN = "";
        public static final Boolean DEFAULT_ENABLE_ADD_BY_CONTACT_TOKEN = null;
        public static final String DEFAULT_GENDER_PRONOUNS = "";
        public static final Boolean DEFAULT_HIDE_ADD_CONNECT_BUTTON = null;
        public static final Boolean DEFAULT_IS_BLOCKED = null;
        public static final Boolean DEFAULT_IS_LH = null;
        public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
        public static final Boolean DEFAULT_IS_STRANGER = null;
        public static final Boolean DEFAULT_IS_TENANT_CERTIFICATION = null;
        public static final String DEFAULT_LEADER_ID = "";
        public static final Boolean DEFAULT_SHOW_DESCRIPTION = null;
        public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
        public static final FieldOptions FIELD_OPTIONS_MLEADER_ID = null;
        private static final long serialVersionUID = 0;
        public final ApplyCommunication mapply_communication;
        public final BlockStatus mblock_status;
        public final Boolean mcan_block;
        public final Boolean mcan_set_stranger;
        public final CertificationInfo mcertification_info;
        public final Long mcontact_application_id;
        public final String mcontact_token;
        public final I18nVal mcross_meta_unit_description;
        public final List<Field> mcustom_tag_fields;
        public final Boolean menable_add_by_contact_token;
        public final FriendStatus mfriend_status;
        public final Gender mgender;
        public final String mgender_pronouns;
        public final Boolean mhide_add_connect_button;
        public final Boolean mis_blocked;
        public final Boolean mis_lh;
        public final Boolean mis_special_focus;
        public final Boolean mis_stranger;
        public final Boolean mis_tenant_certification;
        public final String mleader_id;
        public final MedalList mmedal_list;
        public final ShareInfo mshare_info;
        public final Boolean mshow_description;
        public final String mtenant_certification_url;
        public final I18nVal mtenant_name;
        public final TenantNameStatus mtenant_name_status;
        public final ImageSetPassThrough mtop_image;
        public final UserTag muser_tag;

        public static final class Builder extends Message.Builder<UserInfo, Builder> {
            public ApplyCommunication mapply_communication;
            public BlockStatus mblock_status;
            public Boolean mcan_block;
            public Boolean mcan_set_stranger;
            public CertificationInfo mcertification_info;
            public Long mcontact_application_id;
            public String mcontact_token;
            public I18nVal mcross_meta_unit_description;
            public List<Field> mcustom_tag_fields;
            public Boolean menable_add_by_contact_token;
            public FriendStatus mfriend_status;
            public Gender mgender;
            public String mgender_pronouns;
            public Boolean mhide_add_connect_button;
            public Boolean mis_blocked;
            public Boolean mis_lh;
            public Boolean mis_special_focus;
            public Boolean mis_stranger;
            public Boolean mis_tenant_certification;
            public String mleader_id;
            public MedalList mmedal_list;
            public ShareInfo mshare_info;
            public Boolean mshow_description;
            public String mtenant_certification_url;
            public I18nVal mtenant_name;
            public TenantNameStatus mtenant_name_status;
            public ImageSetPassThrough mtop_image;
            public UserTag muser_tag;

            @Override // com.squareup.wire.Message.Builder
            public UserInfo build() {
                FriendStatus r100 = this.mfriend_status;
                if (r100 == null) goto L7;
                return new UserInfo(this.mfriend_status, this.mgender, this.mtenant_name, this.mcontact_token, this.mcontact_application_id, this.menable_add_by_contact_token, this.mleader_id, this.mis_blocked, this.mblock_status, this.muser_tag, this.mis_tenant_certification, this.mtenant_certification_url, this.mcustom_tag_fields, this.mtop_image, this.mshare_info, this.mshow_description, this.mmedal_list, this.mis_special_focus, this.mgender_pronouns, this.mcross_meta_unit_description, this.mcertification_info, this.mtenant_name_status, this.mapply_communication, this.mcan_block, this.mhide_add_connect_button, this.mcan_set_stranger, this.mis_stranger, this.mis_lh, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mfriend_status"});
            }

            public Builder() {
                this.mcustom_tag_fields = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder apply_communication(ApplyCommunication r100) {
                this.mapply_communication = r100;
                return this;
            }

            public Builder block_status(BlockStatus r100) {
                this.mblock_status = r100;
                return this;
            }

            public Builder can_block(Boolean r100) {
                this.mcan_block = r100;
                return this;
            }

            public Builder can_set_stranger(Boolean r100) {
                this.mcan_set_stranger = r100;
                return this;
            }

            public Builder certification_info(CertificationInfo r100) {
                this.mcertification_info = r100;
                return this;
            }

            public Builder contact_application_id(Long r100) {
                this.mcontact_application_id = r100;
                return this;
            }

            public Builder contact_token(String r100) {
                this.mcontact_token = r100;
                return this;
            }

            public Builder cross_meta_unit_description(I18nVal r100) {
                this.mcross_meta_unit_description = r100;
                return this;
            }

            public Builder custom_tag_fields(List<Field> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcustom_tag_fields = r100;
                return this;
            }

            public Builder enable_add_by_contact_token(Boolean r100) {
                this.menable_add_by_contact_token = r100;
                return this;
            }

            public Builder friend_status(FriendStatus r100) {
                this.mfriend_status = r100;
                return this;
            }

            public Builder gender(Gender r100) {
                this.mgender = r100;
                return this;
            }

            public Builder gender_pronouns(String r100) {
                this.mgender_pronouns = r100;
                return this;
            }

            public Builder hide_add_connect_button(Boolean r100) {
                this.mhide_add_connect_button = r100;
                return this;
            }

            public Builder is_blocked(Boolean r100) {
                this.mis_blocked = r100;
                return this;
            }

            public Builder is_lh(Boolean r100) {
                this.mis_lh = r100;
                return this;
            }

            public Builder is_special_focus(Boolean r100) {
                this.mis_special_focus = r100;
                return this;
            }

            public Builder is_stranger(Boolean r100) {
                this.mis_stranger = r100;
                return this;
            }

            public Builder is_tenant_certification(Boolean r100) {
                this.mis_tenant_certification = r100;
                return this;
            }

            public Builder leader_id(String r100) {
                this.mleader_id = r100;
                return this;
            }

            public Builder medal_list(MedalList r100) {
                this.mmedal_list = r100;
                return this;
            }

            public Builder share_info(ShareInfo r100) {
                this.mshare_info = r100;
                return this;
            }

            public Builder show_description(Boolean r100) {
                this.mshow_description = r100;
                return this;
            }

            public Builder tenant_certification_url(String r100) {
                this.mtenant_certification_url = r100;
                return this;
            }

            public Builder tenant_name(I18nVal r100) {
                this.mtenant_name = r100;
                return this;
            }

            public Builder tenant_name_status(TenantNameStatus r100) {
                this.mtenant_name_status = r100;
                return this;
            }

            public Builder top_image(ImageSetPassThrough r100) {
                this.mtop_image = r100;
                return this;
            }

            public Builder user_tag(UserTag r100) {
                this.muser_tag = r100;
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
                r101.mcontact_token = "";
                r101.mcontact_application_id = 0L;
                Boolean r102 = Boolean.FALSE;
                r101.menable_add_by_contact_token = r102;
                r101.mleader_id = "";
                r101.mis_blocked = r102;
                r101.mis_tenant_certification = r102;
                r101.mtenant_certification_url = "";
                r101.mshow_description = r102;
                r101.mis_special_focus = r102;
                r101.mgender_pronouns = "";
                r101.mcan_block = r102;
                r101.mhide_add_connect_button = r102;
                r101.mcan_set_stranger = r102;
                r101.mis_stranger = r102;
                r101.mis_lh = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L50;
                switch(r104) {
                    case 1: goto L54;
                    case 2: goto L56;
                    case 3: goto L41;
                    case 4: goto L40;
                    case 5: goto L39;
                    case 6: goto L38;
                    case 7: goto L37;
                    case 8: goto L36;
                    case 9: goto L52;
                    case 10: goto L58;
                    case 11: goto L27;
                    case 12: goto L26;
                    case 13: goto L25;
                    case 14: goto L24;
                    case 15: goto L23;
                    case 16: goto L22;
                    case 17: goto L21;
                    case 18: goto L20;
                    case 19: goto L19;
                    case 20: goto L18;
                    case 21: goto L17;
                    case 22: goto L60;
                    case 23: goto L12;
                    case 24: goto L11;
                    case 25: goto L10;
                    case 26: goto L9;
                    case 27: goto L8;
                    case 28: goto L7;
                    default: goto L6;
                };
            L52:
                r101.mblock_status = BlockStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
            L34:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L54:
                r101.mfriend_status = FriendStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
            L48:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L56:
                r101.mgender = Gender.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L44
            L44:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L58:
                r101.muser_tag = UserTag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
            L30:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L60:
                r101.mtenant_name_status = TenantNameStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mis_lh = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.mis_stranger = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.mcan_set_stranger = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                r101.mhide_add_connect_button = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.mcan_block = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.mapply_communication = ApplyCommunication.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.mcertification_info = CertificationInfo.ADAPTER.decode(r100);
                goto L3
            L18:
                r101.mcross_meta_unit_description = I18nVal.ADAPTER.decode(r100);
                goto L3
            L19:
                r101.mgender_pronouns = ProtoAdapter.STRING.decode(r100);
                goto L3
            L20:
                r101.mis_special_focus = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L21:
                r101.mmedal_list = MedalList.ADAPTER.decode(r100);
                goto L3
            L22:
                r101.mshow_description = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L23:
                r101.mshare_info = ShareInfo.ADAPTER.decode(r100);
                goto L3
            L24:
                r101.mtop_image = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.mcustom_tag_fields.add(Field.ADAPTER.decode(r100));
                goto L3
            L26:
                r101.mtenant_certification_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L27:
                r101.mis_tenant_certification = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L36:
                r101.mis_blocked = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L37:
                r101.mleader_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L38:
                r101.menable_add_by_contact_token = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L39:
                r101.mcontact_application_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L40:
                r101.mcontact_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L41:
                r101.mtenant_name = I18nVal.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L50:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserInfo r100) {
                int r101 = FriendStatus.ADAPTER.encodedSizeWithTag(1, r100.mfriend_status);
                Gender r102 = r100.mgender;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = Gender.ADAPTER.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                I18nVal r106 = r100.mtenant_name;
                if (r106 == null) goto L9;
                int r107 = I18nVal.ADAPTER.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.mcontact_token;
                if (r109 == null) goto L13;
                int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
            L14:
                int r111 = r108 + r110;
                Long r112 = r100.mcontact_application_id;
                if (r112 == null) goto L17;
                int r113 = ProtoAdapter.INT64.encodedSizeWithTag(5, r112);
            L18:
                int r114 = r111 + r113;
                Boolean r115 = r100.menable_add_by_contact_token;
                if (r115 == null) goto L21;
                int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r115);
            L22:
                int r117 = r114 + r116;
                String r118 = r100.mleader_id;
                if (r118 == null) goto L25;
                int r119 = ProtoAdapter.STRING.encodedSizeWithTag(7, r118);
            L26:
                int r120 = r117 + r119;
                Boolean r121 = r100.mis_blocked;
                if (r121 == null) goto L29;
                int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r121);
            L30:
                int r123 = r120 + r122;
                BlockStatus r124 = r100.mblock_status;
                if (r124 == null) goto L33;
                int r125 = BlockStatus.ADAPTER.encodedSizeWithTag(9, r124);
            L34:
                int r126 = r123 + r125;
                UserTag r127 = r100.muser_tag;
                if (r127 == null) goto L37;
                int r128 = UserTag.ADAPTER.encodedSizeWithTag(10, r127);
            L38:
                int r129 = r126 + r128;
                Boolean r130 = r100.mis_tenant_certification;
                if (r130 == null) goto L41;
                int r131 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r130);
            L42:
                int r132 = r129 + r131;
                String r133 = r100.mtenant_certification_url;
                if (r133 == null) goto L45;
                int r134 = ProtoAdapter.STRING.encodedSizeWithTag(12, r133);
            L46:
                int r135 = (r132 + r134) + Field.ADAPTER.asRepeated().encodedSizeWithTag(13, r100.mcustom_tag_fields);
                ImageSetPassThrough r136 = r100.mtop_image;
                if (r136 == null) goto L49;
                int r137 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(14, r136);
            L50:
                int r138 = r135 + r137;
                ShareInfo r139 = r100.mshare_info;
                if (r139 == null) goto L53;
                int r140 = ShareInfo.ADAPTER.encodedSizeWithTag(15, r139);
            L54:
                int r141 = r138 + r140;
                Boolean r142 = r100.mshow_description;
                if (r142 == null) goto L57;
                int r143 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r142);
            L58:
                int r144 = r141 + r143;
                MedalList r145 = r100.mmedal_list;
                if (r145 == null) goto L61;
                int r146 = MedalList.ADAPTER.encodedSizeWithTag(17, r145);
            L62:
                int r147 = r144 + r146;
                Boolean r148 = r100.mis_special_focus;
                if (r148 == null) goto L65;
                int r149 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r148);
            L66:
                int r150 = r147 + r149;
                String r151 = r100.mgender_pronouns;
                if (r151 == null) goto L69;
                int r152 = ProtoAdapter.STRING.encodedSizeWithTag(19, r151);
            L70:
                int r153 = r150 + r152;
                I18nVal r154 = r100.mcross_meta_unit_description;
                if (r154 == null) goto L73;
                int r155 = I18nVal.ADAPTER.encodedSizeWithTag(20, r154);
            L74:
                int r156 = r153 + r155;
                CertificationInfo r157 = r100.mcertification_info;
                if (r157 == null) goto L77;
                int r158 = CertificationInfo.ADAPTER.encodedSizeWithTag(21, r157);
            L78:
                int r159 = r156 + r158;
                TenantNameStatus r160 = r100.mtenant_name_status;
                if (r160 == null) goto L81;
                int r161 = TenantNameStatus.ADAPTER.encodedSizeWithTag(22, r160);
            L82:
                int r162 = r159 + r161;
                ApplyCommunication r163 = r100.mapply_communication;
                if (r163 == null) goto L85;
                int r164 = ApplyCommunication.ADAPTER.encodedSizeWithTag(23, r163);
            L86:
                int r165 = r162 + r164;
                Boolean r166 = r100.mcan_block;
                if (r166 == null) goto L89;
                int r167 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r166);
            L90:
                int r168 = r165 + r167;
                Boolean r169 = r100.mhide_add_connect_button;
                if (r169 == null) goto L93;
                int r170 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r169);
            L94:
                int r171 = r168 + r170;
                Boolean r172 = r100.mcan_set_stranger;
                if (r172 == null) goto L97;
                int r173 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r172);
            L98:
                int r174 = r171 + r173;
                Boolean r175 = r100.mis_stranger;
                if (r175 == null) goto L101;
                int r176 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r175);
            L102:
                int r177 = r174 + r176;
                Boolean r178 = r100.mis_lh;
                if (r178 == null) goto L106;
                r103 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r178);
            L106:
                return (r177 + r103) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ UserInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserInfo r101) throws IOException {
                FriendStatus.ADAPTER.encodeWithTag(r100, 1, r101.mfriend_status);
                Gender r102 = r101.mgender;
                if (r102 == null) goto L5;
                Gender.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                I18nVal r103 = r101.mtenant_name;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.mcontact_token;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                Long r105 = r101.mcontact_application_id;
                if (r105 == null) goto L14;
                ProtoAdapter.INT64.encodeWithTag(r100, 5, r105);
            L14:
                Boolean r106 = r101.menable_add_by_contact_token;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
            L17:
                String r107 = r101.mleader_id;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
            L20:
                Boolean r108 = r101.mis_blocked;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
            L23:
                BlockStatus r109 = r101.mblock_status;
                if (r109 == null) goto L26;
                BlockStatus.ADAPTER.encodeWithTag(r100, 9, r109);
            L26:
                UserTag r110 = r101.muser_tag;
                if (r110 == null) goto L29;
                UserTag.ADAPTER.encodeWithTag(r100, 10, r110);
            L29:
                Boolean r111 = r101.mis_tenant_certification;
                if (r111 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
            L32:
                String r112 = r101.mtenant_certification_url;
                if (r112 == null) goto L35;
                ProtoAdapter.STRING.encodeWithTag(r100, 12, r112);
            L35:
                Field.ADAPTER.asRepeated().encodeWithTag(r100, 13, r101.mcustom_tag_fields);
                ImageSetPassThrough r113 = r101.mtop_image;
                if (r113 == null) goto L38;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 14, r113);
            L38:
                ShareInfo r114 = r101.mshare_info;
                if (r114 == null) goto L41;
                ShareInfo.ADAPTER.encodeWithTag(r100, 15, r114);
            L41:
                Boolean r115 = r101.mshow_description;
                if (r115 == null) goto L44;
                ProtoAdapter.BOOL.encodeWithTag(r100, 16, r115);
            L44:
                MedalList r116 = r101.mmedal_list;
                if (r116 == null) goto L47;
                MedalList.ADAPTER.encodeWithTag(r100, 17, r116);
            L47:
                Boolean r117 = r101.mis_special_focus;
                if (r117 == null) goto L50;
                ProtoAdapter.BOOL.encodeWithTag(r100, 18, r117);
            L50:
                String r118 = r101.mgender_pronouns;
                if (r118 == null) goto L53;
                ProtoAdapter.STRING.encodeWithTag(r100, 19, r118);
            L53:
                I18nVal r119 = r101.mcross_meta_unit_description;
                if (r119 == null) goto L56;
                I18nVal.ADAPTER.encodeWithTag(r100, 20, r119);
            L56:
                CertificationInfo r120 = r101.mcertification_info;
                if (r120 == null) goto L59;
                CertificationInfo.ADAPTER.encodeWithTag(r100, 21, r120);
            L59:
                TenantNameStatus r121 = r101.mtenant_name_status;
                if (r121 == null) goto L62;
                TenantNameStatus.ADAPTER.encodeWithTag(r100, 22, r121);
            L62:
                ApplyCommunication r122 = r101.mapply_communication;
                if (r122 == null) goto L65;
                ApplyCommunication.ADAPTER.encodeWithTag(r100, 23, r122);
            L65:
                Boolean r123 = r101.mcan_block;
                if (r123 == null) goto L68;
                ProtoAdapter.BOOL.encodeWithTag(r100, 24, r123);
            L68:
                Boolean r124 = r101.mhide_add_connect_button;
                if (r124 == null) goto L71;
                ProtoAdapter.BOOL.encodeWithTag(r100, 25, r124);
            L71:
                Boolean r125 = r101.mcan_set_stranger;
                if (r125 == null) goto L74;
                ProtoAdapter.BOOL.encodeWithTag(r100, 26, r125);
            L74:
                Boolean r126 = r101.mis_stranger;
                if (r126 == null) goto L77;
                ProtoAdapter.BOOL.encodeWithTag(r100, 27, r126);
            L77:
                Boolean r127 = r101.mis_lh;
                if (r127 == null) goto L80;
                ProtoAdapter.BOOL.encodeWithTag(r100, 28, r127);
            L80:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserInfo();
            FIELD_OPTIONS_MLEADER_ID = new FieldOptions.Builder().id("user_id").build();
            DEFAULT_CONTACT_APPLICATION_ID = 0L;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ENABLE_ADD_BY_CONTACT_TOKEN = r100;
            DEFAULT_IS_BLOCKED = r100;
            DEFAULT_IS_TENANT_CERTIFICATION = r100;
            DEFAULT_SHOW_DESCRIPTION = r100;
            DEFAULT_IS_SPECIAL_FOCUS = r100;
            DEFAULT_CAN_BLOCK = r100;
            DEFAULT_HIDE_ADD_CONNECT_BUTTON = r100;
            DEFAULT_CAN_SET_STRANGER = r100;
            DEFAULT_IS_STRANGER = r100;
            DEFAULT_IS_LH = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfriend_status = this.mfriend_status;
            r100.mgender = this.mgender;
            r100.mtenant_name = this.mtenant_name;
            r100.mcontact_token = this.mcontact_token;
            r100.mcontact_application_id = this.mcontact_application_id;
            r100.menable_add_by_contact_token = this.menable_add_by_contact_token;
            r100.mleader_id = this.mleader_id;
            r100.mis_blocked = this.mis_blocked;
            r100.mblock_status = this.mblock_status;
            r100.muser_tag = this.muser_tag;
            r100.mis_tenant_certification = this.mis_tenant_certification;
            r100.mtenant_certification_url = this.mtenant_certification_url;
            r100.mcustom_tag_fields = Internal.copyOf("mcustom_tag_fields", this.mcustom_tag_fields);
            r100.mtop_image = this.mtop_image;
            r100.mshare_info = this.mshare_info;
            r100.mshow_description = this.mshow_description;
            r100.mmedal_list = this.mmedal_list;
            r100.mis_special_focus = this.mis_special_focus;
            r100.mgender_pronouns = this.mgender_pronouns;
            r100.mcross_meta_unit_description = this.mcross_meta_unit_description;
            r100.mcertification_info = this.mcertification_info;
            r100.mtenant_name_status = this.mtenant_name_status;
            r100.mapply_communication = this.mapply_communication;
            r100.mcan_block = this.mcan_block;
            r100.mhide_add_connect_button = this.mhide_add_connect_button;
            r100.mcan_set_stranger = this.mcan_set_stranger;
            r100.mis_stranger = this.mis_stranger;
            r100.mis_lh = this.mis_lh;
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

        public UserInfo(FriendStatus r310, Gender r311, I18nVal r312, String r313, Long r314, Boolean r315, String r316, Boolean r317, BlockStatus r318, UserTag r410, Boolean r411, String r412, List<Field> r413, ImageSetPassThrough r414, ShareInfo r415, Boolean r416, MedalList r417, Boolean r418, String r419, I18nVal r510, CertificationInfo r511, TenantNameStatus r512, ApplyCommunication r513, Boolean r514, Boolean r515, Boolean r516, Boolean r517, Boolean r518) {
            this(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, ByteString.EMPTY);
        }

        public UserInfo(FriendStatus r100, Gender r101, I18nVal r102, String r103, Long r104, Boolean r105, String r110, Boolean r111, BlockStatus r112, UserTag r113, Boolean r114, String r115, List<Field> r116, ImageSetPassThrough r117, ShareInfo r118, Boolean r119, MedalList r210, Boolean r211, String r212, I18nVal r213, CertificationInfo r214, TenantNameStatus r215, ApplyCommunication r216, Boolean r217, Boolean r218, Boolean r219, Boolean r310, Boolean r311, ByteString r312) {
            super(ADAPTER, r312);
            this.mfriend_status = r100;
            this.mgender = r101;
            this.mtenant_name = r102;
            this.mcontact_token = r103;
            this.mcontact_application_id = r104;
            this.menable_add_by_contact_token = r105;
            this.mleader_id = r110;
            this.mis_blocked = r111;
            this.mblock_status = r112;
            this.muser_tag = r113;
            this.mis_tenant_certification = r114;
            this.mtenant_certification_url = r115;
            this.mcustom_tag_fields = Internal.immutableCopyOf("mcustom_tag_fields", r116);
            this.mtop_image = r117;
            this.mshare_info = r118;
            this.mshow_description = r119;
            this.mmedal_list = r210;
            this.mis_special_focus = r211;
            this.mgender_pronouns = r212;
            this.mcross_meta_unit_description = r213;
            this.mcertification_info = r214;
            this.mtenant_name_status = r215;
            this.mapply_communication = r216;
            this.mcan_block = r217;
            this.mhide_add_connect_button = r218;
            this.mcan_set_stranger = r219;
            this.mis_stranger = r310;
            this.mis_lh = r311;
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
        ADAPTER = new ProtoAdapter_Profile();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_info = this.muser_info;
        r100.mctas = Internal.copyOf("mctas", this.mctas);
        r100.mfields = Internal.copyOf("mfields", this.mfields);
        r100.mtabs = Internal.copyOf("mtabs", this.mtabs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Profile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Profile(UserInfo r100, List<CTA> r101, List<Field> r102, List<TabInfo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public Profile(UserInfo r100, List<CTA> r101, List<Field> r102, List<TabInfo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.muser_info = r100;
        this.mctas = Internal.immutableCopyOf("mctas", r101);
        this.mfields = Internal.immutableCopyOf("mfields", r102);
        this.mtabs = Internal.immutableCopyOf("mtabs", r103);
    }
}
