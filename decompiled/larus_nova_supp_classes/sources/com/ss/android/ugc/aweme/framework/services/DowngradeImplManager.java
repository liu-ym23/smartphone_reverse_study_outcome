package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.bytedance.bmf_mods_api.AdaptiveGradingAPIDefault;
import com.bytedance.bmf_mods_api.ByteStreamHDCallbackAPIDefault;
import com.bytedance.bmf_mods_api.ByteStreamHDDefault;
import com.bytedance.bmf_mods_api.ColorHistAPIDefault;
import com.bytedance.bmf_mods_api.ColorShiftAPIDefault;
import com.bytedance.bmf_mods_api.DenoiseAPIDefault;
import com.bytedance.bmf_mods_api.HydraHDRAPIDefault;
import com.bytedance.bmf_mods_api.MotionSenseAPIDefault;
import com.bytedance.bmf_mods_api.NoiseDetectAPIDefault;
import com.bytedance.bmf_mods_api.NoiseDetectCallbackAPIDefault;
import com.bytedance.bmf_mods_api.NoiseLiveAPIDefault;
import com.bytedance.bmf_mods_api.NoiseLiveCallbackAPIDefault;
import com.bytedance.bmf_mods_api.SitiAPIDefault;
import com.bytedance.bmf_mods_api.TdiLiteStrategyAPIDefault;
import com.bytedance.bmf_mods_api.VideoBrightAPIDefault;
import com.bytedance.bmf_mods_api.VideoBrightCallBackAPIDefault;
import com.bytedance.bmf_mods_api.VideoOCLSRAPIDefault;
import com.bytedance.bmf_mods_api.VideoSRLutAPIDefault;
import com.bytedance.bmf_mods_api.VideoSRLutDspAPIDefault;
import com.bytedance.bmf_mods_api.VideoSRRaisrAPIDefault;
import com.bytedance.bmf_mods_api.VideoSuperResolutionAPIDefault;
import com.bytedance.bmf_mods_api.VqscoreLiveAPIDefault;
import com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPIDefault;
import com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPIDefault;
import com.bytedance.dux.api.DuxComponentServiceDefault;
import com.bytedance.dux.api.DuxEmojiServiceDefault;
import com.bytedance.dux.drawable.api.DoubleColorInitConfigServiceDefault;
import com.bytedance.ies.abmock.datacenter.init.ABMockInitConfigDefault;
import com.bytedance.ies.ugc.aweme.network.NetworkCommonParams;
import com.bytedance.ies.web.jsbridge2.JsBridge2ConfigDefault;
import com.bytedance.pia.core.spi.ConfigTask;
import com.bytedance.timon.foundation.impl.AndroidLoggerImpl;
import com.bytedance.timon.foundation.impl.AppLogImpl;
import com.bytedance.timon.foundation.impl.EventMonitorDowngradeImpl;
import com.bytedance.timon.foundation.impl.ExceptionMonitorImpl;
import com.bytedance.timon.foundation.impl.SPStoreImpl;
import com.bytedance.timon.ruler.adapter.impl.RulerBusinessEmptyImpl;
import com.bytedance.timonbase.TimonLifecycleServiceDowngradeImp;
import com.fackbook.drawee.DraweeConfigOutServiceDowngrade;
import com.larus.agents.api.LocalWebFetchServiceNoop;
import com.larus.agents.api.OfficeTaskSettingsServiceNoop;
import com.larus.app.settings.api.AppSettingsHostServiceNoop;
import com.larus.audio.AudioServiceNoop;
import com.larus.audio.realtimecall.RealtimeCallStrategyNoop;
import com.larus.audio.ttsV2.TtsBackgroundPlayControlServiceNoop;
import com.larus.audio.ttsV2.TtsClientServiceNoop;
import com.larus.audio.ttsV2.TtsGuideServiceNoop;
import com.larus.avlink.api.DefaultDoraGResourceServiceImpl;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceNoop;
import com.larus.bmhome.audio.RealtimeCallServiceNoop;
import com.larus.bmhome.auth.LaunchCacheServiceNoop;
import com.larus.bmhome.auth.LaunchMetricServiceNoop;
import com.larus.bmhome.auth.feature_config.model.FeatureKitServiceNoop;
import com.larus.bmhome.bot.BotStatusCacheServiceNoop;
import com.larus.bmhome.chat.api.AiChatTraceServiceNoop;
import com.larus.bmhome.chat.api.AppreciableTraceServiceNoop;
import com.larus.bmhome.chat.api.AuthModelServiceNoop;
import com.larus.bmhome.chat.api.BotInfoCacheServiceNoop;
import com.larus.bmhome.chat.api.MultimodalTraceServiceNoop;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationClickServiceNoop;
import com.larus.bmhome.chat.input.ChatInputServiceNoop;
import com.larus.bmhome.chat.model.repo.BotRepoServiceNoop;
import com.larus.bmhome.chat.model.repo.ChatRepoServiceNoop;
import com.larus.bmhome.chat.model.repo.ConversationRepoServiceNoop;
import com.larus.bmhome.chat.model.repo.RepoDispatcherServiceNoop;
import com.larus.bmhome.chat.model.repo.SettingRepoServiceNoop;
import com.larus.bmhome.chat.require.MainBotServiceNoop;
import com.larus.bmhome.chat.service.MainBotCommonServiceNoop;
import com.larus.bmhome.chat.setting.UserSettingCacheServiceNoop;
import com.larus.bmhome.chat.standarduikit.StandardUiKitServiceNoop;
import com.larus.bmhome.chat.tips.GuideTipsServiceNoop;
import com.larus.bmhome.collection.CollectionReportNoop;
import com.larus.bmhome.input.api.EnterKeyBehaviorHostServiceNoop;
import com.larus.bmhome.input.api.officemention.OfficeMentionServiceNoop;
import com.larus.bmhome.larkinput.api.host.LarkInputHostServiceNoop;
import com.larus.bmhome.larkinput.api.service.LarkInputServiceNoop;
import com.larus.bmhome.nestedfile.NestFileServiceNoop;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerServiceNoop;
import com.larus.bmhome.setting.FragmentProviderNoop;
import com.larus.bmhome.share.api.ShareRuntimeServiceNoop;
import com.larus.bmhome.taskskill.service.SkillServiceNoop;
import com.larus.bmhome.utils.LandingRedBadgeHelperNoop;
import com.larus.bmhome.utils.LaunchLandingConfigHelperNoop;
import com.larus.bootprotector.DefaultBootProtectorProcessDiff;
import com.larus.business.debug.api.audit.DefaultOpenAuditOfflineServiceImpl;
import com.larus.camera.contract.DefultCameraServiceImpl;
import com.larus.canvas.service.CanvasRepoServiceNoop;
import com.larus.canvas.service.CanvasServiceNoop;
import com.larus.chat.gallery.api.ChatGalleryServiceNoop;
import com.larus.chat.search.api.SdkSearchServiceNoop;
import com.larus.chat.search.api.SearchSectionExternalServiceNoop;
import com.larus.common.venue.api.FlowCommonVenueServiceNoop;
import com.larus.contextwindow.api.ContextWindowUsageServiceNoop;
import com.larus.dora.api.DefaultByteCastManagerImpl;
import com.larus.dora.api.DefaultObricEnvAuthSheetService;
import com.larus.dora.impl.assistant.DefaultAssistantWifiService;
import com.larus.dora.o.api.DefaultDoraODiaryService;
import com.larus.dora.o.api.DefaultDoraOHealthService;
import com.larus.dora.o.api.DefaultDoraOUIService;
import com.larus.extension.account_auth.api.FlowAccountAuthServiceNoop;
import com.larus.extension.aggregate_search_ui.api.AggregateSearchUiServiceNoop;
import com.larus.extension.diversion.api.DiversionConfigNoop;
import com.larus.extension.diversion.api.DiversionImplServiceNoop;
import com.larus.extension.diversion.api.HostDiversionServiceNoop;
import com.larus.extension.offline_message.api.OfflineMessageConfigNoop;
import com.larus.extension.offline_message.api.OfflineMessageServiceNoop;
import com.larus.extension.summary_card.api.SummaryCardConfigNoop;
import com.larus.extension.summary_card.api.SummaryCardServiceNoop;
import com.larus.feedback.api.FlowFeedbackServiceNoop;
import com.larus.instruction.service.InstructionServiceNoop;
import com.larus.mirabridge.api.pluginservice.DoraPluginDefaultService;
import com.larus.mirabridge.api.pluginservice.TTOfficePluginDefaultService;
import com.larus.office.card.doc.content.OfficeCardDocContentServiceNoop;
import com.larus.office.card.doc.create.OfficeCardDocCreateServiceNoop;
import com.larus.office.card.doc.download.OfficeCardDocDownloadServiceNoop;
import com.larus.office.card.sheet.download.OfficeCardSheetDownloadServiceNoop;
import com.larus.office.card.urlpreview.OfficeHtmlFileDownloadServiceNoop;
import com.larus.office.card.urlpreview.OfficeUrlPreviewActionInterceptorProviderNoop;
import com.larus.platform.ObricMessageExtServiceNoop;
import com.larus.platform.api.BtmHostDependencyNoop;
import com.larus.platform.api.DefaultPermissionHelperImpl;
import com.larus.platform.api.DefaultSdkTitleBarInflateImpl;
import com.larus.platform.api.SdkVideoFeedServiceNoop;
import com.larus.platform.api.creation.BachDetectCenterAbilityNoop;
import com.larus.platform.api.creation.BachServiceNoop;
import com.larus.platform.audit.DefaultFlowBehaviorAuditServiceImpl;
import com.larus.platform.model.video.business.VideoArticleProviderNoop;
import com.larus.platform.model.video.business.VideoFeedProviderNoop;
import com.larus.platform.spi.AIChatAudioServiceNoop;
import com.larus.platform.spi.AIChatControlTraceServiceNoop;
import com.larus.platform.spi.AIChatRenderTraceServiceNoop;
import com.larus.platform.spi.AIChatServiceNoop;
import com.larus.platform.spi.AIChatTtsPlayTraceServiceNoop;
import com.larus.platform.spi.AIChatUgcAIGCServiceNoop;
import com.larus.platform.spi.AIChatUploadMediaServiceNoop;
import com.larus.receive.contract.DefaultReceiveCustomDiffImpl;
import com.larus.receive.contract.DefaultReceiveTextDiffImpl;
import com.larus.share.impl.panel.SharePanelServiceNoop;
import com.larus.share.service.DefaultShareOfficeDocService;
import com.larus.share.service.ShareServiceNoop;
import com.larus.share.service.ShareShortUrlCreateServiceNoop;
import com.larus.tts.ChatTtsServiceNoop;
import com.larus.tts.UserSettingRepoServiceNoop;
import com.larus.uaigc.applet.IAICreationAppletHostServiceNoop;
import com.larus.uaigc.applet.IAICreationAppletPageProviderNoop;
import com.larus.uaigc.applet.IMusicAppletHostServiceNoop;
import com.larus.uaigc.applet.IMusicAppletPageProviderNoop;
import com.larus.uaigc.creation.CreationServiceNoop;
import com.larus.uaigc.service.ICreationAiEditServiceNoop;
import com.larus.uaigc.service.ICreationAppletDetailProviderNoop;
import com.larus.uaigc.service.ICreationAppletProfileProviderNoop;
import com.larus.uaigc.service.ICreationAttachmentServiceNoop;
import com.larus.uaigc.service.ICreationAvatarServiceNoop;
import com.larus.uaigc.service.ICreationDetailImageEditServiceNoop;
import com.larus.uaigc.service.ICreationInstructionServiceNoop;
import com.larus.uaigc.service.ICreationMetadataServiceNoop;
import com.larus.uaigc.service.ICreationNotifyServiceNoop;
import com.larus.uaigc.service.ICreationReportServiceNoop;
import com.larus.uaigc.service.ICreationResourceAccessServiceNoop;
import com.larus.uaigc.service.ICreationSaveServiceNoop;
import com.larus.uaigc.service.ICreationShareServiceNoop;
import com.larus.uaigc.service.ICreationSpringVenueServiceNoop;
import com.larus.uaigc.service.ICreationUploadPolicyServiceNoop;
import com.larus.uaigc.service.ICreationWorkflowServiceNoop;
import com.larus.uaigc.service.IUgcAIGCServiceNoop;
import com.larus.uaigc.service.IZLotteryServiceNoop;
import com.larus.voicecall.api.VoiceCallConfigServiceNoop;
import com.larus.voicecall.api.VoiceCallServiceNoop;
import com.larus.voicecall.obric.ObricRealtimeCallServiceNoop;
import com.obric.assistant.common.spi.DefaultFeatureServiceImpl;
import com.obric.assistant.common.spi.DefaultObricConfigService;
import com.obric.assistant.common.spi.DefaultObricContextService;
import com.obric.assistant.common.spi.DefaultObricEnvService;
import com.obric.assistant.common.spi.DefaultObricSlardarConfigService;
import com.obric.assistant.common.spi.DefaultObricUIService;
import com.obric.assistant.common.spi.alog.DefaultObricAlogServiceImpl;
import com.obric.assistant.common.spi.interaction.DefaultObricMessagePopupServiceImpl;
import com.obric.assistant.common.spi.network.DefaultObricBackgroundNetworkBlockServiceImpl;
import com.obric.assistant.common.spi.network.DefaultObricSecurityNetworkServiceImpl;
import com.obric.assistant.common.spi.network.DefaultObricTTNetMonitorHookServiceImpl;
import com.obric.assistant.common.spi.security.DefaultSecurityServiceImpl;
import com.obric.assistant.common.spi.settings.DefaultObricSettingRequestServiceImpl;
import com.obric.assistant.common.spi.toast.DefaultToastHelper;
import com.obric.assistant.extraparam.ObricExtraParamImpl;
import com.obric.assistant.network.ObricHttpConst;
import com.obric.assistant.onelogin.ObricOneLoginDowngradeImpl;
import com.obric.assistant.privacy.ObricPrivacyDowngradeService;
import com.obric.assistant.spi.account.DefaultObricAccountSPIServiceImpl;
import com.obric.assistant.spi.account.DefaultObricXttTokenSyncServiceImpl;
import com.obric.assistant.spi.actionbar.DefaultObricActionBarSendService;
import com.obric.assistant.spi.actionbar.DefaultObricActionBarTrackServiceImpl;
import com.obric.assistant.spi.app.DefaultAppServiceImpl;
import com.obric.assistant.spi.app.DefaultLaunchServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricAsrServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricBackTraceLogServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricContinuousTalkServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricEnrollInteropServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricEnrollTraceParamServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricMmtVideoSettingsService;
import com.obric.assistant.spi.audio.DefaultObricTtsControlServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricVadServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricWakeupAudioCaptureServiceImpl;
import com.obric.assistant.spi.audio.DefaultObricWakeupTruthUploadServiceImpl;
import com.obric.assistant.spi.audio.DefaultRealtimeCallExtServiceImpl;
import com.obric.assistant.spi.bootprotector.DefaultObricBootProtectorSPIService;
import com.obric.assistant.spi.canvas.DefaultObricCanvasService;
import com.obric.assistant.spi.chat.DebugObricChatMessageBgService;
import com.obric.assistant.spi.chat.DefaultObricChatSPIServiceImpl;
import com.obric.assistant.spi.chat.DefaultObricChatUIServiceImpl;
import com.obric.assistant.spi.chat.DefaultObricInteractionServiceImpl;
import com.obric.assistant.spi.chat.DefaultReceiveStreamMessageTypeOverriderImpl;
import com.obric.assistant.spi.common.DefaultObricUtilServiceImpl;
import com.obric.assistant.spi.complextask.DefaultComplexTaskServiceImpl;
import com.obric.assistant.spi.debug.DefaultObicCommonDebugService;
import com.obric.assistant.spi.debug.DefaultObricDebugEnvConfigSPIServiceImpl;
import com.obric.assistant.spi.dora.DefaultDoraWakeupService;
import com.obric.assistant.spi.dora.DefaultObricDoraServiceImpl;
import com.obric.assistant.spi.dora.DefaultObricVendorBluetoothQueryServiceImpl;
import com.obric.assistant.spi.dora.DefaultVendorPrivateLinkServiceImpl;
import com.obric.assistant.spi.essentialtask.DefaultObricEssentialTaskServiceImpl;
import com.obric.assistant.spi.feedback.DefaultFeedbackServiceImpl;
import com.obric.assistant.spi.feedback.DefaultObricFeedbackPanelService;
import com.obric.assistant.spi.home.DefaultObricBottomTabSPIServiceImpl;
import com.obric.assistant.spi.interact.DefaultInteractServiceImpl;
import com.obric.assistant.spi.keyguard.DefaultKeyguardServiceImpl;
import com.obric.assistant.spi.launch.DefaultObricLazyInitSettingsService;
import com.obric.assistant.spi.login.DefaultObricLoginServiceImpl;
import com.obric.assistant.spi.markdown.DefaultObricMarkdownResolverServiceImpl;
import com.obric.assistant.spi.mediaplay.DefaultMediaPlayStateChangeListenerImpl;
import com.obric.assistant.spi.message.DefaultObricForegroundWidgetSyncService;
import com.obric.assistant.spi.message.DefaultObricMessageService;
import com.obric.assistant.spi.miniapp.DefaultObricIntentWidgetPolicy;
import com.obric.assistant.spi.notification.DefaultObricNotificationIslandServiceImpl;
import com.obric.assistant.spi.notification.DefaultObricNotificationListenerServiceImpl;
import com.obric.assistant.spi.office.DefaultOfficeSdkLazyInitService;
import com.obric.assistant.spi.office.DefaultOfficeSdkLazyInitSettingsService;
import com.obric.assistant.spi.performance.DefaultObricMemoryReportSPIService;
import com.obric.assistant.spi.push.DefaultObricPushConfigServiceImpl;
import com.obric.assistant.spi.router.DefaultRouterServiceImpl;
import com.obric.assistant.spi.rtc.DefaultObricRtcService;
import com.obric.assistant.spi.rtc.DefaultRTCCameraConfigService;
import com.obric.assistant.spi.security.minormode.DefaultObricMinorModeServiceImpl;
import com.obric.assistant.spi.security.privacypermission.DefaultObricPrivacyAndPermissionUiServiceImpl;
import com.obric.assistant.spi.share.DefaultShareChannelExtraConfigurator;
import com.obric.assistant.spi.share.DefaultShareKeyConfigService;
import com.obric.assistant.spi.startup.DefaultAssistantStartupTelemetry;
import com.obric.assistant.spi.task.DefaultObricTaskSkillService;
import com.obric.assistant.spi.training.DefaultObricPrivacyModelTrainingService;
import com.obric.assistant.spi.update.DefaultObricUpdateSPIServiceImpl;
import com.obric.assistant.spi.wakeup.DefaultOneshotServiceImpl;
import com.obric.assistant.spi.wakeup.DefaultWakeupLatencyTrackServiceImpl;
import com.obric.assistant.spi.window.DefaultChatWindowServiceImpl;
import com.obric.assistant.spi.zeus.DefaultObricZeusServiceImpl;
import com.obric.assistant.storage.DefaultObricLowStorageServiceImpl;
import com.obric.assistant.zeus.plugin.DefaultObricMigrationHandler;
import com.ss.android.ugc.aweme.framework.services.dyext.impl.AsyncServiceDefaultImpl;
import com.ss.android.ugc.aweme.framework.services.dyext.impl.LoadPluginDefaultImpl;
import com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility;
import com.ss.android.ugc.quota.BDNetworkTagConfigDefault;
import com.ss.android.ugc.route_monitor.api.RouteLazyConfigEmptyImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class DowngradeImplManager {
    final Map<String, String> componentsMap;
    final Set<String> downgradeComponents;
    private Map<String, ServiceProvider> downgradeImplMap;
    private Map<String, Object> staticDowngradeImplCache;
    final Set<String> staticDowngradeNotExistSet;

    public static class SingleInstanceHolder {
        private static final DowngradeImplManager INSTANCE = null;

        private SingleInstanceHolder() {
        }

        static {
            INSTANCE = new DowngradeImplManager();
        }

        public static /* synthetic */ DowngradeImplManager access$000() {
            return INSTANCE;
        }
    }

    public DowngradeImplManager() {
        this.downgradeImplMap = new ConcurrentHashMap();
        this.staticDowngradeImplCache = new ConcurrentHashMap();
        this.componentsMap = new ConcurrentHashMap();
        this.downgradeComponents = Collections.synchronizedSet(new HashSet());
        this.staticDowngradeNotExistSet = Collections.synchronizedSet(new HashSet());
        addServiceComponent("com.larus.apm.api.IExtraParams", "IExtraParams");
        addServiceComponent("com.obric.assistant.onelogin.IObricOneLogin", "IObricOneLogin");
        addServiceComponent("com.larus.network.IHttpConst", "IHttpConst");
        addServiceComponent("com.obric.assistant.spi.training.IObricPrivacyModelTrainingService", "ICustomPrivacyModelTrainingService");
        addServiceComponent("com.larus.home.api.privacy.ICustomPrivacyService", "ICustomPrivacyService");
    }

    public static DowngradeImplManager getInstance() {
        return SingleInstanceHolder.access$000();
    }

    private <T> T getStaticDowngradeImpl(Class<T> r3) {
        switch(r3.getName().hashCode()) {
            case -2086116425: goto L1046;
            case -2051754747: goto L1042;
            case -2029332183: goto L1038;
            case -2002071954: goto L1034;
            case -1994632656: goto L1030;
            case -1987141669: goto L1026;
            case -1980112181: goto L1022;
            case -1971258211: goto L1018;
            case -1891048851: goto L1014;
            case -1865321834: goto L1010;
            case -1862270395: goto L1006;
            case -1859502304: goto L1002;
            case -1856311186: goto L998;
            case -1808983014: goto L994;
            case -1788325683: goto L990;
            case -1787949654: goto L986;
            case -1787177589: goto L982;
            case -1772930888: goto L978;
            case -1770660597: goto L974;
            case -1758245390: goto L970;
            case -1748441402: goto L966;
            case -1742279710: goto L962;
            case -1730623406: goto L958;
            case -1689796830: goto L954;
            case -1646146182: goto L950;
            case -1646057095: goto L946;
            case -1642343718: goto L942;
            case -1632748644: goto L938;
            case -1614766624: goto L934;
            case -1568323663: goto L930;
            case -1566623059: goto L926;
            case -1562927334: goto L922;
            case -1549499957: goto L918;
            case -1546470126: goto L914;
            case -1534475755: goto L910;
            case -1532634484: goto L906;
            case -1521688678: goto L902;
            case -1508076299: goto L898;
            case -1486015631: goto L894;
            case -1485737841: goto L890;
            case -1484749994: goto L886;
            case -1481674212: goto L882;
            case -1474703842: goto L878;
            case -1427953845: goto L874;
            case -1420487376: goto L870;
            case -1388130943: goto L866;
            case -1364971920: goto L862;
            case -1334000955: goto L858;
            case -1327493745: goto L854;
            case -1317882728: goto L850;
            case -1290446764: goto L846;
            case -1267804418: goto L842;
            case -1267374852: goto L838;
            case -1262175347: goto L834;
            case -1233363435: goto L830;
            case -1207459585: goto L826;
            case -1205437563: goto L822;
            case -1179030023: goto L818;
            case -1179020113: goto L814;
            case -1177536076: goto L810;
            case -1172929124: goto L806;
            case -1154027116: goto L802;
            case -1105721093: goto L798;
            case -1099868708: goto L794;
            case -1092373153: goto L790;
            case -1077200566: goto L786;
            case -1074333559: goto L782;
            case -1066186536: goto L778;
            case -1065737689: goto L774;
            case -1058467059: goto L770;
            case -1052601877: goto L766;
            case -1037756562: goto L762;
            case -1012848786: goto L758;
            case -973789449: goto L754;
            case -972367967: goto L750;
            case -953429453: goto L746;
            case -949279935: goto L742;
            case -936687621: goto L738;
            case -926706298: goto L734;
            case -920697538: goto L730;
            case -898103695: goto L726;
            case -887614667: goto L722;
            case -868374699: goto L718;
            case -861799206: goto L714;
            case -843178546: goto L710;
            case -838416547: goto L706;
            case -828329002: goto L702;
            case -819602143: goto L698;
            case -791736954: goto L694;
            case -770192981: goto L690;
            case -767436525: goto L686;
            case -744327845: goto L682;
            case -717415349: goto L678;
            case -703329023: goto L674;
            case -699329961: goto L670;
            case -697686902: goto L666;
            case -696046478: goto L662;
            case -686103597: goto L658;
            case -625937929: goto L654;
            case -618108667: goto L650;
            case -612860388: goto L646;
            case -594196599: goto L642;
            case -593290696: goto L638;
            case -582776969: goto L634;
            case -571933918: goto L630;
            case -570979083: goto L626;
            case -543321814: goto L622;
            case -539725956: goto L618;
            case -538369605: goto L614;
            case -520691330: goto L610;
            case -520612502: goto L606;
            case -509975298: goto L602;
            case -480909286: goto L598;
            case -428685136: goto L594;
            case -402458327: goto L590;
            case -379246765: goto L586;
            case -349004789: goto L582;
            case -348067463: goto L578;
            case -325929818: goto L574;
            case -310298759: goto L570;
            case -272000052: goto L566;
            case -268569559: goto L562;
            case -267815326: goto L558;
            case -265451667: goto L554;
            case -265280401: goto L550;
            case -222956560: goto L546;
            case -207547325: goto L542;
            case -191462075: goto L538;
            case -173009607: goto L534;
            case -166380543: goto L530;
            case -158863879: goto L526;
            case -113221722: goto L522;
            case -59265275: goto L518;
            case -44462226: goto L514;
            case 3709278: goto L510;
            case 14783547: goto L506;
            case 26004728: goto L502;
            case 39042808: goto L498;
            case 42993889: goto L494;
            case 104277105: goto L490;
            case 124117792: goto L486;
            case 128932886: goto L482;
            case 165097319: goto L478;
            case 174990420: goto L474;
            case 182428856: goto L470;
            case 193339506: goto L466;
            case 195663544: goto L462;
            case 207350110: goto L458;
            case 215550315: goto L454;
            case 217420996: goto L450;
            case 225036552: goto L446;
            case 270607638: goto L442;
            case 306185555: goto L438;
            case 318001712: goto L434;
            case 320619603: goto L430;
            case 359285192: goto L426;
            case 368745660: goto L422;
            case 425048167: goto L418;
            case 434654738: goto L414;
            case 437708184: goto L410;
            case 477254501: goto L406;
            case 512942821: goto L402;
            case 531551531: goto L398;
            case 547769267: goto L394;
            case 557789413: goto L390;
            case 567859681: goto L386;
            case 579723823: goto L382;
            case 624888608: goto L378;
            case 642369832: goto L374;
            case 659624553: goto L370;
            case 671802834: goto L366;
            case 678606883: goto L362;
            case 682082159: goto L358;
            case 715181266: goto L354;
            case 733609894: goto L350;
            case 740422859: goto L346;
            case 746141940: goto L342;
            case 765027543: goto L338;
            case 793314947: goto L334;
            case 800642807: goto L330;
            case 811558270: goto L326;
            case 823090321: goto L322;
            case 825320480: goto L318;
            case 826186266: goto L314;
            case 851785726: goto L310;
            case 852138760: goto L306;
            case 882340970: goto L302;
            case 884171435: goto L298;
            case 922519942: goto L294;
            case 954576646: goto L290;
            case 959368139: goto L286;
            case 963281079: goto L282;
            case 990077711: goto L278;
            case 992898896: goto L274;
            case 1035011924: goto L270;
            case 1035105509: goto L266;
            case 1050591241: goto L262;
            case 1053771019: goto L258;
            case 1054965772: goto L254;
            case 1076512045: goto L250;
            case 1100422327: goto L246;
            case 1102306945: goto L242;
            case 1123896552: goto L238;
            case 1124973035: goto L234;
            case 1130041843: goto L230;
            case 1140532268: goto L226;
            case 1151578439: goto L222;
            case 1159930051: goto L218;
            case 1211501904: goto L214;
            case 1216150238: goto L210;
            case 1217768893: goto L206;
            case 1225765567: goto L202;
            case 1239487704: goto L198;
            case 1246571793: goto L194;
            case 1247384202: goto L190;
            case 1254468849: goto L186;
            case 1288011390: goto L182;
            case 1309034040: goto L178;
            case 1366600008: goto L174;
            case 1406324460: goto L170;
            case 1408365504: goto L166;
            case 1429207223: goto L162;
            case 1430409564: goto L158;
            case 1431710924: goto L154;
            case 1450665400: goto L150;
            case 1474927623: goto L146;
            case 1476771971: goto L142;
            case 1497196213: goto L138;
            case 1515762939: goto L134;
            case 1535158852: goto L130;
            case 1535351334: goto L126;
            case 1548625678: goto L122;
            case 1557505142: goto L118;
            case 1638510252: goto L114;
            case 1666866494: goto L110;
            case 1678211149: goto L106;
            case 1678604719: goto L102;
            case 1698137442: goto L98;
            case 1719360859: goto L94;
            case 1720079129: goto L90;
            case 1738596336: goto L86;
            case 1740450882: goto L82;
            case 1771368059: goto L78;
            case 1774753789: goto L74;
            case 1790875022: goto L70;
            case 1871290568: goto L66;
            case 1879139593: goto L62;
            case 1883144456: goto L58;
            case 1889205363: goto L54;
            case 1923297687: goto L50;
            case 1924369694: goto L46;
            case 1940384524: goto L42;
            case 1943721102: goto L38;
            case 1987262224: goto L34;
            case 1998453055: goto L30;
            case 2029515145: goto L26;
            case 2044149834: goto L22;
            case 2074674829: goto L18;
            case 2077453872: goto L14;
            case 2098293800: goto L10;
            case 2136826694: goto L6;
            default: goto L1049;
        };
    L1049:
        this.staticDowngradeNotExistSet.add(r3.getName());
        return null;
    L6:
        if (r3.getName().equals("com.larus.office.card.doc.download.IOfficeCardDocDownloadService") == false) goto L1049;
        T r4 = (T) new OfficeCardDocDownloadServiceNoop();
        putStaticDowngradeImplCache("com.larus.office.card.doc.download.IOfficeCardDocDownloadService", r4);
        return r4;
    L10:
        if (r3.getName().equals("com.larus.share.service.IShareShortUrlCreateService") == false) goto L1049;
        T r5 = (T) new ShareShortUrlCreateServiceNoop();
        putStaticDowngradeImplCache("com.larus.share.service.IShareShortUrlCreateService", r5);
        return r5;
    L14:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricConfigService") == false) goto L1049;
        T r6 = (T) new DefaultObricConfigService();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.IObricConfigService", r6);
        return r6;
    L18:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationSpringVenueService") == false) goto L1049;
        T r7 = (T) new ICreationSpringVenueServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationSpringVenueService", r7);
        return r7;
    L22:
        if (r3.getName().equals("com.obric.assistant.common.spi.network.IObricSecurityNetworkService") == false) goto L1049;
        T r8 = (T) new DefaultObricSecurityNetworkServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.network.IObricSecurityNetworkService", r8);
        return r8;
    L26:
        if (r3.getName().equals("com.larus.audio.ttsV2.ITtsClientService") == false) goto L1049;
        T r9 = (T) new TtsClientServiceNoop();
        putStaticDowngradeImplCache("com.larus.audio.ttsV2.ITtsClientService", r9);
        return r9;
    L30:
        if (r3.getName().equals("com.larus.bmhome.audio.IRealtimeCallService") == false) goto L1049;
        T r10 = (T) new RealtimeCallServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.audio.IRealtimeCallService", r10);
        return r10;
    L34:
        if (r3.getName().equals("com.larus.share.impl.panel.ISharePanelService") == false) goto L1049;
        T r11 = (T) new SharePanelServiceNoop();
        putStaticDowngradeImplCache("com.larus.share.impl.panel.ISharePanelService", r11);
        return r11;
    L38:
        if (r3.getName().equals("com.obric.assistant.spi.window.IChatWindowService") == false) goto L1049;
        T r12 = (T) new DefaultChatWindowServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.window.IChatWindowService", r12);
        return r12;
    L42:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatUgcAIGCService") == false) goto L1049;
        T r13 = (T) new AIChatUgcAIGCServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatUgcAIGCService", r13);
        return r13;
    L46:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationSaveService") == false) goto L1049;
        T r14 = (T) new ICreationSaveServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationSaveService", r14);
        return r14;
    L50:
        if (r3.getName().equals("com.obric.assistant.spi.notification.IObricNotificationListenerService") == false) goto L1049;
        T r15 = (T) new DefaultObricNotificationListenerServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.notification.IObricNotificationListenerService", r15);
        return r15;
    L54:
        if (r3.getName().equals("com.obric.assistant.spi.update.IObricUpdateSPIService") == false) goto L1049;
        T r16 = (T) new DefaultObricUpdateSPIServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.update.IObricUpdateSPIService", r16);
        return r16;
    L58:
        if (r3.getName().equals("com.larus.bmhome.setting.IFragmentProvider") == false) goto L1049;
        T r17 = (T) new FragmentProviderNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.setting.IFragmentProvider", r17);
        return r17;
    L62:
        if (r3.getName().equals("com.larus.extension.offline_message.api.IOfflineMessageConfig") == false) goto L1049;
        T r18 = (T) new OfflineMessageConfigNoop();
        putStaticDowngradeImplCache("com.larus.extension.offline_message.api.IOfflineMessageConfig", r18);
        return r18;
    L66:
        if (r3.getName().equals("com.obric.assistant.spi.message.IObricForegroundWidgetSyncService") == false) goto L1049;
        T r19 = (T) new DefaultObricForegroundWidgetSyncService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.message.IObricForegroundWidgetSyncService", r19);
        return r19;
    L70:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoBrightCallbackAPI") == false) goto L1049;
        T r20 = (T) new VideoBrightCallBackAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoBrightCallbackAPI", r20);
        return r20;
    L74:
        if (r3.getName().equals("com.obric.assistant.spi.security.minormode.IObricMinorModeService") == false) goto L1049;
        T r21 = (T) new DefaultObricMinorModeServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.security.minormode.IObricMinorModeService", r21);
        return r21;
    L78:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSRLutAPI") == false) goto L1049;
        T r22 = (T) new VideoSRLutAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSRLutAPI", r22);
        return r22;
    L82:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAvatarService") == false) goto L1049;
        T r23 = (T) new ICreationAvatarServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationAvatarService", r23);
        return r23;
    L86:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.MotionSenseAPI") == false) goto L1049;
        T r24 = (T) new MotionSenseAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.MotionSenseAPI", r24);
        return r24;
    L90:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.ILogger") == false) goto L1049;
        T r25 = (T) new AndroidLoggerImpl();
        putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.ILogger", r25);
        return r25;
    L94:
        if (r3.getName().equals("com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService") == false) goto L1049;
        T r26 = (T) new DefaultOfficeSdkLazyInitSettingsService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService", r26);
        return r26;
    L98:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricFeatureService") == false) goto L1049;
        T r28 = (T) new DefaultFeatureServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.IObricFeatureService", r28);
        return r28;
    L102:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.DenoiseAPI") == false) goto L1049;
        T r29 = (T) new DenoiseAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.DenoiseAPI", r29);
        return r29;
    L106:
        if (r3.getName().equals("com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService") == false) goto L1049;
        T r30 = (T) new RichMediaCreationClickServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService", r30);
        return r30;
    L110:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricUIService") == false) goto L1049;
        T r31 = (T) new DefaultObricUIService();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.IObricUIService", r31);
        return r31;
    L114:
        if (r3.getName().equals("com.larus.tts.IUserSettingRepoService") == false) goto L1049;
        T r32 = (T) new UserSettingRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.tts.IUserSettingRepoService", r32);
        return r32;
    L118:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAppletDetailProvider") == false) goto L1049;
        T r33 = (T) new ICreationAppletDetailProviderNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationAppletDetailProvider", r33);
        return r33;
    L122:
        if (r3.getName().equals("com.larus.dora.o.api.IDoraOUIService") == false) goto L1049;
        T r34 = (T) new DefaultDoraOUIService();
        putStaticDowngradeImplCache("com.larus.dora.o.api.IDoraOUIService", r34);
        return r34;
    L126:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAppletProfileProvider") == false) goto L1049;
        T r35 = (T) new ICreationAppletProfileProviderNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationAppletProfileProvider", r35);
        return r35;
    L130:
        if (r3.getName().equals("com.obric.assistant.spi.debug.IObricDebugEnvConfigSPIService") == false) goto L1049;
        T r36 = (T) new DefaultObricDebugEnvConfigSPIServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.debug.IObricDebugEnvConfigSPIService", r36);
        return r36;
    L134:
        if (r3.getName().equals("com.bytedance.ies.abmock.datacenter.init.IABMockInitConfig") == false) goto L1049;
        return (T) new ABMockInitConfigDefault();
    L138:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricInteractionService") == false) goto L1049;
        T r37 = (T) new DefaultObricInteractionServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.chat.IObricInteractionService", r37);
        return r37;
    L142:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ByteStreamHDCallbackAPI") == false) goto L1049;
        T r38 = (T) new ByteStreamHDCallbackAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.ByteStreamHDCallbackAPI", r38);
        return r38;
    L146:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationReportService") == false) goto L1049;
        T r39 = (T) new ICreationReportServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationReportService", r39);
        return r39;
    L150:
        if (r3.getName().equals("com.larus.audio.realtimecall.IRealtimeCallStrategy") == false) goto L1049;
        T r40 = (T) new RealtimeCallStrategyNoop();
        putStaticDowngradeImplCache("com.larus.audio.realtimecall.IRealtimeCallStrategy", r40);
        return r40;
    L154:
        if (r3.getName().equals("com.larus.platform.api.ISdkTitleBarInflate") == false) goto L1049;
        T r41 = (T) new DefaultSdkTitleBarInflateImpl();
        putStaticDowngradeImplCache("com.larus.platform.api.ISdkTitleBarInflate", r41);
        return r41;
    L158:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IConversationRepoService") == false) goto L1049;
        T r42 = (T) new ConversationRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.model.repo.IConversationRepoService", r42);
        return r42;
    L162:
        if (r3.getName().equals("com.larus.instruction.service.IInstructionService") == false) goto L1049;
        T r43 = (T) new InstructionServiceNoop();
        putStaticDowngradeImplCache("com.larus.instruction.service.IInstructionService", r43);
        return r43;
    L166:
        if (r3.getName().equals("com.larus.app.settings.api.IAppSettingsHostService") == false) goto L1049;
        T r44 = (T) new AppSettingsHostServiceNoop();
        putStaticDowngradeImplCache("com.larus.app.settings.api.IAppSettingsHostService", r44);
        return r44;
    L170:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.IAppLog") == false) goto L1049;
        T r45 = (T) new AppLogImpl();
        putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IAppLog", r45);
        return r45;
    L174:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationUploadPolicyService") == false) goto L1049;
        T r46 = (T) new ICreationUploadPolicyServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationUploadPolicyService", r46);
        return r46;
    L178:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.IStore") == false) goto L1049;
        T r47 = (T) new SPStoreImpl();
        putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IStore", r47);
        return r47;
    L182:
        if (r3.getName().equals("com.larus.bmhome.chat.standarduikit.IStandardUiKitService") == false) goto L1049;
        T r48 = (T) new StandardUiKitServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.standarduikit.IStandardUiKitService", r48);
        return r48;
    L186:
        if (r3.getName().equals("com.obric.assistant.spi.account.IObricAccountSPIService") == false) goto L1049;
        T r49 = (T) new DefaultObricAccountSPIServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.account.IObricAccountSPIService", r49);
        return r49;
    L190:
        if (r3.getName().equals("com.obric.assistant.spi.training.IObricPrivacyModelTrainingService") == false) goto L1049;
        T r50 = (T) new DefaultObricPrivacyModelTrainingService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.training.IObricPrivacyModelTrainingService", r50);
        return r50;
    L194:
        if (r3.getName().equals("com.obric.assistant.common.spi.interaction.IObricMessagePopupService") == false) goto L1049;
        T r51 = (T) new DefaultObricMessagePopupServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.interaction.IObricMessagePopupService", r51);
        return r51;
    L198:
        if (r3.getName().equals("com.larus.chat.search.api.ISdkSearchService") == false) goto L1049;
        T r52 = (T) new SdkSearchServiceNoop();
        putStaticDowngradeImplCache("com.larus.chat.search.api.ISdkSearchService", r52);
        return r52;
    L202:
        if (r3.getName().equals("com.larus.bmhome.larkinput.api.service.ILarkInputService") == false) goto L1049;
        T r53 = (T) new LarkInputServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.larkinput.api.service.ILarkInputService", r53);
        return r53;
    L206:
        if (r3.getName().equals("com.larus.receive.contract.IReceiveTextDiff") == false) goto L1049;
        T r54 = (T) new DefaultReceiveTextDiffImpl();
        putStaticDowngradeImplCache("com.larus.receive.contract.IReceiveTextDiff", r54);
        return r54;
    L210:
        if (r3.getName().equals("com.obric.assistant.spi.debug.IObicCommonDebugEntranceService") == false) goto L1049;
        T r55 = (T) new DefaultObicCommonDebugService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.debug.IObicCommonDebugEntranceService", r55);
        return r55;
    L214:
        if (r3.getName().equals("com.ss.android.ugc.aweme.framework.services.dyext.api.IAsyncService") == false) goto L1049;
        return (T) new AsyncServiceDefaultImpl();
    L218:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ColorHistAPI") == false) goto L1049;
        T r56 = (T) new ColorHistAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.ColorHistAPI", r56);
        return r56;
    L222:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IMultimodalTraceService") == false) goto L1049;
        T r57 = (T) new MultimodalTraceServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.api.IMultimodalTraceService", r57);
        return r57;
    L226:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationMetadataService") == false) goto L1049;
        T r58 = (T) new ICreationMetadataServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationMetadataService", r58);
        return r58;
    L230:
        if (r3.getName().equals("pv8.a") == false) goto L1049;
        T r59 = (T) new DefaultOpenAuditOfflineServiceImpl();
        putStaticDowngradeImplCache("com.larus.business.debug.api.audit.OpenAuditOfflineService", r59);
        return r59;
    L234:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatTtsPlayTraceService") == false) goto L1049;
        T r60 = (T) new AIChatTtsPlayTraceServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatTtsPlayTraceService", r60);
        return r60;
    L238:
        if (r3.getName().equals("com.larus.platform.api.creation.IBachService") == false) goto L1049;
        T r61 = (T) new BachServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.api.creation.IBachService", r61);
        return r61;
    L242:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatControlTraceService") == false) goto L1049;
        T r62 = (T) new AIChatControlTraceServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatControlTraceService", r62);
        return r62;
    L246:
        if (r3.getName().equals("com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService") == false) goto L1049;
        T r63 = (T) new DefaultObricBootProtectorSPIService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService", r63);
        return r63;
    L250:
        if (r3.getName().equals("com.larus.bmhome.auth.ILaunchCacheService") == false) goto L1049;
        T r64 = (T) new LaunchCacheServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.auth.ILaunchCacheService", r64);
        return r64;
    L254:
        if (r3.getName().equals("com.obric.assistant.onelogin.IObricOneLogin") == false) goto L1049;
        T r65 = (T) new ObricOneLoginDowngradeImpl();
        putStaticDowngradeImplCache("com.obric.assistant.onelogin.IObricOneLogin", r65);
        return r65;
    L258:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.NoiseDetectAPI") == false) goto L1049;
        T r66 = (T) new NoiseDetectAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseDetectAPI", r66);
        return r66;
    L262:
        if (r3.getName().equals("com.larus.voicecall.obric.IObricRealtimeCallService") == false) goto L1049;
        T r67 = (T) new ObricRealtimeCallServiceNoop();
        putStaticDowngradeImplCache("com.larus.voicecall.obric.IObricRealtimeCallService", r67);
        return r67;
    L266:
        if (r3.getName().equals("com.larus.dora.o.api.IDoraODiaryService") == false) goto L1049;
        T r68 = (T) new DefaultDoraODiaryService();
        putStaticDowngradeImplCache("com.larus.dora.o.api.IDoraODiaryService", r68);
        return r68;
    L270:
        if (r3.getName().equals("com.larus.bmhome.input.api.officemention.IOfficeMentionService") == false) goto L1049;
        T r69 = (T) new OfficeMentionServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.input.api.officemention.IOfficeMentionService", r69);
        return r69;
    L274:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IObricVendorPrivateLinkService") == false) goto L1049;
        T r70 = (T) new DefaultVendorPrivateLinkServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.dora.IObricVendorPrivateLinkService", r70);
        return r70;
    L278:
        if (r3.getName().equals("com.larus.bmhome.utils.ILandingRedBadgeHelper") == false) goto L1049;
        T r71 = (T) new LandingRedBadgeHelperNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.utils.ILandingRedBadgeHelper", r71);
        return r71;
    L282:
        if (r3.getName().equals("com.obric.assistant.spi.launch.IObricLazyInitSettingsService") == false) goto L1049;
        T r72 = (T) new DefaultObricLazyInitSettingsService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.launch.IObricLazyInitSettingsService", r72);
        return r72;
    L286:
        if (r3.getName().equals("com.larus.uaigc.service.IZLotteryService") == false) goto L1049;
        T r73 = (T) new IZLotteryServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.IZLotteryService", r73);
        return r73;
    L290:
        if (r3.getName().equals("com.bytedance.ies.ugc.aweme.network.NetworkCommonParams$INetworkCommonParams") == false) goto L1049;
        T r74 = (T) new NetworkCommonParams.Default();
        putStaticDowngradeImplCache("com.bytedance.ies.ugc.aweme.network.NetworkCommonParams$INetworkCommonParams", r74);
        return r74;
    L294:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.NoiseDetectCallbackAPI") == false) goto L1049;
        T r75 = (T) new NoiseDetectCallbackAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseDetectCallbackAPI", r75);
        return r75;
    L298:
        if (r3.getName().equals("com.obric.assistant.spi.zeus.IObricZeusService") == false) goto L1049;
        T r76 = (T) new DefaultObricZeusServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.zeus.IObricZeusService", r76);
        return r76;
    L302:
        if (r3.getName().equals("com.obric.assistant.common.spi.alog.IObricAlogService") == false) goto L1049;
        T r77 = (T) new DefaultObricAlogServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.alog.IObricAlogService", r77);
        return r77;
    L306:
        if (r3.getName().equals("com.obric.assistant.spi.home.IObricBottomTabSPIService") == false) goto L1049;
        T r78 = (T) new DefaultObricBottomTabSPIServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.home.IObricBottomTabSPIService", r78);
        return r78;
    L310:
        if (r3.getName().equals("com.obric.assistant.spi.office.IOfficeSdkLazyInitService") == false) goto L1049;
        T r79 = (T) new DefaultOfficeSdkLazyInitService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.office.IOfficeSdkLazyInitService", r79);
        return r79;
    L314:
        if (r3.getName().equals("com.larus.voicecall.api.IVoiceCallConfigService") == false) goto L1049;
        T r80 = (T) new VoiceCallConfigServiceNoop();
        putStaticDowngradeImplCache("com.larus.voicecall.api.IVoiceCallConfigService", r80);
        return r80;
    L318:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IBotRepoService") == false) goto L1049;
        T r81 = (T) new BotRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.model.repo.IBotRepoService", r81);
        return r81;
    L322:
        if (r3.getName().equals("com.ss.android.ugc.route_monitor.api.IRouteLazyConfig") == false) goto L1049;
        T r82 = (T) new RouteLazyConfigEmptyImpl();
        putStaticDowngradeImplCache("com.ss.android.ugc.route_monitor.api.IRouteLazyConfig", r82);
        return r82;
    L326:
        if (r3.getName().equals("com.obric.assistant.spi.rtc.IObricRTCCameraConfigService") == false) goto L1049;
        T r83 = (T) new DefaultRTCCameraConfigService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.rtc.IObricRTCCameraConfigService", r83);
        return r83;
    L330:
        if (r3.getName().equals("com.bytedance.timonbase.ITMLifecycleService") == false) goto L1049;
        T r84 = (T) new TimonLifecycleServiceDowngradeImp();
        putStaticDowngradeImplCache("com.bytedance.timonbase.ITMLifecycleService", r84);
        return r84;
    L334:
        if (r3.getName().equals("com.larus.canvas.service.ICanvasService") == false) goto L1049;
        T r85 = (T) new CanvasServiceNoop();
        putStaticDowngradeImplCache("com.larus.canvas.service.ICanvasService", r85);
        return r85;
    L338:
        if (r3.getName().equals("com.larus.share.service.IShareService") == false) goto L1049;
        T r86 = (T) new ShareServiceNoop();
        putStaticDowngradeImplCache("com.larus.share.service.IShareService", r86);
        return r86;
    L342:
        if (r3.getName().equals("com.obric.assistant.spi.common.IObricUtilService") == false) goto L1049;
        T r87 = (T) new DefaultObricUtilServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.common.IObricUtilService", r87);
        return r87;
    L346:
        if (r3.getName().equals("com.obric.assistant.spi.interact.IObricInteractService") == false) goto L1049;
        T r88 = (T) new DefaultInteractServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.interact.IObricInteractService", r88);
        return r88;
    L350:
        if (r3.getName().equals("com.larus.dora.o.api.IDoraOHealthService") == false) goto L1049;
        T r89 = (T) new DefaultDoraOHealthService();
        putStaticDowngradeImplCache("com.larus.dora.o.api.IDoraOHealthService", r89);
        return r89;
    L354:
        if (r3.getName().equals("com.larus.network.IHttpConst") == false) goto L1049;
        T r90 = (T) new ObricHttpConst();
        putStaticDowngradeImplCache("com.larus.network.IHttpConst", r90);
        return r90;
    L358:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI") == false) goto L1049;
        T r91 = (T) new VqscoreProcessCallbackAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI", r91);
        return r91;
    L362:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService") == false) goto L1049;
        T r92 = (T) new DefaultObricVendorBluetoothQueryServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService", r92);
        return r92;
    L366:
        if (r3.getName().equals("com.larus.common.venue.api.IFlowCommonVenueService") == false) goto L1049;
        T r93 = (T) new FlowCommonVenueServiceNoop();
        putStaticDowngradeImplCache("com.larus.common.venue.api.IFlowCommonVenueService", r93);
        return r93;
    L370:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationResourceAccessService") == false) goto L1049;
        T r94 = (T) new ICreationResourceAccessServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationResourceAccessService", r94);
        return r94;
    L374:
        if (r3.getName().equals("com.bytedance.ies.web.jsbridge2.IJsBridge2Config") == false) goto L1049;
        return (T) new JsBridge2ConfigDefault();
    L378:
        if (r3.getName().equals("com.obric.assistant.spi.wakeup.IObricOneshotService") == false) goto L1049;
        T r95 = (T) new DefaultOneshotServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.wakeup.IObricOneshotService", r95);
        return r95;
    L382:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricMmtVideoSettingsService") == false) goto L1049;
        T r96 = (T) new DefaultObricMmtVideoSettingsService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricMmtVideoSettingsService", r96);
        return r96;
    L386:
        if (r3.getName().equals("com.bytedance.dux.api.IDuxComponentService") == false) goto L1049;
        T r97 = (T) new DuxComponentServiceDefault();
        putStaticDowngradeImplCache("com.bytedance.dux.api.IDuxComponentService", r97);
        return r97;
    L390:
        if (r3.getName().equals("com.larus.dora.api.IByteCastManager") == false) goto L1049;
        T r98 = (T) new DefaultByteCastManagerImpl();
        putStaticDowngradeImplCache("com.larus.dora.api.IByteCastManager", r98);
        return r98;
    L394:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IDoraWakeupService") == false) goto L1049;
        T r99 = (T) new DefaultDoraWakeupService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.dora.IDoraWakeupService", r99);
        return r99;
    L398:
        if (r3.getName().equals("com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider") == false) goto L1049;
        T r100 = (T) new OfficeUrlPreviewActionInterceptorProviderNoop();
        putStaticDowngradeImplCache("com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider", r100);
        return r100;
    L402:
        if (r3.getName().equals("com.larus.platform.api.creation.IBachDetectCenterAbility") == false) goto L1049;
        T r101 = (T) new BachDetectCenterAbilityNoop();
        putStaticDowngradeImplCache("com.larus.platform.api.creation.IBachDetectCenterAbility", r101);
        return r101;
    L406:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VqscoreLiveAPI") == false) goto L1049;
        T r102 = (T) new VqscoreLiveAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VqscoreLiveAPI", r102);
        return r102;
    L410:
        if (r3.getName().equals("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService") == false) goto L1049;
        T r103 = (T) new RulerBusinessEmptyImpl();
        putStaticDowngradeImplCache("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService", r103);
        return r103;
    L414:
        if (r3.getName().equals("com.larus.chat.search.api.ISearchSectionExternalService") == false) goto L1049;
        T r104 = (T) new SearchSectionExternalServiceNoop();
        putStaticDowngradeImplCache("com.larus.chat.search.api.ISearchSectionExternalService", r104);
        return r104;
    L418:
        if (r3.getName().equals("com.larus.bmhome.input.api.IEnterKeyBehaviorHostService") == false) goto L1049;
        T r105 = (T) new EnterKeyBehaviorHostServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.input.api.IEnterKeyBehaviorHostService", r105);
        return r105;
    L422:
        if (r3.getName().equals("com.larus.agents.api.IOfficeTaskSettingsService") == false) goto L1049;
        T r106 = (T) new OfficeTaskSettingsServiceNoop();
        putStaticDowngradeImplCache("com.larus.agents.api.IOfficeTaskSettingsService", r106);
        return r106;
    L426:
        if (r3.getName().equals("com.larus.tts.IChatTtsService") == false) goto L1049;
        T r107 = (T) new ChatTtsServiceNoop();
        putStaticDowngradeImplCache("com.larus.tts.IChatTtsService", r107);
        return r107;
    L430:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatSPIService") == false) goto L1049;
        T r108 = (T) new DefaultObricChatSPIServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.chat.IObricChatSPIService", r108);
        return r108;
    L434:
        if (r3.getName().equals("com.ss.android.ugc.aweme.framework.services.dyext.api.ILoadPlugin") == false) goto L1049;
        return (T) new LoadPluginDefaultImpl();
    L438:
        if (r3.getName().equals("com.larus.dora.api.IObricEnvAuthSheetService") == false) goto L1049;
        T r109 = (T) new DefaultObricEnvAuthSheetService();
        putStaticDowngradeImplCache("com.larus.dora.api.IObricEnvAuthSheetService", r109);
        return r109;
    L442:
        if (r3.getName().equals("com.obric.assistant.spi.startup.IAssistantStartupTelemetry") == false) goto L1049;
        T r110 = (T) new DefaultAssistantStartupTelemetry();
        putStaticDowngradeImplCache("com.obric.assistant.spi.startup.IAssistantStartupTelemetry", r110);
        return r110;
    L446:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ByteStreamHDAPI") == false) goto L1049;
        T r111 = (T) new ByteStreamHDDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.ByteStreamHDAPI", r111);
        return r111;
    L450:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricWakeupTruthUploadService") == false) goto L1049;
        T r112 = (T) new DefaultObricWakeupTruthUploadServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricWakeupTruthUploadService", r112);
        return r112;
    L454:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricEnrollTraceParamService") == false) goto L1049;
        T r113 = (T) new DefaultObricEnrollTraceParamServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricEnrollTraceParamService", r113);
        return r113;
    L458:
        if (r3.getName().equals("com.larus.home.api.privacy.ICustomPrivacyService") == false) goto L1049;
        T r114 = (T) new ObricPrivacyDowngradeService();
        putStaticDowngradeImplCache("com.larus.home.api.privacy.ICustomPrivacyService", r114);
        return r114;
    L462:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IRepoDispatcherService") == false) goto L1049;
        T r115 = (T) new RepoDispatcherServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.model.repo.IRepoDispatcherService", r115);
        return r115;
    L466:
        if (r3.getName().equals("com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService") == false) goto L1049;
        T r116 = (T) new DefaultObricTTNetMonitorHookServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService", r116);
        return r116;
    L470:
        if (r3.getName().equals("com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService") == false) goto L1049;
        T r117 = (T) new OfficeCardSheetDownloadServiceNoop();
        putStaticDowngradeImplCache("com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService", r117);
        return r117;
    L474:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.IExceptionMonitor") == false) goto L1049;
        T r118 = (T) new ExceptionMonitorImpl();
        putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IExceptionMonitor", r118);
        return r118;
    L478:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IChatRepoService") == false) goto L1049;
        T r119 = (T) new ChatRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.model.repo.IChatRepoService", r119);
        return r119;
    L482:
        if (r3.getName().equals("com.larus.office.card.doc.content.IOfficeCardDocContentService") == false) goto L1049;
        T r120 = (T) new OfficeCardDocContentServiceNoop();
        putStaticDowngradeImplCache("com.larus.office.card.doc.content.IOfficeCardDocContentService", r120);
        return r120;
    L486:
        if (r3.getName().equals("com.obric.assistant.spi.performance.IObricMemoryReportSPIService") == false) goto L1049;
        T r121 = (T) new DefaultObricMemoryReportSPIService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.performance.IObricMemoryReportSPIService", r121);
        return r121;
    L490:
        if (r3.getName().equals("com.obric.assistant.spi.app.IObricLaunchService") == false) goto L1049;
        T r122 = (T) new DefaultLaunchServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.app.IObricLaunchService", r122);
        return r122;
    L494:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationInstructionService") == false) goto L1049;
        T r123 = (T) new ICreationInstructionServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationInstructionService", r123);
        return r123;
    L498:
        if (r3.getName().equals("com.bytedance.dux.api.IDuxEmojiService") == false) goto L1049;
        T r124 = (T) new DuxEmojiServiceDefault();
        putStaticDowngradeImplCache("com.bytedance.dux.api.IDuxEmojiService", r124);
        return r124;
    L502:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.HydraHDRAPI") == false) goto L1049;
        T r125 = (T) new HydraHDRAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.HydraHDRAPI", r125);
        return r125;
    L506:
        if (r3.getName().equals("com.larus.uaigc.service.IUgcAIGCService") == false) goto L1049;
        T r126 = (T) new IUgcAIGCServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.IUgcAIGCService", r126);
        return r126;
    L510:
        if (r3.getName().equals("com.larus.extension.summary_card.api.ISummaryCardService") == false) goto L1049;
        T r127 = (T) new SummaryCardServiceNoop();
        putStaticDowngradeImplCache("com.larus.extension.summary_card.api.ISummaryCardService", r127);
        return r127;
    L514:
        if (r3.getName().equals("com.obric.assistant.spi.task.IObricTaskSkillService") == false) goto L1049;
        T r128 = (T) new DefaultObricTaskSkillService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.task.IObricTaskSkillService", r128);
        return r128;
    L518:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IBotInfoCacheService") == false) goto L1049;
        T r129 = (T) new BotInfoCacheServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.api.IBotInfoCacheService", r129);
        return r129;
    L522:
        if (r3.getName().equals("com.larus.bmhome.chat.tips.IGuideTipsService") == false) goto L1049;
        T r130 = (T) new GuideTipsServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.tips.IGuideTipsService", r130);
        return r130;
    L526:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricRealtimeCallExtService") == false) goto L1049;
        T r131 = (T) new DefaultRealtimeCallExtServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricRealtimeCallExtService", r131);
        return r131;
    L530:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.SitiAPI") == false) goto L1049;
        T r132 = (T) new SitiAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.SitiAPI", r132);
        return r132;
    L534:
        if (r3.getName().equals("com.obric.assistant.storage.IObricLowStorageService") == false) goto L1049;
        T r133 = (T) new DefaultObricLowStorageServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.storage.IObricLowStorageService", r133);
        return r133;
    L538:
        if (r3.getName().equals("com.larus.bmhome.nestedfile.INestedFileCacheManagerService") == false) goto L1049;
        T r134 = (T) new NestedFileCacheManagerServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.nestedfile.INestedFileCacheManagerService", r134);
        return r134;
    L542:
        if (r3.getName().equals("com.larus.platform.api.IPermissionHelperApi") == false) goto L1049;
        T r135 = (T) new DefaultPermissionHelperImpl();
        putStaticDowngradeImplCache("com.larus.platform.api.IPermissionHelperApi", r135);
        return r135;
    L546:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationShareService") == false) goto L1049;
        T r136 = (T) new ICreationShareServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationShareService", r136);
        return r136;
    L550:
        if (r3.getName().equals("com.larus.bootprotector.IBootProtectorProcessDiff") == false) goto L1049;
        T r137 = (T) new DefaultBootProtectorProcessDiff();
        putStaticDowngradeImplCache("com.larus.bootprotector.IBootProtectorProcessDiff", r137);
        return r137;
    L554:
        if (r3.getName().equals("com.bytedance.dux.drawable.api.IDoubleColorInitConfigService") == false) goto L1049;
        T r138 = (T) new DoubleColorInitConfigServiceDefault();
        putStaticDowngradeImplCache("com.bytedance.dux.drawable.api.IDoubleColorInitConfigService", r138);
        return r138;
    L558:
        if (r3.getName().equals("com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService") == false) goto L1049;
        T r139 = (T) new DefaultObricPrivacyAndPermissionUiServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService", r139);
        return r139;
    L562:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.IEventMonitor") == false) goto L1049;
        T r140 = (T) new EventMonitorDowngradeImpl();
        putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IEventMonitor", r140);
        return r140;
    L566:
        if (r3.getName().equals("com.larus.bmhome.utils.ILaunchLandingConfigHelper") == false) goto L1049;
        T r141 = (T) new LaunchLandingConfigHelperNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.utils.ILaunchLandingConfigHelper", r141);
        return r141;
    L570:
        if (r3.getName().equals("com.larus.extension.summary_card.api.ISummaryCardConfig") == false) goto L1049;
        T r142 = (T) new SummaryCardConfigNoop();
        putStaticDowngradeImplCache("com.larus.extension.summary_card.api.ISummaryCardConfig", r142);
        return r142;
    L574:
        if (r3.getName().equals("com.obric.assistant.common.spi.toast.IToastHelper") == false) goto L1049;
        T r143 = (T) new DefaultToastHelper();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.toast.IToastHelper", r143);
        return r143;
    L578:
        if (r3.getName().equals("com.larus.mirabridge.api.pluginservice.IDoraPluginService") == false) goto L1049;
        T r144 = (T) new DoraPluginDefaultService();
        putStaticDowngradeImplCache("com.larus.mirabridge.api.pluginservice.IDoraPluginService", r144);
        return r144;
    L582:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricSlardarConfigService") == false) goto L1049;
        T r145 = (T) new DefaultObricSlardarConfigService();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.IObricSlardarConfigService", r145);
        return r145;
    L586:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAiChatTraceService") == false) goto L1049;
        T r146 = (T) new AiChatTraceServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.api.IAiChatTraceService", r146);
        return r146;
    L590:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAiEditService") == false) goto L1049;
        T r147 = (T) new ICreationAiEditServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationAiEditService", r147);
        return r147;
    L594:
        if (r3.getName().equals("com.larus.avlink.api.IDoraGResourceService") == false) goto L1049;
        T r148 = (T) new DefaultDoraGResourceServiceImpl();
        putStaticDowngradeImplCache("com.larus.avlink.api.IDoraGResourceService", r148);
        return r148;
    L598:
        if (r3.getName().equals("com.larus.bmhome.share.api.IShareRuntimeService") == false) goto L1049;
        T r149 = (T) new ShareRuntimeServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.share.api.IShareRuntimeService", r149);
        return r149;
    L602:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricContinuousTalkService") == false) goto L1049;
        T r150 = (T) new DefaultObricContinuousTalkServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricContinuousTalkService", r150);
        return r150;
    L606:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService") == false) goto L1049;
        T r151 = (T) new DefaultObricWakeupAudioCaptureServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService", r151);
        return r151;
    L610:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatUploadMediaService") == false) goto L1049;
        T r152 = (T) new AIChatUploadMediaServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatUploadMediaService", r152);
        return r152;
    L614:
        if (r3.getName().equals("com.larus.audio.ttsV2.ITtsBackgroundPlayControlService") == false) goto L1049;
        T r153 = (T) new TtsBackgroundPlayControlServiceNoop();
        putStaticDowngradeImplCache("com.larus.audio.ttsV2.ITtsBackgroundPlayControlService", r153);
        return r153;
    L618:
        if (r3.getName().equals("com.obric.assistant.spi.complextask.IComplexTaskService") == false) goto L1049;
        T r154 = (T) new DefaultComplexTaskServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.complextask.IComplexTaskService", r154);
        return r154;
    L622:
        if (r3.getName().equals("com.larus.extension.diversion.api.IDiversionConfig") == false) goto L1049;
        T r155 = (T) new DiversionConfigNoop();
        putStaticDowngradeImplCache("com.larus.extension.diversion.api.IDiversionConfig", r155);
        return r155;
    L626:
        if (r3.getName().equals("com.bytedance.pia.core.spi.api.IPiaConfigTask") == false) goto L1049;
        T r156 = (T) new ConfigTask();
        putStaticDowngradeImplCache("com.bytedance.pia.core.spi.api.IPiaConfigTask", r156);
        return r156;
    L630:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IUserSettingRepoService") == false) goto L1049;
        T r157 = (T) new com.larus.bmhome.chat.model.repo.UserSettingRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.model.repo.IUserSettingRepoService", r157);
        return r157;
    L634:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatUIService") == false) goto L1049;
        T r158 = (T) new DefaultObricChatUIServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.chat.IObricChatUIService", r158);
        return r158;
    L638:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAttachmentService") == false) goto L1049;
        T r159 = (T) new ICreationAttachmentServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationAttachmentService", r159);
        return r159;
    L642:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatService") == false) goto L1049;
        T r160 = (T) new AIChatServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatService", r160);
        return r160;
    L646:
        if (r3.getName().equals("com.obric.assistant.spi.feedback.IFeedbackService") == false) goto L1049;
        T r161 = (T) new DefaultFeedbackServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.feedback.IFeedbackService", r161);
        return r161;
    L650:
        if (r3.getName().equals("com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService") == false) goto L1049;
        T r162 = (T) new DefaultObricBackgroundNetworkBlockServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService", r162);
        return r162;
    L654:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.ISettingRepoService") == false) goto L1049;
        T r163 = (T) new SettingRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.model.repo.ISettingRepoService", r163);
        return r163;
    L658:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatMessageBgService") == false) goto L1049;
        T r164 = (T) new DebugObricChatMessageBgService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.chat.IObricChatMessageBgService", r164);
        return r164;
    L662:
        if (r3.getName().equals("com.obric.assistant.spi.actionbar.IObricActionBarTrackService") == false) goto L1049;
        T r165 = (T) new DefaultObricActionBarTrackServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.actionbar.IObricActionBarTrackService", r165);
        return r165;
    L666:
        if (r3.getName().equals("com.obric.assistant.common.spi.security.IObricSecurityService") == false) goto L1049;
        T r166 = (T) new DefaultSecurityServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.security.IObricSecurityService", r166);
        return r166;
    L670:
        if (r3.getName().equals("com.larus.share.service.IShareOfficeDocService") == false) goto L1049;
        T r167 = (T) new DefaultShareOfficeDocService();
        putStaticDowngradeImplCache("com.larus.share.service.IShareOfficeDocService", r167);
        return r167;
    L674:
        if (r3.getName().equals("com.fackbook.drawee.IDraweeConfigOutService") == false) goto L1049;
        return (T) new DraweeConfigOutServiceDowngrade();
    L678:
        if (r3.getName().equals("com.larus.uaigc.applet.IAICreationAppletPageProvider") == false) goto L1049;
        T r168 = (T) new IAICreationAppletPageProviderNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.applet.IAICreationAppletPageProvider", r168);
        return r168;
    L682:
        if (r3.getName().equals("com.obric.assistant.spi.share.IShareChannelExtraConfigurator") == false) goto L1049;
        T r169 = (T) new DefaultShareChannelExtraConfigurator();
        putStaticDowngradeImplCache("com.obric.assistant.spi.share.IShareChannelExtraConfigurator", r169);
        return r169;
    L686:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoBrightAPI") == false) goto L1049;
        T r170 = (T) new VideoBrightAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoBrightAPI", r170);
        return r170;
    L690:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatAudioService") == false) goto L1049;
        T r171 = (T) new AIChatAudioServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatAudioService", r171);
        return r171;
    L694:
        if (r3.getName().equals("com.larus.basic.experience.downgrade.api.IFlowDowngradeService") == false) goto L1049;
        T r172 = (T) new FlowDowngradeServiceNoop();
        putStaticDowngradeImplCache("com.larus.basic.experience.downgrade.api.IFlowDowngradeService", r172);
        return r172;
    L698:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider") == false) goto L1049;
        T r173 = (T) new DefaultReceiveStreamMessageTypeOverriderImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider", r173);
        return r173;
    L702:
        if (r3.getName().equals("com.larus.bmhome.chat.input.IChatInputService") == false) goto L1049;
        T r174 = (T) new ChatInputServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.input.IChatInputService", r174);
        return r174;
    L706:
        if (r3.getName().equals("com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService") == false) goto L1049;
        T r175 = (T) new AggregateSearchUiServiceNoop();
        putStaticDowngradeImplCache("com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService", r175);
        return r175;
    L710:
        if (r3.getName().equals("com.larus.extension.offline_message.api.IOfflineMessageService") == false) goto L1049;
        T r176 = (T) new OfflineMessageServiceNoop();
        putStaticDowngradeImplCache("com.larus.extension.offline_message.api.IOfflineMessageService", r176);
        return r176;
    L714:
        if (r3.getName().equals("com.obric.assistant.spi.keyguard.IKeyguardService") == false) goto L1049;
        T r177 = (T) new DefaultKeyguardServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.keyguard.IKeyguardService", r177);
        return r177;
    L718:
        if (r3.getName().equals("com.larus.platform.audit.IFlowBehaviorAuditService") == false) goto L1049;
        T r178 = (T) new DefaultFlowBehaviorAuditServiceImpl();
        putStaticDowngradeImplCache("com.larus.platform.audit.IFlowBehaviorAuditService", r178);
        return r178;
    L722:
        if (r3.getName().equals("com.larus.bmhome.chat.require.IMainBotService") == false) goto L1049;
        T r179 = (T) new MainBotServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.require.IMainBotService", r179);
        return r179;
    L726:
        if (r3.getName().equals("com.larus.apm.api.IExtraParams") == false) goto L1049;
        T r180 = (T) new ObricExtraParamImpl();
        putStaticDowngradeImplCache("com.larus.apm.api.IExtraParams", r180);
        return r180;
    L730:
        if (r3.getName().equals("com.larus.chat.gallery.api.IChatGalleryService") == false) goto L1049;
        T r181 = (T) new ChatGalleryServiceNoop();
        putStaticDowngradeImplCache("com.larus.chat.gallery.api.IChatGalleryService", r181);
        return r181;
    L734:
        if (r3.getName().equals("com.larus.office.card.doc.create.IOfficeCardDocCreateService") == false) goto L1049;
        T r182 = (T) new OfficeCardDocCreateServiceNoop();
        putStaticDowngradeImplCache("com.larus.office.card.doc.create.IOfficeCardDocCreateService", r182);
        return r182;
    L738:
        if (r3.getName().equals("com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService") == false) goto L1049;
        T r183 = (T) new DefaultWakeupLatencyTrackServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService", r183);
        return r183;
    L742:
        if (r3.getName().equals("com.larus.receive.contract.IReceiveCustomDiff") == false) goto L1049;
        T r184 = (T) new DefaultReceiveCustomDiffImpl();
        putStaticDowngradeImplCache("com.larus.receive.contract.IReceiveCustomDiff", r184);
        return r184;
    L746:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricBackTraceLogService") == false) goto L1049;
        T r185 = (T) new DefaultObricBackTraceLogServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricBackTraceLogService", r185);
        return r185;
    L750:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAppreciableTraceService") == false) goto L1049;
        T r186 = (T) new AppreciableTraceServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.api.IAppreciableTraceService", r186);
        return r186;
    L754:
        if (r3.getName().equals("com.larus.mirabridge.api.pluginservice.ITTOfficePluginService") == false) goto L1049;
        T r187 = (T) new TTOfficePluginDefaultService();
        putStaticDowngradeImplCache("com.larus.mirabridge.api.pluginservice.ITTOfficePluginService", r187);
        return r187;
    L758:
        if (r3.getName().equals("com.larus.bmhome.taskskill.service.ISkillService") == false) goto L1049;
        T r188 = (T) new SkillServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.taskskill.service.ISkillService", r188);
        return r188;
    L762:
        if (r3.getName().equals("com.obric.assistant.common.spi.settings.IObricSettingRequestService") == false) goto L1049;
        T r189 = (T) new DefaultObricSettingRequestServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.settings.IObricSettingRequestService", r189);
        return r189;
    L766:
        if (r3.getName().equals("com.obric.assistant.spi.router.IObricRouterService") == false) goto L1049;
        T r190 = (T) new DefaultRouterServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.router.IObricRouterService", r190);
        return r190;
    L770:
        if (r3.getName().equals("com.larus.contextwindow.api.IContextWindowUsageService") == false) goto L1049;
        T r191 = (T) new ContextWindowUsageServiceNoop();
        putStaticDowngradeImplCache("com.larus.contextwindow.api.IContextWindowUsageService", r191);
        return r191;
    L774:
        if (r3.getName().equals("com.larus.uaigc.creation.ICreationService") == false) goto L1049;
        T r192 = (T) new CreationServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.creation.ICreationService", r192);
        return r192;
    L778:
        if (r3.getName().equals("com.larus.uaigc.applet.IMusicAppletHostService") == false) goto L1049;
        T r193 = (T) new IMusicAppletHostServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.applet.IMusicAppletHostService", r193);
        return r193;
    L782:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricContextService") == false) goto L1049;
        T r194 = (T) new DefaultObricContextService();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.IObricContextService", r194);
        return r194;
    L786:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.AdaptiveGradingAPI") == false) goto L1049;
        T r195 = (T) new AdaptiveGradingAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.AdaptiveGradingAPI", r195);
        return r195;
    L790:
        if (r3.getName().equals("com.larus.camera.contract.ICameraServiceDiff") == false) goto L1049;
        T r196 = (T) new DefultCameraServiceImpl();
        putStaticDowngradeImplCache("com.larus.camera.contract.ICameraServiceDiff", r196);
        return r196;
    L794:
        if (r3.getName().equals("com.larus.platform.api.ISdkVideoFeedService") == false) goto L1049;
        T r197 = (T) new SdkVideoFeedServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.api.ISdkVideoFeedService", r197);
        return r197;
    L798:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationDetailImageEditService") == false) goto L1049;
        T r198 = (T) new ICreationDetailImageEditServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationDetailImageEditService", r198);
        return r198;
    L802:
        if (r3.getName().equals("com.larus.platform.api.IBtmHostDependency") == false) goto L1049;
        T r199 = (T) new BtmHostDependencyNoop();
        putStaticDowngradeImplCache("com.larus.platform.api.IBtmHostDependency", r199);
        return r199;
    L806:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationWorkflowService") == false) goto L1049;
        T r200 = (T) new ICreationWorkflowServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationWorkflowService", r200);
        return r200;
    L810:
        if (r3.getName().equals("com.obric.assistant.spi.account.IObricXttTokenSyncService") == false) goto L1049;
        T r201 = (T) new DefaultObricXttTokenSyncServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.account.IObricXttTokenSyncService", r201);
        return r201;
    L814:
        if (r3.getName().equals("com.larus.bmhome.collection.ICollectionReport") == false) goto L1049;
        T r202 = (T) new CollectionReportNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.collection.ICollectionReport", r202);
        return r202;
    L818:
        if (r3.getName().equals("com.larus.agents.api.ILocalWebFetchService") == false) goto L1049;
        T r203 = (T) new LocalWebFetchServiceNoop();
        putStaticDowngradeImplCache("com.larus.agents.api.ILocalWebFetchService", r203);
        return r203;
    L822:
        if (r3.getName().equals("com.obric.assistant.spi.actionbar.IObricActionBarSendService") == false) goto L1049;
        T r204 = (T) new DefaultObricActionBarSendService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.actionbar.IObricActionBarSendService", r204);
        return r204;
    L826:
        if (r3.getName().equals("com.larus.bmhome.chat.setting.IUserSettingCacheService") == false) goto L1049;
        T r205 = (T) new UserSettingCacheServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.setting.IUserSettingCacheService", r205);
        return r205;
    L830:
        if (r3.getName().equals("com.larus.uaigc.applet.IMusicAppletPageProvider") == false) goto L1049;
        T r206 = (T) new IMusicAppletPageProviderNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.applet.IMusicAppletPageProvider", r206);
        return r206;
    L834:
        if (r3.getName().equals("com.larus.extension.diversion.api.IDiversionImplService") == false) goto L1049;
        T r207 = (T) new DiversionImplServiceNoop();
        putStaticDowngradeImplCache("com.larus.extension.diversion.api.IDiversionImplService", r207);
        return r207;
    L838:
        if (r3.getName().equals("com.larus.voicecall.api.IVoiceCallService") == false) goto L1049;
        T r208 = (T) new VoiceCallServiceNoop();
        putStaticDowngradeImplCache("com.larus.voicecall.api.IVoiceCallService", r208);
        return r208;
    L842:
        if (r3.getName().equals("com.larus.bmhome.larkinput.api.host.ILarkInputHostService") == false) goto L1049;
        T r209 = (T) new LarkInputHostServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.larkinput.api.host.ILarkInputHostService", r209);
        return r209;
    L846:
        if (r3.getName().equals("com.obric.assistant.zeus.plugin.IObricMigrationHandler") == false) goto L1049;
        T r210 = (T) new DefaultObricMigrationHandler();
        putStaticDowngradeImplCache("com.obric.assistant.zeus.plugin.IObricMigrationHandler", r210);
        return r210;
    L850:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSRLutDspAPI") == false) goto L1049;
        T r211 = (T) new VideoSRLutDspAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSRLutDspAPI", r211);
        return r211;
    L854:
        if (r3.getName().equals("com.larus.bmhome.nestedfile.INestFileService") == false) goto L1049;
        T r212 = (T) new NestFileServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.nestedfile.INestFileService", r212);
        return r212;
    L858:
        if (r3.getName().equals("com.obric.assistant.spi.app.IObricAppService") == false) goto L1049;
        T r213 = (T) new DefaultAppServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.app.IObricAppService", r213);
        return r213;
    L862:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoOCLSRAPI") == false) goto L1049;
        T r214 = (T) new VideoOCLSRAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoOCLSRAPI", r214);
        return r214;
    L866:
        if (r3.getName().equals("com.obric.assistant.spi.essentialtask.IObricEssentialTaskService") == false) goto L1049;
        T r215 = (T) new DefaultObricEssentialTaskServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.essentialtask.IObricEssentialTaskService", r215);
        return r215;
    L870:
        if (r3.getName().equals("com.larus.audio.IAudioService") == false) goto L1049;
        T r216 = (T) new AudioServiceNoop();
        putStaticDowngradeImplCache("com.larus.audio.IAudioService", r216);
        return r216;
    L874:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IObricDoraService") == false) goto L1049;
        T r217 = (T) new DefaultObricDoraServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.dora.IObricDoraService", r217);
        return r217;
    L878:
        if (r3.getName().equals("com.larus.extension.account_auth.api.IFlowAccountAuthService") == false) goto L1049;
        T r218 = (T) new FlowAccountAuthServiceNoop();
        putStaticDowngradeImplCache("com.larus.extension.account_auth.api.IFlowAccountAuthService", r218);
        return r218;
    L882:
        if (r3.getName().equals("com.larus.platform.model.video.business.IVideoFeedProvider") == false) goto L1049;
        T r219 = (T) new VideoFeedProviderNoop();
        putStaticDowngradeImplCache("com.larus.platform.model.video.business.IVideoFeedProvider", r219);
        return r219;
    L886:
        if (r3.getName().equals("com.larus.feedback.api.IFlowFeedbackService") == false) goto L1049;
        T r220 = (T) new FlowFeedbackServiceNoop();
        putStaticDowngradeImplCache("com.larus.feedback.api.IFlowFeedbackService", r220);
        return r220;
    L890:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricTtsControlService") == false) goto L1049;
        T r221 = (T) new DefaultObricTtsControlServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricTtsControlService", r221);
        return r221;
    L894:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricAsrService") == false) goto L1049;
        T r222 = (T) new DefaultObricAsrServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricAsrService", r222);
        return r222;
    L898:
        if (r3.getName().equals("com.obric.assistant.spi.login.IObricLoginService") == false) goto L1049;
        T r223 = (T) new DefaultObricLoginServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.login.IObricLoginService", r223);
        return r223;
    L902:
        if (r3.getName().equals("com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy") == false) goto L1049;
        T r224 = (T) new DefaultObricIntentWidgetPolicy();
        putStaticDowngradeImplCache("com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy", r224);
        return r224;
    L906:
        if (r3.getName().equals("com.larus.dora.impl.assistant.AssistantWifiService") == false) goto L1049;
        T r225 = (T) new DefaultAssistantWifiService();
        putStaticDowngradeImplCache("com.larus.dora.impl.assistant.AssistantWifiService", r225);
        return r225;
    L910:
        if (r3.getName().equals("com.larus.extension.diversion.api.IHostDiversionService") == false) goto L1049;
        T r226 = (T) new HostDiversionServiceNoop();
        putStaticDowngradeImplCache("com.larus.extension.diversion.api.IHostDiversionService", r226);
        return r226;
    L914:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatRenderTraceService") == false) goto L1049;
        T r227 = (T) new AIChatRenderTraceServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.spi.IAIChatRenderTraceService", r227);
        return r227;
    L918:
        if (r3.getName().equals("com.larus.bmhome.auth.ILaunchMetricService") == false) goto L1049;
        T r228 = (T) new LaunchMetricServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.auth.ILaunchMetricService", r228);
        return r228;
    L922:
        if (r3.getName().equals("com.larus.audio.ttsV2.ITtsGuideService") == false) goto L1049;
        T r229 = (T) new TtsGuideServiceNoop();
        putStaticDowngradeImplCache("com.larus.audio.ttsV2.ITtsGuideService", r229);
        return r229;
    L926:
        if (r3.getName().equals("com.obric.assistant.spi.share.IShareKeyConfigService") == false) goto L1049;
        T r230 = (T) new DefaultShareKeyConfigService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.share.IShareKeyConfigService", r230);
        return r230;
    L930:
        if (r3.getName().equals("com.larus.canvas.service.ICanvasRepoService") == false) goto L1049;
        T r231 = (T) new CanvasRepoServiceNoop();
        putStaticDowngradeImplCache("com.larus.canvas.service.ICanvasRepoService", r231);
        return r231;
    L934:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI") == false) goto L1049;
        T r232 = (T) new VqscoreLiveCallbackAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI", r232);
        return r232;
    L938:
        if (r3.getName().equals("com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener") == false) goto L1049;
        T r233 = (T) new DefaultMediaPlayStateChangeListenerImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener", r233);
        return r233;
    L942:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricEnrollInteropService") == false) goto L1049;
        T r234 = (T) new DefaultObricEnrollInteropServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricEnrollInteropService", r234);
        return r234;
    L946:
        if (r3.getName().equals("com.obric.assistant.spi.message.IObricMessageService") == false) goto L1049;
        T r235 = (T) new DefaultObricMessageService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.message.IObricMessageService", r235);
        return r235;
    L950:
        if (r3.getName().equals("com.larus.platform.model.video.business.IVideoArticleProvider") == false) goto L1049;
        T r236 = (T) new VideoArticleProviderNoop();
        putStaticDowngradeImplCache("com.larus.platform.model.video.business.IVideoArticleProvider", r236);
        return r236;
    L954:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.NoiseLiveAPI") == false) goto L1049;
        T r237 = (T) new NoiseLiveAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseLiveAPI", r237);
        return r237;
    L958:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationNotifyService") == false) goto L1049;
        T r238 = (T) new ICreationNotifyServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.service.ICreationNotifyService", r238);
        return r238;
    L962:
        if (r3.getName().equals("com.larus.uaigc.applet.IAICreationAppletHostService") == false) goto L1049;
        T r239 = (T) new IAICreationAppletHostServiceNoop();
        putStaticDowngradeImplCache("com.larus.uaigc.applet.IAICreationAppletHostService", r239);
        return r239;
    L966:
        if (r3.getName().equals("com.ss.android.ugc.quota.IBDNetworkTagConfig") == false) goto L1049;
        T r240 = (T) new BDNetworkTagConfigDefault();
        putStaticDowngradeImplCache("com.ss.android.ugc.quota.IBDNetworkTagConfig", r240);
        return r240;
    L970:
        if (r3.getName().equals("com.larus.bmhome.auth.feature_config.model.IFeatureKitService") == false) goto L1049;
        T r241 = (T) new FeatureKitServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.auth.feature_config.model.IFeatureKitService", r241);
        return r241;
    L974:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricEnvService") == false) goto L1049;
        T r242 = (T) new DefaultObricEnvService();
        putStaticDowngradeImplCache("com.obric.assistant.common.spi.IObricEnvService", r242);
        return r242;
    L978:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricVadService") == false) goto L1049;
        T r243 = (T) new DefaultObricVadServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.audio.IObricVadService", r243);
        return r243;
    L982:
        if (r3.getName().equals("com.obric.assistant.spi.canvas.IObricCanvasService") == false) goto L1049;
        T r244 = (T) new DefaultObricCanvasService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.canvas.IObricCanvasService", r244);
        return r244;
    L986:
        if (r3.getName().equals("com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService") == false) goto L1049;
        T r245 = (T) new OfficeHtmlFileDownloadServiceNoop();
        putStaticDowngradeImplCache("com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService", r245);
        return r245;
    L990:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSRRaisrAPI") == false) goto L1049;
        T r246 = (T) new VideoSRRaisrAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSRRaisrAPI", r246);
        return r246;
    L994:
        if (r3.getName().equals("com.larus.bmhome.chat.service.IMainBotCommonService") == false) goto L1049;
        T r247 = (T) new MainBotCommonServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.service.IMainBotCommonService", r247);
        return r247;
    L998:
        if (r3.getName().equals("com.larus.bmhome.bot.IBotStatusCacheService") == false) goto L1049;
        T r248 = (T) new BotStatusCacheServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.bot.IBotStatusCacheService", r248);
        return r248;
    L1002:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI") == false) goto L1049;
        T r249 = (T) new VideoSuperResolutionAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI", r249);
        return r249;
    L1006:
        if (r3.getName().equals("com.obric.assistant.spi.rtc.IObricRtcService") == false) goto L1049;
        T r250 = (T) new DefaultObricRtcService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.rtc.IObricRtcService", r250);
        return r250;
    L1010:
        if (r3.getName().equals("com.obric.assistant.spi.notification.IObricNotificationIslandService") == false) goto L1049;
        T r251 = (T) new DefaultObricNotificationIslandServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.notification.IObricNotificationIslandService", r251);
        return r251;
    L1014:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ColorShiftAPI") == false) goto L1049;
        T r252 = (T) new ColorShiftAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.ColorShiftAPI", r252);
        return r252;
    L1018:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.NoiseLiveCallbackAPI") == false) goto L1049;
        T r253 = (T) new NoiseLiveCallbackAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseLiveCallbackAPI", r253);
        return r253;
    L1022:
        if (r3.getName().equals("com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility$IFactory") == false) goto L1049;
        T r254 = (T) new ISearchDynamicAbility.DefaultFactory();
        putStaticDowngradeImplCache("com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility$IFactory", r254);
        return r254;
    L1026:
        if (r3.getName().equals("com.obric.assistant.spi.feedback.IObricFeedbackPanelService") == false) goto L1049;
        T r255 = (T) new DefaultObricFeedbackPanelService();
        putStaticDowngradeImplCache("com.obric.assistant.spi.feedback.IObricFeedbackPanelService", r255);
        return r255;
    L1030:
        if (r3.getName().equals("com.larus.platform.IObricMessageExtService") == false) goto L1049;
        T r256 = (T) new ObricMessageExtServiceNoop();
        putStaticDowngradeImplCache("com.larus.platform.IObricMessageExtService", r256);
        return r256;
    L1034:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.TdiLiteStrategyAPI") == false) goto L1049;
        T r257 = (T) new TdiLiteStrategyAPIDefault();
        putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.TdiLiteStrategyAPI", r257);
        return r257;
    L1038:
        if (r3.getName().equals("com.obric.assistant.spi.push.IObricPushConfigService") == false) goto L1049;
        T r258 = (T) new DefaultObricPushConfigServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.push.IObricPushConfigService", r258);
        return r258;
    L1042:
        if (r3.getName().equals("com.obric.assistant.spi.markdown.IObricMarkdownResolverService") == false) goto L1049;
        T r259 = (T) new DefaultObricMarkdownResolverServiceImpl();
        putStaticDowngradeImplCache("com.obric.assistant.spi.markdown.IObricMarkdownResolverService", r259);
        return r259;
    L1046:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAuthModelService") == false) goto L1049;
        T r260 = (T) new AuthModelServiceNoop();
        putStaticDowngradeImplCache("com.larus.bmhome.chat.api.IAuthModelService", r260);
        return r260;
    }

    public void downgradeComponent(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (this.downgradeComponents.contains(r2) == true) goto L9;
        this.downgradeComponents.add(r2);
        return;
    }

    public <T> T getDowngradeImpl(Class<T> r4) {
        String r0 = r4.getName();
        ServiceProvider r1 = this.downgradeImplMap.get(r0);
        if (r1 != null) goto L5;
        T r2 = (T) this.staticDowngradeImplCache.get(r0);
        if (r2 == null) goto L9;
    L12:
        return r2;
    L9:
        if (this.staticDowngradeNotExistSet.contains(r0) == true) goto L12;
        return (T) getStaticDowngradeImpl(r4);
    L5:
        return (T) r1.get();
    }

    public boolean isServiceForceDowngrade(Class r2) {
        String r3 = this.componentsMap.get(r2.getName());
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        return this.downgradeComponents.contains(r3);
    }

    private void addServiceComponent(String r2, String r3) {
        this.componentsMap.put(r2, r3);
    }

    private void putStaticDowngradeImplCache(String r2, Object r3) {
        this.staticDowngradeImplCache.put(r2, r3);
    }

    public <T> void bindDowngradeImpl(Class<T> r2, ServiceProvider<T> r3) {
        this.downgradeImplMap.put(r2.getName(), r3);
    }
}
