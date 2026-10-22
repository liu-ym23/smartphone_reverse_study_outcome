package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.larus.dora.impl.core.settingsconfig.DoraMultiDeviceConfig;
import com.larus.dora.impl.core.settingsconfig.DoraVolumeAdaptationConfig;
import java.util.List;
import kotlin.Metadata;
import qt9.j4;

/* JADX INFO: loaded from: classes4.dex */
@Settings(storageKey = "dora_settings")
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'J\b\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH'J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH'J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H'J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH'J\b\u0010\u000e\u001a\u00020\u0005H'J\b\u0010\u000f\u001a\u00020\u0010H'J\b\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H'J\b\u0010\u0015\u001a\u00020\u0014H'J\b\u0010\u0016\u001a\u00020\u0014H'J\b\u0010\u0017\u001a\u00020\u0018H'J\b\u0010\u0019\u001a\u00020\u0014H'J\b\u0010\u001a\u001a\u00020\u0014H'J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH'J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH'J\b\u0010\u001f\u001a\u00020\u0014H'J\b\u0010 \u001a\u00020\u0003H'J\b\u0010!\u001a\u00020\u0014H'J\n\u0010\"\u001a\u0004\u0018\u00010#H'J\n\u0010$\u001a\u0004\u0018\u00010%H'J\b\u0010&\u001a\u00020\u0014H'J\b\u0010'\u001a\u00020\u0014H'J\b\u0010(\u001a\u00020\u0014H'J\b\u0010)\u001a\u00020\u0014H'J\b\u0010*\u001a\u00020\u0014H'J\b\u0010+\u001a\u00020\u0014H'J\b\u0010,\u001a\u00020\u0014H'J\b\u0010-\u001a\u00020\u0014H'J\b\u0010.\u001a\u00020\u0014H'J\b\u0010/\u001a\u000200H'J\b\u00101\u001a\u000202H'J\b\u00103\u001a\u00020\u0014H'J\n\u00104\u001a\u0004\u0018\u000105H'J\n\u00106\u001a\u0004\u0018\u000107H'J\b\u00108\u001a\u00020\u0014H'J\u0010\u00109\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH'J\u0010\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH'J\b\u0010;\u001a\u00020\u0014H'J\b\u0010<\u001a\u00020\u0014H'J\u0010\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\nH'J\b\u0010?\u001a\u00020\u0014H'J\n\u0010@\u001a\u0004\u0018\u00010AH'J\b\u0010B\u001a\u00020\u0014H'J\b\u0010C\u001a\u00020\u0014H'J\b\u0010D\u001a\u00020\u0003H'J\b\u0010E\u001a\u00020\u0014H'J\b\u0010F\u001a\u00020\u0003H'J\b\u0010G\u001a\u00020\u0014H'J\b\u0010H\u001a\u000202H'J\b\u0010I\u001a\u00020\u0014H'J\n\u0010J\u001a\u0004\u0018\u00010KH'J\b\u0010L\u001a\u00020\u0014H'¨\u0006M"}, d2 = {"Lcom/larus/dora/impl/settings/IDoraSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "enableDoraFeature", "", "deviceManageMoreUrl", "", "doraHealthAgentWebUrl", "systemVoiceConfig", "Lcom/larus/settings/provider/SystemVoiceConfig;", "doraOnboardingQueryTopic", "", "doraOnboardingOpeningRemarks", "doraKeepAliveImageUrl", "doraUploadLogSceneConfig", "doraKmpFeatureConfig", "getOTATriggerConfig", "Lcom/larus/dora/impl/settings/OTATriggerSceneConfig;", "getOtaBypassStateDetectConfig", "Lcom/larus/dora/impl/settings/OTABypassStateDetectConfig;", "isBatteryOptimizationFeatureEnabled", "", "isBoxBatteryOptimizationFeatureEnabled", "isSyncStatusFeatureEnabled", "doraLynxPageConfig", "Lcom/larus/dora/impl/settings/DoraLynxPageConfig;", "isVolumeFeatureEnabled", "isDynamicQpEnabled", "volumeAdaptationConfig", "Lcom/larus/dora/impl/core/settingsconfig/DoraVolumeAdaptationConfig;", "multiDeviceConfig", "Lcom/larus/dora/impl/core/settingsconfig/DoraMultiDeviceConfig;", "isDoraGOMultiConnectionTempOpen", "timeSyncMaxSessionConfig", "isMultiManageEnabled", "doraPushSummaryConfig", "Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "doraGAmbientVolumeConfig", "Lcom/larus/dora/impl/settings/DoraGAmbientVolumeConfig;", "isMultiWakeupKeywordsUiFeatureEnabled", "isWakeupKeywordsSyllableSwitchUiFeatureEnabled", "isDoraOTASingleBudUpgradeFeatureEnabled", "isSilenceOtaAutoTestEnabled", "isThirdPartyDeviceSharedEnabled", "isHDeviceEnabled", "isObricGlassesExploreEnabled", "isQuickNoteEnabled", "isVoicePrintFeatureEnabled", "doraGuideConfig", "Lcom/larus/dora/impl/guide/common/DoraGuideConfig;", "autoGreetLiteEventDelayTime", "", "isDmsAudioPreprocessEnabled", "doraGOnboardingConfig", "Lcom/larus/dora/impl/settings/DoraGOnboardingConfig;", "doraObricOnboardingConfig", "Lcom/larus/dora/impl/settings/DoraObricOnboardingConfig;", "enableHOnboardingNoSkip", "onboardingTitle", "doraHOnboardingOpeningRemarks", "enableNewOnboarding", "isHOnboardingSimplifiedEnabled", "doraHOnboardingSimplifiedTopics", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "enableHUnSupportCommandFeature", "doraBTOptimizationConfig", "Lcom/larus/dora/impl/core/DoraBTOptimizationConfig;", "enableHarmonyZYT", "getAudioDecoderType", "enableDestroyAisTunnelLockMode", "enableDoraNewCommonParamsSwitch", "imuPackageMaxSize", "isImuReportEnabled", "imuReportTimestampCalibrationThreshold", "isDumpAllLogEnabled", "sppLinkRetryConfig", "Lcom/larus/dora/impl/settings/SppLinkRetryConfig;", "enableDoraTrackerMultiDevicesTransmit", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraSettings extends ISettings {
    long autoGreetLiteEventDelayTime();

    String deviceManageMoreUrl();

    com.larus.dora.impl.core.d doraBTOptimizationConfig();

    DoraGAmbientVolumeConfig doraGAmbientVolumeConfig();

    DoraGOnboardingConfig doraGOnboardingConfig();

    i59.b doraGuideConfig();

    List<String> doraHOnboardingOpeningRemarks();

    List<SimplifiedTopic> doraHOnboardingSimplifiedTopics();

    String doraHealthAgentWebUrl();

    String doraKeepAliveImageUrl();

    String doraKmpFeatureConfig();

    a doraLynxPageConfig();

    DoraObricOnboardingConfig doraObricOnboardingConfig();

    List<String> doraOnboardingOpeningRemarks();

    List<String> doraOnboardingQueryTopic();

    DoraPushSummaryConfig doraPushSummaryConfig();

    List<String> doraUploadLogSceneConfig();

    int enableDestroyAisTunnelLockMode();

    int enableDoraFeature();

    boolean enableDoraNewCommonParamsSwitch();

    boolean enableDoraTrackerMultiDevicesTransmit();

    boolean enableHOnboardingNoSkip();

    boolean enableHUnSupportCommandFeature();

    boolean enableHarmonyZYT();

    boolean enableNewOnboarding();

    boolean getAudioDecoderType();

    j1 getOTATriggerConfig();

    h1 getOtaBypassStateDetectConfig();

    int imuPackageMaxSize();

    long imuReportTimestampCalibrationThreshold();

    boolean isBatteryOptimizationFeatureEnabled();

    boolean isBoxBatteryOptimizationFeatureEnabled();

    boolean isDmsAudioPreprocessEnabled();

    boolean isDoraGOMultiConnectionTempOpen();

    boolean isDoraOTASingleBudUpgradeFeatureEnabled();

    boolean isDumpAllLogEnabled();

    boolean isDynamicQpEnabled();

    boolean isHDeviceEnabled();

    boolean isHOnboardingSimplifiedEnabled();

    boolean isImuReportEnabled();

    boolean isMultiManageEnabled();

    boolean isMultiWakeupKeywordsUiFeatureEnabled();

    boolean isObricGlassesExploreEnabled();

    boolean isQuickNoteEnabled();

    boolean isSilenceOtaAutoTestEnabled();

    boolean isSyncStatusFeatureEnabled();

    boolean isThirdPartyDeviceSharedEnabled();

    boolean isVoicePrintFeatureEnabled();

    boolean isVolumeFeatureEnabled();

    boolean isWakeupKeywordsSyllableSwitchUiFeatureEnabled();

    DoraMultiDeviceConfig multiDeviceConfig();

    List<String> onboardingTitle();

    SppLinkRetryConfig sppLinkRetryConfig();

    j4 systemVoiceConfig();

    int timeSyncMaxSessionConfig();

    DoraVolumeAdaptationConfig volumeAdaptationConfig();
}
