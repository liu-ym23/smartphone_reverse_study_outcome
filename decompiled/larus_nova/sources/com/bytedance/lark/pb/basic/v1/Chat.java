package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Chat extends com.squareup.wire.Message<Chat, Builder> {
    public static final ProtoAdapter<Chat> ADAPTER = null;
    public static final AddMemberApply.Enum DEFAULT_ADD_MEMBER_APPLY = null;
    public static final AddMemberPermission.Enum DEFAULT_ADD_MEMBER_PERMISSION = null;
    public static final AdminPostSetting.Enum DEFAULT_ADMIN_POST_SETTING = null;
    public static final Long DEFAULT_AI_KNOWLEDGE_QUERY_ID = null;
    public static final Boolean DEFAULT_ALLOW_POST = null;
    public static final String DEFAULT_ANONYMOUS_ID = "";
    public static final AnonymousSetting.Enum DEFAULT_ANONYMOUS_SETTING = null;
    public static final Long DEFAULT_ANONYMOUS_TOTAL_QUOTA = null;
    public static final AtAllPermission.Enum DEFAULT_AT_ALL_PERMISSION = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_BOX_ID = "";
    public static final Integer DEFAULT_BURN_LIFE = null;
    public static final Boolean DEFAULT_CAN_BE_SORTED_ALPHABETICALLY = null;
    public static final Boolean DEFAULT_CAN_TRANSLATE_NAME = null;
    public static final Boolean DEFAULT_CHATABLE = null;
    public static final Integer DEFAULT_CHATTER_COUNT = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final ChatDisplayModeSetting.Enum DEFAULT_CHAT_DISPLAY_MODE_SETTING = null;
    public static final ChatMode DEFAULT_CHAT_MODE = null;
    public static final ChatPinPermissionSetting.Enum DEFAULT_CHAT_PIN_PERMISSION_SETTING = null;
    public static final ChatTabPermissionSetting.Enum DEFAULT_CHAT_TAB_PERMISSION_SETTING = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final CreateUrgentSetting.Enum DEFAULT_CREATE_URGENT_SETTING = null;
    public static final CreateVideoConferenceSetting.Enum DEFAULT_CREATE_VIDEO_CONFERENCE_SETTING = null;
    public static final DefDisplaySetting.Enum DEFAULT_DEF_DISPLAY_SETTING = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EDIT_MESSAGE_DRAFT_ID = "";
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final Integer DEFAULT_FIRST_CHAT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_FIRST_MESSAGE_POSITION = null;
    public static final Boolean DEFAULT_HAS_VC_CHAT_PERMISSION = null;
    public static final Boolean DEFAULT_HAS_WATER_MARK = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ADMIN = null;
    public static final Boolean DEFAULT_IS_ARCHIVED = null;
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATE = null;
    public static final Boolean DEFAULT_IS_AUTO_TYPING_TRANSLATE = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_CUSTOMER_SERVICE = null;
    public static final Boolean DEFAULT_IS_CUSTOM_ICON = null;
    public static final Boolean DEFAULT_IS_DELAYED = null;
    public static final Boolean DEFAULT_IS_DELETED = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_DISSOLVED = null;
    public static final Boolean DEFAULT_IS_EDU = null;
    public static final Boolean DEFAULT_IS_FAKE = null;
    public static final Boolean DEFAULT_IS_FLAG = null;
    public static final Boolean DEFAULT_IS_FROZEN = null;
    public static final Boolean DEFAULT_IS_IN_BOX = null;
    public static final Boolean DEFAULT_IS_MEETING = null;
    public static final Boolean DEFAULT_IS_MUTE_AT_ALL = null;
    public static final Boolean DEFAULT_IS_OCIC_CUSTOMER_SERVICE = null;
    public static final Boolean DEFAULT_IS_OFFICIAL_ONCALL = null;
    public static final Boolean DEFAULT_IS_OFFLINE_ONCALL = null;
    public static final Boolean DEFAULT_IS_P2P_AI = null;
    public static final Boolean DEFAULT_IS_P2P_OFFICIAL_BOT_AI = null;
    public static final Boolean DEFAULT_IS_PRIVATE_MODE = null;
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Boolean DEFAULT_IS_PUBLIC_V2 = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final Boolean DEFAULT_IS_SUPER = null;
    public static final Boolean DEFAULT_IS_SUPPORT_VIEW = null;
    public static final Boolean DEFAULT_IS_TEAM = null;
    public static final Boolean DEFAULT_IS_TEMP_TOP_FEED = null;
    public static final Boolean DEFAULT_IS_TENANT = null;
    public static final Boolean DEFAULT_IS_USER_COUNT_VISIBLE = null;
    public static final SystemMessageVisible.Enum DEFAULT_JOIN_MESSAGE_VISIBLE = null;
    public static final String DEFAULT_LAST_DRAFT_ID = "";
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = null;
    public static final Float DEFAULT_LAST_READ_OFFSET = null;
    public static final Integer DEFAULT_LAST_READ_POSITION = null;
    public static final String DEFAULT_LAST_THREAD_ID = "";
    public static final Integer DEFAULT_LAST_THREAD_POSITION = null;
    public static final Integer DEFAULT_LAST_THREAD_POSITION_BADGE_COUNT = null;
    public static final String DEFAULT_LAST_VISIBLE_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = null;
    public static final String DEFAULT_LAST_VISIBLE_THREAD_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_THREAD_POSITION = null;
    public static final MessagePosition.Enum DEFAULT_MESSAGE_POSITION = null;
    public static final MessageVisibilitySetting.Enum DEFAULT_MESSAGE_VISIBILITY_SETTING = null;
    public static final String DEFAULT_MINI_AVATAR_KEY = "";
    public static final Boolean DEFAULT_MUTEABLE = null;
    public static final String DEFAULT_MY_THREADS_LAST_DISPLAY_MESSAGE_ID = "";
    public static final Long DEFAULT_MY_THREADS_LAST_TIMESTAMP = null;
    public static final Long DEFAULT_MY_THREADS_READ_TIMESTAMP = null;
    public static final Integer DEFAULT_MY_THREADS_UNREAD_COUNT = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_MAJOR_LANGUAGE = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_NAME_TRANSLATE_LANGUAGE = "";
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NEW_THREAD_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_THREAD_COUNT = null;
    public static final Boolean DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = null;
    public static final String DEFAULT_ONCALL_ID = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final PinPermissionSetting.Enum DEFAULT_PIN_PERMISSION_SETTING = null;
    public static final String DEFAULT_POST_DRAFT_ID = "";
    public static final PostType DEFAULT_POST_TYPE = null;
    public static final Integer DEFAULT_PUT_CHATTER_APPLY_COUNT = null;
    public static final Long DEFAULT_QUERY_CREATE_TIME = null;
    public static final Integer DEFAULT_QUERY_SEQ_ID = null;
    public static final CommonAIReply.Status DEFAULT_QUERY_STATUS = null;
    public static final SystemMessageVisible.Enum DEFAULT_QUIT_MESSAGE_VISIBLE = null;
    public static final Integer DEFAULT_READ_POSITION = null;
    public static final Integer DEFAULT_READ_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION_BADGE_COUNT = null;
    public static final Role DEFAULT_ROLE = null;
    public static final String DEFAULT_SCHEDULE_MESSAGE_DRAFT_ID = "";
    public static final ShareCardPermission.Enum DEFAULT_SHARE_CARD_PERMISSION = null;
    public static final Boolean DEFAULT_SHOULD_DISPLAY_TRANSLATED_NAME = null;
    public static final Boolean DEFAULT_SHOW_BANNER = null;
    public static final Boolean DEFAULT_SHOW_NICKNAME = null;
    public static final String DEFAULT_SIDEBAR_ID = "";
    public static final TeamChatType DEFAULT_TEAM_CHAT_TYPE = null;
    public static final Long DEFAULT_TEAM_ID = null;
    public static final String DEFAULT_TEAM_NAME = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_TEXT_DRAFT_ID = "";
    public static final Long DEFAULT_THEME_ID = null;
    public static final TopNoticePermissionSetting.Enum DEFAULT_TOP_NOTICE_PERMISSION_SETTING = null;
    public static final String DEFAULT_TRANSLATED_NAME = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Boolean DEFAULT_TYPING_TRANSLATE_HAS_AUTO_OPENED = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Integer DEFAULT_USER_COUNT = null;
    public static final UserCountVisibleSetting.Enum DEFAULT_USER_COUNT_VISIBLE_SETTING = null;
    private static final long serialVersionUID = 0;
    public final AddMemberApply.Enum add_member_apply;
    public final AddMemberPermission.Enum add_member_permission;
    public final AdminPostSetting.Enum admin_post_setting;
    public final Long ai_knowledge_query_id;
    public final Boolean allow_post;
    public final Announcement announcement;
    public final String anonymous_id;
    public final AnonymousSetting.Enum anonymous_setting;
    public final Long anonymous_total_quota;
    public final AtAllPermission.Enum at_all_permission;
    public final Image avatar;
    public final String avatar_key;
    public final String avatar_path;
    public final List<String> avatar_urls;
    public final BannerSetting banner_setting;
    public final List<ChatTeamInfo> bound_team_infos;
    public final String box_id;
    public final Integer burn_life;
    public final Boolean can_be_sorted_alphabetically;
    public final Boolean can_translate_name;
    public final ChatDisplayModeSetting.Enum chat_display_mode_setting;
    public final ChatMode chat_mode;
    public final ChatPinPermissionSetting.Enum chat_pin_permission_setting;
    public final ChatTabPermissionSetting.Enum chat_tab_permission_setting;
    public final Boolean chatable;
    public final Integer chatter_count;
    public final Map<Integer, Integer> chatter_extra_states;
    public final String chatter_id;
    public final Long create_time;
    public final CreateUrgentSetting.Enum create_urgent_setting;
    public final CreateVideoConferenceSetting.Enum create_video_conference_setting;
    public final DefDisplaySetting.Enum def_display_setting;
    public final String description;
    public final DoubaoSetting doubao_setting;
    public final String edit_message_draft_id;
    public final List<FeedTag> feed_tag;
    public final FeedCard.FeedType feed_type;
    public final Integer first_chat_message_position;
    public final Integer first_message_position;
    public final Boolean has_vc_chat_permission;
    public final Boolean has_water_mark;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253445id;
    public final Boolean is_admin;
    public final Boolean is_archived;
    public final Boolean is_auto_translate;
    public final Boolean is_auto_typing_translate;
    public final Boolean is_cross_tenant;
    public final Boolean is_cross_with_ka;
    public final Boolean is_crypto;
    public final Boolean is_custom_icon;
    public final Boolean is_customer_service;
    public final Boolean is_delayed;
    public final Boolean is_deleted;
    public final Boolean is_department;
    public final Boolean is_dissolved;
    public final Boolean is_edu;
    public final Boolean is_fake;
    public final Boolean is_flag;
    public final Boolean is_frozen;
    public final Boolean is_in_box;
    public final Boolean is_meeting;
    public final Boolean is_mute_at_all;
    public final Boolean is_ocic_customer_service;
    public final Boolean is_official_oncall;
    public final Boolean is_offline_oncall;
    public final Boolean is_p2p_ai;
    public final Boolean is_p2p_official_bot_ai;
    public final Boolean is_private_mode;
    public final Boolean is_public;
    public final Boolean is_public_v2;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final Boolean is_super;
    public final Boolean is_support_view;
    public final Boolean is_team;
    public final Boolean is_temp_top_feed;
    public final Boolean is_tenant;
    public final Boolean is_user_count_visible;
    public final SystemMessageVisible.Enum join_message_visible;
    public final List<ChatTeamInfo> joined_team_infos;
    public final Map<Long, Team> joined_teams;
    public final String last_draft_id;
    public final String last_message_id;
    public final Integer last_message_position;
    public final Integer last_message_position_badge_count;
    public final Float last_read_offset;
    public final Integer last_read_position;
    public final String last_thread_id;
    public final Integer last_thread_position;
    public final Integer last_thread_position_badge_count;
    public final String last_visible_message_id;
    public final Integer last_visible_message_position;
    public final String last_visible_thread_id;
    public final Integer last_visible_thread_position;
    public final MessagePosition.Enum message_position;
    public final MessageVisibilitySetting.Enum message_visibility_setting;
    public final String mini_avatar_key;
    public final Boolean muteable;
    public final String my_threads_last_display_message_id;
    public final Long my_threads_last_timestamp;
    public final Long my_threads_read_timestamp;
    public final Integer my_threads_unread_count;
    public final String name;
    public final String name_major_language;
    public final String name_pinyin;
    public final String name_translate_language;
    public final Integer new_message_count;
    public final Integer new_thread_count;
    public final Integer no_badged_new_message_count;
    public final Integer no_badged_new_thread_count;
    public final Boolean off_edit_group_chat_info;
    public final String oncall_id;
    public final String owner_id;
    public final PinPermissionSetting.Enum pin_permission_setting;
    public final String post_draft_id;
    public final PostType post_type;
    public final Integer put_chatter_apply_count;
    public final Long query_create_time;
    public final Integer query_seq_id;
    public final CommonAIReply.Status query_status;
    public final SystemMessageVisible.Enum quit_message_visible;
    public final Integer read_position;
    public final Integer read_position_badge_count;
    public final Integer read_thread_position;
    public final Integer read_thread_position_badge_count;
    public final RestrictedModeSetting restricted_mode_setting;
    public final Role role;
    public final String schedule_message_draft_id;
    public final ShareCardPermission.Enum share_card_permission;
    public final Boolean should_display_translated_name;
    public final Boolean show_banner;
    public final Boolean show_nickname;
    public final List<SideBarButton> sidebar_buttons;
    public final String sidebar_id;
    public final TagData tag_info;
    public final List<Tag> tags;
    public final TeamChatType team_chat_type;
    public final Long team_id;
    public final String team_name;
    public final String tenant_id;
    public final String text_draft_id;
    public final Long theme_id;
    public final TnsInfo tns_info;
    public final TopNoticePermissionSetting.Enum top_notice_permission_setting;
    public final String translated_name;
    public final Type type;
    public final Boolean typing_translate_has_auto_opened;
    public final TypingTranslateSetting typing_translate_setting;
    public final Long update_time;
    public final ChatUserAutoMuteSetting user_auto_mute;
    public final Integer user_count;
    public final UserCountVisibleSetting.Enum user_count_visible_setting;

    public Chat(String r155, Type r156, String r157, String r158, Integer r159, Integer r160, Long r161, String r162, String r163, Long r164, String r165, Image r166, String r167, Integer r168, Integer r169, Boolean r170, Boolean r171, Boolean r172, Boolean r173, Boolean r174, String r175, Role r176, Boolean r177, String r178, String r179, Integer r180, Boolean r181, Announcement r182, Boolean r183, String r184, Boolean r185, Boolean r186, MessagePosition.Enum r187, FeedCard.FeedType r188, String r189, Integer r190, Boolean r191, Boolean r192, Boolean r193, Boolean r194, Integer r195, String r196, Integer r197, Integer r198, Integer r199, Integer r200, Boolean r201, Boolean r202, PostType r203, ChatMode r204, String r205, Integer r206, Integer r207, Integer r208, Integer r209, Integer r210, Integer r211, Integer r212, String r213, Boolean r214, String r215, Integer r216, Float r217, Boolean r218, Boolean r219, Boolean r220, Boolean r221, Boolean r222, Boolean r223, Boolean r224, Boolean r225, AddMemberPermission.Enum r226, AtAllPermission.Enum r227, SystemMessageVisible.Enum r228, SystemMessageVisible.Enum r229, ShareCardPermission.Enum r230, AddMemberApply.Enum r231, MessageVisibilitySetting.Enum r232, CreateUrgentSetting.Enum r233, CreateVideoConferenceSetting.Enum r234, PinPermissionSetting.Enum r235, TopNoticePermissionSetting.Enum r236, ChatTabPermissionSetting.Enum r237, ChatDisplayModeSetting.Enum r238, ChatPinPermissionSetting.Enum r239, Integer r240, Boolean r241, String r242, String r243, List<SideBarButton> r244, Long r245, Long r246, Integer r247, String r248, AnonymousSetting.Enum r249, Long r250, Boolean r251, String r252, Boolean r253, Long r254, String r255, TeamChatType r256, Map<Integer, Integer> r257, List<ChatTeamInfo> r258, Map<Long, Team> r259, List<ChatTeamInfo> r260, ChatUserAutoMuteSetting r261, Long r262, Long r263, CommonAIReply.Status r264, Integer r265, String r266, Boolean r267, Boolean r268, Boolean r269, Boolean r270, Boolean r271, Boolean r272, String r273, Boolean r274, Boolean r275, TypingTranslateSetting r276, List<FeedTag> r277, Boolean r278, Boolean r279, String r280, List<String> r281, Integer r282, TagData r283, Boolean r284, Boolean r285, Boolean r286, Boolean r287, RestrictedModeSetting r288, DefDisplaySetting.Enum r289, String r290, Boolean r291, AdminPostSetting.Enum r292, Boolean r293, UserCountVisibleSetting.Enum r294, Boolean r295, DoubaoSetting r296, List<Tag> r297, Long r298, Boolean r299, BannerSetting r300, Boolean r301, Boolean r302, String r303, String r304, String r305, TnsInfo r306) {
        this(r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250, r251, r252, r253, r254, r255, r256, r257, r258, r259, r260, r261, r262, r263, r264, r265, r266, r267, r268, r269, r270, r271, r272, r273, r274, r275, r276, r277, r278, r279, r280, r281, r282, r283, r284, r285, r286, r287, r288, r289, r290, r291, r292, r293, r294, r295, r296, r297, r298, r299, r300, r301, r302, r303, r304, r305, r306, ByteString.EMPTY);
    }

    public Chat(String r100, Type r101, String r102, String r103, Integer r104, Integer r105, Long r110, String r111, String r112, Long r113, String r114, Image r115, String r116, Integer r117, Integer r118, Boolean r119, Boolean r210, Boolean r211, Boolean r212, Boolean r213, String r214, Role r215, Boolean r216, String r217, String r218, Integer r219, Boolean r310, Announcement r311, Boolean r312, String r313, Boolean r314, Boolean r315, MessagePosition.Enum r316, FeedCard.FeedType r317, String r318, Integer r319, Boolean r410, Boolean r411, Boolean r412, Boolean r413, Integer r414, String r415, Integer r416, Integer r417, Integer r418, Integer r419, Boolean r510, Boolean r511, PostType r512, ChatMode r513, String r514, Integer r515, Integer r516, Integer r517, Integer r518, Integer r519, Integer r610, Integer r611, String r612, Boolean r613, String r614, Integer r615, Float r616, Boolean r617, Boolean r618, Boolean r619, Boolean r710, Boolean r711, Boolean r712, Boolean r713, Boolean r714, AddMemberPermission.Enum r715, AtAllPermission.Enum r716, SystemMessageVisible.Enum r717, SystemMessageVisible.Enum r718, ShareCardPermission.Enum r719, AddMemberApply.Enum r810, MessageVisibilitySetting.Enum r811, CreateUrgentSetting.Enum r812, CreateVideoConferenceSetting.Enum r813, PinPermissionSetting.Enum r814, TopNoticePermissionSetting.Enum r815, ChatTabPermissionSetting.Enum r816, ChatDisplayModeSetting.Enum r817, ChatPinPermissionSetting.Enum r818, Integer r819, Boolean r910, String r911, String r912, List<SideBarButton> r913, Long r914, Long r915, Integer r916, String r917, AnonymousSetting.Enum r918, Long r919, Boolean r106, String r107, Boolean r108, Long r109, String r1010, TeamChatType r1011, Map<Integer, Integer> r1012, List<ChatTeamInfo> r1013, Map<Long, Team> r1014, List<ChatTeamInfo> r1015, ChatUserAutoMuteSetting r1110, Long r1111, Long r1112, CommonAIReply.Status r1113, Integer r1114, String r1115, Boolean r1116, Boolean r1117, Boolean r1118, Boolean r1119, Boolean r120, Boolean r121, String r122, Boolean r123, Boolean r124, TypingTranslateSetting r125, List<FeedTag> r126, Boolean r127, Boolean r128, String r129, List<String> r130, Integer r131, TagData r132, Boolean r133, Boolean r134, Boolean r135, Boolean r136, RestrictedModeSetting r137, DefDisplaySetting.Enum r138, String r139, Boolean r140, AdminPostSetting.Enum r141, Boolean r142, UserCountVisibleSetting.Enum r143, Boolean r144, DoubaoSetting r145, List<Tag> r146, Long r147, Boolean r148, BannerSetting r149, Boolean r150, Boolean r151, String r152, String r153, String r154, TnsInfo r155, ByteString r156) {
        super(ADAPTER, r156);
        this.f253445id = r100;
        this.type = r101;
        this.name = r102;
        this.last_message_id = r103;
        this.last_message_position = r104;
        this.new_message_count = r105;
        this.update_time = r110;
        this.avatar_key = r111;
        this.chatter_id = r112;
        this.create_time = r113;
        this.description = r114;
        this.avatar = r115;
        this.owner_id = r116;
        this.chatter_count = r117;
        this.user_count = r118;
        this.is_department = r119;
        this.is_public = r210;
        this.is_archived = r211;
        this.is_deleted = r212;
        this.is_remind = r213;
        this.name_pinyin = r214;
        this.role = r215;
        this.is_customer_service = r216;
        this.text_draft_id = r217;
        this.post_draft_id = r218;
        this.no_badged_new_message_count = r219;
        this.is_shortcut = r310;
        this.announcement = r311;
        this.off_edit_group_chat_info = r312;
        this.tenant_id = r313;
        this.is_custom_icon = r314;
        this.is_dissolved = r315;
        this.message_position = r316;
        this.feed_type = r317;
        this.last_visible_message_id = r318;
        this.burn_life = r319;
        this.is_crypto = r410;
        this.is_meeting = r411;
        this.is_cross_tenant = r412;
        this.is_support_view = r413;
        this.first_message_position = r414;
        this.oncall_id = r415;
        this.last_visible_message_position = r416;
        this.read_position = r417;
        this.read_position_badge_count = r418;
        this.last_message_position_badge_count = r419;
        this.is_public_v2 = r510;
        this.allow_post = r511;
        this.post_type = r512;
        this.chat_mode = r513;
        this.last_thread_id = r514;
        this.last_thread_position = r515;
        this.new_thread_count = r516;
        this.no_badged_new_thread_count = r517;
        this.last_thread_position_badge_count = r518;
        this.read_thread_position = r519;
        this.read_thread_position_badge_count = r610;
        this.last_visible_thread_position = r611;
        this.last_visible_thread_id = r612;
        this.show_nickname = r613;
        this.last_draft_id = r614;
        this.last_read_position = r615;
        this.last_read_offset = r616;
        this.is_edu = r617;
        this.is_admin = r618;
        this.is_mute_at_all = r619;
        this.is_delayed = r710;
        this.is_p2p_ai = r711;
        this.is_ocic_customer_service = r712;
        this.is_p2p_official_bot_ai = r713;
        this.is_temp_top_feed = r714;
        this.add_member_permission = r715;
        this.at_all_permission = r716;
        this.join_message_visible = r717;
        this.quit_message_visible = r718;
        this.share_card_permission = r719;
        this.add_member_apply = r810;
        this.message_visibility_setting = r811;
        this.create_urgent_setting = r812;
        this.create_video_conference_setting = r813;
        this.pin_permission_setting = r814;
        this.top_notice_permission_setting = r815;
        this.chat_tab_permission_setting = r816;
        this.chat_display_mode_setting = r817;
        this.chat_pin_permission_setting = r818;
        this.put_chatter_apply_count = r819;
        this.show_banner = r910;
        this.mini_avatar_key = r911;
        this.sidebar_id = r912;
        this.sidebar_buttons = Internal.immutableCopyOf("sidebar_buttons", r913);
        this.my_threads_read_timestamp = r914;
        this.my_threads_last_timestamp = r915;
        this.my_threads_unread_count = r916;
        this.my_threads_last_display_message_id = r917;
        this.anonymous_setting = r918;
        this.anonymous_total_quota = r919;
        this.is_cross_with_ka = r106;
        this.anonymous_id = r107;
        this.is_team = r108;
        this.team_id = r109;
        this.team_name = r1010;
        this.team_chat_type = r1011;
        this.chatter_extra_states = Internal.immutableCopyOf("chatter_extra_states", r1012);
        this.joined_team_infos = Internal.immutableCopyOf("joined_team_infos", r1013);
        this.joined_teams = Internal.immutableCopyOf("joined_teams", r1014);
        this.bound_team_infos = Internal.immutableCopyOf("bound_team_infos", r1015);
        this.user_auto_mute = r1110;
        this.ai_knowledge_query_id = r1111;
        this.query_create_time = r1112;
        this.query_status = r1113;
        this.query_seq_id = r1114;
        this.edit_message_draft_id = r1115;
        this.chatable = r1116;
        this.muteable = r1117;
        this.is_super = r1118;
        this.is_private_mode = r1119;
        this.is_tenant = r120;
        this.is_in_box = r121;
        this.box_id = r122;
        this.is_auto_translate = r123;
        this.is_auto_typing_translate = r124;
        this.typing_translate_setting = r125;
        this.feed_tag = Internal.immutableCopyOf("feed_tag", r126);
        this.is_flag = r127;
        this.has_water_mark = r128;
        this.avatar_path = r129;
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r130);
        this.first_chat_message_position = r131;
        this.tag_info = r132;
        this.is_fake = r133;
        this.typing_translate_has_auto_opened = r134;
        this.is_official_oncall = r135;
        this.is_offline_oncall = r136;
        this.restricted_mode_setting = r137;
        this.def_display_setting = r138;
        this.schedule_message_draft_id = r139;
        this.has_vc_chat_permission = r140;
        this.admin_post_setting = r141;
        this.can_be_sorted_alphabetically = r142;
        this.user_count_visible_setting = r143;
        this.is_user_count_visible = r144;
        this.doubao_setting = r145;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r146);
        this.theme_id = r147;
        this.is_frozen = r148;
        this.banner_setting = r149;
        this.can_translate_name = r150;
        this.should_display_translated_name = r151;
        this.translated_name = r152;
        this.name_major_language = r153;
        this.name_translate_language = r154;
        this.tns_info = r155;
    }

    public static final class AddMemberApply extends com.squareup.wire.Message<AddMemberApply, Builder> {
        public static final ProtoAdapter<AddMemberApply> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberApply, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddMemberApply build() {
                return new AddMemberApply(super.buildUnknownFields());
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

        public static final class ProtoAdapter_AddMemberApply extends ProtoAdapter<AddMemberApply> {
            public ProtoAdapter_AddMemberApply() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberApply.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddMemberApply decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AddMemberApply r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddMemberApply decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddMemberApply r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddMemberApply r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddMemberApply r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberApply();
        }

        public AddMemberApply() {
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
            return AddMemberApply.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddMemberApply(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AddMemberPermission extends com.squareup.wire.Message<AddMemberPermission, Builder> {
        public static final ProtoAdapter<AddMemberPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddMemberPermission build() {
                return new AddMemberPermission(super.buildUnknownFields());
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

        public static final class ProtoAdapter_AddMemberPermission extends ProtoAdapter<AddMemberPermission> {
            public ProtoAdapter_AddMemberPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddMemberPermission decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AddMemberPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddMemberPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddMemberPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddMemberPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddMemberPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberPermission();
        }

        public AddMemberPermission() {
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
            return AddMemberPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddMemberPermission(ByteString r100) {
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

    public static final class Announcement extends com.squareup.wire.Message<Announcement, Builder> {
        public static final ProtoAdapter<Announcement> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_DOC_URL = "";
        public static final Boolean DEFAULT_ENABLE_OPEN_DOC = null;
        public static final String DEFAULT_LAST_EDITOR_ID = "";
        public static final Long DEFAULT_UPDATE_TIME = null;
        public static final Boolean DEFAULT_USE_OPENDOC = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final String doc_url;
        public final Boolean enable_open_doc;
        public final String last_editor_id;
        public final Long update_time;
        public final Boolean use_opendoc;

        public static final class Builder extends com.squareup.wire.Message.Builder<Announcement, Builder> {
            public String content;
            public String doc_url;
            public Boolean enable_open_doc;
            public String last_editor_id;
            public Long update_time;
            public Boolean use_opendoc;

            @Override // com.squareup.wire.Message.Builder
            public Announcement build() {
                return new Announcement(this.content, this.update_time, this.last_editor_id, this.doc_url, this.enable_open_doc, this.use_opendoc, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder doc_url(String r100) {
                this.doc_url = r100;
                return this;
            }

            public Builder enable_open_doc(Boolean r100) {
                this.enable_open_doc = r100;
                return this;
            }

            public Builder last_editor_id(String r100) {
                this.last_editor_id = r100;
                return this;
            }

            public Builder update_time(Long r100) {
                this.update_time = r100;
                return this;
            }

            public Builder use_opendoc(Boolean r100) {
                this.use_opendoc = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Announcement extends ProtoAdapter<Announcement> {
            public ProtoAdapter_Announcement() {
                super(FieldEncoding.LENGTH_DELIMITED, Announcement.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Announcement decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.update_time = 0L;
                r101.last_editor_id = "";
                r101.doc_url = "";
                r101.enable_open_doc = Boolean.FALSE;
                r101.use_opendoc = Boolean.TRUE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L13;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.use_opendoc = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.enable_open_doc = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.doc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.last_editor_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.update_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Announcement r100) {
                String r101 = r100.content;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.update_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.last_editor_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.doc_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.enable_open_doc;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.use_opendoc;
                if (r116 == null) goto L26;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Announcement decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Announcement r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Announcement r101) throws IOException {
                String r102 = r101.content;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.update_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.last_editor_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.doc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.enable_open_doc;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.use_opendoc;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Announcement r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Announcement();
            DEFAULT_UPDATE_TIME = 0L;
            DEFAULT_ENABLE_OPEN_DOC = Boolean.FALSE;
            DEFAULT_USE_OPENDOC = Boolean.TRUE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.update_time = this.update_time;
            r100.last_editor_id = this.last_editor_id;
            r100.doc_url = this.doc_url;
            r100.enable_open_doc = this.enable_open_doc;
            r100.use_opendoc = this.use_opendoc;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Announcement.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Announcement(String r100, Long r110, String r111, String r112, Boolean r113, Boolean r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public Announcement(String r100, Long r101, String r102, String r103, Boolean r104, Boolean r105, ByteString r106) {
            super(ADAPTER, r106);
            this.content = r100;
            this.update_time = r101;
            this.last_editor_id = r102;
            this.doc_url = r103;
            this.enable_open_doc = r104;
            this.use_opendoc = r105;
        }
    }

    public static final class AnonymousSetting extends com.squareup.wire.Message<AnonymousSetting, Builder> {
        public static final ProtoAdapter<AnonymousSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnonymousSetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AnonymousSetting build() {
                return new AnonymousSetting(super.buildUnknownFields());
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
            public static final Enum INVISIBLE_ALLOWED = null;
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
                Enum r104 = new Enum("INVISIBLE_ALLOWED", 4, 100);
                INVISIBLE_ALLOWED = r104;
                $VALUES = new Enum[]{r100, r101, r102, r103, r104};
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
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 100) goto L14;
                return null;
            L14:
                return INVISIBLE_ALLOWED;
            L16:
                return ALLOWED;
            L18:
                return NOT_ALLOWED;
            L20:
                return INVISIBLE;
            L22:
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

        public static final class ProtoAdapter_AnonymousSetting extends ProtoAdapter<AnonymousSetting> {
            public ProtoAdapter_AnonymousSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AnonymousSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnonymousSetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AnonymousSetting r100) {
                return r100.unknownFields().size();
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
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AnonymousSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnonymousSetting();
        }

        public AnonymousSetting() {
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
            return AnonymousSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AnonymousSetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AtAllPermission extends com.squareup.wire.Message<AtAllPermission, Builder> {
        public static final ProtoAdapter<AtAllPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtAllPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AtAllPermission build() {
                return new AtAllPermission(super.buildUnknownFields());
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

        public static final class ProtoAdapter_AtAllPermission extends ProtoAdapter<AtAllPermission> {
            public ProtoAdapter_AtAllPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, AtAllPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AtAllPermission decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(AtAllPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AtAllPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AtAllPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AtAllPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AtAllPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtAllPermission();
        }

        public AtAllPermission() {
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
            return AtAllPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AtAllPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Chat, Builder> {
        public AddMemberApply.Enum add_member_apply;
        public AddMemberPermission.Enum add_member_permission;
        public AdminPostSetting.Enum admin_post_setting;
        public Long ai_knowledge_query_id;
        public Boolean allow_post;
        public Announcement announcement;
        public String anonymous_id;
        public AnonymousSetting.Enum anonymous_setting;
        public Long anonymous_total_quota;
        public AtAllPermission.Enum at_all_permission;
        public Image avatar;
        public String avatar_key;
        public String avatar_path;
        public List<String> avatar_urls;
        public BannerSetting banner_setting;
        public List<ChatTeamInfo> bound_team_infos;
        public String box_id;
        public Integer burn_life;
        public Boolean can_be_sorted_alphabetically;
        public Boolean can_translate_name;
        public ChatDisplayModeSetting.Enum chat_display_mode_setting;
        public ChatMode chat_mode;
        public ChatPinPermissionSetting.Enum chat_pin_permission_setting;
        public ChatTabPermissionSetting.Enum chat_tab_permission_setting;
        public Boolean chatable;
        public Integer chatter_count;
        public Map<Integer, Integer> chatter_extra_states;
        public String chatter_id;
        public Long create_time;
        public CreateUrgentSetting.Enum create_urgent_setting;
        public CreateVideoConferenceSetting.Enum create_video_conference_setting;
        public DefDisplaySetting.Enum def_display_setting;
        public String description;
        public DoubaoSetting doubao_setting;
        public String edit_message_draft_id;
        public List<FeedTag> feed_tag;
        public FeedCard.FeedType feed_type;
        public Integer first_chat_message_position;
        public Integer first_message_position;
        public Boolean has_vc_chat_permission;
        public Boolean has_water_mark;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253446id;
        public Boolean is_admin;
        public Boolean is_archived;
        public Boolean is_auto_translate;
        public Boolean is_auto_typing_translate;
        public Boolean is_cross_tenant;
        public Boolean is_cross_with_ka;
        public Boolean is_crypto;
        public Boolean is_custom_icon;
        public Boolean is_customer_service;
        public Boolean is_delayed;
        public Boolean is_deleted;
        public Boolean is_department;
        public Boolean is_dissolved;
        public Boolean is_edu;
        public Boolean is_fake;
        public Boolean is_flag;
        public Boolean is_frozen;
        public Boolean is_in_box;
        public Boolean is_meeting;
        public Boolean is_mute_at_all;
        public Boolean is_ocic_customer_service;
        public Boolean is_official_oncall;
        public Boolean is_offline_oncall;
        public Boolean is_p2p_ai;
        public Boolean is_p2p_official_bot_ai;
        public Boolean is_private_mode;
        public Boolean is_public;
        public Boolean is_public_v2;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public Boolean is_super;
        public Boolean is_support_view;
        public Boolean is_team;
        public Boolean is_temp_top_feed;
        public Boolean is_tenant;
        public Boolean is_user_count_visible;
        public SystemMessageVisible.Enum join_message_visible;
        public List<ChatTeamInfo> joined_team_infos;
        public Map<Long, Team> joined_teams;
        public String last_draft_id;
        public String last_message_id;
        public Integer last_message_position;
        public Integer last_message_position_badge_count;
        public Float last_read_offset;
        public Integer last_read_position;
        public String last_thread_id;
        public Integer last_thread_position;
        public Integer last_thread_position_badge_count;
        public String last_visible_message_id;
        public Integer last_visible_message_position;
        public String last_visible_thread_id;
        public Integer last_visible_thread_position;
        public MessagePosition.Enum message_position;
        public MessageVisibilitySetting.Enum message_visibility_setting;
        public String mini_avatar_key;
        public Boolean muteable;
        public String my_threads_last_display_message_id;
        public Long my_threads_last_timestamp;
        public Long my_threads_read_timestamp;
        public Integer my_threads_unread_count;
        public String name;
        public String name_major_language;
        public String name_pinyin;
        public String name_translate_language;
        public Integer new_message_count;
        public Integer new_thread_count;
        public Integer no_badged_new_message_count;
        public Integer no_badged_new_thread_count;
        public Boolean off_edit_group_chat_info;
        public String oncall_id;
        public String owner_id;
        public PinPermissionSetting.Enum pin_permission_setting;
        public String post_draft_id;
        public PostType post_type;
        public Integer put_chatter_apply_count;
        public Long query_create_time;
        public Integer query_seq_id;
        public CommonAIReply.Status query_status;
        public SystemMessageVisible.Enum quit_message_visible;
        public Integer read_position;
        public Integer read_position_badge_count;
        public Integer read_thread_position;
        public Integer read_thread_position_badge_count;
        public RestrictedModeSetting restricted_mode_setting;
        public Role role;
        public String schedule_message_draft_id;
        public ShareCardPermission.Enum share_card_permission;
        public Boolean should_display_translated_name;
        public Boolean show_banner;
        public Boolean show_nickname;
        public List<SideBarButton> sidebar_buttons;
        public String sidebar_id;
        public TagData tag_info;
        public List<Tag> tags;
        public TeamChatType team_chat_type;
        public Long team_id;
        public String team_name;
        public String tenant_id;
        public String text_draft_id;
        public Long theme_id;
        public TnsInfo tns_info;
        public TopNoticePermissionSetting.Enum top_notice_permission_setting;
        public String translated_name;
        public Type type;
        public Boolean typing_translate_has_auto_opened;
        public TypingTranslateSetting typing_translate_setting;
        public Long update_time;
        public ChatUserAutoMuteSetting user_auto_mute;
        public Integer user_count;
        public UserCountVisibleSetting.Enum user_count_visible_setting;

        @Override // com.squareup.wire.Message.Builder
        public Chat build() {
            String r100 = this.f253446id;
            if (r100 == null) goto L7;
            return new Chat(this.f253446id, this.type, this.name, this.last_message_id, this.last_message_position, this.new_message_count, this.update_time, this.avatar_key, this.chatter_id, this.create_time, this.description, this.avatar, this.owner_id, this.chatter_count, this.user_count, this.is_department, this.is_public, this.is_archived, this.is_deleted, this.is_remind, this.name_pinyin, this.role, this.is_customer_service, this.text_draft_id, this.post_draft_id, this.no_badged_new_message_count, this.is_shortcut, this.announcement, this.off_edit_group_chat_info, this.tenant_id, this.is_custom_icon, this.is_dissolved, this.message_position, this.feed_type, this.last_visible_message_id, this.burn_life, this.is_crypto, this.is_meeting, this.is_cross_tenant, this.is_support_view, this.first_message_position, this.oncall_id, this.last_visible_message_position, this.read_position, this.read_position_badge_count, this.last_message_position_badge_count, this.is_public_v2, this.allow_post, this.post_type, this.chat_mode, this.last_thread_id, this.last_thread_position, this.new_thread_count, this.no_badged_new_thread_count, this.last_thread_position_badge_count, this.read_thread_position, this.read_thread_position_badge_count, this.last_visible_thread_position, this.last_visible_thread_id, this.show_nickname, this.last_draft_id, this.last_read_position, this.last_read_offset, this.is_edu, this.is_admin, this.is_mute_at_all, this.is_delayed, this.is_p2p_ai, this.is_ocic_customer_service, this.is_p2p_official_bot_ai, this.is_temp_top_feed, this.add_member_permission, this.at_all_permission, this.join_message_visible, this.quit_message_visible, this.share_card_permission, this.add_member_apply, this.message_visibility_setting, this.create_urgent_setting, this.create_video_conference_setting, this.pin_permission_setting, this.top_notice_permission_setting, this.chat_tab_permission_setting, this.chat_display_mode_setting, this.chat_pin_permission_setting, this.put_chatter_apply_count, this.show_banner, this.mini_avatar_key, this.sidebar_id, this.sidebar_buttons, this.my_threads_read_timestamp, this.my_threads_last_timestamp, this.my_threads_unread_count, this.my_threads_last_display_message_id, this.anonymous_setting, this.anonymous_total_quota, this.is_cross_with_ka, this.anonymous_id, this.is_team, this.team_id, this.team_name, this.team_chat_type, this.chatter_extra_states, this.joined_team_infos, this.joined_teams, this.bound_team_infos, this.user_auto_mute, this.ai_knowledge_query_id, this.query_create_time, this.query_status, this.query_seq_id, this.edit_message_draft_id, this.chatable, this.muteable, this.is_super, this.is_private_mode, this.is_tenant, this.is_in_box, this.box_id, this.is_auto_translate, this.is_auto_typing_translate, this.typing_translate_setting, this.feed_tag, this.is_flag, this.has_water_mark, this.avatar_path, this.avatar_urls, this.first_chat_message_position, this.tag_info, this.is_fake, this.typing_translate_has_auto_opened, this.is_official_oncall, this.is_offline_oncall, this.restricted_mode_setting, this.def_display_setting, this.schedule_message_draft_id, this.has_vc_chat_permission, this.admin_post_setting, this.can_be_sorted_alphabetically, this.user_count_visible_setting, this.is_user_count_visible, this.doubao_setting, this.tags, this.theme_id, this.is_frozen, this.banner_setting, this.can_translate_name, this.should_display_translated_name, this.translated_name, this.name_major_language, this.name_translate_language, this.tns_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.sidebar_buttons = Internal.newMutableList();
            this.chatter_extra_states = Internal.newMutableMap();
            this.joined_team_infos = Internal.newMutableList();
            this.joined_teams = Internal.newMutableMap();
            this.bound_team_infos = Internal.newMutableList();
            this.feed_tag = Internal.newMutableList();
            this.avatar_urls = Internal.newMutableList();
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder add_member_apply(AddMemberApply.Enum r100) {
            this.add_member_apply = r100;
            return this;
        }

        public Builder add_member_permission(AddMemberPermission.Enum r100) {
            this.add_member_permission = r100;
            return this;
        }

        public Builder admin_post_setting(AdminPostSetting.Enum r100) {
            this.admin_post_setting = r100;
            return this;
        }

        public Builder ai_knowledge_query_id(Long r100) {
            this.ai_knowledge_query_id = r100;
            return this;
        }

        public Builder allow_post(Boolean r100) {
            this.allow_post = r100;
            return this;
        }

        public Builder announcement(Announcement r100) {
            this.announcement = r100;
            return this;
        }

        public Builder anonymous_id(String r100) {
            this.anonymous_id = r100;
            return this;
        }

        public Builder anonymous_setting(AnonymousSetting.Enum r100) {
            this.anonymous_setting = r100;
            return this;
        }

        public Builder anonymous_total_quota(Long r100) {
            this.anonymous_total_quota = r100;
            return this;
        }

        public Builder at_all_permission(AtAllPermission.Enum r100) {
            this.at_all_permission = r100;
            return this;
        }

        public Builder avatar(Image r100) {
            this.avatar = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
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

        public Builder banner_setting(BannerSetting r100) {
            this.banner_setting = r100;
            return this;
        }

        public Builder bound_team_infos(List<ChatTeamInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.bound_team_infos = r100;
            return this;
        }

        public Builder box_id(String r100) {
            this.box_id = r100;
            return this;
        }

        public Builder burn_life(Integer r100) {
            this.burn_life = r100;
            return this;
        }

        public Builder can_be_sorted_alphabetically(Boolean r100) {
            this.can_be_sorted_alphabetically = r100;
            return this;
        }

        public Builder can_translate_name(Boolean r100) {
            this.can_translate_name = r100;
            return this;
        }

        public Builder chat_display_mode_setting(ChatDisplayModeSetting.Enum r100) {
            this.chat_display_mode_setting = r100;
            return this;
        }

        public Builder chat_mode(ChatMode r100) {
            this.chat_mode = r100;
            return this;
        }

        public Builder chat_pin_permission_setting(ChatPinPermissionSetting.Enum r100) {
            this.chat_pin_permission_setting = r100;
            return this;
        }

        public Builder chat_tab_permission_setting(ChatTabPermissionSetting.Enum r100) {
            this.chat_tab_permission_setting = r100;
            return this;
        }

        public Builder chatable(Boolean r100) {
            this.chatable = r100;
            return this;
        }

        public Builder chatter_count(Integer r100) {
            this.chatter_count = r100;
            return this;
        }

        public Builder chatter_extra_states(Map<Integer, Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_extra_states = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder create_urgent_setting(CreateUrgentSetting.Enum r100) {
            this.create_urgent_setting = r100;
            return this;
        }

        public Builder create_video_conference_setting(CreateVideoConferenceSetting.Enum r100) {
            this.create_video_conference_setting = r100;
            return this;
        }

        public Builder def_display_setting(DefDisplaySetting.Enum r100) {
            this.def_display_setting = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder doubao_setting(DoubaoSetting r100) {
            this.doubao_setting = r100;
            return this;
        }

        public Builder edit_message_draft_id(String r100) {
            this.edit_message_draft_id = r100;
            return this;
        }

        public Builder feed_tag(List<FeedTag> r100) {
            Internal.checkElementsNotNull(r100);
            this.feed_tag = r100;
            return this;
        }

        public Builder feed_type(FeedCard.FeedType r100) {
            this.feed_type = r100;
            return this;
        }

        public Builder first_chat_message_position(Integer r100) {
            this.first_chat_message_position = r100;
            return this;
        }

        public Builder first_message_position(Integer r100) {
            this.first_message_position = r100;
            return this;
        }

        public Builder has_vc_chat_permission(Boolean r100) {
            this.has_vc_chat_permission = r100;
            return this;
        }

        public Builder has_water_mark(Boolean r100) {
            this.has_water_mark = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253446id = r100;
            return this;
        }

        public Builder is_admin(Boolean r100) {
            this.is_admin = r100;
            return this;
        }

        public Builder is_archived(Boolean r100) {
            this.is_archived = r100;
            return this;
        }

        public Builder is_auto_translate(Boolean r100) {
            this.is_auto_translate = r100;
            return this;
        }

        public Builder is_auto_typing_translate(Boolean r100) {
            this.is_auto_typing_translate = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
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

        public Builder is_custom_icon(Boolean r100) {
            this.is_custom_icon = r100;
            return this;
        }

        public Builder is_customer_service(Boolean r100) {
            this.is_customer_service = r100;
            return this;
        }

        public Builder is_delayed(Boolean r100) {
            this.is_delayed = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }

        public Builder is_department(Boolean r100) {
            this.is_department = r100;
            return this;
        }

        public Builder is_dissolved(Boolean r100) {
            this.is_dissolved = r100;
            return this;
        }

        public Builder is_edu(Boolean r100) {
            this.is_edu = r100;
            return this;
        }

        public Builder is_fake(Boolean r100) {
            this.is_fake = r100;
            return this;
        }

        public Builder is_flag(Boolean r100) {
            this.is_flag = r100;
            return this;
        }

        public Builder is_frozen(Boolean r100) {
            this.is_frozen = r100;
            return this;
        }

        public Builder is_in_box(Boolean r100) {
            this.is_in_box = r100;
            return this;
        }

        public Builder is_meeting(Boolean r100) {
            this.is_meeting = r100;
            return this;
        }

        public Builder is_mute_at_all(Boolean r100) {
            this.is_mute_at_all = r100;
            return this;
        }

        public Builder is_ocic_customer_service(Boolean r100) {
            this.is_ocic_customer_service = r100;
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

        public Builder is_public(Boolean r100) {
            this.is_public = r100;
            return this;
        }

        public Builder is_public_v2(Boolean r100) {
            this.is_public_v2 = r100;
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

        public Builder is_super(Boolean r100) {
            this.is_super = r100;
            return this;
        }

        public Builder is_support_view(Boolean r100) {
            this.is_support_view = r100;
            return this;
        }

        public Builder is_team(Boolean r100) {
            this.is_team = r100;
            return this;
        }

        public Builder is_temp_top_feed(Boolean r100) {
            this.is_temp_top_feed = r100;
            return this;
        }

        public Builder is_tenant(Boolean r100) {
            this.is_tenant = r100;
            return this;
        }

        public Builder is_user_count_visible(Boolean r100) {
            this.is_user_count_visible = r100;
            return this;
        }

        public Builder join_message_visible(SystemMessageVisible.Enum r100) {
            this.join_message_visible = r100;
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

        public Builder last_draft_id(String r100) {
            this.last_draft_id = r100;
            return this;
        }

        public Builder last_message_id(String r100) {
            this.last_message_id = r100;
            return this;
        }

        public Builder last_message_position(Integer r100) {
            this.last_message_position = r100;
            return this;
        }

        public Builder last_message_position_badge_count(Integer r100) {
            this.last_message_position_badge_count = r100;
            return this;
        }

        public Builder last_read_offset(Float r100) {
            this.last_read_offset = r100;
            return this;
        }

        public Builder last_read_position(Integer r100) {
            this.last_read_position = r100;
            return this;
        }

        public Builder last_thread_id(String r100) {
            this.last_thread_id = r100;
            return this;
        }

        public Builder last_thread_position(Integer r100) {
            this.last_thread_position = r100;
            return this;
        }

        public Builder last_thread_position_badge_count(Integer r100) {
            this.last_thread_position_badge_count = r100;
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

        public Builder last_visible_thread_id(String r100) {
            this.last_visible_thread_id = r100;
            return this;
        }

        public Builder last_visible_thread_position(Integer r100) {
            this.last_visible_thread_position = r100;
            return this;
        }

        public Builder message_position(MessagePosition.Enum r100) {
            this.message_position = r100;
            return this;
        }

        public Builder message_visibility_setting(MessageVisibilitySetting.Enum r100) {
            this.message_visibility_setting = r100;
            return this;
        }

        public Builder mini_avatar_key(String r100) {
            this.mini_avatar_key = r100;
            return this;
        }

        public Builder muteable(Boolean r100) {
            this.muteable = r100;
            return this;
        }

        public Builder my_threads_last_display_message_id(String r100) {
            this.my_threads_last_display_message_id = r100;
            return this;
        }

        public Builder my_threads_last_timestamp(Long r100) {
            this.my_threads_last_timestamp = r100;
            return this;
        }

        public Builder my_threads_read_timestamp(Long r100) {
            this.my_threads_read_timestamp = r100;
            return this;
        }

        public Builder my_threads_unread_count(Integer r100) {
            this.my_threads_unread_count = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder name_major_language(String r100) {
            this.name_major_language = r100;
            return this;
        }

        public Builder name_pinyin(String r100) {
            this.name_pinyin = r100;
            return this;
        }

        public Builder name_translate_language(String r100) {
            this.name_translate_language = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder new_thread_count(Integer r100) {
            this.new_thread_count = r100;
            return this;
        }

        public Builder no_badged_new_message_count(Integer r100) {
            this.no_badged_new_message_count = r100;
            return this;
        }

        public Builder no_badged_new_thread_count(Integer r100) {
            this.no_badged_new_thread_count = r100;
            return this;
        }

        public Builder off_edit_group_chat_info(Boolean r100) {
            this.off_edit_group_chat_info = r100;
            return this;
        }

        public Builder oncall_id(String r100) {
            this.oncall_id = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder pin_permission_setting(PinPermissionSetting.Enum r100) {
            this.pin_permission_setting = r100;
            return this;
        }

        public Builder post_draft_id(String r100) {
            this.post_draft_id = r100;
            return this;
        }

        public Builder post_type(PostType r100) {
            this.post_type = r100;
            return this;
        }

        public Builder put_chatter_apply_count(Integer r100) {
            this.put_chatter_apply_count = r100;
            return this;
        }

        public Builder query_create_time(Long r100) {
            this.query_create_time = r100;
            return this;
        }

        public Builder query_seq_id(Integer r100) {
            this.query_seq_id = r100;
            return this;
        }

        public Builder query_status(CommonAIReply.Status r100) {
            this.query_status = r100;
            return this;
        }

        public Builder quit_message_visible(SystemMessageVisible.Enum r100) {
            this.quit_message_visible = r100;
            return this;
        }

        public Builder read_position(Integer r100) {
            this.read_position = r100;
            return this;
        }

        public Builder read_position_badge_count(Integer r100) {
            this.read_position_badge_count = r100;
            return this;
        }

        public Builder read_thread_position(Integer r100) {
            this.read_thread_position = r100;
            return this;
        }

        public Builder read_thread_position_badge_count(Integer r100) {
            this.read_thread_position_badge_count = r100;
            return this;
        }

        public Builder restricted_mode_setting(RestrictedModeSetting r100) {
            this.restricted_mode_setting = r100;
            return this;
        }

        public Builder role(Role r100) {
            this.role = r100;
            return this;
        }

        public Builder schedule_message_draft_id(String r100) {
            this.schedule_message_draft_id = r100;
            return this;
        }

        public Builder share_card_permission(ShareCardPermission.Enum r100) {
            this.share_card_permission = r100;
            return this;
        }

        public Builder should_display_translated_name(Boolean r100) {
            this.should_display_translated_name = r100;
            return this;
        }

        public Builder show_banner(Boolean r100) {
            this.show_banner = r100;
            return this;
        }

        public Builder show_nickname(Boolean r100) {
            this.show_nickname = r100;
            return this;
        }

        public Builder sidebar_buttons(List<SideBarButton> r100) {
            Internal.checkElementsNotNull(r100);
            this.sidebar_buttons = r100;
            return this;
        }

        public Builder sidebar_id(String r100) {
            this.sidebar_id = r100;
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

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder text_draft_id(String r100) {
            this.text_draft_id = r100;
            return this;
        }

        public Builder theme_id(Long r100) {
            this.theme_id = r100;
            return this;
        }

        public Builder tns_info(TnsInfo r100) {
            this.tns_info = r100;
            return this;
        }

        public Builder top_notice_permission_setting(TopNoticePermissionSetting.Enum r100) {
            this.top_notice_permission_setting = r100;
            return this;
        }

        public Builder translated_name(String r100) {
            this.translated_name = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder typing_translate_has_auto_opened(Boolean r100) {
            this.typing_translate_has_auto_opened = r100;
            return this;
        }

        public Builder typing_translate_setting(TypingTranslateSetting r100) {
            this.typing_translate_setting = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder user_auto_mute(ChatUserAutoMuteSetting r100) {
            this.user_auto_mute = r100;
            return this;
        }

        public Builder user_count(Integer r100) {
            this.user_count = r100;
            return this;
        }

        public Builder user_count_visible_setting(UserCountVisibleSetting.Enum r100) {
            this.user_count_visible_setting = r100;
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

    public static final enum ChatMode extends Enum<ChatMode> implements WireEnum {
        private static final /* synthetic */ ChatMode[] $VALUES = null;
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final ChatMode DEFAULT = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN = null;
        public final Boolean deprecated;
        private final int value;

        static {
            ChatMode r100 = new ChatMode("UNKNOWN", 0, 0, null);
            UNKNOWN = r100;
            ChatMode r101 = new ChatMode("DEFAULT", 1, 1, null);
            DEFAULT = r101;
            ChatMode r102 = new ChatMode("THREAD", 2, 2, Boolean.TRUE);
            THREAD = r102;
            ChatMode r103 = new ChatMode("THREAD_V2", 3, 3, null);
            THREAD_V2 = r103;
            $VALUES = new ChatMode[]{r100, r101, r102, r103};
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
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return THREAD_V2;
        L14:
            return THREAD;
        L16:
            return DEFAULT;
        L18:
            return UNKNOWN;
        }

        public static ChatMode valueOf(String r100) {
            return (ChatMode) a.a(ChatMode.class, r100);
        }

        private ChatMode(String r100, int r101, int r102, Boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.deprecated = r103;
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

    public static final class DefDisplaySetting extends com.squareup.wire.Message<DefDisplaySetting, Builder> {
        public static final ProtoAdapter<DefDisplaySetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DefDisplaySetting, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public DefDisplaySetting build() {
                return new DefDisplaySetting(super.buildUnknownFields());
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
            public static final Enum CHAT_MENU = null;
            public static final Enum INPUT_BOX = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("INPUT_BOX", 1, 1);
                INPUT_BOX = r101;
                Enum r102 = new Enum("CHAT_MENU", 2, 2);
                CHAT_MENU = r102;
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
                return CHAT_MENU;
            L12:
                return INPUT_BOX;
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

        public static final class ProtoAdapter_DefDisplaySetting extends ProtoAdapter<DefDisplaySetting> {
            public ProtoAdapter_DefDisplaySetting() {
                super(FieldEncoding.LENGTH_DELIMITED, DefDisplaySetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DefDisplaySetting decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(DefDisplaySetting r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DefDisplaySetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DefDisplaySetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DefDisplaySetting r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DefDisplaySetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DefDisplaySetting();
        }

        public DefDisplaySetting() {
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
            return DefDisplaySetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DefDisplaySetting(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class DoubaoSetting extends com.squareup.wire.Message<DoubaoSetting, Builder> {
        public static final ProtoAdapter<DoubaoSetting> ADAPTER = null;
        public static final Boolean DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = null;
        public static final Boolean DEFAULT_DOUBAO_USING_ENABLED = null;
        private static final long serialVersionUID = 0;
        public final Boolean doubao_proactive_reply_enabled;
        public final Boolean doubao_using_enabled;

        public static final class Builder extends com.squareup.wire.Message.Builder<DoubaoSetting, Builder> {
            public Boolean doubao_proactive_reply_enabled;
            public Boolean doubao_using_enabled;

            @Override // com.squareup.wire.Message.Builder
            public DoubaoSetting build() {
                return new DoubaoSetting(this.doubao_using_enabled, this.doubao_proactive_reply_enabled, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder doubao_proactive_reply_enabled(Boolean r100) {
                this.doubao_proactive_reply_enabled = r100;
                return this;
            }

            public Builder doubao_using_enabled(Boolean r100) {
                this.doubao_using_enabled = r100;
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
                r101.doubao_using_enabled = Boolean.TRUE;
                r101.doubao_proactive_reply_enabled = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.doubao_using_enabled = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.doubao_proactive_reply_enabled = ProtoAdapter.BOOL.decode(r100);
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
                Boolean r101 = r100.doubao_using_enabled;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.doubao_proactive_reply_enabled;
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
                Boolean r102 = r101.doubao_using_enabled;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.doubao_proactive_reply_enabled;
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
            r100.doubao_using_enabled = this.doubao_using_enabled;
            r100.doubao_proactive_reply_enabled = this.doubao_proactive_reply_enabled;
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
            this.doubao_using_enabled = r100;
            this.doubao_proactive_reply_enabled = r101;
        }
    }

    public static final class MessagePosition extends com.squareup.wire.Message<MessagePosition, Builder> {
        public static final ProtoAdapter<MessagePosition> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessagePosition, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public MessagePosition build() {
                return new MessagePosition(super.buildUnknownFields());
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
            public static final Enum NEWEST_UNREAD = null;
            public static final Enum RECENT_LEFT = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("RECENT_LEFT", 1, 1);
                RECENT_LEFT = r101;
                Enum r102 = new Enum("NEWEST_UNREAD", 2, 2);
                NEWEST_UNREAD = r102;
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
                return NEWEST_UNREAD;
            L12:
                return RECENT_LEFT;
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

        public static final class ProtoAdapter_MessagePosition extends ProtoAdapter<MessagePosition> {
            public ProtoAdapter_MessagePosition() {
                super(FieldEncoding.LENGTH_DELIMITED, MessagePosition.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessagePosition decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(MessagePosition r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessagePosition decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessagePosition r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessagePosition r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessagePosition r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessagePosition();
        }

        public MessagePosition() {
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
            return MessagePosition.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessagePosition(ByteString r100) {
            super(ADAPTER, r100);
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

    public static final enum PostType extends Enum<PostType> implements WireEnum {
        private static final /* synthetic */ PostType[] $VALUES = null;
        public static final ProtoAdapter<PostType> ADAPTER = null;
        public static final PostType ANYONE = null;
        public static final PostType ONLY_ADMIN = null;
        public static final PostType UNKNOWN_POST_TYPE = null;
        public static final PostType WHITE_LIST = null;
        private final int value;

        static {
            PostType r100 = new PostType("UNKNOWN_POST_TYPE", 0, 0);
            UNKNOWN_POST_TYPE = r100;
            PostType r101 = new PostType("ANYONE", 1, 1);
            ANYONE = r101;
            PostType r102 = new PostType("ONLY_ADMIN", 2, 2);
            ONLY_ADMIN = r102;
            PostType r103 = new PostType("WHITE_LIST", 3, 3);
            WHITE_LIST = r103;
            $VALUES = new PostType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(PostType.class);
        }

        public static PostType[] values() {
            return (PostType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PostType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return WHITE_LIST;
        L14:
            return ONLY_ADMIN;
        L16:
            return ANYONE;
        L18:
            return UNKNOWN_POST_TYPE;
        }

        public static PostType valueOf(String r100) {
            return (PostType) a.a(PostType.class, r100);
        }

        private PostType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_Chat extends ProtoAdapter<Chat> {
        private final ProtoAdapter<Map<Integer, Integer>> chatter_extra_states;
        private final ProtoAdapter<Map<Long, Team>> joined_teams;

        public ProtoAdapter_Chat() {
            super(FieldEncoding.LENGTH_DELIMITED, Chat.class);
            ProtoAdapter<Integer> r100 = ProtoAdapter.INT32;
            this.chatter_extra_states = ProtoAdapter.newMapAdapter(r100, r100);
            this.joined_teams = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, Team.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Chat decode(ProtoReader r110) throws IOException {
            Builder r100 = new Builder();
            r100.f253446id = "";
            r100.type = Type.P2P;
            r100.name = "";
            r100.last_message_id = "";
            r100.last_message_position = 0;
            r100.new_message_count = 0;
            r100.update_time = 0L;
            r100.avatar_key = "";
            r100.chatter_id = "";
            r100.create_time = 0L;
            r100.description = "";
            r100.owner_id = "";
            r100.chatter_count = 0;
            r100.user_count = 0;
            Boolean r101 = Boolean.FALSE;
            r100.is_department = r101;
            r100.is_public = r101;
            r100.is_archived = r101;
            r100.is_deleted = r101;
            Boolean r102 = Boolean.TRUE;
            r100.is_remind = r102;
            r100.name_pinyin = "";
            r100.role = Role.IGNORE;
            r100.is_customer_service = r101;
            r100.text_draft_id = "";
            r100.post_draft_id = "";
            r100.no_badged_new_message_count = 0;
            r100.is_shortcut = r101;
            r100.off_edit_group_chat_info = r101;
            r100.tenant_id = "";
            r100.is_custom_icon = r101;
            r100.is_dissolved = r101;
            r100.message_position = MessagePosition.Enum.RECENT_LEFT;
            r100.feed_type = FeedCard.FeedType.INBOX;
            r100.last_visible_message_id = "";
            r100.burn_life = 0;
            r100.is_crypto = r101;
            r100.is_meeting = r101;
            r100.is_cross_tenant = r101;
            r100.is_support_view = r101;
            r100.first_message_position = -1;
            r100.oncall_id = "";
            r100.last_visible_message_position = 0;
            r100.read_position = 0;
            r100.read_position_badge_count = 0;
            r100.last_message_position_badge_count = 0;
            r100.is_public_v2 = r101;
            r100.allow_post = r102;
            r100.post_type = PostType.UNKNOWN_POST_TYPE;
            r100.chat_mode = ChatMode.DEFAULT;
            r100.last_thread_id = "";
            r100.last_thread_position = 0;
            r100.new_thread_count = 0;
            r100.no_badged_new_thread_count = 0;
            r100.last_thread_position_badge_count = 0;
            r100.read_thread_position = 0;
            r100.read_thread_position_badge_count = 0;
            r100.last_visible_thread_position = 0;
            r100.last_visible_thread_id = "";
            r100.show_nickname = r101;
            r100.last_draft_id = "";
            r100.last_read_position = -1;
            r100.last_read_offset = Float.valueOf(0.0f);
            r100.is_edu = r101;
            r100.is_admin = r101;
            r100.is_mute_at_all = r101;
            r100.is_delayed = r101;
            r100.is_p2p_ai = r101;
            r100.is_ocic_customer_service = r101;
            r100.is_p2p_official_bot_ai = r101;
            r100.is_temp_top_feed = r101;
            r100.add_member_permission = AddMemberPermission.Enum.ALL_MEMBERS;
            r100.at_all_permission = AtAllPermission.Enum.ALL_MEMBERS;
            SystemMessageVisible.Enum r103 = SystemMessageVisible.Enum.ONLY_OWNER;
            r100.join_message_visible = r103;
            r100.quit_message_visible = r103;
            r100.share_card_permission = ShareCardPermission.Enum.ALLOWED;
            r100.add_member_apply = AddMemberApply.Enum.NO_APPLY;
            r100.message_visibility_setting = MessageVisibilitySetting.Enum.ALL_MESSAGES;
            r100.create_urgent_setting = CreateUrgentSetting.Enum.ALL_MEMBERS;
            r100.create_video_conference_setting = CreateVideoConferenceSetting.Enum.ALL_MEMBERS;
            r100.pin_permission_setting = PinPermissionSetting.Enum.ALL_MEMBERS;
            r100.top_notice_permission_setting = TopNoticePermissionSetting.Enum.ALL_MEMBERS;
            r100.chat_tab_permission_setting = ChatTabPermissionSetting.Enum.ALL_MEMBERS;
            r100.chat_display_mode_setting = ChatDisplayModeSetting.Enum.UNKNOWN;
            r100.chat_pin_permission_setting = ChatPinPermissionSetting.Enum.UNKNOWN;
            r100.put_chatter_apply_count = 0;
            r100.show_banner = r101;
            r100.mini_avatar_key = "";
            r100.sidebar_id = "";
            r100.my_threads_read_timestamp = 0L;
            r100.my_threads_last_timestamp = 0L;
            r100.my_threads_unread_count = 0;
            r100.my_threads_last_display_message_id = "";
            r100.anonymous_setting = AnonymousSetting.Enum.INVISIBLE;
            r100.anonymous_total_quota = 0L;
            r100.is_cross_with_ka = r101;
            r100.anonymous_id = "";
            r100.is_team = r101;
            r100.team_id = 0L;
            r100.team_name = "";
            r100.team_chat_type = TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
            r100.ai_knowledge_query_id = 0L;
            r100.query_create_time = 0L;
            r100.query_status = CommonAIReply.Status.UNKNOWN_STATUS;
            r100.query_seq_id = 0;
            r100.edit_message_draft_id = "";
            r100.chatable = r102;
            r100.muteable = r102;
            r100.is_super = r101;
            r100.is_private_mode = r101;
            r100.is_tenant = r101;
            r100.is_in_box = r101;
            r100.box_id = "";
            r100.is_auto_translate = r101;
            r100.is_auto_typing_translate = r102;
            r100.is_flag = r101;
            r100.has_water_mark = r101;
            r100.avatar_path = "";
            r100.first_chat_message_position = -1;
            r100.is_fake = r101;
            r100.typing_translate_has_auto_opened = r101;
            r100.is_official_oncall = r101;
            r100.is_offline_oncall = r101;
            r100.def_display_setting = DefDisplaySetting.Enum.INPUT_BOX;
            r100.schedule_message_draft_id = "";
            r100.has_vc_chat_permission = r101;
            r100.admin_post_setting = AdminPostSetting.Enum.ALLOW_POST;
            r100.can_be_sorted_alphabetically = r101;
            r100.user_count_visible_setting = UserCountVisibleSetting.Enum.UNKNOWN;
            r100.is_user_count_visible = r102;
            r100.theme_id = 0L;
            r100.is_frozen = r101;
            r100.can_translate_name = r101;
            r100.should_display_translated_name = r101;
            r100.translated_name = "";
            r100.name_major_language = "";
            r100.name_translate_language = "";
            long r104 = r110.beginMessage();
        L3:
            int r105 = r110.nextTag();
            if (r105 == (-1)) goto L254;
            if (r105 != 11) goto L8;
            r100.chatter_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L8:
            if (r105 != 18) goto L10;
            r100.create_time = ProtoAdapter.INT64.decode(r110);
            goto L3
        L10:
            if (r105 != 150) goto L11;
            r100.edit_message_draft_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L11:
            switch(r105) {
                case 1: goto L250;
                case 2: goto L262;
                case 3: goto L245;
                case 4: goto L244;
                case 5: goto L243;
                case 6: goto L242;
                case 7: goto L241;
                case 8: goto L240;
                default: goto L12;
            };
        L262:
            r100.type = Type.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L248
        L248:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L240:
            r100.avatar_key = ProtoAdapter.STRING.decode(r110);
            goto L3
        L241:
            r100.update_time = ProtoAdapter.INT64.decode(r110);
            goto L3
        L242:
            r100.new_message_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L243:
            r100.last_message_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L244:
            r100.last_message_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L245:
            r100.name = ProtoAdapter.STRING.decode(r110);
            goto L3
        L250:
            r100.f253446id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L12:
            switch(r105) {
                case 20: goto L239;
                case 21: goto L238;
                case 22: goto L237;
                case 23: goto L236;
                case 24: goto L235;
                case 25: goto L234;
                case 26: goto L233;
                case 27: goto L232;
                case 28: goto L231;
                case 29: goto L230;
                case 30: goto L229;
                case 31: goto L280;
                case 32: goto L224;
                case 33: goto L223;
                case 34: goto L222;
                case 35: goto L221;
                case 36: goto L220;
                case 37: goto L219;
                case 38: goto L218;
                case 39: goto L217;
                case 40: goto L216;
                case 41: goto L215;
                case 42: goto L266;
                case 43: goto L300;
                case 44: goto L206;
                case 45: goto L205;
                case 46: goto L204;
                case 47: goto L203;
                case 48: goto L202;
                case 49: goto L201;
                case 50: goto L200;
                case 51: goto L199;
                case 52: goto L198;
                case 53: goto L197;
                case 54: goto L196;
                case 55: goto L195;
                case 56: goto L194;
                case 57: goto L193;
                case 58: goto L296;
                default: goto L13;
            };
        L266:
            r100.message_position = MessagePosition.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L213
        L213:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L280:
            r100.role = Role.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L227
        L227:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L296:
            r100.post_type = PostType.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L191
        L191:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L300:
            r100.feed_type = FeedCard.FeedType.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L209
        L209:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L193:
            r100.allow_post = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L194:
            r100.is_public_v2 = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L195:
            r100.last_message_position_badge_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L196:
            r100.read_position_badge_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L197:
            r100.read_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L198:
            r100.last_visible_message_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L199:
            r100.oncall_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L200:
            r100.first_message_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L201:
            r100.is_support_view = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L202:
            r100.is_cross_tenant = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L203:
            r100.is_meeting = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L204:
            r100.is_crypto = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L205:
            r100.burn_life = ProtoAdapter.INT32.decode(r110);
            goto L3
        L206:
            r100.last_visible_message_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L215:
            r100.is_dissolved = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L216:
            r100.is_custom_icon = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L217:
            r100.tenant_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L218:
            r100.off_edit_group_chat_info = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L219:
            r100.announcement = Announcement.ADAPTER.decode(r110);
            goto L3
        L220:
            r100.is_shortcut = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L221:
            r100.no_badged_new_message_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L222:
            r100.post_draft_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L223:
            r100.text_draft_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L224:
            r100.is_customer_service = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L229:
            r100.name_pinyin = ProtoAdapter.STRING.decode(r110);
            goto L3
        L230:
            r100.is_remind = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L231:
            r100.is_deleted = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L232:
            r100.is_archived = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L233:
            r100.is_public = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L234:
            r100.is_department = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L235:
            r100.user_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L236:
            r100.chatter_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L237:
            r100.owner_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L238:
            r100.avatar = Image.ADAPTER.decode(r110);
            goto L3
        L239:
            r100.description = ProtoAdapter.STRING.decode(r110);
            goto L3
        L13:
            switch(r105) {
                case 60: goto L274;
                case 61: goto L184;
                case 62: goto L183;
                case 63: goto L182;
                case 64: goto L181;
                case 65: goto L180;
                case 66: goto L179;
                case 67: goto L178;
                case 68: goto L177;
                case 69: goto L176;
                case 70: goto L175;
                case 71: goto L174;
                case 72: goto L173;
                case 73: goto L172;
                case 74: goto L171;
                case 75: goto L170;
                case 76: goto L169;
                case 77: goto L168;
                case 78: goto L167;
                case 79: goto L166;
                case 80: goto L165;
                case 81: goto L164;
                default: goto L14;
            };
        L274:
            r100.chat_mode = ChatMode.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L187
        L187:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L164:
            r100.is_temp_top_feed = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L165:
            r100.is_p2p_official_bot_ai = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L166:
            r100.is_ocic_customer_service = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L167:
            r100.is_p2p_ai = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L168:
            r100.is_delayed = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L169:
            r100.is_mute_at_all = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L170:
            r100.is_admin = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L171:
            r100.is_edu = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L172:
            r100.last_read_offset = ProtoAdapter.FLOAT.decode(r110);
            goto L3
        L173:
            r100.last_read_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L174:
            r100.last_draft_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L175:
            r100.show_nickname = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L176:
            r100.last_visible_thread_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L177:
            r100.last_visible_thread_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L178:
            r100.read_thread_position_badge_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L179:
            r100.read_thread_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L180:
            r100.last_thread_position_badge_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L181:
            r100.no_badged_new_thread_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L182:
            r100.new_thread_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L183:
            r100.last_thread_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L184:
            r100.last_thread_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L14:
            switch(r105) {
                case 100: goto L256;
                case 101: goto L282;
                case 102: goto L264;
                case 103: goto L288;
                case 104: goto L270;
                case 105: goto L306;
                case 106: goto L139;
                case 107: goto L138;
                case 108: goto L137;
                case 109: goto L136;
                case 110: goto L135;
                case 111: goto L134;
                case 112: goto L133;
                case 113: goto L132;
                case 114: goto L131;
                case 115: goto L290;
                case 116: goto L126;
                case 117: goto L125;
                case 118: goto L302;
                case 119: goto L120;
                case 120: goto L276;
                case 121: goto L304;
                case 122: goto L278;
                case 123: goto L258;
                case 124: goto L286;
                case 125: goto L268;
                case 126: goto L294;
                case 127: goto L91;
                case 128: goto L90;
                case 129: goto L89;
                case 130: goto L292;
                case 131: goto L84;
                case 132: goto L83;
                case 133: goto L82;
                case 134: goto L81;
                case 135: goto L80;
                case 136: goto L79;
                case 137: goto L78;
                case 138: goto L308;
                case 139: goto L73;
                default: goto L15;
            };
        L256:
            r100.add_member_permission = AddMemberPermission.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L162
        L162:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L258:
            r100.top_notice_permission_setting = TopNoticePermissionSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L106
        L106:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L264:
            r100.join_message_visible = SystemMessageVisible.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L154
        L154:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L268:
            r100.chat_display_mode_setting = ChatDisplayModeSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L98
        L98:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L270:
            r100.share_card_permission = ShareCardPermission.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L146
        L146:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L276:
            r100.create_urgent_setting = CreateUrgentSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L118
        L118:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L278:
            r100.pin_permission_setting = PinPermissionSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L110
        L110:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L282:
            r100.at_all_permission = AtAllPermission.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L158
        L158:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L286:
            r100.chat_tab_permission_setting = ChatTabPermissionSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L102
        L102:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L288:
            r100.quit_message_visible = SystemMessageVisible.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L150
        L150:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L290:
            r100.anonymous_setting = AnonymousSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L129
        L129:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L292:
            r100.team_chat_type = TeamChatType.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L87
        L87:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L294:
            r100.chat_pin_permission_setting = ChatPinPermissionSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L94
        L94:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L302:
            r100.message_visibility_setting = MessageVisibilitySetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L123
        L123:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L304:
            r100.create_video_conference_setting = CreateVideoConferenceSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L114
        L114:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L306:
            r100.add_member_apply = AddMemberApply.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L142
        L142:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L308:
            r100.query_status = CommonAIReply.Status.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L76
        L76:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L73:
            r100.query_seq_id = ProtoAdapter.INT32.decode(r110);
            goto L3
        L78:
            r100.query_create_time = ProtoAdapter.INT64.decode(r110);
            goto L3
        L79:
            r100.ai_knowledge_query_id = ProtoAdapter.INT64.decode(r110);
            goto L3
        L80:
            r100.user_auto_mute = ChatUserAutoMuteSetting.ADAPTER.decode(r110);
            goto L3
        L81:
            r100.bound_team_infos.add(ChatTeamInfo.ADAPTER.decode(r110));
            goto L3
        L82:
            r100.joined_teams.putAll(this.joined_teams.decode(r110));
            goto L3
        L83:
            r100.joined_team_infos.add(ChatTeamInfo.ADAPTER.decode(r110));
            goto L3
        L84:
            r100.chatter_extra_states.putAll(this.chatter_extra_states.decode(r110));
            goto L3
        L89:
            r100.team_name = ProtoAdapter.STRING.decode(r110);
            goto L3
        L90:
            r100.team_id = ProtoAdapter.INT64.decode(r110);
            goto L3
        L91:
            r100.is_team = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L120:
            r100.anonymous_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L125:
            r100.is_cross_with_ka = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L126:
            r100.anonymous_total_quota = ProtoAdapter.INT64.decode(r110);
            goto L3
        L131:
            r100.my_threads_last_display_message_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L132:
            r100.my_threads_unread_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L133:
            r100.my_threads_last_timestamp = ProtoAdapter.INT64.decode(r110);
            goto L3
        L134:
            r100.my_threads_read_timestamp = ProtoAdapter.INT64.decode(r110);
            goto L3
        L135:
            r100.sidebar_buttons.add(SideBarButton.ADAPTER.decode(r110));
            goto L3
        L136:
            r100.sidebar_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L137:
            r100.mini_avatar_key = ProtoAdapter.STRING.decode(r110);
            goto L3
        L138:
            r100.show_banner = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L139:
            r100.put_chatter_apply_count = ProtoAdapter.INT32.decode(r110);
            goto L3
        L15:
            switch(r105) {
                case 200: goto L72;
                case 201: goto L71;
                case 202: goto L70;
                case 203: goto L69;
                default: goto L16;
            };
        L69:
            r100.is_private_mode = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L70:
            r100.is_super = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L71:
            r100.muteable = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L72:
            r100.chatable = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L16:
            switch(r105) {
                case 220: goto L68;
                case 221: goto L67;
                case 222: goto L66;
                case 223: goto L65;
                case 224: goto L64;
                case 225: goto L63;
                case 226: goto L62;
                case 227: goto L61;
                default: goto L17;
            };
        L61:
            r100.is_flag = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L62:
            r100.feed_tag.add(FeedTag.ADAPTER.decode(r110));
            goto L3
        L63:
            r100.typing_translate_setting = TypingTranslateSetting.ADAPTER.decode(r110);
            goto L3
        L64:
            r100.is_auto_typing_translate = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L65:
            r100.is_auto_translate = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L66:
            r100.box_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L67:
            r100.is_in_box = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L68:
            r100.is_tenant = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L17:
            switch(r105) {
                case 250: goto L60;
                case 251: goto L59;
                case 252: goto L58;
                case 253: goto L57;
                case 254: goto L56;
                case 255: goto L55;
                case 256: goto L54;
                default: goto L18;
            };
        L54:
            r100.typing_translate_has_auto_opened = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L55:
            r100.is_fake = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L56:
            r100.tag_info = TagData.ADAPTER.decode(r110);
            goto L3
        L57:
            r100.first_chat_message_position = ProtoAdapter.INT32.decode(r110);
            goto L3
        L58:
            r100.avatar_urls.add(ProtoAdapter.STRING.decode(r110));
            goto L3
        L59:
            r100.avatar_path = ProtoAdapter.STRING.decode(r110);
            goto L3
        L60:
            r100.has_water_mark = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L18:
            switch(r105) {
                case 350: goto L53;
                case 351: goto L52;
                case 352: goto L51;
                case 353: goto L260;
                case 354: goto L46;
                case 355: goto L45;
                case 356: goto L272;
                case 357: goto L40;
                case 358: goto L284;
                case 359: goto L35;
                case 360: goto L34;
                default: goto L19;
            };
        L260:
            r100.def_display_setting = DefDisplaySetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L49
        L49:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L272:
            r100.admin_post_setting = AdminPostSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L43
        L43:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L284:
            r100.user_count_visible_setting = UserCountVisibleSetting.Enum.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L38
        L38:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L34:
            r100.doubao_setting = DoubaoSetting.ADAPTER.decode(r110);
            goto L3
        L35:
            r100.is_user_count_visible = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L40:
            r100.can_be_sorted_alphabetically = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L45:
            r100.has_vc_chat_permission = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L46:
            r100.schedule_message_draft_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L51:
            r100.restricted_mode_setting = RestrictedModeSetting.ADAPTER.decode(r110);
            goto L3
        L52:
            r100.is_offline_oncall = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L53:
            r100.is_official_oncall = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L19:
            switch(r105) {
                case 400: goto L298;
                case 401: goto L29;
                case 402: goto L28;
                case 403: goto L27;
                case 404: goto L26;
                case 405: goto L25;
                case 406: goto L24;
                case 407: goto L23;
                case 408: goto L22;
                case 409: goto L21;
                default: goto L20;
            };
        L298:
            r100.tags.add(Tag.ADAPTER.decode(r110));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
        L32:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L21:
            r100.tns_info = TnsInfo.ADAPTER.decode(r110);
            goto L3
        L22:
            r100.name_translate_language = ProtoAdapter.STRING.decode(r110);
            goto L3
        L23:
            r100.name_major_language = ProtoAdapter.STRING.decode(r110);
            goto L3
        L24:
            r100.translated_name = ProtoAdapter.STRING.decode(r110);
            goto L3
        L25:
            r100.should_display_translated_name = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L26:
            r100.can_translate_name = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L27:
            r100.banner_setting = BannerSetting.ADAPTER.decode(r110);
            goto L3
        L28:
            r100.is_frozen = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L29:
            r100.theme_id = ProtoAdapter.INT64.decode(r110);
            goto L3
        L20:
            FieldEncoding r106 = r110.peekFieldEncoding();
            r100.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r110));
            goto L3
        L254:
            r110.endMessage(r104);
            return r100.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Chat r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253445id);
            Type r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.last_message_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.last_message_position;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.new_message_count;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Long r119 = r100.update_time;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.avatar_key;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.chatter_id;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            Long r128 = r100.create_time;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(18, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.description;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(20, r131);
        L42:
            int r133 = r130 + r132;
            Image r134 = r100.avatar;
            if (r134 == null) goto L45;
            int r135 = Image.ADAPTER.encodedSizeWithTag(21, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.owner_id;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(22, r137);
        L50:
            int r139 = r136 + r138;
            Integer r140 = r100.chatter_count;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.INT32.encodedSizeWithTag(23, r140);
        L54:
            int r142 = r139 + r141;
            Integer r143 = r100.user_count;
            if (r143 == null) goto L57;
            int r144 = ProtoAdapter.INT32.encodedSizeWithTag(24, r143);
        L58:
            int r145 = r142 + r144;
            Boolean r146 = r100.is_department;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r146);
        L62:
            int r148 = r145 + r147;
            Boolean r149 = r100.is_public;
            if (r149 == null) goto L65;
            int r150 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r149);
        L66:
            int r151 = r148 + r150;
            Boolean r152 = r100.is_archived;
            if (r152 == null) goto L69;
            int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r152);
        L70:
            int r154 = r151 + r153;
            Boolean r155 = r100.is_deleted;
            if (r155 == null) goto L73;
            int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r155);
        L74:
            int r157 = r154 + r156;
            Boolean r158 = r100.is_remind;
            if (r158 == null) goto L77;
            int r159 = ProtoAdapter.BOOL.encodedSizeWithTag(29, r158);
        L78:
            int r160 = r157 + r159;
            String r161 = r100.name_pinyin;
            if (r161 == null) goto L81;
            int r162 = r101.encodedSizeWithTag(30, r161);
        L82:
            int r163 = r160 + r162;
            Role r164 = r100.role;
            if (r164 == null) goto L85;
            int r165 = Role.ADAPTER.encodedSizeWithTag(31, r164);
        L86:
            int r166 = r163 + r165;
            Boolean r167 = r100.is_customer_service;
            if (r167 == null) goto L89;
            int r168 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r167);
        L90:
            int r169 = r166 + r168;
            String r170 = r100.text_draft_id;
            if (r170 == null) goto L93;
            int r171 = r101.encodedSizeWithTag(33, r170);
        L94:
            int r172 = r169 + r171;
            String r173 = r100.post_draft_id;
            if (r173 == null) goto L97;
            int r174 = r101.encodedSizeWithTag(34, r173);
        L98:
            int r175 = r172 + r174;
            Integer r176 = r100.no_badged_new_message_count;
            if (r176 == null) goto L101;
            int r177 = ProtoAdapter.INT32.encodedSizeWithTag(35, r176);
        L102:
            int r178 = r175 + r177;
            Boolean r179 = r100.is_shortcut;
            if (r179 == null) goto L105;
            int r180 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r179);
        L106:
            int r181 = r178 + r180;
            Announcement r182 = r100.announcement;
            if (r182 == null) goto L109;
            int r183 = Announcement.ADAPTER.encodedSizeWithTag(37, r182);
        L110:
            int r184 = r181 + r183;
            Boolean r185 = r100.off_edit_group_chat_info;
            if (r185 == null) goto L113;
            int r186 = ProtoAdapter.BOOL.encodedSizeWithTag(38, r185);
        L114:
            int r187 = r184 + r186;
            String r188 = r100.tenant_id;
            if (r188 == null) goto L117;
            int r189 = r101.encodedSizeWithTag(39, r188);
        L118:
            int r190 = r187 + r189;
            Boolean r191 = r100.is_custom_icon;
            if (r191 == null) goto L121;
            int r192 = ProtoAdapter.BOOL.encodedSizeWithTag(40, r191);
        L122:
            int r193 = r190 + r192;
            Boolean r194 = r100.is_dissolved;
            if (r194 == null) goto L125;
            int r195 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r194);
        L126:
            int r196 = r193 + r195;
            MessagePosition.Enum r197 = r100.message_position;
            if (r197 == null) goto L129;
            int r198 = MessagePosition.Enum.ADAPTER.encodedSizeWithTag(42, r197);
        L130:
            int r199 = r196 + r198;
            FeedCard.FeedType r200 = r100.feed_type;
            if (r200 == null) goto L133;
            int r201 = FeedCard.FeedType.ADAPTER.encodedSizeWithTag(43, r200);
        L134:
            int r202 = r199 + r201;
            String r203 = r100.last_visible_message_id;
            if (r203 == null) goto L137;
            int r204 = r101.encodedSizeWithTag(44, r203);
        L138:
            int r205 = r202 + r204;
            Integer r206 = r100.burn_life;
            if (r206 == null) goto L141;
            int r207 = ProtoAdapter.INT32.encodedSizeWithTag(45, r206);
        L142:
            int r208 = r205 + r207;
            Boolean r209 = r100.is_crypto;
            if (r209 == null) goto L145;
            int r210 = ProtoAdapter.BOOL.encodedSizeWithTag(46, r209);
        L146:
            int r211 = r208 + r210;
            Boolean r212 = r100.is_meeting;
            if (r212 == null) goto L149;
            int r213 = ProtoAdapter.BOOL.encodedSizeWithTag(47, r212);
        L150:
            int r214 = r211 + r213;
            Boolean r215 = r100.is_cross_tenant;
            if (r215 == null) goto L153;
            int r216 = ProtoAdapter.BOOL.encodedSizeWithTag(48, r215);
        L154:
            int r217 = r214 + r216;
            Boolean r218 = r100.is_support_view;
            if (r218 == null) goto L157;
            int r219 = ProtoAdapter.BOOL.encodedSizeWithTag(49, r218);
        L158:
            int r220 = r217 + r219;
            Integer r221 = r100.first_message_position;
            if (r221 == null) goto L161;
            int r222 = ProtoAdapter.INT32.encodedSizeWithTag(50, r221);
        L162:
            int r223 = r220 + r222;
            String r224 = r100.oncall_id;
            if (r224 == null) goto L165;
            int r225 = r101.encodedSizeWithTag(51, r224);
        L166:
            int r226 = r223 + r225;
            Integer r227 = r100.last_visible_message_position;
            if (r227 == null) goto L169;
            int r228 = ProtoAdapter.INT32.encodedSizeWithTag(52, r227);
        L170:
            int r229 = r226 + r228;
            Integer r230 = r100.read_position;
            if (r230 == null) goto L173;
            int r231 = ProtoAdapter.INT32.encodedSizeWithTag(53, r230);
        L174:
            int r232 = r229 + r231;
            Integer r233 = r100.read_position_badge_count;
            if (r233 == null) goto L177;
            int r234 = ProtoAdapter.INT32.encodedSizeWithTag(54, r233);
        L178:
            int r235 = r232 + r234;
            Integer r236 = r100.last_message_position_badge_count;
            if (r236 == null) goto L181;
            int r237 = ProtoAdapter.INT32.encodedSizeWithTag(55, r236);
        L182:
            int r238 = r235 + r237;
            Boolean r239 = r100.is_public_v2;
            if (r239 == null) goto L185;
            int r240 = ProtoAdapter.BOOL.encodedSizeWithTag(56, r239);
        L186:
            int r241 = r238 + r240;
            Boolean r242 = r100.allow_post;
            if (r242 == null) goto L189;
            int r243 = ProtoAdapter.BOOL.encodedSizeWithTag(57, r242);
        L190:
            int r244 = r241 + r243;
            PostType r245 = r100.post_type;
            if (r245 == null) goto L193;
            int r246 = PostType.ADAPTER.encodedSizeWithTag(58, r245);
        L194:
            int r247 = r244 + r246;
            ChatMode r248 = r100.chat_mode;
            if (r248 == null) goto L197;
            int r249 = ChatMode.ADAPTER.encodedSizeWithTag(60, r248);
        L198:
            int r250 = r247 + r249;
            String r251 = r100.last_thread_id;
            if (r251 == null) goto L201;
            int r252 = r101.encodedSizeWithTag(61, r251);
        L202:
            int r253 = r250 + r252;
            Integer r254 = r100.last_thread_position;
            if (r254 == null) goto L205;
            int r255 = ProtoAdapter.INT32.encodedSizeWithTag(62, r254);
        L206:
            int r256 = r253 + r255;
            Integer r257 = r100.new_thread_count;
            if (r257 == null) goto L209;
            int r258 = ProtoAdapter.INT32.encodedSizeWithTag(63, r257);
        L210:
            int r259 = r256 + r258;
            Integer r260 = r100.no_badged_new_thread_count;
            if (r260 == null) goto L213;
            int r261 = ProtoAdapter.INT32.encodedSizeWithTag(64, r260);
        L214:
            int r262 = r259 + r261;
            Integer r263 = r100.last_thread_position_badge_count;
            if (r263 == null) goto L217;
            int r264 = ProtoAdapter.INT32.encodedSizeWithTag(65, r263);
        L218:
            int r265 = r262 + r264;
            Integer r266 = r100.read_thread_position;
            if (r266 == null) goto L221;
            int r267 = ProtoAdapter.INT32.encodedSizeWithTag(66, r266);
        L222:
            int r268 = r265 + r267;
            Integer r269 = r100.read_thread_position_badge_count;
            if (r269 == null) goto L225;
            int r270 = ProtoAdapter.INT32.encodedSizeWithTag(67, r269);
        L226:
            int r271 = r268 + r270;
            Integer r272 = r100.last_visible_thread_position;
            if (r272 == null) goto L229;
            int r273 = ProtoAdapter.INT32.encodedSizeWithTag(68, r272);
        L230:
            int r274 = r271 + r273;
            String r275 = r100.last_visible_thread_id;
            if (r275 == null) goto L233;
            int r276 = r101.encodedSizeWithTag(69, r275);
        L234:
            int r277 = r274 + r276;
            Boolean r278 = r100.show_nickname;
            if (r278 == null) goto L237;
            int r279 = ProtoAdapter.BOOL.encodedSizeWithTag(70, r278);
        L238:
            int r280 = r277 + r279;
            String r281 = r100.last_draft_id;
            if (r281 == null) goto L241;
            int r282 = r101.encodedSizeWithTag(71, r281);
        L242:
            int r283 = r280 + r282;
            Integer r284 = r100.last_read_position;
            if (r284 == null) goto L245;
            int r285 = ProtoAdapter.INT32.encodedSizeWithTag(72, r284);
        L246:
            int r286 = r283 + r285;
            Float r287 = r100.last_read_offset;
            if (r287 == null) goto L249;
            int r288 = ProtoAdapter.FLOAT.encodedSizeWithTag(73, r287);
        L250:
            int r289 = r286 + r288;
            Boolean r290 = r100.is_edu;
            if (r290 == null) goto L253;
            int r291 = ProtoAdapter.BOOL.encodedSizeWithTag(74, r290);
        L254:
            int r292 = r289 + r291;
            Boolean r293 = r100.is_admin;
            if (r293 == null) goto L257;
            int r294 = ProtoAdapter.BOOL.encodedSizeWithTag(75, r293);
        L258:
            int r295 = r292 + r294;
            Boolean r296 = r100.is_mute_at_all;
            if (r296 == null) goto L261;
            int r297 = ProtoAdapter.BOOL.encodedSizeWithTag(76, r296);
        L262:
            int r298 = r295 + r297;
            Boolean r299 = r100.is_delayed;
            if (r299 == null) goto L265;
            int r300 = ProtoAdapter.BOOL.encodedSizeWithTag(77, r299);
        L266:
            int r301 = r298 + r300;
            Boolean r302 = r100.is_p2p_ai;
            if (r302 == null) goto L269;
            int r303 = ProtoAdapter.BOOL.encodedSizeWithTag(78, r302);
        L270:
            int r304 = r301 + r303;
            Boolean r305 = r100.is_ocic_customer_service;
            if (r305 == null) goto L273;
            int r306 = ProtoAdapter.BOOL.encodedSizeWithTag(79, r305);
        L274:
            int r307 = r304 + r306;
            Boolean r308 = r100.is_p2p_official_bot_ai;
            if (r308 == null) goto L277;
            int r309 = ProtoAdapter.BOOL.encodedSizeWithTag(80, r308);
        L278:
            int r310 = r307 + r309;
            Boolean r311 = r100.is_temp_top_feed;
            if (r311 == null) goto L281;
            int r312 = ProtoAdapter.BOOL.encodedSizeWithTag(81, r311);
        L282:
            int r313 = r310 + r312;
            AddMemberPermission.Enum r314 = r100.add_member_permission;
            if (r314 == null) goto L285;
            int r315 = AddMemberPermission.Enum.ADAPTER.encodedSizeWithTag(100, r314);
        L286:
            int r316 = r313 + r315;
            AtAllPermission.Enum r317 = r100.at_all_permission;
            if (r317 == null) goto L289;
            int r318 = AtAllPermission.Enum.ADAPTER.encodedSizeWithTag(101, r317);
        L290:
            int r319 = r316 + r318;
            SystemMessageVisible.Enum r320 = r100.join_message_visible;
            if (r320 == null) goto L293;
            int r321 = SystemMessageVisible.Enum.ADAPTER.encodedSizeWithTag(102, r320);
        L294:
            int r322 = r319 + r321;
            SystemMessageVisible.Enum r323 = r100.quit_message_visible;
            if (r323 == null) goto L297;
            int r324 = SystemMessageVisible.Enum.ADAPTER.encodedSizeWithTag(103, r323);
        L298:
            int r325 = r322 + r324;
            ShareCardPermission.Enum r326 = r100.share_card_permission;
            if (r326 == null) goto L301;
            int r327 = ShareCardPermission.Enum.ADAPTER.encodedSizeWithTag(104, r326);
        L302:
            int r328 = r325 + r327;
            AddMemberApply.Enum r329 = r100.add_member_apply;
            if (r329 == null) goto L305;
            int r330 = AddMemberApply.Enum.ADAPTER.encodedSizeWithTag(105, r329);
        L306:
            int r331 = r328 + r330;
            MessageVisibilitySetting.Enum r332 = r100.message_visibility_setting;
            if (r332 == null) goto L309;
            int r333 = MessageVisibilitySetting.Enum.ADAPTER.encodedSizeWithTag(118, r332);
        L310:
            int r334 = r331 + r333;
            CreateUrgentSetting.Enum r335 = r100.create_urgent_setting;
            if (r335 == null) goto L313;
            int r336 = CreateUrgentSetting.Enum.ADAPTER.encodedSizeWithTag(120, r335);
        L314:
            int r337 = r334 + r336;
            CreateVideoConferenceSetting.Enum r338 = r100.create_video_conference_setting;
            if (r338 == null) goto L317;
            int r339 = CreateVideoConferenceSetting.Enum.ADAPTER.encodedSizeWithTag(121, r338);
        L318:
            int r340 = r337 + r339;
            PinPermissionSetting.Enum r341 = r100.pin_permission_setting;
            if (r341 == null) goto L321;
            int r342 = PinPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(122, r341);
        L322:
            int r343 = r340 + r342;
            TopNoticePermissionSetting.Enum r344 = r100.top_notice_permission_setting;
            if (r344 == null) goto L325;
            int r345 = TopNoticePermissionSetting.Enum.ADAPTER.encodedSizeWithTag(123, r344);
        L326:
            int r346 = r343 + r345;
            ChatTabPermissionSetting.Enum r347 = r100.chat_tab_permission_setting;
            if (r347 == null) goto L329;
            int r348 = ChatTabPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(124, r347);
        L330:
            int r349 = r346 + r348;
            ChatDisplayModeSetting.Enum r350 = r100.chat_display_mode_setting;
            if (r350 == null) goto L333;
            int r351 = ChatDisplayModeSetting.Enum.ADAPTER.encodedSizeWithTag(125, r350);
        L334:
            int r352 = r349 + r351;
            ChatPinPermissionSetting.Enum r353 = r100.chat_pin_permission_setting;
            if (r353 == null) goto L337;
            int r354 = ChatPinPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(126, r353);
        L338:
            int r355 = r352 + r354;
            Integer r356 = r100.put_chatter_apply_count;
            if (r356 == null) goto L341;
            int r357 = ProtoAdapter.INT32.encodedSizeWithTag(106, r356);
        L342:
            int r358 = r355 + r357;
            Boolean r359 = r100.show_banner;
            if (r359 == null) goto L345;
            int r360 = ProtoAdapter.BOOL.encodedSizeWithTag(107, r359);
        L346:
            int r361 = r358 + r360;
            String r362 = r100.mini_avatar_key;
            if (r362 == null) goto L349;
            int r363 = r101.encodedSizeWithTag(108, r362);
        L350:
            int r364 = r361 + r363;
            String r365 = r100.sidebar_id;
            if (r365 == null) goto L353;
            int r366 = r101.encodedSizeWithTag(109, r365);
        L354:
            int r367 = (r364 + r366) + SideBarButton.ADAPTER.asRepeated().encodedSizeWithTag(110, r100.sidebar_buttons);
            Long r368 = r100.my_threads_read_timestamp;
            if (r368 == null) goto L357;
            int r369 = ProtoAdapter.INT64.encodedSizeWithTag(111, r368);
        L358:
            int r370 = r367 + r369;
            Long r371 = r100.my_threads_last_timestamp;
            if (r371 == null) goto L361;
            int r372 = ProtoAdapter.INT64.encodedSizeWithTag(112, r371);
        L362:
            int r373 = r370 + r372;
            Integer r374 = r100.my_threads_unread_count;
            if (r374 == null) goto L365;
            int r375 = ProtoAdapter.INT32.encodedSizeWithTag(113, r374);
        L366:
            int r376 = r373 + r375;
            String r377 = r100.my_threads_last_display_message_id;
            if (r377 == null) goto L369;
            int r378 = r101.encodedSizeWithTag(114, r377);
        L370:
            int r379 = r376 + r378;
            AnonymousSetting.Enum r380 = r100.anonymous_setting;
            if (r380 == null) goto L373;
            int r381 = AnonymousSetting.Enum.ADAPTER.encodedSizeWithTag(115, r380);
        L374:
            int r382 = r379 + r381;
            Long r383 = r100.anonymous_total_quota;
            if (r383 == null) goto L377;
            int r384 = ProtoAdapter.INT64.encodedSizeWithTag(116, r383);
        L378:
            int r385 = r382 + r384;
            Boolean r386 = r100.is_cross_with_ka;
            if (r386 == null) goto L381;
            int r387 = ProtoAdapter.BOOL.encodedSizeWithTag(117, r386);
        L382:
            int r388 = r385 + r387;
            String r389 = r100.anonymous_id;
            if (r389 == null) goto L385;
            int r390 = r101.encodedSizeWithTag(119, r389);
        L386:
            int r391 = r388 + r390;
            Boolean r392 = r100.is_team;
            if (r392 == null) goto L389;
            int r393 = ProtoAdapter.BOOL.encodedSizeWithTag(127, r392);
        L390:
            int r394 = r391 + r393;
            Long r395 = r100.team_id;
            if (r395 == null) goto L393;
            int r396 = ProtoAdapter.INT64.encodedSizeWithTag(128, r395);
        L394:
            int r397 = r394 + r396;
            String r398 = r100.team_name;
            if (r398 == null) goto L397;
            int r399 = r101.encodedSizeWithTag(129, r398);
        L398:
            int r400 = r397 + r399;
            TeamChatType r401 = r100.team_chat_type;
            if (r401 == null) goto L401;
            int r402 = TeamChatType.ADAPTER.encodedSizeWithTag(130, r401);
        L402:
            int r403 = (r400 + r402) + this.chatter_extra_states.encodedSizeWithTag(131, r100.chatter_extra_states);
            ProtoAdapter<ChatTeamInfo> r404 = ChatTeamInfo.ADAPTER;
            int r405 = ((r403 + r404.asRepeated().encodedSizeWithTag(132, r100.joined_team_infos)) + this.joined_teams.encodedSizeWithTag(133, r100.joined_teams)) + r404.asRepeated().encodedSizeWithTag(134, r100.bound_team_infos);
            ChatUserAutoMuteSetting r406 = r100.user_auto_mute;
            if (r406 == null) goto L405;
            int r407 = ChatUserAutoMuteSetting.ADAPTER.encodedSizeWithTag(135, r406);
        L406:
            int r408 = r405 + r407;
            Long r409 = r100.ai_knowledge_query_id;
            if (r409 == null) goto L409;
            int r410 = ProtoAdapter.INT64.encodedSizeWithTag(136, r409);
        L410:
            int r411 = r408 + r410;
            Long r412 = r100.query_create_time;
            if (r412 == null) goto L413;
            int r413 = ProtoAdapter.INT64.encodedSizeWithTag(137, r412);
        L414:
            int r414 = r411 + r413;
            CommonAIReply.Status r415 = r100.query_status;
            if (r415 == null) goto L417;
            int r416 = CommonAIReply.Status.ADAPTER.encodedSizeWithTag(138, r415);
        L418:
            int r417 = r414 + r416;
            Integer r418 = r100.query_seq_id;
            if (r418 == null) goto L421;
            int r419 = ProtoAdapter.INT32.encodedSizeWithTag(139, r418);
        L422:
            int r420 = r417 + r419;
            String r421 = r100.edit_message_draft_id;
            if (r421 == null) goto L425;
            int r422 = r101.encodedSizeWithTag(150, r421);
        L426:
            int r423 = r420 + r422;
            Boolean r424 = r100.chatable;
            if (r424 == null) goto L429;
            int r425 = ProtoAdapter.BOOL.encodedSizeWithTag(200, r424);
        L430:
            int r426 = r423 + r425;
            Boolean r427 = r100.muteable;
            if (r427 == null) goto L433;
            int r428 = ProtoAdapter.BOOL.encodedSizeWithTag(201, r427);
        L434:
            int r429 = r426 + r428;
            Boolean r430 = r100.is_super;
            if (r430 == null) goto L437;
            int r431 = ProtoAdapter.BOOL.encodedSizeWithTag(202, r430);
        L438:
            int r432 = r429 + r431;
            Boolean r433 = r100.is_private_mode;
            if (r433 == null) goto L441;
            int r434 = ProtoAdapter.BOOL.encodedSizeWithTag(203, r433);
        L442:
            int r435 = r432 + r434;
            Boolean r436 = r100.is_tenant;
            if (r436 == null) goto L445;
            int r437 = ProtoAdapter.BOOL.encodedSizeWithTag(220, r436);
        L446:
            int r438 = r435 + r437;
            Boolean r439 = r100.is_in_box;
            if (r439 == null) goto L449;
            int r440 = ProtoAdapter.BOOL.encodedSizeWithTag(221, r439);
        L450:
            int r441 = r438 + r440;
            String r442 = r100.box_id;
            if (r442 == null) goto L453;
            int r443 = r101.encodedSizeWithTag(222, r442);
        L454:
            int r444 = r441 + r443;
            Boolean r445 = r100.is_auto_translate;
            if (r445 == null) goto L457;
            int r446 = ProtoAdapter.BOOL.encodedSizeWithTag(223, r445);
        L458:
            int r447 = r444 + r446;
            Boolean r448 = r100.is_auto_typing_translate;
            if (r448 == null) goto L461;
            int r449 = ProtoAdapter.BOOL.encodedSizeWithTag(224, r448);
        L462:
            int r450 = r447 + r449;
            TypingTranslateSetting r451 = r100.typing_translate_setting;
            if (r451 == null) goto L465;
            int r452 = TypingTranslateSetting.ADAPTER.encodedSizeWithTag(225, r451);
        L466:
            int r453 = (r450 + r452) + FeedTag.ADAPTER.asRepeated().encodedSizeWithTag(226, r100.feed_tag);
            Boolean r454 = r100.is_flag;
            if (r454 == null) goto L469;
            int r455 = ProtoAdapter.BOOL.encodedSizeWithTag(VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, r454);
        L470:
            int r456 = r453 + r455;
            Boolean r457 = r100.has_water_mark;
            if (r457 == null) goto L473;
            int r458 = ProtoAdapter.BOOL.encodedSizeWithTag(250, r457);
        L474:
            int r459 = r456 + r458;
            String r460 = r100.avatar_path;
            if (r460 == null) goto L477;
            int r461 = r101.encodedSizeWithTag(251, r460);
        L478:
            int r462 = (r459 + r461) + r101.asRepeated().encodedSizeWithTag(252, r100.avatar_urls);
            Integer r463 = r100.first_chat_message_position;
            if (r463 == null) goto L481;
            int r464 = ProtoAdapter.INT32.encodedSizeWithTag(253, r463);
        L482:
            int r465 = r462 + r464;
            TagData r466 = r100.tag_info;
            if (r466 == null) goto L485;
            int r467 = TagData.ADAPTER.encodedSizeWithTag(254, r466);
        L486:
            int r468 = r465 + r467;
            Boolean r469 = r100.is_fake;
            if (r469 == null) goto L489;
            int r470 = ProtoAdapter.BOOL.encodedSizeWithTag(255, r469);
        L490:
            int r471 = r468 + r470;
            Boolean r472 = r100.typing_translate_has_auto_opened;
            if (r472 == null) goto L493;
            int r473 = ProtoAdapter.BOOL.encodedSizeWithTag(256, r472);
        L494:
            int r474 = r471 + r473;
            Boolean r475 = r100.is_official_oncall;
            if (r475 == null) goto L497;
            int r476 = ProtoAdapter.BOOL.encodedSizeWithTag(TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG, r475);
        L498:
            int r477 = r474 + r476;
            Boolean r478 = r100.is_offline_oncall;
            if (r478 == null) goto L501;
            int r479 = ProtoAdapter.BOOL.encodedSizeWithTag(351, r478);
        L502:
            int r480 = r477 + r479;
            RestrictedModeSetting r481 = r100.restricted_mode_setting;
            if (r481 == null) goto L505;
            int r482 = RestrictedModeSetting.ADAPTER.encodedSizeWithTag(352, r481);
        L506:
            int r483 = r480 + r482;
            DefDisplaySetting.Enum r484 = r100.def_display_setting;
            if (r484 == null) goto L509;
            int r485 = DefDisplaySetting.Enum.ADAPTER.encodedSizeWithTag(353, r484);
        L510:
            int r486 = r483 + r485;
            String r487 = r100.schedule_message_draft_id;
            if (r487 == null) goto L513;
            int r488 = r101.encodedSizeWithTag(354, r487);
        L514:
            int r489 = r486 + r488;
            Boolean r490 = r100.has_vc_chat_permission;
            if (r490 == null) goto L517;
            int r491 = ProtoAdapter.BOOL.encodedSizeWithTag(355, r490);
        L518:
            int r492 = r489 + r491;
            AdminPostSetting.Enum r493 = r100.admin_post_setting;
            if (r493 == null) goto L521;
            int r494 = AdminPostSetting.Enum.ADAPTER.encodedSizeWithTag(356, r493);
        L522:
            int r495 = r492 + r494;
            Boolean r496 = r100.can_be_sorted_alphabetically;
            if (r496 == null) goto L525;
            int r497 = ProtoAdapter.BOOL.encodedSizeWithTag(357, r496);
        L526:
            int r498 = r495 + r497;
            UserCountVisibleSetting.Enum r499 = r100.user_count_visible_setting;
            if (r499 == null) goto L529;
            int r500 = UserCountVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(358, r499);
        L530:
            int r501 = r498 + r500;
            Boolean r502 = r100.is_user_count_visible;
            if (r502 == null) goto L533;
            int r503 = ProtoAdapter.BOOL.encodedSizeWithTag(359, r502);
        L534:
            int r504 = r501 + r503;
            DoubaoSetting r505 = r100.doubao_setting;
            if (r505 == null) goto L537;
            int r506 = DoubaoSetting.ADAPTER.encodedSizeWithTag(360, r505);
        L538:
            int r507 = (r504 + r506) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(400, r100.tags);
            Long r508 = r100.theme_id;
            if (r508 == null) goto L541;
            int r509 = ProtoAdapter.INT64.encodedSizeWithTag(401, r508);
        L542:
            int r510 = r507 + r509;
            Boolean r511 = r100.is_frozen;
            if (r511 == null) goto L545;
            int r512 = ProtoAdapter.BOOL.encodedSizeWithTag(402, r511);
        L546:
            int r513 = r510 + r512;
            BannerSetting r514 = r100.banner_setting;
            if (r514 == null) goto L549;
            int r515 = BannerSetting.ADAPTER.encodedSizeWithTag(403, r514);
        L550:
            int r516 = r513 + r515;
            Boolean r517 = r100.can_translate_name;
            if (r517 == null) goto L553;
            int r518 = ProtoAdapter.BOOL.encodedSizeWithTag(404, r517);
        L554:
            int r519 = r516 + r518;
            Boolean r520 = r100.should_display_translated_name;
            if (r520 == null) goto L557;
            int r521 = ProtoAdapter.BOOL.encodedSizeWithTag(405, r520);
        L558:
            int r522 = r519 + r521;
            String r523 = r100.translated_name;
            if (r523 == null) goto L561;
            int r524 = r101.encodedSizeWithTag(406, r523);
        L562:
            int r525 = r522 + r524;
            String r526 = r100.name_major_language;
            if (r526 == null) goto L565;
            int r527 = r101.encodedSizeWithTag(407, r526);
        L566:
            int r528 = r525 + r527;
            String r529 = r100.name_translate_language;
            if (r529 == null) goto L569;
            int r530 = r101.encodedSizeWithTag(408, r529);
        L570:
            int r531 = r528 + r530;
            TnsInfo r532 = r100.tns_info;
            if (r532 == null) goto L574;
            r104 = TnsInfo.ADAPTER.encodedSizeWithTag(409, r532);
        L574:
            return (r531 + r104) + r100.unknownFields().size();
        L569:
            r530 = 0;
            goto L570
        L565:
            r527 = 0;
            goto L566
        L561:
            r524 = 0;
            goto L562
        L557:
            r521 = 0;
            goto L558
        L553:
            r518 = 0;
            goto L554
        L549:
            r515 = 0;
            goto L550
        L545:
            r512 = 0;
            goto L546
        L541:
            r509 = 0;
            goto L542
        L537:
            r506 = 0;
            goto L538
        L533:
            r503 = 0;
            goto L534
        L529:
            r500 = 0;
            goto L530
        L525:
            r497 = 0;
            goto L526
        L521:
            r494 = 0;
            goto L522
        L517:
            r491 = 0;
            goto L518
        L513:
            r488 = 0;
            goto L514
        L509:
            r485 = 0;
            goto L510
        L505:
            r482 = 0;
            goto L506
        L501:
            r479 = 0;
            goto L502
        L497:
            r476 = 0;
            goto L498
        L493:
            r473 = 0;
            goto L494
        L489:
            r470 = 0;
            goto L490
        L485:
            r467 = 0;
            goto L486
        L481:
            r464 = 0;
            goto L482
        L477:
            r461 = 0;
            goto L478
        L473:
            r458 = 0;
            goto L474
        L469:
            r455 = 0;
            goto L470
        L465:
            r452 = 0;
            goto L466
        L461:
            r449 = 0;
            goto L462
        L457:
            r446 = 0;
            goto L458
        L453:
            r443 = 0;
            goto L454
        L449:
            r440 = 0;
            goto L450
        L445:
            r437 = 0;
            goto L446
        L441:
            r434 = 0;
            goto L442
        L437:
            r431 = 0;
            goto L438
        L433:
            r428 = 0;
            goto L434
        L429:
            r425 = 0;
            goto L430
        L425:
            r422 = 0;
            goto L426
        L421:
            r419 = 0;
            goto L422
        L417:
            r416 = 0;
            goto L418
        L413:
            r413 = 0;
            goto L414
        L409:
            r410 = 0;
            goto L410
        L405:
            r407 = 0;
            goto L406
        L401:
            r402 = 0;
            goto L402
        L397:
            r399 = 0;
            goto L398
        L393:
            r396 = 0;
            goto L394
        L389:
            r393 = 0;
            goto L390
        L385:
            r390 = 0;
            goto L386
        L381:
            r387 = 0;
            goto L382
        L377:
            r384 = 0;
            goto L378
        L373:
            r381 = 0;
            goto L374
        L369:
            r378 = 0;
            goto L370
        L365:
            r375 = 0;
            goto L366
        L361:
            r372 = 0;
            goto L362
        L357:
            r369 = 0;
            goto L358
        L353:
            r366 = 0;
            goto L354
        L349:
            r363 = 0;
            goto L350
        L345:
            r360 = 0;
            goto L346
        L341:
            r357 = 0;
            goto L342
        L337:
            r354 = 0;
            goto L338
        L333:
            r351 = 0;
            goto L334
        L329:
            r348 = 0;
            goto L330
        L325:
            r345 = 0;
            goto L326
        L321:
            r342 = 0;
            goto L322
        L317:
            r339 = 0;
            goto L318
        L313:
            r336 = 0;
            goto L314
        L309:
            r333 = 0;
            goto L310
        L305:
            r330 = 0;
            goto L306
        L301:
            r327 = 0;
            goto L302
        L297:
            r324 = 0;
            goto L298
        L293:
            r321 = 0;
            goto L294
        L289:
            r318 = 0;
            goto L290
        L285:
            r315 = 0;
            goto L286
        L281:
            r312 = 0;
            goto L282
        L277:
            r309 = 0;
            goto L278
        L273:
            r306 = 0;
            goto L274
        L269:
            r303 = 0;
            goto L270
        L265:
            r300 = 0;
            goto L266
        L261:
            r297 = 0;
            goto L262
        L257:
            r294 = 0;
            goto L258
        L253:
            r291 = 0;
            goto L254
        L249:
            r288 = 0;
            goto L250
        L245:
            r285 = 0;
            goto L246
        L241:
            r282 = 0;
            goto L242
        L237:
            r279 = 0;
            goto L238
        L233:
            r276 = 0;
            goto L234
        L229:
            r273 = 0;
            goto L230
        L225:
            r270 = 0;
            goto L226
        L221:
            r267 = 0;
            goto L222
        L217:
            r264 = 0;
            goto L218
        L213:
            r261 = 0;
            goto L214
        L209:
            r258 = 0;
            goto L210
        L205:
            r255 = 0;
            goto L206
        L201:
            r252 = 0;
            goto L202
        L197:
            r249 = 0;
            goto L198
        L193:
            r246 = 0;
            goto L194
        L189:
            r243 = 0;
            goto L190
        L185:
            r240 = 0;
            goto L186
        L181:
            r237 = 0;
            goto L182
        L177:
            r234 = 0;
            goto L178
        L173:
            r231 = 0;
            goto L174
        L169:
            r228 = 0;
            goto L170
        L165:
            r225 = 0;
            goto L166
        L161:
            r222 = 0;
            goto L162
        L157:
            r219 = 0;
            goto L158
        L153:
            r216 = 0;
            goto L154
        L149:
            r213 = 0;
            goto L150
        L145:
            r210 = 0;
            goto L146
        L141:
            r207 = 0;
            goto L142
        L137:
            r204 = 0;
            goto L138
        L133:
            r201 = 0;
            goto L134
        L129:
            r198 = 0;
            goto L130
        L125:
            r195 = 0;
            goto L126
        L121:
            r192 = 0;
            goto L122
        L117:
            r189 = 0;
            goto L118
        L113:
            r186 = 0;
            goto L114
        L109:
            r183 = 0;
            goto L110
        L105:
            r180 = 0;
            goto L106
        L101:
            r177 = 0;
            goto L102
        L97:
            r174 = 0;
            goto L98
        L93:
            r171 = 0;
            goto L94
        L89:
            r168 = 0;
            goto L90
        L85:
            r165 = 0;
            goto L86
        L81:
            r162 = 0;
            goto L82
        L77:
            r159 = 0;
            goto L78
        L73:
            r156 = 0;
            goto L74
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ Chat decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Chat r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Chat r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253445id);
            Type r103 = r101.type;
            if (r103 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.name;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.last_message_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Integer r106 = r101.last_message_position;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.new_message_count;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            Long r108 = r101.update_time;
            if (r108 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.avatar_key;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.chatter_id;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 11, r110);
        L26:
            Long r111 = r101.create_time;
            if (r111 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 18, r111);
        L29:
            String r112 = r101.description;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 20, r112);
        L32:
            Image r113 = r101.avatar;
            if (r113 == null) goto L35;
            Image.ADAPTER.encodeWithTag(r100, 21, r113);
        L35:
            String r114 = r101.owner_id;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 22, r114);
        L38:
            Integer r115 = r101.chatter_count;
            if (r115 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 23, r115);
        L41:
            Integer r116 = r101.user_count;
            if (r116 == null) goto L44;
            ProtoAdapter.INT32.encodeWithTag(r100, 24, r116);
        L44:
            Boolean r117 = r101.is_department;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 25, r117);
        L47:
            Boolean r118 = r101.is_public;
            if (r118 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r118);
        L50:
            Boolean r119 = r101.is_archived;
            if (r119 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r119);
        L53:
            Boolean r120 = r101.is_deleted;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 28, r120);
        L56:
            Boolean r121 = r101.is_remind;
            if (r121 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 29, r121);
        L59:
            String r122 = r101.name_pinyin;
            if (r122 == null) goto L62;
            r102.encodeWithTag(r100, 30, r122);
        L62:
            Role r123 = r101.role;
            if (r123 == null) goto L65;
            Role.ADAPTER.encodeWithTag(r100, 31, r123);
        L65:
            Boolean r124 = r101.is_customer_service;
            if (r124 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32, r124);
        L68:
            String r125 = r101.text_draft_id;
            if (r125 == null) goto L71;
            r102.encodeWithTag(r100, 33, r125);
        L71:
            String r126 = r101.post_draft_id;
            if (r126 == null) goto L74;
            r102.encodeWithTag(r100, 34, r126);
        L74:
            Integer r127 = r101.no_badged_new_message_count;
            if (r127 == null) goto L77;
            ProtoAdapter.INT32.encodeWithTag(r100, 35, r127);
        L77:
            Boolean r128 = r101.is_shortcut;
            if (r128 == null) goto L80;
            ProtoAdapter.BOOL.encodeWithTag(r100, 36, r128);
        L80:
            Announcement r129 = r101.announcement;
            if (r129 == null) goto L83;
            Announcement.ADAPTER.encodeWithTag(r100, 37, r129);
        L83:
            Boolean r130 = r101.off_edit_group_chat_info;
            if (r130 == null) goto L86;
            ProtoAdapter.BOOL.encodeWithTag(r100, 38, r130);
        L86:
            String r131 = r101.tenant_id;
            if (r131 == null) goto L89;
            r102.encodeWithTag(r100, 39, r131);
        L89:
            Boolean r132 = r101.is_custom_icon;
            if (r132 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r100, 40, r132);
        L92:
            Boolean r133 = r101.is_dissolved;
            if (r133 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r100, 41, r133);
        L95:
            MessagePosition.Enum r134 = r101.message_position;
            if (r134 == null) goto L98;
            MessagePosition.Enum.ADAPTER.encodeWithTag(r100, 42, r134);
        L98:
            FeedCard.FeedType r135 = r101.feed_type;
            if (r135 == null) goto L101;
            FeedCard.FeedType.ADAPTER.encodeWithTag(r100, 43, r135);
        L101:
            String r136 = r101.last_visible_message_id;
            if (r136 == null) goto L104;
            r102.encodeWithTag(r100, 44, r136);
        L104:
            Integer r137 = r101.burn_life;
            if (r137 == null) goto L107;
            ProtoAdapter.INT32.encodeWithTag(r100, 45, r137);
        L107:
            Boolean r138 = r101.is_crypto;
            if (r138 == null) goto L110;
            ProtoAdapter.BOOL.encodeWithTag(r100, 46, r138);
        L110:
            Boolean r139 = r101.is_meeting;
            if (r139 == null) goto L113;
            ProtoAdapter.BOOL.encodeWithTag(r100, 47, r139);
        L113:
            Boolean r140 = r101.is_cross_tenant;
            if (r140 == null) goto L116;
            ProtoAdapter.BOOL.encodeWithTag(r100, 48, r140);
        L116:
            Boolean r141 = r101.is_support_view;
            if (r141 == null) goto L119;
            ProtoAdapter.BOOL.encodeWithTag(r100, 49, r141);
        L119:
            Integer r142 = r101.first_message_position;
            if (r142 == null) goto L122;
            ProtoAdapter.INT32.encodeWithTag(r100, 50, r142);
        L122:
            String r143 = r101.oncall_id;
            if (r143 == null) goto L125;
            r102.encodeWithTag(r100, 51, r143);
        L125:
            Integer r144 = r101.last_visible_message_position;
            if (r144 == null) goto L128;
            ProtoAdapter.INT32.encodeWithTag(r100, 52, r144);
        L128:
            Integer r145 = r101.read_position;
            if (r145 == null) goto L131;
            ProtoAdapter.INT32.encodeWithTag(r100, 53, r145);
        L131:
            Integer r146 = r101.read_position_badge_count;
            if (r146 == null) goto L134;
            ProtoAdapter.INT32.encodeWithTag(r100, 54, r146);
        L134:
            Integer r147 = r101.last_message_position_badge_count;
            if (r147 == null) goto L137;
            ProtoAdapter.INT32.encodeWithTag(r100, 55, r147);
        L137:
            Boolean r148 = r101.is_public_v2;
            if (r148 == null) goto L140;
            ProtoAdapter.BOOL.encodeWithTag(r100, 56, r148);
        L140:
            Boolean r149 = r101.allow_post;
            if (r149 == null) goto L143;
            ProtoAdapter.BOOL.encodeWithTag(r100, 57, r149);
        L143:
            PostType r150 = r101.post_type;
            if (r150 == null) goto L146;
            PostType.ADAPTER.encodeWithTag(r100, 58, r150);
        L146:
            ChatMode r151 = r101.chat_mode;
            if (r151 == null) goto L149;
            ChatMode.ADAPTER.encodeWithTag(r100, 60, r151);
        L149:
            String r152 = r101.last_thread_id;
            if (r152 == null) goto L152;
            r102.encodeWithTag(r100, 61, r152);
        L152:
            Integer r153 = r101.last_thread_position;
            if (r153 == null) goto L155;
            ProtoAdapter.INT32.encodeWithTag(r100, 62, r153);
        L155:
            Integer r154 = r101.new_thread_count;
            if (r154 == null) goto L158;
            ProtoAdapter.INT32.encodeWithTag(r100, 63, r154);
        L158:
            Integer r155 = r101.no_badged_new_thread_count;
            if (r155 == null) goto L161;
            ProtoAdapter.INT32.encodeWithTag(r100, 64, r155);
        L161:
            Integer r156 = r101.last_thread_position_badge_count;
            if (r156 == null) goto L164;
            ProtoAdapter.INT32.encodeWithTag(r100, 65, r156);
        L164:
            Integer r157 = r101.read_thread_position;
            if (r157 == null) goto L167;
            ProtoAdapter.INT32.encodeWithTag(r100, 66, r157);
        L167:
            Integer r158 = r101.read_thread_position_badge_count;
            if (r158 == null) goto L170;
            ProtoAdapter.INT32.encodeWithTag(r100, 67, r158);
        L170:
            Integer r159 = r101.last_visible_thread_position;
            if (r159 == null) goto L173;
            ProtoAdapter.INT32.encodeWithTag(r100, 68, r159);
        L173:
            String r160 = r101.last_visible_thread_id;
            if (r160 == null) goto L176;
            r102.encodeWithTag(r100, 69, r160);
        L176:
            Boolean r161 = r101.show_nickname;
            if (r161 == null) goto L179;
            ProtoAdapter.BOOL.encodeWithTag(r100, 70, r161);
        L179:
            String r162 = r101.last_draft_id;
            if (r162 == null) goto L182;
            r102.encodeWithTag(r100, 71, r162);
        L182:
            Integer r163 = r101.last_read_position;
            if (r163 == null) goto L185;
            ProtoAdapter.INT32.encodeWithTag(r100, 72, r163);
        L185:
            Float r164 = r101.last_read_offset;
            if (r164 == null) goto L188;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 73, r164);
        L188:
            Boolean r165 = r101.is_edu;
            if (r165 == null) goto L191;
            ProtoAdapter.BOOL.encodeWithTag(r100, 74, r165);
        L191:
            Boolean r166 = r101.is_admin;
            if (r166 == null) goto L194;
            ProtoAdapter.BOOL.encodeWithTag(r100, 75, r166);
        L194:
            Boolean r167 = r101.is_mute_at_all;
            if (r167 == null) goto L197;
            ProtoAdapter.BOOL.encodeWithTag(r100, 76, r167);
        L197:
            Boolean r168 = r101.is_delayed;
            if (r168 == null) goto L200;
            ProtoAdapter.BOOL.encodeWithTag(r100, 77, r168);
        L200:
            Boolean r169 = r101.is_p2p_ai;
            if (r169 == null) goto L203;
            ProtoAdapter.BOOL.encodeWithTag(r100, 78, r169);
        L203:
            Boolean r170 = r101.is_ocic_customer_service;
            if (r170 == null) goto L206;
            ProtoAdapter.BOOL.encodeWithTag(r100, 79, r170);
        L206:
            Boolean r171 = r101.is_p2p_official_bot_ai;
            if (r171 == null) goto L209;
            ProtoAdapter.BOOL.encodeWithTag(r100, 80, r171);
        L209:
            Boolean r172 = r101.is_temp_top_feed;
            if (r172 == null) goto L212;
            ProtoAdapter.BOOL.encodeWithTag(r100, 81, r172);
        L212:
            AddMemberPermission.Enum r173 = r101.add_member_permission;
            if (r173 == null) goto L215;
            AddMemberPermission.Enum.ADAPTER.encodeWithTag(r100, 100, r173);
        L215:
            AtAllPermission.Enum r174 = r101.at_all_permission;
            if (r174 == null) goto L218;
            AtAllPermission.Enum.ADAPTER.encodeWithTag(r100, 101, r174);
        L218:
            SystemMessageVisible.Enum r175 = r101.join_message_visible;
            if (r175 == null) goto L221;
            SystemMessageVisible.Enum.ADAPTER.encodeWithTag(r100, 102, r175);
        L221:
            SystemMessageVisible.Enum r176 = r101.quit_message_visible;
            if (r176 == null) goto L224;
            SystemMessageVisible.Enum.ADAPTER.encodeWithTag(r100, 103, r176);
        L224:
            ShareCardPermission.Enum r177 = r101.share_card_permission;
            if (r177 == null) goto L227;
            ShareCardPermission.Enum.ADAPTER.encodeWithTag(r100, 104, r177);
        L227:
            AddMemberApply.Enum r178 = r101.add_member_apply;
            if (r178 == null) goto L230;
            AddMemberApply.Enum.ADAPTER.encodeWithTag(r100, 105, r178);
        L230:
            MessageVisibilitySetting.Enum r179 = r101.message_visibility_setting;
            if (r179 == null) goto L233;
            MessageVisibilitySetting.Enum.ADAPTER.encodeWithTag(r100, 118, r179);
        L233:
            CreateUrgentSetting.Enum r180 = r101.create_urgent_setting;
            if (r180 == null) goto L236;
            CreateUrgentSetting.Enum.ADAPTER.encodeWithTag(r100, 120, r180);
        L236:
            CreateVideoConferenceSetting.Enum r181 = r101.create_video_conference_setting;
            if (r181 == null) goto L239;
            CreateVideoConferenceSetting.Enum.ADAPTER.encodeWithTag(r100, 121, r181);
        L239:
            PinPermissionSetting.Enum r182 = r101.pin_permission_setting;
            if (r182 == null) goto L242;
            PinPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 122, r182);
        L242:
            TopNoticePermissionSetting.Enum r183 = r101.top_notice_permission_setting;
            if (r183 == null) goto L245;
            TopNoticePermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 123, r183);
        L245:
            ChatTabPermissionSetting.Enum r184 = r101.chat_tab_permission_setting;
            if (r184 == null) goto L248;
            ChatTabPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 124, r184);
        L248:
            ChatDisplayModeSetting.Enum r185 = r101.chat_display_mode_setting;
            if (r185 == null) goto L251;
            ChatDisplayModeSetting.Enum.ADAPTER.encodeWithTag(r100, 125, r185);
        L251:
            ChatPinPermissionSetting.Enum r186 = r101.chat_pin_permission_setting;
            if (r186 == null) goto L254;
            ChatPinPermissionSetting.Enum.ADAPTER.encodeWithTag(r100, 126, r186);
        L254:
            Integer r187 = r101.put_chatter_apply_count;
            if (r187 == null) goto L257;
            ProtoAdapter.INT32.encodeWithTag(r100, 106, r187);
        L257:
            Boolean r188 = r101.show_banner;
            if (r188 == null) goto L260;
            ProtoAdapter.BOOL.encodeWithTag(r100, 107, r188);
        L260:
            String r189 = r101.mini_avatar_key;
            if (r189 == null) goto L263;
            r102.encodeWithTag(r100, 108, r189);
        L263:
            String r190 = r101.sidebar_id;
            if (r190 == null) goto L266;
            r102.encodeWithTag(r100, 109, r190);
        L266:
            SideBarButton.ADAPTER.asRepeated().encodeWithTag(r100, 110, r101.sidebar_buttons);
            Long r191 = r101.my_threads_read_timestamp;
            if (r191 == null) goto L269;
            ProtoAdapter.INT64.encodeWithTag(r100, 111, r191);
        L269:
            Long r192 = r101.my_threads_last_timestamp;
            if (r192 == null) goto L272;
            ProtoAdapter.INT64.encodeWithTag(r100, 112, r192);
        L272:
            Integer r193 = r101.my_threads_unread_count;
            if (r193 == null) goto L275;
            ProtoAdapter.INT32.encodeWithTag(r100, 113, r193);
        L275:
            String r194 = r101.my_threads_last_display_message_id;
            if (r194 == null) goto L278;
            r102.encodeWithTag(r100, 114, r194);
        L278:
            AnonymousSetting.Enum r195 = r101.anonymous_setting;
            if (r195 == null) goto L281;
            AnonymousSetting.Enum.ADAPTER.encodeWithTag(r100, 115, r195);
        L281:
            Long r196 = r101.anonymous_total_quota;
            if (r196 == null) goto L284;
            ProtoAdapter.INT64.encodeWithTag(r100, 116, r196);
        L284:
            Boolean r197 = r101.is_cross_with_ka;
            if (r197 == null) goto L287;
            ProtoAdapter.BOOL.encodeWithTag(r100, 117, r197);
        L287:
            String r198 = r101.anonymous_id;
            if (r198 == null) goto L290;
            r102.encodeWithTag(r100, 119, r198);
        L290:
            Boolean r199 = r101.is_team;
            if (r199 == null) goto L293;
            ProtoAdapter.BOOL.encodeWithTag(r100, 127, r199);
        L293:
            Long r200 = r101.team_id;
            if (r200 == null) goto L296;
            ProtoAdapter.INT64.encodeWithTag(r100, 128, r200);
        L296:
            String r201 = r101.team_name;
            if (r201 == null) goto L299;
            r102.encodeWithTag(r100, 129, r201);
        L299:
            TeamChatType r202 = r101.team_chat_type;
            if (r202 == null) goto L302;
            TeamChatType.ADAPTER.encodeWithTag(r100, 130, r202);
        L302:
            this.chatter_extra_states.encodeWithTag(r100, 131, r101.chatter_extra_states);
            ProtoAdapter<ChatTeamInfo> r203 = ChatTeamInfo.ADAPTER;
            r203.asRepeated().encodeWithTag(r100, 132, r101.joined_team_infos);
            this.joined_teams.encodeWithTag(r100, 133, r101.joined_teams);
            r203.asRepeated().encodeWithTag(r100, 134, r101.bound_team_infos);
            ChatUserAutoMuteSetting r204 = r101.user_auto_mute;
            if (r204 == null) goto L305;
            ChatUserAutoMuteSetting.ADAPTER.encodeWithTag(r100, 135, r204);
        L305:
            Long r205 = r101.ai_knowledge_query_id;
            if (r205 == null) goto L308;
            ProtoAdapter.INT64.encodeWithTag(r100, 136, r205);
        L308:
            Long r206 = r101.query_create_time;
            if (r206 == null) goto L311;
            ProtoAdapter.INT64.encodeWithTag(r100, 137, r206);
        L311:
            CommonAIReply.Status r207 = r101.query_status;
            if (r207 == null) goto L314;
            CommonAIReply.Status.ADAPTER.encodeWithTag(r100, 138, r207);
        L314:
            Integer r208 = r101.query_seq_id;
            if (r208 == null) goto L317;
            ProtoAdapter.INT32.encodeWithTag(r100, 139, r208);
        L317:
            String r209 = r101.edit_message_draft_id;
            if (r209 == null) goto L320;
            r102.encodeWithTag(r100, 150, r209);
        L320:
            Boolean r210 = r101.chatable;
            if (r210 == null) goto L323;
            ProtoAdapter.BOOL.encodeWithTag(r100, 200, r210);
        L323:
            Boolean r211 = r101.muteable;
            if (r211 == null) goto L326;
            ProtoAdapter.BOOL.encodeWithTag(r100, 201, r211);
        L326:
            Boolean r212 = r101.is_super;
            if (r212 == null) goto L329;
            ProtoAdapter.BOOL.encodeWithTag(r100, 202, r212);
        L329:
            Boolean r213 = r101.is_private_mode;
            if (r213 == null) goto L332;
            ProtoAdapter.BOOL.encodeWithTag(r100, 203, r213);
        L332:
            Boolean r214 = r101.is_tenant;
            if (r214 == null) goto L335;
            ProtoAdapter.BOOL.encodeWithTag(r100, 220, r214);
        L335:
            Boolean r215 = r101.is_in_box;
            if (r215 == null) goto L338;
            ProtoAdapter.BOOL.encodeWithTag(r100, 221, r215);
        L338:
            String r216 = r101.box_id;
            if (r216 == null) goto L341;
            r102.encodeWithTag(r100, 222, r216);
        L341:
            Boolean r217 = r101.is_auto_translate;
            if (r217 == null) goto L344;
            ProtoAdapter.BOOL.encodeWithTag(r100, 223, r217);
        L344:
            Boolean r218 = r101.is_auto_typing_translate;
            if (r218 == null) goto L347;
            ProtoAdapter.BOOL.encodeWithTag(r100, 224, r218);
        L347:
            TypingTranslateSetting r219 = r101.typing_translate_setting;
            if (r219 == null) goto L350;
            TypingTranslateSetting.ADAPTER.encodeWithTag(r100, 225, r219);
        L350:
            FeedTag.ADAPTER.asRepeated().encodeWithTag(r100, 226, r101.feed_tag);
            Boolean r220 = r101.is_flag;
            if (r220 == null) goto L353;
            ProtoAdapter.BOOL.encodeWithTag(r100, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, r220);
        L353:
            Boolean r221 = r101.has_water_mark;
            if (r221 == null) goto L356;
            ProtoAdapter.BOOL.encodeWithTag(r100, 250, r221);
        L356:
            String r222 = r101.avatar_path;
            if (r222 == null) goto L359;
            r102.encodeWithTag(r100, 251, r222);
        L359:
            r102.asRepeated().encodeWithTag(r100, 252, r101.avatar_urls);
            Integer r223 = r101.first_chat_message_position;
            if (r223 == null) goto L362;
            ProtoAdapter.INT32.encodeWithTag(r100, 253, r223);
        L362:
            TagData r224 = r101.tag_info;
            if (r224 == null) goto L365;
            TagData.ADAPTER.encodeWithTag(r100, 254, r224);
        L365:
            Boolean r225 = r101.is_fake;
            if (r225 == null) goto L368;
            ProtoAdapter.BOOL.encodeWithTag(r100, 255, r225);
        L368:
            Boolean r226 = r101.typing_translate_has_auto_opened;
            if (r226 == null) goto L371;
            ProtoAdapter.BOOL.encodeWithTag(r100, 256, r226);
        L371:
            Boolean r227 = r101.is_official_oncall;
            if (r227 == null) goto L374;
            ProtoAdapter.BOOL.encodeWithTag(r100, TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG, r227);
        L374:
            Boolean r228 = r101.is_offline_oncall;
            if (r228 == null) goto L377;
            ProtoAdapter.BOOL.encodeWithTag(r100, 351, r228);
        L377:
            RestrictedModeSetting r229 = r101.restricted_mode_setting;
            if (r229 == null) goto L380;
            RestrictedModeSetting.ADAPTER.encodeWithTag(r100, 352, r229);
        L380:
            DefDisplaySetting.Enum r230 = r101.def_display_setting;
            if (r230 == null) goto L383;
            DefDisplaySetting.Enum.ADAPTER.encodeWithTag(r100, 353, r230);
        L383:
            String r231 = r101.schedule_message_draft_id;
            if (r231 == null) goto L386;
            r102.encodeWithTag(r100, 354, r231);
        L386:
            Boolean r232 = r101.has_vc_chat_permission;
            if (r232 == null) goto L389;
            ProtoAdapter.BOOL.encodeWithTag(r100, 355, r232);
        L389:
            AdminPostSetting.Enum r233 = r101.admin_post_setting;
            if (r233 == null) goto L392;
            AdminPostSetting.Enum.ADAPTER.encodeWithTag(r100, 356, r233);
        L392:
            Boolean r234 = r101.can_be_sorted_alphabetically;
            if (r234 == null) goto L395;
            ProtoAdapter.BOOL.encodeWithTag(r100, 357, r234);
        L395:
            UserCountVisibleSetting.Enum r235 = r101.user_count_visible_setting;
            if (r235 == null) goto L398;
            UserCountVisibleSetting.Enum.ADAPTER.encodeWithTag(r100, 358, r235);
        L398:
            Boolean r236 = r101.is_user_count_visible;
            if (r236 == null) goto L401;
            ProtoAdapter.BOOL.encodeWithTag(r100, 359, r236);
        L401:
            DoubaoSetting r237 = r101.doubao_setting;
            if (r237 == null) goto L404;
            DoubaoSetting.ADAPTER.encodeWithTag(r100, 360, r237);
        L404:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 400, r101.tags);
            Long r238 = r101.theme_id;
            if (r238 == null) goto L407;
            ProtoAdapter.INT64.encodeWithTag(r100, 401, r238);
        L407:
            Boolean r239 = r101.is_frozen;
            if (r239 == null) goto L410;
            ProtoAdapter.BOOL.encodeWithTag(r100, 402, r239);
        L410:
            BannerSetting r240 = r101.banner_setting;
            if (r240 == null) goto L413;
            BannerSetting.ADAPTER.encodeWithTag(r100, 403, r240);
        L413:
            Boolean r241 = r101.can_translate_name;
            if (r241 == null) goto L416;
            ProtoAdapter.BOOL.encodeWithTag(r100, 404, r241);
        L416:
            Boolean r242 = r101.should_display_translated_name;
            if (r242 == null) goto L419;
            ProtoAdapter.BOOL.encodeWithTag(r100, 405, r242);
        L419:
            String r243 = r101.translated_name;
            if (r243 == null) goto L422;
            r102.encodeWithTag(r100, 406, r243);
        L422:
            String r244 = r101.name_major_language;
            if (r244 == null) goto L425;
            r102.encodeWithTag(r100, 407, r244);
        L425:
            String r245 = r101.name_translate_language;
            if (r245 == null) goto L428;
            r102.encodeWithTag(r100, 408, r245);
        L428:
            TnsInfo r246 = r101.tns_info;
            if (r246 == null) goto L431;
            TnsInfo.ADAPTER.encodeWithTag(r100, 409, r246);
        L431:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Chat r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RestrictedModeSetting extends com.squareup.wire.Message<RestrictedModeSetting, Builder> {
        public static final ProtoAdapter<RestrictedModeSetting> ADAPTER = null;
        public static final Participant DEFAULT_COPY = null;
        public static final Participant DEFAULT_DOWNLOAD = null;
        public static final Participant DEFAULT_FORWARD = null;
        public static final Participant DEFAULT_SCREENSHOT = null;
        public static final Boolean DEFAULT_SWITCH_ = null;
        private static final long serialVersionUID = 0;
        public final Participant copy;
        public final Participant download;
        public final Participant forward;
        public final OnTimeDelMsgSetting on_time_del_msg_setting;
        public final Participant screenshot;
        public final Boolean switch_;
        public final WhiteListSetting white_list_setting;

        public static final class Builder extends com.squareup.wire.Message.Builder<RestrictedModeSetting, Builder> {
            public Participant copy;
            public Participant download;
            public Participant forward;
            public OnTimeDelMsgSetting on_time_del_msg_setting;
            public Participant screenshot;
            public Boolean switch_;
            public WhiteListSetting white_list_setting;

            @Override // com.squareup.wire.Message.Builder
            public RestrictedModeSetting build() {
                return new RestrictedModeSetting(this.switch_, this.copy, this.forward, this.download, this.screenshot, this.on_time_del_msg_setting, this.white_list_setting, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder copy(Participant r100) {
                this.copy = r100;
                return this;
            }

            public Builder download(Participant r100) {
                this.download = r100;
                return this;
            }

            public Builder forward(Participant r100) {
                this.forward = r100;
                return this;
            }

            public Builder on_time_del_msg_setting(OnTimeDelMsgSetting r100) {
                this.on_time_del_msg_setting = r100;
                return this;
            }

            public Builder screenshot(Participant r100) {
                this.screenshot = r100;
                return this;
            }

            public Builder switch_(Boolean r100) {
                this.switch_ = r100;
                return this;
            }

            public Builder white_list_setting(WhiteListSetting r100) {
                this.white_list_setting = r100;
                return this;
            }
        }

        public static final class OnTimeDelMsgSetting extends com.squareup.wire.Message<OnTimeDelMsgSetting, Builder> {
            public static final ProtoAdapter<OnTimeDelMsgSetting> ADAPTER = null;
            public static final Long DEFAULT_ALIVE_TIME = null;
            public static final Boolean DEFAULT_STATUS = null;
            private static final long serialVersionUID = 0;
            public final Long alive_time;
            public final Boolean status;

            public static final class Builder extends com.squareup.wire.Message.Builder<OnTimeDelMsgSetting, Builder> {
                public Long alive_time;
                public Boolean status;

                @Override // com.squareup.wire.Message.Builder
                public OnTimeDelMsgSetting build() {
                    return new OnTimeDelMsgSetting(this.status, this.alive_time, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder alive_time(Long r100) {
                    this.alive_time = r100;
                    return this;
                }

                public Builder status(Boolean r100) {
                    this.status = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_OnTimeDelMsgSetting extends ProtoAdapter<OnTimeDelMsgSetting> {
                public ProtoAdapter_OnTimeDelMsgSetting() {
                    super(FieldEncoding.LENGTH_DELIMITED, OnTimeDelMsgSetting.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public OnTimeDelMsgSetting decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.status = Boolean.FALSE;
                    r101.alive_time = 0L;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.status = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.alive_time = ProtoAdapter.INT64.decode(r100);
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
                public int encodedSize2(OnTimeDelMsgSetting r100) {
                    Boolean r101 = r100.status;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
                L6:
                    Long r104 = r100.alive_time;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ OnTimeDelMsgSetting decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(OnTimeDelMsgSetting r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, OnTimeDelMsgSetting r101) throws IOException {
                    Boolean r102 = r101.status;
                    if (r102 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
                L5:
                    Long r103 = r101.alive_time;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnTimeDelMsgSetting r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_OnTimeDelMsgSetting();
                DEFAULT_STATUS = Boolean.FALSE;
                DEFAULT_ALIVE_TIME = 0L;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.status = this.status;
                r100.alive_time = this.alive_time;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return OnTimeDelMsgSetting.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public OnTimeDelMsgSetting(Boolean r100, Long r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public OnTimeDelMsgSetting(Boolean r100, Long r101, ByteString r102) {
                super(ADAPTER, r102);
                this.status = r100;
                this.alive_time = r101;
            }
        }

        public static final enum Participant extends Enum<Participant> implements WireEnum {
            private static final /* synthetic */ Participant[] $VALUES = null;
            public static final ProtoAdapter<Participant> ADAPTER = null;
            public static final Participant ALL_MEMBERS = null;
            public static final Participant NO_MEMBER = null;
            public static final Participant UNKNOWN = null;
            private final int value;

            static {
                Participant r100 = new Participant("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Participant r101 = new Participant("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Participant r102 = new Participant("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
                $VALUES = new Participant[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Participant.class);
            }

            public static Participant[] values() {
                return (Participant[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Participant fromValue(int r100) {
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

            public static Participant valueOf(String r100) {
                return (Participant) a.a(Participant.class, r100);
            }

            private Participant(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_RestrictedModeSetting extends ProtoAdapter<RestrictedModeSetting> {
            public ProtoAdapter_RestrictedModeSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, RestrictedModeSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RestrictedModeSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.switch_ = Boolean.FALSE;
                Participant r102 = Participant.NO_MEMBER;
                r101.copy = r102;
                r101.forward = r102;
                r101.download = r102;
                r101.screenshot = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L26;
                switch(r104) {
                    case 1: goto L25;
                    case 2: goto L28;
                    case 3: goto L32;
                    case 4: goto L34;
                    case 5: goto L30;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L28:
                r101.copy = Participant.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r101.screenshot = Participant.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.forward = Participant.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L34:
                r101.download = Participant.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.white_list_setting = WhiteListSetting.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.on_time_del_msg_setting = OnTimeDelMsgSetting.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.switch_ = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(RestrictedModeSetting r100) {
                Boolean r101 = r100.switch_;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Participant r104 = r100.copy;
                if (r104 == null) goto L9;
                int r105 = Participant.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Participant r107 = r100.forward;
                if (r107 == null) goto L13;
                int r108 = Participant.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Participant r110 = r100.download;
                if (r110 == null) goto L17;
                int r111 = Participant.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Participant r113 = r100.screenshot;
                if (r113 == null) goto L21;
                int r114 = Participant.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                OnTimeDelMsgSetting r116 = r100.on_time_del_msg_setting;
                if (r116 == null) goto L25;
                int r117 = OnTimeDelMsgSetting.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                WhiteListSetting r119 = r100.white_list_setting;
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
            public /* bridge */ /* synthetic */ RestrictedModeSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RestrictedModeSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RestrictedModeSetting r101) throws IOException {
                Boolean r102 = r101.switch_;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Participant r103 = r101.copy;
                if (r103 == null) goto L8;
                Participant.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Participant r104 = r101.forward;
                if (r104 == null) goto L11;
                Participant.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Participant r105 = r101.download;
                if (r105 == null) goto L14;
                Participant.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                Participant r106 = r101.screenshot;
                if (r106 == null) goto L17;
                Participant.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                OnTimeDelMsgSetting r107 = r101.on_time_del_msg_setting;
                if (r107 == null) goto L20;
                OnTimeDelMsgSetting.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                WhiteListSetting r108 = r101.white_list_setting;
                if (r108 == null) goto L23;
                WhiteListSetting.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RestrictedModeSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RestrictedModeSetting();
            DEFAULT_SWITCH_ = Boolean.FALSE;
            Participant r100 = Participant.NO_MEMBER;
            DEFAULT_COPY = r100;
            DEFAULT_FORWARD = r100;
            DEFAULT_DOWNLOAD = r100;
            DEFAULT_SCREENSHOT = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.switch_ = this.switch_;
            r100.copy = this.copy;
            r100.forward = this.forward;
            r100.download = this.download;
            r100.screenshot = this.screenshot;
            r100.on_time_del_msg_setting = this.on_time_del_msg_setting;
            r100.white_list_setting = this.white_list_setting;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RestrictedModeSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public RestrictedModeSetting(Boolean r110, Participant r111, Participant r112, Participant r113, Participant r114, OnTimeDelMsgSetting r115, WhiteListSetting r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public RestrictedModeSetting(Boolean r100, Participant r101, Participant r102, Participant r103, Participant r104, OnTimeDelMsgSetting r105, WhiteListSetting r106, ByteString r107) {
            super(ADAPTER, r107);
            this.switch_ = r100;
            this.copy = r101;
            this.forward = r102;
            this.download = r103;
            this.screenshot = r104;
            this.on_time_del_msg_setting = r105;
            this.white_list_setting = r106;
        }
    }

    public static final enum Role extends Enum<Role> implements WireEnum {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final Role IGNORE = null;
        public static final Role MEMBER = null;
        public static final Role THREAD_FOLLOWER = null;
        public static final Role VISITOR = null;
        private final int value;

        static {
            Role r100 = new Role("IGNORE", 0, 0);
            IGNORE = r100;
            Role r101 = new Role("MEMBER", 1, 1);
            MEMBER = r101;
            Role r102 = new Role("VISITOR", 2, 2);
            VISITOR = r102;
            Role r103 = new Role("THREAD_FOLLOWER", 3, 3);
            THREAD_FOLLOWER = r103;
            $VALUES = new Role[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Role.class);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Role fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return THREAD_FOLLOWER;
        L14:
            return VISITOR;
        L16:
            return MEMBER;
        L18:
            return IGNORE;
        }

        public static Role valueOf(String r100) {
            return (Role) a.a(Role.class, r100);
        }

        private Role(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ShareCardPermission extends com.squareup.wire.Message<ShareCardPermission, Builder> {
        public static final ProtoAdapter<ShareCardPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShareCardPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ShareCardPermission build() {
                return new ShareCardPermission(super.buildUnknownFields());
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

        public static final class ProtoAdapter_ShareCardPermission extends ProtoAdapter<ShareCardPermission> {
            public ProtoAdapter_ShareCardPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareCardPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShareCardPermission decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ShareCardPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShareCardPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShareCardPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShareCardPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareCardPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareCardPermission();
        }

        public ShareCardPermission() {
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
            return ShareCardPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShareCardPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class SystemMessageVisible extends com.squareup.wire.Message<SystemMessageVisible, Builder> {
        public static final ProtoAdapter<SystemMessageVisible> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<SystemMessageVisible, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public SystemMessageVisible build() {
                return new SystemMessageVisible(super.buildUnknownFields());
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

        public static final class ProtoAdapter_SystemMessageVisible extends ProtoAdapter<SystemMessageVisible> {
            public ProtoAdapter_SystemMessageVisible() {
                super(FieldEncoding.LENGTH_DELIMITED, SystemMessageVisible.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SystemMessageVisible decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(SystemMessageVisible r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SystemMessageVisible decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SystemMessageVisible r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SystemMessageVisible r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemMessageVisible r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SystemMessageVisible();
        }

        public SystemMessageVisible() {
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
            return SystemMessageVisible.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SystemMessageVisible(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class TnsInfo extends com.squareup.wire.Message<TnsInfo, Builder> {
        public static final ProtoAdapter<TnsInfo> ADAPTER = null;
        public static final TnsOpKind DEFAULT_OP_KIND = null;
        private static final long serialVersionUID = 0;
        public final TnsOpKind op_kind;
        public final TnsSystemBannedInfo system_banned_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<TnsInfo, Builder> {
            public TnsOpKind op_kind;
            public TnsSystemBannedInfo system_banned_info;

            @Override // com.squareup.wire.Message.Builder
            public TnsInfo build() {
                return new TnsInfo(this.op_kind, this.system_banned_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder op_kind(TnsOpKind r100) {
                this.op_kind = r100;
                return this;
            }

            public Builder system_banned_info(TnsSystemBannedInfo r100) {
                this.system_banned_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TnsInfo extends ProtoAdapter<TnsInfo> {
            public ProtoAdapter_TnsInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TnsInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TnsInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.op_kind = TnsOpKind.TNS_OP_NONE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.op_kind = TnsOpKind.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.system_banned_info = TnsSystemBannedInfo.ADAPTER.decode(r100);
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
            public int encodedSize2(TnsInfo r100) {
                TnsOpKind r101 = r100.op_kind;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TnsOpKind.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                TnsSystemBannedInfo r104 = r100.system_banned_info;
                if (r104 == null) goto L10;
                r102 = TnsSystemBannedInfo.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TnsInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TnsInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TnsInfo r101) throws IOException {
                TnsOpKind r102 = r101.op_kind;
                if (r102 == null) goto L5;
                TnsOpKind.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                TnsSystemBannedInfo r103 = r101.system_banned_info;
                if (r103 == null) goto L8;
                TnsSystemBannedInfo.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TnsInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TnsInfo();
            DEFAULT_OP_KIND = TnsOpKind.TNS_OP_NONE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.op_kind = this.op_kind;
            r100.system_banned_info = this.system_banned_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TnsInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TnsInfo(TnsOpKind r100, TnsSystemBannedInfo r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TnsInfo(TnsOpKind r100, TnsSystemBannedInfo r101, ByteString r102) {
            super(ADAPTER, r102);
            this.op_kind = r100;
            this.system_banned_info = r101;
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

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type TOPIC_GROUP = null;
        private final int value;

        static {
            Type r100 = new Type("P2P", 0, 1);
            P2P = r100;
            Type r101 = new Type("GROUP", 1, 2);
            GROUP = r101;
            Type r102 = new Type("TOPIC_GROUP", 2, 3);
            TOPIC_GROUP = r102;
            $VALUES = new Type[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return TOPIC_GROUP;
        L13:
            return GROUP;
        L15:
            return P2P;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TypingTranslateSetting extends com.squareup.wire.Message<TypingTranslateSetting, Builder> {
        public static final ProtoAdapter<TypingTranslateSetting> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN_V3 = null;
        public static final AutoOpenCloseMode DEFAULT_CLOSE_MODE = null;
        public static final Boolean DEFAULT_ENABLE_USE_TRANSLATED_ORIGINAL = null;
        public static final Boolean DEFAULT_IS_OPEN = null;
        public static final OpenMode DEFAULT_OPEN_MODE = null;
        public static final String DEFAULT_TARGET_LANGUAGE = "";
        public static final Long DEFAULT_UPDATE_TIME_NS = null;
        private static final long serialVersionUID = 0;
        public final Boolean can_auto_open_v3;
        public final AutoOpenCloseMode close_mode;
        public final Boolean enable_use_translated_original;
        public final Boolean is_open;
        public final OpenMode open_mode;
        public final String target_language;
        public final Long update_time_ns;

        public static final enum AutoOpenCloseMode extends Enum<AutoOpenCloseMode> implements WireEnum {
            private static final /* synthetic */ AutoOpenCloseMode[] $VALUES = null;
            public static final ProtoAdapter<AutoOpenCloseMode> ADAPTER = null;
            public static final AutoOpenCloseMode CLOSE_DIRECTLY = null;
            public static final AutoOpenCloseMode CLOSE_NO_LONGER_OPEN = null;
            public static final AutoOpenCloseMode CLOSE_POPUP = null;
            public static final AutoOpenCloseMode CLOSE_UNKNOWN = null;
            private final int value;

            static {
                AutoOpenCloseMode r100 = new AutoOpenCloseMode("CLOSE_UNKNOWN", 0, 0);
                CLOSE_UNKNOWN = r100;
                AutoOpenCloseMode r101 = new AutoOpenCloseMode("CLOSE_DIRECTLY", 1, 1);
                CLOSE_DIRECTLY = r101;
                AutoOpenCloseMode r102 = new AutoOpenCloseMode("CLOSE_POPUP", 2, 2);
                CLOSE_POPUP = r102;
                AutoOpenCloseMode r103 = new AutoOpenCloseMode("CLOSE_NO_LONGER_OPEN", 3, 3);
                CLOSE_NO_LONGER_OPEN = r103;
                $VALUES = new AutoOpenCloseMode[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(AutoOpenCloseMode.class);
            }

            public static AutoOpenCloseMode[] values() {
                return (AutoOpenCloseMode[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static AutoOpenCloseMode fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return CLOSE_NO_LONGER_OPEN;
            L14:
                return CLOSE_POPUP;
            L16:
                return CLOSE_DIRECTLY;
            L18:
                return CLOSE_UNKNOWN;
            }

            public static AutoOpenCloseMode valueOf(String r100) {
                return (AutoOpenCloseMode) a.a(AutoOpenCloseMode.class, r100);
            }

            private AutoOpenCloseMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<TypingTranslateSetting, Builder> {
            public Boolean can_auto_open_v3;
            public AutoOpenCloseMode close_mode;
            public Boolean enable_use_translated_original;
            public Boolean is_open;
            public OpenMode open_mode;
            public String target_language;
            public Long update_time_ns;

            @Override // com.squareup.wire.Message.Builder
            public TypingTranslateSetting build() {
                return new TypingTranslateSetting(this.is_open, this.target_language, this.enable_use_translated_original, this.update_time_ns, this.open_mode, this.can_auto_open_v3, this.close_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder can_auto_open_v3(Boolean r100) {
                this.can_auto_open_v3 = r100;
                return this;
            }

            public Builder close_mode(AutoOpenCloseMode r100) {
                this.close_mode = r100;
                return this;
            }

            public Builder enable_use_translated_original(Boolean r100) {
                this.enable_use_translated_original = r100;
                return this;
            }

            public Builder is_open(Boolean r100) {
                this.is_open = r100;
                return this;
            }

            public Builder open_mode(OpenMode r100) {
                this.open_mode = r100;
                return this;
            }

            public Builder target_language(String r100) {
                this.target_language = r100;
                return this;
            }

            public Builder update_time_ns(Long r100) {
                this.update_time_ns = r100;
                return this;
            }
        }

        public static final enum OpenMode extends Enum<OpenMode> implements WireEnum {
            private static final /* synthetic */ OpenMode[] $VALUES = null;
            public static final ProtoAdapter<OpenMode> ADAPTER = null;
            public static final OpenMode AUTO = null;
            public static final OpenMode MANUAL = null;
            public static final OpenMode UNKNOWN = null;
            private final int value;

            static {
                OpenMode r100 = new OpenMode("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                OpenMode r101 = new OpenMode("MANUAL", 1, 1);
                MANUAL = r101;
                OpenMode r102 = new OpenMode("AUTO", 2, 2);
                AUTO = r102;
                $VALUES = new OpenMode[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(OpenMode.class);
            }

            public static OpenMode[] values() {
                return (OpenMode[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static OpenMode fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return AUTO;
            L12:
                return MANUAL;
            L14:
                return UNKNOWN;
            }

            public static OpenMode valueOf(String r100) {
                return (OpenMode) a.a(OpenMode.class, r100);
            }

            private OpenMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_TypingTranslateSetting extends ProtoAdapter<TypingTranslateSetting> {
            public ProtoAdapter_TypingTranslateSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, TypingTranslateSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TypingTranslateSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_open = r102;
                r101.target_language = "";
                r101.enable_use_translated_original = r102;
                r101.update_time_ns = 0L;
                r101.open_mode = OpenMode.UNKNOWN;
                r101.can_auto_open_v3 = r102;
                r101.close_mode = AutoOpenCloseMode.CLOSE_UNKNOWN;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L20;
                switch(r104) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L22;
                    case 6: goto L11;
                    case 7: goto L6;
                    case 8: goto L24;
                    default: goto L6;
                };
            L22:
                r101.open_mode = OpenMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L24:
                r101.close_mode = AutoOpenCloseMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.can_auto_open_v3 = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.update_time_ns = ProtoAdapter.INT64.decode(r100);
                goto L3
            L17:
                r101.enable_use_translated_original = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L18:
                r101.target_language = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.is_open = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(TypingTranslateSetting r100) {
                Boolean r101 = r100.is_open;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.target_language;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.enable_use_translated_original;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Long r110 = r100.update_time_ns;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                OpenMode r113 = r100.open_mode;
                if (r113 == null) goto L21;
                int r114 = OpenMode.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.can_auto_open_v3;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                AutoOpenCloseMode r119 = r100.close_mode;
                if (r119 == null) goto L30;
                r102 = AutoOpenCloseMode.ADAPTER.encodedSizeWithTag(8, r119);
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
            public /* bridge */ /* synthetic */ TypingTranslateSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TypingTranslateSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TypingTranslateSetting r101) throws IOException {
                Boolean r102 = r101.is_open;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.target_language;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.enable_use_translated_original;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Long r105 = r101.update_time_ns;
                if (r105 == null) goto L14;
                ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
            L14:
                OpenMode r106 = r101.open_mode;
                if (r106 == null) goto L17;
                OpenMode.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.can_auto_open_v3;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                AutoOpenCloseMode r108 = r101.close_mode;
                if (r108 == null) goto L23;
                AutoOpenCloseMode.ADAPTER.encodeWithTag(r100, 8, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TypingTranslateSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TypingTranslateSetting();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_OPEN = r100;
            DEFAULT_ENABLE_USE_TRANSLATED_ORIGINAL = r100;
            DEFAULT_UPDATE_TIME_NS = 0L;
            DEFAULT_OPEN_MODE = OpenMode.UNKNOWN;
            DEFAULT_CAN_AUTO_OPEN_V3 = r100;
            DEFAULT_CLOSE_MODE = AutoOpenCloseMode.CLOSE_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_open = this.is_open;
            r100.target_language = this.target_language;
            r100.enable_use_translated_original = this.enable_use_translated_original;
            r100.update_time_ns = this.update_time_ns;
            r100.open_mode = this.open_mode;
            r100.can_auto_open_v3 = this.can_auto_open_v3;
            r100.close_mode = this.close_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TypingTranslateSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TypingTranslateSetting(Boolean r110, String r111, Boolean r112, Long r113, OpenMode r114, Boolean r115, AutoOpenCloseMode r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public TypingTranslateSetting(Boolean r100, String r101, Boolean r102, Long r103, OpenMode r104, Boolean r105, AutoOpenCloseMode r106, ByteString r107) {
            super(ADAPTER, r107);
            this.is_open = r100;
            this.target_language = r101;
            this.enable_use_translated_original = r102;
            this.update_time_ns = r103;
            this.open_mode = r104;
            this.can_auto_open_v3 = r105;
            this.close_mode = r106;
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

    public static final class WhiteListSetting extends com.squareup.wire.Message<WhiteListSetting, Builder> {
        public static final ProtoAdapter<WhiteListSetting> ADAPTER = null;
        public static final Boolean DEFAULT_HIT_WHITELIST = null;
        public static final LevelEnum DEFAULT_LEVEL = null;
        private static final long serialVersionUID = 0;
        public final List<Long> add_user_ids;
        public final List<Long> del_user_ids;
        public final Boolean hit_whitelist;
        public final LevelEnum level;
        public final List<Long> member_list_user_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<WhiteListSetting, Builder> {
            public List<Long> add_user_ids;
            public List<Long> del_user_ids;
            public Boolean hit_whitelist;
            public LevelEnum level;
            public List<Long> member_list_user_ids;

            @Override // com.squareup.wire.Message.Builder
            public WhiteListSetting build() {
                return new WhiteListSetting(this.level, this.add_user_ids, this.del_user_ids, this.member_list_user_ids, this.hit_whitelist, super.buildUnknownFields());
            }

            public Builder() {
                this.add_user_ids = Internal.newMutableList();
                this.del_user_ids = Internal.newMutableList();
                this.member_list_user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder add_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.add_user_ids = r100;
                return this;
            }

            public Builder del_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.del_user_ids = r100;
                return this;
            }

            public Builder hit_whitelist(Boolean r100) {
                this.hit_whitelist = r100;
                return this;
            }

            public Builder level(LevelEnum r100) {
                this.level = r100;
                return this;
            }

            public Builder member_list_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.member_list_user_ids = r100;
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
                r101.level = LevelEnum.NO_MEMBER;
                r101.hit_whitelist = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.level = LevelEnum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.add_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.del_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.member_list_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.hit_whitelist = ProtoAdapter.BOOL.decode(r100);
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
                LevelEnum r101 = r100.level;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = LevelEnum.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
                int r105 = ((r103 + r104.asRepeated().encodedSizeWithTag(2, r100.add_user_ids)) + r104.asRepeated().encodedSizeWithTag(3, r100.del_user_ids)) + r104.asRepeated().encodedSizeWithTag(4, r100.member_list_user_ids);
                Boolean r106 = r100.hit_whitelist;
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
                LevelEnum r102 = r101.level;
                if (r102 == null) goto L5;
                LevelEnum.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                r103.asRepeated().encodeWithTag(r100, 2, r101.add_user_ids);
                r103.asRepeated().encodeWithTag(r100, 3, r101.del_user_ids);
                r103.asRepeated().encodeWithTag(r100, 4, r101.member_list_user_ids);
                Boolean r104 = r101.hit_whitelist;
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
            DEFAULT_LEVEL = LevelEnum.NO_MEMBER;
            DEFAULT_HIT_WHITELIST = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.level = this.level;
            r100.add_user_ids = Internal.copyOf("add_user_ids", this.add_user_ids);
            r100.del_user_ids = Internal.copyOf("del_user_ids", this.del_user_ids);
            r100.member_list_user_ids = Internal.copyOf("member_list_user_ids", this.member_list_user_ids);
            r100.hit_whitelist = this.hit_whitelist;
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
            this.level = r100;
            this.add_user_ids = Internal.immutableCopyOf("add_user_ids", r101);
            this.del_user_ids = Internal.immutableCopyOf("del_user_ids", r102);
            this.member_list_user_ids = Internal.immutableCopyOf("member_list_user_ids", r103);
            this.hit_whitelist = r104;
        }
    }

    public static final enum WidgetState extends Enum<WidgetState> implements WireEnum {
        private static final /* synthetic */ WidgetState[] $VALUES = null;
        public static final ProtoAdapter<WidgetState> ADAPTER = null;
        public static final WidgetState EXPAND = null;
        public static final WidgetState FOLD = null;
        private final int value;

        static {
            WidgetState r100 = new WidgetState("EXPAND", 0, 0);
            EXPAND = r100;
            WidgetState r101 = new WidgetState("FOLD", 1, 1);
            FOLD = r101;
            $VALUES = new WidgetState[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(WidgetState.class);
        }

        public static WidgetState[] values() {
            return (WidgetState[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static WidgetState fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return FOLD;
        L10:
            return EXPAND;
        }

        public static WidgetState valueOf(String r100) {
            return (WidgetState) a.a(WidgetState.class, r100);
        }

        private WidgetState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Chat();
        DEFAULT_TYPE = Type.P2P;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_CHATTER_COUNT = 0;
        DEFAULT_USER_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DEPARTMENT = r100;
        DEFAULT_IS_PUBLIC = r100;
        DEFAULT_IS_ARCHIVED = r100;
        DEFAULT_IS_DELETED = r100;
        Boolean r101 = Boolean.TRUE;
        DEFAULT_IS_REMIND = r101;
        DEFAULT_ROLE = Role.IGNORE;
        DEFAULT_IS_CUSTOMER_SERVICE = r100;
        DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = 0;
        DEFAULT_IS_SHORTCUT = r100;
        DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = r100;
        DEFAULT_IS_CUSTOM_ICON = r100;
        DEFAULT_IS_DISSOLVED = r100;
        DEFAULT_MESSAGE_POSITION = MessagePosition.Enum.RECENT_LEFT;
        DEFAULT_FEED_TYPE = FeedCard.FeedType.INBOX;
        DEFAULT_BURN_LIFE = 0;
        DEFAULT_IS_CRYPTO = r100;
        DEFAULT_IS_MEETING = r100;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_IS_SUPPORT_VIEW = r100;
        DEFAULT_FIRST_MESSAGE_POSITION = -1;
        DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = 0;
        DEFAULT_READ_POSITION = 0;
        DEFAULT_READ_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = 0;
        DEFAULT_IS_PUBLIC_V2 = r100;
        DEFAULT_ALLOW_POST = r101;
        DEFAULT_POST_TYPE = PostType.UNKNOWN_POST_TYPE;
        DEFAULT_CHAT_MODE = ChatMode.DEFAULT;
        DEFAULT_LAST_THREAD_POSITION = 0;
        DEFAULT_NEW_THREAD_COUNT = 0;
        DEFAULT_NO_BADGED_NEW_THREAD_COUNT = 0;
        DEFAULT_LAST_THREAD_POSITION_BADGE_COUNT = 0;
        DEFAULT_READ_THREAD_POSITION = 0;
        DEFAULT_READ_THREAD_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_VISIBLE_THREAD_POSITION = 0;
        DEFAULT_SHOW_NICKNAME = r100;
        DEFAULT_LAST_READ_POSITION = -1;
        DEFAULT_LAST_READ_OFFSET = Float.valueOf(0.0f);
        DEFAULT_IS_EDU = r100;
        DEFAULT_IS_ADMIN = r100;
        DEFAULT_IS_MUTE_AT_ALL = r100;
        DEFAULT_IS_DELAYED = r100;
        DEFAULT_IS_P2P_AI = r100;
        DEFAULT_IS_OCIC_CUSTOMER_SERVICE = r100;
        DEFAULT_IS_P2P_OFFICIAL_BOT_AI = r100;
        DEFAULT_IS_TEMP_TOP_FEED = r100;
        DEFAULT_ADD_MEMBER_PERMISSION = AddMemberPermission.Enum.ALL_MEMBERS;
        DEFAULT_AT_ALL_PERMISSION = AtAllPermission.Enum.ALL_MEMBERS;
        SystemMessageVisible.Enum r102 = SystemMessageVisible.Enum.ONLY_OWNER;
        DEFAULT_JOIN_MESSAGE_VISIBLE = r102;
        DEFAULT_QUIT_MESSAGE_VISIBLE = r102;
        DEFAULT_SHARE_CARD_PERMISSION = ShareCardPermission.Enum.ALLOWED;
        DEFAULT_ADD_MEMBER_APPLY = AddMemberApply.Enum.NO_APPLY;
        DEFAULT_MESSAGE_VISIBILITY_SETTING = MessageVisibilitySetting.Enum.ALL_MESSAGES;
        DEFAULT_CREATE_URGENT_SETTING = CreateUrgentSetting.Enum.ALL_MEMBERS;
        DEFAULT_CREATE_VIDEO_CONFERENCE_SETTING = CreateVideoConferenceSetting.Enum.ALL_MEMBERS;
        DEFAULT_PIN_PERMISSION_SETTING = PinPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_TOP_NOTICE_PERMISSION_SETTING = TopNoticePermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_CHAT_TAB_PERMISSION_SETTING = ChatTabPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_CHAT_DISPLAY_MODE_SETTING = ChatDisplayModeSetting.Enum.UNKNOWN;
        DEFAULT_CHAT_PIN_PERMISSION_SETTING = ChatPinPermissionSetting.Enum.UNKNOWN;
        DEFAULT_PUT_CHATTER_APPLY_COUNT = 0;
        DEFAULT_SHOW_BANNER = r100;
        DEFAULT_MY_THREADS_READ_TIMESTAMP = 0L;
        DEFAULT_MY_THREADS_LAST_TIMESTAMP = 0L;
        DEFAULT_MY_THREADS_UNREAD_COUNT = 0;
        DEFAULT_ANONYMOUS_SETTING = AnonymousSetting.Enum.INVISIBLE;
        DEFAULT_ANONYMOUS_TOTAL_QUOTA = 0L;
        DEFAULT_IS_CROSS_WITH_KA = r100;
        DEFAULT_IS_TEAM = r100;
        DEFAULT_TEAM_ID = 0L;
        DEFAULT_TEAM_CHAT_TYPE = TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
        DEFAULT_AI_KNOWLEDGE_QUERY_ID = 0L;
        DEFAULT_QUERY_CREATE_TIME = 0L;
        DEFAULT_QUERY_STATUS = CommonAIReply.Status.UNKNOWN_STATUS;
        DEFAULT_QUERY_SEQ_ID = 0;
        DEFAULT_CHATABLE = r101;
        DEFAULT_MUTEABLE = r101;
        DEFAULT_IS_SUPER = r100;
        DEFAULT_IS_PRIVATE_MODE = r100;
        DEFAULT_IS_TENANT = r100;
        DEFAULT_IS_IN_BOX = r100;
        DEFAULT_IS_AUTO_TRANSLATE = r100;
        DEFAULT_IS_AUTO_TYPING_TRANSLATE = r101;
        DEFAULT_IS_FLAG = r100;
        DEFAULT_HAS_WATER_MARK = r100;
        DEFAULT_FIRST_CHAT_MESSAGE_POSITION = -1;
        DEFAULT_IS_FAKE = r100;
        DEFAULT_TYPING_TRANSLATE_HAS_AUTO_OPENED = r100;
        DEFAULT_IS_OFFICIAL_ONCALL = r100;
        DEFAULT_IS_OFFLINE_ONCALL = r100;
        DEFAULT_DEF_DISPLAY_SETTING = DefDisplaySetting.Enum.INPUT_BOX;
        DEFAULT_HAS_VC_CHAT_PERMISSION = r100;
        DEFAULT_ADMIN_POST_SETTING = AdminPostSetting.Enum.ALLOW_POST;
        DEFAULT_CAN_BE_SORTED_ALPHABETICALLY = r100;
        DEFAULT_USER_COUNT_VISIBLE_SETTING = UserCountVisibleSetting.Enum.UNKNOWN;
        DEFAULT_IS_USER_COUNT_VISIBLE = r101;
        DEFAULT_THEME_ID = 0L;
        DEFAULT_IS_FROZEN = r100;
        DEFAULT_CAN_TRANSLATE_NAME = r100;
        DEFAULT_SHOULD_DISPLAY_TRANSLATED_NAME = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253446id = this.f253445id;
        r100.type = this.type;
        r100.name = this.name;
        r100.last_message_id = this.last_message_id;
        r100.last_message_position = this.last_message_position;
        r100.new_message_count = this.new_message_count;
        r100.update_time = this.update_time;
        r100.avatar_key = this.avatar_key;
        r100.chatter_id = this.chatter_id;
        r100.create_time = this.create_time;
        r100.description = this.description;
        r100.avatar = this.avatar;
        r100.owner_id = this.owner_id;
        r100.chatter_count = this.chatter_count;
        r100.user_count = this.user_count;
        r100.is_department = this.is_department;
        r100.is_public = this.is_public;
        r100.is_archived = this.is_archived;
        r100.is_deleted = this.is_deleted;
        r100.is_remind = this.is_remind;
        r100.name_pinyin = this.name_pinyin;
        r100.role = this.role;
        r100.is_customer_service = this.is_customer_service;
        r100.text_draft_id = this.text_draft_id;
        r100.post_draft_id = this.post_draft_id;
        r100.no_badged_new_message_count = this.no_badged_new_message_count;
        r100.is_shortcut = this.is_shortcut;
        r100.announcement = this.announcement;
        r100.off_edit_group_chat_info = this.off_edit_group_chat_info;
        r100.tenant_id = this.tenant_id;
        r100.is_custom_icon = this.is_custom_icon;
        r100.is_dissolved = this.is_dissolved;
        r100.message_position = this.message_position;
        r100.feed_type = this.feed_type;
        r100.last_visible_message_id = this.last_visible_message_id;
        r100.burn_life = this.burn_life;
        r100.is_crypto = this.is_crypto;
        r100.is_meeting = this.is_meeting;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.is_support_view = this.is_support_view;
        r100.first_message_position = this.first_message_position;
        r100.oncall_id = this.oncall_id;
        r100.last_visible_message_position = this.last_visible_message_position;
        r100.read_position = this.read_position;
        r100.read_position_badge_count = this.read_position_badge_count;
        r100.last_message_position_badge_count = this.last_message_position_badge_count;
        r100.is_public_v2 = this.is_public_v2;
        r100.allow_post = this.allow_post;
        r100.post_type = this.post_type;
        r100.chat_mode = this.chat_mode;
        r100.last_thread_id = this.last_thread_id;
        r100.last_thread_position = this.last_thread_position;
        r100.new_thread_count = this.new_thread_count;
        r100.no_badged_new_thread_count = this.no_badged_new_thread_count;
        r100.last_thread_position_badge_count = this.last_thread_position_badge_count;
        r100.read_thread_position = this.read_thread_position;
        r100.read_thread_position_badge_count = this.read_thread_position_badge_count;
        r100.last_visible_thread_position = this.last_visible_thread_position;
        r100.last_visible_thread_id = this.last_visible_thread_id;
        r100.show_nickname = this.show_nickname;
        r100.last_draft_id = this.last_draft_id;
        r100.last_read_position = this.last_read_position;
        r100.last_read_offset = this.last_read_offset;
        r100.is_edu = this.is_edu;
        r100.is_admin = this.is_admin;
        r100.is_mute_at_all = this.is_mute_at_all;
        r100.is_delayed = this.is_delayed;
        r100.is_p2p_ai = this.is_p2p_ai;
        r100.is_ocic_customer_service = this.is_ocic_customer_service;
        r100.is_p2p_official_bot_ai = this.is_p2p_official_bot_ai;
        r100.is_temp_top_feed = this.is_temp_top_feed;
        r100.add_member_permission = this.add_member_permission;
        r100.at_all_permission = this.at_all_permission;
        r100.join_message_visible = this.join_message_visible;
        r100.quit_message_visible = this.quit_message_visible;
        r100.share_card_permission = this.share_card_permission;
        r100.add_member_apply = this.add_member_apply;
        r100.message_visibility_setting = this.message_visibility_setting;
        r100.create_urgent_setting = this.create_urgent_setting;
        r100.create_video_conference_setting = this.create_video_conference_setting;
        r100.pin_permission_setting = this.pin_permission_setting;
        r100.top_notice_permission_setting = this.top_notice_permission_setting;
        r100.chat_tab_permission_setting = this.chat_tab_permission_setting;
        r100.chat_display_mode_setting = this.chat_display_mode_setting;
        r100.chat_pin_permission_setting = this.chat_pin_permission_setting;
        r100.put_chatter_apply_count = this.put_chatter_apply_count;
        r100.show_banner = this.show_banner;
        r100.mini_avatar_key = this.mini_avatar_key;
        r100.sidebar_id = this.sidebar_id;
        r100.sidebar_buttons = Internal.copyOf("sidebar_buttons", this.sidebar_buttons);
        r100.my_threads_read_timestamp = this.my_threads_read_timestamp;
        r100.my_threads_last_timestamp = this.my_threads_last_timestamp;
        r100.my_threads_unread_count = this.my_threads_unread_count;
        r100.my_threads_last_display_message_id = this.my_threads_last_display_message_id;
        r100.anonymous_setting = this.anonymous_setting;
        r100.anonymous_total_quota = this.anonymous_total_quota;
        r100.is_cross_with_ka = this.is_cross_with_ka;
        r100.anonymous_id = this.anonymous_id;
        r100.is_team = this.is_team;
        r100.team_id = this.team_id;
        r100.team_name = this.team_name;
        r100.team_chat_type = this.team_chat_type;
        r100.chatter_extra_states = Internal.copyOf("chatter_extra_states", this.chatter_extra_states);
        r100.joined_team_infos = Internal.copyOf("joined_team_infos", this.joined_team_infos);
        r100.joined_teams = Internal.copyOf("joined_teams", this.joined_teams);
        r100.bound_team_infos = Internal.copyOf("bound_team_infos", this.bound_team_infos);
        r100.user_auto_mute = this.user_auto_mute;
        r100.ai_knowledge_query_id = this.ai_knowledge_query_id;
        r100.query_create_time = this.query_create_time;
        r100.query_status = this.query_status;
        r100.query_seq_id = this.query_seq_id;
        r100.edit_message_draft_id = this.edit_message_draft_id;
        r100.chatable = this.chatable;
        r100.muteable = this.muteable;
        r100.is_super = this.is_super;
        r100.is_private_mode = this.is_private_mode;
        r100.is_tenant = this.is_tenant;
        r100.is_in_box = this.is_in_box;
        r100.box_id = this.box_id;
        r100.is_auto_translate = this.is_auto_translate;
        r100.is_auto_typing_translate = this.is_auto_typing_translate;
        r100.typing_translate_setting = this.typing_translate_setting;
        r100.feed_tag = Internal.copyOf("feed_tag", this.feed_tag);
        r100.is_flag = this.is_flag;
        r100.has_water_mark = this.has_water_mark;
        r100.avatar_path = this.avatar_path;
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.first_chat_message_position = this.first_chat_message_position;
        r100.tag_info = this.tag_info;
        r100.is_fake = this.is_fake;
        r100.typing_translate_has_auto_opened = this.typing_translate_has_auto_opened;
        r100.is_official_oncall = this.is_official_oncall;
        r100.is_offline_oncall = this.is_offline_oncall;
        r100.restricted_mode_setting = this.restricted_mode_setting;
        r100.def_display_setting = this.def_display_setting;
        r100.schedule_message_draft_id = this.schedule_message_draft_id;
        r100.has_vc_chat_permission = this.has_vc_chat_permission;
        r100.admin_post_setting = this.admin_post_setting;
        r100.can_be_sorted_alphabetically = this.can_be_sorted_alphabetically;
        r100.user_count_visible_setting = this.user_count_visible_setting;
        r100.is_user_count_visible = this.is_user_count_visible;
        r100.doubao_setting = this.doubao_setting;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.theme_id = this.theme_id;
        r100.is_frozen = this.is_frozen;
        r100.banner_setting = this.banner_setting;
        r100.can_translate_name = this.can_translate_name;
        r100.should_display_translated_name = this.should_display_translated_name;
        r100.translated_name = this.translated_name;
        r100.name_major_language = this.name_major_language;
        r100.name_translate_language = this.name_translate_language;
        r100.tns_info = this.tns_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Chat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }
}
