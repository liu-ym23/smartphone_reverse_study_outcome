package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.basic.v1.DocSortRuleType;
import com.bytedance.lark.pb.basic.v1.GroupSortRuleType;
import com.bytedance.lark.pb.basic.v1.UserGroupSceneType;
import com.bytedance.lark.pb.basic.v1.UserGroupType;
import com.bytedance.lark.pb.search.common.SearchTabName;
import com.google.protobuf.MessageOptions;
import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.aweme.editSticker.model.StickerMobParams;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalFilters extends Message<UniversalFilters, Builder> {
    public static final ProtoAdapter<UniversalFilters> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class BannerFilter extends Message<BannerFilter, Builder> {
        public static final ProtoAdapter<BannerFilter> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_SUPPORT_V2 = null;
        public static final SearchTabName DEFAULT_SEARCH_TAB = null;
        private static final long serialVersionUID = 0;
        public final List<BannerActionType> banner_actions;
        public final Boolean can_support_v2;
        public final SearchTabName search_tab;

        public static final class Builder extends Message.Builder<BannerFilter, Builder> {
            public List<BannerActionType> banner_actions;
            public Boolean can_support_v2;
            public SearchTabName search_tab;

            @Override // com.squareup.wire.Message.Builder
            public BannerFilter build() {
                SearchTabName r100 = this.search_tab;
                if (r100 == null) goto L7;
                return new BannerFilter(this.search_tab, this.can_support_v2, this.banner_actions, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, StickerMobParams.FROM_SEARCH});
            }

            public Builder() {
                this.banner_actions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder banner_actions(List<BannerActionType> r100) {
                Internal.checkElementsNotNull(r100);
                this.banner_actions = r100;
                return this;
            }

            public Builder can_support_v2(Boolean r100) {
                this.can_support_v2 = r100;
                return this;
            }

            public Builder search_tab(SearchTabName r100) {
                this.search_tab = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BannerFilter extends ProtoAdapter<BannerFilter> {
            public ProtoAdapter_BannerFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, BannerFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BannerFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.search_tab = SearchTabName.UNKNOWN_TAB;
                r101.can_support_v2 = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.search_tab = SearchTabName.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.can_support_v2 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.banner_actions.add(BannerActionType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(BannerFilter r100) {
                int r101 = SearchTabName.ADAPTER.encodedSizeWithTag(1, r100.search_tab);
                Boolean r102 = r100.can_support_v2;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
            L7:
                return ((r101 + r103) + BannerActionType.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.banner_actions)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BannerFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BannerFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BannerFilter r101) throws IOException {
                SearchTabName.ADAPTER.encodeWithTag(r100, 1, r101.search_tab);
                Boolean r102 = r101.can_support_v2;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
            L5:
                BannerActionType.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.banner_actions);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BannerFilter();
            DEFAULT_SEARCH_TAB = SearchTabName.UNKNOWN_TAB;
            DEFAULT_CAN_SUPPORT_V2 = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.search_tab = this.search_tab;
            r100.can_support_v2 = this.can_support_v2;
            r100.banner_actions = Internal.copyOf("banner_actions", this.banner_actions);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BannerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public BannerFilter(SearchTabName r100, Boolean r101, List<BannerActionType> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public BannerFilter(SearchTabName r100, Boolean r101, List<BannerActionType> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.search_tab = r100;
            this.can_support_v2 = r101;
            this.banner_actions = Internal.immutableCopyOf("banner_actions", r102);
        }
    }

    public static final class BotFilter extends Message<BotFilter, Builder> {
        public static final ProtoAdapter<BotFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> chat_ids;
        public final List<Integer> search_type;

        public static final class Builder extends Message.Builder<BotFilter, Builder> {
            public List<String> chat_ids;
            public List<Integer> search_type;

            @Override // com.squareup.wire.Message.Builder
            public BotFilter build() {
                return new BotFilter(this.search_type, this.chat_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.search_type = Internal.newMutableList();
                this.chat_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_ids = r100;
                return this;
            }

            public Builder search_type(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BotFilter extends ProtoAdapter<BotFilter> {
            public ProtoAdapter_BotFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, BotFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BotFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.search_type.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(BotFilter r100) {
                return (ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(1, r100.search_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.chat_ids)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BotFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BotFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BotFilter r101) throws IOException {
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 1, r101.search_type);
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.chat_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType ALL = null;
            public static final SearchType TALKED = null;
            public static final SearchType UN_TALKED = null;
            private final int value;

            static {
                SearchType r100 = new SearchType(AccountType.ALL, 0, 0);
                ALL = r100;
                SearchType r101 = new SearchType("TALKED", 1, 1);
                TALKED = r101;
                SearchType r102 = new SearchType("UN_TALKED", 2, 2);
                UN_TALKED = r102;
                $VALUES = new SearchType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return UN_TALKED;
            L12:
                return TALKED;
            L14:
                return ALL;
            }

            public static SearchType valueOf(String r100) {
                return (SearchType) a.a(SearchType.class, r100);
            }

            private SearchType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BotFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.search_type = Internal.copyOf("search_type", this.search_type);
            r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BotFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public BotFilter(List<Integer> r100, List<String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public BotFilter(List<Integer> r100, List<String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.search_type = Internal.immutableCopyOf("search_type", r100);
            this.chat_ids = Internal.immutableCopyOf("chat_ids", r101);
        }
    }

    public static final class Builder extends Message.Builder<UniversalFilters, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public UniversalFilters build() {
            return new UniversalFilters(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ChatFilter extends Message<ChatFilter, Builder> {
        public static final ProtoAdapter<ChatFilter> ADAPTER = null;
        public static final Boolean DEFAULT_ADDABLE_AS_USER = null;
        public static final Boolean DEFAULT_CLOSE_SEARCH_BY_USER = null;
        public static final Boolean DEFAULT_NEED_FROZEN_CHAT = null;
        public static final Boolean DEFAULT_SEARCH_SHIELD = null;
        public static final GroupSortRuleType DEFAULT_SORTTYPE = null;
        private static final long serialVersionUID = 0;
        public final Boolean addable_as_user;
        public final List<String> chat_member_ids;
        public final List<Chat.ChatMode> chat_modes;
        public final List<Chat.Type> chat_types;
        public final Boolean close_search_by_user;
        public final List<String> excluded_chat_ids;
        public final Boolean need_frozen_chat;
        public final Boolean search_shield;
        public final List<Integer> search_types;
        public final GroupSortRuleType sortType;

        public static final class Builder extends Message.Builder<ChatFilter, Builder> {
            public Boolean addable_as_user;
            public List<String> chat_member_ids;
            public List<Chat.ChatMode> chat_modes;
            public List<Chat.Type> chat_types;
            public Boolean close_search_by_user;
            public List<String> excluded_chat_ids;
            public Boolean need_frozen_chat;
            public Boolean search_shield;
            public List<Integer> search_types;
            public GroupSortRuleType sortType;

            @Override // com.squareup.wire.Message.Builder
            public ChatFilter build() {
                return new ChatFilter(this.chat_types, this.chat_modes, this.search_types, this.chat_member_ids, this.excluded_chat_ids, this.addable_as_user, this.sortType, this.search_shield, this.close_search_by_user, this.need_frozen_chat, super.buildUnknownFields());
            }

            public Builder() {
                this.chat_types = Internal.newMutableList();
                this.chat_modes = Internal.newMutableList();
                this.search_types = Internal.newMutableList();
                this.chat_member_ids = Internal.newMutableList();
                this.excluded_chat_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder addable_as_user(Boolean r100) {
                this.addable_as_user = r100;
                return this;
            }

            public Builder chat_member_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_member_ids = r100;
                return this;
            }

            public Builder chat_modes(List<Chat.ChatMode> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_modes = r100;
                return this;
            }

            public Builder chat_types(List<Chat.Type> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_types = r100;
                return this;
            }

            public Builder close_search_by_user(Boolean r100) {
                this.close_search_by_user = r100;
                return this;
            }

            public Builder excluded_chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.excluded_chat_ids = r100;
                return this;
            }

            public Builder need_frozen_chat(Boolean r100) {
                this.need_frozen_chat = r100;
                return this;
            }

            public Builder search_shield(Boolean r100) {
                this.search_shield = r100;
                return this;
            }

            public Builder search_types(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_types = r100;
                return this;
            }

            public Builder sortType(GroupSortRuleType r100) {
                this.sortType = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatFilter extends ProtoAdapter<ChatFilter> {
            public ProtoAdapter_ChatFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.addable_as_user = r102;
                r101.sortType = GroupSortRuleType.GROUP_DEFAULT_SORT;
                r101.search_shield = r102;
                r101.close_search_by_user = r102;
                r101.need_frozen_chat = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L26;
                switch(r104) {
                    case 1: goto L28;
                    case 2: goto L32;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L30;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L28:
                r101.chat_types.add(Chat.Type.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r101.sortType = GroupSortRuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.chat_modes.add(Chat.ChatMode.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.need_frozen_chat = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.close_search_by_user = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.search_shield = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                r101.addable_as_user = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.excluded_chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L16:
                r101.chat_member_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L17:
                r101.search_types.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L26:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatFilter r100) {
                int r101 = (Chat.Type.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chat_types) + Chat.ChatMode.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.chat_modes)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r100.search_types);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                int r103 = (r101 + r102.asRepeated().encodedSizeWithTag(4, r100.chat_member_ids)) + r102.asRepeated().encodedSizeWithTag(5, r100.excluded_chat_ids);
                Boolean r104 = r100.addable_as_user;
                int r105 = 0;
                if (r104 == null) goto L5;
                int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r104);
            L6:
                int r107 = r103 + r106;
                GroupSortRuleType r108 = r100.sortType;
                if (r108 == null) goto L9;
                int r109 = GroupSortRuleType.ADAPTER.encodedSizeWithTag(7, r108);
            L10:
                int r110 = r107 + r109;
                Boolean r111 = r100.search_shield;
                if (r111 == null) goto L13;
                int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r111);
            L14:
                int r113 = r110 + r112;
                Boolean r114 = r100.close_search_by_user;
                if (r114 == null) goto L17;
                int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r114);
            L18:
                int r116 = r113 + r115;
                Boolean r117 = r100.need_frozen_chat;
                if (r117 == null) goto L22;
                r105 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r117);
            L22:
                return (r116 + r105) + r100.unknownFields().size();
            L17:
                r115 = 0;
                goto L18
            L13:
                r112 = 0;
                goto L14
            L9:
                r109 = 0;
                goto L10
            L5:
                r106 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatFilter r101) throws IOException {
                Chat.Type.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chat_types);
                Chat.ChatMode.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.chat_modes);
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 3, r101.search_types);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 4, r101.chat_member_ids);
                r102.asRepeated().encodeWithTag(r100, 5, r101.excluded_chat_ids);
                Boolean r103 = r101.addable_as_user;
                if (r103 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r103);
            L5:
                GroupSortRuleType r104 = r101.sortType;
                if (r104 == null) goto L8;
                GroupSortRuleType.ADAPTER.encodeWithTag(r100, 7, r104);
            L8:
                Boolean r105 = r101.search_shield;
                if (r105 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r105);
            L11:
                Boolean r106 = r101.close_search_by_user;
                if (r106 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r106);
            L14:
                Boolean r107 = r101.need_frozen_chat;
                if (r107 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r107);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType ALL = null;
            public static final SearchType CROSS_TENANT = null;
            public static final SearchType CRYPTO = null;
            public static final SearchType JOINED = null;
            public static final SearchType NORMAL = null;
            public static final SearchType PRIVATE = null;
            public static final SearchType PUBLIC = null;
            public static final SearchType UN_CROSS_TENANT = null;
            public static final SearchType UN_JOINED = null;
            private final int value;

            static {
                SearchType r100 = new SearchType(AccountType.ALL, 0, 0);
                ALL = r100;
                SearchType r101 = new SearchType("JOINED", 1, 1);
                JOINED = r101;
                SearchType r102 = new SearchType("UN_JOINED", 2, 2);
                UN_JOINED = r102;
                SearchType r103 = new SearchType("PRIVATE", 3, 4);
                PRIVATE = r103;
                SearchType r104 = new SearchType("PUBLIC", 4, 8);
                PUBLIC = r104;
                SearchType r110 = new SearchType("CROSS_TENANT", 5, 16);
                CROSS_TENANT = r110;
                SearchType r111 = new SearchType("UN_CROSS_TENANT", 6, 32);
                UN_CROSS_TENANT = r111;
                SearchType r112 = new SearchType("CRYPTO", 7, 64);
                CRYPTO = r112;
                SearchType r113 = new SearchType(EffectConstants.NORMAL, 8, 128);
                NORMAL = r113;
                $VALUES = new SearchType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r100) {
                if (r100 == 0) goto L38;
                if (r100 == 1) goto L36;
                if (r100 == 2) goto L34;
                if (r100 == 4) goto L32;
                if (r100 == 8) goto L30;
                if (r100 == 16) goto L28;
                if (r100 == 32) goto L26;
                if (r100 == 64) goto L24;
                if (r100 == 128) goto L22;
                return null;
            L22:
                return NORMAL;
            L24:
                return CRYPTO;
            L26:
                return UN_CROSS_TENANT;
            L28:
                return CROSS_TENANT;
            L30:
                return PUBLIC;
            L32:
                return PRIVATE;
            L34:
                return UN_JOINED;
            L36:
                return JOINED;
            L38:
                return ALL;
            }

            public static SearchType valueOf(String r100) {
                return (SearchType) a.a(SearchType.class, r100);
            }

            private SearchType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatFilter();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ADDABLE_AS_USER = r100;
            DEFAULT_SORTTYPE = GroupSortRuleType.GROUP_DEFAULT_SORT;
            DEFAULT_SEARCH_SHIELD = r100;
            DEFAULT_CLOSE_SEARCH_BY_USER = r100;
            DEFAULT_NEED_FROZEN_CHAT = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_types = Internal.copyOf("chat_types", this.chat_types);
            r100.chat_modes = Internal.copyOf("chat_modes", this.chat_modes);
            r100.search_types = Internal.copyOf("search_types", this.search_types);
            r100.chat_member_ids = Internal.copyOf("chat_member_ids", this.chat_member_ids);
            r100.excluded_chat_ids = Internal.copyOf("excluded_chat_ids", this.excluded_chat_ids);
            r100.addable_as_user = this.addable_as_user;
            r100.sortType = this.sortType;
            r100.search_shield = this.search_shield;
            r100.close_search_by_user = this.close_search_by_user;
            r100.need_frozen_chat = this.need_frozen_chat;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatFilter(List<Chat.Type> r110, List<Chat.ChatMode> r111, List<Integer> r112, List<String> r113, List<String> r114, Boolean r115, GroupSortRuleType r116, Boolean r210, Boolean r211, Boolean r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public ChatFilter(List<Chat.Type> r100, List<Chat.ChatMode> r101, List<Integer> r102, List<String> r103, List<String> r104, Boolean r105, GroupSortRuleType r106, Boolean r107, Boolean r110, Boolean r111, ByteString r112) {
            super(ADAPTER, r112);
            this.chat_types = Internal.immutableCopyOf("chat_types", r100);
            this.chat_modes = Internal.immutableCopyOf("chat_modes", r101);
            this.search_types = Internal.immutableCopyOf("search_types", r102);
            this.chat_member_ids = Internal.immutableCopyOf("chat_member_ids", r103);
            this.excluded_chat_ids = Internal.immutableCopyOf("excluded_chat_ids", r104);
            this.addable_as_user = r105;
            this.sortType = r106;
            this.search_shield = r107;
            this.close_search_by_user = r110;
            this.need_frozen_chat = r111;
        }
    }

    public static final class ChatInfo extends Message<ChatInfo, Builder> {
        public static final ProtoAdapter<ChatInfo> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final ChatType DEFAULT_CHAT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final ChatType chat_type;

        public static final class Builder extends Message.Builder<ChatInfo, Builder> {
            public String chat_id;
            public ChatType chat_type;

            @Override // com.squareup.wire.Message.Builder
            public ChatInfo build() {
                return new ChatInfo(this.chat_id, this.chat_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder chat_type(ChatType r100) {
                this.chat_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatInfo extends ProtoAdapter<ChatInfo> {
            public ProtoAdapter_ChatInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_id = "";
                r101.chat_type = ChatType.GROUP_CHAT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.chat_type = ChatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
            public int encodedSize2(ChatInfo r100) {
                String r101 = r100.chat_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ChatType r104 = r100.chat_type;
                if (r104 == null) goto L10;
                r102 = ChatType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatInfo r101) throws IOException {
                String r102 = r101.chat_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ChatType r103 = r101.chat_type;
                if (r103 == null) goto L8;
                ChatType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatInfo();
            DEFAULT_CHAT_TYPE = ChatType.GROUP_CHAT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_id = this.chat_id;
            r100.chat_type = this.chat_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatInfo(String r100, ChatType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ChatInfo(String r100, ChatType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.chat_id = r100;
            this.chat_type = r101;
        }
    }

    public static final enum ChatType extends Enum<ChatType> implements WireEnum {
        private static final /* synthetic */ ChatType[] $VALUES = null;
        public static final ProtoAdapter<ChatType> ADAPTER = null;
        public static final ChatType GROUP_CHAT = null;
        public static final ChatType P2P_CHAT = null;
        private final int value;

        static {
            ChatType r100 = new ChatType("GROUP_CHAT", 0, 1);
            GROUP_CHAT = r100;
            ChatType r101 = new ChatType("P2P_CHAT", 1, 2);
            P2P_CHAT = r101;
            $VALUES = new ChatType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatType.class);
        }

        public static ChatType[] values() {
            return (ChatType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return P2P_CHAT;
        L11:
            return GROUP_CHAT;
        }

        public static ChatType valueOf(String r100) {
            return (ChatType) a.a(ChatType.class, r100);
        }

        private ChatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class CommonFilter extends Message<CommonFilter, Builder> {
        public static final ProtoAdapter<CommonFilter> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        public static final Boolean DEFAULT_INCLUDE_OUTER_TENANT = null;
        public static final Boolean DEFAULT_USE_EXTENDED_SEARCH_V2 = null;
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final List<ChatInfo> chat_infos;
        public final Boolean enable_extended_search;
        public final List<String> from_user_ids;
        public final List<String> in_chat_ids;
        public final Boolean include_outer_tenant;
        public final List<SearchQABizType> search_qa_biz_type;
        public final TimeRange time_range;
        public final Boolean use_extended_search_v2;
        public final List<String> with_user_ids;

        public static final class Builder extends Message.Builder<CommonFilter, Builder> {
            public String chat_id;
            public List<ChatInfo> chat_infos;
            public Boolean enable_extended_search;
            public List<String> from_user_ids;
            public List<String> in_chat_ids;
            public Boolean include_outer_tenant;
            public List<SearchQABizType> search_qa_biz_type;
            public TimeRange time_range;
            public Boolean use_extended_search_v2;
            public List<String> with_user_ids;

            @Override // com.squareup.wire.Message.Builder
            public CommonFilter build() {
                return new CommonFilter(this.include_outer_tenant, this.chat_id, this.from_user_ids, this.in_chat_ids, this.time_range, this.with_user_ids, this.enable_extended_search, this.use_extended_search_v2, this.chat_infos, this.search_qa_biz_type, super.buildUnknownFields());
            }

            public Builder() {
                this.from_user_ids = Internal.newMutableList();
                this.in_chat_ids = Internal.newMutableList();
                this.with_user_ids = Internal.newMutableList();
                this.chat_infos = Internal.newMutableList();
                this.search_qa_biz_type = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder chat_infos(List<ChatInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_infos = r100;
                return this;
            }

            public Builder enable_extended_search(Boolean r100) {
                this.enable_extended_search = r100;
                return this;
            }

            public Builder from_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.from_user_ids = r100;
                return this;
            }

            public Builder in_chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.in_chat_ids = r100;
                return this;
            }

            public Builder include_outer_tenant(Boolean r100) {
                this.include_outer_tenant = r100;
                return this;
            }

            public Builder search_qa_biz_type(List<SearchQABizType> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_qa_biz_type = r100;
                return this;
            }

            public Builder time_range(TimeRange r100) {
                this.time_range = r100;
                return this;
            }

            public Builder use_extended_search_v2(Boolean r100) {
                this.use_extended_search_v2 = r100;
                return this;
            }

            public Builder with_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.with_user_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CommonFilter extends ProtoAdapter<CommonFilter> {
            public ProtoAdapter_CommonFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, CommonFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CommonFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.include_outer_tenant = Boolean.TRUE;
                r101.chat_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.enable_extended_search = r102;
                r101.use_extended_search_v2 = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L20;
                switch(r104) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L6;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L11;
                    case 11: goto L22;
                    default: goto L6;
                };
            L22:
                r101.search_qa_biz_type.add(SearchQABizType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.chat_infos.add(ChatInfo.ADAPTER.decode(r100));
                goto L3
            L12:
                r101.use_extended_search_v2 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.enable_extended_search = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                r101.with_user_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L15:
                r101.time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.in_chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L17:
                r101.from_user_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L18:
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.include_outer_tenant = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L20:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CommonFilter r100) {
                Boolean r101 = r100.include_outer_tenant;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.chat_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ProtoAdapter<String> r107 = ProtoAdapter.STRING;
                int r108 = (r106 + r107.asRepeated().encodedSizeWithTag(3, r100.from_user_ids)) + r107.asRepeated().encodedSizeWithTag(4, r100.in_chat_ids);
                TimeRange r109 = r100.time_range;
                if (r109 == null) goto L13;
                int r110 = TimeRange.ADAPTER.encodedSizeWithTag(5, r109);
            L14:
                int r111 = (r108 + r110) + r107.asRepeated().encodedSizeWithTag(7, r100.with_user_ids);
                Boolean r112 = r100.enable_extended_search;
                if (r112 == null) goto L17;
                int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r112);
            L18:
                int r114 = r111 + r113;
                Boolean r115 = r100.use_extended_search_v2;
                if (r115 == null) goto L22;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r115);
            L22:
                return (((r114 + r102) + ChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.chat_infos)) + SearchQABizType.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.search_qa_biz_type)) + r100.unknownFields().size();
            L17:
                r113 = 0;
                goto L18
            L13:
                r110 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CommonFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CommonFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CommonFilter r101) throws IOException {
                Boolean r102 = r101.include_outer_tenant;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.chat_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                r104.asRepeated().encodeWithTag(r100, 3, r101.from_user_ids);
                r104.asRepeated().encodeWithTag(r100, 4, r101.in_chat_ids);
                TimeRange r105 = r101.time_range;
                if (r105 == null) goto L11;
                TimeRange.ADAPTER.encodeWithTag(r100, 5, r105);
            L11:
                r104.asRepeated().encodeWithTag(r100, 7, r101.with_user_ids);
                Boolean r106 = r101.enable_extended_search;
                if (r106 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r106);
            L14:
                Boolean r107 = r101.use_extended_search_v2;
                if (r107 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
            L17:
                ChatInfo.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.chat_infos);
                SearchQABizType.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.search_qa_biz_type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommonFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CommonFilter();
            DEFAULT_INCLUDE_OUTER_TENANT = Boolean.TRUE;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ENABLE_EXTENDED_SEARCH = r100;
            DEFAULT_USE_EXTENDED_SEARCH_V2 = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.include_outer_tenant = this.include_outer_tenant;
            r100.chat_id = this.chat_id;
            r100.from_user_ids = Internal.copyOf("from_user_ids", this.from_user_ids);
            r100.in_chat_ids = Internal.copyOf("in_chat_ids", this.in_chat_ids);
            r100.time_range = this.time_range;
            r100.with_user_ids = Internal.copyOf("with_user_ids", this.with_user_ids);
            r100.enable_extended_search = this.enable_extended_search;
            r100.use_extended_search_v2 = this.use_extended_search_v2;
            r100.chat_infos = Internal.copyOf("chat_infos", this.chat_infos);
            r100.search_qa_biz_type = Internal.copyOf("search_qa_biz_type", this.search_qa_biz_type);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CommonFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CommonFilter(Boolean r110, String r111, List<String> r112, List<String> r113, TimeRange r114, List<String> r115, Boolean r116, Boolean r210, List<ChatInfo> r211, List<SearchQABizType> r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public CommonFilter(Boolean r100, String r101, List<String> r102, List<String> r103, TimeRange r104, List<String> r105, Boolean r106, Boolean r107, List<ChatInfo> r110, List<SearchQABizType> r111, ByteString r112) {
            super(ADAPTER, r112);
            this.include_outer_tenant = r100;
            this.chat_id = r101;
            this.from_user_ids = Internal.immutableCopyOf("from_user_ids", r102);
            this.in_chat_ids = Internal.immutableCopyOf("in_chat_ids", r103);
            this.time_range = r104;
            this.with_user_ids = Internal.immutableCopyOf("with_user_ids", r105);
            this.enable_extended_search = r106;
            this.use_extended_search_v2 = r107;
            this.chat_infos = Internal.immutableCopyOf("chat_infos", r110);
            this.search_qa_biz_type = Internal.immutableCopyOf("search_qa_biz_type", r111);
        }
    }

    public static final class CustomizationFilter extends Message<CustomizationFilter, Builder> {
        public static final ProtoAdapter<CustomizationFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, Templates> templates;

        public static final class Builder extends Message.Builder<CustomizationFilter, Builder> {
            public Map<String, Templates> templates;

            @Override // com.squareup.wire.Message.Builder
            public CustomizationFilter build() {
                return new CustomizationFilter(this.templates, super.buildUnknownFields());
            }

            public Builder() {
                this.templates = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder templates(Map<String, Templates> r100) {
                Internal.checkElementsNotNull(r100);
                this.templates = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomizationFilter extends ProtoAdapter<CustomizationFilter> {
            private final ProtoAdapter<Map<String, Templates>> templates;

            public ProtoAdapter_CustomizationFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomizationFilter.class);
                this.templates = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Templates.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomizationFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.templates.putAll(this.templates.decode(r100));
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
            public int encodedSize2(CustomizationFilter r100) {
                return this.templates.encodedSizeWithTag(1, r100.templates) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CustomizationFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomizationFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomizationFilter r101) throws IOException {
                this.templates.encodeWithTag(r100, 1, r101.templates);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomizationFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class Templates extends Message<Templates, Builder> {
            public static final ProtoAdapter<Templates> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<String> versions;

            public static final class Builder extends Message.Builder<Templates, Builder> {
                public List<String> versions;

                @Override // com.squareup.wire.Message.Builder
                public Templates build() {
                    return new Templates(this.versions, super.buildUnknownFields());
                }

                public Builder() {
                    this.versions = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder versions(List<String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.versions = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Templates extends ProtoAdapter<Templates> {
                public ProtoAdapter_Templates() {
                    super(FieldEncoding.LENGTH_DELIMITED, Templates.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Templates decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.versions.add(ProtoAdapter.STRING.decode(r100));
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
                public int encodedSize2(Templates r100) {
                    return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.versions) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Templates decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Templates r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Templates r101) throws IOException {
                    ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.versions);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Templates r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Templates();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.versions = Internal.copyOf("versions", this.versions);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Templates.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Templates(List<String> r100) {
                this(r100, ByteString.EMPTY);
            }

            public Templates(List<String> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.versions = Internal.immutableCopyOf("versions", r100);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomizationFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.templates = Internal.copyOf("templates", this.templates);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomizationFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomizationFilter(Map<String, Templates> r100) {
            this(r100, ByteString.EMPTY);
        }

        public CustomizationFilter(Map<String, Templates> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.templates = Internal.immutableCopyOf("templates", r100);
        }
    }

    public static final class DepartmentFilter extends Message<DepartmentFilter, Builder> {
        public static final ProtoAdapter<DepartmentFilter> ADAPTER = null;
        public static final Boolean DEFAULT_ADDABLE_AS_USER = null;
        private static final long serialVersionUID = 0;
        public final Boolean addable_as_user;

        public static final class Builder extends Message.Builder<DepartmentFilter, Builder> {
            public Boolean addable_as_user;

            @Override // com.squareup.wire.Message.Builder
            public DepartmentFilter build() {
                return new DepartmentFilter(this.addable_as_user, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder addable_as_user(Boolean r100) {
                this.addable_as_user = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DepartmentFilter extends ProtoAdapter<DepartmentFilter> {
            public ProtoAdapter_DepartmentFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, DepartmentFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DepartmentFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.addable_as_user = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.addable_as_user = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(DepartmentFilter r100) {
                Boolean r101 = r100.addable_as_user;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DepartmentFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DepartmentFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DepartmentFilter r101) throws IOException {
                Boolean r102 = r101.addable_as_user;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DepartmentFilter();
            DEFAULT_ADDABLE_AS_USER = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addable_as_user = this.addable_as_user;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DepartmentFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DepartmentFilter(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public DepartmentFilter(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.addable_as_user = r100;
        }
    }

    public static final class DocFilter extends Message<DocFilter, Builder> {
        public static final ProtoAdapter<DocFilter> ADAPTER = null;
        public static final Boolean DEFAULT_CROSS_LANGUAGE = null;
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        public static final Boolean DEFAULT_ONLYTITLE = null;
        public static final DocSortRuleType DEFAULT_SORTTYPE = null;
        public static final Boolean DEFAULT_USE_EXTENDED_SEARCH_V2 = null;
        private static final long serialVersionUID = 0;
        public final List<String> chat_ids;
        public final List<ChatInfo> chat_infos;
        public final List<String> creator_ids;
        public final Boolean cross_language;
        public final Boolean enable_extended_search;
        public final List<String> folder_tokens;
        public final List<String> from_ids;
        public final Boolean onlyTitle;
        public final TimeRange review_time_range;
        public final List<SearchContentType> search_content_types;
        public final List<String> sharer_ids;
        public final DocSortRuleType sortType;
        public final TimeRange time_range;
        public final List<Doc.Type> types;
        public final Boolean use_extended_search_v2;

        public static final class Builder extends Message.Builder<DocFilter, Builder> {
            public List<String> chat_ids;
            public List<ChatInfo> chat_infos;
            public List<String> creator_ids;
            public Boolean cross_language;
            public Boolean enable_extended_search;
            public List<String> folder_tokens;
            public List<String> from_ids;
            public Boolean onlyTitle;
            public TimeRange review_time_range;
            public List<SearchContentType> search_content_types;
            public List<String> sharer_ids;
            public DocSortRuleType sortType;
            public TimeRange time_range;
            public List<Doc.Type> types;
            public Boolean use_extended_search_v2;

            @Override // com.squareup.wire.Message.Builder
            public DocFilter build() {
                return new DocFilter(this.creator_ids, this.chat_ids, this.types, this.onlyTitle, this.review_time_range, this.search_content_types, this.sharer_ids, this.from_ids, this.sortType, this.cross_language, this.folder_tokens, this.enable_extended_search, this.use_extended_search_v2, this.time_range, this.chat_infos, super.buildUnknownFields());
            }

            public Builder() {
                this.creator_ids = Internal.newMutableList();
                this.chat_ids = Internal.newMutableList();
                this.types = Internal.newMutableList();
                this.search_content_types = Internal.newMutableList();
                this.sharer_ids = Internal.newMutableList();
                this.from_ids = Internal.newMutableList();
                this.folder_tokens = Internal.newMutableList();
                this.chat_infos = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_ids = r100;
                return this;
            }

            public Builder chat_infos(List<ChatInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_infos = r100;
                return this;
            }

            public Builder creator_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.creator_ids = r100;
                return this;
            }

            public Builder cross_language(Boolean r100) {
                this.cross_language = r100;
                return this;
            }

            public Builder enable_extended_search(Boolean r100) {
                this.enable_extended_search = r100;
                return this;
            }

            public Builder folder_tokens(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.folder_tokens = r100;
                return this;
            }

            public Builder from_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.from_ids = r100;
                return this;
            }

            public Builder onlyTitle(Boolean r100) {
                this.onlyTitle = r100;
                return this;
            }

            public Builder review_time_range(TimeRange r100) {
                this.review_time_range = r100;
                return this;
            }

            public Builder search_content_types(List<SearchContentType> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_content_types = r100;
                return this;
            }

            public Builder sharer_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.sharer_ids = r100;
                return this;
            }

            public Builder sortType(DocSortRuleType r100) {
                this.sortType = r100;
                return this;
            }

            public Builder time_range(TimeRange r100) {
                this.time_range = r100;
                return this;
            }

            public Builder types(List<Doc.Type> r100) {
                Internal.checkElementsNotNull(r100);
                this.types = r100;
                return this;
            }

            public Builder use_extended_search_v2(Boolean r100) {
                this.use_extended_search_v2 = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocFilter extends ProtoAdapter<DocFilter> {
            public ProtoAdapter_DocFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, DocFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.onlyTitle = r102;
                r101.sortType = DocSortRuleType.DEFAULT_TYPE;
                r101.cross_language = r102;
                r101.enable_extended_search = r102;
                r101.use_extended_search_v2 = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L33;
                if (r104 != 19) goto L7;
                r101.chat_infos.add(ChatInfo.ADAPTER.decode(r100));
                goto L3
            L7:
                switch(r104) {
                    case 1: goto L31;
                    case 2: goto L30;
                    case 3: goto L37;
                    case 4: goto L25;
                    case 5: goto L24;
                    case 6: goto L35;
                    case 7: goto L19;
                    case 8: goto L18;
                    case 9: goto L39;
                    case 10: goto L13;
                    case 11: goto L12;
                    case 12: goto L11;
                    case 13: goto L10;
                    case 14: goto L9;
                    default: goto L8;
                };
            L35:
                r101.search_content_types.add(SearchContentType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L37:
                r101.types.add(Doc.Type.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
            L28:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L39:
                r101.sortType = DocSortRuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                r101.time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.use_extended_search_v2 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.enable_extended_search = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.folder_tokens.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L13:
                r101.cross_language = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L18:
                r101.from_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L19:
                r101.sharer_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L24:
                r101.review_time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.onlyTitle = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L30:
                r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L31:
                r101.creator_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L33:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DocFilter r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = (r101.asRepeated().encodedSizeWithTag(1, r100.creator_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.chat_ids)) + Doc.Type.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.types);
                Boolean r103 = r100.onlyTitle;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
            L6:
                int r106 = r102 + r105;
                TimeRange r107 = r100.review_time_range;
                if (r107 == null) goto L9;
                int r108 = TimeRange.ADAPTER.encodedSizeWithTag(5, r107);
            L10:
                int r109 = (((r106 + r108) + SearchContentType.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.search_content_types)) + r101.asRepeated().encodedSizeWithTag(7, r100.sharer_ids)) + r101.asRepeated().encodedSizeWithTag(8, r100.from_ids);
                DocSortRuleType r110 = r100.sortType;
                if (r110 == null) goto L13;
                int r111 = DocSortRuleType.ADAPTER.encodedSizeWithTag(9, r110);
            L14:
                int r112 = r109 + r111;
                Boolean r113 = r100.cross_language;
                if (r113 == null) goto L17;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r113);
            L18:
                int r115 = (r112 + r114) + r101.asRepeated().encodedSizeWithTag(11, r100.folder_tokens);
                Boolean r116 = r100.enable_extended_search;
                if (r116 == null) goto L21;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r116);
            L22:
                int r118 = r115 + r117;
                Boolean r119 = r100.use_extended_search_v2;
                if (r119 == null) goto L25;
                int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r119);
            L26:
                int r121 = r118 + r120;
                TimeRange r122 = r100.time_range;
                if (r122 == null) goto L30;
                r104 = TimeRange.ADAPTER.encodedSizeWithTag(14, r122);
            L30:
                return ((r121 + r104) + ChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(19, r100.chat_infos)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ DocFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocFilter r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.creator_ids);
                r102.asRepeated().encodeWithTag(r100, 2, r101.chat_ids);
                Doc.Type.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.types);
                Boolean r103 = r101.onlyTitle;
                if (r103 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
            L5:
                TimeRange r104 = r101.review_time_range;
                if (r104 == null) goto L8;
                TimeRange.ADAPTER.encodeWithTag(r100, 5, r104);
            L8:
                SearchContentType.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.search_content_types);
                r102.asRepeated().encodeWithTag(r100, 7, r101.sharer_ids);
                r102.asRepeated().encodeWithTag(r100, 8, r101.from_ids);
                DocSortRuleType r105 = r101.sortType;
                if (r105 == null) goto L11;
                DocSortRuleType.ADAPTER.encodeWithTag(r100, 9, r105);
            L11:
                Boolean r106 = r101.cross_language;
                if (r106 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r106);
            L14:
                r102.asRepeated().encodeWithTag(r100, 11, r101.folder_tokens);
                Boolean r107 = r101.enable_extended_search;
                if (r107 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r107);
            L17:
                Boolean r108 = r101.use_extended_search_v2;
                if (r108 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 13, r108);
            L20:
                TimeRange r109 = r101.time_range;
                if (r109 == null) goto L23;
                TimeRange.ADAPTER.encodeWithTag(r100, 14, r109);
            L23:
                ChatInfo.ADAPTER.asRepeated().encodeWithTag(r100, 19, r101.chat_infos);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchContentType extends Enum<SearchContentType> implements WireEnum {
            private static final /* synthetic */ SearchContentType[] $VALUES = null;
            public static final ProtoAdapter<SearchContentType> ADAPTER = null;
            public static final SearchContentType FULL_CONTENT = null;
            public static final SearchContentType ONLY_COMMENT = null;
            public static final SearchContentType ONLY_TITLE = null;
            private final int value;

            static {
                SearchContentType r100 = new SearchContentType("ONLY_TITLE", 0, 1);
                ONLY_TITLE = r100;
                SearchContentType r101 = new SearchContentType("FULL_CONTENT", 1, 2);
                FULL_CONTENT = r101;
                SearchContentType r102 = new SearchContentType("ONLY_COMMENT", 2, 3);
                ONLY_COMMENT = r102;
                $VALUES = new SearchContentType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchContentType.class);
            }

            public static SearchContentType[] values() {
                return (SearchContentType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchContentType fromValue(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return null;
            L11:
                return ONLY_COMMENT;
            L13:
                return FULL_CONTENT;
            L15:
                return ONLY_TITLE;
            }

            public static SearchContentType valueOf(String r100) {
                return (SearchContentType) a.a(SearchContentType.class, r100);
            }

            private SearchContentType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocFilter();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ONLYTITLE = r100;
            DEFAULT_SORTTYPE = DocSortRuleType.DEFAULT_TYPE;
            DEFAULT_CROSS_LANGUAGE = r100;
            DEFAULT_ENABLE_EXTENDED_SEARCH = r100;
            DEFAULT_USE_EXTENDED_SEARCH_V2 = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.creator_ids = Internal.copyOf("creator_ids", this.creator_ids);
            r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
            r100.types = Internal.copyOf("types", this.types);
            r100.onlyTitle = this.onlyTitle;
            r100.review_time_range = this.review_time_range;
            r100.search_content_types = Internal.copyOf("search_content_types", this.search_content_types);
            r100.sharer_ids = Internal.copyOf("sharer_ids", this.sharer_ids);
            r100.from_ids = Internal.copyOf("from_ids", this.from_ids);
            r100.sortType = this.sortType;
            r100.cross_language = this.cross_language;
            r100.folder_tokens = Internal.copyOf("folder_tokens", this.folder_tokens);
            r100.enable_extended_search = this.enable_extended_search;
            r100.use_extended_search_v2 = this.use_extended_search_v2;
            r100.time_range = this.time_range;
            r100.chat_infos = Internal.copyOf("chat_infos", this.chat_infos);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocFilter(List<String> r110, List<String> r111, List<Doc.Type> r210, Boolean r211, TimeRange r212, List<SearchContentType> r213, List<String> r214, List<String> r215, DocSortRuleType r216, Boolean r217, List<String> r218, Boolean r219, Boolean r310, TimeRange r311, List<ChatInfo> r312) {
            this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
        }

        public DocFilter(List<String> r100, List<String> r101, List<Doc.Type> r102, Boolean r103, TimeRange r104, List<SearchContentType> r105, List<String> r110, List<String> r111, DocSortRuleType r112, Boolean r113, List<String> r114, Boolean r115, Boolean r116, TimeRange r117, List<ChatInfo> r118, ByteString r119) {
            super(ADAPTER, r119);
            this.creator_ids = Internal.immutableCopyOf("creator_ids", r100);
            this.chat_ids = Internal.immutableCopyOf("chat_ids", r101);
            this.types = Internal.immutableCopyOf("types", r102);
            this.onlyTitle = r103;
            this.review_time_range = r104;
            this.search_content_types = Internal.immutableCopyOf("search_content_types", r105);
            this.sharer_ids = Internal.immutableCopyOf("sharer_ids", r110);
            this.from_ids = Internal.immutableCopyOf("from_ids", r111);
            this.sortType = r112;
            this.cross_language = r113;
            this.folder_tokens = Internal.immutableCopyOf("folder_tokens", r114);
            this.enable_extended_search = r115;
            this.use_extended_search_v2 = r116;
            this.time_range = r117;
            this.chat_infos = Internal.immutableCopyOf("chat_infos", r118);
        }
    }

    public static final class MessageFileFilter extends Message<MessageFileFilter, Builder> {
        public static final ProtoAdapter<MessageFileFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> chat_ids;
        public final List<String> creator_ids;
        public final TimeRange time_range;

        public static final class Builder extends Message.Builder<MessageFileFilter, Builder> {
            public List<String> chat_ids;
            public List<String> creator_ids;
            public TimeRange time_range;

            @Override // com.squareup.wire.Message.Builder
            public MessageFileFilter build() {
                return new MessageFileFilter(this.time_range, this.creator_ids, this.chat_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.creator_ids = Internal.newMutableList();
                this.chat_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_ids = r100;
                return this;
            }

            public Builder creator_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.creator_ids = r100;
                return this;
            }

            public Builder time_range(TimeRange r100) {
                this.time_range = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageFileFilter extends ProtoAdapter<MessageFileFilter> {
            public ProtoAdapter_MessageFileFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageFileFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageFileFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.creator_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(MessageFileFilter r100) {
                TimeRange r101 = r100.time_range;
                if (r101 == null) goto L5;
                int r102 = TimeRange.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<String> r103 = ProtoAdapter.STRING;
                return ((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.creator_ids)) + r103.asRepeated().encodedSizeWithTag(3, r100.chat_ids)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageFileFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageFileFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageFileFilter r101) throws IOException {
                TimeRange r102 = r101.time_range;
                if (r102 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<String> r103 = ProtoAdapter.STRING;
                r103.asRepeated().encodeWithTag(r100, 2, r101.creator_ids);
                r103.asRepeated().encodeWithTag(r100, 3, r101.chat_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFileFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageFileFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.time_range = this.time_range;
            r100.creator_ids = Internal.copyOf("creator_ids", this.creator_ids);
            r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageFileFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageFileFilter(TimeRange r100, List<String> r101, List<String> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public MessageFileFilter(TimeRange r100, List<String> r101, List<String> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.time_range = r100;
            this.creator_ids = Internal.immutableCopyOf("creator_ids", r101);
            this.chat_ids = Internal.immutableCopyOf("chat_ids", r102);
        }
    }

    public static final class MessageFilter extends Message<MessageFilter, Builder> {
        public static final ProtoAdapter<MessageFilter> ADAPTER = null;
        public static final ChatType DEFAULT_CHAT_TYPE = null;
        public static final Boolean DEFAULT_IS_AT_ALL = null;
        private static final long serialVersionUID = 0;
        public final List<String> chat_ids;
        public final ChatType chat_type;
        public final List<String> creator_ids;
        public final List<FromType> excluded_from_types;
        public final List<FromType> from_types;
        public final List<String> include_at_user_ids;
        public final List<com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType> include_attachment_types;
        public final Boolean is_at_all;
        public final List<com.bytedance.lark.pb.basic.v1.Message.Type> message_types;
        public final List<String> receiver_ids;
        public final List<SearchType> search_types;
        public final TimeRange time_range;
        public final List<String> with_user_ids;

        public static final class Builder extends Message.Builder<MessageFilter, Builder> {
            public List<String> chat_ids;
            public ChatType chat_type;
            public List<String> creator_ids;
            public List<FromType> excluded_from_types;
            public List<FromType> from_types;
            public List<String> include_at_user_ids;
            public List<com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType> include_attachment_types;
            public Boolean is_at_all;
            public List<com.bytedance.lark.pb.basic.v1.Message.Type> message_types;
            public List<String> receiver_ids;
            public List<SearchType> search_types;
            public TimeRange time_range;
            public List<String> with_user_ids;

            @Override // com.squareup.wire.Message.Builder
            public MessageFilter build() {
                return new MessageFilter(this.time_range, this.creator_ids, this.chat_ids, this.search_types, this.message_types, this.include_at_user_ids, this.from_types, this.excluded_from_types, this.receiver_ids, this.chat_type, this.with_user_ids, this.include_attachment_types, this.is_at_all, super.buildUnknownFields());
            }

            public Builder() {
                this.creator_ids = Internal.newMutableList();
                this.chat_ids = Internal.newMutableList();
                this.search_types = Internal.newMutableList();
                this.message_types = Internal.newMutableList();
                this.include_at_user_ids = Internal.newMutableList();
                this.from_types = Internal.newMutableList();
                this.excluded_from_types = Internal.newMutableList();
                this.receiver_ids = Internal.newMutableList();
                this.with_user_ids = Internal.newMutableList();
                this.include_attachment_types = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_ids = r100;
                return this;
            }

            public Builder chat_type(ChatType r100) {
                this.chat_type = r100;
                return this;
            }

            public Builder creator_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.creator_ids = r100;
                return this;
            }

            public Builder excluded_from_types(List<FromType> r100) {
                Internal.checkElementsNotNull(r100);
                this.excluded_from_types = r100;
                return this;
            }

            public Builder from_types(List<FromType> r100) {
                Internal.checkElementsNotNull(r100);
                this.from_types = r100;
                return this;
            }

            public Builder include_at_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.include_at_user_ids = r100;
                return this;
            }

            public Builder include_attachment_types(List<com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType> r100) {
                Internal.checkElementsNotNull(r100);
                this.include_attachment_types = r100;
                return this;
            }

            public Builder is_at_all(Boolean r100) {
                this.is_at_all = r100;
                return this;
            }

            public Builder message_types(List<com.bytedance.lark.pb.basic.v1.Message.Type> r100) {
                Internal.checkElementsNotNull(r100);
                this.message_types = r100;
                return this;
            }

            public Builder receiver_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.receiver_ids = r100;
                return this;
            }

            public Builder search_types(List<SearchType> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_types = r100;
                return this;
            }

            public Builder time_range(TimeRange r100) {
                this.time_range = r100;
                return this;
            }

            public Builder with_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.with_user_ids = r100;
                return this;
            }
        }

        public static final enum ChatType extends Enum<ChatType> implements WireEnum {
            private static final /* synthetic */ ChatType[] $VALUES = null;
            public static final ProtoAdapter<ChatType> ADAPTER = null;
            public static final ChatType GROUP_CHAT = null;
            public static final ChatType P2P_CHAT = null;
            private final int value;

            static {
                ChatType r100 = new ChatType("GROUP_CHAT", 0, 1);
                GROUP_CHAT = r100;
                ChatType r101 = new ChatType("P2P_CHAT", 1, 2);
                P2P_CHAT = r101;
                $VALUES = new ChatType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChatType.class);
            }

            public static ChatType[] values() {
                return (ChatType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ChatType fromValue(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return null;
            L9:
                return P2P_CHAT;
            L11:
                return GROUP_CHAT;
            }

            public static ChatType valueOf(String r100) {
                return (ChatType) a.a(ChatType.class, r100);
            }

            private ChatType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum FromType extends Enum<FromType> implements WireEnum {
            private static final /* synthetic */ FromType[] $VALUES = null;
            public static final ProtoAdapter<FromType> ADAPTER = null;
            public static final FromType BOT = null;
            public static final FromType USER = null;
            private final int value;

            static {
                FromType r100 = new FromType("BOT", 0, 1);
                BOT = r100;
                FromType r101 = new FromType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 2);
                USER = r101;
                $VALUES = new FromType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(FromType.class);
            }

            public static FromType[] values() {
                return (FromType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FromType fromValue(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return null;
            L9:
                return USER;
            L11:
                return BOT;
            }

            public static FromType valueOf(String r100) {
                return (FromType) a.a(FromType.class, r100);
            }

            private FromType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MessageFilter extends ProtoAdapter<MessageFilter> {
            public ProtoAdapter_MessageFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_type = ChatType.GROUP_CHAT;
                r101.is_at_all = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L38;
                switch(r103) {
                    case 1: goto L37;
                    case 2: goto L36;
                    case 3: goto L6;
                    case 4: goto L35;
                    case 5: goto L40;
                    case 6: goto L42;
                    case 7: goto L6;
                    case 8: goto L26;
                    case 9: goto L46;
                    case 10: goto L44;
                    case 11: goto L17;
                    case 12: goto L50;
                    case 13: goto L12;
                    case 14: goto L48;
                    case 15: goto L7;
                    default: goto L6;
                };
            L40:
                r101.search_types.add(SearchType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
            L33:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L42:
                r101.message_types.add(com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L44:
                r101.excluded_from_types.add(FromType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L46:
                r101.from_types.add(FromType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L48:
                r101.include_attachment_types.add(com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L50:
                r101.chat_type = ChatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.is_at_all = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.with_user_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L17:
                r101.receiver_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L26:
                r101.include_at_user_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L35:
                r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L36:
                r101.creator_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L37:
                r101.time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L38:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageFilter r100) {
                TimeRange r101 = r100.time_range;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TimeRange.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                int r105 = ((((r103 + r104.asRepeated().encodedSizeWithTag(2, r100.creator_ids)) + r104.asRepeated().encodedSizeWithTag(4, r100.chat_ids)) + SearchType.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.search_types)) + com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.message_types)) + r104.asRepeated().encodedSizeWithTag(8, r100.include_at_user_ids);
                ProtoAdapter<FromType> r106 = FromType.ADAPTER;
                int r107 = ((r105 + r106.asRepeated().encodedSizeWithTag(9, r100.from_types)) + r106.asRepeated().encodedSizeWithTag(10, r100.excluded_from_types)) + r104.asRepeated().encodedSizeWithTag(11, r100.receiver_ids);
                ChatType r108 = r100.chat_type;
                if (r108 == null) goto L9;
                int r109 = ChatType.ADAPTER.encodedSizeWithTag(12, r108);
            L10:
                int r110 = ((r107 + r109) + r104.asRepeated().encodedSizeWithTag(13, r100.with_user_ids)) + com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ADAPTER.asRepeated().encodedSizeWithTag(14, r100.include_attachment_types);
                Boolean r111 = r100.is_at_all;
                if (r111 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r111);
            L14:
                return (r110 + r102) + r100.unknownFields().size();
            L9:
                r109 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageFilter r101) throws IOException {
                TimeRange r102 = r101.time_range;
                if (r102 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<String> r103 = ProtoAdapter.STRING;
                r103.asRepeated().encodeWithTag(r100, 2, r101.creator_ids);
                r103.asRepeated().encodeWithTag(r100, 4, r101.chat_ids);
                SearchType.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.search_types);
                com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.message_types);
                r103.asRepeated().encodeWithTag(r100, 8, r101.include_at_user_ids);
                ProtoAdapter<FromType> r104 = FromType.ADAPTER;
                r104.asRepeated().encodeWithTag(r100, 9, r101.from_types);
                r104.asRepeated().encodeWithTag(r100, 10, r101.excluded_from_types);
                r103.asRepeated().encodeWithTag(r100, 11, r101.receiver_ids);
                ChatType r105 = r101.chat_type;
                if (r105 == null) goto L8;
                ChatType.ADAPTER.encodeWithTag(r100, 12, r105);
            L8:
                r103.asRepeated().encodeWithTag(r100, 13, r101.with_user_ids);
                com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ADAPTER.asRepeated().encodeWithTag(r100, 14, r101.include_attachment_types);
                Boolean r106 = r101.is_at_all;
                if (r106 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 15, r106);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType PIN = null;
            public static final SearchType UNKNOWN = null;
            private final int value;

            static {
                SearchType r100 = new SearchType("UNKNOWN", 0, 2);
                UNKNOWN = r100;
                SearchType r101 = new SearchType("PIN", 1, 3);
                PIN = r101;
                $VALUES = new SearchType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r100) {
                if (r100 == 2) goto L11;
                if (r100 == 3) goto L9;
                return null;
            L9:
                return PIN;
            L11:
                return UNKNOWN;
            }

            public static SearchType valueOf(String r100) {
                return (SearchType) a.a(SearchType.class, r100);
            }

            private SearchType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageFilter();
            DEFAULT_CHAT_TYPE = ChatType.GROUP_CHAT;
            DEFAULT_IS_AT_ALL = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.time_range = this.time_range;
            r100.creator_ids = Internal.copyOf("creator_ids", this.creator_ids);
            r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
            r100.search_types = Internal.copyOf("search_types", this.search_types);
            r100.message_types = Internal.copyOf("message_types", this.message_types);
            r100.include_at_user_ids = Internal.copyOf("include_at_user_ids", this.include_at_user_ids);
            r100.from_types = Internal.copyOf("from_types", this.from_types);
            r100.excluded_from_types = Internal.copyOf("excluded_from_types", this.excluded_from_types);
            r100.receiver_ids = Internal.copyOf("receiver_ids", this.receiver_ids);
            r100.chat_type = this.chat_type;
            r100.with_user_ids = Internal.copyOf("with_user_ids", this.with_user_ids);
            r100.include_attachment_types = Internal.copyOf("include_attachment_types", this.include_attachment_types);
            r100.is_at_all = this.is_at_all;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageFilter(TimeRange r110, List<String> r111, List<String> r112, List<SearchType> r113, List<com.bytedance.lark.pb.basic.v1.Message.Type> r210, List<String> r211, List<FromType> r212, List<FromType> r213, List<String> r214, ChatType r215, List<String> r216, List<com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType> r217, Boolean r218) {
            this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
        }

        public MessageFilter(TimeRange r100, List<String> r101, List<String> r102, List<SearchType> r103, List<com.bytedance.lark.pb.basic.v1.Message.Type> r104, List<String> r105, List<FromType> r106, List<FromType> r107, List<String> r110, ChatType r111, List<String> r112, List<com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType> r113, Boolean r114, ByteString r115) {
            super(ADAPTER, r115);
            this.time_range = r100;
            this.creator_ids = Internal.immutableCopyOf("creator_ids", r101);
            this.chat_ids = Internal.immutableCopyOf("chat_ids", r102);
            this.search_types = Internal.immutableCopyOf("search_types", r103);
            this.message_types = Internal.immutableCopyOf("message_types", r104);
            this.include_at_user_ids = Internal.immutableCopyOf("include_at_user_ids", r105);
            this.from_types = Internal.immutableCopyOf("from_types", r106);
            this.excluded_from_types = Internal.immutableCopyOf("excluded_from_types", r107);
            this.receiver_ids = Internal.immutableCopyOf("receiver_ids", r110);
            this.chat_type = r111;
            this.with_user_ids = Internal.immutableCopyOf("with_user_ids", r112);
            this.include_attachment_types = Internal.immutableCopyOf("include_attachment_types", r113);
            this.is_at_all = r114;
        }
    }

    public static final class MyAIFilter extends Message<MyAIFilter, Builder> {
        public static final ProtoAdapter<MyAIFilter> ADAPTER = null;
        public static final Boolean DEFAULT_MUST_HAVE_CHAT = null;
        public static final MessageOptions MESSAGE_OPTIONS = null;
        private static final long serialVersionUID = 0;
        public final Boolean must_have_chat;

        public static final class Builder extends Message.Builder<MyAIFilter, Builder> {
            public Boolean must_have_chat;

            @Override // com.squareup.wire.Message.Builder
            public MyAIFilter build() {
                return new MyAIFilter(this.must_have_chat, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder must_have_chat(Boolean r100) {
                this.must_have_chat = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MyAIFilter extends ProtoAdapter<MyAIFilter> {
            public ProtoAdapter_MyAIFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MyAIFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MyAIFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.must_have_chat = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.must_have_chat = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(MyAIFilter r100) {
                Boolean r101 = r100.must_have_chat;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MyAIFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MyAIFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MyAIFilter r101) throws IOException {
                Boolean r102 = r101.must_have_chat;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MyAIFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MyAIFilter();
            MESSAGE_OPTIONS = new MessageOptions.Builder().deprecated(Boolean.TRUE).build();
            DEFAULT_MUST_HAVE_CHAT = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.must_have_chat = this.must_have_chat;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MyAIFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MyAIFilter(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public MyAIFilter(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.must_have_chat = r100;
        }
    }

    public static final class NewUserGroupFilter extends Message<NewUserGroupFilter, Builder> {
        public static final ProtoAdapter<NewUserGroupFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Namespace> namespaces;
        public final List<UserGroupType> user_group_types;

        public static final class Builder extends Message.Builder<NewUserGroupFilter, Builder> {
            public List<Namespace> namespaces;
            public List<UserGroupType> user_group_types;

            @Override // com.squareup.wire.Message.Builder
            public NewUserGroupFilter build() {
                return new NewUserGroupFilter(this.user_group_types, this.namespaces, super.buildUnknownFields());
            }

            public Builder() {
                this.user_group_types = Internal.newMutableList();
                this.namespaces = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder namespaces(List<Namespace> r100) {
                Internal.checkElementsNotNull(r100);
                this.namespaces = r100;
                return this;
            }

            public Builder user_group_types(List<UserGroupType> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_group_types = r100;
                return this;
            }
        }

        public static final class Namespace extends Message<Namespace, Builder> {
            public static final ProtoAdapter<Namespace> ADAPTER = null;
            public static final String DEFAULT_NAME = "";
            private static final long serialVersionUID = 0;
            public final String name;
            public final List<UserGroupSceneType> visibility_types;

            public static final class Builder extends Message.Builder<Namespace, Builder> {
                public String name;
                public List<UserGroupSceneType> visibility_types;

                @Override // com.squareup.wire.Message.Builder
                public Namespace build() {
                    return new Namespace(this.name, this.visibility_types, super.buildUnknownFields());
                }

                public Builder() {
                    this.visibility_types = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }

                public Builder visibility_types(List<UserGroupSceneType> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.visibility_types = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Namespace extends ProtoAdapter<Namespace> {
                public ProtoAdapter_Namespace() {
                    super(FieldEncoding.LENGTH_DELIMITED, Namespace.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Namespace decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.name = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.visibility_types.add(UserGroupSceneType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
                public int encodedSize2(Namespace r100) {
                    String r101 = r100.name;
                    if (r101 == null) goto L5;
                    int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L7:
                    return (r102 + UserGroupSceneType.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.visibility_types)) + r100.unknownFields().size();
                L5:
                    r102 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Namespace decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Namespace r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Namespace r101) throws IOException {
                    String r102 = r101.name;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    UserGroupSceneType.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.visibility_types);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Namespace r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Namespace();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.name = this.name;
                r100.visibility_types = Internal.copyOf("visibility_types", this.visibility_types);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Namespace.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Namespace(String r100, List<UserGroupSceneType> r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public Namespace(String r100, List<UserGroupSceneType> r101, ByteString r102) {
                super(ADAPTER, r102);
                this.name = r100;
                this.visibility_types = Internal.immutableCopyOf("visibility_types", r101);
            }
        }

        public static final class ProtoAdapter_NewUserGroupFilter extends ProtoAdapter<NewUserGroupFilter> {
            public ProtoAdapter_NewUserGroupFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, NewUserGroupFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NewUserGroupFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.user_group_types.add(UserGroupType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.namespaces.add(Namespace.ADAPTER.decode(r100));
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
            public int encodedSize2(NewUserGroupFilter r100) {
                return (UserGroupType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.user_group_types) + Namespace.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.namespaces)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ NewUserGroupFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(NewUserGroupFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, NewUserGroupFilter r101) throws IOException {
                UserGroupType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.user_group_types);
                Namespace.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.namespaces);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NewUserGroupFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NewUserGroupFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_group_types = Internal.copyOf("user_group_types", this.user_group_types);
            r100.namespaces = Internal.copyOf("namespaces", this.namespaces);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return NewUserGroupFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public NewUserGroupFilter(List<UserGroupType> r100, List<Namespace> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public NewUserGroupFilter(List<UserGroupType> r100, List<Namespace> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.user_group_types = Internal.immutableCopyOf("user_group_types", r100);
            this.namespaces = Internal.immutableCopyOf("namespaces", r101);
        }
    }

    public static final class ProtoAdapter_UniversalFilters extends ProtoAdapter<UniversalFilters> {
        public ProtoAdapter_UniversalFilters() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalFilters.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalFilters decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(UniversalFilters r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalFilters decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalFilters r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalFilters r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalFilters r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SlashCommandFilter extends Message<SlashCommandFilter, Builder> {
        public static final ProtoAdapter<SlashCommandFilter> ADAPTER = null;
        public static final String DEFAULT_COMMAND_ID = "";
        public static final Boolean DEFAULT_ENABLE_SLASH_COMMAND_FILTER = null;
        private static final long serialVersionUID = 0;
        public final String command_id;
        public final Boolean enable_slash_command_filter;
        public final List<String> extras;
        public final List<CommandFilter> filters;

        public static final class Builder extends Message.Builder<SlashCommandFilter, Builder> {
            public String command_id;
            public Boolean enable_slash_command_filter;
            public List<String> extras;
            public List<CommandFilter> filters;

            @Override // com.squareup.wire.Message.Builder
            public SlashCommandFilter build() {
                String r100 = this.command_id;
                if (r100 == null) goto L7;
                return new SlashCommandFilter(this.command_id, this.extras, this.filters, this.enable_slash_command_filter, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "command_id"});
            }

            public Builder() {
                this.extras = Internal.newMutableList();
                this.filters = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder command_id(String r100) {
                this.command_id = r100;
                return this;
            }

            public Builder enable_slash_command_filter(Boolean r100) {
                this.enable_slash_command_filter = r100;
                return this;
            }

            public Builder extras(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.extras = r100;
                return this;
            }

            public Builder filters(List<CommandFilter> r100) {
                Internal.checkElementsNotNull(r100);
                this.filters = r100;
                return this;
            }
        }

        public static final class CommandFilter extends Message<CommandFilter, Builder> {
            public static final ProtoAdapter<CommandFilter> ADAPTER = null;
            public static final String DEFAULT_FILTER_ID = "";
            private static final long serialVersionUID = 0;
            public final String filter_id;
            public final TimeRange time_range;
            public final List<String> values;

            public static final class Builder extends Message.Builder<CommandFilter, Builder> {
                public String filter_id;
                public TimeRange time_range;
                public List<String> values;

                @Override // com.squareup.wire.Message.Builder
                public CommandFilter build() {
                    String r100 = this.filter_id;
                    if (r100 == null) goto L7;
                    return new CommandFilter(this.filter_id, this.values, this.time_range, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "filter_id"});
                }

                public Builder() {
                    this.values = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder filter_id(String r100) {
                    this.filter_id = r100;
                    return this;
                }

                public Builder time_range(TimeRange r100) {
                    this.time_range = r100;
                    return this;
                }

                public Builder values(List<String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.values = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_CommandFilter extends ProtoAdapter<CommandFilter> {
                public ProtoAdapter_CommandFilter() {
                    super(FieldEncoding.LENGTH_DELIMITED, CommandFilter.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public CommandFilter decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.filter_id = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.filter_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.values.add(ProtoAdapter.STRING.decode(r100));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.time_range = TimeRange.ADAPTER.decode(r100);
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
                public int encodedSize2(CommandFilter r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    int r102 = r101.encodedSizeWithTag(1, r100.filter_id) + r101.asRepeated().encodedSizeWithTag(2, r100.values);
                    TimeRange r103 = r100.time_range;
                    if (r103 == null) goto L5;
                    int r104 = TimeRange.ADAPTER.encodedSizeWithTag(3, r103);
                L7:
                    return (r102 + r104) + r100.unknownFields().size();
                L5:
                    r104 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ CommandFilter decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(CommandFilter r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, CommandFilter r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.filter_id);
                    r102.asRepeated().encodeWithTag(r100, 2, r101.values);
                    TimeRange r103 = r101.time_range;
                    if (r103 == null) goto L5;
                    TimeRange.ADAPTER.encodeWithTag(r100, 3, r103);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommandFilter r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_CommandFilter();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.filter_id = this.filter_id;
                r100.values = Internal.copyOf("values", this.values);
                r100.time_range = this.time_range;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return CommandFilter.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public CommandFilter(String r100, List<String> r101, TimeRange r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public CommandFilter(String r100, List<String> r101, TimeRange r102, ByteString r103) {
                super(ADAPTER, r103);
                this.filter_id = r100;
                this.values = Internal.immutableCopyOf("values", r101);
                this.time_range = r102;
            }
        }

        public static final class ProtoAdapter_SlashCommandFilter extends ProtoAdapter<SlashCommandFilter> {
            public ProtoAdapter_SlashCommandFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SlashCommandFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SlashCommandFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.command_id = "";
                r101.enable_slash_command_filter = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.command_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.extras.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.filters.add(CommandFilter.ADAPTER.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.enable_slash_command_filter = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(SlashCommandFilter r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = (r101.encodedSizeWithTag(1, r100.command_id) + r101.asRepeated().encodedSizeWithTag(2, r100.extras)) + CommandFilter.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.filters);
                Boolean r103 = r100.enable_slash_command_filter;
                if (r103 == null) goto L5;
                int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SlashCommandFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SlashCommandFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SlashCommandFilter r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.command_id);
                r102.asRepeated().encodeWithTag(r100, 2, r101.extras);
                CommandFilter.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.filters);
                Boolean r103 = r101.enable_slash_command_filter;
                if (r103 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SlashCommandFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SlashCommandFilter();
            DEFAULT_ENABLE_SLASH_COMMAND_FILTER = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.command_id = this.command_id;
            r100.extras = Internal.copyOf("extras", this.extras);
            r100.filters = Internal.copyOf("filters", this.filters);
            r100.enable_slash_command_filter = this.enable_slash_command_filter;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SlashCommandFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SlashCommandFilter(String r100, List<String> r101, List<CommandFilter> r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public SlashCommandFilter(String r100, List<String> r101, List<CommandFilter> r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.command_id = r100;
            this.extras = Internal.immutableCopyOf("extras", r101);
            this.filters = Internal.immutableCopyOf("filters", r102);
            this.enable_slash_command_filter = r103;
        }
    }

    public static final class TimeRange extends Message<TimeRange, Builder> {
        public static final ProtoAdapter<TimeRange> ADAPTER = null;
        public static final Long DEFAULT_END_TIME = null;
        public static final Long DEFAULT_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long end_time;
        public final Long start_time;

        public static final class Builder extends Message.Builder<TimeRange, Builder> {
            public Long end_time;
            public Long start_time;

            @Override // com.squareup.wire.Message.Builder
            public TimeRange build() {
                return new TimeRange(this.start_time, this.end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder end_time(Long r100) {
                this.end_time = r100;
                return this;
            }

            public Builder start_time(Long r100) {
                this.start_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeRange extends ProtoAdapter<TimeRange> {
            public ProtoAdapter_TimeRange() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeRange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeRange decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.start_time = 0L;
                r101.end_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.start_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.end_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(TimeRange r100) {
                Long r101 = r100.start_time;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.end_time;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TimeRange decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeRange r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeRange r101) throws IOException {
                Long r102 = r101.start_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.end_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeRange r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeRange();
            DEFAULT_START_TIME = 0L;
            DEFAULT_END_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.start_time = this.start_time;
            r100.end_time = this.end_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeRange(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TimeRange(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.start_time = r100;
            this.end_time = r101;
        }
    }

    public static final class URLFilter extends Message<URLFilter, Builder> {
        public static final ProtoAdapter<URLFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> chat_ids;
        public final List<String> creator_ids;
        public final TimeRange time_range;
        public final List<String> with_user_ids;

        public static final class Builder extends Message.Builder<URLFilter, Builder> {
            public List<String> chat_ids;
            public List<String> creator_ids;
            public TimeRange time_range;
            public List<String> with_user_ids;

            @Override // com.squareup.wire.Message.Builder
            public URLFilter build() {
                return new URLFilter(this.time_range, this.creator_ids, this.chat_ids, this.with_user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.creator_ids = Internal.newMutableList();
                this.chat_ids = Internal.newMutableList();
                this.with_user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_ids = r100;
                return this;
            }

            public Builder creator_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.creator_ids = r100;
                return this;
            }

            public Builder time_range(TimeRange r100) {
                this.time_range = r100;
                return this;
            }

            public Builder with_user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.with_user_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_URLFilter extends ProtoAdapter<URLFilter> {
            public ProtoAdapter_URLFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, URLFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public URLFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.creator_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 13) goto L13;
                r101.with_user_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(URLFilter r100) {
                TimeRange r101 = r100.time_range;
                if (r101 == null) goto L5;
                int r102 = TimeRange.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<String> r103 = ProtoAdapter.STRING;
                return (((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.creator_ids)) + r103.asRepeated().encodedSizeWithTag(3, r100.chat_ids)) + r103.asRepeated().encodedSizeWithTag(13, r100.with_user_ids)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ URLFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(URLFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, URLFilter r101) throws IOException {
                TimeRange r102 = r101.time_range;
                if (r102 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<String> r103 = ProtoAdapter.STRING;
                r103.asRepeated().encodeWithTag(r100, 2, r101.creator_ids);
                r103.asRepeated().encodeWithTag(r100, 3, r101.chat_ids);
                r103.asRepeated().encodeWithTag(r100, 13, r101.with_user_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URLFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.time_range = this.time_range;
            r100.creator_ids = Internal.copyOf("creator_ids", this.creator_ids);
            r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
            r100.with_user_ids = Internal.copyOf("with_user_ids", this.with_user_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return URLFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public URLFilter(TimeRange r100, List<String> r101, List<String> r102, List<String> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public URLFilter(TimeRange r100, List<String> r101, List<String> r102, List<String> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.time_range = r100;
            this.creator_ids = Internal.immutableCopyOf("creator_ids", r101);
            this.chat_ids = Internal.immutableCopyOf("chat_ids", r102);
            this.with_user_ids = Internal.immutableCopyOf("with_user_ids", r103);
        }
    }

    public static final class UserFilter extends Message<UserFilter, Builder> {
        public static final ProtoAdapter<UserFilter> ADAPTER = null;
        public static final Boolean DEFAULT_EXCLUDE = null;
        public static final Boolean DEFAULT_EXCLUDE_OUTER_CONTACT = null;
        public static final Boolean DEFAULT_EXISTS_ENTERPRISE_EMAIL = null;
        private static final long serialVersionUID = 0;
        public final Map<String, FieldValues> custom_fields;
        public final Boolean exclude;
        public final Boolean exclude_outer_contact;
        public final Boolean exists_enterprise_email;
        public final List<Long> in_user_ids;
        public final List<Integer> search_type;

        public static final class Builder extends Message.Builder<UserFilter, Builder> {
            public Map<String, FieldValues> custom_fields;
            public Boolean exclude;
            public Boolean exclude_outer_contact;
            public Boolean exists_enterprise_email;
            public List<Long> in_user_ids;
            public List<Integer> search_type;

            @Override // com.squareup.wire.Message.Builder
            public UserFilter build() {
                return new UserFilter(this.search_type, this.custom_fields, this.exclude, this.exclude_outer_contact, this.exists_enterprise_email, this.in_user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.search_type = Internal.newMutableList();
                this.custom_fields = Internal.newMutableMap();
                this.in_user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder custom_fields(Map<String, FieldValues> r100) {
                Internal.checkElementsNotNull(r100);
                this.custom_fields = r100;
                return this;
            }

            public Builder exclude(Boolean r100) {
                this.exclude = r100;
                return this;
            }

            public Builder exclude_outer_contact(Boolean r100) {
                this.exclude_outer_contact = r100;
                return this;
            }

            public Builder exists_enterprise_email(Boolean r100) {
                this.exists_enterprise_email = r100;
                return this;
            }

            public Builder in_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.in_user_ids = r100;
                return this;
            }

            public Builder search_type(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_type = r100;
                return this;
            }
        }

        public static final class FieldValues extends Message<FieldValues, Builder> {
            public static final ProtoAdapter<FieldValues> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<String> values;

            public static final class Builder extends Message.Builder<FieldValues, Builder> {
                public List<String> values;

                @Override // com.squareup.wire.Message.Builder
                public FieldValues build() {
                    return new FieldValues(this.values, super.buildUnknownFields());
                }

                public Builder() {
                    this.values = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder values(List<String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.values = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_FieldValues extends ProtoAdapter<FieldValues> {
                public ProtoAdapter_FieldValues() {
                    super(FieldEncoding.LENGTH_DELIMITED, FieldValues.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public FieldValues decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.values.add(ProtoAdapter.STRING.decode(r100));
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
                public int encodedSize2(FieldValues r100) {
                    return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.values) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ FieldValues decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(FieldValues r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, FieldValues r101) throws IOException {
                    ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.values);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FieldValues r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_FieldValues();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.values = Internal.copyOf("values", this.values);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return FieldValues.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public FieldValues(List<String> r100) {
                this(r100, ByteString.EMPTY);
            }

            public FieldValues(List<String> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.values = Internal.immutableCopyOf("values", r100);
            }
        }

        public static final class ProtoAdapter_UserFilter extends ProtoAdapter<UserFilter> {
            private final ProtoAdapter<Map<String, FieldValues>> custom_fields;

            public ProtoAdapter_UserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, UserFilter.class);
                this.custom_fields = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, FieldValues.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.exclude = r102;
                r101.exclude_outer_contact = r102;
                r101.exists_enterprise_email = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L24;
                if (r104 != 1) goto L8;
                r101.search_type.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L8:
                if (r104 != 3) goto L10;
                r101.custom_fields.putAll(this.custom_fields.decode(r100));
                goto L3
            L10:
                if (r104 != 4) goto L12;
                r101.exclude = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 5) goto L14;
                r101.exclude_outer_contact = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r104 != 6) goto L16;
                r101.exists_enterprise_email = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                if (r104 != 7) goto L17;
                r101.in_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L17:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserFilter r100) {
                int r101 = ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(1, r100.search_type) + this.custom_fields.encodedSizeWithTag(3, r100.custom_fields);
                Boolean r102 = r100.exclude;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r102);
            L6:
                int r105 = r101 + r104;
                Boolean r106 = r100.exclude_outer_contact;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r106);
            L10:
                int r108 = r105 + r107;
                Boolean r109 = r100.exists_enterprise_email;
                if (r109 == null) goto L14;
                r103 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r109);
            L14:
                return ((r108 + r103) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(7, r100.in_user_ids)) + r100.unknownFields().size();
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UserFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserFilter r101) throws IOException {
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 1, r101.search_type);
                this.custom_fields.encodeWithTag(r100, 3, r101.custom_fields);
                Boolean r102 = r101.exclude;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r102);
            L5:
                Boolean r103 = r101.exclude_outer_contact;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
            L8:
                Boolean r104 = r101.exists_enterprise_email;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r104);
            L11:
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 7, r101.in_user_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType ALL = null;
            public static final SearchType RESIGNED = null;
            public static final SearchType TALKED = null;
            public static final SearchType UN_RESIGNED = null;
            public static final SearchType UN_TALKED = null;
            private final int value;

            static {
                SearchType r100 = new SearchType(AccountType.ALL, 0, 0);
                ALL = r100;
                SearchType r101 = new SearchType("UN_RESIGNED", 1, 1);
                UN_RESIGNED = r101;
                SearchType r102 = new SearchType("RESIGNED", 2, 2);
                RESIGNED = r102;
                SearchType r103 = new SearchType("TALKED", 3, 4);
                TALKED = r103;
                SearchType r104 = new SearchType("UN_TALKED", 4, 8);
                UN_TALKED = r104;
                $VALUES = new SearchType[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 4) goto L16;
                if (r100 == 8) goto L14;
                return null;
            L14:
                return UN_TALKED;
            L16:
                return TALKED;
            L18:
                return RESIGNED;
            L20:
                return UN_RESIGNED;
            L22:
                return ALL;
            }

            public static SearchType valueOf(String r100) {
                return (SearchType) a.a(SearchType.class, r100);
            }

            private SearchType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserFilter();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_EXCLUDE = r100;
            DEFAULT_EXCLUDE_OUTER_CONTACT = r100;
            DEFAULT_EXISTS_ENTERPRISE_EMAIL = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.search_type = Internal.copyOf("search_type", this.search_type);
            r100.custom_fields = Internal.copyOf("custom_fields", this.custom_fields);
            r100.exclude = this.exclude;
            r100.exclude_outer_contact = this.exclude_outer_contact;
            r100.exists_enterprise_email = this.exists_enterprise_email;
            r100.in_user_ids = Internal.copyOf("in_user_ids", this.in_user_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserFilter(List<Integer> r100, Map<String, FieldValues> r110, Boolean r111, Boolean r112, Boolean r113, List<Long> r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public UserFilter(List<Integer> r100, Map<String, FieldValues> r101, Boolean r102, Boolean r103, Boolean r104, List<Long> r105, ByteString r106) {
            super(ADAPTER, r106);
            this.search_type = Internal.immutableCopyOf("search_type", r100);
            this.custom_fields = Internal.immutableCopyOf("custom_fields", r101);
            this.exclude = r102;
            this.exclude_outer_contact = r103;
            this.exists_enterprise_email = r104;
            this.in_user_ids = Internal.immutableCopyOf("in_user_ids", r105);
        }
    }

    public static final class WikiFilter extends Message<WikiFilter, Builder> {
        public static final ProtoAdapter<WikiFilter> ADAPTER = null;
        public static final Boolean DEFAULT_CROSS_LANGUAGE = null;
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        public static final Boolean DEFAULT_ONLY_TITLE = null;
        public static final DocSortRuleType DEFAULT_SORTTYPE = null;
        public static final Boolean DEFAULT_USE_EXTENDED_SEARCH_V2 = null;
        private static final long serialVersionUID = 0;
        public final List<String> chat_ids;
        public final List<ChatInfo> chat_infos;
        public final List<String> creator_ids;
        public final Boolean cross_language;
        public final Boolean enable_extended_search;
        public final List<String> from_ids;
        public final Boolean only_title;
        public final List<String> repo_ids;
        public final TimeRange review_time_range;
        public final List<SearchContentType> search_content_types;
        public final List<String> sharer_ids;
        public final DocSortRuleType sortType;
        public final List<String> space_ids;
        public final TimeRange time_range;
        public final List<Doc.Type> types;
        public final Boolean use_extended_search_v2;

        public static final class Builder extends Message.Builder<WikiFilter, Builder> {
            public List<String> chat_ids;
            public List<ChatInfo> chat_infos;
            public List<String> creator_ids;
            public Boolean cross_language;
            public Boolean enable_extended_search;
            public List<String> from_ids;
            public Boolean only_title;
            public List<String> repo_ids;
            public TimeRange review_time_range;
            public List<SearchContentType> search_content_types;
            public List<String> sharer_ids;
            public DocSortRuleType sortType;
            public List<String> space_ids;
            public TimeRange time_range;
            public List<Doc.Type> types;
            public Boolean use_extended_search_v2;

            @Override // com.squareup.wire.Message.Builder
            public WikiFilter build() {
                return new WikiFilter(this.creator_ids, this.chat_ids, this.repo_ids, this.review_time_range, this.types, this.search_content_types, this.sharer_ids, this.from_ids, this.sortType, this.cross_language, this.space_ids, this.enable_extended_search, this.use_extended_search_v2, this.time_range, this.chat_infos, this.only_title, super.buildUnknownFields());
            }

            public Builder() {
                this.creator_ids = Internal.newMutableList();
                this.chat_ids = Internal.newMutableList();
                this.repo_ids = Internal.newMutableList();
                this.types = Internal.newMutableList();
                this.search_content_types = Internal.newMutableList();
                this.sharer_ids = Internal.newMutableList();
                this.from_ids = Internal.newMutableList();
                this.space_ids = Internal.newMutableList();
                this.chat_infos = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_ids = r100;
                return this;
            }

            public Builder chat_infos(List<ChatInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.chat_infos = r100;
                return this;
            }

            public Builder creator_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.creator_ids = r100;
                return this;
            }

            public Builder cross_language(Boolean r100) {
                this.cross_language = r100;
                return this;
            }

            public Builder enable_extended_search(Boolean r100) {
                this.enable_extended_search = r100;
                return this;
            }

            public Builder from_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.from_ids = r100;
                return this;
            }

            public Builder only_title(Boolean r100) {
                this.only_title = r100;
                return this;
            }

            public Builder repo_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.repo_ids = r100;
                return this;
            }

            public Builder review_time_range(TimeRange r100) {
                this.review_time_range = r100;
                return this;
            }

            public Builder search_content_types(List<SearchContentType> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_content_types = r100;
                return this;
            }

            public Builder sharer_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.sharer_ids = r100;
                return this;
            }

            public Builder sortType(DocSortRuleType r100) {
                this.sortType = r100;
                return this;
            }

            public Builder space_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.space_ids = r100;
                return this;
            }

            public Builder time_range(TimeRange r100) {
                this.time_range = r100;
                return this;
            }

            public Builder types(List<Doc.Type> r100) {
                Internal.checkElementsNotNull(r100);
                this.types = r100;
                return this;
            }

            public Builder use_extended_search_v2(Boolean r100) {
                this.use_extended_search_v2 = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiFilter extends ProtoAdapter<WikiFilter> {
            public ProtoAdapter_WikiFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WikiFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.sortType = DocSortRuleType.DEFAULT_TYPE;
                Boolean r102 = Boolean.FALSE;
                r101.cross_language = r102;
                r101.enable_extended_search = r102;
                r101.use_extended_search_v2 = r102;
                r101.only_title = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L32;
                switch(r104) {
                    case 1: goto L31;
                    case 2: goto L30;
                    case 3: goto L29;
                    case 4: goto L28;
                    case 5: goto L38;
                    case 6: goto L36;
                    case 7: goto L19;
                    case 8: goto L18;
                    case 9: goto L34;
                    case 10: goto L13;
                    case 11: goto L12;
                    case 12: goto L11;
                    case 13: goto L10;
                    case 14: goto L9;
                    case 15: goto L8;
                    case 16: goto L7;
                    default: goto L6;
                };
            L34:
                r101.sortType = DocSortRuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L36:
                r101.search_content_types.add(SearchContentType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L38:
                r101.types.add(Doc.Type.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
            L26:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.only_title = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.chat_infos.add(ChatInfo.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.use_extended_search_v2 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.enable_extended_search = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.space_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L13:
                r101.cross_language = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L18:
                r101.from_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L19:
                r101.sharer_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L28:
                r101.review_time_range = TimeRange.ADAPTER.decode(r100);
                goto L3
            L29:
                r101.repo_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L30:
                r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L31:
                r101.creator_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L32:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(WikiFilter r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = (r101.asRepeated().encodedSizeWithTag(1, r100.creator_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.chat_ids)) + r101.asRepeated().encodedSizeWithTag(3, r100.repo_ids);
                TimeRange r103 = r100.review_time_range;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = TimeRange.ADAPTER.encodedSizeWithTag(4, r103);
            L6:
                int r106 = ((((r102 + r105) + Doc.Type.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.types)) + SearchContentType.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.search_content_types)) + r101.asRepeated().encodedSizeWithTag(7, r100.sharer_ids)) + r101.asRepeated().encodedSizeWithTag(8, r100.from_ids);
                DocSortRuleType r107 = r100.sortType;
                if (r107 == null) goto L9;
                int r108 = DocSortRuleType.ADAPTER.encodedSizeWithTag(9, r107);
            L10:
                int r109 = r106 + r108;
                Boolean r110 = r100.cross_language;
                if (r110 == null) goto L13;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r110);
            L14:
                int r112 = (r109 + r111) + r101.asRepeated().encodedSizeWithTag(11, r100.space_ids);
                Boolean r113 = r100.enable_extended_search;
                if (r113 == null) goto L17;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r113);
            L18:
                int r115 = r112 + r114;
                Boolean r116 = r100.use_extended_search_v2;
                if (r116 == null) goto L21;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r116);
            L22:
                int r118 = r115 + r117;
                TimeRange r119 = r100.time_range;
                if (r119 == null) goto L25;
                int r120 = TimeRange.ADAPTER.encodedSizeWithTag(14, r119);
            L26:
                int r121 = (r118 + r120) + ChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(15, r100.chat_infos);
                Boolean r122 = r100.only_title;
                if (r122 == null) goto L30;
                r104 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r122);
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
            public /* bridge */ /* synthetic */ WikiFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WikiFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WikiFilter r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.creator_ids);
                r102.asRepeated().encodeWithTag(r100, 2, r101.chat_ids);
                r102.asRepeated().encodeWithTag(r100, 3, r101.repo_ids);
                TimeRange r103 = r101.review_time_range;
                if (r103 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r100, 4, r103);
            L5:
                Doc.Type.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.types);
                SearchContentType.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.search_content_types);
                r102.asRepeated().encodeWithTag(r100, 7, r101.sharer_ids);
                r102.asRepeated().encodeWithTag(r100, 8, r101.from_ids);
                DocSortRuleType r104 = r101.sortType;
                if (r104 == null) goto L8;
                DocSortRuleType.ADAPTER.encodeWithTag(r100, 9, r104);
            L8:
                Boolean r105 = r101.cross_language;
                if (r105 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r105);
            L11:
                r102.asRepeated().encodeWithTag(r100, 11, r101.space_ids);
                Boolean r106 = r101.enable_extended_search;
                if (r106 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r106);
            L14:
                Boolean r107 = r101.use_extended_search_v2;
                if (r107 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 13, r107);
            L17:
                TimeRange r108 = r101.time_range;
                if (r108 == null) goto L20;
                TimeRange.ADAPTER.encodeWithTag(r100, 14, r108);
            L20:
                ChatInfo.ADAPTER.asRepeated().encodeWithTag(r100, 15, r101.chat_infos);
                Boolean r109 = r101.only_title;
                if (r109 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 16, r109);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchContentType extends Enum<SearchContentType> implements WireEnum {
            private static final /* synthetic */ SearchContentType[] $VALUES = null;
            public static final ProtoAdapter<SearchContentType> ADAPTER = null;
            public static final SearchContentType FULL_CONTENT = null;
            public static final SearchContentType ONLY_COMMENT = null;
            public static final SearchContentType ONLY_TITLE = null;
            private final int value;

            static {
                SearchContentType r100 = new SearchContentType("ONLY_TITLE", 0, 1);
                ONLY_TITLE = r100;
                SearchContentType r101 = new SearchContentType("FULL_CONTENT", 1, 2);
                FULL_CONTENT = r101;
                SearchContentType r102 = new SearchContentType("ONLY_COMMENT", 2, 3);
                ONLY_COMMENT = r102;
                $VALUES = new SearchContentType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchContentType.class);
            }

            public static SearchContentType[] values() {
                return (SearchContentType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchContentType fromValue(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return null;
            L11:
                return ONLY_COMMENT;
            L13:
                return FULL_CONTENT;
            L15:
                return ONLY_TITLE;
            }

            public static SearchContentType valueOf(String r100) {
                return (SearchContentType) a.a(SearchContentType.class, r100);
            }

            private SearchContentType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiFilter();
            DEFAULT_SORTTYPE = DocSortRuleType.DEFAULT_TYPE;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_CROSS_LANGUAGE = r100;
            DEFAULT_ENABLE_EXTENDED_SEARCH = r100;
            DEFAULT_USE_EXTENDED_SEARCH_V2 = r100;
            DEFAULT_ONLY_TITLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.creator_ids = Internal.copyOf("creator_ids", this.creator_ids);
            r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
            r100.repo_ids = Internal.copyOf("repo_ids", this.repo_ids);
            r100.review_time_range = this.review_time_range;
            r100.types = Internal.copyOf("types", this.types);
            r100.search_content_types = Internal.copyOf("search_content_types", this.search_content_types);
            r100.sharer_ids = Internal.copyOf("sharer_ids", this.sharer_ids);
            r100.from_ids = Internal.copyOf("from_ids", this.from_ids);
            r100.sortType = this.sortType;
            r100.cross_language = this.cross_language;
            r100.space_ids = Internal.copyOf("space_ids", this.space_ids);
            r100.enable_extended_search = this.enable_extended_search;
            r100.use_extended_search_v2 = this.use_extended_search_v2;
            r100.time_range = this.time_range;
            r100.chat_infos = Internal.copyOf("chat_infos", this.chat_infos);
            r100.only_title = this.only_title;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WikiFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public WikiFilter(List<String> r110, List<String> r210, List<String> r211, TimeRange r212, List<Doc.Type> r213, List<SearchContentType> r214, List<String> r215, List<String> r216, DocSortRuleType r217, Boolean r218, List<String> r219, Boolean r310, Boolean r311, TimeRange r312, List<ChatInfo> r313, Boolean r314) {
            this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
        }

        public WikiFilter(List<String> r100, List<String> r101, List<String> r102, TimeRange r103, List<Doc.Type> r104, List<SearchContentType> r105, List<String> r110, List<String> r111, DocSortRuleType r112, Boolean r113, List<String> r114, Boolean r115, Boolean r116, TimeRange r117, List<ChatInfo> r118, Boolean r119, ByteString r210) {
            super(ADAPTER, r210);
            this.creator_ids = Internal.immutableCopyOf("creator_ids", r100);
            this.chat_ids = Internal.immutableCopyOf("chat_ids", r101);
            this.repo_ids = Internal.immutableCopyOf("repo_ids", r102);
            this.review_time_range = r103;
            this.types = Internal.immutableCopyOf("types", r104);
            this.search_content_types = Internal.immutableCopyOf("search_content_types", r105);
            this.sharer_ids = Internal.immutableCopyOf("sharer_ids", r110);
            this.from_ids = Internal.immutableCopyOf("from_ids", r111);
            this.sortType = r112;
            this.cross_language = r113;
            this.space_ids = Internal.immutableCopyOf("space_ids", r114);
            this.enable_extended_search = r115;
            this.use_extended_search_v2 = r116;
            this.time_range = r117;
            this.chat_infos = Internal.immutableCopyOf("chat_infos", r118);
            this.only_title = r119;
        }
    }

    public static final class WikiSpaceFilter extends Message<WikiSpaceFilter, Builder> {
        public static final ProtoAdapter<WikiSpaceFilter> ADAPTER = null;
        public static final Sorter DEFAULT_WIKI_SPACE_SORTER = null;
        private static final long serialVersionUID = 0;
        public final List<FilterPaymentType> wiki_space_payment_type;
        public final Sorter wiki_space_sorter;
        public final List<SpaceType> wiki_space_types;

        public static final class Builder extends Message.Builder<WikiSpaceFilter, Builder> {
            public List<FilterPaymentType> wiki_space_payment_type;
            public Sorter wiki_space_sorter;
            public List<SpaceType> wiki_space_types;

            @Override // com.squareup.wire.Message.Builder
            public WikiSpaceFilter build() {
                return new WikiSpaceFilter(this.wiki_space_types, this.wiki_space_sorter, this.wiki_space_payment_type, super.buildUnknownFields());
            }

            public Builder() {
                this.wiki_space_types = Internal.newMutableList();
                this.wiki_space_payment_type = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder wiki_space_payment_type(List<FilterPaymentType> r100) {
                Internal.checkElementsNotNull(r100);
                this.wiki_space_payment_type = r100;
                return this;
            }

            public Builder wiki_space_sorter(Sorter r100) {
                this.wiki_space_sorter = r100;
                return this;
            }

            public Builder wiki_space_types(List<SpaceType> r100) {
                Internal.checkElementsNotNull(r100);
                this.wiki_space_types = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiSpaceFilter extends ProtoAdapter<WikiSpaceFilter> {
            public ProtoAdapter_WikiSpaceFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiSpaceFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WikiSpaceFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.wiki_space_sorter = Sorter.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.wiki_space_types.add(SpaceType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.wiki_space_sorter = Sorter.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.wiki_space_payment_type.add(FilterPaymentType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
            public int encodedSize2(WikiSpaceFilter r100) {
                int r101 = SpaceType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.wiki_space_types);
                Sorter r102 = r100.wiki_space_sorter;
                if (r102 == null) goto L5;
                int r103 = Sorter.ADAPTER.encodedSizeWithTag(2, r102);
            L7:
                return ((r101 + r103) + FilterPaymentType.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.wiki_space_payment_type)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WikiSpaceFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WikiSpaceFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WikiSpaceFilter r101) throws IOException {
                SpaceType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.wiki_space_types);
                Sorter r102 = r101.wiki_space_sorter;
                if (r102 == null) goto L5;
                Sorter.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                FilterPaymentType.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.wiki_space_payment_type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiSpaceFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Sorter extends Enum<Sorter> implements WireEnum {
            private static final /* synthetic */ Sorter[] $VALUES = null;
            public static final ProtoAdapter<Sorter> ADAPTER = null;
            public static final Sorter DEFAULT = null;
            public static final Sorter HOT = null;
            public static final Sorter NEW = null;
            private final int value;

            static {
                Sorter r100 = new Sorter("DEFAULT", 0, 0);
                DEFAULT = r100;
                Sorter r101 = new Sorter("HOT", 1, 1);
                HOT = r101;
                Sorter r102 = new Sorter("NEW", 2, 2);
                NEW = r102;
                $VALUES = new Sorter[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Sorter.class);
            }

            public static Sorter[] values() {
                return (Sorter[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Sorter fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return NEW;
            L12:
                return HOT;
            L14:
                return DEFAULT;
            }

            public static Sorter valueOf(String r100) {
                return (Sorter) a.a(Sorter.class, r100);
            }

            private Sorter(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum SpaceType extends Enum<SpaceType> implements WireEnum {
            private static final /* synthetic */ SpaceType[] $VALUES = null;
            public static final ProtoAdapter<SpaceType> ADAPTER = null;
            public static final SpaceType Personal = null;
            public static final SpaceType Team = null;
            private final int value;

            static {
                SpaceType r100 = new SpaceType("Team", 0, 0);
                Team = r100;
                SpaceType r101 = new SpaceType("Personal", 1, 1);
                Personal = r101;
                $VALUES = new SpaceType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(SpaceType.class);
            }

            public static SpaceType[] values() {
                return (SpaceType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SpaceType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return Personal;
            L10:
                return Team;
            }

            public static SpaceType valueOf(String r100) {
                return (SpaceType) a.a(SpaceType.class, r100);
            }

            private SpaceType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiSpaceFilter();
            DEFAULT_WIKI_SPACE_SORTER = Sorter.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.wiki_space_types = Internal.copyOf("wiki_space_types", this.wiki_space_types);
            r100.wiki_space_sorter = this.wiki_space_sorter;
            r100.wiki_space_payment_type = Internal.copyOf("wiki_space_payment_type", this.wiki_space_payment_type);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WikiSpaceFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public WikiSpaceFilter(List<SpaceType> r100, Sorter r101, List<FilterPaymentType> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public WikiSpaceFilter(List<SpaceType> r100, Sorter r101, List<FilterPaymentType> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.wiki_space_types = Internal.immutableCopyOf("wiki_space_types", r100);
            this.wiki_space_sorter = r101;
            this.wiki_space_payment_type = Internal.immutableCopyOf("wiki_space_payment_type", r102);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalFilters();
    }

    public UniversalFilters() {
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
        return UniversalFilters.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalFilters(ByteString r100) {
        super(ADAPTER, r100);
    }
}
