package com.bytedance.lark.pb.feed.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.CardContent;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.ChatTeamInfo;
import com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.Icon;
import com.bytedance.lark.pb.basic.v1.Item;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.bytedance.lark.pb.basic.v1.Team;
import com.bytedance.lark.pb.basic.v1.TeamChatType;
import com.bytedance.lark.pb.basic.v1.Urgent;
import com.bytedance.lark.pb.basic.v1.VideoChatContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatData extends Message<ChatData, Builder> {
    public static final ProtoAdapter<ChatData> ADAPTER = null;
    public static final Integer DEFAULT_AT_INFOS_COUNT = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Integer DEFAULT_CAN_SET_STRANGER = null;
    public static final CardContent.Type DEFAULT_CARD_TYPE = null;
    public static final Integer DEFAULT_CHATTER_APPLY_COUNT = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final Chatter.Type DEFAULT_CHATTER_TYPE = null;
    public static final String DEFAULT_CHAT_DESCRIPTION = "";
    public static final Chat.ChatDisplayModeSetting.Enum DEFAULT_CHAT_DISPLAY_MODE_SETTING = null;
    public static final Chat.ChatMode DEFAULT_CHAT_MODE = null;
    public static final Boolean DEFAULT_CHAT_MUTEABLE = null;
    public static final Integer DEFAULT_CHAT_READABLE = null;
    public static final Chat.Role DEFAULT_CHAT_ROLE = null;
    public static final Chat.Type DEFAULT_CHAT_TYPE = null;
    public static final Boolean DEFAULT_CROSS_TENANT = null;
    public static final Boolean DEFAULT_DIGEST_IS_QUERY = null;
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final EntityStatus DEFAULT_ENTITY_STATUS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final Boolean DEFAULT_IS_BLOCKED = null;
    public static final Boolean DEFAULT_IS_CHAT_ADMIN = null;
    public static final Boolean DEFAULT_IS_CHAT_OWNER = null;
    public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_EDU = null;
    public static final Boolean DEFAULT_IS_FROZEN = null;
    public static final Boolean DEFAULT_IS_MEETING = null;
    public static final Boolean DEFAULT_IS_MEMBER = null;
    public static final Boolean DEFAULT_IS_MY_THREADS_UPDATED = null;
    public static final Boolean DEFAULT_IS_OFFICIAL_ONCALL = null;
    public static final Boolean DEFAULT_IS_OFFLINE_ONCALL = null;
    public static final Boolean DEFAULT_IS_P2P_AI = null;
    public static final Boolean DEFAULT_IS_P2P_OFFICIAL_BOT_AI = null;
    public static final Boolean DEFAULT_IS_PRIVATE_MODE = null;
    public static final Boolean DEFAULT_IS_PUBLIC_V2 = null;
    public static final Boolean DEFAULT_IS_RED_BADGE = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final Boolean DEFAULT_IS_STRANGER = null;
    public static final Boolean DEFAULT_IS_SUPER = null;
    public static final Boolean DEFAULT_IS_SUPPORT_VIEW = null;
    public static final Boolean DEFAULT_IS_USER_COUNT_VISIBLE = null;
    public static final Boolean DEFAULT_IS_VOICE_CALL = null;
    public static final Long DEFAULT_LAST_AT_RANK_TIME = null;
    public static final Boolean DEFAULT_LAST_HAS_AI_REPLY = null;
    public static final Long DEFAULT_LAST_MESSAGE_FOLD_ID = null;
    public static final Boolean DEFAULT_LAST_MESSAGE_IS_FOLD = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final String DEFAULT_LAST_MESSAGE_SEND_USER_AVATAR_KEY = "";
    public static final Long DEFAULT_LAST_MESSAGE_SEND_USER_ID = null;
    public static final String DEFAULT_LAST_MESSAGE_SEND_USER_NAME = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.Type DEFAULT_LAST_MESSAGE_TYPE = null;
    public static final String DEFAULT_LAST_VISIBLE_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_LATEST_READ_TIMESTAMP = null;
    public static final String DEFAULT_LOCALIZED_DIGEST_MESSAGE = "";
    public static final String DEFAULT_MINI_AVATAR_KEY = "";
    public static final Boolean DEFAULT_MUTED_BOT_P2P = null;
    public static final String DEFAULT_NAME = "";
    public static final ChatUserAutoMuteSetting.NoticeType DEFAULT_NOTICE_TYPE = null;
    public static final NotMemberType DEFAULT_NOT_MEMBER_TYPE = null;
    public static final String DEFAULT_ONCALL_ID = "";
    public static final String DEFAULT_ORIGINAL_DIGEST_MESSAGE = "";
    public static final Long DEFAULT_QUERY_ID = null;
    public static final AIKnowledgeQueryStatus DEFAULT_QUERY_STATUS = null;
    public static final Long DEFAULT_RANK_TIME = null;
    public static final Integer DEFAULT_READ_POSITION = null;
    public static final Content.SystemType DEFAULT_SYSTEM_MESSAGE_TYPE = null;
    public static final TeamChatType DEFAULT_TEAM_CHAT_TYPE = null;
    public static final Long DEFAULT_TEAM_ID = null;
    public static final String DEFAULT_TEAM_NAME = "";
    public static final Boolean DEFAULT_TENANT_CHAT = null;
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    public static final Integer DEFAULT_USER_COUNT = null;
    public static final String DEFAULT_VIDEO_CHAT_MEETING_CARD_MEETING_ID = "";
    public static final VideoChatContent.Type DEFAULT_VIDEO_CHAT_TYPE = null;
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final AtInfo at_info;
    public final List<AtInfo> at_infos;
    public final Integer at_infos_count;
    public final String avatar_key;
    public final AvatarMedal avatar_medal;
    public final String avatar_path;
    public final List<String> avatar_urls;
    public final Integer bot_ext_type;
    public final List<ChatTeamInfo> bound_team_infos;
    public final Integer can_set_stranger;
    public final CardContent.Type card_type;
    public final String chat_description;
    public final Chat.ChatDisplayModeSetting.Enum chat_display_mode_setting;
    public final Chat.ChatMode chat_mode;
    public final Boolean chat_muteable;
    public final Integer chat_readable;
    public final Chat.Role chat_role;
    public final Chat.Type chat_type;
    public final Integer chatter_apply_count;
    public final String chatter_id;
    public final List<Chatter.ChatterCustomStatus> chatter_status;
    public final Chatter.Type chatter_type;
    public final Boolean cross_tenant;
    public final Digest digest;
    public final Boolean digest_is_query;
    public final HighPriorityDisplay display;
    public final Long display_time;
    public final Long do_not_disturb_end_time;
    public final DraftPreview draft_preview;
    public final EntityStatus entity_status;
    public final FocusInfo focus_info;
    public final Icon icon;
    public final Boolean is_agent;
    public final Boolean is_blocked;
    public final Boolean is_chat_admin;
    public final Boolean is_chat_owner;
    public final Boolean is_cross_with_ka;
    public final Boolean is_crypto;
    public final Boolean is_department;
    public final Boolean is_edu;
    public final Boolean is_frozen;
    public final Boolean is_meeting;
    public final Boolean is_member;
    public final Boolean is_my_threads_updated;
    public final Boolean is_official_oncall;
    public final Boolean is_offline_oncall;
    public final Boolean is_p2p_ai;
    public final Boolean is_p2p_official_bot_ai;
    public final Boolean is_private_mode;
    public final Boolean is_public_v2;
    public final Boolean is_red_badge;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final Boolean is_special_focus;
    public final Boolean is_stranger;
    public final Boolean is_super;
    public final Boolean is_support_view;
    public final Boolean is_user_count_visible;
    public final Boolean is_voice_call;
    public final Item item;
    public final List<Item> items;
    public final List<ChatTeamInfo> joined_team_infos;
    public final Map<Long, Team> joined_teams;
    public final Digest last_at_digest;
    public final Long last_at_rank_time;
    public final Boolean last_has_ai_reply;
    public final Long last_message_fold_id;
    public final Boolean last_message_is_fold;
    public final Integer last_message_position;
    public final String last_message_send_user_avatar_key;
    public final Long last_message_send_user_id;
    public final String last_message_send_user_name;
    public final com.bytedance.lark.pb.basic.v1.Message.Type last_message_type;
    public final String last_visible_message_id;
    public final Integer last_visible_message_position;
    public final Integer latest_read_timestamp;
    public final String localized_digest_message;
    public final String mini_avatar_key;
    public final Boolean muted_bot_p2p;
    public final String name;
    public final NotMemberType not_member_type;
    public final ChatUserAutoMuteSetting.NoticeType notice_type;
    public final String oncall_id;
    public final String original_digest_message;
    public final Long query_id;
    public final AIKnowledgeQueryStatus query_status;
    public final Long rank_time;
    public final List<com.bytedance.lark.pb.basic.v1.Message.Reaction> reactions;
    public final Integer read_position;
    public final Content.SystemType system_message_type;
    public final TagData tag_info;
    public final List<Tag> tags;
    public final TeamChatType team_chat_type;
    public final Long team_id;
    public final String team_name;
    public final Boolean tenant_chat;
    public final Integer unread_count;
    public final UrgentInfo urgent_info;
    public final List<Urgent> urgents;
    public final Integer user_count;
    public final String video_chat_meeting_card_meeting_id;
    public final VideoChatContent.Type video_chat_type;
    public final String with_bot_tag;

    public static final class Builder extends Message.Builder<ChatData, Builder> {
        public AtInfo at_info;
        public List<AtInfo> at_infos;
        public Integer at_infos_count;
        public String avatar_key;
        public AvatarMedal avatar_medal;
        public String avatar_path;
        public List<String> avatar_urls;
        public Integer bot_ext_type;
        public List<ChatTeamInfo> bound_team_infos;
        public Integer can_set_stranger;
        public CardContent.Type card_type;
        public String chat_description;
        public Chat.ChatDisplayModeSetting.Enum chat_display_mode_setting;
        public Chat.ChatMode chat_mode;
        public Boolean chat_muteable;
        public Integer chat_readable;
        public Chat.Role chat_role;
        public Chat.Type chat_type;
        public Integer chatter_apply_count;
        public String chatter_id;
        public List<Chatter.ChatterCustomStatus> chatter_status;
        public Chatter.Type chatter_type;
        public Boolean cross_tenant;
        public Digest digest;
        public Boolean digest_is_query;
        public HighPriorityDisplay display;
        public Long display_time;
        public Long do_not_disturb_end_time;
        public DraftPreview draft_preview;
        public EntityStatus entity_status;
        public FocusInfo focus_info;
        public Icon icon;
        public Boolean is_agent;
        public Boolean is_blocked;
        public Boolean is_chat_admin;
        public Boolean is_chat_owner;
        public Boolean is_cross_with_ka;
        public Boolean is_crypto;
        public Boolean is_department;
        public Boolean is_edu;
        public Boolean is_frozen;
        public Boolean is_meeting;
        public Boolean is_member;
        public Boolean is_my_threads_updated;
        public Boolean is_official_oncall;
        public Boolean is_offline_oncall;
        public Boolean is_p2p_ai;
        public Boolean is_p2p_official_bot_ai;
        public Boolean is_private_mode;
        public Boolean is_public_v2;
        public Boolean is_red_badge;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public Boolean is_special_focus;
        public Boolean is_stranger;
        public Boolean is_super;
        public Boolean is_support_view;
        public Boolean is_user_count_visible;
        public Boolean is_voice_call;
        public Item item;
        public List<Item> items;
        public List<ChatTeamInfo> joined_team_infos;
        public Map<Long, Team> joined_teams;
        public Digest last_at_digest;
        public Long last_at_rank_time;
        public Boolean last_has_ai_reply;
        public Long last_message_fold_id;
        public Boolean last_message_is_fold;
        public Integer last_message_position;
        public String last_message_send_user_avatar_key;
        public Long last_message_send_user_id;
        public String last_message_send_user_name;
        public com.bytedance.lark.pb.basic.v1.Message.Type last_message_type;
        public String last_visible_message_id;
        public Integer last_visible_message_position;
        public Integer latest_read_timestamp;
        public String localized_digest_message;
        public String mini_avatar_key;
        public Boolean muted_bot_p2p;
        public String name;
        public NotMemberType not_member_type;
        public ChatUserAutoMuteSetting.NoticeType notice_type;
        public String oncall_id;
        public String original_digest_message;
        public Long query_id;
        public AIKnowledgeQueryStatus query_status;
        public Long rank_time;
        public List<com.bytedance.lark.pb.basic.v1.Message.Reaction> reactions;
        public Integer read_position;
        public Content.SystemType system_message_type;
        public TagData tag_info;
        public List<Tag> tags;
        public TeamChatType team_chat_type;
        public Long team_id;
        public String team_name;
        public Boolean tenant_chat;
        public Integer unread_count;
        public UrgentInfo urgent_info;
        public List<Urgent> urgents;
        public Integer user_count;
        public String video_chat_meeting_card_meeting_id;
        public VideoChatContent.Type video_chat_type;
        public String with_bot_tag;

        @Override // com.squareup.wire.Message.Builder
        public ChatData build() {
            String r100 = this.name;
            if (r100 == null) goto L9;
            if (this.is_remind == null) goto L9;
            return new ChatData(this.name, this.avatar_key, this.avatar_path, this.avatar_urls, this.unread_count, this.is_remind, this.is_shortcut, this.draft_preview, this.at_info, this.at_infos, this.localized_digest_message, this.entity_status, this.display_time, this.rank_time, this.cross_tenant, this.reactions, this.do_not_disturb_end_time, this.mini_avatar_key, this.original_digest_message, this.chat_type, this.chatter_type, this.chatter_id, this.is_crypto, this.chat_mode, this.is_meeting, this.urgents, this.with_bot_tag, this.last_message_position, this.is_department, this.tenant_chat, this.chat_description, this.is_support_view, this.oncall_id, this.last_message_type, this.system_message_type, this.card_type, this.is_public_v2, this.is_member, this.last_visible_message_id, this.chat_muteable, this.chat_role, this.icon, this.is_edu, this.is_cross_with_ka, this.user_count, this.urgent_info, this.at_infos_count, this.chatter_status, this.focus_info, this.display, this.avatar_medal, this.chat_display_mode_setting, this.last_visible_message_position, this.is_frozen, this.is_p2p_ai, this.is_p2p_official_bot_ai, this.chatter_apply_count, this.last_has_ai_reply, this.notice_type, this.query_status, this.query_id, this.digest_is_query, this.is_red_badge, this.is_official_oncall, this.is_offline_oncall, this.chat_readable, this.is_stranger, this.is_blocked, this.can_set_stranger, this.bot_ext_type, this.is_agent, this.video_chat_type, this.is_voice_call, this.is_my_threads_updated, this.is_super, this.item, this.team_name, this.team_chat_type, this.is_chat_owner, this.is_chat_admin, this.team_id, this.digest, this.is_private_mode, this.muted_bot_p2p, this.last_at_digest, this.last_at_rank_time, this.items, this.joined_team_infos, this.joined_teams, this.bound_team_infos, this.is_special_focus, this.read_position, this.latest_read_timestamp, this.is_user_count_visible, this.not_member_type, this.tags, this.tag_info, this.last_message_send_user_id, this.last_message_send_user_name, this.last_message_send_user_avatar_key, this.last_message_fold_id, this.last_message_is_fold, this.video_chat_meeting_card_meeting_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.is_remind, "is_remind"});
        }

        public Builder() {
            this.avatar_urls = Internal.newMutableList();
            this.at_infos = Internal.newMutableList();
            this.reactions = Internal.newMutableList();
            this.urgents = Internal.newMutableList();
            this.chatter_status = Internal.newMutableList();
            this.items = Internal.newMutableList();
            this.joined_team_infos = Internal.newMutableList();
            this.joined_teams = Internal.newMutableMap();
            this.bound_team_infos = Internal.newMutableList();
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder at_info(AtInfo r100) {
            this.at_info = r100;
            return this;
        }

        public Builder at_infos(List<AtInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_infos = r100;
            return this;
        }

        public Builder at_infos_count(Integer r100) {
            this.at_infos_count = r100;
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

        public Builder bound_team_infos(List<ChatTeamInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.bound_team_infos = r100;
            return this;
        }

        public Builder can_set_stranger(Integer r100) {
            this.can_set_stranger = r100;
            return this;
        }

        public Builder card_type(CardContent.Type r100) {
            this.card_type = r100;
            return this;
        }

        public Builder chat_description(String r100) {
            this.chat_description = r100;
            return this;
        }

        public Builder chat_display_mode_setting(Chat.ChatDisplayModeSetting.Enum r100) {
            this.chat_display_mode_setting = r100;
            return this;
        }

        public Builder chat_mode(Chat.ChatMode r100) {
            this.chat_mode = r100;
            return this;
        }

        public Builder chat_muteable(Boolean r100) {
            this.chat_muteable = r100;
            return this;
        }

        public Builder chat_readable(Integer r100) {
            this.chat_readable = r100;
            return this;
        }

        public Builder chat_role(Chat.Role r100) {
            this.chat_role = r100;
            return this;
        }

        public Builder chat_type(Chat.Type r100) {
            this.chat_type = r100;
            return this;
        }

        public Builder chatter_apply_count(Integer r100) {
            this.chatter_apply_count = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder chatter_status(List<Chatter.ChatterCustomStatus> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_status = r100;
            return this;
        }

        public Builder chatter_type(Chatter.Type r100) {
            this.chatter_type = r100;
            return this;
        }

        public Builder cross_tenant(Boolean r100) {
            this.cross_tenant = r100;
            return this;
        }

        public Builder digest(Digest r100) {
            this.digest = r100;
            return this;
        }

        public Builder digest_is_query(Boolean r100) {
            this.digest_is_query = r100;
            return this;
        }

        public Builder display(HighPriorityDisplay r100) {
            this.display = r100;
            return this;
        }

        public Builder display_time(Long r100) {
            this.display_time = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.do_not_disturb_end_time = r100;
            return this;
        }

        public Builder draft_preview(DraftPreview r100) {
            this.draft_preview = r100;
            return this;
        }

        public Builder entity_status(EntityStatus r100) {
            this.entity_status = r100;
            return this;
        }

        public Builder focus_info(FocusInfo r100) {
            this.focus_info = r100;
            return this;
        }

        public Builder icon(Icon r100) {
            this.icon = r100;
            return this;
        }

        public Builder is_agent(Boolean r100) {
            this.is_agent = r100;
            return this;
        }

        public Builder is_blocked(Boolean r100) {
            this.is_blocked = r100;
            return this;
        }

        public Builder is_chat_admin(Boolean r100) {
            this.is_chat_admin = r100;
            return this;
        }

        public Builder is_chat_owner(Boolean r100) {
            this.is_chat_owner = r100;
            return this;
        }

        public Builder is_cross_with_ka(Boolean r100) {
            this.is_cross_with_ka = r100;
            return this;
        }

        public Builder is_crypto(Boolean r100) {
            this.is_crypto = r100;
            return this;
        }

        public Builder is_department(Boolean r100) {
            this.is_department = r100;
            return this;
        }

        public Builder is_edu(Boolean r100) {
            this.is_edu = r100;
            return this;
        }

        public Builder is_frozen(Boolean r100) {
            this.is_frozen = r100;
            return this;
        }

        public Builder is_meeting(Boolean r100) {
            this.is_meeting = r100;
            return this;
        }

        public Builder is_member(Boolean r100) {
            this.is_member = r100;
            return this;
        }

        public Builder is_my_threads_updated(Boolean r100) {
            this.is_my_threads_updated = r100;
            return this;
        }

        public Builder is_official_oncall(Boolean r100) {
            this.is_official_oncall = r100;
            return this;
        }

        public Builder is_offline_oncall(Boolean r100) {
            this.is_offline_oncall = r100;
            return this;
        }

        public Builder is_p2p_ai(Boolean r100) {
            this.is_p2p_ai = r100;
            return this;
        }

        public Builder is_p2p_official_bot_ai(Boolean r100) {
            this.is_p2p_official_bot_ai = r100;
            return this;
        }

        public Builder is_private_mode(Boolean r100) {
            this.is_private_mode = r100;
            return this;
        }

        public Builder is_public_v2(Boolean r100) {
            this.is_public_v2 = r100;
            return this;
        }

        public Builder is_red_badge(Boolean r100) {
            this.is_red_badge = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder is_shortcut(Boolean r100) {
            this.is_shortcut = r100;
            return this;
        }

        public Builder is_special_focus(Boolean r100) {
            this.is_special_focus = r100;
            return this;
        }

        public Builder is_stranger(Boolean r100) {
            this.is_stranger = r100;
            return this;
        }

        public Builder is_super(Boolean r100) {
            this.is_super = r100;
            return this;
        }

        public Builder is_support_view(Boolean r100) {
            this.is_support_view = r100;
            return this;
        }

        public Builder is_user_count_visible(Boolean r100) {
            this.is_user_count_visible = r100;
            return this;
        }

        public Builder is_voice_call(Boolean r100) {
            this.is_voice_call = r100;
            return this;
        }

        public Builder item(Item r100) {
            this.item = r100;
            return this;
        }

        public Builder items(List<Item> r100) {
            Internal.checkElementsNotNull(r100);
            this.items = r100;
            return this;
        }

        public Builder joined_team_infos(List<ChatTeamInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.joined_team_infos = r100;
            return this;
        }

        public Builder joined_teams(Map<Long, Team> r100) {
            Internal.checkElementsNotNull(r100);
            this.joined_teams = r100;
            return this;
        }

        public Builder last_at_digest(Digest r100) {
            this.last_at_digest = r100;
            return this;
        }

        public Builder last_at_rank_time(Long r100) {
            this.last_at_rank_time = r100;
            return this;
        }

        public Builder last_has_ai_reply(Boolean r100) {
            this.last_has_ai_reply = r100;
            return this;
        }

        public Builder last_message_fold_id(Long r100) {
            this.last_message_fold_id = r100;
            return this;
        }

        public Builder last_message_is_fold(Boolean r100) {
            this.last_message_is_fold = r100;
            return this;
        }

        public Builder last_message_position(Integer r100) {
            this.last_message_position = r100;
            return this;
        }

        public Builder last_message_send_user_avatar_key(String r100) {
            this.last_message_send_user_avatar_key = r100;
            return this;
        }

        public Builder last_message_send_user_id(Long r100) {
            this.last_message_send_user_id = r100;
            return this;
        }

        public Builder last_message_send_user_name(String r100) {
            this.last_message_send_user_name = r100;
            return this;
        }

        public Builder last_message_type(com.bytedance.lark.pb.basic.v1.Message.Type r100) {
            this.last_message_type = r100;
            return this;
        }

        public Builder last_visible_message_id(String r100) {
            this.last_visible_message_id = r100;
            return this;
        }

        public Builder last_visible_message_position(Integer r100) {
            this.last_visible_message_position = r100;
            return this;
        }

        public Builder latest_read_timestamp(Integer r100) {
            this.latest_read_timestamp = r100;
            return this;
        }

        public Builder localized_digest_message(String r100) {
            this.localized_digest_message = r100;
            return this;
        }

        public Builder mini_avatar_key(String r100) {
            this.mini_avatar_key = r100;
            return this;
        }

        public Builder muted_bot_p2p(Boolean r100) {
            this.muted_bot_p2p = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder not_member_type(NotMemberType r100) {
            this.not_member_type = r100;
            return this;
        }

        public Builder notice_type(ChatUserAutoMuteSetting.NoticeType r100) {
            this.notice_type = r100;
            return this;
        }

        public Builder oncall_id(String r100) {
            this.oncall_id = r100;
            return this;
        }

        public Builder original_digest_message(String r100) {
            this.original_digest_message = r100;
            return this;
        }

        public Builder query_id(Long r100) {
            this.query_id = r100;
            return this;
        }

        public Builder query_status(AIKnowledgeQueryStatus r100) {
            this.query_status = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }

        public Builder reactions(List<com.bytedance.lark.pb.basic.v1.Message.Reaction> r100) {
            Internal.checkElementsNotNull(r100);
            this.reactions = r100;
            return this;
        }

        public Builder read_position(Integer r100) {
            this.read_position = r100;
            return this;
        }

        public Builder system_message_type(Content.SystemType r100) {
            this.system_message_type = r100;
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

        public Builder team_chat_type(TeamChatType r100) {
            this.team_chat_type = r100;
            return this;
        }

        public Builder team_id(Long r100) {
            this.team_id = r100;
            return this;
        }

        public Builder team_name(String r100) {
            this.team_name = r100;
            return this;
        }

        public Builder tenant_chat(Boolean r100) {
            this.tenant_chat = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }

        public Builder urgent_info(UrgentInfo r100) {
            this.urgent_info = r100;
            return this;
        }

        public Builder urgents(List<Urgent> r100) {
            Internal.checkElementsNotNull(r100);
            this.urgents = r100;
            return this;
        }

        public Builder user_count(Integer r100) {
            this.user_count = r100;
            return this;
        }

        public Builder video_chat_meeting_card_meeting_id(String r100) {
            this.video_chat_meeting_card_meeting_id = r100;
            return this;
        }

        public Builder video_chat_type(VideoChatContent.Type r100) {
            this.video_chat_type = r100;
            return this;
        }

        public Builder with_bot_tag(String r100) {
            this.with_bot_tag = r100;
            return this;
        }
    }

    public static final enum NotMemberType extends Enum<NotMemberType> implements WireEnum {
        private static final /* synthetic */ NotMemberType[] $VALUES = null;
        public static final ProtoAdapter<NotMemberType> ADAPTER = null;
        public static final NotMemberType NORMAL_DISSOLVED = null;
        public static final NotMemberType NOT_JOINED_OR_EXITED = null;
        public static final NotMemberType TNS_DISSOLVED = null;
        private final int value;

        static {
            NotMemberType r100 = new NotMemberType("NOT_JOINED_OR_EXITED", 0, 0);
            NOT_JOINED_OR_EXITED = r100;
            NotMemberType r101 = new NotMemberType("NORMAL_DISSOLVED", 1, 1);
            NORMAL_DISSOLVED = r101;
            NotMemberType r102 = new NotMemberType("TNS_DISSOLVED", 2, 2);
            TNS_DISSOLVED = r102;
            $VALUES = new NotMemberType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(NotMemberType.class);
        }

        public static NotMemberType[] values() {
            return (NotMemberType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NotMemberType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TNS_DISSOLVED;
        L12:
            return NORMAL_DISSOLVED;
        L14:
            return NOT_JOINED_OR_EXITED;
        }

        public static NotMemberType valueOf(String r100) {
            return (NotMemberType) a.a(NotMemberType.class, r100);
        }

        private NotMemberType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ChatData extends ProtoAdapter<ChatData> {
        private final ProtoAdapter<Map<Long, Team>> joined_teams;

        public ProtoAdapter_ChatData() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatData.class);
            this.joined_teams = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, Team.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.avatar_key = "";
            r101.avatar_path = "";
            r101.unread_count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_remind = r102;
            r101.is_shortcut = r102;
            r101.localized_digest_message = "";
            r101.entity_status = EntityStatus.NORMAL;
            r101.display_time = 0L;
            r101.rank_time = 0L;
            r101.cross_tenant = r102;
            r101.do_not_disturb_end_time = 0L;
            r101.mini_avatar_key = "";
            r101.original_digest_message = "";
            r101.chat_type = Chat.Type.P2P;
            r101.chatter_type = Chatter.Type.UNKNOWN;
            r101.chatter_id = "";
            r101.is_crypto = r102;
            r101.chat_mode = Chat.ChatMode.DEFAULT;
            r101.is_meeting = r102;
            r101.with_bot_tag = "bot";
            r101.last_message_position = 0;
            r101.is_department = r102;
            r101.tenant_chat = r102;
            r101.chat_description = "";
            r101.is_support_view = r102;
            r101.oncall_id = "";
            r101.last_message_type = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
            r101.system_message_type = Content.SystemType.UNKNOWN;
            r101.card_type = CardContent.Type.UNKNOWN_TYPE;
            r101.is_public_v2 = r102;
            Boolean r103 = Boolean.TRUE;
            r101.is_member = r103;
            r101.last_visible_message_id = "";
            r101.chat_muteable = r102;
            r101.chat_role = Chat.Role.IGNORE;
            r101.is_edu = r102;
            r101.is_cross_with_ka = r102;
            r101.user_count = 0;
            r101.at_infos_count = 0;
            r101.chat_display_mode_setting = Chat.ChatDisplayModeSetting.Enum.UNKNOWN;
            r101.last_visible_message_position = 0;
            r101.is_frozen = r102;
            r101.is_p2p_ai = r102;
            r101.is_p2p_official_bot_ai = r102;
            r101.chatter_apply_count = 0;
            r101.last_has_ai_reply = r102;
            r101.notice_type = ChatUserAutoMuteSetting.NoticeType.UNKNOWN;
            r101.query_status = AIKnowledgeQueryStatus.UNKNOWN_QUERY_STATUS;
            r101.query_id = 0L;
            r101.digest_is_query = r102;
            r101.is_red_badge = r102;
            r101.is_official_oncall = r102;
            r101.is_offline_oncall = r102;
            r101.chat_readable = 0;
            r101.is_stranger = r102;
            r101.is_blocked = r102;
            r101.can_set_stranger = 0;
            r101.bot_ext_type = 0;
            r101.is_agent = r102;
            r101.video_chat_type = VideoChatContent.Type.UNKNOWN;
            r101.is_voice_call = r102;
            r101.is_my_threads_updated = r102;
            r101.is_super = r102;
            r101.team_name = "";
            r101.team_chat_type = TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
            r101.is_chat_owner = r102;
            r101.is_chat_admin = r102;
            r101.team_id = 0L;
            r101.is_private_mode = r102;
            r101.muted_bot_p2p = r102;
            r101.last_at_rank_time = 0L;
            r101.is_special_focus = r102;
            r101.read_position = 0;
            r101.latest_read_timestamp = 0;
            r101.is_user_count_visible = r103;
            r101.not_member_type = NotMemberType.NOT_JOINED_OR_EXITED;
            r101.last_message_send_user_id = 0L;
            r101.last_message_send_user_name = "";
            r101.last_message_send_user_avatar_key = "";
            r101.last_message_fold_id = 0L;
            r101.last_message_is_fold = r102;
            r101.video_chat_meeting_card_meeting_id = "";
            long r104 = r100.beginMessage();
        L3:
            int r105 = r100.nextTag();
            if (r105 == (-1)) goto L164;
            if (r105 != 400) goto L8;
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L162
        L162:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r105 != 401) goto L9;
            r101.tag_info = TagData.ADAPTER.decode(r100);
            goto L3
        L9:
            switch(r105) {
                case 1: goto L158;
                case 2: goto L157;
                case 3: goto L156;
                case 4: goto L155;
                case 5: goto L154;
                case 6: goto L153;
                case 7: goto L152;
                case 8: goto L151;
                case 9: goto L150;
                case 10: goto L149;
                case 11: goto L148;
                case 12: goto L184;
                case 13: goto L143;
                case 14: goto L142;
                case 15: goto L141;
                case 16: goto L140;
                case 17: goto L139;
                case 18: goto L138;
                case 19: goto L137;
                case 20: goto L168;
                case 21: goto L174;
                case 22: goto L128;
                case 23: goto L127;
                case 24: goto L186;
                case 25: goto L122;
                case 26: goto L121;
                case 27: goto L120;
                case 28: goto L119;
                case 29: goto L118;
                case 30: goto L117;
                case 31: goto L116;
                default: goto L10;
            };
        L168:
            r101.chat_type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L135
        L135:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L174:
            r101.chatter_type = Chatter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L131
        L131:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L184:
            r101.entity_status = EntityStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L146
        L146:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L186:
            r101.chat_mode = Chat.ChatMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L125
        L125:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L116:
            r101.chat_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L117:
            r101.tenant_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L118:
            r101.is_department = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L119:
            r101.last_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L120:
            r101.with_bot_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L121:
            r101.urgents.add(Urgent.ADAPTER.decode(r100));
            goto L3
        L122:
            r101.is_meeting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L127:
            r101.is_crypto = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L128:
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L137:
            r101.original_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L138:
            r101.mini_avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L139:
            r101.do_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L140:
            r101.reactions.add(com.bytedance.lark.pb.basic.v1.Message.Reaction.ADAPTER.decode(r100));
            goto L3
        L141:
            r101.cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L142:
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L143:
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L148:
            r101.localized_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L149:
            r101.at_infos.add(AtInfo.ADAPTER.decode(r100));
            goto L3
        L150:
            r101.at_info = AtInfo.ADAPTER.decode(r100);
            goto L3
        L151:
            r101.draft_preview = DraftPreview.ADAPTER.decode(r100);
            goto L3
        L152:
            r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L153:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L154:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L155:
            r101.avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L156:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L157:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L158:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            switch(r105) {
                case 33: goto L115;
                case 34: goto L114;
                case 35: goto L176;
                case 36: goto L180;
                case 37: goto L188;
                case 38: goto L101;
                case 39: goto L100;
                case 40: goto L99;
                case 41: goto L98;
                case 42: goto L170;
                case 43: goto L93;
                case 44: goto L92;
                case 45: goto L91;
                case 46: goto L90;
                case 47: goto L89;
                case 48: goto L88;
                case 49: goto L87;
                case 50: goto L86;
                case 51: goto L85;
                case 52: goto L84;
                case 53: goto L190;
                case 54: goto L79;
                case 55: goto L78;
                case 56: goto L77;
                case 57: goto L76;
                case 58: goto L75;
                case 59: goto L74;
                case 60: goto L178;
                case 61: goto L182;
                case 62: goto L65;
                case 63: goto L64;
                case 64: goto L63;
                default: goto L11;
            };
        L170:
            r101.chat_role = Chat.Role.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L96
        L96:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L176:
            r101.last_message_type = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L112
        L112:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L178:
            r101.notice_type = ChatUserAutoMuteSetting.NoticeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L72
        L72:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L180:
            r101.system_message_type = Content.SystemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L108
        L108:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L182:
            r101.query_status = AIKnowledgeQueryStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L68
        L68:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L188:
            r101.card_type = CardContent.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L104
        L104:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L190:
            r101.chat_display_mode_setting = Chat.ChatDisplayModeSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L82
        L82:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L63:
            r101.is_red_badge = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L64:
            r101.digest_is_query = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L65:
            r101.query_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L74:
            r101.last_has_ai_reply = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L75:
            r101.chatter_apply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L76:
            r101.is_p2p_official_bot_ai = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L77:
            r101.is_p2p_ai = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L78:
            r101.is_frozen = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L79:
            r101.last_visible_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L84:
            r101.avatar_medal = AvatarMedal.ADAPTER.decode(r100);
            goto L3
        L85:
            r101.display = HighPriorityDisplay.ADAPTER.decode(r100);
            goto L3
        L86:
            r101.focus_info = FocusInfo.ADAPTER.decode(r100);
            goto L3
        L87:
            r101.chatter_status.add(Chatter.ChatterCustomStatus.ADAPTER.decode(r100));
            goto L3
        L88:
            r101.at_infos_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L89:
            r101.urgent_info = UrgentInfo.ADAPTER.decode(r100);
            goto L3
        L90:
            r101.user_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L91:
            r101.is_cross_with_ka = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L92:
            r101.is_edu = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L93:
            r101.icon = Icon.ADAPTER.decode(r100);
            goto L3
        L98:
            r101.chat_muteable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L99:
            r101.last_visible_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L100:
            r101.is_member = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L101:
            r101.is_public_v2 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L114:
            r101.oncall_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L115:
            r101.is_support_view = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            switch(r105) {
                case 100: goto L62;
                case 101: goto L61;
                case 102: goto L60;
                case 103: goto L59;
                case 104: goto L58;
                case 105: goto L57;
                case 106: goto L56;
                case 107: goto L55;
                default: goto L12;
            };
        L55:
            r101.is_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L56:
            r101.bot_ext_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L57:
            r101.can_set_stranger = ProtoAdapter.INT32.decode(r100);
            goto L3
        L58:
            r101.is_blocked = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L59:
            r101.is_stranger = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L60:
            r101.chat_readable = ProtoAdapter.INT32.decode(r100);
            goto L3
        L61:
            r101.is_offline_oncall = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L62:
            r101.is_official_oncall = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            switch(r105) {
                case 150: goto L194;
                case 151: goto L50;
                case 152: goto L49;
                case 153: goto L48;
                case 154: goto L47;
                case 155: goto L46;
                case 156: goto L166;
                case 157: goto L41;
                case 158: goto L40;
                case 159: goto L39;
                case 160: goto L38;
                case 161: goto L37;
                case 162: goto L36;
                default: goto L13;
            };
        L166:
            r101.team_chat_type = TeamChatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L44
        L44:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L194:
            r101.video_chat_type = VideoChatContent.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L53
        L53:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L36:
            r101.muted_bot_p2p = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L37:
            r101.is_private_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L38:
            r101.digest = Digest.ADAPTER.decode(r100);
            goto L3
        L39:
            r101.team_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L40:
            r101.is_chat_admin = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L41:
            r101.is_chat_owner = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L46:
            r101.team_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L47:
            r101.item = Item.ADAPTER.decode(r100);
            goto L3
        L48:
            r101.is_super = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L49:
            r101.is_my_threads_updated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L50:
            r101.is_voice_call = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            switch(r105) {
                case 166: goto L35;
                case 167: goto L34;
                case 168: goto L33;
                case 169: goto L32;
                case 170: goto L31;
                case 171: goto L30;
                case 172: goto L29;
                case 173: goto L28;
                case 174: goto L27;
                case 175: goto L26;
                case 176: goto L192;
                default: goto L14;
            };
        L192:
            r101.not_member_type = NotMemberType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L26:
            r101.is_user_count_visible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.latest_read_timestamp = ProtoAdapter.INT32.decode(r100);
            goto L3
        L28:
            r101.read_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L29:
            r101.is_special_focus = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L30:
            r101.bound_team_infos.add(ChatTeamInfo.ADAPTER.decode(r100));
            goto L3
        L31:
            r101.joined_teams.putAll(this.joined_teams.decode(r100));
            goto L3
        L32:
            r101.joined_team_infos.add(ChatTeamInfo.ADAPTER.decode(r100));
            goto L3
        L33:
            r101.items.add(Item.ADAPTER.decode(r100));
            goto L3
        L34:
            r101.last_at_rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L35:
            r101.last_at_digest = Digest.ADAPTER.decode(r100);
            goto L3
        L14:
            switch(r105) {
                case 500: goto L21;
                case 501: goto L20;
                case 502: goto L19;
                case 503: goto L18;
                case 504: goto L17;
                case 505: goto L16;
                default: goto L15;
            };
        L16:
            r101.video_chat_meeting_card_meeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.last_message_is_fold = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.last_message_fold_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.last_message_send_user_avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.last_message_send_user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.last_message_send_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r106 = r100.peekFieldEncoding();
            r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
            goto L3
        L164:
            r100.endMessage(r104);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.name);
            String r103 = r100.avatar_key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.avatar_path;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = (r106 + r108) + r101.asRepeated().encodedSizeWithTag(4, r100.avatar_urls);
            Integer r110 = r100.unread_count;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            ProtoAdapter<Boolean> r113 = ProtoAdapter.BOOL;
            int r114 = r112 + r113.encodedSizeWithTag(6, r100.is_remind);
            Boolean r115 = r100.is_shortcut;
            if (r115 == null) goto L17;
            int r116 = r113.encodedSizeWithTag(7, r115);
        L18:
            int r117 = r114 + r116;
            DraftPreview r118 = r100.draft_preview;
            if (r118 == null) goto L21;
            int r119 = DraftPreview.ADAPTER.encodedSizeWithTag(8, r118);
        L22:
            int r120 = r117 + r119;
            AtInfo r121 = r100.at_info;
            if (r121 == null) goto L25;
            int r122 = AtInfo.ADAPTER.encodedSizeWithTag(9, r121);
        L26:
            int r123 = (r120 + r122) + AtInfo.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.at_infos);
            String r124 = r100.localized_digest_message;
            if (r124 == null) goto L29;
            int r125 = r101.encodedSizeWithTag(11, r124);
        L30:
            int r126 = r123 + r125;
            EntityStatus r127 = r100.entity_status;
            if (r127 == null) goto L33;
            int r128 = EntityStatus.ADAPTER.encodedSizeWithTag(12, r127);
        L34:
            int r129 = r126 + r128;
            Long r130 = r100.display_time;
            if (r130 == null) goto L37;
            int r131 = ProtoAdapter.INT64.encodedSizeWithTag(13, r130);
        L38:
            int r132 = r129 + r131;
            Long r133 = r100.rank_time;
            if (r133 == null) goto L41;
            int r134 = ProtoAdapter.INT64.encodedSizeWithTag(14, r133);
        L42:
            int r135 = r132 + r134;
            Boolean r136 = r100.cross_tenant;
            if (r136 == null) goto L45;
            int r137 = r113.encodedSizeWithTag(15, r136);
        L46:
            int r138 = (r135 + r137) + com.bytedance.lark.pb.basic.v1.Message.Reaction.ADAPTER.asRepeated().encodedSizeWithTag(16, r100.reactions);
            Long r139 = r100.do_not_disturb_end_time;
            if (r139 == null) goto L49;
            int r140 = ProtoAdapter.INT64.encodedSizeWithTag(17, r139);
        L50:
            int r141 = r138 + r140;
            String r142 = r100.mini_avatar_key;
            if (r142 == null) goto L53;
            int r143 = r101.encodedSizeWithTag(18, r142);
        L54:
            int r144 = r141 + r143;
            String r145 = r100.original_digest_message;
            if (r145 == null) goto L57;
            int r146 = r101.encodedSizeWithTag(19, r145);
        L58:
            int r147 = r144 + r146;
            Chat.Type r148 = r100.chat_type;
            if (r148 == null) goto L61;
            int r149 = Chat.Type.ADAPTER.encodedSizeWithTag(20, r148);
        L62:
            int r150 = r147 + r149;
            Chatter.Type r151 = r100.chatter_type;
            if (r151 == null) goto L65;
            int r152 = Chatter.Type.ADAPTER.encodedSizeWithTag(21, r151);
        L66:
            int r153 = r150 + r152;
            String r154 = r100.chatter_id;
            if (r154 == null) goto L69;
            int r155 = r101.encodedSizeWithTag(22, r154);
        L70:
            int r156 = r153 + r155;
            Boolean r157 = r100.is_crypto;
            if (r157 == null) goto L73;
            int r158 = r113.encodedSizeWithTag(23, r157);
        L74:
            int r159 = r156 + r158;
            Chat.ChatMode r160 = r100.chat_mode;
            if (r160 == null) goto L77;
            int r161 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(24, r160);
        L78:
            int r162 = r159 + r161;
            Boolean r163 = r100.is_meeting;
            if (r163 == null) goto L81;
            int r164 = r113.encodedSizeWithTag(25, r163);
        L82:
            int r165 = (r162 + r164) + Urgent.ADAPTER.asRepeated().encodedSizeWithTag(26, r100.urgents);
            String r166 = r100.with_bot_tag;
            if (r166 == null) goto L85;
            int r167 = r101.encodedSizeWithTag(27, r166);
        L86:
            int r168 = r165 + r167;
            Integer r169 = r100.last_message_position;
            if (r169 == null) goto L89;
            int r170 = ProtoAdapter.INT32.encodedSizeWithTag(28, r169);
        L90:
            int r171 = r168 + r170;
            Boolean r172 = r100.is_department;
            if (r172 == null) goto L93;
            int r173 = r113.encodedSizeWithTag(29, r172);
        L94:
            int r174 = r171 + r173;
            Boolean r175 = r100.tenant_chat;
            if (r175 == null) goto L97;
            int r176 = r113.encodedSizeWithTag(30, r175);
        L98:
            int r177 = r174 + r176;
            String r178 = r100.chat_description;
            if (r178 == null) goto L101;
            int r179 = r101.encodedSizeWithTag(31, r178);
        L102:
            int r180 = r177 + r179;
            Boolean r181 = r100.is_support_view;
            if (r181 == null) goto L105;
            int r182 = r113.encodedSizeWithTag(33, r181);
        L106:
            int r183 = r180 + r182;
            String r184 = r100.oncall_id;
            if (r184 == null) goto L109;
            int r185 = r101.encodedSizeWithTag(34, r184);
        L110:
            int r186 = r183 + r185;
            com.bytedance.lark.pb.basic.v1.Message.Type r187 = r100.last_message_type;
            if (r187 == null) goto L113;
            int r188 = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodedSizeWithTag(35, r187);
        L114:
            int r189 = r186 + r188;
            Content.SystemType r190 = r100.system_message_type;
            if (r190 == null) goto L117;
            int r191 = Content.SystemType.ADAPTER.encodedSizeWithTag(36, r190);
        L118:
            int r192 = r189 + r191;
            CardContent.Type r193 = r100.card_type;
            if (r193 == null) goto L121;
            int r194 = CardContent.Type.ADAPTER.encodedSizeWithTag(37, r193);
        L122:
            int r195 = r192 + r194;
            Boolean r196 = r100.is_public_v2;
            if (r196 == null) goto L125;
            int r197 = r113.encodedSizeWithTag(38, r196);
        L126:
            int r198 = r195 + r197;
            Boolean r199 = r100.is_member;
            if (r199 == null) goto L129;
            int r200 = r113.encodedSizeWithTag(39, r199);
        L130:
            int r201 = r198 + r200;
            String r202 = r100.last_visible_message_id;
            if (r202 == null) goto L133;
            int r203 = r101.encodedSizeWithTag(40, r202);
        L134:
            int r204 = r201 + r203;
            Boolean r205 = r100.chat_muteable;
            if (r205 == null) goto L137;
            int r206 = r113.encodedSizeWithTag(41, r205);
        L138:
            int r207 = r204 + r206;
            Chat.Role r208 = r100.chat_role;
            if (r208 == null) goto L141;
            int r209 = Chat.Role.ADAPTER.encodedSizeWithTag(42, r208);
        L142:
            int r210 = r207 + r209;
            Icon r211 = r100.icon;
            if (r211 == null) goto L145;
            int r212 = Icon.ADAPTER.encodedSizeWithTag(43, r211);
        L146:
            int r213 = r210 + r212;
            Boolean r214 = r100.is_edu;
            if (r214 == null) goto L149;
            int r215 = r113.encodedSizeWithTag(44, r214);
        L150:
            int r216 = r213 + r215;
            Boolean r217 = r100.is_cross_with_ka;
            if (r217 == null) goto L153;
            int r218 = r113.encodedSizeWithTag(45, r217);
        L154:
            int r219 = r216 + r218;
            Integer r220 = r100.user_count;
            if (r220 == null) goto L157;
            int r221 = ProtoAdapter.INT32.encodedSizeWithTag(46, r220);
        L158:
            int r222 = r219 + r221;
            UrgentInfo r223 = r100.urgent_info;
            if (r223 == null) goto L161;
            int r224 = UrgentInfo.ADAPTER.encodedSizeWithTag(47, r223);
        L162:
            int r225 = r222 + r224;
            Integer r226 = r100.at_infos_count;
            if (r226 == null) goto L165;
            int r227 = ProtoAdapter.INT32.encodedSizeWithTag(48, r226);
        L166:
            int r228 = (r225 + r227) + Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(49, r100.chatter_status);
            FocusInfo r229 = r100.focus_info;
            if (r229 == null) goto L169;
            int r230 = FocusInfo.ADAPTER.encodedSizeWithTag(50, r229);
        L170:
            int r231 = r228 + r230;
            HighPriorityDisplay r232 = r100.display;
            if (r232 == null) goto L173;
            int r233 = HighPriorityDisplay.ADAPTER.encodedSizeWithTag(51, r232);
        L174:
            int r234 = r231 + r233;
            AvatarMedal r235 = r100.avatar_medal;
            if (r235 == null) goto L177;
            int r236 = AvatarMedal.ADAPTER.encodedSizeWithTag(52, r235);
        L178:
            int r237 = r234 + r236;
            Chat.ChatDisplayModeSetting.Enum r238 = r100.chat_display_mode_setting;
            if (r238 == null) goto L181;
            int r239 = Chat.ChatDisplayModeSetting.Enum.ADAPTER.encodedSizeWithTag(53, r238);
        L182:
            int r240 = r237 + r239;
            Integer r241 = r100.last_visible_message_position;
            if (r241 == null) goto L185;
            int r242 = ProtoAdapter.INT32.encodedSizeWithTag(54, r241);
        L186:
            int r243 = r240 + r242;
            Boolean r244 = r100.is_frozen;
            if (r244 == null) goto L189;
            int r245 = r113.encodedSizeWithTag(55, r244);
        L190:
            int r246 = r243 + r245;
            Boolean r247 = r100.is_p2p_ai;
            if (r247 == null) goto L193;
            int r248 = r113.encodedSizeWithTag(56, r247);
        L194:
            int r249 = r246 + r248;
            Boolean r250 = r100.is_p2p_official_bot_ai;
            if (r250 == null) goto L197;
            int r251 = r113.encodedSizeWithTag(57, r250);
        L198:
            int r252 = r249 + r251;
            Integer r253 = r100.chatter_apply_count;
            if (r253 == null) goto L201;
            int r254 = ProtoAdapter.INT32.encodedSizeWithTag(58, r253);
        L202:
            int r255 = r252 + r254;
            Boolean r256 = r100.last_has_ai_reply;
            if (r256 == null) goto L205;
            int r257 = r113.encodedSizeWithTag(59, r256);
        L206:
            int r258 = r255 + r257;
            ChatUserAutoMuteSetting.NoticeType r259 = r100.notice_type;
            if (r259 == null) goto L209;
            int r260 = ChatUserAutoMuteSetting.NoticeType.ADAPTER.encodedSizeWithTag(60, r259);
        L210:
            int r261 = r258 + r260;
            AIKnowledgeQueryStatus r262 = r100.query_status;
            if (r262 == null) goto L213;
            int r263 = AIKnowledgeQueryStatus.ADAPTER.encodedSizeWithTag(61, r262);
        L214:
            int r264 = r261 + r263;
            Long r265 = r100.query_id;
            if (r265 == null) goto L217;
            int r266 = ProtoAdapter.INT64.encodedSizeWithTag(62, r265);
        L218:
            int r267 = r264 + r266;
            Boolean r268 = r100.digest_is_query;
            if (r268 == null) goto L221;
            int r269 = r113.encodedSizeWithTag(63, r268);
        L222:
            int r270 = r267 + r269;
            Boolean r271 = r100.is_red_badge;
            if (r271 == null) goto L225;
            int r272 = r113.encodedSizeWithTag(64, r271);
        L226:
            int r273 = r270 + r272;
            Boolean r274 = r100.is_official_oncall;
            if (r274 == null) goto L229;
            int r275 = r113.encodedSizeWithTag(100, r274);
        L230:
            int r276 = r273 + r275;
            Boolean r277 = r100.is_offline_oncall;
            if (r277 == null) goto L233;
            int r278 = r113.encodedSizeWithTag(101, r277);
        L234:
            int r279 = r276 + r278;
            Integer r280 = r100.chat_readable;
            if (r280 == null) goto L237;
            int r281 = ProtoAdapter.INT32.encodedSizeWithTag(102, r280);
        L238:
            int r282 = r279 + r281;
            Boolean r283 = r100.is_stranger;
            if (r283 == null) goto L241;
            int r284 = r113.encodedSizeWithTag(103, r283);
        L242:
            int r285 = r282 + r284;
            Boolean r286 = r100.is_blocked;
            if (r286 == null) goto L245;
            int r287 = r113.encodedSizeWithTag(104, r286);
        L246:
            int r288 = r285 + r287;
            Integer r289 = r100.can_set_stranger;
            if (r289 == null) goto L249;
            int r290 = ProtoAdapter.INT32.encodedSizeWithTag(105, r289);
        L250:
            int r291 = r288 + r290;
            Integer r292 = r100.bot_ext_type;
            if (r292 == null) goto L253;
            int r293 = ProtoAdapter.INT32.encodedSizeWithTag(106, r292);
        L254:
            int r294 = r291 + r293;
            Boolean r295 = r100.is_agent;
            if (r295 == null) goto L257;
            int r296 = r113.encodedSizeWithTag(107, r295);
        L258:
            int r297 = r294 + r296;
            VideoChatContent.Type r298 = r100.video_chat_type;
            if (r298 == null) goto L261;
            int r299 = VideoChatContent.Type.ADAPTER.encodedSizeWithTag(150, r298);
        L262:
            int r300 = r297 + r299;
            Boolean r301 = r100.is_voice_call;
            if (r301 == null) goto L265;
            int r302 = r113.encodedSizeWithTag(151, r301);
        L266:
            int r303 = r300 + r302;
            Boolean r304 = r100.is_my_threads_updated;
            if (r304 == null) goto L269;
            int r305 = r113.encodedSizeWithTag(152, r304);
        L270:
            int r306 = r303 + r305;
            Boolean r307 = r100.is_super;
            if (r307 == null) goto L273;
            int r308 = r113.encodedSizeWithTag(153, r307);
        L274:
            int r309 = r306 + r308;
            Item r310 = r100.item;
            if (r310 == null) goto L277;
            int r311 = Item.ADAPTER.encodedSizeWithTag(154, r310);
        L278:
            int r312 = r309 + r311;
            String r313 = r100.team_name;
            if (r313 == null) goto L281;
            int r314 = r101.encodedSizeWithTag(155, r313);
        L282:
            int r315 = r312 + r314;
            TeamChatType r316 = r100.team_chat_type;
            if (r316 == null) goto L285;
            int r317 = TeamChatType.ADAPTER.encodedSizeWithTag(156, r316);
        L286:
            int r318 = r315 + r317;
            Boolean r319 = r100.is_chat_owner;
            if (r319 == null) goto L289;
            int r320 = r113.encodedSizeWithTag(157, r319);
        L290:
            int r321 = r318 + r320;
            Boolean r322 = r100.is_chat_admin;
            if (r322 == null) goto L293;
            int r323 = r113.encodedSizeWithTag(158, r322);
        L294:
            int r324 = r321 + r323;
            Long r325 = r100.team_id;
            if (r325 == null) goto L297;
            int r326 = ProtoAdapter.INT64.encodedSizeWithTag(159, r325);
        L298:
            int r327 = r324 + r326;
            Digest r328 = r100.digest;
            if (r328 == null) goto L301;
            int r329 = Digest.ADAPTER.encodedSizeWithTag(160, r328);
        L302:
            int r330 = r327 + r329;
            Boolean r331 = r100.is_private_mode;
            if (r331 == null) goto L305;
            int r332 = r113.encodedSizeWithTag(161, r331);
        L306:
            int r333 = r330 + r332;
            Boolean r334 = r100.muted_bot_p2p;
            if (r334 == null) goto L309;
            int r335 = r113.encodedSizeWithTag(162, r334);
        L310:
            int r336 = r333 + r335;
            Digest r337 = r100.last_at_digest;
            if (r337 == null) goto L313;
            int r338 = Digest.ADAPTER.encodedSizeWithTag(166, r337);
        L314:
            int r339 = r336 + r338;
            Long r340 = r100.last_at_rank_time;
            if (r340 == null) goto L317;
            int r341 = ProtoAdapter.INT64.encodedSizeWithTag(167, r340);
        L318:
            int r342 = (r339 + r341) + Item.ADAPTER.asRepeated().encodedSizeWithTag(168, r100.items);
            ProtoAdapter<ChatTeamInfo> r343 = ChatTeamInfo.ADAPTER;
            int r344 = ((r342 + r343.asRepeated().encodedSizeWithTag(169, r100.joined_team_infos)) + this.joined_teams.encodedSizeWithTag(170, r100.joined_teams)) + r343.asRepeated().encodedSizeWithTag(171, r100.bound_team_infos);
            Boolean r345 = r100.is_special_focus;
            if (r345 == null) goto L321;
            int r346 = r113.encodedSizeWithTag(172, r345);
        L322:
            int r347 = r344 + r346;
            Integer r348 = r100.read_position;
            if (r348 == null) goto L325;
            int r349 = ProtoAdapter.INT32.encodedSizeWithTag(173, r348);
        L326:
            int r350 = r347 + r349;
            Integer r351 = r100.latest_read_timestamp;
            if (r351 == null) goto L329;
            int r352 = ProtoAdapter.INT32.encodedSizeWithTag(174, r351);
        L330:
            int r353 = r350 + r352;
            Boolean r354 = r100.is_user_count_visible;
            if (r354 == null) goto L333;
            int r355 = r113.encodedSizeWithTag(175, r354);
        L334:
            int r356 = r353 + r355;
            NotMemberType r357 = r100.not_member_type;
            if (r357 == null) goto L337;
            int r358 = NotMemberType.ADAPTER.encodedSizeWithTag(176, r357);
        L338:
            int r359 = (r356 + r358) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(400, r100.tags);
            TagData r360 = r100.tag_info;
            if (r360 == null) goto L341;
            int r361 = TagData.ADAPTER.encodedSizeWithTag(401, r360);
        L342:
            int r362 = r359 + r361;
            Long r363 = r100.last_message_send_user_id;
            if (r363 == null) goto L345;
            int r364 = ProtoAdapter.INT64.encodedSizeWithTag(500, r363);
        L346:
            int r365 = r362 + r364;
            String r366 = r100.last_message_send_user_name;
            if (r366 == null) goto L349;
            int r367 = r101.encodedSizeWithTag(501, r366);
        L350:
            int r368 = r365 + r367;
            String r369 = r100.last_message_send_user_avatar_key;
            if (r369 == null) goto L353;
            int r370 = r101.encodedSizeWithTag(502, r369);
        L354:
            int r371 = r368 + r370;
            Long r372 = r100.last_message_fold_id;
            if (r372 == null) goto L357;
            int r373 = ProtoAdapter.INT64.encodedSizeWithTag(503, r372);
        L358:
            int r374 = r371 + r373;
            Boolean r375 = r100.last_message_is_fold;
            if (r375 == null) goto L361;
            int r376 = r113.encodedSizeWithTag(504, r375);
        L362:
            int r377 = r374 + r376;
            String r378 = r100.video_chat_meeting_card_meeting_id;
            if (r378 == null) goto L366;
            r104 = r101.encodedSizeWithTag(505, r378);
        L366:
            return (r377 + r104) + r100.unknownFields().size();
        L361:
            r376 = 0;
            goto L362
        L357:
            r373 = 0;
            goto L358
        L353:
            r370 = 0;
            goto L354
        L349:
            r367 = 0;
            goto L350
        L345:
            r364 = 0;
            goto L346
        L341:
            r361 = 0;
            goto L342
        L337:
            r358 = 0;
            goto L338
        L333:
            r355 = 0;
            goto L334
        L329:
            r352 = 0;
            goto L330
        L325:
            r349 = 0;
            goto L326
        L321:
            r346 = 0;
            goto L322
        L317:
            r341 = 0;
            goto L318
        L313:
            r338 = 0;
            goto L314
        L309:
            r335 = 0;
            goto L310
        L305:
            r332 = 0;
            goto L306
        L301:
            r329 = 0;
            goto L302
        L297:
            r326 = 0;
            goto L298
        L293:
            r323 = 0;
            goto L294
        L289:
            r320 = 0;
            goto L290
        L285:
            r317 = 0;
            goto L286
        L281:
            r314 = 0;
            goto L282
        L277:
            r311 = 0;
            goto L278
        L273:
            r308 = 0;
            goto L274
        L269:
            r305 = 0;
            goto L270
        L265:
            r302 = 0;
            goto L266
        L261:
            r299 = 0;
            goto L262
        L257:
            r296 = 0;
            goto L258
        L253:
            r293 = 0;
            goto L254
        L249:
            r290 = 0;
            goto L250
        L245:
            r287 = 0;
            goto L246
        L241:
            r284 = 0;
            goto L242
        L237:
            r281 = 0;
            goto L238
        L233:
            r278 = 0;
            goto L234
        L229:
            r275 = 0;
            goto L230
        L225:
            r272 = 0;
            goto L226
        L221:
            r269 = 0;
            goto L222
        L217:
            r266 = 0;
            goto L218
        L213:
            r263 = 0;
            goto L214
        L209:
            r260 = 0;
            goto L210
        L205:
            r257 = 0;
            goto L206
        L201:
            r254 = 0;
            goto L202
        L197:
            r251 = 0;
            goto L198
        L193:
            r248 = 0;
            goto L194
        L189:
            r245 = 0;
            goto L190
        L185:
            r242 = 0;
            goto L186
        L181:
            r239 = 0;
            goto L182
        L177:
            r236 = 0;
            goto L178
        L173:
            r233 = 0;
            goto L174
        L169:
            r230 = 0;
            goto L170
        L165:
            r227 = 0;
            goto L166
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
        public /* bridge */ /* synthetic */ ChatData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            String r103 = r101.avatar_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.avatar_path;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r102.asRepeated().encodeWithTag(r100, 4, r101.avatar_urls);
            Integer r105 = r101.unread_count;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            ProtoAdapter<Boolean> r106 = ProtoAdapter.BOOL;
            r106.encodeWithTag(r100, 6, r101.is_remind);
            Boolean r107 = r101.is_shortcut;
            if (r107 == null) goto L14;
            r106.encodeWithTag(r100, 7, r107);
        L14:
            DraftPreview r108 = r101.draft_preview;
            if (r108 == null) goto L17;
            DraftPreview.ADAPTER.encodeWithTag(r100, 8, r108);
        L17:
            AtInfo r109 = r101.at_info;
            if (r109 == null) goto L20;
            AtInfo.ADAPTER.encodeWithTag(r100, 9, r109);
        L20:
            AtInfo.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.at_infos);
            String r110 = r101.localized_digest_message;
            if (r110 == null) goto L23;
            r102.encodeWithTag(r100, 11, r110);
        L23:
            EntityStatus r111 = r101.entity_status;
            if (r111 == null) goto L26;
            EntityStatus.ADAPTER.encodeWithTag(r100, 12, r111);
        L26:
            Long r112 = r101.display_time;
            if (r112 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r112);
        L29:
            Long r113 = r101.rank_time;
            if (r113 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r113);
        L32:
            Boolean r114 = r101.cross_tenant;
            if (r114 == null) goto L35;
            r106.encodeWithTag(r100, 15, r114);
        L35:
            com.bytedance.lark.pb.basic.v1.Message.Reaction.ADAPTER.asRepeated().encodeWithTag(r100, 16, r101.reactions);
            Long r115 = r101.do_not_disturb_end_time;
            if (r115 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r115);
        L38:
            String r116 = r101.mini_avatar_key;
            if (r116 == null) goto L41;
            r102.encodeWithTag(r100, 18, r116);
        L41:
            String r117 = r101.original_digest_message;
            if (r117 == null) goto L44;
            r102.encodeWithTag(r100, 19, r117);
        L44:
            Chat.Type r118 = r101.chat_type;
            if (r118 == null) goto L47;
            Chat.Type.ADAPTER.encodeWithTag(r100, 20, r118);
        L47:
            Chatter.Type r119 = r101.chatter_type;
            if (r119 == null) goto L50;
            Chatter.Type.ADAPTER.encodeWithTag(r100, 21, r119);
        L50:
            String r120 = r101.chatter_id;
            if (r120 == null) goto L53;
            r102.encodeWithTag(r100, 22, r120);
        L53:
            Boolean r121 = r101.is_crypto;
            if (r121 == null) goto L56;
            r106.encodeWithTag(r100, 23, r121);
        L56:
            Chat.ChatMode r122 = r101.chat_mode;
            if (r122 == null) goto L59;
            Chat.ChatMode.ADAPTER.encodeWithTag(r100, 24, r122);
        L59:
            Boolean r123 = r101.is_meeting;
            if (r123 == null) goto L62;
            r106.encodeWithTag(r100, 25, r123);
        L62:
            Urgent.ADAPTER.asRepeated().encodeWithTag(r100, 26, r101.urgents);
            String r124 = r101.with_bot_tag;
            if (r124 == null) goto L65;
            r102.encodeWithTag(r100, 27, r124);
        L65:
            Integer r125 = r101.last_message_position;
            if (r125 == null) goto L68;
            ProtoAdapter.INT32.encodeWithTag(r100, 28, r125);
        L68:
            Boolean r126 = r101.is_department;
            if (r126 == null) goto L71;
            r106.encodeWithTag(r100, 29, r126);
        L71:
            Boolean r127 = r101.tenant_chat;
            if (r127 == null) goto L74;
            r106.encodeWithTag(r100, 30, r127);
        L74:
            String r128 = r101.chat_description;
            if (r128 == null) goto L77;
            r102.encodeWithTag(r100, 31, r128);
        L77:
            Boolean r129 = r101.is_support_view;
            if (r129 == null) goto L80;
            r106.encodeWithTag(r100, 33, r129);
        L80:
            String r130 = r101.oncall_id;
            if (r130 == null) goto L83;
            r102.encodeWithTag(r100, 34, r130);
        L83:
            com.bytedance.lark.pb.basic.v1.Message.Type r131 = r101.last_message_type;
            if (r131 == null) goto L86;
            com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodeWithTag(r100, 35, r131);
        L86:
            Content.SystemType r132 = r101.system_message_type;
            if (r132 == null) goto L89;
            Content.SystemType.ADAPTER.encodeWithTag(r100, 36, r132);
        L89:
            CardContent.Type r133 = r101.card_type;
            if (r133 == null) goto L92;
            CardContent.Type.ADAPTER.encodeWithTag(r100, 37, r133);
        L92:
            Boolean r134 = r101.is_public_v2;
            if (r134 == null) goto L95;
            r106.encodeWithTag(r100, 38, r134);
        L95:
            Boolean r135 = r101.is_member;
            if (r135 == null) goto L98;
            r106.encodeWithTag(r100, 39, r135);
        L98:
            String r136 = r101.last_visible_message_id;
            if (r136 == null) goto L101;
            r102.encodeWithTag(r100, 40, r136);
        L101:
            Boolean r137 = r101.chat_muteable;
            if (r137 == null) goto L104;
            r106.encodeWithTag(r100, 41, r137);
        L104:
            Chat.Role r138 = r101.chat_role;
            if (r138 == null) goto L107;
            Chat.Role.ADAPTER.encodeWithTag(r100, 42, r138);
        L107:
            Icon r139 = r101.icon;
            if (r139 == null) goto L110;
            Icon.ADAPTER.encodeWithTag(r100, 43, r139);
        L110:
            Boolean r140 = r101.is_edu;
            if (r140 == null) goto L113;
            r106.encodeWithTag(r100, 44, r140);
        L113:
            Boolean r141 = r101.is_cross_with_ka;
            if (r141 == null) goto L116;
            r106.encodeWithTag(r100, 45, r141);
        L116:
            Integer r142 = r101.user_count;
            if (r142 == null) goto L119;
            ProtoAdapter.INT32.encodeWithTag(r100, 46, r142);
        L119:
            UrgentInfo r143 = r101.urgent_info;
            if (r143 == null) goto L122;
            UrgentInfo.ADAPTER.encodeWithTag(r100, 47, r143);
        L122:
            Integer r144 = r101.at_infos_count;
            if (r144 == null) goto L125;
            ProtoAdapter.INT32.encodeWithTag(r100, 48, r144);
        L125:
            Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 49, r101.chatter_status);
            FocusInfo r145 = r101.focus_info;
            if (r145 == null) goto L128;
            FocusInfo.ADAPTER.encodeWithTag(r100, 50, r145);
        L128:
            HighPriorityDisplay r146 = r101.display;
            if (r146 == null) goto L131;
            HighPriorityDisplay.ADAPTER.encodeWithTag(r100, 51, r146);
        L131:
            AvatarMedal r147 = r101.avatar_medal;
            if (r147 == null) goto L134;
            AvatarMedal.ADAPTER.encodeWithTag(r100, 52, r147);
        L134:
            Chat.ChatDisplayModeSetting.Enum r148 = r101.chat_display_mode_setting;
            if (r148 == null) goto L137;
            Chat.ChatDisplayModeSetting.Enum.ADAPTER.encodeWithTag(r100, 53, r148);
        L137:
            Integer r149 = r101.last_visible_message_position;
            if (r149 == null) goto L140;
            ProtoAdapter.INT32.encodeWithTag(r100, 54, r149);
        L140:
            Boolean r150 = r101.is_frozen;
            if (r150 == null) goto L143;
            r106.encodeWithTag(r100, 55, r150);
        L143:
            Boolean r151 = r101.is_p2p_ai;
            if (r151 == null) goto L146;
            r106.encodeWithTag(r100, 56, r151);
        L146:
            Boolean r152 = r101.is_p2p_official_bot_ai;
            if (r152 == null) goto L149;
            r106.encodeWithTag(r100, 57, r152);
        L149:
            Integer r153 = r101.chatter_apply_count;
            if (r153 == null) goto L152;
            ProtoAdapter.INT32.encodeWithTag(r100, 58, r153);
        L152:
            Boolean r154 = r101.last_has_ai_reply;
            if (r154 == null) goto L155;
            r106.encodeWithTag(r100, 59, r154);
        L155:
            ChatUserAutoMuteSetting.NoticeType r155 = r101.notice_type;
            if (r155 == null) goto L158;
            ChatUserAutoMuteSetting.NoticeType.ADAPTER.encodeWithTag(r100, 60, r155);
        L158:
            AIKnowledgeQueryStatus r156 = r101.query_status;
            if (r156 == null) goto L161;
            AIKnowledgeQueryStatus.ADAPTER.encodeWithTag(r100, 61, r156);
        L161:
            Long r157 = r101.query_id;
            if (r157 == null) goto L164;
            ProtoAdapter.INT64.encodeWithTag(r100, 62, r157);
        L164:
            Boolean r158 = r101.digest_is_query;
            if (r158 == null) goto L167;
            r106.encodeWithTag(r100, 63, r158);
        L167:
            Boolean r159 = r101.is_red_badge;
            if (r159 == null) goto L170;
            r106.encodeWithTag(r100, 64, r159);
        L170:
            Boolean r160 = r101.is_official_oncall;
            if (r160 == null) goto L173;
            r106.encodeWithTag(r100, 100, r160);
        L173:
            Boolean r161 = r101.is_offline_oncall;
            if (r161 == null) goto L176;
            r106.encodeWithTag(r100, 101, r161);
        L176:
            Integer r162 = r101.chat_readable;
            if (r162 == null) goto L179;
            ProtoAdapter.INT32.encodeWithTag(r100, 102, r162);
        L179:
            Boolean r163 = r101.is_stranger;
            if (r163 == null) goto L182;
            r106.encodeWithTag(r100, 103, r163);
        L182:
            Boolean r164 = r101.is_blocked;
            if (r164 == null) goto L185;
            r106.encodeWithTag(r100, 104, r164);
        L185:
            Integer r165 = r101.can_set_stranger;
            if (r165 == null) goto L188;
            ProtoAdapter.INT32.encodeWithTag(r100, 105, r165);
        L188:
            Integer r166 = r101.bot_ext_type;
            if (r166 == null) goto L191;
            ProtoAdapter.INT32.encodeWithTag(r100, 106, r166);
        L191:
            Boolean r167 = r101.is_agent;
            if (r167 == null) goto L194;
            r106.encodeWithTag(r100, 107, r167);
        L194:
            VideoChatContent.Type r168 = r101.video_chat_type;
            if (r168 == null) goto L197;
            VideoChatContent.Type.ADAPTER.encodeWithTag(r100, 150, r168);
        L197:
            Boolean r169 = r101.is_voice_call;
            if (r169 == null) goto L200;
            r106.encodeWithTag(r100, 151, r169);
        L200:
            Boolean r170 = r101.is_my_threads_updated;
            if (r170 == null) goto L203;
            r106.encodeWithTag(r100, 152, r170);
        L203:
            Boolean r171 = r101.is_super;
            if (r171 == null) goto L206;
            r106.encodeWithTag(r100, 153, r171);
        L206:
            Item r172 = r101.item;
            if (r172 == null) goto L209;
            Item.ADAPTER.encodeWithTag(r100, 154, r172);
        L209:
            String r173 = r101.team_name;
            if (r173 == null) goto L212;
            r102.encodeWithTag(r100, 155, r173);
        L212:
            TeamChatType r174 = r101.team_chat_type;
            if (r174 == null) goto L215;
            TeamChatType.ADAPTER.encodeWithTag(r100, 156, r174);
        L215:
            Boolean r175 = r101.is_chat_owner;
            if (r175 == null) goto L218;
            r106.encodeWithTag(r100, 157, r175);
        L218:
            Boolean r176 = r101.is_chat_admin;
            if (r176 == null) goto L221;
            r106.encodeWithTag(r100, 158, r176);
        L221:
            Long r177 = r101.team_id;
            if (r177 == null) goto L224;
            ProtoAdapter.INT64.encodeWithTag(r100, 159, r177);
        L224:
            Digest r178 = r101.digest;
            if (r178 == null) goto L227;
            Digest.ADAPTER.encodeWithTag(r100, 160, r178);
        L227:
            Boolean r179 = r101.is_private_mode;
            if (r179 == null) goto L230;
            r106.encodeWithTag(r100, 161, r179);
        L230:
            Boolean r180 = r101.muted_bot_p2p;
            if (r180 == null) goto L233;
            r106.encodeWithTag(r100, 162, r180);
        L233:
            Digest r181 = r101.last_at_digest;
            if (r181 == null) goto L236;
            Digest.ADAPTER.encodeWithTag(r100, 166, r181);
        L236:
            Long r182 = r101.last_at_rank_time;
            if (r182 == null) goto L239;
            ProtoAdapter.INT64.encodeWithTag(r100, 167, r182);
        L239:
            Item.ADAPTER.asRepeated().encodeWithTag(r100, 168, r101.items);
            ProtoAdapter<ChatTeamInfo> r183 = ChatTeamInfo.ADAPTER;
            r183.asRepeated().encodeWithTag(r100, 169, r101.joined_team_infos);
            this.joined_teams.encodeWithTag(r100, 170, r101.joined_teams);
            r183.asRepeated().encodeWithTag(r100, 171, r101.bound_team_infos);
            Boolean r184 = r101.is_special_focus;
            if (r184 == null) goto L242;
            r106.encodeWithTag(r100, 172, r184);
        L242:
            Integer r185 = r101.read_position;
            if (r185 == null) goto L245;
            ProtoAdapter.INT32.encodeWithTag(r100, 173, r185);
        L245:
            Integer r186 = r101.latest_read_timestamp;
            if (r186 == null) goto L248;
            ProtoAdapter.INT32.encodeWithTag(r100, 174, r186);
        L248:
            Boolean r187 = r101.is_user_count_visible;
            if (r187 == null) goto L251;
            r106.encodeWithTag(r100, 175, r187);
        L251:
            NotMemberType r188 = r101.not_member_type;
            if (r188 == null) goto L254;
            NotMemberType.ADAPTER.encodeWithTag(r100, 176, r188);
        L254:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 400, r101.tags);
            TagData r189 = r101.tag_info;
            if (r189 == null) goto L257;
            TagData.ADAPTER.encodeWithTag(r100, 401, r189);
        L257:
            Long r190 = r101.last_message_send_user_id;
            if (r190 == null) goto L260;
            ProtoAdapter.INT64.encodeWithTag(r100, 500, r190);
        L260:
            String r191 = r101.last_message_send_user_name;
            if (r191 == null) goto L263;
            r102.encodeWithTag(r100, 501, r191);
        L263:
            String r192 = r101.last_message_send_user_avatar_key;
            if (r192 == null) goto L266;
            r102.encodeWithTag(r100, 502, r192);
        L266:
            Long r193 = r101.last_message_fold_id;
            if (r193 == null) goto L269;
            ProtoAdapter.INT64.encodeWithTag(r100, 503, r193);
        L269:
            Boolean r194 = r101.last_message_is_fold;
            if (r194 == null) goto L272;
            r106.encodeWithTag(r100, 504, r194);
        L272:
            String r195 = r101.video_chat_meeting_card_meeting_id;
            if (r195 == null) goto L275;
            r102.encodeWithTag(r100, 505, r195);
        L275:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatData();
        DEFAULT_UNREAD_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_REMIND = r100;
        DEFAULT_IS_SHORTCUT = r100;
        DEFAULT_ENTITY_STATUS = EntityStatus.NORMAL;
        DEFAULT_DISPLAY_TIME = 0L;
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_CROSS_TENANT = r100;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_CHAT_TYPE = Chat.Type.P2P;
        DEFAULT_CHATTER_TYPE = Chatter.Type.UNKNOWN;
        DEFAULT_IS_CRYPTO = r100;
        DEFAULT_CHAT_MODE = Chat.ChatMode.DEFAULT;
        DEFAULT_IS_MEETING = r100;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_IS_DEPARTMENT = r100;
        DEFAULT_TENANT_CHAT = r100;
        DEFAULT_IS_SUPPORT_VIEW = r100;
        DEFAULT_LAST_MESSAGE_TYPE = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
        DEFAULT_SYSTEM_MESSAGE_TYPE = Content.SystemType.UNKNOWN;
        DEFAULT_CARD_TYPE = CardContent.Type.UNKNOWN_TYPE;
        DEFAULT_IS_PUBLIC_V2 = r100;
        Boolean r101 = Boolean.TRUE;
        DEFAULT_IS_MEMBER = r101;
        DEFAULT_CHAT_MUTEABLE = r100;
        DEFAULT_CHAT_ROLE = Chat.Role.IGNORE;
        DEFAULT_IS_EDU = r100;
        DEFAULT_IS_CROSS_WITH_KA = r100;
        DEFAULT_USER_COUNT = 0;
        DEFAULT_AT_INFOS_COUNT = 0;
        DEFAULT_CHAT_DISPLAY_MODE_SETTING = Chat.ChatDisplayModeSetting.Enum.UNKNOWN;
        DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = 0;
        DEFAULT_IS_FROZEN = r100;
        DEFAULT_IS_P2P_AI = r100;
        DEFAULT_IS_P2P_OFFICIAL_BOT_AI = r100;
        DEFAULT_CHATTER_APPLY_COUNT = 0;
        DEFAULT_LAST_HAS_AI_REPLY = r100;
        DEFAULT_NOTICE_TYPE = ChatUserAutoMuteSetting.NoticeType.UNKNOWN;
        DEFAULT_QUERY_STATUS = AIKnowledgeQueryStatus.UNKNOWN_QUERY_STATUS;
        DEFAULT_QUERY_ID = 0L;
        DEFAULT_DIGEST_IS_QUERY = r100;
        DEFAULT_IS_RED_BADGE = r100;
        DEFAULT_IS_OFFICIAL_ONCALL = r100;
        DEFAULT_IS_OFFLINE_ONCALL = r100;
        DEFAULT_CHAT_READABLE = 0;
        DEFAULT_IS_STRANGER = r100;
        DEFAULT_IS_BLOCKED = r100;
        DEFAULT_CAN_SET_STRANGER = 0;
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = r100;
        DEFAULT_VIDEO_CHAT_TYPE = VideoChatContent.Type.UNKNOWN;
        DEFAULT_IS_VOICE_CALL = r100;
        DEFAULT_IS_MY_THREADS_UPDATED = r100;
        DEFAULT_IS_SUPER = r100;
        DEFAULT_TEAM_CHAT_TYPE = TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
        DEFAULT_IS_CHAT_OWNER = r100;
        DEFAULT_IS_CHAT_ADMIN = r100;
        DEFAULT_TEAM_ID = 0L;
        DEFAULT_IS_PRIVATE_MODE = r100;
        DEFAULT_MUTED_BOT_P2P = r100;
        DEFAULT_LAST_AT_RANK_TIME = 0L;
        DEFAULT_IS_SPECIAL_FOCUS = r100;
        DEFAULT_READ_POSITION = 0;
        DEFAULT_LATEST_READ_TIMESTAMP = 0;
        DEFAULT_IS_USER_COUNT_VISIBLE = r101;
        DEFAULT_NOT_MEMBER_TYPE = NotMemberType.NOT_JOINED_OR_EXITED;
        DEFAULT_LAST_MESSAGE_SEND_USER_ID = 0L;
        DEFAULT_LAST_MESSAGE_FOLD_ID = 0L;
        DEFAULT_LAST_MESSAGE_IS_FOLD = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.avatar_key = this.avatar_key;
        r100.avatar_path = this.avatar_path;
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.unread_count = this.unread_count;
        r100.is_remind = this.is_remind;
        r100.is_shortcut = this.is_shortcut;
        r100.draft_preview = this.draft_preview;
        r100.at_info = this.at_info;
        r100.at_infos = Internal.copyOf("at_infos", this.at_infos);
        r100.localized_digest_message = this.localized_digest_message;
        r100.entity_status = this.entity_status;
        r100.display_time = this.display_time;
        r100.rank_time = this.rank_time;
        r100.cross_tenant = this.cross_tenant;
        r100.reactions = Internal.copyOf("reactions", this.reactions);
        r100.do_not_disturb_end_time = this.do_not_disturb_end_time;
        r100.mini_avatar_key = this.mini_avatar_key;
        r100.original_digest_message = this.original_digest_message;
        r100.chat_type = this.chat_type;
        r100.chatter_type = this.chatter_type;
        r100.chatter_id = this.chatter_id;
        r100.is_crypto = this.is_crypto;
        r100.chat_mode = this.chat_mode;
        r100.is_meeting = this.is_meeting;
        r100.urgents = Internal.copyOf("urgents", this.urgents);
        r100.with_bot_tag = this.with_bot_tag;
        r100.last_message_position = this.last_message_position;
        r100.is_department = this.is_department;
        r100.tenant_chat = this.tenant_chat;
        r100.chat_description = this.chat_description;
        r100.is_support_view = this.is_support_view;
        r100.oncall_id = this.oncall_id;
        r100.last_message_type = this.last_message_type;
        r100.system_message_type = this.system_message_type;
        r100.card_type = this.card_type;
        r100.is_public_v2 = this.is_public_v2;
        r100.is_member = this.is_member;
        r100.last_visible_message_id = this.last_visible_message_id;
        r100.chat_muteable = this.chat_muteable;
        r100.chat_role = this.chat_role;
        r100.icon = this.icon;
        r100.is_edu = this.is_edu;
        r100.is_cross_with_ka = this.is_cross_with_ka;
        r100.user_count = this.user_count;
        r100.urgent_info = this.urgent_info;
        r100.at_infos_count = this.at_infos_count;
        r100.chatter_status = Internal.copyOf("chatter_status", this.chatter_status);
        r100.focus_info = this.focus_info;
        r100.display = this.display;
        r100.avatar_medal = this.avatar_medal;
        r100.chat_display_mode_setting = this.chat_display_mode_setting;
        r100.last_visible_message_position = this.last_visible_message_position;
        r100.is_frozen = this.is_frozen;
        r100.is_p2p_ai = this.is_p2p_ai;
        r100.is_p2p_official_bot_ai = this.is_p2p_official_bot_ai;
        r100.chatter_apply_count = this.chatter_apply_count;
        r100.last_has_ai_reply = this.last_has_ai_reply;
        r100.notice_type = this.notice_type;
        r100.query_status = this.query_status;
        r100.query_id = this.query_id;
        r100.digest_is_query = this.digest_is_query;
        r100.is_red_badge = this.is_red_badge;
        r100.is_official_oncall = this.is_official_oncall;
        r100.is_offline_oncall = this.is_offline_oncall;
        r100.chat_readable = this.chat_readable;
        r100.is_stranger = this.is_stranger;
        r100.is_blocked = this.is_blocked;
        r100.can_set_stranger = this.can_set_stranger;
        r100.bot_ext_type = this.bot_ext_type;
        r100.is_agent = this.is_agent;
        r100.video_chat_type = this.video_chat_type;
        r100.is_voice_call = this.is_voice_call;
        r100.is_my_threads_updated = this.is_my_threads_updated;
        r100.is_super = this.is_super;
        r100.item = this.item;
        r100.team_name = this.team_name;
        r100.team_chat_type = this.team_chat_type;
        r100.is_chat_owner = this.is_chat_owner;
        r100.is_chat_admin = this.is_chat_admin;
        r100.team_id = this.team_id;
        r100.digest = this.digest;
        r100.is_private_mode = this.is_private_mode;
        r100.muted_bot_p2p = this.muted_bot_p2p;
        r100.last_at_digest = this.last_at_digest;
        r100.last_at_rank_time = this.last_at_rank_time;
        r100.items = Internal.copyOf("items", this.items);
        r100.joined_team_infos = Internal.copyOf("joined_team_infos", this.joined_team_infos);
        r100.joined_teams = Internal.copyOf("joined_teams", this.joined_teams);
        r100.bound_team_infos = Internal.copyOf("bound_team_infos", this.bound_team_infos);
        r100.is_special_focus = this.is_special_focus;
        r100.read_position = this.read_position;
        r100.latest_read_timestamp = this.latest_read_timestamp;
        r100.is_user_count_visible = this.is_user_count_visible;
        r100.not_member_type = this.not_member_type;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.tag_info = this.tag_info;
        r100.last_message_send_user_id = this.last_message_send_user_id;
        r100.last_message_send_user_name = this.last_message_send_user_name;
        r100.last_message_send_user_avatar_key = this.last_message_send_user_avatar_key;
        r100.last_message_fold_id = this.last_message_fold_id;
        r100.last_message_is_fold = this.last_message_is_fold;
        r100.video_chat_meeting_card_meeting_id = this.video_chat_meeting_card_meeting_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatData(String r106, String r107, String r108, List<String> r109, Integer r110, Boolean r111, Boolean r112, DraftPreview r113, AtInfo r114, List<AtInfo> r115, String r116, EntityStatus r117, Long r118, Long r119, Boolean r120, List<com.bytedance.lark.pb.basic.v1.Message.Reaction> r121, Long r122, String r123, String r124, Chat.Type r125, Chatter.Type r126, String r127, Boolean r128, Chat.ChatMode r129, Boolean r130, List<Urgent> r131, String r132, Integer r133, Boolean r134, Boolean r135, String r136, Boolean r137, String r138, com.bytedance.lark.pb.basic.v1.Message.Type r139, Content.SystemType r140, CardContent.Type r141, Boolean r142, Boolean r143, String r144, Boolean r145, Chat.Role r146, Icon r147, Boolean r148, Boolean r149, Integer r150, UrgentInfo r151, Integer r152, List<Chatter.ChatterCustomStatus> r153, FocusInfo r154, HighPriorityDisplay r155, AvatarMedal r156, Chat.ChatDisplayModeSetting.Enum r157, Integer r158, Boolean r159, Boolean r160, Boolean r161, Integer r162, Boolean r163, ChatUserAutoMuteSetting.NoticeType r164, AIKnowledgeQueryStatus r165, Long r166, Boolean r167, Boolean r168, Boolean r169, Boolean r170, Integer r171, Boolean r172, Boolean r173, Integer r174, Integer r175, Boolean r176, VideoChatContent.Type r177, Boolean r178, Boolean r179, Boolean r180, Item r181, String r182, TeamChatType r183, Boolean r184, Boolean r185, Long r186, Digest r187, Boolean r188, Boolean r189, Digest r190, Long r191, List<Item> r192, List<ChatTeamInfo> r193, Map<Long, Team> r194, List<ChatTeamInfo> r195, Boolean r196, Integer r197, Integer r198, Boolean r199, NotMemberType r200, List<Tag> r201, TagData r202, Long r203, String r204, String r205, Long r206, Boolean r207, String r208) {
        this(r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, ByteString.EMPTY);
    }

    public ChatData(String r100, String r101, String r102, List<String> r103, Integer r104, Boolean r105, Boolean r110, DraftPreview r111, AtInfo r112, List<AtInfo> r113, String r114, EntityStatus r115, Long r116, Long r117, Boolean r118, List<com.bytedance.lark.pb.basic.v1.Message.Reaction> r119, Long r210, String r211, String r212, Chat.Type r213, Chatter.Type r214, String r215, Boolean r216, Chat.ChatMode r217, Boolean r218, List<Urgent> r219, String r310, Integer r311, Boolean r312, Boolean r313, String r314, Boolean r315, String r316, com.bytedance.lark.pb.basic.v1.Message.Type r317, Content.SystemType r318, CardContent.Type r319, Boolean r410, Boolean r411, String r412, Boolean r413, Chat.Role r414, Icon r415, Boolean r416, Boolean r417, Integer r418, UrgentInfo r419, Integer r510, List<Chatter.ChatterCustomStatus> r511, FocusInfo r512, HighPriorityDisplay r513, AvatarMedal r514, Chat.ChatDisplayModeSetting.Enum r515, Integer r516, Boolean r517, Boolean r518, Boolean r519, Integer r610, Boolean r611, ChatUserAutoMuteSetting.NoticeType r612, AIKnowledgeQueryStatus r613, Long r614, Boolean r615, Boolean r616, Boolean r617, Boolean r618, Integer r619, Boolean r710, Boolean r711, Integer r712, Integer r713, Boolean r714, VideoChatContent.Type r715, Boolean r716, Boolean r717, Boolean r718, Item r719, String r810, TeamChatType r811, Boolean r812, Boolean r813, Long r814, Digest r815, Boolean r816, Boolean r817, Digest r818, Long r819, List<Item> r910, List<ChatTeamInfo> r911, Map<Long, Team> r912, List<ChatTeamInfo> r913, Boolean r914, Integer r915, Integer r916, Boolean r917, NotMemberType r918, List<Tag> r919, TagData r106, Long r107, String r108, String r109, Long r1010, Boolean r1011, String r1012, ByteString r1013) {
        super(ADAPTER, r1013);
        this.name = r100;
        this.avatar_key = r101;
        this.avatar_path = r102;
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r103);
        this.unread_count = r104;
        this.is_remind = r105;
        this.is_shortcut = r110;
        this.draft_preview = r111;
        this.at_info = r112;
        this.at_infos = Internal.immutableCopyOf("at_infos", r113);
        this.localized_digest_message = r114;
        this.entity_status = r115;
        this.display_time = r116;
        this.rank_time = r117;
        this.cross_tenant = r118;
        this.reactions = Internal.immutableCopyOf("reactions", r119);
        this.do_not_disturb_end_time = r210;
        this.mini_avatar_key = r211;
        this.original_digest_message = r212;
        this.chat_type = r213;
        this.chatter_type = r214;
        this.chatter_id = r215;
        this.is_crypto = r216;
        this.chat_mode = r217;
        this.is_meeting = r218;
        this.urgents = Internal.immutableCopyOf("urgents", r219);
        this.with_bot_tag = r310;
        this.last_message_position = r311;
        this.is_department = r312;
        this.tenant_chat = r313;
        this.chat_description = r314;
        this.is_support_view = r315;
        this.oncall_id = r316;
        this.last_message_type = r317;
        this.system_message_type = r318;
        this.card_type = r319;
        this.is_public_v2 = r410;
        this.is_member = r411;
        this.last_visible_message_id = r412;
        this.chat_muteable = r413;
        this.chat_role = r414;
        this.icon = r415;
        this.is_edu = r416;
        this.is_cross_with_ka = r417;
        this.user_count = r418;
        this.urgent_info = r419;
        this.at_infos_count = r510;
        this.chatter_status = Internal.immutableCopyOf("chatter_status", r511);
        this.focus_info = r512;
        this.display = r513;
        this.avatar_medal = r514;
        this.chat_display_mode_setting = r515;
        this.last_visible_message_position = r516;
        this.is_frozen = r517;
        this.is_p2p_ai = r518;
        this.is_p2p_official_bot_ai = r519;
        this.chatter_apply_count = r610;
        this.last_has_ai_reply = r611;
        this.notice_type = r612;
        this.query_status = r613;
        this.query_id = r614;
        this.digest_is_query = r615;
        this.is_red_badge = r616;
        this.is_official_oncall = r617;
        this.is_offline_oncall = r618;
        this.chat_readable = r619;
        this.is_stranger = r710;
        this.is_blocked = r711;
        this.can_set_stranger = r712;
        this.bot_ext_type = r713;
        this.is_agent = r714;
        this.video_chat_type = r715;
        this.is_voice_call = r716;
        this.is_my_threads_updated = r717;
        this.is_super = r718;
        this.item = r719;
        this.team_name = r810;
        this.team_chat_type = r811;
        this.is_chat_owner = r812;
        this.is_chat_admin = r813;
        this.team_id = r814;
        this.digest = r815;
        this.is_private_mode = r816;
        this.muted_bot_p2p = r817;
        this.last_at_digest = r818;
        this.last_at_rank_time = r819;
        this.items = Internal.immutableCopyOf("items", r910);
        this.joined_team_infos = Internal.immutableCopyOf("joined_team_infos", r911);
        this.joined_teams = Internal.immutableCopyOf("joined_teams", r912);
        this.bound_team_infos = Internal.immutableCopyOf("bound_team_infos", r913);
        this.is_special_focus = r914;
        this.read_position = r915;
        this.latest_read_timestamp = r916;
        this.is_user_count_visible = r917;
        this.not_member_type = r918;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r919);
        this.tag_info = r106;
        this.last_message_send_user_id = r107;
        this.last_message_send_user_name = r108;
        this.last_message_send_user_avatar_key = r109;
        this.last_message_fold_id = r1010;
        this.last_message_is_fold = r1011;
        this.video_chat_meeting_card_meeting_id = r1012;
    }
}
