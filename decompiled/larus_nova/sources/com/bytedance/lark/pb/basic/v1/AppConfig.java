package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class AppConfig extends com.squareup.wire.Message<AppConfig, Builder> {
    public static final ProtoAdapter<AppConfig> ADAPTER = null;
    public static final CryptoChatState DEFAULT_CRYPTO_CHAT_STATE = null;
    public static final Integer DEFAULT_GUIDE_TO_RATE_DELAY_HOURS = null;
    public static final FieldOptions FIELD_OPTIONS_ANDROID_APP_STORES = null;
    public static final FieldOptions FIELD_OPTIONS_BANNER_CONFIG = null;
    public static final FieldOptions FIELD_OPTIONS_BILLING_PACKAGE = null;
    public static final FieldOptions FIELD_OPTIONS_CHAT_CONFIG = null;
    public static final FieldOptions FIELD_OPTIONS_CRYPTO_CHAT_STATE = null;
    public static final FieldOptions FIELD_OPTIONS_DATA_RESIDENCY = null;
    public static final FieldOptions FIELD_OPTIONS_DOC_URL_REGEX = null;
    public static final FieldOptions FIELD_OPTIONS_GUIDE_TO_RATE_DELAY_HOURS = null;
    public static final FieldOptions FIELD_OPTIONS_MESSAGE_CONFIG = null;
    public static final FieldOptions FIELD_OPTIONS_RESOURCE = null;
    public static final FieldOptions FIELD_OPTIONS_SEARCH_CONFIG = null;
    public static final FieldOptions FIELD_OPTIONS_URGENT_NUM = null;
    public static final FieldOptions FIELD_OPTIONS_URL_CONFIG = null;
    public static final FieldOptions FIELD_OPTIONS_URL_REGEX = null;
    public static final FieldOptions FIELD_OPTIONS_VOICE_CALL_CONFIG = null;
    public static final FieldOptions FIELD_OPTIONS_ZENDESK = null;
    public static final ProtoAdapter_AppConfig RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> android_app_stores;
    public final BannerConfig banner_config;
    public final BillingPackageConfig billing_package;
    public final ChatConfig chat_config;
    public final CryptoChatState crypto_chat_state;
    public final DataResidency data_residency;
    public final DocUrlRegex doc_url_regex;
    public final Integer guide_to_rate_delay_hours;
    public final MessageConfig message_config;
    public final Resource resource;
    public final SearchConfig search_config;
    public final UrgentNum urgent_num;
    public final URLConfig url_config;
    public final URLRegex url_regex;
    public final VoiceCallConfig voice_call_config;
    public final Zendesk zendesk;

    public static final class BannerConfig extends com.squareup.wire.Message<BannerConfig, Builder> {
        public static final ProtoAdapter<BannerConfig> ADAPTER = null;
        public static final Integer DEFAULT_NOTIFICATION_REFRESH_TIME = null;
        public static final FieldOptions FIELD_OPTIONS_NOTIFICATION_REFRESH_TIME = null;
        private static final long serialVersionUID = 0;
        public final Integer notification_refresh_time;

        public static final class Builder extends com.squareup.wire.Message.Builder<BannerConfig, Builder> {
            public Integer notification_refresh_time;

            @Override // com.squareup.wire.Message.Builder
            public BannerConfig build() {
                return new BannerConfig(this.notification_refresh_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder notification_refresh_time(Integer r100) {
                this.notification_refresh_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BannerConfig extends ProtoAdapter<BannerConfig> {
            public ProtoAdapter_BannerConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, BannerConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BannerConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.notification_refresh_time = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.notification_refresh_time = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(BannerConfig r100) {
                Integer r101 = r100.notification_refresh_time;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BannerConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BannerConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BannerConfig r101) throws IOException {
                Integer r102 = r101.notification_refresh_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BannerConfig();
            FIELD_OPTIONS_NOTIFICATION_REFRESH_TIME = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_NOTIFICATION_REFRESH_TIME = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.notification_refresh_time = this.notification_refresh_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BannerConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BannerConfig(Integer r100) {
            this(r100, ByteString.EMPTY);
        }

        public BannerConfig(Integer r100, ByteString r101) {
            super(ADAPTER, r101);
            this.notification_refresh_time = r100;
        }
    }

    public static final class BillingPackageConfig extends com.squareup.wire.Message<BillingPackageConfig, Builder> {
        public static final ProtoAdapter<BillingPackageConfig> ADAPTER = null;
        public static final Long DEFAULT_BUZZ_LIMIT = null;
        public static final Long DEFAULT_CHAT_BOT_LIMIT = null;
        public static final Long DEFAULT_CHAT_NUMBER_LIMIT = null;
        public static final Long DEFAULT_DOC_NUMBER_LIMIT = null;
        public static final Boolean DEFAULT_HAS_SECRET_CHAT = null;
        public static final Boolean DEFAULT_IS_ENABLE_AUTO_TRANSLATION = null;
        public static final Boolean DEFAULT_IS_LARK_HONGBAO_ENABLE = null;
        public static final Long DEFAULT_VIDEOCHAT_DURATION_LIMIT = null;
        public static final Long DEFAULT_VIDEOCHAT_PARTICIPANT_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_BUZZ_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_CHAT_BOT_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_CHAT_NUMBER_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_DOC_NUMBER_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_HAS_SECRET_CHAT = null;
        public static final FieldOptions FIELD_OPTIONS_IS_ENABLE_AUTO_TRANSLATION = null;
        public static final FieldOptions FIELD_OPTIONS_IS_LARK_HONGBAO_ENABLE = null;
        public static final FieldOptions FIELD_OPTIONS_VIDEOCHAT_DURATION_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_VIDEOCHAT_PARTICIPANT_LIMIT = null;
        private static final long serialVersionUID = 0;
        public final Long buzz_limit;
        public final Long chat_bot_limit;
        public final Long chat_number_limit;
        public final Long doc_number_limit;
        public final Boolean has_secret_chat;
        public final Boolean is_enable_auto_translation;
        public final Boolean is_lark_hongbao_enable;
        public final Long videochat_duration_limit;
        public final Long videochat_participant_limit;

        public static final class Builder extends com.squareup.wire.Message.Builder<BillingPackageConfig, Builder> {
            public Long buzz_limit;
            public Long chat_bot_limit;
            public Long chat_number_limit;
            public Long doc_number_limit;
            public Boolean has_secret_chat;
            public Boolean is_enable_auto_translation;
            public Boolean is_lark_hongbao_enable;
            public Long videochat_duration_limit;
            public Long videochat_participant_limit;

            @Override // com.squareup.wire.Message.Builder
            public BillingPackageConfig build() {
                return new BillingPackageConfig(this.chat_number_limit, this.chat_bot_limit, this.buzz_limit, this.has_secret_chat, this.doc_number_limit, this.videochat_participant_limit, this.videochat_duration_limit, this.is_enable_auto_translation, this.is_lark_hongbao_enable, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder buzz_limit(Long r100) {
                this.buzz_limit = r100;
                return this;
            }

            public Builder chat_bot_limit(Long r100) {
                this.chat_bot_limit = r100;
                return this;
            }

            public Builder chat_number_limit(Long r100) {
                this.chat_number_limit = r100;
                return this;
            }

            public Builder doc_number_limit(Long r100) {
                this.doc_number_limit = r100;
                return this;
            }

            public Builder has_secret_chat(Boolean r100) {
                this.has_secret_chat = r100;
                return this;
            }

            public Builder is_enable_auto_translation(Boolean r100) {
                this.is_enable_auto_translation = r100;
                return this;
            }

            public Builder is_lark_hongbao_enable(Boolean r100) {
                this.is_lark_hongbao_enable = r100;
                return this;
            }

            public Builder videochat_duration_limit(Long r100) {
                this.videochat_duration_limit = r100;
                return this;
            }

            public Builder videochat_participant_limit(Long r100) {
                this.videochat_participant_limit = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BillingPackageConfig extends ProtoAdapter<BillingPackageConfig> {
            public ProtoAdapter_BillingPackageConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, BillingPackageConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BillingPackageConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_number_limit = -1L;
                r101.chat_bot_limit = -1L;
                r101.buzz_limit = -1L;
                Boolean r102 = Boolean.TRUE;
                r101.has_secret_chat = r102;
                r101.doc_number_limit = -1L;
                r101.videochat_participant_limit = -1L;
                r101.videochat_duration_limit = -1L;
                r101.is_enable_auto_translation = r102;
                r101.is_lark_hongbao_enable = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L33;
                if (r104 != 1) goto L8;
                r101.chat_number_limit = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.chat_bot_limit = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r104 != 20) goto L12;
                r101.buzz_limit = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r104 != 30) goto L14;
                r101.has_secret_chat = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r104 != 100) goto L16;
                r101.doc_number_limit = ProtoAdapter.INT64.decode(r100);
                goto L3
            L16:
                if (r104 != 300) goto L18;
                r101.is_enable_auto_translation = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L18:
                if (r104 != 400) goto L20;
                r101.is_lark_hongbao_enable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L20:
                if (r104 != 200) goto L22;
                r101.videochat_participant_limit = ProtoAdapter.INT64.decode(r100);
                goto L3
            L22:
                if (r104 != 201) goto L23;
                r101.videochat_duration_limit = ProtoAdapter.INT64.decode(r100);
                goto L3
            L23:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L33:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(BillingPackageConfig r100) {
                Long r101 = r100.chat_number_limit;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.chat_bot_limit;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.buzz_limit;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(20, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.has_secret_chat;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r110);
            L18:
                int r112 = r109 + r111;
                Long r113 = r100.doc_number_limit;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.INT64.encodedSizeWithTag(100, r113);
            L22:
                int r115 = r112 + r114;
                Long r116 = r100.videochat_participant_limit;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.INT64.encodedSizeWithTag(200, r116);
            L26:
                int r118 = r115 + r117;
                Long r119 = r100.videochat_duration_limit;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.INT64.encodedSizeWithTag(201, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.is_enable_auto_translation;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(300, r122);
            L34:
                int r124 = r121 + r123;
                Boolean r125 = r100.is_lark_hongbao_enable;
                if (r125 == null) goto L38;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(400, r125);
            L38:
                return (r124 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ BillingPackageConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BillingPackageConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BillingPackageConfig r101) throws IOException {
                Long r102 = r101.chat_number_limit;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.chat_bot_limit;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.buzz_limit;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 20, r104);
            L11:
                Boolean r105 = r101.has_secret_chat;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 30, r105);
            L14:
                Long r106 = r101.doc_number_limit;
                if (r106 == null) goto L17;
                ProtoAdapter.INT64.encodeWithTag(r100, 100, r106);
            L17:
                Long r107 = r101.videochat_participant_limit;
                if (r107 == null) goto L20;
                ProtoAdapter.INT64.encodeWithTag(r100, 200, r107);
            L20:
                Long r108 = r101.videochat_duration_limit;
                if (r108 == null) goto L23;
                ProtoAdapter.INT64.encodeWithTag(r100, 201, r108);
            L23:
                Boolean r109 = r101.is_enable_auto_translation;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 300, r109);
            L26:
                Boolean r110 = r101.is_lark_hongbao_enable;
                if (r110 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 400, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BillingPackageConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BillingPackageConfig();
            FIELD_OPTIONS_CHAT_NUMBER_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_CHAT_BOT_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_BUZZ_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_HAS_SECRET_CHAT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_DOC_NUMBER_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_VIDEOCHAT_PARTICIPANT_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_VIDEOCHAT_DURATION_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_IS_ENABLE_AUTO_TRANSLATION = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_IS_LARK_HONGBAO_ENABLE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_CHAT_NUMBER_LIMIT = -1L;
            DEFAULT_CHAT_BOT_LIMIT = -1L;
            DEFAULT_BUZZ_LIMIT = -1L;
            Boolean r100 = Boolean.TRUE;
            DEFAULT_HAS_SECRET_CHAT = r100;
            DEFAULT_DOC_NUMBER_LIMIT = -1L;
            DEFAULT_VIDEOCHAT_PARTICIPANT_LIMIT = -1L;
            DEFAULT_VIDEOCHAT_DURATION_LIMIT = -1L;
            DEFAULT_IS_ENABLE_AUTO_TRANSLATION = r100;
            DEFAULT_IS_LARK_HONGBAO_ENABLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_number_limit = this.chat_number_limit;
            r100.chat_bot_limit = this.chat_bot_limit;
            r100.buzz_limit = this.buzz_limit;
            r100.has_secret_chat = this.has_secret_chat;
            r100.doc_number_limit = this.doc_number_limit;
            r100.videochat_participant_limit = this.videochat_participant_limit;
            r100.videochat_duration_limit = this.videochat_duration_limit;
            r100.is_enable_auto_translation = this.is_enable_auto_translation;
            r100.is_lark_hongbao_enable = this.is_lark_hongbao_enable;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BillingPackageConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BillingPackageConfig(Long r110, Long r111, Long r112, Boolean r113, Long r114, Long r115, Long r116, Boolean r117, Boolean r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public BillingPackageConfig(Long r100, Long r101, Long r102, Boolean r103, Long r104, Long r105, Long r106, Boolean r107, Boolean r110, ByteString r111) {
            super(ADAPTER, r111);
            this.chat_number_limit = r100;
            this.chat_bot_limit = r101;
            this.buzz_limit = r102;
            this.has_secret_chat = r103;
            this.doc_number_limit = r104;
            this.videochat_participant_limit = r105;
            this.videochat_duration_limit = r106;
            this.is_enable_auto_translation = r107;
            this.is_lark_hongbao_enable = r110;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<AppConfig, Builder> implements d<AppConfig> {
        public List<String> android_app_stores;
        public BannerConfig banner_config;
        public BillingPackageConfig billing_package;
        public ChatConfig chat_config;
        public CryptoChatState crypto_chat_state;
        public DataResidency data_residency;
        public DocUrlRegex doc_url_regex;
        public Integer guide_to_rate_delay_hours;
        public MessageConfig message_config;
        public Resource resource;
        public SearchConfig search_config;
        public UrgentNum urgent_num;
        public URLConfig url_config;
        public URLRegex url_regex;
        public VoiceCallConfig voice_call_config;
        public Zendesk zendesk;

        @Override // com.squareup.wire.Message.Builder
        public AppConfig build() {
            return new AppConfig(this.message_config, this.chat_config, this.voice_call_config, this.url_config, this.resource, this.doc_url_regex, this.billing_package, this.url_regex, this.zendesk, this.android_app_stores, this.guide_to_rate_delay_hours, this.search_config, this.banner_config, this.crypto_chat_state, this.urgent_num, this.data_residency, super.buildUnknownFields());
        }

        public Builder() {
            this.android_app_stores = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder android_app_stores(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.android_app_stores = r100;
            return this;
        }

        public Builder banner_config(BannerConfig r100) {
            this.banner_config = r100;
            return this;
        }

        public Builder billing_package(BillingPackageConfig r100) {
            this.billing_package = r100;
            return this;
        }

        public Builder chat_config(ChatConfig r100) {
            this.chat_config = r100;
            return this;
        }

        public Builder crypto_chat_state(CryptoChatState r100) {
            this.crypto_chat_state = r100;
            return this;
        }

        public Builder data_residency(DataResidency r100) {
            this.data_residency = r100;
            return this;
        }

        public Builder doc_url_regex(DocUrlRegex r100) {
            this.doc_url_regex = r100;
            return this;
        }

        public Builder guide_to_rate_delay_hours(Integer r100) {
            this.guide_to_rate_delay_hours = r100;
            return this;
        }

        public Builder message_config(MessageConfig r100) {
            this.message_config = r100;
            return this;
        }

        public Builder resource(Resource r100) {
            this.resource = r100;
            return this;
        }

        public Builder search_config(SearchConfig r100) {
            this.search_config = r100;
            return this;
        }

        public Builder urgent_num(UrgentNum r100) {
            this.urgent_num = r100;
            return this;
        }

        public Builder url_config(URLConfig r100) {
            this.url_config = r100;
            return this;
        }

        public Builder url_regex(URLRegex r100) {
            this.url_regex = r100;
            return this;
        }

        public Builder voice_call_config(VoiceCallConfig r100) {
            this.voice_call_config = r100;
            return this;
        }

        public Builder zendesk(Zendesk r100) {
            this.zendesk = r100;
            return this;
        }
    }

    public static final class ChatConfig extends com.squareup.wire.Message<ChatConfig, Builder> {
        public static final ProtoAdapter<ChatConfig> ADAPTER = null;
        public static final Integer DEFAULT_MAX_MEMBER_COUNT = null;
        public static final Integer DEFAULT_MAX_ORIGIN_GROUP_CHAT_USER_COUNT_4_CREATE_EXTERNAL_CHAT = null;
        public static final Integer DEFAULT_WITHDRAW_CHATTER_EXPIRATION_BY_HOUR = null;
        public static final FieldOptions FIELD_OPTIONS_MAX_MEMBER_COUNT = null;
        public static final FieldOptions FIELD_OPTIONS_MAX_ORIGIN_GROUP_CHAT_USER_COUNT_4_CREATE_EXTERNAL_CHAT = null;
        public static final FieldOptions FIELD_OPTIONS_POST_PERMISSION = null;
        public static final FieldOptions FIELD_OPTIONS_WITHDRAW_CHATTER_EXPIRATION_BY_HOUR = null;
        private static final long serialVersionUID = 0;
        public final Integer max_member_count;
        public final Integer max_origin_group_chat_user_count_4_create_external_chat;
        public final ChatPostPermission post_permission;
        public final Integer withdraw_chatter_expiration_by_hour;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatConfig, Builder> {
            public Integer max_member_count;
            public Integer max_origin_group_chat_user_count_4_create_external_chat;
            public ChatPostPermission post_permission;
            public Integer withdraw_chatter_expiration_by_hour;

            @Override // com.squareup.wire.Message.Builder
            public ChatConfig build() {
                return new ChatConfig(this.max_member_count, this.post_permission, this.withdraw_chatter_expiration_by_hour, this.max_origin_group_chat_user_count_4_create_external_chat, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder max_member_count(Integer r100) {
                this.max_member_count = r100;
                return this;
            }

            public Builder max_origin_group_chat_user_count_4_create_external_chat(Integer r100) {
                this.max_origin_group_chat_user_count_4_create_external_chat = r100;
                return this;
            }

            public Builder post_permission(ChatPostPermission r100) {
                this.post_permission = r100;
                return this;
            }

            public Builder withdraw_chatter_expiration_by_hour(Integer r100) {
                this.withdraw_chatter_expiration_by_hour = r100;
                return this;
            }
        }

        public static final class ChatPostPermission extends com.squareup.wire.Message<ChatPostPermission, Builder> {
            public static final ProtoAdapter<ChatPostPermission> ADAPTER = null;
            public static final Boolean DEFAULT_OPEN_TO_THREAD = null;
            public static final FieldOptions FIELD_OPTIONS_OPEN_TO_THREAD = null;
            private static final long serialVersionUID = 0;
            public final Boolean open_to_thread;

            public static final class Builder extends com.squareup.wire.Message.Builder<ChatPostPermission, Builder> {
                public Boolean open_to_thread;

                @Override // com.squareup.wire.Message.Builder
                public ChatPostPermission build() {
                    return new ChatPostPermission(this.open_to_thread, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder open_to_thread(Boolean r100) {
                    this.open_to_thread = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_ChatPostPermission extends ProtoAdapter<ChatPostPermission> {
                public ProtoAdapter_ChatPostPermission() {
                    super(FieldEncoding.LENGTH_DELIMITED, ChatPostPermission.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ChatPostPermission decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.open_to_thread = Boolean.FALSE;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.open_to_thread = ProtoAdapter.BOOL.decode(r100);
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
                public int encodedSize2(ChatPostPermission r100) {
                    Boolean r101 = r100.open_to_thread;
                    if (r101 == null) goto L5;
                    int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
                L7:
                    return r102 + r100.unknownFields().size();
                L5:
                    r102 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ChatPostPermission decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ChatPostPermission r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ChatPostPermission r101) throws IOException {
                    Boolean r102 = r101.open_to_thread;
                    if (r102 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatPostPermission r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ChatPostPermission();
                FIELD_OPTIONS_OPEN_TO_THREAD = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
                DEFAULT_OPEN_TO_THREAD = Boolean.FALSE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.open_to_thread = this.open_to_thread;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ChatPostPermission.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public ChatPostPermission(Boolean r100) {
                this(r100, ByteString.EMPTY);
            }

            public ChatPostPermission(Boolean r100, ByteString r101) {
                super(ADAPTER, r101);
                this.open_to_thread = r100;
            }
        }

        public static final class ProtoAdapter_ChatConfig extends ProtoAdapter<ChatConfig> {
            public ProtoAdapter_ChatConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.max_member_count = 2000;
                r101.withdraw_chatter_expiration_by_hour = 0;
                r101.max_origin_group_chat_user_count_4_create_external_chat = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.max_member_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.post_permission = ChatPostPermission.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.withdraw_chatter_expiration_by_hour = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.max_origin_group_chat_user_count_4_create_external_chat = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(ChatConfig r100) {
                Integer r101 = r100.max_member_count;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                ChatPostPermission r104 = r100.post_permission;
                if (r104 == null) goto L9;
                int r105 = ChatPostPermission.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.withdraw_chatter_expiration_by_hour;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Integer r110 = r100.max_origin_group_chat_user_count_4_create_external_chat;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ ChatConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatConfig r101) throws IOException {
                Integer r102 = r101.max_member_count;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                ChatPostPermission r103 = r101.post_permission;
                if (r103 == null) goto L8;
                ChatPostPermission.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.withdraw_chatter_expiration_by_hour;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                Integer r105 = r101.max_origin_group_chat_user_count_4_create_external_chat;
                if (r105 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatConfig();
            FIELD_OPTIONS_MAX_MEMBER_COUNT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_POST_PERMISSION = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_WITHDRAW_CHATTER_EXPIRATION_BY_HOUR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_MAX_ORIGIN_GROUP_CHAT_USER_COUNT_4_CREATE_EXTERNAL_CHAT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_MAX_MEMBER_COUNT = 2000;
            DEFAULT_WITHDRAW_CHATTER_EXPIRATION_BY_HOUR = 0;
            DEFAULT_MAX_ORIGIN_GROUP_CHAT_USER_COUNT_4_CREATE_EXTERNAL_CHAT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.max_member_count = this.max_member_count;
            r100.post_permission = this.post_permission;
            r100.withdraw_chatter_expiration_by_hour = this.withdraw_chatter_expiration_by_hour;
            r100.max_origin_group_chat_user_count_4_create_external_chat = this.max_origin_group_chat_user_count_4_create_external_chat;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatConfig(Integer r100, ChatPostPermission r101, Integer r102, Integer r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ChatConfig(Integer r100, ChatPostPermission r101, Integer r102, Integer r103, ByteString r104) {
            super(ADAPTER, r104);
            this.max_member_count = r100;
            this.post_permission = r101;
            this.withdraw_chatter_expiration_by_hour = r102;
            this.max_origin_group_chat_user_count_4_create_external_chat = r103;
        }
    }

    public static final enum CryptoChatState extends Enum<CryptoChatState> implements WireEnum {
        private static final /* synthetic */ CryptoChatState[] $VALUES = null;
        public static final ProtoAdapter<CryptoChatState> ADAPTER = null;
        public static final CryptoChatState ALLOW = null;
        public static final CryptoChatState BLOCK = null;
        public static final CryptoChatState DEFAULT = null;
        public static final CryptoChatState UNKNOWN = null;
        private final int value;

        static {
            CryptoChatState r100 = new CryptoChatState("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CryptoChatState r101 = new CryptoChatState("ALLOW", 1, 1);
            ALLOW = r101;
            CryptoChatState r102 = new CryptoChatState("BLOCK", 2, 2);
            BLOCK = r102;
            CryptoChatState r103 = new CryptoChatState("DEFAULT", 3, 3);
            DEFAULT = r103;
            $VALUES = new CryptoChatState[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(CryptoChatState.class);
        }

        public static CryptoChatState[] values() {
            return (CryptoChatState[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CryptoChatState fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DEFAULT;
        L14:
            return BLOCK;
        L16:
            return ALLOW;
        L18:
            return UNKNOWN;
        }

        public static CryptoChatState valueOf(String r100) {
            return (CryptoChatState) a.a(CryptoChatState.class, r100);
        }

        private CryptoChatState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DataResidency extends com.squareup.wire.Message<DataResidency, Builder> {
        public static final ProtoAdapter<DataResidency> ADAPTER = null;
        public static final String DEFAULT_HELP_URL = "";
        public static final Boolean DEFAULT_IS_SHOW_RESIDENCY = null;
        public static final String DEFAULT_RESIDENCY = "";
        private static final long serialVersionUID = 0;
        public final String help_url;
        public final Boolean is_show_residency;
        public final String residency;

        public static final class Builder extends com.squareup.wire.Message.Builder<DataResidency, Builder> {
            public String help_url;
            public Boolean is_show_residency;
            public String residency;

            @Override // com.squareup.wire.Message.Builder
            public DataResidency build() {
                return new DataResidency(this.residency, this.is_show_residency, this.help_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder help_url(String r100) {
                this.help_url = r100;
                return this;
            }

            public Builder is_show_residency(Boolean r100) {
                this.is_show_residency = r100;
                return this;
            }

            public Builder residency(String r100) {
                this.residency = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataResidency extends ProtoAdapter<DataResidency> {
            public ProtoAdapter_DataResidency() {
                super(FieldEncoding.LENGTH_DELIMITED, DataResidency.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataResidency decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.residency = "";
                r101.is_show_residency = Boolean.FALSE;
                r101.help_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.residency = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.is_show_residency = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.help_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(DataResidency r100) {
                String r101 = r100.residency;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_show_residency;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.help_url;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ DataResidency decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataResidency r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataResidency r101) throws IOException {
                String r102 = r101.residency;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_show_residency;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.help_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataResidency r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataResidency();
            DEFAULT_IS_SHOW_RESIDENCY = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.residency = this.residency;
            r100.is_show_residency = this.is_show_residency;
            r100.help_url = this.help_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataResidency.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataResidency(String r100, Boolean r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DataResidency(String r100, Boolean r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.residency = r100;
            this.is_show_residency = r101;
            this.help_url = r102;
        }
    }

    public static final class DocUrlRegex extends com.squareup.wire.Message<DocUrlRegex, Builder> {
        public static final ProtoAdapter<DocUrlRegex> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_REGEX = null;
        private static final long serialVersionUID = 0;
        public final List<String> regex;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocUrlRegex, Builder> {
            public List<String> regex;

            @Override // com.squareup.wire.Message.Builder
            public DocUrlRegex build() {
                return new DocUrlRegex(this.regex, super.buildUnknownFields());
            }

            public Builder() {
                this.regex = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder regex(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.regex = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocUrlRegex extends ProtoAdapter<DocUrlRegex> {
            public ProtoAdapter_DocUrlRegex() {
                super(FieldEncoding.LENGTH_DELIMITED, DocUrlRegex.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocUrlRegex decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.regex.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(DocUrlRegex r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.regex) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocUrlRegex decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocUrlRegex r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocUrlRegex r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.regex);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocUrlRegex r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocUrlRegex();
            FIELD_OPTIONS_REGEX = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.regex = Internal.copyOf("regex", this.regex);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocUrlRegex.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocUrlRegex(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public DocUrlRegex(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.regex = Internal.immutableCopyOf("regex", r100);
        }
    }

    public static final class MessageConfig extends com.squareup.wire.Message<MessageConfig, Builder> {
        public static final ProtoAdapter<MessageConfig> ADAPTER = null;
        public static final Long DEFAULT_MAX_RECALL_TIME_LIMIT = null;
        public static final FieldOptions FIELD_OPTIONS_MAX_RECALL_TIME_LIMIT = null;
        private static final long serialVersionUID = 0;
        public final Long max_recall_time_limit;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageConfig, Builder> {
            public Long max_recall_time_limit;

            @Override // com.squareup.wire.Message.Builder
            public MessageConfig build() {
                return new MessageConfig(this.max_recall_time_limit, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder max_recall_time_limit(Long r100) {
                this.max_recall_time_limit = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageConfig extends ProtoAdapter<MessageConfig> {
            public ProtoAdapter_MessageConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.max_recall_time_limit = 1440L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.max_recall_time_limit = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(MessageConfig r100) {
                Long r101 = r100.max_recall_time_limit;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageConfig r101) throws IOException {
                Long r102 = r101.max_recall_time_limit;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageConfig();
            FIELD_OPTIONS_MAX_RECALL_TIME_LIMIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_MAX_RECALL_TIME_LIMIT = 1440L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.max_recall_time_limit = this.max_recall_time_limit;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageConfig(Long r100) {
            this(r100, ByteString.EMPTY);
        }

        public MessageConfig(Long r100, ByteString r101) {
            super(ADAPTER, r101);
            this.max_recall_time_limit = r100;
        }
    }

    public static final class ProtoAdapter_AppConfig extends ProtoAdapter<AppConfig> implements c<AppConfig> {
        public ProtoAdapter_AppConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, AppConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppConfig decode(ProtoReader r110) throws IOException {
            Builder r100 = new Builder();
            r100.guide_to_rate_delay_hours = -1;
            r100.crypto_chat_state = CryptoChatState.UNKNOWN;
            long r101 = r110.beginMessage();
        L3:
            int r102 = r110.nextTag();
            if (r102 == (-1)) goto L26;
            switch(r102) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L28;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L28:
            r100.crypto_chat_state = CryptoChatState.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r100.data_residency = DataResidency.ADAPTER.decode(r110);
            goto L3
        L8:
            r100.urgent_num = UrgentNum.ADAPTER.decode(r110);
            goto L3
        L13:
            r100.banner_config = BannerConfig.ADAPTER.decode(r110);
            goto L3
        L14:
            r100.search_config = SearchConfig.ADAPTER.decode(r110);
            goto L3
        L15:
            r100.guide_to_rate_delay_hours = ProtoAdapter.INT32.decode(r110);
            goto L3
        L16:
            r100.android_app_stores.add(ProtoAdapter.STRING.decode(r110));
            goto L3
        L17:
            r100.zendesk = Zendesk.ADAPTER.decode(r110);
            goto L3
        L18:
            r100.url_regex = URLRegex.ADAPTER.decode(r110);
            goto L3
        L19:
            r100.billing_package = BillingPackageConfig.ADAPTER.decode(r110);
            goto L3
        L20:
            r100.doc_url_regex = DocUrlRegex.ADAPTER.decode(r110);
            goto L3
        L21:
            r100.resource = Resource.ADAPTER.decode(r110);
            goto L3
        L22:
            r100.url_config = URLConfig.ADAPTER.decode(r110);
            goto L3
        L23:
            r100.voice_call_config = VoiceCallConfig.ADAPTER.decode(r110);
            goto L3
        L24:
            r100.chat_config = ChatConfig.ADAPTER.decode(r110);
            goto L3
        L25:
            r100.message_config = MessageConfig.ADAPTER.decode(r110);
            goto L3
        L6:
            FieldEncoding r103 = r110.peekFieldEncoding();
            r100.addUnknownField(r102, r103, r103.rawProtoAdapter().decode(r110));
            goto L3
        L26:
            r110.endMessage(r101);
            return r100.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppConfig r100) {
            MessageConfig r101 = r100.message_config;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MessageConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ChatConfig r104 = r100.chat_config;
            if (r104 == null) goto L9;
            int r105 = ChatConfig.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            VoiceCallConfig r107 = r100.voice_call_config;
            if (r107 == null) goto L13;
            int r108 = VoiceCallConfig.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            URLConfig r110 = r100.url_config;
            if (r110 == null) goto L17;
            int r111 = URLConfig.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Resource r113 = r100.resource;
            if (r113 == null) goto L21;
            int r114 = Resource.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            DocUrlRegex r116 = r100.doc_url_regex;
            if (r116 == null) goto L25;
            int r117 = DocUrlRegex.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            BillingPackageConfig r119 = r100.billing_package;
            if (r119 == null) goto L29;
            int r120 = BillingPackageConfig.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            URLRegex r122 = r100.url_regex;
            if (r122 == null) goto L33;
            int r123 = URLRegex.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Zendesk r125 = r100.zendesk;
            if (r125 == null) goto L37;
            int r126 = Zendesk.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = (r124 + r126) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, r100.android_app_stores);
            Integer r128 = r100.guide_to_rate_delay_hours;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            SearchConfig r131 = r100.search_config;
            if (r131 == null) goto L45;
            int r132 = SearchConfig.ADAPTER.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            BannerConfig r134 = r100.banner_config;
            if (r134 == null) goto L49;
            int r135 = BannerConfig.ADAPTER.encodedSizeWithTag(13, r134);
        L50:
            int r136 = r133 + r135;
            CryptoChatState r137 = r100.crypto_chat_state;
            if (r137 == null) goto L53;
            int r138 = CryptoChatState.ADAPTER.encodedSizeWithTag(14, r137);
        L54:
            int r139 = r136 + r138;
            UrgentNum r140 = r100.urgent_num;
            if (r140 == null) goto L57;
            int r141 = UrgentNum.ADAPTER.encodedSizeWithTag(15, r140);
        L58:
            int r142 = r139 + r141;
            DataResidency r143 = r100.data_residency;
            if (r143 == null) goto L62;
            r102 = DataResidency.ADAPTER.encodedSizeWithTag(16, r143);
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
        public /* bridge */ /* synthetic */ AppConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppConfig r101) throws IOException {
            MessageConfig r102 = r101.message_config;
            if (r102 == null) goto L5;
            MessageConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ChatConfig r103 = r101.chat_config;
            if (r103 == null) goto L8;
            ChatConfig.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            VoiceCallConfig r104 = r101.voice_call_config;
            if (r104 == null) goto L11;
            VoiceCallConfig.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            URLConfig r105 = r101.url_config;
            if (r105 == null) goto L14;
            URLConfig.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Resource r106 = r101.resource;
            if (r106 == null) goto L17;
            Resource.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            DocUrlRegex r107 = r101.doc_url_regex;
            if (r107 == null) goto L20;
            DocUrlRegex.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            BillingPackageConfig r108 = r101.billing_package;
            if (r108 == null) goto L23;
            BillingPackageConfig.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            URLRegex r109 = r101.url_regex;
            if (r109 == null) goto L26;
            URLRegex.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            Zendesk r110 = r101.zendesk;
            if (r110 == null) goto L29;
            Zendesk.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 10, r101.android_app_stores);
            Integer r111 = r101.guide_to_rate_delay_hours;
            if (r111 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r111);
        L32:
            SearchConfig r112 = r101.search_config;
            if (r112 == null) goto L35;
            SearchConfig.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            BannerConfig r113 = r101.banner_config;
            if (r113 == null) goto L38;
            BannerConfig.ADAPTER.encodeWithTag(r100, 13, r113);
        L38:
            CryptoChatState r114 = r101.crypto_chat_state;
            if (r114 == null) goto L41;
            CryptoChatState.ADAPTER.encodeWithTag(r100, 14, r114);
        L41:
            UrgentNum r115 = r101.urgent_num;
            if (r115 == null) goto L44;
            UrgentNum.ADAPTER.encodeWithTag(r100, 15, r115);
        L44:
            DataResidency r116 = r101.data_residency;
            if (r116 == null) goto L47;
            DataResidency.ADAPTER.encodeWithTag(r100, 16, r116);
        L47:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Resource extends com.squareup.wire.Message<Resource, Builder> {
        public static final ProtoAdapter<Resource> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_ADDRS = null;
        private static final long serialVersionUID = 0;
        public final Map<String, String> addrs;

        public static final class Builder extends com.squareup.wire.Message.Builder<Resource, Builder> {
            public Map<String, String> addrs;

            @Override // com.squareup.wire.Message.Builder
            public Resource build() {
                return new Resource(this.addrs, super.buildUnknownFields());
            }

            public Builder() {
                this.addrs = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder addrs(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.addrs = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Resource extends ProtoAdapter<Resource> {
            private final ProtoAdapter<Map<String, String>> addrs;

            public ProtoAdapter_Resource() {
                super(FieldEncoding.LENGTH_DELIMITED, Resource.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.addrs = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Resource decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.addrs.putAll(this.addrs.decode(r100));
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
            public int encodedSize2(Resource r100) {
                return this.addrs.encodedSizeWithTag(1, r100.addrs) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Resource decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Resource r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Resource r101) throws IOException {
                this.addrs.encodeWithTag(r100, 1, r101.addrs);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Resource r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Resource();
            FIELD_OPTIONS_ADDRS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addrs = Internal.copyOf("addrs", this.addrs);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Resource.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Resource(Map<String, String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Resource(Map<String, String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.addrs = Internal.immutableCopyOf("addrs", r100);
        }
    }

    public static final class SearchConfig extends com.squareup.wire.Message<SearchConfig, Builder> {
        public static final ProtoAdapter<SearchConfig> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_EXTERNAL_SEARCHES = null;
        private static final long serialVersionUID = 0;
        public final List<ExternalSearch> external_searches;

        public static final class Builder extends com.squareup.wire.Message.Builder<SearchConfig, Builder> {
            public List<ExternalSearch> external_searches;

            @Override // com.squareup.wire.Message.Builder
            public SearchConfig build() {
                return new SearchConfig(this.external_searches, super.buildUnknownFields());
            }

            public Builder() {
                this.external_searches = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder external_searches(List<ExternalSearch> r100) {
                Internal.checkElementsNotNull(r100);
                this.external_searches = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchConfig extends ProtoAdapter<SearchConfig> {
            public ProtoAdapter_SearchConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SearchConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.external_searches.add(ExternalSearch.ADAPTER.decode(r100));
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
            public int encodedSize2(SearchConfig r100) {
                return ExternalSearch.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.external_searches) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SearchConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SearchConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SearchConfig r101) throws IOException {
                ExternalSearch.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.external_searches);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SearchConfig();
            FIELD_OPTIONS_EXTERNAL_SEARCHES = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.external_searches = Internal.copyOf("external_searches", this.external_searches);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SearchConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SearchConfig(List<ExternalSearch> r100) {
            this(r100, ByteString.EMPTY);
        }

        public SearchConfig(List<ExternalSearch> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.external_searches = Internal.immutableCopyOf("external_searches", r100);
        }
    }

    public static final class URLConfig extends com.squareup.wire.Message<URLConfig, Builder> {
        public static final ProtoAdapter<URLConfig> ADAPTER = null;
        public static final String DEFAULT_CREATE_DOC_ADDR = "";
        public static final FieldOptions FIELD_OPTIONS_CREATE_DOC_ADDR = null;
        public static final FieldOptions FIELD_OPTIONS_DOC_DOMAINS = null;
        public static final FieldOptions FIELD_OPTIONS_DOMAIN = null;
        private static final long serialVersionUID = 0;
        public final String create_doc_addr;
        public final List<Domain> doc_domains;
        public final Domain domain;

        public static final class Builder extends com.squareup.wire.Message.Builder<URLConfig, Builder> {
            public String create_doc_addr;
            public List<Domain> doc_domains;
            public Domain domain;

            @Override // com.squareup.wire.Message.Builder
            public URLConfig build() {
                return new URLConfig(this.domain, this.doc_domains, this.create_doc_addr, super.buildUnknownFields());
            }

            public Builder() {
                this.doc_domains = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder create_doc_addr(String r100) {
                this.create_doc_addr = r100;
                return this;
            }

            public Builder doc_domains(List<Domain> r100) {
                Internal.checkElementsNotNull(r100);
                this.doc_domains = r100;
                return this;
            }

            public Builder domain(Domain r100) {
                this.domain = r100;
                return this;
            }
        }

        public static final class Domain extends com.squareup.wire.Message<Domain, Builder> {
            public static final ProtoAdapter<Domain> ADAPTER = null;
            public static final String DEFAULT_DOMAIN = "";
            public static final FieldOptions FIELD_OPTIONS_DOMAIN = null;
            private static final long serialVersionUID = 0;
            public final String domain;

            public static final class Builder extends com.squareup.wire.Message.Builder<Domain, Builder> {
                public String domain;

                @Override // com.squareup.wire.Message.Builder
                public Domain build() {
                    return new Domain(this.domain, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder domain(String r100) {
                    this.domain = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Domain extends ProtoAdapter<Domain> {
                public ProtoAdapter_Domain() {
                    super(FieldEncoding.LENGTH_DELIMITED, Domain.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Domain decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.domain = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.domain = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(Domain r100) {
                    String r101 = r100.domain;
                    if (r101 == null) goto L5;
                    int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L7:
                    return r102 + r100.unknownFields().size();
                L5:
                    r102 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Domain decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Domain r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Domain r101) throws IOException {
                    String r102 = r101.domain;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Domain r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Domain();
                FIELD_OPTIONS_DOMAIN = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.domain = this.domain;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Domain.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Domain(String r100) {
                this(r100, ByteString.EMPTY);
            }

            public Domain(String r100, ByteString r101) {
                super(ADAPTER, r101);
                this.domain = r100;
            }
        }

        public static final class ProtoAdapter_URLConfig extends ProtoAdapter<URLConfig> {
            public ProtoAdapter_URLConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, URLConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public URLConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.create_doc_addr = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.domain = Domain.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.doc_domains.add(Domain.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.create_doc_addr = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(URLConfig r100) {
                Domain r101 = r100.domain;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Domain.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + Domain.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.doc_domains);
                String r105 = r100.create_doc_addr;
                if (r105 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
            L10:
                return (r104 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ URLConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(URLConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, URLConfig r101) throws IOException {
                Domain r102 = r101.domain;
                if (r102 == null) goto L5;
                Domain.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Domain.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.doc_domains);
                String r103 = r101.create_doc_addr;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URLConfig();
            FIELD_OPTIONS_DOMAIN = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_DOC_DOMAINS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_CREATE_DOC_ADDR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.domain = this.domain;
            r100.doc_domains = Internal.copyOf("doc_domains", this.doc_domains);
            r100.create_doc_addr = this.create_doc_addr;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return URLConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public URLConfig(Domain r100, List<Domain> r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public URLConfig(Domain r100, List<Domain> r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.domain = r100;
            this.doc_domains = Internal.immutableCopyOf("doc_domains", r101);
            this.create_doc_addr = r102;
        }
    }

    public static final class URLRegex extends com.squareup.wire.Message<URLRegex, Builder> {
        public static final ProtoAdapter<URLRegex> ADAPTER = null;
        public static final Integer DEFAULT_TIME_OUT = null;
        public static final FieldOptions FIELD_OPTIONS_REGEXES = null;
        public static final FieldOptions FIELD_OPTIONS_TIME_OUT = null;
        private static final long serialVersionUID = 0;
        public final Map<Integer, String> regexes;
        public final Integer time_out;

        public static final class Builder extends com.squareup.wire.Message.Builder<URLRegex, Builder> {
            public Map<Integer, String> regexes;
            public Integer time_out;

            @Override // com.squareup.wire.Message.Builder
            public URLRegex build() {
                return new URLRegex(this.regexes, this.time_out, super.buildUnknownFields());
            }

            public Builder() {
                this.regexes = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder regexes(Map<Integer, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.regexes = r100;
                return this;
            }

            public Builder time_out(Integer r100) {
                this.time_out = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_URLRegex extends ProtoAdapter<URLRegex> {
            private final ProtoAdapter<Map<Integer, String>> regexes;

            public ProtoAdapter_URLRegex() {
                super(FieldEncoding.LENGTH_DELIMITED, URLRegex.class);
                this.regexes = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.STRING);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public URLRegex decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.time_out = 300;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.regexes.putAll(this.regexes.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.time_out = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(URLRegex r100) {
                int r101 = this.regexes.encodedSizeWithTag(1, r100.regexes);
                Integer r102 = r100.time_out;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ URLRegex decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(URLRegex r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, URLRegex r101) throws IOException {
                this.regexes.encodeWithTag(r100, 1, r101.regexes);
                Integer r102 = r101.time_out;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLRegex r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URLRegex();
            FIELD_OPTIONS_REGEXES = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_TIME_OUT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_TIME_OUT = 300;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.regexes = Internal.copyOf("regexes", this.regexes);
            r100.time_out = this.time_out;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return URLRegex.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public URLRegex(Map<Integer, String> r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public URLRegex(Map<Integer, String> r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.regexes = Internal.immutableCopyOf("regexes", r100);
            this.time_out = r101;
        }
    }

    public static final class UrgentNum extends com.squareup.wire.Message<UrgentNum, Builder> {
        public static final ProtoAdapter<UrgentNum> ADAPTER = null;
        public static final Long DEFAULT_UPDATE_TIME = null;
        public static final FieldOptions FIELD_OPTIONS_NUMS = null;
        public static final FieldOptions FIELD_OPTIONS_UPDATE_TIME = null;
        private static final long serialVersionUID = 0;
        public final List<String> nums;
        public final Long update_time;

        public static final class Builder extends com.squareup.wire.Message.Builder<UrgentNum, Builder> {
            public List<String> nums;
            public Long update_time;

            @Override // com.squareup.wire.Message.Builder
            public UrgentNum build() {
                return new UrgentNum(this.nums, this.update_time, super.buildUnknownFields());
            }

            public Builder() {
                this.nums = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder nums(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.nums = r100;
                return this;
            }

            public Builder update_time(Long r100) {
                this.update_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UrgentNum extends ProtoAdapter<UrgentNum> {
            public ProtoAdapter_UrgentNum() {
                super(FieldEncoding.LENGTH_DELIMITED, UrgentNum.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UrgentNum decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.update_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.nums.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.update_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(UrgentNum r100) {
                int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.nums);
                Long r102 = r100.update_time;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UrgentNum decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UrgentNum r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UrgentNum r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.nums);
                Long r102 = r101.update_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrgentNum r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UrgentNum();
            FIELD_OPTIONS_NUMS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_UPDATE_TIME = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_UPDATE_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.nums = Internal.copyOf("nums", this.nums);
            r100.update_time = this.update_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UrgentNum.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UrgentNum(List<String> r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public UrgentNum(List<String> r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.nums = Internal.immutableCopyOf("nums", r100);
            this.update_time = r101;
        }
    }

    public static final class VoiceCallConfig extends com.squareup.wire.Message<VoiceCallConfig, Builder> {
        public static final ProtoAdapter<VoiceCallConfig> ADAPTER = null;
        public static final Integer DEFAULT_HEARTBEAT_CYCLE = null;
        public static final Integer DEFAULT_HEARTBEAT_EXPIRED_TIME = null;
        public static final FieldOptions FIELD_OPTIONS_HEARTBEAT_CYCLE = null;
        public static final FieldOptions FIELD_OPTIONS_HEARTBEAT_EXPIRED_TIME = null;
        private static final long serialVersionUID = 0;
        public final Integer heartbeat_cycle;
        public final Integer heartbeat_expired_time;

        public static final class Builder extends com.squareup.wire.Message.Builder<VoiceCallConfig, Builder> {
            public Integer heartbeat_cycle;
            public Integer heartbeat_expired_time;

            @Override // com.squareup.wire.Message.Builder
            public VoiceCallConfig build() {
                return new VoiceCallConfig(this.heartbeat_cycle, this.heartbeat_expired_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder heartbeat_cycle(Integer r100) {
                this.heartbeat_cycle = r100;
                return this;
            }

            public Builder heartbeat_expired_time(Integer r100) {
                this.heartbeat_expired_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_VoiceCallConfig extends ProtoAdapter<VoiceCallConfig> {
            public ProtoAdapter_VoiceCallConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, VoiceCallConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public VoiceCallConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.heartbeat_cycle = 3;
                r101.heartbeat_expired_time = 12;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L11;
                if (r103 != 2) goto L7;
                r101.heartbeat_cycle = ProtoAdapter.INT32.decode(r100);
                goto L3
            L7:
                if (r103 != 3) goto L8;
                r101.heartbeat_expired_time = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L11:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(VoiceCallConfig r100) {
                Integer r101 = r100.heartbeat_cycle;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r101);
            L6:
                Integer r104 = r100.heartbeat_expired_time;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ VoiceCallConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(VoiceCallConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, VoiceCallConfig r101) throws IOException {
                Integer r102 = r101.heartbeat_cycle;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
            L5:
                Integer r103 = r101.heartbeat_expired_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VoiceCallConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VoiceCallConfig();
            FIELD_OPTIONS_HEARTBEAT_CYCLE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_HEARTBEAT_EXPIRED_TIME = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_HEARTBEAT_CYCLE = 3;
            DEFAULT_HEARTBEAT_EXPIRED_TIME = 12;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.heartbeat_cycle = this.heartbeat_cycle;
            r100.heartbeat_expired_time = this.heartbeat_expired_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return VoiceCallConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public VoiceCallConfig(Integer r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public VoiceCallConfig(Integer r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.heartbeat_cycle = r100;
            this.heartbeat_expired_time = r101;
        }
    }

    public static final class Zendesk extends com.squareup.wire.Message<Zendesk, Builder> {
        public static final ProtoAdapter<Zendesk> ADAPTER = null;
        public static final Boolean DEFAULT_ONCALL_CHAT = null;
        public static final String DEFAULT_WEB_FORM_URL = "";
        public static final FieldOptions FIELD_OPTIONS_ONCALL_CHAT = null;
        public static final FieldOptions FIELD_OPTIONS_WEB_FORM_URL = null;
        private static final long serialVersionUID = 0;
        public final Boolean oncall_chat;
        public final String web_form_url;

        public static final class Builder extends com.squareup.wire.Message.Builder<Zendesk, Builder> {
            public Boolean oncall_chat;
            public String web_form_url;

            @Override // com.squareup.wire.Message.Builder
            public Zendesk build() {
                return new Zendesk(this.web_form_url, this.oncall_chat, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder oncall_chat(Boolean r100) {
                this.oncall_chat = r100;
                this.web_form_url = null;
                return this;
            }

            public Builder web_form_url(String r100) {
                this.web_form_url = r100;
                this.oncall_chat = null;
                return this;
            }
        }

        public static final class ProtoAdapter_Zendesk extends ProtoAdapter<Zendesk> {
            public ProtoAdapter_Zendesk() {
                super(FieldEncoding.LENGTH_DELIMITED, Zendesk.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Zendesk decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.web_form_url("");
                r101.oncall_chat(Boolean.FALSE);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.web_form_url(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.oncall_chat(ProtoAdapter.BOOL.decode(r100));
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
            public int encodedSize2(Zendesk r100) {
                String r101 = r100.web_form_url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.oncall_chat;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Zendesk decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Zendesk r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Zendesk r101) throws IOException {
                String r102 = r101.web_form_url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.oncall_chat;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Zendesk r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Zendesk();
            FIELD_OPTIONS_WEB_FORM_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_ONCALL_CHAT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_ONCALL_CHAT = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.web_form_url = this.web_form_url;
            r100.oncall_chat = this.oncall_chat;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Zendesk.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Zendesk(String r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Zendesk(String r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            if (Internal.countNonNull(r100, r101) > 1) goto L7;
            this.web_form_url = r100;
            this.oncall_chat = r101;
            return;
        L7:
            throw new IllegalArgumentException("at most one of web_form_url, oncall_chat may be non-null");
        }
    }

    static {
        ProtoAdapter_AppConfig r100 = new ProtoAdapter_AppConfig();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_MESSAGE_CONFIG = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CHAT_CONFIG = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_VOICE_CALL_CONFIG = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_URL_CONFIG = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_RESOURCE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DOC_URL_REGEX = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_BILLING_PACKAGE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_URL_REGEX = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ZENDESK = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ANDROID_APP_STORES = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_GUIDE_TO_RATE_DELAY_HOURS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SEARCH_CONFIG = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_BANNER_CONFIG = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CRYPTO_CHAT_STATE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_URGENT_NUM = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DATA_RESIDENCY = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_GUIDE_TO_RATE_DELAY_HOURS = -1;
        DEFAULT_CRYPTO_CHAT_STATE = CryptoChatState.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_config = this.message_config;
        r100.chat_config = this.chat_config;
        r100.voice_call_config = this.voice_call_config;
        r100.url_config = this.url_config;
        r100.resource = this.resource;
        r100.doc_url_regex = this.doc_url_regex;
        r100.billing_package = this.billing_package;
        r100.url_regex = this.url_regex;
        r100.zendesk = this.zendesk;
        r100.android_app_stores = Internal.copyOf("android_app_stores", this.android_app_stores);
        r100.guide_to_rate_delay_hours = this.guide_to_rate_delay_hours;
        r100.search_config = this.search_config;
        r100.banner_config = this.banner_config;
        r100.crypto_chat_state = this.crypto_chat_state;
        r100.urgent_num = this.urgent_num;
        r100.data_residency = this.data_residency;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppConfig(MessageConfig r110, ChatConfig r210, VoiceCallConfig r211, URLConfig r212, Resource r213, DocUrlRegex r214, BillingPackageConfig r215, URLRegex r216, Zendesk r217, List<String> r218, Integer r219, SearchConfig r310, BannerConfig r311, CryptoChatState r312, UrgentNum r313, DataResidency r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public AppConfig(MessageConfig r100, ChatConfig r101, VoiceCallConfig r102, URLConfig r103, Resource r104, DocUrlRegex r105, BillingPackageConfig r110, URLRegex r111, Zendesk r112, List<String> r113, Integer r114, SearchConfig r115, BannerConfig r116, CryptoChatState r117, UrgentNum r118, DataResidency r119, ByteString r210) {
        super(ADAPTER, r210);
        this.message_config = r100;
        this.chat_config = r101;
        this.voice_call_config = r102;
        this.url_config = r103;
        this.resource = r104;
        this.doc_url_regex = r105;
        this.billing_package = r110;
        this.url_regex = r111;
        this.zendesk = r112;
        this.android_app_stores = Internal.immutableCopyOf("android_app_stores", r113);
        this.guide_to_rate_delay_hours = r114;
        this.search_config = r115;
        this.banner_config = r116;
        this.crypto_chat_state = r117;
        this.urgent_num = r118;
        this.data_residency = r119;
    }
}
