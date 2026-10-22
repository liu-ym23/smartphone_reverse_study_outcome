package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.AppStatusInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AppMeta extends Message<AppMeta, Builder> {
    public static final ProtoAdapter<AppMeta> ADAPTER = null;
    public static final String DEFAULT_APP_STORE_URL = "";
    public static final String DEFAULT_APP_URL = "";
    public static final String DEFAULT_BOT_ID = "";
    public static final String DEFAULT_CLI_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_AVAILABLE = null;
    private static final long serialVersionUID = 0;
    public final List<AppStatusInfo.FeatureAbility> mapp_ability;
    public final AppExtTag mapp_ext_tag;
    public final List<AppShortcutEntity> mapp_shortcut_entities;
    public final String mapp_store_url;
    public final String mapp_url;
    public final String mbot_id;
    public final String mcli_id;
    public final String mid;
    public final Boolean mis_available;
    public final AppStatusInfo.AppUsageStatus mstatus;

    public static final class AppExtTag extends Message<AppExtTag, Builder> {
        public static final ProtoAdapter<AppExtTag> ADAPTER = null;
        public static final Boolean DEFAULT_IS_AGENT = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_agent;

        public static final class Builder extends Message.Builder<AppExtTag, Builder> {
            public Boolean mis_agent;

            @Override // com.squareup.wire.Message.Builder
            public AppExtTag build() {
                return new AppExtTag(this.mis_agent, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_agent(Boolean r100) {
                this.mis_agent = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AppExtTag extends ProtoAdapter<AppExtTag> {
            public ProtoAdapter_AppExtTag() {
                super(FieldEncoding.LENGTH_DELIMITED, AppExtTag.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AppExtTag decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mis_agent = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mis_agent = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(AppExtTag r100) {
                Boolean r101 = r100.mis_agent;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AppExtTag decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AppExtTag r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AppExtTag r101) throws IOException {
                Boolean r102 = r101.mis_agent;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppExtTag r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppExtTag();
            DEFAULT_IS_AGENT = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_agent = this.mis_agent;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AppExtTag.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AppExtTag(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public AppExtTag(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mis_agent = r100;
        }
    }

    public static final class AppShortcutEntity extends Message<AppShortcutEntity, Builder> {
        public static final ProtoAdapter<AppShortcutEntity> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<AppShortcutItem> mAndroidShortcutItems;
        public final List<AppShortcutItem> mIOSShortcutItems;
        public final List<AppShortcutItem> mPCShortcutItems;

        public static final class Builder extends Message.Builder<AppShortcutEntity, Builder> {
            public List<AppShortcutItem> mAndroidShortcutItems;
            public List<AppShortcutItem> mIOSShortcutItems;
            public List<AppShortcutItem> mPCShortcutItems;

            @Override // com.squareup.wire.Message.Builder
            public AppShortcutEntity build() {
                return new AppShortcutEntity(this.mPCShortcutItems, this.mIOSShortcutItems, this.mAndroidShortcutItems, super.buildUnknownFields());
            }

            public Builder() {
                this.mPCShortcutItems = Internal.newMutableList();
                this.mIOSShortcutItems = Internal.newMutableList();
                this.mAndroidShortcutItems = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder AndroidShortcutItems(List<AppShortcutItem> r100) {
                Internal.checkElementsNotNull(r100);
                this.mAndroidShortcutItems = r100;
                return this;
            }

            public Builder IOSShortcutItems(List<AppShortcutItem> r100) {
                Internal.checkElementsNotNull(r100);
                this.mIOSShortcutItems = r100;
                return this;
            }

            public Builder PCShortcutItems(List<AppShortcutItem> r100) {
                Internal.checkElementsNotNull(r100);
                this.mPCShortcutItems = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AppShortcutEntity extends ProtoAdapter<AppShortcutEntity> {
            public ProtoAdapter_AppShortcutEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, AppShortcutEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AppShortcutEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mPCShortcutItems.add(AppShortcutItem.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mIOSShortcutItems.add(AppShortcutItem.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mAndroidShortcutItems.add(AppShortcutItem.ADAPTER.decode(r100));
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
            public int encodedSize2(AppShortcutEntity r100) {
                ProtoAdapter<AppShortcutItem> r101 = AppShortcutItem.ADAPTER;
                return ((r101.asRepeated().encodedSizeWithTag(1, r100.mPCShortcutItems) + r101.asRepeated().encodedSizeWithTag(2, r100.mIOSShortcutItems)) + r101.asRepeated().encodedSizeWithTag(3, r100.mAndroidShortcutItems)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AppShortcutEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AppShortcutEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AppShortcutEntity r101) throws IOException {
                ProtoAdapter<AppShortcutItem> r102 = AppShortcutItem.ADAPTER;
                r102.asRepeated().encodeWithTag(r100, 1, r101.mPCShortcutItems);
                r102.asRepeated().encodeWithTag(r100, 2, r101.mIOSShortcutItems);
                r102.asRepeated().encodeWithTag(r100, 3, r101.mAndroidShortcutItems);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppShortcutEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppShortcutEntity();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mPCShortcutItems = Internal.copyOf("mPCShortcutItems", this.mPCShortcutItems);
            r100.mIOSShortcutItems = Internal.copyOf("mIOSShortcutItems", this.mIOSShortcutItems);
            r100.mAndroidShortcutItems = Internal.copyOf("mAndroidShortcutItems", this.mAndroidShortcutItems);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AppShortcutEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AppShortcutEntity(List<AppShortcutItem> r100, List<AppShortcutItem> r101, List<AppShortcutItem> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public AppShortcutEntity(List<AppShortcutItem> r100, List<AppShortcutItem> r101, List<AppShortcutItem> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mPCShortcutItems = Internal.immutableCopyOf("mPCShortcutItems", r100);
            this.mIOSShortcutItems = Internal.immutableCopyOf("mIOSShortcutItems", r101);
            this.mAndroidShortcutItems = Internal.immutableCopyOf("mAndroidShortcutItems", r102);
        }
    }

    public static final class AppShortcutItem extends Message<AppShortcutItem, Builder> {
        public static final ProtoAdapter<AppShortcutItem> ADAPTER = null;
        public static final String DEFAULT_APP_LINK = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mapp_link;
        public final String mname;

        public static final class Builder extends Message.Builder<AppShortcutItem, Builder> {
            public String mapp_link;
            public String mname;

            @Override // com.squareup.wire.Message.Builder
            public AppShortcutItem build() {
                String r100 = this.mname;
                if (r100 == null) goto L9;
                if (this.mapp_link == null) goto L9;
                return new AppShortcutItem(this.mname, this.mapp_link, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mname", this.mapp_link, "mapp_link"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder app_link(String r100) {
                this.mapp_link = r100;
                return this;
            }

            public Builder name(String r100) {
                this.mname = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AppShortcutItem extends ProtoAdapter<AppShortcutItem> {
            public ProtoAdapter_AppShortcutItem() {
                super(FieldEncoding.LENGTH_DELIMITED, AppShortcutItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AppShortcutItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mname = "";
                r101.mapp_link = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mname = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mapp_link = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AppShortcutItem r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.encodedSizeWithTag(1, r100.mname) + r101.encodedSizeWithTag(2, r100.mapp_link)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AppShortcutItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AppShortcutItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AppShortcutItem r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.mname);
                r102.encodeWithTag(r100, 2, r101.mapp_link);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppShortcutItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppShortcutItem();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mname = this.mname;
            r100.mapp_link = this.mapp_link;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AppShortcutItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AppShortcutItem(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AppShortcutItem(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mname = r100;
            this.mapp_link = r101;
        }
    }

    public static final class Builder extends Message.Builder<AppMeta, Builder> {
        public List<AppStatusInfo.FeatureAbility> mapp_ability;
        public AppExtTag mapp_ext_tag;
        public List<AppShortcutEntity> mapp_shortcut_entities;
        public String mapp_store_url;
        public String mapp_url;
        public String mbot_id;
        public String mcli_id;
        public String mid;
        public Boolean mis_available;
        public AppStatusInfo.AppUsageStatus mstatus;

        @Override // com.squareup.wire.Message.Builder
        public AppMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new AppMeta(this.mid, this.mapp_store_url, this.mis_available, this.mstatus, this.mapp_ability, this.mbot_id, this.mapp_url, this.mcli_id, this.mapp_shortcut_entities, this.mapp_ext_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mapp_ability = Internal.newMutableList();
            this.mapp_shortcut_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_ability(List<AppStatusInfo.FeatureAbility> r100) {
            Internal.checkElementsNotNull(r100);
            this.mapp_ability = r100;
            return this;
        }

        public Builder app_ext_tag(AppExtTag r100) {
            this.mapp_ext_tag = r100;
            return this;
        }

        public Builder app_shortcut_entities(List<AppShortcutEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.mapp_shortcut_entities = r100;
            return this;
        }

        public Builder app_store_url(String r100) {
            this.mapp_store_url = r100;
            return this;
        }

        public Builder app_url(String r100) {
            this.mapp_url = r100;
            return this;
        }

        public Builder bot_id(String r100) {
            this.mbot_id = r100;
            return this;
        }

        public Builder cli_id(String r100) {
            this.mcli_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_available(Boolean r100) {
            this.mis_available = r100;
            return this;
        }

        public Builder status(AppStatusInfo.AppUsageStatus r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppMeta extends ProtoAdapter<AppMeta> {
        public ProtoAdapter_AppMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, AppMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mapp_store_url = "";
            r101.mis_available = Boolean.FALSE;
            r101.mbot_id = "";
            r101.mapp_url = "";
            r101.mcli_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L25;
                case 5: goto L27;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L25:
            r101.mstatus = AppStatusInfo.AppUsageStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r101.mapp_ability.add(AppStatusInfo.FeatureAbility.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mapp_ext_tag = AppExtTag.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mapp_shortcut_entities.add(AppShortcutEntity.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.mcli_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mapp_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mbot_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.mis_available = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.mapp_store_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.mid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AppMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            String r103 = r100.mapp_store_url;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.mis_available;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            AppStatusInfo.AppUsageStatus r110 = r100.mstatus;
            if (r110 == null) goto L13;
            int r111 = AppStatusInfo.AppUsageStatus.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            int r112 = (r109 + r111) + AppStatusInfo.FeatureAbility.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mapp_ability);
            String r113 = r100.mbot_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.mapp_url;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mcli_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(8, r119);
        L26:
            int r121 = (r118 + r120) + AppShortcutEntity.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.mapp_shortcut_entities);
            AppExtTag r122 = r100.mapp_ext_tag;
            if (r122 == null) goto L30;
            r104 = AppExtTag.ADAPTER.encodedSizeWithTag(10, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ AppMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            String r103 = r101.mapp_store_url;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.mis_available;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            AppStatusInfo.AppUsageStatus r105 = r101.mstatus;
            if (r105 == null) goto L11;
            AppStatusInfo.AppUsageStatus.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            AppStatusInfo.FeatureAbility.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mapp_ability);
            String r106 = r101.mbot_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.mapp_url;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            String r108 = r101.mcli_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 8, r108);
        L20:
            AppShortcutEntity.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.mapp_shortcut_entities);
            AppExtTag r109 = r101.mapp_ext_tag;
            if (r109 == null) goto L23;
            AppExtTag.ADAPTER.encodeWithTag(r100, 10, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppMeta();
        DEFAULT_IS_AVAILABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mapp_store_url = this.mapp_store_url;
        r100.mis_available = this.mis_available;
        r100.mstatus = this.mstatus;
        r100.mapp_ability = Internal.copyOf("mapp_ability", this.mapp_ability);
        r100.mbot_id = this.mbot_id;
        r100.mapp_url = this.mapp_url;
        r100.mcli_id = this.mcli_id;
        r100.mapp_shortcut_entities = Internal.copyOf("mapp_shortcut_entities", this.mapp_shortcut_entities);
        r100.mapp_ext_tag = this.mapp_ext_tag;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppMeta(String r110, String r111, Boolean r112, AppStatusInfo.AppUsageStatus r113, List<AppStatusInfo.FeatureAbility> r114, String r115, String r116, String r210, List<AppShortcutEntity> r211, AppExtTag r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public AppMeta(String r100, String r101, Boolean r102, AppStatusInfo.AppUsageStatus r103, List<AppStatusInfo.FeatureAbility> r104, String r105, String r106, String r107, List<AppShortcutEntity> r110, AppExtTag r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mid = r100;
        this.mapp_store_url = r101;
        this.mis_available = r102;
        this.mstatus = r103;
        this.mapp_ability = Internal.immutableCopyOf("mapp_ability", r104);
        this.mbot_id = r105;
        this.mapp_url = r106;
        this.mcli_id = r107;
        this.mapp_shortcut_entities = Internal.immutableCopyOf("mapp_shortcut_entities", r110);
        this.mapp_ext_tag = r111;
    }
}
