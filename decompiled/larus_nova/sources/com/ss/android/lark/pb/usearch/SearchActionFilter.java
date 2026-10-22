package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchActionFilter extends Message<SearchActionFilter, Builder> {
    public static final ProtoAdapter<SearchActionFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MessageFilter.ChatTypeFilter mchat_type_filter;
    public final DocsFilter.ContainerTypeFilter mdocs_container_type;
    public final DocsFilter.FromUserFilter mdocs_from_user;
    public final DocsFilter.InChatFilter mdocs_in_chat;
    public final DocsFilter.InFolderFilter mdocs_in_folder;
    public final DocsFilter.MatchTypeFilter mdocs_match_type;
    public final DocsFilter.ObjectTypeFilter mdocs_object_type;
    public final DocsFilter.OpenTimeRangeFilter mdocs_open_time_range;
    public final DocsFilter.OwnerFilter mdocs_owner;
    public final DocsFilter.SharerFilter mdocs_sharer;
    public final DocsFilter.Sorter mdocs_sorter;
    public final DocsFilter.EnableExtendedSearch menable_extended_search;
    public final GroupChatFilter.IncludeUserFilter mgroup_chat_include_user;
    public final GroupChatFilter.SearchTypeFilter mgroup_chat_search_type;
    public final GroupChatFilter.SortRuleFilter mgroup_chat_sort_type;
    public final MessageFilter.AttachmentFilter mmessage_attachment;
    public final MessageFilter.FromUserFilter mmessage_from_user;
    public final MessageFilter.InChatFilter mmessage_in_chat;
    public final MessageFilter.MatchScopeFilter mmessage_match_scope;
    public final MessageFilter.TimeFilter mmessage_time_range;
    public final MessageFilter.MessageTypeFilter mmessage_type;
    public final MessageFilter.WithUserFilter mmessage_with_user;
    public final OpenSearchFilter.OpenSearchSortFilter mopen_search_sort_filter;
    public final SmartSearchFilter.FromUserFilter msmart_search_from_user;
    public final SmartSearchFilter.InChatFilter msmart_search_in_chat;
    public final SmartSearchFilter.TimeRangeFilter msmart_search_time_range;
    public final SmartSearchFilter.WithUserFilter msmart_search_with_user;
    public final DocsFilter.InWikiSpaceFilter mwikis_in_wiki_space;

    public static final class Builder extends Message.Builder<SearchActionFilter, Builder> {
        public MessageFilter.ChatTypeFilter mchat_type_filter;
        public DocsFilter.ContainerTypeFilter mdocs_container_type;
        public DocsFilter.FromUserFilter mdocs_from_user;
        public DocsFilter.InChatFilter mdocs_in_chat;
        public DocsFilter.InFolderFilter mdocs_in_folder;
        public DocsFilter.MatchTypeFilter mdocs_match_type;
        public DocsFilter.ObjectTypeFilter mdocs_object_type;
        public DocsFilter.OpenTimeRangeFilter mdocs_open_time_range;
        public DocsFilter.OwnerFilter mdocs_owner;
        public DocsFilter.SharerFilter mdocs_sharer;
        public DocsFilter.Sorter mdocs_sorter;
        public DocsFilter.EnableExtendedSearch menable_extended_search;
        public GroupChatFilter.IncludeUserFilter mgroup_chat_include_user;
        public GroupChatFilter.SearchTypeFilter mgroup_chat_search_type;
        public GroupChatFilter.SortRuleFilter mgroup_chat_sort_type;
        public MessageFilter.AttachmentFilter mmessage_attachment;
        public MessageFilter.FromUserFilter mmessage_from_user;
        public MessageFilter.InChatFilter mmessage_in_chat;
        public MessageFilter.MatchScopeFilter mmessage_match_scope;
        public MessageFilter.TimeFilter mmessage_time_range;
        public MessageFilter.MessageTypeFilter mmessage_type;
        public MessageFilter.WithUserFilter mmessage_with_user;
        public OpenSearchFilter.OpenSearchSortFilter mopen_search_sort_filter;
        public SmartSearchFilter.FromUserFilter msmart_search_from_user;
        public SmartSearchFilter.InChatFilter msmart_search_in_chat;
        public SmartSearchFilter.TimeRangeFilter msmart_search_time_range;
        public SmartSearchFilter.WithUserFilter msmart_search_with_user;
        public DocsFilter.InWikiSpaceFilter mwikis_in_wiki_space;

        @Override // com.squareup.wire.Message.Builder
        public SearchActionFilter build() {
            return new SearchActionFilter(this.msmart_search_from_user, this.msmart_search_in_chat, this.msmart_search_time_range, this.msmart_search_with_user, this.mmessage_time_range, this.mmessage_from_user, this.mmessage_in_chat, this.mmessage_type, this.mmessage_match_scope, this.mchat_type_filter, this.mmessage_with_user, this.mmessage_attachment, this.mgroup_chat_search_type, this.mgroup_chat_include_user, this.mgroup_chat_sort_type, this.mdocs_from_user, this.mdocs_owner, this.mdocs_sharer, this.mdocs_container_type, this.mdocs_object_type, this.mdocs_open_time_range, this.mdocs_match_type, this.mdocs_in_chat, this.mdocs_sorter, this.mdocs_in_folder, this.mwikis_in_wiki_space, this.menable_extended_search, this.mopen_search_sort_filter, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_type_filter(MessageFilter.ChatTypeFilter r100) {
            this.mchat_type_filter = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_container_type(DocsFilter.ContainerTypeFilter r100) {
            this.mdocs_container_type = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_from_user(DocsFilter.FromUserFilter r100) {
            this.mdocs_from_user = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_in_chat(DocsFilter.InChatFilter r100) {
            this.mdocs_in_chat = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_in_folder(DocsFilter.InFolderFilter r100) {
            this.mdocs_in_folder = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_match_type(DocsFilter.MatchTypeFilter r100) {
            this.mdocs_match_type = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_object_type(DocsFilter.ObjectTypeFilter r100) {
            this.mdocs_object_type = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_open_time_range(DocsFilter.OpenTimeRangeFilter r100) {
            this.mdocs_open_time_range = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_owner(DocsFilter.OwnerFilter r100) {
            this.mdocs_owner = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_sharer(DocsFilter.SharerFilter r100) {
            this.mdocs_sharer = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_sorter(DocsFilter.Sorter r100) {
            this.mdocs_sorter = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder enable_extended_search(DocsFilter.EnableExtendedSearch r100) {
            this.menable_extended_search = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder group_chat_include_user(GroupChatFilter.IncludeUserFilter r100) {
            this.mgroup_chat_include_user = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder group_chat_search_type(GroupChatFilter.SearchTypeFilter r100) {
            this.mgroup_chat_search_type = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder group_chat_sort_type(GroupChatFilter.SortRuleFilter r100) {
            this.mgroup_chat_sort_type = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_attachment(MessageFilter.AttachmentFilter r100) {
            this.mmessage_attachment = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_from_user(MessageFilter.FromUserFilter r100) {
            this.mmessage_from_user = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_in_chat(MessageFilter.InChatFilter r100) {
            this.mmessage_in_chat = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_match_scope(MessageFilter.MatchScopeFilter r100) {
            this.mmessage_match_scope = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_time_range(MessageFilter.TimeFilter r100) {
            this.mmessage_time_range = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_type(MessageFilter.MessageTypeFilter r100) {
            this.mmessage_type = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_with_user(MessageFilter.WithUserFilter r100) {
            this.mmessage_with_user = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder open_search_sort_filter(OpenSearchFilter.OpenSearchSortFilter r100) {
            this.mopen_search_sort_filter = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            return this;
        }

        public Builder smart_search_from_user(SmartSearchFilter.FromUserFilter r100) {
            this.msmart_search_from_user = r100;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder smart_search_in_chat(SmartSearchFilter.InChatFilter r100) {
            this.msmart_search_in_chat = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder smart_search_time_range(SmartSearchFilter.TimeRangeFilter r100) {
            this.msmart_search_time_range = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder smart_search_with_user(SmartSearchFilter.WithUserFilter r100) {
            this.msmart_search_with_user = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder wikis_in_wiki_space(DocsFilter.InWikiSpaceFilter r100) {
            this.mwikis_in_wiki_space = r100;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchActionFilter extends ProtoAdapter<SearchActionFilter> {
        public ProtoAdapter_SearchActionFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchActionFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchActionFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L47;
            if (r103 != 1) goto L8;
            r101.smart_search_from_user(SmartSearchFilter.FromUserFilter.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.smart_search_in_chat(SmartSearchFilter.InChatFilter.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.smart_search_time_range(SmartSearchFilter.TimeRangeFilter.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.smart_search_with_user(SmartSearchFilter.WithUserFilter.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 44) goto L15;
            r101.open_search_sort_filter(OpenSearchFilter.OpenSearchSortFilter.ADAPTER.decode(r100));
            goto L3
        L15:
            switch(r103) {
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L39;
                case 14: goto L38;
                case 15: goto L37;
                case 16: goto L36;
                case 17: goto L35;
                case 18: goto L34;
                default: goto L16;
            };
        L34:
            r101.message_attachment(MessageFilter.AttachmentFilter.ADAPTER.decode(r100));
            goto L3
        L35:
            r101.message_with_user(MessageFilter.WithUserFilter.ADAPTER.decode(r100));
            goto L3
        L36:
            r101.chat_type_filter(MessageFilter.ChatTypeFilter.ADAPTER.decode(r100));
            goto L3
        L37:
            r101.message_match_scope(MessageFilter.MatchScopeFilter.ADAPTER.decode(r100));
            goto L3
        L38:
            r101.message_type(MessageFilter.MessageTypeFilter.ADAPTER.decode(r100));
            goto L3
        L39:
            r101.message_in_chat(MessageFilter.InChatFilter.ADAPTER.decode(r100));
            goto L3
        L40:
            r101.message_from_user(MessageFilter.FromUserFilter.ADAPTER.decode(r100));
            goto L3
        L41:
            r101.message_time_range(MessageFilter.TimeFilter.ADAPTER.decode(r100));
            goto L3
        L16:
            switch(r103) {
                case 21: goto L33;
                case 22: goto L32;
                case 23: goto L31;
                default: goto L17;
            };
        L31:
            r101.group_chat_sort_type(GroupChatFilter.SortRuleFilter.ADAPTER.decode(r100));
            goto L3
        L32:
            r101.group_chat_include_user(GroupChatFilter.IncludeUserFilter.ADAPTER.decode(r100));
            goto L3
        L33:
            r101.group_chat_search_type(GroupChatFilter.SearchTypeFilter.ADAPTER.decode(r100));
            goto L3
        L17:
            switch(r103) {
                case 31: goto L30;
                case 32: goto L29;
                case 33: goto L28;
                case 34: goto L27;
                case 35: goto L26;
                case 36: goto L25;
                case 37: goto L24;
                case 38: goto L23;
                case 39: goto L22;
                case 40: goto L21;
                case 41: goto L20;
                case 42: goto L19;
                default: goto L18;
            };
        L19:
            r101.enable_extended_search(DocsFilter.EnableExtendedSearch.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.wikis_in_wiki_space(DocsFilter.InWikiSpaceFilter.ADAPTER.decode(r100));
            goto L3
        L21:
            r101.docs_in_folder(DocsFilter.InFolderFilter.ADAPTER.decode(r100));
            goto L3
        L22:
            r101.docs_sorter(DocsFilter.Sorter.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.docs_in_chat(DocsFilter.InChatFilter.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.docs_match_type(DocsFilter.MatchTypeFilter.ADAPTER.decode(r100));
            goto L3
        L25:
            r101.docs_open_time_range(DocsFilter.OpenTimeRangeFilter.ADAPTER.decode(r100));
            goto L3
        L26:
            r101.docs_object_type(DocsFilter.ObjectTypeFilter.ADAPTER.decode(r100));
            goto L3
        L27:
            r101.docs_container_type(DocsFilter.ContainerTypeFilter.ADAPTER.decode(r100));
            goto L3
        L28:
            r101.docs_sharer(DocsFilter.SharerFilter.ADAPTER.decode(r100));
            goto L3
        L29:
            r101.docs_owner(DocsFilter.OwnerFilter.ADAPTER.decode(r100));
            goto L3
        L30:
            r101.docs_from_user(DocsFilter.FromUserFilter.ADAPTER.decode(r100));
            goto L3
        L18:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L47:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchActionFilter r100) {
            SmartSearchFilter.FromUserFilter r101 = r100.msmart_search_from_user;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SmartSearchFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            SmartSearchFilter.InChatFilter r104 = r100.msmart_search_in_chat;
            if (r104 == null) goto L9;
            int r105 = SmartSearchFilter.InChatFilter.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SmartSearchFilter.TimeRangeFilter r107 = r100.msmart_search_time_range;
            if (r107 == null) goto L13;
            int r108 = SmartSearchFilter.TimeRangeFilter.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            SmartSearchFilter.WithUserFilter r110 = r100.msmart_search_with_user;
            if (r110 == null) goto L17;
            int r111 = SmartSearchFilter.WithUserFilter.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            MessageFilter.TimeFilter r113 = r100.mmessage_time_range;
            if (r113 == null) goto L21;
            int r114 = MessageFilter.TimeFilter.ADAPTER.encodedSizeWithTag(11, r113);
        L22:
            int r115 = r112 + r114;
            MessageFilter.FromUserFilter r116 = r100.mmessage_from_user;
            if (r116 == null) goto L25;
            int r117 = MessageFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(12, r116);
        L26:
            int r118 = r115 + r117;
            MessageFilter.InChatFilter r119 = r100.mmessage_in_chat;
            if (r119 == null) goto L29;
            int r120 = MessageFilter.InChatFilter.ADAPTER.encodedSizeWithTag(13, r119);
        L30:
            int r121 = r118 + r120;
            MessageFilter.MessageTypeFilter r122 = r100.mmessage_type;
            if (r122 == null) goto L33;
            int r123 = MessageFilter.MessageTypeFilter.ADAPTER.encodedSizeWithTag(14, r122);
        L34:
            int r124 = r121 + r123;
            MessageFilter.MatchScopeFilter r125 = r100.mmessage_match_scope;
            if (r125 == null) goto L37;
            int r126 = MessageFilter.MatchScopeFilter.ADAPTER.encodedSizeWithTag(15, r125);
        L38:
            int r127 = r124 + r126;
            MessageFilter.ChatTypeFilter r128 = r100.mchat_type_filter;
            if (r128 == null) goto L41;
            int r129 = MessageFilter.ChatTypeFilter.ADAPTER.encodedSizeWithTag(16, r128);
        L42:
            int r130 = r127 + r129;
            MessageFilter.WithUserFilter r131 = r100.mmessage_with_user;
            if (r131 == null) goto L45;
            int r132 = MessageFilter.WithUserFilter.ADAPTER.encodedSizeWithTag(17, r131);
        L46:
            int r133 = r130 + r132;
            MessageFilter.AttachmentFilter r134 = r100.mmessage_attachment;
            if (r134 == null) goto L49;
            int r135 = MessageFilter.AttachmentFilter.ADAPTER.encodedSizeWithTag(18, r134);
        L50:
            int r136 = r133 + r135;
            GroupChatFilter.SearchTypeFilter r137 = r100.mgroup_chat_search_type;
            if (r137 == null) goto L53;
            int r138 = GroupChatFilter.SearchTypeFilter.ADAPTER.encodedSizeWithTag(21, r137);
        L54:
            int r139 = r136 + r138;
            GroupChatFilter.IncludeUserFilter r140 = r100.mgroup_chat_include_user;
            if (r140 == null) goto L57;
            int r141 = GroupChatFilter.IncludeUserFilter.ADAPTER.encodedSizeWithTag(22, r140);
        L58:
            int r142 = r139 + r141;
            GroupChatFilter.SortRuleFilter r143 = r100.mgroup_chat_sort_type;
            if (r143 == null) goto L61;
            int r144 = GroupChatFilter.SortRuleFilter.ADAPTER.encodedSizeWithTag(23, r143);
        L62:
            int r145 = r142 + r144;
            DocsFilter.FromUserFilter r146 = r100.mdocs_from_user;
            if (r146 == null) goto L65;
            int r147 = DocsFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(31, r146);
        L66:
            int r148 = r145 + r147;
            DocsFilter.OwnerFilter r149 = r100.mdocs_owner;
            if (r149 == null) goto L69;
            int r150 = DocsFilter.OwnerFilter.ADAPTER.encodedSizeWithTag(32, r149);
        L70:
            int r151 = r148 + r150;
            DocsFilter.SharerFilter r152 = r100.mdocs_sharer;
            if (r152 == null) goto L73;
            int r153 = DocsFilter.SharerFilter.ADAPTER.encodedSizeWithTag(33, r152);
        L74:
            int r154 = r151 + r153;
            DocsFilter.ContainerTypeFilter r155 = r100.mdocs_container_type;
            if (r155 == null) goto L77;
            int r156 = DocsFilter.ContainerTypeFilter.ADAPTER.encodedSizeWithTag(34, r155);
        L78:
            int r157 = r154 + r156;
            DocsFilter.ObjectTypeFilter r158 = r100.mdocs_object_type;
            if (r158 == null) goto L81;
            int r159 = DocsFilter.ObjectTypeFilter.ADAPTER.encodedSizeWithTag(35, r158);
        L82:
            int r160 = r157 + r159;
            DocsFilter.OpenTimeRangeFilter r161 = r100.mdocs_open_time_range;
            if (r161 == null) goto L85;
            int r162 = DocsFilter.OpenTimeRangeFilter.ADAPTER.encodedSizeWithTag(36, r161);
        L86:
            int r163 = r160 + r162;
            DocsFilter.MatchTypeFilter r164 = r100.mdocs_match_type;
            if (r164 == null) goto L89;
            int r165 = DocsFilter.MatchTypeFilter.ADAPTER.encodedSizeWithTag(37, r164);
        L90:
            int r166 = r163 + r165;
            DocsFilter.InChatFilter r167 = r100.mdocs_in_chat;
            if (r167 == null) goto L93;
            int r168 = DocsFilter.InChatFilter.ADAPTER.encodedSizeWithTag(38, r167);
        L94:
            int r169 = r166 + r168;
            DocsFilter.Sorter r170 = r100.mdocs_sorter;
            if (r170 == null) goto L97;
            int r171 = DocsFilter.Sorter.ADAPTER.encodedSizeWithTag(39, r170);
        L98:
            int r172 = r169 + r171;
            DocsFilter.InFolderFilter r173 = r100.mdocs_in_folder;
            if (r173 == null) goto L101;
            int r174 = DocsFilter.InFolderFilter.ADAPTER.encodedSizeWithTag(40, r173);
        L102:
            int r175 = r172 + r174;
            DocsFilter.InWikiSpaceFilter r176 = r100.mwikis_in_wiki_space;
            if (r176 == null) goto L105;
            int r177 = DocsFilter.InWikiSpaceFilter.ADAPTER.encodedSizeWithTag(41, r176);
        L106:
            int r178 = r175 + r177;
            DocsFilter.EnableExtendedSearch r179 = r100.menable_extended_search;
            if (r179 == null) goto L109;
            int r180 = DocsFilter.EnableExtendedSearch.ADAPTER.encodedSizeWithTag(42, r179);
        L110:
            int r181 = r178 + r180;
            OpenSearchFilter.OpenSearchSortFilter r182 = r100.mopen_search_sort_filter;
            if (r182 == null) goto L114;
            r102 = OpenSearchFilter.OpenSearchSortFilter.ADAPTER.encodedSizeWithTag(44, r182);
        L114:
            return (r181 + r102) + r100.unknownFields().size();
        L109:
            r180 = 0;
            goto L110
        L105:
            r177 = 0;
            goto L106
        L101:
            r174 = 0;
            goto L102
        L97:
            r171 = 0;
            goto L98
        L93:
            r168 = 0;
            goto L94
        L89:
            r165 = 0;
            goto L90
        L85:
            r162 = 0;
            goto L86
        L81:
            r159 = 0;
            goto L82
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
        public /* bridge */ /* synthetic */ SearchActionFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchActionFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchActionFilter r101) throws IOException {
            SmartSearchFilter.FromUserFilter r102 = r101.msmart_search_from_user;
            if (r102 == null) goto L5;
            SmartSearchFilter.FromUserFilter.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            SmartSearchFilter.InChatFilter r103 = r101.msmart_search_in_chat;
            if (r103 == null) goto L8;
            SmartSearchFilter.InChatFilter.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            SmartSearchFilter.TimeRangeFilter r104 = r101.msmart_search_time_range;
            if (r104 == null) goto L11;
            SmartSearchFilter.TimeRangeFilter.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            SmartSearchFilter.WithUserFilter r105 = r101.msmart_search_with_user;
            if (r105 == null) goto L14;
            SmartSearchFilter.WithUserFilter.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            MessageFilter.TimeFilter r106 = r101.mmessage_time_range;
            if (r106 == null) goto L17;
            MessageFilter.TimeFilter.ADAPTER.encodeWithTag(r100, 11, r106);
        L17:
            MessageFilter.FromUserFilter r107 = r101.mmessage_from_user;
            if (r107 == null) goto L20;
            MessageFilter.FromUserFilter.ADAPTER.encodeWithTag(r100, 12, r107);
        L20:
            MessageFilter.InChatFilter r108 = r101.mmessage_in_chat;
            if (r108 == null) goto L23;
            MessageFilter.InChatFilter.ADAPTER.encodeWithTag(r100, 13, r108);
        L23:
            MessageFilter.MessageTypeFilter r109 = r101.mmessage_type;
            if (r109 == null) goto L26;
            MessageFilter.MessageTypeFilter.ADAPTER.encodeWithTag(r100, 14, r109);
        L26:
            MessageFilter.MatchScopeFilter r110 = r101.mmessage_match_scope;
            if (r110 == null) goto L29;
            MessageFilter.MatchScopeFilter.ADAPTER.encodeWithTag(r100, 15, r110);
        L29:
            MessageFilter.ChatTypeFilter r111 = r101.mchat_type_filter;
            if (r111 == null) goto L32;
            MessageFilter.ChatTypeFilter.ADAPTER.encodeWithTag(r100, 16, r111);
        L32:
            MessageFilter.WithUserFilter r112 = r101.mmessage_with_user;
            if (r112 == null) goto L35;
            MessageFilter.WithUserFilter.ADAPTER.encodeWithTag(r100, 17, r112);
        L35:
            MessageFilter.AttachmentFilter r113 = r101.mmessage_attachment;
            if (r113 == null) goto L38;
            MessageFilter.AttachmentFilter.ADAPTER.encodeWithTag(r100, 18, r113);
        L38:
            GroupChatFilter.SearchTypeFilter r114 = r101.mgroup_chat_search_type;
            if (r114 == null) goto L41;
            GroupChatFilter.SearchTypeFilter.ADAPTER.encodeWithTag(r100, 21, r114);
        L41:
            GroupChatFilter.IncludeUserFilter r115 = r101.mgroup_chat_include_user;
            if (r115 == null) goto L44;
            GroupChatFilter.IncludeUserFilter.ADAPTER.encodeWithTag(r100, 22, r115);
        L44:
            GroupChatFilter.SortRuleFilter r116 = r101.mgroup_chat_sort_type;
            if (r116 == null) goto L47;
            GroupChatFilter.SortRuleFilter.ADAPTER.encodeWithTag(r100, 23, r116);
        L47:
            DocsFilter.FromUserFilter r117 = r101.mdocs_from_user;
            if (r117 == null) goto L50;
            DocsFilter.FromUserFilter.ADAPTER.encodeWithTag(r100, 31, r117);
        L50:
            DocsFilter.OwnerFilter r118 = r101.mdocs_owner;
            if (r118 == null) goto L53;
            DocsFilter.OwnerFilter.ADAPTER.encodeWithTag(r100, 32, r118);
        L53:
            DocsFilter.SharerFilter r119 = r101.mdocs_sharer;
            if (r119 == null) goto L56;
            DocsFilter.SharerFilter.ADAPTER.encodeWithTag(r100, 33, r119);
        L56:
            DocsFilter.ContainerTypeFilter r120 = r101.mdocs_container_type;
            if (r120 == null) goto L59;
            DocsFilter.ContainerTypeFilter.ADAPTER.encodeWithTag(r100, 34, r120);
        L59:
            DocsFilter.ObjectTypeFilter r121 = r101.mdocs_object_type;
            if (r121 == null) goto L62;
            DocsFilter.ObjectTypeFilter.ADAPTER.encodeWithTag(r100, 35, r121);
        L62:
            DocsFilter.OpenTimeRangeFilter r122 = r101.mdocs_open_time_range;
            if (r122 == null) goto L65;
            DocsFilter.OpenTimeRangeFilter.ADAPTER.encodeWithTag(r100, 36, r122);
        L65:
            DocsFilter.MatchTypeFilter r123 = r101.mdocs_match_type;
            if (r123 == null) goto L68;
            DocsFilter.MatchTypeFilter.ADAPTER.encodeWithTag(r100, 37, r123);
        L68:
            DocsFilter.InChatFilter r124 = r101.mdocs_in_chat;
            if (r124 == null) goto L71;
            DocsFilter.InChatFilter.ADAPTER.encodeWithTag(r100, 38, r124);
        L71:
            DocsFilter.Sorter r125 = r101.mdocs_sorter;
            if (r125 == null) goto L74;
            DocsFilter.Sorter.ADAPTER.encodeWithTag(r100, 39, r125);
        L74:
            DocsFilter.InFolderFilter r126 = r101.mdocs_in_folder;
            if (r126 == null) goto L77;
            DocsFilter.InFolderFilter.ADAPTER.encodeWithTag(r100, 40, r126);
        L77:
            DocsFilter.InWikiSpaceFilter r127 = r101.mwikis_in_wiki_space;
            if (r127 == null) goto L80;
            DocsFilter.InWikiSpaceFilter.ADAPTER.encodeWithTag(r100, 41, r127);
        L80:
            DocsFilter.EnableExtendedSearch r128 = r101.menable_extended_search;
            if (r128 == null) goto L83;
            DocsFilter.EnableExtendedSearch.ADAPTER.encodeWithTag(r100, 42, r128);
        L83:
            OpenSearchFilter.OpenSearchSortFilter r129 = r101.mopen_search_sort_filter;
            if (r129 == null) goto L86;
            OpenSearchFilter.OpenSearchSortFilter.ADAPTER.encodeWithTag(r100, 44, r129);
        L86:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchActionFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchActionFilter();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msmart_search_from_user = this.msmart_search_from_user;
        r100.msmart_search_in_chat = this.msmart_search_in_chat;
        r100.msmart_search_time_range = this.msmart_search_time_range;
        r100.msmart_search_with_user = this.msmart_search_with_user;
        r100.mmessage_time_range = this.mmessage_time_range;
        r100.mmessage_from_user = this.mmessage_from_user;
        r100.mmessage_in_chat = this.mmessage_in_chat;
        r100.mmessage_type = this.mmessage_type;
        r100.mmessage_match_scope = this.mmessage_match_scope;
        r100.mchat_type_filter = this.mchat_type_filter;
        r100.mmessage_with_user = this.mmessage_with_user;
        r100.mmessage_attachment = this.mmessage_attachment;
        r100.mgroup_chat_search_type = this.mgroup_chat_search_type;
        r100.mgroup_chat_include_user = this.mgroup_chat_include_user;
        r100.mgroup_chat_sort_type = this.mgroup_chat_sort_type;
        r100.mdocs_from_user = this.mdocs_from_user;
        r100.mdocs_owner = this.mdocs_owner;
        r100.mdocs_sharer = this.mdocs_sharer;
        r100.mdocs_container_type = this.mdocs_container_type;
        r100.mdocs_object_type = this.mdocs_object_type;
        r100.mdocs_open_time_range = this.mdocs_open_time_range;
        r100.mdocs_match_type = this.mdocs_match_type;
        r100.mdocs_in_chat = this.mdocs_in_chat;
        r100.mdocs_sorter = this.mdocs_sorter;
        r100.mdocs_in_folder = this.mdocs_in_folder;
        r100.mwikis_in_wiki_space = this.mwikis_in_wiki_space;
        r100.menable_extended_search = this.menable_extended_search;
        r100.mopen_search_sort_filter = this.mopen_search_sort_filter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchActionFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchActionFilter(SmartSearchFilter.FromUserFilter r310, SmartSearchFilter.InChatFilter r311, SmartSearchFilter.TimeRangeFilter r312, SmartSearchFilter.WithUserFilter r313, MessageFilter.TimeFilter r314, MessageFilter.FromUserFilter r315, MessageFilter.InChatFilter r316, MessageFilter.MessageTypeFilter r317, MessageFilter.MatchScopeFilter r318, MessageFilter.ChatTypeFilter r410, MessageFilter.WithUserFilter r411, MessageFilter.AttachmentFilter r412, GroupChatFilter.SearchTypeFilter r413, GroupChatFilter.IncludeUserFilter r414, GroupChatFilter.SortRuleFilter r415, DocsFilter.FromUserFilter r416, DocsFilter.OwnerFilter r417, DocsFilter.SharerFilter r418, DocsFilter.ContainerTypeFilter r419, DocsFilter.ObjectTypeFilter r510, DocsFilter.OpenTimeRangeFilter r511, DocsFilter.MatchTypeFilter r512, DocsFilter.InChatFilter r513, DocsFilter.Sorter r514, DocsFilter.InFolderFilter r515, DocsFilter.InWikiSpaceFilter r516, DocsFilter.EnableExtendedSearch r517, OpenSearchFilter.OpenSearchSortFilter r518) {
        this(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, ByteString.EMPTY);
    }

    public SearchActionFilter(SmartSearchFilter.FromUserFilter r110, SmartSearchFilter.InChatFilter r111, SmartSearchFilter.TimeRangeFilter r210, SmartSearchFilter.WithUserFilter r211, MessageFilter.TimeFilter r212, MessageFilter.FromUserFilter r213, MessageFilter.InChatFilter r214, MessageFilter.MessageTypeFilter r215, MessageFilter.MatchScopeFilter r216, MessageFilter.ChatTypeFilter r217, MessageFilter.WithUserFilter r218, MessageFilter.AttachmentFilter r219, GroupChatFilter.SearchTypeFilter r310, GroupChatFilter.IncludeUserFilter r311, GroupChatFilter.SortRuleFilter r312, DocsFilter.FromUserFilter r313, DocsFilter.OwnerFilter r314, DocsFilter.SharerFilter r315, DocsFilter.ContainerTypeFilter r316, DocsFilter.ObjectTypeFilter r317, DocsFilter.OpenTimeRangeFilter r318, DocsFilter.MatchTypeFilter r319, DocsFilter.InChatFilter r410, DocsFilter.Sorter r411, DocsFilter.InFolderFilter r412, DocsFilter.InWikiSpaceFilter r413, DocsFilter.EnableExtendedSearch r414, OpenSearchFilter.OpenSearchSortFilter r415, ByteString r416) {
        super(ADAPTER, r416);
        if (Internal.countNonNull(r110, r111, r210, r211, new Object[]{r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415}) > 1) goto L7;
        this.msmart_search_from_user = r110;
        this.msmart_search_in_chat = r111;
        this.msmart_search_time_range = r210;
        this.msmart_search_with_user = r211;
        this.mmessage_time_range = r212;
        this.mmessage_from_user = r213;
        this.mmessage_in_chat = r214;
        this.mmessage_type = r215;
        this.mmessage_match_scope = r216;
        this.mchat_type_filter = r217;
        this.mmessage_with_user = r218;
        this.mmessage_attachment = r219;
        this.mgroup_chat_search_type = r310;
        this.mgroup_chat_include_user = r311;
        this.mgroup_chat_sort_type = r312;
        this.mdocs_from_user = r313;
        this.mdocs_owner = r314;
        this.mdocs_sharer = r315;
        this.mdocs_container_type = r316;
        this.mdocs_object_type = r317;
        this.mdocs_open_time_range = r318;
        this.mdocs_match_type = r319;
        this.mdocs_in_chat = r410;
        this.mdocs_sorter = r411;
        this.mdocs_in_folder = r412;
        this.mwikis_in_wiki_space = r413;
        this.menable_extended_search = r414;
        this.mopen_search_sort_filter = r415;
        return;
    L7:
        throw new IllegalArgumentException("at most one of msmart_search_from_user, msmart_search_in_chat, msmart_search_time_range, msmart_search_with_user, mmessage_time_range, mmessage_from_user, mmessage_in_chat, mmessage_type, mmessage_match_scope, mchat_type_filter, mmessage_with_user, mmessage_attachment, mgroup_chat_search_type, mgroup_chat_include_user, mgroup_chat_sort_type, mdocs_from_user, mdocs_owner, mdocs_sharer, mdocs_container_type, mdocs_object_type, mdocs_open_time_range, mdocs_match_type, mdocs_in_chat, mdocs_sorter, mdocs_in_folder, mwikis_in_wiki_space, menable_extended_search, mopen_search_sort_filter may be non-null");
    }
}
