package com.obric.assistant;

import android.util.EventsUtils;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.google.gson.JsonObject;
import com.obric.assistant.settings.config.ObricMmtVideoHardwareConfig;
import java.util.HashMap;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Settings(storageKey = "nova_settings")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0005H'J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH'J\b\u0010\t\u001a\u00020\nH'J\b\u0010\u000b\u001a\u00020\fH'J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H'J$\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012H'J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0003H'J$\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012H'J\n\u0010!\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\"\u001a\u0004\u0018\u00010\u0003H'J\n\u0010#\u001a\u0004\u0018\u00010\u0003H'J\n\u0010$\u001a\u0004\u0018\u00010\u0003H'J\n\u0010%\u001a\u0004\u0018\u00010\u0003H'J\n\u0010&\u001a\u0004\u0018\u00010\u0003H'J\n\u0010'\u001a\u0004\u0018\u00010\u0003H'J\n\u0010(\u001a\u0004\u0018\u00010\u0003H'J\n\u0010)\u001a\u0004\u0018\u00010\u0003H'J\n\u0010*\u001a\u0004\u0018\u00010\u0003H'J\n\u0010+\u001a\u0004\u0018\u00010\u0003H'J\n\u0010,\u001a\u0004\u0018\u00010\u0003H'J\n\u0010-\u001a\u0004\u0018\u00010\u0003H'J\n\u0010.\u001a\u0004\u0018\u00010\u0003H'J\n\u0010/\u001a\u0004\u0018\u00010\u0003H'J\n\u00100\u001a\u0004\u0018\u00010\u0003H'J\n\u00101\u001a\u0004\u0018\u00010\u0003H'J\n\u00102\u001a\u0004\u0018\u00010\u0003H'J\n\u00103\u001a\u0004\u0018\u00010\u0003H'J\n\u00104\u001a\u0004\u0018\u00010\u0003H'J\n\u00105\u001a\u0004\u0018\u00010\u0003H'J\n\u00106\u001a\u0004\u0018\u00010\u0003H'J\n\u00107\u001a\u0004\u0018\u00010\u0003H'J\n\u00108\u001a\u0004\u0018\u00010\u0003H'J\n\u00109\u001a\u0004\u0018\u00010\u0003H'J\n\u0010:\u001a\u0004\u0018\u00010\u0003H'J\b\u0010;\u001a\u00020\u0005H'J\b\u0010<\u001a\u00020\u0005H'J\n\u0010=\u001a\u0004\u0018\u00010\u0003H'J\n\u0010>\u001a\u0004\u0018\u00010\u0003H'J\n\u0010?\u001a\u0004\u0018\u00010\u0003H'J\b\u0010@\u001a\u00020\fH'J\n\u0010A\u001a\u0004\u0018\u00010\u0003H'J\n\u0010B\u001a\u0004\u0018\u00010\u0003H'J\n\u0010C\u001a\u0004\u0018\u00010\u0003H'J\n\u0010D\u001a\u0004\u0018\u00010\u0003H'J\n\u0010E\u001a\u0004\u0018\u00010\u0003H'J\n\u0010F\u001a\u0004\u0018\u00010\u0003H'J\n\u0010G\u001a\u0004\u0018\u00010\u0003H'J\n\u0010H\u001a\u0004\u0018\u00010\u0003H'J\n\u0010I\u001a\u0004\u0018\u00010\u0003H'J\n\u0010J\u001a\u0004\u0018\u00010\u0003H'J\n\u0010K\u001a\u0004\u0018\u00010\u0003H'J\n\u0010L\u001a\u0004\u0018\u00010\u0003H'J\n\u0010M\u001a\u0004\u0018\u00010\u0003H'J\n\u0010N\u001a\u0004\u0018\u00010\u0003H'J\n\u0010O\u001a\u0004\u0018\u00010\u0003H'J\n\u0010P\u001a\u0004\u0018\u00010\u0003H'J\n\u0010Q\u001a\u0004\u0018\u00010\u0003H'J\n\u0010R\u001a\u0004\u0018\u00010\u0003H'J\n\u0010S\u001a\u0004\u0018\u00010\u0003H'J\n\u0010T\u001a\u0004\u0018\u00010\u0003H'J\n\u0010U\u001a\u0004\u0018\u00010\u0003H'J\n\u0010V\u001a\u0004\u0018\u00010\u0003H'J\n\u0010W\u001a\u0004\u0018\u00010\u0003H'J\n\u0010X\u001a\u0004\u0018\u00010\u0003H'J\b\u0010Y\u001a\u00020\u0005H'J\n\u0010Z\u001a\u0004\u0018\u00010\u0003H'J\n\u0010[\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\\\u001a\u0004\u0018\u00010\u0003H'J\b\u0010]\u001a\u00020\u0005H'J\n\u0010^\u001a\u0004\u0018\u00010\u0003H'J\n\u0010_\u001a\u0004\u0018\u00010\u0003H'J\n\u0010`\u001a\u0004\u0018\u00010\u0003H'J\n\u0010a\u001a\u0004\u0018\u00010\u0003H'J\n\u0010b\u001a\u0004\u0018\u00010\u0003H'J\n\u0010c\u001a\u0004\u0018\u00010\u0003H'J\b\u0010d\u001a\u00020eH'J\n\u0010f\u001a\u0004\u0018\u00010\u0003H'¨\u0006g"}, d2 = {"Lcom/obric/assistant/IObricCloudSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getObricAppFunctionSettings", "Lcom/google/gson/JsonObject;", "enableObricSettingsOverride", XmlPullParser.NO_NAMESPACE, "isOfficeSdkLazyInitEnabled", "getMmtVideoHardwareConfig", "Lcom/obric/assistant/settings/config/ObricMmtVideoHardwareConfig;", "getObricLazyInitConfig", "Lcom/obric/assistant/ObricLazyInitConfig;", "getObricPrivacyLaneType", XmlPullParser.NO_NAMESPACE, "getObricCheckUpdateConfig", "obricPluginsConfig", "Ljava/util/HashMap;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "Lkotlin/collections/HashMap;", "getObricPowerLockConfig", "getObricStateMachineMultitaskConfig", "getObricAigcGenerationStateConfig", "getObricWakeupAudioCaptureConfig", "getObricComplexTaskSettingsConfig", "getObricSelfUpdateSettingsConfig", "getObricUpdateSettingsConfig", "getObricModelSettingsConfig", "getObricVoicePrintAuthenticateSettingsConfig", "getObricQueryAuthenticateConfig", "getObricSecuritySettingsConfig", "getObricSecuritySettingsPackageWhitelistConfig", "getObricFeatureConfigMap", "getObricComplexTaskCaseFromPC", "getObricAutoIncreaseDelayedTimeConfig", "getObricProcessesManagerConfig", "getObricAppLogSettingsConfig", "getObricLogSettingsConfig", "getObricSettingsListConfig", "getObricPerformanceMonitorConfig", "getObricMemoryReportConfig", "getObricThresholdDumpHprofConfig", "getObricThresholdPssUploadFilesConfig", "getObricCrashDumpHprofConfig", "getObricSettingsConfig", "getObricOneLoginConfig", "getObricBreathWakeupDataTrackerJson", "getObricAutoGuiBlacklistConfig", "getObricAutoGuiAppScopeConfig", "getAutoGuiAutomaticExecutionAuthorizationConfig", "getObricAutoSettingsJson", "getAgentSkillsSettingsJson", "getObricOmniSupportFileUploadMap", "getObricActionBarItemsConfig", "getObricActionBarModelMenuConfig", "getObricBottomTabConfig", "getObricTaskSystemConfig", "getObricEventTaskExperimentConfig", "getObricAsrFeedbackConfig", "getObricContTalkConfig", "isObricContTalkPvadSwitchShowEnable", "isReRecordWakeWordGuideEnable", "getWindowActionBarItemsConfig", "getObricResetTaskModeTimeConfig", "getObricWakeupSoundConfig", "getObricWakeupSoundConfigWhite", "getObricPromptCellConfig", "getObricTaskTimeoutConfig", "getObricAiKeyConfig", "getObricProductInfoConfig", "getObricFeatureAudioBreathDataTrackerConfig", "getObricDoraGNewDeviceManageConfig", "getVoiceWakeupStage1Config", "getObricFeatureAutoActionAppBlacklistConfig", "getObricOUseMemory", "getObricMemoryDataCollectConfig", "getObricLarkConfirmSettingsConfig", "getObricImageUploadCompressConfig", "getObricAppIntentScreenshotCacheConfig", "getObricScreenshotUploadConfig", "getObricFeatureConfigSingle", "getObricFeatureConfigGroup", "getObricFeatureMemoryTogglesConfig", "getObricPerformancePowerMonitorSettingsConfig", "getObricIpcAnomalyReportConfig", "getObricPerformanceCPUExceptionDiagnosisSettingsConfig", "getObricScriptToggleMap", "getObricOmniDataFeedbackToggleMap", "getObricOmniUploadImageAutoDrainToggleMap", "getObricAppIntentLockScreenExecuteConfig", "isCloseAudioConnAppBackGroundOnlyForObric", "getObricFeatureGenesisFeedbackSupport", "getObricFeatureCocreationReviewSupport", "getVoiceWakeupSidThresholdConfig", "isBypassAdaptiveSid", "getWindowFeatureEnabled", "getObricFeatureDownloadCertificateConfig", "getObricFeatureKeepAliveHighLevel", "getObricFeatureKeepAliveMidLevel", "getObricFeatureKeepAliveLowLevel", "getObricFeatureExitAiAgentWhenNovaDied", "getObricZeusAutoFetchConfig", "Lcom/obric/assistant/ZeusAutoFetchConfig;", "getObricVoiceSectionTrackerEnableSlardar", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricCloudSettings extends ISettings {
    boolean enableObricSettingsOverride();

    JsonObject getAgentSkillsSettingsJson();

    JsonObject getAutoGuiAutomaticExecutionAuthorizationConfig();

    ObricMmtVideoHardwareConfig getMmtVideoHardwareConfig();

    JsonObject getObricActionBarItemsConfig();

    JsonObject getObricActionBarModelMenuConfig();

    JsonObject getObricAiKeyConfig();

    JsonObject getObricAigcGenerationStateConfig();

    JsonObject getObricAppFunctionSettings();

    JsonObject getObricAppIntentLockScreenExecuteConfig();

    JsonObject getObricAppIntentScreenshotCacheConfig();

    JsonObject getObricAppLogSettingsConfig();

    JsonObject getObricAsrFeedbackConfig();

    JsonObject getObricAutoGuiAppScopeConfig();

    JsonObject getObricAutoGuiBlacklistConfig();

    JsonObject getObricAutoIncreaseDelayedTimeConfig();

    JsonObject getObricAutoSettingsJson();

    JsonObject getObricBottomTabConfig();

    JsonObject getObricBreathWakeupDataTrackerJson();

    JsonObject getObricCheckUpdateConfig();

    HashMap<String, Object> getObricComplexTaskCaseFromPC();

    JsonObject getObricComplexTaskSettingsConfig();

    JsonObject getObricContTalkConfig();

    JsonObject getObricCrashDumpHprofConfig();

    JsonObject getObricDoraGNewDeviceManageConfig();

    JsonObject getObricEventTaskExperimentConfig();

    JsonObject getObricFeatureAudioBreathDataTrackerConfig();

    JsonObject getObricFeatureAutoActionAppBlacklistConfig();

    JsonObject getObricFeatureCocreationReviewSupport();

    JsonObject getObricFeatureConfigGroup();

    JsonObject getObricFeatureConfigMap();

    JsonObject getObricFeatureConfigSingle();

    JsonObject getObricFeatureDownloadCertificateConfig();

    JsonObject getObricFeatureExitAiAgentWhenNovaDied();

    JsonObject getObricFeatureGenesisFeedbackSupport();

    JsonObject getObricFeatureKeepAliveHighLevel();

    JsonObject getObricFeatureKeepAliveLowLevel();

    JsonObject getObricFeatureKeepAliveMidLevel();

    JsonObject getObricFeatureMemoryTogglesConfig();

    JsonObject getObricImageUploadCompressConfig();

    JsonObject getObricIpcAnomalyReportConfig();

    JsonObject getObricLarkConfirmSettingsConfig();

    ObricLazyInitConfig getObricLazyInitConfig();

    JsonObject getObricLogSettingsConfig();

    JsonObject getObricMemoryDataCollectConfig();

    JsonObject getObricMemoryReportConfig();

    JsonObject getObricModelSettingsConfig();

    JsonObject getObricOUseMemory();

    JsonObject getObricOmniDataFeedbackToggleMap();

    JsonObject getObricOmniSupportFileUploadMap();

    JsonObject getObricOmniUploadImageAutoDrainToggleMap();

    JsonObject getObricOneLoginConfig();

    JsonObject getObricPerformanceCPUExceptionDiagnosisSettingsConfig();

    JsonObject getObricPerformanceMonitorConfig();

    JsonObject getObricPerformancePowerMonitorSettingsConfig();

    JsonObject getObricPowerLockConfig();

    int getObricPrivacyLaneType();

    JsonObject getObricProcessesManagerConfig();

    JsonObject getObricProductInfoConfig();

    JsonObject getObricPromptCellConfig();

    JsonObject getObricQueryAuthenticateConfig();

    JsonObject getObricResetTaskModeTimeConfig();

    JsonObject getObricScreenshotUploadConfig();

    JsonObject getObricScriptToggleMap();

    JsonObject getObricSecuritySettingsConfig();

    JsonObject getObricSecuritySettingsPackageWhitelistConfig();

    JsonObject getObricSelfUpdateSettingsConfig();

    JsonObject getObricSettingsConfig();

    JsonObject getObricSettingsListConfig();

    JsonObject getObricStateMachineMultitaskConfig();

    JsonObject getObricTaskSystemConfig();

    JsonObject getObricTaskTimeoutConfig();

    JsonObject getObricThresholdDumpHprofConfig();

    JsonObject getObricThresholdPssUploadFilesConfig();

    JsonObject getObricUpdateSettingsConfig();

    JsonObject getObricVoicePrintAuthenticateSettingsConfig();

    JsonObject getObricVoiceSectionTrackerEnableSlardar();

    JsonObject getObricWakeupAudioCaptureConfig();

    JsonObject getObricWakeupSoundConfig();

    int getObricWakeupSoundConfigWhite();

    ZeusAutoFetchConfig getObricZeusAutoFetchConfig();

    JsonObject getVoiceWakeupSidThresholdConfig();

    JsonObject getVoiceWakeupStage1Config();

    JsonObject getWindowActionBarItemsConfig();

    JsonObject getWindowFeatureEnabled();

    boolean isBypassAdaptiveSid();

    boolean isCloseAudioConnAppBackGroundOnlyForObric();

    boolean isObricContTalkPvadSwitchShowEnable();

    boolean isOfficeSdkLazyInitEnabled();

    boolean isReRecordWakeWordGuideEnable();

    HashMap<String, Object> obricPluginsConfig();
}
