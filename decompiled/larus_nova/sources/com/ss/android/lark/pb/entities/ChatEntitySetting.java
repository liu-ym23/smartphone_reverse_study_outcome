package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatEntitySetting extends com.squareup.wire.Message<ChatEntitySetting, Builder> {
    public static final ProtoAdapter<ChatEntitySetting> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AddMemberApplySetting.Enum madd_member_apply_setting;
    public final AddMemberPermissionSetting.Enum madd_member_permission_setting;
    public final AdminPostSetting.Enum madmin_post_setting;
    public final AnonymousSetting manonymous_setting;
    public final AtAllPermissionSetting.Enum mat_all_permission_setting;
    public final ChatDisplayModeSetting.Enum mchat_display_mode_setting;
    public final ChatPinPermissionSetting.Enum mchat_pin_permission_setting;
    public final ChatTabPermissionSetting.Enum mchat_tab_permission_setting;
    public final CreateUrgentSetting.Enum mcreate_urgent_setting;
    public final CreateVideoConferenceSetting.Enum mcreate_video_conference_setting;
    public final SystemMessageVisibleSetting.Enum mjoin_message_visible_setting;
    public final MessageVisibilitySetting.Enum mmessage_visibility_setting;
    public final PinPermissionSetting.Enum mpin_permission_setting;
    public final SystemMessageVisibleSetting.Enum mquit_message_visible_setting;
    public final ShareCardPermissionSetting.Enum mshare_card_permission_setting;
    public final ThreadAnonymousSetting.Enum mthread_anonymous_setting;
    public final TopNoticePermissionSetting.Enum mtop_notice_permission_setting;
    public final UserCountVisibleSetting.Enum muser_count_visible_setting;

    public static final class AddMemberApplySetting extends com.squareup.wire.Message<AddMemberApplySetting, Builder> {
        public static final ProtoAdapter<AddMemberApplySetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberApplySetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddMemberApplySetting build() {
                return new AddMemberApplySetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum NEED_APPLY = null;
            public static final Enum NO_APPLY = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("NO_APPLY", 1, 1);
                NO_APPLY = r101;
                Enum r102 = new Enum("NEED_APPLY", 2, 2);
                NEED_APPLY = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return NEED_APPLY;
            L12:
                return NO_APPLY;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_AddMemberApplySetting extends ProtoAdapter<AddMemberApplySetting> {
            public ProtoAdapter_AddMemberApplySetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberApplySetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddMemberApplySetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AddMemberApplySetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddMemberApplySetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddMemberApplySetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddMemberApplySetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddMemberApplySetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberApplySetting();
        }

        public AddMemberApplySetting() {
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
            return AddMemberApplySetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddMemberApplySetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AddMemberPermissionSetting extends com.squareup.wire.Message<AddMemberPermissionSetting, Builder> {
        public static final ProtoAdapter<AddMemberPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddMemberPermissionSetting build() {
                return new AddMemberPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_OWNER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_AddMemberPermissionSetting extends ProtoAdapter<AddMemberPermissionSetting> {
            public ProtoAdapter_AddMemberPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddMemberPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AddMemberPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddMemberPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddMemberPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddMemberPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddMemberPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberPermissionSetting();
        }

        public AddMemberPermissionSetting() {
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
            return AddMemberPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddMemberPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AdminPostSetting extends com.squareup.wire.Message<AdminPostSetting, Builder> {
        public static final ProtoAdapter<AdminPostSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AdminPostSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AdminPostSetting build() {
                return new AdminPostSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOW_POST = null;
            public static final Enum BANNED_POST = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALLOW_POST", 1, 1);
                ALLOW_POST = r101;
                Enum r102 = new Enum("BANNED_POST", 2, 2);
                BANNED_POST = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return BANNED_POST;
            L12:
                return ALLOW_POST;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_AdminPostSetting extends ProtoAdapter<AdminPostSetting> {
            public ProtoAdapter_AdminPostSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AdminPostSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AdminPostSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AdminPostSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AdminPostSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AdminPostSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AdminPostSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AdminPostSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AdminPostSetting();
        }

        public AdminPostSetting() {
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
            return AdminPostSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AdminPostSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AnonymousSetting extends com.squareup.wire.Message<AnonymousSetting, Builder> {
        public static final ProtoAdapter<AnonymousSetting> ADAPTER = null;
        public static final Boolean DEFAULT_IS_ALLOW_ANONYMOUS = null;
        public static final Boolean DEFAULT_IS_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_allow_anonymous;
        public final Boolean mis_visible;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnonymousSetting, Builder> {
            public Boolean mis_allow_anonymous;
            public Boolean mis_visible;

            @Override // com.squareup.wire.Message.Builder
            public AnonymousSetting build() {
                return new AnonymousSetting(this.mis_allow_anonymous, this.mis_visible, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder is_allow_anonymous(Boolean r100) {
                this.mis_allow_anonymous = r100;
                return this;
            }

            public Builder is_visible(Boolean r100) {
                this.mis_visible = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AnonymousSetting extends ProtoAdapter<AnonymousSetting> {
            public ProtoAdapter_AnonymousSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AnonymousSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnonymousSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.mis_allow_anonymous = r102;
                r101.mis_visible = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.mis_allow_anonymous = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.mis_visible = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(AnonymousSetting r100) {
                Boolean r101 = r100.mis_allow_anonymous;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mis_visible;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AnonymousSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AnonymousSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AnonymousSetting r101) throws IOException {
                Boolean r102 = r101.mis_allow_anonymous;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mis_visible;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AnonymousSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnonymousSetting();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_ALLOW_ANONYMOUS = r100;
            DEFAULT_IS_VISIBLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_allow_anonymous = this.mis_allow_anonymous;
            r100.mis_visible = this.mis_visible;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AnonymousSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AnonymousSetting(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AnonymousSetting(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mis_allow_anonymous = r100;
            this.mis_visible = r101;
        }
    }

    public static final class AtAllPermissionSetting extends com.squareup.wire.Message<AtAllPermissionSetting, Builder> {
        public static final ProtoAdapter<AtAllPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtAllPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AtAllPermissionSetting build() {
                return new AtAllPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_OWNER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_AtAllPermissionSetting extends ProtoAdapter<AtAllPermissionSetting> {
            public ProtoAdapter_AtAllPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AtAllPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AtAllPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AtAllPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AtAllPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AtAllPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AtAllPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AtAllPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtAllPermissionSetting();
        }

        public AtAllPermissionSetting() {
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
            return AtAllPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AtAllPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatEntitySetting, Builder> {
        public AddMemberApplySetting.Enum madd_member_apply_setting;
        public AddMemberPermissionSetting.Enum madd_member_permission_setting;
        public AdminPostSetting.Enum madmin_post_setting;
        public AnonymousSetting manonymous_setting;
        public AtAllPermissionSetting.Enum mat_all_permission_setting;
        public ChatDisplayModeSetting.Enum mchat_display_mode_setting;
        public ChatPinPermissionSetting.Enum mchat_pin_permission_setting;
        public ChatTabPermissionSetting.Enum mchat_tab_permission_setting;
        public CreateUrgentSetting.Enum mcreate_urgent_setting;
        public CreateVideoConferenceSetting.Enum mcreate_video_conference_setting;
        public SystemMessageVisibleSetting.Enum mjoin_message_visible_setting;
        public MessageVisibilitySetting.Enum mmessage_visibility_setting;
        public PinPermissionSetting.Enum mpin_permission_setting;
        public SystemMessageVisibleSetting.Enum mquit_message_visible_setting;
        public ShareCardPermissionSetting.Enum mshare_card_permission_setting;
        public ThreadAnonymousSetting.Enum mthread_anonymous_setting;
        public TopNoticePermissionSetting.Enum mtop_notice_permission_setting;
        public UserCountVisibleSetting.Enum muser_count_visible_setting;

        @Override // com.squareup.wire.Message.Builder
        public ChatEntitySetting build() {
            return new ChatEntitySetting(this.madd_member_permission_setting, this.mat_all_permission_setting, this.mjoin_message_visible_setting, this.mquit_message_visible_setting, this.mshare_card_permission_setting, this.madd_member_apply_setting, this.mthread_anonymous_setting, this.mmessage_visibility_setting, this.manonymous_setting, this.mcreate_urgent_setting, this.mcreate_video_conference_setting, this.mpin_permission_setting, this.mtop_notice_permission_setting, this.mchat_tab_permission_setting, this.mchat_display_mode_setting, this.madmin_post_setting, this.mchat_pin_permission_setting, this.muser_count_visible_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder add_member_apply_setting(AddMemberApplySetting.Enum r100) {
            this.madd_member_apply_setting = r100;
            return this;
        }

        public Builder add_member_permission_setting(AddMemberPermissionSetting.Enum r100) {
            this.madd_member_permission_setting = r100;
            return this;
        }

        public Builder admin_post_setting(AdminPostSetting.Enum r100) {
            this.madmin_post_setting = r100;
            return this;
        }

        public Builder anonymous_setting(AnonymousSetting r100) {
            this.manonymous_setting = r100;
            return this;
        }

        public Builder at_all_permission_setting(AtAllPermissionSetting.Enum r100) {
            this.mat_all_permission_setting = r100;
            return this;
        }

        public Builder chat_display_mode_setting(ChatDisplayModeSetting.Enum r100) {
            this.mchat_display_mode_setting = r100;
            return this;
        }

        public Builder chat_pin_permission_setting(ChatPinPermissionSetting.Enum r100) {
            this.mchat_pin_permission_setting = r100;
            return this;
        }

        public Builder chat_tab_permission_setting(ChatTabPermissionSetting.Enum r100) {
            this.mchat_tab_permission_setting = r100;
            return this;
        }

        public Builder create_urgent_setting(CreateUrgentSetting.Enum r100) {
            this.mcreate_urgent_setting = r100;
            return this;
        }

        public Builder create_video_conference_setting(CreateVideoConferenceSetting.Enum r100) {
            this.mcreate_video_conference_setting = r100;
            return this;
        }

        public Builder join_message_visible_setting(SystemMessageVisibleSetting.Enum r100) {
            this.mjoin_message_visible_setting = r100;
            return this;
        }

        public Builder message_visibility_setting(MessageVisibilitySetting.Enum r100) {
            this.mmessage_visibility_setting = r100;
            return this;
        }

        public Builder pin_permission_setting(PinPermissionSetting.Enum r100) {
            this.mpin_permission_setting = r100;
            return this;
        }

        public Builder quit_message_visible_setting(SystemMessageVisibleSetting.Enum r100) {
            this.mquit_message_visible_setting = r100;
            return this;
        }

        public Builder share_card_permission_setting(ShareCardPermissionSetting.Enum r100) {
            this.mshare_card_permission_setting = r100;
            return this;
        }

        public Builder thread_anonymous_setting(ThreadAnonymousSetting.Enum r100) {
            this.mthread_anonymous_setting = r100;
            return this;
        }

        public Builder top_notice_permission_setting(TopNoticePermissionSetting.Enum r100) {
            this.mtop_notice_permission_setting = r100;
            return this;
        }

        public Builder user_count_visible_setting(UserCountVisibleSetting.Enum r100) {
            this.muser_count_visible_setting = r100;
            return this;
        }
    }

    public static final class ChatDisplayModeSetting extends com.squareup.wire.Message<ChatDisplayModeSetting, Builder> {
        public static final ProtoAdapter<ChatDisplayModeSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatDisplayModeSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ChatDisplayModeSetting build() {
                return new ChatDisplayModeSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum DEFAULT = null;
            public static final Enum THREAD = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("DEFAULT", 1, 1);
                DEFAULT = r101;
                Enum r102 = new Enum("THREAD", 2, 2);
                THREAD = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return THREAD;
            L12:
                return DEFAULT;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ChatDisplayModeSetting extends ProtoAdapter<ChatDisplayModeSetting> {
            public ProtoAdapter_ChatDisplayModeSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatDisplayModeSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatDisplayModeSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ChatDisplayModeSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatDisplayModeSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatDisplayModeSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatDisplayModeSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatDisplayModeSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatDisplayModeSetting();
        }

        public ChatDisplayModeSetting() {
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
            return ChatDisplayModeSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatDisplayModeSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ChatPinPermissionSetting extends com.squareup.wire.Message<ChatPinPermissionSetting, Builder> {
        public static final ProtoAdapter<ChatPinPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatPinPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ChatPinPermissionSetting build() {
                return new ChatPinPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ChatPinPermissionSetting extends ProtoAdapter<ChatPinPermissionSetting> {
            public ProtoAdapter_ChatPinPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatPinPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatPinPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ChatPinPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatPinPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatPinPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatPinPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatPinPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatPinPermissionSetting();
        }

        public ChatPinPermissionSetting() {
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
            return ChatPinPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatPinPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ChatTabPermissionSetting extends com.squareup.wire.Message<ChatTabPermissionSetting, Builder> {
        public static final ProtoAdapter<ChatTabPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatTabPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ChatTabPermissionSetting build() {
                return new ChatTabPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ChatTabPermissionSetting extends ProtoAdapter<ChatTabPermissionSetting> {
            public ProtoAdapter_ChatTabPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatTabPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatTabPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ChatTabPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatTabPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatTabPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatTabPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatTabPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatTabPermissionSetting();
        }

        public ChatTabPermissionSetting() {
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
            return ChatTabPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatTabPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class CreateUrgentSetting extends com.squareup.wire.Message<CreateUrgentSetting, Builder> {
        public static final ProtoAdapter<CreateUrgentSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CreateUrgentSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public CreateUrgentSetting build() {
                return new CreateUrgentSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_CreateUrgentSetting extends ProtoAdapter<CreateUrgentSetting> {
            public ProtoAdapter_CreateUrgentSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CreateUrgentSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateUrgentSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(CreateUrgentSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CreateUrgentSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CreateUrgentSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CreateUrgentSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateUrgentSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CreateUrgentSetting();
        }

        public CreateUrgentSetting() {
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
            return CreateUrgentSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CreateUrgentSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class CreateVideoConferenceSetting extends com.squareup.wire.Message<CreateVideoConferenceSetting, Builder> {
        public static final ProtoAdapter<CreateVideoConferenceSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CreateVideoConferenceSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public CreateVideoConferenceSetting build() {
                return new CreateVideoConferenceSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_CreateVideoConferenceSetting extends ProtoAdapter<CreateVideoConferenceSetting> {
            public ProtoAdapter_CreateVideoConferenceSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CreateVideoConferenceSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateVideoConferenceSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(CreateVideoConferenceSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CreateVideoConferenceSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CreateVideoConferenceSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CreateVideoConferenceSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateVideoConferenceSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CreateVideoConferenceSetting();
        }

        public CreateVideoConferenceSetting() {
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
            return CreateVideoConferenceSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CreateVideoConferenceSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final enum Field extends Enum<Field> implements WireEnum {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Field ADD_MEMBER_APPLY_SETTING = null;
        public static final Field ADD_MEMBER_PERMISSION_SETTING = null;
        public static final Field ADMIN_POST_SETTING = null;
        public static final Field ALLOW_ANONYMOUS_SETTING = null;
        public static final Field AT_ALL_PERMISSION_SETTING = null;
        public static final Field CHAT_DISPLAY_MODE_SETTING = null;
        public static final Field CHAT_PIN_PERMISSION_SETTING = null;
        public static final Field CHAT_TAB_PERMISSION_SETTING = null;
        public static final Field CREATE_URGENT_SETTING = null;
        public static final Field CREATE_VIDEO_CONFERENCE_SETTING = null;
        public static final Field JOIN_MESSAGE_VISIBLE_SETTING = null;
        public static final Field MESSAGE_VISIBILITY_SETTING = null;
        public static final Field PIN_PERMISSION_SETTING = null;
        public static final Field QUIT_MESSAGE_VISIBLE_SETTING = null;
        public static final Field SHARE_CARD_PERMISSION_SETTING = null;
        public static final Field THREAD_ANONYMOUS_SETTING = null;
        public static final Field TOP_NOTICE_PERMISSION_SETTING = null;
        public static final Field UNKNOWN = null;
        public static final Field USER_COUNT_VISIBLE_SETTING = null;
        private final int value;

        static {
            Field r100 = new Field("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Field r101 = new Field("ADD_MEMBER_PERMISSION_SETTING", 1, 1);
            ADD_MEMBER_PERMISSION_SETTING = r101;
            Field r102 = new Field("AT_ALL_PERMISSION_SETTING", 2, 2);
            AT_ALL_PERMISSION_SETTING = r102;
            Field r103 = new Field("JOIN_MESSAGE_VISIBLE_SETTING", 3, 3);
            JOIN_MESSAGE_VISIBLE_SETTING = r103;
            Field r104 = new Field("QUIT_MESSAGE_VISIBLE_SETTING", 4, 4);
            QUIT_MESSAGE_VISIBLE_SETTING = r104;
            Field r105 = new Field("SHARE_CARD_PERMISSION_SETTING", 5, 5);
            SHARE_CARD_PERMISSION_SETTING = r105;
            Field r110 = new Field("ADD_MEMBER_APPLY_SETTING", 6, 6);
            ADD_MEMBER_APPLY_SETTING = r110;
            Field r111 = new Field("THREAD_ANONYMOUS_SETTING", 7, 7);
            THREAD_ANONYMOUS_SETTING = r111;
            Field r112 = new Field("MESSAGE_VISIBILITY_SETTING", 8, 8);
            MESSAGE_VISIBILITY_SETTING = r112;
            Field r113 = new Field("ALLOW_ANONYMOUS_SETTING", 9, 9);
            ALLOW_ANONYMOUS_SETTING = r113;
            Field r114 = new Field("CREATE_URGENT_SETTING", 10, 10);
            CREATE_URGENT_SETTING = r114;
            Field r115 = new Field("CREATE_VIDEO_CONFERENCE_SETTING", 11, 11);
            CREATE_VIDEO_CONFERENCE_SETTING = r115;
            Field r106 = new Field("PIN_PERMISSION_SETTING", 12, 12);
            PIN_PERMISSION_SETTING = r106;
            Field r107 = new Field("TOP_NOTICE_PERMISSION_SETTING", 13, 14);
            TOP_NOTICE_PERMISSION_SETTING = r107;
            Field r108 = new Field("CHAT_TAB_PERMISSION_SETTING", 14, 15);
            CHAT_TAB_PERMISSION_SETTING = r108;
            Field r109 = new Field("CHAT_DISPLAY_MODE_SETTING", 15, 16);
            CHAT_DISPLAY_MODE_SETTING = r109;
            Field r116 = new Field("ADMIN_POST_SETTING", 16, 17);
            ADMIN_POST_SETTING = r116;
            Field r117 = new Field("CHAT_PIN_PERMISSION_SETTING", 17, 18);
            CHAT_PIN_PERMISSION_SETTING = r117;
            Field r118 = new Field("USER_COUNT_VISIBLE_SETTING", 18, 19);
            USER_COUNT_VISIBLE_SETTING = r118;
            $VALUES = new Field[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
            ADAPTER = ProtoAdapter.newEnumAdapter(Field.class);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Field fromValue(int r100) {
            switch(r100) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L3;
                case 14: goto L16;
                case 15: goto L14;
                case 16: goto L12;
                case 17: goto L10;
                case 18: goto L8;
                case 19: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return USER_COUNT_VISIBLE_SETTING;
        L8:
            return CHAT_PIN_PERMISSION_SETTING;
        L10:
            return ADMIN_POST_SETTING;
        L12:
            return CHAT_DISPLAY_MODE_SETTING;
        L14:
            return CHAT_TAB_PERMISSION_SETTING;
        L16:
            return TOP_NOTICE_PERMISSION_SETTING;
        L18:
            return PIN_PERMISSION_SETTING;
        L20:
            return CREATE_VIDEO_CONFERENCE_SETTING;
        L22:
            return CREATE_URGENT_SETTING;
        L24:
            return ALLOW_ANONYMOUS_SETTING;
        L26:
            return MESSAGE_VISIBILITY_SETTING;
        L28:
            return THREAD_ANONYMOUS_SETTING;
        L30:
            return ADD_MEMBER_APPLY_SETTING;
        L32:
            return SHARE_CARD_PERMISSION_SETTING;
        L34:
            return QUIT_MESSAGE_VISIBLE_SETTING;
        L36:
            return JOIN_MESSAGE_VISIBLE_SETTING;
        L38:
            return AT_ALL_PERMISSION_SETTING;
        L40:
            return ADD_MEMBER_PERMISSION_SETTING;
        L42:
            return UNKNOWN;
        }

        public static Field valueOf(String r100) {
            return (Field) a.a(Field.class, r100);
        }

        private Field(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class MessageVisibilitySetting extends com.squareup.wire.Message<MessageVisibilitySetting, Builder> {
        public static final ProtoAdapter<MessageVisibilitySetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageVisibilitySetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public MessageVisibilitySetting build() {
                return new MessageVisibilitySetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MESSAGES = null;
            public static final Enum ONLY_NEW_MESSAGES = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MESSAGES", 1, 1);
                ALL_MESSAGES = r101;
                Enum r102 = new Enum("ONLY_NEW_MESSAGES", 2, 2);
                ONLY_NEW_MESSAGES = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_NEW_MESSAGES;
            L12:
                return ALL_MESSAGES;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MessageVisibilitySetting extends ProtoAdapter<MessageVisibilitySetting> {
            public ProtoAdapter_MessageVisibilitySetting() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageVisibilitySetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageVisibilitySetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(MessageVisibilitySetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageVisibilitySetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageVisibilitySetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageVisibilitySetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageVisibilitySetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageVisibilitySetting();
        }

        public MessageVisibilitySetting() {
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
            return MessageVisibilitySetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageVisibilitySetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class PinPermissionSetting extends com.squareup.wire.Message<PinPermissionSetting, Builder> {
        public static final ProtoAdapter<PinPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<PinPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public PinPermissionSetting build() {
                return new PinPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_PinPermissionSetting extends ProtoAdapter<PinPermissionSetting> {
            public ProtoAdapter_PinPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, PinPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PinPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(PinPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PinPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PinPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PinPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PinPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PinPermissionSetting();
        }

        public PinPermissionSetting() {
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
            return PinPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PinPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ProtoAdapter_ChatEntitySetting extends ProtoAdapter<ChatEntitySetting> {
        public ProtoAdapter_ChatEntitySetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatEntitySetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatEntitySetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L76;
            switch(r103) {
                case 1: goto L82;
                case 2: goto L96;
                case 3: goto L102;
                case 4: goto L106;
                case 5: goto L108;
                case 6: goto L80;
                case 7: goto L84;
                case 8: goto L90;
                case 9: goto L43;
                case 10: goto L78;
                case 11: goto L92;
                case 12: goto L94;
                case 13: goto L98;
                case 14: goto L104;
                case 15: goto L110;
                case 16: goto L86;
                case 17: goto L88;
                case 18: goto L100;
                default: goto L6;
            };
        L78:
            r101.mcreate_urgent_setting = CreateUrgentSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L41
        L41:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L80:
            r101.madd_member_apply_setting = AddMemberApplySetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
        L54:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L82:
            r101.madd_member_permission_setting = AddMemberPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L74
        L74:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L84:
            r101.mthread_anonymous_setting = ThreadAnonymousSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
        L50:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L86:
            r101.madmin_post_setting = AdminPostSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L88:
            r101.mchat_pin_permission_setting = ChatPinPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L90:
            r101.mmessage_visibility_setting = MessageVisibilitySetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L46
        L46:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L92:
            r101.mcreate_video_conference_setting = CreateVideoConferenceSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L37
        L37:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L94:
            r101.mpin_permission_setting = PinPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L96:
            r101.mat_all_permission_setting = AtAllPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L70
        L70:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L98:
            r101.mtop_notice_permission_setting = TopNoticePermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L100:
            r101.muser_count_visible_setting = UserCountVisibleSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L102:
            r101.mjoin_message_visible_setting = SystemMessageVisibleSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L66
        L66:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L104:
            r101.mchat_tab_permission_setting = ChatTabPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L106:
            r101.mquit_message_visible_setting = SystemMessageVisibleSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L62
        L62:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L108:
            r101.mshare_card_permission_setting = ShareCardPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L58
        L58:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L110:
            r101.mchat_display_mode_setting = ChatDisplayModeSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L43:
            r101.manonymous_setting = AnonymousSetting.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L76:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatEntitySetting r100) {
            AddMemberPermissionSetting.Enum r101 = r100.madd_member_permission_setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AddMemberPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            AtAllPermissionSetting.Enum r104 = r100.mat_all_permission_setting;
            if (r104 == null) goto L9;
            int r105 = AtAllPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SystemMessageVisibleSetting.Enum r107 = r100.mjoin_message_visible_setting;
            if (r107 == null) goto L13;
            int r108 = SystemMessageVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            SystemMessageVisibleSetting.Enum r110 = r100.mquit_message_visible_setting;
            if (r110 == null) goto L17;
            int r111 = SystemMessageVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ShareCardPermissionSetting.Enum r113 = r100.mshare_card_permission_setting;
            if (r113 == null) goto L21;
            int r114 = ShareCardPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            AddMemberApplySetting.Enum r116 = r100.madd_member_apply_setting;
            if (r116 == null) goto L25;
            int r117 = AddMemberApplySetting.Enum.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ThreadAnonymousSetting.Enum r119 = r100.mthread_anonymous_setting;
            if (r119 == null) goto L29;
            int r120 = ThreadAnonymousSetting.Enum.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            MessageVisibilitySetting.Enum r122 = r100.mmessage_visibility_setting;
            if (r122 == null) goto L33;
            int r123 = MessageVisibilitySetting.Enum.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            AnonymousSetting r125 = r100.manonymous_setting;
            if (r125 == null) goto L37;
            int r126 = AnonymousSetting.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            CreateUrgentSetting.Enum r128 = r100.mcreate_urgent_setting;
            if (r128 == null) goto L41;
            int r129 = CreateUrgentSetting.Enum.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            CreateVideoConferenceSetting.Enum r131 = r100.mcreate_video_conference_setting;
            if (r131 == null) goto L45;
            int r132 = CreateVideoConferenceSetting.Enum.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            PinPermissionSetting.Enum r134 = r100.mpin_permission_setting;
            if (r134 == null) goto L49;
            int r135 = PinPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            TopNoticePermissionSetting.Enum r137 = r100.mtop_notice_permission_setting;
            if (r137 == null) goto L53;
            int r138 = TopNoticePermissionSetting.Enum.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            ChatTabPermissionSetting.Enum r140 = r100.mchat_tab_permission_setting;
            if (r140 == null) goto L57;
            int r141 = ChatTabPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            ChatDisplayModeSetting.Enum r143 = r100.mchat_display_mode_setting;
            if (r143 == null) goto L61;
            int r144 = ChatDisplayModeSetting.Enum.ADAPTER.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            AdminPostSetting.Enum r146 = r100.madmin_post_setting;
            if (r146 == null) goto L65;
            int r147 = AdminPostSetting.Enum.ADAPTER.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            ChatPinPermissionSetting.Enum r149 = r100.mchat_pin_permission_setting;
            if (r149 == null) goto L69;
            int r150 = ChatPinPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            UserCountVisibleSetting.Enum r152 = r100.muser_count_visible_setting;
            if (r152 == null) goto L74;
            r102 = UserCountVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(18, r152);
        L74:
            return (r151 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ChatEntitySetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatEntitySetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatEntitySetting r101) throws IOException {
            AddMemberPermissionSetting.Enum r102 = r101.madd_member_permission_setting;
            if (r102 == null) goto L5;
            AddMemberPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            AtAllPermissionSetting.Enum r103 = r101.mat_all_permission_setting;
            if (r103 == null) goto L8;
            AtAllPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            SystemMessageVisibleSetting.Enum r104 = r101.mjoin_message_visible_setting;
            if (r104 == null) goto L11;
            SystemMessageVisibleSetting.Enum.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            SystemMessageVisibleSetting.Enum r105 = r101.mquit_message_visible_setting;
            if (r105 == null) goto L14;
            SystemMessageVisibleSetting.Enum.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ShareCardPermissionSetting.Enum r106 = r101.mshare_card_permission_setting;
            if (r106 == null) goto L17;
            ShareCardPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            AddMemberApplySetting.Enum r107 = r101.madd_member_apply_setting;
            if (r107 == null) goto L20;
            AddMemberApplySetting.Enum.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            ThreadAnonymousSetting.Enum r108 = r101.mthread_anonymous_setting;
            if (r108 == null) goto L23;
            ThreadAnonymousSetting.Enum.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            MessageVisibilitySetting.Enum r109 = r101.mmessage_visibility_setting;
            if (r109 == null) goto L26;
            MessageVisibilitySetting.Enum.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            AnonymousSetting r110 = r101.manonymous_setting;
            if (r110 == null) goto L29;
            AnonymousSetting.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            CreateUrgentSetting.Enum r111 = r101.mcreate_urgent_setting;
            if (r111 == null) goto L32;
            CreateUrgentSetting.Enum.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            CreateVideoConferenceSetting.Enum r112 = r101.mcreate_video_conference_setting;
            if (r112 == null) goto L35;
            CreateVideoConferenceSetting.Enum.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            PinPermissionSetting.Enum r113 = r101.mpin_permission_setting;
            if (r113 == null) goto L38;
            PinPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            TopNoticePermissionSetting.Enum r114 = r101.mtop_notice_permission_setting;
            if (r114 == null) goto L41;
            TopNoticePermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            ChatTabPermissionSetting.Enum r115 = r101.mchat_tab_permission_setting;
            if (r115 == null) goto L44;
            ChatTabPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 14, r115);
        L44:
            ChatDisplayModeSetting.Enum r116 = r101.mchat_display_mode_setting;
            if (r116 == null) goto L47;
            ChatDisplayModeSetting.Enum.ADAPTER.encodeWithTag(r100, 15, r116);
        L47:
            AdminPostSetting.Enum r117 = r101.madmin_post_setting;
            if (r117 == null) goto L50;
            AdminPostSetting.Enum.ADAPTER.encodeWithTag(r100, 16, r117);
        L50:
            ChatPinPermissionSetting.Enum r118 = r101.mchat_pin_permission_setting;
            if (r118 == null) goto L53;
            ChatPinPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 17, r118);
        L53:
            UserCountVisibleSetting.Enum r119 = r101.muser_count_visible_setting;
            if (r119 == null) goto L56;
            UserCountVisibleSetting.Enum.ADAPTER.encodeWithTag(r100, 18, r119);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatEntitySetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ShareCardPermissionSetting extends com.squareup.wire.Message<ShareCardPermissionSetting, Builder> {
        public static final ProtoAdapter<ShareCardPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShareCardPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ShareCardPermissionSetting build() {
                return new ShareCardPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALLOWED", 1, 1);
                ALLOWED = r101;
                Enum r102 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return NOT_ALLOWED;
            L12:
                return ALLOWED;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ShareCardPermissionSetting extends ProtoAdapter<ShareCardPermissionSetting> {
            public ProtoAdapter_ShareCardPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareCardPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShareCardPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ShareCardPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShareCardPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShareCardPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShareCardPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareCardPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareCardPermissionSetting();
        }

        public ShareCardPermissionSetting() {
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
            return ShareCardPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShareCardPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class SystemMessageVisibleSetting extends com.squareup.wire.Message<SystemMessageVisibleSetting, Builder> {
        public static final ProtoAdapter<SystemMessageVisibleSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<SystemMessageVisibleSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public SystemMessageVisibleSetting build() {
                return new SystemMessageVisibleSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum NOT_ANYONE = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ONLY_OWNER", 1, 1);
                ONLY_OWNER = r101;
                Enum r102 = new Enum("ALL_MEMBERS", 2, 2);
                ALL_MEMBERS = r102;
                Enum r103 = new Enum("NOT_ANYONE", 3, 3);
                NOT_ANYONE = r103;
                $VALUES = new Enum[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return NOT_ANYONE;
            L14:
                return ALL_MEMBERS;
            L16:
                return ONLY_OWNER;
            L18:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_SystemMessageVisibleSetting extends ProtoAdapter<SystemMessageVisibleSetting> {
            public ProtoAdapter_SystemMessageVisibleSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, SystemMessageVisibleSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SystemMessageVisibleSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(SystemMessageVisibleSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SystemMessageVisibleSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SystemMessageVisibleSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SystemMessageVisibleSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemMessageVisibleSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SystemMessageVisibleSetting();
        }

        public SystemMessageVisibleSetting() {
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
            return SystemMessageVisibleSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SystemMessageVisibleSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ThreadAnonymousSetting extends com.squareup.wire.Message<ThreadAnonymousSetting, Builder> {
        public static final ProtoAdapter<ThreadAnonymousSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ThreadAnonymousSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ThreadAnonymousSetting build() {
                return new ThreadAnonymousSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final Enum INVISIBLE = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("INVISIBLE", 1, 1);
                INVISIBLE = r101;
                Enum r102 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r102;
                Enum r103 = new Enum("ALLOWED", 3, 3);
                ALLOWED = r103;
                $VALUES = new Enum[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return ALLOWED;
            L14:
                return NOT_ALLOWED;
            L16:
                return INVISIBLE;
            L18:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ThreadAnonymousSetting extends ProtoAdapter<ThreadAnonymousSetting> {
            public ProtoAdapter_ThreadAnonymousSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ThreadAnonymousSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThreadAnonymousSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ThreadAnonymousSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThreadAnonymousSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThreadAnonymousSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThreadAnonymousSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadAnonymousSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThreadAnonymousSetting();
        }

        public ThreadAnonymousSetting() {
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
            return ThreadAnonymousSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThreadAnonymousSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class TopNoticePermissionSetting extends com.squareup.wire.Message<TopNoticePermissionSetting, Builder> {
        public static final ProtoAdapter<TopNoticePermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<TopNoticePermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public TopNoticePermissionSetting build() {
                return new TopNoticePermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_TopNoticePermissionSetting extends ProtoAdapter<TopNoticePermissionSetting> {
            public ProtoAdapter_TopNoticePermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, TopNoticePermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TopNoticePermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(TopNoticePermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TopNoticePermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TopNoticePermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TopNoticePermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TopNoticePermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TopNoticePermissionSetting();
        }

        public TopNoticePermissionSetting() {
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
            return TopNoticePermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TopNoticePermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class UserCountVisibleSetting extends com.squareup.wire.Message<UserCountVisibleSetting, Builder> {
        public static final ProtoAdapter<UserCountVisibleSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<UserCountVisibleSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public UserCountVisibleSetting build() {
                return new UserCountVisibleSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Enum[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) a.a(Enum.class, r100);
            }

            private Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_UserCountVisibleSetting extends ProtoAdapter<UserCountVisibleSetting> {
            public ProtoAdapter_UserCountVisibleSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, UserCountVisibleSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserCountVisibleSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(UserCountVisibleSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UserCountVisibleSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserCountVisibleSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserCountVisibleSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserCountVisibleSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserCountVisibleSetting();
        }

        public UserCountVisibleSetting() {
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
            return UserCountVisibleSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserCountVisibleSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatEntitySetting();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.madd_member_permission_setting = this.madd_member_permission_setting;
        r100.mat_all_permission_setting = this.mat_all_permission_setting;
        r100.mjoin_message_visible_setting = this.mjoin_message_visible_setting;
        r100.mquit_message_visible_setting = this.mquit_message_visible_setting;
        r100.mshare_card_permission_setting = this.mshare_card_permission_setting;
        r100.madd_member_apply_setting = this.madd_member_apply_setting;
        r100.mthread_anonymous_setting = this.mthread_anonymous_setting;
        r100.mmessage_visibility_setting = this.mmessage_visibility_setting;
        r100.manonymous_setting = this.manonymous_setting;
        r100.mcreate_urgent_setting = this.mcreate_urgent_setting;
        r100.mcreate_video_conference_setting = this.mcreate_video_conference_setting;
        r100.mpin_permission_setting = this.mpin_permission_setting;
        r100.mtop_notice_permission_setting = this.mtop_notice_permission_setting;
        r100.mchat_tab_permission_setting = this.mchat_tab_permission_setting;
        r100.mchat_display_mode_setting = this.mchat_display_mode_setting;
        r100.madmin_post_setting = this.madmin_post_setting;
        r100.mchat_pin_permission_setting = this.mchat_pin_permission_setting;
        r100.muser_count_visible_setting = this.muser_count_visible_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatEntitySetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatEntitySetting(AddMemberPermissionSetting.Enum r210, AtAllPermissionSetting.Enum r211, SystemMessageVisibleSetting.Enum r212, SystemMessageVisibleSetting.Enum r213, ShareCardPermissionSetting.Enum r214, AddMemberApplySetting.Enum r215, ThreadAnonymousSetting.Enum r216, MessageVisibilitySetting.Enum r217, AnonymousSetting r218, CreateUrgentSetting.Enum r310, CreateVideoConferenceSetting.Enum r311, PinPermissionSetting.Enum r312, TopNoticePermissionSetting.Enum r313, ChatTabPermissionSetting.Enum r314, ChatDisplayModeSetting.Enum r315, AdminPostSetting.Enum r316, ChatPinPermissionSetting.Enum r317, UserCountVisibleSetting.Enum r318) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, ByteString.EMPTY);
    }

    public ChatEntitySetting(AddMemberPermissionSetting.Enum r100, AtAllPermissionSetting.Enum r101, SystemMessageVisibleSetting.Enum r102, SystemMessageVisibleSetting.Enum r103, ShareCardPermissionSetting.Enum r104, AddMemberApplySetting.Enum r105, ThreadAnonymousSetting.Enum r110, MessageVisibilitySetting.Enum r111, AnonymousSetting r112, CreateUrgentSetting.Enum r113, CreateVideoConferenceSetting.Enum r114, PinPermissionSetting.Enum r115, TopNoticePermissionSetting.Enum r116, ChatTabPermissionSetting.Enum r117, ChatDisplayModeSetting.Enum r118, AdminPostSetting.Enum r119, ChatPinPermissionSetting.Enum r210, UserCountVisibleSetting.Enum r211, ByteString r212) {
        super(ADAPTER, r212);
        this.madd_member_permission_setting = r100;
        this.mat_all_permission_setting = r101;
        this.mjoin_message_visible_setting = r102;
        this.mquit_message_visible_setting = r103;
        this.mshare_card_permission_setting = r104;
        this.madd_member_apply_setting = r105;
        this.mthread_anonymous_setting = r110;
        this.mmessage_visibility_setting = r111;
        this.manonymous_setting = r112;
        this.mcreate_urgent_setting = r113;
        this.mcreate_video_conference_setting = r114;
        this.mpin_permission_setting = r115;
        this.mtop_notice_permission_setting = r116;
        this.mchat_tab_permission_setting = r117;
        this.mchat_display_mode_setting = r118;
        this.madmin_post_setting = r119;
        this.mchat_pin_permission_setting = r210;
        this.muser_count_visible_setting = r211;
    }
}
