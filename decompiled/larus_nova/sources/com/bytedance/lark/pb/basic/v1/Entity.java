package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.bytedance.lark.pb.openplatform.v1.AppInfoItem;
import com.bytedance.lark.pb.vote.v1.VotedInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class Entity extends com.squareup.wire.Message<Entity, Builder> {
    public static final ProtoAdapter<Entity> ADAPTER = null;
    public static final ProtoAdapter_Entity RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, AbbreviationEntity> abbrevs;
    public final Map<String, MessageAnalysisConfig> analysis_configs;
    public final Map<Long, AppInfoItem> app_info_items;
    public final Map<String, ChatChatter> chat_chatters;
    public final Map<Long, ByteString> chat_themes;
    public final Map<String, Chat> chats;
    public final Map<Long, ChatterSensitiveInfo> chatter_id_to_sensitive_info;
    public final Map<String, Chatter> chatters;
    public final Map<String, Department> departments;
    public final Map<String, DocFeed> doc_feeds;
    public final Map<String, DocMessage> doc_messages;
    public final Map<String, DocPermission> doc_permissions;
    public final Map<String, Doc> docs;
    public final Map<String, Draft> drafts;
    public final Map<Long, EditingMessageInfo> editing_message_infos;
    public final Map<String, Email> emails;
    public final Map<String, Message> ephemeral_messages;
    public final Map<String, FavoritesObject> favorites;
    public final Map<String, FeedCard> feed_cards;
    public final Map<String, ChatMailSetting> mail_setting;
    public final Map<String, HashTagMentionEntity> mentions;
    public final Map<String, SubTranslateInfo> merge_forward_translate_messages;
    public final Map<Long, MessageFoldDetail> message_fold_details;
    public final Map<String, DocPermissionInfo> message_id2doc_permission_infos;
    public final Map<String, MessageLink> message_links;
    public final Map<Long, MessageLocalDataInfoMap> message_local_data;
    public final Map<String, Message> messages;
    public final Map<String, Oncall> oncalls;
    public final Map<String, OpenApp> open_apps;
    public final List<PackStackInfo> pack_stack_infos;
    public final Map<String, PreviewEntityPair> preview_entities;
    public final Map<String, URLPreviewTemplate> preview_templates;
    public final Map<String, QuasiMessage> quasi_messages;
    public final Map<String, QuasiScheduleMessage> quasi_schedule_message;
    public final Map<String, QuasiThread> quasi_threads;
    public final Map<String, ScheduleMessage> schedule_message;
    public final Map<String, Team> teams;
    public final Map<String, Tenant> tenants;
    public final Map<String, Thread> threads;
    public final Map<String, TopicGroup> topic_groups;
    public final Map<String, TranslateInfo> translate_messages;
    public final Map<String, Urgent> urgents;
    public final Map<Long, UserGroupEntity> user_groups;
    public final Map<Long, VotedInfo> voted_infos;

    public static final class Builder extends com.squareup.wire.Message.Builder<Entity, Builder> implements d<Entity> {
        public Map<String, AbbreviationEntity> abbrevs;
        public Map<String, MessageAnalysisConfig> analysis_configs;
        public Map<Long, AppInfoItem> app_info_items;
        public Map<String, ChatChatter> chat_chatters;
        public Map<Long, ByteString> chat_themes;
        public Map<String, Chat> chats;
        public Map<Long, ChatterSensitiveInfo> chatter_id_to_sensitive_info;
        public Map<String, Chatter> chatters;
        public Map<String, Department> departments;
        public Map<String, DocFeed> doc_feeds;
        public Map<String, DocMessage> doc_messages;
        public Map<String, DocPermission> doc_permissions;
        public Map<String, Doc> docs;
        public Map<String, Draft> drafts;
        public Map<Long, EditingMessageInfo> editing_message_infos;
        public Map<String, Email> emails;
        public Map<String, Message> ephemeral_messages;
        public Map<String, FavoritesObject> favorites;
        public Map<String, FeedCard> feed_cards;
        public Map<String, ChatMailSetting> mail_setting;
        public Map<String, HashTagMentionEntity> mentions;
        public Map<String, SubTranslateInfo> merge_forward_translate_messages;
        public Map<Long, MessageFoldDetail> message_fold_details;
        public Map<String, DocPermissionInfo> message_id2doc_permission_infos;
        public Map<String, MessageLink> message_links;
        public Map<Long, MessageLocalDataInfoMap> message_local_data;
        public Map<String, Message> messages;
        public Map<String, Oncall> oncalls;
        public Map<String, OpenApp> open_apps;
        public List<PackStackInfo> pack_stack_infos;
        public Map<String, PreviewEntityPair> preview_entities;
        public Map<String, URLPreviewTemplate> preview_templates;
        public Map<String, QuasiMessage> quasi_messages;
        public Map<String, QuasiScheduleMessage> quasi_schedule_message;
        public Map<String, QuasiThread> quasi_threads;
        public Map<String, ScheduleMessage> schedule_message;
        public Map<String, Team> teams;
        public Map<String, Tenant> tenants;
        public Map<String, Thread> threads;
        public Map<String, TopicGroup> topic_groups;
        public Map<String, TranslateInfo> translate_messages;
        public Map<String, Urgent> urgents;
        public Map<Long, UserGroupEntity> user_groups;
        public Map<Long, VotedInfo> voted_infos;

        @Override // com.squareup.wire.Message.Builder
        public Entity build() {
            return new Entity(this.messages, this.chats, this.chatters, this.quasi_messages, this.departments, this.urgents, this.drafts, this.feed_cards, this.emails, this.docs, this.doc_permissions, this.doc_feeds, this.doc_messages, this.threads, this.quasi_threads, this.favorites, this.translate_messages, this.tenants, this.chat_chatters, this.message_id2doc_permission_infos, this.open_apps, this.oncalls, this.topic_groups, this.abbrevs, this.ephemeral_messages, this.merge_forward_translate_messages, this.mail_setting, this.mentions, this.preview_entities, this.preview_templates, this.voted_infos, this.teams, this.editing_message_infos, this.message_fold_details, this.quasi_schedule_message, this.schedule_message, this.chat_themes, this.message_local_data, this.pack_stack_infos, this.message_links, this.chatter_id_to_sensitive_info, this.app_info_items, this.user_groups, this.analysis_configs, super.buildUnknownFields());
        }

        public Builder() {
            this.messages = Internal.newMutableMap();
            this.chats = Internal.newMutableMap();
            this.chatters = Internal.newMutableMap();
            this.quasi_messages = Internal.newMutableMap();
            this.departments = Internal.newMutableMap();
            this.urgents = Internal.newMutableMap();
            this.drafts = Internal.newMutableMap();
            this.feed_cards = Internal.newMutableMap();
            this.emails = Internal.newMutableMap();
            this.docs = Internal.newMutableMap();
            this.doc_permissions = Internal.newMutableMap();
            this.doc_feeds = Internal.newMutableMap();
            this.doc_messages = Internal.newMutableMap();
            this.threads = Internal.newMutableMap();
            this.quasi_threads = Internal.newMutableMap();
            this.favorites = Internal.newMutableMap();
            this.translate_messages = Internal.newMutableMap();
            this.tenants = Internal.newMutableMap();
            this.chat_chatters = Internal.newMutableMap();
            this.message_id2doc_permission_infos = Internal.newMutableMap();
            this.open_apps = Internal.newMutableMap();
            this.oncalls = Internal.newMutableMap();
            this.topic_groups = Internal.newMutableMap();
            this.abbrevs = Internal.newMutableMap();
            this.ephemeral_messages = Internal.newMutableMap();
            this.merge_forward_translate_messages = Internal.newMutableMap();
            this.mail_setting = Internal.newMutableMap();
            this.mentions = Internal.newMutableMap();
            this.preview_entities = Internal.newMutableMap();
            this.preview_templates = Internal.newMutableMap();
            this.voted_infos = Internal.newMutableMap();
            this.teams = Internal.newMutableMap();
            this.editing_message_infos = Internal.newMutableMap();
            this.message_fold_details = Internal.newMutableMap();
            this.quasi_schedule_message = Internal.newMutableMap();
            this.schedule_message = Internal.newMutableMap();
            this.chat_themes = Internal.newMutableMap();
            this.message_local_data = Internal.newMutableMap();
            this.pack_stack_infos = Internal.newMutableList();
            this.message_links = Internal.newMutableMap();
            this.chatter_id_to_sensitive_info = Internal.newMutableMap();
            this.app_info_items = Internal.newMutableMap();
            this.user_groups = Internal.newMutableMap();
            this.analysis_configs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder abbrevs(Map<String, AbbreviationEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.abbrevs = r100;
            return this;
        }

        public Builder analysis_configs(Map<String, MessageAnalysisConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.analysis_configs = r100;
            return this;
        }

        public Builder app_info_items(Map<Long, AppInfoItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.app_info_items = r100;
            return this;
        }

        public Builder chat_chatters(Map<String, ChatChatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_chatters = r100;
            return this;
        }

        public Builder chat_themes(Map<Long, ByteString> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_themes = r100;
            return this;
        }

        public Builder chats(Map<String, Chat> r100) {
            Internal.checkElementsNotNull(r100);
            this.chats = r100;
            return this;
        }

        public Builder chatter_id_to_sensitive_info(Map<Long, ChatterSensitiveInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_id_to_sensitive_info = r100;
            return this;
        }

        public Builder chatters(Map<String, Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }

        public Builder departments(Map<String, Department> r100) {
            Internal.checkElementsNotNull(r100);
            this.departments = r100;
            return this;
        }

        public Builder doc_feeds(Map<String, DocFeed> r100) {
            Internal.checkElementsNotNull(r100);
            this.doc_feeds = r100;
            return this;
        }

        public Builder doc_messages(Map<String, DocMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.doc_messages = r100;
            return this;
        }

        public Builder doc_permissions(Map<String, DocPermission> r100) {
            Internal.checkElementsNotNull(r100);
            this.doc_permissions = r100;
            return this;
        }

        public Builder docs(Map<String, Doc> r100) {
            Internal.checkElementsNotNull(r100);
            this.docs = r100;
            return this;
        }

        public Builder drafts(Map<String, Draft> r100) {
            Internal.checkElementsNotNull(r100);
            this.drafts = r100;
            return this;
        }

        public Builder editing_message_infos(Map<Long, EditingMessageInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.editing_message_infos = r100;
            return this;
        }

        public Builder emails(Map<String, Email> r100) {
            Internal.checkElementsNotNull(r100);
            this.emails = r100;
            return this;
        }

        public Builder ephemeral_messages(Map<String, Message> r100) {
            Internal.checkElementsNotNull(r100);
            this.ephemeral_messages = r100;
            return this;
        }

        public Builder favorites(Map<String, FavoritesObject> r100) {
            Internal.checkElementsNotNull(r100);
            this.favorites = r100;
            return this;
        }

        public Builder feed_cards(Map<String, FeedCard> r100) {
            Internal.checkElementsNotNull(r100);
            this.feed_cards = r100;
            return this;
        }

        public Builder mail_setting(Map<String, ChatMailSetting> r100) {
            Internal.checkElementsNotNull(r100);
            this.mail_setting = r100;
            return this;
        }

        public Builder mentions(Map<String, HashTagMentionEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.mentions = r100;
            return this;
        }

        public Builder merge_forward_translate_messages(Map<String, SubTranslateInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.merge_forward_translate_messages = r100;
            return this;
        }

        public Builder message_fold_details(Map<Long, MessageFoldDetail> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_fold_details = r100;
            return this;
        }

        public Builder message_id2doc_permission_infos(Map<String, DocPermissionInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id2doc_permission_infos = r100;
            return this;
        }

        public Builder message_links(Map<String, MessageLink> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_links = r100;
            return this;
        }

        public Builder message_local_data(Map<Long, MessageLocalDataInfoMap> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_local_data = r100;
            return this;
        }

        public Builder messages(Map<String, Message> r100) {
            Internal.checkElementsNotNull(r100);
            this.messages = r100;
            return this;
        }

        public Builder oncalls(Map<String, Oncall> r100) {
            Internal.checkElementsNotNull(r100);
            this.oncalls = r100;
            return this;
        }

        public Builder open_apps(Map<String, OpenApp> r100) {
            Internal.checkElementsNotNull(r100);
            this.open_apps = r100;
            return this;
        }

        public Builder pack_stack_infos(List<PackStackInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.pack_stack_infos = r100;
            return this;
        }

        public Builder preview_entities(Map<String, PreviewEntityPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entities = r100;
            return this;
        }

        public Builder preview_templates(Map<String, URLPreviewTemplate> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_templates = r100;
            return this;
        }

        public Builder quasi_messages(Map<String, QuasiMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.quasi_messages = r100;
            return this;
        }

        public Builder quasi_schedule_message(Map<String, QuasiScheduleMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.quasi_schedule_message = r100;
            return this;
        }

        public Builder quasi_threads(Map<String, QuasiThread> r100) {
            Internal.checkElementsNotNull(r100);
            this.quasi_threads = r100;
            return this;
        }

        public Builder schedule_message(Map<String, ScheduleMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.schedule_message = r100;
            return this;
        }

        public Builder teams(Map<String, Team> r100) {
            Internal.checkElementsNotNull(r100);
            this.teams = r100;
            return this;
        }

        public Builder tenants(Map<String, Tenant> r100) {
            Internal.checkElementsNotNull(r100);
            this.tenants = r100;
            return this;
        }

        public Builder threads(Map<String, Thread> r100) {
            Internal.checkElementsNotNull(r100);
            this.threads = r100;
            return this;
        }

        public Builder topic_groups(Map<String, TopicGroup> r100) {
            Internal.checkElementsNotNull(r100);
            this.topic_groups = r100;
            return this;
        }

        public Builder translate_messages(Map<String, TranslateInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.translate_messages = r100;
            return this;
        }

        public Builder urgents(Map<String, Urgent> r100) {
            Internal.checkElementsNotNull(r100);
            this.urgents = r100;
            return this;
        }

        public Builder user_groups(Map<Long, UserGroupEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_groups = r100;
            return this;
        }

        public Builder voted_infos(Map<Long, VotedInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.voted_infos = r100;
            return this;
        }
    }

    public static final class ChatChatter extends com.squareup.wire.Message<ChatChatter, Builder> {
        public static final ProtoAdapter<ChatChatter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, Chatter> chatters;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatChatter, Builder> {
            public Map<String, Chatter> chatters;

            @Override // com.squareup.wire.Message.Builder
            public ChatChatter build() {
                return new ChatChatter(this.chatters, super.buildUnknownFields());
            }

            public Builder() {
                this.chatters = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatters(Map<String, Chatter> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatters = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatChatter extends ProtoAdapter<ChatChatter> {
            private final ProtoAdapter<Map<String, Chatter>> chatters;

            public ProtoAdapter_ChatChatter() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatChatter.class);
                this.chatters = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Chatter.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatChatter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.chatters.putAll(this.chatters.decode(r100));
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
            public int encodedSize2(ChatChatter r100) {
                return this.chatters.encodedSizeWithTag(1, r100.chatters) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatChatter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatChatter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatChatter r101) throws IOException {
                this.chatters.encodeWithTag(r100, 1, r101.chatters);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatChatter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatChatter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatters = Internal.copyOf("chatters", this.chatters);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatChatter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatChatter(Map<String, Chatter> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ChatChatter(Map<String, Chatter> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.chatters = Internal.immutableCopyOf("chatters", r100);
        }
    }

    public static final class DocPermissionInfo extends com.squareup.wire.Message<DocPermissionInfo, Builder> {
        public static final ProtoAdapter<DocPermissionInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, DocPermission> token2doc_permissions;
        public final Map<String, DocPermission> url2doc_permissions;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocPermissionInfo, Builder> {
            public Map<String, DocPermission> token2doc_permissions;
            public Map<String, DocPermission> url2doc_permissions;

            @Override // com.squareup.wire.Message.Builder
            public DocPermissionInfo build() {
                return new DocPermissionInfo(this.token2doc_permissions, this.url2doc_permissions, super.buildUnknownFields());
            }

            public Builder() {
                this.token2doc_permissions = Internal.newMutableMap();
                this.url2doc_permissions = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder token2doc_permissions(Map<String, DocPermission> r100) {
                Internal.checkElementsNotNull(r100);
                this.token2doc_permissions = r100;
                return this;
            }

            public Builder url2doc_permissions(Map<String, DocPermission> r100) {
                Internal.checkElementsNotNull(r100);
                this.url2doc_permissions = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocPermissionInfo extends ProtoAdapter<DocPermissionInfo> {
            private final ProtoAdapter<Map<String, DocPermission>> token2doc_permissions;
            private final ProtoAdapter<Map<String, DocPermission>> url2doc_permissions;

            public ProtoAdapter_DocPermissionInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DocPermissionInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                ProtoAdapter<DocPermission> r101 = DocPermission.ADAPTER;
                this.token2doc_permissions = ProtoAdapter.newMapAdapter(r100, r101);
                this.url2doc_permissions = ProtoAdapter.newMapAdapter(r100, r101);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocPermissionInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.token2doc_permissions.putAll(this.token2doc_permissions.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.url2doc_permissions.putAll(this.url2doc_permissions.decode(r100));
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
            public int encodedSize2(DocPermissionInfo r100) {
                return (this.token2doc_permissions.encodedSizeWithTag(1, r100.token2doc_permissions) + this.url2doc_permissions.encodedSizeWithTag(2, r100.url2doc_permissions)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocPermissionInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocPermissionInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocPermissionInfo r101) throws IOException {
                this.token2doc_permissions.encodeWithTag(r100, 1, r101.token2doc_permissions);
                this.url2doc_permissions.encodeWithTag(r100, 2, r101.url2doc_permissions);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocPermissionInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocPermissionInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.token2doc_permissions = Internal.copyOf("token2doc_permissions", this.token2doc_permissions);
            r100.url2doc_permissions = Internal.copyOf("url2doc_permissions", this.url2doc_permissions);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocPermissionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocPermissionInfo(Map<String, DocPermission> r100, Map<String, DocPermission> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DocPermissionInfo(Map<String, DocPermission> r100, Map<String, DocPermission> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.token2doc_permissions = Internal.immutableCopyOf("token2doc_permissions", r100);
            this.url2doc_permissions = Internal.immutableCopyOf("url2doc_permissions", r101);
        }
    }

    public static final class PackStackInfo extends com.squareup.wire.Message<PackStackInfo, Builder> {
        public static final ProtoAdapter<PackStackInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<Long, Integer> messages;
        public final Map<Long, Integer> threads;

        public static final class Builder extends com.squareup.wire.Message.Builder<PackStackInfo, Builder> {
            public Map<Long, Integer> messages;
            public Map<Long, Integer> threads;

            @Override // com.squareup.wire.Message.Builder
            public PackStackInfo build() {
                return new PackStackInfo(this.messages, this.threads, super.buildUnknownFields());
            }

            public Builder() {
                this.messages = Internal.newMutableMap();
                this.threads = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder messages(Map<Long, Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.messages = r100;
                return this;
            }

            public Builder threads(Map<Long, Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.threads = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PackStackInfo extends ProtoAdapter<PackStackInfo> {
            private final ProtoAdapter<Map<Long, Integer>> messages;
            private final ProtoAdapter<Map<Long, Integer>> threads;

            public ProtoAdapter_PackStackInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PackStackInfo.class);
                ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
                ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
                this.messages = ProtoAdapter.newMapAdapter(r100, r101);
                this.threads = ProtoAdapter.newMapAdapter(r100, r101);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PackStackInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.messages.putAll(this.messages.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.threads.putAll(this.threads.decode(r100));
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
            public int encodedSize2(PackStackInfo r100) {
                return (this.messages.encodedSizeWithTag(1, r100.messages) + this.threads.encodedSizeWithTag(2, r100.threads)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PackStackInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PackStackInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PackStackInfo r101) throws IOException {
                this.messages.encodeWithTag(r100, 1, r101.messages);
                this.threads.encodeWithTag(r100, 2, r101.threads);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PackStackInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PackStackInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.messages = Internal.copyOf("messages", this.messages);
            r100.threads = Internal.copyOf("threads", this.threads);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PackStackInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PackStackInfo(Map<Long, Integer> r100, Map<Long, Integer> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public PackStackInfo(Map<Long, Integer> r100, Map<Long, Integer> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.messages = Internal.immutableCopyOf("messages", r100);
            this.threads = Internal.immutableCopyOf("threads", r101);
        }
    }

    public static final class ProtoAdapter_Entity extends ProtoAdapter<Entity> implements c<Entity> {
        private final ProtoAdapter<Map<String, AbbreviationEntity>> abbrevs;
        private final ProtoAdapter<Map<String, MessageAnalysisConfig>> analysis_configs;
        private final ProtoAdapter<Map<Long, AppInfoItem>> app_info_items;
        private final ProtoAdapter<Map<String, ChatChatter>> chat_chatters;
        private final ProtoAdapter<Map<Long, ByteString>> chat_themes;
        private final ProtoAdapter<Map<String, Chat>> chats;
        private final ProtoAdapter<Map<Long, ChatterSensitiveInfo>> chatter_id_to_sensitive_info;
        private final ProtoAdapter<Map<String, Chatter>> chatters;
        private final ProtoAdapter<Map<String, Department>> departments;
        private final ProtoAdapter<Map<String, DocFeed>> doc_feeds;
        private final ProtoAdapter<Map<String, DocMessage>> doc_messages;
        private final ProtoAdapter<Map<String, DocPermission>> doc_permissions;
        private final ProtoAdapter<Map<String, Doc>> docs;
        private final ProtoAdapter<Map<String, Draft>> drafts;
        private final ProtoAdapter<Map<Long, EditingMessageInfo>> editing_message_infos;
        private final ProtoAdapter<Map<String, Email>> emails;
        private final ProtoAdapter<Map<String, Message>> ephemeral_messages;
        private final ProtoAdapter<Map<String, FavoritesObject>> favorites;
        private final ProtoAdapter<Map<String, FeedCard>> feed_cards;
        private final ProtoAdapter<Map<String, ChatMailSetting>> mail_setting;
        private final ProtoAdapter<Map<String, HashTagMentionEntity>> mentions;
        private final ProtoAdapter<Map<String, SubTranslateInfo>> merge_forward_translate_messages;
        private final ProtoAdapter<Map<Long, MessageFoldDetail>> message_fold_details;
        private final ProtoAdapter<Map<String, DocPermissionInfo>> message_id2doc_permission_infos;
        private final ProtoAdapter<Map<String, MessageLink>> message_links;
        private final ProtoAdapter<Map<Long, MessageLocalDataInfoMap>> message_local_data;
        private final ProtoAdapter<Map<String, Message>> messages;
        private final ProtoAdapter<Map<String, Oncall>> oncalls;
        private final ProtoAdapter<Map<String, OpenApp>> open_apps;
        private final ProtoAdapter<Map<String, PreviewEntityPair>> preview_entities;
        private final ProtoAdapter<Map<String, URLPreviewTemplate>> preview_templates;
        private final ProtoAdapter<Map<String, QuasiMessage>> quasi_messages;
        private final ProtoAdapter<Map<String, QuasiScheduleMessage>> quasi_schedule_message;
        private final ProtoAdapter<Map<String, QuasiThread>> quasi_threads;
        private final ProtoAdapter<Map<String, ScheduleMessage>> schedule_message;
        private final ProtoAdapter<Map<String, Team>> teams;
        private final ProtoAdapter<Map<String, Tenant>> tenants;
        private final ProtoAdapter<Map<String, Thread>> threads;
        private final ProtoAdapter<Map<String, TopicGroup>> topic_groups;
        private final ProtoAdapter<Map<String, TranslateInfo>> translate_messages;
        private final ProtoAdapter<Map<String, Urgent>> urgents;
        private final ProtoAdapter<Map<Long, UserGroupEntity>> user_groups;
        private final ProtoAdapter<Map<Long, VotedInfo>> voted_infos;

        public ProtoAdapter_Entity() {
            super(FieldEncoding.LENGTH_DELIMITED, Entity.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            ProtoAdapter<Message> r101 = Message.ADAPTER;
            this.messages = ProtoAdapter.newMapAdapter(r100, r101);
            this.chats = ProtoAdapter.newMapAdapter(r100, Chat.ADAPTER);
            this.chatters = ProtoAdapter.newMapAdapter(r100, Chatter.ADAPTER);
            this.quasi_messages = ProtoAdapter.newMapAdapter(r100, QuasiMessage.ADAPTER);
            this.departments = ProtoAdapter.newMapAdapter(r100, Department.ADAPTER);
            this.urgents = ProtoAdapter.newMapAdapter(r100, Urgent.ADAPTER);
            this.drafts = ProtoAdapter.newMapAdapter(r100, Draft.ADAPTER);
            this.feed_cards = ProtoAdapter.newMapAdapter(r100, FeedCard.ADAPTER);
            this.emails = ProtoAdapter.newMapAdapter(r100, Email.ADAPTER);
            this.docs = ProtoAdapter.newMapAdapter(r100, Doc.ADAPTER);
            this.doc_permissions = ProtoAdapter.newMapAdapter(r100, DocPermission.ADAPTER);
            this.doc_feeds = ProtoAdapter.newMapAdapter(r100, DocFeed.ADAPTER);
            this.doc_messages = ProtoAdapter.newMapAdapter(r100, DocMessage.ADAPTER);
            this.threads = ProtoAdapter.newMapAdapter(r100, Thread.ADAPTER);
            this.quasi_threads = ProtoAdapter.newMapAdapter(r100, QuasiThread.ADAPTER);
            this.favorites = ProtoAdapter.newMapAdapter(r100, FavoritesObject.ADAPTER);
            this.translate_messages = ProtoAdapter.newMapAdapter(r100, TranslateInfo.ADAPTER);
            this.tenants = ProtoAdapter.newMapAdapter(r100, Tenant.ADAPTER);
            this.chat_chatters = ProtoAdapter.newMapAdapter(r100, ChatChatter.ADAPTER);
            this.message_id2doc_permission_infos = ProtoAdapter.newMapAdapter(r100, DocPermissionInfo.ADAPTER);
            this.open_apps = ProtoAdapter.newMapAdapter(r100, OpenApp.ADAPTER);
            this.oncalls = ProtoAdapter.newMapAdapter(r100, Oncall.ADAPTER);
            this.topic_groups = ProtoAdapter.newMapAdapter(r100, TopicGroup.ADAPTER);
            this.abbrevs = ProtoAdapter.newMapAdapter(r100, AbbreviationEntity.ADAPTER);
            this.ephemeral_messages = ProtoAdapter.newMapAdapter(r100, r101);
            this.merge_forward_translate_messages = ProtoAdapter.newMapAdapter(r100, SubTranslateInfo.ADAPTER);
            this.mail_setting = ProtoAdapter.newMapAdapter(r100, ChatMailSetting.ADAPTER);
            this.mentions = ProtoAdapter.newMapAdapter(r100, HashTagMentionEntity.ADAPTER);
            this.preview_entities = ProtoAdapter.newMapAdapter(r100, PreviewEntityPair.ADAPTER);
            this.preview_templates = ProtoAdapter.newMapAdapter(r100, URLPreviewTemplate.ADAPTER);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            this.voted_infos = ProtoAdapter.newMapAdapter(r102, VotedInfo.ADAPTER);
            this.teams = ProtoAdapter.newMapAdapter(r100, Team.ADAPTER);
            this.editing_message_infos = ProtoAdapter.newMapAdapter(r102, EditingMessageInfo.ADAPTER);
            this.message_fold_details = ProtoAdapter.newMapAdapter(r102, MessageFoldDetail.ADAPTER);
            this.quasi_schedule_message = ProtoAdapter.newMapAdapter(r100, QuasiScheduleMessage.ADAPTER);
            this.schedule_message = ProtoAdapter.newMapAdapter(r100, ScheduleMessage.ADAPTER);
            this.chat_themes = ProtoAdapter.newMapAdapter(r102, ProtoAdapter.BYTES);
            this.message_local_data = ProtoAdapter.newMapAdapter(r102, MessageLocalDataInfoMap.ADAPTER);
            this.message_links = ProtoAdapter.newMapAdapter(r100, MessageLink.ADAPTER);
            this.chatter_id_to_sensitive_info = ProtoAdapter.newMapAdapter(r102, ChatterSensitiveInfo.ADAPTER);
            this.app_info_items = ProtoAdapter.newMapAdapter(r102, AppInfoItem.ADAPTER);
            this.user_groups = ProtoAdapter.newMapAdapter(r102, UserGroupEntity.ADAPTER);
            this.analysis_configs = ProtoAdapter.newMapAdapter(r100, MessageAnalysisConfig.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Entity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L51;
            switch(r103) {
                case 1: goto L50;
                case 2: goto L49;
                case 3: goto L48;
                case 4: goto L47;
                case 5: goto L46;
                case 6: goto L45;
                case 7: goto L44;
                case 8: goto L43;
                case 9: goto L42;
                case 10: goto L41;
                case 11: goto L40;
                case 12: goto L39;
                case 13: goto L38;
                case 14: goto L37;
                case 15: goto L36;
                case 16: goto L35;
                case 17: goto L34;
                case 18: goto L33;
                case 19: goto L32;
                case 20: goto L31;
                case 21: goto L30;
                case 22: goto L29;
                case 23: goto L28;
                case 24: goto L27;
                case 25: goto L26;
                case 26: goto L25;
                case 27: goto L24;
                case 28: goto L23;
                case 29: goto L22;
                case 30: goto L21;
                case 31: goto L20;
                case 32: goto L19;
                case 33: goto L18;
                case 34: goto L17;
                case 35: goto L16;
                case 36: goto L15;
                case 37: goto L14;
                case 38: goto L13;
                case 39: goto L12;
                case 40: goto L11;
                case 41: goto L10;
                case 42: goto L9;
                case 43: goto L8;
                case 44: goto L7;
                default: goto L6;
            };
        L7:
            r101.analysis_configs.putAll(this.analysis_configs.decode(r100));
            goto L3
        L8:
            r101.user_groups.putAll(this.user_groups.decode(r100));
            goto L3
        L9:
            r101.app_info_items.putAll(this.app_info_items.decode(r100));
            goto L3
        L10:
            r101.chatter_id_to_sensitive_info.putAll(this.chatter_id_to_sensitive_info.decode(r100));
            goto L3
        L11:
            r101.message_links.putAll(this.message_links.decode(r100));
            goto L3
        L12:
            r101.pack_stack_infos.add(PackStackInfo.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.message_local_data.putAll(this.message_local_data.decode(r100));
            goto L3
        L14:
            r101.chat_themes.putAll(this.chat_themes.decode(r100));
            goto L3
        L15:
            r101.schedule_message.putAll(this.schedule_message.decode(r100));
            goto L3
        L16:
            r101.quasi_schedule_message.putAll(this.quasi_schedule_message.decode(r100));
            goto L3
        L17:
            r101.message_fold_details.putAll(this.message_fold_details.decode(r100));
            goto L3
        L18:
            r101.editing_message_infos.putAll(this.editing_message_infos.decode(r100));
            goto L3
        L19:
            r101.teams.putAll(this.teams.decode(r100));
            goto L3
        L20:
            r101.voted_infos.putAll(this.voted_infos.decode(r100));
            goto L3
        L21:
            r101.preview_templates.putAll(this.preview_templates.decode(r100));
            goto L3
        L22:
            r101.preview_entities.putAll(this.preview_entities.decode(r100));
            goto L3
        L23:
            r101.mentions.putAll(this.mentions.decode(r100));
            goto L3
        L24:
            r101.mail_setting.putAll(this.mail_setting.decode(r100));
            goto L3
        L25:
            r101.merge_forward_translate_messages.putAll(this.merge_forward_translate_messages.decode(r100));
            goto L3
        L26:
            r101.ephemeral_messages.putAll(this.ephemeral_messages.decode(r100));
            goto L3
        L27:
            r101.abbrevs.putAll(this.abbrevs.decode(r100));
            goto L3
        L28:
            r101.topic_groups.putAll(this.topic_groups.decode(r100));
            goto L3
        L29:
            r101.oncalls.putAll(this.oncalls.decode(r100));
            goto L3
        L30:
            r101.open_apps.putAll(this.open_apps.decode(r100));
            goto L3
        L31:
            r101.message_id2doc_permission_infos.putAll(this.message_id2doc_permission_infos.decode(r100));
            goto L3
        L32:
            r101.chat_chatters.putAll(this.chat_chatters.decode(r100));
            goto L3
        L33:
            r101.tenants.putAll(this.tenants.decode(r100));
            goto L3
        L34:
            r101.translate_messages.putAll(this.translate_messages.decode(r100));
            goto L3
        L35:
            r101.favorites.putAll(this.favorites.decode(r100));
            goto L3
        L36:
            r101.quasi_threads.putAll(this.quasi_threads.decode(r100));
            goto L3
        L37:
            r101.threads.putAll(this.threads.decode(r100));
            goto L3
        L38:
            r101.doc_messages.putAll(this.doc_messages.decode(r100));
            goto L3
        L39:
            r101.doc_feeds.putAll(this.doc_feeds.decode(r100));
            goto L3
        L40:
            r101.doc_permissions.putAll(this.doc_permissions.decode(r100));
            goto L3
        L41:
            r101.docs.putAll(this.docs.decode(r100));
            goto L3
        L42:
            r101.emails.putAll(this.emails.decode(r100));
            goto L3
        L43:
            r101.feed_cards.putAll(this.feed_cards.decode(r100));
            goto L3
        L44:
            r101.drafts.putAll(this.drafts.decode(r100));
            goto L3
        L45:
            r101.urgents.putAll(this.urgents.decode(r100));
            goto L3
        L46:
            r101.departments.putAll(this.departments.decode(r100));
            goto L3
        L47:
            r101.quasi_messages.putAll(this.quasi_messages.decode(r100));
            goto L3
        L48:
            r101.chatters.putAll(this.chatters.decode(r100));
            goto L3
        L49:
            r101.chats.putAll(this.chats.decode(r100));
            goto L3
        L50:
            r101.messages.putAll(this.messages.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L51:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Entity r100) {
            return (((((((((((((((((((((((((((((((((((((((((((this.messages.encodedSizeWithTag(1, r100.messages) + this.chats.encodedSizeWithTag(2, r100.chats)) + this.chatters.encodedSizeWithTag(3, r100.chatters)) + this.quasi_messages.encodedSizeWithTag(4, r100.quasi_messages)) + this.departments.encodedSizeWithTag(5, r100.departments)) + this.urgents.encodedSizeWithTag(6, r100.urgents)) + this.drafts.encodedSizeWithTag(7, r100.drafts)) + this.feed_cards.encodedSizeWithTag(8, r100.feed_cards)) + this.emails.encodedSizeWithTag(9, r100.emails)) + this.docs.encodedSizeWithTag(10, r100.docs)) + this.doc_permissions.encodedSizeWithTag(11, r100.doc_permissions)) + this.doc_feeds.encodedSizeWithTag(12, r100.doc_feeds)) + this.doc_messages.encodedSizeWithTag(13, r100.doc_messages)) + this.threads.encodedSizeWithTag(14, r100.threads)) + this.quasi_threads.encodedSizeWithTag(15, r100.quasi_threads)) + this.favorites.encodedSizeWithTag(16, r100.favorites)) + this.translate_messages.encodedSizeWithTag(17, r100.translate_messages)) + this.tenants.encodedSizeWithTag(18, r100.tenants)) + this.chat_chatters.encodedSizeWithTag(19, r100.chat_chatters)) + this.message_id2doc_permission_infos.encodedSizeWithTag(20, r100.message_id2doc_permission_infos)) + this.open_apps.encodedSizeWithTag(21, r100.open_apps)) + this.oncalls.encodedSizeWithTag(22, r100.oncalls)) + this.topic_groups.encodedSizeWithTag(23, r100.topic_groups)) + this.abbrevs.encodedSizeWithTag(24, r100.abbrevs)) + this.ephemeral_messages.encodedSizeWithTag(25, r100.ephemeral_messages)) + this.merge_forward_translate_messages.encodedSizeWithTag(26, r100.merge_forward_translate_messages)) + this.mail_setting.encodedSizeWithTag(27, r100.mail_setting)) + this.mentions.encodedSizeWithTag(28, r100.mentions)) + this.preview_entities.encodedSizeWithTag(29, r100.preview_entities)) + this.preview_templates.encodedSizeWithTag(30, r100.preview_templates)) + this.voted_infos.encodedSizeWithTag(31, r100.voted_infos)) + this.teams.encodedSizeWithTag(32, r100.teams)) + this.editing_message_infos.encodedSizeWithTag(33, r100.editing_message_infos)) + this.message_fold_details.encodedSizeWithTag(34, r100.message_fold_details)) + this.quasi_schedule_message.encodedSizeWithTag(35, r100.quasi_schedule_message)) + this.schedule_message.encodedSizeWithTag(36, r100.schedule_message)) + this.chat_themes.encodedSizeWithTag(37, r100.chat_themes)) + this.message_local_data.encodedSizeWithTag(38, r100.message_local_data)) + PackStackInfo.ADAPTER.asRepeated().encodedSizeWithTag(39, r100.pack_stack_infos)) + this.message_links.encodedSizeWithTag(40, r100.message_links)) + this.chatter_id_to_sensitive_info.encodedSizeWithTag(41, r100.chatter_id_to_sensitive_info)) + this.app_info_items.encodedSizeWithTag(42, r100.app_info_items)) + this.user_groups.encodedSizeWithTag(43, r100.user_groups)) + this.analysis_configs.encodedSizeWithTag(44, r100.analysis_configs)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Entity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Entity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Entity r101) throws IOException {
            this.messages.encodeWithTag(r100, 1, r101.messages);
            this.chats.encodeWithTag(r100, 2, r101.chats);
            this.chatters.encodeWithTag(r100, 3, r101.chatters);
            this.quasi_messages.encodeWithTag(r100, 4, r101.quasi_messages);
            this.departments.encodeWithTag(r100, 5, r101.departments);
            this.urgents.encodeWithTag(r100, 6, r101.urgents);
            this.drafts.encodeWithTag(r100, 7, r101.drafts);
            this.feed_cards.encodeWithTag(r100, 8, r101.feed_cards);
            this.emails.encodeWithTag(r100, 9, r101.emails);
            this.docs.encodeWithTag(r100, 10, r101.docs);
            this.doc_permissions.encodeWithTag(r100, 11, r101.doc_permissions);
            this.doc_feeds.encodeWithTag(r100, 12, r101.doc_feeds);
            this.doc_messages.encodeWithTag(r100, 13, r101.doc_messages);
            this.threads.encodeWithTag(r100, 14, r101.threads);
            this.quasi_threads.encodeWithTag(r100, 15, r101.quasi_threads);
            this.favorites.encodeWithTag(r100, 16, r101.favorites);
            this.translate_messages.encodeWithTag(r100, 17, r101.translate_messages);
            this.tenants.encodeWithTag(r100, 18, r101.tenants);
            this.chat_chatters.encodeWithTag(r100, 19, r101.chat_chatters);
            this.message_id2doc_permission_infos.encodeWithTag(r100, 20, r101.message_id2doc_permission_infos);
            this.open_apps.encodeWithTag(r100, 21, r101.open_apps);
            this.oncalls.encodeWithTag(r100, 22, r101.oncalls);
            this.topic_groups.encodeWithTag(r100, 23, r101.topic_groups);
            this.abbrevs.encodeWithTag(r100, 24, r101.abbrevs);
            this.ephemeral_messages.encodeWithTag(r100, 25, r101.ephemeral_messages);
            this.merge_forward_translate_messages.encodeWithTag(r100, 26, r101.merge_forward_translate_messages);
            this.mail_setting.encodeWithTag(r100, 27, r101.mail_setting);
            this.mentions.encodeWithTag(r100, 28, r101.mentions);
            this.preview_entities.encodeWithTag(r100, 29, r101.preview_entities);
            this.preview_templates.encodeWithTag(r100, 30, r101.preview_templates);
            this.voted_infos.encodeWithTag(r100, 31, r101.voted_infos);
            this.teams.encodeWithTag(r100, 32, r101.teams);
            this.editing_message_infos.encodeWithTag(r100, 33, r101.editing_message_infos);
            this.message_fold_details.encodeWithTag(r100, 34, r101.message_fold_details);
            this.quasi_schedule_message.encodeWithTag(r100, 35, r101.quasi_schedule_message);
            this.schedule_message.encodeWithTag(r100, 36, r101.schedule_message);
            this.chat_themes.encodeWithTag(r100, 37, r101.chat_themes);
            this.message_local_data.encodeWithTag(r100, 38, r101.message_local_data);
            PackStackInfo.ADAPTER.asRepeated().encodeWithTag(r100, 39, r101.pack_stack_infos);
            this.message_links.encodeWithTag(r100, 40, r101.message_links);
            this.chatter_id_to_sensitive_info.encodeWithTag(r100, 41, r101.chatter_id_to_sensitive_info);
            this.app_info_items.encodeWithTag(r100, 42, r101.app_info_items);
            this.user_groups.encodeWithTag(r100, 43, r101.user_groups);
            this.analysis_configs.encodeWithTag(r100, 44, r101.analysis_configs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Entity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_Entity r100 = new ProtoAdapter_Entity();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.messages = Internal.copyOf("messages", this.messages);
        r100.chats = Internal.copyOf("chats", this.chats);
        r100.chatters = Internal.copyOf("chatters", this.chatters);
        r100.quasi_messages = Internal.copyOf("quasi_messages", this.quasi_messages);
        r100.departments = Internal.copyOf(InvRouter.DEPARTMENTS, this.departments);
        r100.urgents = Internal.copyOf("urgents", this.urgents);
        r100.drafts = Internal.copyOf("drafts", this.drafts);
        r100.feed_cards = Internal.copyOf("feed_cards", this.feed_cards);
        r100.emails = Internal.copyOf("emails", this.emails);
        r100.docs = Internal.copyOf("docs", this.docs);
        r100.doc_permissions = Internal.copyOf("doc_permissions", this.doc_permissions);
        r100.doc_feeds = Internal.copyOf("doc_feeds", this.doc_feeds);
        r100.doc_messages = Internal.copyOf("doc_messages", this.doc_messages);
        r100.threads = Internal.copyOf("threads", this.threads);
        r100.quasi_threads = Internal.copyOf("quasi_threads", this.quasi_threads);
        r100.favorites = Internal.copyOf("favorites", this.favorites);
        r100.translate_messages = Internal.copyOf("translate_messages", this.translate_messages);
        r100.tenants = Internal.copyOf("tenants", this.tenants);
        r100.chat_chatters = Internal.copyOf("chat_chatters", this.chat_chatters);
        r100.message_id2doc_permission_infos = Internal.copyOf("message_id2doc_permission_infos", this.message_id2doc_permission_infos);
        r100.open_apps = Internal.copyOf("open_apps", this.open_apps);
        r100.oncalls = Internal.copyOf("oncalls", this.oncalls);
        r100.topic_groups = Internal.copyOf("topic_groups", this.topic_groups);
        r100.abbrevs = Internal.copyOf("abbrevs", this.abbrevs);
        r100.ephemeral_messages = Internal.copyOf("ephemeral_messages", this.ephemeral_messages);
        r100.merge_forward_translate_messages = Internal.copyOf("merge_forward_translate_messages", this.merge_forward_translate_messages);
        r100.mail_setting = Internal.copyOf("mail_setting", this.mail_setting);
        r100.mentions = Internal.copyOf("mentions", this.mentions);
        r100.preview_entities = Internal.copyOf("preview_entities", this.preview_entities);
        r100.preview_templates = Internal.copyOf("preview_templates", this.preview_templates);
        r100.voted_infos = Internal.copyOf("voted_infos", this.voted_infos);
        r100.teams = Internal.copyOf("teams", this.teams);
        r100.editing_message_infos = Internal.copyOf("editing_message_infos", this.editing_message_infos);
        r100.message_fold_details = Internal.copyOf("message_fold_details", this.message_fold_details);
        r100.quasi_schedule_message = Internal.copyOf("quasi_schedule_message", this.quasi_schedule_message);
        r100.schedule_message = Internal.copyOf("schedule_message", this.schedule_message);
        r100.chat_themes = Internal.copyOf("chat_themes", this.chat_themes);
        r100.message_local_data = Internal.copyOf("message_local_data", this.message_local_data);
        r100.pack_stack_infos = Internal.copyOf("pack_stack_infos", this.pack_stack_infos);
        r100.message_links = Internal.copyOf("message_links", this.message_links);
        r100.chatter_id_to_sensitive_info = Internal.copyOf("chatter_id_to_sensitive_info", this.chatter_id_to_sensitive_info);
        r100.app_info_items = Internal.copyOf("app_info_items", this.app_info_items);
        r100.user_groups = Internal.copyOf("user_groups", this.user_groups);
        r100.analysis_configs = Internal.copyOf("analysis_configs", this.analysis_configs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Entity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Entity(Map<String, Message> r410, Map<String, Chat> r411, Map<String, Chatter> r412, Map<String, QuasiMessage> r510, Map<String, Department> r511, Map<String, Urgent> r512, Map<String, Draft> r513, Map<String, FeedCard> r514, Map<String, Email> r515, Map<String, Doc> r516, Map<String, DocPermission> r517, Map<String, DocFeed> r518, Map<String, DocMessage> r519, Map<String, Thread> r610, Map<String, QuasiThread> r611, Map<String, FavoritesObject> r612, Map<String, TranslateInfo> r613, Map<String, Tenant> r614, Map<String, ChatChatter> r615, Map<String, DocPermissionInfo> r616, Map<String, OpenApp> r617, Map<String, Oncall> r618, Map<String, TopicGroup> r619, Map<String, AbbreviationEntity> r710, Map<String, Message> r711, Map<String, SubTranslateInfo> r712, Map<String, ChatMailSetting> r713, Map<String, HashTagMentionEntity> r714, Map<String, PreviewEntityPair> r715, Map<String, URLPreviewTemplate> r716, Map<Long, VotedInfo> r717, Map<String, Team> r718, Map<Long, EditingMessageInfo> r719, Map<Long, MessageFoldDetail> r810, Map<String, QuasiScheduleMessage> r811, Map<String, ScheduleMessage> r812, Map<Long, ByteString> r813, Map<Long, MessageLocalDataInfoMap> r814, List<PackStackInfo> r815, Map<String, MessageLink> r816, Map<Long, ChatterSensitiveInfo> r817, Map<Long, AppInfoItem> r818, Map<Long, UserGroupEntity> r819, Map<String, MessageAnalysisConfig> r910) {
        this(r410, r411, r412, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, ByteString.EMPTY);
    }

    public Entity(Map<String, Message> r100, Map<String, Chat> r101, Map<String, Chatter> r102, Map<String, QuasiMessage> r103, Map<String, Department> r104, Map<String, Urgent> r105, Map<String, Draft> r110, Map<String, FeedCard> r111, Map<String, Email> r112, Map<String, Doc> r113, Map<String, DocPermission> r114, Map<String, DocFeed> r115, Map<String, DocMessage> r116, Map<String, Thread> r117, Map<String, QuasiThread> r118, Map<String, FavoritesObject> r119, Map<String, TranslateInfo> r210, Map<String, Tenant> r211, Map<String, ChatChatter> r212, Map<String, DocPermissionInfo> r213, Map<String, OpenApp> r214, Map<String, Oncall> r215, Map<String, TopicGroup> r216, Map<String, AbbreviationEntity> r217, Map<String, Message> r218, Map<String, SubTranslateInfo> r219, Map<String, ChatMailSetting> r310, Map<String, HashTagMentionEntity> r311, Map<String, PreviewEntityPair> r312, Map<String, URLPreviewTemplate> r313, Map<Long, VotedInfo> r314, Map<String, Team> r315, Map<Long, EditingMessageInfo> r316, Map<Long, MessageFoldDetail> r317, Map<String, QuasiScheduleMessage> r318, Map<String, ScheduleMessage> r319, Map<Long, ByteString> r410, Map<Long, MessageLocalDataInfoMap> r411, List<PackStackInfo> r412, Map<String, MessageLink> r413, Map<Long, ChatterSensitiveInfo> r414, Map<Long, AppInfoItem> r415, Map<Long, UserGroupEntity> r416, Map<String, MessageAnalysisConfig> r417, ByteString r418) {
        super(ADAPTER, r418);
        this.messages = Internal.immutableCopyOf("messages", r100);
        this.chats = Internal.immutableCopyOf("chats", r101);
        this.chatters = Internal.immutableCopyOf("chatters", r102);
        this.quasi_messages = Internal.immutableCopyOf("quasi_messages", r103);
        this.departments = Internal.immutableCopyOf(InvRouter.DEPARTMENTS, r104);
        this.urgents = Internal.immutableCopyOf("urgents", r105);
        this.drafts = Internal.immutableCopyOf("drafts", r110);
        this.feed_cards = Internal.immutableCopyOf("feed_cards", r111);
        this.emails = Internal.immutableCopyOf("emails", r112);
        this.docs = Internal.immutableCopyOf("docs", r113);
        this.doc_permissions = Internal.immutableCopyOf("doc_permissions", r114);
        this.doc_feeds = Internal.immutableCopyOf("doc_feeds", r115);
        this.doc_messages = Internal.immutableCopyOf("doc_messages", r116);
        this.threads = Internal.immutableCopyOf("threads", r117);
        this.quasi_threads = Internal.immutableCopyOf("quasi_threads", r118);
        this.favorites = Internal.immutableCopyOf("favorites", r119);
        this.translate_messages = Internal.immutableCopyOf("translate_messages", r210);
        this.tenants = Internal.immutableCopyOf("tenants", r211);
        this.chat_chatters = Internal.immutableCopyOf("chat_chatters", r212);
        this.message_id2doc_permission_infos = Internal.immutableCopyOf("message_id2doc_permission_infos", r213);
        this.open_apps = Internal.immutableCopyOf("open_apps", r214);
        this.oncalls = Internal.immutableCopyOf("oncalls", r215);
        this.topic_groups = Internal.immutableCopyOf("topic_groups", r216);
        this.abbrevs = Internal.immutableCopyOf("abbrevs", r217);
        this.ephemeral_messages = Internal.immutableCopyOf("ephemeral_messages", r218);
        this.merge_forward_translate_messages = Internal.immutableCopyOf("merge_forward_translate_messages", r219);
        this.mail_setting = Internal.immutableCopyOf("mail_setting", r310);
        this.mentions = Internal.immutableCopyOf("mentions", r311);
        this.preview_entities = Internal.immutableCopyOf("preview_entities", r312);
        this.preview_templates = Internal.immutableCopyOf("preview_templates", r313);
        this.voted_infos = Internal.immutableCopyOf("voted_infos", r314);
        this.teams = Internal.immutableCopyOf("teams", r315);
        this.editing_message_infos = Internal.immutableCopyOf("editing_message_infos", r316);
        this.message_fold_details = Internal.immutableCopyOf("message_fold_details", r317);
        this.quasi_schedule_message = Internal.immutableCopyOf("quasi_schedule_message", r318);
        this.schedule_message = Internal.immutableCopyOf("schedule_message", r319);
        this.chat_themes = Internal.immutableCopyOf("chat_themes", r410);
        this.message_local_data = Internal.immutableCopyOf("message_local_data", r411);
        this.pack_stack_infos = Internal.immutableCopyOf("pack_stack_infos", r412);
        this.message_links = Internal.immutableCopyOf("message_links", r413);
        this.chatter_id_to_sensitive_info = Internal.immutableCopyOf("chatter_id_to_sensitive_info", r414);
        this.app_info_items = Internal.immutableCopyOf("app_info_items", r415);
        this.user_groups = Internal.immutableCopyOf("user_groups", r416);
        this.analysis_configs = Internal.immutableCopyOf("analysis_configs", r417);
    }
}
