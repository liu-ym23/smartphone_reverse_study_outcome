package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
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
public final class Chatter extends com.squareup.wire.Message<Chatter, Builder> {
    public static final ProtoAdapter<Chatter> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_ACCOUNT_ID = "";
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_ANOTHER_NAME = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final String DEFAULT_CHAT_CHATTER_LIST_DEPARTMENT_NAME = "";
    public static final String DEFAULT_CREATOR_ID = "";
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_EN_US_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final Boolean DEFAULT_IS_ANONYMOUS = null;
    public static final Boolean DEFAULT_IS_DEFAULT_AVATAR = null;
    public static final Boolean DEFAULT_IS_FROZEN = null;
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final Boolean DEFAULT_IS_RESIGNED = null;
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final Boolean DEFAULT_IS_TENANT_CERTIFICATION = null;
    public static final String DEFAULT_LOCALIZED_NAME = "";
    public static final String DEFAULT_MAJOR_LANGUAGE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_NAME_WITH_ANOTHER_NAME = "";
    public static final String DEFAULT_OPEN_APP_ID = "";
    public static final String DEFAULT_PRIVATE_DESCRIPTION = "";
    public static final Long DEFAULT_PRIVATE_DESCRIPTION_ID = null;
    public static final Boolean DEFAULT_PROFILE_ENABLED = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final TenantNameStatus DEFAULT_TENANT_NAME_STATUS = null;
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Boolean accept_sms_phone_urgent;
    public final AccessInfo access_info;
    public final String account_id;
    public final String alias;
    public final String another_name;
    public final ImageSet avatar;
    public final String avatar_key;
    public final AvatarMedal avatar_medal;
    public final String avatar_path;
    public final List<String> avatar_urls;
    public final Integer bot_ext_type;
    public final Boolean can_join_group;
    public final String chat_chatter_list_department_name;
    public final ChatExtra chat_extra;
    public final List<String> common_locales;
    public final String creator_id;
    public final Description description;
    public final Long do_not_disturb_end_time;
    public final String email;
    public final String en_us_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253459id;
    public final Boolean in_contacts;
    public final Boolean is_agent;
    public final Boolean is_anonymous;
    public final Boolean is_default_avatar;
    public final Boolean is_frozen;
    public final Boolean is_registered;
    public final Boolean is_resigned;
    public final Boolean is_special_focus;
    public final Boolean is_tenant_certification;
    public final String localized_name;
    public final String major_language;
    public final BotMutedInfo muted_info;
    public final String name;
    public final String name_pinyin;
    public final String name_with_another_name;
    public final String open_app_id;
    public final String private_description;
    public final Long private_description_id;
    public final Boolean profile_enabled;
    public final List<ChatterCustomStatus> status;
    public final TagData tag_info;
    public final List<Tag> tags;
    public final String tenant_id;
    public final TenantNameStatus tenant_name_status;
    public final TimeZone time_zone;
    public final Type type;
    public final Long update_time;
    public final String with_bot_tag;
    public final WorkStatus work_status;

    public static final class AccessInfo extends com.squareup.wire.Message<AccessInfo, Builder> {
        public static final ProtoAdapter<AccessInfo> ADAPTER = null;
        public static final Boolean DEFAULT_PHONE_CALL = null;
        public static final Boolean DEFAULT_VIDEO_CALL = null;
        public static final Boolean DEFAULT_VOICE_CALL = null;
        private static final long serialVersionUID = 0;
        public final AccessProfile access_profile;
        public final Boolean phone_call;
        public final Boolean video_call;
        public final Boolean voice_call;

        public static final class AccessProfile extends com.squareup.wire.Message<AccessProfile, Builder> {
            public static final ProtoAdapter<AccessProfile> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final AccessMessage access_message_phone_call;
            public final AccessMessage access_message_urgent;
            public final AccessMessage access_message_video_call;
            public final AccessMessage access_message_voice_call;

            public static final class AccessMessage extends com.squareup.wire.Message<AccessMessage, Builder> {
                public static final ProtoAdapter<AccessMessage> ADAPTER = null;
                public static final InaccessibleCode DEFAULT_INACCESSIBLE_CODE = null;
                public static final Boolean DEFAULT_IS_ACCESSIBLE = null;
                private static final long serialVersionUID = 0;
                public final InaccessibleCode inaccessible_code;
                public final Boolean is_accessible;

                public static final class Builder extends com.squareup.wire.Message.Builder<AccessMessage, Builder> {
                    public InaccessibleCode inaccessible_code;
                    public Boolean is_accessible;

                    @Override // com.squareup.wire.Message.Builder
                    public AccessMessage build() {
                        return new AccessMessage(this.is_accessible, this.inaccessible_code, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }

                    public Builder inaccessible_code(InaccessibleCode r100) {
                        this.inaccessible_code = r100;
                        return this;
                    }

                    public Builder is_accessible(Boolean r100) {
                        this.is_accessible = r100;
                        return this;
                    }
                }

                public static final enum InaccessibleCode extends Enum<InaccessibleCode> implements WireEnum {
                    private static final /* synthetic */ InaccessibleCode[] $VALUES = null;
                    public static final ProtoAdapter<InaccessibleCode> ADAPTER = null;
                    public static final InaccessibleCode DEFAULT = null;
                    public static final InaccessibleCode EXECUTIVES = null;
                    private final int value;

                    static {
                        InaccessibleCode r100 = new InaccessibleCode("DEFAULT", 0, 0);
                        DEFAULT = r100;
                        InaccessibleCode r101 = new InaccessibleCode("EXECUTIVES", 1, 1);
                        EXECUTIVES = r101;
                        $VALUES = new InaccessibleCode[]{r100, r101};
                        ADAPTER = ProtoAdapter.newEnumAdapter(InaccessibleCode.class);
                    }

                    public static InaccessibleCode[] values() {
                        return (InaccessibleCode[]) $VALUES.clone();
                    }

                    @Override // com.squareup.wire.WireEnum
                    public final int getValue() {
                        return this.value;
                    }

                    public static InaccessibleCode fromValue(int r100) {
                        if (r100 == 0) goto L10;
                        if (r100 == 1) goto L8;
                        return null;
                    L8:
                        return EXECUTIVES;
                    L10:
                        return DEFAULT;
                    }

                    public static InaccessibleCode valueOf(String r100) {
                        return (InaccessibleCode) a.a(InaccessibleCode.class, r100);
                    }

                    private InaccessibleCode(String r100, int r101, int r102) {
                        super(r100, r101);
                        this.value = r102;
                    }
                }

                public static final class ProtoAdapter_AccessMessage extends ProtoAdapter<AccessMessage> {
                    public ProtoAdapter_AccessMessage() {
                        super(FieldEncoding.LENGTH_DELIMITED, AccessMessage.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public AccessMessage decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.is_accessible = Boolean.TRUE;
                        r101.inaccessible_code = InaccessibleCode.DEFAULT;
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L15;
                        if (r103 != 1) goto L8;
                        r101.is_accessible = ProtoAdapter.BOOL.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.inaccessible_code = InaccessibleCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
                    public int encodedSize2(AccessMessage r100) {
                        Boolean r101 = r100.is_accessible;
                        int r102 = 0;
                        if (r101 == null) goto L5;
                        int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
                    L6:
                        InaccessibleCode r104 = r100.inaccessible_code;
                        if (r104 == null) goto L10;
                        r102 = InaccessibleCode.ADAPTER.encodedSizeWithTag(2, r104);
                    L10:
                        return (r103 + r102) + r100.unknownFields().size();
                    L5:
                        r103 = 0;
                        goto L6
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ AccessMessage decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(AccessMessage r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, AccessMessage r101) throws IOException {
                        Boolean r102 = r101.is_accessible;
                        if (r102 == null) goto L5;
                        ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
                    L5:
                        InaccessibleCode r103 = r101.inaccessible_code;
                        if (r103 == null) goto L8;
                        InaccessibleCode.ADAPTER.encodeWithTag(r100, 2, r103);
                    L8:
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AccessMessage r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_AccessMessage();
                    DEFAULT_IS_ACCESSIBLE = Boolean.TRUE;
                    DEFAULT_INACCESSIBLE_CODE = InaccessibleCode.DEFAULT;
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.is_accessible = this.is_accessible;
                    r100.inaccessible_code = this.inaccessible_code;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return AccessMessage.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public AccessMessage(Boolean r100, InaccessibleCode r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public AccessMessage(Boolean r100, InaccessibleCode r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.is_accessible = r100;
                    this.inaccessible_code = r101;
                }
            }

            public static final class Builder extends com.squareup.wire.Message.Builder<AccessProfile, Builder> {
                public AccessMessage access_message_phone_call;
                public AccessMessage access_message_urgent;
                public AccessMessage access_message_video_call;
                public AccessMessage access_message_voice_call;

                @Override // com.squareup.wire.Message.Builder
                public AccessProfile build() {
                    return new AccessProfile(this.access_message_phone_call, this.access_message_voice_call, this.access_message_video_call, this.access_message_urgent, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder access_message_phone_call(AccessMessage r100) {
                    this.access_message_phone_call = r100;
                    return this;
                }

                public Builder access_message_urgent(AccessMessage r100) {
                    this.access_message_urgent = r100;
                    return this;
                }

                public Builder access_message_video_call(AccessMessage r100) {
                    this.access_message_video_call = r100;
                    return this;
                }

                public Builder access_message_voice_call(AccessMessage r100) {
                    this.access_message_voice_call = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_AccessProfile extends ProtoAdapter<AccessProfile> {
                public ProtoAdapter_AccessProfile() {
                    super(FieldEncoding.LENGTH_DELIMITED, AccessProfile.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public AccessProfile decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.access_message_phone_call = AccessMessage.ADAPTER.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.access_message_voice_call = AccessMessage.ADAPTER.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.access_message_video_call = AccessMessage.ADAPTER.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.access_message_urgent = AccessMessage.ADAPTER.decode(r100);
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
                public int encodedSize2(AccessProfile r100) {
                    AccessMessage r101 = r100.access_message_phone_call;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = AccessMessage.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    AccessMessage r104 = r100.access_message_voice_call;
                    if (r104 == null) goto L9;
                    int r105 = AccessMessage.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    AccessMessage r107 = r100.access_message_video_call;
                    if (r107 == null) goto L13;
                    int r108 = AccessMessage.ADAPTER.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    AccessMessage r110 = r100.access_message_urgent;
                    if (r110 == null) goto L18;
                    r102 = AccessMessage.ADAPTER.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ AccessProfile decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(AccessProfile r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, AccessProfile r101) throws IOException {
                    AccessMessage r102 = r101.access_message_phone_call;
                    if (r102 == null) goto L5;
                    AccessMessage.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    AccessMessage r103 = r101.access_message_voice_call;
                    if (r103 == null) goto L8;
                    AccessMessage.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    AccessMessage r104 = r101.access_message_video_call;
                    if (r104 == null) goto L11;
                    AccessMessage.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    AccessMessage r105 = r101.access_message_urgent;
                    if (r105 == null) goto L14;
                    AccessMessage.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AccessProfile r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_AccessProfile();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.access_message_phone_call = this.access_message_phone_call;
                r100.access_message_voice_call = this.access_message_voice_call;
                r100.access_message_video_call = this.access_message_video_call;
                r100.access_message_urgent = this.access_message_urgent;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return AccessProfile.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public AccessProfile(AccessMessage r100, AccessMessage r101, AccessMessage r102, AccessMessage r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public AccessProfile(AccessMessage r100, AccessMessage r101, AccessMessage r102, AccessMessage r103, ByteString r104) {
                super(ADAPTER, r104);
                this.access_message_phone_call = r100;
                this.access_message_voice_call = r101;
                this.access_message_video_call = r102;
                this.access_message_urgent = r103;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<AccessInfo, Builder> {
            public AccessProfile access_profile;
            public Boolean phone_call;
            public Boolean video_call;
            public Boolean voice_call;

            @Override // com.squareup.wire.Message.Builder
            public AccessInfo build() {
                return new AccessInfo(this.phone_call, this.voice_call, this.video_call, this.access_profile, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder access_profile(AccessProfile r100) {
                this.access_profile = r100;
                return this;
            }

            public Builder phone_call(Boolean r100) {
                this.phone_call = r100;
                return this;
            }

            public Builder video_call(Boolean r100) {
                this.video_call = r100;
                return this;
            }

            public Builder voice_call(Boolean r100) {
                this.voice_call = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AccessInfo extends ProtoAdapter<AccessInfo> {
            public ProtoAdapter_AccessInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AccessInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AccessInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.TRUE;
                r101.phone_call = r102;
                r101.voice_call = r102;
                r101.video_call = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.phone_call = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.voice_call = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.video_call = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.access_profile = AccessProfile.ADAPTER.decode(r100);
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
            public int encodedSize2(AccessInfo r100) {
                Boolean r101 = r100.phone_call;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.voice_call;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.video_call;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                AccessProfile r110 = r100.access_profile;
                if (r110 == null) goto L18;
                r102 = AccessProfile.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ AccessInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AccessInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AccessInfo r101) throws IOException {
                Boolean r102 = r101.phone_call;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.voice_call;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.video_call;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                AccessProfile r105 = r101.access_profile;
                if (r105 == null) goto L14;
                AccessProfile.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AccessInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AccessInfo();
            Boolean r100 = Boolean.TRUE;
            DEFAULT_PHONE_CALL = r100;
            DEFAULT_VOICE_CALL = r100;
            DEFAULT_VIDEO_CALL = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.phone_call = this.phone_call;
            r100.voice_call = this.voice_call;
            r100.video_call = this.video_call;
            r100.access_profile = this.access_profile;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AccessInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AccessInfo(Boolean r100, Boolean r101, Boolean r102, AccessProfile r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public AccessInfo(Boolean r100, Boolean r101, Boolean r102, AccessProfile r103, ByteString r104) {
            super(ADAPTER, r104);
            this.phone_call = r100;
            this.voice_call = r101;
            this.video_call = r102;
            this.access_profile = r103;
        }
    }

    public static final class BotMutedInfo extends com.squareup.wire.Message<BotMutedInfo, Builder> {
        public static final ProtoAdapter<BotMutedInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, Boolean> muted_scenes;

        public static final class Builder extends com.squareup.wire.Message.Builder<BotMutedInfo, Builder> {
            public Map<String, Boolean> muted_scenes;

            @Override // com.squareup.wire.Message.Builder
            public BotMutedInfo build() {
                return new BotMutedInfo(this.muted_scenes, super.buildUnknownFields());
            }

            public Builder() {
                this.muted_scenes = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder muted_scenes(Map<String, Boolean> r100) {
                Internal.checkElementsNotNull(r100);
                this.muted_scenes = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BotMutedInfo extends ProtoAdapter<BotMutedInfo> {
            private final ProtoAdapter<Map<String, Boolean>> muted_scenes;

            public ProtoAdapter_BotMutedInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, BotMutedInfo.class);
                this.muted_scenes = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BotMutedInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.muted_scenes.putAll(this.muted_scenes.decode(r100));
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
            public int encodedSize2(BotMutedInfo r100) {
                return this.muted_scenes.encodedSizeWithTag(1, r100.muted_scenes) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BotMutedInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BotMutedInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BotMutedInfo r101) throws IOException {
                this.muted_scenes.encodeWithTag(r100, 1, r101.muted_scenes);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotMutedInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BotMutedInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muted_scenes = Internal.copyOf("muted_scenes", this.muted_scenes);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BotMutedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BotMutedInfo(Map<String, Boolean> r100) {
            this(r100, ByteString.EMPTY);
        }

        public BotMutedInfo(Map<String, Boolean> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muted_scenes = Internal.immutableCopyOf("muted_scenes", r100);
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Chatter, Builder> {
        public Boolean accept_sms_phone_urgent;
        public AccessInfo access_info;
        public String account_id;
        public String alias;
        public String another_name;
        public ImageSet avatar;
        public String avatar_key;
        public AvatarMedal avatar_medal;
        public String avatar_path;
        public List<String> avatar_urls;
        public Integer bot_ext_type;
        public Boolean can_join_group;
        public String chat_chatter_list_department_name;
        public ChatExtra chat_extra;
        public List<String> common_locales;
        public String creator_id;
        public Description description;
        public Long do_not_disturb_end_time;
        public String email;
        public String en_us_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253460id;
        public Boolean in_contacts;
        public Boolean is_agent;
        public Boolean is_anonymous;
        public Boolean is_default_avatar;
        public Boolean is_frozen;
        public Boolean is_registered;
        public Boolean is_resigned;
        public Boolean is_special_focus;
        public Boolean is_tenant_certification;
        public String localized_name;
        public String major_language;
        public BotMutedInfo muted_info;
        public String name;
        public String name_pinyin;
        public String name_with_another_name;
        public String open_app_id;
        public String private_description;
        public Long private_description_id;
        public Boolean profile_enabled;
        public List<ChatterCustomStatus> status;
        public TagData tag_info;
        public List<Tag> tags;
        public String tenant_id;
        public TenantNameStatus tenant_name_status;
        public TimeZone time_zone;
        public Type type;
        public Long update_time;
        public String with_bot_tag;
        public WorkStatus work_status;

        @Override // com.squareup.wire.Message.Builder
        public Chatter build() {
            String r100 = this.f253460id;
            if (r100 == null) goto L15;
            if (this.name == null) goto L15;
            if (this.type == null) goto L15;
            if (this.update_time == null) goto L15;
            if (this.name_pinyin == null) goto L15;
            return new Chatter(this.f253460id, this.name, this.type, this.avatar, this.update_time, this.name_pinyin, this.creator_id, this.is_resigned, this.is_registered, this.en_us_name, this.description, this.avatar_key, this.tenant_id, this.localized_name, this.alias, this.work_status, this.profile_enabled, this.account_id, this.access_info, this.open_app_id, this.avatar_path, this.email, this.do_not_disturb_end_time, this.avatar_urls, this.time_zone, this.is_frozen, this.is_anonymous, this.avatar_medal, this.name_with_another_name, this.another_name, this.is_default_avatar, this.is_special_focus, this.major_language, this.tag_info, this.private_description, this.private_description_id, this.is_tenant_certification, this.tenant_name_status, this.common_locales, this.with_bot_tag, this.in_contacts, this.can_join_group, this.muted_info, this.chat_chatter_list_department_name, this.bot_ext_type, this.is_agent, this.status, this.chat_extra, this.accept_sms_phone_urgent, this.tags, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.name, "name", this.type, "type", this.update_time, "update_time", this.name_pinyin, "name_pinyin"});
        }

        public Builder() {
            this.avatar_urls = Internal.newMutableList();
            this.common_locales = Internal.newMutableList();
            this.status = Internal.newMutableList();
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder accept_sms_phone_urgent(Boolean r100) {
            this.accept_sms_phone_urgent = r100;
            return this;
        }

        public Builder access_info(AccessInfo r100) {
            this.access_info = r100;
            return this;
        }

        public Builder account_id(String r100) {
            this.account_id = r100;
            return this;
        }

        public Builder alias(String r100) {
            this.alias = r100;
            return this;
        }

        public Builder another_name(String r100) {
            this.another_name = r100;
            return this;
        }

        public Builder avatar(ImageSet r100) {
            this.avatar = r100;
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

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder avatar_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.avatar_urls = r100;
            return this;
        }

        public Builder bot_ext_type(Integer r100) {
            this.bot_ext_type = r100;
            return this;
        }

        public Builder can_join_group(Boolean r100) {
            this.can_join_group = r100;
            return this;
        }

        public Builder chat_chatter_list_department_name(String r100) {
            this.chat_chatter_list_department_name = r100;
            return this;
        }

        public Builder chat_extra(ChatExtra r100) {
            this.chat_extra = r100;
            return this;
        }

        public Builder common_locales(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.common_locales = r100;
            return this;
        }

        public Builder creator_id(String r100) {
            this.creator_id = r100;
            return this;
        }

        public Builder description(Description r100) {
            this.description = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.do_not_disturb_end_time = r100;
            return this;
        }

        public Builder email(String r100) {
            this.email = r100;
            return this;
        }

        public Builder en_us_name(String r100) {
            this.en_us_name = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253460id = r100;
            return this;
        }

        public Builder in_contacts(Boolean r100) {
            this.in_contacts = r100;
            return this;
        }

        public Builder is_agent(Boolean r100) {
            this.is_agent = r100;
            return this;
        }

        public Builder is_anonymous(Boolean r100) {
            this.is_anonymous = r100;
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

        public Builder is_tenant_certification(Boolean r100) {
            this.is_tenant_certification = r100;
            return this;
        }

        public Builder localized_name(String r100) {
            this.localized_name = r100;
            return this;
        }

        public Builder major_language(String r100) {
            this.major_language = r100;
            return this;
        }

        public Builder muted_info(BotMutedInfo r100) {
            this.muted_info = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder name_pinyin(String r100) {
            this.name_pinyin = r100;
            return this;
        }

        public Builder name_with_another_name(String r100) {
            this.name_with_another_name = r100;
            return this;
        }

        public Builder open_app_id(String r100) {
            this.open_app_id = r100;
            return this;
        }

        public Builder private_description(String r100) {
            this.private_description = r100;
            return this;
        }

        public Builder private_description_id(Long r100) {
            this.private_description_id = r100;
            return this;
        }

        public Builder profile_enabled(Boolean r100) {
            this.profile_enabled = r100;
            return this;
        }

        public Builder status(List<ChatterCustomStatus> r100) {
            Internal.checkElementsNotNull(r100);
            this.status = r100;
            return this;
        }

        public Builder tag_info(TagData r100) {
            this.tag_info = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder tenant_name_status(TenantNameStatus r100) {
            this.tenant_name_status = r100;
            return this;
        }

        public Builder time_zone(TimeZone r100) {
            this.time_zone = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder with_bot_tag(String r100) {
            this.with_bot_tag = r100;
            return this;
        }

        public Builder work_status(WorkStatus r100) {
            this.work_status = r100;
            return this;
        }
    }

    public static final class ChatExtra extends com.squareup.wire.Message<ChatExtra, Builder> {
        public static final ProtoAdapter<ChatExtra> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final String DEFAULT_NICK_NAME = "";
        public static final String DEFAULT_NICK_NAME_PINYIN = "";
        public static final OncallRole DEFAULT_ONCALL_ROLE = null;
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final String nick_name;
        public final String nick_name_pinyin;
        public final OncallRole oncall_role;
        public final ChatChatterTagInfo tag_infos;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatExtra, Builder> {
            public String chat_id;
            public String nick_name;
            public String nick_name_pinyin;
            public OncallRole oncall_role;
            public ChatChatterTagInfo tag_infos;

            @Override // com.squareup.wire.Message.Builder
            public ChatExtra build() {
                String r100 = this.chat_id;
                if (r100 == null) goto L7;
                return new ChatExtra(this.chat_id, this.nick_name, this.oncall_role, this.nick_name_pinyin, this.tag_infos, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder nick_name(String r100) {
                this.nick_name = r100;
                return this;
            }

            public Builder nick_name_pinyin(String r100) {
                this.nick_name_pinyin = r100;
                return this;
            }

            public Builder oncall_role(OncallRole r100) {
                this.oncall_role = r100;
                return this;
            }

            public Builder tag_infos(ChatChatterTagInfo r100) {
                this.tag_infos = r100;
                return this;
            }
        }

        public static final class ChatChatterTagInfo extends com.squareup.wire.Message<ChatChatterTagInfo, Builder> {
            public static final ProtoAdapter<ChatChatterTagInfo> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<TagInfo> tags;

            public static final class Builder extends com.squareup.wire.Message.Builder<ChatChatterTagInfo, Builder> {
                public List<TagInfo> tags;

                @Override // com.squareup.wire.Message.Builder
                public ChatChatterTagInfo build() {
                    return new ChatChatterTagInfo(this.tags, super.buildUnknownFields());
                }

                public Builder() {
                    this.tags = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder tags(List<TagInfo> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.tags = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ChatChatterTagInfo extends ProtoAdapter<ChatChatterTagInfo> {
                public ProtoAdapter_ChatChatterTagInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, ChatChatterTagInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ChatChatterTagInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.tags.add(TagInfo.ADAPTER.decode(r100));
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
                public int encodedSize2(ChatChatterTagInfo r100) {
                    return TagInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tags) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ChatChatterTagInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ChatChatterTagInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ChatChatterTagInfo r101) throws IOException {
                    TagInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tags);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatChatterTagInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            public static final class TagInfo extends com.squareup.wire.Message<TagInfo, Builder> {
                public static final ProtoAdapter<TagInfo> ADAPTER = null;
                public static final String DEFAULT_DESCRIPTION = "";
                public static final TagType DEFAULT_TAG_TYPE = null;
                private static final long serialVersionUID = 0;
                public final String description;
                public final TagType tag_type;

                public static final class Builder extends com.squareup.wire.Message.Builder<TagInfo, Builder> {
                    public String description;
                    public TagType tag_type;

                    @Override // com.squareup.wire.Message.Builder
                    public TagInfo build() {
                        return new TagInfo(this.tag_type, this.description, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }

                    public Builder description(String r100) {
                        this.description = r100;
                        return this;
                    }

                    public Builder tag_type(TagType r100) {
                        this.tag_type = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_TagInfo extends ProtoAdapter<TagInfo> {
                    public ProtoAdapter_TagInfo() {
                        super(FieldEncoding.LENGTH_DELIMITED, TagInfo.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public TagInfo decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.tag_type = TagType.UNKNOWN;
                        r101.description = "";
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L15;
                        if (r103 != 1) goto L8;
                        r101.tag_type = TagType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                    L13:
                        e = move-exception;
                        r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.description = ProtoAdapter.STRING.decode(r100);
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
                    public int encodedSize2(TagInfo r100) {
                        TagType r101 = r100.tag_type;
                        int r102 = 0;
                        if (r101 == null) goto L5;
                        int r103 = TagType.ADAPTER.encodedSizeWithTag(1, r101);
                    L6:
                        String r104 = r100.description;
                        if (r104 == null) goto L10;
                        r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                    L10:
                        return (r103 + r102) + r100.unknownFields().size();
                    L5:
                        r103 = 0;
                        goto L6
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ TagInfo decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(TagInfo r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, TagInfo r101) throws IOException {
                        TagType r102 = r101.tag_type;
                        if (r102 == null) goto L5;
                        TagType.ADAPTER.encodeWithTag(r100, 1, r102);
                    L5:
                        String r103 = r101.description;
                        if (r103 == null) goto L8;
                        ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                    L8:
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagInfo r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                public static final enum TagType extends Enum<TagType> implements WireEnum {
                    private static final /* synthetic */ TagType[] $VALUES = null;
                    public static final ProtoAdapter<TagType> ADAPTER = null;
                    public static final TagType ADMIN_USER = null;
                    public static final TagType CLASS_TEACHER = null;
                    public static final TagType DISCIPLINE_TEACHER = null;
                    public static final TagType UNKNOWN = null;
                    private final int value;

                    static {
                        TagType r100 = new TagType("UNKNOWN", 0, 0);
                        UNKNOWN = r100;
                        TagType r101 = new TagType("CLASS_TEACHER", 1, 1);
                        CLASS_TEACHER = r101;
                        TagType r102 = new TagType("DISCIPLINE_TEACHER", 2, 2);
                        DISCIPLINE_TEACHER = r102;
                        TagType r103 = new TagType("ADMIN_USER", 3, 3);
                        ADMIN_USER = r103;
                        $VALUES = new TagType[]{r100, r101, r102, r103};
                        ADAPTER = ProtoAdapter.newEnumAdapter(TagType.class);
                    }

                    public static TagType[] values() {
                        return (TagType[]) $VALUES.clone();
                    }

                    @Override // com.squareup.wire.WireEnum
                    public final int getValue() {
                        return this.value;
                    }

                    public static TagType fromValue(int r100) {
                        if (r100 == 0) goto L18;
                        if (r100 == 1) goto L16;
                        if (r100 == 2) goto L14;
                        if (r100 == 3) goto L12;
                        return null;
                    L12:
                        return ADMIN_USER;
                    L14:
                        return DISCIPLINE_TEACHER;
                    L16:
                        return CLASS_TEACHER;
                    L18:
                        return UNKNOWN;
                    }

                    public static TagType valueOf(String r100) {
                        return (TagType) a.a(TagType.class, r100);
                    }

                    private TagType(String r100, int r101, int r102) {
                        super(r100, r101);
                        this.value = r102;
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_TagInfo();
                    DEFAULT_TAG_TYPE = TagType.UNKNOWN;
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.tag_type = this.tag_type;
                    r100.description = this.description;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return TagInfo.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public TagInfo(TagType r100, String r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public TagInfo(TagType r100, String r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.tag_type = r100;
                    this.description = r101;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ChatChatterTagInfo();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ChatChatterTagInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public ChatChatterTagInfo(List<TagInfo> r100) {
                this(r100, ByteString.EMPTY);
            }

            public ChatChatterTagInfo(List<TagInfo> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r100);
            }
        }

        public static final enum OncallRole extends Enum<OncallRole> implements WireEnum {
            private static final /* synthetic */ OncallRole[] $VALUES = null;
            public static final ProtoAdapter<OncallRole> ADAPTER = null;
            public static final OncallRole ONCALL = null;
            public static final OncallRole ONCALL_HELPER = null;
            public static final OncallRole UNKNOWN = null;
            public static final OncallRole USER = null;
            public static final OncallRole USER_HELPER = null;
            private final int value;

            static {
                OncallRole r100 = new OncallRole("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                OncallRole r101 = new OncallRole(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 3);
                USER = r101;
                OncallRole r102 = new OncallRole("ONCALL", 2, 4);
                ONCALL = r102;
                OncallRole r103 = new OncallRole("ONCALL_HELPER", 3, 5);
                ONCALL_HELPER = r103;
                OncallRole r104 = new OncallRole("USER_HELPER", 4, 6);
                USER_HELPER = r104;
                $VALUES = new OncallRole[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(OncallRole.class);
            }

            public static OncallRole[] values() {
                return (OncallRole[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static OncallRole fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L18;
                if (r100 == 5) goto L16;
                if (r100 == 6) goto L14;
                return null;
            L14:
                return USER_HELPER;
            L16:
                return ONCALL_HELPER;
            L18:
                return ONCALL;
            L20:
                return USER;
            L22:
                return UNKNOWN;
            }

            public static OncallRole valueOf(String r100) {
                return (OncallRole) a.a(OncallRole.class, r100);
            }

            private OncallRole(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ChatExtra extends ProtoAdapter<ChatExtra> {
            public ProtoAdapter_ChatExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_id = "";
                r101.nick_name = "";
                r101.oncall_role = OncallRole.UNKNOWN;
                r101.nick_name_pinyin = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.nick_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.oncall_role = OncallRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.nick_name_pinyin = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.tag_infos = ChatChatterTagInfo.ADAPTER.decode(r100);
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
            public int encodedSize2(ChatExtra r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
                String r103 = r100.nick_name;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                OncallRole r107 = r100.oncall_role;
                if (r107 == null) goto L9;
                int r108 = OncallRole.ADAPTER.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.nick_name_pinyin;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(4, r110);
            L14:
                int r112 = r109 + r111;
                ChatChatterTagInfo r113 = r100.tag_infos;
                if (r113 == null) goto L18;
                r104 = ChatChatterTagInfo.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ ChatExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatExtra r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.chat_id);
                String r103 = r101.nick_name;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                OncallRole r104 = r101.oncall_role;
                if (r104 == null) goto L8;
                OncallRole.ADAPTER.encodeWithTag(r100, 3, r104);
            L8:
                String r105 = r101.nick_name_pinyin;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 4, r105);
            L11:
                ChatChatterTagInfo r106 = r101.tag_infos;
                if (r106 == null) goto L14;
                ChatChatterTagInfo.ADAPTER.encodeWithTag(r100, 5, r106);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatExtra();
            DEFAULT_ONCALL_ROLE = OncallRole.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_id = this.chat_id;
            r100.nick_name = this.nick_name;
            r100.oncall_role = this.oncall_role;
            r100.nick_name_pinyin = this.nick_name_pinyin;
            r100.tag_infos = this.tag_infos;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatExtra(String r100, String r101, OncallRole r110, String r111, ChatChatterTagInfo r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ChatExtra(String r100, String r101, OncallRole r102, String r103, ChatChatterTagInfo r104, ByteString r105) {
            super(ADAPTER, r105);
            this.chat_id = r100;
            this.nick_name = r101;
            this.oncall_role = r102;
            this.nick_name_pinyin = r103;
            this.tag_infos = r104;
        }
    }

    public static final class ChatterCustomStatus extends com.squareup.wire.Message<ChatterCustomStatus, Builder> {
        public static final ProtoAdapter<ChatterCustomStatus> ADAPTER = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final String DEFAULT_ICON_KEY = "";
        public static final Boolean DEFAULT_IS_NOT_DISTURB_MODE = null;
        public static final Long DEFAULT_STATUS_ID = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final StatusEffectiveInterval effective_interval;
        public final String fs_unit;
        public final String icon_key;
        public final Boolean is_not_disturb_mode;
        public final Long status_id;
        public final TagInfo tag_info;
        public final TimeFormat time_format;
        public final String title;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatterCustomStatus, Builder> {
            public StatusEffectiveInterval effective_interval;
            public String fs_unit;
            public String icon_key;
            public Boolean is_not_disturb_mode;
            public Long status_id;
            public TagInfo tag_info;
            public TimeFormat time_format;
            public String title;

            @Override // com.squareup.wire.Message.Builder
            public ChatterCustomStatus build() {
                return new ChatterCustomStatus(this.title, this.icon_key, this.fs_unit, this.is_not_disturb_mode, this.effective_interval, this.tag_info, this.time_format, this.status_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder effective_interval(StatusEffectiveInterval r100) {
                this.effective_interval = r100;
                return this;
            }

            public Builder fs_unit(String r100) {
                this.fs_unit = r100;
                return this;
            }

            public Builder icon_key(String r100) {
                this.icon_key = r100;
                return this;
            }

            public Builder is_not_disturb_mode(Boolean r100) {
                this.is_not_disturb_mode = r100;
                return this;
            }

            public Builder status_id(Long r100) {
                this.status_id = r100;
                return this;
            }

            public Builder tag_info(TagInfo r100) {
                this.tag_info = r100;
                return this;
            }

            public Builder time_format(TimeFormat r100) {
                this.time_format = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterCustomStatus extends ProtoAdapter<ChatterCustomStatus> {
            public ProtoAdapter_ChatterCustomStatus() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterCustomStatus.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatterCustomStatus decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.icon_key = "";
                r101.fs_unit = "";
                r101.is_not_disturb_mode = Boolean.FALSE;
                r101.status_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                switch(r103) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r101.status_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                r101.time_format = TimeFormat.ADAPTER.decode(r100);
                goto L3
            L9:
                r101.tag_info = TagInfo.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.effective_interval = StatusEffectiveInterval.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.is_not_disturb_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.fs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.icon_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatterCustomStatus r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.icon_key;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.fs_unit;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_not_disturb_mode;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                StatusEffectiveInterval r113 = r100.effective_interval;
                if (r113 == null) goto L21;
                int r114 = StatusEffectiveInterval.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                TagInfo r116 = r100.tag_info;
                if (r116 == null) goto L25;
                int r117 = TagInfo.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                TimeFormat r119 = r100.time_format;
                if (r119 == null) goto L29;
                int r120 = TimeFormat.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Long r122 = r100.status_id;
                if (r122 == null) goto L34;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
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
            public /* bridge */ /* synthetic */ ChatterCustomStatus decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatterCustomStatus r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatterCustomStatus r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.icon_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.fs_unit;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.is_not_disturb_mode;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                StatusEffectiveInterval r106 = r101.effective_interval;
                if (r106 == null) goto L17;
                StatusEffectiveInterval.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                TagInfo r107 = r101.tag_info;
                if (r107 == null) goto L20;
                TagInfo.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                TimeFormat r108 = r101.time_format;
                if (r108 == null) goto L23;
                TimeFormat.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                Long r109 = r101.status_id;
                if (r109 == null) goto L26;
                ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterCustomStatus r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterCustomStatus();
            DEFAULT_IS_NOT_DISTURB_MODE = Boolean.FALSE;
            DEFAULT_STATUS_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.icon_key = this.icon_key;
            r100.fs_unit = this.fs_unit;
            r100.is_not_disturb_mode = this.is_not_disturb_mode;
            r100.effective_interval = this.effective_interval;
            r100.tag_info = this.tag_info;
            r100.time_format = this.time_format;
            r100.status_id = this.status_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatterCustomStatus.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatterCustomStatus(String r110, String r111, String r112, Boolean r113, StatusEffectiveInterval r114, TagInfo r115, TimeFormat r116, Long r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public ChatterCustomStatus(String r100, String r101, String r102, Boolean r103, StatusEffectiveInterval r104, TagInfo r105, TimeFormat r106, Long r107, ByteString r110) {
            super(ADAPTER, r110);
            this.title = r100;
            this.icon_key = r101;
            this.fs_unit = r102;
            this.is_not_disturb_mode = r103;
            this.effective_interval = r104;
            this.tag_info = r105;
            this.time_format = r106;
            this.status_id = r107;
        }
    }

    public static final class Description extends com.squareup.wire.Message<Description, Builder> {
        public static final ProtoAdapter<Description> ADAPTER = null;
        public static final Long DEFAULT_DESCRIPTION_ID = null;
        public static final String DEFAULT_TEXT = "";
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Long description_id;
        public final String text;
        public final Type type;

        public static final class Builder extends com.squareup.wire.Message.Builder<Description, Builder> {
            public Long description_id;
            public String text;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public Description build() {
                return new Description(this.text, this.type, this.description_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder description_id(Long r100) {
                this.description_id = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Description extends ProtoAdapter<Description> {
            public ProtoAdapter_Description() {
                super(FieldEncoding.LENGTH_DELIMITED, Description.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Description decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.type = Type.ON_DEFAULT;
                r101.description_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.description_id = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(Description r100) {
                String r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Type r104 = r100.type;
                if (r104 == null) goto L9;
                int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.description_id;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ Description decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Description r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Description r101) throws IOException {
                String r102 = r101.text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Type r103 = r101.type;
                if (r103 == null) goto L8;
                Type.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.description_id;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Description r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ON_BUSINESS = null;
            public static final Type ON_DEFAULT = null;
            public static final Type ON_LEAVE = null;
            public static final Type ON_MEETING = null;
            private final int value;

            static {
                Type r100 = new Type("ON_DEFAULT", 0, 0);
                ON_DEFAULT = r100;
                Type r101 = new Type("ON_BUSINESS", 1, 1);
                ON_BUSINESS = r101;
                Type r102 = new Type("ON_LEAVE", 2, 2);
                ON_LEAVE = r102;
                Type r103 = new Type("ON_MEETING", 3, 3);
                ON_MEETING = r103;
                $VALUES = new Type[]{r100, r101, r102, r103};
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
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return ON_MEETING;
            L14:
                return ON_LEAVE;
            L16:
                return ON_BUSINESS;
            L18:
                return ON_DEFAULT;
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
            ADAPTER = new ProtoAdapter_Description();
            DEFAULT_TYPE = Type.ON_DEFAULT;
            DEFAULT_DESCRIPTION_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.type = this.type;
            r100.description_id = this.description_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Description.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Description(String r100, Type r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Description(String r100, Type r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.text = r100;
            this.type = r101;
            this.description_id = r102;
        }
    }

    public static final class ProtoAdapter_Chatter extends ProtoAdapter<Chatter> {
        public ProtoAdapter_Chatter() {
            super(FieldEncoding.LENGTH_DELIMITED, Chatter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Chatter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253460id = "";
            r101.name = "";
            r101.type = Type.UNKNOWN;
            r101.update_time = 0L;
            r101.name_pinyin = "";
            r101.creator_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_resigned = r102;
            Boolean r103 = Boolean.TRUE;
            r101.is_registered = r103;
            r101.en_us_name = "";
            r101.avatar_key = "";
            r101.tenant_id = "";
            r101.localized_name = "";
            r101.alias = "";
            r101.profile_enabled = r103;
            r101.account_id = "";
            r101.open_app_id = "";
            r101.avatar_path = "";
            r101.email = "";
            r101.do_not_disturb_end_time = 0L;
            r101.is_frozen = r102;
            r101.is_anonymous = r102;
            r101.name_with_another_name = "";
            r101.another_name = "";
            r101.is_default_avatar = r102;
            r101.is_special_focus = r102;
            r101.major_language = "";
            r101.private_description = "";
            r101.private_description_id = 0L;
            r101.is_tenant_certification = r102;
            r101.tenant_name_status = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
            r101.with_bot_tag = "bot";
            r101.in_contacts = r103;
            r101.can_join_group = r103;
            r101.chat_chatter_list_department_name = "";
            r101.bot_ext_type = 0;
            r101.is_agent = r102;
            r101.accept_sms_phone_urgent = r102;
            long r104 = r100.beginMessage();
        L3:
            int r105 = r100.nextTag();
            if (r105 == (-1)) goto L80;
            if (r105 != 36) goto L8;
            r101.private_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r105 != 37) goto L10;
            r101.private_description_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r105 != 150) goto L12;
            r101.status.add(ChatterCustomStatus.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r105 != 200) goto L14;
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L75
        L75:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r105 != 1000) goto L16;
            r101.chat_extra = ChatExtra.ADAPTER.decode(r100);
            goto L3
        L16:
            if (r105 != 1001) goto L17;
            r101.accept_sms_phone_urgent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            switch(r105) {
                case 1: goto L70;
                case 2: goto L69;
                case 3: goto L86;
                case 4: goto L64;
                case 5: goto L63;
                case 6: goto L62;
                case 7: goto L61;
                case 8: goto L60;
                case 9: goto L59;
                case 10: goto L58;
                case 11: goto L57;
                case 12: goto L56;
                case 13: goto L55;
                case 14: goto L54;
                case 15: goto L53;
                case 16: goto L52;
                case 17: goto L51;
                case 18: goto L50;
                case 19: goto L49;
                case 20: goto L48;
                case 21: goto L47;
                case 22: goto L46;
                case 23: goto L45;
                case 24: goto L44;
                case 25: goto L43;
                case 26: goto L42;
                case 27: goto L41;
                case 28: goto L40;
                case 29: goto L39;
                case 30: goto L38;
                case 31: goto L37;
                case 32: goto L36;
                case 33: goto L35;
                case 34: goto L34;
                default: goto L18;
            };
        L86:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L67
        L67:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L34:
            r101.tag_info = TagData.ADAPTER.decode(r100);
            goto L3
        L35:
            r101.major_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.is_special_focus = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L37:
            r101.is_default_avatar = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L38:
            r101.another_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.name_with_another_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L40:
            r101.avatar_medal = AvatarMedal.ADAPTER.decode(r100);
            goto L3
        L41:
            r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L42:
            r101.is_frozen = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L43:
            r101.time_zone = TimeZone.ADAPTER.decode(r100);
            goto L3
        L44:
            r101.avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L45:
            r101.do_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L46:
            r101.email = ProtoAdapter.STRING.decode(r100);
            goto L3
        L47:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L48:
            r101.open_app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L49:
            r101.access_info = AccessInfo.ADAPTER.decode(r100);
            goto L3
        L50:
            r101.account_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L51:
            r101.profile_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L52:
            r101.work_status = WorkStatus.ADAPTER.decode(r100);
            goto L3
        L53:
            r101.alias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L54:
            r101.localized_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L55:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L56:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L57:
            r101.description = Description.ADAPTER.decode(r100);
            goto L3
        L58:
            r101.en_us_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L59:
            r101.is_registered = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L60:
            r101.is_resigned = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L61:
            r101.creator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L62:
            r101.name_pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L63:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L64:
            r101.avatar = ImageSet.ADAPTER.decode(r100);
            goto L3
        L69:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L70:
            r101.f253460id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            switch(r105) {
                case 45: goto L33;
                case 46: goto L84;
                case 47: goto L28;
                default: goto L19;
            };
        L84:
            r101.tenant_name_status = TenantNameStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r101.common_locales.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L33:
            r101.is_tenant_certification = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            switch(r105) {
                case 100: goto L27;
                case 101: goto L26;
                case 102: goto L25;
                case 103: goto L24;
                case 104: goto L23;
                case 105: goto L22;
                case 106: goto L21;
                default: goto L20;
            };
        L21:
            r101.is_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.bot_ext_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L23:
            r101.chat_chatter_list_department_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.muted_info = BotMutedInfo.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.can_join_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.in_contacts = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.with_bot_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            FieldEncoding r106 = r100.peekFieldEncoding();
            r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
            goto L3
        L80:
            r100.endMessage(r104);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Chatter r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.f253459id) + r101.encodedSizeWithTag(2, r100.name)) + Type.ADAPTER.encodedSizeWithTag(3, r100.type);
            ImageSet r103 = r100.avatar;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ImageSet.ADAPTER.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            ProtoAdapter<Long> r107 = ProtoAdapter.INT64;
            int r108 = (r106 + r107.encodedSizeWithTag(5, r100.update_time)) + r101.encodedSizeWithTag(6, r100.name_pinyin);
            String r109 = r100.creator_id;
            if (r109 == null) goto L9;
            int r110 = r101.encodedSizeWithTag(7, r109);
        L10:
            int r111 = r108 + r110;
            Boolean r112 = r100.is_resigned;
            if (r112 == null) goto L13;
            int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r112);
        L14:
            int r114 = r111 + r113;
            Boolean r115 = r100.is_registered;
            if (r115 == null) goto L17;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r115);
        L18:
            int r117 = r114 + r116;
            String r118 = r100.en_us_name;
            if (r118 == null) goto L21;
            int r119 = r101.encodedSizeWithTag(10, r118);
        L22:
            int r120 = r117 + r119;
            Description r121 = r100.description;
            if (r121 == null) goto L25;
            int r122 = Description.ADAPTER.encodedSizeWithTag(11, r121);
        L26:
            int r123 = r120 + r122;
            String r124 = r100.avatar_key;
            if (r124 == null) goto L29;
            int r125 = r101.encodedSizeWithTag(12, r124);
        L30:
            int r126 = r123 + r125;
            String r127 = r100.tenant_id;
            if (r127 == null) goto L33;
            int r128 = r101.encodedSizeWithTag(13, r127);
        L34:
            int r129 = r126 + r128;
            String r130 = r100.localized_name;
            if (r130 == null) goto L37;
            int r131 = r101.encodedSizeWithTag(14, r130);
        L38:
            int r132 = r129 + r131;
            String r133 = r100.alias;
            if (r133 == null) goto L41;
            int r134 = r101.encodedSizeWithTag(15, r133);
        L42:
            int r135 = r132 + r134;
            WorkStatus r136 = r100.work_status;
            if (r136 == null) goto L45;
            int r137 = WorkStatus.ADAPTER.encodedSizeWithTag(16, r136);
        L46:
            int r138 = r135 + r137;
            Boolean r139 = r100.profile_enabled;
            if (r139 == null) goto L49;
            int r140 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r139);
        L50:
            int r141 = r138 + r140;
            String r142 = r100.account_id;
            if (r142 == null) goto L53;
            int r143 = r101.encodedSizeWithTag(18, r142);
        L54:
            int r144 = r141 + r143;
            AccessInfo r145 = r100.access_info;
            if (r145 == null) goto L57;
            int r146 = AccessInfo.ADAPTER.encodedSizeWithTag(19, r145);
        L58:
            int r147 = r144 + r146;
            String r148 = r100.open_app_id;
            if (r148 == null) goto L61;
            int r149 = r101.encodedSizeWithTag(20, r148);
        L62:
            int r150 = r147 + r149;
            String r151 = r100.avatar_path;
            if (r151 == null) goto L65;
            int r152 = r101.encodedSizeWithTag(21, r151);
        L66:
            int r153 = r150 + r152;
            String r154 = r100.email;
            if (r154 == null) goto L69;
            int r155 = r101.encodedSizeWithTag(22, r154);
        L70:
            int r156 = r153 + r155;
            Long r157 = r100.do_not_disturb_end_time;
            if (r157 == null) goto L73;
            int r158 = r107.encodedSizeWithTag(23, r157);
        L74:
            int r159 = (r156 + r158) + r101.asRepeated().encodedSizeWithTag(24, r100.avatar_urls);
            TimeZone r160 = r100.time_zone;
            if (r160 == null) goto L77;
            int r161 = TimeZone.ADAPTER.encodedSizeWithTag(25, r160);
        L78:
            int r162 = r159 + r161;
            Boolean r163 = r100.is_frozen;
            if (r163 == null) goto L81;
            int r164 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r163);
        L82:
            int r165 = r162 + r164;
            Boolean r166 = r100.is_anonymous;
            if (r166 == null) goto L85;
            int r167 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r166);
        L86:
            int r168 = r165 + r167;
            AvatarMedal r169 = r100.avatar_medal;
            if (r169 == null) goto L89;
            int r170 = AvatarMedal.ADAPTER.encodedSizeWithTag(28, r169);
        L90:
            int r171 = r168 + r170;
            String r172 = r100.name_with_another_name;
            if (r172 == null) goto L93;
            int r173 = r101.encodedSizeWithTag(29, r172);
        L94:
            int r174 = r171 + r173;
            String r175 = r100.another_name;
            if (r175 == null) goto L97;
            int r176 = r101.encodedSizeWithTag(30, r175);
        L98:
            int r177 = r174 + r176;
            Boolean r178 = r100.is_default_avatar;
            if (r178 == null) goto L101;
            int r179 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r178);
        L102:
            int r180 = r177 + r179;
            Boolean r181 = r100.is_special_focus;
            if (r181 == null) goto L105;
            int r182 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r181);
        L106:
            int r183 = r180 + r182;
            String r184 = r100.major_language;
            if (r184 == null) goto L109;
            int r185 = r101.encodedSizeWithTag(33, r184);
        L110:
            int r186 = r183 + r185;
            TagData r187 = r100.tag_info;
            if (r187 == null) goto L113;
            int r188 = TagData.ADAPTER.encodedSizeWithTag(34, r187);
        L114:
            int r189 = r186 + r188;
            String r190 = r100.private_description;
            if (r190 == null) goto L117;
            int r191 = r101.encodedSizeWithTag(36, r190);
        L118:
            int r192 = r189 + r191;
            Long r193 = r100.private_description_id;
            if (r193 == null) goto L121;
            int r194 = r107.encodedSizeWithTag(37, r193);
        L122:
            int r195 = r192 + r194;
            Boolean r196 = r100.is_tenant_certification;
            if (r196 == null) goto L125;
            int r197 = ProtoAdapter.BOOL.encodedSizeWithTag(45, r196);
        L126:
            int r198 = r195 + r197;
            TenantNameStatus r199 = r100.tenant_name_status;
            if (r199 == null) goto L129;
            int r200 = TenantNameStatus.ADAPTER.encodedSizeWithTag(46, r199);
        L130:
            int r201 = (r198 + r200) + r101.asRepeated().encodedSizeWithTag(47, r100.common_locales);
            String r202 = r100.with_bot_tag;
            if (r202 == null) goto L133;
            int r203 = r101.encodedSizeWithTag(100, r202);
        L134:
            int r204 = r201 + r203;
            Boolean r205 = r100.in_contacts;
            if (r205 == null) goto L137;
            int r206 = ProtoAdapter.BOOL.encodedSizeWithTag(101, r205);
        L138:
            int r207 = r204 + r206;
            Boolean r208 = r100.can_join_group;
            if (r208 == null) goto L141;
            int r209 = ProtoAdapter.BOOL.encodedSizeWithTag(102, r208);
        L142:
            int r210 = r207 + r209;
            BotMutedInfo r211 = r100.muted_info;
            if (r211 == null) goto L145;
            int r212 = BotMutedInfo.ADAPTER.encodedSizeWithTag(103, r211);
        L146:
            int r213 = r210 + r212;
            String r214 = r100.chat_chatter_list_department_name;
            if (r214 == null) goto L149;
            int r215 = r101.encodedSizeWithTag(104, r214);
        L150:
            int r216 = r213 + r215;
            Integer r217 = r100.bot_ext_type;
            if (r217 == null) goto L153;
            int r218 = ProtoAdapter.INT32.encodedSizeWithTag(105, r217);
        L154:
            int r219 = r216 + r218;
            Boolean r220 = r100.is_agent;
            if (r220 == null) goto L157;
            int r221 = ProtoAdapter.BOOL.encodedSizeWithTag(106, r220);
        L158:
            int r222 = (r219 + r221) + ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(150, r100.status);
            ChatExtra r223 = r100.chat_extra;
            if (r223 == null) goto L161;
            int r224 = ChatExtra.ADAPTER.encodedSizeWithTag(1000, r223);
        L162:
            int r225 = r222 + r224;
            Boolean r226 = r100.accept_sms_phone_urgent;
            if (r226 == null) goto L166;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(1001, r226);
        L166:
            return ((r225 + r104) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(200, r100.tags)) + r100.unknownFields().size();
        L161:
            r224 = 0;
            goto L162
        L157:
            r221 = 0;
            goto L158
        L153:
            r218 = 0;
            goto L154
        L149:
            r215 = 0;
            goto L150
        L145:
            r212 = 0;
            goto L146
        L141:
            r209 = 0;
            goto L142
        L137:
            r206 = 0;
            goto L138
        L133:
            r203 = 0;
            goto L134
        L129:
            r200 = 0;
            goto L130
        L125:
            r197 = 0;
            goto L126
        L121:
            r194 = 0;
            goto L122
        L117:
            r191 = 0;
            goto L118
        L113:
            r188 = 0;
            goto L114
        L109:
            r185 = 0;
            goto L110
        L105:
            r182 = 0;
            goto L106
        L101:
            r179 = 0;
            goto L102
        L97:
            r176 = 0;
            goto L98
        L93:
            r173 = 0;
            goto L94
        L89:
            r170 = 0;
            goto L90
        L85:
            r167 = 0;
            goto L86
        L81:
            r164 = 0;
            goto L82
        L77:
            r161 = 0;
            goto L78
        L73:
            r158 = 0;
            goto L74
        L69:
            r155 = 0;
            goto L70
        L65:
            r152 = 0;
            goto L66
        L61:
            r149 = 0;
            goto L62
        L57:
            r146 = 0;
            goto L58
        L53:
            r143 = 0;
            goto L54
        L49:
            r140 = 0;
            goto L50
        L45:
            r137 = 0;
            goto L46
        L41:
            r134 = 0;
            goto L42
        L37:
            r131 = 0;
            goto L38
        L33:
            r128 = 0;
            goto L34
        L29:
            r125 = 0;
            goto L30
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
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
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Chatter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Chatter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Chatter r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253459id);
            r102.encodeWithTag(r100, 2, r101.name);
            Type.ADAPTER.encodeWithTag(r100, 3, r101.type);
            ImageSet r103 = r101.avatar;
            if (r103 == null) goto L5;
            ImageSet.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            r104.encodeWithTag(r100, 5, r101.update_time);
            r102.encodeWithTag(r100, 6, r101.name_pinyin);
            String r105 = r101.creator_id;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 7, r105);
        L8:
            Boolean r106 = r101.is_resigned;
            if (r106 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r106);
        L11:
            Boolean r107 = r101.is_registered;
            if (r107 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
        L14:
            String r108 = r101.en_us_name;
            if (r108 == null) goto L17;
            r102.encodeWithTag(r100, 10, r108);
        L17:
            Description r109 = r101.description;
            if (r109 == null) goto L20;
            Description.ADAPTER.encodeWithTag(r100, 11, r109);
        L20:
            String r110 = r101.avatar_key;
            if (r110 == null) goto L23;
            r102.encodeWithTag(r100, 12, r110);
        L23:
            String r111 = r101.tenant_id;
            if (r111 == null) goto L26;
            r102.encodeWithTag(r100, 13, r111);
        L26:
            String r112 = r101.localized_name;
            if (r112 == null) goto L29;
            r102.encodeWithTag(r100, 14, r112);
        L29:
            String r113 = r101.alias;
            if (r113 == null) goto L32;
            r102.encodeWithTag(r100, 15, r113);
        L32:
            WorkStatus r114 = r101.work_status;
            if (r114 == null) goto L35;
            WorkStatus.ADAPTER.encodeWithTag(r100, 16, r114);
        L35:
            Boolean r115 = r101.profile_enabled;
            if (r115 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r115);
        L38:
            String r116 = r101.account_id;
            if (r116 == null) goto L41;
            r102.encodeWithTag(r100, 18, r116);
        L41:
            AccessInfo r117 = r101.access_info;
            if (r117 == null) goto L44;
            AccessInfo.ADAPTER.encodeWithTag(r100, 19, r117);
        L44:
            String r118 = r101.open_app_id;
            if (r118 == null) goto L47;
            r102.encodeWithTag(r100, 20, r118);
        L47:
            String r119 = r101.avatar_path;
            if (r119 == null) goto L50;
            r102.encodeWithTag(r100, 21, r119);
        L50:
            String r120 = r101.email;
            if (r120 == null) goto L53;
            r102.encodeWithTag(r100, 22, r120);
        L53:
            Long r121 = r101.do_not_disturb_end_time;
            if (r121 == null) goto L56;
            r104.encodeWithTag(r100, 23, r121);
        L56:
            r102.asRepeated().encodeWithTag(r100, 24, r101.avatar_urls);
            TimeZone r122 = r101.time_zone;
            if (r122 == null) goto L59;
            TimeZone.ADAPTER.encodeWithTag(r100, 25, r122);
        L59:
            Boolean r123 = r101.is_frozen;
            if (r123 == null) goto L62;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r123);
        L62:
            Boolean r124 = r101.is_anonymous;
            if (r124 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r124);
        L65:
            AvatarMedal r125 = r101.avatar_medal;
            if (r125 == null) goto L68;
            AvatarMedal.ADAPTER.encodeWithTag(r100, 28, r125);
        L68:
            String r126 = r101.name_with_another_name;
            if (r126 == null) goto L71;
            r102.encodeWithTag(r100, 29, r126);
        L71:
            String r127 = r101.another_name;
            if (r127 == null) goto L74;
            r102.encodeWithTag(r100, 30, r127);
        L74:
            Boolean r128 = r101.is_default_avatar;
            if (r128 == null) goto L77;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r128);
        L77:
            Boolean r129 = r101.is_special_focus;
            if (r129 == null) goto L80;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32, r129);
        L80:
            String r130 = r101.major_language;
            if (r130 == null) goto L83;
            r102.encodeWithTag(r100, 33, r130);
        L83:
            TagData r131 = r101.tag_info;
            if (r131 == null) goto L86;
            TagData.ADAPTER.encodeWithTag(r100, 34, r131);
        L86:
            String r132 = r101.private_description;
            if (r132 == null) goto L89;
            r102.encodeWithTag(r100, 36, r132);
        L89:
            Long r133 = r101.private_description_id;
            if (r133 == null) goto L92;
            r104.encodeWithTag(r100, 37, r133);
        L92:
            Boolean r134 = r101.is_tenant_certification;
            if (r134 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r100, 45, r134);
        L95:
            TenantNameStatus r135 = r101.tenant_name_status;
            if (r135 == null) goto L98;
            TenantNameStatus.ADAPTER.encodeWithTag(r100, 46, r135);
        L98:
            r102.asRepeated().encodeWithTag(r100, 47, r101.common_locales);
            String r136 = r101.with_bot_tag;
            if (r136 == null) goto L101;
            r102.encodeWithTag(r100, 100, r136);
        L101:
            Boolean r137 = r101.in_contacts;
            if (r137 == null) goto L104;
            ProtoAdapter.BOOL.encodeWithTag(r100, 101, r137);
        L104:
            Boolean r138 = r101.can_join_group;
            if (r138 == null) goto L107;
            ProtoAdapter.BOOL.encodeWithTag(r100, 102, r138);
        L107:
            BotMutedInfo r139 = r101.muted_info;
            if (r139 == null) goto L110;
            BotMutedInfo.ADAPTER.encodeWithTag(r100, 103, r139);
        L110:
            String r140 = r101.chat_chatter_list_department_name;
            if (r140 == null) goto L113;
            r102.encodeWithTag(r100, 104, r140);
        L113:
            Integer r141 = r101.bot_ext_type;
            if (r141 == null) goto L116;
            ProtoAdapter.INT32.encodeWithTag(r100, 105, r141);
        L116:
            Boolean r142 = r101.is_agent;
            if (r142 == null) goto L119;
            ProtoAdapter.BOOL.encodeWithTag(r100, 106, r142);
        L119:
            ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 150, r101.status);
            ChatExtra r143 = r101.chat_extra;
            if (r143 == null) goto L122;
            ChatExtra.ADAPTER.encodeWithTag(r100, 1000, r143);
        L122:
            Boolean r144 = r101.accept_sms_phone_urgent;
            if (r144 == null) goto L125;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1001, r144);
        L125:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 200, r101.tags);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Chatter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TimeZone extends com.squareup.wire.Message<TimeZone, Builder> {
        public static final ProtoAdapter<TimeZone> ADAPTER = null;
        public static final String DEFAULT_TIME_ZONE_ID = "";
        private static final long serialVersionUID = 0;
        public final String time_zone_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeZone, Builder> {
            public String time_zone_id;

            @Override // com.squareup.wire.Message.Builder
            public TimeZone build() {
                String r100 = this.time_zone_id;
                if (r100 == null) goto L7;
                return new TimeZone(this.time_zone_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "time_zone_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder time_zone_id(String r100) {
                this.time_zone_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeZone extends ProtoAdapter<TimeZone> {
            public ProtoAdapter_TimeZone() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeZone.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeZone decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.time_zone_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.time_zone_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TimeZone r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.time_zone_id) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TimeZone decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeZone r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeZone r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.time_zone_id);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeZone r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeZone();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.time_zone_id = this.time_zone_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeZone.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeZone(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public TimeZone(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.time_zone_id = r100;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AI = null;
        public static final Type BOT = null;
        public static final Type DOUBAO = null;
        public static final Type UNKNOWN = null;
        public static final Type USER = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            Type r102 = new Type("BOT", 2, 2);
            BOT = r102;
            Type r103 = new Type("AI", 3, 3);
            AI = r103;
            Type r104 = new Type("DOUBAO", 4, 4);
            DOUBAO = r104;
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
            return DOUBAO;
        L16:
            return AI;
        L18:
            return BOT;
        L20:
            return USER;
        L22:
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
        ADAPTER = new ProtoAdapter_Chatter();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_RESIGNED = r100;
        Boolean r101 = Boolean.TRUE;
        DEFAULT_IS_REGISTERED = r101;
        DEFAULT_PROFILE_ENABLED = r101;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_IS_FROZEN = r100;
        DEFAULT_IS_ANONYMOUS = r100;
        DEFAULT_IS_DEFAULT_AVATAR = r100;
        DEFAULT_IS_SPECIAL_FOCUS = r100;
        DEFAULT_PRIVATE_DESCRIPTION_ID = 0L;
        DEFAULT_IS_TENANT_CERTIFICATION = r100;
        DEFAULT_TENANT_NAME_STATUS = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
        DEFAULT_IN_CONTACTS = r101;
        DEFAULT_CAN_JOIN_GROUP = r101;
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = r100;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253460id = this.f253459id;
        r100.name = this.name;
        r100.type = this.type;
        r100.avatar = this.avatar;
        r100.update_time = this.update_time;
        r100.name_pinyin = this.name_pinyin;
        r100.creator_id = this.creator_id;
        r100.is_resigned = this.is_resigned;
        r100.is_registered = this.is_registered;
        r100.en_us_name = this.en_us_name;
        r100.description = this.description;
        r100.avatar_key = this.avatar_key;
        r100.tenant_id = this.tenant_id;
        r100.localized_name = this.localized_name;
        r100.alias = this.alias;
        r100.work_status = this.work_status;
        r100.profile_enabled = this.profile_enabled;
        r100.account_id = this.account_id;
        r100.access_info = this.access_info;
        r100.open_app_id = this.open_app_id;
        r100.avatar_path = this.avatar_path;
        r100.email = this.email;
        r100.do_not_disturb_end_time = this.do_not_disturb_end_time;
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.time_zone = this.time_zone;
        r100.is_frozen = this.is_frozen;
        r100.is_anonymous = this.is_anonymous;
        r100.avatar_medal = this.avatar_medal;
        r100.name_with_another_name = this.name_with_another_name;
        r100.another_name = this.another_name;
        r100.is_default_avatar = this.is_default_avatar;
        r100.is_special_focus = this.is_special_focus;
        r100.major_language = this.major_language;
        r100.tag_info = this.tag_info;
        r100.private_description = this.private_description;
        r100.private_description_id = this.private_description_id;
        r100.is_tenant_certification = this.is_tenant_certification;
        r100.tenant_name_status = this.tenant_name_status;
        r100.common_locales = Internal.copyOf("common_locales", this.common_locales);
        r100.with_bot_tag = this.with_bot_tag;
        r100.in_contacts = this.in_contacts;
        r100.can_join_group = this.can_join_group;
        r100.muted_info = this.muted_info;
        r100.chat_chatter_list_department_name = this.chat_chatter_list_department_name;
        r100.bot_ext_type = this.bot_ext_type;
        r100.is_agent = this.is_agent;
        r100.status = Internal.copyOf("status", this.status);
        r100.chat_extra = this.chat_extra;
        r100.accept_sms_phone_urgent = this.accept_sms_phone_urgent;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Chatter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Chatter(String r510, String r511, Type r512, ImageSet r513, Long r514, String r515, String r516, Boolean r610, Boolean r611, String r612, Description r613, String r614, String r615, String r616, String r617, WorkStatus r618, Boolean r619, String r710, AccessInfo r711, String r712, String r713, String r714, Long r715, List<String> r716, TimeZone r717, Boolean r718, Boolean r719, AvatarMedal r810, String r811, String r812, Boolean r813, Boolean r814, String r815, TagData r816, String r817, Long r818, Boolean r819, TenantNameStatus r910, List<String> r911, String r912, Boolean r913, Boolean r914, BotMutedInfo r915, String r916, Integer r917, Boolean r918, List<ChatterCustomStatus> r919, ChatExtra r100, Boolean r101, List<Tag> r102) {
        this(r510, r511, r512, r513, r514, r515, r516, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, ByteString.EMPTY);
    }

    public Chatter(String r100, String r101, Type r102, ImageSet r103, Long r104, String r105, String r110, Boolean r111, Boolean r112, String r113, Description r114, String r115, String r116, String r117, String r118, WorkStatus r119, Boolean r210, String r211, AccessInfo r212, String r213, String r214, String r215, Long r216, List<String> r217, TimeZone r218, Boolean r219, Boolean r310, AvatarMedal r311, String r312, String r313, Boolean r314, Boolean r315, String r316, TagData r317, String r318, Long r319, Boolean r410, TenantNameStatus r411, List<String> r412, String r413, Boolean r414, Boolean r415, BotMutedInfo r416, String r417, Integer r418, Boolean r419, List<ChatterCustomStatus> r510, ChatExtra r511, Boolean r512, List<Tag> r513, ByteString r514) {
        super(ADAPTER, r514);
        this.f253459id = r100;
        this.name = r101;
        this.type = r102;
        this.avatar = r103;
        this.update_time = r104;
        this.name_pinyin = r105;
        this.creator_id = r110;
        this.is_resigned = r111;
        this.is_registered = r112;
        this.en_us_name = r113;
        this.description = r114;
        this.avatar_key = r115;
        this.tenant_id = r116;
        this.localized_name = r117;
        this.alias = r118;
        this.work_status = r119;
        this.profile_enabled = r210;
        this.account_id = r211;
        this.access_info = r212;
        this.open_app_id = r213;
        this.avatar_path = r214;
        this.email = r215;
        this.do_not_disturb_end_time = r216;
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r217);
        this.time_zone = r218;
        this.is_frozen = r219;
        this.is_anonymous = r310;
        this.avatar_medal = r311;
        this.name_with_another_name = r312;
        this.another_name = r313;
        this.is_default_avatar = r314;
        this.is_special_focus = r315;
        this.major_language = r316;
        this.tag_info = r317;
        this.private_description = r318;
        this.private_description_id = r319;
        this.is_tenant_certification = r410;
        this.tenant_name_status = r411;
        this.common_locales = Internal.immutableCopyOf("common_locales", r412);
        this.with_bot_tag = r413;
        this.in_contacts = r414;
        this.can_join_group = r415;
        this.muted_info = r416;
        this.chat_chatter_list_department_name = r417;
        this.bot_ext_type = r418;
        this.is_agent = r419;
        this.status = Internal.immutableCopyOf("status", r510);
        this.chat_extra = r511;
        this.accept_sms_phone_urgent = r512;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r513);
    }
}
