package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.OpenApp;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AppMeta extends Message<AppMeta, Builder> {
    public static final ProtoAdapter<AppMeta> ADAPTER = null;
    public static final String DEFAULT_APP_STORE_URL = "";
    public static final String DEFAULT_APP_URL = "";
    public static final String DEFAULT_BOT_ID = "";
    public static final String DEFAULT_CLI_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_AVAILABLE = null;
    public static final OpenApp.State DEFAULT_STATE = null;
    private static final long serialVersionUID = 0;
    public final List<OpenApp.Ability> app_abilities;
    public final AppExtTag app_ext_tag;
    public final List<AppShortcutEntity> app_shortcut_entities;
    public final String app_store_url;
    public final String app_url;
    public final String bot_id;
    public final String cli_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253697id;
    public final Boolean is_available;
    public final OpenApp.State state;

    public static final class AppExtTag extends Message<AppExtTag, Builder> {
        public static final ProtoAdapter<AppExtTag> ADAPTER = null;
        public static final Boolean DEFAULT_IS_AGENT = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_agent;

        public static final class Builder extends Message.Builder<AppExtTag, Builder> {
            public Boolean is_agent;

            @Override // com.squareup.wire.Message.Builder
            public AppExtTag build() {
                return new AppExtTag(this.is_agent, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_agent(Boolean r100) {
                this.is_agent = r100;
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
                r101.is_agent = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.is_agent = ProtoAdapter.BOOL.decode(r100);
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
                Boolean r101 = r100.is_agent;
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
                Boolean r102 = r101.is_agent;
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
            r100.is_agent = this.is_agent;
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
            this.is_agent = r100;
        }
    }

    public static final class AppShortcut extends Message<AppShortcut, Builder> {
        public static final ProtoAdapter<AppShortcut> ADAPTER = null;
        public static final String DEFAULT_APP_LINK = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String app_link;
        public final String name;

        public static final class Builder extends Message.Builder<AppShortcut, Builder> {
            public String app_link;
            public String name;

            @Override // com.squareup.wire.Message.Builder
            public AppShortcut build() {
                String r100 = this.name;
                if (r100 == null) goto L9;
                if (this.app_link == null) goto L9;
                return new AppShortcut(this.name, this.app_link, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "name", this.app_link, "app_link"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder app_link(String r100) {
                this.app_link = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AppShortcut extends ProtoAdapter<AppShortcut> {
            public ProtoAdapter_AppShortcut() {
                super(FieldEncoding.LENGTH_DELIMITED, AppShortcut.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AppShortcut decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.name = "";
                r101.app_link = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.app_link = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AppShortcut r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.encodedSizeWithTag(1, r100.name) + r101.encodedSizeWithTag(2, r100.app_link)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AppShortcut decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AppShortcut r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AppShortcut r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.name);
                r102.encodeWithTag(r100, 2, r101.app_link);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppShortcut r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppShortcut();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.name = this.name;
            r100.app_link = this.app_link;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AppShortcut.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AppShortcut(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AppShortcut(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.name = r100;
            this.app_link = r101;
        }
    }

    public static final class AppShortcutEntity extends Message<AppShortcutEntity, Builder> {
        public static final ProtoAdapter<AppShortcutEntity> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<AppShortcut> android_items;
        public final List<AppShortcut> ios_items;
        public final List<AppShortcut> pc_items;

        public static final class Builder extends Message.Builder<AppShortcutEntity, Builder> {
            public List<AppShortcut> android_items;
            public List<AppShortcut> ios_items;
            public List<AppShortcut> pc_items;

            @Override // com.squareup.wire.Message.Builder
            public AppShortcutEntity build() {
                return new AppShortcutEntity(this.pc_items, this.ios_items, this.android_items, super.buildUnknownFields());
            }

            public Builder() {
                this.pc_items = Internal.newMutableList();
                this.ios_items = Internal.newMutableList();
                this.android_items = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder android_items(List<AppShortcut> r100) {
                Internal.checkElementsNotNull(r100);
                this.android_items = r100;
                return this;
            }

            public Builder ios_items(List<AppShortcut> r100) {
                Internal.checkElementsNotNull(r100);
                this.ios_items = r100;
                return this;
            }

            public Builder pc_items(List<AppShortcut> r100) {
                Internal.checkElementsNotNull(r100);
                this.pc_items = r100;
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
                r101.pc_items.add(AppShortcut.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.ios_items.add(AppShortcut.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.android_items.add(AppShortcut.ADAPTER.decode(r100));
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
                ProtoAdapter<AppShortcut> r101 = AppShortcut.ADAPTER;
                return ((r101.asRepeated().encodedSizeWithTag(1, r100.pc_items) + r101.asRepeated().encodedSizeWithTag(2, r100.ios_items)) + r101.asRepeated().encodedSizeWithTag(3, r100.android_items)) + r100.unknownFields().size();
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
                ProtoAdapter<AppShortcut> r102 = AppShortcut.ADAPTER;
                r102.asRepeated().encodeWithTag(r100, 1, r101.pc_items);
                r102.asRepeated().encodeWithTag(r100, 2, r101.ios_items);
                r102.asRepeated().encodeWithTag(r100, 3, r101.android_items);
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
            r100.pc_items = Internal.copyOf("pc_items", this.pc_items);
            r100.ios_items = Internal.copyOf("ios_items", this.ios_items);
            r100.android_items = Internal.copyOf("android_items", this.android_items);
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

        public AppShortcutEntity(List<AppShortcut> r100, List<AppShortcut> r101, List<AppShortcut> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public AppShortcutEntity(List<AppShortcut> r100, List<AppShortcut> r101, List<AppShortcut> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.pc_items = Internal.immutableCopyOf("pc_items", r100);
            this.ios_items = Internal.immutableCopyOf("ios_items", r101);
            this.android_items = Internal.immutableCopyOf("android_items", r102);
        }
    }

    public static final class Builder extends Message.Builder<AppMeta, Builder> {
        public List<OpenApp.Ability> app_abilities;
        public AppExtTag app_ext_tag;
        public List<AppShortcutEntity> app_shortcut_entities;
        public String app_store_url;
        public String app_url;
        public String bot_id;
        public String cli_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253698id;
        public Boolean is_available;
        public OpenApp.State state;

        @Override // com.squareup.wire.Message.Builder
        public AppMeta build() {
            String r100 = this.f253698id;
            if (r100 == null) goto L7;
            return new AppMeta(this.f253698id, this.app_store_url, this.is_available, this.state, this.app_abilities, this.bot_id, this.app_url, this.cli_id, this.app_shortcut_entities, this.app_ext_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.app_abilities = Internal.newMutableList();
            this.app_shortcut_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_abilities(List<OpenApp.Ability> r100) {
            Internal.checkElementsNotNull(r100);
            this.app_abilities = r100;
            return this;
        }

        public Builder app_ext_tag(AppExtTag r100) {
            this.app_ext_tag = r100;
            return this;
        }

        public Builder app_shortcut_entities(List<AppShortcutEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.app_shortcut_entities = r100;
            return this;
        }

        public Builder app_store_url(String r100) {
            this.app_store_url = r100;
            return this;
        }

        public Builder app_url(String r100) {
            this.app_url = r100;
            return this;
        }

        public Builder bot_id(String r100) {
            this.bot_id = r100;
            return this;
        }

        public Builder cli_id(String r100) {
            this.cli_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253698id = r100;
            return this;
        }

        public Builder is_available(Boolean r100) {
            this.is_available = r100;
            return this;
        }

        public Builder state(OpenApp.State r100) {
            this.state = r100;
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
            r101.f253698id = "";
            r101.app_store_url = "";
            r101.is_available = Boolean.FALSE;
            r101.state = OpenApp.State.USABLE;
            r101.bot_id = "";
            r101.app_url = "";
            r101.cli_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L29;
            if (r103 != 1) goto L8;
            r101.f253698id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.state = OpenApp.State.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 8) goto L11;
            r101.app_store_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            switch(r103) {
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L33;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L13;
                default: goto L12;
            };
        L33:
            r101.app_abilities.add(OpenApp.Ability.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.app_ext_tag = AppExtTag.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.cli_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.app_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.bot_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.app_shortcut_entities.add(AppShortcutEntity.ADAPTER.decode(r100));
            goto L3
        L22:
            r101.is_available = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253697id);
            String r103 = r100.app_store_url;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(8, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_available;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r107);
        L10:
            int r109 = r106 + r108;
            OpenApp.State r110 = r100.state;
            if (r110 == null) goto L13;
            int r111 = OpenApp.State.ADAPTER.encodedSizeWithTag(3, r110);
        L14:
            int r112 = (r109 + r111) + OpenApp.Ability.ADAPTER.asRepeated().encodedSizeWithTag(12, r100.app_abilities);
            String r113 = r100.bot_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(13, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.app_url;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(14, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.cli_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(15, r119);
        L26:
            int r121 = (r118 + r120) + AppShortcutEntity.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.app_shortcut_entities);
            AppExtTag r122 = r100.app_ext_tag;
            if (r122 == null) goto L30;
            r104 = AppExtTag.ADAPTER.encodedSizeWithTag(16, r122);
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
            r102.encodeWithTag(r100, 1, r101.f253697id);
            String r103 = r101.app_store_url;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 8, r103);
        L5:
            Boolean r104 = r101.is_available;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r104);
        L8:
            OpenApp.State r105 = r101.state;
            if (r105 == null) goto L11;
            OpenApp.State.ADAPTER.encodeWithTag(r100, 3, r105);
        L11:
            OpenApp.Ability.ADAPTER.asRepeated().encodeWithTag(r100, 12, r101.app_abilities);
            String r106 = r101.bot_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 13, r106);
        L14:
            String r107 = r101.app_url;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 14, r107);
        L17:
            String r108 = r101.cli_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 15, r108);
        L20:
            AppShortcutEntity.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.app_shortcut_entities);
            AppExtTag r109 = r101.app_ext_tag;
            if (r109 == null) goto L23;
            AppExtTag.ADAPTER.encodeWithTag(r100, 16, r109);
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
        DEFAULT_STATE = OpenApp.State.USABLE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253698id = this.f253697id;
        r100.app_store_url = this.app_store_url;
        r100.is_available = this.is_available;
        r100.state = this.state;
        r100.app_abilities = Internal.copyOf("app_abilities", this.app_abilities);
        r100.bot_id = this.bot_id;
        r100.app_url = this.app_url;
        r100.cli_id = this.cli_id;
        r100.app_shortcut_entities = Internal.copyOf("app_shortcut_entities", this.app_shortcut_entities);
        r100.app_ext_tag = this.app_ext_tag;
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

    public AppMeta(String r110, String r111, Boolean r112, OpenApp.State r113, List<OpenApp.Ability> r114, String r115, String r116, String r210, List<AppShortcutEntity> r211, AppExtTag r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public AppMeta(String r100, String r101, Boolean r102, OpenApp.State r103, List<OpenApp.Ability> r104, String r105, String r106, String r107, List<AppShortcutEntity> r110, AppExtTag r111, ByteString r112) {
        super(ADAPTER, r112);
        this.f253697id = r100;
        this.app_store_url = r101;
        this.is_available = r102;
        this.state = r103;
        this.app_abilities = Internal.immutableCopyOf("app_abilities", r104);
        this.bot_id = r105;
        this.app_url = r106;
        this.cli_id = r107;
        this.app_shortcut_entities = Internal.immutableCopyOf("app_shortcut_entities", r110);
        this.app_ext_tag = r111;
    }
}
