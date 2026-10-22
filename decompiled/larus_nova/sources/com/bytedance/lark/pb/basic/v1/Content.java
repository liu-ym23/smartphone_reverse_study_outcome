package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.lark.pb.office_sdk.basic.DoubaoContent;
import com.bytedance.lark.pb.vote.v1.VoteContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.bduploader.BDAbstractUpload;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Content extends com.squareup.wire.Message<Content, Builder> {
    public static final ProtoAdapter<Content> ADAPTER = null;
    public static final Integer DEFAULT_AUDIO2TEXT_START_TIME = null;
    public static final String DEFAULT_CACHE_FILE_PATH = "";
    public static final String DEFAULT_CRYPTO_TOKEN = "";
    public static final FileType DEFAULT_DEPRECATED = null;
    public static final Integer DEFAULT_DURATION = null;
    public static final String DEFAULT_E2EE_FROM_ID = "";
    public static final String DEFAULT_E2EE_TO_ID = "";
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final FileAbility DEFAULT_FILE_ABILITY = null;
    public static final Long DEFAULT_FILE_LAST_UPDATE_TIME_MS = null;
    public static final Long DEFAULT_FILE_LAST_UPDATE_USER_ID = null;
    public static final String DEFAULT_FILE_PATH = "";
    public static final FilePermission DEFAULT_FILE_PERMISSION = null;
    public static final FilePreviewStage DEFAULT_FILE_PREVIEW_STAGE = null;
    public static final File.Source DEFAULT_FILE_SOURCE = null;
    public static final String DEFAULT_FILE_UPLOAD_ID = "";
    public static final String DEFAULT_FILE_URI = "";
    public static final String DEFAULT_FOLDER_ARCHIVE_KEY = "";
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Boolean DEFAULT_HIDE_VOICE2TEXT = null;
    public static final String DEFAULT_I18N_TITLE_KEY = "";
    public static final String DEFAULT_IMAGE_UPLOAD_ID = "";
    public static final Boolean DEFAULT_INCLUDE_CLEANED_RESOURCES = null;
    public static final Boolean DEFAULT_IS_ABLE_LAN_TRANS = null;
    public static final Boolean DEFAULT_IS_AUDIO_RECOGNIZE_FINISH = null;
    public static final Boolean DEFAULT_IS_AUDIO_WITH_TEXT = null;
    public static final Boolean DEFAULT_IS_ENCRYPTED = null;
    public static final Boolean DEFAULT_IS_FRIEND = null;
    public static final Boolean DEFAULT_IS_GROUP_ANNOUNCEMENT = null;
    public static final Boolean DEFAULT_IS_IN_MY_NUT_STORE = null;
    public static final Boolean DEFAULT_IS_ORIGIN_SOURCE = null;
    public static final Boolean DEFAULT_IS_TRY_USE_LAN_TRANS = null;
    public static final Boolean DEFAULT_IS_UNKNOWN_DOUBAO_CONTENT = null;
    public static final Boolean DEFAULT_IS_VOICE_CALL = null;
    public static final String DEFAULT_JOIN_TOKEN = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_LAN_RECEIVER_DEVICE_ID = "";
    public static final String DEFAULT_LAN_SENDER_DEVICE_ID = "";
    public static final TransStatus DEFAULT_LAN_TRANS_STATUS = null;
    public static final String DEFAULT_LAN_TRANS_STATUS_TEXT = "";
    public static final String DEFAULT_LOCAL_UPLOAD_ID = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAMESPACE = "";
    public static final Long DEFAULT_ORIGIN_SENDER_ID = null;
    public static final String DEFAULT_ORIGIN_SENDER_ID_STR = "";
    public static final String DEFAULT_ORIGIN_SENDER_NAME = "";
    public static final Long DEFAULT_ORIGIN_SIZE = null;
    public static final String DEFAULT_ORIGIN_TOS_KEY = "";
    public static final String DEFAULT_SHARE_CHATTER_ID = "";
    public static final String DEFAULT_SHARE_CHAT_ID = "";
    public static final Integer DEFAULT_SHARE_CHAT_LAST_STATE = null;
    public static final Long DEFAULT_SIZE = null;
    public static final String DEFAULT_STICKER_ID = "";
    public static final String DEFAULT_STICKER_SET_ID = "";
    public static final Integer DEFAULT_SYSTEM_MESSAGE_VERSION = null;
    public static final SystemType DEFAULT_SYSTEM_TYPE = null;
    public static final Integer DEFAULT_SYSTEM_TYPE_VALUE = null;
    public static final String DEFAULT_TEMPLATE = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final TransIdentity DEFAULT_TRANS_IDENTITY = null;
    public static final String DEFAULT_TRIGGER_ID = "";
    public static final String DEFAULT_VC_DURATION_TIME = "";
    public static final String DEFAULT_VC_FEEDBACK_STATUS = "";
    public static final String DEFAULT_VC_FROM_FEEDBACK_STATUS = "";
    public static final String DEFAULT_VC_FROM_ID = "";
    public static final String DEFAULT_VC_MEETING_ID = "";
    public static final String DEFAULT_VC_PASSCODE = "";
    public static final String DEFAULT_VC_TO_FEEDBACK_STATUS = "";
    public static final String DEFAULT_VC_TO_ID = "";
    public static final String DEFAULT_VOICE2TEXT = "";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Abbreviation abbreviation;
    public final List<File> attachments;
    public final Integer audio2text_start_time;
    public final String cache_file_path;
    public final CalendarContent calendar_content;
    public final CardContent card_content;
    public final Map<String, ResourceCleanScene> clean_resource_key_scene;
    public final List<Reference> content_references;
    public final Map<String, ContentValue> content_values;
    public final String crypto_token;
    public final FileType deprecated;
    public final DocEntity doc_entity;
    public final DoubaoContent doubao_content;
    public final DoubaoResource doubao_resource;
    public final Integer duration;
    public final String e2ee_from_id;
    public final String e2ee_to_id;
    public final EmailSystemEvent event;
    public final Long expire_time;
    public final FileAbility file_ability;
    public final List<File> file_attachments;
    public final Long file_last_update_time_ms;
    public final Long file_last_update_user_id;
    public final String file_path;
    public final FilePermission file_permission;
    public final FilePreviewStage file_preview_stage;
    public final File.Source file_source;
    public final String file_upload_id;
    public final String file_uri;
    public final String folder_archive_key;
    public final String fs_unit;
    public final GeneralCalendarContent general_calendar_content;
    public final Integer height;
    public final Boolean hide_voice2text;
    public final HongbaoContent hongbao_content;
    public final HongbaoSystemContent hongbao_system_content;
    public final String i18n_title_key;
    public final ImageSet image;
    public final String image_upload_id;
    public final Boolean include_cleaned_resources;
    public final Boolean is_able_lan_trans;
    public final Boolean is_audio_recognize_finish;
    public final Boolean is_audio_with_text;
    public final Boolean is_encrypted;
    public final Boolean is_friend;
    public final Boolean is_group_announcement;
    public final Boolean is_in_my_nut_store;
    public final Boolean is_origin_source;
    public final Boolean is_try_use_lan_trans;
    public final Boolean is_unknown_doubao_content;
    public final Boolean is_voice_call;
    public final Map<Integer, SystemMessageItemAction> item_actions;
    public final String join_token;
    public final String key;
    public final String lan_receiver_device_id;
    public final String lan_sender_device_id;
    public final TransStatus lan_trans_status;
    public final String lan_trans_status_text;
    public final LingoOption lingo_option;
    public final LocalStatus local_status;
    public final String local_upload_id;
    public final LocationContent location_content;
    public final MediaContent media_content;
    public final MergeForwardContent merge_forward_content;
    public final String mime;
    public final String name;
    public final String namespace;
    public final Long origin_sender_id;
    public final String origin_sender_id_str;
    public final String origin_sender_name;
    public final Long origin_size;
    public final String origin_tos_key;
    public final List<PreviewUrlContent> preview_urls;
    public final List<String> resource_urls;
    public final RichText rich_text;
    public final List<String> risk_object_keys;
    public final ShareCalendarEventContent share_calendar_event_content;
    public final String share_chat_id;
    public final Integer share_chat_last_state;
    public final String share_chatter_id;
    public final ShareUserCardInfo share_user_card_info;
    public final Long size;
    public final String sticker_id;
    public final StickerInfo sticker_info;
    public final String sticker_set_id;
    public final Map<String, SystemContentValue> system_content_values;
    public final SystemExtraContent system_extra_content;
    public final Integer system_message_version;
    public final SystemType system_type;
    public final Integer system_type_value;
    public final String template;
    public final String text;
    public final List<TextUrlContent> text_url_contents;
    public final String title;
    public final TodoOperationContent todo_operation_content;
    public final TransIdentity trans_identity;
    public final TransmitInfo transmit_info;
    public final String trigger_id;
    public final Map<String, ElementRefs> typed_element_refs;
    public final Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;
    public final Map<String, String> values;
    public final String vc_duration_time;
    public final String vc_feedback_status;
    public final String vc_from_feedback_status;
    public final String vc_from_id;
    public final String vc_meeting_id;
    public final String vc_passcode;
    public final String vc_to_feedback_status;
    public final String vc_to_id;
    public final VideoChatContent videochat_content;
    public final String voice2text;
    public final VoteContent vote_content;
    public final Integer width;

    public static final class Builder extends com.squareup.wire.Message.Builder<Content, Builder> {
        public Abbreviation abbreviation;
        public List<File> attachments;
        public Integer audio2text_start_time;
        public String cache_file_path;
        public CalendarContent calendar_content;
        public CardContent card_content;
        public Map<String, ResourceCleanScene> clean_resource_key_scene;
        public List<Reference> content_references;
        public Map<String, ContentValue> content_values;
        public String crypto_token;
        public FileType deprecated;
        public DocEntity doc_entity;
        public DoubaoContent doubao_content;
        public DoubaoResource doubao_resource;
        public Integer duration;
        public String e2ee_from_id;
        public String e2ee_to_id;
        public EmailSystemEvent event;
        public Long expire_time;
        public FileAbility file_ability;
        public List<File> file_attachments;
        public Long file_last_update_time_ms;
        public Long file_last_update_user_id;
        public String file_path;
        public FilePermission file_permission;
        public FilePreviewStage file_preview_stage;
        public File.Source file_source;
        public String file_upload_id;
        public String file_uri;
        public String folder_archive_key;
        public String fs_unit;
        public GeneralCalendarContent general_calendar_content;
        public Integer height;
        public Boolean hide_voice2text;
        public HongbaoContent hongbao_content;
        public HongbaoSystemContent hongbao_system_content;
        public String i18n_title_key;
        public ImageSet image;
        public String image_upload_id;
        public Boolean include_cleaned_resources;
        public Boolean is_able_lan_trans;
        public Boolean is_audio_recognize_finish;
        public Boolean is_audio_with_text;
        public Boolean is_encrypted;
        public Boolean is_friend;
        public Boolean is_group_announcement;
        public Boolean is_in_my_nut_store;
        public Boolean is_origin_source;
        public Boolean is_try_use_lan_trans;
        public Boolean is_unknown_doubao_content;
        public Boolean is_voice_call;
        public Map<Integer, SystemMessageItemAction> item_actions;
        public String join_token;
        public String key;
        public String lan_receiver_device_id;
        public String lan_sender_device_id;
        public TransStatus lan_trans_status;
        public String lan_trans_status_text;
        public LingoOption lingo_option;
        public LocalStatus local_status;
        public String local_upload_id;
        public LocationContent location_content;
        public MediaContent media_content;
        public MergeForwardContent merge_forward_content;
        public String mime;
        public String name;
        public String namespace;
        public Long origin_sender_id;
        public String origin_sender_id_str;
        public String origin_sender_name;
        public Long origin_size;
        public String origin_tos_key;
        public List<PreviewUrlContent> preview_urls;
        public List<String> resource_urls;
        public RichText rich_text;
        public List<String> risk_object_keys;
        public ShareCalendarEventContent share_calendar_event_content;
        public String share_chat_id;
        public Integer share_chat_last_state;
        public String share_chatter_id;
        public ShareUserCardInfo share_user_card_info;
        public Long size;
        public String sticker_id;
        public StickerInfo sticker_info;
        public String sticker_set_id;
        public Map<String, SystemContentValue> system_content_values;
        public SystemExtraContent system_extra_content;
        public Integer system_message_version;
        public SystemType system_type;
        public Integer system_type_value;
        public String template;
        public String text;
        public List<TextUrlContent> text_url_contents;
        public String title;
        public TodoOperationContent todo_operation_content;
        public TransIdentity trans_identity;
        public TransmitInfo transmit_info;
        public String trigger_id;
        public Map<String, ElementRefs> typed_element_refs;
        public Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;
        public Map<String, String> values;
        public String vc_duration_time;
        public String vc_feedback_status;
        public String vc_from_feedback_status;
        public String vc_from_id;
        public String vc_meeting_id;
        public String vc_passcode;
        public String vc_to_feedback_status;
        public String vc_to_id;
        public VideoChatContent videochat_content;
        public String voice2text;
        public VoteContent vote_content;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public Content build() {
            return new Content(this.title, this.text, this.image, this.is_origin_source, this.origin_size, this.image_upload_id, this.key, this.name, this.size, this.mime, this.file_upload_id, this.template, this.values, this.duration, this.deprecated, this.system_type, this.event, this.content_values, this.system_type_value, this.i18n_title_key, this.system_content_values, this.item_actions, this.system_message_version, this.voice2text, this.hide_voice2text, this.origin_sender_id, this.local_upload_id, this.origin_tos_key, this.origin_sender_name, this.is_friend, this.origin_sender_id_str, this.is_audio_recognize_finish, this.audio2text_start_time, this.is_audio_with_text, this.url_preview_hang_point_map, this.is_group_announcement, this.doc_entity, this.file_path, this.file_source, this.namespace, this.is_in_my_nut_store, this.cache_file_path, this.lan_trans_status, this.trans_identity, this.lan_trans_status_text, this.lan_sender_device_id, this.lan_receiver_device_id, this.is_try_use_lan_trans, this.is_able_lan_trans, this.file_uri, this.is_encrypted, this.risk_object_keys, this.file_ability, this.file_permission, this.file_last_update_user_id, this.file_last_update_time_ms, this.local_status, this.file_preview_stage, this.attachments, this.file_attachments, this.share_chat_id, this.join_token, this.expire_time, this.share_chat_last_state, this.width, this.height, this.crypto_token, this.merge_forward_content, this.transmit_info, this.preview_urls, this.rich_text, this.calendar_content, this.share_calendar_event_content, this.general_calendar_content, this.text_url_contents, this.card_content, this.location_content, this.e2ee_from_id, this.e2ee_to_id, this.trigger_id, this.vc_from_id, this.vc_to_id, this.vc_duration_time, this.vc_meeting_id, this.vc_passcode, this.vc_feedback_status, this.vc_from_feedback_status, this.vc_to_feedback_status, this.is_voice_call, this.media_content, this.hongbao_content, this.hongbao_system_content, this.system_extra_content, this.videochat_content, this.resource_urls, this.fs_unit, this.sticker_info, this.sticker_id, this.sticker_set_id, this.share_user_card_info, this.share_chatter_id, this.abbreviation, this.typed_element_refs, this.todo_operation_content, this.lingo_option, this.vote_content, this.folder_archive_key, this.content_references, this.include_cleaned_resources, this.clean_resource_key_scene, this.doubao_content, this.is_unknown_doubao_content, this.doubao_resource, super.buildUnknownFields());
        }

        public Builder() {
            this.values = Internal.newMutableMap();
            this.content_values = Internal.newMutableMap();
            this.system_content_values = Internal.newMutableMap();
            this.item_actions = Internal.newMutableMap();
            this.url_preview_hang_point_map = Internal.newMutableMap();
            this.risk_object_keys = Internal.newMutableList();
            this.attachments = Internal.newMutableList();
            this.file_attachments = Internal.newMutableList();
            this.preview_urls = Internal.newMutableList();
            this.text_url_contents = Internal.newMutableList();
            this.resource_urls = Internal.newMutableList();
            this.typed_element_refs = Internal.newMutableMap();
            this.content_references = Internal.newMutableList();
            this.clean_resource_key_scene = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder abbreviation(Abbreviation r100) {
            this.abbreviation = r100;
            return this;
        }

        public Builder attachments(List<File> r100) {
            Internal.checkElementsNotNull(r100);
            this.attachments = r100;
            return this;
        }

        public Builder audio2text_start_time(Integer r100) {
            this.audio2text_start_time = r100;
            return this;
        }

        public Builder cache_file_path(String r100) {
            this.cache_file_path = r100;
            return this;
        }

        public Builder calendar_content(CalendarContent r100) {
            this.calendar_content = r100;
            return this;
        }

        public Builder card_content(CardContent r100) {
            this.card_content = r100;
            return this;
        }

        public Builder clean_resource_key_scene(Map<String, ResourceCleanScene> r100) {
            Internal.checkElementsNotNull(r100);
            this.clean_resource_key_scene = r100;
            return this;
        }

        public Builder content_references(List<Reference> r100) {
            Internal.checkElementsNotNull(r100);
            this.content_references = r100;
            return this;
        }

        public Builder content_values(Map<String, ContentValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.content_values = r100;
            return this;
        }

        public Builder crypto_token(String r100) {
            this.crypto_token = r100;
            return this;
        }

        public Builder deprecated(FileType r100) {
            this.deprecated = r100;
            return this;
        }

        public Builder doc_entity(DocEntity r100) {
            this.doc_entity = r100;
            return this;
        }

        public Builder doubao_content(DoubaoContent r100) {
            this.doubao_content = r100;
            return this;
        }

        public Builder doubao_resource(DoubaoResource r100) {
            this.doubao_resource = r100;
            return this;
        }

        public Builder duration(Integer r100) {
            this.duration = r100;
            return this;
        }

        public Builder e2ee_from_id(String r100) {
            this.e2ee_from_id = r100;
            return this;
        }

        public Builder e2ee_to_id(String r100) {
            this.e2ee_to_id = r100;
            return this;
        }

        public Builder event(EmailSystemEvent r100) {
            this.event = r100;
            return this;
        }

        public Builder expire_time(Long r100) {
            this.expire_time = r100;
            return this;
        }

        public Builder file_ability(FileAbility r100) {
            this.file_ability = r100;
            return this;
        }

        public Builder file_attachments(List<File> r100) {
            Internal.checkElementsNotNull(r100);
            this.file_attachments = r100;
            return this;
        }

        public Builder file_last_update_time_ms(Long r100) {
            this.file_last_update_time_ms = r100;
            return this;
        }

        public Builder file_last_update_user_id(Long r100) {
            this.file_last_update_user_id = r100;
            return this;
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }

        public Builder file_permission(FilePermission r100) {
            this.file_permission = r100;
            return this;
        }

        public Builder file_preview_stage(FilePreviewStage r100) {
            this.file_preview_stage = r100;
            return this;
        }

        public Builder file_source(File.Source r100) {
            this.file_source = r100;
            return this;
        }

        public Builder file_upload_id(String r100) {
            this.file_upload_id = r100;
            return this;
        }

        public Builder file_uri(String r100) {
            this.file_uri = r100;
            return this;
        }

        public Builder folder_archive_key(String r100) {
            this.folder_archive_key = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }

        public Builder general_calendar_content(GeneralCalendarContent r100) {
            this.general_calendar_content = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder hide_voice2text(Boolean r100) {
            this.hide_voice2text = r100;
            return this;
        }

        public Builder hongbao_content(HongbaoContent r100) {
            this.hongbao_content = r100;
            return this;
        }

        public Builder hongbao_system_content(HongbaoSystemContent r100) {
            this.hongbao_system_content = r100;
            return this;
        }

        public Builder i18n_title_key(String r100) {
            this.i18n_title_key = r100;
            return this;
        }

        public Builder image(ImageSet r100) {
            this.image = r100;
            return this;
        }

        public Builder image_upload_id(String r100) {
            this.image_upload_id = r100;
            return this;
        }

        public Builder include_cleaned_resources(Boolean r100) {
            this.include_cleaned_resources = r100;
            return this;
        }

        public Builder is_able_lan_trans(Boolean r100) {
            this.is_able_lan_trans = r100;
            return this;
        }

        public Builder is_audio_recognize_finish(Boolean r100) {
            this.is_audio_recognize_finish = r100;
            return this;
        }

        public Builder is_audio_with_text(Boolean r100) {
            this.is_audio_with_text = r100;
            return this;
        }

        public Builder is_encrypted(Boolean r100) {
            this.is_encrypted = r100;
            return this;
        }

        public Builder is_friend(Boolean r100) {
            this.is_friend = r100;
            return this;
        }

        public Builder is_group_announcement(Boolean r100) {
            this.is_group_announcement = r100;
            return this;
        }

        public Builder is_in_my_nut_store(Boolean r100) {
            this.is_in_my_nut_store = r100;
            return this;
        }

        public Builder is_origin_source(Boolean r100) {
            this.is_origin_source = r100;
            return this;
        }

        public Builder is_try_use_lan_trans(Boolean r100) {
            this.is_try_use_lan_trans = r100;
            return this;
        }

        public Builder is_unknown_doubao_content(Boolean r100) {
            this.is_unknown_doubao_content = r100;
            return this;
        }

        public Builder is_voice_call(Boolean r100) {
            this.is_voice_call = r100;
            return this;
        }

        public Builder item_actions(Map<Integer, SystemMessageItemAction> r100) {
            Internal.checkElementsNotNull(r100);
            this.item_actions = r100;
            return this;
        }

        public Builder join_token(String r100) {
            this.join_token = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder lan_receiver_device_id(String r100) {
            this.lan_receiver_device_id = r100;
            return this;
        }

        public Builder lan_sender_device_id(String r100) {
            this.lan_sender_device_id = r100;
            return this;
        }

        public Builder lan_trans_status(TransStatus r100) {
            this.lan_trans_status = r100;
            return this;
        }

        public Builder lan_trans_status_text(String r100) {
            this.lan_trans_status_text = r100;
            return this;
        }

        public Builder lingo_option(LingoOption r100) {
            this.lingo_option = r100;
            return this;
        }

        public Builder local_status(LocalStatus r100) {
            this.local_status = r100;
            return this;
        }

        public Builder local_upload_id(String r100) {
            this.local_upload_id = r100;
            return this;
        }

        public Builder location_content(LocationContent r100) {
            this.location_content = r100;
            return this;
        }

        public Builder media_content(MediaContent r100) {
            this.media_content = r100;
            return this;
        }

        public Builder merge_forward_content(MergeForwardContent r100) {
            this.merge_forward_content = r100;
            return this;
        }

        public Builder mime(String r100) {
            this.mime = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder namespace(String r100) {
            this.namespace = r100;
            return this;
        }

        public Builder origin_sender_id(Long r100) {
            this.origin_sender_id = r100;
            return this;
        }

        public Builder origin_sender_id_str(String r100) {
            this.origin_sender_id_str = r100;
            return this;
        }

        public Builder origin_sender_name(String r100) {
            this.origin_sender_name = r100;
            return this;
        }

        public Builder origin_size(Long r100) {
            this.origin_size = r100;
            return this;
        }

        public Builder origin_tos_key(String r100) {
            this.origin_tos_key = r100;
            return this;
        }

        public Builder preview_urls(List<PreviewUrlContent> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_urls = r100;
            return this;
        }

        public Builder resource_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.resource_urls = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder risk_object_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.risk_object_keys = r100;
            return this;
        }

        public Builder share_calendar_event_content(ShareCalendarEventContent r100) {
            this.share_calendar_event_content = r100;
            return this;
        }

        public Builder share_chat_id(String r100) {
            this.share_chat_id = r100;
            return this;
        }

        public Builder share_chat_last_state(Integer r100) {
            this.share_chat_last_state = r100;
            return this;
        }

        public Builder share_chatter_id(String r100) {
            this.share_chatter_id = r100;
            return this;
        }

        public Builder share_user_card_info(ShareUserCardInfo r100) {
            this.share_user_card_info = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.size = r100;
            return this;
        }

        public Builder sticker_id(String r100) {
            this.sticker_id = r100;
            return this;
        }

        public Builder sticker_info(StickerInfo r100) {
            this.sticker_info = r100;
            return this;
        }

        public Builder sticker_set_id(String r100) {
            this.sticker_set_id = r100;
            return this;
        }

        public Builder system_content_values(Map<String, SystemContentValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.system_content_values = r100;
            return this;
        }

        public Builder system_extra_content(SystemExtraContent r100) {
            this.system_extra_content = r100;
            return this;
        }

        public Builder system_message_version(Integer r100) {
            this.system_message_version = r100;
            return this;
        }

        public Builder system_type(SystemType r100) {
            this.system_type = r100;
            return this;
        }

        public Builder system_type_value(Integer r100) {
            this.system_type_value = r100;
            return this;
        }

        public Builder template(String r100) {
            this.template = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder text_url_contents(List<TextUrlContent> r100) {
            Internal.checkElementsNotNull(r100);
            this.text_url_contents = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder todo_operation_content(TodoOperationContent r100) {
            this.todo_operation_content = r100;
            return this;
        }

        public Builder trans_identity(TransIdentity r100) {
            this.trans_identity = r100;
            return this;
        }

        public Builder transmit_info(TransmitInfo r100) {
            this.transmit_info = r100;
            return this;
        }

        public Builder trigger_id(String r100) {
            this.trigger_id = r100;
            return this;
        }

        public Builder typed_element_refs(Map<String, ElementRefs> r100) {
            Internal.checkElementsNotNull(r100);
            this.typed_element_refs = r100;
            return this;
        }

        public Builder url_preview_hang_point_map(Map<String, UrlPreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_hang_point_map = r100;
            return this;
        }

        public Builder values(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.values = r100;
            return this;
        }

        public Builder vc_duration_time(String r100) {
            this.vc_duration_time = r100;
            return this;
        }

        public Builder vc_feedback_status(String r100) {
            this.vc_feedback_status = r100;
            return this;
        }

        public Builder vc_from_feedback_status(String r100) {
            this.vc_from_feedback_status = r100;
            return this;
        }

        public Builder vc_from_id(String r100) {
            this.vc_from_id = r100;
            return this;
        }

        public Builder vc_meeting_id(String r100) {
            this.vc_meeting_id = r100;
            return this;
        }

        public Builder vc_passcode(String r100) {
            this.vc_passcode = r100;
            return this;
        }

        public Builder vc_to_feedback_status(String r100) {
            this.vc_to_feedback_status = r100;
            return this;
        }

        public Builder vc_to_id(String r100) {
            this.vc_to_id = r100;
            return this;
        }

        public Builder videochat_content(VideoChatContent r100) {
            this.videochat_content = r100;
            return this;
        }

        public Builder voice2text(String r100) {
            this.voice2text = r100;
            return this;
        }

        public Builder vote_content(VoteContent r100) {
            this.vote_content = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ContentValue extends com.squareup.wire.Message<ContentValue, Builder> {
        public static final ProtoAdapter<ContentValue> ADAPTER = null;
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_LINK = "";
        public static final String DEFAULT_TEXT = "";
        public static final ContentValueType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final SystemMessageAction action;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253465id;
        public final List<String> ids;
        public final List<Item> items;
        public final String link;
        public final String text;
        public final ContentValueType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<ContentValue, Builder> {
            public SystemMessageAction action;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253466id;
            public List<String> ids;
            public List<Item> items;
            public String link;
            public String text;
            public ContentValueType type;

            @Override // com.squareup.wire.Message.Builder
            public ContentValue build() {
                return new ContentValue(this.f253466id, this.type, this.ids, this.text, this.link, this.action, this.items, super.buildUnknownFields());
            }

            public Builder() {
                this.ids = Internal.newMutableList();
                this.items = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action(SystemMessageAction r100) {
                this.action = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253466id = r100;
                return this;
            }

            public Builder ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.ids = r100;
                return this;
            }

            public Builder items(List<Item> r100) {
                Internal.checkElementsNotNull(r100);
                this.items = r100;
                return this;
            }

            public Builder link(String r100) {
                this.link = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder type(ContentValueType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class Item extends com.squareup.wire.Message<Item, Builder> {
            public static final ProtoAdapter<Item> ADAPTER = null;
            public static final Integer DEFAULT_ACTION_ID = null;
            public static final String DEFAULT_ID = "";
            public static final Boolean DEFAULT_IS_CLICKABLE = null;
            public static final String DEFAULT_LINK = "";
            public static final String DEFAULT_TEXT = "";
            public static final ContentValueType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            public final Integer action_id;
            public final Map<String, String> i18n_text;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public final String f253467id;
            public final Boolean is_clickable;
            public final String link;
            public final String text;
            public final ContentValueType type;

            public static final class Builder extends com.squareup.wire.Message.Builder<Item, Builder> {
                public Integer action_id;
                public Map<String, String> i18n_text;

                /* JADX INFO: renamed from: id, reason: collision with root package name */
                public String f253468id;
                public Boolean is_clickable;
                public String link;
                public String text;
                public ContentValueType type;

                @Override // com.squareup.wire.Message.Builder
                public Item build() {
                    return new Item(this.f253468id, this.text, this.i18n_text, this.type, this.link, this.action_id, this.is_clickable, super.buildUnknownFields());
                }

                public Builder() {
                    this.i18n_text = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder action_id(Integer r100) {
                    this.action_id = r100;
                    return this;
                }

                public Builder i18n_text(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.i18n_text = r100;
                    return this;
                }

                public Builder id(String r100) {
                    this.f253468id = r100;
                    return this;
                }

                public Builder is_clickable(Boolean r100) {
                    this.is_clickable = r100;
                    return this;
                }

                public Builder link(String r100) {
                    this.link = r100;
                    return this;
                }

                public Builder text(String r100) {
                    this.text = r100;
                    return this;
                }

                public Builder type(ContentValueType r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
                private final ProtoAdapter<Map<String, String>> i18n_text;

                public ProtoAdapter_Item() {
                    super(FieldEncoding.LENGTH_DELIMITED, Item.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.i18n_text = ProtoAdapter.newMapAdapter(r100, r100);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Item decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.f253468id = "";
                    r101.text = "";
                    r101.type = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
                    r101.link = "";
                    r101.action_id = 0;
                    r101.is_clickable = Boolean.FALSE;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L17;
                    switch(r103) {
                        case 1: goto L16;
                        case 2: goto L15;
                        case 3: goto L14;
                        case 4: goto L19;
                        case 5: goto L9;
                        case 6: goto L8;
                        case 7: goto L7;
                        default: goto L6;
                    };
                L19:
                    r101.type = ContentValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                L12:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L7:
                    r101.is_clickable = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L8:
                    r101.action_id = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L9:
                    r101.link = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L14:
                    r101.i18n_text.putAll(this.i18n_text.decode(r100));
                    goto L3
                L15:
                    r101.text = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L16:
                    r101.f253468id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L17:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(Item r100) {
                    String r101 = r100.f253467id;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.text;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = (r103 + r105) + this.i18n_text.encodedSizeWithTag(3, r100.i18n_text);
                    ContentValueType r107 = r100.type;
                    if (r107 == null) goto L13;
                    int r108 = ContentValueType.ADAPTER.encodedSizeWithTag(4, r107);
                L14:
                    int r109 = r106 + r108;
                    String r110 = r100.link;
                    if (r110 == null) goto L17;
                    int r111 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
                L18:
                    int r112 = r109 + r111;
                    Integer r113 = r100.action_id;
                    if (r113 == null) goto L21;
                    int r114 = ProtoAdapter.INT32.encodedSizeWithTag(6, r113);
                L22:
                    int r115 = r112 + r114;
                    Boolean r116 = r100.is_clickable;
                    if (r116 == null) goto L26;
                    r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
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
                public /* bridge */ /* synthetic */ Item decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Item r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Item r101) throws IOException {
                    String r102 = r101.f253467id;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.text;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    this.i18n_text.encodeWithTag(r100, 3, r101.i18n_text);
                    ContentValueType r104 = r101.type;
                    if (r104 == null) goto L11;
                    ContentValueType.ADAPTER.encodeWithTag(r100, 4, r104);
                L11:
                    String r105 = r101.link;
                    if (r105 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
                L14:
                    Integer r106 = r101.action_id;
                    if (r106 == null) goto L17;
                    ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
                L17:
                    Boolean r107 = r101.is_clickable;
                    if (r107 == null) goto L20;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
                L20:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Item r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Item();
                DEFAULT_TYPE = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
                DEFAULT_ACTION_ID = 0;
                DEFAULT_IS_CLICKABLE = Boolean.FALSE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.f253468id = this.f253467id;
                r100.text = this.text;
                r100.i18n_text = Internal.copyOf("i18n_text", this.i18n_text);
                r100.type = this.type;
                r100.link = this.link;
                r100.action_id = this.action_id;
                r100.is_clickable = this.is_clickable;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Item.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Item(String r110, String r111, Map<String, String> r112, ContentValueType r113, String r114, Integer r115, Boolean r116) {
                this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
            }

            public Item(String r100, String r101, Map<String, String> r102, ContentValueType r103, String r104, Integer r105, Boolean r106, ByteString r107) {
                super(ADAPTER, r107);
                this.f253467id = r100;
                this.text = r101;
                this.i18n_text = Internal.immutableCopyOf("i18n_text", r102);
                this.type = r103;
                this.link = r104;
                this.action_id = r105;
                this.is_clickable = r106;
            }
        }

        public static final class ProtoAdapter_ContentValue extends ProtoAdapter<ContentValue> {
            public ProtoAdapter_ContentValue() {
                super(FieldEncoding.LENGTH_DELIMITED, ContentValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ContentValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253466id = "";
                r101.type = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
                r101.text = "";
                r101.link = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L17;
                switch(r103) {
                    case 1: goto L16;
                    case 2: goto L19;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r101.type = ContentValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.items.add(Item.ADAPTER.decode(r100));
                goto L3
            L8:
                r101.action = SystemMessageAction.ADAPTER.decode(r100);
                goto L3
            L9:
                r101.link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L16:
                r101.f253466id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L17:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ContentValue r100) {
                String r101 = r100.f253465id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ContentValueType r104 = r100.type;
                if (r104 == null) goto L9;
                int r105 = ContentValueType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ProtoAdapter<String> r107 = ProtoAdapter.STRING;
                int r108 = r106 + r107.asRepeated().encodedSizeWithTag(3, r100.ids);
                String r109 = r100.text;
                if (r109 == null) goto L13;
                int r110 = r107.encodedSizeWithTag(4, r109);
            L14:
                int r111 = r108 + r110;
                String r112 = r100.link;
                if (r112 == null) goto L17;
                int r113 = r107.encodedSizeWithTag(5, r112);
            L18:
                int r114 = r111 + r113;
                SystemMessageAction r115 = r100.action;
                if (r115 == null) goto L22;
                r102 = SystemMessageAction.ADAPTER.encodedSizeWithTag(6, r115);
            L22:
                return ((r114 + r102) + Item.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.items)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ContentValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ContentValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ContentValue r101) throws IOException {
                String r102 = r101.f253465id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ContentValueType r103 = r101.type;
                if (r103 == null) goto L8;
                ContentValueType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                r104.asRepeated().encodeWithTag(r100, 3, r101.ids);
                String r105 = r101.text;
                if (r105 == null) goto L11;
                r104.encodeWithTag(r100, 4, r105);
            L11:
                String r106 = r101.link;
                if (r106 == null) goto L14;
                r104.encodeWithTag(r100, 5, r106);
            L14:
                SystemMessageAction r107 = r101.action;
                if (r107 == null) goto L17;
                SystemMessageAction.ADAPTER.encodeWithTag(r100, 6, r107);
            L17:
                Item.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.items);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContentValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContentValue();
            DEFAULT_TYPE = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253466id = this.f253465id;
            r100.type = this.type;
            r100.ids = Internal.copyOf("ids", this.ids);
            r100.text = this.text;
            r100.link = this.link;
            r100.action = this.action;
            r100.items = Internal.copyOf("items", this.items);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ContentValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ContentValue(String r110, ContentValueType r111, List<String> r112, String r113, String r114, SystemMessageAction r115, List<Item> r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public ContentValue(String r100, ContentValueType r101, List<String> r102, String r103, String r104, SystemMessageAction r105, List<Item> r106, ByteString r107) {
            super(ADAPTER, r107);
            this.f253465id = r100;
            this.type = r101;
            this.ids = Internal.immutableCopyOf("ids", r102);
            this.text = r103;
            this.link = r104;
            this.action = r105;
            this.items = Internal.immutableCopyOf("items", r106);
        }
    }

    public static final enum ContentValueType extends Enum<ContentValueType> implements WireEnum {
        private static final /* synthetic */ ContentValueType[] $VALUES = null;
        public static final ContentValueType ACTION = null;
        public static final ProtoAdapter<ContentValueType> ADAPTER = null;
        public static final ContentValueType BOT = null;
        public static final ContentValueType CHAT = null;
        public static final ContentValueType CHATTER = null;
        public static final ContentValueType CONTENT_VALUE_TYPE_UNKNOWN = null;
        public static final ContentValueType DEPARTMENT = null;
        public static final ContentValueType TEXT = null;
        public static final ContentValueType URL = null;
        public static final ContentValueType USER = null;
        private final int value;

        static {
            ContentValueType r100 = new ContentValueType("CONTENT_VALUE_TYPE_UNKNOWN", 0, 0);
            CONTENT_VALUE_TYPE_UNKNOWN = r100;
            ContentValueType r101 = new ContentValueType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            ContentValueType r102 = new ContentValueType("BOT", 2, 2);
            BOT = r102;
            ContentValueType r103 = new ContentValueType(CardAdapter.TEXT, 3, 3);
            TEXT = r103;
            ContentValueType r104 = new ContentValueType("CHAT", 4, 4);
            CHAT = r104;
            ContentValueType r105 = new ContentValueType("CHATTER", 5, 5);
            CHATTER = r105;
            ContentValueType r110 = new ContentValueType("URL", 6, 6);
            URL = r110;
            ContentValueType r111 = new ContentValueType("ACTION", 7, 7);
            ACTION = r111;
            ContentValueType r112 = new ContentValueType("DEPARTMENT", 8, 8);
            DEPARTMENT = r112;
            $VALUES = new ContentValueType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContentValueType.class);
        }

        public static ContentValueType[] values() {
            return (ContentValueType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ContentValueType fromValue(int r100) {
            switch(r100) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DEPARTMENT;
        L8:
            return ACTION;
        L10:
            return URL;
        L12:
            return CHATTER;
        L14:
            return CHAT;
        L16:
            return TEXT;
        L18:
            return BOT;
        L20:
            return USER;
        L22:
            return CONTENT_VALUE_TYPE_UNKNOWN;
        }

        public static ContentValueType valueOf(String r100) {
            return (ContentValueType) a.a(ContentValueType.class, r100);
        }

        private ContentValueType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FileAbility extends Enum<FileAbility> implements WireEnum {
        private static final /* synthetic */ FileAbility[] $VALUES = null;
        public static final ProtoAdapter<FileAbility> ADAPTER = null;
        public static final FileAbility NOT_SUPPORT_PREVIEW = null;
        public static final FileAbility SUPPORT_EDIT = null;
        public static final FileAbility SUPPORT_PREVIEW = null;
        public static final FileAbility UNKNOWN_SUPPORT_STATE = null;
        private final int value;

        static {
            FileAbility r100 = new FileAbility("UNKNOWN_SUPPORT_STATE", 0, 0);
            UNKNOWN_SUPPORT_STATE = r100;
            FileAbility r101 = new FileAbility("SUPPORT_EDIT", 1, 1);
            SUPPORT_EDIT = r101;
            FileAbility r102 = new FileAbility("SUPPORT_PREVIEW", 2, 2);
            SUPPORT_PREVIEW = r102;
            FileAbility r103 = new FileAbility("NOT_SUPPORT_PREVIEW", 3, 3);
            NOT_SUPPORT_PREVIEW = r103;
            $VALUES = new FileAbility[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileAbility.class);
        }

        public static FileAbility[] values() {
            return (FileAbility[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FileAbility fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return NOT_SUPPORT_PREVIEW;
        L14:
            return SUPPORT_PREVIEW;
        L16:
            return SUPPORT_EDIT;
        L18:
            return UNKNOWN_SUPPORT_STATE;
        }

        public static FileAbility valueOf(String r100) {
            return (FileAbility) a.a(FileAbility.class, r100);
        }

        private FileAbility(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FilePermission extends Enum<FilePermission> implements WireEnum {
        private static final /* synthetic */ FilePermission[] $VALUES = null;
        public static final ProtoAdapter<FilePermission> ADAPTER = null;
        public static final FilePermission CAN_EDIT = null;
        public static final FilePermission CAN_PREVIEW = null;
        public static final FilePermission UNKNOWN_CAN_STATE = null;
        private final int value;

        static {
            FilePermission r100 = new FilePermission("UNKNOWN_CAN_STATE", 0, 0);
            UNKNOWN_CAN_STATE = r100;
            FilePermission r101 = new FilePermission("CAN_EDIT", 1, 1);
            CAN_EDIT = r101;
            FilePermission r102 = new FilePermission("CAN_PREVIEW", 2, 2);
            CAN_PREVIEW = r102;
            $VALUES = new FilePermission[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(FilePermission.class);
        }

        public static FilePermission[] values() {
            return (FilePermission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FilePermission fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CAN_PREVIEW;
        L12:
            return CAN_EDIT;
        L14:
            return UNKNOWN_CAN_STATE;
        }

        public static FilePermission valueOf(String r100) {
            return (FilePermission) a.a(FilePermission.class, r100);
        }

        private FilePermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class LocalStatus extends com.squareup.wire.Message<LocalStatus, Builder> {
        public static final ProtoAdapter<LocalStatus> ADAPTER = null;
        public static final Long DEFAULT_FILE_LAST_UPDATE_TIME_MS = null;
        public static final Long DEFAULT_FILE_LAST_UPDATE_USER_ID = null;
        private static final long serialVersionUID = 0;
        public final Long file_last_update_time_ms;
        public final Long file_last_update_user_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<LocalStatus, Builder> {
            public Long file_last_update_time_ms;
            public Long file_last_update_user_id;

            @Override // com.squareup.wire.Message.Builder
            public LocalStatus build() {
                return new LocalStatus(this.file_last_update_user_id, this.file_last_update_time_ms, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder file_last_update_time_ms(Long r100) {
                this.file_last_update_time_ms = r100;
                return this;
            }

            public Builder file_last_update_user_id(Long r100) {
                this.file_last_update_user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LocalStatus extends ProtoAdapter<LocalStatus> {
            public ProtoAdapter_LocalStatus() {
                super(FieldEncoding.LENGTH_DELIMITED, LocalStatus.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LocalStatus decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.file_last_update_user_id = 0L;
                r101.file_last_update_time_ms = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.file_last_update_user_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.file_last_update_time_ms = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(LocalStatus r100) {
                Long r101 = r100.file_last_update_user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.file_last_update_time_ms;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LocalStatus decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LocalStatus r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LocalStatus r101) throws IOException {
                Long r102 = r101.file_last_update_user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.file_last_update_time_ms;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocalStatus r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LocalStatus();
            DEFAULT_FILE_LAST_UPDATE_USER_ID = 0L;
            DEFAULT_FILE_LAST_UPDATE_TIME_MS = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.file_last_update_user_id = this.file_last_update_user_id;
            r100.file_last_update_time_ms = this.file_last_update_time_ms;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LocalStatus.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LocalStatus(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public LocalStatus(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.file_last_update_user_id = r100;
            this.file_last_update_time_ms = r101;
        }
    }

    public static final class NewTopicSystemMessageExtraContent extends com.squareup.wire.Message<NewTopicSystemMessageExtraContent, Builder> {
        public static final ProtoAdapter<NewTopicSystemMessageExtraContent> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> tool_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<NewTopicSystemMessageExtraContent, Builder> {
            public List<String> tool_ids;

            @Override // com.squareup.wire.Message.Builder
            public NewTopicSystemMessageExtraContent build() {
                return new NewTopicSystemMessageExtraContent(this.tool_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.tool_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder tool_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.tool_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_NewTopicSystemMessageExtraContent extends ProtoAdapter<NewTopicSystemMessageExtraContent> {
            public ProtoAdapter_NewTopicSystemMessageExtraContent() {
                super(FieldEncoding.LENGTH_DELIMITED, NewTopicSystemMessageExtraContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NewTopicSystemMessageExtraContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.tool_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(NewTopicSystemMessageExtraContent r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.tool_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ NewTopicSystemMessageExtraContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(NewTopicSystemMessageExtraContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, NewTopicSystemMessageExtraContent r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.tool_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NewTopicSystemMessageExtraContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NewTopicSystemMessageExtraContent();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tool_ids = Internal.copyOf("tool_ids", this.tool_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return NewTopicSystemMessageExtraContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public NewTopicSystemMessageExtraContent(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public NewTopicSystemMessageExtraContent(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.tool_ids = Internal.immutableCopyOf("tool_ids", r100);
        }
    }

    public static final class ProtoAdapter_Content extends ProtoAdapter<Content> {
        private final ProtoAdapter<Map<String, ResourceCleanScene>> clean_resource_key_scene;
        private final ProtoAdapter<Map<String, ContentValue>> content_values;
        private final ProtoAdapter<Map<Integer, SystemMessageItemAction>> item_actions;
        private final ProtoAdapter<Map<String, SystemContentValue>> system_content_values;
        private final ProtoAdapter<Map<String, ElementRefs>> typed_element_refs;
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> url_preview_hang_point_map;
        private final ProtoAdapter<Map<String, String>> values;

        public ProtoAdapter_Content() {
            super(FieldEncoding.LENGTH_DELIMITED, Content.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.values = ProtoAdapter.newMapAdapter(r100, r100);
            this.content_values = ProtoAdapter.newMapAdapter(r100, ContentValue.ADAPTER);
            this.system_content_values = ProtoAdapter.newMapAdapter(r100, SystemContentValue.ADAPTER);
            this.item_actions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, SystemMessageItemAction.ADAPTER);
            this.url_preview_hang_point_map = ProtoAdapter.newMapAdapter(r100, UrlPreviewHangPoint.ADAPTER);
            this.typed_element_refs = ProtoAdapter.newMapAdapter(r100, ElementRefs.ADAPTER);
            this.clean_resource_key_scene = ProtoAdapter.newMapAdapter(r100, ResourceCleanScene.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Content decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title = "";
            r101.text = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_origin_source = r102;
            r101.origin_size = 0L;
            r101.image_upload_id = "";
            r101.key = "";
            r101.name = "";
            r101.size = 0L;
            r101.mime = "";
            r101.file_upload_id = "";
            r101.template = "";
            r101.duration = 0;
            r101.deprecated = FileType.DEFAULT;
            r101.system_type = SystemType.UNKNOWN;
            r101.system_type_value = 0;
            r101.i18n_title_key = "";
            r101.system_message_version = 0;
            r101.voice2text = "";
            r101.hide_voice2text = Boolean.TRUE;
            r101.origin_sender_id = 0L;
            r101.local_upload_id = "";
            r101.origin_tos_key = "";
            r101.origin_sender_name = "";
            r101.is_friend = r102;
            r101.origin_sender_id_str = "";
            r101.is_audio_recognize_finish = r102;
            r101.audio2text_start_time = 0;
            r101.is_audio_with_text = r102;
            r101.is_group_announcement = r102;
            r101.file_path = "";
            r101.file_source = File.Source.LARK_SERVER;
            r101.namespace = "";
            r101.is_in_my_nut_store = r102;
            r101.cache_file_path = "";
            r101.lan_trans_status = TransStatus.PENDING;
            r101.trans_identity = TransIdentity.OTHER;
            r101.lan_trans_status_text = "";
            r101.lan_sender_device_id = "";
            r101.lan_receiver_device_id = "";
            r101.is_try_use_lan_trans = r102;
            r101.is_able_lan_trans = r102;
            r101.file_uri = "";
            r101.is_encrypted = r102;
            r101.file_ability = FileAbility.UNKNOWN_SUPPORT_STATE;
            r101.file_permission = FilePermission.UNKNOWN_CAN_STATE;
            r101.file_last_update_user_id = 0L;
            r101.file_last_update_time_ms = 0L;
            r101.file_preview_stage = FilePreviewStage.UnknownStage;
            r101.share_chat_id = "";
            r101.join_token = "";
            r101.expire_time = 0L;
            r101.share_chat_last_state = 0;
            r101.width = 0;
            r101.height = 0;
            r101.crypto_token = "";
            r101.e2ee_from_id = "";
            r101.e2ee_to_id = "";
            r101.trigger_id = "";
            r101.vc_from_id = "";
            r101.vc_to_id = "";
            r101.vc_duration_time = "";
            r101.vc_meeting_id = "";
            r101.vc_passcode = "";
            r101.vc_feedback_status = "";
            r101.vc_from_feedback_status = "";
            r101.vc_to_feedback_status = "";
            r101.is_voice_call = r102;
            r101.fs_unit = "";
            r101.sticker_id = "";
            r101.sticker_set_id = "";
            r101.share_chatter_id = "";
            r101.folder_archive_key = "";
            r101.include_cleaned_resources = r102;
            r101.is_unknown_doubao_content = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L173;
            if (r104 != 1) goto L8;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.image = ImageSet.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L16;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            if (r104 != 6) goto L18;
            r101.size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            if (r104 == 7) goto L166;
            if (r104 != 400) goto L22;
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            if (r104 != 401) goto L24;
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L24:
            if (r104 != 600) goto L26;
            r101.merge_forward_content = MergeForwardContent.ADAPTER.decode(r100);
            goto L3
        L26:
            if (r104 != 601) goto L27;
            r101.transmit_info = TransmitInfo.ADAPTER.decode(r100);
            goto L3
        L27:
            switch(r104) {
                case 7: goto L166;
                case 8: goto L161;
                case 9: goto L160;
                case 10: goto L159;
                case 11: goto L179;
                case 12: goto L185;
                case 13: goto L150;
                case 14: goto L149;
                case 15: goto L148;
                case 16: goto L147;
                case 17: goto L146;
                case 18: goto L145;
                case 19: goto L144;
                case 20: goto L143;
                case 21: goto L142;
                case 22: goto L141;
                case 23: goto L140;
                case 24: goto L139;
                case 25: goto L138;
                case 26: goto L137;
                case 27: goto L136;
                case 28: goto L135;
                case 29: goto L134;
                case 30: goto L133;
                case 31: goto L132;
                case 32: goto L131;
                case 33: goto L130;
                case 34: goto L129;
                case 35: goto L128;
                case 200: goto L127;
                case 500: goto L126;
                case 700: goto L125;
                case 800: goto L124;
                case 1000: goto L123;
                case 1010: goto L122;
                case 1401: goto L121;
                case 1500: goto L120;
                case 1501: goto L119;
                case 1502: goto L118;
                case 1503: goto L117;
                case 1504: goto L116;
                case 1600: goto L115;
                case 1601: goto L114;
                case 2000: goto L113;
                case 2001: goto L112;
                case 2010: goto L111;
                case 2020: goto L110;
                case 2021: goto L109;
                case 2022: goto L108;
                case 2023: goto L107;
                case 2024: goto L106;
                case 2025: goto L105;
                case 2026: goto L104;
                case 2027: goto L103;
                case 2028: goto L102;
                case 10000: goto L101;
                default: goto L28;
            };
        L179:
            r101.deprecated = FileType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L157
        L157:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L185:
            r101.system_type = SystemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L153
        L153:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L101:
            r101.text_url_contents.add(TextUrlContent.ADAPTER.decode(r100));
            goto L3
        L102:
            r101.doubao_resource = DoubaoResource.ADAPTER.decode(r100);
            goto L3
        L103:
            r101.file_attachments.add(File.ADAPTER.decode(r100));
            goto L3
        L104:
            r101.is_unknown_doubao_content = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L105:
            r101.doubao_content = DoubaoContent.ADAPTER.decode(r100);
            goto L3
        L106:
            r101.clean_resource_key_scene.putAll(this.clean_resource_key_scene.decode(r100));
            goto L3
        L107:
            r101.include_cleaned_resources = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L108:
            r101.content_references.add(Reference.ADAPTER.decode(r100));
            goto L3
        L109:
            r101.folder_archive_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L110:
            r101.vote_content = VoteContent.ADAPTER.decode(r100);
            goto L3
        L111:
            r101.todo_operation_content = TodoOperationContent.ADAPTER.decode(r100);
            goto L3
        L112:
            r101.typed_element_refs.putAll(this.typed_element_refs.decode(r100));
            goto L3
        L113:
            r101.abbreviation = Abbreviation.ADAPTER.decode(r100);
            goto L3
        L114:
            r101.share_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L115:
            r101.share_user_card_info = ShareUserCardInfo.ADAPTER.decode(r100);
            goto L3
        L116:
            r101.sticker_set_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L117:
            r101.sticker_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L118:
            r101.sticker_info = StickerInfo.ADAPTER.decode(r100);
            goto L3
        L119:
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L120:
            r101.resource_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L121:
            r101.videochat_content = VideoChatContent.ADAPTER.decode(r100);
            goto L3
        L122:
            r101.location_content = LocationContent.ADAPTER.decode(r100);
            goto L3
        L123:
            r101.card_content = CardContent.ADAPTER.decode(r100);
            goto L3
        L124:
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L125:
            r101.preview_urls.add(PreviewUrlContent.ADAPTER.decode(r100));
            goto L3
        L126:
            r101.crypto_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L127:
            r101.attachments.add(File.ADAPTER.decode(r100));
            goto L3
        L128:
            r101.file_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L129:
            r101.image_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L130:
            r101.lingo_option = LingoOption.ADAPTER.decode(r100);
            goto L3
        L131:
            r101.origin_size = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L132:
            r101.is_origin_source = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L133:
            r101.item_actions.putAll(this.item_actions.decode(r100));
            goto L3
        L134:
            r101.url_preview_hang_point_map.putAll(this.url_preview_hang_point_map.decode(r100));
            goto L3
        L135:
            r101.is_audio_with_text = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L136:
            r101.audio2text_start_time = ProtoAdapter.INT32.decode(r100);
            goto L3
        L137:
            r101.is_audio_recognize_finish = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L138:
            r101.origin_sender_id_str = ProtoAdapter.STRING.decode(r100);
            goto L3
        L139:
            r101.is_friend = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L140:
            r101.origin_sender_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L141:
            r101.origin_tos_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L142:
            r101.local_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L143:
            r101.origin_sender_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L144:
            r101.hide_voice2text = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L145:
            r101.voice2text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L146:
            r101.system_content_values.putAll(this.system_content_values.decode(r100));
            goto L3
        L147:
            r101.i18n_title_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L148:
            r101.system_type_value = ProtoAdapter.INT32.decode(r100);
            goto L3
        L149:
            r101.content_values.putAll(this.content_values.decode(r100));
            goto L3
        L150:
            r101.event = EmailSystemEvent.ADAPTER.decode(r100);
            goto L3
        L159:
            r101.duration = ProtoAdapter.INT32.decode(r100);
            goto L3
        L160:
            r101.values.putAll(this.values.decode(r100));
            goto L3
        L161:
            r101.template = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            switch(r104) {
                case 50: goto L100;
                case 51: goto L99;
                case 52: goto L98;
                default: goto L29;
            };
        L98:
            r101.system_message_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L99:
            r101.doc_entity = DocEntity.ADAPTER.decode(r100);
            goto L3
        L100:
            r101.is_group_announcement = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L29:
            switch(r104) {
                case 100: goto L97;
                case 101: goto L183;
                case 102: goto L92;
                case 103: goto L91;
                case 104: goto L90;
                case 105: goto L181;
                case 106: goto L187;
                case 107: goto L81;
                case 108: goto L80;
                case 109: goto L79;
                case 110: goto L78;
                case 111: goto L77;
                case 112: goto L76;
                case 113: goto L75;
                case 114: goto L74;
                case 115: goto L189;
                case 116: goto L177;
                case 117: goto L65;
                case 118: goto L64;
                case 119: goto L63;
                case 120: goto L175;
                default: goto L30;
            };
        L175:
            r101.file_preview_stage = FilePreviewStage.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L61
        L61:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L177:
            r101.file_permission = FilePermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L68
        L68:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L181:
            r101.lan_trans_status = TransStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L88
        L88:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L183:
            r101.file_source = File.Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L95
        L95:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L187:
            r101.trans_identity = TransIdentity.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L84
        L84:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L189:
            r101.file_ability = FileAbility.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L72
        L72:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L63:
            r101.local_status = LocalStatus.ADAPTER.decode(r100);
            goto L3
        L64:
            r101.file_last_update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L65:
            r101.file_last_update_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L74:
            r101.risk_object_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L75:
            r101.is_encrypted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L76:
            r101.file_uri = ProtoAdapter.STRING.decode(r100);
            goto L3
        L77:
            r101.is_able_lan_trans = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L78:
            r101.is_try_use_lan_trans = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L79:
            r101.lan_receiver_device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L80:
            r101.lan_sender_device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L81:
            r101.lan_trans_status_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L90:
            r101.cache_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L91:
            r101.is_in_my_nut_store = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L92:
            r101.namespace = ProtoAdapter.STRING.decode(r100);
            goto L3
        L97:
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            switch(r104) {
                case 300: goto L58;
                case 301: goto L57;
                case 302: goto L56;
                case 303: goto L55;
                default: goto L31;
            };
        L55:
            r101.share_chat_last_state = ProtoAdapter.INT32.decode(r100);
            goto L3
        L56:
            r101.expire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L57:
            r101.join_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L58:
            r101.share_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            switch(r104) {
                case 900: goto L54;
                case 901: goto L53;
                case 902: goto L52;
                default: goto L32;
            };
        L52:
            r101.general_calendar_content = GeneralCalendarContent.ADAPTER.decode(r100);
            goto L3
        L53:
            r101.share_calendar_event_content = ShareCalendarEventContent.ADAPTER.decode(r100);
            goto L3
        L54:
            r101.calendar_content = CalendarContent.ADAPTER.decode(r100);
            goto L3
        L32:
            switch(r104) {
                case 1100: goto L51;
                case 1101: goto L50;
                case 1102: goto L49;
                default: goto L33;
            };
        L49:
            r101.trigger_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L50:
            r101.e2ee_to_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L51:
            r101.e2ee_from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            switch(r104) {
                case 1200: goto L48;
                case 1201: goto L47;
                case 1202: goto L46;
                case 1203: goto L45;
                case 1204: goto L44;
                case 1205: goto L43;
                case 1206: goto L42;
                case 1207: goto L41;
                case 1208: goto L40;
                default: goto L34;
            };
        L40:
            r101.is_voice_call = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L41:
            r101.vc_to_feedback_status = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.vc_from_feedback_status = ProtoAdapter.STRING.decode(r100);
            goto L3
        L43:
            r101.vc_feedback_status = ProtoAdapter.STRING.decode(r100);
            goto L3
        L44:
            r101.vc_passcode = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.vc_meeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L46:
            r101.vc_duration_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L47:
            r101.vc_to_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L48:
            r101.vc_from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            switch(r104) {
                case 1300: goto L39;
                case 1301: goto L38;
                case 1302: goto L37;
                case 1303: goto L36;
                default: goto L35;
            };
        L36:
            r101.system_extra_content = SystemExtraContent.ADAPTER.decode(r100);
            goto L3
        L37:
            r101.hongbao_system_content = HongbaoSystemContent.ADAPTER.decode(r100);
            goto L3
        L38:
            r101.hongbao_content = HongbaoContent.ADAPTER.decode(r100);
            goto L3
        L39:
            r101.media_content = MediaContent.ADAPTER.decode(r100);
            goto L3
        L35:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
        L166:
            r101.mime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L173:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Content r100) {
            String r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.text;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ImageSet r107 = r100.image;
            if (r107 == null) goto L13;
            int r108 = ImageSet.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_origin_source;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.origin_size;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.UINT64.encodedSizeWithTag(32, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.image_upload_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(34, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.key;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(4, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.name;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(5, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.size;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(6, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mime;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(7, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.file_upload_id;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(35, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.template;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(8, r134);
        L50:
            int r136 = (r133 + r135) + this.values.encodedSizeWithTag(9, r100.values);
            Integer r137 = r100.duration;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT32.encodedSizeWithTag(10, r137);
        L54:
            int r139 = r136 + r138;
            FileType r140 = r100.deprecated;
            if (r140 == null) goto L57;
            int r141 = FileType.ADAPTER.encodedSizeWithTag(11, r140);
        L58:
            int r142 = r139 + r141;
            SystemType r143 = r100.system_type;
            if (r143 == null) goto L61;
            int r144 = SystemType.ADAPTER.encodedSizeWithTag(12, r143);
        L62:
            int r145 = r142 + r144;
            EmailSystemEvent r146 = r100.event;
            if (r146 == null) goto L65;
            int r147 = EmailSystemEvent.ADAPTER.encodedSizeWithTag(13, r146);
        L66:
            int r148 = (r145 + r147) + this.content_values.encodedSizeWithTag(14, r100.content_values);
            Integer r149 = r100.system_type_value;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.INT32.encodedSizeWithTag(15, r149);
        L70:
            int r151 = r148 + r150;
            String r152 = r100.i18n_title_key;
            if (r152 == null) goto L73;
            int r153 = ProtoAdapter.STRING.encodedSizeWithTag(16, r152);
        L74:
            int r154 = ((r151 + r153) + this.system_content_values.encodedSizeWithTag(17, r100.system_content_values)) + this.item_actions.encodedSizeWithTag(30, r100.item_actions);
            Integer r155 = r100.system_message_version;
            if (r155 == null) goto L77;
            int r156 = ProtoAdapter.INT32.encodedSizeWithTag(52, r155);
        L78:
            int r157 = r154 + r156;
            String r158 = r100.voice2text;
            if (r158 == null) goto L81;
            int r159 = ProtoAdapter.STRING.encodedSizeWithTag(18, r158);
        L82:
            int r160 = r157 + r159;
            Boolean r161 = r100.hide_voice2text;
            if (r161 == null) goto L85;
            int r162 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r161);
        L86:
            int r163 = r160 + r162;
            Long r164 = r100.origin_sender_id;
            if (r164 == null) goto L89;
            int r165 = ProtoAdapter.INT64.encodedSizeWithTag(20, r164);
        L90:
            int r166 = r163 + r165;
            String r167 = r100.local_upload_id;
            if (r167 == null) goto L93;
            int r168 = ProtoAdapter.STRING.encodedSizeWithTag(21, r167);
        L94:
            int r169 = r166 + r168;
            String r170 = r100.origin_tos_key;
            if (r170 == null) goto L97;
            int r171 = ProtoAdapter.STRING.encodedSizeWithTag(22, r170);
        L98:
            int r172 = r169 + r171;
            String r173 = r100.origin_sender_name;
            if (r173 == null) goto L101;
            int r174 = ProtoAdapter.STRING.encodedSizeWithTag(23, r173);
        L102:
            int r175 = r172 + r174;
            Boolean r176 = r100.is_friend;
            if (r176 == null) goto L105;
            int r177 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r176);
        L106:
            int r178 = r175 + r177;
            String r179 = r100.origin_sender_id_str;
            if (r179 == null) goto L109;
            int r180 = ProtoAdapter.STRING.encodedSizeWithTag(25, r179);
        L110:
            int r181 = r178 + r180;
            Boolean r182 = r100.is_audio_recognize_finish;
            if (r182 == null) goto L113;
            int r183 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r182);
        L114:
            int r184 = r181 + r183;
            Integer r185 = r100.audio2text_start_time;
            if (r185 == null) goto L117;
            int r186 = ProtoAdapter.INT32.encodedSizeWithTag(27, r185);
        L118:
            int r187 = r184 + r186;
            Boolean r188 = r100.is_audio_with_text;
            if (r188 == null) goto L121;
            int r189 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r188);
        L122:
            int r190 = (r187 + r189) + this.url_preview_hang_point_map.encodedSizeWithTag(29, r100.url_preview_hang_point_map);
            Boolean r191 = r100.is_group_announcement;
            if (r191 == null) goto L125;
            int r192 = ProtoAdapter.BOOL.encodedSizeWithTag(50, r191);
        L126:
            int r193 = r190 + r192;
            DocEntity r194 = r100.doc_entity;
            if (r194 == null) goto L129;
            int r195 = DocEntity.ADAPTER.encodedSizeWithTag(51, r194);
        L130:
            int r196 = r193 + r195;
            String r197 = r100.file_path;
            if (r197 == null) goto L133;
            int r198 = ProtoAdapter.STRING.encodedSizeWithTag(100, r197);
        L134:
            int r199 = r196 + r198;
            File.Source r200 = r100.file_source;
            if (r200 == null) goto L137;
            int r201 = File.Source.ADAPTER.encodedSizeWithTag(101, r200);
        L138:
            int r202 = r199 + r201;
            String r203 = r100.namespace;
            if (r203 == null) goto L141;
            int r204 = ProtoAdapter.STRING.encodedSizeWithTag(102, r203);
        L142:
            int r205 = r202 + r204;
            Boolean r206 = r100.is_in_my_nut_store;
            if (r206 == null) goto L145;
            int r207 = ProtoAdapter.BOOL.encodedSizeWithTag(103, r206);
        L146:
            int r208 = r205 + r207;
            String r209 = r100.cache_file_path;
            if (r209 == null) goto L149;
            int r210 = ProtoAdapter.STRING.encodedSizeWithTag(104, r209);
        L150:
            int r211 = r208 + r210;
            TransStatus r212 = r100.lan_trans_status;
            if (r212 == null) goto L153;
            int r213 = TransStatus.ADAPTER.encodedSizeWithTag(105, r212);
        L154:
            int r214 = r211 + r213;
            TransIdentity r215 = r100.trans_identity;
            if (r215 == null) goto L157;
            int r216 = TransIdentity.ADAPTER.encodedSizeWithTag(106, r215);
        L158:
            int r217 = r214 + r216;
            String r218 = r100.lan_trans_status_text;
            if (r218 == null) goto L161;
            int r219 = ProtoAdapter.STRING.encodedSizeWithTag(107, r218);
        L162:
            int r220 = r217 + r219;
            String r221 = r100.lan_sender_device_id;
            if (r221 == null) goto L165;
            int r222 = ProtoAdapter.STRING.encodedSizeWithTag(108, r221);
        L166:
            int r223 = r220 + r222;
            String r224 = r100.lan_receiver_device_id;
            if (r224 == null) goto L169;
            int r225 = ProtoAdapter.STRING.encodedSizeWithTag(109, r224);
        L170:
            int r226 = r223 + r225;
            Boolean r227 = r100.is_try_use_lan_trans;
            if (r227 == null) goto L173;
            int r228 = ProtoAdapter.BOOL.encodedSizeWithTag(110, r227);
        L174:
            int r229 = r226 + r228;
            Boolean r230 = r100.is_able_lan_trans;
            if (r230 == null) goto L177;
            int r231 = ProtoAdapter.BOOL.encodedSizeWithTag(111, r230);
        L178:
            int r232 = r229 + r231;
            String r233 = r100.file_uri;
            if (r233 == null) goto L181;
            int r234 = ProtoAdapter.STRING.encodedSizeWithTag(112, r233);
        L182:
            int r235 = r232 + r234;
            Boolean r236 = r100.is_encrypted;
            if (r236 == null) goto L185;
            int r237 = ProtoAdapter.BOOL.encodedSizeWithTag(113, r236);
        L186:
            int r238 = r235 + r237;
            ProtoAdapter<String> r239 = ProtoAdapter.STRING;
            int r240 = r238 + r239.asRepeated().encodedSizeWithTag(114, r100.risk_object_keys);
            FileAbility r241 = r100.file_ability;
            if (r241 == null) goto L189;
            int r242 = FileAbility.ADAPTER.encodedSizeWithTag(115, r241);
        L190:
            int r243 = r240 + r242;
            FilePermission r244 = r100.file_permission;
            if (r244 == null) goto L193;
            int r245 = FilePermission.ADAPTER.encodedSizeWithTag(116, r244);
        L194:
            int r246 = r243 + r245;
            Long r247 = r100.file_last_update_user_id;
            if (r247 == null) goto L197;
            int r248 = ProtoAdapter.INT64.encodedSizeWithTag(117, r247);
        L198:
            int r249 = r246 + r248;
            Long r250 = r100.file_last_update_time_ms;
            if (r250 == null) goto L201;
            int r251 = ProtoAdapter.INT64.encodedSizeWithTag(118, r250);
        L202:
            int r252 = r249 + r251;
            LocalStatus r253 = r100.local_status;
            if (r253 == null) goto L205;
            int r254 = LocalStatus.ADAPTER.encodedSizeWithTag(119, r253);
        L206:
            int r255 = r252 + r254;
            FilePreviewStage r256 = r100.file_preview_stage;
            if (r256 == null) goto L209;
            int r257 = FilePreviewStage.ADAPTER.encodedSizeWithTag(120, r256);
        L210:
            int r258 = r255 + r257;
            ProtoAdapter<File> r259 = File.ADAPTER;
            int r260 = (r258 + r259.asRepeated().encodedSizeWithTag(200, r100.attachments)) + r259.asRepeated().encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_DISABLE_RECENT_CACHE, r100.file_attachments);
            String r261 = r100.share_chat_id;
            if (r261 == null) goto L213;
            int r262 = r239.encodedSizeWithTag(300, r261);
        L214:
            int r263 = r260 + r262;
            String r264 = r100.join_token;
            if (r264 == null) goto L217;
            int r265 = r239.encodedSizeWithTag(301, r264);
        L218:
            int r266 = r263 + r265;
            Long r267 = r100.expire_time;
            if (r267 == null) goto L221;
            int r268 = ProtoAdapter.INT64.encodedSizeWithTag(302, r267);
        L222:
            int r269 = r266 + r268;
            Integer r270 = r100.share_chat_last_state;
            if (r270 == null) goto L225;
            int r271 = ProtoAdapter.INT32.encodedSizeWithTag(303, r270);
        L226:
            int r272 = r269 + r271;
            Integer r273 = r100.width;
            if (r273 == null) goto L229;
            int r274 = ProtoAdapter.INT32.encodedSizeWithTag(400, r273);
        L230:
            int r275 = r272 + r274;
            Integer r276 = r100.height;
            if (r276 == null) goto L233;
            int r277 = ProtoAdapter.INT32.encodedSizeWithTag(401, r276);
        L234:
            int r278 = r275 + r277;
            String r279 = r100.crypto_token;
            if (r279 == null) goto L237;
            int r280 = r239.encodedSizeWithTag(500, r279);
        L238:
            int r281 = r278 + r280;
            MergeForwardContent r282 = r100.merge_forward_content;
            if (r282 == null) goto L241;
            int r283 = MergeForwardContent.ADAPTER.encodedSizeWithTag(600, r282);
        L242:
            int r284 = r281 + r283;
            TransmitInfo r285 = r100.transmit_info;
            if (r285 == null) goto L245;
            int r286 = TransmitInfo.ADAPTER.encodedSizeWithTag(601, r285);
        L246:
            int r287 = (r284 + r286) + PreviewUrlContent.ADAPTER.asRepeated().encodedSizeWithTag(700, r100.preview_urls);
            RichText r288 = r100.rich_text;
            if (r288 == null) goto L249;
            int r289 = RichText.ADAPTER.encodedSizeWithTag(800, r288);
        L250:
            int r290 = r287 + r289;
            CalendarContent r291 = r100.calendar_content;
            if (r291 == null) goto L253;
            int r292 = CalendarContent.ADAPTER.encodedSizeWithTag(900, r291);
        L254:
            int r293 = r290 + r292;
            ShareCalendarEventContent r294 = r100.share_calendar_event_content;
            if (r294 == null) goto L257;
            int r295 = ShareCalendarEventContent.ADAPTER.encodedSizeWithTag(901, r294);
        L258:
            int r296 = r293 + r295;
            GeneralCalendarContent r297 = r100.general_calendar_content;
            if (r297 == null) goto L261;
            int r298 = GeneralCalendarContent.ADAPTER.encodedSizeWithTag(902, r297);
        L262:
            int r299 = (r296 + r298) + TextUrlContent.ADAPTER.asRepeated().encodedSizeWithTag(10000, r100.text_url_contents);
            CardContent r300 = r100.card_content;
            if (r300 == null) goto L265;
            int r301 = CardContent.ADAPTER.encodedSizeWithTag(1000, r300);
        L266:
            int r302 = r299 + r301;
            LocationContent r303 = r100.location_content;
            if (r303 == null) goto L269;
            int r304 = LocationContent.ADAPTER.encodedSizeWithTag(1010, r303);
        L270:
            int r305 = r302 + r304;
            String r306 = r100.e2ee_from_id;
            if (r306 == null) goto L273;
            int r307 = r239.encodedSizeWithTag(1100, r306);
        L274:
            int r308 = r305 + r307;
            String r309 = r100.e2ee_to_id;
            if (r309 == null) goto L277;
            int r310 = r239.encodedSizeWithTag(1101, r309);
        L278:
            int r311 = r308 + r310;
            String r312 = r100.trigger_id;
            if (r312 == null) goto L281;
            int r313 = r239.encodedSizeWithTag(1102, r312);
        L282:
            int r314 = r311 + r313;
            String r315 = r100.vc_from_id;
            if (r315 == null) goto L285;
            int r316 = r239.encodedSizeWithTag(1200, r315);
        L286:
            int r317 = r314 + r316;
            String r318 = r100.vc_to_id;
            if (r318 == null) goto L289;
            int r319 = r239.encodedSizeWithTag(1201, r318);
        L290:
            int r320 = r317 + r319;
            String r321 = r100.vc_duration_time;
            if (r321 == null) goto L293;
            int r322 = r239.encodedSizeWithTag(1202, r321);
        L294:
            int r323 = r320 + r322;
            String r324 = r100.vc_meeting_id;
            if (r324 == null) goto L297;
            int r325 = r239.encodedSizeWithTag(1203, r324);
        L298:
            int r326 = r323 + r325;
            String r327 = r100.vc_passcode;
            if (r327 == null) goto L301;
            int r328 = r239.encodedSizeWithTag(1204, r327);
        L302:
            int r329 = r326 + r328;
            String r330 = r100.vc_feedback_status;
            if (r330 == null) goto L305;
            int r331 = r239.encodedSizeWithTag(1205, r330);
        L306:
            int r332 = r329 + r331;
            String r333 = r100.vc_from_feedback_status;
            if (r333 == null) goto L309;
            int r334 = r239.encodedSizeWithTag(1206, r333);
        L310:
            int r335 = r332 + r334;
            String r336 = r100.vc_to_feedback_status;
            if (r336 == null) goto L313;
            int r337 = r239.encodedSizeWithTag(1207, r336);
        L314:
            int r338 = r335 + r337;
            Boolean r339 = r100.is_voice_call;
            if (r339 == null) goto L317;
            int r340 = ProtoAdapter.BOOL.encodedSizeWithTag(1208, r339);
        L318:
            int r341 = r338 + r340;
            MediaContent r342 = r100.media_content;
            if (r342 == null) goto L321;
            int r343 = MediaContent.ADAPTER.encodedSizeWithTag(1300, r342);
        L322:
            int r344 = r341 + r343;
            HongbaoContent r345 = r100.hongbao_content;
            if (r345 == null) goto L325;
            int r346 = HongbaoContent.ADAPTER.encodedSizeWithTag(1301, r345);
        L326:
            int r347 = r344 + r346;
            HongbaoSystemContent r348 = r100.hongbao_system_content;
            if (r348 == null) goto L329;
            int r349 = HongbaoSystemContent.ADAPTER.encodedSizeWithTag(1302, r348);
        L330:
            int r350 = r347 + r349;
            SystemExtraContent r351 = r100.system_extra_content;
            if (r351 == null) goto L333;
            int r352 = SystemExtraContent.ADAPTER.encodedSizeWithTag(1303, r351);
        L334:
            int r353 = r350 + r352;
            VideoChatContent r354 = r100.videochat_content;
            if (r354 == null) goto L337;
            int r355 = VideoChatContent.ADAPTER.encodedSizeWithTag(1401, r354);
        L338:
            int r356 = (r353 + r355) + r239.asRepeated().encodedSizeWithTag(1500, r100.resource_urls);
            String r357 = r100.fs_unit;
            if (r357 == null) goto L341;
            int r358 = r239.encodedSizeWithTag(1501, r357);
        L342:
            int r359 = r356 + r358;
            StickerInfo r360 = r100.sticker_info;
            if (r360 == null) goto L345;
            int r361 = StickerInfo.ADAPTER.encodedSizeWithTag(1502, r360);
        L346:
            int r362 = r359 + r361;
            String r363 = r100.sticker_id;
            if (r363 == null) goto L349;
            int r364 = r239.encodedSizeWithTag(1503, r363);
        L350:
            int r365 = r362 + r364;
            String r366 = r100.sticker_set_id;
            if (r366 == null) goto L353;
            int r367 = r239.encodedSizeWithTag(1504, r366);
        L354:
            int r368 = r365 + r367;
            ShareUserCardInfo r369 = r100.share_user_card_info;
            if (r369 == null) goto L357;
            int r370 = ShareUserCardInfo.ADAPTER.encodedSizeWithTag(1600, r369);
        L358:
            int r371 = r368 + r370;
            String r372 = r100.share_chatter_id;
            if (r372 == null) goto L361;
            int r373 = r239.encodedSizeWithTag(1601, r372);
        L362:
            int r374 = r371 + r373;
            Abbreviation r375 = r100.abbreviation;
            if (r375 == null) goto L365;
            int r376 = Abbreviation.ADAPTER.encodedSizeWithTag(2000, r375);
        L366:
            int r377 = (r374 + r376) + this.typed_element_refs.encodedSizeWithTag(2001, r100.typed_element_refs);
            TodoOperationContent r378 = r100.todo_operation_content;
            if (r378 == null) goto L369;
            int r379 = TodoOperationContent.ADAPTER.encodedSizeWithTag(2010, r378);
        L370:
            int r380 = r377 + r379;
            LingoOption r381 = r100.lingo_option;
            if (r381 == null) goto L373;
            int r382 = LingoOption.ADAPTER.encodedSizeWithTag(33, r381);
        L374:
            int r383 = r380 + r382;
            VoteContent r384 = r100.vote_content;
            if (r384 == null) goto L377;
            int r385 = VoteContent.ADAPTER.encodedSizeWithTag(2020, r384);
        L378:
            int r386 = r383 + r385;
            String r387 = r100.folder_archive_key;
            if (r387 == null) goto L381;
            int r388 = r239.encodedSizeWithTag(2021, r387);
        L382:
            int r389 = (r386 + r388) + Reference.ADAPTER.asRepeated().encodedSizeWithTag(2022, r100.content_references);
            Boolean r390 = r100.include_cleaned_resources;
            if (r390 == null) goto L385;
            int r391 = ProtoAdapter.BOOL.encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_OPTIMIZE_RANGE, r390);
        L386:
            int r392 = (r389 + r391) + this.clean_resource_key_scene.encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, r100.clean_resource_key_scene);
            DoubaoContent r393 = r100.doubao_content;
            if (r393 == null) goto L389;
            int r394 = DoubaoContent.ADAPTER.encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, r393);
        L390:
            int r395 = r392 + r394;
            Boolean r396 = r100.is_unknown_doubao_content;
            if (r396 == null) goto L393;
            int r397 = ProtoAdapter.BOOL.encodedSizeWithTag(2026, r396);
        L394:
            int r398 = r395 + r397;
            DoubaoResource r399 = r100.doubao_resource;
            if (r399 == null) goto L398;
            r102 = DoubaoResource.ADAPTER.encodedSizeWithTag(DataLoaderHelper.DATALOADER_KEY_INT_UPDATE_FILE_INTERNAL, r399);
        L398:
            return (r398 + r102) + r100.unknownFields().size();
        L393:
            r397 = 0;
            goto L394
        L389:
            r394 = 0;
            goto L390
        L385:
            r391 = 0;
            goto L386
        L381:
            r388 = 0;
            goto L382
        L377:
            r385 = 0;
            goto L378
        L373:
            r382 = 0;
            goto L374
        L369:
            r379 = 0;
            goto L370
        L365:
            r376 = 0;
            goto L366
        L361:
            r373 = 0;
            goto L362
        L357:
            r370 = 0;
            goto L358
        L353:
            r367 = 0;
            goto L354
        L349:
            r364 = 0;
            goto L350
        L345:
            r361 = 0;
            goto L346
        L341:
            r358 = 0;
            goto L342
        L337:
            r355 = 0;
            goto L338
        L333:
            r352 = 0;
            goto L334
        L329:
            r349 = 0;
            goto L330
        L325:
            r346 = 0;
            goto L326
        L321:
            r343 = 0;
            goto L322
        L317:
            r340 = 0;
            goto L318
        L313:
            r337 = 0;
            goto L314
        L309:
            r334 = 0;
            goto L310
        L305:
            r331 = 0;
            goto L306
        L301:
            r328 = 0;
            goto L302
        L297:
            r325 = 0;
            goto L298
        L293:
            r322 = 0;
            goto L294
        L289:
            r319 = 0;
            goto L290
        L285:
            r316 = 0;
            goto L286
        L281:
            r313 = 0;
            goto L282
        L277:
            r310 = 0;
            goto L278
        L273:
            r307 = 0;
            goto L274
        L269:
            r304 = 0;
            goto L270
        L265:
            r301 = 0;
            goto L266
        L261:
            r298 = 0;
            goto L262
        L257:
            r295 = 0;
            goto L258
        L253:
            r292 = 0;
            goto L254
        L249:
            r289 = 0;
            goto L250
        L245:
            r286 = 0;
            goto L246
        L241:
            r283 = 0;
            goto L242
        L237:
            r280 = 0;
            goto L238
        L233:
            r277 = 0;
            goto L234
        L229:
            r274 = 0;
            goto L230
        L225:
            r271 = 0;
            goto L226
        L221:
            r268 = 0;
            goto L222
        L217:
            r265 = 0;
            goto L218
        L213:
            r262 = 0;
            goto L214
        L209:
            r257 = 0;
            goto L210
        L205:
            r254 = 0;
            goto L206
        L201:
            r251 = 0;
            goto L202
        L197:
            r248 = 0;
            goto L198
        L193:
            r245 = 0;
            goto L194
        L189:
            r242 = 0;
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
        public /* bridge */ /* synthetic */ Content decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Content r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Content r101) throws IOException {
            String r102 = r101.title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ImageSet r104 = r101.image;
            if (r104 == null) goto L11;
            ImageSet.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_origin_source;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r105);
        L14:
            Long r106 = r101.origin_size;
            if (r106 == null) goto L17;
            ProtoAdapter.UINT64.encodeWithTag(r100, 32, r106);
        L17:
            String r107 = r101.image_upload_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 34, r107);
        L20:
            String r108 = r101.key;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r108);
        L23:
            String r109 = r101.name;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r109);
        L26:
            Long r110 = r101.size;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r110);
        L29:
            String r111 = r101.mime;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r111);
        L32:
            String r112 = r101.file_upload_id;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 35, r112);
        L35:
            String r113 = r101.template;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r113);
        L38:
            this.values.encodeWithTag(r100, 9, r101.values);
            Integer r114 = r101.duration;
            if (r114 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r114);
        L41:
            FileType r115 = r101.deprecated;
            if (r115 == null) goto L44;
            FileType.ADAPTER.encodeWithTag(r100, 11, r115);
        L44:
            SystemType r116 = r101.system_type;
            if (r116 == null) goto L47;
            SystemType.ADAPTER.encodeWithTag(r100, 12, r116);
        L47:
            EmailSystemEvent r117 = r101.event;
            if (r117 == null) goto L50;
            EmailSystemEvent.ADAPTER.encodeWithTag(r100, 13, r117);
        L50:
            this.content_values.encodeWithTag(r100, 14, r101.content_values);
            Integer r118 = r101.system_type_value;
            if (r118 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r100, 15, r118);
        L53:
            String r119 = r101.i18n_title_key;
            if (r119 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r100, 16, r119);
        L56:
            this.system_content_values.encodeWithTag(r100, 17, r101.system_content_values);
            this.item_actions.encodeWithTag(r100, 30, r101.item_actions);
            Integer r120 = r101.system_message_version;
            if (r120 == null) goto L59;
            ProtoAdapter.INT32.encodeWithTag(r100, 52, r120);
        L59:
            String r121 = r101.voice2text;
            if (r121 == null) goto L62;
            ProtoAdapter.STRING.encodeWithTag(r100, 18, r121);
        L62:
            Boolean r122 = r101.hide_voice2text;
            if (r122 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r122);
        L65:
            Long r123 = r101.origin_sender_id;
            if (r123 == null) goto L68;
            ProtoAdapter.INT64.encodeWithTag(r100, 20, r123);
        L68:
            String r124 = r101.local_upload_id;
            if (r124 == null) goto L71;
            ProtoAdapter.STRING.encodeWithTag(r100, 21, r124);
        L71:
            String r125 = r101.origin_tos_key;
            if (r125 == null) goto L74;
            ProtoAdapter.STRING.encodeWithTag(r100, 22, r125);
        L74:
            String r126 = r101.origin_sender_name;
            if (r126 == null) goto L77;
            ProtoAdapter.STRING.encodeWithTag(r100, 23, r126);
        L77:
            Boolean r127 = r101.is_friend;
            if (r127 == null) goto L80;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r127);
        L80:
            String r128 = r101.origin_sender_id_str;
            if (r128 == null) goto L83;
            ProtoAdapter.STRING.encodeWithTag(r100, 25, r128);
        L83:
            Boolean r129 = r101.is_audio_recognize_finish;
            if (r129 == null) goto L86;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r129);
        L86:
            Integer r130 = r101.audio2text_start_time;
            if (r130 == null) goto L89;
            ProtoAdapter.INT32.encodeWithTag(r100, 27, r130);
        L89:
            Boolean r131 = r101.is_audio_with_text;
            if (r131 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r100, 28, r131);
        L92:
            this.url_preview_hang_point_map.encodeWithTag(r100, 29, r101.url_preview_hang_point_map);
            Boolean r132 = r101.is_group_announcement;
            if (r132 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r100, 50, r132);
        L95:
            DocEntity r133 = r101.doc_entity;
            if (r133 == null) goto L98;
            DocEntity.ADAPTER.encodeWithTag(r100, 51, r133);
        L98:
            String r134 = r101.file_path;
            if (r134 == null) goto L101;
            ProtoAdapter.STRING.encodeWithTag(r100, 100, r134);
        L101:
            File.Source r135 = r101.file_source;
            if (r135 == null) goto L104;
            File.Source.ADAPTER.encodeWithTag(r100, 101, r135);
        L104:
            String r136 = r101.namespace;
            if (r136 == null) goto L107;
            ProtoAdapter.STRING.encodeWithTag(r100, 102, r136);
        L107:
            Boolean r137 = r101.is_in_my_nut_store;
            if (r137 == null) goto L110;
            ProtoAdapter.BOOL.encodeWithTag(r100, 103, r137);
        L110:
            String r138 = r101.cache_file_path;
            if (r138 == null) goto L113;
            ProtoAdapter.STRING.encodeWithTag(r100, 104, r138);
        L113:
            TransStatus r139 = r101.lan_trans_status;
            if (r139 == null) goto L116;
            TransStatus.ADAPTER.encodeWithTag(r100, 105, r139);
        L116:
            TransIdentity r140 = r101.trans_identity;
            if (r140 == null) goto L119;
            TransIdentity.ADAPTER.encodeWithTag(r100, 106, r140);
        L119:
            String r141 = r101.lan_trans_status_text;
            if (r141 == null) goto L122;
            ProtoAdapter.STRING.encodeWithTag(r100, 107, r141);
        L122:
            String r142 = r101.lan_sender_device_id;
            if (r142 == null) goto L125;
            ProtoAdapter.STRING.encodeWithTag(r100, 108, r142);
        L125:
            String r143 = r101.lan_receiver_device_id;
            if (r143 == null) goto L128;
            ProtoAdapter.STRING.encodeWithTag(r100, 109, r143);
        L128:
            Boolean r144 = r101.is_try_use_lan_trans;
            if (r144 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r100, 110, r144);
        L131:
            Boolean r145 = r101.is_able_lan_trans;
            if (r145 == null) goto L134;
            ProtoAdapter.BOOL.encodeWithTag(r100, 111, r145);
        L134:
            String r146 = r101.file_uri;
            if (r146 == null) goto L137;
            ProtoAdapter.STRING.encodeWithTag(r100, 112, r146);
        L137:
            Boolean r147 = r101.is_encrypted;
            if (r147 == null) goto L140;
            ProtoAdapter.BOOL.encodeWithTag(r100, 113, r147);
        L140:
            ProtoAdapter<String> r148 = ProtoAdapter.STRING;
            r148.asRepeated().encodeWithTag(r100, 114, r101.risk_object_keys);
            FileAbility r149 = r101.file_ability;
            if (r149 == null) goto L143;
            FileAbility.ADAPTER.encodeWithTag(r100, 115, r149);
        L143:
            FilePermission r150 = r101.file_permission;
            if (r150 == null) goto L146;
            FilePermission.ADAPTER.encodeWithTag(r100, 116, r150);
        L146:
            Long r151 = r101.file_last_update_user_id;
            if (r151 == null) goto L149;
            ProtoAdapter.INT64.encodeWithTag(r100, 117, r151);
        L149:
            Long r152 = r101.file_last_update_time_ms;
            if (r152 == null) goto L152;
            ProtoAdapter.INT64.encodeWithTag(r100, 118, r152);
        L152:
            LocalStatus r153 = r101.local_status;
            if (r153 == null) goto L155;
            LocalStatus.ADAPTER.encodeWithTag(r100, 119, r153);
        L155:
            FilePreviewStage r154 = r101.file_preview_stage;
            if (r154 == null) goto L158;
            FilePreviewStage.ADAPTER.encodeWithTag(r100, 120, r154);
        L158:
            ProtoAdapter<File> r155 = File.ADAPTER;
            r155.asRepeated().encodeWithTag(r100, 200, r101.attachments);
            r155.asRepeated().encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_DISABLE_RECENT_CACHE, r101.file_attachments);
            String r156 = r101.share_chat_id;
            if (r156 == null) goto L161;
            r148.encodeWithTag(r100, 300, r156);
        L161:
            String r157 = r101.join_token;
            if (r157 == null) goto L164;
            r148.encodeWithTag(r100, 301, r157);
        L164:
            Long r158 = r101.expire_time;
            if (r158 == null) goto L167;
            ProtoAdapter.INT64.encodeWithTag(r100, 302, r158);
        L167:
            Integer r159 = r101.share_chat_last_state;
            if (r159 == null) goto L170;
            ProtoAdapter.INT32.encodeWithTag(r100, 303, r159);
        L170:
            Integer r160 = r101.width;
            if (r160 == null) goto L173;
            ProtoAdapter.INT32.encodeWithTag(r100, 400, r160);
        L173:
            Integer r161 = r101.height;
            if (r161 == null) goto L176;
            ProtoAdapter.INT32.encodeWithTag(r100, 401, r161);
        L176:
            String r162 = r101.crypto_token;
            if (r162 == null) goto L179;
            r148.encodeWithTag(r100, 500, r162);
        L179:
            MergeForwardContent r163 = r101.merge_forward_content;
            if (r163 == null) goto L182;
            MergeForwardContent.ADAPTER.encodeWithTag(r100, 600, r163);
        L182:
            TransmitInfo r164 = r101.transmit_info;
            if (r164 == null) goto L185;
            TransmitInfo.ADAPTER.encodeWithTag(r100, 601, r164);
        L185:
            PreviewUrlContent.ADAPTER.asRepeated().encodeWithTag(r100, 700, r101.preview_urls);
            RichText r165 = r101.rich_text;
            if (r165 == null) goto L188;
            RichText.ADAPTER.encodeWithTag(r100, 800, r165);
        L188:
            CalendarContent r166 = r101.calendar_content;
            if (r166 == null) goto L191;
            CalendarContent.ADAPTER.encodeWithTag(r100, 900, r166);
        L191:
            ShareCalendarEventContent r167 = r101.share_calendar_event_content;
            if (r167 == null) goto L194;
            ShareCalendarEventContent.ADAPTER.encodeWithTag(r100, 901, r167);
        L194:
            GeneralCalendarContent r168 = r101.general_calendar_content;
            if (r168 == null) goto L197;
            GeneralCalendarContent.ADAPTER.encodeWithTag(r100, 902, r168);
        L197:
            TextUrlContent.ADAPTER.asRepeated().encodeWithTag(r100, 10000, r101.text_url_contents);
            CardContent r169 = r101.card_content;
            if (r169 == null) goto L200;
            CardContent.ADAPTER.encodeWithTag(r100, 1000, r169);
        L200:
            LocationContent r170 = r101.location_content;
            if (r170 == null) goto L203;
            LocationContent.ADAPTER.encodeWithTag(r100, 1010, r170);
        L203:
            String r171 = r101.e2ee_from_id;
            if (r171 == null) goto L206;
            r148.encodeWithTag(r100, 1100, r171);
        L206:
            String r172 = r101.e2ee_to_id;
            if (r172 == null) goto L209;
            r148.encodeWithTag(r100, 1101, r172);
        L209:
            String r173 = r101.trigger_id;
            if (r173 == null) goto L212;
            r148.encodeWithTag(r100, 1102, r173);
        L212:
            String r174 = r101.vc_from_id;
            if (r174 == null) goto L215;
            r148.encodeWithTag(r100, 1200, r174);
        L215:
            String r175 = r101.vc_to_id;
            if (r175 == null) goto L218;
            r148.encodeWithTag(r100, 1201, r175);
        L218:
            String r176 = r101.vc_duration_time;
            if (r176 == null) goto L221;
            r148.encodeWithTag(r100, 1202, r176);
        L221:
            String r177 = r101.vc_meeting_id;
            if (r177 == null) goto L224;
            r148.encodeWithTag(r100, 1203, r177);
        L224:
            String r178 = r101.vc_passcode;
            if (r178 == null) goto L227;
            r148.encodeWithTag(r100, 1204, r178);
        L227:
            String r179 = r101.vc_feedback_status;
            if (r179 == null) goto L230;
            r148.encodeWithTag(r100, 1205, r179);
        L230:
            String r180 = r101.vc_from_feedback_status;
            if (r180 == null) goto L233;
            r148.encodeWithTag(r100, 1206, r180);
        L233:
            String r181 = r101.vc_to_feedback_status;
            if (r181 == null) goto L236;
            r148.encodeWithTag(r100, 1207, r181);
        L236:
            Boolean r182 = r101.is_voice_call;
            if (r182 == null) goto L239;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1208, r182);
        L239:
            MediaContent r183 = r101.media_content;
            if (r183 == null) goto L242;
            MediaContent.ADAPTER.encodeWithTag(r100, 1300, r183);
        L242:
            HongbaoContent r184 = r101.hongbao_content;
            if (r184 == null) goto L245;
            HongbaoContent.ADAPTER.encodeWithTag(r100, 1301, r184);
        L245:
            HongbaoSystemContent r185 = r101.hongbao_system_content;
            if (r185 == null) goto L248;
            HongbaoSystemContent.ADAPTER.encodeWithTag(r100, 1302, r185);
        L248:
            SystemExtraContent r186 = r101.system_extra_content;
            if (r186 == null) goto L251;
            SystemExtraContent.ADAPTER.encodeWithTag(r100, 1303, r186);
        L251:
            VideoChatContent r187 = r101.videochat_content;
            if (r187 == null) goto L254;
            VideoChatContent.ADAPTER.encodeWithTag(r100, 1401, r187);
        L254:
            r148.asRepeated().encodeWithTag(r100, 1500, r101.resource_urls);
            String r188 = r101.fs_unit;
            if (r188 == null) goto L257;
            r148.encodeWithTag(r100, 1501, r188);
        L257:
            StickerInfo r189 = r101.sticker_info;
            if (r189 == null) goto L260;
            StickerInfo.ADAPTER.encodeWithTag(r100, 1502, r189);
        L260:
            String r190 = r101.sticker_id;
            if (r190 == null) goto L263;
            r148.encodeWithTag(r100, 1503, r190);
        L263:
            String r191 = r101.sticker_set_id;
            if (r191 == null) goto L266;
            r148.encodeWithTag(r100, 1504, r191);
        L266:
            ShareUserCardInfo r192 = r101.share_user_card_info;
            if (r192 == null) goto L269;
            ShareUserCardInfo.ADAPTER.encodeWithTag(r100, 1600, r192);
        L269:
            String r193 = r101.share_chatter_id;
            if (r193 == null) goto L272;
            r148.encodeWithTag(r100, 1601, r193);
        L272:
            Abbreviation r194 = r101.abbreviation;
            if (r194 == null) goto L275;
            Abbreviation.ADAPTER.encodeWithTag(r100, 2000, r194);
        L275:
            this.typed_element_refs.encodeWithTag(r100, 2001, r101.typed_element_refs);
            TodoOperationContent r195 = r101.todo_operation_content;
            if (r195 == null) goto L278;
            TodoOperationContent.ADAPTER.encodeWithTag(r100, 2010, r195);
        L278:
            LingoOption r196 = r101.lingo_option;
            if (r196 == null) goto L281;
            LingoOption.ADAPTER.encodeWithTag(r100, 33, r196);
        L281:
            VoteContent r197 = r101.vote_content;
            if (r197 == null) goto L284;
            VoteContent.ADAPTER.encodeWithTag(r100, 2020, r197);
        L284:
            String r198 = r101.folder_archive_key;
            if (r198 == null) goto L287;
            r148.encodeWithTag(r100, 2021, r198);
        L287:
            Reference.ADAPTER.asRepeated().encodeWithTag(r100, 2022, r101.content_references);
            Boolean r199 = r101.include_cleaned_resources;
            if (r199 == null) goto L290;
            ProtoAdapter.BOOL.encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_OPTIMIZE_RANGE, r199);
        L290:
            this.clean_resource_key_scene.encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, r101.clean_resource_key_scene);
            DoubaoContent r200 = r101.doubao_content;
            if (r200 == null) goto L293;
            DoubaoContent.ADAPTER.encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, r200);
        L293:
            Boolean r201 = r101.is_unknown_doubao_content;
            if (r201 == null) goto L296;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2026, r201);
        L296:
            DoubaoResource r202 = r101.doubao_resource;
            if (r202 == null) goto L299;
            DoubaoResource.ADAPTER.encodeWithTag(r100, DataLoaderHelper.DATALOADER_KEY_INT_UPDATE_FILE_INTERNAL, r202);
        L299:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Content r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Reference extends com.squareup.wire.Message<Reference, Builder> {
        public static final ProtoAdapter<Reference> ADAPTER = null;
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String title;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<Reference, Builder> {
            public String title;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public Reference build() {
                return new Reference(this.url, this.title, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Reference extends ProtoAdapter<Reference> {
            public ProtoAdapter_Reference() {
                super(FieldEncoding.LENGTH_DELIMITED, Reference.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Reference decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.title = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.title = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Reference r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.title;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Reference decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Reference r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Reference r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.title;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Reference r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Reference();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.title = this.title;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Reference.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Reference(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Reference(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.url = r100;
            this.title = r101;
        }
    }

    public static final class ShareUserCardInfo extends com.squareup.wire.Message<ShareUserCardInfo, Builder> {
        public static final ProtoAdapter<ShareUserCardInfo> ADAPTER = null;
        public static final String DEFAULT_CHATTER_ID = "";
        public static final String DEFAULT_EN_US_NAME = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final Image avatar_image;
        public final String chatter_id;
        public final String en_us_name;
        public final Map<String, String> international_name;
        public final String name;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShareUserCardInfo, Builder> {
            public Image avatar_image;
            public String chatter_id;
            public String en_us_name;
            public Map<String, String> international_name;
            public String name;

            @Override // com.squareup.wire.Message.Builder
            public ShareUserCardInfo build() {
                return new ShareUserCardInfo(this.chatter_id, this.avatar_image, this.name, this.en_us_name, this.international_name, super.buildUnknownFields());
            }

            public Builder() {
                this.international_name = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder avatar_image(Image r100) {
                this.avatar_image = r100;
                return this;
            }

            public Builder chatter_id(String r100) {
                this.chatter_id = r100;
                return this;
            }

            public Builder en_us_name(String r100) {
                this.en_us_name = r100;
                return this;
            }

            public Builder international_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.international_name = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShareUserCardInfo extends ProtoAdapter<ShareUserCardInfo> {
            private final ProtoAdapter<Map<String, String>> international_name;

            public ProtoAdapter_ShareUserCardInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareUserCardInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.international_name = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShareUserCardInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chatter_id = "";
                r101.name = "";
                r101.en_us_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.chatter_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.avatar_image = Image.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.en_us_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.international_name.putAll(this.international_name.decode(r100));
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
            public int encodedSize2(ShareUserCardInfo r100) {
                String r101 = r100.chatter_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Image r104 = r100.avatar_image;
                if (r104 == null) goto L9;
                int r105 = Image.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.name;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.en_us_name;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return ((r109 + r102) + this.international_name.encodedSizeWithTag(5, r100.international_name)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ShareUserCardInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShareUserCardInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShareUserCardInfo r101) throws IOException {
                String r102 = r101.chatter_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Image r103 = r101.avatar_image;
                if (r103 == null) goto L8;
                Image.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.name;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.en_us_name;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                this.international_name.encodeWithTag(r100, 5, r101.international_name);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareUserCardInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareUserCardInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_id = this.chatter_id;
            r100.avatar_image = this.avatar_image;
            r100.name = this.name;
            r100.en_us_name = this.en_us_name;
            r100.international_name = Internal.copyOf("international_name", this.international_name);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShareUserCardInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShareUserCardInfo(String r100, Image r101, String r110, String r111, Map<String, String> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ShareUserCardInfo(String r100, Image r101, String r102, String r103, Map<String, String> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.chatter_id = r100;
            this.avatar_image = r101;
            this.name = r102;
            this.en_us_name = r103;
            this.international_name = Internal.immutableCopyOf("international_name", r104);
        }
    }

    public static final class StickerInfo extends com.squareup.wire.Message<StickerInfo, Builder> {
        public static final ProtoAdapter<StickerInfo> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final Boolean DEFAULT_IS_PAID = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final String description;
        public final Boolean is_paid;
        public final String title;

        public static final class Builder extends com.squareup.wire.Message.Builder<StickerInfo, Builder> {
            public String description;
            public Boolean is_paid;
            public String title;

            @Override // com.squareup.wire.Message.Builder
            public StickerInfo build() {
                return new StickerInfo(this.title, this.description, this.is_paid, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder description(String r100) {
                this.description = r100;
                return this;
            }

            public Builder is_paid(Boolean r100) {
                this.is_paid = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StickerInfo extends ProtoAdapter<StickerInfo> {
            public ProtoAdapter_StickerInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, StickerInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StickerInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.description = "";
                r101.is_paid = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 2) goto L8;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 3) goto L10;
                r101.description = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 4) goto L11;
                r101.is_paid = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(StickerInfo r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r101);
            L6:
                String r104 = r100.description;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(3, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_paid;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
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
            public /* bridge */ /* synthetic */ StickerInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StickerInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StickerInfo r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.description;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                Boolean r104 = r101.is_paid;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StickerInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StickerInfo();
            DEFAULT_IS_PAID = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.description = this.description;
            r100.is_paid = this.is_paid;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StickerInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public StickerInfo(String r100, String r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public StickerInfo(String r100, String r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.title = r100;
            this.description = r101;
            this.is_paid = r102;
        }
    }

    public static final class SystemContentValue extends com.squareup.wire.Message<SystemContentValue, Builder> {
        public static final ProtoAdapter<SystemContentValue> ADAPTER = null;
        public static final ContentValueType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final List<ContentValue> content_values;
        public final ContentValueType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<SystemContentValue, Builder> {
            public List<ContentValue> content_values;
            public ContentValueType type;

            @Override // com.squareup.wire.Message.Builder
            public SystemContentValue build() {
                return new SystemContentValue(this.type, this.content_values, super.buildUnknownFields());
            }

            public Builder() {
                this.content_values = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content_values(List<ContentValue> r100) {
                Internal.checkElementsNotNull(r100);
                this.content_values = r100;
                return this;
            }

            public Builder type(ContentValueType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ContentValue extends com.squareup.wire.Message<ContentValue, Builder> {
            public static final ProtoAdapter<ContentValue> ADAPTER = null;
            public static final Integer DEFAULT_ACTION_ID = null;
            public static final SystemMessageAction.ActType DEFAULT_ACTION_TYPE = null;
            public static final String DEFAULT_ID = "";
            public static final Boolean DEFAULT_IS_ANONYMOUS = null;
            public static final Boolean DEFAULT_IS_CLICKABLE = null;
            public static final String DEFAULT_LINK = "";
            public static final ContentValueType DEFAULT_TYPE = null;
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;
            public final Integer action_id;
            public final SystemMessageAction.ActType action_type;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public final String f253469id;
            public final Boolean is_anonymous;
            public final Boolean is_clickable;
            public final String link;
            public final ContentValueType type;
            public final String value;

            public static final class Builder extends com.squareup.wire.Message.Builder<ContentValue, Builder> {
                public Integer action_id;
                public SystemMessageAction.ActType action_type;

                /* JADX INFO: renamed from: id, reason: collision with root package name */
                public String f253470id;
                public Boolean is_anonymous;
                public Boolean is_clickable;
                public String link;
                public ContentValueType type;
                public String value;

                @Override // com.squareup.wire.Message.Builder
                public ContentValue build() {
                    return new ContentValue(this.value, this.f253470id, this.link, this.type, this.action_type, this.is_anonymous, this.action_id, this.is_clickable, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder action_id(Integer r100) {
                    this.action_id = r100;
                    return this;
                }

                public Builder action_type(SystemMessageAction.ActType r100) {
                    this.action_type = r100;
                    return this;
                }

                public Builder id(String r100) {
                    this.f253470id = r100;
                    return this;
                }

                public Builder is_anonymous(Boolean r100) {
                    this.is_anonymous = r100;
                    return this;
                }

                public Builder is_clickable(Boolean r100) {
                    this.is_clickable = r100;
                    return this;
                }

                public Builder link(String r100) {
                    this.link = r100;
                    return this;
                }

                public Builder type(ContentValueType r100) {
                    this.type = r100;
                    return this;
                }

                public Builder value(String r100) {
                    this.value = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ContentValue extends ProtoAdapter<ContentValue> {
                public ProtoAdapter_ContentValue() {
                    super(FieldEncoding.LENGTH_DELIMITED, ContentValue.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ContentValue decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.value = "";
                    r101.f253470id = "";
                    r101.link = "";
                    r101.type = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
                    r101.action_type = SystemMessageAction.ActType.UNKNOWN_ACT_TYPE;
                    Boolean r102 = Boolean.FALSE;
                    r101.is_anonymous = r102;
                    r101.action_id = 0;
                    r101.is_clickable = r102;
                    long r103 = r100.beginMessage();
                L3:
                    int r104 = r100.nextTag();
                    if (r104 == (-1)) goto L21;
                    switch(r104) {
                        case 1: goto L20;
                        case 2: goto L19;
                        case 3: goto L18;
                        case 4: goto L25;
                        case 5: goto L23;
                        case 6: goto L9;
                        case 7: goto L8;
                        case 8: goto L7;
                        default: goto L6;
                    };
                L23:
                    r101.action_type = SystemMessageAction.ActType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                L12:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L25:
                    r101.type = ContentValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L7:
                    r101.is_clickable = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L8:
                    r101.action_id = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L9:
                    r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L18:
                    r101.link = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L19:
                    r101.f253470id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L20:
                    r101.value = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r105 = r100.peekFieldEncoding();
                    r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                    goto L3
                L21:
                    r100.endMessage(r103);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(ContentValue r100) {
                    String r101 = r100.value;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.f253469id;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.link;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    ContentValueType r110 = r100.type;
                    if (r110 == null) goto L17;
                    int r111 = ContentValueType.ADAPTER.encodedSizeWithTag(4, r110);
                L18:
                    int r112 = r109 + r111;
                    SystemMessageAction.ActType r113 = r100.action_type;
                    if (r113 == null) goto L21;
                    int r114 = SystemMessageAction.ActType.ADAPTER.encodedSizeWithTag(5, r113);
                L22:
                    int r115 = r112 + r114;
                    Boolean r116 = r100.is_anonymous;
                    if (r116 == null) goto L25;
                    int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
                L26:
                    int r118 = r115 + r117;
                    Integer r119 = r100.action_id;
                    if (r119 == null) goto L29;
                    int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
                L30:
                    int r121 = r118 + r120;
                    Boolean r122 = r100.is_clickable;
                    if (r122 == null) goto L34;
                    r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
                L34:
                    return (r121 + r102) + r100.unknownFields().size();
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
                public /* bridge */ /* synthetic */ ContentValue decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ContentValue r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ContentValue r101) throws IOException {
                    String r102 = r101.value;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.f253469id;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.link;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    ContentValueType r105 = r101.type;
                    if (r105 == null) goto L14;
                    ContentValueType.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    SystemMessageAction.ActType r106 = r101.action_type;
                    if (r106 == null) goto L17;
                    SystemMessageAction.ActType.ADAPTER.encodeWithTag(r100, 5, r106);
                L17:
                    Boolean r107 = r101.is_anonymous;
                    if (r107 == null) goto L20;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
                L20:
                    Integer r108 = r101.action_id;
                    if (r108 == null) goto L23;
                    ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
                L23:
                    Boolean r109 = r101.is_clickable;
                    if (r109 == null) goto L26;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
                L26:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContentValue r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ContentValue();
                DEFAULT_TYPE = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
                DEFAULT_ACTION_TYPE = SystemMessageAction.ActType.UNKNOWN_ACT_TYPE;
                Boolean r100 = Boolean.FALSE;
                DEFAULT_IS_ANONYMOUS = r100;
                DEFAULT_ACTION_ID = 0;
                DEFAULT_IS_CLICKABLE = r100;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.value = this.value;
                r100.f253470id = this.f253469id;
                r100.link = this.link;
                r100.type = this.type;
                r100.action_type = this.action_type;
                r100.is_anonymous = this.is_anonymous;
                r100.action_id = this.action_id;
                r100.is_clickable = this.is_clickable;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ContentValue.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public ContentValue(String r110, String r111, String r112, ContentValueType r113, SystemMessageAction.ActType r114, Boolean r115, Integer r116, Boolean r117) {
                this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
            }

            public ContentValue(String r100, String r101, String r102, ContentValueType r103, SystemMessageAction.ActType r104, Boolean r105, Integer r106, Boolean r107, ByteString r110) {
                super(ADAPTER, r110);
                this.value = r100;
                this.f253469id = r101;
                this.link = r102;
                this.type = r103;
                this.action_type = r104;
                this.is_anonymous = r105;
                this.action_id = r106;
                this.is_clickable = r107;
            }
        }

        public static final class ProtoAdapter_SystemContentValue extends ProtoAdapter<SystemContentValue> {
            public ProtoAdapter_SystemContentValue() {
                super(FieldEncoding.LENGTH_DELIMITED, SystemContentValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SystemContentValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = ContentValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.content_values.add(ContentValue.ADAPTER.decode(r100));
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
            public int encodedSize2(SystemContentValue r100) {
                ContentValueType r101 = r100.type;
                if (r101 == null) goto L5;
                int r102 = ContentValueType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + ContentValue.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.content_values)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SystemContentValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SystemContentValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SystemContentValue r101) throws IOException {
                ContentValueType r102 = r101.type;
                if (r102 == null) goto L5;
                ContentValueType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ContentValue.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.content_values);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemContentValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SystemContentValue();
            DEFAULT_TYPE = ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.content_values = Internal.copyOf("content_values", this.content_values);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SystemContentValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SystemContentValue(ContentValueType r100, List<ContentValue> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SystemContentValue(ContentValueType r100, List<ContentValue> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.content_values = Internal.immutableCopyOf("content_values", r101);
        }
    }

    public static final class SystemExtraContent extends com.squareup.wire.Message<SystemExtraContent, Builder> {
        public static final ProtoAdapter<SystemExtraContent> ADAPTER = null;
        public static final Boolean DEFAULT_CLEAR_SCREEN = null;
        private static final long serialVersionUID = 0;
        public final Boolean clear_screen;
        public final SystemGuideContent guide_content;
        public final NewTopicSystemMessageExtraContent new_topic_system_message_extra_content;

        public static final class Builder extends com.squareup.wire.Message.Builder<SystemExtraContent, Builder> {
            public Boolean clear_screen;
            public SystemGuideContent guide_content;
            public NewTopicSystemMessageExtraContent new_topic_system_message_extra_content;

            @Override // com.squareup.wire.Message.Builder
            public SystemExtraContent build() {
                return new SystemExtraContent(this.guide_content, this.new_topic_system_message_extra_content, this.clear_screen, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder clear_screen(Boolean r100) {
                this.clear_screen = r100;
                return this;
            }

            public Builder guide_content(SystemGuideContent r100) {
                this.guide_content = r100;
                return this;
            }

            public Builder new_topic_system_message_extra_content(NewTopicSystemMessageExtraContent r100) {
                this.new_topic_system_message_extra_content = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SystemExtraContent extends ProtoAdapter<SystemExtraContent> {
            public ProtoAdapter_SystemExtraContent() {
                super(FieldEncoding.LENGTH_DELIMITED, SystemExtraContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SystemExtraContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.clear_screen = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.guide_content = SystemGuideContent.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.new_topic_system_message_extra_content = NewTopicSystemMessageExtraContent.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.clear_screen = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(SystemExtraContent r100) {
                SystemGuideContent r101 = r100.guide_content;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = SystemGuideContent.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                NewTopicSystemMessageExtraContent r104 = r100.new_topic_system_message_extra_content;
                if (r104 == null) goto L9;
                int r105 = NewTopicSystemMessageExtraContent.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.clear_screen;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ SystemExtraContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SystemExtraContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SystemExtraContent r101) throws IOException {
                SystemGuideContent r102 = r101.guide_content;
                if (r102 == null) goto L5;
                SystemGuideContent.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                NewTopicSystemMessageExtraContent r103 = r101.new_topic_system_message_extra_content;
                if (r103 == null) goto L8;
                NewTopicSystemMessageExtraContent.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.clear_screen;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemExtraContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SystemExtraContent();
            DEFAULT_CLEAR_SCREEN = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.guide_content = this.guide_content;
            r100.new_topic_system_message_extra_content = this.new_topic_system_message_extra_content;
            r100.clear_screen = this.clear_screen;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SystemExtraContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SystemExtraContent(SystemGuideContent r100, NewTopicSystemMessageExtraContent r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SystemExtraContent(SystemGuideContent r100, NewTopicSystemMessageExtraContent r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.guide_content = r100;
            this.new_topic_system_message_extra_content = r101;
            this.clear_screen = r102;
        }
    }

    public static final class SystemMessageAction extends com.squareup.wire.Message<SystemMessageAction, Builder> {
        public static final ProtoAdapter<SystemMessageAction> ADAPTER = null;
        public static final ByteString DEFAULT_PAYLOAD = null;
        public static final ActType DEFAULT_TYPE = null;
        public static final Integer DEFAULT_TYPE_NUM = null;
        private static final long serialVersionUID = 0;
        public final ByteString payload;
        public final ActType type;
        public final Integer type_num;

        public static final enum ActType extends Enum<ActType> implements WireEnum {
            private static final /* synthetic */ ActType[] $VALUES = null;
            public static final ProtoAdapter<ActType> ADAPTER = null;
            public static final ActType INVITE_AT_CHATTERS = null;
            public static final ActType UNKNOWN_ACT_TYPE = null;
            public static final ActType URL = null;
            private final int value;

            static {
                ActType r100 = new ActType("UNKNOWN_ACT_TYPE", 0, 0);
                UNKNOWN_ACT_TYPE = r100;
                ActType r101 = new ActType("INVITE_AT_CHATTERS", 1, 1);
                INVITE_AT_CHATTERS = r101;
                ActType r102 = new ActType("URL", 2, 2);
                URL = r102;
                $VALUES = new ActType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(ActType.class);
            }

            public static ActType[] values() {
                return (ActType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ActType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return URL;
            L12:
                return INVITE_AT_CHATTERS;
            L14:
                return UNKNOWN_ACT_TYPE;
            }

            public static ActType valueOf(String r100) {
                return (ActType) a.a(ActType.class, r100);
            }

            private ActType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<SystemMessageAction, Builder> {
            public ByteString payload;
            public ActType type;
            public Integer type_num;

            @Override // com.squareup.wire.Message.Builder
            public SystemMessageAction build() {
                return new SystemMessageAction(this.type, this.type_num, this.payload, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder payload(ByteString r100) {
                this.payload = r100;
                return this;
            }

            public Builder type(ActType r100) {
                this.type = r100;
                return this;
            }

            public Builder type_num(Integer r100) {
                this.type_num = r100;
                return this;
            }
        }

        public static final class InviteAtChatters extends com.squareup.wire.Message<InviteAtChatters, Builder> {
            public static final ProtoAdapter<InviteAtChatters> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<Long> at_chatter_ids;

            public static final class Builder extends com.squareup.wire.Message.Builder<InviteAtChatters, Builder> {
                public List<Long> at_chatter_ids;

                @Override // com.squareup.wire.Message.Builder
                public InviteAtChatters build() {
                    return new InviteAtChatters(this.at_chatter_ids, super.buildUnknownFields());
                }

                public Builder() {
                    this.at_chatter_ids = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder at_chatter_ids(List<Long> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.at_chatter_ids = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_InviteAtChatters extends ProtoAdapter<InviteAtChatters> {
                public ProtoAdapter_InviteAtChatters() {
                    super(FieldEncoding.LENGTH_DELIMITED, InviteAtChatters.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public InviteAtChatters decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.at_chatter_ids.add(ProtoAdapter.INT64.decode(r100));
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
                public int encodedSize2(InviteAtChatters r100) {
                    return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.at_chatter_ids) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ InviteAtChatters decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(InviteAtChatters r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, InviteAtChatters r101) throws IOException {
                    ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.at_chatter_ids);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InviteAtChatters r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_InviteAtChatters();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.at_chatter_ids = Internal.copyOf("at_chatter_ids", this.at_chatter_ids);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return InviteAtChatters.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public InviteAtChatters(List<Long> r100) {
                this(r100, ByteString.EMPTY);
            }

            public InviteAtChatters(List<Long> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.at_chatter_ids = Internal.immutableCopyOf("at_chatter_ids", r100);
            }
        }

        public static final class ProtoAdapter_SystemMessageAction extends ProtoAdapter<SystemMessageAction> {
            public ProtoAdapter_SystemMessageAction() {
                super(FieldEncoding.LENGTH_DELIMITED, SystemMessageAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SystemMessageAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ActType.UNKNOWN_ACT_TYPE;
                r101.type_num = 0;
                r101.payload = ByteString.EMPTY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.type = ActType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.type_num = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.payload = ProtoAdapter.BYTES.decode(r100);
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
            public int encodedSize2(SystemMessageAction r100) {
                ActType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ActType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.type_num;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ByteString r107 = r100.payload;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ SystemMessageAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SystemMessageAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SystemMessageAction r101) throws IOException {
                ActType r102 = r101.type;
                if (r102 == null) goto L5;
                ActType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.type_num;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ByteString r104 = r101.payload;
                if (r104 == null) goto L11;
                ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemMessageAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class Url extends com.squareup.wire.Message<Url, Builder> {
            public static final ProtoAdapter<Url> ADAPTER = null;
            public static final String DEFAULT_ANDROID = "";
            public static final String DEFAULT_COMMON = "";
            public static final String DEFAULT_IOS = "";
            public static final String DEFAULT_PC = "";
            public static final String DEFAULT_WEB = "";
            private static final long serialVersionUID = 0;

            /* JADX INFO: renamed from: android, reason: collision with root package name */
            public final String f253471android;
            public final String common;
            public final String ios;

            /* JADX INFO: renamed from: pc, reason: collision with root package name */
            public final String f253472pc;

            /* JADX INFO: renamed from: web, reason: collision with root package name */
            public final String f253473web;

            public static final class Builder extends com.squareup.wire.Message.Builder<Url, Builder> {

                /* JADX INFO: renamed from: android, reason: collision with root package name */
                public String f253474android;
                public String common;
                public String ios;

                /* JADX INFO: renamed from: pc, reason: collision with root package name */
                public String f253475pc;

                /* JADX INFO: renamed from: web, reason: collision with root package name */
                public String f253476web;

                @Override // com.squareup.wire.Message.Builder
                public Url build() {
                    String r100 = this.common;
                    if (r100 == null) goto L7;
                    return new Url(this.ios, this.f253474android, this.f253475pc, this.f253476web, this.common, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "common"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder android(String r100) {
                    this.f253474android = r100;
                    return this;
                }

                public Builder common(String r100) {
                    this.common = r100;
                    return this;
                }

                public Builder ios(String r100) {
                    this.ios = r100;
                    return this;
                }

                public Builder pc(String r100) {
                    this.f253475pc = r100;
                    return this;
                }

                public Builder web(String r100) {
                    this.f253476web = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Url extends ProtoAdapter<Url> {
                public ProtoAdapter_Url() {
                    super(FieldEncoding.LENGTH_DELIMITED, Url.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Url decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.ios = "";
                    r101.f253474android = "";
                    r101.f253475pc = "";
                    r101.f253476web = "";
                    r101.common = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L21;
                    if (r103 != 1) goto L8;
                    r101.ios = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.f253474android = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.f253475pc = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L14;
                    r101.f253476web = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L14:
                    if (r103 != 100) goto L15;
                    r101.common = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(Url r100) {
                    String r101 = r100.ios;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.f253471android;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.f253472pc;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    String r110 = r100.f253473web;
                    if (r110 == null) goto L18;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
                L18:
                    return ((r109 + r102) + ProtoAdapter.STRING.encodedSizeWithTag(100, r100.common)) + r100.unknownFields().size();
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
                public /* bridge */ /* synthetic */ Url decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Url r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Url r101) throws IOException {
                    String r102 = r101.ios;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.f253471android;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.f253472pc;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    String r105 = r101.f253473web;
                    if (r105 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
                L14:
                    ProtoAdapter.STRING.encodeWithTag(r100, 100, r101.common);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Url r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Url();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.ios = this.ios;
                r100.f253474android = this.f253471android;
                r100.f253475pc = this.f253472pc;
                r100.f253476web = this.f253473web;
                r100.common = this.common;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Url.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Url(String r100, String r101, String r110, String r111, String r112) {
                this(r100, r101, r110, r111, r112, ByteString.EMPTY);
            }

            public Url(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
                super(ADAPTER, r105);
                this.ios = r100;
                this.f253471android = r101;
                this.f253472pc = r102;
                this.f253473web = r103;
                this.common = r104;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SystemMessageAction();
            DEFAULT_TYPE = ActType.UNKNOWN_ACT_TYPE;
            DEFAULT_TYPE_NUM = 0;
            DEFAULT_PAYLOAD = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.type_num = this.type_num;
            r100.payload = this.payload;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SystemMessageAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SystemMessageAction(ActType r100, Integer r101, ByteString r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SystemMessageAction(ActType r100, Integer r101, ByteString r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.type_num = r101;
            this.payload = r102;
        }
    }

    public static final enum SystemType extends Enum<SystemType> implements WireEnum {
        private static final /* synthetic */ SystemType[] $VALUES = null;
        public static final ProtoAdapter<SystemType> ADAPTER = null;
        public static final SystemType ADD_EMAIL_MEMBERS = null;
        public static final SystemType ADD_MEMBER_TO_ADMIN_LIST = null;
        public static final SystemType ADMIN_OPEN_ANYONE_POST = null;
        public static final SystemType ADMIN_OPEN_ANYONE_POST_THREAD = null;
        public static final SystemType ALL_MEMBERS_CAN_MANAGE_CHAT_TAB = null;
        public static final SystemType ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets = null;
        public static final SystemType ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1 = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = null;
        public static final SystemType ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT = null;
        public static final SystemType AUTO_OPEN_TYPING_TRANSLATE = null;
        public static final SystemType AUTO_OPEN_TYPING_TRANSLATE_V1 = null;
        public static final SystemType AUTO_TRANSLATE_GUIDANCE = null;
        public static final SystemType BIND_CHAT_INTO_TEAM = null;
        public static final SystemType BIND_CHAT_INTO_TEAM_MANAGER = null;
        public static final SystemType BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE = null;
        public static final SystemType BUILD_FRIENDSHIP = null;
        public static final SystemType BUILD_ONEWAY_RELATION = null;
        public static final SystemType BuzzLimit = null;
        public static final SystemType BuzzNotAnswer = null;
        public static final SystemType BuzzSystemError = null;
        public static final SystemType BuzzTimeOut = null;
        public static final SystemType CANCEL_EMERGENCY_CALL = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = null;
        public static final SystemType CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE = null;
        public static final SystemType CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE = null;
        public static final SystemType CHAT_ROOM_END = null;
        public static final SystemType CHAT_ROOM_START = null;
        public static final SystemType CHAT_ROOM_START_V2 = null;
        public static final SystemType CHAT_USER_BOT_AUTO_MUTE = null;
        public static final SystemType CHAT_USER_BOT_AUTO_MUTE_S = null;
        public static final SystemType CHAT_USER_LARGE_CHAT_AUTO_MUTE = null;
        public static final SystemType CHAT_USER_P2P_BOT_AUTO_MUTE = null;
        public static final SystemType CHECK_USER_PHONE_NUMBER = null;
        public static final SystemType CHECK_USER_PHONE_USER_IN_WHITELIST = null;
        public static final SystemType CIRCLE_ANONYMOUS_OFF = null;
        public static final SystemType CIRCLE_ANONYMOUS_ON = null;
        public static final SystemType CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS = null;
        public static final SystemType CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS = null;
        public static final SystemType CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED = null;
        public static final SystemType CIRCLE_USER_CHANGE_DOC_PERMISSION = null;
        public static final SystemType CIRCLE_WELCOME_NEW_MEMBERS = null;
        public static final SystemType CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY = null;
        public static final SystemType CLOSE_TEAM_ADD_MEMBERS_PERMISSION = null;
        public static final SystemType CLOSE_TEAM_CREATE_CHAT_PERMISSION = null;
        public static final SystemType CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER = null;
        public static final SystemType CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER = null;
        public static final SystemType CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT = null;
        public static final SystemType CREATE_P2P_SOURCE = null;
        public static final SystemType CREATE_TEAM_AND_INVITE_MEMBERS = null;
        public static final SystemType CREATE_TEAM_CHAT = null;
        public static final SystemType CREATE_TEAM_CHAT_V2_MANAGER = null;
        public static final SystemType CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF = null;
        public static final SystemType CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON = null;
        public static final SystemType CRYPTO_LOW_VERSION_HINT = null;
        public static final SystemType CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING = null;
        public static final SystemType CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT = null;
        public static final SystemType CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS = null;
        public static final SystemType CantBuzzEmptyName = null;
        public static final SystemType CantBuzzEmptyPhoneNumber = null;
        public static final SystemType CantBuzzMembers = null;
        public static final SystemType CantChatUserPrivacySettings = null;
        public static final SystemType DECLINE_INVITATION = null;
        public static final SystemType DECLINE_SPEC_INVITATION = null;
        public static final SystemType DELETE_TEAM_DESCRIPTION = null;
        public static final SystemType DERIVE_FROM_P2P_CHAT = null;
        public static final SystemType DISSOLVE_TEAM_AND_UNBIND_CHAT = null;
        public static final SystemType DOC_TEMPLATE_GROUP_SHARE = null;
        public static final SystemType DOUBAO_SHOW_JOIN_CHAT = null;
        public static final SystemType DOUBAO_SHOW_JOIN_CHAT_STRANGER = null;
        public static final SystemType DOUBAO_SHOW_NEW_CONTACT = null;
        public static final SystemType DOUBAO_SHOW_NEW_CONTACT_NO_GREETING = null;
        public static final SystemType DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS = null;
        public static final SystemType DOUBAO_SHOW_READ_TIP = null;
        public static final SystemType EMERGENCY_CALL_NOTANSWER = null;
        public static final SystemType ENABLE_TEAM_ADD_MEMBERS_PERMISSION = null;
        public static final SystemType ENABLE_TEAM_CREATE_CHAT_PERMISSION = null;
        public static final SystemType EXTERNAL_COORDINATE_CTL = null;
        public static final SystemType GRAB_OTHER_HONGBAO = null;
        public static final SystemType GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES = null;
        public static final SystemType GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF = null;
        public static final SystemType GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON = null;
        public static final SystemType HANGUP_EMERGENCY_CALL = null;
        public static final SystemType HELP_DESK_USER_JOIN_CHAT = null;
        public static final SystemType HELP_DESK_USER_JOIN_CHAT_NO_HISTORY = null;
        public static final SystemType HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED = null;
        public static final SystemType INVITE_AT_CHATTERS = null;
        public static final SystemType INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD = null;
        public static final SystemType INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD = null;
        public static final SystemType INVITE_CHAT_MEMBER_2_CHAT = null;
        public static final SystemType INVITE_CHAT_MEMBER_2_OUT_CHAT = null;
        public static final SystemType INVITE_FRIENDS_SUCCESS = null;
        public static final SystemType INVITE_MEMBERS_JOIN_TEAM = null;
        public static final SystemType INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE = null;
        public static final SystemType JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD = null;
        public static final SystemType JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY = null;
        public static final SystemType JOIN_DEPARTMENT_GROUP = null;
        public static final SystemType KICK_MEMBERS_OUT_TEAM = null;
        public static final SystemType LAST_HONGBAO_IS_GRABBED = null;
        public static final SystemType LOCAL_MENTION_BOTS_NOT_IN_CHAT = null;
        public static final SystemType Lark_IM_BotCustomization = null;
        public static final SystemType Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite = null;
        public static final SystemType Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndDepartment_MemberInivite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroup_MemberInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroup_OwnerInvite = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam = null;
        public static final SystemType Lark_IM_Server_WelcomeTo_Text = null;
        public static final SystemType MANUAL_OPEN_TYPING_TRANSLATE = null;
        public static final SystemType MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS = null;
        public static final SystemType MEETING_TRANSFER_TO_CHAT = null;
        public static final SystemType MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL = null;
        public static final SystemType MEMBERS_JOIN_TEAM_CHAT_FAIL = null;
        public static final SystemType MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL = null;
        public static final SystemType MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES = null;
        public static final SystemType MEMBERS_JOIN_TEAM_FAIL = null;
        public static final SystemType MEMBERS_LEAVE_AND_TRANSFER = null;
        public static final SystemType MEMBER_LEAVE_TEAM = null;
        public static final SystemType MENTIONED_PERSON_NOT_IN_CIRCLE = null;
        public static final SystemType MIND_NOTE_TEMPLATE_GROUP_SHARE = null;
        public static final SystemType MODIFY_EMAIL_MEMBERS = null;
        public static final SystemType MODIFY_TEAM_AVATAR = null;
        public static final SystemType MODIFY_TEAM_DESCRIPTION = null;
        public static final SystemType MODIFY_TEAM_NAME = null;
        public static final SystemType MultiItemSystemContent = null;
        public static final SystemType MyAI_NewTopicTip = null;
        public static final SystemType MyAI_SceneTopicDynamicTip = null;
        public static final SystemType NON_FRIENDS_NOTICE = null;
        public static final SystemType NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY = null;
        public static final SystemType NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT = null;
        public static final SystemType ONLY_ADMIN_CAN_MANAGE_CHAT_TAB = null;
        public static final SystemType ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets = null;
        public static final SystemType ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1 = null;
        public static final SystemType OTHER_GRAB_MY_HONGBAO = null;
        public static final SystemType REMOVE_EMAIL_MEMBERS = null;
        public static final SystemType REMOVE_MEMBER_FROM_ADMIN_LIST = null;
        public static final SystemType SAIPAN_ADD_ONCALL = null;
        public static final SystemType SAIPAN_NOTIFY_AGENT_QUEUEING = null;
        public static final SystemType SAIPAN_REMIND_ONCALL_AUTO_DONE = null;
        public static final SystemType SAIPAN_REMIND_ONCALL_DONE = null;
        public static final SystemType SAIPAN_REMIND_ONCALL_REPLY = null;
        public static final SystemType SAIPAN_RESERVED_3 = null;
        public static final SystemType SAIPAN_RESERVED_4 = null;
        public static final SystemType SAIPAN_RESERVED_5 = null;
        public static final SystemType SAIPAN_SELECT_CARD_CONTENT = null;
        public static final SystemType SAIPAN_USER_QUEUEING = null;
        public static final SystemType SEND_HONGBAO_MESSAGE_FAILED = null;
        public static final SystemType SEND_MESSAGE_COLLABORATION_AUTH_FAILED = null;
        public static final SystemType SHEET_TEMPLATE_GROUP_SHARE = null;
        public static final SystemType SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS = null;
        public static final SystemType SIMPLIFY_OTHER_GRAB_MY_HONGBAO = null;
        public static final SystemType SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM = null;
        public static final SystemType SIMPLIFY_SYSTEM_WELCOME_USER = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_GROUP_LINK = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_QR_CODE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_SHARE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = null;
        public static final SystemType START_EMERGENCY_CALL = null;
        public static final SystemType SYSTEM_EPHEMERAL_NOTIFY = null;
        public static final SystemType SYSTEM_WELCOME_USER = null;
        public static final SystemType TARGET_EXTERNAL_COORDINATE_CTL = null;
        public static final SystemType TEAM_CHAT_TURN_OPEN_MESSAGE = null;
        public static final SystemType TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM = null;
        public static final SystemType TRANSFER_CIRCLE_OWNER = null;
        public static final SystemType TRANSFER_CIRCLE_OWNER_AND_LEAVE = null;
        public static final SystemType TRANSFER_GROUP_CHAT_OWNER = null;
        public static final SystemType TRANSFER_GROUP_CHAT_OWNER_AND_QUIT = null;
        public static final SystemType TRANSFER_TEAM_OWNER = null;
        public static final SystemType UNBIND_CHAT_WITH_TEAM = null;
        public static final SystemType UNKNOWN = null;
        public static final SystemType UPDATE_CHAT_TO_TEAM = null;
        public static final SystemType UPGRADE_SUPER_CHAT = null;
        public static final SystemType USER_ADD_MEETING_CHAT = null;
        public static final SystemType USER_CALL_E2EE_VOICE_DURATION = null;
        public static final SystemType USER_CALL_E2EE_VOICE_ON_CANCELL = null;
        public static final SystemType USER_CALL_E2EE_VOICE_ON_MISSING = null;
        public static final SystemType USER_CALL_E2EE_VOICE_WHEN_OCCUPY = null;
        public static final SystemType USER_CALL_E2EE_VOICE_WHEN_REFUSED = null;
        public static final SystemType USER_CHANGE_DOC_PERMISSION = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT = null;
        public static final SystemType USER_CHECK_OTHERS_TELEPHONE = null;
        public static final SystemType USER_CLEAR_CIRCLE_ANNOUNCEMENT = null;
        public static final SystemType USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT = null;
        public static final SystemType USER_CREATE_CIRCLE = null;
        public static final SystemType USER_CREATE_CIRCLE_AND_INVITE = null;
        public static final SystemType USER_CREATE_FACE_TO_FACE_CHAT = null;
        public static final SystemType USER_CREATE_TEAM = null;
        public static final SystemType USER_DISMISSED_MEETING_CHAT = null;
        public static final SystemType USER_INVITE_BOT_JOIN = null;
        public static final SystemType USER_INVITE_BOT_JOIN_CIRCLE = null;
        public static final SystemType USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN = null;
        public static final SystemType USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW = null;
        public static final SystemType USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_MEETING = null;
        public static final SystemType USER_JOIN_CHAT_AUTO_MUTE = null;
        public static final SystemType USER_JOIN_CHAT_BY_LINK = null;
        public static final SystemType USER_JOIN_CHAT_BY_LINK_NO_HISTORY = null;
        public static final SystemType USER_JOIN_CHAT_FROM_TEAM = null;
        public static final SystemType USER_JOIN_CHAT_WELCOME_MESSAGE = null;
        public static final SystemType USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = null;
        public static final SystemType USER_JOIN_FACE_TO_FACE_CHAT = null;
        public static final SystemType USER_JOIN_VIA_GROUP_LINK = null;
        public static final SystemType USER_JOIN_VIA_QR_CODE = null;
        public static final SystemType USER_JOIN_VIA_QR_CODE_NO_HISTORY = null;
        public static final SystemType USER_JOIN_VIA_QR_NEW = null;
        public static final SystemType USER_JOIN_VIA_SHARE = null;
        public static final SystemType USER_JOIN_VIA_SHARE_NEW = null;
        public static final SystemType USER_JOIN_VIA_SHARE_NO_HISTORY = null;
        public static final SystemType USER_LEAVE_CIRCLE = null;
        public static final SystemType USER_LOW_VERSION_HINT = null;
        public static final SystemType USER_MODIFY_CIRCLE_AVATAR = null;
        public static final SystemType USER_MODIFY_CIRCLE_DESCRIPTION = null;
        public static final SystemType USER_MODIFY_CIRCLE_NAME = null;
        public static final SystemType USER_MODIFY_CIRCLE_OWNER = null;
        public static final SystemType USER_MODIFY_CIRCLE_SETTINGS = null;
        public static final SystemType USER_MODIFY_EMAIL_SUBJECT = null;
        public static final SystemType USER_MODIFY_GROUP_AVATAR = null;
        public static final SystemType USER_MODIFY_GROUP_DESCRIPTION = null;
        public static final SystemType USER_MODIFY_GROUP_NAME = null;
        public static final SystemType USER_MODIFY_GROUP_SETTINGS = null;
        public static final SystemType USER_MODIFY_THREAD_TOPIC = null;
        public static final SystemType USER_OPEN_ANYONE_POST = null;
        public static final SystemType USER_OPEN_ANYONE_POST_THREAD = null;
        public static final SystemType USER_OPEN_ONLY_ADMIN_POST = null;
        public static final SystemType USER_OPEN_ONLY_ADMIN_POST_THREAD = null;
        public static final SystemType USER_OPEN_ONLY_OWNER_AND_ADMIN_POST = null;
        public static final SystemType USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD = null;
        public static final SystemType USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST = null;
        public static final SystemType USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD = null;
        public static final SystemType USER_QUIT_GROUP = null;
        public static final SystemType USER_QUIT_MEETING_CHAT = null;
        public static final SystemType USER_REMOVE_CIRCLE_DESCRIPTION = null;
        public static final SystemType USER_REMOVE_CIRCLE_MEMBERS = null;
        public static final SystemType USER_REMOVE_GROUP_DESCRIPTION = null;
        public static final SystemType USER_REMOVE_OTHERS = null;
        public static final SystemType USER_REMOVE_OTHERS_FROM_MEETING = null;
        public static final SystemType USER_REMOVE_SEPECIFY_MEMBERS_POST = null;
        public static final SystemType USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD = null;
        public static final SystemType USER_SEPECIFY_MEMBERS_POST = null;
        public static final SystemType USER_SET_CRYPTO_MESSAGE_BURN_LIFE = null;
        public static final SystemType USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS = null;
        public static final SystemType USER_SET_ONLY_CIRCLE_OWNER_CAN_POST = null;
        public static final SystemType USER_SHARE_DOC_FOLDER = null;
        public static final SystemType USER_SHARE_DOC_PERMISSION = null;
        public static final SystemType USER_SPECIFY_MEMBERS_POST_THREAD = null;
        public static final SystemType USER_START_CRYPTO_GROUP_AND_INVITE = null;
        public static final SystemType USER_START_GROUP = null;
        public static final SystemType USER_START_GROUP_AND_INVITE = null;
        public static final SystemType USER_START_MEETING_GROUP_AND_INVITE = null;
        public static final SystemType USER_SYNC_MESSAGE = null;
        public static final SystemType USER_SYNC_MESSAGE_TO_CIRCLE = null;
        public static final SystemType USER_SYNC_MESSAGE_V2 = null;
        public static final SystemType USER_THREAD_CLEAR_TITLE = null;
        public static final SystemType USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT = null;
        public static final SystemType USER_TURN_OFF_GROUP_MAIL = null;
        public static final SystemType USER_TURN_ON_GROUP_MAIL = null;
        public static final SystemType USER_WITHDRAW_CIRCLE_INVITATION = null;
        public static final SystemType VC_CALL_CONNECT_FAIL = null;
        public static final SystemType VC_CALL_DISCONNECT = null;
        public static final SystemType VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_CALL_DURATION = null;
        public static final SystemType VC_CALL_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_CALL_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_CALL_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_CALL_FINISH_NOTICE = null;
        public static final SystemType VC_CALL_HOST_BUSY = null;
        public static final SystemType VC_CALL_HOST_CANCEL = null;
        public static final SystemType VC_CALL_INTERVIEWEE_BUSY = null;
        public static final SystemType VC_CALL_INTERVIEWEE_NOT_ONLINE = null;
        public static final SystemType VC_CALL_INTERVIEWEE_NO_ANSWER = null;
        public static final SystemType VC_CALL_INTERVIEWEE_REFUSE = null;
        public static final SystemType VC_CALL_INTERVIEWER_CANCEL = null;
        public static final SystemType VC_CALL_PARTI_BUSY = null;
        public static final SystemType VC_CALL_PARTI_CANCEL = null;
        public static final SystemType VC_CALL_PARTI_NO_ANSWER = null;
        public static final SystemType VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_ENTERPRISE_PHONE_CREATE = null;
        public static final SystemType VC_MEETING_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_MEETING_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_MEETING_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_MEETING_STARTED = null;
        public static final SystemType VC_VIDEO_CHAT_STARTED = null;
        public static final SystemType VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VOIP_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VOIP_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VOIP_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VOIP_INTERVIEWEE_BUSY = null;
        public static final SystemType VOIP_INTERVIEWEE_NOT_ONLINE = null;
        public static final SystemType VOIP_INTERVIEWEE_NO_ANSWER = null;
        public static final SystemType VOIP_INTERVIEWEE_REFUSE = null;
        public static final SystemType VOIP_INTERVIEWER_CANCEL = null;
        public static final SystemType WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = null;
        public static final SystemType WILL_REACH_CHAT_CHATTER_COUNT_LIMIT = null;
        public static final SystemType WIPE_ANNOUNCEMENT = null;
        public static final SystemType WITHDRAW_ADDED_USER = null;
        private final int value;

        public static SystemType[] values() {
            return (SystemType[]) $VALUES.clone();
        }

        static {
            SystemType r100 = new SystemType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SystemType r101 = new SystemType("USER_MODIFY_GROUP_NAME", 1, 1);
            USER_MODIFY_GROUP_NAME = r101;
            SystemType r102 = new SystemType("USER_MODIFY_GROUP_AVATAR", 2, 2);
            USER_MODIFY_GROUP_AVATAR = r102;
            SystemType r103 = new SystemType("USER_MODIFY_GROUP_DESCRIPTION", 3, 3);
            USER_MODIFY_GROUP_DESCRIPTION = r103;
            SystemType r104 = new SystemType("USER_MODIFY_GROUP_SETTINGS", 4, 4);
            USER_MODIFY_GROUP_SETTINGS = r104;
            SystemType r105 = new SystemType("USER_START_GROUP_AND_INVITE", 5, 5);
            USER_START_GROUP_AND_INVITE = r105;
            SystemType r110 = new SystemType("SYSTEM_WELCOME_USER", 6, 6);
            SYSTEM_WELCOME_USER = r110;
            SystemType r111 = new SystemType("USER_INVITE_OTHERS_JOIN", 7, 7);
            USER_INVITE_OTHERS_JOIN = r111;
            SystemType r112 = new SystemType("USER_QUIT_GROUP", 8, 8);
            USER_QUIT_GROUP = r112;
            SystemType r113 = new SystemType("USER_REMOVE_OTHERS", 9, 9);
            USER_REMOVE_OTHERS = r113;
            SystemType r114 = new SystemType("USER_REMOVE_GROUP_DESCRIPTION", 10, 10);
            USER_REMOVE_GROUP_DESCRIPTION = r114;
            SystemType r115 = new SystemType("USER_CHECK_OTHERS_TELEPHONE", 11, 11);
            USER_CHECK_OTHERS_TELEPHONE = r115;
            SystemType r106 = new SystemType("DERIVE_FROM_P2P_CHAT", 12, 12);
            DERIVE_FROM_P2P_CHAT = r106;
            SystemType r107 = new SystemType("USER_JOIN_VIA_SHARE", 13, 13);
            USER_JOIN_VIA_SHARE = r107;
            SystemType r108 = new SystemType("TRANSFER_GROUP_CHAT_OWNER", 14, 14);
            TRANSFER_GROUP_CHAT_OWNER = r108;
            SystemType r109 = new SystemType("TRANSFER_GROUP_CHAT_OWNER_AND_QUIT", 15, 15);
            TRANSFER_GROUP_CHAT_OWNER_AND_QUIT = r109;
            SystemType r116 = new SystemType("WIPE_ANNOUNCEMENT", 16, 16);
            WIPE_ANNOUNCEMENT = r116;
            SystemType r117 = new SystemType("ADD_EMAIL_MEMBERS", 17, 17);
            ADD_EMAIL_MEMBERS = r117;
            SystemType r118 = new SystemType("REMOVE_EMAIL_MEMBERS", 18, 18);
            REMOVE_EMAIL_MEMBERS = r118;
            SystemType r119 = new SystemType("MODIFY_EMAIL_MEMBERS", 19, 19);
            MODIFY_EMAIL_MEMBERS = r119;
            SystemType r120 = new SystemType("USER_MODIFY_EMAIL_SUBJECT", 20, 20);
            USER_MODIFY_EMAIL_SUBJECT = r120;
            SystemType r121 = new SystemType("USER_SYNC_MESSAGE", 21, 21);
            USER_SYNC_MESSAGE = r121;
            SystemType r122 = new SystemType("USER_MODIFY_THREAD_TOPIC", 22, 22);
            USER_MODIFY_THREAD_TOPIC = r122;
            SystemType r123 = new SystemType("USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT", 23, 23);
            USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT = r123;
            SystemType r124 = new SystemType("USER_START_CRYPTO_GROUP_AND_INVITE", 24, 24);
            USER_START_CRYPTO_GROUP_AND_INVITE = r124;
            SystemType r125 = new SystemType("USER_CALL_E2EE_VOICE_ON_CANCELL", 25, 25);
            USER_CALL_E2EE_VOICE_ON_CANCELL = r125;
            SystemType r126 = new SystemType("USER_CALL_E2EE_VOICE_ON_MISSING", 26, 26);
            USER_CALL_E2EE_VOICE_ON_MISSING = r126;
            SystemType r127 = new SystemType("USER_CALL_E2EE_VOICE_DURATION", 27, 27);
            USER_CALL_E2EE_VOICE_DURATION = r127;
            SystemType r128 = new SystemType("VC_CALL_HOST_CANCEL", 28, 28);
            VC_CALL_HOST_CANCEL = r128;
            SystemType r129 = new SystemType("VC_CALL_PARTI_NO_ANSWER", 29, 29);
            VC_CALL_PARTI_NO_ANSWER = r129;
            SystemType r130 = new SystemType("VC_CALL_PARTI_CANCEL", 30, 30);
            VC_CALL_PARTI_CANCEL = r130;
            SystemType r131 = new SystemType("VC_CALL_HOST_BUSY", 31, 31);
            VC_CALL_HOST_BUSY = r131;
            SystemType r132 = new SystemType("VC_CALL_PARTI_BUSY", 32, 32);
            VC_CALL_PARTI_BUSY = r132;
            SystemType r133 = new SystemType("VC_CALL_FINISH_NOTICE", 33, 33);
            VC_CALL_FINISH_NOTICE = r133;
            SystemType r134 = new SystemType("VC_CALL_DURATION", 34, 34);
            VC_CALL_DURATION = r134;
            SystemType r135 = new SystemType("USER_START_MEETING_GROUP_AND_INVITE", 35, 35);
            USER_START_MEETING_GROUP_AND_INVITE = r135;
            SystemType r136 = new SystemType("USER_INVITE_OTHERS_JOIN_MEETING", 36, 36);
            USER_INVITE_OTHERS_JOIN_MEETING = r136;
            SystemType r137 = new SystemType("USER_QUIT_MEETING_CHAT", 37, 37);
            USER_QUIT_MEETING_CHAT = r137;
            SystemType r138 = new SystemType("USER_DISMISSED_MEETING_CHAT", 38, 38);
            USER_DISMISSED_MEETING_CHAT = r138;
            SystemType r139 = new SystemType("USER_START_GROUP", 39, 39);
            USER_START_GROUP = r139;
            SystemType r140 = new SystemType("USER_REMOVE_OTHERS_FROM_MEETING", 40, 40);
            USER_REMOVE_OTHERS_FROM_MEETING = r140;
            SystemType r141 = new SystemType("USER_ADD_MEETING_CHAT", 41, 41);
            USER_ADD_MEETING_CHAT = r141;
            SystemType r142 = new SystemType("JOIN_DEPARTMENT_GROUP", 42, 42);
            JOIN_DEPARTMENT_GROUP = r142;
            SystemType r143 = new SystemType("BUILD_FRIENDSHIP", 43, 43);
            BUILD_FRIENDSHIP = r143;
            SystemType r144 = new SystemType("NON_FRIENDS_NOTICE", 44, 44);
            NON_FRIENDS_NOTICE = r144;
            SystemType r145 = new SystemType("DECLINE_INVITATION", 45, 45);
            DECLINE_INVITATION = r145;
            SystemType r146 = new SystemType("DECLINE_SPEC_INVITATION", 46, 46);
            DECLINE_SPEC_INVITATION = r146;
            SystemType r147 = new SystemType("USER_JOIN_VIA_QR_CODE", 47, 47);
            USER_JOIN_VIA_QR_CODE = r147;
            SystemType r148 = new SystemType("VC_CALL_CONNECT_FAIL", 48, 48);
            VC_CALL_CONNECT_FAIL = r148;
            SystemType r149 = new SystemType("VC_CALL_DISCONNECT", 49, 49);
            VC_CALL_DISCONNECT = r149;
            SystemType r150 = new SystemType("USER_CALL_E2EE_VOICE_WHEN_REFUSED", 50, 52);
            USER_CALL_E2EE_VOICE_WHEN_REFUSED = r150;
            SystemType r151 = new SystemType("USER_CALL_E2EE_VOICE_WHEN_OCCUPY", 51, 53);
            USER_CALL_E2EE_VOICE_WHEN_OCCUPY = r151;
            SystemType r152 = new SystemType("GRAB_OTHER_HONGBAO", 52, 54);
            GRAB_OTHER_HONGBAO = r152;
            SystemType r153 = new SystemType("OTHER_GRAB_MY_HONGBAO", 53, 55);
            OTHER_GRAB_MY_HONGBAO = r153;
            SystemType r154 = new SystemType("LAST_HONGBAO_IS_GRABBED", 54, 56);
            LAST_HONGBAO_IS_GRABBED = r154;
            SystemType r155 = new SystemType("SEND_HONGBAO_MESSAGE_FAILED", 55, 57);
            SEND_HONGBAO_MESSAGE_FAILED = r155;
            SystemType r156 = new SystemType("USER_SYNC_MESSAGE_V2", 56, 58);
            USER_SYNC_MESSAGE_V2 = r156;
            SystemType r157 = new SystemType("USER_SHARE_DOC_PERMISSION", 57, 59);
            USER_SHARE_DOC_PERMISSION = r157;
            SystemType r158 = new SystemType("USER_CHANGE_DOC_PERMISSION", 58, 60);
            USER_CHANGE_DOC_PERMISSION = r158;
            SystemType r159 = new SystemType("USER_SHARE_DOC_FOLDER", 59, 61);
            USER_SHARE_DOC_FOLDER = r159;
            SystemType r160 = new SystemType("USER_OPEN_ONLY_ADMIN_POST", 60, 62);
            USER_OPEN_ONLY_ADMIN_POST = r160;
            SystemType r161 = new SystemType("USER_SEPECIFY_MEMBERS_POST", 61, 63);
            USER_SEPECIFY_MEMBERS_POST = r161;
            SystemType r162 = new SystemType("USER_LOW_VERSION_HINT", 62, 64);
            USER_LOW_VERSION_HINT = r162;
            SystemType r163 = new SystemType("USER_THREAD_CLEAR_TITLE", 63, 65);
            USER_THREAD_CLEAR_TITLE = r163;
            SystemType r164 = new SystemType("USER_OPEN_ANYONE_POST", 64, 66);
            USER_OPEN_ANYONE_POST = r164;
            SystemType r165 = new SystemType("CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT", 65, 67);
            CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT = r165;
            SystemType r166 = new SystemType("CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS", 66, 68);
            CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS = r166;
            SystemType r167 = new SystemType("CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING", 67, 69);
            CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING = r167;
            SystemType r168 = new SystemType("USER_SET_CRYPTO_MESSAGE_BURN_LIFE", 68, 70);
            USER_SET_CRYPTO_MESSAGE_BURN_LIFE = r168;
            SystemType r169 = new SystemType("USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT", 69, 71);
            USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT = r169;
            SystemType r170 = new SystemType("CRYPTO_LOW_VERSION_HINT", 70, 72);
            CRYPTO_LOW_VERSION_HINT = r170;
            SystemType r171 = new SystemType("INVITE_CHAT_MEMBER_2_OUT_CHAT", 71, 73);
            INVITE_CHAT_MEMBER_2_OUT_CHAT = r171;
            SystemType r172 = new SystemType("CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER", 72, 74);
            CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER = r172;
            SystemType r173 = new SystemType("AUTO_TRANSLATE_GUIDANCE", 73, 75);
            AUTO_TRANSLATE_GUIDANCE = r173;
            SystemType r174 = new SystemType("WITHDRAW_ADDED_USER", 74, 76);
            WITHDRAW_ADDED_USER = r174;
            SystemType r175 = new SystemType("SAIPAN_REMIND_ONCALL_REPLY", 75, 77);
            SAIPAN_REMIND_ONCALL_REPLY = r175;
            SystemType r176 = new SystemType("SAIPAN_REMIND_ONCALL_DONE", 76, 78);
            SAIPAN_REMIND_ONCALL_DONE = r176;
            SystemType r177 = new SystemType("SAIPAN_REMIND_ONCALL_AUTO_DONE", 77, 79);
            SAIPAN_REMIND_ONCALL_AUTO_DONE = r177;
            SystemType r178 = new SystemType("SAIPAN_ADD_ONCALL", 78, 80);
            SAIPAN_ADD_ONCALL = r178;
            SystemType r179 = new SystemType("VC_MEETING_STARTED", 79, 83);
            VC_MEETING_STARTED = r179;
            SystemType r180 = new SystemType("USER_OPEN_ONLY_ADMIN_POST_THREAD", 80, 84);
            USER_OPEN_ONLY_ADMIN_POST_THREAD = r180;
            SystemType r181 = new SystemType("USER_SPECIFY_MEMBERS_POST_THREAD", 81, 85);
            USER_SPECIFY_MEMBERS_POST_THREAD = r181;
            SystemType r182 = new SystemType("USER_OPEN_ANYONE_POST_THREAD", 82, 86);
            USER_OPEN_ANYONE_POST_THREAD = r182;
            SystemType r183 = new SystemType("VC_MEETING_ENDED_OVER_ONE_HOUR", 83, 87);
            VC_MEETING_ENDED_OVER_ONE_HOUR = r183;
            SystemType r184 = new SystemType("INVITE_AT_CHATTERS", 84, 88);
            INVITE_AT_CHATTERS = r184;
            SystemType r185 = new SystemType("VC_MEETING_ENDED_LESS_ONE_HOUR", 85, 89);
            VC_MEETING_ENDED_LESS_ONE_HOUR = r185;
            SystemType r186 = new SystemType("VC_MEETING_ENDED_LESS_ONE_MIN", 86, 90);
            VC_MEETING_ENDED_LESS_ONE_MIN = r186;
            SystemType r187 = new SystemType("VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR", 87, 91);
            VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR = r187;
            SystemType r188 = new SystemType("VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR", 88, 92);
            VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR = r188;
            SystemType r189 = new SystemType("VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN", 89, 93);
            VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN = r189;
            SystemType r190 = new SystemType("VC_VIDEO_CHAT_STARTED", 90, 94);
            VC_VIDEO_CHAT_STARTED = r190;
            SystemType r191 = new SystemType("VC_CALL_ENDED_OVER_ONE_HOUR", 91, 95);
            VC_CALL_ENDED_OVER_ONE_HOUR = r191;
            SystemType r192 = new SystemType("VC_CALL_ENDED_LESS_ONE_HOUR", 92, 96);
            VC_CALL_ENDED_LESS_ONE_HOUR = r192;
            SystemType r193 = new SystemType("VC_CALL_ENDED_LESS_ONE_MIN", 93, 97);
            VC_CALL_ENDED_LESS_ONE_MIN = r193;
            SystemType r194 = new SystemType("VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR", 94, 98);
            VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR = r194;
            SystemType r195 = new SystemType("VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR", 95, 99);
            VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR = r195;
            SystemType r196 = new SystemType("VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN", 96, 100);
            VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN = r196;
            SystemType r197 = new SystemType("VC_CALL_INTERVIEWEE_NO_ANSWER", 97, 101);
            VC_CALL_INTERVIEWEE_NO_ANSWER = r197;
            SystemType r198 = new SystemType("VC_CALL_INTERVIEWEE_REFUSE", 98, 102);
            VC_CALL_INTERVIEWEE_REFUSE = r198;
            SystemType r199 = new SystemType("VC_CALL_INTERVIEWER_CANCEL", 99, 103);
            VC_CALL_INTERVIEWER_CANCEL = r199;
            SystemType r200 = new SystemType("VC_CALL_INTERVIEWEE_BUSY", 100, 104);
            VC_CALL_INTERVIEWEE_BUSY = r200;
            SystemType r201 = new SystemType("VOIP_ENDED_OVER_ONE_HOUR", 101, 105);
            VOIP_ENDED_OVER_ONE_HOUR = r201;
            SystemType r202 = new SystemType("VOIP_ENDED_LESS_ONE_HOUR", 102, 106);
            VOIP_ENDED_LESS_ONE_HOUR = r202;
            SystemType r203 = new SystemType("VOIP_ENDED_LESS_ONE_MIN", 103, 107);
            VOIP_ENDED_LESS_ONE_MIN = r203;
            SystemType r204 = new SystemType("VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR", 104, 108);
            VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR = r204;
            SystemType r205 = new SystemType("VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR", 105, 109);
            VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR = r205;
            SystemType r206 = new SystemType("VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN", 106, 110);
            VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN = r206;
            SystemType r207 = new SystemType("VOIP_INTERVIEWEE_NO_ANSWER", 107, 111);
            VOIP_INTERVIEWEE_NO_ANSWER = r207;
            SystemType r208 = new SystemType("VOIP_INTERVIEWEE_REFUSE", 108, 112);
            VOIP_INTERVIEWEE_REFUSE = r208;
            SystemType r209 = new SystemType("VOIP_INTERVIEWER_CANCEL", 109, 113);
            VOIP_INTERVIEWER_CANCEL = r209;
            SystemType r210 = new SystemType("VOIP_INTERVIEWEE_BUSY", 110, 114);
            VOIP_INTERVIEWEE_BUSY = r210;
            SystemType r211 = new SystemType("SAIPAN_SELECT_CARD_CONTENT", 111, 115);
            SAIPAN_SELECT_CARD_CONTENT = r211;
            SystemType r212 = new SystemType("SAIPAN_USER_QUEUEING", 112, 116);
            SAIPAN_USER_QUEUEING = r212;
            SystemType r213 = new SystemType("SAIPAN_NOTIFY_AGENT_QUEUEING", 113, 117);
            SAIPAN_NOTIFY_AGENT_QUEUEING = r213;
            SystemType r214 = new SystemType("SAIPAN_RESERVED_3", 114, 118);
            SAIPAN_RESERVED_3 = r214;
            SystemType r215 = new SystemType("SAIPAN_RESERVED_4", 115, 119);
            SAIPAN_RESERVED_4 = r215;
            SystemType r216 = new SystemType("SAIPAN_RESERVED_5", 116, 120);
            SAIPAN_RESERVED_5 = r216;
            SystemType r217 = new SystemType("CANCEL_EMERGENCY_CALL", 117, 121);
            CANCEL_EMERGENCY_CALL = r217;
            SystemType r218 = new SystemType("HANGUP_EMERGENCY_CALL", 118, 122);
            HANGUP_EMERGENCY_CALL = r218;
            SystemType r219 = new SystemType("START_EMERGENCY_CALL", 119, 123);
            START_EMERGENCY_CALL = r219;
            SystemType r220 = new SystemType("MEETING_TRANSFER_TO_CHAT", 120, 124);
            MEETING_TRANSFER_TO_CHAT = r220;
            SystemType r221 = new SystemType("MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL", 121, 125);
            MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL = r221;
            SystemType r222 = new SystemType("VC_CALL_INTERVIEWEE_NOT_ONLINE", 122, 131);
            VC_CALL_INTERVIEWEE_NOT_ONLINE = r222;
            SystemType r223 = new SystemType("VOIP_INTERVIEWEE_NOT_ONLINE", 123, 132);
            VOIP_INTERVIEWEE_NOT_ONLINE = r223;
            SystemType r224 = new SystemType("USER_JOIN_CHAT_AUTO_MUTE", 124, 138);
            USER_JOIN_CHAT_AUTO_MUTE = r224;
            SystemType r225 = new SystemType("EMERGENCY_CALL_NOTANSWER", 125, 139);
            EMERGENCY_CALL_NOTANSWER = r225;
            SystemType r226 = new SystemType("INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD", 126, 140);
            INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD = r226;
            SystemType r227 = new SystemType("INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD", 127, 141);
            INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD = r227;
            SystemType r228 = new SystemType("CHAT_ROOM_START", 128, 143);
            CHAT_ROOM_START = r228;
            SystemType r229 = new SystemType("USER_TURN_ON_GROUP_MAIL", 129, 148);
            USER_TURN_ON_GROUP_MAIL = r229;
            SystemType r230 = new SystemType("USER_TURN_OFF_GROUP_MAIL", 130, 149);
            USER_TURN_OFF_GROUP_MAIL = r230;
            SystemType r231 = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER", 131, 150);
            USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER = r231;
            SystemType r232 = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS", 132, 151);
            USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS = r232;
            SystemType r233 = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT", 133, 152);
            USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT = r233;
            SystemType r234 = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE", 134, 153);
            USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE = r234;
            SystemType r235 = new SystemType("USER_JOIN_VIA_GROUP_LINK", 135, 154);
            USER_JOIN_VIA_GROUP_LINK = r235;
            SystemType r236 = new SystemType("CHAT_ROOM_END", 136, 155);
            CHAT_ROOM_END = r236;
            SystemType r237 = new SystemType("CHAT_ROOM_START_V2", 137, 156);
            CHAT_ROOM_START_V2 = r237;
            SystemType r238 = new SystemType("SYSTEM_EPHEMERAL_NOTIFY", 138, 157);
            SYSTEM_EPHEMERAL_NOTIFY = r238;
            SystemType r239 = new SystemType("BUILD_ONEWAY_RELATION", 139, 158);
            BUILD_ONEWAY_RELATION = r239;
            SystemType r240 = new SystemType("INVITE_FRIENDS_SUCCESS", 140, 159);
            INVITE_FRIENDS_SUCCESS = r240;
            SystemType r241 = new SystemType("CREATE_P2P_SOURCE", 141, 160);
            CREATE_P2P_SOURCE = r241;
            SystemType r242 = new SystemType("SEND_MESSAGE_COLLABORATION_AUTH_FAILED", 142, 161);
            SEND_MESSAGE_COLLABORATION_AUTH_FAILED = r242;
            SystemType r243 = new SystemType("NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY", 143, 162);
            NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY = r243;
            SystemType r244 = new SystemType("NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT", 144, 163);
            NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT = r244;
            SystemType r245 = new SystemType("USER_INVITE_BOT_JOIN", 145, 169);
            USER_INVITE_BOT_JOIN = r245;
            SystemType r246 = new SystemType("DOC_TEMPLATE_GROUP_SHARE", 146, 170);
            DOC_TEMPLATE_GROUP_SHARE = r246;
            SystemType r247 = new SystemType("SHEET_TEMPLATE_GROUP_SHARE", 147, 171);
            SHEET_TEMPLATE_GROUP_SHARE = r247;
            SystemType r248 = new SystemType("MIND_NOTE_TEMPLATE_GROUP_SHARE", 148, 172);
            MIND_NOTE_TEMPLATE_GROUP_SHARE = r248;
            SystemType r249 = new SystemType("CantChatUserPrivacySettings", 149, 175);
            CantChatUserPrivacySettings = r249;
            SystemType r250 = new SystemType("CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT", 150, 185);
            CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT = r250;
            SystemType r251 = new SystemType("MENTIONED_PERSON_NOT_IN_CIRCLE", 151, 186);
            MENTIONED_PERSON_NOT_IN_CIRCLE = r251;
            SystemType r252 = new SystemType("INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE", 152, 187);
            INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE = r252;
            SystemType r253 = new SystemType("CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS", 153, 188);
            CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS = r253;
            SystemType r254 = new SystemType("CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS", 154, 189);
            CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS = r254;
            SystemType r255 = new SystemType("JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD", 155, 190);
            JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD = r255;
            SystemType r256 = new SystemType("CIRCLE_WELCOME_NEW_MEMBERS", 156, 191);
            CIRCLE_WELCOME_NEW_MEMBERS = r256;
            SystemType r257 = new SystemType("TRANSFER_CIRCLE_OWNER", 157, 192);
            TRANSFER_CIRCLE_OWNER = r257;
            SystemType r258 = new SystemType("TRANSFER_CIRCLE_OWNER_AND_LEAVE", 158, 193);
            TRANSFER_CIRCLE_OWNER_AND_LEAVE = r258;
            SystemType r259 = new SystemType("CIRCLE_USER_CHANGE_DOC_PERMISSION", 159, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
            CIRCLE_USER_CHANGE_DOC_PERMISSION = r259;
            SystemType r260 = new SystemType("USER_INVITE_BOT_JOIN_CIRCLE", 160, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO);
            USER_INVITE_BOT_JOIN_CIRCLE = r260;
            SystemType r261 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE", 161, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE);
            USER_INVITE_OTHERS_JOIN_CIRCLE = r261;
            SystemType r262 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK", 162, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = r262;
            SystemType r263 = new SystemType("CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED", 163, 198);
            CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED = r263;
            SystemType r264 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE", 164, 199);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = r264;
            SystemType r265 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD", 165, 200);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = r265;
            SystemType r266 = new SystemType("USER_MODIFY_CIRCLE_AVATAR", 166, 201);
            USER_MODIFY_CIRCLE_AVATAR = r266;
            SystemType r267 = new SystemType("USER_MODIFY_CIRCLE_DESCRIPTION", 167, 202);
            USER_MODIFY_CIRCLE_DESCRIPTION = r267;
            SystemType r268 = new SystemType("USER_MODIFY_CIRCLE_NAME", 168, 203);
            USER_MODIFY_CIRCLE_NAME = r268;
            SystemType r269 = new SystemType("USER_MODIFY_CIRCLE_OWNER", 169, 204);
            USER_MODIFY_CIRCLE_OWNER = r269;
            SystemType r270 = new SystemType("USER_MODIFY_CIRCLE_SETTINGS", 170, 205);
            USER_MODIFY_CIRCLE_SETTINGS = r270;
            SystemType r271 = new SystemType("USER_SET_ONLY_CIRCLE_OWNER_CAN_POST", 171, 206);
            USER_SET_ONLY_CIRCLE_OWNER_CAN_POST = r271;
            SystemType r272 = new SystemType("USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS", 172, 207);
            USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS = r272;
            SystemType r273 = new SystemType("USER_LEAVE_CIRCLE", 173, 208);
            USER_LEAVE_CIRCLE = r273;
            SystemType r274 = new SystemType("USER_REMOVE_CIRCLE_DESCRIPTION", 174, 209);
            USER_REMOVE_CIRCLE_DESCRIPTION = r274;
            SystemType r275 = new SystemType("USER_REMOVE_CIRCLE_MEMBERS", 175, 210);
            USER_REMOVE_CIRCLE_MEMBERS = r275;
            SystemType r276 = new SystemType("USER_CREATE_CIRCLE", 176, 211);
            USER_CREATE_CIRCLE = r276;
            SystemType r277 = new SystemType("USER_CREATE_CIRCLE_AND_INVITE", 177, 212);
            USER_CREATE_CIRCLE_AND_INVITE = r277;
            SystemType r278 = new SystemType("USER_SYNC_MESSAGE_TO_CIRCLE", 178, 213);
            USER_SYNC_MESSAGE_TO_CIRCLE = r278;
            SystemType r279 = new SystemType("USER_CLEAR_CIRCLE_ANNOUNCEMENT", 179, 214);
            USER_CLEAR_CIRCLE_ANNOUNCEMENT = r279;
            SystemType r280 = new SystemType("USER_WITHDRAW_CIRCLE_INVITATION", 180, 215);
            USER_WITHDRAW_CIRCLE_INVITATION = r280;
            SystemType r281 = new SystemType("CIRCLE_ANONYMOUS_ON", 181, 216);
            CIRCLE_ANONYMOUS_ON = r281;
            SystemType r282 = new SystemType("CIRCLE_ANONYMOUS_OFF", 182, 217);
            CIRCLE_ANONYMOUS_OFF = r282;
            SystemType r283 = new SystemType("Lark_IM_CreateGroup_UserAndGroup_OwnerInvite", 183, 225);
            Lark_IM_CreateGroup_UserAndGroup_OwnerInvite = r283;
            SystemType r284 = new SystemType("Lark_IM_CreateGroup_UserAndGroup_MemberInvite", 184, 226);
            Lark_IM_CreateGroup_UserAndGroup_MemberInvite = r284;
            SystemType r285 = new SystemType("Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite", 185, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL);
            Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite = r285;
            SystemType r286 = new SystemType("Lark_IM_CreateGroup_UserAndDepartment_MemberInivite", 186, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2);
            Lark_IM_CreateGroup_UserAndDepartment_MemberInivite = r286;
            SystemType r287 = new SystemType("Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite", 187, 229);
            Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite = r287;
            SystemType r288 = new SystemType("Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite", 188, 230);
            Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite = r288;
            SystemType r289 = new SystemType("Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite", 189, 231);
            Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite = r289;
            SystemType r290 = new SystemType("Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite", 190, VideoRef.VALUE_VIDEO_REF_CATEGORY);
            Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite = r290;
            SystemType r291 = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter", 191, 233);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter = r291;
            SystemType r292 = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter", 192, 234);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter = r292;
            SystemType r293 = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee", 193, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee = r293;
            SystemType r294 = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee", MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, VideoRef.VALUE_VIDEO_REF_CONST_DEPTH);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee = r294;
            SystemType r295 = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers = r295;
            SystemType r296 = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers", MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 238);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers = r296;
            SystemType r297 = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter", MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter = r297;
            SystemType r298 = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter", 198, 240);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter = r298;
            SystemType r299 = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee", 199, 241);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee = r299;
            SystemType r300 = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee", 200, 242);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee = r300;
            SystemType r301 = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers", 201, 243);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers = r301;
            SystemType r302 = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers", 202, 244);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers = r302;
            SystemType r303 = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter", 203, 245);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter = r303;
            SystemType r304 = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter", 204, 246);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter = r304;
            SystemType r305 = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee", 205, 247);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee = r305;
            SystemType r306 = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee", 206, 248);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee = r306;
            SystemType r307 = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers", 207, 249);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers = r307;
            SystemType r308 = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers", 208, 250);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers = r308;
            SystemType r309 = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter", 209, 251);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter = r309;
            SystemType r310 = new SystemType("Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter", 210, 252);
            Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter = r310;
            SystemType r311 = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee", 211, 253);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee = r311;
            SystemType r312 = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee", 212, 254);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee = r312;
            SystemType r313 = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers", 213, 255);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers = r313;
            SystemType r314 = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers", 214, 256);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers = r314;
            SystemType r315 = new SystemType("Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam", 215, 257);
            Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam = r315;
            SystemType r316 = new SystemType("Lark_IM_Server_WelcomeTo_Text", 216, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME);
            Lark_IM_Server_WelcomeTo_Text = r316;
            SystemType r317 = new SystemType("INVITE_CHAT_MEMBER_2_CHAT", 217, 300);
            INVITE_CHAT_MEMBER_2_CHAT = r317;
            SystemType r318 = new SystemType("WILL_REACH_CHAT_CHATTER_COUNT_LIMIT", 218, 301);
            WILL_REACH_CHAT_CHATTER_COUNT_LIMIT = r318;
            SystemType r319 = new SystemType("ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT", 219, 302);
            ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT = r319;
            SystemType r320 = new SystemType("USER_CREATE_FACE_TO_FACE_CHAT", 220, 303);
            USER_CREATE_FACE_TO_FACE_CHAT = r320;
            SystemType r321 = new SystemType("USER_JOIN_FACE_TO_FACE_CHAT", 221, 304);
            USER_JOIN_FACE_TO_FACE_CHAT = r321;
            SystemType r322 = new SystemType("WELCOME_USER_JOIN_FACE_TO_FACE_CHAT", 222, 305);
            WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = r322;
            SystemType r323 = new SystemType("USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT", 223, 306);
            USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT = r323;
            SystemType r324 = new SystemType("USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN", 224, 307);
            USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN = r324;
            SystemType r325 = new SystemType("CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER", 225, 308);
            CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER = r325;
            SystemType r326 = new SystemType("USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST", 226, 309);
            USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST = r326;
            SystemType r327 = new SystemType("USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD", VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 310);
            USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD = r327;
            SystemType r328 = new SystemType("USER_REMOVE_SEPECIFY_MEMBERS_POST", VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2, 311);
            USER_REMOVE_SEPECIFY_MEMBERS_POST = r328;
            SystemType r329 = new SystemType("USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD", 229, 312);
            USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD = r329;
            SystemType r330 = new SystemType("ADD_MEMBER_TO_ADMIN_LIST", 230, 313);
            ADD_MEMBER_TO_ADMIN_LIST = r330;
            SystemType r331 = new SystemType("REMOVE_MEMBER_FROM_ADMIN_LIST", 231, 314);
            REMOVE_MEMBER_FROM_ADMIN_LIST = r331;
            SystemType r332 = new SystemType("USER_OPEN_ONLY_OWNER_AND_ADMIN_POST", VideoRef.VALUE_VIDEO_REF_CATEGORY, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT);
            USER_OPEN_ONLY_OWNER_AND_ADMIN_POST = r332;
            SystemType r333 = new SystemType("USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD", 233, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME);
            USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD = r333;
            SystemType r334 = new SystemType("ADMIN_OPEN_ANYONE_POST", 234, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME);
            ADMIN_OPEN_ANYONE_POST = r334;
            SystemType r335 = new SystemType("ADMIN_OPEN_ANYONE_POST_THREAD", VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, 320);
            ADMIN_OPEN_ANYONE_POST_THREAD = r335;
            SystemType r336 = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN", VideoRef.VALUE_VIDEO_REF_CONST_DEPTH, 322);
            USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN = r336;
            SystemType r337 = new SystemType("GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON", VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, 323);
            GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON = r337;
            SystemType r338 = new SystemType("GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF", 238, 324);
            GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF = r338;
            SystemType r339 = new SystemType("GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES", VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 325);
            GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES = r339;
            SystemType r340 = new SystemType("CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY", 240, 326);
            CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY = r340;
            SystemType r341 = new SystemType("JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY", 241, 327);
            JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY = r341;
            SystemType r342 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY", 242, 328);
            USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY = r342;
            SystemType r343 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY", 243, 329);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY = r343;
            SystemType r344 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY", 244, 330);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY = r344;
            SystemType r345 = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY", 245, 331);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY = r345;
            SystemType r346 = new SystemType("USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW", 246, 338);
            USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW = r346;
            SystemType r347 = new SystemType("USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY", 247, 332);
            USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY = r347;
            SystemType r348 = new SystemType("USER_JOIN_VIA_QR_NEW", 248, 339);
            USER_JOIN_VIA_QR_NEW = r348;
            SystemType r349 = new SystemType("USER_JOIN_VIA_QR_CODE_NO_HISTORY", 249, 333);
            USER_JOIN_VIA_QR_CODE_NO_HISTORY = r349;
            SystemType r350 = new SystemType("USER_JOIN_CHAT_WELCOME_MESSAGE", 250, 334);
            USER_JOIN_CHAT_WELCOME_MESSAGE = r350;
            SystemType r351 = new SystemType("USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY", 251, 335);
            USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = r351;
            SystemType r352 = new SystemType("USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE", 252, 336);
            USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE = r352;
            SystemType r353 = new SystemType("USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY", 253, 337);
            USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = r353;
            SystemType r354 = new SystemType("USER_JOIN_VIA_SHARE_NEW", 254, 340);
            USER_JOIN_VIA_SHARE_NEW = r354;
            SystemType r355 = new SystemType("USER_JOIN_VIA_SHARE_NO_HISTORY", 255, 341);
            USER_JOIN_VIA_SHARE_NO_HISTORY = r355;
            SystemType r356 = new SystemType("USER_JOIN_CHAT_BY_LINK", 256, 342);
            USER_JOIN_CHAT_BY_LINK = r356;
            SystemType r357 = new SystemType("USER_JOIN_CHAT_BY_LINK_NO_HISTORY", 257, 343);
            USER_JOIN_CHAT_BY_LINK_NO_HISTORY = r357;
            SystemType r358 = new SystemType("HELP_DESK_USER_JOIN_CHAT", 258, 344);
            HELP_DESK_USER_JOIN_CHAT = r358;
            SystemType r359 = new SystemType("HELP_DESK_USER_JOIN_CHAT_NO_HISTORY", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 345);
            HELP_DESK_USER_JOIN_CHAT_NO_HISTORY = r359;
            SystemType r360 = new SystemType("UPGRADE_SUPER_CHAT", 260, 348);
            UPGRADE_SUPER_CHAT = r360;
            SystemType r361 = new SystemType("CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON", 261, 346);
            CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON = r361;
            SystemType r362 = new SystemType("CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF", 262, 347);
            CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF = r362;
            SystemType r363 = new SystemType("AUTO_OPEN_TYPING_TRANSLATE", MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD);
            AUTO_OPEN_TYPING_TRANSLATE = r363;
            SystemType r364 = new SystemType("ONLY_ADMIN_CAN_MANAGE_CHAT_TAB", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME);
            ONLY_ADMIN_CAN_MANAGE_CHAT_TAB = r364;
            SystemType r365 = new SystemType("ALL_MEMBERS_CAN_MANAGE_CHAT_TAB", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME);
            ALL_MEMBERS_CAN_MANAGE_CHAT_TAB = r365;
            SystemType r366 = new SystemType("ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL);
            ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets = r366;
            SystemType r367 = new SystemType("ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER);
            ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets = r367;
            SystemType r368 = new SystemType("ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500);
            ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1 = r368;
            SystemType r369 = new SystemType("ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500);
            ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1 = r369;
            SystemType r370 = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL", 270, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = r370;
            SystemType r371 = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = r371;
            SystemType r372 = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = r372;
            SystemType r373 = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD", 273, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = r373;
            SystemType r374 = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL", 274, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = r374;
            SystemType r375 = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = r375;
            SystemType r376 = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD", MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = r376;
            SystemType r377 = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD", MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = r377;
            SystemType r378 = new SystemType("EXTERNAL_COORDINATE_CTL", MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 401);
            EXTERNAL_COORDINATE_CTL = r378;
            SystemType r379 = new SystemType("TARGET_EXTERNAL_COORDINATE_CTL", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 402);
            TARGET_EXTERNAL_COORDINATE_CTL = r379;
            SystemType r380 = new SystemType("CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE", 280, 403);
            CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE = r380;
            SystemType r381 = new SystemType("CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE", MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 404);
            CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE = r381;
            SystemType r382 = new SystemType("BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE", MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 405);
            BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE = r382;
            SystemType r383 = new SystemType("MANUAL_OPEN_TYPING_TRANSLATE", MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, BDAbstractUpload.KeyIsSDKMaxRetryTimeout);
            MANUAL_OPEN_TYPING_TRANSLATE = r383;
            SystemType r384 = new SystemType("AUTO_OPEN_TYPING_TRANSLATE_V1", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, BDAbstractUpload.KeyIsXQuicLibAvailable);
            AUTO_OPEN_TYPING_TRANSLATE_V1 = r384;
            SystemType r385 = new SystemType("CREATE_TEAM_AND_INVITE_MEMBERS", MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 501);
            CREATE_TEAM_AND_INVITE_MEMBERS = r385;
            SystemType r386 = new SystemType("UPDATE_CHAT_TO_TEAM", MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, 502);
            UPDATE_CHAT_TO_TEAM = r386;
            SystemType r387 = new SystemType("INVITE_MEMBERS_JOIN_TEAM", MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 503);
            INVITE_MEMBERS_JOIN_TEAM = r387;
            SystemType r388 = new SystemType("MEMBERS_JOIN_TEAM_FAIL", 288, 504);
            MEMBERS_JOIN_TEAM_FAIL = r388;
            SystemType r389 = new SystemType("KICK_MEMBERS_OUT_TEAM", MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 505);
            KICK_MEMBERS_OUT_TEAM = r389;
            SystemType r390 = new SystemType("MEMBER_LEAVE_TEAM", 290, 506);
            MEMBER_LEAVE_TEAM = r390;
            SystemType r391 = new SystemType("TRANSFER_TEAM_OWNER", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, 507);
            TRANSFER_TEAM_OWNER = r391;
            SystemType r392 = new SystemType("MODIFY_TEAM_NAME", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 508);
            MODIFY_TEAM_NAME = r392;
            SystemType r393 = new SystemType("ENABLE_TEAM_CREATE_CHAT_PERMISSION", MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 509);
            ENABLE_TEAM_CREATE_CHAT_PERMISSION = r393;
            SystemType r394 = new SystemType("CLOSE_TEAM_CREATE_CHAT_PERMISSION", MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 510);
            CLOSE_TEAM_CREATE_CHAT_PERMISSION = r394;
            SystemType r395 = new SystemType("ENABLE_TEAM_ADD_MEMBERS_PERMISSION", MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 511);
            ENABLE_TEAM_ADD_MEMBERS_PERMISSION = r395;
            SystemType r396 = new SystemType("CLOSE_TEAM_ADD_MEMBERS_PERMISSION", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 512);
            CLOSE_TEAM_ADD_MEMBERS_PERMISSION = r396;
            SystemType r397 = new SystemType("DISSOLVE_TEAM_AND_UNBIND_CHAT", MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 513);
            DISSOLVE_TEAM_AND_UNBIND_CHAT = r397;
            SystemType r398 = new SystemType("CREATE_TEAM_CHAT", MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 514);
            CREATE_TEAM_CHAT = r398;
            SystemType r399 = new SystemType("BIND_CHAT_INTO_TEAM", 299, 515);
            BIND_CHAT_INTO_TEAM = r399;
            SystemType r400 = new SystemType("UNBIND_CHAT_WITH_TEAM", 300, 516);
            UNBIND_CHAT_WITH_TEAM = r400;
            SystemType r401 = new SystemType("MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL", 301, 517);
            MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL = r401;
            SystemType r402 = new SystemType("MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES", 302, 518);
            MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES = r402;
            SystemType r403 = new SystemType("MEMBERS_JOIN_TEAM_CHAT_FAIL", 303, 519);
            MEMBERS_JOIN_TEAM_CHAT_FAIL = r403;
            SystemType r404 = new SystemType("MEMBERS_LEAVE_AND_TRANSFER", 304, 520);
            MEMBERS_LEAVE_AND_TRANSFER = r404;
            SystemType r405 = new SystemType("USER_CREATE_TEAM", 305, 521);
            USER_CREATE_TEAM = r405;
            SystemType r406 = new SystemType("CHECK_USER_PHONE_NUMBER", 306, 522);
            CHECK_USER_PHONE_NUMBER = r406;
            SystemType r407 = new SystemType("CHECK_USER_PHONE_USER_IN_WHITELIST", 307, 523);
            CHECK_USER_PHONE_USER_IN_WHITELIST = r407;
            SystemType r408 = new SystemType("CantBuzzEmptyPhoneNumber", 308, 524);
            CantBuzzEmptyPhoneNumber = r408;
            SystemType r409 = new SystemType("CantBuzzEmptyName", 309, 525);
            CantBuzzEmptyName = r409;
            SystemType r410 = new SystemType("BuzzLimit", 310, 526);
            BuzzLimit = r410;
            SystemType r411 = new SystemType("BuzzSystemError", 311, TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER);
            BuzzSystemError = r411;
            SystemType r412 = new SystemType("BuzzTimeOut", 312, TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER);
            BuzzTimeOut = r412;
            SystemType r413 = new SystemType("CantBuzzMembers", 313, TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER);
            CantBuzzMembers = r413;
            SystemType r414 = new SystemType("BuzzNotAnswer", 314, 530);
            BuzzNotAnswer = r414;
            SystemType r415 = new SystemType("MultiItemSystemContent", 315, 531);
            MultiItemSystemContent = r415;
            SystemType r416 = new SystemType("VC_ENTERPRISE_PHONE_CREATE", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 532);
            VC_ENTERPRISE_PHONE_CREATE = r416;
            SystemType r417 = new SystemType("MODIFY_TEAM_AVATAR", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, 533);
            MODIFY_TEAM_AVATAR = r417;
            SystemType r418 = new SystemType("MODIFY_TEAM_DESCRIPTION", MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 534);
            MODIFY_TEAM_DESCRIPTION = r418;
            SystemType r419 = new SystemType("DELETE_TEAM_DESCRIPTION", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 535);
            DELETE_TEAM_DESCRIPTION = r419;
            SystemType r420 = new SystemType("CREATE_TEAM_CHAT_V2_MANAGER", 320, 541);
            CREATE_TEAM_CHAT_V2_MANAGER = r420;
            SystemType r421 = new SystemType("BIND_CHAT_INTO_TEAM_MANAGER", 321, 542);
            BIND_CHAT_INTO_TEAM_MANAGER = r421;
            SystemType r422 = new SystemType("USER_JOIN_CHAT_FROM_TEAM", 322, 543);
            USER_JOIN_CHAT_FROM_TEAM = r422;
            SystemType r423 = new SystemType("TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM", 323, 544);
            TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM = r423;
            SystemType r424 = new SystemType("TEAM_CHAT_TURN_OPEN_MESSAGE", 324, 545);
            TEAM_CHAT_TURN_OPEN_MESSAGE = r424;
            SystemType r425 = new SystemType("SIMPLIFY_OTHER_GRAB_MY_HONGBAO", 325, 615);
            SIMPLIFY_OTHER_GRAB_MY_HONGBAO = r425;
            SystemType r426 = new SystemType("SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM", 326, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS);
            SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM = r426;
            SystemType r427 = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN", 327, 616);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN = r427;
            SystemType r428 = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY", 328, 617);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = r428;
            SystemType r429 = new SystemType("SIMPLIFY_SYSTEM_WELCOME_USER", 329, 618);
            SIMPLIFY_SYSTEM_WELCOME_USER = r429;
            SystemType r430 = new SystemType("SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE", 330, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID);
            SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE = r430;
            SystemType r431 = new SystemType("SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY", 331, 620);
            SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = r431;
            SystemType r432 = new SystemType("SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS", 332, 621);
            SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS = r432;
            SystemType r433 = new SystemType("SIMPLIFY_USER_JOIN_VIA_SHARE", 333, 622);
            SIMPLIFY_USER_JOIN_VIA_SHARE = r433;
            SystemType r434 = new SystemType("SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY", 334, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME);
            SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY = r434;
            SystemType r435 = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD", 335, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = r435;
            SystemType r436 = new SystemType("SIMPLIFY_USER_JOIN_VIA_QR_CODE", 336, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME);
            SIMPLIFY_USER_JOIN_VIA_QR_CODE = r436;
            SystemType r437 = new SystemType("SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY", 337, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME);
            SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY = r437;
            SystemType r438 = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE", 338, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = r438;
            SystemType r439 = new SystemType("SIMPLIFY_USER_JOIN_VIA_GROUP_LINK", 339, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME);
            SIMPLIFY_USER_JOIN_VIA_GROUP_LINK = r439;
            SystemType r440 = new SystemType("SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY", 340, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME);
            SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY = r440;
            SystemType r441 = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK", 341, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = r441;
            SystemType r442 = new SystemType("SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT", 342, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME);
            SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = r442;
            SystemType r443 = new SystemType("SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM", 343, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_OPENED_TIME);
            SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM = r443;
            SystemType r444 = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE", 344, 634);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE = r444;
            SystemType r445 = new SystemType("HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED", 345, 702);
            HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED = r445;
            SystemType r446 = new SystemType("MyAI_NewTopicTip", 346, 1100);
            MyAI_NewTopicTip = r446;
            SystemType r447 = new SystemType("MyAI_SceneTopicDynamicTip", 347, 1110);
            MyAI_SceneTopicDynamicTip = r447;
            SystemType r448 = new SystemType("Lark_IM_BotCustomization", 348, 1203);
            Lark_IM_BotCustomization = r448;
            SystemType r449 = new SystemType("MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS", 349, 1301);
            MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS = r449;
            SystemType r450 = new SystemType("CHAT_USER_LARGE_CHAT_AUTO_MUTE", TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG, 1500);
            CHAT_USER_LARGE_CHAT_AUTO_MUTE = r450;
            SystemType r451 = new SystemType("CHAT_USER_BOT_AUTO_MUTE", 351, 1501);
            CHAT_USER_BOT_AUTO_MUTE = r451;
            SystemType r452 = new SystemType("CHAT_USER_BOT_AUTO_MUTE_S", 352, 1502);
            CHAT_USER_BOT_AUTO_MUTE_S = r452;
            SystemType r453 = new SystemType("CHAT_USER_P2P_BOT_AUTO_MUTE", 353, 1503);
            CHAT_USER_P2P_BOT_AUTO_MUTE = r453;
            SystemType r454 = new SystemType("DOUBAO_SHOW_NEW_CONTACT", 354, 1504);
            DOUBAO_SHOW_NEW_CONTACT = r454;
            SystemType r455 = new SystemType("DOUBAO_SHOW_READ_TIP", 355, 1505);
            DOUBAO_SHOW_READ_TIP = r455;
            SystemType r456 = new SystemType("DOUBAO_SHOW_JOIN_CHAT", 356, 1506);
            DOUBAO_SHOW_JOIN_CHAT = r456;
            SystemType r457 = new SystemType("DOUBAO_SHOW_JOIN_CHAT_STRANGER", 357, 1507);
            DOUBAO_SHOW_JOIN_CHAT_STRANGER = r457;
            SystemType r458 = new SystemType("DOUBAO_SHOW_NEW_CONTACT_NO_GREETING", 358, 1510);
            DOUBAO_SHOW_NEW_CONTACT_NO_GREETING = r458;
            SystemType r459 = new SystemType("DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS", 359, 1511);
            DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS = r459;
            SystemType r460 = new SystemType("LOCAL_MENTION_BOTS_NOT_IN_CHAT", 360, 10000);
            LOCAL_MENTION_BOTS_NOT_IN_CHAT = r460;
            $VALUES = new SystemType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250, r251, r252, r253, r254, r255, r256, r257, r258, r259, r260, r261, r262, r263, r264, r265, r266, r267, r268, r269, r270, r271, r272, r273, r274, r275, r276, r277, r278, r279, r280, r281, r282, r283, r284, r285, r286, r287, r288, r289, r290, r291, r292, r293, r294, r295, r296, r297, r298, r299, r300, r301, r302, r303, r304, r305, r306, r307, r308, r309, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r330, r331, r332, r333, r334, r335, r336, r337, r338, r339, r340, r341, r342, r343, r344, r345, r346, r347, r348, r349, r350, r351, r352, r353, r354, r355, r356, r357, r358, r359, r360, r361, r362, r363, r364, r365, r366, r367, r368, r369, r370, r371, r372, r373, r374, r375, r376, r377, r378, r379, r380, r381, r382, r383, r384, r385, r386, r387, r388, r389, r390, r391, r392, r393, r394, r395, r396, r397, r398, r399, r400, r401, r402, r403, r404, r405, r406, r407, r408, r409, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r430, r431, r432, r433, r434, r435, r436, r437, r438, r439, r440, r441, r442, r443, r444, r445, r446, r447, r448, r449, r450, r451, r452, r453, r454, r455, r456, r457, r458, r459, r460};
            ADAPTER = ProtoAdapter.newEnumAdapter(SystemType.class);
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SystemType fromValue(int r100) {
            if (r100 == 0) goto L753;
            if (r100 == 1) goto L751;
            if (r100 == 2) goto L749;
            if (r100 == 3) goto L747;
            if (r100 == 4) goto L745;
            if (r100 == 5) goto L743;
            if (r100 == 6) goto L741;
            if (r100 == 7) goto L739;
            if (r100 == 131) goto L737;
            if (r100 == 132) goto L735;
            switch(r100) {
                case 7: goto L739;
                case 8: goto L733;
                case 9: goto L731;
                case 10: goto L729;
                case 11: goto L727;
                case 12: goto L725;
                case 13: goto L723;
                case 14: goto L721;
                case 15: goto L719;
                case 16: goto L717;
                case 17: goto L715;
                case 18: goto L713;
                case 19: goto L711;
                case 20: goto L709;
                case 21: goto L707;
                case 22: goto L705;
                case 23: goto L703;
                case 24: goto L701;
                case 25: goto L699;
                case 26: goto L697;
                case 27: goto L695;
                case 28: goto L693;
                case 29: goto L691;
                case 30: goto L689;
                case 31: goto L687;
                case 32: goto L685;
                case 33: goto L683;
                case 34: goto L681;
                case 35: goto L679;
                case 36: goto L677;
                case 37: goto L675;
                case 38: goto L673;
                case 39: goto L671;
                case 40: goto L669;
                case 41: goto L667;
                case 42: goto L665;
                case 43: goto L663;
                case 44: goto L661;
                case 45: goto L659;
                case 46: goto L657;
                case 47: goto L655;
                case 48: goto L653;
                case 49: goto L651;
                case 143: goto L649;
                case 175: goto L647;
                case 268: goto L645;
                case 317: goto L643;
                case 318: goto L641;
                case 319: goto L639;
                case 320: goto L637;
                case 322: goto L635;
                case 323: goto L633;
                case 324: goto L631;
                case 325: goto L629;
                case 326: goto L627;
                case 327: goto L625;
                case 328: goto L623;
                case 329: goto L621;
                case 330: goto L619;
                case 331: goto L617;
                case 332: goto L615;
                case 333: goto L613;
                case 334: goto L611;
                case 335: goto L609;
                case 336: goto L607;
                case 337: goto L605;
                case 338: goto L603;
                case 339: goto L601;
                case 340: goto L599;
                case 341: goto L597;
                case 342: goto L595;
                case 343: goto L593;
                case 344: goto L591;
                case 345: goto L589;
                case 346: goto L587;
                case 347: goto L585;
                case 348: goto L583;
                case 363: goto L581;
                case 364: goto L579;
                case 365: goto L577;
                case 379: goto L575;
                case 380: goto L573;
                case 385: goto L571;
                case 386: goto L569;
                case 392: goto L567;
                case 393: goto L565;
                case 394: goto L563;
                case 395: goto L561;
                case 396: goto L559;
                case 397: goto L557;
                case 398: goto L555;
                case 399: goto L553;
                case 401: goto L551;
                case 402: goto L549;
                case 403: goto L547;
                case 404: goto L545;
                case 405: goto L543;
                case 428: goto L541;
                case 429: goto L539;
                case 501: goto L537;
                case 502: goto L535;
                case 503: goto L533;
                case 504: goto L531;
                case 505: goto L529;
                case 506: goto L527;
                case 507: goto L525;
                case 508: goto L523;
                case 509: goto L521;
                case 510: goto L519;
                case 511: goto L517;
                case 512: goto L515;
                case 513: goto L513;
                case 514: goto L511;
                case 515: goto L509;
                case 516: goto L507;
                case 517: goto L505;
                case 518: goto L503;
                case 519: goto L501;
                case 520: goto L499;
                case 521: goto L497;
                case 522: goto L495;
                case 523: goto L493;
                case 524: goto L491;
                case 525: goto L489;
                case 526: goto L487;
                case 527: goto L485;
                case 528: goto L483;
                case 529: goto L481;
                case 530: goto L479;
                case 531: goto L477;
                case 532: goto L475;
                case 533: goto L473;
                case 534: goto L471;
                case 535: goto L469;
                case 541: goto L467;
                case 542: goto L465;
                case 543: goto L463;
                case 544: goto L461;
                case 545: goto L459;
                case 615: goto L457;
                case 616: goto L455;
                case 617: goto L453;
                case 618: goto L451;
                case 619: goto L449;
                case 620: goto L447;
                case 621: goto L445;
                case 622: goto L443;
                case 623: goto L441;
                case 624: goto L439;
                case 625: goto L437;
                case 626: goto L435;
                case 627: goto L433;
                case 628: goto L431;
                case 629: goto L429;
                case 630: goto L427;
                case 631: goto L425;
                case 632: goto L423;
                case 633: goto L421;
                case 634: goto L419;
                case 702: goto L417;
                case 1100: goto L415;
                case 1110: goto L413;
                case 1203: goto L411;
                case 1301: goto L409;
                case 1500: goto L407;
                case 1501: goto L405;
                case 1502: goto L403;
                case 1503: goto L401;
                case 1504: goto L399;
                case 1505: goto L397;
                case 1506: goto L395;
                case 1507: goto L393;
                case 1510: goto L391;
                case 1511: goto L389;
                case 10000: goto L387;
                default: goto L22;
            };
        L22:
            switch(r100) {
                case 52: goto L385;
                case 53: goto L383;
                case 54: goto L381;
                case 55: goto L379;
                case 56: goto L377;
                case 57: goto L375;
                case 58: goto L373;
                case 59: goto L371;
                case 60: goto L369;
                case 61: goto L367;
                case 62: goto L365;
                case 63: goto L363;
                case 64: goto L361;
                case 65: goto L359;
                case 66: goto L357;
                case 67: goto L355;
                case 68: goto L353;
                case 69: goto L351;
                case 70: goto L349;
                case 71: goto L347;
                case 72: goto L345;
                case 73: goto L343;
                case 74: goto L341;
                case 75: goto L339;
                case 76: goto L337;
                case 77: goto L335;
                case 78: goto L333;
                case 79: goto L331;
                case 80: goto L329;
                default: goto L23;
            };
        L23:
            switch(r100) {
                case 83: goto L327;
                case 84: goto L325;
                case 85: goto L323;
                case 86: goto L321;
                case 87: goto L319;
                case 88: goto L317;
                case 89: goto L315;
                case 90: goto L313;
                case 91: goto L311;
                case 92: goto L309;
                case 93: goto L307;
                case 94: goto L305;
                case 95: goto L303;
                case 96: goto L301;
                case 97: goto L299;
                case 98: goto L297;
                case 99: goto L295;
                case 100: goto L293;
                case 101: goto L291;
                case 102: goto L289;
                case 103: goto L287;
                case 104: goto L285;
                case 105: goto L283;
                case 106: goto L281;
                case 107: goto L279;
                case 108: goto L277;
                case 109: goto L275;
                case 110: goto L273;
                case 111: goto L271;
                case 112: goto L269;
                case 113: goto L267;
                case 114: goto L265;
                case 115: goto L263;
                case 116: goto L261;
                case 117: goto L259;
                case 118: goto L257;
                case 119: goto L255;
                case 120: goto L253;
                case 121: goto L251;
                case 122: goto L249;
                case 123: goto L247;
                case 124: goto L245;
                case 125: goto L243;
                default: goto L24;
            };
        L24:
            switch(r100) {
                case 138: goto L241;
                case 139: goto L239;
                case 140: goto L237;
                case 141: goto L235;
                default: goto L25;
            };
        L25:
            switch(r100) {
                case 148: goto L233;
                case 149: goto L231;
                case 150: goto L229;
                case 151: goto L227;
                case 152: goto L225;
                case 153: goto L223;
                case 154: goto L221;
                case 155: goto L219;
                case 156: goto L217;
                case 157: goto L215;
                case 158: goto L213;
                case 159: goto L211;
                case 160: goto L209;
                case 161: goto L207;
                case 162: goto L205;
                case 163: goto L203;
                default: goto L26;
            };
        L26:
            switch(r100) {
                case 169: goto L201;
                case 170: goto L199;
                case 171: goto L197;
                case 172: goto L195;
                default: goto L27;
            };
        L27:
            switch(r100) {
                case 185: goto L193;
                case 186: goto L191;
                case 187: goto L189;
                case 188: goto L187;
                case 189: goto L185;
                case 190: goto L183;
                case 191: goto L181;
                case 192: goto L179;
                case 193: goto L177;
                case 194: goto L175;
                case 195: goto L173;
                case 196: goto L171;
                case 197: goto L169;
                case 198: goto L167;
                case 199: goto L165;
                case 200: goto L163;
                case 201: goto L161;
                case 202: goto L159;
                case 203: goto L157;
                case 204: goto L155;
                case 205: goto L153;
                case 206: goto L151;
                case 207: goto L149;
                case 208: goto L147;
                case 209: goto L145;
                case 210: goto L143;
                case 211: goto L141;
                case 212: goto L139;
                case 213: goto L137;
                case 214: goto L135;
                case 215: goto L133;
                case 216: goto L131;
                case 217: goto L129;
                default: goto L28;
            };
        L28:
            switch(r100) {
                case 225: goto L127;
                case 226: goto L125;
                case 227: goto L123;
                case 228: goto L121;
                case 229: goto L119;
                case 230: goto L117;
                case 231: goto L115;
                case 232: goto L113;
                case 233: goto L111;
                case 234: goto L109;
                case 235: goto L107;
                case 236: goto L105;
                case 237: goto L103;
                case 238: goto L101;
                case 239: goto L99;
                case 240: goto L97;
                case 241: goto L95;
                case 242: goto L93;
                case 243: goto L91;
                case 244: goto L89;
                case 245: goto L87;
                case 246: goto L85;
                case 247: goto L83;
                case 248: goto L81;
                case 249: goto L79;
                case 250: goto L77;
                case 251: goto L75;
                case 252: goto L73;
                case 253: goto L71;
                case 254: goto L69;
                case 255: goto L67;
                case 256: goto L65;
                case 257: goto L63;
                default: goto L29;
            };
        L29:
            switch(r100) {
                case 300: goto L61;
                case 301: goto L59;
                case 302: goto L57;
                case 303: goto L55;
                case 304: goto L53;
                case 305: goto L51;
                case 306: goto L49;
                case 307: goto L47;
                case 308: goto L45;
                case 309: goto L43;
                case 310: goto L41;
                case 311: goto L39;
                case 312: goto L37;
                case 313: goto L35;
                case 314: goto L33;
                default: goto L30;
            };
        L30:
            return null;
        L33:
            return REMOVE_MEMBER_FROM_ADMIN_LIST;
        L35:
            return ADD_MEMBER_TO_ADMIN_LIST;
        L37:
            return USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD;
        L39:
            return USER_REMOVE_SEPECIFY_MEMBERS_POST;
        L41:
            return USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD;
        L43:
            return USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST;
        L45:
            return CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER;
        L47:
            return USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN;
        L49:
            return USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT;
        L51:
            return WELCOME_USER_JOIN_FACE_TO_FACE_CHAT;
        L53:
            return USER_JOIN_FACE_TO_FACE_CHAT;
        L55:
            return USER_CREATE_FACE_TO_FACE_CHAT;
        L57:
            return ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT;
        L59:
            return WILL_REACH_CHAT_CHATTER_COUNT_LIMIT;
        L61:
            return INVITE_CHAT_MEMBER_2_CHAT;
        L63:
            return Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam;
        L65:
            return Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers;
        L67:
            return Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers;
        L69:
            return Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee;
        L71:
            return Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee;
        L73:
            return Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter;
        L75:
            return Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter;
        L77:
            return Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers;
        L79:
            return Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers;
        L81:
            return Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee;
        L83:
            return Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee;
        L85:
            return Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter;
        L87:
            return Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter;
        L89:
            return Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers;
        L91:
            return Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers;
        L93:
            return Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee;
        L95:
            return Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee;
        L97:
            return Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter;
        L99:
            return Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter;
        L101:
            return Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers;
        L103:
            return Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers;
        L105:
            return Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee;
        L107:
            return Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee;
        L109:
            return Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter;
        L111:
            return Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter;
        L113:
            return Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite;
        L115:
            return Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite;
        L117:
            return Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite;
        L119:
            return Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite;
        L121:
            return Lark_IM_CreateGroup_UserAndDepartment_MemberInivite;
        L123:
            return Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite;
        L125:
            return Lark_IM_CreateGroup_UserAndGroup_MemberInvite;
        L127:
            return Lark_IM_CreateGroup_UserAndGroup_OwnerInvite;
        L129:
            return CIRCLE_ANONYMOUS_OFF;
        L131:
            return CIRCLE_ANONYMOUS_ON;
        L133:
            return USER_WITHDRAW_CIRCLE_INVITATION;
        L135:
            return USER_CLEAR_CIRCLE_ANNOUNCEMENT;
        L137:
            return USER_SYNC_MESSAGE_TO_CIRCLE;
        L139:
            return USER_CREATE_CIRCLE_AND_INVITE;
        L141:
            return USER_CREATE_CIRCLE;
        L143:
            return USER_REMOVE_CIRCLE_MEMBERS;
        L145:
            return USER_REMOVE_CIRCLE_DESCRIPTION;
        L147:
            return USER_LEAVE_CIRCLE;
        L149:
            return USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS;
        L151:
            return USER_SET_ONLY_CIRCLE_OWNER_CAN_POST;
        L153:
            return USER_MODIFY_CIRCLE_SETTINGS;
        L155:
            return USER_MODIFY_CIRCLE_OWNER;
        L157:
            return USER_MODIFY_CIRCLE_NAME;
        L159:
            return USER_MODIFY_CIRCLE_DESCRIPTION;
        L161:
            return USER_MODIFY_CIRCLE_AVATAR;
        L163:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD;
        L165:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE;
        L167:
            return CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED;
        L169:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK;
        L171:
            return USER_INVITE_OTHERS_JOIN_CIRCLE;
        L173:
            return USER_INVITE_BOT_JOIN_CIRCLE;
        L175:
            return CIRCLE_USER_CHANGE_DOC_PERMISSION;
        L177:
            return TRANSFER_CIRCLE_OWNER_AND_LEAVE;
        L179:
            return TRANSFER_CIRCLE_OWNER;
        L181:
            return CIRCLE_WELCOME_NEW_MEMBERS;
        L183:
            return JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD;
        L185:
            return CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS;
        L187:
            return CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS;
        L189:
            return INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE;
        L191:
            return MENTIONED_PERSON_NOT_IN_CIRCLE;
        L193:
            return CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT;
        L195:
            return MIND_NOTE_TEMPLATE_GROUP_SHARE;
        L197:
            return SHEET_TEMPLATE_GROUP_SHARE;
        L199:
            return DOC_TEMPLATE_GROUP_SHARE;
        L201:
            return USER_INVITE_BOT_JOIN;
        L203:
            return NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT;
        L205:
            return NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY;
        L207:
            return SEND_MESSAGE_COLLABORATION_AUTH_FAILED;
        L209:
            return CREATE_P2P_SOURCE;
        L211:
            return INVITE_FRIENDS_SUCCESS;
        L213:
            return BUILD_ONEWAY_RELATION;
        L215:
            return SYSTEM_EPHEMERAL_NOTIFY;
        L217:
            return CHAT_ROOM_START_V2;
        L219:
            return CHAT_ROOM_END;
        L221:
            return USER_JOIN_VIA_GROUP_LINK;
        L223:
            return USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE;
        L225:
            return USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT;
        L227:
            return USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS;
        L229:
            return USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER;
        L231:
            return USER_TURN_OFF_GROUP_MAIL;
        L233:
            return USER_TURN_ON_GROUP_MAIL;
        L235:
            return INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD;
        L237:
            return INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD;
        L239:
            return EMERGENCY_CALL_NOTANSWER;
        L241:
            return USER_JOIN_CHAT_AUTO_MUTE;
        L243:
            return MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL;
        L245:
            return MEETING_TRANSFER_TO_CHAT;
        L247:
            return START_EMERGENCY_CALL;
        L249:
            return HANGUP_EMERGENCY_CALL;
        L251:
            return CANCEL_EMERGENCY_CALL;
        L253:
            return SAIPAN_RESERVED_5;
        L255:
            return SAIPAN_RESERVED_4;
        L257:
            return SAIPAN_RESERVED_3;
        L259:
            return SAIPAN_NOTIFY_AGENT_QUEUEING;
        L261:
            return SAIPAN_USER_QUEUEING;
        L263:
            return SAIPAN_SELECT_CARD_CONTENT;
        L265:
            return VOIP_INTERVIEWEE_BUSY;
        L267:
            return VOIP_INTERVIEWER_CANCEL;
        L269:
            return VOIP_INTERVIEWEE_REFUSE;
        L271:
            return VOIP_INTERVIEWEE_NO_ANSWER;
        L273:
            return VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN;
        L275:
            return VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR;
        L277:
            return VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR;
        L279:
            return VOIP_ENDED_LESS_ONE_MIN;
        L281:
            return VOIP_ENDED_LESS_ONE_HOUR;
        L283:
            return VOIP_ENDED_OVER_ONE_HOUR;
        L285:
            return VC_CALL_INTERVIEWEE_BUSY;
        L287:
            return VC_CALL_INTERVIEWER_CANCEL;
        L289:
            return VC_CALL_INTERVIEWEE_REFUSE;
        L291:
            return VC_CALL_INTERVIEWEE_NO_ANSWER;
        L293:
            return VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN;
        L295:
            return VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR;
        L297:
            return VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR;
        L299:
            return VC_CALL_ENDED_LESS_ONE_MIN;
        L301:
            return VC_CALL_ENDED_LESS_ONE_HOUR;
        L303:
            return VC_CALL_ENDED_OVER_ONE_HOUR;
        L305:
            return VC_VIDEO_CHAT_STARTED;
        L307:
            return VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN;
        L309:
            return VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR;
        L311:
            return VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR;
        L313:
            return VC_MEETING_ENDED_LESS_ONE_MIN;
        L315:
            return VC_MEETING_ENDED_LESS_ONE_HOUR;
        L317:
            return INVITE_AT_CHATTERS;
        L319:
            return VC_MEETING_ENDED_OVER_ONE_HOUR;
        L321:
            return USER_OPEN_ANYONE_POST_THREAD;
        L323:
            return USER_SPECIFY_MEMBERS_POST_THREAD;
        L325:
            return USER_OPEN_ONLY_ADMIN_POST_THREAD;
        L327:
            return VC_MEETING_STARTED;
        L329:
            return SAIPAN_ADD_ONCALL;
        L331:
            return SAIPAN_REMIND_ONCALL_AUTO_DONE;
        L333:
            return SAIPAN_REMIND_ONCALL_DONE;
        L335:
            return SAIPAN_REMIND_ONCALL_REPLY;
        L337:
            return WITHDRAW_ADDED_USER;
        L339:
            return AUTO_TRANSLATE_GUIDANCE;
        L341:
            return CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER;
        L343:
            return INVITE_CHAT_MEMBER_2_OUT_CHAT;
        L345:
            return CRYPTO_LOW_VERSION_HINT;
        L347:
            return USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT;
        L349:
            return USER_SET_CRYPTO_MESSAGE_BURN_LIFE;
        L351:
            return CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING;
        L353:
            return CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS;
        L355:
            return CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT;
        L357:
            return USER_OPEN_ANYONE_POST;
        L359:
            return USER_THREAD_CLEAR_TITLE;
        L361:
            return USER_LOW_VERSION_HINT;
        L363:
            return USER_SEPECIFY_MEMBERS_POST;
        L365:
            return USER_OPEN_ONLY_ADMIN_POST;
        L367:
            return USER_SHARE_DOC_FOLDER;
        L369:
            return USER_CHANGE_DOC_PERMISSION;
        L371:
            return USER_SHARE_DOC_PERMISSION;
        L373:
            return USER_SYNC_MESSAGE_V2;
        L375:
            return SEND_HONGBAO_MESSAGE_FAILED;
        L377:
            return LAST_HONGBAO_IS_GRABBED;
        L379:
            return OTHER_GRAB_MY_HONGBAO;
        L381:
            return GRAB_OTHER_HONGBAO;
        L383:
            return USER_CALL_E2EE_VOICE_WHEN_OCCUPY;
        L385:
            return USER_CALL_E2EE_VOICE_WHEN_REFUSED;
        L387:
            return LOCAL_MENTION_BOTS_NOT_IN_CHAT;
        L389:
            return DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS;
        L391:
            return DOUBAO_SHOW_NEW_CONTACT_NO_GREETING;
        L393:
            return DOUBAO_SHOW_JOIN_CHAT_STRANGER;
        L395:
            return DOUBAO_SHOW_JOIN_CHAT;
        L397:
            return DOUBAO_SHOW_READ_TIP;
        L399:
            return DOUBAO_SHOW_NEW_CONTACT;
        L401:
            return CHAT_USER_P2P_BOT_AUTO_MUTE;
        L403:
            return CHAT_USER_BOT_AUTO_MUTE_S;
        L405:
            return CHAT_USER_BOT_AUTO_MUTE;
        L407:
            return CHAT_USER_LARGE_CHAT_AUTO_MUTE;
        L409:
            return MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS;
        L411:
            return Lark_IM_BotCustomization;
        L413:
            return MyAI_SceneTopicDynamicTip;
        L415:
            return MyAI_NewTopicTip;
        L417:
            return HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED;
        L419:
            return SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE;
        L421:
            return SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM;
        L423:
            return SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM;
        L425:
            return SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT;
        L427:
            return SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK;
        L429:
            return SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY;
        L431:
            return SIMPLIFY_USER_JOIN_VIA_GROUP_LINK;
        L433:
            return SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE;
        L435:
            return SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY;
        L437:
            return SIMPLIFY_USER_JOIN_VIA_QR_CODE;
        L439:
            return SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD;
        L441:
            return SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY;
        L443:
            return SIMPLIFY_USER_JOIN_VIA_SHARE;
        L445:
            return SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS;
        L447:
            return SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY;
        L449:
            return SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE;
        L451:
            return SIMPLIFY_SYSTEM_WELCOME_USER;
        L453:
            return SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY;
        L455:
            return SIMPLIFY_USER_INVITE_OTHERS_JOIN;
        L457:
            return SIMPLIFY_OTHER_GRAB_MY_HONGBAO;
        L459:
            return TEAM_CHAT_TURN_OPEN_MESSAGE;
        L461:
            return TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM;
        L463:
            return USER_JOIN_CHAT_FROM_TEAM;
        L465:
            return BIND_CHAT_INTO_TEAM_MANAGER;
        L467:
            return CREATE_TEAM_CHAT_V2_MANAGER;
        L469:
            return DELETE_TEAM_DESCRIPTION;
        L471:
            return MODIFY_TEAM_DESCRIPTION;
        L473:
            return MODIFY_TEAM_AVATAR;
        L475:
            return VC_ENTERPRISE_PHONE_CREATE;
        L477:
            return MultiItemSystemContent;
        L479:
            return BuzzNotAnswer;
        L481:
            return CantBuzzMembers;
        L483:
            return BuzzTimeOut;
        L485:
            return BuzzSystemError;
        L487:
            return BuzzLimit;
        L489:
            return CantBuzzEmptyName;
        L491:
            return CantBuzzEmptyPhoneNumber;
        L493:
            return CHECK_USER_PHONE_USER_IN_WHITELIST;
        L495:
            return CHECK_USER_PHONE_NUMBER;
        L497:
            return USER_CREATE_TEAM;
        L499:
            return MEMBERS_LEAVE_AND_TRANSFER;
        L501:
            return MEMBERS_JOIN_TEAM_CHAT_FAIL;
        L503:
            return MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES;
        L505:
            return MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL;
        L507:
            return UNBIND_CHAT_WITH_TEAM;
        L509:
            return BIND_CHAT_INTO_TEAM;
        L511:
            return CREATE_TEAM_CHAT;
        L513:
            return DISSOLVE_TEAM_AND_UNBIND_CHAT;
        L515:
            return CLOSE_TEAM_ADD_MEMBERS_PERMISSION;
        L517:
            return ENABLE_TEAM_ADD_MEMBERS_PERMISSION;
        L519:
            return CLOSE_TEAM_CREATE_CHAT_PERMISSION;
        L521:
            return ENABLE_TEAM_CREATE_CHAT_PERMISSION;
        L523:
            return MODIFY_TEAM_NAME;
        L525:
            return TRANSFER_TEAM_OWNER;
        L527:
            return MEMBER_LEAVE_TEAM;
        L529:
            return KICK_MEMBERS_OUT_TEAM;
        L531:
            return MEMBERS_JOIN_TEAM_FAIL;
        L533:
            return INVITE_MEMBERS_JOIN_TEAM;
        L535:
            return UPDATE_CHAT_TO_TEAM;
        L537:
            return CREATE_TEAM_AND_INVITE_MEMBERS;
        L539:
            return AUTO_OPEN_TYPING_TRANSLATE_V1;
        L541:
            return MANUAL_OPEN_TYPING_TRANSLATE;
        L543:
            return BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE;
        L545:
            return CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE;
        L547:
            return CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE;
        L549:
            return TARGET_EXTERNAL_COORDINATE_CTL;
        L551:
            return EXTERNAL_COORDINATE_CTL;
        L553:
            return CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD;
        L555:
            return ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD;
        L557:
            return CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL;
        L559:
            return ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL;
        L561:
            return CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD;
        L563:
            return ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD;
        L565:
            return CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL;
        L567:
            return ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL;
        L569:
            return ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1;
        L571:
            return ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1;
        L573:
            return ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets;
        L575:
            return ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets;
        L577:
            return ALL_MEMBERS_CAN_MANAGE_CHAT_TAB;
        L579:
            return ONLY_ADMIN_CAN_MANAGE_CHAT_TAB;
        L581:
            return AUTO_OPEN_TYPING_TRANSLATE;
        L583:
            return UPGRADE_SUPER_CHAT;
        L585:
            return CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF;
        L587:
            return CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON;
        L589:
            return HELP_DESK_USER_JOIN_CHAT_NO_HISTORY;
        L591:
            return HELP_DESK_USER_JOIN_CHAT;
        L593:
            return USER_JOIN_CHAT_BY_LINK_NO_HISTORY;
        L595:
            return USER_JOIN_CHAT_BY_LINK;
        L597:
            return USER_JOIN_VIA_SHARE_NO_HISTORY;
        L599:
            return USER_JOIN_VIA_SHARE_NEW;
        L601:
            return USER_JOIN_VIA_QR_NEW;
        L603:
            return USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW;
        L605:
            return USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY;
        L607:
            return USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE;
        L609:
            return USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY;
        L611:
            return USER_JOIN_CHAT_WELCOME_MESSAGE;
        L613:
            return USER_JOIN_VIA_QR_CODE_NO_HISTORY;
        L615:
            return USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY;
        L617:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY;
        L619:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY;
        L621:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY;
        L623:
            return USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY;
        L625:
            return JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY;
        L627:
            return CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY;
        L629:
            return GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES;
        L631:
            return GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF;
        L633:
            return GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON;
        L635:
            return USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN;
        L637:
            return ADMIN_OPEN_ANYONE_POST_THREAD;
        L639:
            return ADMIN_OPEN_ANYONE_POST;
        L641:
            return USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD;
        L643:
            return USER_OPEN_ONLY_OWNER_AND_ADMIN_POST;
        L645:
            return Lark_IM_Server_WelcomeTo_Text;
        L647:
            return CantChatUserPrivacySettings;
        L649:
            return CHAT_ROOM_START;
        L651:
            return VC_CALL_DISCONNECT;
        L653:
            return VC_CALL_CONNECT_FAIL;
        L655:
            return USER_JOIN_VIA_QR_CODE;
        L657:
            return DECLINE_SPEC_INVITATION;
        L659:
            return DECLINE_INVITATION;
        L661:
            return NON_FRIENDS_NOTICE;
        L663:
            return BUILD_FRIENDSHIP;
        L665:
            return JOIN_DEPARTMENT_GROUP;
        L667:
            return USER_ADD_MEETING_CHAT;
        L669:
            return USER_REMOVE_OTHERS_FROM_MEETING;
        L671:
            return USER_START_GROUP;
        L673:
            return USER_DISMISSED_MEETING_CHAT;
        L675:
            return USER_QUIT_MEETING_CHAT;
        L677:
            return USER_INVITE_OTHERS_JOIN_MEETING;
        L679:
            return USER_START_MEETING_GROUP_AND_INVITE;
        L681:
            return VC_CALL_DURATION;
        L683:
            return VC_CALL_FINISH_NOTICE;
        L685:
            return VC_CALL_PARTI_BUSY;
        L687:
            return VC_CALL_HOST_BUSY;
        L689:
            return VC_CALL_PARTI_CANCEL;
        L691:
            return VC_CALL_PARTI_NO_ANSWER;
        L693:
            return VC_CALL_HOST_CANCEL;
        L695:
            return USER_CALL_E2EE_VOICE_DURATION;
        L697:
            return USER_CALL_E2EE_VOICE_ON_MISSING;
        L699:
            return USER_CALL_E2EE_VOICE_ON_CANCELL;
        L701:
            return USER_START_CRYPTO_GROUP_AND_INVITE;
        L703:
            return USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT;
        L705:
            return USER_MODIFY_THREAD_TOPIC;
        L707:
            return USER_SYNC_MESSAGE;
        L709:
            return USER_MODIFY_EMAIL_SUBJECT;
        L711:
            return MODIFY_EMAIL_MEMBERS;
        L713:
            return REMOVE_EMAIL_MEMBERS;
        L715:
            return ADD_EMAIL_MEMBERS;
        L717:
            return WIPE_ANNOUNCEMENT;
        L719:
            return TRANSFER_GROUP_CHAT_OWNER_AND_QUIT;
        L721:
            return TRANSFER_GROUP_CHAT_OWNER;
        L723:
            return USER_JOIN_VIA_SHARE;
        L725:
            return DERIVE_FROM_P2P_CHAT;
        L727:
            return USER_CHECK_OTHERS_TELEPHONE;
        L729:
            return USER_REMOVE_GROUP_DESCRIPTION;
        L731:
            return USER_REMOVE_OTHERS;
        L733:
            return USER_QUIT_GROUP;
        L735:
            return VOIP_INTERVIEWEE_NOT_ONLINE;
        L737:
            return VC_CALL_INTERVIEWEE_NOT_ONLINE;
        L739:
            return USER_INVITE_OTHERS_JOIN;
        L741:
            return SYSTEM_WELCOME_USER;
        L743:
            return USER_START_GROUP_AND_INVITE;
        L745:
            return USER_MODIFY_GROUP_SETTINGS;
        L747:
            return USER_MODIFY_GROUP_DESCRIPTION;
        L749:
            return USER_MODIFY_GROUP_AVATAR;
        L751:
            return USER_MODIFY_GROUP_NAME;
        L753:
            return UNKNOWN;
        }

        public static SystemType valueOf(String r100) {
            return (SystemType) a.a(SystemType.class, r100);
        }

        private SystemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TransmitInfo extends com.squareup.wire.Message<TransmitInfo, Builder> {
        public static final ProtoAdapter<TransmitInfo> ADAPTER = null;
        public static final String DEFAULT_ORIGIN_MERGE_FORWARD_ID = "";
        private static final long serialVersionUID = 0;
        public final String origin_merge_forward_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<TransmitInfo, Builder> {
            public String origin_merge_forward_id;

            @Override // com.squareup.wire.Message.Builder
            public TransmitInfo build() {
                return new TransmitInfo(this.origin_merge_forward_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder origin_merge_forward_id(String r100) {
                this.origin_merge_forward_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TransmitInfo extends ProtoAdapter<TransmitInfo> {
            public ProtoAdapter_TransmitInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TransmitInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TransmitInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.origin_merge_forward_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.origin_merge_forward_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TransmitInfo r100) {
                String r101 = r100.origin_merge_forward_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TransmitInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TransmitInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TransmitInfo r101) throws IOException {
                String r102 = r101.origin_merge_forward_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransmitInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TransmitInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.origin_merge_forward_id = this.origin_merge_forward_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TransmitInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TransmitInfo(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public TransmitInfo(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.origin_merge_forward_id = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Content();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ORIGIN_SOURCE = r100;
        DEFAULT_ORIGIN_SIZE = 0L;
        DEFAULT_SIZE = 0L;
        DEFAULT_DURATION = 0;
        DEFAULT_DEPRECATED = FileType.DEFAULT;
        DEFAULT_SYSTEM_TYPE = SystemType.UNKNOWN;
        DEFAULT_SYSTEM_TYPE_VALUE = 0;
        DEFAULT_SYSTEM_MESSAGE_VERSION = 0;
        DEFAULT_HIDE_VOICE2TEXT = Boolean.TRUE;
        DEFAULT_ORIGIN_SENDER_ID = 0L;
        DEFAULT_IS_FRIEND = r100;
        DEFAULT_IS_AUDIO_RECOGNIZE_FINISH = r100;
        DEFAULT_AUDIO2TEXT_START_TIME = 0;
        DEFAULT_IS_AUDIO_WITH_TEXT = r100;
        DEFAULT_IS_GROUP_ANNOUNCEMENT = r100;
        DEFAULT_FILE_SOURCE = File.Source.LARK_SERVER;
        DEFAULT_IS_IN_MY_NUT_STORE = r100;
        DEFAULT_LAN_TRANS_STATUS = TransStatus.PENDING;
        DEFAULT_TRANS_IDENTITY = TransIdentity.OTHER;
        DEFAULT_IS_TRY_USE_LAN_TRANS = r100;
        DEFAULT_IS_ABLE_LAN_TRANS = r100;
        DEFAULT_IS_ENCRYPTED = r100;
        DEFAULT_FILE_ABILITY = FileAbility.UNKNOWN_SUPPORT_STATE;
        DEFAULT_FILE_PERMISSION = FilePermission.UNKNOWN_CAN_STATE;
        DEFAULT_FILE_LAST_UPDATE_USER_ID = 0L;
        DEFAULT_FILE_LAST_UPDATE_TIME_MS = 0L;
        DEFAULT_FILE_PREVIEW_STAGE = FilePreviewStage.UnknownStage;
        DEFAULT_EXPIRE_TIME = 0L;
        DEFAULT_SHARE_CHAT_LAST_STATE = 0;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_IS_VOICE_CALL = r100;
        DEFAULT_INCLUDE_CLEANED_RESOURCES = r100;
        DEFAULT_IS_UNKNOWN_DOUBAO_CONTENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.text = this.text;
        r100.image = this.image;
        r100.is_origin_source = this.is_origin_source;
        r100.origin_size = this.origin_size;
        r100.image_upload_id = this.image_upload_id;
        r100.key = this.key;
        r100.name = this.name;
        r100.size = this.size;
        r100.mime = this.mime;
        r100.file_upload_id = this.file_upload_id;
        r100.template = this.template;
        r100.values = Internal.copyOf("values", this.values);
        r100.duration = this.duration;
        r100.deprecated = this.deprecated;
        r100.system_type = this.system_type;
        r100.event = this.event;
        r100.content_values = Internal.copyOf("content_values", this.content_values);
        r100.system_type_value = this.system_type_value;
        r100.i18n_title_key = this.i18n_title_key;
        r100.system_content_values = Internal.copyOf("system_content_values", this.system_content_values);
        r100.item_actions = Internal.copyOf("item_actions", this.item_actions);
        r100.system_message_version = this.system_message_version;
        r100.voice2text = this.voice2text;
        r100.hide_voice2text = this.hide_voice2text;
        r100.origin_sender_id = this.origin_sender_id;
        r100.local_upload_id = this.local_upload_id;
        r100.origin_tos_key = this.origin_tos_key;
        r100.origin_sender_name = this.origin_sender_name;
        r100.is_friend = this.is_friend;
        r100.origin_sender_id_str = this.origin_sender_id_str;
        r100.is_audio_recognize_finish = this.is_audio_recognize_finish;
        r100.audio2text_start_time = this.audio2text_start_time;
        r100.is_audio_with_text = this.is_audio_with_text;
        r100.url_preview_hang_point_map = Internal.copyOf("url_preview_hang_point_map", this.url_preview_hang_point_map);
        r100.is_group_announcement = this.is_group_announcement;
        r100.doc_entity = this.doc_entity;
        r100.file_path = this.file_path;
        r100.file_source = this.file_source;
        r100.namespace = this.namespace;
        r100.is_in_my_nut_store = this.is_in_my_nut_store;
        r100.cache_file_path = this.cache_file_path;
        r100.lan_trans_status = this.lan_trans_status;
        r100.trans_identity = this.trans_identity;
        r100.lan_trans_status_text = this.lan_trans_status_text;
        r100.lan_sender_device_id = this.lan_sender_device_id;
        r100.lan_receiver_device_id = this.lan_receiver_device_id;
        r100.is_try_use_lan_trans = this.is_try_use_lan_trans;
        r100.is_able_lan_trans = this.is_able_lan_trans;
        r100.file_uri = this.file_uri;
        r100.is_encrypted = this.is_encrypted;
        r100.risk_object_keys = Internal.copyOf("risk_object_keys", this.risk_object_keys);
        r100.file_ability = this.file_ability;
        r100.file_permission = this.file_permission;
        r100.file_last_update_user_id = this.file_last_update_user_id;
        r100.file_last_update_time_ms = this.file_last_update_time_ms;
        r100.local_status = this.local_status;
        r100.file_preview_stage = this.file_preview_stage;
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.file_attachments = Internal.copyOf("file_attachments", this.file_attachments);
        r100.share_chat_id = this.share_chat_id;
        r100.join_token = this.join_token;
        r100.expire_time = this.expire_time;
        r100.share_chat_last_state = this.share_chat_last_state;
        r100.width = this.width;
        r100.height = this.height;
        r100.crypto_token = this.crypto_token;
        r100.merge_forward_content = this.merge_forward_content;
        r100.transmit_info = this.transmit_info;
        r100.preview_urls = Internal.copyOf("preview_urls", this.preview_urls);
        r100.rich_text = this.rich_text;
        r100.calendar_content = this.calendar_content;
        r100.share_calendar_event_content = this.share_calendar_event_content;
        r100.general_calendar_content = this.general_calendar_content;
        r100.text_url_contents = Internal.copyOf("text_url_contents", this.text_url_contents);
        r100.card_content = this.card_content;
        r100.location_content = this.location_content;
        r100.e2ee_from_id = this.e2ee_from_id;
        r100.e2ee_to_id = this.e2ee_to_id;
        r100.trigger_id = this.trigger_id;
        r100.vc_from_id = this.vc_from_id;
        r100.vc_to_id = this.vc_to_id;
        r100.vc_duration_time = this.vc_duration_time;
        r100.vc_meeting_id = this.vc_meeting_id;
        r100.vc_passcode = this.vc_passcode;
        r100.vc_feedback_status = this.vc_feedback_status;
        r100.vc_from_feedback_status = this.vc_from_feedback_status;
        r100.vc_to_feedback_status = this.vc_to_feedback_status;
        r100.is_voice_call = this.is_voice_call;
        r100.media_content = this.media_content;
        r100.hongbao_content = this.hongbao_content;
        r100.hongbao_system_content = this.hongbao_system_content;
        r100.system_extra_content = this.system_extra_content;
        r100.videochat_content = this.videochat_content;
        r100.resource_urls = Internal.copyOf("resource_urls", this.resource_urls);
        r100.fs_unit = this.fs_unit;
        r100.sticker_info = this.sticker_info;
        r100.sticker_id = this.sticker_id;
        r100.sticker_set_id = this.sticker_set_id;
        r100.share_user_card_info = this.share_user_card_info;
        r100.share_chatter_id = this.share_chatter_id;
        r100.abbreviation = this.abbreviation;
        r100.typed_element_refs = Internal.copyOf("typed_element_refs", this.typed_element_refs);
        r100.todo_operation_content = this.todo_operation_content;
        r100.lingo_option = this.lingo_option;
        r100.vote_content = this.vote_content;
        r100.folder_archive_key = this.folder_archive_key;
        r100.content_references = Internal.copyOf("content_references", this.content_references);
        r100.include_cleaned_resources = this.include_cleaned_resources;
        r100.clean_resource_key_scene = Internal.copyOf("clean_resource_key_scene", this.clean_resource_key_scene);
        r100.doubao_content = this.doubao_content;
        r100.is_unknown_doubao_content = this.is_unknown_doubao_content;
        r100.doubao_resource = this.doubao_resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Content.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Content(String r116, String r117, ImageSet r118, Boolean r119, Long r120, String r121, String r122, String r123, Long r124, String r125, String r126, String r127, Map<String, String> r128, Integer r129, FileType r130, SystemType r131, EmailSystemEvent r132, Map<String, ContentValue> r133, Integer r134, String r135, Map<String, SystemContentValue> r136, Map<Integer, SystemMessageItemAction> r137, Integer r138, String r139, Boolean r140, Long r141, String r142, String r143, String r144, Boolean r145, String r146, Boolean r147, Integer r148, Boolean r149, Map<String, UrlPreviewHangPoint> r150, Boolean r151, DocEntity r152, String r153, File.Source r154, String r155, Boolean r156, String r157, TransStatus r158, TransIdentity r159, String r160, String r161, String r162, Boolean r163, Boolean r164, String r165, Boolean r166, List<String> r167, FileAbility r168, FilePermission r169, Long r170, Long r171, LocalStatus r172, FilePreviewStage r173, List<File> r174, List<File> r175, String r176, String r177, Long r178, Integer r179, Integer r180, Integer r181, String r182, MergeForwardContent r183, TransmitInfo r184, List<PreviewUrlContent> r185, RichText r186, CalendarContent r187, ShareCalendarEventContent r188, GeneralCalendarContent r189, List<TextUrlContent> r190, CardContent r191, LocationContent r192, String r193, String r194, String r195, String r196, String r197, String r198, String r199, String r200, String r201, String r202, String r203, Boolean r204, MediaContent r205, HongbaoContent r206, HongbaoSystemContent r207, SystemExtraContent r208, VideoChatContent r209, List<String> r210, String r211, StickerInfo r212, String r213, String r214, ShareUserCardInfo r215, String r216, Abbreviation r217, Map<String, ElementRefs> r218, TodoOperationContent r219, LingoOption r220, VoteContent r221, String r222, List<Reference> r223, Boolean r224, Map<String, ResourceCleanScene> r225, DoubaoContent r226, Boolean r227, DoubaoResource r228) {
        this(r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, ByteString.EMPTY);
    }

    public Content(String r100, String r101, ImageSet r102, Boolean r103, Long r104, String r105, String r110, String r111, Long r112, String r113, String r114, String r115, Map<String, String> r116, Integer r117, FileType r118, SystemType r119, EmailSystemEvent r210, Map<String, ContentValue> r211, Integer r212, String r213, Map<String, SystemContentValue> r214, Map<Integer, SystemMessageItemAction> r215, Integer r216, String r217, Boolean r218, Long r219, String r310, String r311, String r312, Boolean r313, String r314, Boolean r315, Integer r316, Boolean r317, Map<String, UrlPreviewHangPoint> r318, Boolean r319, DocEntity r410, String r411, File.Source r412, String r413, Boolean r414, String r415, TransStatus r416, TransIdentity r417, String r418, String r419, String r510, Boolean r511, Boolean r512, String r513, Boolean r514, List<String> r515, FileAbility r516, FilePermission r517, Long r518, Long r519, LocalStatus r610, FilePreviewStage r611, List<File> r612, List<File> r613, String r614, String r615, Long r616, Integer r617, Integer r618, Integer r619, String r710, MergeForwardContent r711, TransmitInfo r712, List<PreviewUrlContent> r713, RichText r714, CalendarContent r715, ShareCalendarEventContent r716, GeneralCalendarContent r717, List<TextUrlContent> r718, CardContent r719, LocationContent r810, String r811, String r812, String r813, String r814, String r815, String r816, String r817, String r818, String r819, String r910, String r911, Boolean r912, MediaContent r913, HongbaoContent r914, HongbaoSystemContent r915, SystemExtraContent r916, VideoChatContent r917, List<String> r918, String r919, StickerInfo r106, String r107, String r108, ShareUserCardInfo r109, String r1010, Abbreviation r1011, Map<String, ElementRefs> r1012, TodoOperationContent r1013, LingoOption r1014, VoteContent r1015, String r1110, List<Reference> r1111, Boolean r1112, Map<String, ResourceCleanScene> r1113, DoubaoContent r1114, Boolean r1115, DoubaoResource r1116, ByteString r1117) {
        super(ADAPTER, r1117);
        this.title = r100;
        this.text = r101;
        this.image = r102;
        this.is_origin_source = r103;
        this.origin_size = r104;
        this.image_upload_id = r105;
        this.key = r110;
        this.name = r111;
        this.size = r112;
        this.mime = r113;
        this.file_upload_id = r114;
        this.template = r115;
        this.values = Internal.immutableCopyOf("values", r116);
        this.duration = r117;
        this.deprecated = r118;
        this.system_type = r119;
        this.event = r210;
        this.content_values = Internal.immutableCopyOf("content_values", r211);
        this.system_type_value = r212;
        this.i18n_title_key = r213;
        this.system_content_values = Internal.immutableCopyOf("system_content_values", r214);
        this.item_actions = Internal.immutableCopyOf("item_actions", r215);
        this.system_message_version = r216;
        this.voice2text = r217;
        this.hide_voice2text = r218;
        this.origin_sender_id = r219;
        this.local_upload_id = r310;
        this.origin_tos_key = r311;
        this.origin_sender_name = r312;
        this.is_friend = r313;
        this.origin_sender_id_str = r314;
        this.is_audio_recognize_finish = r315;
        this.audio2text_start_time = r316;
        this.is_audio_with_text = r317;
        this.url_preview_hang_point_map = Internal.immutableCopyOf("url_preview_hang_point_map", r318);
        this.is_group_announcement = r319;
        this.doc_entity = r410;
        this.file_path = r411;
        this.file_source = r412;
        this.namespace = r413;
        this.is_in_my_nut_store = r414;
        this.cache_file_path = r415;
        this.lan_trans_status = r416;
        this.trans_identity = r417;
        this.lan_trans_status_text = r418;
        this.lan_sender_device_id = r419;
        this.lan_receiver_device_id = r510;
        this.is_try_use_lan_trans = r511;
        this.is_able_lan_trans = r512;
        this.file_uri = r513;
        this.is_encrypted = r514;
        this.risk_object_keys = Internal.immutableCopyOf("risk_object_keys", r515);
        this.file_ability = r516;
        this.file_permission = r517;
        this.file_last_update_user_id = r518;
        this.file_last_update_time_ms = r519;
        this.local_status = r610;
        this.file_preview_stage = r611;
        this.attachments = Internal.immutableCopyOf("attachments", r612);
        this.file_attachments = Internal.immutableCopyOf("file_attachments", r613);
        this.share_chat_id = r614;
        this.join_token = r615;
        this.expire_time = r616;
        this.share_chat_last_state = r617;
        this.width = r618;
        this.height = r619;
        this.crypto_token = r710;
        this.merge_forward_content = r711;
        this.transmit_info = r712;
        this.preview_urls = Internal.immutableCopyOf("preview_urls", r713);
        this.rich_text = r714;
        this.calendar_content = r715;
        this.share_calendar_event_content = r716;
        this.general_calendar_content = r717;
        this.text_url_contents = Internal.immutableCopyOf("text_url_contents", r718);
        this.card_content = r719;
        this.location_content = r810;
        this.e2ee_from_id = r811;
        this.e2ee_to_id = r812;
        this.trigger_id = r813;
        this.vc_from_id = r814;
        this.vc_to_id = r815;
        this.vc_duration_time = r816;
        this.vc_meeting_id = r817;
        this.vc_passcode = r818;
        this.vc_feedback_status = r819;
        this.vc_from_feedback_status = r910;
        this.vc_to_feedback_status = r911;
        this.is_voice_call = r912;
        this.media_content = r913;
        this.hongbao_content = r914;
        this.hongbao_system_content = r915;
        this.system_extra_content = r916;
        this.videochat_content = r917;
        this.resource_urls = Internal.immutableCopyOf("resource_urls", r918);
        this.fs_unit = r919;
        this.sticker_info = r106;
        this.sticker_id = r107;
        this.sticker_set_id = r108;
        this.share_user_card_info = r109;
        this.share_chatter_id = r1010;
        this.abbreviation = r1011;
        this.typed_element_refs = Internal.immutableCopyOf("typed_element_refs", r1012);
        this.todo_operation_content = r1013;
        this.lingo_option = r1014;
        this.vote_content = r1015;
        this.folder_archive_key = r1110;
        this.content_references = Internal.immutableCopyOf("content_references", r1111);
        this.include_cleaned_resources = r1112;
        this.clean_resource_key_scene = Internal.immutableCopyOf("clean_resource_key_scene", r1113);
        this.doubao_content = r1114;
        this.is_unknown_doubao_content = r1115;
        this.doubao_resource = r1116;
    }
}
