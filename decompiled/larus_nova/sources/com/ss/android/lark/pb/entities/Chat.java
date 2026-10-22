package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
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

/* JADX INFO: loaded from: classes37.dex */
public final class Chat extends com.squareup.wire.Message<Chat, Builder> {
    public static final ProtoAdapter<Chat> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_POST = null;
    public static final Long DEFAULT_BURNED_TIME = null;
    public static final Long DEFAULT_CHAT_CHATTER_VERSION = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_ENABLE_WATERMARK = null;
    public static final Long DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT_VERSION = null;
    public static final Integer DEFAULT_FIRST_CHAT_MESSAGE_POSITION = null;
    public static final Boolean DEFAULT_HAS_CHAT_MENU = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ADMIN = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT_V1 = null;
    public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_CUSTOMER_SERVICE = null;
    public static final Boolean DEFAULT_IS_CUSTOM_ICON = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_DEPARTMENT_V1 = null;
    public static final Boolean DEFAULT_IS_DISSOLVED = null;
    public static final Boolean DEFAULT_IS_EDU = null;
    public static final Boolean DEFAULT_IS_FROZEN = null;
    public static final Boolean DEFAULT_IS_INVISIBLE = null;
    public static final Boolean DEFAULT_IS_LARGE_GROUP = null;
    public static final Boolean DEFAULT_IS_MEETING = null;
    public static final Boolean DEFAULT_IS_P2P_AI = null;
    public static final Boolean DEFAULT_IS_P2P_OFFICIAL_BOT_AI = null;
    public static final Boolean DEFAULT_IS_PRIVATE_MODE = null;
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Boolean DEFAULT_IS_PUBLIC_V2 = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SAME_PAGE_MEETING = null;
    public static final Boolean DEFAULT_IS_SUPER = null;
    public static final Boolean DEFAULT_IS_TEAM = null;
    public static final Boolean DEFAULT_IS_TENANT = null;
    public static final Long DEFAULT_JOIN_TIME_MS = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final String DEFAULT_LAST_THREAD_ID = "";
    public static final Integer DEFAULT_LAST_THREAD_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Integer DEFAULT_LAST_THREAD_POSITION = null;
    public static final Integer DEFAULT_LAST_THREAD_POSITION_BADGE_COUNT = null;
    public static final String DEFAULT_LAST_VISIBLE_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_MESSAGE_NO_BADGED_COUNT = null;
    public static final Integer DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = null;
    public static final String DEFAULT_LAST_VISIBLE_THREAD_ID = "";
    public static final Integer DEFAULT_LAST_VISIBLE_THREAD_POSITION = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Long DEFAULT_MY_THREADS_LAST_DISPLAY_MESSAGE_ID = null;
    public static final Long DEFAULT_MY_THREADS_LAST_TIMESTAMP = null;
    public static final Long DEFAULT_MY_THREADS_READ_TIMESTAMP = null;
    public static final Integer DEFAULT_MY_THREADS_UNREAD_COUNT = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_NAME_PY = "";
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NEW_THREAD_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_THREAD_COUNT = null;
    public static final Boolean DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = null;
    public static final Long DEFAULT_ONCALL_ID = null;
    public static final String DEFAULT_OPEN_CHAT_ID = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final Integer DEFAULT_PUT_CHATTER_APPLY_COUNT = null;
    public static final Integer DEFAULT_READ_POSITION = null;
    public static final Integer DEFAULT_READ_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_THREAD_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = null;
    public static final Boolean DEFAULT_SHOW_BANNER = null;
    public static final String DEFAULT_SIDEBAR_ID = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final Integer DEFAULT_THREAD_START_POSITION = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    public static final Long DEFAULT_USER_CLEAN_MESSAGE_TIME_MS = null;
    public static final Integer DEFAULT_USER_COUNT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mallow_post;
    public final Announcement mannouncement;
    public final Image mavatar;
    public final BannerSetting mbanner_setting;
    public final ChatBizContent mbiz_content;
    public final Map<Integer, Long> mbiz_version_map;
    public final Long mburned_time;
    public final Long mchat_chatter_version;
    public final ChatConfig mchat_config;
    public final ChatEntitySetting mchat_entity_setting;
    public final GeneralChatSetting mchat_general_setting;
    public final ChatMode mchat_mode;
    public final ChatSecurityConfig mchat_security_config;
    public final Map<Integer, Integer> mchatter_extra_states;
    public final Long mcreate_time;
    public final CryptoChatInfo mcrypto_chat_info;
    public final String mdescription;
    public final Boolean menable_watermark;
    public final Map<String, String> mextra;
    public final Long mfilter_mute_bot_badge_count_version;
    public final Integer mfirst_chat_message_position;
    public final Map<Integer, Boolean> mgroup_type;
    public final Boolean mhas_chat_menu;
    public final I18nInf mi18n_inf;
    public final Map<String, String> mi18n_names;
    public final String mid;
    public final Boolean mis_admin;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_cross_tenant_v1;
    public final Boolean mis_cross_with_ka;
    public final Boolean mis_crypto;
    public final Boolean mis_custom_icon;
    public final Boolean mis_customer_service;
    public final Boolean mis_department;
    public final Boolean mis_department_v1;
    public final Boolean mis_dissolved;
    public final Boolean mis_edu;
    public final Boolean mis_frozen;
    public final Boolean mis_invisible;
    public final Boolean mis_large_group;
    public final Boolean mis_meeting;
    public final Boolean mis_p2p_ai;
    public final Boolean mis_p2p_official_bot_ai;
    public final Boolean mis_private_mode;
    public final Boolean mis_public;
    public final Boolean mis_public_v2;
    public final Boolean mis_remind;
    public final Boolean mis_same_page_meeting;
    public final Boolean mis_super;
    public final Boolean mis_team;
    public final Boolean mis_tenant;
    public final Long mjoin_time_ms;
    public final String mkey;
    public final String mlast_message_id;
    public final Integer mlast_message_position;
    public final Integer mlast_message_position_badge_count;
    public final Integer mlast_message_position_filter_mute_bot_badge_count;
    public final String mlast_thread_id;
    public final Integer mlast_thread_message_position_filter_mute_bot_badge_count;
    public final Integer mlast_thread_position;
    public final Integer mlast_thread_position_badge_count;
    public final String mlast_visible_message_id;
    public final Integer mlast_visible_message_no_badged_count;
    public final Integer mlast_visible_message_position;
    public final String mlast_visible_thread_id;
    public final Integer mlast_visible_thread_position;
    public final Integer mmember_count;
    public final MessageLastVisibleInfoPatch mmessage_last_visible_patch;
    public final Image mmini_avatar;
    public final Long mmy_threads_last_display_message_id;
    public final Long mmy_threads_last_timestamp;
    public final Long mmy_threads_read_timestamp;
    public final Integer mmy_threads_unread_count;
    public final String mname;
    public final String mname_pinyin;
    public final String mname_py;
    public final Integer mnew_message_count;
    public final Integer mnew_thread_count;
    public final Integer mno_badged_new_message_count;
    public final Integer mno_badged_new_thread_count;
    public final Boolean moff_edit_group_chat_info;
    public final Long moncall_id;
    public final String mopen_chat_id;
    public final String mowner_id;
    public final ChatPostType mpost_type;
    public final Integer mput_chatter_apply_count;
    public final Integer mread_position;
    public final Integer mread_position_badge_count;
    public final Integer mread_position_filter_mute_bot_badge_count;
    public final Integer mread_thread_position;
    public final Integer mread_thread_position_badge_count;
    public final Integer mread_thread_position_filter_mute_bot_badge_count;
    public final Role mrole;
    public final Boolean mshow_banner;
    public final String msidebar_id;
    public final Status mstatus;
    public final SupportView msupport_view;
    public final SystemBannedInfo msystem_banned_info;
    public final TagData mtag_data;
    public final List<Integer> mtags;
    public final String mtenant_id;
    public final MessageLastVisibleInfoPatch mthread_last_visible_patch;
    public final Integer mthread_start_position;
    public final TnsOpKind mtns_op_kind;
    public final ChatToolkit mtoolkit;
    public final Type mtype;
    public final Long mupdate_time;
    public final Long mupdate_time_ms;
    public final ChatUserAutoMuteSetting muser_auto_mute_setting;
    public final Long muser_clean_message_time_ms;
    public final Integer muser_count;
    public final ChatSetting muser_setting;

    public static final class Announcement extends com.squareup.wire.Message<Announcement, Builder> {
        public static final ProtoAdapter<Announcement> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_DOC_URL = "";
        public static final Boolean DEFAULT_ENABLE_OPENDOC = null;
        public static final String DEFAULT_LAST_EDITOR_ID = "";
        public static final Long DEFAULT_UPDATE_TIME = null;
        public static final Boolean DEFAULT_USE_OPENDOC = null;
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mdoc_url;
        public final Boolean menable_opendoc;
        public final String mlast_editor_id;
        public final Long mupdate_time;
        public final Boolean muse_opendoc;

        public static final class Builder extends com.squareup.wire.Message.Builder<Announcement, Builder> {
            public String mcontent;
            public String mdoc_url;
            public Boolean menable_opendoc;
            public String mlast_editor_id;
            public Long mupdate_time;
            public Boolean muse_opendoc;

            @Override // com.squareup.wire.Message.Builder
            public Announcement build() {
                return new Announcement(this.mcontent, this.mupdate_time, this.mlast_editor_id, this.mdoc_url, this.menable_opendoc, this.muse_opendoc, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder doc_url(String r100) {
                this.mdoc_url = r100;
                return this;
            }

            public Builder enable_opendoc(Boolean r100) {
                this.menable_opendoc = r100;
                return this;
            }

            public Builder last_editor_id(String r100) {
                this.mlast_editor_id = r100;
                return this;
            }

            public Builder update_time(Long r100) {
                this.mupdate_time = r100;
                return this;
            }

            public Builder use_opendoc(Boolean r100) {
                this.muse_opendoc = r100;
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
                r101.mcontent = "";
                r101.mupdate_time = 0L;
                r101.mlast_editor_id = "";
                r101.mdoc_url = "";
                r101.menable_opendoc = Boolean.FALSE;
                r101.muse_opendoc = Boolean.TRUE;
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
                r101.muse_opendoc = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.menable_opendoc = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.mdoc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mlast_editor_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.mcontent;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.mupdate_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mlast_editor_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mdoc_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.menable_opendoc;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.muse_opendoc;
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
                String r102 = r101.mcontent;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.mupdate_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mlast_editor_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mdoc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.menable_opendoc;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.muse_opendoc;
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
            DEFAULT_ENABLE_OPENDOC = Boolean.FALSE;
            DEFAULT_USE_OPENDOC = Boolean.TRUE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcontent = this.mcontent;
            r100.mupdate_time = this.mupdate_time;
            r100.mlast_editor_id = this.mlast_editor_id;
            r100.mdoc_url = this.mdoc_url;
            r100.menable_opendoc = this.menable_opendoc;
            r100.muse_opendoc = this.muse_opendoc;
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
            this.mcontent = r100;
            this.mupdate_time = r101;
            this.mlast_editor_id = r102;
            this.mdoc_url = r103;
            this.menable_opendoc = r104;
            this.muse_opendoc = r105;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Chat, Builder> {
        public Boolean mallow_post;
        public Announcement mannouncement;
        public Image mavatar;
        public BannerSetting mbanner_setting;
        public ChatBizContent mbiz_content;
        public Map<Integer, Long> mbiz_version_map;
        public Long mburned_time;
        public Long mchat_chatter_version;
        public ChatConfig mchat_config;
        public ChatEntitySetting mchat_entity_setting;
        public GeneralChatSetting mchat_general_setting;
        public ChatMode mchat_mode;
        public ChatSecurityConfig mchat_security_config;
        public Map<Integer, Integer> mchatter_extra_states;
        public Long mcreate_time;
        public CryptoChatInfo mcrypto_chat_info;
        public String mdescription;
        public Boolean menable_watermark;
        public Map<String, String> mextra;
        public Long mfilter_mute_bot_badge_count_version;
        public Integer mfirst_chat_message_position;
        public Map<Integer, Boolean> mgroup_type;
        public Boolean mhas_chat_menu;
        public I18nInf mi18n_inf;
        public Map<String, String> mi18n_names;
        public String mid;
        public Boolean mis_admin;
        public Boolean mis_cross_tenant;
        public Boolean mis_cross_tenant_v1;
        public Boolean mis_cross_with_ka;
        public Boolean mis_crypto;
        public Boolean mis_custom_icon;
        public Boolean mis_customer_service;
        public Boolean mis_department;
        public Boolean mis_department_v1;
        public Boolean mis_dissolved;
        public Boolean mis_edu;
        public Boolean mis_frozen;
        public Boolean mis_invisible;
        public Boolean mis_large_group;
        public Boolean mis_meeting;
        public Boolean mis_p2p_ai;
        public Boolean mis_p2p_official_bot_ai;
        public Boolean mis_private_mode;
        public Boolean mis_public;
        public Boolean mis_public_v2;
        public Boolean mis_remind;
        public Boolean mis_same_page_meeting;
        public Boolean mis_super;
        public Boolean mis_team;
        public Boolean mis_tenant;
        public Long mjoin_time_ms;
        public String mkey;
        public String mlast_message_id;
        public Integer mlast_message_position;
        public Integer mlast_message_position_badge_count;
        public Integer mlast_message_position_filter_mute_bot_badge_count;
        public String mlast_thread_id;
        public Integer mlast_thread_message_position_filter_mute_bot_badge_count;
        public Integer mlast_thread_position;
        public Integer mlast_thread_position_badge_count;
        public String mlast_visible_message_id;
        public Integer mlast_visible_message_no_badged_count;
        public Integer mlast_visible_message_position;
        public String mlast_visible_thread_id;
        public Integer mlast_visible_thread_position;
        public Integer mmember_count;
        public MessageLastVisibleInfoPatch mmessage_last_visible_patch;
        public Image mmini_avatar;
        public Long mmy_threads_last_display_message_id;
        public Long mmy_threads_last_timestamp;
        public Long mmy_threads_read_timestamp;
        public Integer mmy_threads_unread_count;
        public String mname;
        public String mname_pinyin;
        public String mname_py;
        public Integer mnew_message_count;
        public Integer mnew_thread_count;
        public Integer mno_badged_new_message_count;
        public Integer mno_badged_new_thread_count;
        public Boolean moff_edit_group_chat_info;
        public Long moncall_id;
        public String mopen_chat_id;
        public String mowner_id;
        public ChatPostType mpost_type;
        public Integer mput_chatter_apply_count;
        public Integer mread_position;
        public Integer mread_position_badge_count;
        public Integer mread_position_filter_mute_bot_badge_count;
        public Integer mread_thread_position;
        public Integer mread_thread_position_badge_count;
        public Integer mread_thread_position_filter_mute_bot_badge_count;
        public Role mrole;
        public Boolean mshow_banner;
        public String msidebar_id;
        public Status mstatus;
        public SupportView msupport_view;
        public SystemBannedInfo msystem_banned_info;
        public TagData mtag_data;
        public List<Integer> mtags;
        public String mtenant_id;
        public MessageLastVisibleInfoPatch mthread_last_visible_patch;
        public Integer mthread_start_position;
        public TnsOpKind mtns_op_kind;
        public ChatToolkit mtoolkit;
        public Type mtype;
        public Long mupdate_time;
        public Long mupdate_time_ms;
        public ChatUserAutoMuteSetting muser_auto_mute_setting;
        public Long muser_clean_message_time_ms;
        public Integer muser_count;
        public ChatSetting muser_setting;

        @Override // com.squareup.wire.Message.Builder
        public Chat build() {
            return new Chat(this.mid, this.mtype, this.mlast_message_id, this.mname, this.mavatar, this.mowner_id, this.mnew_message_count, this.mstatus, this.mupdate_time, this.mkey, this.mdescription, this.mmember_count, this.mis_department, this.mis_public, this.mlast_message_position, this.muser_count, this.mname_pinyin, this.mcreate_time, this.mis_customer_service, this.mrole, this.mis_custom_icon, this.mno_badged_new_message_count, this.moff_edit_group_chat_info, this.mannouncement, this.mtenant_id, this.mupdate_time_ms, this.mis_remind, this.mchat_entity_setting, this.muser_setting, this.mis_dissolved, this.mis_meeting, this.mlast_visible_message_id, this.mmessage_last_visible_patch, this.mlast_thread_id, this.mnew_thread_count, this.mlast_thread_position, this.mis_crypto, this.mno_badged_new_thread_count, this.mthread_start_position, this.mchat_mode, this.mchat_config, this.mis_cross_tenant, this.mis_tenant, this.msupport_view, this.mjoin_time_ms, this.moncall_id, this.mlast_visible_message_position, this.mlast_visible_message_no_badged_count, this.mread_position, this.mread_position_badge_count, this.mlast_message_position_badge_count, this.menable_watermark, this.mmini_avatar, this.msidebar_id, this.mname_py, this.mi18n_names, this.mi18n_inf, this.mread_thread_position, this.mread_thread_position_badge_count, this.mlast_thread_position_badge_count, this.mlast_visible_thread_position, this.mlast_visible_thread_id, this.mthread_last_visible_patch, this.mchat_security_config, this.mis_public_v2, this.mpost_type, this.mallow_post, this.mburned_time, this.mput_chatter_apply_count, this.mshow_banner, this.mis_large_group, this.mfirst_chat_message_position, this.mtags, this.mextra, this.mis_same_page_meeting, this.mmy_threads_read_timestamp, this.mmy_threads_last_timestamp, this.mis_edu, this.mmy_threads_last_display_message_id, this.mmy_threads_unread_count, this.mis_cross_with_ka, this.mis_admin, this.mis_super, this.mis_team, this.mbiz_content, this.mchatter_extra_states, this.mis_private_mode, this.mopen_chat_id, this.mtoolkit, this.mchat_general_setting, this.mtag_data, this.mgroup_type, this.mbiz_version_map, this.mcrypto_chat_info, this.mis_frozen, this.mchat_chatter_version, this.mis_department_v1, this.mis_p2p_ai, this.mbanner_setting, this.mhas_chat_menu, this.mis_p2p_official_bot_ai, this.mis_invisible, this.mis_cross_tenant_v1, this.muser_auto_mute_setting, this.mread_position_filter_mute_bot_badge_count, this.mlast_message_position_filter_mute_bot_badge_count, this.mread_thread_position_filter_mute_bot_badge_count, this.mlast_thread_message_position_filter_mute_bot_badge_count, this.mfilter_mute_bot_badge_count_version, this.muser_clean_message_time_ms, this.mtns_op_kind, this.msystem_banned_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_names = Internal.newMutableMap();
            this.mtags = Internal.newMutableList();
            this.mextra = Internal.newMutableMap();
            this.mchatter_extra_states = Internal.newMutableMap();
            this.mgroup_type = Internal.newMutableMap();
            this.mbiz_version_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder allow_post(Boolean r100) {
            this.mallow_post = r100;
            return this;
        }

        public Builder announcement(Announcement r100) {
            this.mannouncement = r100;
            return this;
        }

        public Builder avatar(Image r100) {
            this.mavatar = r100;
            return this;
        }

        public Builder banner_setting(BannerSetting r100) {
            this.mbanner_setting = r100;
            return this;
        }

        public Builder biz_content(ChatBizContent r100) {
            this.mbiz_content = r100;
            return this;
        }

        public Builder biz_version_map(Map<Integer, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbiz_version_map = r100;
            return this;
        }

        public Builder burned_time(Long r100) {
            this.mburned_time = r100;
            return this;
        }

        public Builder chat_chatter_version(Long r100) {
            this.mchat_chatter_version = r100;
            return this;
        }

        public Builder chat_config(ChatConfig r100) {
            this.mchat_config = r100;
            return this;
        }

        public Builder chat_entity_setting(ChatEntitySetting r100) {
            this.mchat_entity_setting = r100;
            return this;
        }

        public Builder chat_general_setting(GeneralChatSetting r100) {
            this.mchat_general_setting = r100;
            return this;
        }

        public Builder chat_mode(ChatMode r100) {
            this.mchat_mode = r100;
            return this;
        }

        public Builder chat_security_config(ChatSecurityConfig r100) {
            this.mchat_security_config = r100;
            return this;
        }

        public Builder chatter_extra_states(Map<Integer, Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchatter_extra_states = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.mcreate_time = r100;
            return this;
        }

        public Builder crypto_chat_info(CryptoChatInfo r100) {
            this.mcrypto_chat_info = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder enable_watermark(Boolean r100) {
            this.menable_watermark = r100;
            return this;
        }

        public Builder extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextra = r100;
            return this;
        }

        public Builder filter_mute_bot_badge_count_version(Long r100) {
            this.mfilter_mute_bot_badge_count_version = r100;
            return this;
        }

        public Builder first_chat_message_position(Integer r100) {
            this.mfirst_chat_message_position = r100;
            return this;
        }

        public Builder group_type(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.mgroup_type = r100;
            return this;
        }

        public Builder has_chat_menu(Boolean r100) {
            this.mhas_chat_menu = r100;
            return this;
        }

        public Builder i18n_inf(I18nInf r100) {
            this.mi18n_inf = r100;
            return this;
        }

        public Builder i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_names = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_admin(Boolean r100) {
            this.mis_admin = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.mis_cross_tenant = r100;
            return this;
        }

        public Builder is_cross_tenant_v1(Boolean r100) {
            this.mis_cross_tenant_v1 = r100;
            return this;
        }

        public Builder is_cross_with_ka(Boolean r100) {
            this.mis_cross_with_ka = r100;
            return this;
        }

        public Builder is_crypto(Boolean r100) {
            this.mis_crypto = r100;
            return this;
        }

        public Builder is_custom_icon(Boolean r100) {
            this.mis_custom_icon = r100;
            return this;
        }

        public Builder is_customer_service(Boolean r100) {
            this.mis_customer_service = r100;
            return this;
        }

        public Builder is_department(Boolean r100) {
            this.mis_department = r100;
            return this;
        }

        public Builder is_department_v1(Boolean r100) {
            this.mis_department_v1 = r100;
            return this;
        }

        public Builder is_dissolved(Boolean r100) {
            this.mis_dissolved = r100;
            return this;
        }

        public Builder is_edu(Boolean r100) {
            this.mis_edu = r100;
            return this;
        }

        public Builder is_frozen(Boolean r100) {
            this.mis_frozen = r100;
            return this;
        }

        public Builder is_invisible(Boolean r100) {
            this.mis_invisible = r100;
            return this;
        }

        public Builder is_large_group(Boolean r100) {
            this.mis_large_group = r100;
            return this;
        }

        public Builder is_meeting(Boolean r100) {
            this.mis_meeting = r100;
            return this;
        }

        public Builder is_p2p_ai(Boolean r100) {
            this.mis_p2p_ai = r100;
            return this;
        }

        public Builder is_p2p_official_bot_ai(Boolean r100) {
            this.mis_p2p_official_bot_ai = r100;
            return this;
        }

        public Builder is_private_mode(Boolean r100) {
            this.mis_private_mode = r100;
            return this;
        }

        public Builder is_public(Boolean r100) {
            this.mis_public = r100;
            return this;
        }

        public Builder is_public_v2(Boolean r100) {
            this.mis_public_v2 = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.mis_remind = r100;
            return this;
        }

        public Builder is_same_page_meeting(Boolean r100) {
            this.mis_same_page_meeting = r100;
            return this;
        }

        public Builder is_super(Boolean r100) {
            this.mis_super = r100;
            return this;
        }

        public Builder is_team(Boolean r100) {
            this.mis_team = r100;
            return this;
        }

        public Builder is_tenant(Boolean r100) {
            this.mis_tenant = r100;
            return this;
        }

        public Builder join_time_ms(Long r100) {
            this.mjoin_time_ms = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder last_message_id(String r100) {
            this.mlast_message_id = r100;
            return this;
        }

        public Builder last_message_position(Integer r100) {
            this.mlast_message_position = r100;
            return this;
        }

        public Builder last_message_position_badge_count(Integer r100) {
            this.mlast_message_position_badge_count = r100;
            return this;
        }

        public Builder last_message_position_filter_mute_bot_badge_count(Integer r100) {
            this.mlast_message_position_filter_mute_bot_badge_count = r100;
            return this;
        }

        public Builder last_thread_id(String r100) {
            this.mlast_thread_id = r100;
            return this;
        }

        public Builder last_thread_message_position_filter_mute_bot_badge_count(Integer r100) {
            this.mlast_thread_message_position_filter_mute_bot_badge_count = r100;
            return this;
        }

        public Builder last_thread_position(Integer r100) {
            this.mlast_thread_position = r100;
            return this;
        }

        public Builder last_thread_position_badge_count(Integer r100) {
            this.mlast_thread_position_badge_count = r100;
            return this;
        }

        public Builder last_visible_message_id(String r100) {
            this.mlast_visible_message_id = r100;
            return this;
        }

        public Builder last_visible_message_no_badged_count(Integer r100) {
            this.mlast_visible_message_no_badged_count = r100;
            return this;
        }

        public Builder last_visible_message_position(Integer r100) {
            this.mlast_visible_message_position = r100;
            return this;
        }

        public Builder last_visible_thread_id(String r100) {
            this.mlast_visible_thread_id = r100;
            return this;
        }

        public Builder last_visible_thread_position(Integer r100) {
            this.mlast_visible_thread_position = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.mmember_count = r100;
            return this;
        }

        public Builder message_last_visible_patch(MessageLastVisibleInfoPatch r100) {
            this.mmessage_last_visible_patch = r100;
            return this;
        }

        public Builder mini_avatar(Image r100) {
            this.mmini_avatar = r100;
            return this;
        }

        public Builder my_threads_last_display_message_id(Long r100) {
            this.mmy_threads_last_display_message_id = r100;
            return this;
        }

        public Builder my_threads_last_timestamp(Long r100) {
            this.mmy_threads_last_timestamp = r100;
            return this;
        }

        public Builder my_threads_read_timestamp(Long r100) {
            this.mmy_threads_read_timestamp = r100;
            return this;
        }

        public Builder my_threads_unread_count(Integer r100) {
            this.mmy_threads_unread_count = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder name_pinyin(String r100) {
            this.mname_pinyin = r100;
            return this;
        }

        public Builder name_py(String r100) {
            this.mname_py = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.mnew_message_count = r100;
            return this;
        }

        public Builder new_thread_count(Integer r100) {
            this.mnew_thread_count = r100;
            return this;
        }

        public Builder no_badged_new_message_count(Integer r100) {
            this.mno_badged_new_message_count = r100;
            return this;
        }

        public Builder no_badged_new_thread_count(Integer r100) {
            this.mno_badged_new_thread_count = r100;
            return this;
        }

        public Builder off_edit_group_chat_info(Boolean r100) {
            this.moff_edit_group_chat_info = r100;
            return this;
        }

        public Builder oncall_id(Long r100) {
            this.moncall_id = r100;
            return this;
        }

        public Builder open_chat_id(String r100) {
            this.mopen_chat_id = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.mowner_id = r100;
            return this;
        }

        public Builder post_type(ChatPostType r100) {
            this.mpost_type = r100;
            return this;
        }

        public Builder put_chatter_apply_count(Integer r100) {
            this.mput_chatter_apply_count = r100;
            return this;
        }

        public Builder read_position(Integer r100) {
            this.mread_position = r100;
            return this;
        }

        public Builder read_position_badge_count(Integer r100) {
            this.mread_position_badge_count = r100;
            return this;
        }

        public Builder read_position_filter_mute_bot_badge_count(Integer r100) {
            this.mread_position_filter_mute_bot_badge_count = r100;
            return this;
        }

        public Builder read_thread_position(Integer r100) {
            this.mread_thread_position = r100;
            return this;
        }

        public Builder read_thread_position_badge_count(Integer r100) {
            this.mread_thread_position_badge_count = r100;
            return this;
        }

        public Builder read_thread_position_filter_mute_bot_badge_count(Integer r100) {
            this.mread_thread_position_filter_mute_bot_badge_count = r100;
            return this;
        }

        public Builder role(Role r100) {
            this.mrole = r100;
            return this;
        }

        public Builder show_banner(Boolean r100) {
            this.mshow_banner = r100;
            return this;
        }

        public Builder sidebar_id(String r100) {
            this.msidebar_id = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder support_view(SupportView r100) {
            this.msupport_view = r100;
            return this;
        }

        public Builder system_banned_info(SystemBannedInfo r100) {
            this.msystem_banned_info = r100;
            return this;
        }

        public Builder tag_data(TagData r100) {
            this.mtag_data = r100;
            return this;
        }

        public Builder tags(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtags = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }

        public Builder thread_last_visible_patch(MessageLastVisibleInfoPatch r100) {
            this.mthread_last_visible_patch = r100;
            return this;
        }

        public Builder thread_start_position(Integer r100) {
            this.mthread_start_position = r100;
            return this;
        }

        public Builder tns_op_kind(TnsOpKind r100) {
            this.mtns_op_kind = r100;
            return this;
        }

        public Builder toolkit(ChatToolkit r100) {
            this.mtoolkit = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.mupdate_time = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.mupdate_time_ms = r100;
            return this;
        }

        public Builder user_auto_mute_setting(ChatUserAutoMuteSetting r100) {
            this.muser_auto_mute_setting = r100;
            return this;
        }

        public Builder user_clean_message_time_ms(Long r100) {
            this.muser_clean_message_time_ms = r100;
            return this;
        }

        public Builder user_count(Integer r100) {
            this.muser_count = r100;
            return this;
        }

        public Builder user_setting(ChatSetting r100) {
            this.muser_setting = r100;
            return this;
        }
    }

    public static final enum ChatMode extends Enum<ChatMode> implements WireEnum {
        private static final /* synthetic */ ChatMode[] $VALUES = null;
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final ChatMode DEFAULT = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN_CHAT_MODE = null;
        private final int value;

        static {
            ChatMode r100 = new ChatMode("UNKNOWN_CHAT_MODE", 0, 0);
            UNKNOWN_CHAT_MODE = r100;
            ChatMode r101 = new ChatMode("DEFAULT", 1, 1);
            DEFAULT = r101;
            ChatMode r102 = new ChatMode("THREAD", 2, 2);
            THREAD = r102;
            ChatMode r103 = new ChatMode("THREAD_V2", 3, 3);
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
            return UNKNOWN_CHAT_MODE;
        }

        public static ChatMode valueOf(String r100) {
            return (ChatMode) a.a(ChatMode.class, r100);
        }

        private ChatMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class I18nInf extends com.squareup.wire.Message<I18nInf, Builder> {
        public static final ProtoAdapter<I18nInf> ADAPTER = null;
        public static final String DEFAULT_VERSION = "";
        private static final long serialVersionUID = 0;
        public final Map<String, Double> mchat_name_language_ratio;
        public final I18nNameType mi18n_name_type;
        public final Map<String, String> mi18n_names;
        public final Map<String, String> mi18n_translated_names;
        public final String mversion;

        public static final class Builder extends com.squareup.wire.Message.Builder<I18nInf, Builder> {
            public Map<String, Double> mchat_name_language_ratio;
            public I18nNameType mi18n_name_type;
            public Map<String, String> mi18n_names;
            public Map<String, String> mi18n_translated_names;
            public String mversion;

            @Override // com.squareup.wire.Message.Builder
            public I18nInf build() {
                return new I18nInf(this.mi18n_names, this.mi18n_translated_names, this.mi18n_name_type, this.mchat_name_language_ratio, this.mversion, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_names = Internal.newMutableMap();
                this.mi18n_translated_names = Internal.newMutableMap();
                this.mchat_name_language_ratio = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chat_name_language_ratio(Map<String, Double> r100) {
                Internal.checkElementsNotNull(r100);
                this.mchat_name_language_ratio = r100;
                return this;
            }

            public Builder i18n_name_type(I18nNameType r100) {
                this.mi18n_name_type = r100;
                return this;
            }

            public Builder i18n_names(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mi18n_names = r100;
                return this;
            }

            public Builder i18n_translated_names(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mi18n_translated_names = r100;
                return this;
            }

            public Builder version(String r100) {
                this.mversion = r100;
                return this;
            }
        }

        public static final enum I18nNameType extends Enum<I18nNameType> implements WireEnum {
            private static final /* synthetic */ I18nNameType[] $VALUES = null;
            public static final ProtoAdapter<I18nNameType> ADAPTER = null;
            public static final I18nNameType CUSTOM = null;
            public static final I18nNameType DEFAULT = null;
            public static final I18nNameType TRANSLATE = null;
            public static final I18nNameType UNKNOWN = null;
            private final int value;

            static {
                I18nNameType r100 = new I18nNameType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                I18nNameType r101 = new I18nNameType("DEFAULT", 1, 1);
                DEFAULT = r101;
                I18nNameType r102 = new I18nNameType("CUSTOM", 2, 2);
                CUSTOM = r102;
                I18nNameType r103 = new I18nNameType("TRANSLATE", 3, 3);
                TRANSLATE = r103;
                $VALUES = new I18nNameType[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(I18nNameType.class);
            }

            public static I18nNameType[] values() {
                return (I18nNameType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static I18nNameType fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return TRANSLATE;
            L14:
                return CUSTOM;
            L16:
                return DEFAULT;
            L18:
                return UNKNOWN;
            }

            public static I18nNameType valueOf(String r100) {
                return (I18nNameType) a.a(I18nNameType.class, r100);
            }

            private I18nNameType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_I18nInf extends ProtoAdapter<I18nInf> {
            private final ProtoAdapter<Map<String, Double>> mchat_name_language_ratio;
            private final ProtoAdapter<Map<String, String>> mi18n_names;
            private final ProtoAdapter<Map<String, String>> mi18n_translated_names;

            public ProtoAdapter_I18nInf() {
                super(FieldEncoding.LENGTH_DELIMITED, I18nInf.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.mi18n_names = ProtoAdapter.newMapAdapter(r100, r100);
                this.mi18n_translated_names = ProtoAdapter.newMapAdapter(r100, r100);
                this.mchat_name_language_ratio = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.DOUBLE);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public I18nInf decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mversion = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.mi18n_names.putAll(this.mi18n_names.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mi18n_translated_names.putAll(this.mi18n_translated_names.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mi18n_name_type = I18nNameType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.mchat_name_language_ratio.putAll(this.mchat_name_language_ratio.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.mversion = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(I18nInf r100) {
                int r101 = this.mi18n_names.encodedSizeWithTag(1, r100.mi18n_names) + this.mi18n_translated_names.encodedSizeWithTag(2, r100.mi18n_translated_names);
                I18nNameType r102 = r100.mi18n_name_type;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = I18nNameType.ADAPTER.encodedSizeWithTag(3, r102);
            L6:
                int r105 = (r101 + r104) + this.mchat_name_language_ratio.encodedSizeWithTag(4, r100.mchat_name_language_ratio);
                String r106 = r100.mversion;
                if (r106 == null) goto L10;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(5, r106);
            L10:
                return (r105 + r103) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ I18nInf decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(I18nInf r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, I18nInf r101) throws IOException {
                this.mi18n_names.encodeWithTag(r100, 1, r101.mi18n_names);
                this.mi18n_translated_names.encodeWithTag(r100, 2, r101.mi18n_translated_names);
                I18nNameType r102 = r101.mi18n_name_type;
                if (r102 == null) goto L5;
                I18nNameType.ADAPTER.encodeWithTag(r100, 3, r102);
            L5:
                this.mchat_name_language_ratio.encodeWithTag(r100, 4, r101.mchat_name_language_ratio);
                String r103 = r101.mversion;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nInf r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_I18nInf();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
            r100.mi18n_translated_names = Internal.copyOf("mi18n_translated_names", this.mi18n_translated_names);
            r100.mi18n_name_type = this.mi18n_name_type;
            r100.mchat_name_language_ratio = Internal.copyOf("mchat_name_language_ratio", this.mchat_name_language_ratio);
            r100.mversion = this.mversion;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return I18nInf.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public I18nInf(Map<String, String> r100, Map<String, String> r101, I18nNameType r110, Map<String, Double> r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public I18nInf(Map<String, String> r100, Map<String, String> r101, I18nNameType r102, Map<String, Double> r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r100);
            this.mi18n_translated_names = Internal.immutableCopyOf("mi18n_translated_names", r101);
            this.mi18n_name_type = r102;
            this.mchat_name_language_ratio = Internal.immutableCopyOf("mchat_name_language_ratio", r103);
            this.mversion = r104;
        }
    }

    public static final class ProtoAdapter_Chat extends ProtoAdapter<Chat> {
        private final ProtoAdapter<Map<Integer, Long>> mbiz_version_map;
        private final ProtoAdapter<Map<Integer, Integer>> mchatter_extra_states;
        private final ProtoAdapter<Map<String, String>> mextra;
        private final ProtoAdapter<Map<Integer, Boolean>> mgroup_type;
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_Chat() {
            super(FieldEncoding.LENGTH_DELIMITED, Chat.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r100, r100);
            this.mextra = ProtoAdapter.newMapAdapter(r100, r100);
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            this.mchatter_extra_states = ProtoAdapter.newMapAdapter(r101, r101);
            this.mgroup_type = ProtoAdapter.newMapAdapter(r101, ProtoAdapter.BOOL);
            this.mbiz_version_map = ProtoAdapter.newMapAdapter(r101, ProtoAdapter.INT64);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Chat decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mlast_message_id = "";
            r101.mname = "";
            r101.mowner_id = "";
            r101.mnew_message_count = 0;
            r101.mupdate_time = 0L;
            r101.mkey = "";
            r101.mdescription = "";
            r101.mmember_count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.mis_department = r102;
            r101.mis_public = r102;
            r101.mlast_message_position = 0;
            r101.muser_count = 0;
            r101.mname_pinyin = "";
            r101.mcreate_time = 0L;
            r101.mis_customer_service = r102;
            r101.mis_custom_icon = r102;
            r101.mno_badged_new_message_count = 0;
            r101.moff_edit_group_chat_info = r102;
            r101.mtenant_id = "";
            r101.mupdate_time_ms = 0L;
            r101.mis_remind = Boolean.TRUE;
            r101.mis_dissolved = r102;
            r101.mis_meeting = r102;
            r101.mlast_visible_message_id = "";
            r101.mlast_thread_id = "";
            r101.mnew_thread_count = 0;
            r101.mlast_thread_position = 0;
            r101.mis_crypto = r102;
            r101.mno_badged_new_thread_count = 0;
            r101.mthread_start_position = 0;
            r101.mis_cross_tenant = r102;
            r101.mis_tenant = r102;
            r101.mjoin_time_ms = 0L;
            r101.moncall_id = 0L;
            r101.mlast_visible_message_position = 0;
            r101.mlast_visible_message_no_badged_count = 0;
            r101.mread_position = 0;
            r101.mread_position_badge_count = 0;
            r101.mlast_message_position_badge_count = 0;
            r101.menable_watermark = r102;
            r101.msidebar_id = "";
            r101.mname_py = "";
            r101.mread_thread_position = 0;
            r101.mread_thread_position_badge_count = 0;
            r101.mlast_thread_position_badge_count = 0;
            r101.mlast_visible_thread_position = 0;
            r101.mlast_visible_thread_id = "";
            r101.mis_public_v2 = r102;
            r101.mallow_post = r102;
            r101.mburned_time = 0L;
            r101.mput_chatter_apply_count = 0;
            r101.mshow_banner = r102;
            r101.mis_large_group = r102;
            r101.mfirst_chat_message_position = 0;
            r101.mis_same_page_meeting = r102;
            r101.mmy_threads_read_timestamp = 0L;
            r101.mmy_threads_last_timestamp = 0L;
            r101.mis_edu = r102;
            r101.mmy_threads_last_display_message_id = 0L;
            r101.mmy_threads_unread_count = 0;
            r101.mis_cross_with_ka = r102;
            r101.mis_admin = r102;
            r101.mis_super = r102;
            r101.mis_team = r102;
            r101.mis_private_mode = r102;
            r101.mopen_chat_id = "";
            r101.mis_frozen = r102;
            r101.mchat_chatter_version = 0L;
            r101.mis_department_v1 = r102;
            r101.mis_p2p_ai = r102;
            r101.mhas_chat_menu = r102;
            r101.mis_p2p_official_bot_ai = r102;
            r101.mis_invisible = r102;
            r101.mis_cross_tenant_v1 = r102;
            r101.mread_position_filter_mute_bot_badge_count = 0;
            r101.mlast_message_position_filter_mute_bot_badge_count = 0;
            r101.mread_thread_position_filter_mute_bot_badge_count = 0;
            r101.mlast_thread_message_position_filter_mute_bot_badge_count = 0;
            r101.mfilter_mute_bot_badge_count_version = 0L;
            r101.muser_clean_message_time_ms = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L141;
            switch(r104) {
                case 1: goto L140;
                case 2: goto L145;
                case 3: goto L135;
                case 4: goto L134;
                case 5: goto L133;
                case 6: goto L132;
                case 7: goto L131;
                case 8: goto L151;
                case 9: goto L126;
                case 10: goto L125;
                case 11: goto L124;
                case 12: goto L123;
                case 13: goto L122;
                case 14: goto L121;
                case 15: goto L120;
                case 16: goto L119;
                case 17: goto L118;
                case 18: goto L117;
                case 19: goto L116;
                case 20: goto L147;
                case 21: goto L111;
                case 22: goto L110;
                case 23: goto L109;
                case 24: goto L108;
                case 25: goto L107;
                case 26: goto L106;
                case 27: goto L105;
                case 28: goto L104;
                case 29: goto L103;
                case 30: goto L102;
                case 31: goto L101;
                case 32: goto L100;
                case 33: goto L99;
                case 34: goto L98;
                case 35: goto L97;
                case 36: goto L96;
                case 37: goto L95;
                case 38: goto L94;
                case 39: goto L155;
                case 40: goto L89;
                case 41: goto L88;
                case 42: goto L87;
                case 43: goto L153;
                case 44: goto L82;
                case 45: goto L81;
                case 46: goto L80;
                case 47: goto L79;
                case 48: goto L78;
                case 49: goto L77;
                case 50: goto L76;
                case 51: goto L75;
                case 52: goto L74;
                case 53: goto L73;
                default: goto L6;
            };
        L145:
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L138
        L138:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L147:
            r101.mrole = Role.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L114
        L114:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L151:
            r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L129
        L129:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L153:
            r101.msupport_view = SupportView.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L85
        L85:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L155:
            r101.mchat_mode = ChatMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L92
        L92:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L73:
            r101.msidebar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L74:
            r101.mmini_avatar = Image.ADAPTER.decode(r100);
            goto L3
        L75:
            r101.menable_watermark = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L76:
            r101.mlast_message_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L77:
            r101.mread_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L78:
            r101.mread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L79:
            r101.mlast_visible_message_no_badged_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L80:
            r101.mlast_visible_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L81:
            r101.moncall_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L82:
            r101.mjoin_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L87:
            r101.mis_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L88:
            r101.mis_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L89:
            r101.mchat_config = ChatConfig.ADAPTER.decode(r100);
            goto L3
        L94:
            r101.mthread_start_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L95:
            r101.mno_badged_new_thread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L96:
            r101.mis_crypto = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L97:
            r101.mlast_thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L98:
            r101.mnew_thread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L99:
            r101.mlast_thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L100:
            r101.mlast_visible_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L101:
            r101.mis_meeting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L102:
            r101.mis_dissolved = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L103:
            r101.muser_setting = ChatSetting.ADAPTER.decode(r100);
            goto L3
        L104:
            r101.mchat_entity_setting = ChatEntitySetting.ADAPTER.decode(r100);
            goto L3
        L105:
            r101.mis_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L106:
            r101.mupdate_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L107:
            r101.mtenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L108:
            r101.mannouncement = Announcement.ADAPTER.decode(r100);
            goto L3
        L109:
            r101.moff_edit_group_chat_info = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L110:
            r101.mno_badged_new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L111:
            r101.mis_custom_icon = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L116:
            r101.mis_customer_service = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L117:
            r101.mcreate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L118:
            r101.mname_pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L119:
            r101.muser_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L120:
            r101.mlast_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L121:
            r101.mis_public = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L122:
            r101.mis_department = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L123:
            r101.mmember_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L124:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L125:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L126:
            r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L131:
            r101.mnew_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L132:
            r101.mowner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L133:
            r101.mavatar = Image.ADAPTER.decode(r100);
            goto L3
        L134:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L135:
            r101.mlast_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L140:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r104) {
                case 100: goto L72;
                case 101: goto L71;
                case 102: goto L70;
                case 103: goto L69;
                case 104: goto L68;
                case 105: goto L67;
                case 106: goto L66;
                case 107: goto L65;
                case 108: goto L64;
                case 109: goto L63;
                case 110: goto L149;
                case 111: goto L58;
                case 112: goto L57;
                case 113: goto L56;
                case 114: goto L55;
                case 115: goto L54;
                case 116: goto L53;
                case 117: goto L52;
                case 118: goto L51;
                case 119: goto L50;
                case 120: goto L49;
                case 121: goto L48;
                case 122: goto L47;
                case 123: goto L46;
                case 124: goto L45;
                case 125: goto L44;
                case 126: goto L43;
                case 127: goto L42;
                case 128: goto L41;
                case 129: goto L40;
                case 130: goto L39;
                case 131: goto L38;
                case 132: goto L37;
                case 133: goto L36;
                case 134: goto L35;
                case 135: goto L34;
                case 136: goto L33;
                case 137: goto L32;
                case 138: goto L31;
                case 139: goto L30;
                case 140: goto L29;
                case 141: goto L28;
                case 142: goto L27;
                case 143: goto L26;
                case 144: goto L25;
                case 145: goto L24;
                case 146: goto L23;
                case 147: goto L22;
                case 148: goto L21;
                case 149: goto L20;
                case 150: goto L19;
                case 151: goto L18;
                case 152: goto L17;
                case 153: goto L16;
                case 154: goto L15;
                case 155: goto L14;
                case 156: goto L13;
                case 157: goto L143;
                case 158: goto L8;
                default: goto L7;
            };
        L143:
            r101.mtns_op_kind = TnsOpKind.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L149:
            r101.mpost_type = ChatPostType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L61
        L61:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r101.msystem_banned_info = SystemBannedInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.muser_clean_message_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.mfilter_mute_bot_badge_count_version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.mlast_thread_message_position_filter_mute_bot_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.mread_thread_position_filter_mute_bot_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.mlast_message_position_filter_mute_bot_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.mread_position_filter_mute_bot_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.muser_auto_mute_setting = ChatUserAutoMuteSetting.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.mis_cross_tenant_v1 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.mis_invisible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.mis_p2p_official_bot_ai = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.mhas_chat_menu = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.mbanner_setting = BannerSetting.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.mis_p2p_ai = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.mis_department_v1 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.mchat_chatter_version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L28:
            r101.mis_frozen = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L29:
            r101.mcrypto_chat_info = CryptoChatInfo.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.mbiz_version_map.putAll(this.mbiz_version_map.decode(r100));
            goto L3
        L31:
            r101.mgroup_type.putAll(this.mgroup_type.decode(r100));
            goto L3
        L32:
            r101.mtag_data = TagData.ADAPTER.decode(r100);
            goto L3
        L33:
            r101.mchat_general_setting = GeneralChatSetting.ADAPTER.decode(r100);
            goto L3
        L34:
            r101.mtoolkit = ChatToolkit.ADAPTER.decode(r100);
            goto L3
        L35:
            r101.mopen_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.mis_private_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L37:
            r101.mthread_last_visible_patch = MessageLastVisibleInfoPatch.ADAPTER.decode(r100);
            goto L3
        L38:
            r101.mmessage_last_visible_patch = MessageLastVisibleInfoPatch.ADAPTER.decode(r100);
            goto L3
        L39:
            r101.mchatter_extra_states.putAll(this.mchatter_extra_states.decode(r100));
            goto L3
        L40:
            r101.mbiz_content = ChatBizContent.ADAPTER.decode(r100);
            goto L3
        L41:
            r101.mis_team = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L42:
            r101.mis_super = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L43:
            r101.mis_admin = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L44:
            r101.mis_cross_with_ka = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L45:
            r101.mmy_threads_unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L46:
            r101.mmy_threads_last_display_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L47:
            r101.mis_edu = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L48:
            r101.mmy_threads_last_timestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L49:
            r101.mmy_threads_read_timestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L50:
            r101.mis_same_page_meeting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L51:
            r101.mextra.putAll(this.mextra.decode(r100));
            goto L3
        L52:
            r101.mtags.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L53:
            r101.mfirst_chat_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L54:
            r101.mis_large_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L55:
            r101.mshow_banner = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L56:
            r101.mput_chatter_apply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L57:
            r101.mburned_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L58:
            r101.mallow_post = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L63:
            r101.mis_public_v2 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L64:
            r101.mchat_security_config = ChatSecurityConfig.ADAPTER.decode(r100);
            goto L3
        L65:
            r101.mlast_visible_thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L66:
            r101.mlast_visible_thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L67:
            r101.mlast_thread_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L68:
            r101.mread_thread_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L69:
            r101.mread_thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L70:
            r101.mi18n_inf = I18nInf.ADAPTER.decode(r100);
            goto L3
        L71:
            r101.mi18n_names.putAll(this.mi18n_names.decode(r100));
            goto L3
        L72:
            r101.mname_py = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L141:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Chat r100) {
            String r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Type r104 = r100.mtype;
            if (r104 == null) goto L9;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mlast_message_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mname;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Image r113 = r100.mavatar;
            if (r113 == null) goto L21;
            int r114 = Image.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mowner_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.mnew_message_count;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Status r122 = r100.mstatus;
            if (r122 == null) goto L33;
            int r123 = Status.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.mupdate_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mkey;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.mdescription;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Integer r134 = r100.mmember_count;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT32.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Boolean r137 = r100.mis_department;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.mis_public;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            Integer r143 = r100.mlast_message_position;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.INT32.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            Integer r146 = r100.muser_count;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.INT32.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            String r149 = r100.mname_pinyin;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.STRING.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            Long r152 = r100.mcreate_time;
            if (r152 == null) goto L73;
            int r153 = ProtoAdapter.INT64.encodedSizeWithTag(18, r152);
        L74:
            int r154 = r151 + r153;
            Boolean r155 = r100.mis_customer_service;
            if (r155 == null) goto L77;
            int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r155);
        L78:
            int r157 = r154 + r156;
            Role r158 = r100.mrole;
            if (r158 == null) goto L81;
            int r159 = Role.ADAPTER.encodedSizeWithTag(20, r158);
        L82:
            int r160 = r157 + r159;
            Boolean r161 = r100.mis_custom_icon;
            if (r161 == null) goto L85;
            int r162 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r161);
        L86:
            int r163 = r160 + r162;
            Integer r164 = r100.mno_badged_new_message_count;
            if (r164 == null) goto L89;
            int r165 = ProtoAdapter.INT32.encodedSizeWithTag(22, r164);
        L90:
            int r166 = r163 + r165;
            Boolean r167 = r100.moff_edit_group_chat_info;
            if (r167 == null) goto L93;
            int r168 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r167);
        L94:
            int r169 = r166 + r168;
            Announcement r170 = r100.mannouncement;
            if (r170 == null) goto L97;
            int r171 = Announcement.ADAPTER.encodedSizeWithTag(24, r170);
        L98:
            int r172 = r169 + r171;
            String r173 = r100.mtenant_id;
            if (r173 == null) goto L101;
            int r174 = ProtoAdapter.STRING.encodedSizeWithTag(25, r173);
        L102:
            int r175 = r172 + r174;
            Long r176 = r100.mupdate_time_ms;
            if (r176 == null) goto L105;
            int r177 = ProtoAdapter.INT64.encodedSizeWithTag(26, r176);
        L106:
            int r178 = r175 + r177;
            Boolean r179 = r100.mis_remind;
            if (r179 == null) goto L109;
            int r180 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r179);
        L110:
            int r181 = r178 + r180;
            ChatEntitySetting r182 = r100.mchat_entity_setting;
            if (r182 == null) goto L113;
            int r183 = ChatEntitySetting.ADAPTER.encodedSizeWithTag(28, r182);
        L114:
            int r184 = r181 + r183;
            ChatSetting r185 = r100.muser_setting;
            if (r185 == null) goto L117;
            int r186 = ChatSetting.ADAPTER.encodedSizeWithTag(29, r185);
        L118:
            int r187 = r184 + r186;
            Boolean r188 = r100.mis_dissolved;
            if (r188 == null) goto L121;
            int r189 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r188);
        L122:
            int r190 = r187 + r189;
            Boolean r191 = r100.mis_meeting;
            if (r191 == null) goto L125;
            int r192 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r191);
        L126:
            int r193 = r190 + r192;
            String r194 = r100.mlast_visible_message_id;
            if (r194 == null) goto L129;
            int r195 = ProtoAdapter.STRING.encodedSizeWithTag(32, r194);
        L130:
            int r196 = r193 + r195;
            MessageLastVisibleInfoPatch r197 = r100.mmessage_last_visible_patch;
            if (r197 == null) goto L133;
            int r198 = MessageLastVisibleInfoPatch.ADAPTER.encodedSizeWithTag(131, r197);
        L134:
            int r199 = r196 + r198;
            String r200 = r100.mlast_thread_id;
            if (r200 == null) goto L137;
            int r201 = ProtoAdapter.STRING.encodedSizeWithTag(33, r200);
        L138:
            int r202 = r199 + r201;
            Integer r203 = r100.mnew_thread_count;
            if (r203 == null) goto L141;
            int r204 = ProtoAdapter.INT32.encodedSizeWithTag(34, r203);
        L142:
            int r205 = r202 + r204;
            Integer r206 = r100.mlast_thread_position;
            if (r206 == null) goto L145;
            int r207 = ProtoAdapter.INT32.encodedSizeWithTag(35, r206);
        L146:
            int r208 = r205 + r207;
            Boolean r209 = r100.mis_crypto;
            if (r209 == null) goto L149;
            int r210 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r209);
        L150:
            int r211 = r208 + r210;
            Integer r212 = r100.mno_badged_new_thread_count;
            if (r212 == null) goto L153;
            int r213 = ProtoAdapter.INT32.encodedSizeWithTag(37, r212);
        L154:
            int r214 = r211 + r213;
            Integer r215 = r100.mthread_start_position;
            if (r215 == null) goto L157;
            int r216 = ProtoAdapter.INT32.encodedSizeWithTag(38, r215);
        L158:
            int r217 = r214 + r216;
            ChatMode r218 = r100.mchat_mode;
            if (r218 == null) goto L161;
            int r219 = ChatMode.ADAPTER.encodedSizeWithTag(39, r218);
        L162:
            int r220 = r217 + r219;
            ChatConfig r221 = r100.mchat_config;
            if (r221 == null) goto L165;
            int r222 = ChatConfig.ADAPTER.encodedSizeWithTag(40, r221);
        L166:
            int r223 = r220 + r222;
            Boolean r224 = r100.mis_cross_tenant;
            if (r224 == null) goto L169;
            int r225 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r224);
        L170:
            int r226 = r223 + r225;
            Boolean r227 = r100.mis_tenant;
            if (r227 == null) goto L173;
            int r228 = ProtoAdapter.BOOL.encodedSizeWithTag(42, r227);
        L174:
            int r229 = r226 + r228;
            SupportView r230 = r100.msupport_view;
            if (r230 == null) goto L177;
            int r231 = SupportView.ADAPTER.encodedSizeWithTag(43, r230);
        L178:
            int r232 = r229 + r231;
            Long r233 = r100.mjoin_time_ms;
            if (r233 == null) goto L181;
            int r234 = ProtoAdapter.INT64.encodedSizeWithTag(44, r233);
        L182:
            int r235 = r232 + r234;
            Long r236 = r100.moncall_id;
            if (r236 == null) goto L185;
            int r237 = ProtoAdapter.INT64.encodedSizeWithTag(45, r236);
        L186:
            int r238 = r235 + r237;
            Integer r239 = r100.mlast_visible_message_position;
            if (r239 == null) goto L189;
            int r240 = ProtoAdapter.INT32.encodedSizeWithTag(46, r239);
        L190:
            int r241 = r238 + r240;
            Integer r242 = r100.mlast_visible_message_no_badged_count;
            if (r242 == null) goto L193;
            int r243 = ProtoAdapter.INT32.encodedSizeWithTag(47, r242);
        L194:
            int r244 = r241 + r243;
            Integer r245 = r100.mread_position;
            if (r245 == null) goto L197;
            int r246 = ProtoAdapter.INT32.encodedSizeWithTag(48, r245);
        L198:
            int r247 = r244 + r246;
            Integer r248 = r100.mread_position_badge_count;
            if (r248 == null) goto L201;
            int r249 = ProtoAdapter.INT32.encodedSizeWithTag(49, r248);
        L202:
            int r250 = r247 + r249;
            Integer r251 = r100.mlast_message_position_badge_count;
            if (r251 == null) goto L205;
            int r252 = ProtoAdapter.INT32.encodedSizeWithTag(50, r251);
        L206:
            int r253 = r250 + r252;
            Boolean r254 = r100.menable_watermark;
            if (r254 == null) goto L209;
            int r255 = ProtoAdapter.BOOL.encodedSizeWithTag(51, r254);
        L210:
            int r256 = r253 + r255;
            Image r257 = r100.mmini_avatar;
            if (r257 == null) goto L213;
            int r258 = Image.ADAPTER.encodedSizeWithTag(52, r257);
        L214:
            int r259 = r256 + r258;
            String r260 = r100.msidebar_id;
            if (r260 == null) goto L217;
            int r261 = ProtoAdapter.STRING.encodedSizeWithTag(53, r260);
        L218:
            int r262 = r259 + r261;
            String r263 = r100.mname_py;
            if (r263 == null) goto L221;
            int r264 = ProtoAdapter.STRING.encodedSizeWithTag(100, r263);
        L222:
            int r265 = (r262 + r264) + this.mi18n_names.encodedSizeWithTag(101, r100.mi18n_names);
            I18nInf r266 = r100.mi18n_inf;
            if (r266 == null) goto L225;
            int r267 = I18nInf.ADAPTER.encodedSizeWithTag(102, r266);
        L226:
            int r268 = r265 + r267;
            Integer r269 = r100.mread_thread_position;
            if (r269 == null) goto L229;
            int r270 = ProtoAdapter.INT32.encodedSizeWithTag(103, r269);
        L230:
            int r271 = r268 + r270;
            Integer r272 = r100.mread_thread_position_badge_count;
            if (r272 == null) goto L233;
            int r273 = ProtoAdapter.INT32.encodedSizeWithTag(104, r272);
        L234:
            int r274 = r271 + r273;
            Integer r275 = r100.mlast_thread_position_badge_count;
            if (r275 == null) goto L237;
            int r276 = ProtoAdapter.INT32.encodedSizeWithTag(105, r275);
        L238:
            int r277 = r274 + r276;
            Integer r278 = r100.mlast_visible_thread_position;
            if (r278 == null) goto L241;
            int r279 = ProtoAdapter.INT32.encodedSizeWithTag(106, r278);
        L242:
            int r280 = r277 + r279;
            String r281 = r100.mlast_visible_thread_id;
            if (r281 == null) goto L245;
            int r282 = ProtoAdapter.STRING.encodedSizeWithTag(107, r281);
        L246:
            int r283 = r280 + r282;
            MessageLastVisibleInfoPatch r284 = r100.mthread_last_visible_patch;
            if (r284 == null) goto L249;
            int r285 = MessageLastVisibleInfoPatch.ADAPTER.encodedSizeWithTag(132, r284);
        L250:
            int r286 = r283 + r285;
            ChatSecurityConfig r287 = r100.mchat_security_config;
            if (r287 == null) goto L253;
            int r288 = ChatSecurityConfig.ADAPTER.encodedSizeWithTag(108, r287);
        L254:
            int r289 = r286 + r288;
            Boolean r290 = r100.mis_public_v2;
            if (r290 == null) goto L257;
            int r291 = ProtoAdapter.BOOL.encodedSizeWithTag(109, r290);
        L258:
            int r292 = r289 + r291;
            ChatPostType r293 = r100.mpost_type;
            if (r293 == null) goto L261;
            int r294 = ChatPostType.ADAPTER.encodedSizeWithTag(110, r293);
        L262:
            int r295 = r292 + r294;
            Boolean r296 = r100.mallow_post;
            if (r296 == null) goto L265;
            int r297 = ProtoAdapter.BOOL.encodedSizeWithTag(111, r296);
        L266:
            int r298 = r295 + r297;
            Long r299 = r100.mburned_time;
            if (r299 == null) goto L269;
            int r300 = ProtoAdapter.INT64.encodedSizeWithTag(112, r299);
        L270:
            int r301 = r298 + r300;
            Integer r302 = r100.mput_chatter_apply_count;
            if (r302 == null) goto L273;
            int r303 = ProtoAdapter.INT32.encodedSizeWithTag(113, r302);
        L274:
            int r304 = r301 + r303;
            Boolean r305 = r100.mshow_banner;
            if (r305 == null) goto L277;
            int r306 = ProtoAdapter.BOOL.encodedSizeWithTag(114, r305);
        L278:
            int r307 = r304 + r306;
            Boolean r308 = r100.mis_large_group;
            if (r308 == null) goto L281;
            int r309 = ProtoAdapter.BOOL.encodedSizeWithTag(115, r308);
        L282:
            int r310 = r307 + r309;
            Integer r311 = r100.mfirst_chat_message_position;
            if (r311 == null) goto L285;
            int r312 = ProtoAdapter.INT32.encodedSizeWithTag(116, r311);
        L286:
            int r313 = r310 + r312;
            ProtoAdapter<Integer> r314 = ProtoAdapter.INT32;
            int r315 = (r313 + r314.asRepeated().encodedSizeWithTag(117, r100.mtags)) + this.mextra.encodedSizeWithTag(118, r100.mextra);
            Boolean r316 = r100.mis_same_page_meeting;
            if (r316 == null) goto L289;
            int r317 = ProtoAdapter.BOOL.encodedSizeWithTag(119, r316);
        L290:
            int r318 = r315 + r317;
            Long r319 = r100.mmy_threads_read_timestamp;
            if (r319 == null) goto L293;
            int r320 = ProtoAdapter.INT64.encodedSizeWithTag(120, r319);
        L294:
            int r321 = r318 + r320;
            Long r322 = r100.mmy_threads_last_timestamp;
            if (r322 == null) goto L297;
            int r323 = ProtoAdapter.INT64.encodedSizeWithTag(121, r322);
        L298:
            int r324 = r321 + r323;
            Boolean r325 = r100.mis_edu;
            if (r325 == null) goto L301;
            int r326 = ProtoAdapter.BOOL.encodedSizeWithTag(122, r325);
        L302:
            int r327 = r324 + r326;
            Long r328 = r100.mmy_threads_last_display_message_id;
            if (r328 == null) goto L305;
            int r329 = ProtoAdapter.INT64.encodedSizeWithTag(123, r328);
        L306:
            int r330 = r327 + r329;
            Integer r331 = r100.mmy_threads_unread_count;
            if (r331 == null) goto L309;
            int r332 = r314.encodedSizeWithTag(124, r331);
        L310:
            int r333 = r330 + r332;
            Boolean r334 = r100.mis_cross_with_ka;
            if (r334 == null) goto L313;
            int r335 = ProtoAdapter.BOOL.encodedSizeWithTag(125, r334);
        L314:
            int r336 = r333 + r335;
            Boolean r337 = r100.mis_admin;
            if (r337 == null) goto L317;
            int r338 = ProtoAdapter.BOOL.encodedSizeWithTag(126, r337);
        L318:
            int r339 = r336 + r338;
            Boolean r340 = r100.mis_super;
            if (r340 == null) goto L321;
            int r341 = ProtoAdapter.BOOL.encodedSizeWithTag(127, r340);
        L322:
            int r342 = r339 + r341;
            Boolean r343 = r100.mis_team;
            if (r343 == null) goto L325;
            int r344 = ProtoAdapter.BOOL.encodedSizeWithTag(128, r343);
        L326:
            int r345 = r342 + r344;
            ChatBizContent r346 = r100.mbiz_content;
            if (r346 == null) goto L329;
            int r347 = ChatBizContent.ADAPTER.encodedSizeWithTag(129, r346);
        L330:
            int r348 = (r345 + r347) + this.mchatter_extra_states.encodedSizeWithTag(130, r100.mchatter_extra_states);
            Boolean r349 = r100.mis_private_mode;
            if (r349 == null) goto L333;
            int r350 = ProtoAdapter.BOOL.encodedSizeWithTag(133, r349);
        L334:
            int r351 = r348 + r350;
            String r352 = r100.mopen_chat_id;
            if (r352 == null) goto L337;
            int r353 = ProtoAdapter.STRING.encodedSizeWithTag(134, r352);
        L338:
            int r354 = r351 + r353;
            ChatToolkit r355 = r100.mtoolkit;
            if (r355 == null) goto L341;
            int r356 = ChatToolkit.ADAPTER.encodedSizeWithTag(135, r355);
        L342:
            int r357 = r354 + r356;
            GeneralChatSetting r358 = r100.mchat_general_setting;
            if (r358 == null) goto L345;
            int r359 = GeneralChatSetting.ADAPTER.encodedSizeWithTag(136, r358);
        L346:
            int r360 = r357 + r359;
            TagData r361 = r100.mtag_data;
            if (r361 == null) goto L349;
            int r362 = TagData.ADAPTER.encodedSizeWithTag(137, r361);
        L350:
            int r363 = ((r360 + r362) + this.mgroup_type.encodedSizeWithTag(138, r100.mgroup_type)) + this.mbiz_version_map.encodedSizeWithTag(139, r100.mbiz_version_map);
            CryptoChatInfo r364 = r100.mcrypto_chat_info;
            if (r364 == null) goto L353;
            int r365 = CryptoChatInfo.ADAPTER.encodedSizeWithTag(140, r364);
        L354:
            int r366 = r363 + r365;
            Boolean r367 = r100.mis_frozen;
            if (r367 == null) goto L357;
            int r368 = ProtoAdapter.BOOL.encodedSizeWithTag(141, r367);
        L358:
            int r369 = r366 + r368;
            Long r370 = r100.mchat_chatter_version;
            if (r370 == null) goto L361;
            int r371 = ProtoAdapter.INT64.encodedSizeWithTag(142, r370);
        L362:
            int r372 = r369 + r371;
            Boolean r373 = r100.mis_department_v1;
            if (r373 == null) goto L365;
            int r374 = ProtoAdapter.BOOL.encodedSizeWithTag(143, r373);
        L366:
            int r375 = r372 + r374;
            Boolean r376 = r100.mis_p2p_ai;
            if (r376 == null) goto L369;
            int r377 = ProtoAdapter.BOOL.encodedSizeWithTag(144, r376);
        L370:
            int r378 = r375 + r377;
            BannerSetting r379 = r100.mbanner_setting;
            if (r379 == null) goto L373;
            int r380 = BannerSetting.ADAPTER.encodedSizeWithTag(145, r379);
        L374:
            int r381 = r378 + r380;
            Boolean r382 = r100.mhas_chat_menu;
            if (r382 == null) goto L377;
            int r383 = ProtoAdapter.BOOL.encodedSizeWithTag(146, r382);
        L378:
            int r384 = r381 + r383;
            Boolean r385 = r100.mis_p2p_official_bot_ai;
            if (r385 == null) goto L381;
            int r386 = ProtoAdapter.BOOL.encodedSizeWithTag(147, r385);
        L382:
            int r387 = r384 + r386;
            Boolean r388 = r100.mis_invisible;
            if (r388 == null) goto L385;
            int r389 = ProtoAdapter.BOOL.encodedSizeWithTag(148, r388);
        L386:
            int r390 = r387 + r389;
            Boolean r391 = r100.mis_cross_tenant_v1;
            if (r391 == null) goto L389;
            int r392 = ProtoAdapter.BOOL.encodedSizeWithTag(149, r391);
        L390:
            int r393 = r390 + r392;
            ChatUserAutoMuteSetting r394 = r100.muser_auto_mute_setting;
            if (r394 == null) goto L393;
            int r395 = ChatUserAutoMuteSetting.ADAPTER.encodedSizeWithTag(150, r394);
        L394:
            int r396 = r393 + r395;
            Integer r397 = r100.mread_position_filter_mute_bot_badge_count;
            if (r397 == null) goto L397;
            int r398 = r314.encodedSizeWithTag(151, r397);
        L398:
            int r399 = r396 + r398;
            Integer r400 = r100.mlast_message_position_filter_mute_bot_badge_count;
            if (r400 == null) goto L401;
            int r401 = r314.encodedSizeWithTag(152, r400);
        L402:
            int r402 = r399 + r401;
            Integer r403 = r100.mread_thread_position_filter_mute_bot_badge_count;
            if (r403 == null) goto L405;
            int r404 = r314.encodedSizeWithTag(153, r403);
        L406:
            int r405 = r402 + r404;
            Integer r406 = r100.mlast_thread_message_position_filter_mute_bot_badge_count;
            if (r406 == null) goto L409;
            int r407 = r314.encodedSizeWithTag(154, r406);
        L410:
            int r408 = r405 + r407;
            Long r409 = r100.mfilter_mute_bot_badge_count_version;
            if (r409 == null) goto L413;
            int r410 = ProtoAdapter.INT64.encodedSizeWithTag(155, r409);
        L414:
            int r411 = r408 + r410;
            Long r412 = r100.muser_clean_message_time_ms;
            if (r412 == null) goto L417;
            int r413 = ProtoAdapter.INT64.encodedSizeWithTag(156, r412);
        L418:
            int r414 = r411 + r413;
            TnsOpKind r415 = r100.mtns_op_kind;
            if (r415 == null) goto L421;
            int r416 = TnsOpKind.ADAPTER.encodedSizeWithTag(157, r415);
        L422:
            int r417 = r414 + r416;
            SystemBannedInfo r418 = r100.msystem_banned_info;
            if (r418 == null) goto L426;
            r102 = SystemBannedInfo.ADAPTER.encodedSizeWithTag(158, r418);
        L426:
            return (r417 + r102) + r100.unknownFields().size();
        L421:
            r416 = 0;
            goto L422
        L417:
            r413 = 0;
            goto L418
        L413:
            r410 = 0;
            goto L414
        L409:
            r407 = 0;
            goto L410
        L405:
            r404 = 0;
            goto L406
        L401:
            r401 = 0;
            goto L402
        L397:
            r398 = 0;
            goto L398
        L393:
            r395 = 0;
            goto L394
        L389:
            r392 = 0;
            goto L390
        L385:
            r389 = 0;
            goto L386
        L381:
            r386 = 0;
            goto L382
        L377:
            r383 = 0;
            goto L378
        L373:
            r380 = 0;
            goto L374
        L369:
            r377 = 0;
            goto L370
        L365:
            r374 = 0;
            goto L366
        L361:
            r371 = 0;
            goto L362
        L357:
            r368 = 0;
            goto L358
        L353:
            r365 = 0;
            goto L354
        L349:
            r362 = 0;
            goto L350
        L345:
            r359 = 0;
            goto L346
        L341:
            r356 = 0;
            goto L342
        L337:
            r353 = 0;
            goto L338
        L333:
            r350 = 0;
            goto L334
        L329:
            r347 = 0;
            goto L330
        L325:
            r344 = 0;
            goto L326
        L321:
            r341 = 0;
            goto L322
        L317:
            r338 = 0;
            goto L318
        L313:
            r335 = 0;
            goto L314
        L309:
            r332 = 0;
            goto L310
        L305:
            r329 = 0;
            goto L306
        L301:
            r326 = 0;
            goto L302
        L297:
            r323 = 0;
            goto L298
        L293:
            r320 = 0;
            goto L294
        L289:
            r317 = 0;
            goto L290
        L285:
            r312 = 0;
            goto L286
        L281:
            r309 = 0;
            goto L282
        L277:
            r306 = 0;
            goto L278
        L273:
            r303 = 0;
            goto L274
        L269:
            r300 = 0;
            goto L270
        L265:
            r297 = 0;
            goto L266
        L261:
            r294 = 0;
            goto L262
        L257:
            r291 = 0;
            goto L258
        L253:
            r288 = 0;
            goto L254
        L249:
            r285 = 0;
            goto L250
        L245:
            r282 = 0;
            goto L246
        L241:
            r279 = 0;
            goto L242
        L237:
            r276 = 0;
            goto L238
        L233:
            r273 = 0;
            goto L234
        L229:
            r270 = 0;
            goto L230
        L225:
            r267 = 0;
            goto L226
        L221:
            r264 = 0;
            goto L222
        L217:
            r261 = 0;
            goto L218
        L213:
            r258 = 0;
            goto L214
        L209:
            r255 = 0;
            goto L210
        L205:
            r252 = 0;
            goto L206
        L201:
            r249 = 0;
            goto L202
        L197:
            r246 = 0;
            goto L198
        L193:
            r243 = 0;
            goto L194
        L189:
            r240 = 0;
            goto L190
        L185:
            r237 = 0;
            goto L186
        L181:
            r234 = 0;
            goto L182
        L177:
            r231 = 0;
            goto L178
        L173:
            r228 = 0;
            goto L174
        L169:
            r225 = 0;
            goto L170
        L165:
            r222 = 0;
            goto L166
        L161:
            r219 = 0;
            goto L162
        L157:
            r216 = 0;
            goto L158
        L153:
            r213 = 0;
            goto L154
        L149:
            r210 = 0;
            goto L150
        L145:
            r207 = 0;
            goto L146
        L141:
            r204 = 0;
            goto L142
        L137:
            r201 = 0;
            goto L138
        L133:
            r198 = 0;
            goto L134
        L129:
            r195 = 0;
            goto L130
        L125:
            r192 = 0;
            goto L126
        L121:
            r189 = 0;
            goto L122
        L117:
            r186 = 0;
            goto L118
        L113:
            r183 = 0;
            goto L114
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
        public /* bridge */ /* synthetic */ Chat decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Chat r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Chat r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Type r103 = r101.mtype;
            if (r103 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mlast_message_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mname;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Image r106 = r101.mavatar;
            if (r106 == null) goto L17;
            Image.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mowner_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.mnew_message_count;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            Status r109 = r101.mstatus;
            if (r109 == null) goto L26;
            Status.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.mupdate_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.mkey;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.mdescription;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            Integer r113 = r101.mmember_count;
            if (r113 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r113);
        L38:
            Boolean r114 = r101.mis_department;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r114);
        L41:
            Boolean r115 = r101.mis_public;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r115);
        L44:
            Integer r116 = r101.mlast_message_position;
            if (r116 == null) goto L47;
            ProtoAdapter.INT32.encodeWithTag(r100, 15, r116);
        L47:
            Integer r117 = r101.muser_count;
            if (r117 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r100, 16, r117);
        L50:
            String r118 = r101.mname_pinyin;
            if (r118 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r100, 17, r118);
        L53:
            Long r119 = r101.mcreate_time;
            if (r119 == null) goto L56;
            ProtoAdapter.INT64.encodeWithTag(r100, 18, r119);
        L56:
            Boolean r120 = r101.mis_customer_service;
            if (r120 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r120);
        L59:
            Role r121 = r101.mrole;
            if (r121 == null) goto L62;
            Role.ADAPTER.encodeWithTag(r100, 20, r121);
        L62:
            Boolean r122 = r101.mis_custom_icon;
            if (r122 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r122);
        L65:
            Integer r123 = r101.mno_badged_new_message_count;
            if (r123 == null) goto L68;
            ProtoAdapter.INT32.encodeWithTag(r100, 22, r123);
        L68:
            Boolean r124 = r101.moff_edit_group_chat_info;
            if (r124 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r100, 23, r124);
        L71:
            Announcement r125 = r101.mannouncement;
            if (r125 == null) goto L74;
            Announcement.ADAPTER.encodeWithTag(r100, 24, r125);
        L74:
            String r126 = r101.mtenant_id;
            if (r126 == null) goto L77;
            ProtoAdapter.STRING.encodeWithTag(r100, 25, r126);
        L77:
            Long r127 = r101.mupdate_time_ms;
            if (r127 == null) goto L80;
            ProtoAdapter.INT64.encodeWithTag(r100, 26, r127);
        L80:
            Boolean r128 = r101.mis_remind;
            if (r128 == null) goto L83;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r128);
        L83:
            ChatEntitySetting r129 = r101.mchat_entity_setting;
            if (r129 == null) goto L86;
            ChatEntitySetting.ADAPTER.encodeWithTag(r100, 28, r129);
        L86:
            ChatSetting r130 = r101.muser_setting;
            if (r130 == null) goto L89;
            ChatSetting.ADAPTER.encodeWithTag(r100, 29, r130);
        L89:
            Boolean r131 = r101.mis_dissolved;
            if (r131 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r100, 30, r131);
        L92:
            Boolean r132 = r101.mis_meeting;
            if (r132 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r132);
        L95:
            String r133 = r101.mlast_visible_message_id;
            if (r133 == null) goto L98;
            ProtoAdapter.STRING.encodeWithTag(r100, 32, r133);
        L98:
            MessageLastVisibleInfoPatch r134 = r101.mmessage_last_visible_patch;
            if (r134 == null) goto L101;
            MessageLastVisibleInfoPatch.ADAPTER.encodeWithTag(r100, 131, r134);
        L101:
            String r135 = r101.mlast_thread_id;
            if (r135 == null) goto L104;
            ProtoAdapter.STRING.encodeWithTag(r100, 33, r135);
        L104:
            Integer r136 = r101.mnew_thread_count;
            if (r136 == null) goto L107;
            ProtoAdapter.INT32.encodeWithTag(r100, 34, r136);
        L107:
            Integer r137 = r101.mlast_thread_position;
            if (r137 == null) goto L110;
            ProtoAdapter.INT32.encodeWithTag(r100, 35, r137);
        L110:
            Boolean r138 = r101.mis_crypto;
            if (r138 == null) goto L113;
            ProtoAdapter.BOOL.encodeWithTag(r100, 36, r138);
        L113:
            Integer r139 = r101.mno_badged_new_thread_count;
            if (r139 == null) goto L116;
            ProtoAdapter.INT32.encodeWithTag(r100, 37, r139);
        L116:
            Integer r140 = r101.mthread_start_position;
            if (r140 == null) goto L119;
            ProtoAdapter.INT32.encodeWithTag(r100, 38, r140);
        L119:
            ChatMode r141 = r101.mchat_mode;
            if (r141 == null) goto L122;
            ChatMode.ADAPTER.encodeWithTag(r100, 39, r141);
        L122:
            ChatConfig r142 = r101.mchat_config;
            if (r142 == null) goto L125;
            ChatConfig.ADAPTER.encodeWithTag(r100, 40, r142);
        L125:
            Boolean r143 = r101.mis_cross_tenant;
            if (r143 == null) goto L128;
            ProtoAdapter.BOOL.encodeWithTag(r100, 41, r143);
        L128:
            Boolean r144 = r101.mis_tenant;
            if (r144 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r100, 42, r144);
        L131:
            SupportView r145 = r101.msupport_view;
            if (r145 == null) goto L134;
            SupportView.ADAPTER.encodeWithTag(r100, 43, r145);
        L134:
            Long r146 = r101.mjoin_time_ms;
            if (r146 == null) goto L137;
            ProtoAdapter.INT64.encodeWithTag(r100, 44, r146);
        L137:
            Long r147 = r101.moncall_id;
            if (r147 == null) goto L140;
            ProtoAdapter.INT64.encodeWithTag(r100, 45, r147);
        L140:
            Integer r148 = r101.mlast_visible_message_position;
            if (r148 == null) goto L143;
            ProtoAdapter.INT32.encodeWithTag(r100, 46, r148);
        L143:
            Integer r149 = r101.mlast_visible_message_no_badged_count;
            if (r149 == null) goto L146;
            ProtoAdapter.INT32.encodeWithTag(r100, 47, r149);
        L146:
            Integer r150 = r101.mread_position;
            if (r150 == null) goto L149;
            ProtoAdapter.INT32.encodeWithTag(r100, 48, r150);
        L149:
            Integer r151 = r101.mread_position_badge_count;
            if (r151 == null) goto L152;
            ProtoAdapter.INT32.encodeWithTag(r100, 49, r151);
        L152:
            Integer r152 = r101.mlast_message_position_badge_count;
            if (r152 == null) goto L155;
            ProtoAdapter.INT32.encodeWithTag(r100, 50, r152);
        L155:
            Boolean r153 = r101.menable_watermark;
            if (r153 == null) goto L158;
            ProtoAdapter.BOOL.encodeWithTag(r100, 51, r153);
        L158:
            Image r154 = r101.mmini_avatar;
            if (r154 == null) goto L161;
            Image.ADAPTER.encodeWithTag(r100, 52, r154);
        L161:
            String r155 = r101.msidebar_id;
            if (r155 == null) goto L164;
            ProtoAdapter.STRING.encodeWithTag(r100, 53, r155);
        L164:
            String r156 = r101.mname_py;
            if (r156 == null) goto L167;
            ProtoAdapter.STRING.encodeWithTag(r100, 100, r156);
        L167:
            this.mi18n_names.encodeWithTag(r100, 101, r101.mi18n_names);
            I18nInf r157 = r101.mi18n_inf;
            if (r157 == null) goto L170;
            I18nInf.ADAPTER.encodeWithTag(r100, 102, r157);
        L170:
            Integer r158 = r101.mread_thread_position;
            if (r158 == null) goto L173;
            ProtoAdapter.INT32.encodeWithTag(r100, 103, r158);
        L173:
            Integer r159 = r101.mread_thread_position_badge_count;
            if (r159 == null) goto L176;
            ProtoAdapter.INT32.encodeWithTag(r100, 104, r159);
        L176:
            Integer r160 = r101.mlast_thread_position_badge_count;
            if (r160 == null) goto L179;
            ProtoAdapter.INT32.encodeWithTag(r100, 105, r160);
        L179:
            Integer r161 = r101.mlast_visible_thread_position;
            if (r161 == null) goto L182;
            ProtoAdapter.INT32.encodeWithTag(r100, 106, r161);
        L182:
            String r162 = r101.mlast_visible_thread_id;
            if (r162 == null) goto L185;
            ProtoAdapter.STRING.encodeWithTag(r100, 107, r162);
        L185:
            MessageLastVisibleInfoPatch r163 = r101.mthread_last_visible_patch;
            if (r163 == null) goto L188;
            MessageLastVisibleInfoPatch.ADAPTER.encodeWithTag(r100, 132, r163);
        L188:
            ChatSecurityConfig r164 = r101.mchat_security_config;
            if (r164 == null) goto L191;
            ChatSecurityConfig.ADAPTER.encodeWithTag(r100, 108, r164);
        L191:
            Boolean r165 = r101.mis_public_v2;
            if (r165 == null) goto L194;
            ProtoAdapter.BOOL.encodeWithTag(r100, 109, r165);
        L194:
            ChatPostType r166 = r101.mpost_type;
            if (r166 == null) goto L197;
            ChatPostType.ADAPTER.encodeWithTag(r100, 110, r166);
        L197:
            Boolean r167 = r101.mallow_post;
            if (r167 == null) goto L200;
            ProtoAdapter.BOOL.encodeWithTag(r100, 111, r167);
        L200:
            Long r168 = r101.mburned_time;
            if (r168 == null) goto L203;
            ProtoAdapter.INT64.encodeWithTag(r100, 112, r168);
        L203:
            Integer r169 = r101.mput_chatter_apply_count;
            if (r169 == null) goto L206;
            ProtoAdapter.INT32.encodeWithTag(r100, 113, r169);
        L206:
            Boolean r170 = r101.mshow_banner;
            if (r170 == null) goto L209;
            ProtoAdapter.BOOL.encodeWithTag(r100, 114, r170);
        L209:
            Boolean r171 = r101.mis_large_group;
            if (r171 == null) goto L212;
            ProtoAdapter.BOOL.encodeWithTag(r100, 115, r171);
        L212:
            Integer r172 = r101.mfirst_chat_message_position;
            if (r172 == null) goto L215;
            ProtoAdapter.INT32.encodeWithTag(r100, 116, r172);
        L215:
            ProtoAdapter<Integer> r173 = ProtoAdapter.INT32;
            r173.asRepeated().encodeWithTag(r100, 117, r101.mtags);
            this.mextra.encodeWithTag(r100, 118, r101.mextra);
            Boolean r174 = r101.mis_same_page_meeting;
            if (r174 == null) goto L218;
            ProtoAdapter.BOOL.encodeWithTag(r100, 119, r174);
        L218:
            Long r175 = r101.mmy_threads_read_timestamp;
            if (r175 == null) goto L221;
            ProtoAdapter.INT64.encodeWithTag(r100, 120, r175);
        L221:
            Long r176 = r101.mmy_threads_last_timestamp;
            if (r176 == null) goto L224;
            ProtoAdapter.INT64.encodeWithTag(r100, 121, r176);
        L224:
            Boolean r177 = r101.mis_edu;
            if (r177 == null) goto L227;
            ProtoAdapter.BOOL.encodeWithTag(r100, 122, r177);
        L227:
            Long r178 = r101.mmy_threads_last_display_message_id;
            if (r178 == null) goto L230;
            ProtoAdapter.INT64.encodeWithTag(r100, 123, r178);
        L230:
            Integer r179 = r101.mmy_threads_unread_count;
            if (r179 == null) goto L233;
            r173.encodeWithTag(r100, 124, r179);
        L233:
            Boolean r180 = r101.mis_cross_with_ka;
            if (r180 == null) goto L236;
            ProtoAdapter.BOOL.encodeWithTag(r100, 125, r180);
        L236:
            Boolean r181 = r101.mis_admin;
            if (r181 == null) goto L239;
            ProtoAdapter.BOOL.encodeWithTag(r100, 126, r181);
        L239:
            Boolean r182 = r101.mis_super;
            if (r182 == null) goto L242;
            ProtoAdapter.BOOL.encodeWithTag(r100, 127, r182);
        L242:
            Boolean r183 = r101.mis_team;
            if (r183 == null) goto L245;
            ProtoAdapter.BOOL.encodeWithTag(r100, 128, r183);
        L245:
            ChatBizContent r184 = r101.mbiz_content;
            if (r184 == null) goto L248;
            ChatBizContent.ADAPTER.encodeWithTag(r100, 129, r184);
        L248:
            this.mchatter_extra_states.encodeWithTag(r100, 130, r101.mchatter_extra_states);
            Boolean r185 = r101.mis_private_mode;
            if (r185 == null) goto L251;
            ProtoAdapter.BOOL.encodeWithTag(r100, 133, r185);
        L251:
            String r186 = r101.mopen_chat_id;
            if (r186 == null) goto L254;
            ProtoAdapter.STRING.encodeWithTag(r100, 134, r186);
        L254:
            ChatToolkit r187 = r101.mtoolkit;
            if (r187 == null) goto L257;
            ChatToolkit.ADAPTER.encodeWithTag(r100, 135, r187);
        L257:
            GeneralChatSetting r188 = r101.mchat_general_setting;
            if (r188 == null) goto L260;
            GeneralChatSetting.ADAPTER.encodeWithTag(r100, 136, r188);
        L260:
            TagData r189 = r101.mtag_data;
            if (r189 == null) goto L263;
            TagData.ADAPTER.encodeWithTag(r100, 137, r189);
        L263:
            this.mgroup_type.encodeWithTag(r100, 138, r101.mgroup_type);
            this.mbiz_version_map.encodeWithTag(r100, 139, r101.mbiz_version_map);
            CryptoChatInfo r190 = r101.mcrypto_chat_info;
            if (r190 == null) goto L266;
            CryptoChatInfo.ADAPTER.encodeWithTag(r100, 140, r190);
        L266:
            Boolean r191 = r101.mis_frozen;
            if (r191 == null) goto L269;
            ProtoAdapter.BOOL.encodeWithTag(r100, 141, r191);
        L269:
            Long r192 = r101.mchat_chatter_version;
            if (r192 == null) goto L272;
            ProtoAdapter.INT64.encodeWithTag(r100, 142, r192);
        L272:
            Boolean r193 = r101.mis_department_v1;
            if (r193 == null) goto L275;
            ProtoAdapter.BOOL.encodeWithTag(r100, 143, r193);
        L275:
            Boolean r194 = r101.mis_p2p_ai;
            if (r194 == null) goto L278;
            ProtoAdapter.BOOL.encodeWithTag(r100, 144, r194);
        L278:
            BannerSetting r195 = r101.mbanner_setting;
            if (r195 == null) goto L281;
            BannerSetting.ADAPTER.encodeWithTag(r100, 145, r195);
        L281:
            Boolean r196 = r101.mhas_chat_menu;
            if (r196 == null) goto L284;
            ProtoAdapter.BOOL.encodeWithTag(r100, 146, r196);
        L284:
            Boolean r197 = r101.mis_p2p_official_bot_ai;
            if (r197 == null) goto L287;
            ProtoAdapter.BOOL.encodeWithTag(r100, 147, r197);
        L287:
            Boolean r198 = r101.mis_invisible;
            if (r198 == null) goto L290;
            ProtoAdapter.BOOL.encodeWithTag(r100, 148, r198);
        L290:
            Boolean r199 = r101.mis_cross_tenant_v1;
            if (r199 == null) goto L293;
            ProtoAdapter.BOOL.encodeWithTag(r100, 149, r199);
        L293:
            ChatUserAutoMuteSetting r200 = r101.muser_auto_mute_setting;
            if (r200 == null) goto L296;
            ChatUserAutoMuteSetting.ADAPTER.encodeWithTag(r100, 150, r200);
        L296:
            Integer r201 = r101.mread_position_filter_mute_bot_badge_count;
            if (r201 == null) goto L299;
            r173.encodeWithTag(r100, 151, r201);
        L299:
            Integer r202 = r101.mlast_message_position_filter_mute_bot_badge_count;
            if (r202 == null) goto L302;
            r173.encodeWithTag(r100, 152, r202);
        L302:
            Integer r203 = r101.mread_thread_position_filter_mute_bot_badge_count;
            if (r203 == null) goto L305;
            r173.encodeWithTag(r100, 153, r203);
        L305:
            Integer r204 = r101.mlast_thread_message_position_filter_mute_bot_badge_count;
            if (r204 == null) goto L308;
            r173.encodeWithTag(r100, 154, r204);
        L308:
            Long r205 = r101.mfilter_mute_bot_badge_count_version;
            if (r205 == null) goto L311;
            ProtoAdapter.INT64.encodeWithTag(r100, 155, r205);
        L311:
            Long r206 = r101.muser_clean_message_time_ms;
            if (r206 == null) goto L314;
            ProtoAdapter.INT64.encodeWithTag(r100, 156, r206);
        L314:
            TnsOpKind r207 = r101.mtns_op_kind;
            if (r207 == null) goto L317;
            TnsOpKind.ADAPTER.encodeWithTag(r100, 157, r207);
        L317:
            SystemBannedInfo r208 = r101.msystem_banned_info;
            if (r208 == null) goto L320;
            SystemBannedInfo.ADAPTER.encodeWithTag(r100, 158, r208);
        L320:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Chat r101) throws IOException {
            encode2(r100, r101);
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

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status ARCHIVE = null;
        public static final Status DELETED = null;
        public static final Status NORMAL = null;
        private final int value;

        static {
            Status r100 = new Status(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            Status r101 = new Status("ARCHIVE", 1, 1);
            ARCHIVE = r101;
            Status r102 = new Status("DELETED", 2, 2);
            DELETED = r102;
            $VALUES = new Status[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DELETED;
        L12:
            return ARCHIVE;
        L14:
            return NORMAL;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SupportView extends Enum<SupportView> implements WireEnum {
        private static final /* synthetic */ SupportView[] $VALUES = null;
        public static final ProtoAdapter<SupportView> ADAPTER = null;
        public static final SupportView VIEW_CRYPTO = null;
        public static final SupportView VIEW_MEETING = null;
        public static final SupportView VIEW_P2PGROUP = null;
        public static final SupportView VIEW_THREAD = null;
        public static final SupportView VIEW_UNKNOWN = null;
        private final int value;

        static {
            SupportView r100 = new SupportView("VIEW_UNKNOWN", 0, 0);
            VIEW_UNKNOWN = r100;
            SupportView r101 = new SupportView("VIEW_P2PGROUP", 1, 1);
            VIEW_P2PGROUP = r101;
            SupportView r102 = new SupportView("VIEW_MEETING", 2, 2);
            VIEW_MEETING = r102;
            SupportView r103 = new SupportView("VIEW_THREAD", 3, 3);
            VIEW_THREAD = r103;
            SupportView r104 = new SupportView("VIEW_CRYPTO", 4, 4);
            VIEW_CRYPTO = r104;
            $VALUES = new SupportView[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(SupportView.class);
        }

        public static SupportView[] values() {
            return (SupportView[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SupportView fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return VIEW_CRYPTO;
        L16:
            return VIEW_THREAD;
        L18:
            return VIEW_MEETING;
        L20:
            return VIEW_P2PGROUP;
        L22:
            return VIEW_UNKNOWN;
        }

        public static SupportView valueOf(String r100) {
            return (SupportView) a.a(SupportView.class, r100);
        }

        private SupportView(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type TOPIC_GROUP = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("P2P", 1, 1);
            P2P = r101;
            Type r102 = new Type("GROUP", 2, 2);
            GROUP = r102;
            Type r103 = new Type("TOPIC_GROUP", 3, 3);
            TOPIC_GROUP = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
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
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return TOPIC_GROUP;
        L14:
            return GROUP;
        L16:
            return P2P;
        L18:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Chat();
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_MEMBER_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DEPARTMENT = r100;
        DEFAULT_IS_PUBLIC = r100;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_USER_COUNT = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_IS_CUSTOMER_SERVICE = r100;
        DEFAULT_IS_CUSTOM_ICON = r100;
        DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = 0;
        DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = r100;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_IS_REMIND = Boolean.TRUE;
        DEFAULT_IS_DISSOLVED = r100;
        DEFAULT_IS_MEETING = r100;
        DEFAULT_NEW_THREAD_COUNT = 0;
        DEFAULT_LAST_THREAD_POSITION = 0;
        DEFAULT_IS_CRYPTO = r100;
        DEFAULT_NO_BADGED_NEW_THREAD_COUNT = 0;
        DEFAULT_THREAD_START_POSITION = 0;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_IS_TENANT = r100;
        DEFAULT_JOIN_TIME_MS = 0L;
        DEFAULT_ONCALL_ID = 0L;
        DEFAULT_LAST_VISIBLE_MESSAGE_POSITION = 0;
        DEFAULT_LAST_VISIBLE_MESSAGE_NO_BADGED_COUNT = 0;
        DEFAULT_READ_POSITION = 0;
        DEFAULT_READ_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = 0;
        DEFAULT_ENABLE_WATERMARK = r100;
        DEFAULT_READ_THREAD_POSITION = 0;
        DEFAULT_READ_THREAD_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_THREAD_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_VISIBLE_THREAD_POSITION = 0;
        DEFAULT_IS_PUBLIC_V2 = r100;
        DEFAULT_ALLOW_POST = r100;
        DEFAULT_BURNED_TIME = 0L;
        DEFAULT_PUT_CHATTER_APPLY_COUNT = 0;
        DEFAULT_SHOW_BANNER = r100;
        DEFAULT_IS_LARGE_GROUP = r100;
        DEFAULT_FIRST_CHAT_MESSAGE_POSITION = 0;
        DEFAULT_IS_SAME_PAGE_MEETING = r100;
        DEFAULT_MY_THREADS_READ_TIMESTAMP = 0L;
        DEFAULT_MY_THREADS_LAST_TIMESTAMP = 0L;
        DEFAULT_IS_EDU = r100;
        DEFAULT_MY_THREADS_LAST_DISPLAY_MESSAGE_ID = 0L;
        DEFAULT_MY_THREADS_UNREAD_COUNT = 0;
        DEFAULT_IS_CROSS_WITH_KA = r100;
        DEFAULT_IS_ADMIN = r100;
        DEFAULT_IS_SUPER = r100;
        DEFAULT_IS_TEAM = r100;
        DEFAULT_IS_PRIVATE_MODE = r100;
        DEFAULT_IS_FROZEN = r100;
        DEFAULT_CHAT_CHATTER_VERSION = 0L;
        DEFAULT_IS_DEPARTMENT_V1 = r100;
        DEFAULT_IS_P2P_AI = r100;
        DEFAULT_HAS_CHAT_MENU = r100;
        DEFAULT_IS_P2P_OFFICIAL_BOT_AI = r100;
        DEFAULT_IS_INVISIBLE = r100;
        DEFAULT_IS_CROSS_TENANT_V1 = r100;
        DEFAULT_READ_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_READ_THREAD_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_LAST_THREAD_MESSAGE_POSITION_FILTER_MUTE_BOT_BADGE_COUNT = 0;
        DEFAULT_FILTER_MUTE_BOT_BADGE_COUNT_VERSION = 0L;
        DEFAULT_USER_CLEAN_MESSAGE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtype = this.mtype;
        r100.mlast_message_id = this.mlast_message_id;
        r100.mname = this.mname;
        r100.mavatar = this.mavatar;
        r100.mowner_id = this.mowner_id;
        r100.mnew_message_count = this.mnew_message_count;
        r100.mstatus = this.mstatus;
        r100.mupdate_time = this.mupdate_time;
        r100.mkey = this.mkey;
        r100.mdescription = this.mdescription;
        r100.mmember_count = this.mmember_count;
        r100.mis_department = this.mis_department;
        r100.mis_public = this.mis_public;
        r100.mlast_message_position = this.mlast_message_position;
        r100.muser_count = this.muser_count;
        r100.mname_pinyin = this.mname_pinyin;
        r100.mcreate_time = this.mcreate_time;
        r100.mis_customer_service = this.mis_customer_service;
        r100.mrole = this.mrole;
        r100.mis_custom_icon = this.mis_custom_icon;
        r100.mno_badged_new_message_count = this.mno_badged_new_message_count;
        r100.moff_edit_group_chat_info = this.moff_edit_group_chat_info;
        r100.mannouncement = this.mannouncement;
        r100.mtenant_id = this.mtenant_id;
        r100.mupdate_time_ms = this.mupdate_time_ms;
        r100.mis_remind = this.mis_remind;
        r100.mchat_entity_setting = this.mchat_entity_setting;
        r100.muser_setting = this.muser_setting;
        r100.mis_dissolved = this.mis_dissolved;
        r100.mis_meeting = this.mis_meeting;
        r100.mlast_visible_message_id = this.mlast_visible_message_id;
        r100.mmessage_last_visible_patch = this.mmessage_last_visible_patch;
        r100.mlast_thread_id = this.mlast_thread_id;
        r100.mnew_thread_count = this.mnew_thread_count;
        r100.mlast_thread_position = this.mlast_thread_position;
        r100.mis_crypto = this.mis_crypto;
        r100.mno_badged_new_thread_count = this.mno_badged_new_thread_count;
        r100.mthread_start_position = this.mthread_start_position;
        r100.mchat_mode = this.mchat_mode;
        r100.mchat_config = this.mchat_config;
        r100.mis_cross_tenant = this.mis_cross_tenant;
        r100.mis_tenant = this.mis_tenant;
        r100.msupport_view = this.msupport_view;
        r100.mjoin_time_ms = this.mjoin_time_ms;
        r100.moncall_id = this.moncall_id;
        r100.mlast_visible_message_position = this.mlast_visible_message_position;
        r100.mlast_visible_message_no_badged_count = this.mlast_visible_message_no_badged_count;
        r100.mread_position = this.mread_position;
        r100.mread_position_badge_count = this.mread_position_badge_count;
        r100.mlast_message_position_badge_count = this.mlast_message_position_badge_count;
        r100.menable_watermark = this.menable_watermark;
        r100.mmini_avatar = this.mmini_avatar;
        r100.msidebar_id = this.msidebar_id;
        r100.mname_py = this.mname_py;
        r100.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r100.mi18n_inf = this.mi18n_inf;
        r100.mread_thread_position = this.mread_thread_position;
        r100.mread_thread_position_badge_count = this.mread_thread_position_badge_count;
        r100.mlast_thread_position_badge_count = this.mlast_thread_position_badge_count;
        r100.mlast_visible_thread_position = this.mlast_visible_thread_position;
        r100.mlast_visible_thread_id = this.mlast_visible_thread_id;
        r100.mthread_last_visible_patch = this.mthread_last_visible_patch;
        r100.mchat_security_config = this.mchat_security_config;
        r100.mis_public_v2 = this.mis_public_v2;
        r100.mpost_type = this.mpost_type;
        r100.mallow_post = this.mallow_post;
        r100.mburned_time = this.mburned_time;
        r100.mput_chatter_apply_count = this.mput_chatter_apply_count;
        r100.mshow_banner = this.mshow_banner;
        r100.mis_large_group = this.mis_large_group;
        r100.mfirst_chat_message_position = this.mfirst_chat_message_position;
        r100.mtags = Internal.copyOf("mtags", this.mtags);
        r100.mextra = Internal.copyOf("mextra", this.mextra);
        r100.mis_same_page_meeting = this.mis_same_page_meeting;
        r100.mmy_threads_read_timestamp = this.mmy_threads_read_timestamp;
        r100.mmy_threads_last_timestamp = this.mmy_threads_last_timestamp;
        r100.mis_edu = this.mis_edu;
        r100.mmy_threads_last_display_message_id = this.mmy_threads_last_display_message_id;
        r100.mmy_threads_unread_count = this.mmy_threads_unread_count;
        r100.mis_cross_with_ka = this.mis_cross_with_ka;
        r100.mis_admin = this.mis_admin;
        r100.mis_super = this.mis_super;
        r100.mis_team = this.mis_team;
        r100.mbiz_content = this.mbiz_content;
        r100.mchatter_extra_states = Internal.copyOf("mchatter_extra_states", this.mchatter_extra_states);
        r100.mis_private_mode = this.mis_private_mode;
        r100.mopen_chat_id = this.mopen_chat_id;
        r100.mtoolkit = this.mtoolkit;
        r100.mchat_general_setting = this.mchat_general_setting;
        r100.mtag_data = this.mtag_data;
        r100.mgroup_type = Internal.copyOf("mgroup_type", this.mgroup_type);
        r100.mbiz_version_map = Internal.copyOf("mbiz_version_map", this.mbiz_version_map);
        r100.mcrypto_chat_info = this.mcrypto_chat_info;
        r100.mis_frozen = this.mis_frozen;
        r100.mchat_chatter_version = this.mchat_chatter_version;
        r100.mis_department_v1 = this.mis_department_v1;
        r100.mis_p2p_ai = this.mis_p2p_ai;
        r100.mbanner_setting = this.mbanner_setting;
        r100.mhas_chat_menu = this.mhas_chat_menu;
        r100.mis_p2p_official_bot_ai = this.mis_p2p_official_bot_ai;
        r100.mis_invisible = this.mis_invisible;
        r100.mis_cross_tenant_v1 = this.mis_cross_tenant_v1;
        r100.muser_auto_mute_setting = this.muser_auto_mute_setting;
        r100.mread_position_filter_mute_bot_badge_count = this.mread_position_filter_mute_bot_badge_count;
        r100.mlast_message_position_filter_mute_bot_badge_count = this.mlast_message_position_filter_mute_bot_badge_count;
        r100.mread_thread_position_filter_mute_bot_badge_count = this.mread_thread_position_filter_mute_bot_badge_count;
        r100.mlast_thread_message_position_filter_mute_bot_badge_count = this.mlast_thread_message_position_filter_mute_bot_badge_count;
        r100.mfilter_mute_bot_badge_count_version = this.mfilter_mute_bot_badge_count_version;
        r100.muser_clean_message_time_ms = this.muser_clean_message_time_ms;
        r100.mtns_op_kind = this.mtns_op_kind;
        r100.msystem_banned_info = this.msystem_banned_info;
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

    public Chat(String r115, Type r116, String r117, String r118, Image r119, String r120, Integer r121, Status r122, Long r123, String r124, String r125, Integer r126, Boolean r127, Boolean r128, Integer r129, Integer r130, String r131, Long r132, Boolean r133, Role r134, Boolean r135, Integer r136, Boolean r137, Announcement r138, String r139, Long r140, Boolean r141, ChatEntitySetting r142, ChatSetting r143, Boolean r144, Boolean r145, String r146, MessageLastVisibleInfoPatch r147, String r148, Integer r149, Integer r150, Boolean r151, Integer r152, Integer r153, ChatMode r154, ChatConfig r155, Boolean r156, Boolean r157, SupportView r158, Long r159, Long r160, Integer r161, Integer r162, Integer r163, Integer r164, Integer r165, Boolean r166, Image r167, String r168, String r169, Map<String, String> r170, I18nInf r171, Integer r172, Integer r173, Integer r174, Integer r175, String r176, MessageLastVisibleInfoPatch r177, ChatSecurityConfig r178, Boolean r179, ChatPostType r180, Boolean r181, Long r182, Integer r183, Boolean r184, Boolean r185, Integer r186, List<Integer> r187, Map<String, String> r188, Boolean r189, Long r190, Long r191, Boolean r192, Long r193, Integer r194, Boolean r195, Boolean r196, Boolean r197, Boolean r198, ChatBizContent r199, Map<Integer, Integer> r200, Boolean r201, String r202, ChatToolkit r203, GeneralChatSetting r204, TagData r205, Map<Integer, Boolean> r206, Map<Integer, Long> r207, CryptoChatInfo r208, Boolean r209, Long r210, Boolean r211, Boolean r212, BannerSetting r213, Boolean r214, Boolean r215, Boolean r216, Boolean r217, ChatUserAutoMuteSetting r218, Integer r219, Integer r220, Integer r221, Integer r222, Long r223, Long r224, TnsOpKind r225, SystemBannedInfo r226) {
        this(r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, ByteString.EMPTY);
    }

    public Chat(String r100, Type r101, String r102, String r103, Image r104, String r105, Integer r110, Status r111, Long r112, String r113, String r114, Integer r115, Boolean r116, Boolean r117, Integer r118, Integer r119, String r210, Long r211, Boolean r212, Role r213, Boolean r214, Integer r215, Boolean r216, Announcement r217, String r218, Long r219, Boolean r310, ChatEntitySetting r311, ChatSetting r312, Boolean r313, Boolean r314, String r315, MessageLastVisibleInfoPatch r316, String r317, Integer r318, Integer r319, Boolean r410, Integer r411, Integer r412, ChatMode r413, ChatConfig r414, Boolean r415, Boolean r416, SupportView r417, Long r418, Long r419, Integer r510, Integer r511, Integer r512, Integer r513, Integer r514, Boolean r515, Image r516, String r517, String r518, Map<String, String> r519, I18nInf r610, Integer r611, Integer r612, Integer r613, Integer r614, String r615, MessageLastVisibleInfoPatch r616, ChatSecurityConfig r617, Boolean r618, ChatPostType r619, Boolean r710, Long r711, Integer r712, Boolean r713, Boolean r714, Integer r715, List<Integer> r716, Map<String, String> r717, Boolean r718, Long r719, Long r810, Boolean r811, Long r812, Integer r813, Boolean r814, Boolean r815, Boolean r816, Boolean r817, ChatBizContent r818, Map<Integer, Integer> r819, Boolean r910, String r911, ChatToolkit r912, GeneralChatSetting r913, TagData r914, Map<Integer, Boolean> r915, Map<Integer, Long> r916, CryptoChatInfo r917, Boolean r918, Long r919, Boolean r106, Boolean r107, BannerSetting r108, Boolean r109, Boolean r1010, Boolean r1011, Boolean r1012, ChatUserAutoMuteSetting r1013, Integer r1014, Integer r1015, Integer r1110, Integer r1111, Long r1112, Long r1113, TnsOpKind r1114, SystemBannedInfo r1115, ByteString r1116) {
        super(ADAPTER, r1116);
        this.mid = r100;
        this.mtype = r101;
        this.mlast_message_id = r102;
        this.mname = r103;
        this.mavatar = r104;
        this.mowner_id = r105;
        this.mnew_message_count = r110;
        this.mstatus = r111;
        this.mupdate_time = r112;
        this.mkey = r113;
        this.mdescription = r114;
        this.mmember_count = r115;
        this.mis_department = r116;
        this.mis_public = r117;
        this.mlast_message_position = r118;
        this.muser_count = r119;
        this.mname_pinyin = r210;
        this.mcreate_time = r211;
        this.mis_customer_service = r212;
        this.mrole = r213;
        this.mis_custom_icon = r214;
        this.mno_badged_new_message_count = r215;
        this.moff_edit_group_chat_info = r216;
        this.mannouncement = r217;
        this.mtenant_id = r218;
        this.mupdate_time_ms = r219;
        this.mis_remind = r310;
        this.mchat_entity_setting = r311;
        this.muser_setting = r312;
        this.mis_dissolved = r313;
        this.mis_meeting = r314;
        this.mlast_visible_message_id = r315;
        this.mmessage_last_visible_patch = r316;
        this.mlast_thread_id = r317;
        this.mnew_thread_count = r318;
        this.mlast_thread_position = r319;
        this.mis_crypto = r410;
        this.mno_badged_new_thread_count = r411;
        this.mthread_start_position = r412;
        this.mchat_mode = r413;
        this.mchat_config = r414;
        this.mis_cross_tenant = r415;
        this.mis_tenant = r416;
        this.msupport_view = r417;
        this.mjoin_time_ms = r418;
        this.moncall_id = r419;
        this.mlast_visible_message_position = r510;
        this.mlast_visible_message_no_badged_count = r511;
        this.mread_position = r512;
        this.mread_position_badge_count = r513;
        this.mlast_message_position_badge_count = r514;
        this.menable_watermark = r515;
        this.mmini_avatar = r516;
        this.msidebar_id = r517;
        this.mname_py = r518;
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r519);
        this.mi18n_inf = r610;
        this.mread_thread_position = r611;
        this.mread_thread_position_badge_count = r612;
        this.mlast_thread_position_badge_count = r613;
        this.mlast_visible_thread_position = r614;
        this.mlast_visible_thread_id = r615;
        this.mthread_last_visible_patch = r616;
        this.mchat_security_config = r617;
        this.mis_public_v2 = r618;
        this.mpost_type = r619;
        this.mallow_post = r710;
        this.mburned_time = r711;
        this.mput_chatter_apply_count = r712;
        this.mshow_banner = r713;
        this.mis_large_group = r714;
        this.mfirst_chat_message_position = r715;
        this.mtags = Internal.immutableCopyOf("mtags", r716);
        this.mextra = Internal.immutableCopyOf("mextra", r717);
        this.mis_same_page_meeting = r718;
        this.mmy_threads_read_timestamp = r719;
        this.mmy_threads_last_timestamp = r810;
        this.mis_edu = r811;
        this.mmy_threads_last_display_message_id = r812;
        this.mmy_threads_unread_count = r813;
        this.mis_cross_with_ka = r814;
        this.mis_admin = r815;
        this.mis_super = r816;
        this.mis_team = r817;
        this.mbiz_content = r818;
        this.mchatter_extra_states = Internal.immutableCopyOf("mchatter_extra_states", r819);
        this.mis_private_mode = r910;
        this.mopen_chat_id = r911;
        this.mtoolkit = r912;
        this.mchat_general_setting = r913;
        this.mtag_data = r914;
        this.mgroup_type = Internal.immutableCopyOf("mgroup_type", r915);
        this.mbiz_version_map = Internal.immutableCopyOf("mbiz_version_map", r916);
        this.mcrypto_chat_info = r917;
        this.mis_frozen = r918;
        this.mchat_chatter_version = r919;
        this.mis_department_v1 = r106;
        this.mis_p2p_ai = r107;
        this.mbanner_setting = r108;
        this.mhas_chat_menu = r109;
        this.mis_p2p_official_bot_ai = r1010;
        this.mis_invisible = r1011;
        this.mis_cross_tenant_v1 = r1012;
        this.muser_auto_mute_setting = r1013;
        this.mread_position_filter_mute_bot_badge_count = r1014;
        this.mlast_message_position_filter_mute_bot_badge_count = r1015;
        this.mread_thread_position_filter_mute_bot_badge_count = r1110;
        this.mlast_thread_message_position_filter_mute_bot_badge_count = r1111;
        this.mfilter_mute_bot_badge_count_version = r1112;
        this.muser_clean_message_time_ms = r1113;
        this.mtns_op_kind = r1114;
        this.msystem_banned_info = r1115;
    }
}
