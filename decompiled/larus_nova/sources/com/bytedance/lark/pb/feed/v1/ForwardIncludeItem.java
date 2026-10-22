package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ForwardIncludeItem extends Message<ForwardIncludeItem, Builder> {
    public static final ProtoAdapter<ForwardIncludeItem> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<ForwardIncludeItem, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public ForwardIncludeItem build() {
            return new ForwardIncludeItem(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final enum GroupChatTypeCondition extends Enum<GroupChatTypeCondition> implements WireEnum {
        private static final /* synthetic */ GroupChatTypeCondition[] $VALUES = null;
        public static final ProtoAdapter<GroupChatTypeCondition> ADAPTER = null;
        public static final GroupChatTypeCondition ALL_CHAT = null;
        public static final GroupChatTypeCondition DEFAULT_CHAT = null;
        public static final GroupChatTypeCondition THREAD_CHAT = null;
        private final int value;

        static {
            GroupChatTypeCondition r100 = new GroupChatTypeCondition("ALL_CHAT", 0, 0);
            ALL_CHAT = r100;
            GroupChatTypeCondition r101 = new GroupChatTypeCondition("DEFAULT_CHAT", 1, 1);
            DEFAULT_CHAT = r101;
            GroupChatTypeCondition r102 = new GroupChatTypeCondition("THREAD_CHAT", 2, 2);
            THREAD_CHAT = r102;
            $VALUES = new GroupChatTypeCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(GroupChatTypeCondition.class);
        }

        public static GroupChatTypeCondition[] values() {
            return (GroupChatTypeCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static GroupChatTypeCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return THREAD_CHAT;
        L12:
            return DEFAULT_CHAT;
        L14:
            return ALL_CHAT;
        }

        public static GroupChatTypeCondition valueOf(String r100) {
            return (GroupChatTypeCondition) a.a(GroupChatTypeCondition.class, r100);
        }

        private GroupChatTypeCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class IncludeItem extends Message<IncludeItem, Builder> {
        public static final ProtoAdapter<IncludeItem> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_BOT_CONFIGS = null;
        public static final FieldOptions FIELD_OPTIONS_GROUP_CHAT_CONFIGS = null;
        public static final FieldOptions FIELD_OPTIONS_MY_AI_CONFIGS = null;
        public static final FieldOptions FIELD_OPTIONS_THREAD_CONFIGS = null;
        public static final FieldOptions FIELD_OPTIONS_USER_CONFIGS = null;
        private static final long serialVersionUID = 0;
        public final BotConfig bot_configs;
        public final GroupChatConfig group_chat_configs;
        public final MyAIConfig my_ai_configs;
        public final ThreadConfig thread_configs;
        public final UserConfig user_configs;

        public static final class BotConfig extends Message<BotConfig, Builder> {
            public static final ProtoAdapter<BotConfig> ADAPTER = null;
            private static final long serialVersionUID = 0;

            public static final class Builder extends Message.Builder<BotConfig, Builder> {
                @Override // com.squareup.wire.Message.Builder
                public BotConfig build() {
                    return new BotConfig(super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }
            }

            public static final class ProtoAdapter_BotConfig extends ProtoAdapter<BotConfig> {
                public ProtoAdapter_BotConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, BotConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public BotConfig decode(ProtoReader r100) throws IOException {
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
                public int encodedSize2(BotConfig r100) {
                    return r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ BotConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(BotConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, BotConfig r101) throws IOException {
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_BotConfig();
            }

            public BotConfig() {
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
                return BotConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public BotConfig(ByteString r100) {
                super(ADAPTER, r100);
            }
        }

        public static final class Builder extends Message.Builder<IncludeItem, Builder> {
            public BotConfig bot_configs;
            public GroupChatConfig group_chat_configs;
            public MyAIConfig my_ai_configs;
            public ThreadConfig thread_configs;
            public UserConfig user_configs;

            @Override // com.squareup.wire.Message.Builder
            public IncludeItem build() {
                return new IncludeItem(this.user_configs, this.group_chat_configs, this.bot_configs, this.thread_configs, this.my_ai_configs, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder bot_configs(BotConfig r100) {
                this.bot_configs = r100;
                this.user_configs = null;
                this.group_chat_configs = null;
                this.thread_configs = null;
                this.my_ai_configs = null;
                return this;
            }

            public Builder group_chat_configs(GroupChatConfig r100) {
                this.group_chat_configs = r100;
                this.user_configs = null;
                this.bot_configs = null;
                this.thread_configs = null;
                this.my_ai_configs = null;
                return this;
            }

            public Builder my_ai_configs(MyAIConfig r100) {
                this.my_ai_configs = r100;
                this.user_configs = null;
                this.group_chat_configs = null;
                this.bot_configs = null;
                this.thread_configs = null;
                return this;
            }

            public Builder thread_configs(ThreadConfig r100) {
                this.thread_configs = r100;
                this.user_configs = null;
                this.group_chat_configs = null;
                this.bot_configs = null;
                this.my_ai_configs = null;
                return this;
            }

            public Builder user_configs(UserConfig r100) {
                this.user_configs = r100;
                this.group_chat_configs = null;
                this.bot_configs = null;
                this.thread_configs = null;
                this.my_ai_configs = null;
                return this;
            }
        }

        public static final class GroupChatConfig extends Message<GroupChatConfig, Builder> {
            public static final ProtoAdapter<GroupChatConfig> ADAPTER = null;
            public static final GroupChatTypeCondition DEFAULT_GROUP_CHAT_TYPE_CONDITION = null;
            public static final PublicTypeCondition DEFAULT_PUBLIC_TYPE_CONDITION = null;
            public static final ShieldTypeCondition DEFAULT_SHIELD_TYPE_CONDITION = null;
            public static final TenantCondition DEFAULT_TENANT_CONDITION = null;
            private static final long serialVersionUID = 0;
            public final GroupChatTypeCondition group_chat_type_condition;
            public final PublicTypeCondition public_type_condition;
            public final ShieldTypeCondition shield_type_condition;
            public final TenantCondition tenant_condition;

            public static final class Builder extends Message.Builder<GroupChatConfig, Builder> {
                public GroupChatTypeCondition group_chat_type_condition;
                public PublicTypeCondition public_type_condition;
                public ShieldTypeCondition shield_type_condition;
                public TenantCondition tenant_condition;

                @Override // com.squareup.wire.Message.Builder
                public GroupChatConfig build() {
                    return new GroupChatConfig(this.tenant_condition, this.group_chat_type_condition, this.public_type_condition, this.shield_type_condition, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder group_chat_type_condition(GroupChatTypeCondition r100) {
                    this.group_chat_type_condition = r100;
                    return this;
                }

                public Builder public_type_condition(PublicTypeCondition r100) {
                    this.public_type_condition = r100;
                    return this;
                }

                public Builder shield_type_condition(ShieldTypeCondition r100) {
                    this.shield_type_condition = r100;
                    return this;
                }

                public Builder tenant_condition(TenantCondition r100) {
                    this.tenant_condition = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_GroupChatConfig extends ProtoAdapter<GroupChatConfig> {
                public ProtoAdapter_GroupChatConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, GroupChatConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public GroupChatConfig decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.tenant_condition = TenantCondition.ALL_TENANT;
                    r101.group_chat_type_condition = GroupChatTypeCondition.ALL_CHAT;
                    r101.public_type_condition = PublicTypeCondition.ALL_STATUS;
                    r101.shield_type_condition = ShieldTypeCondition.ALL;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L30;
                    if (r103 != 1) goto L8;
                    r101.tenant_condition = TenantCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
                L28:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.group_chat_type_condition = GroupChatTypeCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
                L24:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.public_type_condition = PublicTypeCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
                L20:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.shield_type_condition = ShieldTypeCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L30:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(GroupChatConfig r100) {
                    TenantCondition r101 = r100.tenant_condition;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = TenantCondition.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    GroupChatTypeCondition r104 = r100.group_chat_type_condition;
                    if (r104 == null) goto L9;
                    int r105 = GroupChatTypeCondition.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    PublicTypeCondition r107 = r100.public_type_condition;
                    if (r107 == null) goto L13;
                    int r108 = PublicTypeCondition.ADAPTER.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    ShieldTypeCondition r110 = r100.shield_type_condition;
                    if (r110 == null) goto L18;
                    r102 = ShieldTypeCondition.ADAPTER.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ GroupChatConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(GroupChatConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, GroupChatConfig r101) throws IOException {
                    TenantCondition r102 = r101.tenant_condition;
                    if (r102 == null) goto L5;
                    TenantCondition.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    GroupChatTypeCondition r103 = r101.group_chat_type_condition;
                    if (r103 == null) goto L8;
                    GroupChatTypeCondition.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    PublicTypeCondition r104 = r101.public_type_condition;
                    if (r104 == null) goto L11;
                    PublicTypeCondition.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    ShieldTypeCondition r105 = r101.shield_type_condition;
                    if (r105 == null) goto L14;
                    ShieldTypeCondition.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupChatConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_GroupChatConfig();
                DEFAULT_TENANT_CONDITION = TenantCondition.ALL_TENANT;
                DEFAULT_GROUP_CHAT_TYPE_CONDITION = GroupChatTypeCondition.ALL_CHAT;
                DEFAULT_PUBLIC_TYPE_CONDITION = PublicTypeCondition.ALL_STATUS;
                DEFAULT_SHIELD_TYPE_CONDITION = ShieldTypeCondition.ALL;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.tenant_condition = this.tenant_condition;
                r100.group_chat_type_condition = this.group_chat_type_condition;
                r100.public_type_condition = this.public_type_condition;
                r100.shield_type_condition = this.shield_type_condition;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return GroupChatConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public GroupChatConfig(TenantCondition r100, GroupChatTypeCondition r101, PublicTypeCondition r102, ShieldTypeCondition r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public GroupChatConfig(TenantCondition r100, GroupChatTypeCondition r101, PublicTypeCondition r102, ShieldTypeCondition r103, ByteString r104) {
                super(ADAPTER, r104);
                this.tenant_condition = r100;
                this.group_chat_type_condition = r101;
                this.public_type_condition = r102;
                this.shield_type_condition = r103;
            }
        }

        public static final class MyAIConfig extends Message<MyAIConfig, Builder> {
            public static final ProtoAdapter<MyAIConfig> ADAPTER = null;
            private static final long serialVersionUID = 0;

            public static final class Builder extends Message.Builder<MyAIConfig, Builder> {
                @Override // com.squareup.wire.Message.Builder
                public MyAIConfig build() {
                    return new MyAIConfig(super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }
            }

            public static final class ProtoAdapter_MyAIConfig extends ProtoAdapter<MyAIConfig> {
                public ProtoAdapter_MyAIConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, MyAIConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public MyAIConfig decode(ProtoReader r100) throws IOException {
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
                public int encodedSize2(MyAIConfig r100) {
                    return r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ MyAIConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(MyAIConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, MyAIConfig r101) throws IOException {
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MyAIConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_MyAIConfig();
            }

            public MyAIConfig() {
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
                return MyAIConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public MyAIConfig(ByteString r100) {
                super(ADAPTER, r100);
            }
        }

        public static final class ProtoAdapter_IncludeItem extends ProtoAdapter<IncludeItem> {
            public ProtoAdapter_IncludeItem() {
                super(FieldEncoding.LENGTH_DELIMITED, IncludeItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public IncludeItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.user_configs(UserConfig.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.group_chat_configs(GroupChatConfig.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.bot_configs(BotConfig.ADAPTER.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.thread_configs(ThreadConfig.ADAPTER.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.my_ai_configs(MyAIConfig.ADAPTER.decode(r100));
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
            public int encodedSize2(IncludeItem r100) {
                UserConfig r101 = r100.user_configs;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = UserConfig.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                GroupChatConfig r104 = r100.group_chat_configs;
                if (r104 == null) goto L9;
                int r105 = GroupChatConfig.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                BotConfig r107 = r100.bot_configs;
                if (r107 == null) goto L13;
                int r108 = BotConfig.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ThreadConfig r110 = r100.thread_configs;
                if (r110 == null) goto L17;
                int r111 = ThreadConfig.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                MyAIConfig r113 = r100.my_ai_configs;
                if (r113 == null) goto L22;
                r102 = MyAIConfig.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ IncludeItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(IncludeItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, IncludeItem r101) throws IOException {
                UserConfig r102 = r101.user_configs;
                if (r102 == null) goto L5;
                UserConfig.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                GroupChatConfig r103 = r101.group_chat_configs;
                if (r103 == null) goto L8;
                GroupChatConfig.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                BotConfig r104 = r101.bot_configs;
                if (r104 == null) goto L11;
                BotConfig.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ThreadConfig r105 = r101.thread_configs;
                if (r105 == null) goto L14;
                ThreadConfig.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                MyAIConfig r106 = r101.my_ai_configs;
                if (r106 == null) goto L17;
                MyAIConfig.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IncludeItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class ThreadConfig extends Message<ThreadConfig, Builder> {
            public static final ProtoAdapter<ThreadConfig> ADAPTER = null;
            public static final PublicTypeCondition DEFAULT_PUBLIC_TYPE_CONDITION = null;
            public static final TenantCondition DEFAULT_TENANT_CONDITION = null;
            public static final ThreadTypeCondition DEFAULT_THREAD_TYPE_CONDITION = null;
            private static final long serialVersionUID = 0;
            public final PublicTypeCondition public_type_condition;
            public final TenantCondition tenant_condition;
            public final ThreadTypeCondition thread_type_condition;

            public static final class Builder extends Message.Builder<ThreadConfig, Builder> {
                public PublicTypeCondition public_type_condition;
                public TenantCondition tenant_condition;
                public ThreadTypeCondition thread_type_condition;

                @Override // com.squareup.wire.Message.Builder
                public ThreadConfig build() {
                    return new ThreadConfig(this.tenant_condition, this.thread_type_condition, this.public_type_condition, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder public_type_condition(PublicTypeCondition r100) {
                    this.public_type_condition = r100;
                    return this;
                }

                public Builder tenant_condition(TenantCondition r100) {
                    this.tenant_condition = r100;
                    return this;
                }

                public Builder thread_type_condition(ThreadTypeCondition r100) {
                    this.thread_type_condition = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ThreadConfig extends ProtoAdapter<ThreadConfig> {
                public ProtoAdapter_ThreadConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, ThreadConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ThreadConfig decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.tenant_condition = TenantCondition.ALL_TENANT;
                    r101.thread_type_condition = ThreadTypeCondition.ALL_THREAD;
                    r101.public_type_condition = PublicTypeCondition.ALL_STATUS;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L24;
                    if (r103 != 1) goto L8;
                    r101.tenant_condition = TenantCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
                L22:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.thread_type_condition = ThreadTypeCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                L18:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.public_type_condition = PublicTypeCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
                L14:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L11:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L24:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(ThreadConfig r100) {
                    TenantCondition r101 = r100.tenant_condition;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = TenantCondition.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    ThreadTypeCondition r104 = r100.thread_type_condition;
                    if (r104 == null) goto L9;
                    int r105 = ThreadTypeCondition.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    PublicTypeCondition r107 = r100.public_type_condition;
                    if (r107 == null) goto L14;
                    r102 = PublicTypeCondition.ADAPTER.encodedSizeWithTag(3, r107);
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
                public /* bridge */ /* synthetic */ ThreadConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ThreadConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ThreadConfig r101) throws IOException {
                    TenantCondition r102 = r101.tenant_condition;
                    if (r102 == null) goto L5;
                    TenantCondition.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    ThreadTypeCondition r103 = r101.thread_type_condition;
                    if (r103 == null) goto L8;
                    ThreadTypeCondition.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    PublicTypeCondition r104 = r101.public_type_condition;
                    if (r104 == null) goto L11;
                    PublicTypeCondition.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ThreadConfig();
                DEFAULT_TENANT_CONDITION = TenantCondition.ALL_TENANT;
                DEFAULT_THREAD_TYPE_CONDITION = ThreadTypeCondition.ALL_THREAD;
                DEFAULT_PUBLIC_TYPE_CONDITION = PublicTypeCondition.ALL_STATUS;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.tenant_condition = this.tenant_condition;
                r100.thread_type_condition = this.thread_type_condition;
                r100.public_type_condition = this.public_type_condition;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ThreadConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public ThreadConfig(TenantCondition r100, ThreadTypeCondition r101, PublicTypeCondition r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public ThreadConfig(TenantCondition r100, ThreadTypeCondition r101, PublicTypeCondition r102, ByteString r103) {
                super(ADAPTER, r103);
                this.tenant_condition = r100;
                this.thread_type_condition = r101;
                this.public_type_condition = r102;
            }
        }

        public static final class UserConfig extends Message<UserConfig, Builder> {
            public static final ProtoAdapter<UserConfig> ADAPTER = null;
            public static final TalkedStatusCondition DEFAULT_TALKED_STATUS_CONDITION = null;
            public static final TenantCondition DEFAULT_TENANT_CONDITION = null;
            public static final UserTypeCondition DEFAULT_USER_TYPE_CONDITION = null;
            public static final WorkStatusCondition DEFAULT_WORK_STATUS_CONDITION = null;
            private static final long serialVersionUID = 0;
            public final TalkedStatusCondition talked_status_condition;
            public final TenantCondition tenant_condition;
            public final UserTypeCondition user_type_condition;
            public final WorkStatusCondition work_status_condition;

            public static final class Builder extends Message.Builder<UserConfig, Builder> {
                public TalkedStatusCondition talked_status_condition;
                public TenantCondition tenant_condition;
                public UserTypeCondition user_type_condition;
                public WorkStatusCondition work_status_condition;

                @Override // com.squareup.wire.Message.Builder
                public UserConfig build() {
                    return new UserConfig(this.tenant_condition, this.talked_status_condition, this.user_type_condition, this.work_status_condition, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder talked_status_condition(TalkedStatusCondition r100) {
                    this.talked_status_condition = r100;
                    return this;
                }

                public Builder tenant_condition(TenantCondition r100) {
                    this.tenant_condition = r100;
                    return this;
                }

                public Builder user_type_condition(UserTypeCondition r100) {
                    this.user_type_condition = r100;
                    return this;
                }

                public Builder work_status_condition(WorkStatusCondition r100) {
                    this.work_status_condition = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_UserConfig extends ProtoAdapter<UserConfig> {
                public ProtoAdapter_UserConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, UserConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public UserConfig decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.tenant_condition = TenantCondition.ALL_TENANT;
                    r101.talked_status_condition = TalkedStatusCondition.ALL_TALKED;
                    r101.user_type_condition = UserTypeCondition.ALL_USER;
                    r101.work_status_condition = WorkStatusCondition.ALL_RESIGNED;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L30;
                    if (r103 != 1) goto L8;
                    r101.tenant_condition = TenantCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
                L28:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.talked_status_condition = TalkedStatusCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
                L24:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.user_type_condition = UserTypeCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
                L20:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.work_status_condition = WorkStatusCondition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L30:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(UserConfig r100) {
                    TenantCondition r101 = r100.tenant_condition;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = TenantCondition.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    TalkedStatusCondition r104 = r100.talked_status_condition;
                    if (r104 == null) goto L9;
                    int r105 = TalkedStatusCondition.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    UserTypeCondition r107 = r100.user_type_condition;
                    if (r107 == null) goto L13;
                    int r108 = UserTypeCondition.ADAPTER.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    WorkStatusCondition r110 = r100.work_status_condition;
                    if (r110 == null) goto L18;
                    r102 = WorkStatusCondition.ADAPTER.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ UserConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(UserConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, UserConfig r101) throws IOException {
                    TenantCondition r102 = r101.tenant_condition;
                    if (r102 == null) goto L5;
                    TenantCondition.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    TalkedStatusCondition r103 = r101.talked_status_condition;
                    if (r103 == null) goto L8;
                    TalkedStatusCondition.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    UserTypeCondition r104 = r101.user_type_condition;
                    if (r104 == null) goto L11;
                    UserTypeCondition.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    WorkStatusCondition r105 = r101.work_status_condition;
                    if (r105 == null) goto L14;
                    WorkStatusCondition.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_UserConfig();
                DEFAULT_TENANT_CONDITION = TenantCondition.ALL_TENANT;
                DEFAULT_TALKED_STATUS_CONDITION = TalkedStatusCondition.ALL_TALKED;
                DEFAULT_USER_TYPE_CONDITION = UserTypeCondition.ALL_USER;
                DEFAULT_WORK_STATUS_CONDITION = WorkStatusCondition.ALL_RESIGNED;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.tenant_condition = this.tenant_condition;
                r100.talked_status_condition = this.talked_status_condition;
                r100.user_type_condition = this.user_type_condition;
                r100.work_status_condition = this.work_status_condition;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return UserConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public UserConfig(TenantCondition r100, TalkedStatusCondition r101, UserTypeCondition r102, WorkStatusCondition r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public UserConfig(TenantCondition r100, TalkedStatusCondition r101, UserTypeCondition r102, WorkStatusCondition r103, ByteString r104) {
                super(ADAPTER, r104);
                this.tenant_condition = r100;
                this.talked_status_condition = r101;
                this.user_type_condition = r102;
                this.work_status_condition = r103;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_IncludeItem();
            FIELD_OPTIONS_USER_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_GROUP_CHAT_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_BOT_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_THREAD_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_MY_AI_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_configs = this.user_configs;
            r100.group_chat_configs = this.group_chat_configs;
            r100.bot_configs = this.bot_configs;
            r100.thread_configs = this.thread_configs;
            r100.my_ai_configs = this.my_ai_configs;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return IncludeItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public IncludeItem(UserConfig r100, GroupChatConfig r101, BotConfig r110, ThreadConfig r111, MyAIConfig r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public IncludeItem(UserConfig r100, GroupChatConfig r101, BotConfig r102, ThreadConfig r103, MyAIConfig r104, ByteString r105) {
            super(ADAPTER, r105);
            if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104}) > 1) goto L7;
            this.user_configs = r100;
            this.group_chat_configs = r101;
            this.bot_configs = r102;
            this.thread_configs = r103;
            this.my_ai_configs = r104;
            return;
        L7:
            throw new IllegalArgumentException("at most one of user_configs, group_chat_configs, bot_configs, thread_configs, my_ai_configs may be non-null");
        }
    }

    public static final class ProtoAdapter_ForwardIncludeItem extends ProtoAdapter<ForwardIncludeItem> {
        public ProtoAdapter_ForwardIncludeItem() {
            super(FieldEncoding.LENGTH_DELIMITED, ForwardIncludeItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ForwardIncludeItem decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(ForwardIncludeItem r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ForwardIncludeItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ForwardIncludeItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ForwardIncludeItem r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ForwardIncludeItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum PublicTypeCondition extends Enum<PublicTypeCondition> implements WireEnum {
        private static final /* synthetic */ PublicTypeCondition[] $VALUES = null;
        public static final ProtoAdapter<PublicTypeCondition> ADAPTER = null;
        public static final PublicTypeCondition ALL_STATUS = null;
        public static final PublicTypeCondition PRIVATE = null;
        public static final PublicTypeCondition PUBLIC = null;
        private final int value;

        static {
            PublicTypeCondition r100 = new PublicTypeCondition("ALL_STATUS", 0, 0);
            ALL_STATUS = r100;
            PublicTypeCondition r101 = new PublicTypeCondition("PUBLIC", 1, 1);
            PUBLIC = r101;
            PublicTypeCondition r102 = new PublicTypeCondition("PRIVATE", 2, 2);
            PRIVATE = r102;
            $VALUES = new PublicTypeCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(PublicTypeCondition.class);
        }

        public static PublicTypeCondition[] values() {
            return (PublicTypeCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PublicTypeCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PRIVATE;
        L12:
            return PUBLIC;
        L14:
            return ALL_STATUS;
        }

        public static PublicTypeCondition valueOf(String r100) {
            return (PublicTypeCondition) a.a(PublicTypeCondition.class, r100);
        }

        private PublicTypeCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ShieldTypeCondition extends Enum<ShieldTypeCondition> implements WireEnum {
        private static final /* synthetic */ ShieldTypeCondition[] $VALUES = null;
        public static final ProtoAdapter<ShieldTypeCondition> ADAPTER = null;
        public static final ShieldTypeCondition ALL = null;
        public static final ShieldTypeCondition NORMAL = null;
        public static final ShieldTypeCondition SHIELD = null;
        private final int value;

        static {
            ShieldTypeCondition r100 = new ShieldTypeCondition(AccountType.ALL, 0, 0);
            ALL = r100;
            ShieldTypeCondition r101 = new ShieldTypeCondition("SHIELD", 1, 1);
            SHIELD = r101;
            ShieldTypeCondition r102 = new ShieldTypeCondition(EffectConstants.NORMAL, 2, 2);
            NORMAL = r102;
            $VALUES = new ShieldTypeCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShieldTypeCondition.class);
        }

        public static ShieldTypeCondition[] values() {
            return (ShieldTypeCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ShieldTypeCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NORMAL;
        L12:
            return SHIELD;
        L14:
            return ALL;
        }

        public static ShieldTypeCondition valueOf(String r100) {
            return (ShieldTypeCondition) a.a(ShieldTypeCondition.class, r100);
        }

        private ShieldTypeCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum TalkedStatusCondition extends Enum<TalkedStatusCondition> implements WireEnum {
        private static final /* synthetic */ TalkedStatusCondition[] $VALUES = null;
        public static final ProtoAdapter<TalkedStatusCondition> ADAPTER = null;
        public static final TalkedStatusCondition ALL_TALKED = null;
        public static final TalkedStatusCondition NOT_TALKED = null;
        public static final TalkedStatusCondition TALKED = null;
        private final int value;

        static {
            TalkedStatusCondition r100 = new TalkedStatusCondition("ALL_TALKED", 0, 0);
            ALL_TALKED = r100;
            TalkedStatusCondition r101 = new TalkedStatusCondition("TALKED", 1, 1);
            TALKED = r101;
            TalkedStatusCondition r102 = new TalkedStatusCondition("NOT_TALKED", 2, 2);
            NOT_TALKED = r102;
            $VALUES = new TalkedStatusCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TalkedStatusCondition.class);
        }

        public static TalkedStatusCondition[] values() {
            return (TalkedStatusCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TalkedStatusCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NOT_TALKED;
        L12:
            return TALKED;
        L14:
            return ALL_TALKED;
        }

        public static TalkedStatusCondition valueOf(String r100) {
            return (TalkedStatusCondition) a.a(TalkedStatusCondition.class, r100);
        }

        private TalkedStatusCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum TenantCondition extends Enum<TenantCondition> implements WireEnum {
        private static final /* synthetic */ TenantCondition[] $VALUES = null;
        public static final ProtoAdapter<TenantCondition> ADAPTER = null;
        public static final TenantCondition ALL_TENANT = null;
        public static final TenantCondition CROSS_TENANT = null;
        public static final TenantCondition NOT_CROSS_TENANT = null;
        private final int value;

        static {
            TenantCondition r100 = new TenantCondition("ALL_TENANT", 0, 0);
            ALL_TENANT = r100;
            TenantCondition r101 = new TenantCondition("NOT_CROSS_TENANT", 1, 1);
            NOT_CROSS_TENANT = r101;
            TenantCondition r102 = new TenantCondition("CROSS_TENANT", 2, 2);
            CROSS_TENANT = r102;
            $VALUES = new TenantCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TenantCondition.class);
        }

        public static TenantCondition[] values() {
            return (TenantCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TenantCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CROSS_TENANT;
        L12:
            return NOT_CROSS_TENANT;
        L14:
            return ALL_TENANT;
        }

        public static TenantCondition valueOf(String r100) {
            return (TenantCondition) a.a(TenantCondition.class, r100);
        }

        private TenantCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ThreadTypeCondition extends Enum<ThreadTypeCondition> implements WireEnum {
        private static final /* synthetic */ ThreadTypeCondition[] $VALUES = null;
        public static final ProtoAdapter<ThreadTypeCondition> ADAPTER = null;
        public static final ThreadTypeCondition ALL_THREAD = null;
        public static final ThreadTypeCondition CHAT_THREAD = null;
        public static final ThreadTypeCondition MSG_THREAD = null;
        private final int value;

        static {
            ThreadTypeCondition r100 = new ThreadTypeCondition("ALL_THREAD", 0, 0);
            ALL_THREAD = r100;
            ThreadTypeCondition r101 = new ThreadTypeCondition("CHAT_THREAD", 1, 1);
            CHAT_THREAD = r101;
            ThreadTypeCondition r102 = new ThreadTypeCondition("MSG_THREAD", 2, 2);
            MSG_THREAD = r102;
            $VALUES = new ThreadTypeCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ThreadTypeCondition.class);
        }

        public static ThreadTypeCondition[] values() {
            return (ThreadTypeCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ThreadTypeCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return MSG_THREAD;
        L12:
            return CHAT_THREAD;
        L14:
            return ALL_THREAD;
        }

        public static ThreadTypeCondition valueOf(String r100) {
            return (ThreadTypeCondition) a.a(ThreadTypeCondition.class, r100);
        }

        private ThreadTypeCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum UserTypeCondition extends Enum<UserTypeCondition> implements WireEnum {
        private static final /* synthetic */ UserTypeCondition[] $VALUES = null;
        public static final ProtoAdapter<UserTypeCondition> ADAPTER = null;
        public static final UserTypeCondition ALL_USER = null;
        public static final UserTypeCondition OTHERS = null;
        public static final UserTypeCondition SELF = null;
        private final int value;

        static {
            UserTypeCondition r100 = new UserTypeCondition("ALL_USER", 0, 0);
            ALL_USER = r100;
            UserTypeCondition r101 = new UserTypeCondition("SELF", 1, 1);
            SELF = r101;
            UserTypeCondition r102 = new UserTypeCondition(AccountType.OTHERS, 2, 2);
            OTHERS = r102;
            $VALUES = new UserTypeCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(UserTypeCondition.class);
        }

        public static UserTypeCondition[] values() {
            return (UserTypeCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static UserTypeCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return OTHERS;
        L12:
            return SELF;
        L14:
            return ALL_USER;
        }

        public static UserTypeCondition valueOf(String r100) {
            return (UserTypeCondition) a.a(UserTypeCondition.class, r100);
        }

        private UserTypeCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum WorkStatusCondition extends Enum<WorkStatusCondition> implements WireEnum {
        private static final /* synthetic */ WorkStatusCondition[] $VALUES = null;
        public static final ProtoAdapter<WorkStatusCondition> ADAPTER = null;
        public static final WorkStatusCondition ALL_RESIGNED = null;
        public static final WorkStatusCondition NOT_RESIGNED = null;
        public static final WorkStatusCondition RESIGNED = null;
        private final int value;

        static {
            WorkStatusCondition r100 = new WorkStatusCondition("ALL_RESIGNED", 0, 0);
            ALL_RESIGNED = r100;
            WorkStatusCondition r101 = new WorkStatusCondition("RESIGNED", 1, 1);
            RESIGNED = r101;
            WorkStatusCondition r102 = new WorkStatusCondition("NOT_RESIGNED", 2, 2);
            NOT_RESIGNED = r102;
            $VALUES = new WorkStatusCondition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(WorkStatusCondition.class);
        }

        public static WorkStatusCondition[] values() {
            return (WorkStatusCondition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static WorkStatusCondition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NOT_RESIGNED;
        L12:
            return RESIGNED;
        L14:
            return ALL_RESIGNED;
        }

        public static WorkStatusCondition valueOf(String r100) {
            return (WorkStatusCondition) a.a(WorkStatusCondition.class, r100);
        }

        private WorkStatusCondition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ForwardIncludeItem();
    }

    public ForwardIncludeItem() {
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
        return ForwardIncludeItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ForwardIncludeItem(ByteString r100) {
        super(ADAPTER, r100);
    }
}
