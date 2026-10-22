package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.search.v1.ChatterPermissionsRequest;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class BaseEntity extends Message<BaseEntity, Builder> {
    public static final ProtoAdapter<BaseEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<BaseEntity, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public BaseEntity build() {
            return new BaseEntity(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final enum ChatMode extends Enum<ChatMode> implements WireEnum {
        private static final /* synthetic */ ChatMode[] $VALUES = null;
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final ChatMode NORMAL = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode UNLIMITED = null;
        private final int value;

        static {
            ChatMode r100 = new ChatMode("UNLIMITED", 0, 0);
            UNLIMITED = r100;
            ChatMode r101 = new ChatMode(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            ChatMode r102 = new ChatMode("THREAD", 2, 2);
            THREAD = r102;
            $VALUES = new ChatMode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatMode.class);
        }

        public static ChatMode[] values() {
            return (ChatMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatMode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return THREAD;
        L12:
            return NORMAL;
        L14:
            return UNLIMITED;
        }

        public static ChatMode valueOf(String r100) {
            return (ChatMode) a.a(ChatMode.class, r100);
        }

        private ChatMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class EntityFilter extends Message<EntityFilter, Builder> {
        public static final ProtoAdapter<EntityFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final UniversalFilters.BannerFilter banner_filter;
        public final UniversalFilters.BotFilter bot_filter;
        public final UniversalFilters.CustomizationFilter customization_filter;
        public final UniversalFilters.DepartmentFilter department_filter;
        public final UniversalFilters.DocFilter doc_filter;
        public final UniversalFilters.ChatFilter group_chat_filter;
        public final UniversalFilters.MessageFileFilter message_file_filter;
        public final UniversalFilters.MessageFilter message_filter;
        public final UniversalFilters.MyAIFilter my_ai_filter;
        public final UniversalFilters.NewUserGroupFilter new_user_group_filter;
        public final UniversalFilters.SlashCommandFilter slash_command_filter;
        public final UniversalFilters.URLFilter url_filter;
        public final UniversalFilters.UserFilter user_filter;
        public final UniversalFilters.WikiFilter wiki_filter;
        public final UniversalFilters.WikiSpaceFilter wiki_space_filter;

        public static final class Builder extends Message.Builder<EntityFilter, Builder> {
            public UniversalFilters.BannerFilter banner_filter;
            public UniversalFilters.BotFilter bot_filter;
            public UniversalFilters.CustomizationFilter customization_filter;
            public UniversalFilters.DepartmentFilter department_filter;
            public UniversalFilters.DocFilter doc_filter;
            public UniversalFilters.ChatFilter group_chat_filter;
            public UniversalFilters.MessageFileFilter message_file_filter;
            public UniversalFilters.MessageFilter message_filter;
            public UniversalFilters.MyAIFilter my_ai_filter;
            public UniversalFilters.NewUserGroupFilter new_user_group_filter;
            public UniversalFilters.SlashCommandFilter slash_command_filter;
            public UniversalFilters.URLFilter url_filter;
            public UniversalFilters.UserFilter user_filter;
            public UniversalFilters.WikiFilter wiki_filter;
            public UniversalFilters.WikiSpaceFilter wiki_space_filter;

            @Override // com.squareup.wire.Message.Builder
            public EntityFilter build() {
                return new EntityFilter(this.user_filter, this.group_chat_filter, this.message_filter, this.doc_filter, this.wiki_filter, this.url_filter, this.department_filter, this.slash_command_filter, this.customization_filter, this.bot_filter, this.banner_filter, this.wiki_space_filter, this.message_file_filter, this.my_ai_filter, this.new_user_group_filter, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder banner_filter(UniversalFilters.BannerFilter r100) {
                this.banner_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder bot_filter(UniversalFilters.BotFilter r100) {
                this.bot_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder customization_filter(UniversalFilters.CustomizationFilter r100) {
                this.customization_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder department_filter(UniversalFilters.DepartmentFilter r100) {
                this.department_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder doc_filter(UniversalFilters.DocFilter r100) {
                this.doc_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder group_chat_filter(UniversalFilters.ChatFilter r100) {
                this.group_chat_filter = r100;
                this.user_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder message_file_filter(UniversalFilters.MessageFileFilter r100) {
                this.message_file_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder message_filter(UniversalFilters.MessageFilter r100) {
                this.message_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder my_ai_filter(UniversalFilters.MyAIFilter r100) {
                this.my_ai_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder new_user_group_filter(UniversalFilters.NewUserGroupFilter r100) {
                this.new_user_group_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                return this;
            }

            public Builder slash_command_filter(UniversalFilters.SlashCommandFilter r100) {
                this.slash_command_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder url_filter(UniversalFilters.URLFilter r100) {
                this.url_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder user_filter(UniversalFilters.UserFilter r100) {
                this.user_filter = r100;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder wiki_filter(UniversalFilters.WikiFilter r100) {
                this.wiki_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.wiki_space_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }

            public Builder wiki_space_filter(UniversalFilters.WikiSpaceFilter r100) {
                this.wiki_space_filter = r100;
                this.user_filter = null;
                this.group_chat_filter = null;
                this.message_filter = null;
                this.doc_filter = null;
                this.wiki_filter = null;
                this.url_filter = null;
                this.department_filter = null;
                this.slash_command_filter = null;
                this.customization_filter = null;
                this.bot_filter = null;
                this.banner_filter = null;
                this.message_file_filter = null;
                this.my_ai_filter = null;
                this.new_user_group_filter = null;
                return this;
            }
        }

        public static final class ProtoAdapter_EntityFilter extends ProtoAdapter<EntityFilter> {
            public ProtoAdapter_EntityFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, EntityFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EntityFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L22;
                switch(r103) {
                    case 1: goto L21;
                    case 2: goto L20;
                    case 3: goto L19;
                    case 4: goto L18;
                    case 5: goto L17;
                    case 6: goto L16;
                    case 7: goto L15;
                    case 8: goto L14;
                    case 9: goto L13;
                    case 10: goto L12;
                    case 11: goto L11;
                    case 12: goto L10;
                    case 13: goto L6;
                    case 14: goto L9;
                    case 15: goto L8;
                    case 16: goto L7;
                    default: goto L6;
                };
            L7:
                r101.new_user_group_filter(UniversalFilters.NewUserGroupFilter.ADAPTER.decode(r100));
                goto L3
            L8:
                r101.my_ai_filter(UniversalFilters.MyAIFilter.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.message_file_filter(UniversalFilters.MessageFileFilter.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.wiki_space_filter(UniversalFilters.WikiSpaceFilter.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.banner_filter(UniversalFilters.BannerFilter.ADAPTER.decode(r100));
                goto L3
            L12:
                r101.bot_filter(UniversalFilters.BotFilter.ADAPTER.decode(r100));
                goto L3
            L13:
                r101.customization_filter(UniversalFilters.CustomizationFilter.ADAPTER.decode(r100));
                goto L3
            L14:
                r101.slash_command_filter(UniversalFilters.SlashCommandFilter.ADAPTER.decode(r100));
                goto L3
            L15:
                r101.department_filter(UniversalFilters.DepartmentFilter.ADAPTER.decode(r100));
                goto L3
            L16:
                r101.url_filter(UniversalFilters.URLFilter.ADAPTER.decode(r100));
                goto L3
            L17:
                r101.wiki_filter(UniversalFilters.WikiFilter.ADAPTER.decode(r100));
                goto L3
            L18:
                r101.doc_filter(UniversalFilters.DocFilter.ADAPTER.decode(r100));
                goto L3
            L19:
                r101.message_filter(UniversalFilters.MessageFilter.ADAPTER.decode(r100));
                goto L3
            L20:
                r101.group_chat_filter(UniversalFilters.ChatFilter.ADAPTER.decode(r100));
                goto L3
            L21:
                r101.user_filter(UniversalFilters.UserFilter.ADAPTER.decode(r100));
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L22:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(EntityFilter r100) {
                UniversalFilters.UserFilter r101 = r100.user_filter;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = UniversalFilters.UserFilter.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                UniversalFilters.ChatFilter r104 = r100.group_chat_filter;
                if (r104 == null) goto L9;
                int r105 = UniversalFilters.ChatFilter.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                UniversalFilters.MessageFilter r107 = r100.message_filter;
                if (r107 == null) goto L13;
                int r108 = UniversalFilters.MessageFilter.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                UniversalFilters.DocFilter r110 = r100.doc_filter;
                if (r110 == null) goto L17;
                int r111 = UniversalFilters.DocFilter.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                UniversalFilters.WikiFilter r113 = r100.wiki_filter;
                if (r113 == null) goto L21;
                int r114 = UniversalFilters.WikiFilter.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                UniversalFilters.URLFilter r116 = r100.url_filter;
                if (r116 == null) goto L25;
                int r117 = UniversalFilters.URLFilter.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                UniversalFilters.DepartmentFilter r119 = r100.department_filter;
                if (r119 == null) goto L29;
                int r120 = UniversalFilters.DepartmentFilter.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                UniversalFilters.SlashCommandFilter r122 = r100.slash_command_filter;
                if (r122 == null) goto L33;
                int r123 = UniversalFilters.SlashCommandFilter.ADAPTER.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                UniversalFilters.CustomizationFilter r125 = r100.customization_filter;
                if (r125 == null) goto L37;
                int r126 = UniversalFilters.CustomizationFilter.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                UniversalFilters.BotFilter r128 = r100.bot_filter;
                if (r128 == null) goto L41;
                int r129 = UniversalFilters.BotFilter.ADAPTER.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                UniversalFilters.BannerFilter r131 = r100.banner_filter;
                if (r131 == null) goto L45;
                int r132 = UniversalFilters.BannerFilter.ADAPTER.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                UniversalFilters.WikiSpaceFilter r134 = r100.wiki_space_filter;
                if (r134 == null) goto L49;
                int r135 = UniversalFilters.WikiSpaceFilter.ADAPTER.encodedSizeWithTag(12, r134);
            L50:
                int r136 = r133 + r135;
                UniversalFilters.MessageFileFilter r137 = r100.message_file_filter;
                if (r137 == null) goto L53;
                int r138 = UniversalFilters.MessageFileFilter.ADAPTER.encodedSizeWithTag(14, r137);
            L54:
                int r139 = r136 + r138;
                UniversalFilters.MyAIFilter r140 = r100.my_ai_filter;
                if (r140 == null) goto L57;
                int r141 = UniversalFilters.MyAIFilter.ADAPTER.encodedSizeWithTag(15, r140);
            L58:
                int r142 = r139 + r141;
                UniversalFilters.NewUserGroupFilter r143 = r100.new_user_group_filter;
                if (r143 == null) goto L62;
                r102 = UniversalFilters.NewUserGroupFilter.ADAPTER.encodedSizeWithTag(16, r143);
            L62:
                return (r142 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ EntityFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EntityFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EntityFilter r101) throws IOException {
                UniversalFilters.UserFilter r102 = r101.user_filter;
                if (r102 == null) goto L5;
                UniversalFilters.UserFilter.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                UniversalFilters.ChatFilter r103 = r101.group_chat_filter;
                if (r103 == null) goto L8;
                UniversalFilters.ChatFilter.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                UniversalFilters.MessageFilter r104 = r101.message_filter;
                if (r104 == null) goto L11;
                UniversalFilters.MessageFilter.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                UniversalFilters.DocFilter r105 = r101.doc_filter;
                if (r105 == null) goto L14;
                UniversalFilters.DocFilter.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                UniversalFilters.WikiFilter r106 = r101.wiki_filter;
                if (r106 == null) goto L17;
                UniversalFilters.WikiFilter.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                UniversalFilters.URLFilter r107 = r101.url_filter;
                if (r107 == null) goto L20;
                UniversalFilters.URLFilter.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                UniversalFilters.DepartmentFilter r108 = r101.department_filter;
                if (r108 == null) goto L23;
                UniversalFilters.DepartmentFilter.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                UniversalFilters.SlashCommandFilter r109 = r101.slash_command_filter;
                if (r109 == null) goto L26;
                UniversalFilters.SlashCommandFilter.ADAPTER.encodeWithTag(r100, 8, r109);
            L26:
                UniversalFilters.CustomizationFilter r110 = r101.customization_filter;
                if (r110 == null) goto L29;
                UniversalFilters.CustomizationFilter.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                UniversalFilters.BotFilter r111 = r101.bot_filter;
                if (r111 == null) goto L32;
                UniversalFilters.BotFilter.ADAPTER.encodeWithTag(r100, 10, r111);
            L32:
                UniversalFilters.BannerFilter r112 = r101.banner_filter;
                if (r112 == null) goto L35;
                UniversalFilters.BannerFilter.ADAPTER.encodeWithTag(r100, 11, r112);
            L35:
                UniversalFilters.WikiSpaceFilter r113 = r101.wiki_space_filter;
                if (r113 == null) goto L38;
                UniversalFilters.WikiSpaceFilter.ADAPTER.encodeWithTag(r100, 12, r113);
            L38:
                UniversalFilters.MessageFileFilter r114 = r101.message_file_filter;
                if (r114 == null) goto L41;
                UniversalFilters.MessageFileFilter.ADAPTER.encodeWithTag(r100, 14, r114);
            L41:
                UniversalFilters.MyAIFilter r115 = r101.my_ai_filter;
                if (r115 == null) goto L44;
                UniversalFilters.MyAIFilter.ADAPTER.encodeWithTag(r100, 15, r115);
            L44:
                UniversalFilters.NewUserGroupFilter r116 = r101.new_user_group_filter;
                if (r116 == null) goto L47;
                UniversalFilters.NewUserGroupFilter.ADAPTER.encodeWithTag(r100, 16, r116);
            L47:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EntityFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EntityFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_filter = this.user_filter;
            r100.group_chat_filter = this.group_chat_filter;
            r100.message_filter = this.message_filter;
            r100.doc_filter = this.doc_filter;
            r100.wiki_filter = this.wiki_filter;
            r100.url_filter = this.url_filter;
            r100.department_filter = this.department_filter;
            r100.slash_command_filter = this.slash_command_filter;
            r100.customization_filter = this.customization_filter;
            r100.bot_filter = this.bot_filter;
            r100.banner_filter = this.banner_filter;
            r100.wiki_space_filter = this.wiki_space_filter;
            r100.message_file_filter = this.message_file_filter;
            r100.my_ai_filter = this.my_ai_filter;
            r100.new_user_group_filter = this.new_user_group_filter;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EntityFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EntityFilter(UniversalFilters.UserFilter r110, UniversalFilters.ChatFilter r111, UniversalFilters.MessageFilter r210, UniversalFilters.DocFilter r211, UniversalFilters.WikiFilter r212, UniversalFilters.URLFilter r213, UniversalFilters.DepartmentFilter r214, UniversalFilters.SlashCommandFilter r215, UniversalFilters.CustomizationFilter r216, UniversalFilters.BotFilter r217, UniversalFilters.BannerFilter r218, UniversalFilters.WikiSpaceFilter r219, UniversalFilters.MessageFileFilter r310, UniversalFilters.MyAIFilter r311, UniversalFilters.NewUserGroupFilter r312) {
            this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
        }

        public EntityFilter(UniversalFilters.UserFilter r110, UniversalFilters.ChatFilter r111, UniversalFilters.MessageFilter r210, UniversalFilters.DocFilter r211, UniversalFilters.WikiFilter r212, UniversalFilters.URLFilter r213, UniversalFilters.DepartmentFilter r214, UniversalFilters.SlashCommandFilter r215, UniversalFilters.CustomizationFilter r216, UniversalFilters.BotFilter r217, UniversalFilters.BannerFilter r218, UniversalFilters.WikiSpaceFilter r219, UniversalFilters.MessageFileFilter r310, UniversalFilters.MyAIFilter r311, UniversalFilters.NewUserGroupFilter r312, ByteString r313) {
            super(ADAPTER, r313);
            if (Internal.countNonNull(r110, r111, r210, r211, new Object[]{r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312}) > 1) goto L7;
            this.user_filter = r110;
            this.group_chat_filter = r111;
            this.message_filter = r210;
            this.doc_filter = r211;
            this.wiki_filter = r212;
            this.url_filter = r213;
            this.department_filter = r214;
            this.slash_command_filter = r215;
            this.customization_filter = r216;
            this.bot_filter = r217;
            this.banner_filter = r218;
            this.wiki_space_filter = r219;
            this.message_file_filter = r310;
            this.my_ai_filter = r311;
            this.new_user_group_filter = r312;
            return;
        L7:
            throw new IllegalArgumentException("at most one of user_filter, group_chat_filter, message_filter, doc_filter, wiki_filter, url_filter, department_filter, slash_command_filter, customization_filter, bot_filter, banner_filter, wiki_space_filter, message_file_filter, my_ai_filter, new_user_group_filter may be non-null");
        }
    }

    public static final class EntityItem extends Message<EntityItem, Builder> {
        public static final ProtoAdapter<EntityItem> ADAPTER = null;
        public static final String DEFAULT_LOCAL_PAGINATION_TOKEN = "";
        public static final BaseEnum.MergePolicy DEFAULT_MERGE_POLICY = null;
        public static final Integer DEFAULT_RANK_BOOSTING = null;
        public static final SearchEntityType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final EntityFilter entity_filter;
        public final EntitySelector entity_selector;
        public final Map<String, String> extras;
        public final String local_pagination_token;
        public final BaseEnum.MergePolicy merge_policy;
        public final Integer rank_boosting;
        public final SpotlightStrategy spotlight_strategy;
        public final SearchEntityType type;

        public static final class Builder extends Message.Builder<EntityItem, Builder> {
            public EntityFilter entity_filter;
            public EntitySelector entity_selector;
            public Map<String, String> extras;
            public String local_pagination_token;
            public BaseEnum.MergePolicy merge_policy;
            public Integer rank_boosting;
            public SpotlightStrategy spotlight_strategy;
            public SearchEntityType type;

            @Override // com.squareup.wire.Message.Builder
            public EntityItem build() {
                SearchEntityType r100 = this.type;
                if (r100 == null) goto L7;
                return new EntityItem(this.type, this.rank_boosting, this.merge_policy, this.entity_filter, this.entity_selector, this.spotlight_strategy, this.local_pagination_token, this.extras, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "type"});
            }

            public Builder() {
                this.extras = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder entity_filter(EntityFilter r100) {
                this.entity_filter = r100;
                return this;
            }

            public Builder entity_selector(EntitySelector r100) {
                this.entity_selector = r100;
                return this;
            }

            public Builder extras(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.extras = r100;
                return this;
            }

            public Builder local_pagination_token(String r100) {
                this.local_pagination_token = r100;
                return this;
            }

            public Builder merge_policy(BaseEnum.MergePolicy r100) {
                this.merge_policy = r100;
                return this;
            }

            public Builder rank_boosting(Integer r100) {
                this.rank_boosting = r100;
                return this;
            }

            public Builder spotlight_strategy(SpotlightStrategy r100) {
                this.spotlight_strategy = r100;
                return this;
            }

            public Builder type(SearchEntityType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EntityItem extends ProtoAdapter<EntityItem> {
            private final ProtoAdapter<Map<String, String>> extras;

            public ProtoAdapter_EntityItem() {
                super(FieldEncoding.LENGTH_DELIMITED, EntityItem.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.extras = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EntityItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = SearchEntityType.UNKNOWN;
                r101.rank_boosting = 0;
                r101.merge_policy = BaseEnum.MergePolicy.COMBINE_LOCAL_AND_SERVER;
                r101.local_pagination_token = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                switch(r103) {
                    case 1: goto L23;
                    case 2: goto L16;
                    case 3: goto L25;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L23:
                r101.type = SearchEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L25:
                r101.merge_policy = BaseEnum.MergePolicy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.extras.putAll(this.extras.decode(r100));
                goto L3
            L8:
                r101.local_pagination_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.spotlight_strategy = SpotlightStrategy.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.entity_selector = EntitySelector.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.entity_filter = EntityFilter.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.rank_boosting = ProtoAdapter.INT32.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(EntityItem r100) {
                int r101 = SearchEntityType.ADAPTER.encodedSizeWithTag(1, r100.type);
                Integer r102 = r100.rank_boosting;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                BaseEnum.MergePolicy r106 = r100.merge_policy;
                if (r106 == null) goto L9;
                int r107 = BaseEnum.MergePolicy.ADAPTER.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                EntityFilter r109 = r100.entity_filter;
                if (r109 == null) goto L13;
                int r110 = EntityFilter.ADAPTER.encodedSizeWithTag(4, r109);
            L14:
                int r111 = r108 + r110;
                EntitySelector r112 = r100.entity_selector;
                if (r112 == null) goto L17;
                int r113 = EntitySelector.ADAPTER.encodedSizeWithTag(5, r112);
            L18:
                int r114 = r111 + r113;
                SpotlightStrategy r115 = r100.spotlight_strategy;
                if (r115 == null) goto L21;
                int r116 = SpotlightStrategy.ADAPTER.encodedSizeWithTag(6, r115);
            L22:
                int r117 = r114 + r116;
                String r118 = r100.local_pagination_token;
                if (r118 == null) goto L26;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(7, r118);
            L26:
                return ((r117 + r103) + this.extras.encodedSizeWithTag(8, r100.extras)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ EntityItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EntityItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EntityItem r101) throws IOException {
                SearchEntityType.ADAPTER.encodeWithTag(r100, 1, r101.type);
                Integer r102 = r101.rank_boosting;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
            L5:
                BaseEnum.MergePolicy r103 = r101.merge_policy;
                if (r103 == null) goto L8;
                BaseEnum.MergePolicy.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                EntityFilter r104 = r101.entity_filter;
                if (r104 == null) goto L11;
                EntityFilter.ADAPTER.encodeWithTag(r100, 4, r104);
            L11:
                EntitySelector r105 = r101.entity_selector;
                if (r105 == null) goto L14;
                EntitySelector.ADAPTER.encodeWithTag(r100, 5, r105);
            L14:
                SpotlightStrategy r106 = r101.spotlight_strategy;
                if (r106 == null) goto L17;
                SpotlightStrategy.ADAPTER.encodeWithTag(r100, 6, r106);
            L17:
                String r107 = r101.local_pagination_token;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
            L20:
                this.extras.encodeWithTag(r100, 8, r101.extras);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EntityItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EntityItem();
            DEFAULT_TYPE = SearchEntityType.UNKNOWN;
            DEFAULT_RANK_BOOSTING = 0;
            DEFAULT_MERGE_POLICY = BaseEnum.MergePolicy.COMBINE_LOCAL_AND_SERVER;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.rank_boosting = this.rank_boosting;
            r100.merge_policy = this.merge_policy;
            r100.entity_filter = this.entity_filter;
            r100.entity_selector = this.entity_selector;
            r100.spotlight_strategy = this.spotlight_strategy;
            r100.local_pagination_token = this.local_pagination_token;
            r100.extras = Internal.copyOf("extras", this.extras);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EntityItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EntityItem(SearchEntityType r110, Integer r111, BaseEnum.MergePolicy r112, EntityFilter r113, EntitySelector r114, SpotlightStrategy r115, String r116, Map<String, String> r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public EntityItem(SearchEntityType r100, Integer r101, BaseEnum.MergePolicy r102, EntityFilter r103, EntitySelector r104, SpotlightStrategy r105, String r106, Map<String, String> r107, ByteString r110) {
            super(ADAPTER, r110);
            this.type = r100;
            this.rank_boosting = r101;
            this.merge_policy = r102;
            this.entity_filter = r103;
            this.entity_selector = r104;
            this.spotlight_strategy = r105;
            this.local_pagination_token = r106;
            this.extras = Internal.immutableCopyOf("extras", r107);
        }
    }

    public static final class EntitySelector extends Message<EntitySelector, Builder> {
        public static final ProtoAdapter<EntitySelector> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final UniversalSelectors.BotSelector bot_selector;
        public final UniversalSelectors.CryptoP2PChatSelector crypto_p2p_chat_selector;
        public final UniversalSelectors.CustomizationSelector customization_selector;
        public final UniversalSelectors.DocSelector doc_selector;
        public final UniversalSelectors.GroupChatSelector group_chat_selector;
        public final UniversalSelectors.MessageFileSelector message_file_selector;
        public final UniversalSelectors.MessageSelector message_selector;
        public final UniversalSelectors.QaCardSelector qa_card_selector;
        public final UniversalSelectors.ShieldP2PChatSelector shield_p2p_chat_selector;
        public final UniversalSelectors.URLSelector url_selector;
        public final UniversalSelectors.UserSelector user_selector;
        public final UniversalSelectors.WikiSelector wiki_selector;

        public static final class Builder extends Message.Builder<EntitySelector, Builder> {
            public UniversalSelectors.BotSelector bot_selector;
            public UniversalSelectors.CryptoP2PChatSelector crypto_p2p_chat_selector;
            public UniversalSelectors.CustomizationSelector customization_selector;
            public UniversalSelectors.DocSelector doc_selector;
            public UniversalSelectors.GroupChatSelector group_chat_selector;
            public UniversalSelectors.MessageFileSelector message_file_selector;
            public UniversalSelectors.MessageSelector message_selector;
            public UniversalSelectors.QaCardSelector qa_card_selector;
            public UniversalSelectors.ShieldP2PChatSelector shield_p2p_chat_selector;
            public UniversalSelectors.URLSelector url_selector;
            public UniversalSelectors.UserSelector user_selector;
            public UniversalSelectors.WikiSelector wiki_selector;

            @Override // com.squareup.wire.Message.Builder
            public EntitySelector build() {
                return new EntitySelector(this.user_selector, this.qa_card_selector, this.customization_selector, this.message_selector, this.wiki_selector, this.group_chat_selector, this.doc_selector, this.crypto_p2p_chat_selector, this.shield_p2p_chat_selector, this.url_selector, this.message_file_selector, this.bot_selector, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder bot_selector(UniversalSelectors.BotSelector r100) {
                this.bot_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                return this;
            }

            public Builder crypto_p2p_chat_selector(UniversalSelectors.CryptoP2PChatSelector r100) {
                this.crypto_p2p_chat_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder customization_selector(UniversalSelectors.CustomizationSelector r100) {
                this.customization_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder doc_selector(UniversalSelectors.DocSelector r100) {
                this.doc_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder group_chat_selector(UniversalSelectors.GroupChatSelector r100) {
                this.group_chat_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder message_file_selector(UniversalSelectors.MessageFileSelector r100) {
                this.message_file_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder message_selector(UniversalSelectors.MessageSelector r100) {
                this.message_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder qa_card_selector(UniversalSelectors.QaCardSelector r100) {
                this.qa_card_selector = r100;
                this.user_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder shield_p2p_chat_selector(UniversalSelectors.ShieldP2PChatSelector r100) {
                this.shield_p2p_chat_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder url_selector(UniversalSelectors.URLSelector r100) {
                this.url_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder user_selector(UniversalSelectors.UserSelector r100) {
                this.user_selector = r100;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.wiki_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }

            public Builder wiki_selector(UniversalSelectors.WikiSelector r100) {
                this.wiki_selector = r100;
                this.user_selector = null;
                this.qa_card_selector = null;
                this.customization_selector = null;
                this.message_selector = null;
                this.group_chat_selector = null;
                this.doc_selector = null;
                this.crypto_p2p_chat_selector = null;
                this.shield_p2p_chat_selector = null;
                this.url_selector = null;
                this.message_file_selector = null;
                this.bot_selector = null;
                return this;
            }
        }

        public static final class ProtoAdapter_EntitySelector extends ProtoAdapter<EntitySelector> {
            public ProtoAdapter_EntitySelector() {
                super(FieldEncoding.LENGTH_DELIMITED, EntitySelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EntitySelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L6;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    case 10: goto L10;
                    case 11: goto L9;
                    case 12: goto L6;
                    case 13: goto L8;
                    case 14: goto L7;
                    default: goto L6;
                };
            L7:
                r101.bot_selector(UniversalSelectors.BotSelector.ADAPTER.decode(r100));
                goto L3
            L8:
                r101.message_file_selector(UniversalSelectors.MessageFileSelector.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.url_selector(UniversalSelectors.URLSelector.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.shield_p2p_chat_selector(UniversalSelectors.ShieldP2PChatSelector.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.crypto_p2p_chat_selector(UniversalSelectors.CryptoP2PChatSelector.ADAPTER.decode(r100));
                goto L3
            L12:
                r101.doc_selector(UniversalSelectors.DocSelector.ADAPTER.decode(r100));
                goto L3
            L13:
                r101.group_chat_selector(UniversalSelectors.GroupChatSelector.ADAPTER.decode(r100));
                goto L3
            L14:
                r101.wiki_selector(UniversalSelectors.WikiSelector.ADAPTER.decode(r100));
                goto L3
            L15:
                r101.message_selector(UniversalSelectors.MessageSelector.ADAPTER.decode(r100));
                goto L3
            L16:
                r101.customization_selector(UniversalSelectors.CustomizationSelector.ADAPTER.decode(r100));
                goto L3
            L17:
                r101.qa_card_selector(UniversalSelectors.QaCardSelector.ADAPTER.decode(r100));
                goto L3
            L18:
                r101.user_selector(UniversalSelectors.UserSelector.ADAPTER.decode(r100));
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
            public int encodedSize2(EntitySelector r100) {
                UniversalSelectors.UserSelector r101 = r100.user_selector;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = UniversalSelectors.UserSelector.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                UniversalSelectors.QaCardSelector r104 = r100.qa_card_selector;
                if (r104 == null) goto L9;
                int r105 = UniversalSelectors.QaCardSelector.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                UniversalSelectors.CustomizationSelector r107 = r100.customization_selector;
                if (r107 == null) goto L13;
                int r108 = UniversalSelectors.CustomizationSelector.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                UniversalSelectors.MessageSelector r110 = r100.message_selector;
                if (r110 == null) goto L17;
                int r111 = UniversalSelectors.MessageSelector.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                UniversalSelectors.WikiSelector r113 = r100.wiki_selector;
                if (r113 == null) goto L21;
                int r114 = UniversalSelectors.WikiSelector.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                UniversalSelectors.GroupChatSelector r116 = r100.group_chat_selector;
                if (r116 == null) goto L25;
                int r117 = UniversalSelectors.GroupChatSelector.ADAPTER.encodedSizeWithTag(7, r116);
            L26:
                int r118 = r115 + r117;
                UniversalSelectors.DocSelector r119 = r100.doc_selector;
                if (r119 == null) goto L29;
                int r120 = UniversalSelectors.DocSelector.ADAPTER.encodedSizeWithTag(8, r119);
            L30:
                int r121 = r118 + r120;
                UniversalSelectors.CryptoP2PChatSelector r122 = r100.crypto_p2p_chat_selector;
                if (r122 == null) goto L33;
                int r123 = UniversalSelectors.CryptoP2PChatSelector.ADAPTER.encodedSizeWithTag(9, r122);
            L34:
                int r124 = r121 + r123;
                UniversalSelectors.ShieldP2PChatSelector r125 = r100.shield_p2p_chat_selector;
                if (r125 == null) goto L37;
                int r126 = UniversalSelectors.ShieldP2PChatSelector.ADAPTER.encodedSizeWithTag(10, r125);
            L38:
                int r127 = r124 + r126;
                UniversalSelectors.URLSelector r128 = r100.url_selector;
                if (r128 == null) goto L41;
                int r129 = UniversalSelectors.URLSelector.ADAPTER.encodedSizeWithTag(11, r128);
            L42:
                int r130 = r127 + r129;
                UniversalSelectors.MessageFileSelector r131 = r100.message_file_selector;
                if (r131 == null) goto L45;
                int r132 = UniversalSelectors.MessageFileSelector.ADAPTER.encodedSizeWithTag(13, r131);
            L46:
                int r133 = r130 + r132;
                UniversalSelectors.BotSelector r134 = r100.bot_selector;
                if (r134 == null) goto L50;
                r102 = UniversalSelectors.BotSelector.ADAPTER.encodedSizeWithTag(14, r134);
            L50:
                return (r133 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ EntitySelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EntitySelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EntitySelector r101) throws IOException {
                UniversalSelectors.UserSelector r102 = r101.user_selector;
                if (r102 == null) goto L5;
                UniversalSelectors.UserSelector.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                UniversalSelectors.QaCardSelector r103 = r101.qa_card_selector;
                if (r103 == null) goto L8;
                UniversalSelectors.QaCardSelector.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                UniversalSelectors.CustomizationSelector r104 = r101.customization_selector;
                if (r104 == null) goto L11;
                UniversalSelectors.CustomizationSelector.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                UniversalSelectors.MessageSelector r105 = r101.message_selector;
                if (r105 == null) goto L14;
                UniversalSelectors.MessageSelector.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                UniversalSelectors.WikiSelector r106 = r101.wiki_selector;
                if (r106 == null) goto L17;
                UniversalSelectors.WikiSelector.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                UniversalSelectors.GroupChatSelector r107 = r101.group_chat_selector;
                if (r107 == null) goto L20;
                UniversalSelectors.GroupChatSelector.ADAPTER.encodeWithTag(r100, 7, r107);
            L20:
                UniversalSelectors.DocSelector r108 = r101.doc_selector;
                if (r108 == null) goto L23;
                UniversalSelectors.DocSelector.ADAPTER.encodeWithTag(r100, 8, r108);
            L23:
                UniversalSelectors.CryptoP2PChatSelector r109 = r101.crypto_p2p_chat_selector;
                if (r109 == null) goto L26;
                UniversalSelectors.CryptoP2PChatSelector.ADAPTER.encodeWithTag(r100, 9, r109);
            L26:
                UniversalSelectors.ShieldP2PChatSelector r110 = r101.shield_p2p_chat_selector;
                if (r110 == null) goto L29;
                UniversalSelectors.ShieldP2PChatSelector.ADAPTER.encodeWithTag(r100, 10, r110);
            L29:
                UniversalSelectors.URLSelector r111 = r101.url_selector;
                if (r111 == null) goto L32;
                UniversalSelectors.URLSelector.ADAPTER.encodeWithTag(r100, 11, r111);
            L32:
                UniversalSelectors.MessageFileSelector r112 = r101.message_file_selector;
                if (r112 == null) goto L35;
                UniversalSelectors.MessageFileSelector.ADAPTER.encodeWithTag(r100, 13, r112);
            L35:
                UniversalSelectors.BotSelector r113 = r101.bot_selector;
                if (r113 == null) goto L38;
                UniversalSelectors.BotSelector.ADAPTER.encodeWithTag(r100, 14, r113);
            L38:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EntitySelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EntitySelector();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_selector = this.user_selector;
            r100.qa_card_selector = this.qa_card_selector;
            r100.customization_selector = this.customization_selector;
            r100.message_selector = this.message_selector;
            r100.wiki_selector = this.wiki_selector;
            r100.group_chat_selector = this.group_chat_selector;
            r100.doc_selector = this.doc_selector;
            r100.crypto_p2p_chat_selector = this.crypto_p2p_chat_selector;
            r100.shield_p2p_chat_selector = this.shield_p2p_chat_selector;
            r100.url_selector = this.url_selector;
            r100.message_file_selector = this.message_file_selector;
            r100.bot_selector = this.bot_selector;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EntitySelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EntitySelector(UniversalSelectors.UserSelector r110, UniversalSelectors.QaCardSelector r111, UniversalSelectors.CustomizationSelector r112, UniversalSelectors.MessageSelector r113, UniversalSelectors.WikiSelector r114, UniversalSelectors.GroupChatSelector r210, UniversalSelectors.DocSelector r211, UniversalSelectors.CryptoP2PChatSelector r212, UniversalSelectors.ShieldP2PChatSelector r213, UniversalSelectors.URLSelector r214, UniversalSelectors.MessageFileSelector r215, UniversalSelectors.BotSelector r216) {
            this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
        }

        public EntitySelector(UniversalSelectors.UserSelector r100, UniversalSelectors.QaCardSelector r101, UniversalSelectors.CustomizationSelector r102, UniversalSelectors.MessageSelector r103, UniversalSelectors.WikiSelector r104, UniversalSelectors.GroupChatSelector r105, UniversalSelectors.DocSelector r106, UniversalSelectors.CryptoP2PChatSelector r110, UniversalSelectors.ShieldP2PChatSelector r111, UniversalSelectors.URLSelector r112, UniversalSelectors.MessageFileSelector r113, UniversalSelectors.BotSelector r114, ByteString r115) {
            super(ADAPTER, r115);
            if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105, r106, r110, r111, r112, r113, r114}) > 1) goto L7;
            this.user_selector = r100;
            this.qa_card_selector = r101;
            this.customization_selector = r102;
            this.message_selector = r103;
            this.wiki_selector = r104;
            this.group_chat_selector = r105;
            this.doc_selector = r106;
            this.crypto_p2p_chat_selector = r110;
            this.shield_p2p_chat_selector = r111;
            this.url_selector = r112;
            this.message_file_selector = r113;
            this.bot_selector = r114;
            return;
        L7:
            throw new IllegalArgumentException("at most one of user_selector, qa_card_selector, customization_selector, message_selector, wiki_selector, group_chat_selector, doc_selector, crypto_p2p_chat_selector, shield_p2p_chat_selector, url_selector, message_file_selector, bot_selector may be non-null");
        }
    }

    public static final class ProtoAdapter_BaseEntity extends ProtoAdapter<BaseEntity> {
        public ProtoAdapter_BaseEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, BaseEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BaseEntity decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(BaseEntity r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BaseEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BaseEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BaseEntity r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BaseEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SearchContext extends Message<SearchContext, Builder> {
        public static final ProtoAdapter<SearchContext> ADAPTER = null;
        public static final Boolean DEFAULT_LOCAL_SEARCH_USE_SECTION = null;
        public static final Boolean DEFAULT_NEED_INTENTION_RECOGNITION = null;
        public static final RequestSource DEFAULT_REQUEST_SOURCE = null;
        public static final String DEFAULT_SOURCE_KEY = "";
        public static final String DEFAULT_TAG_NAME = "";
        private static final long serialVersionUID = 0;
        public final UniversalFilters.CommonFilter common_filter;
        public final List<EntityItem> entity_items;
        public final Boolean local_search_use_section;
        public final Boolean need_intention_recognition;
        public final RequestSource request_source;
        public final SearchAction search_action;
        public final String source_key;
        public final List<SuggestionItem> suggestion_items;
        public final String tag_name;

        public static final class Builder extends Message.Builder<SearchContext, Builder> {
            public UniversalFilters.CommonFilter common_filter;
            public List<EntityItem> entity_items;
            public Boolean local_search_use_section;
            public Boolean need_intention_recognition;
            public RequestSource request_source;
            public SearchAction search_action;
            public String source_key;
            public List<SuggestionItem> suggestion_items;
            public String tag_name;

            @Override // com.squareup.wire.Message.Builder
            public SearchContext build() {
                return new SearchContext(this.tag_name, this.entity_items, this.common_filter, this.suggestion_items, this.source_key, this.search_action, this.need_intention_recognition, this.request_source, this.local_search_use_section, super.buildUnknownFields());
            }

            public Builder() {
                this.entity_items = Internal.newMutableList();
                this.suggestion_items = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder common_filter(UniversalFilters.CommonFilter r100) {
                this.common_filter = r100;
                return this;
            }

            public Builder entity_items(List<EntityItem> r100) {
                Internal.checkElementsNotNull(r100);
                this.entity_items = r100;
                return this;
            }

            public Builder local_search_use_section(Boolean r100) {
                this.local_search_use_section = r100;
                return this;
            }

            public Builder need_intention_recognition(Boolean r100) {
                this.need_intention_recognition = r100;
                return this;
            }

            public Builder request_source(RequestSource r100) {
                this.request_source = r100;
                return this;
            }

            public Builder search_action(SearchAction r100) {
                this.search_action = r100;
                return this;
            }

            public Builder source_key(String r100) {
                this.source_key = r100;
                return this;
            }

            public Builder suggestion_items(List<SuggestionItem> r100) {
                Internal.checkElementsNotNull(r100);
                this.suggestion_items = r100;
                return this;
            }

            public Builder tag_name(String r100) {
                this.tag_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchContext extends ProtoAdapter<SearchContext> {
            public ProtoAdapter_SearchContext() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchContext.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SearchContext decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.tag_name = "";
                r101.source_key = "";
                Boolean r102 = Boolean.FALSE;
                r101.need_intention_recognition = r102;
                r101.request_source = RequestSource.UNKNOWN;
                r101.local_search_use_section = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L19;
                switch(r104) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L21;
                    case 9: goto L7;
                    default: goto L6;
                };
            L21:
                r101.request_source = RequestSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.local_search_use_section = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.need_intention_recognition = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.search_action = SearchAction.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.source_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.suggestion_items.add(SuggestionItem.ADAPTER.decode(r100));
                goto L3
            L16:
                r101.common_filter = UniversalFilters.CommonFilter.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.entity_items.add(EntityItem.ADAPTER.decode(r100));
                goto L3
            L18:
                r101.tag_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L19:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SearchContext r100) {
                String r101 = r100.tag_name;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + EntityItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.entity_items);
                UniversalFilters.CommonFilter r105 = r100.common_filter;
                if (r105 == null) goto L9;
                int r106 = UniversalFilters.CommonFilter.ADAPTER.encodedSizeWithTag(3, r105);
            L10:
                int r107 = (r104 + r106) + SuggestionItem.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.suggestion_items);
                String r108 = r100.source_key;
                if (r108 == null) goto L13;
                int r109 = ProtoAdapter.STRING.encodedSizeWithTag(5, r108);
            L14:
                int r110 = r107 + r109;
                SearchAction r111 = r100.search_action;
                if (r111 == null) goto L17;
                int r112 = SearchAction.ADAPTER.encodedSizeWithTag(6, r111);
            L18:
                int r113 = r110 + r112;
                Boolean r114 = r100.need_intention_recognition;
                if (r114 == null) goto L21;
                int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r114);
            L22:
                int r116 = r113 + r115;
                RequestSource r117 = r100.request_source;
                if (r117 == null) goto L25;
                int r118 = RequestSource.ADAPTER.encodedSizeWithTag(8, r117);
            L26:
                int r119 = r116 + r118;
                Boolean r120 = r100.local_search_use_section;
                if (r120 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r120);
            L30:
                return (r119 + r102) + r100.unknownFields().size();
            L25:
                r118 = 0;
                goto L26
            L21:
                r115 = 0;
                goto L22
            L17:
                r112 = 0;
                goto L18
            L13:
                r109 = 0;
                goto L14
            L9:
                r106 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SearchContext decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SearchContext r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SearchContext r101) throws IOException {
                String r102 = r101.tag_name;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                EntityItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.entity_items);
                UniversalFilters.CommonFilter r103 = r101.common_filter;
                if (r103 == null) goto L8;
                UniversalFilters.CommonFilter.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                SuggestionItem.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.suggestion_items);
                String r104 = r101.source_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
            L11:
                SearchAction r105 = r101.search_action;
                if (r105 == null) goto L14;
                SearchAction.ADAPTER.encodeWithTag(r100, 6, r105);
            L14:
                Boolean r106 = r101.need_intention_recognition;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
            L17:
                RequestSource r107 = r101.request_source;
                if (r107 == null) goto L20;
                RequestSource.ADAPTER.encodeWithTag(r100, 8, r107);
            L20:
                Boolean r108 = r101.local_search_use_section;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchContext r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum RequestSource extends Enum<RequestSource> implements WireEnum {
            private static final /* synthetic */ RequestSource[] $VALUES = null;
            public static final ProtoAdapter<RequestSource> ADAPTER = null;
            public static final RequestSource COMBINE_SERVER_AND_HOLD = null;
            public static final RequestSource HOLD_ONLY = null;
            public static final RequestSource SERVER_ONLY = null;
            public static final RequestSource SPOTLIGHT_ONLY = null;
            public static final RequestSource UNKNOWN = null;
            private final int value;

            static {
                RequestSource r100 = new RequestSource("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                RequestSource r101 = new RequestSource("SPOTLIGHT_ONLY", 1, 1);
                SPOTLIGHT_ONLY = r101;
                RequestSource r102 = new RequestSource("SERVER_ONLY", 2, 2);
                SERVER_ONLY = r102;
                RequestSource r103 = new RequestSource("COMBINE_SERVER_AND_HOLD", 3, 3);
                COMBINE_SERVER_AND_HOLD = r103;
                RequestSource r104 = new RequestSource("HOLD_ONLY", 4, 4);
                HOLD_ONLY = r104;
                $VALUES = new RequestSource[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(RequestSource.class);
            }

            public static RequestSource[] values() {
                return (RequestSource[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static RequestSource fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return HOLD_ONLY;
            L16:
                return COMBINE_SERVER_AND_HOLD;
            L18:
                return SERVER_ONLY;
            L20:
                return SPOTLIGHT_ONLY;
            L22:
                return UNKNOWN;
            }

            public static RequestSource valueOf(String r100) {
                return (RequestSource) a.a(RequestSource.class, r100);
            }

            private RequestSource(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SearchContext();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_NEED_INTENTION_RECOGNITION = r100;
            DEFAULT_REQUEST_SOURCE = RequestSource.UNKNOWN;
            DEFAULT_LOCAL_SEARCH_USE_SECTION = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tag_name = this.tag_name;
            r100.entity_items = Internal.copyOf("entity_items", this.entity_items);
            r100.common_filter = this.common_filter;
            r100.suggestion_items = Internal.copyOf("suggestion_items", this.suggestion_items);
            r100.source_key = this.source_key;
            r100.search_action = this.search_action;
            r100.need_intention_recognition = this.need_intention_recognition;
            r100.request_source = this.request_source;
            r100.local_search_use_section = this.local_search_use_section;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SearchContext.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SearchContext(String r110, List<EntityItem> r111, UniversalFilters.CommonFilter r112, List<SuggestionItem> r113, String r114, SearchAction r115, Boolean r116, RequestSource r117, Boolean r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public SearchContext(String r100, List<EntityItem> r101, UniversalFilters.CommonFilter r102, List<SuggestionItem> r103, String r104, SearchAction r105, Boolean r106, RequestSource r107, Boolean r110, ByteString r111) {
            super(ADAPTER, r111);
            this.tag_name = r100;
            this.entity_items = Internal.immutableCopyOf("entity_items", r101);
            this.common_filter = r102;
            this.suggestion_items = Internal.immutableCopyOf("suggestion_items", r103);
            this.source_key = r104;
            this.search_action = r105;
            this.need_intention_recognition = r106;
            this.request_source = r107;
            this.local_search_use_section = r110;
        }
    }

    public static final class SearchExtras extends Message<SearchExtras, Builder> {
        public static final ProtoAdapter<SearchExtras> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE_DOC_USERPROFILE = null;
        public static final Boolean DEFAULT_ENABLE_DOUBAO_AI = null;
        public static final Boolean DEFAULT_ENABLE_FOLDER = null;
        public static final Boolean DEFAULT_ENABLE_MESSAGE_ATTACHMENT = null;
        public static final Boolean DEFAULT_ENABLE_SEARCH_IN_CHAT = null;
        public static final Boolean DEFAULT_ENABLE_SEARCH_RESOURCE_IN_CHAT = null;
        public static final Boolean DEFAULT_ENABLE_SECTION_CONFIG = null;
        public static final Boolean DEFAULT_ENABLE_SHORTCUT = null;
        public static final Boolean DEFAULT_EXPLANATION_TAG_ENABLE = null;
        public static final String DEFAULT_IMPRESSION_ID = "";
        public static final Boolean DEFAULT_INCLUDE_MY_AI = null;
        public static final Boolean DEFAULT_NEED_INSERT_DOUBAO_WORK = null;
        public static final Boolean DEFAULT_NEED_SHOW_PATH = null;
        public static final Integer DEFAULT_QUERY_INPUT_STATE = null;
        public static final Boolean DEFAULT_RENDER_DATA_ENABLE = null;
        public static final String DEFAULT_SEARCH_EXTRAS_STRING = "";
        private static final long serialVersionUID = 0;
        public final List<QuerySlice> adv_grammar_query_slices;
        public final ChatterPermissionsRequest chatter_permissions;
        public final Boolean enable_doc_userprofile;
        public final Boolean enable_doubao_ai;
        public final Boolean enable_folder;
        public final Boolean enable_message_attachment;
        public final Boolean enable_search_in_chat;
        public final Boolean enable_search_resource_in_chat;
        public final Boolean enable_section_config;
        public final Boolean enable_shortcut;
        public final Boolean explanation_tag_enable;
        public final String impression_id;
        public final Boolean include_my_ai;
        public final Boolean need_insert_doubao_work;
        public final Boolean need_show_path;
        public final QueryCompositionInfo query_composition_info;
        public final Integer query_input_state;
        public final List<QueryParserSupplier> query_parser_suppliers;
        public final Boolean render_data_enable;
        public final String search_extras_string;
        public final SugFilterParams sug_filter_params;

        public static final class Builder extends Message.Builder<SearchExtras, Builder> {
            public List<QuerySlice> adv_grammar_query_slices;
            public ChatterPermissionsRequest chatter_permissions;
            public Boolean enable_doc_userprofile;
            public Boolean enable_doubao_ai;
            public Boolean enable_folder;
            public Boolean enable_message_attachment;
            public Boolean enable_search_in_chat;
            public Boolean enable_search_resource_in_chat;
            public Boolean enable_section_config;
            public Boolean enable_shortcut;
            public Boolean explanation_tag_enable;
            public String impression_id;
            public Boolean include_my_ai;
            public Boolean need_insert_doubao_work;
            public Boolean need_show_path;
            public QueryCompositionInfo query_composition_info;
            public Integer query_input_state;
            public List<QueryParserSupplier> query_parser_suppliers;
            public Boolean render_data_enable;
            public String search_extras_string;
            public SugFilterParams sug_filter_params;

            @Override // com.squareup.wire.Message.Builder
            public SearchExtras build() {
                return new SearchExtras(this.search_extras_string, this.chatter_permissions, this.query_input_state, this.query_composition_info, this.impression_id, this.need_show_path, this.enable_folder, this.explanation_tag_enable, this.render_data_enable, this.enable_shortcut, this.include_my_ai, this.enable_message_attachment, this.enable_doc_userprofile, this.enable_section_config, this.sug_filter_params, this.enable_search_in_chat, this.enable_search_resource_in_chat, this.query_parser_suppliers, this.adv_grammar_query_slices, this.enable_doubao_ai, this.need_insert_doubao_work, super.buildUnknownFields());
            }

            public Builder() {
                this.query_parser_suppliers = Internal.newMutableList();
                this.adv_grammar_query_slices = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder adv_grammar_query_slices(List<QuerySlice> r100) {
                Internal.checkElementsNotNull(r100);
                this.adv_grammar_query_slices = r100;
                return this;
            }

            public Builder chatter_permissions(ChatterPermissionsRequest r100) {
                this.chatter_permissions = r100;
                return this;
            }

            public Builder enable_doc_userprofile(Boolean r100) {
                this.enable_doc_userprofile = r100;
                return this;
            }

            public Builder enable_doubao_ai(Boolean r100) {
                this.enable_doubao_ai = r100;
                return this;
            }

            public Builder enable_folder(Boolean r100) {
                this.enable_folder = r100;
                return this;
            }

            public Builder enable_message_attachment(Boolean r100) {
                this.enable_message_attachment = r100;
                return this;
            }

            public Builder enable_search_in_chat(Boolean r100) {
                this.enable_search_in_chat = r100;
                return this;
            }

            public Builder enable_search_resource_in_chat(Boolean r100) {
                this.enable_search_resource_in_chat = r100;
                return this;
            }

            public Builder enable_section_config(Boolean r100) {
                this.enable_section_config = r100;
                return this;
            }

            public Builder enable_shortcut(Boolean r100) {
                this.enable_shortcut = r100;
                return this;
            }

            public Builder explanation_tag_enable(Boolean r100) {
                this.explanation_tag_enable = r100;
                return this;
            }

            public Builder impression_id(String r100) {
                this.impression_id = r100;
                return this;
            }

            public Builder include_my_ai(Boolean r100) {
                this.include_my_ai = r100;
                return this;
            }

            public Builder need_insert_doubao_work(Boolean r100) {
                this.need_insert_doubao_work = r100;
                return this;
            }

            public Builder need_show_path(Boolean r100) {
                this.need_show_path = r100;
                return this;
            }

            public Builder query_composition_info(QueryCompositionInfo r100) {
                this.query_composition_info = r100;
                return this;
            }

            public Builder query_input_state(Integer r100) {
                this.query_input_state = r100;
                return this;
            }

            public Builder query_parser_suppliers(List<QueryParserSupplier> r100) {
                Internal.checkElementsNotNull(r100);
                this.query_parser_suppliers = r100;
                return this;
            }

            public Builder render_data_enable(Boolean r100) {
                this.render_data_enable = r100;
                return this;
            }

            public Builder search_extras_string(String r100) {
                this.search_extras_string = r100;
                return this;
            }

            public Builder sug_filter_params(SugFilterParams r100) {
                this.sug_filter_params = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchExtras extends ProtoAdapter<SearchExtras> {
            public ProtoAdapter_SearchExtras() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchExtras.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SearchExtras decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.search_extras_string = "";
                r101.query_input_state = 0;
                r101.impression_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.need_show_path = r102;
                r101.enable_folder = r102;
                r101.explanation_tag_enable = r102;
                r101.render_data_enable = r102;
                r101.enable_shortcut = r102;
                r101.include_my_ai = r102;
                r101.enable_message_attachment = r102;
                r101.enable_doc_userprofile = r102;
                r101.enable_section_config = r102;
                r101.enable_search_in_chat = r102;
                r101.enable_search_resource_in_chat = r102;
                r101.enable_doubao_ai = r102;
                r101.need_insert_doubao_work = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L28;
                switch(r104) {
                    case 1: goto L27;
                    case 2: goto L26;
                    case 3: goto L25;
                    case 4: goto L24;
                    case 5: goto L23;
                    case 6: goto L22;
                    case 7: goto L21;
                    case 8: goto L20;
                    case 9: goto L19;
                    case 10: goto L18;
                    case 11: goto L17;
                    case 12: goto L16;
                    case 13: goto L15;
                    case 14: goto L14;
                    case 15: goto L13;
                    case 16: goto L12;
                    case 17: goto L11;
                    case 18: goto L6;
                    case 19: goto L6;
                    case 20: goto L10;
                    case 21: goto L9;
                    case 22: goto L8;
                    case 23: goto L7;
                    default: goto L6;
                };
            L7:
                r101.need_insert_doubao_work = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.enable_doubao_ai = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.adv_grammar_query_slices.add(QuerySlice.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.query_parser_suppliers.add(QueryParserSupplier.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.enable_search_resource_in_chat = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.enable_search_in_chat = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.sug_filter_params = SugFilterParams.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.enable_section_config = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.enable_doc_userprofile = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.enable_message_attachment = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L17:
                r101.include_my_ai = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L18:
                r101.enable_shortcut = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L19:
                r101.render_data_enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L20:
                r101.explanation_tag_enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L21:
                r101.enable_folder = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L22:
                r101.need_show_path = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L23:
                r101.impression_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L24:
                r101.query_composition_info = QueryCompositionInfo.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.query_input_state = ProtoAdapter.INT32.decode(r100);
                goto L3
            L26:
                r101.chatter_permissions = ChatterPermissionsRequest.ADAPTER.decode(r100);
                goto L3
            L27:
                r101.search_extras_string = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L28:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SearchExtras r100) {
                String r101 = r100.search_extras_string;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ChatterPermissionsRequest r104 = r100.chatter_permissions;
                if (r104 == null) goto L9;
                int r105 = ChatterPermissionsRequest.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.query_input_state;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                QueryCompositionInfo r110 = r100.query_composition_info;
                if (r110 == null) goto L17;
                int r111 = QueryCompositionInfo.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.impression_id;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.need_show_path;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.enable_folder;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.explanation_tag_enable;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Boolean r125 = r100.render_data_enable;
                if (r125 == null) goto L37;
                int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                Boolean r128 = r100.enable_shortcut;
                if (r128 == null) goto L41;
                int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                Boolean r131 = r100.include_my_ai;
                if (r131 == null) goto L45;
                int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                Boolean r134 = r100.enable_message_attachment;
                if (r134 == null) goto L49;
                int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
            L50:
                int r136 = r133 + r135;
                Boolean r137 = r100.enable_doc_userprofile;
                if (r137 == null) goto L53;
                int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r137);
            L54:
                int r139 = r136 + r138;
                Boolean r140 = r100.enable_section_config;
                if (r140 == null) goto L57;
                int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r140);
            L58:
                int r142 = r139 + r141;
                SugFilterParams r143 = r100.sug_filter_params;
                if (r143 == null) goto L61;
                int r144 = SugFilterParams.ADAPTER.encodedSizeWithTag(15, r143);
            L62:
                int r145 = r142 + r144;
                Boolean r146 = r100.enable_search_in_chat;
                if (r146 == null) goto L65;
                int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r146);
            L66:
                int r148 = r145 + r147;
                Boolean r149 = r100.enable_search_resource_in_chat;
                if (r149 == null) goto L69;
                int r150 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r149);
            L70:
                int r151 = ((r148 + r150) + QueryParserSupplier.ADAPTER.asRepeated().encodedSizeWithTag(20, r100.query_parser_suppliers)) + QuerySlice.ADAPTER.asRepeated().encodedSizeWithTag(21, r100.adv_grammar_query_slices);
                Boolean r152 = r100.enable_doubao_ai;
                if (r152 == null) goto L73;
                int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r152);
            L74:
                int r154 = r151 + r153;
                Boolean r155 = r100.need_insert_doubao_work;
                if (r155 == null) goto L78;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r155);
            L78:
                return (r154 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ SearchExtras decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SearchExtras r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SearchExtras r101) throws IOException {
                String r102 = r101.search_extras_string;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ChatterPermissionsRequest r103 = r101.chatter_permissions;
                if (r103 == null) goto L8;
                ChatterPermissionsRequest.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.query_input_state;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                QueryCompositionInfo r105 = r101.query_composition_info;
                if (r105 == null) goto L14;
                QueryCompositionInfo.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.impression_id;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.need_show_path;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.enable_folder;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                Boolean r109 = r101.explanation_tag_enable;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
            L26:
                Boolean r110 = r101.render_data_enable;
                if (r110 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
            L29:
                Boolean r111 = r101.enable_shortcut;
                if (r111 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
            L32:
                Boolean r112 = r101.include_my_ai;
                if (r112 == null) goto L35;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
            L35:
                Boolean r113 = r101.enable_message_attachment;
                if (r113 == null) goto L38;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
            L38:
                Boolean r114 = r101.enable_doc_userprofile;
                if (r114 == null) goto L41;
                ProtoAdapter.BOOL.encodeWithTag(r100, 13, r114);
            L41:
                Boolean r115 = r101.enable_section_config;
                if (r115 == null) goto L44;
                ProtoAdapter.BOOL.encodeWithTag(r100, 14, r115);
            L44:
                SugFilterParams r116 = r101.sug_filter_params;
                if (r116 == null) goto L47;
                SugFilterParams.ADAPTER.encodeWithTag(r100, 15, r116);
            L47:
                Boolean r117 = r101.enable_search_in_chat;
                if (r117 == null) goto L50;
                ProtoAdapter.BOOL.encodeWithTag(r100, 16, r117);
            L50:
                Boolean r118 = r101.enable_search_resource_in_chat;
                if (r118 == null) goto L53;
                ProtoAdapter.BOOL.encodeWithTag(r100, 17, r118);
            L53:
                QueryParserSupplier.ADAPTER.asRepeated().encodeWithTag(r100, 20, r101.query_parser_suppliers);
                QuerySlice.ADAPTER.asRepeated().encodeWithTag(r100, 21, r101.adv_grammar_query_slices);
                Boolean r119 = r101.enable_doubao_ai;
                if (r119 == null) goto L56;
                ProtoAdapter.BOOL.encodeWithTag(r100, 22, r119);
            L56:
                Boolean r120 = r101.need_insert_doubao_work;
                if (r120 == null) goto L59;
                ProtoAdapter.BOOL.encodeWithTag(r100, 23, r120);
            L59:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchExtras r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class QueryCompositionInfo extends Message<QueryCompositionInfo, Builder> {
            public static final ProtoAdapter<QueryCompositionInfo> ADAPTER = null;
            public static final Integer DEFAULT_END = null;
            public static final Integer DEFAULT_START = null;
            private static final long serialVersionUID = 0;
            public final Integer end;
            public final Integer start;

            public static final class Builder extends Message.Builder<QueryCompositionInfo, Builder> {
                public Integer end;
                public Integer start;

                @Override // com.squareup.wire.Message.Builder
                public QueryCompositionInfo build() {
                    Integer r100 = this.start;
                    if (r100 == null) goto L9;
                    if (this.end == null) goto L9;
                    return new QueryCompositionInfo(this.start, this.end, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r100, "start", this.end, "end"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder end(Integer r100) {
                    this.end = r100;
                    return this;
                }

                public Builder start(Integer r100) {
                    this.start = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_QueryCompositionInfo extends ProtoAdapter<QueryCompositionInfo> {
                public ProtoAdapter_QueryCompositionInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, QueryCompositionInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public QueryCompositionInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.start = 0;
                    r101.end = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.start = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.end = ProtoAdapter.INT32.decode(r100);
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
                public int encodedSize2(QueryCompositionInfo r100) {
                    ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
                    return (r101.encodedSizeWithTag(1, r100.start) + r101.encodedSizeWithTag(2, r100.end)) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ QueryCompositionInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(QueryCompositionInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, QueryCompositionInfo r101) throws IOException {
                    ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
                    r102.encodeWithTag(r100, 1, r101.start);
                    r102.encodeWithTag(r100, 2, r101.end);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QueryCompositionInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_QueryCompositionInfo();
                DEFAULT_START = 0;
                DEFAULT_END = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.start = this.start;
                r100.end = this.end;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return QueryCompositionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public QueryCompositionInfo(Integer r100, Integer r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public QueryCompositionInfo(Integer r100, Integer r101, ByteString r102) {
                super(ADAPTER, r102);
                this.start = r100;
                this.end = r101;
            }
        }

        public static final class QuerySlice extends Message<QuerySlice, Builder> {
            public static final ProtoAdapter<QuerySlice> ADAPTER = null;
            public static final AdvGrammarConf.SelectorType DEFAULT_SELECTOR_TYPE = null;
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;
            public final AdvGrammarConf.SelectorType selector_type;
            public final String value;

            public static final class Builder extends Message.Builder<QuerySlice, Builder> {
                public AdvGrammarConf.SelectorType selector_type;
                public String value;

                @Override // com.squareup.wire.Message.Builder
                public QuerySlice build() {
                    return new QuerySlice(this.selector_type, this.value, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder selector_type(AdvGrammarConf.SelectorType r100) {
                    this.selector_type = r100;
                    return this;
                }

                public Builder value(String r100) {
                    this.value = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_QuerySlice extends ProtoAdapter<QuerySlice> {
                public ProtoAdapter_QuerySlice() {
                    super(FieldEncoding.LENGTH_DELIMITED, QuerySlice.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public QuerySlice decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.selector_type = AdvGrammarConf.SelectorType.ENUM_SELECTOR;
                    r101.value = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.selector_type = AdvGrammarConf.SelectorType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                L13:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.value = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(QuerySlice r100) {
                    AdvGrammarConf.SelectorType r101 = r100.selector_type;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = AdvGrammarConf.SelectorType.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.value;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ QuerySlice decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(QuerySlice r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, QuerySlice r101) throws IOException {
                    AdvGrammarConf.SelectorType r102 = r101.selector_type;
                    if (r102 == null) goto L5;
                    AdvGrammarConf.SelectorType.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.value;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuerySlice r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_QuerySlice();
                DEFAULT_SELECTOR_TYPE = AdvGrammarConf.SelectorType.ENUM_SELECTOR;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.selector_type = this.selector_type;
                r100.value = this.value;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return QuerySlice.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public QuerySlice(AdvGrammarConf.SelectorType r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public QuerySlice(AdvGrammarConf.SelectorType r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.selector_type = r100;
                this.value = r101;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SearchExtras();
            DEFAULT_QUERY_INPUT_STATE = 0;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_NEED_SHOW_PATH = r100;
            DEFAULT_ENABLE_FOLDER = r100;
            DEFAULT_EXPLANATION_TAG_ENABLE = r100;
            DEFAULT_RENDER_DATA_ENABLE = r100;
            DEFAULT_ENABLE_SHORTCUT = r100;
            DEFAULT_INCLUDE_MY_AI = r100;
            DEFAULT_ENABLE_MESSAGE_ATTACHMENT = r100;
            DEFAULT_ENABLE_DOC_USERPROFILE = r100;
            DEFAULT_ENABLE_SECTION_CONFIG = r100;
            DEFAULT_ENABLE_SEARCH_IN_CHAT = r100;
            DEFAULT_ENABLE_SEARCH_RESOURCE_IN_CHAT = r100;
            DEFAULT_ENABLE_DOUBAO_AI = r100;
            DEFAULT_NEED_INSERT_DOUBAO_WORK = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.search_extras_string = this.search_extras_string;
            r100.chatter_permissions = this.chatter_permissions;
            r100.query_input_state = this.query_input_state;
            r100.query_composition_info = this.query_composition_info;
            r100.impression_id = this.impression_id;
            r100.need_show_path = this.need_show_path;
            r100.enable_folder = this.enable_folder;
            r100.explanation_tag_enable = this.explanation_tag_enable;
            r100.render_data_enable = this.render_data_enable;
            r100.enable_shortcut = this.enable_shortcut;
            r100.include_my_ai = this.include_my_ai;
            r100.enable_message_attachment = this.enable_message_attachment;
            r100.enable_doc_userprofile = this.enable_doc_userprofile;
            r100.enable_section_config = this.enable_section_config;
            r100.sug_filter_params = this.sug_filter_params;
            r100.enable_search_in_chat = this.enable_search_in_chat;
            r100.enable_search_resource_in_chat = this.enable_search_resource_in_chat;
            r100.query_parser_suppliers = Internal.copyOf("query_parser_suppliers", this.query_parser_suppliers);
            r100.adv_grammar_query_slices = Internal.copyOf("adv_grammar_query_slices", this.adv_grammar_query_slices);
            r100.enable_doubao_ai = this.enable_doubao_ai;
            r100.need_insert_doubao_work = this.need_insert_doubao_work;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SearchExtras.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SearchExtras(String r210, ChatterPermissionsRequest r211, Integer r212, QueryCompositionInfo r213, String r214, Boolean r215, Boolean r310, Boolean r311, Boolean r312, Boolean r313, Boolean r314, Boolean r315, Boolean r316, Boolean r317, SugFilterParams r318, Boolean r319, Boolean r410, List<QueryParserSupplier> r411, List<QuerySlice> r412, Boolean r413, Boolean r414) {
            this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, ByteString.EMPTY);
        }

        public SearchExtras(String r100, ChatterPermissionsRequest r101, Integer r102, QueryCompositionInfo r103, String r104, Boolean r105, Boolean r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, Boolean r116, Boolean r117, SugFilterParams r118, Boolean r119, Boolean r210, List<QueryParserSupplier> r211, List<QuerySlice> r212, Boolean r213, Boolean r214, ByteString r215) {
            super(ADAPTER, r215);
            this.search_extras_string = r100;
            this.chatter_permissions = r101;
            this.query_input_state = r102;
            this.query_composition_info = r103;
            this.impression_id = r104;
            this.need_show_path = r105;
            this.enable_folder = r110;
            this.explanation_tag_enable = r111;
            this.render_data_enable = r112;
            this.enable_shortcut = r113;
            this.include_my_ai = r114;
            this.enable_message_attachment = r115;
            this.enable_doc_userprofile = r116;
            this.enable_section_config = r117;
            this.sug_filter_params = r118;
            this.enable_search_in_chat = r119;
            this.enable_search_resource_in_chat = r210;
            this.query_parser_suppliers = Internal.immutableCopyOf("query_parser_suppliers", r211);
            this.adv_grammar_query_slices = Internal.immutableCopyOf("adv_grammar_query_slices", r212);
            this.enable_doubao_ai = r213;
            this.need_insert_doubao_work = r214;
        }
    }

    public static final class SpotlightStrategy extends Message<SpotlightStrategy, Builder> {
        public static final ProtoAdapter<SpotlightStrategy> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE_LMSG_POS_FILTERING = null;
        public static final Boolean DEFAULT_ENABLE_SINGLE_RANK = null;
        private static final long serialVersionUID = 0;
        public final Boolean enable_lmsg_pos_filtering;
        public final Boolean enable_single_rank;

        public static final class Builder extends Message.Builder<SpotlightStrategy, Builder> {
            public Boolean enable_lmsg_pos_filtering;
            public Boolean enable_single_rank;

            @Override // com.squareup.wire.Message.Builder
            public SpotlightStrategy build() {
                return new SpotlightStrategy(this.enable_lmsg_pos_filtering, this.enable_single_rank, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder enable_lmsg_pos_filtering(Boolean r100) {
                this.enable_lmsg_pos_filtering = r100;
                return this;
            }

            public Builder enable_single_rank(Boolean r100) {
                this.enable_single_rank = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SpotlightStrategy extends ProtoAdapter<SpotlightStrategy> {
            public ProtoAdapter_SpotlightStrategy() {
                super(FieldEncoding.LENGTH_DELIMITED, SpotlightStrategy.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpotlightStrategy decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.enable_lmsg_pos_filtering = r102;
                r101.enable_single_rank = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.enable_lmsg_pos_filtering = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.enable_single_rank = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(SpotlightStrategy r100) {
                Boolean r101 = r100.enable_lmsg_pos_filtering;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.enable_single_rank;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SpotlightStrategy decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SpotlightStrategy r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SpotlightStrategy r101) throws IOException {
                Boolean r102 = r101.enable_lmsg_pos_filtering;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.enable_single_rank;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpotlightStrategy r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpotlightStrategy();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ENABLE_LMSG_POS_FILTERING = r100;
            DEFAULT_ENABLE_SINGLE_RANK = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.enable_lmsg_pos_filtering = this.enable_lmsg_pos_filtering;
            r100.enable_single_rank = this.enable_single_rank;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SpotlightStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SpotlightStrategy(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SpotlightStrategy(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.enable_lmsg_pos_filtering = r100;
            this.enable_single_rank = r101;
        }
    }

    public static final class SuggestionBooster extends Message<SuggestionBooster, Builder> {
        public static final ProtoAdapter<SuggestionBooster> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final UniversalBoosters.BaikeCardBooster baike_card_booster;

        public static final class Builder extends Message.Builder<SuggestionBooster, Builder> {
            public UniversalBoosters.BaikeCardBooster baike_card_booster;

            @Override // com.squareup.wire.Message.Builder
            public SuggestionBooster build() {
                return new SuggestionBooster(this.baike_card_booster, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder baike_card_booster(UniversalBoosters.BaikeCardBooster r100) {
                this.baike_card_booster = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SuggestionBooster extends ProtoAdapter<SuggestionBooster> {
            public ProtoAdapter_SuggestionBooster() {
                super(FieldEncoding.LENGTH_DELIMITED, SuggestionBooster.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SuggestionBooster decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.baike_card_booster(UniversalBoosters.BaikeCardBooster.ADAPTER.decode(r100));
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
            public int encodedSize2(SuggestionBooster r100) {
                UniversalBoosters.BaikeCardBooster r101 = r100.baike_card_booster;
                if (r101 == null) goto L5;
                int r102 = UniversalBoosters.BaikeCardBooster.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SuggestionBooster decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SuggestionBooster r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SuggestionBooster r101) throws IOException {
                UniversalBoosters.BaikeCardBooster r102 = r101.baike_card_booster;
                if (r102 == null) goto L5;
                UniversalBoosters.BaikeCardBooster.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SuggestionBooster r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SuggestionBooster();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.baike_card_booster = this.baike_card_booster;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SuggestionBooster.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SuggestionBooster(UniversalBoosters.BaikeCardBooster r100) {
            this(r100, ByteString.EMPTY);
        }

        public SuggestionBooster(UniversalBoosters.BaikeCardBooster r100, ByteString r101) {
            super(ADAPTER, r101);
            this.baike_card_booster = r100;
        }
    }

    public static final class SuggestionItem extends Message<SuggestionItem, Builder> {
        public static final ProtoAdapter<SuggestionItem> ADAPTER = null;
        public static final SuggestionType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final SuggestionBooster booster;
        public final SuggestionSelector selector;
        public final SuggestionType type;

        public static final class Builder extends Message.Builder<SuggestionItem, Builder> {
            public SuggestionBooster booster;
            public SuggestionSelector selector;
            public SuggestionType type;

            @Override // com.squareup.wire.Message.Builder
            public SuggestionItem build() {
                SuggestionType r100 = this.type;
                if (r100 == null) goto L7;
                return new SuggestionItem(this.type, this.selector, this.booster, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder booster(SuggestionBooster r100) {
                this.booster = r100;
                return this;
            }

            public Builder selector(SuggestionSelector r100) {
                this.selector = r100;
                return this;
            }

            public Builder type(SuggestionType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SuggestionItem extends ProtoAdapter<SuggestionItem> {
            public ProtoAdapter_SuggestionItem() {
                super(FieldEncoding.LENGTH_DELIMITED, SuggestionItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SuggestionItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = SuggestionType.UNKNOWN_SUGGESTION;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.type = SuggestionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.selector = SuggestionSelector.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.booster = SuggestionBooster.ADAPTER.decode(r100);
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
            public int encodedSize2(SuggestionItem r100) {
                int r101 = SuggestionType.ADAPTER.encodedSizeWithTag(1, r100.type);
                SuggestionSelector r102 = r100.selector;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = SuggestionSelector.ADAPTER.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                SuggestionBooster r106 = r100.booster;
                if (r106 == null) goto L10;
                r103 = SuggestionBooster.ADAPTER.encodedSizeWithTag(3, r106);
            L10:
                return (r105 + r103) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SuggestionItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SuggestionItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SuggestionItem r101) throws IOException {
                SuggestionType.ADAPTER.encodeWithTag(r100, 1, r101.type);
                SuggestionSelector r102 = r101.selector;
                if (r102 == null) goto L5;
                SuggestionSelector.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                SuggestionBooster r103 = r101.booster;
                if (r103 == null) goto L8;
                SuggestionBooster.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SuggestionItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SuggestionItem();
            DEFAULT_TYPE = SuggestionType.UNKNOWN_SUGGESTION;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.selector = this.selector;
            r100.booster = this.booster;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SuggestionItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SuggestionItem(SuggestionType r100, SuggestionSelector r101, SuggestionBooster r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SuggestionItem(SuggestionType r100, SuggestionSelector r101, SuggestionBooster r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.selector = r101;
            this.booster = r102;
        }
    }

    public static final class SuggestionSelector extends Message<SuggestionSelector, Builder> {
        public static final ProtoAdapter<SuggestionSelector> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final UniversalSelectors.RecommendFilterSelector recommend_filter_selector;
        public final UniversalSelectors.ServiceCardSelector service_card_selector;

        public static final class Builder extends Message.Builder<SuggestionSelector, Builder> {
            public UniversalSelectors.RecommendFilterSelector recommend_filter_selector;
            public UniversalSelectors.ServiceCardSelector service_card_selector;

            @Override // com.squareup.wire.Message.Builder
            public SuggestionSelector build() {
                return new SuggestionSelector(this.recommend_filter_selector, this.service_card_selector, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder recommend_filter_selector(UniversalSelectors.RecommendFilterSelector r100) {
                this.recommend_filter_selector = r100;
                this.service_card_selector = null;
                return this;
            }

            public Builder service_card_selector(UniversalSelectors.ServiceCardSelector r100) {
                this.service_card_selector = r100;
                this.recommend_filter_selector = null;
                return this;
            }
        }

        public static final class ProtoAdapter_SuggestionSelector extends ProtoAdapter<SuggestionSelector> {
            public ProtoAdapter_SuggestionSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, SuggestionSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SuggestionSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.recommend_filter_selector(UniversalSelectors.RecommendFilterSelector.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.service_card_selector(UniversalSelectors.ServiceCardSelector.ADAPTER.decode(r100));
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
            public int encodedSize2(SuggestionSelector r100) {
                UniversalSelectors.RecommendFilterSelector r101 = r100.recommend_filter_selector;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = UniversalSelectors.RecommendFilterSelector.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                UniversalSelectors.ServiceCardSelector r104 = r100.service_card_selector;
                if (r104 == null) goto L10;
                r102 = UniversalSelectors.ServiceCardSelector.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SuggestionSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SuggestionSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SuggestionSelector r101) throws IOException {
                UniversalSelectors.RecommendFilterSelector r102 = r101.recommend_filter_selector;
                if (r102 == null) goto L5;
                UniversalSelectors.RecommendFilterSelector.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                UniversalSelectors.ServiceCardSelector r103 = r101.service_card_selector;
                if (r103 == null) goto L8;
                UniversalSelectors.ServiceCardSelector.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SuggestionSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SuggestionSelector();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.recommend_filter_selector = this.recommend_filter_selector;
            r100.service_card_selector = this.service_card_selector;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SuggestionSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SuggestionSelector(UniversalSelectors.RecommendFilterSelector r100, UniversalSelectors.ServiceCardSelector r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SuggestionSelector(UniversalSelectors.RecommendFilterSelector r100, UniversalSelectors.ServiceCardSelector r101, ByteString r102) {
            super(ADAPTER, r102);
            if (Internal.countNonNull(r100, r101) > 1) goto L7;
            this.recommend_filter_selector = r100;
            this.service_card_selector = r101;
            return;
        L7:
            throw new IllegalArgumentException("at most one of recommend_filter_selector, service_card_selector may be non-null");
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BaseEntity();
    }

    public BaseEntity() {
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
        return BaseEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BaseEntity(ByteString r100) {
        super(ADAPTER, r100);
    }
}
