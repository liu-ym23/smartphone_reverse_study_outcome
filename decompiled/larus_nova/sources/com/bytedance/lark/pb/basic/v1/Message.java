package com.bytedance.lark.pb.basic.v1;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.download.api.config.HttpMethod;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Message extends com.squareup.wire.Message<Message, Builder> {
    public static final ProtoAdapter<Message> ADAPTER = null;
    public static final String DEFAULT_AI_ANSWER_RAW_DATA = "";
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    public static final AIMessageLikeFeedbackStatus DEFAULT_AI_MESSAGE_LIKE_FEEDBACK_STATUS = null;
    public static final AIMessageType DEFAULT_AI_MESSAGE_TYPE = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final Integer DEFAULT_BURN_LIFE = null;
    public static final Long DEFAULT_BURN_TIME = null;
    public static final Boolean DEFAULT_CAN_SHOW_AI_PROGRESS = null;
    public static final Integer DEFAULT_CHARACTER_LENGTH = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_CREATE_TIME_MS = null;
    public static final String DEFAULT_CRYPTO_TOKEN = "";
    public static final Boolean DEFAULT_DISABLE_SEARCH = null;
    public static final MessageDLPState DEFAULT_DLP_STATE = null;
    public static final String DEFAULT_DOC_KEY = "";
    public static final String DEFAULT_EDIT_DRAFT_ID = "";
    public static final Long DEFAULT_EDIT_TIME_MS = null;
    public static final Integer DEFAULT_EDIT_VERSION = null;
    public static final FileDeletedStatus DEFAULT_FILE_DELETED_STATUS = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final Boolean DEFAULT_FORWARD_FROM_FRIEND = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final FromType DEFAULT_FROM_TYPE = null;
    public static final Boolean DEFAULT_HAS_FOLLOW_UP = null;
    public static final String DEFAULT_ID = "";
    public static final ChatDisplayModeSetting DEFAULT_IN_CHAT_DISPLAY_MODE = null;
    public static final Boolean DEFAULT_IS_ABNORMAL = null;
    public static final Boolean DEFAULT_IS_AI_SESSION_FIRST_MSG = null;
    public static final Boolean DEFAULT_IS_AT_ALL = null;
    public static final Boolean DEFAULT_IS_AT_ME = null;
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATED_BY_RECEIVER = null;
    public static final Boolean DEFAULT_IS_BADGED = null;
    public static final Boolean DEFAULT_IS_BURNED = null;
    public static final Boolean DEFAULT_IS_CLEANED = null;
    public static final Boolean DEFAULT_IS_CRYPTO_INTERMEDIATE = null;
    public static final Boolean DEFAULT_IS_DECRYPTO_FAIL = null;
    public static final Boolean DEFAULT_IS_DELETED = null;
    public static final Boolean DEFAULT_IS_EDITED = null;
    public static final Boolean DEFAULT_IS_FILE_DELETED = null;
    public static final Boolean DEFAULT_IS_FLAG = null;
    public static final Boolean DEFAULT_IS_INCLUDE_DOC_URL = null;
    public static final Boolean DEFAULT_IS_MANUAL_TRANSLATED = null;
    public static final Boolean DEFAULT_IS_NO_TRACE_DELETED = null;
    public static final Boolean DEFAULT_IS_ON_TIME_DEL = null;
    public static final Boolean DEFAULT_IS_RECALLED = null;
    public static final Boolean DEFAULT_IS_REEDITABLE = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Boolean DEFAULT_IS_SECRET_CHAT_DECRYPTED_FAILED = null;
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final Boolean DEFAULT_IS_TRUNCATED = null;
    public static final Boolean DEFAULT_IS_UNTRANSLATEABLE = null;
    public static final Boolean DEFAULT_IS_URGENT = null;
    public static final Boolean DEFAULT_IS_VISIBLE = null;
    public static final String DEFAULT_MESSAGE_LANGUAGE = "";
    public static final Boolean DEFAULT_ME_READ = null;
    public static final String DEFAULT_MSG_THREAD_DRAFT_ID = "";
    public static final String DEFAULT_ORIGINAL_SENDER_ID = "";
    public static final Integer DEFAULT_ORIGIN_BADGE_COUNT = null;
    public static final Integer DEFAULT_ORIGIN_THREAD_BADGE_COUNT = null;
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_PARENT_SOURCE_ID = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final String DEFAULT_POST_DRAFT_ID = "";
    public static final Integer DEFAULT_READ_COUNT = null;
    public static final String DEFAULT_RECALLER_ID = "";
    public static final RecallerIdentity DEFAULT_RECALLER_IDENTITY = null;
    public static final String DEFAULT_REMINDER_ID = "";
    public static final Integer DEFAULT_REPLY_COUNT = null;
    public static final String DEFAULT_ROOT_ID = "";
    public static final String DEFAULT_ROOT_SOURCE_ID = "";
    public static final String DEFAULT_SCHEDULE_MESSAGE_DRAFT_ID = "";
    public static final MessageSensitivity DEFAULT_SENSITIVITY = null;
    public static final Boolean DEFAULT_SET_GREY = null;
    public static final Boolean DEFAULT_SHOULD_NOTIFY = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final SourceType DEFAULT_SOURCE_TYPE = null;
    public static final Boolean DEFAULT_STATIC_RESOURCE_MESSAGE_RECALLED = null;
    public static final Integer DEFAULT_STREAM_SEQUENCE_ID = null;
    public static final StreamStatus DEFAULT_STREAM_STATUS = null;
    public static final Boolean DEFAULT_SYNC_DEPENDENCY = null;
    public static final SyncToChatMessageType DEFAULT_SYNC_TO_CHAT_MESSAGE_TYPE = null;
    public static final Long DEFAULT_SYNC_TO_CHAT_RELATED_MESSAGE_ID = null;
    public static final Long DEFAULT_SYNC_TO_CHAT_THREAD_ROOT_ID = null;
    public static final String DEFAULT_TEXT_DRAFT_ID = "";
    public static final Integer DEFAULT_THREAD_BADGE_COUNT = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final ThreadMessageType DEFAULT_THREAD_MESSAGE_TYPE = null;
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final Integer DEFAULT_THREAD_REPLY_COUNT = null;
    public static final String DEFAULT_TRANSLATE_LANGUAGE = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URGENT_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> ack_urgent_chatter_ids;
    public final String ai_answer_raw_data;
    public final Long ai_chat_mode_id;
    public final AIInfo ai_info;
    public final AIMessageLikeFeedbackStatus ai_message_like_feedback_status;
    public final AIMessageType ai_message_type;
    public final AIReplyEntryInfo ai_reply_entry_info;
    public final AnonymousInfo anonymous_info;
    public final List<String> at_out_chatter_ids;
    public final AuthorizedSource authorized_source;
    public final Integer badge_count;
    public final Integer burn_life;
    public final Long burn_time;
    public final Boolean can_show_ai_progress;
    public final CardInfo card_info;
    public final Channel channel;
    public final Integer character_length;
    public final String chat_id;
    public final String cid;
    public final Content content;
    public final COTContent cot_content;
    public final Long create_time;
    public final Long create_time_ms;
    public final String crypto_token;
    public final Boolean disable_search;
    public final DisabledAction disabled_action;
    public final MessageDLPState dlp_state;
    public final String doc_key;
    public final String edit_draft_id;
    public final Long edit_time_ms;
    public final Integer edit_version;
    public final FileDeletedStatus file_deleted_status;
    public final Long fold_id;
    public final Boolean forward_from_friend;
    public final String from_id;
    public final FromType from_type;
    public final Boolean has_follow_up;
    public final Map<String, String> i18n_content_language;
    public final I18nInfo i18n_info;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253515id;
    public final Map<String, ImageTranslationAbility> image_translation_ability;
    public final ChatDisplayModeSetting in_chat_display_mode;
    public final Boolean is_abnormal;
    public final Boolean is_ai_session_first_msg;
    public final Boolean is_at_all;
    public final Boolean is_at_me;
    public final Boolean is_auto_translated_by_receiver;
    public final Boolean is_badged;
    public final Boolean is_burned;
    public final Boolean is_cleaned;
    public final Boolean is_crypto_intermediate;
    public final Boolean is_decrypto_fail;
    public final Boolean is_deleted;
    public final Boolean is_edited;
    public final Boolean is_file_deleted;
    public final Boolean is_flag;
    public final Boolean is_include_doc_url;
    public final Boolean is_manual_translated;
    public final Boolean is_no_trace_deleted;
    public final Boolean is_on_time_del;
    public final Boolean is_recalled;
    public final Boolean is_reeditable;
    public final Boolean is_restricted;
    public final Boolean is_secret_chat_decrypted_failed;
    public final Boolean is_special_focus;
    public final Boolean is_truncated;
    public final Boolean is_untranslateable;
    public final Boolean is_urgent;
    public final Boolean is_visible;
    public final Boolean me_read;
    public final String message_language;
    public final List<String> message_languages;
    public final String msg_thread_draft_id;
    public final Integer origin_badge_count;
    public final Integer origin_thread_badge_count;
    public final String original_sender_id;
    public final String parent_id;
    public final String parent_source_id;
    public final PartialReplyInfo partial_reply_info;
    public final Pin pin;
    public final Integer position;
    public final String post_draft_id;
    public final List<Reaction> reactions;
    public final List<String> read_at_chatter_ids;
    public final Integer read_count;
    public final String recaller_id;
    public final RecallerIdentity recaller_identity;
    public final String reminder_id;
    public final Integer reply_count;
    public final String root_id;
    public final String root_source_id;
    public final String schedule_message_draft_id;
    public final SecurityESCReviewExtra security_extra;
    public final MessageSensitivity sensitivity;
    public final Boolean set_grey;
    public final Boolean should_notify;
    public final AIReply smart_ai_reply;
    public final String source_id;
    public final SourceType source_type;
    public final Boolean static_resource_message_recalled;
    public final Integer stream_sequence_id;
    public final StreamStatus stream_status;
    public final Boolean sync_dependency;
    public final SyncToChatMessageType sync_to_chat_message_type;
    public final Long sync_to_chat_related_message_id;
    public final Long sync_to_chat_thread_root_id;
    public final String text_draft_id;
    public final Integer thread_badge_count;
    public final String thread_id;
    public final ThreadMessageType thread_message_type;
    public final Integer thread_position;
    public final Integer thread_reply_count;
    public final String translate_language;
    public final TranslateMessageDisplayRule translate_message_display_rule;
    public final Type type;
    public final List<String> unack_urgent_chatter_ids;
    public final List<String> unread_chatter_ids;
    public final Integer unread_count;
    public final Long update_time;
    public final String urgent_id;
    public final Version version;

    public static final class AIInfo extends com.squareup.wire.Message<AIInfo, Builder> {
        public static final ProtoAdapter<AIInfo> ADAPTER = null;
        public static final String DEFAULT_ENTERPRISE_QA_GENERAL_INFO = "";
        public static final Long DEFAULT_ROOT_ROUND_ID = null;
        public static final Long DEFAULT_ROUND_ID = null;
        private static final long serialVersionUID = 0;
        public final ButtonConfig button_config;
        public final String enterprise_qa_general_info;
        public final Long root_round_id;
        public final Long round_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AIInfo, Builder> {
            public ButtonConfig button_config;
            public String enterprise_qa_general_info;
            public Long root_round_id;
            public Long round_id;

            @Override // com.squareup.wire.Message.Builder
            public AIInfo build() {
                return new AIInfo(this.round_id, this.button_config, this.root_round_id, this.enterprise_qa_general_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder button_config(ButtonConfig r100) {
                this.button_config = r100;
                return this;
            }

            public Builder enterprise_qa_general_info(String r100) {
                this.enterprise_qa_general_info = r100;
                return this;
            }

            public Builder root_round_id(Long r100) {
                this.root_round_id = r100;
                return this;
            }

            public Builder round_id(Long r100) {
                this.round_id = r100;
                return this;
            }
        }

        public static final class ButtonConfig extends com.squareup.wire.Message<ButtonConfig, Builder> {
            public static final ProtoAdapter<ButtonConfig> ADAPTER = null;
            public static final String DEFAULT_AI_ANSWER_MARKDOWN_DATA = "";
            public static final String DEFAULT_BUTTON_LIST_JSON = "";
            public static final Strategy DEFAULT_STRATEGY = null;
            private static final long serialVersionUID = 0;
            public final String ai_answer_markdown_data;
            public final String button_list_json;
            public final List<Button> customize_buttons;
            public final Strategy strategy;

            public static final class Builder extends com.squareup.wire.Message.Builder<ButtonConfig, Builder> {
                public String ai_answer_markdown_data;
                public String button_list_json;
                public List<Button> customize_buttons;
                public Strategy strategy;

                @Override // com.squareup.wire.Message.Builder
                public ButtonConfig build() {
                    return new ButtonConfig(this.strategy, this.customize_buttons, this.ai_answer_markdown_data, this.button_list_json, super.buildUnknownFields());
                }

                public Builder() {
                    this.customize_buttons = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder ai_answer_markdown_data(String r100) {
                    this.ai_answer_markdown_data = r100;
                    return this;
                }

                public Builder button_list_json(String r100) {
                    this.button_list_json = r100;
                    return this;
                }

                public Builder customize_buttons(List<Button> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.customize_buttons = r100;
                    return this;
                }

                public Builder strategy(Strategy r100) {
                    this.strategy = r100;
                    return this;
                }
            }

            public static final enum Button extends Enum<Button> implements WireEnum {
                private static final /* synthetic */ Button[] $VALUES = null;
                public static final ProtoAdapter<Button> ADAPTER = null;
                public static final Button COPY = null;
                public static final Button DISLIKE = null;
                public static final Button LIKE = null;
                public static final Button REGENERATE = null;
                public static final Button SHARE = null;
                public static final Button UNKNOWN = null;
                private final int value;

                static {
                    Button r100 = new Button("UNKNOWN", 0, 0);
                    UNKNOWN = r100;
                    Button r101 = new Button("LIKE", 1, 1);
                    LIKE = r101;
                    Button r102 = new Button("DISLIKE", 2, 2);
                    DISLIKE = r102;
                    Button r103 = new Button("REGENERATE", 3, 3);
                    REGENERATE = r103;
                    Button r104 = new Button("SHARE", 4, 4);
                    SHARE = r104;
                    Button r105 = new Button("COPY", 5, 5);
                    COPY = r105;
                    $VALUES = new Button[]{r100, r101, r102, r103, r104, r105};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Button.class);
                }

                public static Button[] values() {
                    return (Button[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static Button fromValue(int r100) {
                    if (r100 == 0) goto L26;
                    if (r100 == 1) goto L24;
                    if (r100 == 2) goto L22;
                    if (r100 == 3) goto L20;
                    if (r100 == 4) goto L18;
                    if (r100 == 5) goto L16;
                    return null;
                L16:
                    return COPY;
                L18:
                    return SHARE;
                L20:
                    return REGENERATE;
                L22:
                    return DISLIKE;
                L24:
                    return LIKE;
                L26:
                    return UNKNOWN;
                }

                public static Button valueOf(String r100) {
                    return (Button) a.a(Button.class, r100);
                }

                private Button(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final class ProtoAdapter_ButtonConfig extends ProtoAdapter<ButtonConfig> {
                public ProtoAdapter_ButtonConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, ButtonConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ButtonConfig decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.strategy = Strategy.DEFAULT;
                    r101.ai_answer_markdown_data = "";
                    r101.button_list_json = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L24;
                    if (r103 != 1) goto L8;
                    r101.strategy = Strategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
                L22:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.customize_buttons.add(Button.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                L18:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.ai_answer_markdown_data = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.button_list_json = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L24:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(ButtonConfig r100) {
                    Strategy r101 = r100.strategy;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = Strategy.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    int r104 = r103 + Button.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.customize_buttons);
                    String r105 = r100.ai_answer_markdown_data;
                    if (r105 == null) goto L9;
                    int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
                L10:
                    int r107 = r104 + r106;
                    String r108 = r100.button_list_json;
                    if (r108 == null) goto L14;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
                L14:
                    return (r107 + r102) + r100.unknownFields().size();
                L9:
                    r106 = 0;
                    goto L10
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ButtonConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ButtonConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ButtonConfig r101) throws IOException {
                    Strategy r102 = r101.strategy;
                    if (r102 == null) goto L5;
                    Strategy.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    Button.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.customize_buttons);
                    String r103 = r101.ai_answer_markdown_data;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
                L8:
                    String r104 = r101.button_list_json;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            public static final enum Strategy extends Enum<Strategy> implements WireEnum {
                private static final /* synthetic */ Strategy[] $VALUES = null;
                public static final ProtoAdapter<Strategy> ADAPTER = null;
                public static final Strategy CUSTOMIZE = null;
                public static final Strategy DEFAULT = null;
                private final int value;

                static {
                    Strategy r100 = new Strategy("DEFAULT", 0, 0);
                    DEFAULT = r100;
                    Strategy r101 = new Strategy("CUSTOMIZE", 1, 1);
                    CUSTOMIZE = r101;
                    $VALUES = new Strategy[]{r100, r101};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Strategy.class);
                }

                public static Strategy[] values() {
                    return (Strategy[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static Strategy fromValue(int r100) {
                    if (r100 == 0) goto L10;
                    if (r100 == 1) goto L8;
                    return null;
                L8:
                    return CUSTOMIZE;
                L10:
                    return DEFAULT;
                }

                public static Strategy valueOf(String r100) {
                    return (Strategy) a.a(Strategy.class, r100);
                }

                private Strategy(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ButtonConfig();
                DEFAULT_STRATEGY = Strategy.DEFAULT;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.strategy = this.strategy;
                r100.customize_buttons = Internal.copyOf("customize_buttons", this.customize_buttons);
                r100.ai_answer_markdown_data = this.ai_answer_markdown_data;
                r100.button_list_json = this.button_list_json;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ButtonConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public ButtonConfig(Strategy r100, List<Button> r101, String r102, String r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public ButtonConfig(Strategy r100, List<Button> r101, String r102, String r103, ByteString r104) {
                super(ADAPTER, r104);
                this.strategy = r100;
                this.customize_buttons = Internal.immutableCopyOf("customize_buttons", r101);
                this.ai_answer_markdown_data = r102;
                this.button_list_json = r103;
            }
        }

        public static final class ProtoAdapter_AIInfo extends ProtoAdapter<AIInfo> {
            public ProtoAdapter_AIInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AIInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AIInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.round_id = 0L;
                r101.root_round_id = 0L;
                r101.enterprise_qa_general_info = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.round_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.button_config = ButtonConfig.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.root_round_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.enterprise_qa_general_info = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AIInfo r100) {
                Long r101 = r100.round_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                ButtonConfig r104 = r100.button_config;
                if (r104 == null) goto L9;
                int r105 = ButtonConfig.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.root_round_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.enterprise_qa_general_info;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ AIInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AIInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AIInfo r101) throws IOException {
                Long r102 = r101.round_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                ButtonConfig r103 = r101.button_config;
                if (r103 == null) goto L8;
                ButtonConfig.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.root_round_id;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.enterprise_qa_general_info;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AIInfo();
            DEFAULT_ROUND_ID = 0L;
            DEFAULT_ROOT_ROUND_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.round_id = this.round_id;
            r100.button_config = this.button_config;
            r100.root_round_id = this.root_round_id;
            r100.enterprise_qa_general_info = this.enterprise_qa_general_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AIInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AIInfo(Long r100, ButtonConfig r101, Long r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public AIInfo(Long r100, ButtonConfig r101, Long r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.round_id = r100;
            this.button_config = r101;
            this.root_round_id = r102;
            this.enterprise_qa_general_info = r103;
        }
    }

    public static final enum AIMessageLikeFeedbackStatus extends Enum<AIMessageLikeFeedbackStatus> implements WireEnum {
        private static final /* synthetic */ AIMessageLikeFeedbackStatus[] $VALUES = null;
        public static final ProtoAdapter<AIMessageLikeFeedbackStatus> ADAPTER = null;
        public static final AIMessageLikeFeedbackStatus DISLIKE = null;
        public static final AIMessageLikeFeedbackStatus LIKE = null;
        public static final AIMessageLikeFeedbackStatus UNKNOWN_STATUS = null;
        private final int value;

        static {
            AIMessageLikeFeedbackStatus r100 = new AIMessageLikeFeedbackStatus("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r100;
            AIMessageLikeFeedbackStatus r101 = new AIMessageLikeFeedbackStatus("LIKE", 1, 1);
            LIKE = r101;
            AIMessageLikeFeedbackStatus r102 = new AIMessageLikeFeedbackStatus("DISLIKE", 2, 2);
            DISLIKE = r102;
            $VALUES = new AIMessageLikeFeedbackStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AIMessageLikeFeedbackStatus.class);
        }

        public static AIMessageLikeFeedbackStatus[] values() {
            return (AIMessageLikeFeedbackStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AIMessageLikeFeedbackStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DISLIKE;
        L12:
            return LIKE;
        L14:
            return UNKNOWN_STATUS;
        }

        public static AIMessageLikeFeedbackStatus valueOf(String r100) {
            return (AIMessageLikeFeedbackStatus) a.a(AIMessageLikeFeedbackStatus.class, r100);
        }

        private AIMessageLikeFeedbackStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum AIMessageType extends Enum<AIMessageType> implements WireEnum {
        private static final /* synthetic */ AIMessageType[] $VALUES = null;
        public static final ProtoAdapter<AIMessageType> ADAPTER = null;
        public static final AIMessageType GUIDE_MESSAGE = null;
        public static final AIMessageType NOT_STREAM_ANSWER = null;
        public static final AIMessageType OTHER = null;
        public static final AIMessageType QUESTION = null;
        public static final AIMessageType STREAM_ANSWER = null;
        public static final AIMessageType SYSTEM_MESSAGE = null;
        private final int value;

        static {
            AIMessageType r100 = new AIMessageType(FlowDoraWifiScene.OTHER, 0, 0);
            OTHER = r100;
            AIMessageType r101 = new AIMessageType("QUESTION", 1, 1);
            QUESTION = r101;
            AIMessageType r102 = new AIMessageType("STREAM_ANSWER", 2, 2);
            STREAM_ANSWER = r102;
            AIMessageType r103 = new AIMessageType("NOT_STREAM_ANSWER", 3, 3);
            NOT_STREAM_ANSWER = r103;
            AIMessageType r104 = new AIMessageType("SYSTEM_MESSAGE", 4, 4);
            SYSTEM_MESSAGE = r104;
            AIMessageType r105 = new AIMessageType("GUIDE_MESSAGE", 5, 5);
            GUIDE_MESSAGE = r105;
            $VALUES = new AIMessageType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(AIMessageType.class);
        }

        public static AIMessageType[] values() {
            return (AIMessageType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AIMessageType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return GUIDE_MESSAGE;
        L18:
            return SYSTEM_MESSAGE;
        L20:
            return NOT_STREAM_ANSWER;
        L22:
            return STREAM_ANSWER;
        L24:
            return QUESTION;
        L26:
            return OTHER;
        }

        public static AIMessageType valueOf(String r100) {
            return (AIMessageType) a.a(AIMessageType.class, r100);
        }

        private AIMessageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class AIReplyEntryInfo extends com.squareup.wire.Message<AIReplyEntryInfo, Builder> {
        public static final ProtoAdapter<AIReplyEntryInfo> ADAPTER = null;
        public static final String DEFAULT_AI_REPLY_ID = "";
        public static final Boolean DEFAULT_HAS_PRE_GENERATION = null;
        private static final long serialVersionUID = 0;
        public final String ai_reply_id;
        public final Boolean has_pre_generation;

        public static final class Builder extends com.squareup.wire.Message.Builder<AIReplyEntryInfo, Builder> {
            public String ai_reply_id;
            public Boolean has_pre_generation;

            @Override // com.squareup.wire.Message.Builder
            public AIReplyEntryInfo build() {
                return new AIReplyEntryInfo(this.has_pre_generation, this.ai_reply_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder ai_reply_id(String r100) {
                this.ai_reply_id = r100;
                return this;
            }

            public Builder has_pre_generation(Boolean r100) {
                this.has_pre_generation = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AIReplyEntryInfo extends ProtoAdapter<AIReplyEntryInfo> {
            public ProtoAdapter_AIReplyEntryInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AIReplyEntryInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AIReplyEntryInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.has_pre_generation = Boolean.FALSE;
                r101.ai_reply_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.has_pre_generation = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.ai_reply_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AIReplyEntryInfo r100) {
                Boolean r101 = r100.has_pre_generation;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.ai_reply_id;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AIReplyEntryInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AIReplyEntryInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AIReplyEntryInfo r101) throws IOException {
                Boolean r102 = r101.has_pre_generation;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.ai_reply_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIReplyEntryInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AIReplyEntryInfo();
            DEFAULT_HAS_PRE_GENERATION = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.has_pre_generation = this.has_pre_generation;
            r100.ai_reply_id = this.ai_reply_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AIReplyEntryInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AIReplyEntryInfo(Boolean r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AIReplyEntryInfo(Boolean r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.has_pre_generation = r100;
            this.ai_reply_id = r101;
        }
    }

    public static final enum AgentSendMessageSourceDisplayPolicy extends Enum<AgentSendMessageSourceDisplayPolicy> implements WireEnum {
        private static final /* synthetic */ AgentSendMessageSourceDisplayPolicy[] $VALUES = null;
        public static final ProtoAdapter<AgentSendMessageSourceDisplayPolicy> ADAPTER = null;
        public static final AgentSendMessageSourceDisplayPolicy INLINE = null;
        public static final AgentSendMessageSourceDisplayPolicy MENU = null;
        public static final AgentSendMessageSourceDisplayPolicy UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = null;
        private final int value;

        static {
            AgentSendMessageSourceDisplayPolicy r100 = new AgentSendMessageSourceDisplayPolicy("UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", 0, 0);
            UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = r100;
            AgentSendMessageSourceDisplayPolicy r101 = new AgentSendMessageSourceDisplayPolicy("MENU", 1, 1);
            MENU = r101;
            AgentSendMessageSourceDisplayPolicy r102 = new AgentSendMessageSourceDisplayPolicy("INLINE", 2, 2);
            INLINE = r102;
            $VALUES = new AgentSendMessageSourceDisplayPolicy[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AgentSendMessageSourceDisplayPolicy.class);
        }

        public static AgentSendMessageSourceDisplayPolicy[] values() {
            return (AgentSendMessageSourceDisplayPolicy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AgentSendMessageSourceDisplayPolicy fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return INLINE;
        L12:
            return MENU;
        L14:
            return UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
        }

        public static AgentSendMessageSourceDisplayPolicy valueOf(String r100) {
            return (AgentSendMessageSourceDisplayPolicy) a.a(AgentSendMessageSourceDisplayPolicy.class, r100);
        }

        private AgentSendMessageSourceDisplayPolicy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class AnonymousInfo extends com.squareup.wire.Message<AnonymousInfo, Builder> {
        public static final ProtoAdapter<AnonymousInfo> ADAPTER = null;
        public static final Boolean DEFAULT_IS_ANONYMOUS = null;
        public static final Boolean DEFAULT_IS_SENDER = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_anonymous;
        public final Boolean is_sender;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnonymousInfo, Builder> {
            public Boolean is_anonymous;
            public Boolean is_sender;

            @Override // com.squareup.wire.Message.Builder
            public AnonymousInfo build() {
                Boolean r100 = this.is_anonymous;
                if (r100 == null) goto L7;
                return new AnonymousInfo(this.is_anonymous, this.is_sender, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder is_anonymous(Boolean r100) {
                this.is_anonymous = r100;
                return this;
            }

            public Builder is_sender(Boolean r100) {
                this.is_sender = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AnonymousInfo extends ProtoAdapter<AnonymousInfo> {
            public ProtoAdapter_AnonymousInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AnonymousInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnonymousInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_anonymous = r102;
                r101.is_sender = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.is_sender = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(AnonymousInfo r100) {
                ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
                int r102 = r101.encodedSizeWithTag(1, r100.is_anonymous);
                Boolean r103 = r100.is_sender;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(2, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AnonymousInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AnonymousInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AnonymousInfo r101) throws IOException {
                ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
                r102.encodeWithTag(r100, 1, r101.is_anonymous);
                Boolean r103 = r101.is_sender;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AnonymousInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnonymousInfo();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_ANONYMOUS = r100;
            DEFAULT_IS_SENDER = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_anonymous = this.is_anonymous;
            r100.is_sender = this.is_sender;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AnonymousInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AnonymousInfo(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AnonymousInfo(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.is_anonymous = r100;
            this.is_sender = r101;
        }
    }

    public static final class AuthorizedSource extends com.squareup.wire.Message<AuthorizedSource, Builder> {
        public static final ProtoAdapter<AuthorizedSource> ADAPTER = null;
        public static final AuthorizedSourceType DEFAULT_AUTHORIZED_SOURCE_TYPE = null;
        public static final AgentSendMessageSourceDisplayPolicy DEFAULT_DISPLAY_POLICY = null;
        public static final Long DEFAULT_SOURCE_ID = null;
        private static final long serialVersionUID = 0;
        public final AuthorizedSourceType authorized_source_type;
        public final AgentSendMessageSourceDisplayPolicy display_policy;
        public final Long source_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AuthorizedSource, Builder> {
            public AuthorizedSourceType authorized_source_type;
            public AgentSendMessageSourceDisplayPolicy display_policy;
            public Long source_id;

            @Override // com.squareup.wire.Message.Builder
            public AuthorizedSource build() {
                Long r100 = this.source_id;
                if (r100 == null) goto L9;
                if (this.authorized_source_type == null) goto L9;
                return new AuthorizedSource(this.source_id, this.authorized_source_type, this.display_policy, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "source_id", this.authorized_source_type, "authorized_source_type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder authorized_source_type(AuthorizedSourceType r100) {
                this.authorized_source_type = r100;
                return this;
            }

            public Builder display_policy(AgentSendMessageSourceDisplayPolicy r100) {
                this.display_policy = r100;
                return this;
            }

            public Builder source_id(Long r100) {
                this.source_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AuthorizedSource extends ProtoAdapter<AuthorizedSource> {
            public ProtoAdapter_AuthorizedSource() {
                super(FieldEncoding.LENGTH_DELIMITED, AuthorizedSource.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AuthorizedSource decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.source_id = 0L;
                r101.authorized_source_type = AuthorizedSourceType.UNKNOWN_AUTHORIZED_SOURCE_TYPE;
                r101.display_policy = AgentSendMessageSourceDisplayPolicy.UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.source_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.authorized_source_type = AuthorizedSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.display_policy = AgentSendMessageSourceDisplayPolicy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
            public int encodedSize2(AuthorizedSource r100) {
                int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.source_id) + AuthorizedSourceType.ADAPTER.encodedSizeWithTag(2, r100.authorized_source_type);
                AgentSendMessageSourceDisplayPolicy r102 = r100.display_policy;
                if (r102 == null) goto L5;
                int r103 = AgentSendMessageSourceDisplayPolicy.ADAPTER.encodedSizeWithTag(3, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AuthorizedSource decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AuthorizedSource r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AuthorizedSource r101) throws IOException {
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.source_id);
                AuthorizedSourceType.ADAPTER.encodeWithTag(r100, 2, r101.authorized_source_type);
                AgentSendMessageSourceDisplayPolicy r102 = r101.display_policy;
                if (r102 == null) goto L5;
                AgentSendMessageSourceDisplayPolicy.ADAPTER.encodeWithTag(r100, 3, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AuthorizedSource r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AuthorizedSource();
            DEFAULT_SOURCE_ID = 0L;
            DEFAULT_AUTHORIZED_SOURCE_TYPE = AuthorizedSourceType.UNKNOWN_AUTHORIZED_SOURCE_TYPE;
            DEFAULT_DISPLAY_POLICY = AgentSendMessageSourceDisplayPolicy.UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.source_id = this.source_id;
            r100.authorized_source_type = this.authorized_source_type;
            r100.display_policy = this.display_policy;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AuthorizedSource.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AuthorizedSource(Long r100, AuthorizedSourceType r101, AgentSendMessageSourceDisplayPolicy r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public AuthorizedSource(Long r100, AuthorizedSourceType r101, AgentSendMessageSourceDisplayPolicy r102, ByteString r103) {
            super(ADAPTER, r103);
            this.source_id = r100;
            this.authorized_source_type = r101;
            this.display_policy = r102;
        }
    }

    public static final enum AuthorizedSourceType extends Enum<AuthorizedSourceType> implements WireEnum {
        private static final /* synthetic */ AuthorizedSourceType[] $VALUES = null;
        public static final ProtoAdapter<AuthorizedSourceType> ADAPTER = null;
        public static final AuthorizedSourceType APP = null;
        public static final AuthorizedSourceType UNKNOWN_AUTHORIZED_SOURCE_TYPE = null;
        private final int value;

        static {
            AuthorizedSourceType r100 = new AuthorizedSourceType("UNKNOWN_AUTHORIZED_SOURCE_TYPE", 0, 0);
            UNKNOWN_AUTHORIZED_SOURCE_TYPE = r100;
            AuthorizedSourceType r101 = new AuthorizedSourceType("APP", 1, 1);
            APP = r101;
            $VALUES = new AuthorizedSourceType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(AuthorizedSourceType.class);
        }

        public static AuthorizedSourceType[] values() {
            return (AuthorizedSourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AuthorizedSourceType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return APP;
        L10:
            return UNKNOWN_AUTHORIZED_SOURCE_TYPE;
        }

        public static AuthorizedSourceType valueOf(String r100) {
            return (AuthorizedSourceType) a.a(AuthorizedSourceType.class, r100);
        }

        private AuthorizedSourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Message, Builder> {
        public List<String> ack_urgent_chatter_ids;
        public String ai_answer_raw_data;
        public Long ai_chat_mode_id;
        public AIInfo ai_info;
        public AIMessageLikeFeedbackStatus ai_message_like_feedback_status;
        public AIMessageType ai_message_type;
        public AIReplyEntryInfo ai_reply_entry_info;
        public AnonymousInfo anonymous_info;
        public List<String> at_out_chatter_ids;
        public AuthorizedSource authorized_source;
        public Integer badge_count;
        public Integer burn_life;
        public Long burn_time;
        public Boolean can_show_ai_progress;
        public CardInfo card_info;
        public Channel channel;
        public Integer character_length;
        public String chat_id;
        public String cid;
        public Content content;
        public COTContent cot_content;
        public Long create_time;
        public Long create_time_ms;
        public String crypto_token;
        public Boolean disable_search;
        public DisabledAction disabled_action;
        public MessageDLPState dlp_state;
        public String doc_key;
        public String edit_draft_id;
        public Long edit_time_ms;
        public Integer edit_version;
        public FileDeletedStatus file_deleted_status;
        public Long fold_id;
        public Boolean forward_from_friend;
        public String from_id;
        public FromType from_type;
        public Boolean has_follow_up;
        public Map<String, String> i18n_content_language;
        public I18nInfo i18n_info;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253516id;
        public Map<String, ImageTranslationAbility> image_translation_ability;
        public ChatDisplayModeSetting in_chat_display_mode;
        public Boolean is_abnormal;
        public Boolean is_ai_session_first_msg;
        public Boolean is_at_all;
        public Boolean is_at_me;
        public Boolean is_auto_translated_by_receiver;
        public Boolean is_badged;
        public Boolean is_burned;
        public Boolean is_cleaned;
        public Boolean is_crypto_intermediate;
        public Boolean is_decrypto_fail;
        public Boolean is_deleted;
        public Boolean is_edited;
        public Boolean is_file_deleted;
        public Boolean is_flag;
        public Boolean is_include_doc_url;
        public Boolean is_manual_translated;
        public Boolean is_no_trace_deleted;
        public Boolean is_on_time_del;
        public Boolean is_recalled;
        public Boolean is_reeditable;
        public Boolean is_restricted;
        public Boolean is_secret_chat_decrypted_failed;
        public Boolean is_special_focus;
        public Boolean is_truncated;
        public Boolean is_untranslateable;
        public Boolean is_urgent;
        public Boolean is_visible;
        public Boolean me_read;
        public String message_language;
        public List<String> message_languages;
        public String msg_thread_draft_id;
        public Integer origin_badge_count;
        public Integer origin_thread_badge_count;
        public String original_sender_id;
        public String parent_id;
        public String parent_source_id;
        public PartialReplyInfo partial_reply_info;
        public Pin pin;
        public Integer position;
        public String post_draft_id;
        public List<Reaction> reactions;
        public List<String> read_at_chatter_ids;
        public Integer read_count;
        public String recaller_id;
        public RecallerIdentity recaller_identity;
        public String reminder_id;
        public Integer reply_count;
        public String root_id;
        public String root_source_id;
        public String schedule_message_draft_id;
        public SecurityESCReviewExtra security_extra;
        public MessageSensitivity sensitivity;
        public Boolean set_grey;
        public Boolean should_notify;
        public AIReply smart_ai_reply;
        public String source_id;
        public SourceType source_type;
        public Boolean static_resource_message_recalled;
        public Integer stream_sequence_id;
        public StreamStatus stream_status;
        public Boolean sync_dependency;
        public SyncToChatMessageType sync_to_chat_message_type;
        public Long sync_to_chat_related_message_id;
        public Long sync_to_chat_thread_root_id;
        public String text_draft_id;
        public Integer thread_badge_count;
        public String thread_id;
        public ThreadMessageType thread_message_type;
        public Integer thread_position;
        public Integer thread_reply_count;
        public String translate_language;
        public TranslateMessageDisplayRule translate_message_display_rule;
        public Type type;
        public List<String> unack_urgent_chatter_ids;
        public List<String> unread_chatter_ids;
        public Integer unread_count;
        public Long update_time;
        public String urgent_id;
        public Version version;

        @Override // com.squareup.wire.Message.Builder
        public Message build() {
            String r100 = this.f253516id;
            if (r100 == null) goto L21;
            if (this.type == null) goto L21;
            if (this.chat_id == null) goto L21;
            if (this.create_time == null) goto L21;
            if (this.update_time == null) goto L21;
            if (this.root_id == null) goto L21;
            if (this.content == null) goto L21;
            if (this.unread_count == null) goto L21;
            return new Message(this.f253516id, this.type, this.chat_id, this.thread_id, this.create_time, this.update_time, this.root_id, this.content, this.reactions, this.unread_count, this.from_id, this.should_notify, this.is_recalled, this.is_edited, this.reply_count, this.position, this.cid, this.me_read, this.reminder_id, this.parent_source_id, this.root_source_id, this.is_urgent, this.urgent_id, this.parent_id, this.is_at_me, this.is_at_all, this.is_truncated, this.read_count, this.unread_chatter_ids, this.text_draft_id, this.post_draft_id, this.is_file_deleted, this.is_deleted, this.is_abnormal, this.from_type, this.doc_key, this.unack_urgent_chatter_ids, this.ack_urgent_chatter_ids, this.channel, this.is_visible, this.burn_life, this.burn_time, this.thread_position, this.source_type, this.source_id, this.translate_language, this.recaller_id, this.recaller_identity, this.pin, this.badge_count, this.is_reeditable, this.is_badged, this.is_untranslateable, this.read_at_chatter_ids, this.thread_badge_count, this.thread_reply_count, this.at_out_chatter_ids, this.is_burned, this.message_language, this.is_auto_translated_by_receiver, this.is_no_trace_deleted, this.origin_badge_count, this.origin_thread_badge_count, this.sensitivity, this.crypto_token, this.is_decrypto_fail, this.is_secret_chat_decrypted_failed, this.translate_message_display_rule, this.is_manual_translated, this.original_sender_id, this.forward_from_friend, this.static_resource_message_recalled, this.is_crypto_intermediate, this.image_translation_ability, this.is_special_focus, this.is_include_doc_url, this.file_deleted_status, this.character_length, this.msg_thread_draft_id, this.sync_dependency, this.anonymous_info, this.is_flag, this.thread_message_type, this.create_time_ms, this.i18n_content_language, this.disable_search, this.edit_version, this.edit_time_ms, this.edit_draft_id, this.dlp_state, this.message_languages, this.i18n_info, this.fold_id, this.version, this.schedule_message_draft_id, this.in_chat_display_mode, this.is_restricted, this.set_grey, this.disabled_action, this.is_on_time_del, this.is_cleaned, this.security_extra, this.stream_status, this.stream_sequence_id, this.ai_chat_mode_id, this.ai_answer_raw_data, this.ai_message_like_feedback_status, this.ai_message_type, this.sync_to_chat_thread_root_id, this.sync_to_chat_message_type, this.sync_to_chat_related_message_id, this.can_show_ai_progress, this.partial_reply_info, this.is_ai_session_first_msg, this.authorized_source, this.has_follow_up, this.ai_info, this.ai_reply_entry_info, this.card_info, this.smart_ai_reply, this.cot_content, super.buildUnknownFields());
        L21:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type", this.chat_id, "chat_id", this.create_time, "create_time", this.update_time, "update_time", this.root_id, "root_id", this.content, "content", this.unread_count, "unread_count"});
        }

        public Builder() {
            this.reactions = Internal.newMutableList();
            this.unread_chatter_ids = Internal.newMutableList();
            this.unack_urgent_chatter_ids = Internal.newMutableList();
            this.ack_urgent_chatter_ids = Internal.newMutableList();
            this.read_at_chatter_ids = Internal.newMutableList();
            this.at_out_chatter_ids = Internal.newMutableList();
            this.image_translation_ability = Internal.newMutableMap();
            this.i18n_content_language = Internal.newMutableMap();
            this.message_languages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ack_urgent_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ack_urgent_chatter_ids = r100;
            return this;
        }

        public Builder ai_answer_raw_data(String r100) {
            this.ai_answer_raw_data = r100;
            return this;
        }

        public Builder ai_chat_mode_id(Long r100) {
            this.ai_chat_mode_id = r100;
            return this;
        }

        public Builder ai_info(AIInfo r100) {
            this.ai_info = r100;
            return this;
        }

        public Builder ai_message_like_feedback_status(AIMessageLikeFeedbackStatus r100) {
            this.ai_message_like_feedback_status = r100;
            return this;
        }

        public Builder ai_message_type(AIMessageType r100) {
            this.ai_message_type = r100;
            return this;
        }

        public Builder ai_reply_entry_info(AIReplyEntryInfo r100) {
            this.ai_reply_entry_info = r100;
            return this;
        }

        public Builder anonymous_info(AnonymousInfo r100) {
            this.anonymous_info = r100;
            return this;
        }

        public Builder at_out_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_out_chatter_ids = r100;
            return this;
        }

        public Builder authorized_source(AuthorizedSource r100) {
            this.authorized_source = r100;
            return this;
        }

        public Builder badge_count(Integer r100) {
            this.badge_count = r100;
            return this;
        }

        public Builder burn_life(Integer r100) {
            this.burn_life = r100;
            return this;
        }

        public Builder burn_time(Long r100) {
            this.burn_time = r100;
            return this;
        }

        public Builder can_show_ai_progress(Boolean r100) {
            this.can_show_ai_progress = r100;
            return this;
        }

        public Builder card_info(CardInfo r100) {
            this.card_info = r100;
            return this;
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder character_length(Integer r100) {
            this.character_length = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder content(Content r100) {
            this.content = r100;
            return this;
        }

        public Builder cot_content(COTContent r100) {
            this.cot_content = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder create_time_ms(Long r100) {
            this.create_time_ms = r100;
            return this;
        }

        public Builder crypto_token(String r100) {
            this.crypto_token = r100;
            return this;
        }

        public Builder disable_search(Boolean r100) {
            this.disable_search = r100;
            return this;
        }

        public Builder disabled_action(DisabledAction r100) {
            this.disabled_action = r100;
            return this;
        }

        public Builder dlp_state(MessageDLPState r100) {
            this.dlp_state = r100;
            return this;
        }

        public Builder doc_key(String r100) {
            this.doc_key = r100;
            return this;
        }

        public Builder edit_draft_id(String r100) {
            this.edit_draft_id = r100;
            return this;
        }

        public Builder edit_time_ms(Long r100) {
            this.edit_time_ms = r100;
            return this;
        }

        public Builder edit_version(Integer r100) {
            this.edit_version = r100;
            return this;
        }

        public Builder file_deleted_status(FileDeletedStatus r100) {
            this.file_deleted_status = r100;
            return this;
        }

        public Builder fold_id(Long r100) {
            this.fold_id = r100;
            return this;
        }

        public Builder forward_from_friend(Boolean r100) {
            this.forward_from_friend = r100;
            return this;
        }

        public Builder from_id(String r100) {
            this.from_id = r100;
            return this;
        }

        public Builder from_type(FromType r100) {
            this.from_type = r100;
            return this;
        }

        public Builder has_follow_up(Boolean r100) {
            this.has_follow_up = r100;
            return this;
        }

        public Builder i18n_content_language(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_content_language = r100;
            return this;
        }

        public Builder i18n_info(I18nInfo r100) {
            this.i18n_info = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253516id = r100;
            return this;
        }

        public Builder image_translation_ability(Map<String, ImageTranslationAbility> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_translation_ability = r100;
            return this;
        }

        public Builder in_chat_display_mode(ChatDisplayModeSetting r100) {
            this.in_chat_display_mode = r100;
            return this;
        }

        public Builder is_abnormal(Boolean r100) {
            this.is_abnormal = r100;
            return this;
        }

        public Builder is_ai_session_first_msg(Boolean r100) {
            this.is_ai_session_first_msg = r100;
            return this;
        }

        public Builder is_at_all(Boolean r100) {
            this.is_at_all = r100;
            return this;
        }

        public Builder is_at_me(Boolean r100) {
            this.is_at_me = r100;
            return this;
        }

        public Builder is_auto_translated_by_receiver(Boolean r100) {
            this.is_auto_translated_by_receiver = r100;
            return this;
        }

        public Builder is_badged(Boolean r100) {
            this.is_badged = r100;
            return this;
        }

        public Builder is_burned(Boolean r100) {
            this.is_burned = r100;
            return this;
        }

        public Builder is_cleaned(Boolean r100) {
            this.is_cleaned = r100;
            return this;
        }

        public Builder is_crypto_intermediate(Boolean r100) {
            this.is_crypto_intermediate = r100;
            return this;
        }

        public Builder is_decrypto_fail(Boolean r100) {
            this.is_decrypto_fail = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }

        public Builder is_edited(Boolean r100) {
            this.is_edited = r100;
            return this;
        }

        public Builder is_file_deleted(Boolean r100) {
            this.is_file_deleted = r100;
            return this;
        }

        public Builder is_flag(Boolean r100) {
            this.is_flag = r100;
            return this;
        }

        public Builder is_include_doc_url(Boolean r100) {
            this.is_include_doc_url = r100;
            return this;
        }

        public Builder is_manual_translated(Boolean r100) {
            this.is_manual_translated = r100;
            return this;
        }

        public Builder is_no_trace_deleted(Boolean r100) {
            this.is_no_trace_deleted = r100;
            return this;
        }

        public Builder is_on_time_del(Boolean r100) {
            this.is_on_time_del = r100;
            return this;
        }

        public Builder is_recalled(Boolean r100) {
            this.is_recalled = r100;
            return this;
        }

        public Builder is_reeditable(Boolean r100) {
            this.is_reeditable = r100;
            return this;
        }

        public Builder is_restricted(Boolean r100) {
            this.is_restricted = r100;
            return this;
        }

        public Builder is_secret_chat_decrypted_failed(Boolean r100) {
            this.is_secret_chat_decrypted_failed = r100;
            return this;
        }

        public Builder is_special_focus(Boolean r100) {
            this.is_special_focus = r100;
            return this;
        }

        public Builder is_truncated(Boolean r100) {
            this.is_truncated = r100;
            return this;
        }

        public Builder is_untranslateable(Boolean r100) {
            this.is_untranslateable = r100;
            return this;
        }

        public Builder is_urgent(Boolean r100) {
            this.is_urgent = r100;
            return this;
        }

        public Builder is_visible(Boolean r100) {
            this.is_visible = r100;
            return this;
        }

        public Builder me_read(Boolean r100) {
            this.me_read = r100;
            return this;
        }

        public Builder message_language(String r100) {
            this.message_language = r100;
            return this;
        }

        public Builder message_languages(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_languages = r100;
            return this;
        }

        public Builder msg_thread_draft_id(String r100) {
            this.msg_thread_draft_id = r100;
            return this;
        }

        public Builder origin_badge_count(Integer r100) {
            this.origin_badge_count = r100;
            return this;
        }

        public Builder origin_thread_badge_count(Integer r100) {
            this.origin_thread_badge_count = r100;
            return this;
        }

        public Builder original_sender_id(String r100) {
            this.original_sender_id = r100;
            return this;
        }

        public Builder parent_id(String r100) {
            this.parent_id = r100;
            return this;
        }

        public Builder parent_source_id(String r100) {
            this.parent_source_id = r100;
            return this;
        }

        public Builder partial_reply_info(PartialReplyInfo r100) {
            this.partial_reply_info = r100;
            return this;
        }

        public Builder pin(Pin r100) {
            this.pin = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder post_draft_id(String r100) {
            this.post_draft_id = r100;
            return this;
        }

        public Builder reactions(List<Reaction> r100) {
            Internal.checkElementsNotNull(r100);
            this.reactions = r100;
            return this;
        }

        public Builder read_at_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.read_at_chatter_ids = r100;
            return this;
        }

        public Builder read_count(Integer r100) {
            this.read_count = r100;
            return this;
        }

        public Builder recaller_id(String r100) {
            this.recaller_id = r100;
            return this;
        }

        public Builder recaller_identity(RecallerIdentity r100) {
            this.recaller_identity = r100;
            return this;
        }

        public Builder reminder_id(String r100) {
            this.reminder_id = r100;
            return this;
        }

        public Builder reply_count(Integer r100) {
            this.reply_count = r100;
            return this;
        }

        public Builder root_id(String r100) {
            this.root_id = r100;
            return this;
        }

        public Builder root_source_id(String r100) {
            this.root_source_id = r100;
            return this;
        }

        public Builder schedule_message_draft_id(String r100) {
            this.schedule_message_draft_id = r100;
            return this;
        }

        public Builder security_extra(SecurityESCReviewExtra r100) {
            this.security_extra = r100;
            return this;
        }

        public Builder sensitivity(MessageSensitivity r100) {
            this.sensitivity = r100;
            return this;
        }

        public Builder set_grey(Boolean r100) {
            this.set_grey = r100;
            return this;
        }

        public Builder should_notify(Boolean r100) {
            this.should_notify = r100;
            return this;
        }

        public Builder smart_ai_reply(AIReply r100) {
            this.smart_ai_reply = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(SourceType r100) {
            this.source_type = r100;
            return this;
        }

        public Builder static_resource_message_recalled(Boolean r100) {
            this.static_resource_message_recalled = r100;
            return this;
        }

        public Builder stream_sequence_id(Integer r100) {
            this.stream_sequence_id = r100;
            return this;
        }

        public Builder stream_status(StreamStatus r100) {
            this.stream_status = r100;
            return this;
        }

        public Builder sync_dependency(Boolean r100) {
            this.sync_dependency = r100;
            return this;
        }

        public Builder sync_to_chat_message_type(SyncToChatMessageType r100) {
            this.sync_to_chat_message_type = r100;
            return this;
        }

        public Builder sync_to_chat_related_message_id(Long r100) {
            this.sync_to_chat_related_message_id = r100;
            return this;
        }

        public Builder sync_to_chat_thread_root_id(Long r100) {
            this.sync_to_chat_thread_root_id = r100;
            return this;
        }

        public Builder text_draft_id(String r100) {
            this.text_draft_id = r100;
            return this;
        }

        public Builder thread_badge_count(Integer r100) {
            this.thread_badge_count = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_message_type(ThreadMessageType r100) {
            this.thread_message_type = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.thread_position = r100;
            return this;
        }

        public Builder thread_reply_count(Integer r100) {
            this.thread_reply_count = r100;
            return this;
        }

        public Builder translate_language(String r100) {
            this.translate_language = r100;
            return this;
        }

        public Builder translate_message_display_rule(TranslateMessageDisplayRule r100) {
            this.translate_message_display_rule = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder unack_urgent_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.unack_urgent_chatter_ids = r100;
            return this;
        }

        public Builder unread_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.unread_chatter_ids = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder urgent_id(String r100) {
            this.urgent_id = r100;
            return this;
        }

        public Builder version(Version r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class CardInfo extends com.squareup.wire.Message<CardInfo, Builder> {
        public static final ProtoAdapter<CardInfo> ADAPTER = null;
        public static final Long DEFAULT_UPDATE_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long update_time;

        public static final class Builder extends com.squareup.wire.Message.Builder<CardInfo, Builder> {
            public Long update_time;

            @Override // com.squareup.wire.Message.Builder
            public CardInfo build() {
                return new CardInfo(this.update_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder update_time(Long r100) {
                this.update_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CardInfo extends ProtoAdapter<CardInfo> {
            public ProtoAdapter_CardInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CardInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CardInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.update_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 3) goto L7;
                r101.update_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(CardInfo r100) {
                Long r101 = r100.update_time;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CardInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CardInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CardInfo r101) throws IOException {
                Long r102 = r101.update_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CardInfo();
            DEFAULT_UPDATE_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.update_time = this.update_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CardInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CardInfo(Long r100) {
            this(r100, ByteString.EMPTY);
        }

        public CardInfo(Long r100, ByteString r101) {
            super(ADAPTER, r101);
            this.update_time = r100;
        }
    }

    public static final enum ChatDisplayModeSetting extends Enum<ChatDisplayModeSetting> implements WireEnum {
        private static final /* synthetic */ ChatDisplayModeSetting[] $VALUES = null;
        public static final ProtoAdapter<ChatDisplayModeSetting> ADAPTER = null;
        public static final ChatDisplayModeSetting DEFAULT = null;
        public static final ChatDisplayModeSetting THREAD = null;
        public static final ChatDisplayModeSetting UNKNOWN_DISPLAY_MODE = null;
        private final int value;

        static {
            ChatDisplayModeSetting r100 = new ChatDisplayModeSetting("UNKNOWN_DISPLAY_MODE", 0, 0);
            UNKNOWN_DISPLAY_MODE = r100;
            ChatDisplayModeSetting r101 = new ChatDisplayModeSetting("DEFAULT", 1, 1);
            DEFAULT = r101;
            ChatDisplayModeSetting r102 = new ChatDisplayModeSetting("THREAD", 2, 2);
            THREAD = r102;
            $VALUES = new ChatDisplayModeSetting[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatDisplayModeSetting.class);
        }

        public static ChatDisplayModeSetting[] values() {
            return (ChatDisplayModeSetting[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatDisplayModeSetting fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return THREAD;
        L12:
            return DEFAULT;
        L14:
            return UNKNOWN_DISPLAY_MODE;
        }

        public static ChatDisplayModeSetting valueOf(String r100) {
            return (ChatDisplayModeSetting) a.a(ChatDisplayModeSetting.class, r100);
        }

        private ChatDisplayModeSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DisabledAction extends com.squareup.wire.Message<DisabledAction, Builder> {
        public static final ProtoAdapter<DisabledAction> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<Integer, Behavior> actions;

        public static final enum Action extends Enum<Action> implements WireEnum {
            private static final /* synthetic */ Action[] $VALUES = null;
            public static final Action ACTION_UNSPECIFIED = null;
            public static final ProtoAdapter<Action> ADAPTER = null;
            public static final Action ADD_STICKER = null;
            public static final Action ADD_TASK = null;
            public static final Action ALL_ACTION = null;
            public static final Action CHAT_PIN = null;
            public static final Action CLIP_TO_TOP = null;
            public static final Action COPY = null;
            public static final Action COPY_MESSAGE_LINK = null;
            public static final Action DELETE = null;
            public static final Action DERIVE = null;
            public static final Action DOWNLOAD = null;
            public static final Action EDIT_MESSAGE = null;
            public static final Action FAVORITE = null;
            public static final Action FLAG = null;
            public static final Action MULTI_SELECT = null;
            public static final Action PIN = null;
            public static final Action REACTION = null;
            public static final Action RECALL = null;
            public static final Action REPLY = null;
            public static final Action REPLY_IN_THREAD = null;
            public static final Action SAVE_TO_LOCAL = null;
            public static final Action SAVE_TO_SPACE = null;
            public static final Action SEND_URGENT = null;
            public static final Action TRANSLATE = null;
            public static final Action TRANSMIT = null;
            public static final Action Widgets = null;
            private final int value;

            static {
                Action r100 = new Action("ACTION_UNSPECIFIED", 0, 0);
                ACTION_UNSPECIFIED = r100;
                Action r101 = new Action("ALL_ACTION", 1, 1);
                ALL_ACTION = r101;
                Action r102 = new Action(CardAdapter.REACTION, 2, 2);
                REACTION = r102;
                Action r103 = new Action("REPLY", 3, 3);
                REPLY = r103;
                Action r104 = new Action("TRANSMIT", 4, 4);
                TRANSMIT = r104;
                Action r105 = new Action("REPLY_IN_THREAD", 5, 5);
                REPLY_IN_THREAD = r105;
                Action r110 = new Action("SEND_URGENT", 6, 6);
                SEND_URGENT = r110;
                Action r111 = new Action("RECALL", 7, 7);
                RECALL = r111;
                Action r112 = new Action("EDIT_MESSAGE", 8, 8);
                EDIT_MESSAGE = r112;
                Action r113 = new Action("MULTI_SELECT", 9, 9);
                MULTI_SELECT = r113;
                Action r114 = new Action("FLAG", 10, 10);
                FLAG = r114;
                Action r115 = new Action("FAVORITE", 11, 11);
                FAVORITE = r115;
                Action r106 = new Action("PIN", 12, 12);
                PIN = r106;
                Action r107 = new Action("CLIP_TO_TOP", 13, 13);
                CLIP_TO_TOP = r107;
                Action r108 = new Action("ADD_TASK", 14, 14);
                ADD_TASK = r108;
                Action r109 = new Action("TRANSLATE", 15, 15);
                TRANSLATE = r109;
                Action r116 = new Action("DELETE", 16, 16);
                DELETE = r116;
                Action r117 = new Action("SAVE_TO_LOCAL", 17, 17);
                SAVE_TO_LOCAL = r117;
                Action r118 = new Action("SAVE_TO_SPACE", 18, 18);
                SAVE_TO_SPACE = r118;
                Action r119 = new Action("ADD_STICKER", 19, 19);
                ADD_STICKER = r119;
                Action r120 = new Action(HttpMethod.DOWNLOAD, 20, 20);
                DOWNLOAD = r120;
                Action r121 = new Action("COPY", 21, 21);
                COPY = r121;
                Action r122 = new Action("COPY_MESSAGE_LINK", 22, 22);
                COPY_MESSAGE_LINK = r122;
                Action r123 = new Action("Widgets", 23, 23);
                Widgets = r123;
                Action r124 = new Action("CHAT_PIN", 24, 24);
                CHAT_PIN = r124;
                Action r125 = new Action("DERIVE", 25, 25);
                DERIVE = r125;
                $VALUES = new Action[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
                ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
            }

            public static Action[] values() {
                return (Action[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Action fromValue(int r100) {
                switch(r100) {
                    case 0: goto L56;
                    case 1: goto L54;
                    case 2: goto L52;
                    case 3: goto L50;
                    case 4: goto L48;
                    case 5: goto L46;
                    case 6: goto L44;
                    case 7: goto L42;
                    case 8: goto L40;
                    case 9: goto L38;
                    case 10: goto L36;
                    case 11: goto L34;
                    case 12: goto L32;
                    case 13: goto L30;
                    case 14: goto L28;
                    case 15: goto L26;
                    case 16: goto L24;
                    case 17: goto L22;
                    case 18: goto L20;
                    case 19: goto L18;
                    case 20: goto L16;
                    case 21: goto L14;
                    case 22: goto L12;
                    case 23: goto L10;
                    case 24: goto L8;
                    case 25: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DERIVE;
            L8:
                return CHAT_PIN;
            L10:
                return Widgets;
            L12:
                return COPY_MESSAGE_LINK;
            L14:
                return COPY;
            L16:
                return DOWNLOAD;
            L18:
                return ADD_STICKER;
            L20:
                return SAVE_TO_SPACE;
            L22:
                return SAVE_TO_LOCAL;
            L24:
                return DELETE;
            L26:
                return TRANSLATE;
            L28:
                return ADD_TASK;
            L30:
                return CLIP_TO_TOP;
            L32:
                return PIN;
            L34:
                return FAVORITE;
            L36:
                return FLAG;
            L38:
                return MULTI_SELECT;
            L40:
                return EDIT_MESSAGE;
            L42:
                return RECALL;
            L44:
                return SEND_URGENT;
            L46:
                return REPLY_IN_THREAD;
            L48:
                return TRANSMIT;
            L50:
                return REPLY;
            L52:
                return REACTION;
            L54:
                return ALL_ACTION;
            L56:
                return ACTION_UNSPECIFIED;
            }

            public static Action valueOf(String r100) {
                return (Action) a.a(Action.class, r100);
            }

            private Action(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Behavior extends com.squareup.wire.Message<Behavior, Builder> {
            public static final ProtoAdapter<Behavior> ADAPTER = null;
            public static final Integer DEFAULT_CODE = null;
            public static final DisplayMode DEFAULT_DISPLAY_MODE = null;
            private static final long serialVersionUID = 0;
            public final Integer code;
            public final DisplayMode display_mode;

            public static final class Builder extends com.squareup.wire.Message.Builder<Behavior, Builder> {
                public Integer code;
                public DisplayMode display_mode;

                @Override // com.squareup.wire.Message.Builder
                public Behavior build() {
                    return new Behavior(this.display_mode, this.code, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder code(Integer r100) {
                    this.code = r100;
                    return this;
                }

                public Builder display_mode(DisplayMode r100) {
                    this.display_mode = r100;
                    return this;
                }
            }

            public static final enum DisplayMode extends Enum<DisplayMode> implements WireEnum {
                private static final /* synthetic */ DisplayMode[] $VALUES = null;
                public static final ProtoAdapter<DisplayMode> ADAPTER = null;
                public static final DisplayMode DISABLE = null;
                public static final DisplayMode INVISIBLE = null;
                public static final DisplayMode MODE_UNSPECIFIED = null;
                private final int value;

                static {
                    DisplayMode r100 = new DisplayMode("MODE_UNSPECIFIED", 0, 0);
                    MODE_UNSPECIFIED = r100;
                    DisplayMode r101 = new DisplayMode("DISABLE", 1, 1);
                    DISABLE = r101;
                    DisplayMode r102 = new DisplayMode("INVISIBLE", 2, 2);
                    INVISIBLE = r102;
                    $VALUES = new DisplayMode[]{r100, r101, r102};
                    ADAPTER = ProtoAdapter.newEnumAdapter(DisplayMode.class);
                }

                public static DisplayMode[] values() {
                    return (DisplayMode[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static DisplayMode fromValue(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return INVISIBLE;
                L12:
                    return DISABLE;
                L14:
                    return MODE_UNSPECIFIED;
                }

                public static DisplayMode valueOf(String r100) {
                    return (DisplayMode) a.a(DisplayMode.class, r100);
                }

                private DisplayMode(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final class ProtoAdapter_Behavior extends ProtoAdapter<Behavior> {
                public ProtoAdapter_Behavior() {
                    super(FieldEncoding.LENGTH_DELIMITED, Behavior.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Behavior decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.display_mode = DisplayMode.MODE_UNSPECIFIED;
                    r101.code = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.display_mode = DisplayMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                L13:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.code = ProtoAdapter.INT32.decode(r100);
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
                public int encodedSize2(Behavior r100) {
                    DisplayMode r101 = r100.display_mode;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = DisplayMode.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.code;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Behavior decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Behavior r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Behavior r101) throws IOException {
                    DisplayMode r102 = r101.display_mode;
                    if (r102 == null) goto L5;
                    DisplayMode.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.code;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Behavior r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Behavior();
                DEFAULT_DISPLAY_MODE = DisplayMode.MODE_UNSPECIFIED;
                DEFAULT_CODE = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.display_mode = this.display_mode;
                r100.code = this.code;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Behavior.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Behavior(DisplayMode r100, Integer r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public Behavior(DisplayMode r100, Integer r101, ByteString r102) {
                super(ADAPTER, r102);
                this.display_mode = r100;
                this.code = r101;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<DisabledAction, Builder> {
            public Map<Integer, Behavior> actions;

            @Override // com.squareup.wire.Message.Builder
            public DisabledAction build() {
                return new DisabledAction(this.actions, super.buildUnknownFields());
            }

            public Builder() {
                this.actions = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder actions(Map<Integer, Behavior> r100) {
                Internal.checkElementsNotNull(r100);
                this.actions = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DisabledAction extends ProtoAdapter<DisabledAction> {
            private final ProtoAdapter<Map<Integer, Behavior>> actions;

            public ProtoAdapter_DisabledAction() {
                super(FieldEncoding.LENGTH_DELIMITED, DisabledAction.class);
                this.actions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, Behavior.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DisabledAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.actions.putAll(this.actions.decode(r100));
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
            public int encodedSize2(DisabledAction r100) {
                return this.actions.encodedSizeWithTag(1, r100.actions) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DisabledAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DisabledAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DisabledAction r101) throws IOException {
                this.actions.encodeWithTag(r100, 1, r101.actions);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisabledAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisabledAction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DisabledAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DisabledAction(Map<Integer, Behavior> r100) {
            this(r100, ByteString.EMPTY);
        }

        public DisabledAction(Map<Integer, Behavior> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r100);
        }
    }

    public static final enum FileDeletedStatus extends Enum<FileDeletedStatus> implements WireEnum {
        private static final /* synthetic */ FileDeletedStatus[] $VALUES = null;
        public static final ProtoAdapter<FileDeletedStatus> ADAPTER = null;
        public static final FileDeletedStatus FREED_UP = null;
        public static final FileDeletedStatus NORMAL = null;
        public static final FileDeletedStatus RECALLED = null;
        public static final FileDeletedStatus RECOVERABLE = null;
        public static final FileDeletedStatus UNRECOVERABLE = null;
        private final int value;

        static {
            FileDeletedStatus r100 = new FileDeletedStatus(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            FileDeletedStatus r101 = new FileDeletedStatus("RECOVERABLE", 1, 1);
            RECOVERABLE = r101;
            FileDeletedStatus r102 = new FileDeletedStatus("UNRECOVERABLE", 2, 2);
            UNRECOVERABLE = r102;
            FileDeletedStatus r103 = new FileDeletedStatus("RECALLED", 3, 3);
            RECALLED = r103;
            FileDeletedStatus r104 = new FileDeletedStatus("FREED_UP", 4, 4);
            FREED_UP = r104;
            $VALUES = new FileDeletedStatus[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileDeletedStatus.class);
        }

        public static FileDeletedStatus[] values() {
            return (FileDeletedStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FileDeletedStatus fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return FREED_UP;
        L16:
            return RECALLED;
        L18:
            return UNRECOVERABLE;
        L20:
            return RECOVERABLE;
        L22:
            return NORMAL;
        }

        public static FileDeletedStatus valueOf(String r100) {
            return (FileDeletedStatus) a.a(FileDeletedStatus.class, r100);
        }

        private FileDeletedStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FromType extends Enum<FromType> implements WireEnum {
        private static final /* synthetic */ FromType[] $VALUES = null;
        public static final ProtoAdapter<FromType> ADAPTER = null;
        public static final FromType BOT = null;
        public static final FromType UNKNOWN_FROM_TYPE = null;
        public static final FromType USER = null;
        private final int value;

        static {
            FromType r100 = new FromType("UNKNOWN_FROM_TYPE", 0, 0);
            UNKNOWN_FROM_TYPE = r100;
            FromType r101 = new FromType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            FromType r102 = new FromType("BOT", 2, 2);
            BOT = r102;
            $VALUES = new FromType[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BOT;
        L12:
            return USER;
        L14:
            return UNKNOWN_FROM_TYPE;
        }

        public static FromType valueOf(String r100) {
            return (FromType) a.a(FromType.class, r100);
        }

        private FromType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MessageAttachmentType extends Enum<MessageAttachmentType> implements WireEnum {
        private static final /* synthetic */ MessageAttachmentType[] $VALUES = null;
        public static final ProtoAdapter<MessageAttachmentType> ADAPTER = null;
        public static final MessageAttachmentType ATTACHMENT_FILE = null;
        public static final MessageAttachmentType ATTACHMENT_IMAGE = null;
        public static final MessageAttachmentType ATTACHMENT_LINK = null;
        public static final MessageAttachmentType ATTACHMENT_VIDEO = null;
        public static final MessageAttachmentType UNKNOWN_ATTACHMENT_TYPE = null;
        private final int value;

        static {
            MessageAttachmentType r100 = new MessageAttachmentType("UNKNOWN_ATTACHMENT_TYPE", 0, 0);
            UNKNOWN_ATTACHMENT_TYPE = r100;
            MessageAttachmentType r101 = new MessageAttachmentType("ATTACHMENT_IMAGE", 1, 1);
            ATTACHMENT_IMAGE = r101;
            MessageAttachmentType r102 = new MessageAttachmentType("ATTACHMENT_VIDEO", 2, 2);
            ATTACHMENT_VIDEO = r102;
            MessageAttachmentType r103 = new MessageAttachmentType("ATTACHMENT_FILE", 3, 3);
            ATTACHMENT_FILE = r103;
            MessageAttachmentType r104 = new MessageAttachmentType("ATTACHMENT_LINK", 4, 4);
            ATTACHMENT_LINK = r104;
            $VALUES = new MessageAttachmentType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(MessageAttachmentType.class);
        }

        public static MessageAttachmentType[] values() {
            return (MessageAttachmentType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MessageAttachmentType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return ATTACHMENT_LINK;
        L16:
            return ATTACHMENT_FILE;
        L18:
            return ATTACHMENT_VIDEO;
        L20:
            return ATTACHMENT_IMAGE;
        L22:
            return UNKNOWN_ATTACHMENT_TYPE;
        }

        public static MessageAttachmentType valueOf(String r100) {
            return (MessageAttachmentType) a.a(MessageAttachmentType.class, r100);
        }

        private MessageAttachmentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MessageSensitivity extends Enum<MessageSensitivity> implements WireEnum {
        private static final /* synthetic */ MessageSensitivity[] $VALUES = null;
        public static final ProtoAdapter<MessageSensitivity> ADAPTER = null;
        public static final MessageSensitivity DANGEROUS = null;
        public static final MessageSensitivity SAFE = null;
        public static final MessageSensitivity UNKNOWN_SENSITIVITY = null;
        private final int value;

        static {
            MessageSensitivity r100 = new MessageSensitivity("UNKNOWN_SENSITIVITY", 0, 0);
            UNKNOWN_SENSITIVITY = r100;
            MessageSensitivity r101 = new MessageSensitivity("SAFE", 1, 1);
            SAFE = r101;
            MessageSensitivity r102 = new MessageSensitivity("DANGEROUS", 2, 2);
            DANGEROUS = r102;
            $VALUES = new MessageSensitivity[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(MessageSensitivity.class);
        }

        public static MessageSensitivity[] values() {
            return (MessageSensitivity[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MessageSensitivity fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DANGEROUS;
        L12:
            return SAFE;
        L14:
            return UNKNOWN_SENSITIVITY;
        }

        public static MessageSensitivity valueOf(String r100) {
            return (MessageSensitivity) a.a(MessageSensitivity.class, r100);
        }

        private MessageSensitivity(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class PartialReplyInfo extends com.squareup.wire.Message<PartialReplyInfo, Builder> {
        public static final ProtoAdapter<PartialReplyInfo> ADAPTER = null;
        public static final PartialContentRelativePosition DEFAULT_POSITION = null;
        private static final long serialVersionUID = 0;
        public final RichText content;
        public final PartialContentRelativePosition position;

        public static final class Builder extends com.squareup.wire.Message.Builder<PartialReplyInfo, Builder> {
            public RichText content;
            public PartialContentRelativePosition position;

            @Override // com.squareup.wire.Message.Builder
            public PartialReplyInfo build() {
                return new PartialReplyInfo(this.content, this.position, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(RichText r100) {
                this.content = r100;
                return this;
            }

            public Builder position(PartialContentRelativePosition r100) {
                this.position = r100;
                return this;
            }
        }

        public static final enum PartialContentRelativePosition extends Enum<PartialContentRelativePosition> implements WireEnum {
            private static final /* synthetic */ PartialContentRelativePosition[] $VALUES = null;
            public static final ProtoAdapter<PartialContentRelativePosition> ADAPTER = null;
            public static final PartialContentRelativePosition HEAD = null;
            public static final PartialContentRelativePosition MIDDLE = null;
            public static final PartialContentRelativePosition TAIL = null;
            public static final PartialContentRelativePosition UNKNOWN = null;
            private final int value;

            static {
                PartialContentRelativePosition r100 = new PartialContentRelativePosition("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                PartialContentRelativePosition r101 = new PartialContentRelativePosition("HEAD", 1, 1);
                HEAD = r101;
                PartialContentRelativePosition r102 = new PartialContentRelativePosition("MIDDLE", 2, 2);
                MIDDLE = r102;
                PartialContentRelativePosition r103 = new PartialContentRelativePosition("TAIL", 3, 3);
                TAIL = r103;
                $VALUES = new PartialContentRelativePosition[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(PartialContentRelativePosition.class);
            }

            public static PartialContentRelativePosition[] values() {
                return (PartialContentRelativePosition[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static PartialContentRelativePosition fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return TAIL;
            L14:
                return MIDDLE;
            L16:
                return HEAD;
            L18:
                return UNKNOWN;
            }

            public static PartialContentRelativePosition valueOf(String r100) {
                return (PartialContentRelativePosition) a.a(PartialContentRelativePosition.class, r100);
            }

            private PartialContentRelativePosition(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_PartialReplyInfo extends ProtoAdapter<PartialReplyInfo> {
            public ProtoAdapter_PartialReplyInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PartialReplyInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PartialReplyInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.position = PartialContentRelativePosition.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.content = RichText.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.position = PartialContentRelativePosition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
            public int encodedSize2(PartialReplyInfo r100) {
                RichText r101 = r100.content;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                PartialContentRelativePosition r104 = r100.position;
                if (r104 == null) goto L10;
                r102 = PartialContentRelativePosition.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PartialReplyInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PartialReplyInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PartialReplyInfo r101) throws IOException {
                RichText r102 = r101.content;
                if (r102 == null) goto L5;
                RichText.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                PartialContentRelativePosition r103 = r101.position;
                if (r103 == null) goto L8;
                PartialContentRelativePosition.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PartialReplyInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PartialReplyInfo();
            DEFAULT_POSITION = PartialContentRelativePosition.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.position = this.position;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PartialReplyInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PartialReplyInfo(RichText r100, PartialContentRelativePosition r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public PartialReplyInfo(RichText r100, PartialContentRelativePosition r101, ByteString r102) {
            super(ADAPTER, r102);
            this.content = r100;
            this.position = r101;
        }
    }

    public static final class Pin extends com.squareup.wire.Message<Pin, Builder> {
        public static final ProtoAdapter<Pin> ADAPTER = null;
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_OPERATOR_ID = "";
        public static final Long DEFAULT_TIMESTAMP = null;
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253517id;
        public final String operator_id;
        public final Long timestamp;

        public static final class Builder extends com.squareup.wire.Message.Builder<Pin, Builder> {

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253518id;
            public String operator_id;
            public Long timestamp;

            @Override // com.squareup.wire.Message.Builder
            public Pin build() {
                String r100 = this.f253518id;
                if (r100 == null) goto L9;
                if (this.operator_id == null) goto L9;
                return new Pin(this.f253518id, this.operator_id, this.timestamp, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "id", this.operator_id, "operator_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder id(String r100) {
                this.f253518id = r100;
                return this;
            }

            public Builder operator_id(String r100) {
                this.operator_id = r100;
                return this;
            }

            public Builder timestamp(Long r100) {
                this.timestamp = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Pin extends ProtoAdapter<Pin> {
            public ProtoAdapter_Pin() {
                super(FieldEncoding.LENGTH_DELIMITED, Pin.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Pin decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253518id = "";
                r101.operator_id = "";
                r101.timestamp = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.f253518id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.operator_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.timestamp = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(Pin r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.f253517id) + r101.encodedSizeWithTag(2, r100.operator_id);
                Long r103 = r100.timestamp;
                if (r103 == null) goto L5;
                int r104 = ProtoAdapter.INT64.encodedSizeWithTag(3, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Pin decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Pin r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Pin r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.f253517id);
                r102.encodeWithTag(r100, 2, r101.operator_id);
                Long r103 = r101.timestamp;
                if (r103 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Pin r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Pin();
            DEFAULT_TIMESTAMP = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253518id = this.f253517id;
            r100.operator_id = this.operator_id;
            r100.timestamp = this.timestamp;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Pin.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Pin(String r100, String r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Pin(String r100, String r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.f253517id = r100;
            this.operator_id = r101;
            this.timestamp = r102;
        }
    }

    public static final class ProtoAdapter_Message extends ProtoAdapter<Message> {
        private final ProtoAdapter<Map<String, String>> i18n_content_language;
        private final ProtoAdapter<Map<String, ImageTranslationAbility>> image_translation_ability;

        public ProtoAdapter_Message() {
            super(FieldEncoding.LENGTH_DELIMITED, Message.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.image_translation_ability = ProtoAdapter.newMapAdapter(r100, ImageTranslationAbility.ADAPTER);
            this.i18n_content_language = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Message decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253516id = "";
            r101.type = Type.UNKNOWN;
            r101.chat_id = "";
            r101.thread_id = "";
            r101.create_time = 0L;
            r101.update_time = 0L;
            r101.root_id = "";
            r101.unread_count = 0;
            r101.from_id = "";
            Boolean r102 = Boolean.TRUE;
            r101.should_notify = r102;
            Boolean r103 = Boolean.FALSE;
            r101.is_recalled = r103;
            r101.is_edited = r103;
            r101.reply_count = 0;
            r101.position = 0;
            r101.cid = "";
            r101.me_read = r103;
            r101.reminder_id = "";
            r101.parent_source_id = "";
            r101.root_source_id = "";
            r101.is_urgent = r103;
            r101.urgent_id = "";
            r101.parent_id = "";
            r101.is_at_me = r103;
            r101.is_at_all = r103;
            r101.is_truncated = r103;
            r101.read_count = 0;
            r101.text_draft_id = "";
            r101.post_draft_id = "";
            r101.is_file_deleted = r103;
            r101.is_deleted = r103;
            r101.is_abnormal = r103;
            r101.from_type = FromType.UNKNOWN_FROM_TYPE;
            r101.doc_key = "";
            r101.is_visible = r102;
            r101.burn_life = 0;
            r101.burn_time = 0L;
            r101.thread_position = 0;
            r101.source_type = SourceType.TYPE_FROM_UNKONWN;
            r101.source_id = "";
            r101.translate_language = "";
            r101.recaller_id = "";
            r101.recaller_identity = RecallerIdentity.UNKNOWN_IDENTITY;
            r101.badge_count = 0;
            r101.is_reeditable = r103;
            r101.is_badged = r103;
            r101.is_untranslateable = r103;
            r101.thread_badge_count = 0;
            r101.thread_reply_count = 0;
            r101.is_burned = r103;
            r101.message_language = "";
            r101.is_auto_translated_by_receiver = r103;
            r101.is_no_trace_deleted = r103;
            r101.origin_badge_count = 0;
            r101.origin_thread_badge_count = 0;
            r101.sensitivity = MessageSensitivity.UNKNOWN_SENSITIVITY;
            r101.crypto_token = "";
            r101.is_decrypto_fail = r103;
            r101.is_secret_chat_decrypted_failed = r103;
            r101.is_manual_translated = r103;
            r101.original_sender_id = "";
            r101.forward_from_friend = r103;
            r101.static_resource_message_recalled = r103;
            r101.is_crypto_intermediate = r103;
            r101.is_special_focus = r103;
            r101.is_include_doc_url = r103;
            r101.file_deleted_status = FileDeletedStatus.NORMAL;
            r101.character_length = 0;
            r101.msg_thread_draft_id = "";
            r101.sync_dependency = r103;
            r101.is_flag = r103;
            r101.thread_message_type = ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
            r101.create_time_ms = 0L;
            r101.disable_search = r103;
            r101.edit_version = 0;
            r101.edit_time_ms = 0L;
            r101.edit_draft_id = "";
            r101.dlp_state = MessageDLPState.UNKNOWN_DLP_STATE;
            r101.fold_id = 0L;
            r101.schedule_message_draft_id = "";
            r101.in_chat_display_mode = ChatDisplayModeSetting.UNKNOWN_DISPLAY_MODE;
            r101.is_restricted = r103;
            r101.set_grey = r103;
            r101.is_on_time_del = r103;
            r101.is_cleaned = r103;
            r101.stream_status = StreamStatus.STREAM_UNKNOWN;
            r101.stream_sequence_id = 0;
            r101.ai_chat_mode_id = 0L;
            r101.ai_answer_raw_data = "";
            r101.ai_message_like_feedback_status = AIMessageLikeFeedbackStatus.UNKNOWN_STATUS;
            r101.ai_message_type = AIMessageType.OTHER;
            r101.sync_to_chat_thread_root_id = 0L;
            r101.sync_to_chat_message_type = SyncToChatMessageType.UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
            r101.sync_to_chat_related_message_id = 0L;
            r101.can_show_ai_progress = r103;
            r101.is_ai_session_first_msg = r103;
            r101.has_follow_up = r103;
            long r104 = r100.beginMessage();
        L3:
            int r105 = r100.nextTag();
            if (r105 == (-1)) goto L174;
            if (r105 != 170) goto L7;
            r101.cot_content = COTContent.ADAPTER.decode(r100);
            goto L3
        L7:
            switch(r105) {
                case 1: goto L172;
                case 2: goto L180;
                case 3: goto L167;
                case 4: goto L166;
                case 5: goto L165;
                case 6: goto L164;
                case 7: goto L163;
                case 8: goto L162;
                case 9: goto L161;
                case 10: goto L160;
                default: goto L8;
            };
        L180:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L170
        L170:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L160:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L161:
            r101.reactions.add(Reaction.ADAPTER.decode(r100));
            goto L3
        L162:
            r101.content = Content.ADAPTER.decode(r100);
            goto L3
        L163:
            r101.root_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L164:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L165:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L166:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L167:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L172:
            r101.f253516id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            switch(r105) {
                case 20: goto L159;
                case 21: goto L158;
                case 22: goto L157;
                case 23: goto L156;
                case 24: goto L155;
                case 25: goto L154;
                case 26: goto L153;
                case 27: goto L152;
                case 28: goto L151;
                case 29: goto L150;
                case 30: goto L149;
                case 31: goto L148;
                case 32: goto L147;
                case 33: goto L146;
                case 34: goto L145;
                case 35: goto L144;
                case 36: goto L143;
                case 37: goto L142;
                case 38: goto L141;
                case 39: goto L140;
                case 40: goto L139;
                case 41: goto L138;
                case 42: goto L137;
                case 43: goto L196;
                case 44: goto L132;
                case 45: goto L131;
                case 46: goto L130;
                case 47: goto L129;
                case 48: goto L128;
                case 49: goto L127;
                case 50: goto L126;
                case 51: goto L125;
                case 52: goto L188;
                case 53: goto L120;
                case 54: goto L119;
                case 55: goto L118;
                case 56: goto L198;
                case 57: goto L113;
                case 58: goto L112;
                case 59: goto L111;
                case 60: goto L110;
                case 61: goto L109;
                case 62: goto L108;
                case 63: goto L107;
                case 64: goto L106;
                case 65: goto L105;
                case 66: goto L104;
                case 67: goto L103;
                case 68: goto L102;
                case 69: goto L101;
                case 70: goto L100;
                case 71: goto L99;
                case 72: goto L184;
                case 73: goto L94;
                case 74: goto L93;
                case 75: goto L92;
                default: goto L9;
            };
        L184:
            r101.sensitivity = MessageSensitivity.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L97
        L97:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L188:
            r101.source_type = SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L123
        L123:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L196:
            r101.from_type = FromType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L135
        L135:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L198:
            r101.recaller_identity = RecallerIdentity.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L116
        L116:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L92:
            r101.is_secret_chat_decrypted_failed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L93:
            r101.is_decrypto_fail = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L94:
            r101.crypto_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L99:
            r101.origin_thread_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L100:
            r101.origin_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L101:
            r101.is_no_trace_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L102:
            r101.is_auto_translated_by_receiver = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L103:
            r101.message_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L104:
            r101.is_burned = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L105:
            r101.at_out_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L106:
            r101.thread_reply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L107:
            r101.thread_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L108:
            r101.read_at_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L109:
            r101.is_untranslateable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L110:
            r101.is_badged = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L111:
            r101.is_reeditable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L112:
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L113:
            r101.pin = Pin.ADAPTER.decode(r100);
            goto L3
        L118:
            r101.recaller_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L119:
            r101.translate_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L120:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L125:
            r101.thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L126:
            r101.burn_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L127:
            r101.burn_life = ProtoAdapter.INT32.decode(r100);
            goto L3
        L128:
            r101.is_visible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L129:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L130:
            r101.ack_urgent_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L131:
            r101.unack_urgent_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L132:
            r101.doc_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L137:
            r101.is_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L138:
            r101.is_file_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L139:
            r101.post_draft_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L140:
            r101.text_draft_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L141:
            r101.unread_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L142:
            r101.read_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L143:
            r101.is_truncated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L144:
            r101.is_at_all = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L145:
            r101.is_at_me = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L146:
            r101.parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L147:
            r101.urgent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L148:
            r101.is_urgent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L149:
            r101.root_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L150:
            r101.parent_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L151:
            r101.reminder_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L152:
            r101.me_read = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L153:
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L154:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L155:
            r101.reply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L156:
            r101.is_edited = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L157:
            r101.is_recalled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L158:
            r101.should_notify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L159:
            r101.from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            switch(r105) {
                case 80: goto L91;
                case 81: goto L90;
                case 82: goto L89;
                case 83: goto L88;
                case 84: goto L87;
                case 85: goto L86;
                case 86: goto L85;
                case 87: goto L84;
                case 88: goto L83;
                default: goto L10;
            };
        L83:
            r101.is_include_doc_url = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L84:
            r101.is_special_focus = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L85:
            r101.image_translation_ability.putAll(this.image_translation_ability.decode(r100));
            goto L3
        L86:
            r101.is_crypto_intermediate = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L87:
            r101.static_resource_message_recalled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L88:
            r101.forward_from_friend = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L89:
            r101.original_sender_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L90:
            r101.is_manual_translated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L91:
            r101.translate_message_display_rule = TranslateMessageDisplayRule.ADAPTER.decode(r100);
            goto L3
        L10:
            switch(r105) {
                case 90: goto L190;
                case 91: goto L78;
                case 92: goto L77;
                default: goto L11;
            };
        L190:
            r101.file_deleted_status = FileDeletedStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L81
        L81:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L77:
            r101.msg_thread_draft_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L78:
            r101.character_length = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            switch(r105) {
                case 100: goto L76;
                case 101: goto L75;
                case 102: goto L74;
                case 103: goto L176;
                case 104: goto L69;
                case 105: goto L68;
                case 106: goto L67;
                case 107: goto L66;
                case 108: goto L65;
                case 109: goto L64;
                case 110: goto L200;
                case 111: goto L59;
                case 112: goto L58;
                case 113: goto L57;
                case 114: goto L56;
                case 115: goto L55;
                case 116: goto L178;
                case 117: goto L50;
                case 118: goto L49;
                case 119: goto L48;
                case 120: goto L47;
                case 121: goto L46;
                case 122: goto L45;
                default: goto L12;
            };
        L176:
            r101.thread_message_type = ThreadMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L72
        L72:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L178:
            r101.in_chat_display_mode = ChatDisplayModeSetting.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L53
        L53:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L200:
            r101.dlp_state = MessageDLPState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L62
        L62:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L45:
            r101.security_extra = SecurityESCReviewExtra.ADAPTER.decode(r100);
            goto L3
        L46:
            r101.is_cleaned = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L47:
            r101.is_on_time_del = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L48:
            r101.disabled_action = DisabledAction.ADAPTER.decode(r100);
            goto L3
        L49:
            r101.set_grey = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L50:
            r101.is_restricted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L55:
            r101.schedule_message_draft_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L56:
            r101.version = Version.ADAPTER.decode(r100);
            goto L3
        L57:
            r101.fold_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L58:
            r101.i18n_info = I18nInfo.ADAPTER.decode(r100);
            goto L3
        L59:
            r101.message_languages.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L64:
            r101.edit_draft_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L65:
            r101.edit_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L66:
            r101.edit_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L67:
            r101.disable_search = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L68:
            r101.i18n_content_language.putAll(this.i18n_content_language.decode(r100));
            goto L3
        L69:
            r101.create_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L74:
            r101.is_flag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L75:
            r101.anonymous_info = AnonymousInfo.ADAPTER.decode(r100);
            goto L3
        L76:
            r101.sync_dependency = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            switch(r105) {
                case 150: goto L192;
                case 151: goto L40;
                case 152: goto L39;
                case 153: goto L38;
                case 154: goto L182;
                case 155: goto L186;
                case 156: goto L29;
                case 157: goto L194;
                case 158: goto L24;
                case 159: goto L23;
                case 160: goto L22;
                case 161: goto L21;
                case 162: goto L20;
                case 163: goto L19;
                case 164: goto L18;
                case 165: goto L17;
                case 166: goto L16;
                case 167: goto L15;
                case 168: goto L14;
                default: goto L13;
            };
        L182:
            r101.ai_message_like_feedback_status = AIMessageLikeFeedbackStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L186:
            r101.ai_message_type = AIMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
        L32:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L192:
            r101.stream_status = StreamStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L43
        L43:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L194:
            r101.sync_to_chat_message_type = SyncToChatMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            r101.smart_ai_reply = AIReply.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.card_info = CardInfo.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.is_abnormal = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.ai_reply_entry_info = AIReplyEntryInfo.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.ai_info = AIInfo.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.has_follow_up = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.authorized_source = AuthorizedSource.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.is_ai_session_first_msg = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.partial_reply_info = PartialReplyInfo.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.can_show_ai_progress = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.sync_to_chat_related_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L29:
            r101.sync_to_chat_thread_root_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L38:
            r101.ai_answer_raw_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.ai_chat_mode_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L40:
            r101.stream_sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r106 = r100.peekFieldEncoding();
            r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
            goto L3
        L174:
            r100.endMessage(r104);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Message r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.f253515id) + Type.ADAPTER.encodedSizeWithTag(2, r100.type)) + r101.encodedSizeWithTag(3, r100.chat_id);
            String r103 = r100.thread_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            ProtoAdapter<Long> r107 = ProtoAdapter.INT64;
            int r108 = ((((r106 + r107.encodedSizeWithTag(5, r100.create_time)) + r107.encodedSizeWithTag(6, r100.update_time)) + r101.encodedSizeWithTag(7, r100.root_id)) + Content.ADAPTER.encodedSizeWithTag(8, r100.content)) + Reaction.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.reactions);
            ProtoAdapter<Integer> r109 = ProtoAdapter.INT32;
            int r110 = r108 + r109.encodedSizeWithTag(10, r100.unread_count);
            String r111 = r100.from_id;
            if (r111 == null) goto L9;
            int r112 = r101.encodedSizeWithTag(20, r111);
        L10:
            int r113 = r110 + r112;
            Boolean r114 = r100.should_notify;
            if (r114 == null) goto L13;
            int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r114);
        L14:
            int r116 = r113 + r115;
            Boolean r117 = r100.is_recalled;
            if (r117 == null) goto L17;
            int r118 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r117);
        L18:
            int r119 = r116 + r118;
            Boolean r120 = r100.is_edited;
            if (r120 == null) goto L21;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r120);
        L22:
            int r122 = r119 + r121;
            Integer r123 = r100.reply_count;
            if (r123 == null) goto L25;
            int r124 = r109.encodedSizeWithTag(24, r123);
        L26:
            int r125 = r122 + r124;
            Integer r126 = r100.position;
            if (r126 == null) goto L29;
            int r127 = r109.encodedSizeWithTag(25, r126);
        L30:
            int r128 = r125 + r127;
            String r129 = r100.cid;
            if (r129 == null) goto L33;
            int r130 = r101.encodedSizeWithTag(26, r129);
        L34:
            int r131 = r128 + r130;
            Boolean r132 = r100.me_read;
            if (r132 == null) goto L37;
            int r133 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r132);
        L38:
            int r134 = r131 + r133;
            String r135 = r100.reminder_id;
            if (r135 == null) goto L41;
            int r136 = r101.encodedSizeWithTag(28, r135);
        L42:
            int r137 = r134 + r136;
            String r138 = r100.parent_source_id;
            if (r138 == null) goto L45;
            int r139 = r101.encodedSizeWithTag(29, r138);
        L46:
            int r140 = r137 + r139;
            String r141 = r100.root_source_id;
            if (r141 == null) goto L49;
            int r142 = r101.encodedSizeWithTag(30, r141);
        L50:
            int r143 = r140 + r142;
            Boolean r144 = r100.is_urgent;
            if (r144 == null) goto L53;
            int r145 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r144);
        L54:
            int r146 = r143 + r145;
            String r147 = r100.urgent_id;
            if (r147 == null) goto L57;
            int r148 = r101.encodedSizeWithTag(32, r147);
        L58:
            int r149 = r146 + r148;
            String r150 = r100.parent_id;
            if (r150 == null) goto L61;
            int r151 = r101.encodedSizeWithTag(33, r150);
        L62:
            int r152 = r149 + r151;
            Boolean r153 = r100.is_at_me;
            if (r153 == null) goto L65;
            int r154 = ProtoAdapter.BOOL.encodedSizeWithTag(34, r153);
        L66:
            int r155 = r152 + r154;
            Boolean r156 = r100.is_at_all;
            if (r156 == null) goto L69;
            int r157 = ProtoAdapter.BOOL.encodedSizeWithTag(35, r156);
        L70:
            int r158 = r155 + r157;
            Boolean r159 = r100.is_truncated;
            if (r159 == null) goto L73;
            int r160 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r159);
        L74:
            int r161 = r158 + r160;
            Integer r162 = r100.read_count;
            if (r162 == null) goto L77;
            int r163 = r109.encodedSizeWithTag(37, r162);
        L78:
            int r164 = (r161 + r163) + r101.asRepeated().encodedSizeWithTag(38, r100.unread_chatter_ids);
            String r165 = r100.text_draft_id;
            if (r165 == null) goto L81;
            int r166 = r101.encodedSizeWithTag(39, r165);
        L82:
            int r167 = r164 + r166;
            String r168 = r100.post_draft_id;
            if (r168 == null) goto L85;
            int r169 = r101.encodedSizeWithTag(40, r168);
        L86:
            int r170 = r167 + r169;
            Boolean r171 = r100.is_file_deleted;
            if (r171 == null) goto L89;
            int r172 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r171);
        L90:
            int r173 = r170 + r172;
            Boolean r174 = r100.is_deleted;
            if (r174 == null) goto L93;
            int r175 = ProtoAdapter.BOOL.encodedSizeWithTag(42, r174);
        L94:
            int r176 = r173 + r175;
            Boolean r177 = r100.is_abnormal;
            if (r177 == null) goto L97;
            int r178 = ProtoAdapter.BOOL.encodedSizeWithTag(166, r177);
        L98:
            int r179 = r176 + r178;
            FromType r180 = r100.from_type;
            if (r180 == null) goto L101;
            int r181 = FromType.ADAPTER.encodedSizeWithTag(43, r180);
        L102:
            int r182 = r179 + r181;
            String r183 = r100.doc_key;
            if (r183 == null) goto L105;
            int r184 = r101.encodedSizeWithTag(44, r183);
        L106:
            int r185 = ((r182 + r184) + r101.asRepeated().encodedSizeWithTag(45, r100.unack_urgent_chatter_ids)) + r101.asRepeated().encodedSizeWithTag(46, r100.ack_urgent_chatter_ids);
            Channel r186 = r100.channel;
            if (r186 == null) goto L109;
            int r187 = Channel.ADAPTER.encodedSizeWithTag(47, r186);
        L110:
            int r188 = r185 + r187;
            Boolean r189 = r100.is_visible;
            if (r189 == null) goto L113;
            int r190 = ProtoAdapter.BOOL.encodedSizeWithTag(48, r189);
        L114:
            int r191 = r188 + r190;
            Integer r192 = r100.burn_life;
            if (r192 == null) goto L117;
            int r193 = r109.encodedSizeWithTag(49, r192);
        L118:
            int r194 = r191 + r193;
            Long r195 = r100.burn_time;
            if (r195 == null) goto L121;
            int r196 = r107.encodedSizeWithTag(50, r195);
        L122:
            int r197 = r194 + r196;
            Integer r198 = r100.thread_position;
            if (r198 == null) goto L125;
            int r199 = r109.encodedSizeWithTag(51, r198);
        L126:
            int r200 = r197 + r199;
            SourceType r201 = r100.source_type;
            if (r201 == null) goto L129;
            int r202 = SourceType.ADAPTER.encodedSizeWithTag(52, r201);
        L130:
            int r203 = r200 + r202;
            String r204 = r100.source_id;
            if (r204 == null) goto L133;
            int r205 = r101.encodedSizeWithTag(53, r204);
        L134:
            int r206 = r203 + r205;
            String r207 = r100.translate_language;
            if (r207 == null) goto L137;
            int r208 = r101.encodedSizeWithTag(54, r207);
        L138:
            int r209 = r206 + r208;
            String r210 = r100.recaller_id;
            if (r210 == null) goto L141;
            int r211 = r101.encodedSizeWithTag(55, r210);
        L142:
            int r212 = r209 + r211;
            RecallerIdentity r213 = r100.recaller_identity;
            if (r213 == null) goto L145;
            int r214 = RecallerIdentity.ADAPTER.encodedSizeWithTag(56, r213);
        L146:
            int r215 = r212 + r214;
            Pin r216 = r100.pin;
            if (r216 == null) goto L149;
            int r217 = Pin.ADAPTER.encodedSizeWithTag(57, r216);
        L150:
            int r218 = r215 + r217;
            Integer r219 = r100.badge_count;
            if (r219 == null) goto L153;
            int r220 = r109.encodedSizeWithTag(58, r219);
        L154:
            int r221 = r218 + r220;
            Boolean r222 = r100.is_reeditable;
            if (r222 == null) goto L157;
            int r223 = ProtoAdapter.BOOL.encodedSizeWithTag(59, r222);
        L158:
            int r224 = r221 + r223;
            Boolean r225 = r100.is_badged;
            if (r225 == null) goto L161;
            int r226 = ProtoAdapter.BOOL.encodedSizeWithTag(60, r225);
        L162:
            int r227 = r224 + r226;
            Boolean r228 = r100.is_untranslateable;
            if (r228 == null) goto L165;
            int r229 = ProtoAdapter.BOOL.encodedSizeWithTag(61, r228);
        L166:
            int r230 = (r227 + r229) + r101.asRepeated().encodedSizeWithTag(62, r100.read_at_chatter_ids);
            Integer r231 = r100.thread_badge_count;
            if (r231 == null) goto L169;
            int r232 = r109.encodedSizeWithTag(63, r231);
        L170:
            int r233 = r230 + r232;
            Integer r234 = r100.thread_reply_count;
            if (r234 == null) goto L173;
            int r235 = r109.encodedSizeWithTag(64, r234);
        L174:
            int r236 = (r233 + r235) + r101.asRepeated().encodedSizeWithTag(65, r100.at_out_chatter_ids);
            Boolean r237 = r100.is_burned;
            if (r237 == null) goto L177;
            int r238 = ProtoAdapter.BOOL.encodedSizeWithTag(66, r237);
        L178:
            int r239 = r236 + r238;
            String r240 = r100.message_language;
            if (r240 == null) goto L181;
            int r241 = r101.encodedSizeWithTag(67, r240);
        L182:
            int r242 = r239 + r241;
            Boolean r243 = r100.is_auto_translated_by_receiver;
            if (r243 == null) goto L185;
            int r244 = ProtoAdapter.BOOL.encodedSizeWithTag(68, r243);
        L186:
            int r245 = r242 + r244;
            Boolean r246 = r100.is_no_trace_deleted;
            if (r246 == null) goto L189;
            int r247 = ProtoAdapter.BOOL.encodedSizeWithTag(69, r246);
        L190:
            int r248 = r245 + r247;
            Integer r249 = r100.origin_badge_count;
            if (r249 == null) goto L193;
            int r250 = r109.encodedSizeWithTag(70, r249);
        L194:
            int r251 = r248 + r250;
            Integer r252 = r100.origin_thread_badge_count;
            if (r252 == null) goto L197;
            int r253 = r109.encodedSizeWithTag(71, r252);
        L198:
            int r254 = r251 + r253;
            MessageSensitivity r255 = r100.sensitivity;
            if (r255 == null) goto L201;
            int r256 = MessageSensitivity.ADAPTER.encodedSizeWithTag(72, r255);
        L202:
            int r257 = r254 + r256;
            String r258 = r100.crypto_token;
            if (r258 == null) goto L205;
            int r259 = r101.encodedSizeWithTag(73, r258);
        L206:
            int r260 = r257 + r259;
            Boolean r261 = r100.is_decrypto_fail;
            if (r261 == null) goto L209;
            int r262 = ProtoAdapter.BOOL.encodedSizeWithTag(74, r261);
        L210:
            int r263 = r260 + r262;
            Boolean r264 = r100.is_secret_chat_decrypted_failed;
            if (r264 == null) goto L213;
            int r265 = ProtoAdapter.BOOL.encodedSizeWithTag(75, r264);
        L214:
            int r266 = r263 + r265;
            TranslateMessageDisplayRule r267 = r100.translate_message_display_rule;
            if (r267 == null) goto L217;
            int r268 = TranslateMessageDisplayRule.ADAPTER.encodedSizeWithTag(80, r267);
        L218:
            int r269 = r266 + r268;
            Boolean r270 = r100.is_manual_translated;
            if (r270 == null) goto L221;
            int r271 = ProtoAdapter.BOOL.encodedSizeWithTag(81, r270);
        L222:
            int r272 = r269 + r271;
            String r273 = r100.original_sender_id;
            if (r273 == null) goto L225;
            int r274 = r101.encodedSizeWithTag(82, r273);
        L226:
            int r275 = r272 + r274;
            Boolean r276 = r100.forward_from_friend;
            if (r276 == null) goto L229;
            int r277 = ProtoAdapter.BOOL.encodedSizeWithTag(83, r276);
        L230:
            int r278 = r275 + r277;
            Boolean r279 = r100.static_resource_message_recalled;
            if (r279 == null) goto L233;
            int r280 = ProtoAdapter.BOOL.encodedSizeWithTag(84, r279);
        L234:
            int r281 = r278 + r280;
            Boolean r282 = r100.is_crypto_intermediate;
            if (r282 == null) goto L237;
            int r283 = ProtoAdapter.BOOL.encodedSizeWithTag(85, r282);
        L238:
            int r284 = (r281 + r283) + this.image_translation_ability.encodedSizeWithTag(86, r100.image_translation_ability);
            Boolean r285 = r100.is_special_focus;
            if (r285 == null) goto L241;
            int r286 = ProtoAdapter.BOOL.encodedSizeWithTag(87, r285);
        L242:
            int r287 = r284 + r286;
            Boolean r288 = r100.is_include_doc_url;
            if (r288 == null) goto L245;
            int r289 = ProtoAdapter.BOOL.encodedSizeWithTag(88, r288);
        L246:
            int r290 = r287 + r289;
            FileDeletedStatus r291 = r100.file_deleted_status;
            if (r291 == null) goto L249;
            int r292 = FileDeletedStatus.ADAPTER.encodedSizeWithTag(90, r291);
        L250:
            int r293 = r290 + r292;
            Integer r294 = r100.character_length;
            if (r294 == null) goto L253;
            int r295 = r109.encodedSizeWithTag(91, r294);
        L254:
            int r296 = r293 + r295;
            String r297 = r100.msg_thread_draft_id;
            if (r297 == null) goto L257;
            int r298 = r101.encodedSizeWithTag(92, r297);
        L258:
            int r299 = r296 + r298;
            Boolean r300 = r100.sync_dependency;
            if (r300 == null) goto L261;
            int r301 = ProtoAdapter.BOOL.encodedSizeWithTag(100, r300);
        L262:
            int r302 = r299 + r301;
            AnonymousInfo r303 = r100.anonymous_info;
            if (r303 == null) goto L265;
            int r304 = AnonymousInfo.ADAPTER.encodedSizeWithTag(101, r303);
        L266:
            int r305 = r302 + r304;
            Boolean r306 = r100.is_flag;
            if (r306 == null) goto L269;
            int r307 = ProtoAdapter.BOOL.encodedSizeWithTag(102, r306);
        L270:
            int r308 = r305 + r307;
            ThreadMessageType r309 = r100.thread_message_type;
            if (r309 == null) goto L273;
            int r310 = ThreadMessageType.ADAPTER.encodedSizeWithTag(103, r309);
        L274:
            int r311 = r308 + r310;
            Long r312 = r100.create_time_ms;
            if (r312 == null) goto L277;
            int r313 = r107.encodedSizeWithTag(104, r312);
        L278:
            int r314 = (r311 + r313) + this.i18n_content_language.encodedSizeWithTag(105, r100.i18n_content_language);
            Boolean r315 = r100.disable_search;
            if (r315 == null) goto L281;
            int r316 = ProtoAdapter.BOOL.encodedSizeWithTag(106, r315);
        L282:
            int r317 = r314 + r316;
            Integer r318 = r100.edit_version;
            if (r318 == null) goto L285;
            int r319 = r109.encodedSizeWithTag(107, r318);
        L286:
            int r320 = r317 + r319;
            Long r321 = r100.edit_time_ms;
            if (r321 == null) goto L289;
            int r322 = r107.encodedSizeWithTag(108, r321);
        L290:
            int r323 = r320 + r322;
            String r324 = r100.edit_draft_id;
            if (r324 == null) goto L293;
            int r325 = r101.encodedSizeWithTag(109, r324);
        L294:
            int r326 = r323 + r325;
            MessageDLPState r327 = r100.dlp_state;
            if (r327 == null) goto L297;
            int r328 = MessageDLPState.ADAPTER.encodedSizeWithTag(110, r327);
        L298:
            int r329 = (r326 + r328) + r101.asRepeated().encodedSizeWithTag(111, r100.message_languages);
            I18nInfo r330 = r100.i18n_info;
            if (r330 == null) goto L301;
            int r331 = I18nInfo.ADAPTER.encodedSizeWithTag(112, r330);
        L302:
            int r332 = r329 + r331;
            Long r333 = r100.fold_id;
            if (r333 == null) goto L305;
            int r334 = r107.encodedSizeWithTag(113, r333);
        L306:
            int r335 = r332 + r334;
            Version r336 = r100.version;
            if (r336 == null) goto L309;
            int r337 = Version.ADAPTER.encodedSizeWithTag(114, r336);
        L310:
            int r338 = r335 + r337;
            String r339 = r100.schedule_message_draft_id;
            if (r339 == null) goto L313;
            int r340 = r101.encodedSizeWithTag(115, r339);
        L314:
            int r341 = r338 + r340;
            ChatDisplayModeSetting r342 = r100.in_chat_display_mode;
            if (r342 == null) goto L317;
            int r343 = ChatDisplayModeSetting.ADAPTER.encodedSizeWithTag(116, r342);
        L318:
            int r344 = r341 + r343;
            Boolean r345 = r100.is_restricted;
            if (r345 == null) goto L321;
            int r346 = ProtoAdapter.BOOL.encodedSizeWithTag(117, r345);
        L322:
            int r347 = r344 + r346;
            Boolean r348 = r100.set_grey;
            if (r348 == null) goto L325;
            int r349 = ProtoAdapter.BOOL.encodedSizeWithTag(118, r348);
        L326:
            int r350 = r347 + r349;
            DisabledAction r351 = r100.disabled_action;
            if (r351 == null) goto L329;
            int r352 = DisabledAction.ADAPTER.encodedSizeWithTag(119, r351);
        L330:
            int r353 = r350 + r352;
            Boolean r354 = r100.is_on_time_del;
            if (r354 == null) goto L333;
            int r355 = ProtoAdapter.BOOL.encodedSizeWithTag(120, r354);
        L334:
            int r356 = r353 + r355;
            Boolean r357 = r100.is_cleaned;
            if (r357 == null) goto L337;
            int r358 = ProtoAdapter.BOOL.encodedSizeWithTag(121, r357);
        L338:
            int r359 = r356 + r358;
            SecurityESCReviewExtra r360 = r100.security_extra;
            if (r360 == null) goto L341;
            int r361 = SecurityESCReviewExtra.ADAPTER.encodedSizeWithTag(122, r360);
        L342:
            int r362 = r359 + r361;
            StreamStatus r363 = r100.stream_status;
            if (r363 == null) goto L345;
            int r364 = StreamStatus.ADAPTER.encodedSizeWithTag(150, r363);
        L346:
            int r365 = r362 + r364;
            Integer r366 = r100.stream_sequence_id;
            if (r366 == null) goto L349;
            int r367 = r109.encodedSizeWithTag(151, r366);
        L350:
            int r368 = r365 + r367;
            Long r369 = r100.ai_chat_mode_id;
            if (r369 == null) goto L353;
            int r370 = r107.encodedSizeWithTag(152, r369);
        L354:
            int r371 = r368 + r370;
            String r372 = r100.ai_answer_raw_data;
            if (r372 == null) goto L357;
            int r373 = r101.encodedSizeWithTag(153, r372);
        L358:
            int r374 = r371 + r373;
            AIMessageLikeFeedbackStatus r375 = r100.ai_message_like_feedback_status;
            if (r375 == null) goto L361;
            int r376 = AIMessageLikeFeedbackStatus.ADAPTER.encodedSizeWithTag(154, r375);
        L362:
            int r377 = r374 + r376;
            AIMessageType r378 = r100.ai_message_type;
            if (r378 == null) goto L365;
            int r379 = AIMessageType.ADAPTER.encodedSizeWithTag(155, r378);
        L366:
            int r380 = r377 + r379;
            Long r381 = r100.sync_to_chat_thread_root_id;
            if (r381 == null) goto L369;
            int r382 = r107.encodedSizeWithTag(156, r381);
        L370:
            int r383 = r380 + r382;
            SyncToChatMessageType r384 = r100.sync_to_chat_message_type;
            if (r384 == null) goto L373;
            int r385 = SyncToChatMessageType.ADAPTER.encodedSizeWithTag(157, r384);
        L374:
            int r386 = r383 + r385;
            Long r387 = r100.sync_to_chat_related_message_id;
            if (r387 == null) goto L377;
            int r388 = r107.encodedSizeWithTag(158, r387);
        L378:
            int r389 = r386 + r388;
            Boolean r390 = r100.can_show_ai_progress;
            if (r390 == null) goto L381;
            int r391 = ProtoAdapter.BOOL.encodedSizeWithTag(159, r390);
        L382:
            int r392 = r389 + r391;
            PartialReplyInfo r393 = r100.partial_reply_info;
            if (r393 == null) goto L385;
            int r394 = PartialReplyInfo.ADAPTER.encodedSizeWithTag(160, r393);
        L386:
            int r395 = r392 + r394;
            Boolean r396 = r100.is_ai_session_first_msg;
            if (r396 == null) goto L389;
            int r397 = ProtoAdapter.BOOL.encodedSizeWithTag(161, r396);
        L390:
            int r398 = r395 + r397;
            AuthorizedSource r399 = r100.authorized_source;
            if (r399 == null) goto L393;
            int r400 = AuthorizedSource.ADAPTER.encodedSizeWithTag(162, r399);
        L394:
            int r401 = r398 + r400;
            Boolean r402 = r100.has_follow_up;
            if (r402 == null) goto L397;
            int r403 = ProtoAdapter.BOOL.encodedSizeWithTag(163, r402);
        L398:
            int r404 = r401 + r403;
            AIInfo r405 = r100.ai_info;
            if (r405 == null) goto L401;
            int r406 = AIInfo.ADAPTER.encodedSizeWithTag(164, r405);
        L402:
            int r407 = r404 + r406;
            AIReplyEntryInfo r408 = r100.ai_reply_entry_info;
            if (r408 == null) goto L405;
            int r409 = AIReplyEntryInfo.ADAPTER.encodedSizeWithTag(165, r408);
        L406:
            int r410 = r407 + r409;
            CardInfo r411 = r100.card_info;
            if (r411 == null) goto L409;
            int r412 = CardInfo.ADAPTER.encodedSizeWithTag(167, r411);
        L410:
            int r413 = r410 + r412;
            AIReply r414 = r100.smart_ai_reply;
            if (r414 == null) goto L413;
            int r415 = AIReply.ADAPTER.encodedSizeWithTag(168, r414);
        L414:
            int r416 = r413 + r415;
            COTContent r417 = r100.cot_content;
            if (r417 == null) goto L418;
            r104 = COTContent.ADAPTER.encodedSizeWithTag(170, r417);
        L418:
            return (r416 + r104) + r100.unknownFields().size();
        L413:
            r415 = 0;
            goto L414
        L409:
            r412 = 0;
            goto L410
        L405:
            r409 = 0;
            goto L406
        L401:
            r406 = 0;
            goto L402
        L397:
            r403 = 0;
            goto L398
        L393:
            r400 = 0;
            goto L394
        L389:
            r397 = 0;
            goto L390
        L385:
            r394 = 0;
            goto L386
        L381:
            r391 = 0;
            goto L382
        L377:
            r388 = 0;
            goto L378
        L373:
            r385 = 0;
            goto L374
        L369:
            r382 = 0;
            goto L370
        L365:
            r379 = 0;
            goto L366
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
            r343 = 0;
            goto L318
        L313:
            r340 = 0;
            goto L314
        L309:
            r337 = 0;
            goto L310
        L305:
            r334 = 0;
            goto L306
        L301:
            r331 = 0;
            goto L302
        L297:
            r328 = 0;
            goto L298
        L293:
            r325 = 0;
            goto L294
        L289:
            r322 = 0;
            goto L290
        L285:
            r319 = 0;
            goto L286
        L281:
            r316 = 0;
            goto L282
        L277:
            r313 = 0;
            goto L278
        L273:
            r310 = 0;
            goto L274
        L269:
            r307 = 0;
            goto L270
        L265:
            r304 = 0;
            goto L266
        L261:
            r301 = 0;
            goto L262
        L257:
            r298 = 0;
            goto L258
        L253:
            r295 = 0;
            goto L254
        L249:
            r292 = 0;
            goto L250
        L245:
            r289 = 0;
            goto L246
        L241:
            r286 = 0;
            goto L242
        L237:
            r283 = 0;
            goto L238
        L233:
            r280 = 0;
            goto L234
        L229:
            r277 = 0;
            goto L230
        L225:
            r274 = 0;
            goto L226
        L221:
            r271 = 0;
            goto L222
        L217:
            r268 = 0;
            goto L218
        L213:
            r265 = 0;
            goto L214
        L209:
            r262 = 0;
            goto L210
        L205:
            r259 = 0;
            goto L206
        L201:
            r256 = 0;
            goto L202
        L197:
            r253 = 0;
            goto L198
        L193:
            r250 = 0;
            goto L194
        L189:
            r247 = 0;
            goto L190
        L185:
            r244 = 0;
            goto L186
        L181:
            r241 = 0;
            goto L182
        L177:
            r238 = 0;
            goto L178
        L173:
            r235 = 0;
            goto L174
        L169:
            r232 = 0;
            goto L170
        L165:
            r229 = 0;
            goto L166
        L161:
            r226 = 0;
            goto L162
        L157:
            r223 = 0;
            goto L158
        L153:
            r220 = 0;
            goto L154
        L149:
            r217 = 0;
            goto L150
        L145:
            r214 = 0;
            goto L146
        L141:
            r211 = 0;
            goto L142
        L137:
            r208 = 0;
            goto L138
        L133:
            r205 = 0;
            goto L134
        L129:
            r202 = 0;
            goto L130
        L125:
            r199 = 0;
            goto L126
        L121:
            r196 = 0;
            goto L122
        L117:
            r193 = 0;
            goto L118
        L113:
            r190 = 0;
            goto L114
        L109:
            r187 = 0;
            goto L110
        L105:
            r184 = 0;
            goto L106
        L101:
            r181 = 0;
            goto L102
        L97:
            r178 = 0;
            goto L98
        L93:
            r175 = 0;
            goto L94
        L89:
            r172 = 0;
            goto L90
        L85:
            r169 = 0;
            goto L86
        L81:
            r166 = 0;
            goto L82
        L77:
            r163 = 0;
            goto L78
        L73:
            r160 = 0;
            goto L74
        L69:
            r157 = 0;
            goto L70
        L65:
            r154 = 0;
            goto L66
        L61:
            r151 = 0;
            goto L62
        L57:
            r148 = 0;
            goto L58
        L53:
            r145 = 0;
            goto L54
        L49:
            r142 = 0;
            goto L50
        L45:
            r139 = 0;
            goto L46
        L41:
            r136 = 0;
            goto L42
        L37:
            r133 = 0;
            goto L38
        L33:
            r130 = 0;
            goto L34
        L29:
            r127 = 0;
            goto L30
        L25:
            r124 = 0;
            goto L26
        L21:
            r121 = 0;
            goto L22
        L17:
            r118 = 0;
            goto L18
        L13:
            r115 = 0;
            goto L14
        L9:
            r112 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Message decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Message r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Message r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253515id);
            Type.ADAPTER.encodeWithTag(r100, 2, r101.type);
            r102.encodeWithTag(r100, 3, r101.chat_id);
            String r103 = r101.thread_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            r104.encodeWithTag(r100, 5, r101.create_time);
            r104.encodeWithTag(r100, 6, r101.update_time);
            r102.encodeWithTag(r100, 7, r101.root_id);
            Content.ADAPTER.encodeWithTag(r100, 8, r101.content);
            Reaction.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.reactions);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            r105.encodeWithTag(r100, 10, r101.unread_count);
            String r106 = r101.from_id;
            if (r106 == null) goto L8;
            r102.encodeWithTag(r100, 20, r106);
        L8:
            Boolean r107 = r101.should_notify;
            if (r107 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r107);
        L11:
            Boolean r108 = r101.is_recalled;
            if (r108 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 22, r108);
        L14:
            Boolean r109 = r101.is_edited;
            if (r109 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 23, r109);
        L17:
            Integer r110 = r101.reply_count;
            if (r110 == null) goto L20;
            r105.encodeWithTag(r100, 24, r110);
        L20:
            Integer r111 = r101.position;
            if (r111 == null) goto L23;
            r105.encodeWithTag(r100, 25, r111);
        L23:
            String r112 = r101.cid;
            if (r112 == null) goto L26;
            r102.encodeWithTag(r100, 26, r112);
        L26:
            Boolean r113 = r101.me_read;
            if (r113 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r113);
        L29:
            String r114 = r101.reminder_id;
            if (r114 == null) goto L32;
            r102.encodeWithTag(r100, 28, r114);
        L32:
            String r115 = r101.parent_source_id;
            if (r115 == null) goto L35;
            r102.encodeWithTag(r100, 29, r115);
        L35:
            String r116 = r101.root_source_id;
            if (r116 == null) goto L38;
            r102.encodeWithTag(r100, 30, r116);
        L38:
            Boolean r117 = r101.is_urgent;
            if (r117 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r117);
        L41:
            String r118 = r101.urgent_id;
            if (r118 == null) goto L44;
            r102.encodeWithTag(r100, 32, r118);
        L44:
            String r119 = r101.parent_id;
            if (r119 == null) goto L47;
            r102.encodeWithTag(r100, 33, r119);
        L47:
            Boolean r120 = r101.is_at_me;
            if (r120 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 34, r120);
        L50:
            Boolean r121 = r101.is_at_all;
            if (r121 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 35, r121);
        L53:
            Boolean r122 = r101.is_truncated;
            if (r122 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 36, r122);
        L56:
            Integer r123 = r101.read_count;
            if (r123 == null) goto L59;
            r105.encodeWithTag(r100, 37, r123);
        L59:
            r102.asRepeated().encodeWithTag(r100, 38, r101.unread_chatter_ids);
            String r124 = r101.text_draft_id;
            if (r124 == null) goto L62;
            r102.encodeWithTag(r100, 39, r124);
        L62:
            String r125 = r101.post_draft_id;
            if (r125 == null) goto L65;
            r102.encodeWithTag(r100, 40, r125);
        L65:
            Boolean r126 = r101.is_file_deleted;
            if (r126 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r100, 41, r126);
        L68:
            Boolean r127 = r101.is_deleted;
            if (r127 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r100, 42, r127);
        L71:
            Boolean r128 = r101.is_abnormal;
            if (r128 == null) goto L74;
            ProtoAdapter.BOOL.encodeWithTag(r100, 166, r128);
        L74:
            FromType r129 = r101.from_type;
            if (r129 == null) goto L77;
            FromType.ADAPTER.encodeWithTag(r100, 43, r129);
        L77:
            String r130 = r101.doc_key;
            if (r130 == null) goto L80;
            r102.encodeWithTag(r100, 44, r130);
        L80:
            r102.asRepeated().encodeWithTag(r100, 45, r101.unack_urgent_chatter_ids);
            r102.asRepeated().encodeWithTag(r100, 46, r101.ack_urgent_chatter_ids);
            Channel r131 = r101.channel;
            if (r131 == null) goto L83;
            Channel.ADAPTER.encodeWithTag(r100, 47, r131);
        L83:
            Boolean r132 = r101.is_visible;
            if (r132 == null) goto L86;
            ProtoAdapter.BOOL.encodeWithTag(r100, 48, r132);
        L86:
            Integer r133 = r101.burn_life;
            if (r133 == null) goto L89;
            r105.encodeWithTag(r100, 49, r133);
        L89:
            Long r134 = r101.burn_time;
            if (r134 == null) goto L92;
            r104.encodeWithTag(r100, 50, r134);
        L92:
            Integer r135 = r101.thread_position;
            if (r135 == null) goto L95;
            r105.encodeWithTag(r100, 51, r135);
        L95:
            SourceType r136 = r101.source_type;
            if (r136 == null) goto L98;
            SourceType.ADAPTER.encodeWithTag(r100, 52, r136);
        L98:
            String r137 = r101.source_id;
            if (r137 == null) goto L101;
            r102.encodeWithTag(r100, 53, r137);
        L101:
            String r138 = r101.translate_language;
            if (r138 == null) goto L104;
            r102.encodeWithTag(r100, 54, r138);
        L104:
            String r139 = r101.recaller_id;
            if (r139 == null) goto L107;
            r102.encodeWithTag(r100, 55, r139);
        L107:
            RecallerIdentity r140 = r101.recaller_identity;
            if (r140 == null) goto L110;
            RecallerIdentity.ADAPTER.encodeWithTag(r100, 56, r140);
        L110:
            Pin r141 = r101.pin;
            if (r141 == null) goto L113;
            Pin.ADAPTER.encodeWithTag(r100, 57, r141);
        L113:
            Integer r142 = r101.badge_count;
            if (r142 == null) goto L116;
            r105.encodeWithTag(r100, 58, r142);
        L116:
            Boolean r143 = r101.is_reeditable;
            if (r143 == null) goto L119;
            ProtoAdapter.BOOL.encodeWithTag(r100, 59, r143);
        L119:
            Boolean r144 = r101.is_badged;
            if (r144 == null) goto L122;
            ProtoAdapter.BOOL.encodeWithTag(r100, 60, r144);
        L122:
            Boolean r145 = r101.is_untranslateable;
            if (r145 == null) goto L125;
            ProtoAdapter.BOOL.encodeWithTag(r100, 61, r145);
        L125:
            r102.asRepeated().encodeWithTag(r100, 62, r101.read_at_chatter_ids);
            Integer r146 = r101.thread_badge_count;
            if (r146 == null) goto L128;
            r105.encodeWithTag(r100, 63, r146);
        L128:
            Integer r147 = r101.thread_reply_count;
            if (r147 == null) goto L131;
            r105.encodeWithTag(r100, 64, r147);
        L131:
            r102.asRepeated().encodeWithTag(r100, 65, r101.at_out_chatter_ids);
            Boolean r148 = r101.is_burned;
            if (r148 == null) goto L134;
            ProtoAdapter.BOOL.encodeWithTag(r100, 66, r148);
        L134:
            String r149 = r101.message_language;
            if (r149 == null) goto L137;
            r102.encodeWithTag(r100, 67, r149);
        L137:
            Boolean r150 = r101.is_auto_translated_by_receiver;
            if (r150 == null) goto L140;
            ProtoAdapter.BOOL.encodeWithTag(r100, 68, r150);
        L140:
            Boolean r151 = r101.is_no_trace_deleted;
            if (r151 == null) goto L143;
            ProtoAdapter.BOOL.encodeWithTag(r100, 69, r151);
        L143:
            Integer r152 = r101.origin_badge_count;
            if (r152 == null) goto L146;
            r105.encodeWithTag(r100, 70, r152);
        L146:
            Integer r153 = r101.origin_thread_badge_count;
            if (r153 == null) goto L149;
            r105.encodeWithTag(r100, 71, r153);
        L149:
            MessageSensitivity r154 = r101.sensitivity;
            if (r154 == null) goto L152;
            MessageSensitivity.ADAPTER.encodeWithTag(r100, 72, r154);
        L152:
            String r155 = r101.crypto_token;
            if (r155 == null) goto L155;
            r102.encodeWithTag(r100, 73, r155);
        L155:
            Boolean r156 = r101.is_decrypto_fail;
            if (r156 == null) goto L158;
            ProtoAdapter.BOOL.encodeWithTag(r100, 74, r156);
        L158:
            Boolean r157 = r101.is_secret_chat_decrypted_failed;
            if (r157 == null) goto L161;
            ProtoAdapter.BOOL.encodeWithTag(r100, 75, r157);
        L161:
            TranslateMessageDisplayRule r158 = r101.translate_message_display_rule;
            if (r158 == null) goto L164;
            TranslateMessageDisplayRule.ADAPTER.encodeWithTag(r100, 80, r158);
        L164:
            Boolean r159 = r101.is_manual_translated;
            if (r159 == null) goto L167;
            ProtoAdapter.BOOL.encodeWithTag(r100, 81, r159);
        L167:
            String r160 = r101.original_sender_id;
            if (r160 == null) goto L170;
            r102.encodeWithTag(r100, 82, r160);
        L170:
            Boolean r161 = r101.forward_from_friend;
            if (r161 == null) goto L173;
            ProtoAdapter.BOOL.encodeWithTag(r100, 83, r161);
        L173:
            Boolean r162 = r101.static_resource_message_recalled;
            if (r162 == null) goto L176;
            ProtoAdapter.BOOL.encodeWithTag(r100, 84, r162);
        L176:
            Boolean r163 = r101.is_crypto_intermediate;
            if (r163 == null) goto L179;
            ProtoAdapter.BOOL.encodeWithTag(r100, 85, r163);
        L179:
            this.image_translation_ability.encodeWithTag(r100, 86, r101.image_translation_ability);
            Boolean r164 = r101.is_special_focus;
            if (r164 == null) goto L182;
            ProtoAdapter.BOOL.encodeWithTag(r100, 87, r164);
        L182:
            Boolean r165 = r101.is_include_doc_url;
            if (r165 == null) goto L185;
            ProtoAdapter.BOOL.encodeWithTag(r100, 88, r165);
        L185:
            FileDeletedStatus r166 = r101.file_deleted_status;
            if (r166 == null) goto L188;
            FileDeletedStatus.ADAPTER.encodeWithTag(r100, 90, r166);
        L188:
            Integer r167 = r101.character_length;
            if (r167 == null) goto L191;
            r105.encodeWithTag(r100, 91, r167);
        L191:
            String r168 = r101.msg_thread_draft_id;
            if (r168 == null) goto L194;
            r102.encodeWithTag(r100, 92, r168);
        L194:
            Boolean r169 = r101.sync_dependency;
            if (r169 == null) goto L197;
            ProtoAdapter.BOOL.encodeWithTag(r100, 100, r169);
        L197:
            AnonymousInfo r170 = r101.anonymous_info;
            if (r170 == null) goto L200;
            AnonymousInfo.ADAPTER.encodeWithTag(r100, 101, r170);
        L200:
            Boolean r171 = r101.is_flag;
            if (r171 == null) goto L203;
            ProtoAdapter.BOOL.encodeWithTag(r100, 102, r171);
        L203:
            ThreadMessageType r172 = r101.thread_message_type;
            if (r172 == null) goto L206;
            ThreadMessageType.ADAPTER.encodeWithTag(r100, 103, r172);
        L206:
            Long r173 = r101.create_time_ms;
            if (r173 == null) goto L209;
            r104.encodeWithTag(r100, 104, r173);
        L209:
            this.i18n_content_language.encodeWithTag(r100, 105, r101.i18n_content_language);
            Boolean r174 = r101.disable_search;
            if (r174 == null) goto L212;
            ProtoAdapter.BOOL.encodeWithTag(r100, 106, r174);
        L212:
            Integer r175 = r101.edit_version;
            if (r175 == null) goto L215;
            r105.encodeWithTag(r100, 107, r175);
        L215:
            Long r176 = r101.edit_time_ms;
            if (r176 == null) goto L218;
            r104.encodeWithTag(r100, 108, r176);
        L218:
            String r177 = r101.edit_draft_id;
            if (r177 == null) goto L221;
            r102.encodeWithTag(r100, 109, r177);
        L221:
            MessageDLPState r178 = r101.dlp_state;
            if (r178 == null) goto L224;
            MessageDLPState.ADAPTER.encodeWithTag(r100, 110, r178);
        L224:
            r102.asRepeated().encodeWithTag(r100, 111, r101.message_languages);
            I18nInfo r179 = r101.i18n_info;
            if (r179 == null) goto L227;
            I18nInfo.ADAPTER.encodeWithTag(r100, 112, r179);
        L227:
            Long r180 = r101.fold_id;
            if (r180 == null) goto L230;
            r104.encodeWithTag(r100, 113, r180);
        L230:
            Version r181 = r101.version;
            if (r181 == null) goto L233;
            Version.ADAPTER.encodeWithTag(r100, 114, r181);
        L233:
            String r182 = r101.schedule_message_draft_id;
            if (r182 == null) goto L236;
            r102.encodeWithTag(r100, 115, r182);
        L236:
            ChatDisplayModeSetting r183 = r101.in_chat_display_mode;
            if (r183 == null) goto L239;
            ChatDisplayModeSetting.ADAPTER.encodeWithTag(r100, 116, r183);
        L239:
            Boolean r184 = r101.is_restricted;
            if (r184 == null) goto L242;
            ProtoAdapter.BOOL.encodeWithTag(r100, 117, r184);
        L242:
            Boolean r185 = r101.set_grey;
            if (r185 == null) goto L245;
            ProtoAdapter.BOOL.encodeWithTag(r100, 118, r185);
        L245:
            DisabledAction r186 = r101.disabled_action;
            if (r186 == null) goto L248;
            DisabledAction.ADAPTER.encodeWithTag(r100, 119, r186);
        L248:
            Boolean r187 = r101.is_on_time_del;
            if (r187 == null) goto L251;
            ProtoAdapter.BOOL.encodeWithTag(r100, 120, r187);
        L251:
            Boolean r188 = r101.is_cleaned;
            if (r188 == null) goto L254;
            ProtoAdapter.BOOL.encodeWithTag(r100, 121, r188);
        L254:
            SecurityESCReviewExtra r189 = r101.security_extra;
            if (r189 == null) goto L257;
            SecurityESCReviewExtra.ADAPTER.encodeWithTag(r100, 122, r189);
        L257:
            StreamStatus r190 = r101.stream_status;
            if (r190 == null) goto L260;
            StreamStatus.ADAPTER.encodeWithTag(r100, 150, r190);
        L260:
            Integer r191 = r101.stream_sequence_id;
            if (r191 == null) goto L263;
            r105.encodeWithTag(r100, 151, r191);
        L263:
            Long r192 = r101.ai_chat_mode_id;
            if (r192 == null) goto L266;
            r104.encodeWithTag(r100, 152, r192);
        L266:
            String r193 = r101.ai_answer_raw_data;
            if (r193 == null) goto L269;
            r102.encodeWithTag(r100, 153, r193);
        L269:
            AIMessageLikeFeedbackStatus r194 = r101.ai_message_like_feedback_status;
            if (r194 == null) goto L272;
            AIMessageLikeFeedbackStatus.ADAPTER.encodeWithTag(r100, 154, r194);
        L272:
            AIMessageType r195 = r101.ai_message_type;
            if (r195 == null) goto L275;
            AIMessageType.ADAPTER.encodeWithTag(r100, 155, r195);
        L275:
            Long r196 = r101.sync_to_chat_thread_root_id;
            if (r196 == null) goto L278;
            r104.encodeWithTag(r100, 156, r196);
        L278:
            SyncToChatMessageType r197 = r101.sync_to_chat_message_type;
            if (r197 == null) goto L281;
            SyncToChatMessageType.ADAPTER.encodeWithTag(r100, 157, r197);
        L281:
            Long r198 = r101.sync_to_chat_related_message_id;
            if (r198 == null) goto L284;
            r104.encodeWithTag(r100, 158, r198);
        L284:
            Boolean r199 = r101.can_show_ai_progress;
            if (r199 == null) goto L287;
            ProtoAdapter.BOOL.encodeWithTag(r100, 159, r199);
        L287:
            PartialReplyInfo r200 = r101.partial_reply_info;
            if (r200 == null) goto L290;
            PartialReplyInfo.ADAPTER.encodeWithTag(r100, 160, r200);
        L290:
            Boolean r201 = r101.is_ai_session_first_msg;
            if (r201 == null) goto L293;
            ProtoAdapter.BOOL.encodeWithTag(r100, 161, r201);
        L293:
            AuthorizedSource r202 = r101.authorized_source;
            if (r202 == null) goto L296;
            AuthorizedSource.ADAPTER.encodeWithTag(r100, 162, r202);
        L296:
            Boolean r203 = r101.has_follow_up;
            if (r203 == null) goto L299;
            ProtoAdapter.BOOL.encodeWithTag(r100, 163, r203);
        L299:
            AIInfo r204 = r101.ai_info;
            if (r204 == null) goto L302;
            AIInfo.ADAPTER.encodeWithTag(r100, 164, r204);
        L302:
            AIReplyEntryInfo r205 = r101.ai_reply_entry_info;
            if (r205 == null) goto L305;
            AIReplyEntryInfo.ADAPTER.encodeWithTag(r100, 165, r205);
        L305:
            CardInfo r206 = r101.card_info;
            if (r206 == null) goto L308;
            CardInfo.ADAPTER.encodeWithTag(r100, 167, r206);
        L308:
            AIReply r207 = r101.smart_ai_reply;
            if (r207 == null) goto L311;
            AIReply.ADAPTER.encodeWithTag(r100, 168, r207);
        L311:
            COTContent r208 = r101.cot_content;
            if (r208 == null) goto L314;
            COTContent.ADAPTER.encodeWithTag(r100, 170, r208);
        L314:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Message r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Reaction extends com.squareup.wire.Message<Reaction, Builder> {
        public static final ProtoAdapter<Reaction> ADAPTER = null;
        public static final Integer DEFAULT_CHATTER_COUNT = null;
        public static final String DEFAULT_TYPE = "";
        private static final long serialVersionUID = 0;
        public final Integer chatter_count;
        public final List<String> chatter_ids;
        public final String type;

        public static final class Builder extends com.squareup.wire.Message.Builder<Reaction, Builder> {
            public Integer chatter_count;
            public List<String> chatter_ids;
            public String type;

            @Override // com.squareup.wire.Message.Builder
            public Reaction build() {
                String r100 = this.type;
                if (r100 == null) goto L7;
                return new Reaction(this.type, this.chatter_ids, this.chatter_count, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "type"});
            }

            public Builder() {
                this.chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_count(Integer r100) {
                this.chatter_count = r100;
                return this;
            }

            public Builder chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatter_ids = r100;
                return this;
            }

            public Builder type(String r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Reaction extends ProtoAdapter<Reaction> {
            public ProtoAdapter_Reaction() {
                super(FieldEncoding.LENGTH_DELIMITED, Reaction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Reaction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = "";
                r101.chatter_count = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.chatter_count = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Reaction r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.type) + r101.asRepeated().encodedSizeWithTag(2, r100.chatter_ids);
                Integer r103 = r100.chatter_count;
                if (r103 == null) goto L5;
                int r104 = ProtoAdapter.INT32.encodedSizeWithTag(3, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Reaction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Reaction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Reaction r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.type);
                r102.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
                Integer r103 = r101.chatter_count;
                if (r103 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Reaction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Reaction();
            DEFAULT_CHATTER_COUNT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
            r100.chatter_count = this.chatter_count;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Reaction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Reaction(String r100, List<String> r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Reaction(String r100, List<String> r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
            this.chatter_count = r102;
        }
    }

    public static final enum RecallerIdentity extends Enum<RecallerIdentity> implements WireEnum {
        private static final /* synthetic */ RecallerIdentity[] $VALUES = null;
        public static final ProtoAdapter<RecallerIdentity> ADAPTER = null;
        public static final RecallerIdentity ADMINISTRATOR = null;
        public static final RecallerIdentity DOUBAO_QUERY_OWNER = null;
        public static final RecallerIdentity ENTERPRISE_ADMINISTRATOR = null;
        public static final RecallerIdentity GROUP_ADMIN = null;
        public static final RecallerIdentity OWNER = null;
        public static final RecallerIdentity UNKNOWN_IDENTITY = null;
        private final int value;

        static {
            RecallerIdentity r100 = new RecallerIdentity("UNKNOWN_IDENTITY", 0, 0);
            UNKNOWN_IDENTITY = r100;
            RecallerIdentity r101 = new RecallerIdentity("OWNER", 1, 1);
            OWNER = r101;
            RecallerIdentity r102 = new RecallerIdentity("ADMINISTRATOR", 2, 2);
            ADMINISTRATOR = r102;
            RecallerIdentity r103 = new RecallerIdentity("GROUP_ADMIN", 3, 3);
            GROUP_ADMIN = r103;
            RecallerIdentity r104 = new RecallerIdentity("ENTERPRISE_ADMINISTRATOR", 4, 4);
            ENTERPRISE_ADMINISTRATOR = r104;
            RecallerIdentity r105 = new RecallerIdentity("DOUBAO_QUERY_OWNER", 5, 5);
            DOUBAO_QUERY_OWNER = r105;
            $VALUES = new RecallerIdentity[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(RecallerIdentity.class);
        }

        public static RecallerIdentity[] values() {
            return (RecallerIdentity[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RecallerIdentity fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return DOUBAO_QUERY_OWNER;
        L18:
            return ENTERPRISE_ADMINISTRATOR;
        L20:
            return GROUP_ADMIN;
        L22:
            return ADMINISTRATOR;
        L24:
            return OWNER;
        L26:
            return UNKNOWN_IDENTITY;
        }

        public static RecallerIdentity valueOf(String r100) {
            return (RecallerIdentity) a.a(RecallerIdentity.class, r100);
        }

        private RecallerIdentity(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType TYPE_FROM_FAVORITE = null;
        public static final SourceType TYPE_FROM_FLAG = null;
        public static final SourceType TYPE_FROM_MERGEFORWARD = null;
        public static final SourceType TYPE_FROM_MESSAGE = null;
        public static final SourceType TYPE_FROM_TODO_REFER_RESOURCE = null;
        public static final SourceType TYPE_FROM_UNKONWN = null;
        private final int value;

        static {
            SourceType r100 = new SourceType("TYPE_FROM_UNKONWN", 0, 0);
            TYPE_FROM_UNKONWN = r100;
            SourceType r101 = new SourceType("TYPE_FROM_MESSAGE", 1, 1);
            TYPE_FROM_MESSAGE = r101;
            SourceType r102 = new SourceType("TYPE_FROM_MERGEFORWARD", 2, 2);
            TYPE_FROM_MERGEFORWARD = r102;
            SourceType r103 = new SourceType("TYPE_FROM_FAVORITE", 3, 3);
            TYPE_FROM_FAVORITE = r103;
            SourceType r104 = new SourceType("TYPE_FROM_TODO_REFER_RESOURCE", 4, 4);
            TYPE_FROM_TODO_REFER_RESOURCE = r104;
            SourceType r105 = new SourceType("TYPE_FROM_FLAG", 5, 7);
            TYPE_FROM_FLAG = r105;
            $VALUES = new SourceType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 7) goto L16;
            return null;
        L16:
            return TYPE_FROM_FLAG;
        L18:
            return TYPE_FROM_TODO_REFER_RESOURCE;
        L20:
            return TYPE_FROM_FAVORITE;
        L22:
            return TYPE_FROM_MERGEFORWARD;
        L24:
            return TYPE_FROM_MESSAGE;
        L26:
            return TYPE_FROM_UNKONWN;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) a.a(SourceType.class, r100);
        }

        private SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum StreamStatus extends Enum<StreamStatus> implements WireEnum {
        private static final /* synthetic */ StreamStatus[] $VALUES = null;
        public static final ProtoAdapter<StreamStatus> ADAPTER = null;
        public static final StreamStatus STREAM_BREAK = null;
        public static final StreamStatus STREAM_ERROR = null;
        public static final StreamStatus STREAM_OVER = null;
        public static final StreamStatus STREAM_PREPARE = null;
        public static final StreamStatus STREAM_TRANSPORT = null;
        public static final StreamStatus STREAM_UNKNOWN = null;
        private final int value;

        static {
            StreamStatus r100 = new StreamStatus("STREAM_UNKNOWN", 0, 0);
            STREAM_UNKNOWN = r100;
            StreamStatus r101 = new StreamStatus("STREAM_TRANSPORT", 1, 1);
            STREAM_TRANSPORT = r101;
            StreamStatus r102 = new StreamStatus("STREAM_OVER", 2, 2);
            STREAM_OVER = r102;
            StreamStatus r103 = new StreamStatus("STREAM_ERROR", 3, 3);
            STREAM_ERROR = r103;
            StreamStatus r104 = new StreamStatus("STREAM_BREAK", 4, 4);
            STREAM_BREAK = r104;
            StreamStatus r105 = new StreamStatus("STREAM_PREPARE", 5, 5);
            STREAM_PREPARE = r105;
            $VALUES = new StreamStatus[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(StreamStatus.class);
        }

        public static StreamStatus[] values() {
            return (StreamStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static StreamStatus fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return STREAM_PREPARE;
        L18:
            return STREAM_BREAK;
        L20:
            return STREAM_ERROR;
        L22:
            return STREAM_OVER;
        L24:
            return STREAM_TRANSPORT;
        L26:
            return STREAM_UNKNOWN;
        }

        public static StreamStatus valueOf(String r100) {
            return (StreamStatus) a.a(StreamStatus.class, r100);
        }

        private StreamStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SyncToChatMessageType extends Enum<SyncToChatMessageType> implements WireEnum {
        private static final /* synthetic */ SyncToChatMessageType[] $VALUES = null;
        public static final ProtoAdapter<SyncToChatMessageType> ADAPTER = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_SOURCE_MESSAGE = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_TARGET_MESSAGE = null;
        public static final SyncToChatMessageType UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = null;
        private final int value;

        static {
            SyncToChatMessageType r100 = new SyncToChatMessageType("UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE", 0, 0);
            UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = r100;
            SyncToChatMessageType r101 = new SyncToChatMessageType("SYNC_TO_CHAT_TARGET_MESSAGE", 1, 1);
            SYNC_TO_CHAT_TARGET_MESSAGE = r101;
            SyncToChatMessageType r102 = new SyncToChatMessageType("SYNC_TO_CHAT_SOURCE_MESSAGE", 2, 2);
            SYNC_TO_CHAT_SOURCE_MESSAGE = r102;
            $VALUES = new SyncToChatMessageType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SyncToChatMessageType.class);
        }

        public static SyncToChatMessageType[] values() {
            return (SyncToChatMessageType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SyncToChatMessageType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return SYNC_TO_CHAT_SOURCE_MESSAGE;
        L12:
            return SYNC_TO_CHAT_TARGET_MESSAGE;
        L14:
            return UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        }

        public static SyncToChatMessageType valueOf(String r100) {
            return (SyncToChatMessageType) a.a(SyncToChatMessageType.class, r100);
        }

        private SyncToChatMessageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ThreadMessageType extends Enum<ThreadMessageType> implements WireEnum {
        private static final /* synthetic */ ThreadMessageType[] $VALUES = null;
        public static final ProtoAdapter<ThreadMessageType> ADAPTER = null;
        public static final ThreadMessageType THREAD_REPLY_MESSAGE = null;
        public static final ThreadMessageType THREAD_ROOT_MESSAGE = null;
        public static final ThreadMessageType UNKNOWN_THREAD_MESSAGE = null;
        private final int value;

        static {
            ThreadMessageType r100 = new ThreadMessageType("UNKNOWN_THREAD_MESSAGE", 0, 0);
            UNKNOWN_THREAD_MESSAGE = r100;
            ThreadMessageType r101 = new ThreadMessageType("THREAD_ROOT_MESSAGE", 1, 1);
            THREAD_ROOT_MESSAGE = r101;
            ThreadMessageType r102 = new ThreadMessageType("THREAD_REPLY_MESSAGE", 2, 2);
            THREAD_REPLY_MESSAGE = r102;
            $VALUES = new ThreadMessageType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ThreadMessageType.class);
        }

        public static ThreadMessageType[] values() {
            return (ThreadMessageType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ThreadMessageType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return THREAD_REPLY_MESSAGE;
        L12:
            return THREAD_ROOT_MESSAGE;
        L14:
            return UNKNOWN_THREAD_MESSAGE;
        }

        public static ThreadMessageType valueOf(String r100) {
            return (ThreadMessageType) a.a(ThreadMessageType.class, r100);
        }

        private ThreadMessageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AUDIO = null;
        public static final Type CALENDAR = null;
        public static final Type CARD = null;
        public static final Type COMMERCIALIZED_HONGBAO = null;
        public static final Type DIAGNOSE = null;
        public static final Type DOUBAO = null;
        public static final Type EMAIL = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type GENERAL_CALENDAR = null;
        public static final Type HONGBAO = null;
        public static final Type IMAGE = null;
        public static final Type LOCATION = null;
        public static final Type MEDIA = null;
        public static final Type MERGE_FORWARD = null;
        public static final Type POST = null;
        public static final Type SHARE_CALENDAR_EVENT = null;
        public static final Type SHARE_GROUP_CHAT = null;
        public static final Type SHARE_USER_CARD = null;
        public static final Type STICKER = null;
        public static final Type SYSTEM = null;
        public static final Type TEXT = null;
        public static final Type TODO = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO_CHAT = null;
        public static final Type VOTE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("POST", 1, 2);
            POST = r101;
            Type r102 = new Type("FILE", 2, 3);
            FILE = r102;
            Type r103 = new Type(CardAdapter.TEXT, 3, 4);
            TEXT = r103;
            Type r104 = new Type("IMAGE", 4, 5);
            IMAGE = r104;
            Type r105 = new Type(MediaScene.SYSTEM, 5, 6);
            SYSTEM = r105;
            Type r110 = new Type("AUDIO", 6, 7);
            AUDIO = r110;
            Type r111 = new Type(CommonConstant.RETKEY.EMAIL, 7, 8);
            EMAIL = r111;
            Type r112 = new Type("SHARE_GROUP_CHAT", 8, 9);
            SHARE_GROUP_CHAT = r112;
            Type r113 = new Type("STICKER", 9, 10);
            STICKER = r113;
            Type r114 = new Type("MERGE_FORWARD", 10, 11);
            MERGE_FORWARD = r114;
            Type r115 = new Type("CALENDAR", 11, 12);
            CALENDAR = r115;
            Type r106 = new Type("CARD", 12, 13);
            CARD = r106;
            Type r107 = new Type("MEDIA", 13, 15);
            MEDIA = r107;
            Type r108 = new Type("SHARE_CALENDAR_EVENT", 14, 16);
            SHARE_CALENDAR_EVENT = r108;
            Type r109 = new Type("HONGBAO", 15, 17);
            HONGBAO = r109;
            Type r116 = new Type("GENERAL_CALENDAR", 16, 18);
            GENERAL_CALENDAR = r116;
            Type r117 = new Type("VIDEO_CHAT", 17, 19);
            VIDEO_CHAT = r117;
            Type r118 = new Type(HTTP.LOCATION, 18, 20);
            LOCATION = r118;
            Type r119 = new Type("COMMERCIALIZED_HONGBAO", 19, 22);
            COMMERCIALIZED_HONGBAO = r119;
            Type r120 = new Type("SHARE_USER_CARD", 20, 23);
            SHARE_USER_CARD = r120;
            Type r121 = new Type(AlarmSessionType.TODO, 21, 24);
            TODO = r121;
            Type r122 = new Type("FOLDER", 22, 25);
            FOLDER = r122;
            Type r123 = new Type("DIAGNOSE", 23, 26);
            DIAGNOSE = r123;
            Type r124 = new Type("VOTE", 24, 27);
            VOTE = r124;
            Type r125 = new Type("DOUBAO", 25, 29);
            DOUBAO = r125;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
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
            switch(r100) {
                case 0: goto L56;
                case 1: goto L3;
                case 2: goto L54;
                case 3: goto L52;
                case 4: goto L50;
                case 5: goto L48;
                case 6: goto L46;
                case 7: goto L44;
                case 8: goto L42;
                case 9: goto L40;
                case 10: goto L38;
                case 11: goto L36;
                case 12: goto L34;
                case 13: goto L32;
                case 14: goto L3;
                case 15: goto L30;
                case 16: goto L28;
                case 17: goto L26;
                case 18: goto L24;
                case 19: goto L22;
                case 20: goto L20;
                case 21: goto L3;
                case 22: goto L18;
                case 23: goto L16;
                case 24: goto L14;
                case 25: goto L12;
                case 26: goto L10;
                case 27: goto L8;
                case 28: goto L3;
                case 29: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOUBAO;
        L8:
            return VOTE;
        L10:
            return DIAGNOSE;
        L12:
            return FOLDER;
        L14:
            return TODO;
        L16:
            return SHARE_USER_CARD;
        L18:
            return COMMERCIALIZED_HONGBAO;
        L20:
            return LOCATION;
        L22:
            return VIDEO_CHAT;
        L24:
            return GENERAL_CALENDAR;
        L26:
            return HONGBAO;
        L28:
            return SHARE_CALENDAR_EVENT;
        L30:
            return MEDIA;
        L32:
            return CARD;
        L34:
            return CALENDAR;
        L36:
            return MERGE_FORWARD;
        L38:
            return STICKER;
        L40:
            return SHARE_GROUP_CHAT;
        L42:
            return EMAIL;
        L44:
            return AUDIO;
        L46:
            return SYSTEM;
        L48:
            return IMAGE;
        L50:
            return TEXT;
        L52:
            return FILE;
        L54:
            return POST;
        L56:
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

    public static final class Version extends com.squareup.wire.Message<Version, Builder> {
        public static final ProtoAdapter<Version> ADAPTER = null;
        public static final Integer DEFAULT_CONTENT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Integer content_version;

        public static final class Builder extends com.squareup.wire.Message.Builder<Version, Builder> {
            public Integer content_version;

            @Override // com.squareup.wire.Message.Builder
            public Version build() {
                return new Version(this.content_version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content_version(Integer r100) {
                this.content_version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Version extends ProtoAdapter<Version> {
            public ProtoAdapter_Version() {
                super(FieldEncoding.LENGTH_DELIMITED, Version.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Version decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content_version = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.content_version = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Version r100) {
                Integer r101 = r100.content_version;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Version decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Version r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Version r101) throws IOException {
                Integer r102 = r101.content_version;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Version r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Version();
            DEFAULT_CONTENT_VERSION = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content_version = this.content_version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Version.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Version(Integer r100) {
            this(r100, ByteString.EMPTY);
        }

        public Version(Integer r100, ByteString r101) {
            super(ADAPTER, r101);
            this.content_version = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Message();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_UNREAD_COUNT = 0;
        Boolean r100 = Boolean.TRUE;
        DEFAULT_SHOULD_NOTIFY = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_RECALLED = r101;
        DEFAULT_IS_EDITED = r101;
        DEFAULT_REPLY_COUNT = 0;
        DEFAULT_POSITION = 0;
        DEFAULT_ME_READ = r101;
        DEFAULT_IS_URGENT = r101;
        DEFAULT_IS_AT_ME = r101;
        DEFAULT_IS_AT_ALL = r101;
        DEFAULT_IS_TRUNCATED = r101;
        DEFAULT_READ_COUNT = 0;
        DEFAULT_IS_FILE_DELETED = r101;
        DEFAULT_IS_DELETED = r101;
        DEFAULT_IS_ABNORMAL = r101;
        DEFAULT_FROM_TYPE = FromType.UNKNOWN_FROM_TYPE;
        DEFAULT_IS_VISIBLE = r100;
        DEFAULT_BURN_LIFE = 0;
        DEFAULT_BURN_TIME = 0L;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_SOURCE_TYPE = SourceType.TYPE_FROM_UNKONWN;
        DEFAULT_RECALLER_IDENTITY = RecallerIdentity.UNKNOWN_IDENTITY;
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_IS_REEDITABLE = r101;
        DEFAULT_IS_BADGED = r101;
        DEFAULT_IS_UNTRANSLATEABLE = r101;
        DEFAULT_THREAD_BADGE_COUNT = 0;
        DEFAULT_THREAD_REPLY_COUNT = 0;
        DEFAULT_IS_BURNED = r101;
        DEFAULT_IS_AUTO_TRANSLATED_BY_RECEIVER = r101;
        DEFAULT_IS_NO_TRACE_DELETED = r101;
        DEFAULT_ORIGIN_BADGE_COUNT = 0;
        DEFAULT_ORIGIN_THREAD_BADGE_COUNT = 0;
        DEFAULT_SENSITIVITY = MessageSensitivity.UNKNOWN_SENSITIVITY;
        DEFAULT_IS_DECRYPTO_FAIL = r101;
        DEFAULT_IS_SECRET_CHAT_DECRYPTED_FAILED = r101;
        DEFAULT_IS_MANUAL_TRANSLATED = r101;
        DEFAULT_FORWARD_FROM_FRIEND = r101;
        DEFAULT_STATIC_RESOURCE_MESSAGE_RECALLED = r101;
        DEFAULT_IS_CRYPTO_INTERMEDIATE = r101;
        DEFAULT_IS_SPECIAL_FOCUS = r101;
        DEFAULT_IS_INCLUDE_DOC_URL = r101;
        DEFAULT_FILE_DELETED_STATUS = FileDeletedStatus.NORMAL;
        DEFAULT_CHARACTER_LENGTH = 0;
        DEFAULT_SYNC_DEPENDENCY = r101;
        DEFAULT_IS_FLAG = r101;
        DEFAULT_THREAD_MESSAGE_TYPE = ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
        DEFAULT_CREATE_TIME_MS = 0L;
        DEFAULT_DISABLE_SEARCH = r101;
        DEFAULT_EDIT_VERSION = 0;
        DEFAULT_EDIT_TIME_MS = 0L;
        DEFAULT_DLP_STATE = MessageDLPState.UNKNOWN_DLP_STATE;
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_IN_CHAT_DISPLAY_MODE = ChatDisplayModeSetting.UNKNOWN_DISPLAY_MODE;
        DEFAULT_IS_RESTRICTED = r101;
        DEFAULT_SET_GREY = r101;
        DEFAULT_IS_ON_TIME_DEL = r101;
        DEFAULT_IS_CLEANED = r101;
        DEFAULT_STREAM_STATUS = StreamStatus.STREAM_UNKNOWN;
        DEFAULT_STREAM_SEQUENCE_ID = 0;
        DEFAULT_AI_CHAT_MODE_ID = 0L;
        DEFAULT_AI_MESSAGE_LIKE_FEEDBACK_STATUS = AIMessageLikeFeedbackStatus.UNKNOWN_STATUS;
        DEFAULT_AI_MESSAGE_TYPE = AIMessageType.OTHER;
        DEFAULT_SYNC_TO_CHAT_THREAD_ROOT_ID = 0L;
        DEFAULT_SYNC_TO_CHAT_MESSAGE_TYPE = SyncToChatMessageType.UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        DEFAULT_SYNC_TO_CHAT_RELATED_MESSAGE_ID = 0L;
        DEFAULT_CAN_SHOW_AI_PROGRESS = r101;
        DEFAULT_IS_AI_SESSION_FIRST_MSG = r101;
        DEFAULT_HAS_FOLLOW_UP = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253516id = this.f253515id;
        r100.type = this.type;
        r100.chat_id = this.chat_id;
        r100.thread_id = this.thread_id;
        r100.create_time = this.create_time;
        r100.update_time = this.update_time;
        r100.root_id = this.root_id;
        r100.content = this.content;
        r100.reactions = Internal.copyOf("reactions", this.reactions);
        r100.unread_count = this.unread_count;
        r100.from_id = this.from_id;
        r100.should_notify = this.should_notify;
        r100.is_recalled = this.is_recalled;
        r100.is_edited = this.is_edited;
        r100.reply_count = this.reply_count;
        r100.position = this.position;
        r100.cid = this.cid;
        r100.me_read = this.me_read;
        r100.reminder_id = this.reminder_id;
        r100.parent_source_id = this.parent_source_id;
        r100.root_source_id = this.root_source_id;
        r100.is_urgent = this.is_urgent;
        r100.urgent_id = this.urgent_id;
        r100.parent_id = this.parent_id;
        r100.is_at_me = this.is_at_me;
        r100.is_at_all = this.is_at_all;
        r100.is_truncated = this.is_truncated;
        r100.read_count = this.read_count;
        r100.unread_chatter_ids = Internal.copyOf("unread_chatter_ids", this.unread_chatter_ids);
        r100.text_draft_id = this.text_draft_id;
        r100.post_draft_id = this.post_draft_id;
        r100.is_file_deleted = this.is_file_deleted;
        r100.is_deleted = this.is_deleted;
        r100.is_abnormal = this.is_abnormal;
        r100.from_type = this.from_type;
        r100.doc_key = this.doc_key;
        r100.unack_urgent_chatter_ids = Internal.copyOf("unack_urgent_chatter_ids", this.unack_urgent_chatter_ids);
        r100.ack_urgent_chatter_ids = Internal.copyOf("ack_urgent_chatter_ids", this.ack_urgent_chatter_ids);
        r100.channel = this.channel;
        r100.is_visible = this.is_visible;
        r100.burn_life = this.burn_life;
        r100.burn_time = this.burn_time;
        r100.thread_position = this.thread_position;
        r100.source_type = this.source_type;
        r100.source_id = this.source_id;
        r100.translate_language = this.translate_language;
        r100.recaller_id = this.recaller_id;
        r100.recaller_identity = this.recaller_identity;
        r100.pin = this.pin;
        r100.badge_count = this.badge_count;
        r100.is_reeditable = this.is_reeditable;
        r100.is_badged = this.is_badged;
        r100.is_untranslateable = this.is_untranslateable;
        r100.read_at_chatter_ids = Internal.copyOf("read_at_chatter_ids", this.read_at_chatter_ids);
        r100.thread_badge_count = this.thread_badge_count;
        r100.thread_reply_count = this.thread_reply_count;
        r100.at_out_chatter_ids = Internal.copyOf("at_out_chatter_ids", this.at_out_chatter_ids);
        r100.is_burned = this.is_burned;
        r100.message_language = this.message_language;
        r100.is_auto_translated_by_receiver = this.is_auto_translated_by_receiver;
        r100.is_no_trace_deleted = this.is_no_trace_deleted;
        r100.origin_badge_count = this.origin_badge_count;
        r100.origin_thread_badge_count = this.origin_thread_badge_count;
        r100.sensitivity = this.sensitivity;
        r100.crypto_token = this.crypto_token;
        r100.is_decrypto_fail = this.is_decrypto_fail;
        r100.is_secret_chat_decrypted_failed = this.is_secret_chat_decrypted_failed;
        r100.translate_message_display_rule = this.translate_message_display_rule;
        r100.is_manual_translated = this.is_manual_translated;
        r100.original_sender_id = this.original_sender_id;
        r100.forward_from_friend = this.forward_from_friend;
        r100.static_resource_message_recalled = this.static_resource_message_recalled;
        r100.is_crypto_intermediate = this.is_crypto_intermediate;
        r100.image_translation_ability = Internal.copyOf("image_translation_ability", this.image_translation_ability);
        r100.is_special_focus = this.is_special_focus;
        r100.is_include_doc_url = this.is_include_doc_url;
        r100.file_deleted_status = this.file_deleted_status;
        r100.character_length = this.character_length;
        r100.msg_thread_draft_id = this.msg_thread_draft_id;
        r100.sync_dependency = this.sync_dependency;
        r100.anonymous_info = this.anonymous_info;
        r100.is_flag = this.is_flag;
        r100.thread_message_type = this.thread_message_type;
        r100.create_time_ms = this.create_time_ms;
        r100.i18n_content_language = Internal.copyOf("i18n_content_language", this.i18n_content_language);
        r100.disable_search = this.disable_search;
        r100.edit_version = this.edit_version;
        r100.edit_time_ms = this.edit_time_ms;
        r100.edit_draft_id = this.edit_draft_id;
        r100.dlp_state = this.dlp_state;
        r100.message_languages = Internal.copyOf("message_languages", this.message_languages);
        r100.i18n_info = this.i18n_info;
        r100.fold_id = this.fold_id;
        r100.version = this.version;
        r100.schedule_message_draft_id = this.schedule_message_draft_id;
        r100.in_chat_display_mode = this.in_chat_display_mode;
        r100.is_restricted = this.is_restricted;
        r100.set_grey = this.set_grey;
        r100.disabled_action = this.disabled_action;
        r100.is_on_time_del = this.is_on_time_del;
        r100.is_cleaned = this.is_cleaned;
        r100.security_extra = this.security_extra;
        r100.stream_status = this.stream_status;
        r100.stream_sequence_id = this.stream_sequence_id;
        r100.ai_chat_mode_id = this.ai_chat_mode_id;
        r100.ai_answer_raw_data = this.ai_answer_raw_data;
        r100.ai_message_like_feedback_status = this.ai_message_like_feedback_status;
        r100.ai_message_type = this.ai_message_type;
        r100.sync_to_chat_thread_root_id = this.sync_to_chat_thread_root_id;
        r100.sync_to_chat_message_type = this.sync_to_chat_message_type;
        r100.sync_to_chat_related_message_id = this.sync_to_chat_related_message_id;
        r100.can_show_ai_progress = this.can_show_ai_progress;
        r100.partial_reply_info = this.partial_reply_info;
        r100.is_ai_session_first_msg = this.is_ai_session_first_msg;
        r100.authorized_source = this.authorized_source;
        r100.has_follow_up = this.has_follow_up;
        r100.ai_info = this.ai_info;
        r100.ai_reply_entry_info = this.ai_reply_entry_info;
        r100.card_info = this.card_info;
        r100.smart_ai_reply = this.smart_ai_reply;
        r100.cot_content = this.cot_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Message.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Message(String r124, Type r125, String r126, String r127, Long r128, Long r129, String r130, Content r131, List<Reaction> r132, Integer r133, String r134, Boolean r135, Boolean r136, Boolean r137, Integer r138, Integer r139, String r140, Boolean r141, String r142, String r143, String r144, Boolean r145, String r146, String r147, Boolean r148, Boolean r149, Boolean r150, Integer r151, List<String> r152, String r153, String r154, Boolean r155, Boolean r156, Boolean r157, FromType r158, String r159, List<String> r160, List<String> r161, Channel r162, Boolean r163, Integer r164, Long r165, Integer r166, SourceType r167, String r168, String r169, String r170, RecallerIdentity r171, Pin r172, Integer r173, Boolean r174, Boolean r175, Boolean r176, List<String> r177, Integer r178, Integer r179, List<String> r180, Boolean r181, String r182, Boolean r183, Boolean r184, Integer r185, Integer r186, MessageSensitivity r187, String r188, Boolean r189, Boolean r190, TranslateMessageDisplayRule r191, Boolean r192, String r193, Boolean r194, Boolean r195, Boolean r196, Map<String, ImageTranslationAbility> r197, Boolean r198, Boolean r199, FileDeletedStatus r200, Integer r201, String r202, Boolean r203, AnonymousInfo r204, Boolean r205, ThreadMessageType r206, Long r207, Map<String, String> r208, Boolean r209, Integer r210, Long r211, String r212, MessageDLPState r213, List<String> r214, I18nInfo r215, Long r216, Version r217, String r218, ChatDisplayModeSetting r219, Boolean r220, Boolean r221, DisabledAction r222, Boolean r223, Boolean r224, SecurityESCReviewExtra r225, StreamStatus r226, Integer r227, Long r228, String r229, AIMessageLikeFeedbackStatus r230, AIMessageType r231, Long r232, SyncToChatMessageType r233, Long r234, Boolean r235, PartialReplyInfo r236, Boolean r237, AuthorizedSource r238, Boolean r239, AIInfo r240, AIReplyEntryInfo r241, CardInfo r242, AIReply r243, COTContent r244) {
        this(r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, ByteString.EMPTY);
    }

    public Message(String r100, Type r101, String r102, String r103, Long r104, Long r105, String r110, Content r111, List<Reaction> r112, Integer r113, String r114, Boolean r115, Boolean r116, Boolean r117, Integer r118, Integer r119, String r210, Boolean r211, String r212, String r213, String r214, Boolean r215, String r216, String r217, Boolean r218, Boolean r219, Boolean r310, Integer r311, List<String> r312, String r313, String r314, Boolean r315, Boolean r316, Boolean r317, FromType r318, String r319, List<String> r410, List<String> r411, Channel r412, Boolean r413, Integer r414, Long r415, Integer r416, SourceType r417, String r418, String r419, String r510, RecallerIdentity r511, Pin r512, Integer r513, Boolean r514, Boolean r515, Boolean r516, List<String> r517, Integer r518, Integer r519, List<String> r610, Boolean r611, String r612, Boolean r613, Boolean r614, Integer r615, Integer r616, MessageSensitivity r617, String r618, Boolean r619, Boolean r710, TranslateMessageDisplayRule r711, Boolean r712, String r713, Boolean r714, Boolean r715, Boolean r716, Map<String, ImageTranslationAbility> r717, Boolean r718, Boolean r719, FileDeletedStatus r810, Integer r811, String r812, Boolean r813, AnonymousInfo r814, Boolean r815, ThreadMessageType r816, Long r817, Map<String, String> r818, Boolean r819, Integer r910, Long r911, String r912, MessageDLPState r913, List<String> r914, I18nInfo r915, Long r916, Version r917, String r918, ChatDisplayModeSetting r919, Boolean r106, Boolean r107, DisabledAction r108, Boolean r109, Boolean r1010, SecurityESCReviewExtra r1011, StreamStatus r1012, Integer r1013, Long r1014, String r1015, AIMessageLikeFeedbackStatus r1110, AIMessageType r1111, Long r1112, SyncToChatMessageType r1113, Long r1114, Boolean r1115, PartialReplyInfo r1116, Boolean r1117, AuthorizedSource r1118, Boolean r1119, AIInfo r120, AIReplyEntryInfo r121, CardInfo r122, AIReply r123, COTContent r124, ByteString r125) {
        super(ADAPTER, r125);
        this.f253515id = r100;
        this.type = r101;
        this.chat_id = r102;
        this.thread_id = r103;
        this.create_time = r104;
        this.update_time = r105;
        this.root_id = r110;
        this.content = r111;
        this.reactions = Internal.immutableCopyOf("reactions", r112);
        this.unread_count = r113;
        this.from_id = r114;
        this.should_notify = r115;
        this.is_recalled = r116;
        this.is_edited = r117;
        this.reply_count = r118;
        this.position = r119;
        this.cid = r210;
        this.me_read = r211;
        this.reminder_id = r212;
        this.parent_source_id = r213;
        this.root_source_id = r214;
        this.is_urgent = r215;
        this.urgent_id = r216;
        this.parent_id = r217;
        this.is_at_me = r218;
        this.is_at_all = r219;
        this.is_truncated = r310;
        this.read_count = r311;
        this.unread_chatter_ids = Internal.immutableCopyOf("unread_chatter_ids", r312);
        this.text_draft_id = r313;
        this.post_draft_id = r314;
        this.is_file_deleted = r315;
        this.is_deleted = r316;
        this.is_abnormal = r317;
        this.from_type = r318;
        this.doc_key = r319;
        this.unack_urgent_chatter_ids = Internal.immutableCopyOf("unack_urgent_chatter_ids", r410);
        this.ack_urgent_chatter_ids = Internal.immutableCopyOf("ack_urgent_chatter_ids", r411);
        this.channel = r412;
        this.is_visible = r413;
        this.burn_life = r414;
        this.burn_time = r415;
        this.thread_position = r416;
        this.source_type = r417;
        this.source_id = r418;
        this.translate_language = r419;
        this.recaller_id = r510;
        this.recaller_identity = r511;
        this.pin = r512;
        this.badge_count = r513;
        this.is_reeditable = r514;
        this.is_badged = r515;
        this.is_untranslateable = r516;
        this.read_at_chatter_ids = Internal.immutableCopyOf("read_at_chatter_ids", r517);
        this.thread_badge_count = r518;
        this.thread_reply_count = r519;
        this.at_out_chatter_ids = Internal.immutableCopyOf("at_out_chatter_ids", r610);
        this.is_burned = r611;
        this.message_language = r612;
        this.is_auto_translated_by_receiver = r613;
        this.is_no_trace_deleted = r614;
        this.origin_badge_count = r615;
        this.origin_thread_badge_count = r616;
        this.sensitivity = r617;
        this.crypto_token = r618;
        this.is_decrypto_fail = r619;
        this.is_secret_chat_decrypted_failed = r710;
        this.translate_message_display_rule = r711;
        this.is_manual_translated = r712;
        this.original_sender_id = r713;
        this.forward_from_friend = r714;
        this.static_resource_message_recalled = r715;
        this.is_crypto_intermediate = r716;
        this.image_translation_ability = Internal.immutableCopyOf("image_translation_ability", r717);
        this.is_special_focus = r718;
        this.is_include_doc_url = r719;
        this.file_deleted_status = r810;
        this.character_length = r811;
        this.msg_thread_draft_id = r812;
        this.sync_dependency = r813;
        this.anonymous_info = r814;
        this.is_flag = r815;
        this.thread_message_type = r816;
        this.create_time_ms = r817;
        this.i18n_content_language = Internal.immutableCopyOf("i18n_content_language", r818);
        this.disable_search = r819;
        this.edit_version = r910;
        this.edit_time_ms = r911;
        this.edit_draft_id = r912;
        this.dlp_state = r913;
        this.message_languages = Internal.immutableCopyOf("message_languages", r914);
        this.i18n_info = r915;
        this.fold_id = r916;
        this.version = r917;
        this.schedule_message_draft_id = r918;
        this.in_chat_display_mode = r919;
        this.is_restricted = r106;
        this.set_grey = r107;
        this.disabled_action = r108;
        this.is_on_time_del = r109;
        this.is_cleaned = r1010;
        this.security_extra = r1011;
        this.stream_status = r1012;
        this.stream_sequence_id = r1013;
        this.ai_chat_mode_id = r1014;
        this.ai_answer_raw_data = r1015;
        this.ai_message_like_feedback_status = r1110;
        this.ai_message_type = r1111;
        this.sync_to_chat_thread_root_id = r1112;
        this.sync_to_chat_message_type = r1113;
        this.sync_to_chat_related_message_id = r1114;
        this.can_show_ai_progress = r1115;
        this.partial_reply_info = r1116;
        this.is_ai_session_first_msg = r1117;
        this.authorized_source = r1118;
        this.has_follow_up = r1119;
        this.ai_info = r120;
        this.ai_reply_entry_info = r121;
        this.card_info = r122;
        this.smart_ai_reply = r123;
        this.cot_content = r124;
    }
}
