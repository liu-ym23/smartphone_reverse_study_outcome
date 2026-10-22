package com.bytedance.lark.pb.basic.v1;

import androidx.camera.video.AudioStats;
import annotation.Debug;
import com.alipay.sdk.m.l.b;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.protobuf.FieldOptions;
import com.obric.miniapp.alarm.AccountType;
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

/* JADX INFO: loaded from: classes20.dex */
public final class InitSDKRequest extends com.squareup.wire.Message<InitSDKRequest, Builder> {
    public static final ProtoAdapter<InitSDKRequest> ADAPTER = null;
    public static final String DEFAULT_APP_CHANNEL = "";
    public static final String DEFAULT_APP_ID = "1161";
    public static final Boolean DEFAULT_BASIC_MODE = null;
    public static final String DEFAULT_BOE_TT_FEATURE_ENV = "";
    public static final String DEFAULT_CLIENT_LOG_STORAGE_PATH = "";
    public static final String DEFAULT_CUSTOM_LOG_PATH = "";
    public static final DataSynchronismStrategy DEFAULT_DATA_SYNCHRONISM_STRATEGY = null;
    public static final String DEFAULT_DEVICE_MODEL = "";
    public static final DevicePerfLevel DEFAULT_DEVICE_PERF_LEVEL = null;
    public static final Boolean DEFAULT_ENABLE_NEW_TTNET_LOG_REPORTER = null;
    public static final Boolean DEFAULT_ENABLE_THREAD = null;
    public static final Boolean DEFAULT_ENABLE_THREAD_SUBSCRIPTION = null;
    public static final EnvType DEFAULT_ENV = null;
    public static final Integer DEFAULT_EPOCH_STEP_COUNT = null;
    public static final Integer DEFAULT_EXPECTED_THREAD = null;
    public static final String DEFAULT_INIT_CONFIG_PATH = "";
    public static final Boolean DEFAULT_IS_ANYDOOR_ENABLE = null;
    public static final Boolean DEFAULT_IS_RELEASE = null;
    public static final Boolean DEFAULT_IS_WRAP_ASYNC_CALLBACK_DATA_WITH_PACKET = null;
    public static final String DEFAULT_LOCALE_IDENTIFIER = "zh_CN";
    public static final String DEFAULT_LOCAL_TIMEZONE = "";
    public static final Long DEFAULT_MAIN_THREAD_ID = null;
    public static final Boolean DEFAULT_NEED_CALL_ASYNC = null;
    public static final Boolean DEFAULT_NEED_SETTINGS = null;
    public static final String DEFAULT_OLD_STORAGE_PATH = "";
    public static final String DEFAULT_OS_VERSION = "";
    public static final PackageId DEFAULT_PACKAGE_ID = null;
    public static final String DEFAULT_PATH_PREFIX = "";
    public static final Double DEFAULT_PER_WORKER_SPAWN_THRESHOLD = null;
    public static final PowerLevel DEFAULT_POWER_LEVEL_UNDER_BACKGROUND = null;
    public static final String DEFAULT_PRE_RPC_PERSIST_DYECP_FD_KEY = "";
    public static final String DEFAULT_PRE_RPC_PERSIST_DYECP_FD_VALUE = "";
    public static final String DEFAULT_PRE_RPC_PERSIST_MOCK_TAG_VALUE = "";
    public static final ProcessType DEFAULT_PROCESS_TYPE = null;
    public static final String DEFAULT_STORAGE_PATH = "";
    public static final String DEFAULT_STRESS_TEST_TAG = "";
    public static final String DEFAULT_SUB_ACCOUNT_PATH = "";
    public static final String DEFAULT_SUB_USER_PATH = "";
    public static final Integer DEFAULT_THREAD_PRIORITY = null;
    public static final String DEFAULT_USER_AGENT = "";
    public static final String DEFAULT_USER_ID = "";
    public static final Boolean DEFAULT_USE_DEPRECATED_PUSH_MSG = null;
    public static final String DEFAULT_VERSION = "";
    public static final String DEFAULT_WASM_INIT_CONFIG = "";
    public static final Long DEFAULT_WORKER_CREATE_DURATION = null;
    public static final Long DEFAULT_WORKER_RELEASE_DURATION = null;
    public static final String DEFAULT_X_TT_ENV = "";
    private static final long serialVersionUID = 0;
    public final String app_channel;
    public final String app_id;
    public final Boolean basic_mode;
    public final BoeRpcPersistDyecpFd boe_rpc_persist_dyecp_fd;
    public final String boe_tt_feature_env;
    public final ClientABExperiment client_ab_experiment;
    public final NetworkClientCertificate client_cert;
    public final String client_log_storage_path;
    public final List<String> client_stability_log_dirs;
    public final String custom_log_path;
    public final Map<String, String> customized_init_meta;
    public final DataSynchronismStrategy data_synchronism_strategy;
    public final DeprecatedConfig deprecated_config;
    public final DeviceInfo device_info;
    public final String device_model;
    public final DevicePerfLevel device_perf_level;
    public final Boolean enable_new_ttnet_log_reporter;
    public final Boolean enable_thread;
    public final Boolean enable_thread_subscription;
    public final EnvType env;
    public final EnvV2 env_v2;
    public final Integer epoch_step_count;
    public final Integer expected_thread;
    public final FrontierConfig frontier_config;
    public final String init_config_path;
    public final InitLogUpload init_log_upload;
    public final Boolean is_anydoor_enable;
    public final Boolean is_release;
    public final Boolean is_wrap_async_callback_data_with_packet;
    public final KaInitConfig ka_init_config;
    public final String local_timezone;
    public final String locale_identifier;
    public final LogSetting log_setting;
    public final Long main_thread_id;
    public final Boolean need_call_async;
    public final Boolean need_settings;
    public final List<NetDecorator> net_decorators;
    public final NetSemaphoreMonitorSetting net_semaphore_monitor_setting;
    public final NetworkSetting network_settings;
    public final String old_storage_path;
    public final String os_version;
    public final PackageId package_id;
    public final String path_prefix;
    public final Double per_worker_spawn_threshold;
    public final PowerLevel power_level_under_background;
    public final String pre_rpc_persist_dyecp_fd_key;
    public final String pre_rpc_persist_dyecp_fd_value;
    public final String pre_rpc_persist_mock_tag_value;
    public final PreloadConfig preload_config;
    public final ProcessType process_type;
    public final ProxyConfig proxy_config;
    public final Map<String, String> settings_queries;
    public final String storage_path;
    public final String stress_test_tag;
    public final String sub_account_path;
    public final String sub_user_path;
    public final List<String> tags;
    public final ThreadPoolMonitorSetting thread_pool_monitor_setting;
    public final Integer thread_priority;
    public final Boolean use_deprecated_push_msg;
    public final String user_agent;
    public final String user_id;
    public final String version;
    public final String wasm_init_config;
    public final Long worker_create_duration;
    public final Long worker_release_duration;
    public final String x_tt_env;

    public static final class BoeRpcPersistDyecpFd extends com.squareup.wire.Message<BoeRpcPersistDyecpFd, Builder> {
        public static final ProtoAdapter<BoeRpcPersistDyecpFd> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String key;
        public final String value;

        public static final class Builder extends com.squareup.wire.Message.Builder<BoeRpcPersistDyecpFd, Builder> {
            public String key;
            public String value;

            @Override // com.squareup.wire.Message.Builder
            public BoeRpcPersistDyecpFd build() {
                return new BoeRpcPersistDyecpFd(this.key, this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder value(String r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BoeRpcPersistDyecpFd extends ProtoAdapter<BoeRpcPersistDyecpFd> {
            public ProtoAdapter_BoeRpcPersistDyecpFd() {
                super(FieldEncoding.LENGTH_DELIMITED, BoeRpcPersistDyecpFd.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BoeRpcPersistDyecpFd decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.value = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.value = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(BoeRpcPersistDyecpFd r100) {
                String r101 = r100.key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
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
            public /* bridge */ /* synthetic */ BoeRpcPersistDyecpFd decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BoeRpcPersistDyecpFd r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BoeRpcPersistDyecpFd r101) throws IOException {
                String r102 = r101.key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.value;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BoeRpcPersistDyecpFd r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BoeRpcPersistDyecpFd();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BoeRpcPersistDyecpFd.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BoeRpcPersistDyecpFd(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public BoeRpcPersistDyecpFd(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.key = r100;
            this.value = r101;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<InitSDKRequest, Builder> {
        public String app_channel;
        public String app_id;
        public Boolean basic_mode;
        public BoeRpcPersistDyecpFd boe_rpc_persist_dyecp_fd;
        public String boe_tt_feature_env;
        public ClientABExperiment client_ab_experiment;
        public NetworkClientCertificate client_cert;
        public String client_log_storage_path;
        public List<String> client_stability_log_dirs;
        public String custom_log_path;
        public Map<String, String> customized_init_meta;
        public DataSynchronismStrategy data_synchronism_strategy;
        public DeprecatedConfig deprecated_config;
        public DeviceInfo device_info;
        public String device_model;
        public DevicePerfLevel device_perf_level;
        public Boolean enable_new_ttnet_log_reporter;
        public Boolean enable_thread;
        public Boolean enable_thread_subscription;
        public EnvType env;
        public EnvV2 env_v2;
        public Integer epoch_step_count;
        public Integer expected_thread;
        public FrontierConfig frontier_config;
        public String init_config_path;
        public InitLogUpload init_log_upload;
        public Boolean is_anydoor_enable;
        public Boolean is_release;
        public Boolean is_wrap_async_callback_data_with_packet;
        public KaInitConfig ka_init_config;
        public String local_timezone;
        public String locale_identifier;
        public LogSetting log_setting;
        public Long main_thread_id;
        public Boolean need_call_async;
        public Boolean need_settings;
        public List<NetDecorator> net_decorators;
        public NetSemaphoreMonitorSetting net_semaphore_monitor_setting;
        public NetworkSetting network_settings;
        public String old_storage_path;
        public String os_version;
        public PackageId package_id;
        public String path_prefix;
        public Double per_worker_spawn_threshold;
        public PowerLevel power_level_under_background;
        public String pre_rpc_persist_dyecp_fd_key;
        public String pre_rpc_persist_dyecp_fd_value;
        public String pre_rpc_persist_mock_tag_value;
        public PreloadConfig preload_config;
        public ProcessType process_type;
        public ProxyConfig proxy_config;
        public Map<String, String> settings_queries;
        public String storage_path;
        public String stress_test_tag;
        public String sub_account_path;
        public String sub_user_path;
        public List<String> tags;
        public ThreadPoolMonitorSetting thread_pool_monitor_setting;
        public Integer thread_priority;
        public Boolean use_deprecated_push_msg;
        public String user_agent;
        public String user_id;
        public String version;
        public String wasm_init_config;
        public Long worker_create_duration;
        public Long worker_release_duration;
        public String x_tt_env;

        @Override // com.squareup.wire.Message.Builder
        public InitSDKRequest build() {
            String r100 = this.storage_path;
            if (r100 == null) goto L13;
            if (this.version == null) goto L13;
            if (this.user_agent == null) goto L13;
            if (this.init_config_path == null) goto L13;
            return new InitSDKRequest(this.storage_path, this.env, this.version, this.user_agent, this.process_type, this.user_id, this.need_call_async, this.app_id, this.locale_identifier, this.client_log_storage_path, this.client_stability_log_dirs, this.path_prefix, this.sub_account_path, this.sub_user_path, this.old_storage_path, this.custom_log_path, this.init_log_upload, this.device_info, this.data_synchronism_strategy, this.enable_thread, this.is_wrap_async_callback_data_with_packet, this.enable_thread_subscription, this.use_deprecated_push_msg, this.preload_config, this.power_level_under_background, this.package_id, this.deprecated_config, this.ka_init_config, this.frontier_config, this.env_v2, this.main_thread_id, this.need_settings, this.client_cert, this.boe_tt_feature_env, this.boe_rpc_persist_dyecp_fd, this.local_timezone, this.init_config_path, this.basic_mode, this.stress_test_tag, this.wasm_init_config, this.is_release, this.pre_rpc_persist_dyecp_fd_key, this.pre_rpc_persist_dyecp_fd_value, this.pre_rpc_persist_mock_tag_value, this.os_version, this.is_anydoor_enable, this.device_model, this.x_tt_env, this.settings_queries, this.app_channel, this.proxy_config, this.worker_create_duration, this.per_worker_spawn_threshold, this.thread_priority, this.expected_thread, this.epoch_step_count, this.tags, this.worker_release_duration, this.device_perf_level, this.client_ab_experiment, this.log_setting, this.network_settings, this.net_semaphore_monitor_setting, this.thread_pool_monitor_setting, this.customized_init_meta, this.net_decorators, this.enable_new_ttnet_log_reporter, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "storage_path", this.version, "version", this.user_agent, b.f25480b, this.init_config_path, "init_config_path"});
        }

        public Builder() {
            this.client_stability_log_dirs = Internal.newMutableList();
            this.settings_queries = Internal.newMutableMap();
            this.tags = Internal.newMutableList();
            this.customized_init_meta = Internal.newMutableMap();
            this.net_decorators = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_channel(String r100) {
            this.app_channel = r100;
            return this;
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder basic_mode(Boolean r100) {
            this.basic_mode = r100;
            return this;
        }

        public Builder boe_rpc_persist_dyecp_fd(BoeRpcPersistDyecpFd r100) {
            this.boe_rpc_persist_dyecp_fd = r100;
            return this;
        }

        public Builder boe_tt_feature_env(String r100) {
            this.boe_tt_feature_env = r100;
            return this;
        }

        public Builder client_ab_experiment(ClientABExperiment r100) {
            this.client_ab_experiment = r100;
            return this;
        }

        public Builder client_cert(NetworkClientCertificate r100) {
            this.client_cert = r100;
            return this;
        }

        public Builder client_log_storage_path(String r100) {
            this.client_log_storage_path = r100;
            return this;
        }

        public Builder client_stability_log_dirs(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.client_stability_log_dirs = r100;
            return this;
        }

        public Builder custom_log_path(String r100) {
            this.custom_log_path = r100;
            return this;
        }

        public Builder customized_init_meta(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.customized_init_meta = r100;
            return this;
        }

        public Builder data_synchronism_strategy(DataSynchronismStrategy r100) {
            this.data_synchronism_strategy = r100;
            return this;
        }

        public Builder deprecated_config(DeprecatedConfig r100) {
            this.deprecated_config = r100;
            return this;
        }

        public Builder device_info(DeviceInfo r100) {
            this.device_info = r100;
            return this;
        }

        public Builder device_model(String r100) {
            this.device_model = r100;
            return this;
        }

        public Builder device_perf_level(DevicePerfLevel r100) {
            this.device_perf_level = r100;
            return this;
        }

        public Builder enable_new_ttnet_log_reporter(Boolean r100) {
            this.enable_new_ttnet_log_reporter = r100;
            return this;
        }

        public Builder enable_thread(Boolean r100) {
            this.enable_thread = r100;
            return this;
        }

        public Builder enable_thread_subscription(Boolean r100) {
            this.enable_thread_subscription = r100;
            return this;
        }

        public Builder env(EnvType r100) {
            this.env = r100;
            return this;
        }

        public Builder env_v2(EnvV2 r100) {
            this.env_v2 = r100;
            return this;
        }

        public Builder epoch_step_count(Integer r100) {
            this.epoch_step_count = r100;
            return this;
        }

        public Builder expected_thread(Integer r100) {
            this.expected_thread = r100;
            return this;
        }

        public Builder frontier_config(FrontierConfig r100) {
            this.frontier_config = r100;
            return this;
        }

        public Builder init_config_path(String r100) {
            this.init_config_path = r100;
            return this;
        }

        public Builder init_log_upload(InitLogUpload r100) {
            this.init_log_upload = r100;
            return this;
        }

        public Builder is_anydoor_enable(Boolean r100) {
            this.is_anydoor_enable = r100;
            return this;
        }

        public Builder is_release(Boolean r100) {
            this.is_release = r100;
            return this;
        }

        public Builder is_wrap_async_callback_data_with_packet(Boolean r100) {
            this.is_wrap_async_callback_data_with_packet = r100;
            return this;
        }

        public Builder ka_init_config(KaInitConfig r100) {
            this.ka_init_config = r100;
            return this;
        }

        public Builder local_timezone(String r100) {
            this.local_timezone = r100;
            return this;
        }

        public Builder locale_identifier(String r100) {
            this.locale_identifier = r100;
            return this;
        }

        public Builder log_setting(LogSetting r100) {
            this.log_setting = r100;
            return this;
        }

        public Builder main_thread_id(Long r100) {
            this.main_thread_id = r100;
            return this;
        }

        public Builder need_call_async(Boolean r100) {
            this.need_call_async = r100;
            return this;
        }

        public Builder need_settings(Boolean r100) {
            this.need_settings = r100;
            return this;
        }

        public Builder net_decorators(List<NetDecorator> r100) {
            Internal.checkElementsNotNull(r100);
            this.net_decorators = r100;
            return this;
        }

        public Builder net_semaphore_monitor_setting(NetSemaphoreMonitorSetting r100) {
            this.net_semaphore_monitor_setting = r100;
            return this;
        }

        public Builder network_settings(NetworkSetting r100) {
            this.network_settings = r100;
            return this;
        }

        public Builder old_storage_path(String r100) {
            this.old_storage_path = r100;
            return this;
        }

        public Builder os_version(String r100) {
            this.os_version = r100;
            return this;
        }

        public Builder package_id(PackageId r100) {
            this.package_id = r100;
            return this;
        }

        public Builder path_prefix(String r100) {
            this.path_prefix = r100;
            return this;
        }

        public Builder per_worker_spawn_threshold(Double r100) {
            this.per_worker_spawn_threshold = r100;
            return this;
        }

        public Builder power_level_under_background(PowerLevel r100) {
            this.power_level_under_background = r100;
            return this;
        }

        public Builder pre_rpc_persist_dyecp_fd_key(String r100) {
            this.pre_rpc_persist_dyecp_fd_key = r100;
            return this;
        }

        public Builder pre_rpc_persist_dyecp_fd_value(String r100) {
            this.pre_rpc_persist_dyecp_fd_value = r100;
            return this;
        }

        public Builder pre_rpc_persist_mock_tag_value(String r100) {
            this.pre_rpc_persist_mock_tag_value = r100;
            return this;
        }

        public Builder preload_config(PreloadConfig r100) {
            this.preload_config = r100;
            return this;
        }

        public Builder process_type(ProcessType r100) {
            this.process_type = r100;
            return this;
        }

        public Builder proxy_config(ProxyConfig r100) {
            this.proxy_config = r100;
            return this;
        }

        public Builder settings_queries(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.settings_queries = r100;
            return this;
        }

        public Builder storage_path(String r100) {
            this.storage_path = r100;
            return this;
        }

        public Builder stress_test_tag(String r100) {
            this.stress_test_tag = r100;
            return this;
        }

        public Builder sub_account_path(String r100) {
            this.sub_account_path = r100;
            return this;
        }

        public Builder sub_user_path(String r100) {
            this.sub_user_path = r100;
            return this;
        }

        public Builder tags(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder thread_pool_monitor_setting(ThreadPoolMonitorSetting r100) {
            this.thread_pool_monitor_setting = r100;
            return this;
        }

        public Builder thread_priority(Integer r100) {
            this.thread_priority = r100;
            return this;
        }

        public Builder use_deprecated_push_msg(Boolean r100) {
            this.use_deprecated_push_msg = r100;
            return this;
        }

        public Builder user_agent(String r100) {
            this.user_agent = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }

        public Builder wasm_init_config(String r100) {
            this.wasm_init_config = r100;
            return this;
        }

        public Builder worker_create_duration(Long r100) {
            this.worker_create_duration = r100;
            return this;
        }

        public Builder worker_release_duration(Long r100) {
            this.worker_release_duration = r100;
            return this;
        }

        public Builder x_tt_env(String r100) {
            this.x_tt_env = r100;
            return this;
        }
    }

    public static final class ClientABExperiment extends com.squareup.wire.Message<ClientABExperiment, Builder> {
        public static final ProtoAdapter<ClientABExperiment> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE_ALAUDALOG_DOWNGRADE = null;
        public static final Boolean DEFAULT_ENABLE_ALAUDALOG_UPLOAD_EXCEPTION = null;
        public static final Boolean DEFAULT_ENABLE_ALAUDALOG_UPLOAD_METRICS = null;
        public static final Boolean DEFAULT_ENABLE_DELAY_LOAD_MORE_FEEDS = null;
        private static final long serialVersionUID = 0;
        public final Boolean enable_alaudalog_downgrade;
        public final Boolean enable_alaudalog_upload_exception;
        public final Boolean enable_alaudalog_upload_metrics;
        public final Boolean enable_delay_load_more_feeds;

        public static final class Builder extends com.squareup.wire.Message.Builder<ClientABExperiment, Builder> {
            public Boolean enable_alaudalog_downgrade;
            public Boolean enable_alaudalog_upload_exception;
            public Boolean enable_alaudalog_upload_metrics;
            public Boolean enable_delay_load_more_feeds;

            @Override // com.squareup.wire.Message.Builder
            public ClientABExperiment build() {
                return new ClientABExperiment(this.enable_delay_load_more_feeds, this.enable_alaudalog_upload_exception, this.enable_alaudalog_upload_metrics, this.enable_alaudalog_downgrade, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder enable_alaudalog_downgrade(Boolean r100) {
                this.enable_alaudalog_downgrade = r100;
                return this;
            }

            public Builder enable_alaudalog_upload_exception(Boolean r100) {
                this.enable_alaudalog_upload_exception = r100;
                return this;
            }

            public Builder enable_alaudalog_upload_metrics(Boolean r100) {
                this.enable_alaudalog_upload_metrics = r100;
                return this;
            }

            public Builder enable_delay_load_more_feeds(Boolean r100) {
                this.enable_delay_load_more_feeds = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ClientABExperiment extends ProtoAdapter<ClientABExperiment> {
            public ProtoAdapter_ClientABExperiment() {
                super(FieldEncoding.LENGTH_DELIMITED, ClientABExperiment.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ClientABExperiment decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.enable_delay_load_more_feeds = r102;
                r101.enable_alaudalog_upload_exception = r102;
                r101.enable_alaudalog_upload_metrics = r102;
                r101.enable_alaudalog_downgrade = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.enable_delay_load_more_feeds = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.enable_alaudalog_upload_exception = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.enable_alaudalog_upload_metrics = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.enable_alaudalog_downgrade = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ClientABExperiment r100) {
                Boolean r101 = r100.enable_delay_load_more_feeds;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.enable_alaudalog_upload_exception;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.enable_alaudalog_upload_metrics;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.enable_alaudalog_downgrade;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ ClientABExperiment decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ClientABExperiment r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ClientABExperiment r101) throws IOException {
                Boolean r102 = r101.enable_delay_load_more_feeds;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.enable_alaudalog_upload_exception;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.enable_alaudalog_upload_metrics;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.enable_alaudalog_downgrade;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ClientABExperiment r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ClientABExperiment();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ENABLE_DELAY_LOAD_MORE_FEEDS = r100;
            DEFAULT_ENABLE_ALAUDALOG_UPLOAD_EXCEPTION = r100;
            DEFAULT_ENABLE_ALAUDALOG_UPLOAD_METRICS = r100;
            DEFAULT_ENABLE_ALAUDALOG_DOWNGRADE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.enable_delay_load_more_feeds = this.enable_delay_load_more_feeds;
            r100.enable_alaudalog_upload_exception = this.enable_alaudalog_upload_exception;
            r100.enable_alaudalog_upload_metrics = this.enable_alaudalog_upload_metrics;
            r100.enable_alaudalog_downgrade = this.enable_alaudalog_downgrade;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ClientABExperiment.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ClientABExperiment(Boolean r100, Boolean r101, Boolean r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ClientABExperiment(Boolean r100, Boolean r101, Boolean r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.enable_delay_load_more_feeds = r100;
            this.enable_alaudalog_upload_exception = r101;
            this.enable_alaudalog_upload_metrics = r102;
            this.enable_alaudalog_downgrade = r103;
        }
    }

    public static final enum DataSynchronismStrategy extends Enum<DataSynchronismStrategy> implements WireEnum {
        private static final /* synthetic */ DataSynchronismStrategy[] $VALUES = null;
        public static final ProtoAdapter<DataSynchronismStrategy> ADAPTER = null;
        public static final DataSynchronismStrategy BROADCAST = null;
        public static final DataSynchronismStrategy SUBSCRIBE = null;
        private final int value;

        static {
            DataSynchronismStrategy r100 = new DataSynchronismStrategy("BROADCAST", 0, 1);
            BROADCAST = r100;
            DataSynchronismStrategy r101 = new DataSynchronismStrategy("SUBSCRIBE", 1, 2);
            SUBSCRIBE = r101;
            $VALUES = new DataSynchronismStrategy[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataSynchronismStrategy.class);
        }

        public static DataSynchronismStrategy[] values() {
            return (DataSynchronismStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataSynchronismStrategy fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return SUBSCRIBE;
        L11:
            return BROADCAST;
        }

        public static DataSynchronismStrategy valueOf(String r100) {
            return (DataSynchronismStrategy) a.a(DataSynchronismStrategy.class, r100);
        }

        private DataSynchronismStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DeviceInfo extends com.squareup.wire.Message<DeviceInfo, Builder> {
        public static final ProtoAdapter<DeviceInfo> ADAPTER = null;
        public static final String DEFAULT_DEVICE_ID = "";
        public static final String DEFAULT_DEVICE_PLATFORM = "";
        public static final String DEFAULT_INSTALL_ID = "";
        private static final long serialVersionUID = 0;
        public final String device_id;
        public final String device_platform;
        public final String install_id;
        public final Map<String, String> settings_queries;

        public static final class Builder extends com.squareup.wire.Message.Builder<DeviceInfo, Builder> {
            public String device_id;
            public String device_platform;
            public String install_id;
            public Map<String, String> settings_queries;

            @Override // com.squareup.wire.Message.Builder
            public DeviceInfo build() {
                String r100 = this.device_id;
                if (r100 == null) goto L7;
                return new DeviceInfo(this.device_id, this.install_id, this.device_platform, this.settings_queries, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "device_id"});
            }

            public Builder() {
                this.settings_queries = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder device_id(String r100) {
                this.device_id = r100;
                return this;
            }

            public Builder device_platform(String r100) {
                this.device_platform = r100;
                return this;
            }

            public Builder install_id(String r100) {
                this.install_id = r100;
                return this;
            }

            public Builder settings_queries(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.settings_queries = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DeviceInfo extends ProtoAdapter<DeviceInfo> {
            private final ProtoAdapter<Map<String, String>> settings_queries;

            public ProtoAdapter_DeviceInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DeviceInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.settings_queries = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DeviceInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.device_id = "";
                r101.install_id = "";
                r101.device_platform = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.device_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.install_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.device_platform = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.settings_queries.putAll(this.settings_queries.decode(r100));
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
            public int encodedSize2(DeviceInfo r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.device_id);
                String r103 = r100.install_id;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.device_platform;
                if (r107 == null) goto L10;
                r104 = r101.encodedSizeWithTag(3, r107);
            L10:
                return ((r106 + r104) + this.settings_queries.encodedSizeWithTag(4, r100.settings_queries)) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DeviceInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DeviceInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DeviceInfo r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.device_id);
                String r103 = r101.install_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                String r104 = r101.device_platform;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 3, r104);
            L8:
                this.settings_queries.encodeWithTag(r100, 4, r101.settings_queries);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeviceInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DeviceInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.device_id = this.device_id;
            r100.install_id = this.install_id;
            r100.device_platform = this.device_platform;
            r100.settings_queries = Internal.copyOf("settings_queries", this.settings_queries);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DeviceInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DeviceInfo(String r100, String r101, String r102, Map<String, String> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public DeviceInfo(String r100, String r101, String r102, Map<String, String> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.device_id = r100;
            this.install_id = r101;
            this.device_platform = r102;
            this.settings_queries = Internal.immutableCopyOf("settings_queries", r103);
        }
    }

    public static final enum DevicePerfLevel extends Enum<DevicePerfLevel> implements WireEnum {
        private static final /* synthetic */ DevicePerfLevel[] $VALUES = null;
        public static final ProtoAdapter<DevicePerfLevel> ADAPTER = null;
        public static final DevicePerfLevel DEVICE_HIGH = null;
        public static final DevicePerfLevel DEVICE_LOW = null;
        public static final DevicePerfLevel DEVICE_MIDDLE = null;
        public static final DevicePerfLevel DEVICE_UNKNOWN = null;
        private final int value;

        static {
            DevicePerfLevel r100 = new DevicePerfLevel("DEVICE_UNKNOWN", 0, 0);
            DEVICE_UNKNOWN = r100;
            DevicePerfLevel r101 = new DevicePerfLevel("DEVICE_HIGH", 1, 1);
            DEVICE_HIGH = r101;
            DevicePerfLevel r102 = new DevicePerfLevel("DEVICE_MIDDLE", 2, 2);
            DEVICE_MIDDLE = r102;
            DevicePerfLevel r103 = new DevicePerfLevel("DEVICE_LOW", 3, 3);
            DEVICE_LOW = r103;
            $VALUES = new DevicePerfLevel[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(DevicePerfLevel.class);
        }

        public static DevicePerfLevel[] values() {
            return (DevicePerfLevel[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DevicePerfLevel fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DEVICE_LOW;
        L14:
            return DEVICE_MIDDLE;
        L16:
            return DEVICE_HIGH;
        L18:
            return DEVICE_UNKNOWN;
        }

        public static DevicePerfLevel valueOf(String r100) {
            return (DevicePerfLevel) a.a(DevicePerfLevel.class, r100);
        }

        private DevicePerfLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum EnvType extends Enum<EnvType> implements WireEnum {
        private static final /* synthetic */ EnvType[] $VALUES = null;
        public static final ProtoAdapter<EnvType> ADAPTER = null;
        public static final EnvType ONLINE = null;
        public static final EnvType OVERSEA = null;
        public static final EnvType OVERSEA_STAGING = null;
        public static final EnvType PRE_RELEASE = null;
        public static final EnvType STAGING = null;
        private final int value;

        static {
            EnvType r100 = new EnvType("ONLINE", 0, 1);
            ONLINE = r100;
            EnvType r101 = new EnvType("STAGING", 1, 2);
            STAGING = r101;
            EnvType r102 = new EnvType("PRE_RELEASE", 2, 3);
            PRE_RELEASE = r102;
            EnvType r103 = new EnvType("OVERSEA", 3, 4);
            OVERSEA = r103;
            EnvType r104 = new EnvType("OVERSEA_STAGING", 4, 5);
            OVERSEA_STAGING = r104;
            $VALUES = new EnvType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(EnvType.class);
        }

        public static EnvType[] values() {
            return (EnvType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EnvType fromValue(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 5) goto L15;
            return null;
        L15:
            return OVERSEA_STAGING;
        L17:
            return OVERSEA;
        L19:
            return PRE_RELEASE;
        L21:
            return STAGING;
        L23:
            return ONLINE;
        }

        public static EnvType valueOf(String r100) {
            return (EnvType) a.a(EnvType.class, r100);
        }

        private EnvType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class EnvV2 extends com.squareup.wire.Message<EnvV2, Builder> {
        public static final ProtoAdapter<EnvV2> ADAPTER = null;
        public static final String DEFAULT_BRAND = "";
        public static final String DEFAULT_GEO = "";
        public static final Type DEFAULT_TYPE = null;
        public static final String DEFAULT_UNIT = "";
        public static final FieldOptions FIELD_OPTIONS_BRAND = null;
        public static final FieldOptions FIELD_OPTIONS_GEO = null;
        public static final FieldOptions FIELD_OPTIONS_TYPE = null;
        public static final FieldOptions FIELD_OPTIONS_UNIT = null;
        private static final long serialVersionUID = 0;
        public final String brand;
        public final String geo;
        public final Type type;
        public final String unit;

        public static final class Builder extends com.squareup.wire.Message.Builder<EnvV2, Builder> {
            public String brand;
            public String geo;
            public Type type;
            public String unit;

            @Override // com.squareup.wire.Message.Builder
            public EnvV2 build() {
                return new EnvV2(this.type, this.unit, this.brand, this.geo, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder brand(String r100) {
                this.brand = r100;
                return this;
            }

            public Builder geo(String r100) {
                this.geo = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }

            public Builder unit(String r100) {
                this.unit = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EnvV2 extends ProtoAdapter<EnvV2> {
            public ProtoAdapter_EnvV2() {
                super(FieldEncoding.LENGTH_DELIMITED, EnvV2.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EnvV2 decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.RELEASE;
                r101.unit = "";
                r101.brand = "";
                r101.geo = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.brand = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.geo = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(EnvV2 r100) {
                Type r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.unit;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.brand;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.geo;
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
            public /* bridge */ /* synthetic */ EnvV2 decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EnvV2 r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EnvV2 r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.unit;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.brand;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.geo;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnvV2 r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type PRE_RELEASE = null;
            public static final Type RELEASE = null;
            public static final Type STAGING = null;
            private final int value;

            static {
                Type r100 = new Type("RELEASE", 0, 1);
                RELEASE = r100;
                Type r101 = new Type("STAGING", 1, 2);
                STAGING = r101;
                Type r102 = new Type("PRE_RELEASE", 2, 3);
                PRE_RELEASE = r102;
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
                return PRE_RELEASE;
            L13:
                return STAGING;
            L15:
                return RELEASE;
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
            ADAPTER = new ProtoAdapter_EnvV2();
            FIELD_OPTIONS_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_UNIT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_BRAND = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_GEO = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_TYPE = Type.RELEASE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.unit = this.unit;
            r100.brand = this.brand;
            r100.geo = this.geo;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EnvV2.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EnvV2(Type r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public EnvV2(Type r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.type = r100;
            this.unit = r101;
            this.brand = r102;
            this.geo = r103;
        }
    }

    public static final class FrontierConfig extends com.squareup.wire.Message<FrontierConfig, Builder> {
        public static final ProtoAdapter<FrontierConfig> ADAPTER = null;
        public static final String DEFAULT_AID = "";
        public static final String DEFAULT_APP_KEY = "";
        public static final String DEFAULT_FPID = "";
        public static final String DEFAULT_SERVICE_ID = "";
        private static final long serialVersionUID = 0;
        public final String aid;
        public final String app_key;
        public final String fpid;
        public final String service_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<FrontierConfig, Builder> {
            public String aid;
            public String app_key;
            public String fpid;
            public String service_id;

            @Override // com.squareup.wire.Message.Builder
            public FrontierConfig build() {
                return new FrontierConfig(this.fpid, this.service_id, this.aid, this.app_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder aid(String r100) {
                this.aid = r100;
                return this;
            }

            public Builder app_key(String r100) {
                this.app_key = r100;
                return this;
            }

            public Builder fpid(String r100) {
                this.fpid = r100;
                return this;
            }

            public Builder service_id(String r100) {
                this.service_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FrontierConfig extends ProtoAdapter<FrontierConfig> {
            public ProtoAdapter_FrontierConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, FrontierConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FrontierConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.fpid = "";
                r101.service_id = "";
                r101.aid = "";
                r101.app_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.fpid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.service_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.aid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.app_key = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(FrontierConfig r100) {
                String r101 = r100.fpid;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.service_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.aid;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.app_key;
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
            public /* bridge */ /* synthetic */ FrontierConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FrontierConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FrontierConfig r101) throws IOException {
                String r102 = r101.fpid;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.service_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.aid;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.app_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FrontierConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FrontierConfig();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.fpid = this.fpid;
            r100.service_id = this.service_id;
            r100.aid = this.aid;
            r100.app_key = this.app_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FrontierConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public FrontierConfig(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public FrontierConfig(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.fpid = r100;
            this.service_id = r101;
            this.aid = r102;
            this.app_key = r103;
        }
    }

    public static final class LogSetting extends com.squareup.wire.Message<LogSetting, Builder> {
        public static final ProtoAdapter<LogSetting> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_KEY_ID = "";
        private static final long serialVersionUID = 0;
        public final String key;
        public final String key_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<LogSetting, Builder> {
            public String key;
            public String key_id;

            @Override // com.squareup.wire.Message.Builder
            public LogSetting build() {
                return new LogSetting(this.key_id, this.key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder key_id(String r100) {
                this.key_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LogSetting extends ProtoAdapter<LogSetting> {
            public ProtoAdapter_LogSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, LogSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LogSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key_id = "";
                r101.key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.key_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.key = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(LogSetting r100) {
                String r101 = r100.key_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.key;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LogSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LogSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LogSetting r101) throws IOException {
                String r102 = r101.key_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LogSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LogSetting();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key_id = this.key_id;
            r100.key = this.key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LogSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LogSetting(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public LogSetting(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.key_id = r100;
            this.key = r101;
        }
    }

    public static final class NetSemaphoreMonitorSetting extends com.squareup.wire.Message<NetSemaphoreMonitorSetting, Builder> {
        public static final ProtoAdapter<NetSemaphoreMonitorSetting> ADAPTER = null;
        public static final Boolean DEFAULT_EVENT_MONITOR = null;
        public static final Integer DEFAULT_SEMAPHORE_COUNT = null;
        public static final Integer DEFAULT_WAITING_TIME_THRESHOLD = null;
        private static final long serialVersionUID = 0;
        public final Boolean event_monitor;
        public final Integer semaphore_count;
        public final Integer waiting_time_threshold;

        public static final class Builder extends com.squareup.wire.Message.Builder<NetSemaphoreMonitorSetting, Builder> {
            public Boolean event_monitor;
            public Integer semaphore_count;
            public Integer waiting_time_threshold;

            @Override // com.squareup.wire.Message.Builder
            public NetSemaphoreMonitorSetting build() {
                Boolean r100 = this.event_monitor;
                if (r100 == null) goto L11;
                if (this.semaphore_count == null) goto L11;
                if (this.waiting_time_threshold == null) goto L11;
                return new NetSemaphoreMonitorSetting(this.event_monitor, this.semaphore_count, this.waiting_time_threshold, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "event_monitor", this.semaphore_count, "semaphore_count", this.waiting_time_threshold, "waiting_time_threshold"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder event_monitor(Boolean r100) {
                this.event_monitor = r100;
                return this;
            }

            public Builder semaphore_count(Integer r100) {
                this.semaphore_count = r100;
                return this;
            }

            public Builder waiting_time_threshold(Integer r100) {
                this.waiting_time_threshold = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_NetSemaphoreMonitorSetting extends ProtoAdapter<NetSemaphoreMonitorSetting> {
            public ProtoAdapter_NetSemaphoreMonitorSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, NetSemaphoreMonitorSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NetSemaphoreMonitorSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.event_monitor = Boolean.FALSE;
                r101.semaphore_count = 0;
                r101.waiting_time_threshold = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.event_monitor = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.semaphore_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.waiting_time_threshold = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(NetSemaphoreMonitorSetting r100) {
                int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.event_monitor);
                ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
                return ((r101 + r102.encodedSizeWithTag(2, r100.semaphore_count)) + r102.encodedSizeWithTag(3, r100.waiting_time_threshold)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ NetSemaphoreMonitorSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(NetSemaphoreMonitorSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, NetSemaphoreMonitorSetting r101) throws IOException {
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.event_monitor);
                ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
                r102.encodeWithTag(r100, 2, r101.semaphore_count);
                r102.encodeWithTag(r100, 3, r101.waiting_time_threshold);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NetSemaphoreMonitorSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NetSemaphoreMonitorSetting();
            DEFAULT_EVENT_MONITOR = Boolean.FALSE;
            DEFAULT_SEMAPHORE_COUNT = 0;
            DEFAULT_WAITING_TIME_THRESHOLD = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.event_monitor = this.event_monitor;
            r100.semaphore_count = this.semaphore_count;
            r100.waiting_time_threshold = this.waiting_time_threshold;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return NetSemaphoreMonitorSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public NetSemaphoreMonitorSetting(Boolean r100, Integer r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public NetSemaphoreMonitorSetting(Boolean r100, Integer r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.event_monitor = r100;
            this.semaphore_count = r101;
            this.waiting_time_threshold = r102;
        }
    }

    public static final enum PackageId extends Enum<PackageId> implements WireEnum {
        private static final /* synthetic */ PackageId[] $VALUES = null;
        public static final ProtoAdapter<PackageId> ADAPTER = null;
        public static final PackageId FEISHU = null;
        public static final PackageId LARK = null;
        private final int value;

        static {
            PackageId r100 = new PackageId(AccountType.LARK, 0, 1);
            LARK = r100;
            PackageId r101 = new PackageId("FEISHU", 1, 2);
            FEISHU = r101;
            $VALUES = new PackageId[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(PackageId.class);
        }

        public static PackageId[] values() {
            return (PackageId[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PackageId fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return FEISHU;
        L11:
            return LARK;
        }

        public static PackageId valueOf(String r100) {
            return (PackageId) a.a(PackageId.class, r100);
        }

        private PackageId(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PowerLevel extends Enum<PowerLevel> implements WireEnum {
        private static final /* synthetic */ PowerLevel[] $VALUES = null;
        public static final ProtoAdapter<PowerLevel> ADAPTER = null;
        public static final PowerLevel High = null;
        public static final PowerLevel Low = null;
        public static final PowerLevel Medium = null;
        public static final PowerLevel Stop = null;
        private final int value;

        static {
            PowerLevel r100 = new PowerLevel("Stop", 0, 1);
            Stop = r100;
            PowerLevel r101 = new PowerLevel("Low", 1, 2);
            Low = r101;
            PowerLevel r102 = new PowerLevel("Medium", 2, 3);
            Medium = r102;
            PowerLevel r103 = new PowerLevel("High", 3, 4);
            High = r103;
            $VALUES = new PowerLevel[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(PowerLevel.class);
        }

        public static PowerLevel[] values() {
            return (PowerLevel[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PowerLevel fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return High;
        L15:
            return Medium;
        L17:
            return Low;
        L19:
            return Stop;
        }

        public static PowerLevel valueOf(String r100) {
            return (PowerLevel) a.a(PowerLevel.class, r100);
        }

        private PowerLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class PreloadConfig extends com.squareup.wire.Message<PreloadConfig, Builder> {
        public static final ProtoAdapter<PreloadConfig> ADAPTER = null;
        public static final Integer DEFAULT_PRELOAD_CHAT_CHATTER_COUNT = null;
        private static final long serialVersionUID = 0;
        public final Integer preload_chat_chatter_count;

        public static final class Builder extends com.squareup.wire.Message.Builder<PreloadConfig, Builder> {
            public Integer preload_chat_chatter_count;

            @Override // com.squareup.wire.Message.Builder
            public PreloadConfig build() {
                return new PreloadConfig(this.preload_chat_chatter_count, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder preload_chat_chatter_count(Integer r100) {
                this.preload_chat_chatter_count = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PreloadConfig extends ProtoAdapter<PreloadConfig> {
            public ProtoAdapter_PreloadConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, PreloadConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PreloadConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.preload_chat_chatter_count = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.preload_chat_chatter_count = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(PreloadConfig r100) {
                Integer r101 = r100.preload_chat_chatter_count;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PreloadConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PreloadConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PreloadConfig r101) throws IOException {
                Integer r102 = r101.preload_chat_chatter_count;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreloadConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PreloadConfig();
            DEFAULT_PRELOAD_CHAT_CHATTER_COUNT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.preload_chat_chatter_count = this.preload_chat_chatter_count;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PreloadConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PreloadConfig(Integer r100) {
            this(r100, ByteString.EMPTY);
        }

        public PreloadConfig(Integer r100, ByteString r101) {
            super(ADAPTER, r101);
            this.preload_chat_chatter_count = r100;
        }
    }

    public static final enum ProcessType extends Enum<ProcessType> implements WireEnum {
        private static final /* synthetic */ ProcessType[] $VALUES = null;
        public static final ProtoAdapter<ProcessType> ADAPTER = null;
        public static final ProcessType CHILD = null;
        public static final ProcessType FRONTIER = null;
        public static final ProcessType MAIN = null;
        public static final ProcessType NETWORK = null;
        private final int value;

        static {
            ProcessType r100 = new ProcessType(AccountType.MAIN, 0, 1);
            MAIN = r100;
            ProcessType r101 = new ProcessType("CHILD", 1, 2);
            CHILD = r101;
            ProcessType r102 = new ProcessType("NETWORK", 2, 3);
            NETWORK = r102;
            ProcessType r103 = new ProcessType("FRONTIER", 3, 4);
            FRONTIER = r103;
            $VALUES = new ProcessType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ProcessType.class);
        }

        public static ProcessType[] values() {
            return (ProcessType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ProcessType fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return FRONTIER;
        L15:
            return NETWORK;
        L17:
            return CHILD;
        L19:
            return MAIN;
        }

        public static ProcessType valueOf(String r100) {
            return (ProcessType) a.a(ProcessType.class, r100);
        }

        private ProcessType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_InitSDKRequest extends ProtoAdapter<InitSDKRequest> {
        private final ProtoAdapter<Map<String, String>> customized_init_meta;
        private final ProtoAdapter<Map<String, String>> settings_queries;

        public ProtoAdapter_InitSDKRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, InitSDKRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.settings_queries = ProtoAdapter.newMapAdapter(r100, r100);
            this.customized_init_meta = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InitSDKRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.storage_path = "";
            r101.env = EnvType.ONLINE;
            r101.version = "";
            r101.user_agent = "";
            r101.process_type = ProcessType.MAIN;
            r101.user_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.need_call_async = r102;
            r101.app_id = InitSDKRequest.DEFAULT_APP_ID;
            r101.locale_identifier = "zh_CN";
            r101.client_log_storage_path = "";
            r101.path_prefix = "";
            r101.sub_account_path = "";
            r101.sub_user_path = "";
            r101.old_storage_path = "";
            r101.custom_log_path = "";
            r101.data_synchronism_strategy = DataSynchronismStrategy.BROADCAST;
            r101.enable_thread = r102;
            r101.is_wrap_async_callback_data_with_packet = r102;
            r101.enable_thread_subscription = r102;
            r101.use_deprecated_push_msg = Boolean.TRUE;
            r101.power_level_under_background = PowerLevel.Low;
            r101.package_id = PackageId.LARK;
            r101.main_thread_id = 0L;
            r101.need_settings = r102;
            r101.boe_tt_feature_env = "";
            r101.local_timezone = "";
            r101.init_config_path = "";
            r101.basic_mode = r102;
            r101.stress_test_tag = "";
            r101.wasm_init_config = "";
            r101.is_release = r102;
            r101.pre_rpc_persist_dyecp_fd_key = "";
            r101.pre_rpc_persist_dyecp_fd_value = "";
            r101.pre_rpc_persist_mock_tag_value = "";
            r101.os_version = "";
            r101.is_anydoor_enable = r102;
            r101.device_model = "";
            r101.x_tt_env = "";
            r101.app_channel = "";
            r101.worker_create_duration = 0L;
            r101.per_worker_spawn_threshold = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.thread_priority = 0;
            r101.expected_thread = 0;
            r101.epoch_step_count = 0;
            r101.worker_release_duration = 0L;
            r101.device_perf_level = DevicePerfLevel.DEVICE_UNKNOWN;
            r101.enable_new_ttnet_log_reporter = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L95;
            if (r104 != 20) goto L7;
            r101.data_synchronism_strategy = DataSynchronismStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L93
        L93:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            switch(r104) {
                case 1: goto L90;
                case 2: goto L97;
                case 3: goto L85;
                case 4: goto L84;
                case 5: goto L103;
                case 6: goto L79;
                case 7: goto L78;
                case 8: goto L77;
                case 9: goto L76;
                case 10: goto L75;
                case 11: goto L74;
                case 12: goto L73;
                case 13: goto L72;
                case 14: goto L71;
                case 15: goto L70;
                case 16: goto L69;
                case 17: goto L68;
                case 18: goto L67;
                default: goto L8;
            };
        L97:
            r101.env = EnvType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L88
        L88:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L103:
            r101.process_type = ProcessType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L82
        L82:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L67:
            r101.device_info = DeviceInfo.ADAPTER.decode(r100);
            goto L3
        L68:
            r101.client_stability_log_dirs.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L69:
            r101.init_log_upload = InitLogUpload.ADAPTER.decode(r100);
            goto L3
        L70:
            r101.custom_log_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L71:
            r101.old_storage_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L72:
            r101.sub_user_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L73:
            r101.sub_account_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L74:
            r101.path_prefix = ProtoAdapter.STRING.decode(r100);
            goto L3
        L75:
            r101.client_log_storage_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L76:
            r101.locale_identifier = ProtoAdapter.STRING.decode(r100);
            goto L3
        L77:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L78:
            r101.need_call_async = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L79:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L84:
            r101.user_agent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L85:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L90:
            r101.storage_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            switch(r104) {
                case 40: goto L66;
                case 41: goto L65;
                case 42: goto L64;
                case 43: goto L63;
                case 44: goto L62;
                case 45: goto L101;
                case 46: goto L105;
                case 47: goto L53;
                case 48: goto L52;
                case 49: goto L51;
                case 50: goto L50;
                case 51: goto L49;
                case 52: goto L48;
                case 53: goto L47;
                case 54: goto L46;
                case 55: goto L45;
                case 56: goto L44;
                case 57: goto L43;
                case 58: goto L42;
                case 59: goto L41;
                case 60: goto L40;
                case 61: goto L39;
                case 62: goto L38;
                case 63: goto L37;
                case 64: goto L36;
                case 65: goto L35;
                case 66: goto L34;
                case 67: goto L33;
                case 68: goto L32;
                case 69: goto L31;
                case 70: goto L30;
                case 71: goto L29;
                case 72: goto L28;
                case 73: goto L27;
                case 74: goto L26;
                case 75: goto L25;
                case 76: goto L24;
                case 77: goto L23;
                case 78: goto L22;
                case 79: goto L107;
                case 80: goto L17;
                case 81: goto L16;
                case 82: goto L15;
                case 83: goto L14;
                case 84: goto L13;
                case 85: goto L12;
                case 86: goto L11;
                case 87: goto L10;
                default: goto L9;
            };
        L101:
            r101.power_level_under_background = PowerLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L60
        L60:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L105:
            r101.package_id = PackageId.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L56
        L56:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L107:
            r101.device_perf_level = DevicePerfLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            r101.enable_new_ttnet_log_reporter = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.net_decorators.add(NetDecorator.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.customized_init_meta.putAll(this.customized_init_meta.decode(r100));
            goto L3
        L13:
            r101.thread_pool_monitor_setting = ThreadPoolMonitorSetting.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.net_semaphore_monitor_setting = NetSemaphoreMonitorSetting.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.network_settings = NetworkSetting.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.log_setting = LogSetting.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.client_ab_experiment = ClientABExperiment.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.worker_release_duration = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L23:
            r101.tags.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L24:
            r101.epoch_step_count = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L25:
            r101.expected_thread = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L26:
            r101.thread_priority = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L27:
            r101.per_worker_spawn_threshold = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L28:
            r101.worker_create_duration = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L29:
            r101.proxy_config = ProxyConfig.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.app_channel = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.settings_queries.putAll(this.settings_queries.decode(r100));
            goto L3
        L32:
            r101.x_tt_env = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.device_model = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.is_anydoor_enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.os_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.pre_rpc_persist_mock_tag_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.pre_rpc_persist_dyecp_fd_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.pre_rpc_persist_dyecp_fd_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.is_release = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L40:
            r101.wasm_init_config = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.stress_test_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.basic_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L43:
            r101.init_config_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L44:
            r101.local_timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.boe_rpc_persist_dyecp_fd = BoeRpcPersistDyecpFd.ADAPTER.decode(r100);
            goto L3
        L46:
            r101.boe_tt_feature_env = ProtoAdapter.STRING.decode(r100);
            goto L3
        L47:
            r101.client_cert = NetworkClientCertificate.ADAPTER.decode(r100);
            goto L3
        L48:
            r101.need_settings = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L49:
            r101.main_thread_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L50:
            r101.env_v2 = EnvV2.ADAPTER.decode(r100);
            goto L3
        L51:
            r101.frontier_config = FrontierConfig.ADAPTER.decode(r100);
            goto L3
        L52:
            r101.ka_init_config = KaInitConfig.ADAPTER.decode(r100);
            goto L3
        L53:
            r101.deprecated_config = DeprecatedConfig.ADAPTER.decode(r100);
            goto L3
        L62:
            r101.preload_config = PreloadConfig.ADAPTER.decode(r100);
            goto L3
        L63:
            r101.use_deprecated_push_msg = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L64:
            r101.enable_thread_subscription = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L65:
            r101.is_wrap_async_callback_data_with_packet = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L66:
            r101.enable_thread = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L95:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InitSDKRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.storage_path);
            EnvType r103 = r100.env;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = EnvType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = ((r102 + r105) + r101.encodedSizeWithTag(3, r100.version)) + r101.encodedSizeWithTag(4, r100.user_agent);
            ProcessType r107 = r100.process_type;
            if (r107 == null) goto L9;
            int r108 = ProcessType.ADAPTER.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.user_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.need_call_async;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.app_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.locale_identifier;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.client_log_storage_path;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(10, r122);
        L30:
            int r124 = (r121 + r123) + r101.asRepeated().encodedSizeWithTag(17, r100.client_stability_log_dirs);
            String r125 = r100.path_prefix;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.sub_account_path;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.sub_user_path;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(13, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.old_storage_path;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(14, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.custom_log_path;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(15, r137);
        L50:
            int r139 = r136 + r138;
            InitLogUpload r140 = r100.init_log_upload;
            if (r140 == null) goto L53;
            int r141 = InitLogUpload.ADAPTER.encodedSizeWithTag(16, r140);
        L54:
            int r142 = r139 + r141;
            DeviceInfo r143 = r100.device_info;
            if (r143 == null) goto L57;
            int r144 = DeviceInfo.ADAPTER.encodedSizeWithTag(18, r143);
        L58:
            int r145 = r142 + r144;
            DataSynchronismStrategy r146 = r100.data_synchronism_strategy;
            if (r146 == null) goto L61;
            int r147 = DataSynchronismStrategy.ADAPTER.encodedSizeWithTag(20, r146);
        L62:
            int r148 = r145 + r147;
            Boolean r149 = r100.enable_thread;
            if (r149 == null) goto L65;
            int r150 = ProtoAdapter.BOOL.encodedSizeWithTag(40, r149);
        L66:
            int r151 = r148 + r150;
            Boolean r152 = r100.is_wrap_async_callback_data_with_packet;
            if (r152 == null) goto L69;
            int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r152);
        L70:
            int r154 = r151 + r153;
            Boolean r155 = r100.enable_thread_subscription;
            if (r155 == null) goto L73;
            int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(42, r155);
        L74:
            int r157 = r154 + r156;
            Boolean r158 = r100.use_deprecated_push_msg;
            if (r158 == null) goto L77;
            int r159 = ProtoAdapter.BOOL.encodedSizeWithTag(43, r158);
        L78:
            int r160 = r157 + r159;
            PreloadConfig r161 = r100.preload_config;
            if (r161 == null) goto L81;
            int r162 = PreloadConfig.ADAPTER.encodedSizeWithTag(44, r161);
        L82:
            int r163 = r160 + r162;
            PowerLevel r164 = r100.power_level_under_background;
            if (r164 == null) goto L85;
            int r165 = PowerLevel.ADAPTER.encodedSizeWithTag(45, r164);
        L86:
            int r166 = r163 + r165;
            PackageId r167 = r100.package_id;
            if (r167 == null) goto L89;
            int r168 = PackageId.ADAPTER.encodedSizeWithTag(46, r167);
        L90:
            int r169 = r166 + r168;
            DeprecatedConfig r170 = r100.deprecated_config;
            if (r170 == null) goto L93;
            int r171 = DeprecatedConfig.ADAPTER.encodedSizeWithTag(47, r170);
        L94:
            int r172 = r169 + r171;
            KaInitConfig r173 = r100.ka_init_config;
            if (r173 == null) goto L97;
            int r174 = KaInitConfig.ADAPTER.encodedSizeWithTag(48, r173);
        L98:
            int r175 = r172 + r174;
            FrontierConfig r176 = r100.frontier_config;
            if (r176 == null) goto L101;
            int r177 = FrontierConfig.ADAPTER.encodedSizeWithTag(49, r176);
        L102:
            int r178 = r175 + r177;
            EnvV2 r179 = r100.env_v2;
            if (r179 == null) goto L105;
            int r180 = EnvV2.ADAPTER.encodedSizeWithTag(50, r179);
        L106:
            int r181 = r178 + r180;
            Long r182 = r100.main_thread_id;
            if (r182 == null) goto L109;
            int r183 = ProtoAdapter.INT64.encodedSizeWithTag(51, r182);
        L110:
            int r184 = r181 + r183;
            Boolean r185 = r100.need_settings;
            if (r185 == null) goto L113;
            int r186 = ProtoAdapter.BOOL.encodedSizeWithTag(52, r185);
        L114:
            int r187 = r184 + r186;
            NetworkClientCertificate r188 = r100.client_cert;
            if (r188 == null) goto L117;
            int r189 = NetworkClientCertificate.ADAPTER.encodedSizeWithTag(53, r188);
        L118:
            int r190 = r187 + r189;
            String r191 = r100.boe_tt_feature_env;
            if (r191 == null) goto L121;
            int r192 = r101.encodedSizeWithTag(54, r191);
        L122:
            int r193 = r190 + r192;
            BoeRpcPersistDyecpFd r194 = r100.boe_rpc_persist_dyecp_fd;
            if (r194 == null) goto L125;
            int r195 = BoeRpcPersistDyecpFd.ADAPTER.encodedSizeWithTag(55, r194);
        L126:
            int r196 = r193 + r195;
            String r197 = r100.local_timezone;
            if (r197 == null) goto L129;
            int r198 = r101.encodedSizeWithTag(56, r197);
        L130:
            int r199 = (r196 + r198) + r101.encodedSizeWithTag(57, r100.init_config_path);
            Boolean r200 = r100.basic_mode;
            if (r200 == null) goto L133;
            int r201 = ProtoAdapter.BOOL.encodedSizeWithTag(58, r200);
        L134:
            int r202 = r199 + r201;
            String r203 = r100.stress_test_tag;
            if (r203 == null) goto L137;
            int r204 = r101.encodedSizeWithTag(59, r203);
        L138:
            int r205 = r202 + r204;
            String r206 = r100.wasm_init_config;
            if (r206 == null) goto L141;
            int r207 = r101.encodedSizeWithTag(60, r206);
        L142:
            int r208 = r205 + r207;
            Boolean r209 = r100.is_release;
            if (r209 == null) goto L145;
            int r210 = ProtoAdapter.BOOL.encodedSizeWithTag(61, r209);
        L146:
            int r211 = r208 + r210;
            String r212 = r100.pre_rpc_persist_dyecp_fd_key;
            if (r212 == null) goto L149;
            int r213 = r101.encodedSizeWithTag(62, r212);
        L150:
            int r214 = r211 + r213;
            String r215 = r100.pre_rpc_persist_dyecp_fd_value;
            if (r215 == null) goto L153;
            int r216 = r101.encodedSizeWithTag(63, r215);
        L154:
            int r217 = r214 + r216;
            String r218 = r100.pre_rpc_persist_mock_tag_value;
            if (r218 == null) goto L157;
            int r219 = r101.encodedSizeWithTag(64, r218);
        L158:
            int r220 = r217 + r219;
            String r221 = r100.os_version;
            if (r221 == null) goto L161;
            int r222 = r101.encodedSizeWithTag(65, r221);
        L162:
            int r223 = r220 + r222;
            Boolean r224 = r100.is_anydoor_enable;
            if (r224 == null) goto L165;
            int r225 = ProtoAdapter.BOOL.encodedSizeWithTag(66, r224);
        L166:
            int r226 = r223 + r225;
            String r227 = r100.device_model;
            if (r227 == null) goto L169;
            int r228 = r101.encodedSizeWithTag(67, r227);
        L170:
            int r229 = r226 + r228;
            String r230 = r100.x_tt_env;
            if (r230 == null) goto L173;
            int r231 = r101.encodedSizeWithTag(68, r230);
        L174:
            int r232 = (r229 + r231) + this.settings_queries.encodedSizeWithTag(69, r100.settings_queries);
            String r233 = r100.app_channel;
            if (r233 == null) goto L177;
            int r234 = r101.encodedSizeWithTag(70, r233);
        L178:
            int r235 = r232 + r234;
            ProxyConfig r236 = r100.proxy_config;
            if (r236 == null) goto L181;
            int r237 = ProxyConfig.ADAPTER.encodedSizeWithTag(71, r236);
        L182:
            int r238 = r235 + r237;
            Long r239 = r100.worker_create_duration;
            if (r239 == null) goto L185;
            int r240 = ProtoAdapter.UINT64.encodedSizeWithTag(72, r239);
        L186:
            int r241 = r238 + r240;
            Double r242 = r100.per_worker_spawn_threshold;
            if (r242 == null) goto L189;
            int r243 = ProtoAdapter.DOUBLE.encodedSizeWithTag(73, r242);
        L190:
            int r244 = r241 + r243;
            Integer r245 = r100.thread_priority;
            if (r245 == null) goto L193;
            int r246 = ProtoAdapter.UINT32.encodedSizeWithTag(74, r245);
        L194:
            int r247 = r244 + r246;
            Integer r248 = r100.expected_thread;
            if (r248 == null) goto L197;
            int r249 = ProtoAdapter.UINT32.encodedSizeWithTag(75, r248);
        L198:
            int r250 = r247 + r249;
            Integer r251 = r100.epoch_step_count;
            if (r251 == null) goto L201;
            int r252 = ProtoAdapter.UINT32.encodedSizeWithTag(76, r251);
        L202:
            int r253 = (r250 + r252) + r101.asRepeated().encodedSizeWithTag(77, r100.tags);
            Long r254 = r100.worker_release_duration;
            if (r254 == null) goto L205;
            int r255 = ProtoAdapter.UINT64.encodedSizeWithTag(78, r254);
        L206:
            int r256 = r253 + r255;
            DevicePerfLevel r257 = r100.device_perf_level;
            if (r257 == null) goto L209;
            int r258 = DevicePerfLevel.ADAPTER.encodedSizeWithTag(79, r257);
        L210:
            int r259 = r256 + r258;
            ClientABExperiment r260 = r100.client_ab_experiment;
            if (r260 == null) goto L213;
            int r261 = ClientABExperiment.ADAPTER.encodedSizeWithTag(80, r260);
        L214:
            int r262 = r259 + r261;
            LogSetting r263 = r100.log_setting;
            if (r263 == null) goto L217;
            int r264 = LogSetting.ADAPTER.encodedSizeWithTag(81, r263);
        L218:
            int r265 = r262 + r264;
            NetworkSetting r266 = r100.network_settings;
            if (r266 == null) goto L221;
            int r267 = NetworkSetting.ADAPTER.encodedSizeWithTag(82, r266);
        L222:
            int r268 = r265 + r267;
            NetSemaphoreMonitorSetting r269 = r100.net_semaphore_monitor_setting;
            if (r269 == null) goto L225;
            int r270 = NetSemaphoreMonitorSetting.ADAPTER.encodedSizeWithTag(83, r269);
        L226:
            int r271 = r268 + r270;
            ThreadPoolMonitorSetting r272 = r100.thread_pool_monitor_setting;
            if (r272 == null) goto L229;
            int r273 = ThreadPoolMonitorSetting.ADAPTER.encodedSizeWithTag(84, r272);
        L230:
            int r274 = ((r271 + r273) + this.customized_init_meta.encodedSizeWithTag(85, r100.customized_init_meta)) + NetDecorator.ADAPTER.asRepeated().encodedSizeWithTag(86, r100.net_decorators);
            Boolean r275 = r100.enable_new_ttnet_log_reporter;
            if (r275 == null) goto L234;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(87, r275);
        L234:
            return (r274 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ InitSDKRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InitSDKRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InitSDKRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.storage_path);
            EnvType r103 = r101.env;
            if (r103 == null) goto L5;
            EnvType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            r102.encodeWithTag(r100, 3, r101.version);
            r102.encodeWithTag(r100, 4, r101.user_agent);
            ProcessType r104 = r101.process_type;
            if (r104 == null) goto L8;
            ProcessType.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.user_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Boolean r106 = r101.need_call_async;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.app_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            String r108 = r101.locale_identifier;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 9, r108);
        L20:
            String r109 = r101.client_log_storage_path;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 10, r109);
        L23:
            r102.asRepeated().encodeWithTag(r100, 17, r101.client_stability_log_dirs);
            String r110 = r101.path_prefix;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 11, r110);
        L26:
            String r111 = r101.sub_account_path;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 12, r111);
        L29:
            String r112 = r101.sub_user_path;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 13, r112);
        L32:
            String r113 = r101.old_storage_path;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 14, r113);
        L35:
            String r114 = r101.custom_log_path;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 15, r114);
        L38:
            InitLogUpload r115 = r101.init_log_upload;
            if (r115 == null) goto L41;
            InitLogUpload.ADAPTER.encodeWithTag(r100, 16, r115);
        L41:
            DeviceInfo r116 = r101.device_info;
            if (r116 == null) goto L44;
            DeviceInfo.ADAPTER.encodeWithTag(r100, 18, r116);
        L44:
            DataSynchronismStrategy r117 = r101.data_synchronism_strategy;
            if (r117 == null) goto L47;
            DataSynchronismStrategy.ADAPTER.encodeWithTag(r100, 20, r117);
        L47:
            Boolean r118 = r101.enable_thread;
            if (r118 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 40, r118);
        L50:
            Boolean r119 = r101.is_wrap_async_callback_data_with_packet;
            if (r119 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 41, r119);
        L53:
            Boolean r120 = r101.enable_thread_subscription;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 42, r120);
        L56:
            Boolean r121 = r101.use_deprecated_push_msg;
            if (r121 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 43, r121);
        L59:
            PreloadConfig r122 = r101.preload_config;
            if (r122 == null) goto L62;
            PreloadConfig.ADAPTER.encodeWithTag(r100, 44, r122);
        L62:
            PowerLevel r123 = r101.power_level_under_background;
            if (r123 == null) goto L65;
            PowerLevel.ADAPTER.encodeWithTag(r100, 45, r123);
        L65:
            PackageId r124 = r101.package_id;
            if (r124 == null) goto L68;
            PackageId.ADAPTER.encodeWithTag(r100, 46, r124);
        L68:
            DeprecatedConfig r125 = r101.deprecated_config;
            if (r125 == null) goto L71;
            DeprecatedConfig.ADAPTER.encodeWithTag(r100, 47, r125);
        L71:
            KaInitConfig r126 = r101.ka_init_config;
            if (r126 == null) goto L74;
            KaInitConfig.ADAPTER.encodeWithTag(r100, 48, r126);
        L74:
            FrontierConfig r127 = r101.frontier_config;
            if (r127 == null) goto L77;
            FrontierConfig.ADAPTER.encodeWithTag(r100, 49, r127);
        L77:
            EnvV2 r128 = r101.env_v2;
            if (r128 == null) goto L80;
            EnvV2.ADAPTER.encodeWithTag(r100, 50, r128);
        L80:
            Long r129 = r101.main_thread_id;
            if (r129 == null) goto L83;
            ProtoAdapter.INT64.encodeWithTag(r100, 51, r129);
        L83:
            Boolean r130 = r101.need_settings;
            if (r130 == null) goto L86;
            ProtoAdapter.BOOL.encodeWithTag(r100, 52, r130);
        L86:
            NetworkClientCertificate r131 = r101.client_cert;
            if (r131 == null) goto L89;
            NetworkClientCertificate.ADAPTER.encodeWithTag(r100, 53, r131);
        L89:
            String r132 = r101.boe_tt_feature_env;
            if (r132 == null) goto L92;
            r102.encodeWithTag(r100, 54, r132);
        L92:
            BoeRpcPersistDyecpFd r133 = r101.boe_rpc_persist_dyecp_fd;
            if (r133 == null) goto L95;
            BoeRpcPersistDyecpFd.ADAPTER.encodeWithTag(r100, 55, r133);
        L95:
            String r134 = r101.local_timezone;
            if (r134 == null) goto L98;
            r102.encodeWithTag(r100, 56, r134);
        L98:
            r102.encodeWithTag(r100, 57, r101.init_config_path);
            Boolean r135 = r101.basic_mode;
            if (r135 == null) goto L101;
            ProtoAdapter.BOOL.encodeWithTag(r100, 58, r135);
        L101:
            String r136 = r101.stress_test_tag;
            if (r136 == null) goto L104;
            r102.encodeWithTag(r100, 59, r136);
        L104:
            String r137 = r101.wasm_init_config;
            if (r137 == null) goto L107;
            r102.encodeWithTag(r100, 60, r137);
        L107:
            Boolean r138 = r101.is_release;
            if (r138 == null) goto L110;
            ProtoAdapter.BOOL.encodeWithTag(r100, 61, r138);
        L110:
            String r139 = r101.pre_rpc_persist_dyecp_fd_key;
            if (r139 == null) goto L113;
            r102.encodeWithTag(r100, 62, r139);
        L113:
            String r140 = r101.pre_rpc_persist_dyecp_fd_value;
            if (r140 == null) goto L116;
            r102.encodeWithTag(r100, 63, r140);
        L116:
            String r141 = r101.pre_rpc_persist_mock_tag_value;
            if (r141 == null) goto L119;
            r102.encodeWithTag(r100, 64, r141);
        L119:
            String r142 = r101.os_version;
            if (r142 == null) goto L122;
            r102.encodeWithTag(r100, 65, r142);
        L122:
            Boolean r143 = r101.is_anydoor_enable;
            if (r143 == null) goto L125;
            ProtoAdapter.BOOL.encodeWithTag(r100, 66, r143);
        L125:
            String r144 = r101.device_model;
            if (r144 == null) goto L128;
            r102.encodeWithTag(r100, 67, r144);
        L128:
            String r145 = r101.x_tt_env;
            if (r145 == null) goto L131;
            r102.encodeWithTag(r100, 68, r145);
        L131:
            this.settings_queries.encodeWithTag(r100, 69, r101.settings_queries);
            String r146 = r101.app_channel;
            if (r146 == null) goto L134;
            r102.encodeWithTag(r100, 70, r146);
        L134:
            ProxyConfig r147 = r101.proxy_config;
            if (r147 == null) goto L137;
            ProxyConfig.ADAPTER.encodeWithTag(r100, 71, r147);
        L137:
            Long r148 = r101.worker_create_duration;
            if (r148 == null) goto L140;
            ProtoAdapter.UINT64.encodeWithTag(r100, 72, r148);
        L140:
            Double r149 = r101.per_worker_spawn_threshold;
            if (r149 == null) goto L143;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 73, r149);
        L143:
            Integer r150 = r101.thread_priority;
            if (r150 == null) goto L146;
            ProtoAdapter.UINT32.encodeWithTag(r100, 74, r150);
        L146:
            Integer r151 = r101.expected_thread;
            if (r151 == null) goto L149;
            ProtoAdapter.UINT32.encodeWithTag(r100, 75, r151);
        L149:
            Integer r152 = r101.epoch_step_count;
            if (r152 == null) goto L152;
            ProtoAdapter.UINT32.encodeWithTag(r100, 76, r152);
        L152:
            r102.asRepeated().encodeWithTag(r100, 77, r101.tags);
            Long r153 = r101.worker_release_duration;
            if (r153 == null) goto L155;
            ProtoAdapter.UINT64.encodeWithTag(r100, 78, r153);
        L155:
            DevicePerfLevel r154 = r101.device_perf_level;
            if (r154 == null) goto L158;
            DevicePerfLevel.ADAPTER.encodeWithTag(r100, 79, r154);
        L158:
            ClientABExperiment r155 = r101.client_ab_experiment;
            if (r155 == null) goto L161;
            ClientABExperiment.ADAPTER.encodeWithTag(r100, 80, r155);
        L161:
            LogSetting r156 = r101.log_setting;
            if (r156 == null) goto L164;
            LogSetting.ADAPTER.encodeWithTag(r100, 81, r156);
        L164:
            NetworkSetting r157 = r101.network_settings;
            if (r157 == null) goto L167;
            NetworkSetting.ADAPTER.encodeWithTag(r100, 82, r157);
        L167:
            NetSemaphoreMonitorSetting r158 = r101.net_semaphore_monitor_setting;
            if (r158 == null) goto L170;
            NetSemaphoreMonitorSetting.ADAPTER.encodeWithTag(r100, 83, r158);
        L170:
            ThreadPoolMonitorSetting r159 = r101.thread_pool_monitor_setting;
            if (r159 == null) goto L173;
            ThreadPoolMonitorSetting.ADAPTER.encodeWithTag(r100, 84, r159);
        L173:
            this.customized_init_meta.encodeWithTag(r100, 85, r101.customized_init_meta);
            NetDecorator.ADAPTER.asRepeated().encodeWithTag(r100, 86, r101.net_decorators);
            Boolean r160 = r101.enable_new_ttnet_log_reporter;
            if (r160 == null) goto L176;
            ProtoAdapter.BOOL.encodeWithTag(r100, 87, r160);
        L176:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InitSDKRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ThreadPoolMonitorSetting extends com.squareup.wire.Message<ThreadPoolMonitorSetting, Builder> {
        public static final ProtoAdapter<ThreadPoolMonitorSetting> ADAPTER = null;
        public static final Boolean DEFAULT_EVENT_MONITOR = null;
        public static final Integer DEFAULT_WAITING_TIME_THRESHOLD = null;
        private static final long serialVersionUID = 0;
        public final Boolean event_monitor;
        public final Integer waiting_time_threshold;

        public static final class Builder extends com.squareup.wire.Message.Builder<ThreadPoolMonitorSetting, Builder> {
            public Boolean event_monitor;
            public Integer waiting_time_threshold;

            @Override // com.squareup.wire.Message.Builder
            public ThreadPoolMonitorSetting build() {
                Boolean r100 = this.event_monitor;
                if (r100 == null) goto L9;
                if (this.waiting_time_threshold == null) goto L9;
                return new ThreadPoolMonitorSetting(this.event_monitor, this.waiting_time_threshold, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "event_monitor", this.waiting_time_threshold, "waiting_time_threshold"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder event_monitor(Boolean r100) {
                this.event_monitor = r100;
                return this;
            }

            public Builder waiting_time_threshold(Integer r100) {
                this.waiting_time_threshold = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThreadPoolMonitorSetting extends ProtoAdapter<ThreadPoolMonitorSetting> {
            public ProtoAdapter_ThreadPoolMonitorSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ThreadPoolMonitorSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThreadPoolMonitorSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.event_monitor = Boolean.FALSE;
                r101.waiting_time_threshold = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.event_monitor = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.waiting_time_threshold = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(ThreadPoolMonitorSetting r100) {
                return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.event_monitor) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.waiting_time_threshold)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThreadPoolMonitorSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThreadPoolMonitorSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThreadPoolMonitorSetting r101) throws IOException {
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.event_monitor);
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.waiting_time_threshold);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadPoolMonitorSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThreadPoolMonitorSetting();
            DEFAULT_EVENT_MONITOR = Boolean.FALSE;
            DEFAULT_WAITING_TIME_THRESHOLD = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.event_monitor = this.event_monitor;
            r100.waiting_time_threshold = this.waiting_time_threshold;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThreadPoolMonitorSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThreadPoolMonitorSetting(Boolean r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ThreadPoolMonitorSetting(Boolean r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.event_monitor = r100;
            this.waiting_time_threshold = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InitSDKRequest();
        DEFAULT_ENV = EnvType.ONLINE;
        DEFAULT_PROCESS_TYPE = ProcessType.MAIN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_NEED_CALL_ASYNC = r100;
        DEFAULT_DATA_SYNCHRONISM_STRATEGY = DataSynchronismStrategy.BROADCAST;
        DEFAULT_ENABLE_THREAD = r100;
        DEFAULT_IS_WRAP_ASYNC_CALLBACK_DATA_WITH_PACKET = r100;
        DEFAULT_ENABLE_THREAD_SUBSCRIPTION = r100;
        DEFAULT_USE_DEPRECATED_PUSH_MSG = Boolean.TRUE;
        DEFAULT_POWER_LEVEL_UNDER_BACKGROUND = PowerLevel.Low;
        DEFAULT_PACKAGE_ID = PackageId.LARK;
        DEFAULT_MAIN_THREAD_ID = 0L;
        DEFAULT_NEED_SETTINGS = r100;
        DEFAULT_BASIC_MODE = r100;
        DEFAULT_IS_RELEASE = r100;
        DEFAULT_IS_ANYDOOR_ENABLE = r100;
        DEFAULT_WORKER_CREATE_DURATION = 0L;
        DEFAULT_PER_WORKER_SPAWN_THRESHOLD = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_THREAD_PRIORITY = 0;
        DEFAULT_EXPECTED_THREAD = 0;
        DEFAULT_EPOCH_STEP_COUNT = 0;
        DEFAULT_WORKER_RELEASE_DURATION = 0L;
        DEFAULT_DEVICE_PERF_LEVEL = DevicePerfLevel.DEVICE_UNKNOWN;
        DEFAULT_ENABLE_NEW_TTNET_LOG_REPORTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.storage_path = this.storage_path;
        r100.env = this.env;
        r100.version = this.version;
        r100.user_agent = this.user_agent;
        r100.process_type = this.process_type;
        r100.user_id = this.user_id;
        r100.need_call_async = this.need_call_async;
        r100.app_id = this.app_id;
        r100.locale_identifier = this.locale_identifier;
        r100.client_log_storage_path = this.client_log_storage_path;
        r100.client_stability_log_dirs = Internal.copyOf("client_stability_log_dirs", this.client_stability_log_dirs);
        r100.path_prefix = this.path_prefix;
        r100.sub_account_path = this.sub_account_path;
        r100.sub_user_path = this.sub_user_path;
        r100.old_storage_path = this.old_storage_path;
        r100.custom_log_path = this.custom_log_path;
        r100.init_log_upload = this.init_log_upload;
        r100.device_info = this.device_info;
        r100.data_synchronism_strategy = this.data_synchronism_strategy;
        r100.enable_thread = this.enable_thread;
        r100.is_wrap_async_callback_data_with_packet = this.is_wrap_async_callback_data_with_packet;
        r100.enable_thread_subscription = this.enable_thread_subscription;
        r100.use_deprecated_push_msg = this.use_deprecated_push_msg;
        r100.preload_config = this.preload_config;
        r100.power_level_under_background = this.power_level_under_background;
        r100.package_id = this.package_id;
        r100.deprecated_config = this.deprecated_config;
        r100.ka_init_config = this.ka_init_config;
        r100.frontier_config = this.frontier_config;
        r100.env_v2 = this.env_v2;
        r100.main_thread_id = this.main_thread_id;
        r100.need_settings = this.need_settings;
        r100.client_cert = this.client_cert;
        r100.boe_tt_feature_env = this.boe_tt_feature_env;
        r100.boe_rpc_persist_dyecp_fd = this.boe_rpc_persist_dyecp_fd;
        r100.local_timezone = this.local_timezone;
        r100.init_config_path = this.init_config_path;
        r100.basic_mode = this.basic_mode;
        r100.stress_test_tag = this.stress_test_tag;
        r100.wasm_init_config = this.wasm_init_config;
        r100.is_release = this.is_release;
        r100.pre_rpc_persist_dyecp_fd_key = this.pre_rpc_persist_dyecp_fd_key;
        r100.pre_rpc_persist_dyecp_fd_value = this.pre_rpc_persist_dyecp_fd_value;
        r100.pre_rpc_persist_mock_tag_value = this.pre_rpc_persist_mock_tag_value;
        r100.os_version = this.os_version;
        r100.is_anydoor_enable = this.is_anydoor_enable;
        r100.device_model = this.device_model;
        r100.x_tt_env = this.x_tt_env;
        r100.settings_queries = Internal.copyOf("settings_queries", this.settings_queries);
        r100.app_channel = this.app_channel;
        r100.proxy_config = this.proxy_config;
        r100.worker_create_duration = this.worker_create_duration;
        r100.per_worker_spawn_threshold = this.per_worker_spawn_threshold;
        r100.thread_priority = this.thread_priority;
        r100.expected_thread = this.expected_thread;
        r100.epoch_step_count = this.epoch_step_count;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.worker_release_duration = this.worker_release_duration;
        r100.device_perf_level = this.device_perf_level;
        r100.client_ab_experiment = this.client_ab_experiment;
        r100.log_setting = this.log_setting;
        r100.network_settings = this.network_settings;
        r100.net_semaphore_monitor_setting = this.net_semaphore_monitor_setting;
        r100.thread_pool_monitor_setting = this.thread_pool_monitor_setting;
        r100.customized_init_meta = Internal.copyOf("customized_init_meta", this.customized_init_meta);
        r100.net_decorators = Internal.copyOf("net_decorators", this.net_decorators);
        r100.enable_new_ttnet_log_reporter = this.enable_new_ttnet_log_reporter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InitSDKRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public InitSDKRequest(String r710, EnvType r711, String r712, String r713, ProcessType r714, String r715, Boolean r716, String r717, String r718, String r719, List<String> r810, String r811, String r812, String r813, String r814, String r815, InitLogUpload r816, DeviceInfo r817, DataSynchronismStrategy r818, Boolean r819, Boolean r910, Boolean r911, Boolean r912, PreloadConfig r913, PowerLevel r914, PackageId r915, DeprecatedConfig r916, KaInitConfig r917, FrontierConfig r918, EnvV2 r919, Long r100, Boolean r101, NetworkClientCertificate r102, String r103, BoeRpcPersistDyecpFd r104, String r105, String r106, Boolean r107, String r108, String r109, Boolean r110, String r111, String r112, String r113, String r114, Boolean r115, String r116, String r117, Map<String, String> r118, String r119, ProxyConfig r120, Long r121, Double r122, Integer r123, Integer r124, Integer r125, List<String> r126, Long r127, DevicePerfLevel r128, ClientABExperiment r129, LogSetting r130, NetworkSetting r131, NetSemaphoreMonitorSetting r132, ThreadPoolMonitorSetting r133, Map<String, String> r134, List<NetDecorator> r135, Boolean r136) {
        this(r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, ByteString.EMPTY);
    }

    public InitSDKRequest(String r100, EnvType r101, String r102, String r103, ProcessType r104, String r105, Boolean r110, String r111, String r112, String r113, List<String> r114, String r115, String r116, String r117, String r118, String r119, InitLogUpload r210, DeviceInfo r211, DataSynchronismStrategy r212, Boolean r213, Boolean r214, Boolean r215, Boolean r216, PreloadConfig r217, PowerLevel r218, PackageId r219, DeprecatedConfig r310, KaInitConfig r311, FrontierConfig r312, EnvV2 r313, Long r314, Boolean r315, NetworkClientCertificate r316, String r317, BoeRpcPersistDyecpFd r318, String r319, String r410, Boolean r411, String r412, String r413, Boolean r414, String r415, String r416, String r417, String r418, Boolean r419, String r510, String r511, Map<String, String> r512, String r513, ProxyConfig r514, Long r515, Double r516, Integer r517, Integer r518, Integer r519, List<String> r610, Long r611, DevicePerfLevel r612, ClientABExperiment r613, LogSetting r614, NetworkSetting r615, NetSemaphoreMonitorSetting r616, ThreadPoolMonitorSetting r617, Map<String, String> r618, List<NetDecorator> r619, Boolean r710, ByteString r711) {
        super(ADAPTER, r711);
        this.storage_path = r100;
        this.env = r101;
        this.version = r102;
        this.user_agent = r103;
        this.process_type = r104;
        this.user_id = r105;
        this.need_call_async = r110;
        this.app_id = r111;
        this.locale_identifier = r112;
        this.client_log_storage_path = r113;
        this.client_stability_log_dirs = Internal.immutableCopyOf("client_stability_log_dirs", r114);
        this.path_prefix = r115;
        this.sub_account_path = r116;
        this.sub_user_path = r117;
        this.old_storage_path = r118;
        this.custom_log_path = r119;
        this.init_log_upload = r210;
        this.device_info = r211;
        this.data_synchronism_strategy = r212;
        this.enable_thread = r213;
        this.is_wrap_async_callback_data_with_packet = r214;
        this.enable_thread_subscription = r215;
        this.use_deprecated_push_msg = r216;
        this.preload_config = r217;
        this.power_level_under_background = r218;
        this.package_id = r219;
        this.deprecated_config = r310;
        this.ka_init_config = r311;
        this.frontier_config = r312;
        this.env_v2 = r313;
        this.main_thread_id = r314;
        this.need_settings = r315;
        this.client_cert = r316;
        this.boe_tt_feature_env = r317;
        this.boe_rpc_persist_dyecp_fd = r318;
        this.local_timezone = r319;
        this.init_config_path = r410;
        this.basic_mode = r411;
        this.stress_test_tag = r412;
        this.wasm_init_config = r413;
        this.is_release = r414;
        this.pre_rpc_persist_dyecp_fd_key = r415;
        this.pre_rpc_persist_dyecp_fd_value = r416;
        this.pre_rpc_persist_mock_tag_value = r417;
        this.os_version = r418;
        this.is_anydoor_enable = r419;
        this.device_model = r510;
        this.x_tt_env = r511;
        this.settings_queries = Internal.immutableCopyOf("settings_queries", r512);
        this.app_channel = r513;
        this.proxy_config = r514;
        this.worker_create_duration = r515;
        this.per_worker_spawn_threshold = r516;
        this.thread_priority = r517;
        this.expected_thread = r518;
        this.epoch_step_count = r519;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r610);
        this.worker_release_duration = r611;
        this.device_perf_level = r612;
        this.client_ab_experiment = r613;
        this.log_setting = r614;
        this.network_settings = r615;
        this.net_semaphore_monitor_setting = r616;
        this.thread_pool_monitor_setting = r617;
        this.customized_init_meta = Internal.immutableCopyOf("customized_init_meta", r618);
        this.net_decorators = Internal.immutableCopyOf("net_decorators", r619);
        this.enable_new_ttnet_log_reporter = r710;
    }
}
