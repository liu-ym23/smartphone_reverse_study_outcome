package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class GeneralChatSetting extends com.squareup.wire.Message<GeneralChatSetting, Builder> {
    public static final ProtoAdapter<GeneralChatSetting> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DefDisplaySetting mdef_display_setting;
    public final DoubaoSetting mdoubao_setting;
    public final RestrictedModePermissionSetting mrestricted_mode_permission_setting;

    public static final class Builder extends com.squareup.wire.Message.Builder<GeneralChatSetting, Builder> {
        public DefDisplaySetting mdef_display_setting;
        public DoubaoSetting mdoubao_setting;
        public RestrictedModePermissionSetting mrestricted_mode_permission_setting;

        @Override // com.squareup.wire.Message.Builder
        public GeneralChatSetting build() {
            return new GeneralChatSetting(this.mrestricted_mode_permission_setting, this.mdef_display_setting, this.mdoubao_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder def_display_setting(DefDisplaySetting r100) {
            this.mdef_display_setting = r100;
            return this;
        }

        public Builder doubao_setting(DoubaoSetting r100) {
            this.mdoubao_setting = r100;
            return this;
        }

        public Builder restricted_mode_permission_setting(RestrictedModePermissionSetting r100) {
            this.mrestricted_mode_permission_setting = r100;
            return this;
        }
    }

    public static final class CopyPermissionSetting extends com.squareup.wire.Message<CopyPermissionSetting, Builder> {
        public static final ProtoAdapter<CopyPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CopyPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public CopyPermissionSetting build() {
                return new CopyPermissionSetting(super.buildUnknownFields());
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
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_CopyPermissionSetting extends ProtoAdapter<CopyPermissionSetting> {
            public ProtoAdapter_CopyPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CopyPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CopyPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(CopyPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CopyPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CopyPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CopyPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CopyPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CopyPermissionSetting();
        }

        public CopyPermissionSetting() {
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
            return CopyPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CopyPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class DoubaoSetting extends com.squareup.wire.Message<DoubaoSetting, Builder> {
        public static final ProtoAdapter<DoubaoSetting> ADAPTER = null;
        public static final Boolean DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = null;
        public static final Boolean DEFAULT_DOUBAO_USING_ENABLED = null;
        private static final long serialVersionUID = 0;
        public final Boolean mdoubao_proactive_reply_enabled;
        public final Boolean mdoubao_using_enabled;

        public static final class Builder extends com.squareup.wire.Message.Builder<DoubaoSetting, Builder> {
            public Boolean mdoubao_proactive_reply_enabled;
            public Boolean mdoubao_using_enabled;

            @Override // com.squareup.wire.Message.Builder
            public DoubaoSetting build() {
                return new DoubaoSetting(this.mdoubao_using_enabled, this.mdoubao_proactive_reply_enabled, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder doubao_proactive_reply_enabled(Boolean r100) {
                this.mdoubao_proactive_reply_enabled = r100;
                return this;
            }

            public Builder doubao_using_enabled(Boolean r100) {
                this.mdoubao_using_enabled = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DoubaoSetting extends ProtoAdapter<DoubaoSetting> {
            public ProtoAdapter_DoubaoSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, DoubaoSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DoubaoSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mdoubao_using_enabled = Boolean.TRUE;
                r101.mdoubao_proactive_reply_enabled = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mdoubao_using_enabled = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mdoubao_proactive_reply_enabled = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(DoubaoSetting r100) {
                Boolean r101 = r100.mdoubao_using_enabled;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mdoubao_proactive_reply_enabled;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DoubaoSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DoubaoSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DoubaoSetting r101) throws IOException {
                Boolean r102 = r101.mdoubao_using_enabled;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mdoubao_proactive_reply_enabled;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DoubaoSetting();
            DEFAULT_DOUBAO_USING_ENABLED = Boolean.TRUE;
            DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mdoubao_using_enabled = this.mdoubao_using_enabled;
            r100.mdoubao_proactive_reply_enabled = this.mdoubao_proactive_reply_enabled;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DoubaoSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DoubaoSetting(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DoubaoSetting(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mdoubao_using_enabled = r100;
            this.mdoubao_proactive_reply_enabled = r101;
        }
    }

    public static final class DownloadPermissionSetting extends com.squareup.wire.Message<DownloadPermissionSetting, Builder> {
        public static final ProtoAdapter<DownloadPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DownloadPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public DownloadPermissionSetting build() {
                return new DownloadPermissionSetting(super.buildUnknownFields());
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
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_DownloadPermissionSetting extends ProtoAdapter<DownloadPermissionSetting> {
            public ProtoAdapter_DownloadPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, DownloadPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DownloadPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(DownloadPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DownloadPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DownloadPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DownloadPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DownloadPermissionSetting();
        }

        public DownloadPermissionSetting() {
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
            return DownloadPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DownloadPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final enum Field extends Enum<Field> implements WireEnum {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Field COPY_PERMISSION_SETTING = null;
        public static final Field DEF_DISPLAY_SETTING = null;
        public static final Field DOUBAO_SETTING_DOUBAO_ENABLE = null;
        public static final Field DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE = null;
        public static final Field DOWNLOAD_PERMISSION_SETTING = null;
        public static final Field FORWARD_PERMISSION_SETTING = null;
        public static final Field ON_TIME_DEL_MSG_SETTING_ALIVE_TIME = null;
        public static final Field ON_TIME_DEL_MSG_SETTING_STATUS = null;
        public static final Field RESTRICTED_MODE_PERMISSION_SETTING = null;
        public static final Field SCREENSHOT_PERNISSION_SETTING = null;
        public static final Field UNKNOWN = null;
        public static final Field WHITE_LIST_SETTING_LEVEL = null;
        public static final Field WHITE_LIST_SETTING_USERS = null;
        private final int value;

        static {
            Field r100 = new Field("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Field r101 = new Field("RESTRICTED_MODE_PERMISSION_SETTING", 1, 1);
            RESTRICTED_MODE_PERMISSION_SETTING = r101;
            Field r102 = new Field("FORWARD_PERMISSION_SETTING", 2, 2);
            FORWARD_PERMISSION_SETTING = r102;
            Field r103 = new Field("COPY_PERMISSION_SETTING", 3, 3);
            COPY_PERMISSION_SETTING = r103;
            Field r104 = new Field("DOWNLOAD_PERMISSION_SETTING", 4, 4);
            DOWNLOAD_PERMISSION_SETTING = r104;
            Field r105 = new Field("SCREENSHOT_PERNISSION_SETTING", 5, 5);
            SCREENSHOT_PERNISSION_SETTING = r105;
            Field r110 = new Field("DEF_DISPLAY_SETTING", 6, 6);
            DEF_DISPLAY_SETTING = r110;
            Field r111 = new Field("ON_TIME_DEL_MSG_SETTING_STATUS", 7, 7);
            ON_TIME_DEL_MSG_SETTING_STATUS = r111;
            Field r112 = new Field("ON_TIME_DEL_MSG_SETTING_ALIVE_TIME", 8, 8);
            ON_TIME_DEL_MSG_SETTING_ALIVE_TIME = r112;
            Field r113 = new Field("WHITE_LIST_SETTING_LEVEL", 9, 9);
            WHITE_LIST_SETTING_LEVEL = r113;
            Field r114 = new Field("WHITE_LIST_SETTING_USERS", 10, 10);
            WHITE_LIST_SETTING_USERS = r114;
            Field r115 = new Field("DOUBAO_SETTING_DOUBAO_ENABLE", 11, 11);
            DOUBAO_SETTING_DOUBAO_ENABLE = r115;
            Field r106 = new Field("DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE", 12, 12);
            DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE = r106;
            $VALUES = new Field[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
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
                case 0: goto L30;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L14;
                case 9: goto L12;
                case 10: goto L10;
                case 11: goto L8;
                case 12: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE;
        L8:
            return DOUBAO_SETTING_DOUBAO_ENABLE;
        L10:
            return WHITE_LIST_SETTING_USERS;
        L12:
            return WHITE_LIST_SETTING_LEVEL;
        L14:
            return ON_TIME_DEL_MSG_SETTING_ALIVE_TIME;
        L16:
            return ON_TIME_DEL_MSG_SETTING_STATUS;
        L18:
            return DEF_DISPLAY_SETTING;
        L20:
            return SCREENSHOT_PERNISSION_SETTING;
        L22:
            return DOWNLOAD_PERMISSION_SETTING;
        L24:
            return COPY_PERMISSION_SETTING;
        L26:
            return FORWARD_PERMISSION_SETTING;
        L28:
            return RESTRICTED_MODE_PERMISSION_SETTING;
        L30:
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

    public static final class ForwardPermissionSetting extends com.squareup.wire.Message<ForwardPermissionSetting, Builder> {
        public static final ProtoAdapter<ForwardPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ForwardPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ForwardPermissionSetting build() {
                return new ForwardPermissionSetting(super.buildUnknownFields());
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
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_ForwardPermissionSetting extends ProtoAdapter<ForwardPermissionSetting> {
            public ProtoAdapter_ForwardPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ForwardPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ForwardPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ForwardPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ForwardPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ForwardPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ForwardPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ForwardPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ForwardPermissionSetting();
        }

        public ForwardPermissionSetting() {
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
            return ForwardPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ForwardPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class OnTimeDelMsgPermissionSetting extends com.squareup.wire.Message<OnTimeDelMsgPermissionSetting, Builder> {
        public static final ProtoAdapter<OnTimeDelMsgPermissionSetting> ADAPTER = null;
        public static final Long DEFAULT_ALIVE_TIME = null;
        public static final Boolean DEFAULT_STATUS = null;
        private static final long serialVersionUID = 0;
        public final Long malive_time;
        public final Boolean mstatus;

        public static final class Builder extends com.squareup.wire.Message.Builder<OnTimeDelMsgPermissionSetting, Builder> {
            public Long malive_time;
            public Boolean mstatus;

            @Override // com.squareup.wire.Message.Builder
            public OnTimeDelMsgPermissionSetting build() {
                return new OnTimeDelMsgPermissionSetting(this.mstatus, this.malive_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder alive_time(Long r100) {
                this.malive_time = r100;
                return this;
            }

            public Builder status(Boolean r100) {
                this.mstatus = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OnTimeDelMsgPermissionSetting extends ProtoAdapter<OnTimeDelMsgPermissionSetting> {
            public ProtoAdapter_OnTimeDelMsgPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, OnTimeDelMsgPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnTimeDelMsgPermissionSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mstatus = Boolean.FALSE;
                r101.malive_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mstatus = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.malive_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(OnTimeDelMsgPermissionSetting r100) {
                Boolean r101 = r100.mstatus;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.malive_time;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OnTimeDelMsgPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnTimeDelMsgPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnTimeDelMsgPermissionSetting r101) throws IOException {
                Boolean r102 = r101.mstatus;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.malive_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnTimeDelMsgPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnTimeDelMsgPermissionSetting();
            DEFAULT_STATUS = Boolean.FALSE;
            DEFAULT_ALIVE_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mstatus = this.mstatus;
            r100.malive_time = this.malive_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnTimeDelMsgPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnTimeDelMsgPermissionSetting(Boolean r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OnTimeDelMsgPermissionSetting(Boolean r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mstatus = r100;
            this.malive_time = r101;
        }
    }

    public static final class ProtoAdapter_GeneralChatSetting extends ProtoAdapter<GeneralChatSetting> {
        public ProtoAdapter_GeneralChatSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, GeneralChatSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GeneralChatSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mrestricted_mode_permission_setting = RestrictedModePermissionSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mdef_display_setting = DefDisplaySetting.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mdoubao_setting = DoubaoSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(GeneralChatSetting r100) {
            RestrictedModePermissionSetting r101 = r100.mrestricted_mode_permission_setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RestrictedModePermissionSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DefDisplaySetting r104 = r100.mdef_display_setting;
            if (r104 == null) goto L9;
            int r105 = DefDisplaySetting.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            DoubaoSetting r107 = r100.mdoubao_setting;
            if (r107 == null) goto L14;
            r102 = DoubaoSetting.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GeneralChatSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GeneralChatSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GeneralChatSetting r101) throws IOException {
            RestrictedModePermissionSetting r102 = r101.mrestricted_mode_permission_setting;
            if (r102 == null) goto L5;
            RestrictedModePermissionSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DefDisplaySetting r103 = r101.mdef_display_setting;
            if (r103 == null) goto L8;
            DefDisplaySetting.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            DoubaoSetting r104 = r101.mdoubao_setting;
            if (r104 == null) goto L11;
            DoubaoSetting.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GeneralChatSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RestrictedModePermissionSetting extends com.squareup.wire.Message<RestrictedModePermissionSetting, Builder> {
        public static final ProtoAdapter<RestrictedModePermissionSetting> ADAPTER = null;
        public static final Boolean DEFAULT_STATUS = null;
        private static final long serialVersionUID = 0;
        public final CopyPermissionSetting.Enum mcopy_permission_setting;
        public final DownloadPermissionSetting.Enum mdownload_permission_setting;
        public final OnTimeDelMsgPermissionSetting mon_time_del_msg_permission_setting;
        public final ScreenshotPermissionSetting.Enum mscreenshot_permission_setting;
        public final Boolean mstatus;
        public final ForwardPermissionSetting.Enum mtransmit_permission_setting;
        public final WhiteListSetting mwhite_list_setting;

        public static final class Builder extends com.squareup.wire.Message.Builder<RestrictedModePermissionSetting, Builder> {
            public CopyPermissionSetting.Enum mcopy_permission_setting;
            public DownloadPermissionSetting.Enum mdownload_permission_setting;
            public OnTimeDelMsgPermissionSetting mon_time_del_msg_permission_setting;
            public ScreenshotPermissionSetting.Enum mscreenshot_permission_setting;
            public Boolean mstatus;
            public ForwardPermissionSetting.Enum mtransmit_permission_setting;
            public WhiteListSetting mwhite_list_setting;

            @Override // com.squareup.wire.Message.Builder
            public RestrictedModePermissionSetting build() {
                return new RestrictedModePermissionSetting(this.mstatus, this.mtransmit_permission_setting, this.mcopy_permission_setting, this.mdownload_permission_setting, this.mscreenshot_permission_setting, this.mon_time_del_msg_permission_setting, this.mwhite_list_setting, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder copy_permission_setting(CopyPermissionSetting.Enum r100) {
                this.mcopy_permission_setting = r100;
                return this;
            }

            public Builder download_permission_setting(DownloadPermissionSetting.Enum r100) {
                this.mdownload_permission_setting = r100;
                return this;
            }

            public Builder on_time_del_msg_permission_setting(OnTimeDelMsgPermissionSetting r100) {
                this.mon_time_del_msg_permission_setting = r100;
                return this;
            }

            public Builder screenshot_permission_setting(ScreenshotPermissionSetting.Enum r100) {
                this.mscreenshot_permission_setting = r100;
                return this;
            }

            public Builder status(Boolean r100) {
                this.mstatus = r100;
                return this;
            }

            public Builder transmit_permission_setting(ForwardPermissionSetting.Enum r100) {
                this.mtransmit_permission_setting = r100;
                return this;
            }

            public Builder white_list_setting(WhiteListSetting r100) {
                this.mwhite_list_setting = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RestrictedModePermissionSetting extends ProtoAdapter<RestrictedModePermissionSetting> {
            public ProtoAdapter_RestrictedModePermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, RestrictedModePermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RestrictedModePermissionSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mstatus = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L26;
                switch(r103) {
                    case 1: goto L25;
                    case 2: goto L30;
                    case 3: goto L32;
                    case 4: goto L28;
                    case 5: goto L34;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L28:
                r101.mdownload_permission_setting = DownloadPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r101.mtransmit_permission_setting = ForwardPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.mcopy_permission_setting = CopyPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L34:
                r101.mscreenshot_permission_setting = ScreenshotPermissionSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mwhite_list_setting = WhiteListSetting.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.mon_time_del_msg_permission_setting = OnTimeDelMsgPermissionSetting.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.mstatus = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(RestrictedModePermissionSetting r100) {
                Boolean r101 = r100.mstatus;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                ForwardPermissionSetting.Enum r104 = r100.mtransmit_permission_setting;
                if (r104 == null) goto L9;
                int r105 = ForwardPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                CopyPermissionSetting.Enum r107 = r100.mcopy_permission_setting;
                if (r107 == null) goto L13;
                int r108 = CopyPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                DownloadPermissionSetting.Enum r110 = r100.mdownload_permission_setting;
                if (r110 == null) goto L17;
                int r111 = DownloadPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ScreenshotPermissionSetting.Enum r113 = r100.mscreenshot_permission_setting;
                if (r113 == null) goto L21;
                int r114 = ScreenshotPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                OnTimeDelMsgPermissionSetting r116 = r100.mon_time_del_msg_permission_setting;
                if (r116 == null) goto L25;
                int r117 = OnTimeDelMsgPermissionSetting.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                WhiteListSetting r119 = r100.mwhite_list_setting;
                if (r119 == null) goto L30;
                r102 = WhiteListSetting.ADAPTER.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ RestrictedModePermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RestrictedModePermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RestrictedModePermissionSetting r101) throws IOException {
                Boolean r102 = r101.mstatus;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                ForwardPermissionSetting.Enum r103 = r101.mtransmit_permission_setting;
                if (r103 == null) goto L8;
                ForwardPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                CopyPermissionSetting.Enum r104 = r101.mcopy_permission_setting;
                if (r104 == null) goto L11;
                CopyPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                DownloadPermissionSetting.Enum r105 = r101.mdownload_permission_setting;
                if (r105 == null) goto L14;
                DownloadPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                ScreenshotPermissionSetting.Enum r106 = r101.mscreenshot_permission_setting;
                if (r106 == null) goto L17;
                ScreenshotPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                OnTimeDelMsgPermissionSetting r107 = r101.mon_time_del_msg_permission_setting;
                if (r107 == null) goto L20;
                OnTimeDelMsgPermissionSetting.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                WhiteListSetting r108 = r101.mwhite_list_setting;
                if (r108 == null) goto L23;
                WhiteListSetting.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RestrictedModePermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RestrictedModePermissionSetting();
            DEFAULT_STATUS = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mstatus = this.mstatus;
            r100.mtransmit_permission_setting = this.mtransmit_permission_setting;
            r100.mcopy_permission_setting = this.mcopy_permission_setting;
            r100.mdownload_permission_setting = this.mdownload_permission_setting;
            r100.mscreenshot_permission_setting = this.mscreenshot_permission_setting;
            r100.mon_time_del_msg_permission_setting = this.mon_time_del_msg_permission_setting;
            r100.mwhite_list_setting = this.mwhite_list_setting;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RestrictedModePermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public RestrictedModePermissionSetting(Boolean r110, ForwardPermissionSetting.Enum r111, CopyPermissionSetting.Enum r112, DownloadPermissionSetting.Enum r113, ScreenshotPermissionSetting.Enum r114, OnTimeDelMsgPermissionSetting r115, WhiteListSetting r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public RestrictedModePermissionSetting(Boolean r100, ForwardPermissionSetting.Enum r101, CopyPermissionSetting.Enum r102, DownloadPermissionSetting.Enum r103, ScreenshotPermissionSetting.Enum r104, OnTimeDelMsgPermissionSetting r105, WhiteListSetting r106, ByteString r107) {
            super(ADAPTER, r107);
            this.mstatus = r100;
            this.mtransmit_permission_setting = r101;
            this.mcopy_permission_setting = r102;
            this.mdownload_permission_setting = r103;
            this.mscreenshot_permission_setting = r104;
            this.mon_time_del_msg_permission_setting = r105;
            this.mwhite_list_setting = r106;
        }
    }

    public static final class ScreenshotPermissionSetting extends com.squareup.wire.Message<ScreenshotPermissionSetting, Builder> {
        public static final ProtoAdapter<ScreenshotPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ScreenshotPermissionSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ScreenshotPermissionSetting build() {
                return new ScreenshotPermissionSetting(super.buildUnknownFields());
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
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_ScreenshotPermissionSetting extends ProtoAdapter<ScreenshotPermissionSetting> {
            public ProtoAdapter_ScreenshotPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ScreenshotPermissionSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ScreenshotPermissionSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ScreenshotPermissionSetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ScreenshotPermissionSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ScreenshotPermissionSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ScreenshotPermissionSetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ScreenshotPermissionSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ScreenshotPermissionSetting();
        }

        public ScreenshotPermissionSetting() {
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
            return ScreenshotPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ScreenshotPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class WhiteListSetting extends com.squareup.wire.Message<WhiteListSetting, Builder> {
        public static final ProtoAdapter<WhiteListSetting> ADAPTER = null;
        public static final Boolean DEFAULT_HIT_WHITELIST = null;
        private static final long serialVersionUID = 0;
        public final List<Long> madd_user_ids;
        public final List<Long> mdel_user_ids;
        public final Boolean mhit_whitelist;
        public final LevelEnum mlevel;
        public final List<Long> muser_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<WhiteListSetting, Builder> {
            public List<Long> madd_user_ids;
            public List<Long> mdel_user_ids;
            public Boolean mhit_whitelist;
            public LevelEnum mlevel;
            public List<Long> muser_ids;

            @Override // com.squareup.wire.Message.Builder
            public WhiteListSetting build() {
                return new WhiteListSetting(this.mlevel, this.madd_user_ids, this.mdel_user_ids, this.muser_ids, this.mhit_whitelist, super.buildUnknownFields());
            }

            public Builder() {
                this.madd_user_ids = Internal.newMutableList();
                this.mdel_user_ids = Internal.newMutableList();
                this.muser_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder add_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.madd_user_ids = r100;
                return this;
            }

            public Builder del_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.mdel_user_ids = r100;
                return this;
            }

            public Builder hit_whitelist(Boolean r100) {
                this.mhit_whitelist = r100;
                return this;
            }

            public Builder level(LevelEnum r100) {
                this.mlevel = r100;
                return this;
            }

            public Builder user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.muser_ids = r100;
                return this;
            }
        }

        public static final enum LevelEnum extends Enum<LevelEnum> implements WireEnum {
            private static final /* synthetic */ LevelEnum[] $VALUES = null;
            public static final ProtoAdapter<LevelEnum> ADAPTER = null;
            public static final LevelEnum MEMBER_LIST = null;
            public static final LevelEnum NO_MEMBER = null;
            public static final LevelEnum ONLY_ADMIN_AND_OWNER = null;
            public static final LevelEnum UNKNOWN = null;
            private final int value;

            static {
                LevelEnum r100 = new LevelEnum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                LevelEnum r101 = new LevelEnum("NO_MEMBER", 1, 1);
                NO_MEMBER = r101;
                LevelEnum r102 = new LevelEnum("ONLY_ADMIN_AND_OWNER", 2, 2);
                ONLY_ADMIN_AND_OWNER = r102;
                LevelEnum r103 = new LevelEnum("MEMBER_LIST", 3, 3);
                MEMBER_LIST = r103;
                $VALUES = new LevelEnum[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(LevelEnum.class);
            }

            public static LevelEnum[] values() {
                return (LevelEnum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static LevelEnum fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return MEMBER_LIST;
            L14:
                return ONLY_ADMIN_AND_OWNER;
            L16:
                return NO_MEMBER;
            L18:
                return UNKNOWN;
            }

            public static LevelEnum valueOf(String r100) {
                return (LevelEnum) a.a(LevelEnum.class, r100);
            }

            private LevelEnum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_WhiteListSetting extends ProtoAdapter<WhiteListSetting> {
            public ProtoAdapter_WhiteListSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, WhiteListSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WhiteListSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mhit_whitelist = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.mlevel = LevelEnum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.madd_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mdel_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.muser_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.mhit_whitelist = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(WhiteListSetting r100) {
                LevelEnum r101 = r100.mlevel;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = LevelEnum.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
                int r105 = ((r103 + r104.asRepeated().encodedSizeWithTag(2, r100.madd_user_ids)) + r104.asRepeated().encodedSizeWithTag(3, r100.mdel_user_ids)) + r104.asRepeated().encodedSizeWithTag(4, r100.muser_ids);
                Boolean r106 = r100.mhit_whitelist;
                if (r106 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r106);
            L10:
                return (r105 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WhiteListSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WhiteListSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WhiteListSetting r101) throws IOException {
                LevelEnum r102 = r101.mlevel;
                if (r102 == null) goto L5;
                LevelEnum.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                r103.asRepeated().encodeWithTag(r100, 2, r101.madd_user_ids);
                r103.asRepeated().encodeWithTag(r100, 3, r101.mdel_user_ids);
                r103.asRepeated().encodeWithTag(r100, 4, r101.muser_ids);
                Boolean r104 = r101.mhit_whitelist;
                if (r104 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WhiteListSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WhiteListSetting();
            DEFAULT_HIT_WHITELIST = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlevel = this.mlevel;
            r100.madd_user_ids = Internal.copyOf("madd_user_ids", this.madd_user_ids);
            r100.mdel_user_ids = Internal.copyOf("mdel_user_ids", this.mdel_user_ids);
            r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r100.mhit_whitelist = this.mhit_whitelist;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WhiteListSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public WhiteListSetting(LevelEnum r100, List<Long> r101, List<Long> r110, List<Long> r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public WhiteListSetting(LevelEnum r100, List<Long> r101, List<Long> r102, List<Long> r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.mlevel = r100;
            this.madd_user_ids = Internal.immutableCopyOf("madd_user_ids", r101);
            this.mdel_user_ids = Internal.immutableCopyOf("mdel_user_ids", r102);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r103);
            this.mhit_whitelist = r104;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GeneralChatSetting();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mrestricted_mode_permission_setting = this.mrestricted_mode_permission_setting;
        r100.mdef_display_setting = this.mdef_display_setting;
        r100.mdoubao_setting = this.mdoubao_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GeneralChatSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public GeneralChatSetting(RestrictedModePermissionSetting r100, DefDisplaySetting r101, DoubaoSetting r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GeneralChatSetting(RestrictedModePermissionSetting r100, DefDisplaySetting r101, DoubaoSetting r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mrestricted_mode_permission_setting = r100;
        this.mdef_display_setting = r101;
        this.mdoubao_setting = r102;
    }
}
